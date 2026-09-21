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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDeployServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDeployServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDEPLOYCENTERID = "PSDEPLOYCENTERID";
    public static final String FIELD_PSDEPLOYCENTERNAME = "PSDEPLOYCENTERNAME";
    public static final String FIELD_PSDEPLOYSERVERID = "PSDEPLOYSERVERID";
    public static final String FIELD_PSDEPLOYSERVERNAME = "PSDEPLOYSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
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
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PASSWD = 4;
    private static final int INDEX_PORT = 5;
    private static final int INDEX_PSDEPLOYCENTERID = 6;
    private static final int INDEX_PSDEPLOYCENTERNAME = 7;
    private static final int INDEX_PSDEPLOYSERVERID = 8;
    private static final int INDEX_PSDEPLOYSERVERNAME = 9;
    private static final int INDEX_PSSVRDOMAINID = 10;
    private static final int INDEX_PSSVRDOMAINNAME = 11;
    private static final int INDEX_RESPOS = 12;
    private static final int INDEX_RESREADYTIME = 13;
    private static final int INDEX_RESSTATE = 14;
    private static final int INDEX_SSHIPADDR = 15;
    private static final int INDEX_SSHPORT = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_UPLOADFILEMODE = 19;
    private static final int INDEX_UPLOADPATH = 20;
    private static final int INDEX_USERNAME = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final int INDEX_WORKSHOPPATH = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDeployServerBase proxyPSDeployServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdeploycenteridDirtyFlag = false;
    private boolean psdeploycenternameDirtyFlag = false;
    private boolean psdeployserveridDirtyFlag = false;
    private boolean psdeployservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
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
    @Column(name="psdeployserverid")
    private String psdeployserverid;
    @Column(name="psdeployservername")
    private String psdeployservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
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
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSDeployCenterLock = new Integer(1);
    private PSDeployCenter psdeploycenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

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

    public void setPSDeployServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeployserverid = string;
        this.psdeployserveridDirtyFlag = true;
    }

    public String getPSDeployServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployServerId();
        }
        return this.psdeployserverid;
    }

    public boolean isPSDeployServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployServerIdDirty();
        }
        return this.psdeployserveridDirtyFlag;
    }

    public void resetPSDeployServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployServerId();
            return;
        }
        this.psdeployserveridDirtyFlag = false;
        this.psdeployserverid = null;
    }

    public void setPSDeployServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeployservername = string;
        this.psdeployservernameDirtyFlag = true;
    }

    public String getPSDeployServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployServerName();
        }
        return this.psdeployservername;
    }

    public boolean isPSDeployServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployServerNameDirty();
        }
        return this.psdeployservernameDirtyFlag;
    }

    public void resetPSDeployServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployServerName();
            return;
        }
        this.psdeployservernameDirtyFlag = false;
        this.psdeployservername = null;
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
        PSDeployServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDeployServerBase pSDeployServerBase) {
        pSDeployServerBase.resetCreateDate();
        pSDeployServerBase.resetCreateMan();
        pSDeployServerBase.resetIpAddr();
        pSDeployServerBase.resetMemo();
        pSDeployServerBase.resetPasswd();
        pSDeployServerBase.resetPort();
        pSDeployServerBase.resetPSDeployCenterId();
        pSDeployServerBase.resetPSDeployCenterName();
        pSDeployServerBase.resetPSDeployServerId();
        pSDeployServerBase.resetPSDeployServerName();
        pSDeployServerBase.resetPSSvrDomainId();
        pSDeployServerBase.resetPSSvrDomainName();
        pSDeployServerBase.resetResPos();
        pSDeployServerBase.resetResReadyTime();
        pSDeployServerBase.resetResState();
        pSDeployServerBase.resetSSHIPAddr();
        pSDeployServerBase.resetSSHPort();
        pSDeployServerBase.resetUpdateDate();
        pSDeployServerBase.resetUpdateMan();
        pSDeployServerBase.resetUploadFileMode();
        pSDeployServerBase.resetUploadPath();
        pSDeployServerBase.resetUserName();
        pSDeployServerBase.resetValidFlag();
        pSDeployServerBase.resetWorkshopPath();
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
        if (!bl || this.isPSDeployServerIdDirty()) {
            hashMap.put(FIELD_PSDEPLOYSERVERID, this.getPSDeployServerId());
        }
        if (!bl || this.isPSDeployServerNameDirty()) {
            hashMap.put(FIELD_PSDEPLOYSERVERNAME, this.getPSDeployServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
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
        return PSDeployServerBase.get(this, n);
    }

    private static Object get(PSDeployServerBase pSDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployServerBase.getCreateDate();
            }
            case 1: {
                return pSDeployServerBase.getCreateMan();
            }
            case 2: {
                return pSDeployServerBase.getIpAddr();
            }
            case 3: {
                return pSDeployServerBase.getMemo();
            }
            case 4: {
                return pSDeployServerBase.getPasswd();
            }
            case 5: {
                return pSDeployServerBase.getPort();
            }
            case 6: {
                return pSDeployServerBase.getPSDeployCenterId();
            }
            case 7: {
                return pSDeployServerBase.getPSDeployCenterName();
            }
            case 8: {
                return pSDeployServerBase.getPSDeployServerId();
            }
            case 9: {
                return pSDeployServerBase.getPSDeployServerName();
            }
            case 10: {
                return pSDeployServerBase.getPSSvrDomainId();
            }
            case 11: {
                return pSDeployServerBase.getPSSvrDomainName();
            }
            case 12: {
                return pSDeployServerBase.getResPos();
            }
            case 13: {
                return pSDeployServerBase.getResReadyTime();
            }
            case 14: {
                return pSDeployServerBase.getResState();
            }
            case 15: {
                return pSDeployServerBase.getSSHIPAddr();
            }
            case 16: {
                return pSDeployServerBase.getSSHPort();
            }
            case 17: {
                return pSDeployServerBase.getUpdateDate();
            }
            case 18: {
                return pSDeployServerBase.getUpdateMan();
            }
            case 19: {
                return pSDeployServerBase.getUploadFileMode();
            }
            case 20: {
                return pSDeployServerBase.getUploadPath();
            }
            case 21: {
                return pSDeployServerBase.getUserName();
            }
            case 22: {
                return pSDeployServerBase.getValidFlag();
            }
            case 23: {
                return pSDeployServerBase.getWorkshopPath();
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
        PSDeployServerBase.set(this, n, object);
    }

    private static void set(PSDeployServerBase pSDeployServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDeployServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDeployServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDeployServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDeployServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDeployServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDeployServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDeployServerBase.setPSDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDeployServerBase.setPSDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDeployServerBase.setPSDeployServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDeployServerBase.setPSDeployServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDeployServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDeployServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDeployServerBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDeployServerBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDeployServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDeployServerBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDeployServerBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDeployServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDeployServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDeployServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDeployServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDeployServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDeployServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDeployServerBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDeployServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDeployServerBase pSDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDeployServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDeployServerBase.getIpAddr() == null;
            }
            case 3: {
                return pSDeployServerBase.getMemo() == null;
            }
            case 4: {
                return pSDeployServerBase.getPasswd() == null;
            }
            case 5: {
                return pSDeployServerBase.getPort() == null;
            }
            case 6: {
                return pSDeployServerBase.getPSDeployCenterId() == null;
            }
            case 7: {
                return pSDeployServerBase.getPSDeployCenterName() == null;
            }
            case 8: {
                return pSDeployServerBase.getPSDeployServerId() == null;
            }
            case 9: {
                return pSDeployServerBase.getPSDeployServerName() == null;
            }
            case 10: {
                return pSDeployServerBase.getPSSvrDomainId() == null;
            }
            case 11: {
                return pSDeployServerBase.getPSSvrDomainName() == null;
            }
            case 12: {
                return pSDeployServerBase.getResPos() == null;
            }
            case 13: {
                return pSDeployServerBase.getResReadyTime() == null;
            }
            case 14: {
                return pSDeployServerBase.getResState() == null;
            }
            case 15: {
                return pSDeployServerBase.getSSHIPAddr() == null;
            }
            case 16: {
                return pSDeployServerBase.getSSHPort() == null;
            }
            case 17: {
                return pSDeployServerBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDeployServerBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDeployServerBase.getUploadFileMode() == null;
            }
            case 20: {
                return pSDeployServerBase.getUploadPath() == null;
            }
            case 21: {
                return pSDeployServerBase.getUserName() == null;
            }
            case 22: {
                return pSDeployServerBase.getValidFlag() == null;
            }
            case 23: {
                return pSDeployServerBase.getWorkshopPath() == null;
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
        return PSDeployServerBase.contains(this, n);
    }

    private static boolean contains(PSDeployServerBase pSDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDeployServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDeployServerBase.isCreateManDirty();
            }
            case 2: {
                return pSDeployServerBase.isIpAddrDirty();
            }
            case 3: {
                return pSDeployServerBase.isMemoDirty();
            }
            case 4: {
                return pSDeployServerBase.isPasswdDirty();
            }
            case 5: {
                return pSDeployServerBase.isPortDirty();
            }
            case 6: {
                return pSDeployServerBase.isPSDeployCenterIdDirty();
            }
            case 7: {
                return pSDeployServerBase.isPSDeployCenterNameDirty();
            }
            case 8: {
                return pSDeployServerBase.isPSDeployServerIdDirty();
            }
            case 9: {
                return pSDeployServerBase.isPSDeployServerNameDirty();
            }
            case 10: {
                return pSDeployServerBase.isPSSvrDomainIdDirty();
            }
            case 11: {
                return pSDeployServerBase.isPSSvrDomainNameDirty();
            }
            case 12: {
                return pSDeployServerBase.isResPosDirty();
            }
            case 13: {
                return pSDeployServerBase.isResReadyTimeDirty();
            }
            case 14: {
                return pSDeployServerBase.isResStateDirty();
            }
            case 15: {
                return pSDeployServerBase.isSSHIPAddrDirty();
            }
            case 16: {
                return pSDeployServerBase.isSSHPortDirty();
            }
            case 17: {
                return pSDeployServerBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDeployServerBase.isUpdateManDirty();
            }
            case 19: {
                return pSDeployServerBase.isUploadFileModeDirty();
            }
            case 20: {
                return pSDeployServerBase.isUploadPathDirty();
            }
            case 21: {
                return pSDeployServerBase.isUserNameDirty();
            }
            case 22: {
                return pSDeployServerBase.isValidFlagDirty();
            }
            case 23: {
                return pSDeployServerBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDeployServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDeployServerBase pSDeployServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDeployServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPort()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycenterid", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSDeployCenterId()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycentername", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSDeployCenterName()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSDeployServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeployserverid", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSDeployServerId()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSDeployServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeployservername", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSDeployServerName()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getResPos()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDeployServerBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDeployServerBase.getJSONValue((Object)pSDeployServerBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDeployServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDeployServerBase pSDeployServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDeployServerBase.getCreateDate() != null) {
            object = pSDeployServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDeployServerBase.getCreateMan() != null) {
            object = pSDeployServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getIpAddr() != null) {
            object = pSDeployServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getMemo() != null) {
            object = pSDeployServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPasswd() != null) {
            object = pSDeployServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPort() != null) {
            object = pSDeployServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployServerBase.getPSDeployCenterId() != null) {
            object = pSDeployServerBase.getPSDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPSDeployCenterName() != null) {
            object = pSDeployServerBase.getPSDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPSDeployServerId() != null) {
            object = pSDeployServerBase.getPSDeployServerId();
            xmlNode.setAttribute(FIELD_PSDEPLOYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPSDeployServerName() != null) {
            object = pSDeployServerBase.getPSDeployServerName();
            xmlNode.setAttribute(FIELD_PSDEPLOYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPSSvrDomainId() != null) {
            object = pSDeployServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getPSSvrDomainName() != null) {
            object = pSDeployServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getResPos() != null) {
            object = pSDeployServerBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployServerBase.getResReadyTime() != null) {
            object = pSDeployServerBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDeployServerBase.getResState() != null) {
            object = pSDeployServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployServerBase.getSSHIPAddr() != null) {
            object = pSDeployServerBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getSSHPort() != null) {
            object = pSDeployServerBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployServerBase.getUpdateDate() != null) {
            object = pSDeployServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDeployServerBase.getUpdateMan() != null) {
            object = pSDeployServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getUploadFileMode() != null) {
            object = pSDeployServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getUploadPath() != null) {
            object = pSDeployServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getUserName() != null) {
            object = pSDeployServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDeployServerBase.getValidFlag() != null) {
            object = pSDeployServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDeployServerBase.getWorkshopPath() != null) {
            object = pSDeployServerBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDeployServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDeployServerBase pSDeployServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDeployServerBase.isCreateDateDirty() && (bl || pSDeployServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDeployServerBase.getCreateDate());
        }
        if (pSDeployServerBase.isCreateManDirty() && (bl || pSDeployServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDeployServerBase.getCreateMan());
        }
        if (pSDeployServerBase.isIpAddrDirty() && (bl || pSDeployServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDeployServerBase.getIpAddr());
        }
        if (pSDeployServerBase.isMemoDirty() && (bl || pSDeployServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDeployServerBase.getMemo());
        }
        if (pSDeployServerBase.isPasswdDirty() && (bl || pSDeployServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDeployServerBase.getPasswd());
        }
        if (pSDeployServerBase.isPortDirty() && (bl || pSDeployServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDeployServerBase.getPort());
        }
        if (pSDeployServerBase.isPSDeployCenterIdDirty() && (bl || pSDeployServerBase.getPSDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERID, (Object)pSDeployServerBase.getPSDeployCenterId());
        }
        if (pSDeployServerBase.isPSDeployCenterNameDirty() && (bl || pSDeployServerBase.getPSDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERNAME, (Object)pSDeployServerBase.getPSDeployCenterName());
        }
        if (pSDeployServerBase.isPSDeployServerIdDirty() && (bl || pSDeployServerBase.getPSDeployServerId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYSERVERID, (Object)pSDeployServerBase.getPSDeployServerId());
        }
        if (pSDeployServerBase.isPSDeployServerNameDirty() && (bl || pSDeployServerBase.getPSDeployServerName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYSERVERNAME, (Object)pSDeployServerBase.getPSDeployServerName());
        }
        if (pSDeployServerBase.isPSSvrDomainIdDirty() && (bl || pSDeployServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDeployServerBase.getPSSvrDomainId());
        }
        if (pSDeployServerBase.isPSSvrDomainNameDirty() && (bl || pSDeployServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDeployServerBase.getPSSvrDomainName());
        }
        if (pSDeployServerBase.isResPosDirty() && (bl || pSDeployServerBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDeployServerBase.getResPos());
        }
        if (pSDeployServerBase.isResReadyTimeDirty() && (bl || pSDeployServerBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDeployServerBase.getResReadyTime());
        }
        if (pSDeployServerBase.isResStateDirty() && (bl || pSDeployServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDeployServerBase.getResState());
        }
        if (pSDeployServerBase.isSSHIPAddrDirty() && (bl || pSDeployServerBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDeployServerBase.getSSHIPAddr());
        }
        if (pSDeployServerBase.isSSHPortDirty() && (bl || pSDeployServerBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDeployServerBase.getSSHPort());
        }
        if (pSDeployServerBase.isUpdateDateDirty() && (bl || pSDeployServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDeployServerBase.getUpdateDate());
        }
        if (pSDeployServerBase.isUpdateManDirty() && (bl || pSDeployServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDeployServerBase.getUpdateMan());
        }
        if (pSDeployServerBase.isUploadFileModeDirty() && (bl || pSDeployServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDeployServerBase.getUploadFileMode());
        }
        if (pSDeployServerBase.isUploadPathDirty() && (bl || pSDeployServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDeployServerBase.getUploadPath());
        }
        if (pSDeployServerBase.isUserNameDirty() && (bl || pSDeployServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDeployServerBase.getUserName());
        }
        if (pSDeployServerBase.isValidFlagDirty() && (bl || pSDeployServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDeployServerBase.getValidFlag());
        }
        if (pSDeployServerBase.isWorkshopPathDirty() && (bl || pSDeployServerBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDeployServerBase.getWorkshopPath());
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
        return PSDeployServerBase.remove(this, n);
    }

    private static boolean remove(PSDeployServerBase pSDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDeployServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDeployServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDeployServerBase.resetIpAddr();
                return true;
            }
            case 3: {
                pSDeployServerBase.resetMemo();
                return true;
            }
            case 4: {
                pSDeployServerBase.resetPasswd();
                return true;
            }
            case 5: {
                pSDeployServerBase.resetPort();
                return true;
            }
            case 6: {
                pSDeployServerBase.resetPSDeployCenterId();
                return true;
            }
            case 7: {
                pSDeployServerBase.resetPSDeployCenterName();
                return true;
            }
            case 8: {
                pSDeployServerBase.resetPSDeployServerId();
                return true;
            }
            case 9: {
                pSDeployServerBase.resetPSDeployServerName();
                return true;
            }
            case 10: {
                pSDeployServerBase.resetPSSvrDomainId();
                return true;
            }
            case 11: {
                pSDeployServerBase.resetPSSvrDomainName();
                return true;
            }
            case 12: {
                pSDeployServerBase.resetResPos();
                return true;
            }
            case 13: {
                pSDeployServerBase.resetResReadyTime();
                return true;
            }
            case 14: {
                pSDeployServerBase.resetResState();
                return true;
            }
            case 15: {
                pSDeployServerBase.resetSSHIPAddr();
                return true;
            }
            case 16: {
                pSDeployServerBase.resetSSHPort();
                return true;
            }
            case 17: {
                pSDeployServerBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDeployServerBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDeployServerBase.resetUploadFileMode();
                return true;
            }
            case 20: {
                pSDeployServerBase.resetUploadPath();
                return true;
            }
            case 21: {
                pSDeployServerBase.resetUserName();
                return true;
            }
            case 22: {
                pSDeployServerBase.resetValidFlag();
                return true;
            }
            case 23: {
                pSDeployServerBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDeployCenter getPSDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenter();
        }
        if (this.getPSDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDeployCenterLock;
        synchronized (n) {
            if (this.psdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDeployCenterId(), (Object)this.psdeploycenter.getPSDeployCenterId()) != 0L) {
                this.psdeploycenter = null;
            }
            if (this.psdeploycenter == null) {
                PSDeployCenter pSDeployCenter = new PSDeployCenter();
                pSDeployCenter.setPSDeployCenterId(this.getPSDeployCenterId());
                PSDeployCenterService pSDeployCenterService = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDeployCenterService.autoGet((IEntity)pSDeployCenter);
                this.psdeploycenter = pSDeployCenter;
            }
            return this.psdeploycenter;
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

    private PSDeployServerBase getProxyEntity() {
        return this.proxyPSDeployServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDeployServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDeployServerBase) {
            this.proxyPSDeployServerBase = (PSDeployServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IPADDR, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PASSWD, 4);
        fieldIndexMap.put(FIELD_PORT, 5);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPLOYSERVERID, 8);
        fieldIndexMap.put(FIELD_PSDEPLOYSERVERNAME, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 10);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 11);
        fieldIndexMap.put(FIELD_RESPOS, 12);
        fieldIndexMap.put(FIELD_RESREADYTIME, 13);
        fieldIndexMap.put(FIELD_RESSTATE, 14);
        fieldIndexMap.put(FIELD_SSHIPADDR, 15);
        fieldIndexMap.put(FIELD_SSHPORT, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 19);
        fieldIndexMap.put(FIELD_UPLOADPATH, 20);
        fieldIndexMap.put(FIELD_USERNAME, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 23);
    }
}

