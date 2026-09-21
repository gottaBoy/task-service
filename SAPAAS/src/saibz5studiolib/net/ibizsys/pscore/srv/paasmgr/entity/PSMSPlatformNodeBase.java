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
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMSPlatformNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMSPlatformNodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String FIELD_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
    public static final String FIELD_PSMSPLATFORMNODEID = "PSMSPLATFORMNODEID";
    public static final String FIELD_PSMSPLATFORMNODENAME = "PSMSPLATFORMNODENAME";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IPADDR = 2;
    private static final int INDEX_IPADDR2 = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PASSWD = 5;
    private static final int INDEX_PORT = 6;
    private static final int INDEX_PSMSPLATFORMID = 7;
    private static final int INDEX_PSMSPLATFORMNAME = 8;
    private static final int INDEX_PSMSPLATFORMNODEID = 9;
    private static final int INDEX_PSMSPLATFORMNODENAME = 10;
    private static final int INDEX_SSHIPADDR = 11;
    private static final int INDEX_SSHPORT = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_UPLOADFILEMODE = 15;
    private static final int INDEX_UPLOADPATH = 16;
    private static final int INDEX_USERNAME = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final int INDEX_WORKSHOPPATH = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMSPlatformNodeBase proxyPSMSPlatformNodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmsplatformidDirtyFlag = false;
    private boolean psmsplatformnameDirtyFlag = false;
    private boolean psmsplatformnodeidDirtyFlag = false;
    private boolean psmsplatformnodenameDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workshoppathDirtyFlag = false;
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
    @Column(name="psmsplatformid")
    private String psmsplatformid;
    @Column(name="psmsplatformname")
    private String psmsplatformname;
    @Column(name="psmsplatformnodeid")
    private String psmsplatformnodeid;
    @Column(name="psmsplatformnodename")
    private String psmsplatformnodename;
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
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSMSPlatformLock = new Integer(1);
    private PSMSPlatform psmsplatform = null;

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

    public void setPSMSPlatformNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformnodeid = string;
        this.psmsplatformnodeidDirtyFlag = true;
    }

    public String getPSMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNodeId();
        }
        return this.psmsplatformnodeid;
    }

    public boolean isPSMSPlatformNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNodeIdDirty();
        }
        return this.psmsplatformnodeidDirtyFlag;
    }

    public void resetPSMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformNodeId();
            return;
        }
        this.psmsplatformnodeidDirtyFlag = false;
        this.psmsplatformnodeid = null;
    }

    public void setPSMSPlatformNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformnodename = string;
        this.psmsplatformnodenameDirtyFlag = true;
    }

    public String getPSMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNodeName();
        }
        return this.psmsplatformnodename;
    }

    public boolean isPSMSPlatformNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNodeNameDirty();
        }
        return this.psmsplatformnodenameDirtyFlag;
    }

    public void resetPSMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformNodeName();
            return;
        }
        this.psmsplatformnodenameDirtyFlag = false;
        this.psmsplatformnodename = null;
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
        PSMSPlatformNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMSPlatformNodeBase pSMSPlatformNodeBase) {
        pSMSPlatformNodeBase.resetCreateDate();
        pSMSPlatformNodeBase.resetCreateMan();
        pSMSPlatformNodeBase.resetIpAddr();
        pSMSPlatformNodeBase.resetIpAddr2();
        pSMSPlatformNodeBase.resetMemo();
        pSMSPlatformNodeBase.resetPasswd();
        pSMSPlatformNodeBase.resetPort();
        pSMSPlatformNodeBase.resetPSMSPlatformId();
        pSMSPlatformNodeBase.resetPSMSPlatformName();
        pSMSPlatformNodeBase.resetPSMSPlatformNodeId();
        pSMSPlatformNodeBase.resetPSMSPlatformNodeName();
        pSMSPlatformNodeBase.resetSSHIPAddr();
        pSMSPlatformNodeBase.resetSSHPort();
        pSMSPlatformNodeBase.resetUpdateDate();
        pSMSPlatformNodeBase.resetUpdateMan();
        pSMSPlatformNodeBase.resetUploadFileMode();
        pSMSPlatformNodeBase.resetUploadPath();
        pSMSPlatformNodeBase.resetUserName();
        pSMSPlatformNodeBase.resetValidFlag();
        pSMSPlatformNodeBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMID, this.getPSMSPlatformId());
        }
        if (!bl || this.isPSMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNAME, this.getPSMSPlatformName());
        }
        if (!bl || this.isPSMSPlatformNodeIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNODEID, this.getPSMSPlatformNodeId());
        }
        if (!bl || this.isPSMSPlatformNodeNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNODENAME, this.getPSMSPlatformNodeName());
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
        return PSMSPlatformNodeBase.get(this, n);
    }

    private static Object get(PSMSPlatformNodeBase pSMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformNodeBase.getCreateDate();
            }
            case 1: {
                return pSMSPlatformNodeBase.getCreateMan();
            }
            case 2: {
                return pSMSPlatformNodeBase.getIpAddr();
            }
            case 3: {
                return pSMSPlatformNodeBase.getIpAddr2();
            }
            case 4: {
                return pSMSPlatformNodeBase.getMemo();
            }
            case 5: {
                return pSMSPlatformNodeBase.getPasswd();
            }
            case 6: {
                return pSMSPlatformNodeBase.getPort();
            }
            case 7: {
                return pSMSPlatformNodeBase.getPSMSPlatformId();
            }
            case 8: {
                return pSMSPlatformNodeBase.getPSMSPlatformName();
            }
            case 9: {
                return pSMSPlatformNodeBase.getPSMSPlatformNodeId();
            }
            case 10: {
                return pSMSPlatformNodeBase.getPSMSPlatformNodeName();
            }
            case 11: {
                return pSMSPlatformNodeBase.getSSHIPAddr();
            }
            case 12: {
                return pSMSPlatformNodeBase.getSSHPort();
            }
            case 13: {
                return pSMSPlatformNodeBase.getUpdateDate();
            }
            case 14: {
                return pSMSPlatformNodeBase.getUpdateMan();
            }
            case 15: {
                return pSMSPlatformNodeBase.getUploadFileMode();
            }
            case 16: {
                return pSMSPlatformNodeBase.getUploadPath();
            }
            case 17: {
                return pSMSPlatformNodeBase.getUserName();
            }
            case 18: {
                return pSMSPlatformNodeBase.getValidFlag();
            }
            case 19: {
                return pSMSPlatformNodeBase.getWorkshopPath();
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
        PSMSPlatformNodeBase.set(this, n, object);
    }

    private static void set(PSMSPlatformNodeBase pSMSPlatformNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMSPlatformNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMSPlatformNodeBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMSPlatformNodeBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMSPlatformNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMSPlatformNodeBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMSPlatformNodeBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSMSPlatformNodeBase.setPSMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMSPlatformNodeBase.setPSMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMSPlatformNodeBase.setPSMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMSPlatformNodeBase.setPSMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMSPlatformNodeBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMSPlatformNodeBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSMSPlatformNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSMSPlatformNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMSPlatformNodeBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSMSPlatformNodeBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMSPlatformNodeBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMSPlatformNodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSMSPlatformNodeBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSMSPlatformNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSMSPlatformNodeBase pSMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformNodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSMSPlatformNodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSMSPlatformNodeBase.getIpAddr() == null;
            }
            case 3: {
                return pSMSPlatformNodeBase.getIpAddr2() == null;
            }
            case 4: {
                return pSMSPlatformNodeBase.getMemo() == null;
            }
            case 5: {
                return pSMSPlatformNodeBase.getPasswd() == null;
            }
            case 6: {
                return pSMSPlatformNodeBase.getPort() == null;
            }
            case 7: {
                return pSMSPlatformNodeBase.getPSMSPlatformId() == null;
            }
            case 8: {
                return pSMSPlatformNodeBase.getPSMSPlatformName() == null;
            }
            case 9: {
                return pSMSPlatformNodeBase.getPSMSPlatformNodeId() == null;
            }
            case 10: {
                return pSMSPlatformNodeBase.getPSMSPlatformNodeName() == null;
            }
            case 11: {
                return pSMSPlatformNodeBase.getSSHIPAddr() == null;
            }
            case 12: {
                return pSMSPlatformNodeBase.getSSHPort() == null;
            }
            case 13: {
                return pSMSPlatformNodeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSMSPlatformNodeBase.getUpdateMan() == null;
            }
            case 15: {
                return pSMSPlatformNodeBase.getUploadFileMode() == null;
            }
            case 16: {
                return pSMSPlatformNodeBase.getUploadPath() == null;
            }
            case 17: {
                return pSMSPlatformNodeBase.getUserName() == null;
            }
            case 18: {
                return pSMSPlatformNodeBase.getValidFlag() == null;
            }
            case 19: {
                return pSMSPlatformNodeBase.getWorkshopPath() == null;
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
        return PSMSPlatformNodeBase.contains(this, n);
    }

    private static boolean contains(PSMSPlatformNodeBase pSMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformNodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSMSPlatformNodeBase.isCreateManDirty();
            }
            case 2: {
                return pSMSPlatformNodeBase.isIpAddrDirty();
            }
            case 3: {
                return pSMSPlatformNodeBase.isIpAddr2Dirty();
            }
            case 4: {
                return pSMSPlatformNodeBase.isMemoDirty();
            }
            case 5: {
                return pSMSPlatformNodeBase.isPasswdDirty();
            }
            case 6: {
                return pSMSPlatformNodeBase.isPortDirty();
            }
            case 7: {
                return pSMSPlatformNodeBase.isPSMSPlatformIdDirty();
            }
            case 8: {
                return pSMSPlatformNodeBase.isPSMSPlatformNameDirty();
            }
            case 9: {
                return pSMSPlatformNodeBase.isPSMSPlatformNodeIdDirty();
            }
            case 10: {
                return pSMSPlatformNodeBase.isPSMSPlatformNodeNameDirty();
            }
            case 11: {
                return pSMSPlatformNodeBase.isSSHIPAddrDirty();
            }
            case 12: {
                return pSMSPlatformNodeBase.isSSHPortDirty();
            }
            case 13: {
                return pSMSPlatformNodeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSMSPlatformNodeBase.isUpdateManDirty();
            }
            case 15: {
                return pSMSPlatformNodeBase.isUploadFileModeDirty();
            }
            case 16: {
                return pSMSPlatformNodeBase.isUploadPathDirty();
            }
            case 17: {
                return pSMSPlatformNodeBase.isUserNameDirty();
            }
            case 18: {
                return pSMSPlatformNodeBase.isValidFlagDirty();
            }
            case 19: {
                return pSMSPlatformNodeBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMSPlatformNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMSPlatformNodeBase pSMSPlatformNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMSPlatformNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPort()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformid", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPSMSPlatformId()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformname", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPSMSPlatformName()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformnodeid", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPSMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformnodename", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getPSMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getUserName()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSMSPlatformNodeBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSMSPlatformNodeBase.getJSONValue((Object)pSMSPlatformNodeBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMSPlatformNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMSPlatformNodeBase pSMSPlatformNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMSPlatformNodeBase.getCreateDate() != null) {
            object = pSMSPlatformNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformNodeBase.getCreateMan() != null) {
            object = pSMSPlatformNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getIpAddr() != null) {
            object = pSMSPlatformNodeBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getIpAddr2() != null) {
            object = pSMSPlatformNodeBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getMemo() != null) {
            object = pSMSPlatformNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getPasswd() != null) {
            object = pSMSPlatformNodeBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getPort() != null) {
            object = pSMSPlatformNodeBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformId() != null) {
            object = pSMSPlatformNodeBase.getPSMSPlatformId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformName() != null) {
            object = pSMSPlatformNodeBase.getPSMSPlatformName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeId() != null) {
            object = pSMSPlatformNodeBase.getPSMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeName() != null) {
            object = pSMSPlatformNodeBase.getPSMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getSSHIPAddr() != null) {
            object = pSMSPlatformNodeBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getSSHPort() != null) {
            object = pSMSPlatformNodeBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformNodeBase.getUpdateDate() != null) {
            object = pSMSPlatformNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformNodeBase.getUpdateMan() != null) {
            object = pSMSPlatformNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getUploadFileMode() != null) {
            object = pSMSPlatformNodeBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getUploadPath() != null) {
            object = pSMSPlatformNodeBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getUserName() != null) {
            object = pSMSPlatformNodeBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformNodeBase.getValidFlag() != null) {
            object = pSMSPlatformNodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformNodeBase.getWorkshopPath() != null) {
            object = pSMSPlatformNodeBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMSPlatformNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMSPlatformNodeBase pSMSPlatformNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMSPlatformNodeBase.isCreateDateDirty() && (bl || pSMSPlatformNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMSPlatformNodeBase.getCreateDate());
        }
        if (pSMSPlatformNodeBase.isCreateManDirty() && (bl || pSMSPlatformNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMSPlatformNodeBase.getCreateMan());
        }
        if (pSMSPlatformNodeBase.isIpAddrDirty() && (bl || pSMSPlatformNodeBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMSPlatformNodeBase.getIpAddr());
        }
        if (pSMSPlatformNodeBase.isIpAddr2Dirty() && (bl || pSMSPlatformNodeBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSMSPlatformNodeBase.getIpAddr2());
        }
        if (pSMSPlatformNodeBase.isMemoDirty() && (bl || pSMSPlatformNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMSPlatformNodeBase.getMemo());
        }
        if (pSMSPlatformNodeBase.isPasswdDirty() && (bl || pSMSPlatformNodeBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMSPlatformNodeBase.getPasswd());
        }
        if (pSMSPlatformNodeBase.isPortDirty() && (bl || pSMSPlatformNodeBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMSPlatformNodeBase.getPort());
        }
        if (pSMSPlatformNodeBase.isPSMSPlatformIdDirty() && (bl || pSMSPlatformNodeBase.getPSMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMID, (Object)pSMSPlatformNodeBase.getPSMSPlatformId());
        }
        if (pSMSPlatformNodeBase.isPSMSPlatformNameDirty() && (bl || pSMSPlatformNodeBase.getPSMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNAME, (Object)pSMSPlatformNodeBase.getPSMSPlatformName());
        }
        if (pSMSPlatformNodeBase.isPSMSPlatformNodeIdDirty() && (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNODEID, (Object)pSMSPlatformNodeBase.getPSMSPlatformNodeId());
        }
        if (pSMSPlatformNodeBase.isPSMSPlatformNodeNameDirty() && (bl || pSMSPlatformNodeBase.getPSMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNODENAME, (Object)pSMSPlatformNodeBase.getPSMSPlatformNodeName());
        }
        if (pSMSPlatformNodeBase.isSSHIPAddrDirty() && (bl || pSMSPlatformNodeBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSMSPlatformNodeBase.getSSHIPAddr());
        }
        if (pSMSPlatformNodeBase.isSSHPortDirty() && (bl || pSMSPlatformNodeBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSMSPlatformNodeBase.getSSHPort());
        }
        if (pSMSPlatformNodeBase.isUpdateDateDirty() && (bl || pSMSPlatformNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMSPlatformNodeBase.getUpdateDate());
        }
        if (pSMSPlatformNodeBase.isUpdateManDirty() && (bl || pSMSPlatformNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMSPlatformNodeBase.getUpdateMan());
        }
        if (pSMSPlatformNodeBase.isUploadFileModeDirty() && (bl || pSMSPlatformNodeBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSMSPlatformNodeBase.getUploadFileMode());
        }
        if (pSMSPlatformNodeBase.isUploadPathDirty() && (bl || pSMSPlatformNodeBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSMSPlatformNodeBase.getUploadPath());
        }
        if (pSMSPlatformNodeBase.isUserNameDirty() && (bl || pSMSPlatformNodeBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMSPlatformNodeBase.getUserName());
        }
        if (pSMSPlatformNodeBase.isValidFlagDirty() && (bl || pSMSPlatformNodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMSPlatformNodeBase.getValidFlag());
        }
        if (pSMSPlatformNodeBase.isWorkshopPathDirty() && (bl || pSMSPlatformNodeBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSMSPlatformNodeBase.getWorkshopPath());
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
        return PSMSPlatformNodeBase.remove(this, n);
    }

    private static boolean remove(PSMSPlatformNodeBase pSMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformNodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMSPlatformNodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMSPlatformNodeBase.resetIpAddr();
                return true;
            }
            case 3: {
                pSMSPlatformNodeBase.resetIpAddr2();
                return true;
            }
            case 4: {
                pSMSPlatformNodeBase.resetMemo();
                return true;
            }
            case 5: {
                pSMSPlatformNodeBase.resetPasswd();
                return true;
            }
            case 6: {
                pSMSPlatformNodeBase.resetPort();
                return true;
            }
            case 7: {
                pSMSPlatformNodeBase.resetPSMSPlatformId();
                return true;
            }
            case 8: {
                pSMSPlatformNodeBase.resetPSMSPlatformName();
                return true;
            }
            case 9: {
                pSMSPlatformNodeBase.resetPSMSPlatformNodeId();
                return true;
            }
            case 10: {
                pSMSPlatformNodeBase.resetPSMSPlatformNodeName();
                return true;
            }
            case 11: {
                pSMSPlatformNodeBase.resetSSHIPAddr();
                return true;
            }
            case 12: {
                pSMSPlatformNodeBase.resetSSHPort();
                return true;
            }
            case 13: {
                pSMSPlatformNodeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSMSPlatformNodeBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSMSPlatformNodeBase.resetUploadFileMode();
                return true;
            }
            case 16: {
                pSMSPlatformNodeBase.resetUploadPath();
                return true;
            }
            case 17: {
                pSMSPlatformNodeBase.resetUserName();
                return true;
            }
            case 18: {
                pSMSPlatformNodeBase.resetValidFlag();
                return true;
            }
            case 19: {
                pSMSPlatformNodeBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMSPlatform getPSMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatform();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSMSPlatformLock;
        synchronized (n) {
            if (this.psmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSMSPlatformId(), (Object)this.psmsplatform.getPSMSPlatformId()) != 0L) {
                this.psmsplatform = null;
            }
            if (this.psmsplatform == null) {
                PSMSPlatform pSMSPlatform = new PSMSPlatform();
                pSMSPlatform.setPSMSPlatformId(this.getPSMSPlatformId());
                PSMSPlatformService pSMSPlatformService = (PSMSPlatformService)ServiceGlobal.getService(PSMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSMSPlatformService.autoGet((IEntity)pSMSPlatform);
                this.psmsplatform = pSMSPlatform;
            }
            return this.psmsplatform;
        }
    }

    private PSMSPlatformNodeBase getProxyEntity() {
        return this.proxyPSMSPlatformNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMSPlatformNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSMSPlatformNodeBase) {
            this.proxyPSMSPlatformNodeBase = (PSMSPlatformNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IPADDR, 2);
        fieldIndexMap.put(FIELD_IPADDR2, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PASSWD, 5);
        fieldIndexMap.put(FIELD_PORT, 6);
        fieldIndexMap.put(FIELD_PSMSPLATFORMID, 7);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNAME, 8);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNODEID, 9);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNODENAME, 10);
        fieldIndexMap.put(FIELD_SSHIPADDR, 11);
        fieldIndexMap.put(FIELD_SSHPORT, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 15);
        fieldIndexMap.put(FIELD_UPLOADPATH, 16);
        fieldIndexMap.put(FIELD_USERNAME, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 19);
    }
}

