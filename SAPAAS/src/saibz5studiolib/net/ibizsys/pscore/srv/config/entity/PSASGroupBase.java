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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSASGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSASGroupBase.class);
    public static final String FIELD_APPFOLDER = "APPFOLDER";
    public static final String FIELD_ASSTATE = "ASSTATE";
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSASGROUPID = "PSASGROUPID";
    public static final String FIELD_PSASGROUPNAME = "PSASGROUPNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_STARTCMD = "STARTCMD";
    public static final String FIELD_STOPCMD = "STOPCMD";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_APPFOLDER = 0;
    private static final int INDEX_ASSTATE = 1;
    private static final int INDEX_ASTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_HTTPPORT = 5;
    private static final int INDEX_HTTPSPORT = 6;
    private static final int INDEX_IPADDR = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PASSWD = 9;
    private static final int INDEX_PSASGROUPID = 10;
    private static final int INDEX_PSASGROUPNAME = 11;
    private static final int INDEX_PSSVRDOMAINID = 12;
    private static final int INDEX_PSSVRDOMAINNAME = 13;
    private static final int INDEX_REFINFO = 14;
    private static final int INDEX_SSHIPADDR = 15;
    private static final int INDEX_SSHPORT = 16;
    private static final int INDEX_STARTCMD = 17;
    private static final int INDEX_STOPCMD = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USAGEMODE = 21;
    private static final int INDEX_USERNAME = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSASGroupBase proxyPSASGroupBase = null;
    private boolean appfolderDirtyFlag = false;
    private boolean asstateDirtyFlag = false;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psasgroupidDirtyFlag = false;
    private boolean psasgroupnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean startcmdDirtyFlag = false;
    private boolean stopcmdDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="appfolder")
    private String appfolder;
    @Column(name="asstate")
    private Integer asstate;
    @Column(name="astype")
    private String astype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psasgroupid")
    private String psasgroupid;
    @Column(name="psasgroupname")
    private String psasgroupname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="startcmd")
    private String startcmd;
    @Column(name="stopcmd")
    private String stopcmd;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="username")
    private String username;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAppFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appfolder = string;
        this.appfolderDirtyFlag = true;
    }

    public String getAppFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppFolder();
        }
        return this.appfolder;
    }

    public boolean isAppFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppFolderDirty();
        }
        return this.appfolderDirtyFlag;
    }

    public void resetAppFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppFolder();
            return;
        }
        this.appfolderDirtyFlag = false;
        this.appfolder = null;
    }

    public void setASState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASState(n);
            return;
        }
        this.asstate = n;
        this.asstateDirtyFlag = true;
    }

    public Integer getASState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASState();
        }
        return this.asstate;
    }

    public boolean isASStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASStateDirty();
        }
        return this.asstateDirtyFlag;
    }

    public void resetASState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASState();
            return;
        }
        this.asstateDirtyFlag = false;
        this.asstate = null;
    }

    public void setASType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.astype = string;
        this.astypeDirtyFlag = true;
    }

    public String getASType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASType();
        }
        return this.astype;
    }

    public boolean isASTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASTypeDirty();
        }
        return this.astypeDirtyFlag;
    }

    public void resetASType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASType();
            return;
        }
        this.astypeDirtyFlag = false;
        this.astype = null;
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

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
    }

    public void setHttpsPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpsPort(n);
            return;
        }
        this.httpsport = n;
        this.httpsportDirtyFlag = true;
    }

    public Integer getHttpsPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpsPort();
        }
        return this.httpsport;
    }

    public boolean isHttpsPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpsPortDirty();
        }
        return this.httpsportDirtyFlag;
    }

    public void resetHttpsPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpsPort();
            return;
        }
        this.httpsportDirtyFlag = false;
        this.httpsport = null;
    }

    public void setIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr();
        }
        return this.ipaddr;
    }

    public boolean isIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
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

    public void setPSASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasgroupid = string;
        this.psasgroupidDirtyFlag = true;
    }

    public String getPSASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASGroupId();
        }
        return this.psasgroupid;
    }

    public boolean isPSASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASGroupIdDirty();
        }
        return this.psasgroupidDirtyFlag;
    }

    public void resetPSASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASGroupId();
            return;
        }
        this.psasgroupidDirtyFlag = false;
        this.psasgroupid = null;
    }

    public void setPSASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasgroupname = string;
        this.psasgroupnameDirtyFlag = true;
    }

    public String getPSASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASGroupName();
        }
        return this.psasgroupname;
    }

    public boolean isPSASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASGroupNameDirty();
        }
        return this.psasgroupnameDirtyFlag;
    }

    public void resetPSASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASGroupName();
            return;
        }
        this.psasgroupnameDirtyFlag = false;
        this.psasgroupname = null;
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

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
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

    public void setStartCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startcmd = string;
        this.startcmdDirtyFlag = true;
    }

    public String getStartCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartCmd();
        }
        return this.startcmd;
    }

    public boolean isStartCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartCmdDirty();
        }
        return this.startcmdDirtyFlag;
    }

    public void resetStartCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartCmd();
            return;
        }
        this.startcmdDirtyFlag = false;
        this.startcmd = null;
    }

    public void setStopCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStopCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stopcmd = string;
        this.stopcmdDirtyFlag = true;
    }

    public String getStopCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStopCmd();
        }
        return this.stopcmd;
    }

    public boolean isStopCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStopCmdDirty();
        }
        return this.stopcmdDirtyFlag;
    }

    public void resetStopCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStopCmd();
            return;
        }
        this.stopcmdDirtyFlag = false;
        this.stopcmd = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
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

    protected void onReset() {
        PSASGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSASGroupBase pSASGroupBase) {
        pSASGroupBase.resetAppFolder();
        pSASGroupBase.resetASState();
        pSASGroupBase.resetASType();
        pSASGroupBase.resetCreateDate();
        pSASGroupBase.resetCreateMan();
        pSASGroupBase.resetHttpPort();
        pSASGroupBase.resetHttpsPort();
        pSASGroupBase.resetIPAddr();
        pSASGroupBase.resetMemo();
        pSASGroupBase.resetPasswd();
        pSASGroupBase.resetPSASGroupId();
        pSASGroupBase.resetPSASGroupName();
        pSASGroupBase.resetPSSvrDomainId();
        pSASGroupBase.resetPSSvrDomainName();
        pSASGroupBase.resetRefInfo();
        pSASGroupBase.resetSSHIPAddr();
        pSASGroupBase.resetSSHPort();
        pSASGroupBase.resetStartCmd();
        pSASGroupBase.resetStopCmd();
        pSASGroupBase.resetUpdateDate();
        pSASGroupBase.resetUpdateMan();
        pSASGroupBase.resetUsageMode();
        pSASGroupBase.resetUserName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppFolderDirty()) {
            hashMap.put(FIELD_APPFOLDER, this.getAppFolder());
        }
        if (!bl || this.isASStateDirty()) {
            hashMap.put(FIELD_ASSTATE, this.getASState());
        }
        if (!bl || this.isASTypeDirty()) {
            hashMap.put(FIELD_ASTYPE, this.getASType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSASGroupIdDirty()) {
            hashMap.put(FIELD_PSASGROUPID, this.getPSASGroupId());
        }
        if (!bl || this.isPSASGroupNameDirty()) {
            hashMap.put(FIELD_PSASGROUPNAME, this.getPSASGroupName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isStartCmdDirty()) {
            hashMap.put(FIELD_STARTCMD, this.getStartCmd());
        }
        if (!bl || this.isStopCmdDirty()) {
            hashMap.put(FIELD_STOPCMD, this.getStopCmd());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSASGroupBase.get(this, n);
    }

    private static Object get(PSASGroupBase pSASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASGroupBase.getAppFolder();
            }
            case 1: {
                return pSASGroupBase.getASState();
            }
            case 2: {
                return pSASGroupBase.getASType();
            }
            case 3: {
                return pSASGroupBase.getCreateDate();
            }
            case 4: {
                return pSASGroupBase.getCreateMan();
            }
            case 5: {
                return pSASGroupBase.getHttpPort();
            }
            case 6: {
                return pSASGroupBase.getHttpsPort();
            }
            case 7: {
                return pSASGroupBase.getIPAddr();
            }
            case 8: {
                return pSASGroupBase.getMemo();
            }
            case 9: {
                return pSASGroupBase.getPasswd();
            }
            case 10: {
                return pSASGroupBase.getPSASGroupId();
            }
            case 11: {
                return pSASGroupBase.getPSASGroupName();
            }
            case 12: {
                return pSASGroupBase.getPSSvrDomainId();
            }
            case 13: {
                return pSASGroupBase.getPSSvrDomainName();
            }
            case 14: {
                return pSASGroupBase.getRefInfo();
            }
            case 15: {
                return pSASGroupBase.getSSHIPAddr();
            }
            case 16: {
                return pSASGroupBase.getSSHPort();
            }
            case 17: {
                return pSASGroupBase.getStartCmd();
            }
            case 18: {
                return pSASGroupBase.getStopCmd();
            }
            case 19: {
                return pSASGroupBase.getUpdateDate();
            }
            case 20: {
                return pSASGroupBase.getUpdateMan();
            }
            case 21: {
                return pSASGroupBase.getUsageMode();
            }
            case 22: {
                return pSASGroupBase.getUserName();
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
        PSASGroupBase.set(this, n, object);
    }

    private static void set(PSASGroupBase pSASGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSASGroupBase.setAppFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSASGroupBase.setASState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSASGroupBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSASGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSASGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSASGroupBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSASGroupBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSASGroupBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSASGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSASGroupBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSASGroupBase.setPSASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSASGroupBase.setPSASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSASGroupBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSASGroupBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSASGroupBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSASGroupBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSASGroupBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSASGroupBase.setStartCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSASGroupBase.setStopCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSASGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSASGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSASGroupBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSASGroupBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSASGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSASGroupBase pSASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASGroupBase.getAppFolder() == null;
            }
            case 1: {
                return pSASGroupBase.getASState() == null;
            }
            case 2: {
                return pSASGroupBase.getASType() == null;
            }
            case 3: {
                return pSASGroupBase.getCreateDate() == null;
            }
            case 4: {
                return pSASGroupBase.getCreateMan() == null;
            }
            case 5: {
                return pSASGroupBase.getHttpPort() == null;
            }
            case 6: {
                return pSASGroupBase.getHttpsPort() == null;
            }
            case 7: {
                return pSASGroupBase.getIPAddr() == null;
            }
            case 8: {
                return pSASGroupBase.getMemo() == null;
            }
            case 9: {
                return pSASGroupBase.getPasswd() == null;
            }
            case 10: {
                return pSASGroupBase.getPSASGroupId() == null;
            }
            case 11: {
                return pSASGroupBase.getPSASGroupName() == null;
            }
            case 12: {
                return pSASGroupBase.getPSSvrDomainId() == null;
            }
            case 13: {
                return pSASGroupBase.getPSSvrDomainName() == null;
            }
            case 14: {
                return pSASGroupBase.getRefInfo() == null;
            }
            case 15: {
                return pSASGroupBase.getSSHIPAddr() == null;
            }
            case 16: {
                return pSASGroupBase.getSSHPort() == null;
            }
            case 17: {
                return pSASGroupBase.getStartCmd() == null;
            }
            case 18: {
                return pSASGroupBase.getStopCmd() == null;
            }
            case 19: {
                return pSASGroupBase.getUpdateDate() == null;
            }
            case 20: {
                return pSASGroupBase.getUpdateMan() == null;
            }
            case 21: {
                return pSASGroupBase.getUsageMode() == null;
            }
            case 22: {
                return pSASGroupBase.getUserName() == null;
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
        return PSASGroupBase.contains(this, n);
    }

    private static boolean contains(PSASGroupBase pSASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASGroupBase.isAppFolderDirty();
            }
            case 1: {
                return pSASGroupBase.isASStateDirty();
            }
            case 2: {
                return pSASGroupBase.isASTypeDirty();
            }
            case 3: {
                return pSASGroupBase.isCreateDateDirty();
            }
            case 4: {
                return pSASGroupBase.isCreateManDirty();
            }
            case 5: {
                return pSASGroupBase.isHttpPortDirty();
            }
            case 6: {
                return pSASGroupBase.isHttpsPortDirty();
            }
            case 7: {
                return pSASGroupBase.isIPAddrDirty();
            }
            case 8: {
                return pSASGroupBase.isMemoDirty();
            }
            case 9: {
                return pSASGroupBase.isPasswdDirty();
            }
            case 10: {
                return pSASGroupBase.isPSASGroupIdDirty();
            }
            case 11: {
                return pSASGroupBase.isPSASGroupNameDirty();
            }
            case 12: {
                return pSASGroupBase.isPSSvrDomainIdDirty();
            }
            case 13: {
                return pSASGroupBase.isPSSvrDomainNameDirty();
            }
            case 14: {
                return pSASGroupBase.isRefInfoDirty();
            }
            case 15: {
                return pSASGroupBase.isSSHIPAddrDirty();
            }
            case 16: {
                return pSASGroupBase.isSSHPortDirty();
            }
            case 17: {
                return pSASGroupBase.isStartCmdDirty();
            }
            case 18: {
                return pSASGroupBase.isStopCmdDirty();
            }
            case 19: {
                return pSASGroupBase.isUpdateDateDirty();
            }
            case 20: {
                return pSASGroupBase.isUpdateManDirty();
            }
            case 21: {
                return pSASGroupBase.isUsageModeDirty();
            }
            case 22: {
                return pSASGroupBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSASGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSASGroupBase pSASGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSASGroupBase.getAppFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfolder", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getAppFolder()), (boolean)false);
        }
        if (bl || pSASGroupBase.getASState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asstate", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getASState()), (boolean)false);
        }
        if (bl || pSASGroupBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getASType()), (boolean)false);
        }
        if (bl || pSASGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSASGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSASGroupBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSASGroupBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSASGroupBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSASGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSASGroupBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getPasswd()), (boolean)false);
        }
        if (bl || pSASGroupBase.getPSASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasgroupid", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getPSASGroupId()), (boolean)false);
        }
        if (bl || pSASGroupBase.getPSASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasgroupname", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getPSASGroupName()), (boolean)false);
        }
        if (bl || pSASGroupBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSASGroupBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSASGroupBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSASGroupBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSASGroupBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSASGroupBase.getStartCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startcmd", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getStartCmd()), (boolean)false);
        }
        if (bl || pSASGroupBase.getStopCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopcmd", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getStopCmd()), (boolean)false);
        }
        if (bl || pSASGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSASGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSASGroupBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSASGroupBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSASGroupBase.getJSONValue((Object)pSASGroupBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSASGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSASGroupBase pSASGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSASGroupBase.getAppFolder() != null) {
            object = pSASGroupBase.getAppFolder();
            xmlNode.setAttribute(FIELD_APPFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getASState() != null) {
            object = pSASGroupBase.getASState();
            xmlNode.setAttribute(FIELD_ASSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASGroupBase.getASType() != null) {
            object = pSASGroupBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getCreateDate() != null) {
            object = pSASGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASGroupBase.getCreateMan() != null) {
            object = pSASGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getHttpPort() != null) {
            object = pSASGroupBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASGroupBase.getHttpsPort() != null) {
            object = pSASGroupBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASGroupBase.getIPAddr() != null) {
            object = pSASGroupBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getMemo() != null) {
            object = pSASGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getPasswd() != null) {
            object = pSASGroupBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getPSASGroupId() != null) {
            object = pSASGroupBase.getPSASGroupId();
            xmlNode.setAttribute(FIELD_PSASGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getPSASGroupName() != null) {
            object = pSASGroupBase.getPSASGroupName();
            xmlNode.setAttribute(FIELD_PSASGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getPSSvrDomainId() != null) {
            object = pSASGroupBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getPSSvrDomainName() != null) {
            object = pSASGroupBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getRefInfo() != null) {
            object = pSASGroupBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getSSHIPAddr() != null) {
            object = pSASGroupBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getSSHPort() != null) {
            object = pSASGroupBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASGroupBase.getStartCmd() != null) {
            object = pSASGroupBase.getStartCmd();
            xmlNode.setAttribute(FIELD_STARTCMD, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getStopCmd() != null) {
            object = pSASGroupBase.getStopCmd();
            xmlNode.setAttribute(FIELD_STOPCMD, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getUpdateDate() != null) {
            object = pSASGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASGroupBase.getUpdateMan() != null) {
            object = pSASGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getUsageMode() != null) {
            object = pSASGroupBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSASGroupBase.getUserName() != null) {
            object = pSASGroupBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSASGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSASGroupBase pSASGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSASGroupBase.isAppFolderDirty() && (bl || pSASGroupBase.getAppFolder() != null)) {
            iDataObject.set(FIELD_APPFOLDER, (Object)pSASGroupBase.getAppFolder());
        }
        if (pSASGroupBase.isASStateDirty() && (bl || pSASGroupBase.getASState() != null)) {
            iDataObject.set(FIELD_ASSTATE, (Object)pSASGroupBase.getASState());
        }
        if (pSASGroupBase.isASTypeDirty() && (bl || pSASGroupBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSASGroupBase.getASType());
        }
        if (pSASGroupBase.isCreateDateDirty() && (bl || pSASGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSASGroupBase.getCreateDate());
        }
        if (pSASGroupBase.isCreateManDirty() && (bl || pSASGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSASGroupBase.getCreateMan());
        }
        if (pSASGroupBase.isHttpPortDirty() && (bl || pSASGroupBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSASGroupBase.getHttpPort());
        }
        if (pSASGroupBase.isHttpsPortDirty() && (bl || pSASGroupBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSASGroupBase.getHttpsPort());
        }
        if (pSASGroupBase.isIPAddrDirty() && (bl || pSASGroupBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSASGroupBase.getIPAddr());
        }
        if (pSASGroupBase.isMemoDirty() && (bl || pSASGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSASGroupBase.getMemo());
        }
        if (pSASGroupBase.isPasswdDirty() && (bl || pSASGroupBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSASGroupBase.getPasswd());
        }
        if (pSASGroupBase.isPSASGroupIdDirty() && (bl || pSASGroupBase.getPSASGroupId() != null)) {
            iDataObject.set(FIELD_PSASGROUPID, (Object)pSASGroupBase.getPSASGroupId());
        }
        if (pSASGroupBase.isPSASGroupNameDirty() && (bl || pSASGroupBase.getPSASGroupName() != null)) {
            iDataObject.set(FIELD_PSASGROUPNAME, (Object)pSASGroupBase.getPSASGroupName());
        }
        if (pSASGroupBase.isPSSvrDomainIdDirty() && (bl || pSASGroupBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSASGroupBase.getPSSvrDomainId());
        }
        if (pSASGroupBase.isPSSvrDomainNameDirty() && (bl || pSASGroupBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSASGroupBase.getPSSvrDomainName());
        }
        if (pSASGroupBase.isRefInfoDirty() && (bl || pSASGroupBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSASGroupBase.getRefInfo());
        }
        if (pSASGroupBase.isSSHIPAddrDirty() && (bl || pSASGroupBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSASGroupBase.getSSHIPAddr());
        }
        if (pSASGroupBase.isSSHPortDirty() && (bl || pSASGroupBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSASGroupBase.getSSHPort());
        }
        if (pSASGroupBase.isStartCmdDirty() && (bl || pSASGroupBase.getStartCmd() != null)) {
            iDataObject.set(FIELD_STARTCMD, (Object)pSASGroupBase.getStartCmd());
        }
        if (pSASGroupBase.isStopCmdDirty() && (bl || pSASGroupBase.getStopCmd() != null)) {
            iDataObject.set(FIELD_STOPCMD, (Object)pSASGroupBase.getStopCmd());
        }
        if (pSASGroupBase.isUpdateDateDirty() && (bl || pSASGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSASGroupBase.getUpdateDate());
        }
        if (pSASGroupBase.isUpdateManDirty() && (bl || pSASGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSASGroupBase.getUpdateMan());
        }
        if (pSASGroupBase.isUsageModeDirty() && (bl || pSASGroupBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSASGroupBase.getUsageMode());
        }
        if (pSASGroupBase.isUserNameDirty() && (bl || pSASGroupBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSASGroupBase.getUserName());
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
        return PSASGroupBase.remove(this, n);
    }

    private static boolean remove(PSASGroupBase pSASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSASGroupBase.resetAppFolder();
                return true;
            }
            case 1: {
                pSASGroupBase.resetASState();
                return true;
            }
            case 2: {
                pSASGroupBase.resetASType();
                return true;
            }
            case 3: {
                pSASGroupBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSASGroupBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSASGroupBase.resetHttpPort();
                return true;
            }
            case 6: {
                pSASGroupBase.resetHttpsPort();
                return true;
            }
            case 7: {
                pSASGroupBase.resetIPAddr();
                return true;
            }
            case 8: {
                pSASGroupBase.resetMemo();
                return true;
            }
            case 9: {
                pSASGroupBase.resetPasswd();
                return true;
            }
            case 10: {
                pSASGroupBase.resetPSASGroupId();
                return true;
            }
            case 11: {
                pSASGroupBase.resetPSASGroupName();
                return true;
            }
            case 12: {
                pSASGroupBase.resetPSSvrDomainId();
                return true;
            }
            case 13: {
                pSASGroupBase.resetPSSvrDomainName();
                return true;
            }
            case 14: {
                pSASGroupBase.resetRefInfo();
                return true;
            }
            case 15: {
                pSASGroupBase.resetSSHIPAddr();
                return true;
            }
            case 16: {
                pSASGroupBase.resetSSHPort();
                return true;
            }
            case 17: {
                pSASGroupBase.resetStartCmd();
                return true;
            }
            case 18: {
                pSASGroupBase.resetStopCmd();
                return true;
            }
            case 19: {
                pSASGroupBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSASGroupBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSASGroupBase.resetUsageMode();
                return true;
            }
            case 22: {
                pSASGroupBase.resetUserName();
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

    private PSASGroupBase getProxyEntity() {
        return this.proxyPSASGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSASGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSASGroupBase) {
            this.proxyPSASGroupBase = (PSASGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSASGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPFOLDER, 0);
        fieldIndexMap.put(FIELD_ASSTATE, 1);
        fieldIndexMap.put(FIELD_ASTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_HTTPPORT, 5);
        fieldIndexMap.put(FIELD_HTTPSPORT, 6);
        fieldIndexMap.put(FIELD_IPADDR, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PASSWD, 9);
        fieldIndexMap.put(FIELD_PSASGROUPID, 10);
        fieldIndexMap.put(FIELD_PSASGROUPNAME, 11);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 12);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 13);
        fieldIndexMap.put(FIELD_REFINFO, 14);
        fieldIndexMap.put(FIELD_SSHIPADDR, 15);
        fieldIndexMap.put(FIELD_SSHPORT, 16);
        fieldIndexMap.put(FIELD_STARTCMD, 17);
        fieldIndexMap.put(FIELD_STOPCMD, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USAGEMODE, 21);
        fieldIndexMap.put(FIELD_USERNAME, 22);
    }
}

