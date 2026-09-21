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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDeployServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDeployServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDCDEPLOYSERVERID = "PSDCDEPLOYSERVERID";
    public static final String FIELD_PSDCDEPLOYSERVERNAME = "PSDCDEPLOYSERVERNAME";
    public static final String FIELD_PSDEPLOYSERVERID = "PSDEPLOYSERVERID";
    public static final String FIELD_PSDEPLOYSERVERNAME = "PSDEPLOYSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
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
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_EXPRIEDTIME = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PASSWD = 6;
    private static final int INDEX_PORT = 7;
    private static final int INDEX_PSDCDEPLOYCENTERID = 8;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 9;
    private static final int INDEX_PSDCDEPLOYSERVERID = 10;
    private static final int INDEX_PSDCDEPLOYSERVERNAME = 11;
    private static final int INDEX_PSDEPLOYSERVERID = 12;
    private static final int INDEX_PSDEPLOYSERVERNAME = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_REFCOUNT = 16;
    private static final int INDEX_RESPOS = 17;
    private static final int INDEX_RESREADYTIME = 18;
    private static final int INDEX_RESSTATE = 19;
    private static final int INDEX_SSHIPADDR = 20;
    private static final int INDEX_SSHPORT = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_UPLOADFILEMODE = 24;
    private static final int INDEX_UPLOADPATH = 25;
    private static final int INDEX_USERNAME = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final int INDEX_WORKSHOPPATH = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDeployServerBase proxyPSDCDeployServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdcdeployserveridDirtyFlag = false;
    private boolean psdcdeployservernameDirtyFlag = false;
    private boolean psdeployserveridDirtyFlag = false;
    private boolean psdeployservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdcdeployserverid")
    private String psdcdeployserverid;
    @Column(name="psdcdeployservername")
    private String psdcdeployservername;
    @Column(name="psdeployserverid")
    private String psdeployserverid;
    @Column(name="psdeployservername")
    private String psdeployservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="refcount")
    private Integer refcount;
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
    private Integer objPSDCDeployCenterLock = new Integer(1);
    private PSDCDeployCenter psdcdeploycenter = null;
    private Integer objPSDeployServerLock = new Integer(1);
    private PSDeployServer psdeployserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setPSDCDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycenterid = string;
        this.psdcdeploycenteridDirtyFlag = true;
    }

    public String getPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterId();
        }
        return this.psdcdeploycenterid;
    }

    public boolean isPSDCDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterIdDirty();
        }
        return this.psdcdeploycenteridDirtyFlag;
    }

    public void resetPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterId();
            return;
        }
        this.psdcdeploycenteridDirtyFlag = false;
        this.psdcdeploycenterid = null;
    }

    public void setPSDCDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycentername = string;
        this.psdcdeploycenternameDirtyFlag = true;
    }

    public String getPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterName();
        }
        return this.psdcdeploycentername;
    }

    public boolean isPSDCDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterNameDirty();
        }
        return this.psdcdeploycenternameDirtyFlag;
    }

    public void resetPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterName();
            return;
        }
        this.psdcdeploycenternameDirtyFlag = false;
        this.psdcdeploycentername = null;
    }

    public void setPSDCDeployServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeployserverid = string;
        this.psdcdeployserveridDirtyFlag = true;
    }

    public String getPSDCDeployServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServerId();
        }
        return this.psdcdeployserverid;
    }

    public boolean isPSDCDeployServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployServerIdDirty();
        }
        return this.psdcdeployserveridDirtyFlag;
    }

    public void resetPSDCDeployServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployServerId();
            return;
        }
        this.psdcdeployserveridDirtyFlag = false;
        this.psdcdeployserverid = null;
    }

    public void setPSDCDeployServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeployservername = string;
        this.psdcdeployservernameDirtyFlag = true;
    }

    public String getPSDCDeployServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServerName();
        }
        return this.psdcdeployservername;
    }

    public boolean isPSDCDeployServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployServerNameDirty();
        }
        return this.psdcdeployservernameDirtyFlag;
    }

    public void resetPSDCDeployServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployServerName();
            return;
        }
        this.psdcdeployservernameDirtyFlag = false;
        this.psdcdeployservername = null;
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
        PSDCDeployServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDeployServerBase pSDCDeployServerBase) {
        pSDCDeployServerBase.resetCreateDate();
        pSDCDeployServerBase.resetCreateMan();
        pSDCDeployServerBase.resetDefaultFlag();
        pSDCDeployServerBase.resetExpriedTime();
        pSDCDeployServerBase.resetIpAddr();
        pSDCDeployServerBase.resetMemo();
        pSDCDeployServerBase.resetPasswd();
        pSDCDeployServerBase.resetPort();
        pSDCDeployServerBase.resetPSDCDeployCenterId();
        pSDCDeployServerBase.resetPSDCDeployCenterName();
        pSDCDeployServerBase.resetPSDCDeployServerId();
        pSDCDeployServerBase.resetPSDCDeployServerName();
        pSDCDeployServerBase.resetPSDeployServerId();
        pSDCDeployServerBase.resetPSDeployServerName();
        pSDCDeployServerBase.resetPSDevCenterId();
        pSDCDeployServerBase.resetPSDevCenterName();
        pSDCDeployServerBase.resetRefCount();
        pSDCDeployServerBase.resetResPos();
        pSDCDeployServerBase.resetResReadyTime();
        pSDCDeployServerBase.resetResState();
        pSDCDeployServerBase.resetSSHIPAddr();
        pSDCDeployServerBase.resetSSHPort();
        pSDCDeployServerBase.resetUpdateDate();
        pSDCDeployServerBase.resetUpdateMan();
        pSDCDeployServerBase.resetUploadFileMode();
        pSDCDeployServerBase.resetUploadPath();
        pSDCDeployServerBase.resetUserName();
        pSDCDeployServerBase.resetValidFlag();
        pSDCDeployServerBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDCDeployServerIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYSERVERID, this.getPSDCDeployServerId());
        }
        if (!bl || this.isPSDCDeployServerNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYSERVERNAME, this.getPSDCDeployServerName());
        }
        if (!bl || this.isPSDeployServerIdDirty()) {
            hashMap.put(FIELD_PSDEPLOYSERVERID, this.getPSDeployServerId());
        }
        if (!bl || this.isPSDeployServerNameDirty()) {
            hashMap.put(FIELD_PSDEPLOYSERVERNAME, this.getPSDeployServerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        return PSDCDeployServerBase.get(this, n);
    }

    private static Object get(PSDCDeployServerBase pSDCDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployServerBase.getCreateDate();
            }
            case 1: {
                return pSDCDeployServerBase.getCreateMan();
            }
            case 2: {
                return pSDCDeployServerBase.getDefaultFlag();
            }
            case 3: {
                return pSDCDeployServerBase.getExpriedTime();
            }
            case 4: {
                return pSDCDeployServerBase.getIpAddr();
            }
            case 5: {
                return pSDCDeployServerBase.getMemo();
            }
            case 6: {
                return pSDCDeployServerBase.getPasswd();
            }
            case 7: {
                return pSDCDeployServerBase.getPort();
            }
            case 8: {
                return pSDCDeployServerBase.getPSDCDeployCenterId();
            }
            case 9: {
                return pSDCDeployServerBase.getPSDCDeployCenterName();
            }
            case 10: {
                return pSDCDeployServerBase.getPSDCDeployServerId();
            }
            case 11: {
                return pSDCDeployServerBase.getPSDCDeployServerName();
            }
            case 12: {
                return pSDCDeployServerBase.getPSDeployServerId();
            }
            case 13: {
                return pSDCDeployServerBase.getPSDeployServerName();
            }
            case 14: {
                return pSDCDeployServerBase.getPSDevCenterId();
            }
            case 15: {
                return pSDCDeployServerBase.getPSDevCenterName();
            }
            case 16: {
                return pSDCDeployServerBase.getRefCount();
            }
            case 17: {
                return pSDCDeployServerBase.getResPos();
            }
            case 18: {
                return pSDCDeployServerBase.getResReadyTime();
            }
            case 19: {
                return pSDCDeployServerBase.getResState();
            }
            case 20: {
                return pSDCDeployServerBase.getSSHIPAddr();
            }
            case 21: {
                return pSDCDeployServerBase.getSSHPort();
            }
            case 22: {
                return pSDCDeployServerBase.getUpdateDate();
            }
            case 23: {
                return pSDCDeployServerBase.getUpdateMan();
            }
            case 24: {
                return pSDCDeployServerBase.getUploadFileMode();
            }
            case 25: {
                return pSDCDeployServerBase.getUploadPath();
            }
            case 26: {
                return pSDCDeployServerBase.getUserName();
            }
            case 27: {
                return pSDCDeployServerBase.getValidFlag();
            }
            case 28: {
                return pSDCDeployServerBase.getWorkshopPath();
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
        PSDCDeployServerBase.set(this, n, object);
    }

    private static void set(PSDCDeployServerBase pSDCDeployServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDeployServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDeployServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDeployServerBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCDeployServerBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCDeployServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDeployServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDeployServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDeployServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCDeployServerBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDeployServerBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDeployServerBase.setPSDCDeployServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDeployServerBase.setPSDCDeployServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCDeployServerBase.setPSDeployServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCDeployServerBase.setPSDeployServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCDeployServerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCDeployServerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCDeployServerBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDCDeployServerBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDCDeployServerBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDCDeployServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDCDeployServerBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCDeployServerBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCDeployServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDCDeployServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCDeployServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCDeployServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCDeployServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCDeployServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDCDeployServerBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCDeployServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDeployServerBase pSDCDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDeployServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDeployServerBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSDCDeployServerBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDCDeployServerBase.getIpAddr() == null;
            }
            case 5: {
                return pSDCDeployServerBase.getMemo() == null;
            }
            case 6: {
                return pSDCDeployServerBase.getPasswd() == null;
            }
            case 7: {
                return pSDCDeployServerBase.getPort() == null;
            }
            case 8: {
                return pSDCDeployServerBase.getPSDCDeployCenterId() == null;
            }
            case 9: {
                return pSDCDeployServerBase.getPSDCDeployCenterName() == null;
            }
            case 10: {
                return pSDCDeployServerBase.getPSDCDeployServerId() == null;
            }
            case 11: {
                return pSDCDeployServerBase.getPSDCDeployServerName() == null;
            }
            case 12: {
                return pSDCDeployServerBase.getPSDeployServerId() == null;
            }
            case 13: {
                return pSDCDeployServerBase.getPSDeployServerName() == null;
            }
            case 14: {
                return pSDCDeployServerBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDCDeployServerBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSDCDeployServerBase.getRefCount() == null;
            }
            case 17: {
                return pSDCDeployServerBase.getResPos() == null;
            }
            case 18: {
                return pSDCDeployServerBase.getResReadyTime() == null;
            }
            case 19: {
                return pSDCDeployServerBase.getResState() == null;
            }
            case 20: {
                return pSDCDeployServerBase.getSSHIPAddr() == null;
            }
            case 21: {
                return pSDCDeployServerBase.getSSHPort() == null;
            }
            case 22: {
                return pSDCDeployServerBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDCDeployServerBase.getUpdateMan() == null;
            }
            case 24: {
                return pSDCDeployServerBase.getUploadFileMode() == null;
            }
            case 25: {
                return pSDCDeployServerBase.getUploadPath() == null;
            }
            case 26: {
                return pSDCDeployServerBase.getUserName() == null;
            }
            case 27: {
                return pSDCDeployServerBase.getValidFlag() == null;
            }
            case 28: {
                return pSDCDeployServerBase.getWorkshopPath() == null;
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
        return PSDCDeployServerBase.contains(this, n);
    }

    private static boolean contains(PSDCDeployServerBase pSDCDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDeployServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDeployServerBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDeployServerBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSDCDeployServerBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDCDeployServerBase.isIpAddrDirty();
            }
            case 5: {
                return pSDCDeployServerBase.isMemoDirty();
            }
            case 6: {
                return pSDCDeployServerBase.isPasswdDirty();
            }
            case 7: {
                return pSDCDeployServerBase.isPortDirty();
            }
            case 8: {
                return pSDCDeployServerBase.isPSDCDeployCenterIdDirty();
            }
            case 9: {
                return pSDCDeployServerBase.isPSDCDeployCenterNameDirty();
            }
            case 10: {
                return pSDCDeployServerBase.isPSDCDeployServerIdDirty();
            }
            case 11: {
                return pSDCDeployServerBase.isPSDCDeployServerNameDirty();
            }
            case 12: {
                return pSDCDeployServerBase.isPSDeployServerIdDirty();
            }
            case 13: {
                return pSDCDeployServerBase.isPSDeployServerNameDirty();
            }
            case 14: {
                return pSDCDeployServerBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDCDeployServerBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSDCDeployServerBase.isRefCountDirty();
            }
            case 17: {
                return pSDCDeployServerBase.isResPosDirty();
            }
            case 18: {
                return pSDCDeployServerBase.isResReadyTimeDirty();
            }
            case 19: {
                return pSDCDeployServerBase.isResStateDirty();
            }
            case 20: {
                return pSDCDeployServerBase.isSSHIPAddrDirty();
            }
            case 21: {
                return pSDCDeployServerBase.isSSHPortDirty();
            }
            case 22: {
                return pSDCDeployServerBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDCDeployServerBase.isUpdateManDirty();
            }
            case 24: {
                return pSDCDeployServerBase.isUploadFileModeDirty();
            }
            case 25: {
                return pSDCDeployServerBase.isUploadPathDirty();
            }
            case 26: {
                return pSDCDeployServerBase.isUserNameDirty();
            }
            case 27: {
                return pSDCDeployServerBase.isValidFlagDirty();
            }
            case 28: {
                return pSDCDeployServerBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDeployServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDeployServerBase pSDCDeployServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDeployServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPort()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeployserverid", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDCDeployServerId()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeployservername", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDCDeployServerName()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDeployServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeployserverid", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDeployServerId()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDeployServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeployservername", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDeployServerName()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCDeployServerBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCDeployServerBase.getJSONValue((Object)pSDCDeployServerBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDeployServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDeployServerBase pSDCDeployServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDeployServerBase.getCreateDate() != null) {
            object = pSDCDeployServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getCreateMan() != null) {
            object = pSDCDeployServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getDefaultFlag() != null) {
            object = pSDCDeployServerBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getExpriedTime() != null) {
            object = pSDCDeployServerBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getIpAddr() != null) {
            object = pSDCDeployServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getMemo() != null) {
            object = pSDCDeployServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPasswd() != null) {
            object = pSDCDeployServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPort() != null) {
            object = pSDCDeployServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployCenterId() != null) {
            object = pSDCDeployServerBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployCenterName() != null) {
            object = pSDCDeployServerBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployServerId() != null) {
            object = pSDCDeployServerBase.getPSDCDeployServerId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDCDeployServerName() != null) {
            object = pSDCDeployServerBase.getPSDCDeployServerName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDeployServerId() != null) {
            object = pSDCDeployServerBase.getPSDeployServerId();
            xmlNode.setAttribute(FIELD_PSDEPLOYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDeployServerName() != null) {
            object = pSDCDeployServerBase.getPSDeployServerName();
            xmlNode.setAttribute(FIELD_PSDEPLOYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDevCenterId() != null) {
            object = pSDCDeployServerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getPSDevCenterName() != null) {
            object = pSDCDeployServerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getRefCount() != null) {
            object = pSDCDeployServerBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getResPos() != null) {
            object = pSDCDeployServerBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getResReadyTime() != null) {
            object = pSDCDeployServerBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getResState() != null) {
            object = pSDCDeployServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getSSHIPAddr() != null) {
            object = pSDCDeployServerBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getSSHPort() != null) {
            object = pSDCDeployServerBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getUpdateDate() != null) {
            object = pSDCDeployServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getUpdateMan() != null) {
            object = pSDCDeployServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getUploadFileMode() != null) {
            object = pSDCDeployServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getUploadPath() != null) {
            object = pSDCDeployServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getUserName() != null) {
            object = pSDCDeployServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDeployServerBase.getValidFlag() != null) {
            object = pSDCDeployServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDeployServerBase.getWorkshopPath() != null) {
            object = pSDCDeployServerBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDeployServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDeployServerBase pSDCDeployServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDeployServerBase.isCreateDateDirty() && (bl || pSDCDeployServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDeployServerBase.getCreateDate());
        }
        if (pSDCDeployServerBase.isCreateManDirty() && (bl || pSDCDeployServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDeployServerBase.getCreateMan());
        }
        if (pSDCDeployServerBase.isDefaultFlagDirty() && (bl || pSDCDeployServerBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCDeployServerBase.getDefaultFlag());
        }
        if (pSDCDeployServerBase.isExpriedTimeDirty() && (bl || pSDCDeployServerBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCDeployServerBase.getExpriedTime());
        }
        if (pSDCDeployServerBase.isIpAddrDirty() && (bl || pSDCDeployServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCDeployServerBase.getIpAddr());
        }
        if (pSDCDeployServerBase.isMemoDirty() && (bl || pSDCDeployServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDeployServerBase.getMemo());
        }
        if (pSDCDeployServerBase.isPasswdDirty() && (bl || pSDCDeployServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCDeployServerBase.getPasswd());
        }
        if (pSDCDeployServerBase.isPortDirty() && (bl || pSDCDeployServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCDeployServerBase.getPort());
        }
        if (pSDCDeployServerBase.isPSDCDeployCenterIdDirty() && (bl || pSDCDeployServerBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDCDeployServerBase.getPSDCDeployCenterId());
        }
        if (pSDCDeployServerBase.isPSDCDeployCenterNameDirty() && (bl || pSDCDeployServerBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDCDeployServerBase.getPSDCDeployCenterName());
        }
        if (pSDCDeployServerBase.isPSDCDeployServerIdDirty() && (bl || pSDCDeployServerBase.getPSDCDeployServerId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYSERVERID, (Object)pSDCDeployServerBase.getPSDCDeployServerId());
        }
        if (pSDCDeployServerBase.isPSDCDeployServerNameDirty() && (bl || pSDCDeployServerBase.getPSDCDeployServerName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYSERVERNAME, (Object)pSDCDeployServerBase.getPSDCDeployServerName());
        }
        if (pSDCDeployServerBase.isPSDeployServerIdDirty() && (bl || pSDCDeployServerBase.getPSDeployServerId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYSERVERID, (Object)pSDCDeployServerBase.getPSDeployServerId());
        }
        if (pSDCDeployServerBase.isPSDeployServerNameDirty() && (bl || pSDCDeployServerBase.getPSDeployServerName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYSERVERNAME, (Object)pSDCDeployServerBase.getPSDeployServerName());
        }
        if (pSDCDeployServerBase.isPSDevCenterIdDirty() && (bl || pSDCDeployServerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCDeployServerBase.getPSDevCenterId());
        }
        if (pSDCDeployServerBase.isPSDevCenterNameDirty() && (bl || pSDCDeployServerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCDeployServerBase.getPSDevCenterName());
        }
        if (pSDCDeployServerBase.isRefCountDirty() && (bl || pSDCDeployServerBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCDeployServerBase.getRefCount());
        }
        if (pSDCDeployServerBase.isResPosDirty() && (bl || pSDCDeployServerBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCDeployServerBase.getResPos());
        }
        if (pSDCDeployServerBase.isResReadyTimeDirty() && (bl || pSDCDeployServerBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCDeployServerBase.getResReadyTime());
        }
        if (pSDCDeployServerBase.isResStateDirty() && (bl || pSDCDeployServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCDeployServerBase.getResState());
        }
        if (pSDCDeployServerBase.isSSHIPAddrDirty() && (bl || pSDCDeployServerBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCDeployServerBase.getSSHIPAddr());
        }
        if (pSDCDeployServerBase.isSSHPortDirty() && (bl || pSDCDeployServerBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCDeployServerBase.getSSHPort());
        }
        if (pSDCDeployServerBase.isUpdateDateDirty() && (bl || pSDCDeployServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDeployServerBase.getUpdateDate());
        }
        if (pSDCDeployServerBase.isUpdateManDirty() && (bl || pSDCDeployServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDeployServerBase.getUpdateMan());
        }
        if (pSDCDeployServerBase.isUploadFileModeDirty() && (bl || pSDCDeployServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCDeployServerBase.getUploadFileMode());
        }
        if (pSDCDeployServerBase.isUploadPathDirty() && (bl || pSDCDeployServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCDeployServerBase.getUploadPath());
        }
        if (pSDCDeployServerBase.isUserNameDirty() && (bl || pSDCDeployServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCDeployServerBase.getUserName());
        }
        if (pSDCDeployServerBase.isValidFlagDirty() && (bl || pSDCDeployServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCDeployServerBase.getValidFlag());
        }
        if (pSDCDeployServerBase.isWorkshopPathDirty() && (bl || pSDCDeployServerBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCDeployServerBase.getWorkshopPath());
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
        return PSDCDeployServerBase.remove(this, n);
    }

    private static boolean remove(PSDCDeployServerBase pSDCDeployServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDeployServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDeployServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDeployServerBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSDCDeployServerBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDCDeployServerBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSDCDeployServerBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCDeployServerBase.resetPasswd();
                return true;
            }
            case 7: {
                pSDCDeployServerBase.resetPort();
                return true;
            }
            case 8: {
                pSDCDeployServerBase.resetPSDCDeployCenterId();
                return true;
            }
            case 9: {
                pSDCDeployServerBase.resetPSDCDeployCenterName();
                return true;
            }
            case 10: {
                pSDCDeployServerBase.resetPSDCDeployServerId();
                return true;
            }
            case 11: {
                pSDCDeployServerBase.resetPSDCDeployServerName();
                return true;
            }
            case 12: {
                pSDCDeployServerBase.resetPSDeployServerId();
                return true;
            }
            case 13: {
                pSDCDeployServerBase.resetPSDeployServerName();
                return true;
            }
            case 14: {
                pSDCDeployServerBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDCDeployServerBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSDCDeployServerBase.resetRefCount();
                return true;
            }
            case 17: {
                pSDCDeployServerBase.resetResPos();
                return true;
            }
            case 18: {
                pSDCDeployServerBase.resetResReadyTime();
                return true;
            }
            case 19: {
                pSDCDeployServerBase.resetResState();
                return true;
            }
            case 20: {
                pSDCDeployServerBase.resetSSHIPAddr();
                return true;
            }
            case 21: {
                pSDCDeployServerBase.resetSSHPort();
                return true;
            }
            case 22: {
                pSDCDeployServerBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDCDeployServerBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSDCDeployServerBase.resetUploadFileMode();
                return true;
            }
            case 25: {
                pSDCDeployServerBase.resetUploadPath();
                return true;
            }
            case 26: {
                pSDCDeployServerBase.resetUserName();
                return true;
            }
            case 27: {
                pSDCDeployServerBase.resetValidFlag();
                return true;
            }
            case 28: {
                pSDCDeployServerBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDeployCenter getPSDCDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenter();
        }
        if (this.getPSDCDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDCDeployCenterLock;
        synchronized (n) {
            if (this.psdcdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDeployCenterId(), (Object)this.psdcdeploycenter.getPSDCDeployCenterId()) != 0L) {
                this.psdcdeploycenter = null;
            }
            if (this.psdcdeploycenter == null) {
                PSDCDeployCenter pSDCDeployCenter = new PSDCDeployCenter();
                pSDCDeployCenter.setPSDCDeployCenterId(this.getPSDCDeployCenterId());
                PSDCDeployCenterService pSDCDeployCenterService = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDCDeployCenterService.autoGet((IEntity)pSDCDeployCenter);
                this.psdcdeploycenter = pSDCDeployCenter;
            }
            return this.psdcdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDeployServer getPSDeployServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployServer();
        }
        if (this.getPSDeployServerId() == null) {
            return null;
        }
        Integer n = this.objPSDeployServerLock;
        synchronized (n) {
            if (this.psdeployserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDeployServerId(), (Object)this.psdeployserver.getPSDeployServerId()) != 0L) {
                this.psdeployserver = null;
            }
            if (this.psdeployserver == null) {
                PSDeployServer pSDeployServer = new PSDeployServer();
                pSDeployServer.setPSDeployServerId(this.getPSDeployServerId());
                PSDeployServerService pSDeployServerService = (PSDeployServerService)ServiceGlobal.getService(PSDeployServerService.class, (SessionFactory)this.getSessionFactory());
                pSDeployServerService.autoGet((IEntity)pSDeployServer);
                this.psdeployserver = pSDeployServer;
            }
            return this.psdeployserver;
        }
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

    private PSDCDeployServerBase getProxyEntity() {
        return this.proxyPSDCDeployServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDeployServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDeployServerBase) {
            this.proxyPSDCDeployServerBase = (PSDCDeployServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PASSWD, 6);
        fieldIndexMap.put(FIELD_PORT, 7);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 9);
        fieldIndexMap.put(FIELD_PSDCDEPLOYSERVERID, 10);
        fieldIndexMap.put(FIELD_PSDCDEPLOYSERVERNAME, 11);
        fieldIndexMap.put(FIELD_PSDEPLOYSERVERID, 12);
        fieldIndexMap.put(FIELD_PSDEPLOYSERVERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_REFCOUNT, 16);
        fieldIndexMap.put(FIELD_RESPOS, 17);
        fieldIndexMap.put(FIELD_RESREADYTIME, 18);
        fieldIndexMap.put(FIELD_RESSTATE, 19);
        fieldIndexMap.put(FIELD_SSHIPADDR, 20);
        fieldIndexMap.put(FIELD_SSHPORT, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 24);
        fieldIndexMap.put(FIELD_UPLOADPATH, 25);
        fieldIndexMap.put(FIELD_USERNAME, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 28);
    }
}

