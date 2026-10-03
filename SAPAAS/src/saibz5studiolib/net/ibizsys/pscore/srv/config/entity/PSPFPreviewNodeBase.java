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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPreviewNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPreviewNodeBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_APPFOLDER = "APPFOLDER";
    public static final String FIELD_ASSTATE = "ASSTATE";
    public static final String FIELD_CFGFOLDER = "CFGFOLDER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LASTPREVIEWTIME = "LASTPREVIEWTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PREVIEWURL = "PREVIEWURL";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPREVIEWNODEID = "PSPFPREVIEWNODEID";
    public static final String FIELD_PSPFPREVIEWNODENAME = "PSPFPREVIEWNODENAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String FIELD_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_STARTCMD = "STARTCMD";
    public static final String FIELD_STOPCMD = "STOPCMD";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_WAITTIME = "WAITTIME";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_APPFOLDER = 2;
    private static final int INDEX_ASSTATE = 3;
    private static final int INDEX_CFGFOLDER = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_HTTPADDRESS = 7;
    private static final int INDEX_HTTPPORT = 8;
    private static final int INDEX_HTTPSPORT = 9;
    private static final int INDEX_IPADDR = 10;
    private static final int INDEX_LASTPREVIEWTIME = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PARAM = 13;
    private static final int INDEX_PARAM2 = 14;
    private static final int INDEX_PARAM3 = 15;
    private static final int INDEX_PARAM4 = 16;
    private static final int INDEX_PARAM5 = 17;
    private static final int INDEX_PARAM6 = 18;
    private static final int INDEX_PARAM7 = 19;
    private static final int INDEX_PARAM8 = 20;
    private static final int INDEX_PASSWD = 21;
    private static final int INDEX_PREVIEWURL = 22;
    private static final int INDEX_PSPFID = 23;
    private static final int INDEX_PSPFNAME = 24;
    private static final int INDEX_PSPFPREVIEWNODEID = 25;
    private static final int INDEX_PSPFPREVIEWNODENAME = 26;
    private static final int INDEX_PSSVRDOMAINID = 27;
    private static final int INDEX_PSSVRDOMAINNAME = 28;
    private static final int INDEX_PSSVRSERVERID = 29;
    private static final int INDEX_PSSVRSERVERNAME = 30;
    private static final int INDEX_PSSYSAPPID = 31;
    private static final int INDEX_PSTASKSERVERID = 32;
    private static final int INDEX_PSTASKSERVERNAME = 33;
    private static final int INDEX_SSHIPADDR = 34;
    private static final int INDEX_SSHPORT = 35;
    private static final int INDEX_STARTCMD = 36;
    private static final int INDEX_STOPCMD = 37;
    private static final int INDEX_UPDATEDATE = 38;
    private static final int INDEX_UPDATEMAN = 39;
    private static final int INDEX_UPLOADFILEMODE = 40;
    private static final int INDEX_UPLOADPATH = 41;
    private static final int INDEX_USERNAME = 42;
    private static final int INDEX_WAITTIME = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPreviewNodeBase proxyPSPFPreviewNodeBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean appfolderDirtyFlag = false;
    private boolean asstateDirtyFlag = false;
    private boolean cfgfolderDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean lastpreviewtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean previewurlDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpreviewnodeidDirtyFlag = false;
    private boolean pspfpreviewnodenameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssvrserveridDirtyFlag = false;
    private boolean pssvrservernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean startcmdDirtyFlag = false;
    private boolean stopcmdDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean waittimeDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="appfolder")
    private String appfolder;
    @Column(name="asstate")
    private Integer asstate;
    @Column(name="cfgfolder")
    private String cfgfolder;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="lastpreviewtime")
    private Timestamp lastpreviewtime;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="passwd")
    private String passwd;
    @Column(name="previewurl")
    private String previewurl;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpreviewnodeid")
    private String pspfpreviewnodeid;
    @Column(name="pspfpreviewnodename")
    private String pspfpreviewnodename;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pssvrserverid")
    private String pssvrserverid;
    @Column(name="pssvrservername")
    private String pssvrservername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
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
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="username")
    private String username;
    @Column(name="waittime")
    private Integer waittime;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSSvrServerLock = new Integer(1);
    private PSSvrServer pssvrserver = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setCfgFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgfolder = string;
        this.cfgfolderDirtyFlag = true;
    }

    public String getCfgFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgFolder();
        }
        return this.cfgfolder;
    }

    public boolean isCfgFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgFolderDirty();
        }
        return this.cfgfolderDirtyFlag;
    }

    public void resetCfgFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgFolder();
            return;
        }
        this.cfgfolderDirtyFlag = false;
        this.cfgfolder = null;
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

    public void setHttpAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpaddress = string;
        this.httpaddressDirtyFlag = true;
    }

    public String getHttpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpAddress();
        }
        return this.httpaddress;
    }

    public boolean isHttpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpAddressDirty();
        }
        return this.httpaddressDirtyFlag;
    }

    public void resetHttpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpAddress();
            return;
        }
        this.httpaddressDirtyFlag = false;
        this.httpaddress = null;
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

    public void setLastPreviewTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastPreviewTime(timestamp);
            return;
        }
        this.lastpreviewtime = timestamp;
        this.lastpreviewtimeDirtyFlag = true;
    }

    public Timestamp getLastPreviewTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastPreviewTime();
        }
        return this.lastpreviewtime;
    }

    public boolean isLastPreviewTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastPreviewTimeDirty();
        }
        return this.lastpreviewtimeDirtyFlag;
    }

    public void resetLastPreviewTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastPreviewTime();
            return;
        }
        this.lastpreviewtimeDirtyFlag = false;
        this.lastpreviewtime = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
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

    public void setPreviewUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewurl = string;
        this.previewurlDirtyFlag = true;
    }

    public String getPreviewUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewUrl();
        }
        return this.previewurl;
    }

    public boolean isPreviewUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewUrlDirty();
        }
        return this.previewurlDirtyFlag;
    }

    public void resetPreviewUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewUrl();
            return;
        }
        this.previewurlDirtyFlag = false;
        this.previewurl = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFPreviewNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPreviewNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpreviewnodeid = string;
        this.pspfpreviewnodeidDirtyFlag = true;
    }

    public String getPSPFPreviewNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewNodeId();
        }
        return this.pspfpreviewnodeid;
    }

    public boolean isPSPFPreviewNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPreviewNodeIdDirty();
        }
        return this.pspfpreviewnodeidDirtyFlag;
    }

    public void resetPSPFPreviewNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPreviewNodeId();
            return;
        }
        this.pspfpreviewnodeidDirtyFlag = false;
        this.pspfpreviewnodeid = null;
    }

    public void setPSPFPreviewNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPreviewNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpreviewnodename = string;
        this.pspfpreviewnodenameDirtyFlag = true;
    }

    public String getPSPFPreviewNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewNodeName();
        }
        return this.pspfpreviewnodename;
    }

    public boolean isPSPFPreviewNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPreviewNodeNameDirty();
        }
        return this.pspfpreviewnodenameDirtyFlag;
    }

    public void resetPSPFPreviewNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPreviewNodeName();
            return;
        }
        this.pspfpreviewnodenameDirtyFlag = false;
        this.pspfpreviewnodename = null;
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

    public void setPSSvrServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrserverid = string;
        this.pssvrserveridDirtyFlag = true;
    }

    public String getPSSvrServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrServerId();
        }
        return this.pssvrserverid;
    }

    public boolean isPSSvrServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrServerIdDirty();
        }
        return this.pssvrserveridDirtyFlag;
    }

    public void resetPSSvrServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrServerId();
            return;
        }
        this.pssvrserveridDirtyFlag = false;
        this.pssvrserverid = null;
    }

    public void setPSSvrServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrservername = string;
        this.pssvrservernameDirtyFlag = true;
    }

    public String getPSSvrServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrServerName();
        }
        return this.pssvrservername;
    }

    public boolean isPSSvrServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrServerNameDirty();
        }
        return this.pssvrservernameDirtyFlag;
    }

    public void resetPSSvrServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrServerName();
            return;
        }
        this.pssvrservernameDirtyFlag = false;
        this.pssvrservername = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
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

    public void setWaitTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWaitTime(n);
            return;
        }
        this.waittime = n;
        this.waittimeDirtyFlag = true;
    }

    public Integer getWaitTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWaitTime();
        }
        return this.waittime;
    }

    public boolean isWaitTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWaitTimeDirty();
        }
        return this.waittimeDirtyFlag;
    }

    public void resetWaitTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWaitTime();
            return;
        }
        this.waittimeDirtyFlag = false;
        this.waittime = null;
    }

    protected void onReset() {
        PSPFPreviewNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPreviewNodeBase pSPFPreviewNodeBase) {
        pSPFPreviewNodeBase.resetAdminPasswd();
        pSPFPreviewNodeBase.resetAdminUserName();
        pSPFPreviewNodeBase.resetAppFolder();
        pSPFPreviewNodeBase.resetASState();
        pSPFPreviewNodeBase.resetCfgFolder();
        pSPFPreviewNodeBase.resetCreateDate();
        pSPFPreviewNodeBase.resetCreateMan();
        pSPFPreviewNodeBase.resetHttpAddress();
        pSPFPreviewNodeBase.resetHttpPort();
        pSPFPreviewNodeBase.resetHttpsPort();
        pSPFPreviewNodeBase.resetIpAddr();
        pSPFPreviewNodeBase.resetLastPreviewTime();
        pSPFPreviewNodeBase.resetMemo();
        pSPFPreviewNodeBase.resetParam();
        pSPFPreviewNodeBase.resetParam2();
        pSPFPreviewNodeBase.resetParam3();
        pSPFPreviewNodeBase.resetParam4();
        pSPFPreviewNodeBase.resetParam5();
        pSPFPreviewNodeBase.resetParam6();
        pSPFPreviewNodeBase.resetParam7();
        pSPFPreviewNodeBase.resetParam8();
        pSPFPreviewNodeBase.resetPasswd();
        pSPFPreviewNodeBase.resetPreviewUrl();
        pSPFPreviewNodeBase.resetPSPFId();
        pSPFPreviewNodeBase.resetPSPFName();
        pSPFPreviewNodeBase.resetPSPFPreviewNodeId();
        pSPFPreviewNodeBase.resetPSPFPreviewNodeName();
        pSPFPreviewNodeBase.resetPSSvrDomainId();
        pSPFPreviewNodeBase.resetPSSvrDomainName();
        pSPFPreviewNodeBase.resetPSSvrServerId();
        pSPFPreviewNodeBase.resetPSSvrServerName();
        pSPFPreviewNodeBase.resetPSSysAppId();
        pSPFPreviewNodeBase.resetPSTaskServerId();
        pSPFPreviewNodeBase.resetPSTaskServerName();
        pSPFPreviewNodeBase.resetSSHIPAddr();
        pSPFPreviewNodeBase.resetSSHPort();
        pSPFPreviewNodeBase.resetStartCmd();
        pSPFPreviewNodeBase.resetStopCmd();
        pSPFPreviewNodeBase.resetUpdateDate();
        pSPFPreviewNodeBase.resetUpdateMan();
        pSPFPreviewNodeBase.resetUploadFileMode();
        pSPFPreviewNodeBase.resetUploadPath();
        pSPFPreviewNodeBase.resetUserName();
        pSPFPreviewNodeBase.resetWaitTime();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPasswdDirty()) {
            hashMap.put(FIELD_ADMINPASSWD, this.getAdminPasswd());
        }
        if (!bl || this.isAdminUserNameDirty()) {
            hashMap.put(FIELD_ADMINUSERNAME, this.getAdminUserName());
        }
        if (!bl || this.isAppFolderDirty()) {
            hashMap.put(FIELD_APPFOLDER, this.getAppFolder());
        }
        if (!bl || this.isASStateDirty()) {
            hashMap.put(FIELD_ASSTATE, this.getASState());
        }
        if (!bl || this.isCfgFolderDirty()) {
            hashMap.put(FIELD_CFGFOLDER, this.getCfgFolder());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHttpAddressDirty()) {
            hashMap.put(FIELD_HTTPADDRESS, this.getHttpAddress());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isLastPreviewTimeDirty()) {
            hashMap.put(FIELD_LASTPREVIEWTIME, this.getLastPreviewTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPreviewUrlDirty()) {
            hashMap.put(FIELD_PREVIEWURL, this.getPreviewUrl());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPreviewNodeIdDirty()) {
            hashMap.put(FIELD_PSPFPREVIEWNODEID, this.getPSPFPreviewNodeId());
        }
        if (!bl || this.isPSPFPreviewNodeNameDirty()) {
            hashMap.put(FIELD_PSPFPREVIEWNODENAME, this.getPSPFPreviewNodeName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSSvrServerIdDirty()) {
            hashMap.put(FIELD_PSSVRSERVERID, this.getPSSvrServerId());
        }
        if (!bl || this.isPSSvrServerNameDirty()) {
            hashMap.put(FIELD_PSSVRSERVERNAME, this.getPSSvrServerName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUploadPathDirty()) {
            hashMap.put(FIELD_UPLOADPATH, this.getUploadPath());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isWaitTimeDirty()) {
            hashMap.put(FIELD_WAITTIME, this.getWaitTime());
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
        return PSPFPreviewNodeBase.get(this, n);
    }

    private static Object get(PSPFPreviewNodeBase pSPFPreviewNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewNodeBase.getAdminPasswd();
            }
            case 1: {
                return pSPFPreviewNodeBase.getAdminUserName();
            }
            case 2: {
                return pSPFPreviewNodeBase.getAppFolder();
            }
            case 3: {
                return pSPFPreviewNodeBase.getASState();
            }
            case 4: {
                return pSPFPreviewNodeBase.getCfgFolder();
            }
            case 5: {
                return pSPFPreviewNodeBase.getCreateDate();
            }
            case 6: {
                return pSPFPreviewNodeBase.getCreateMan();
            }
            case 7: {
                return pSPFPreviewNodeBase.getHttpAddress();
            }
            case 8: {
                return pSPFPreviewNodeBase.getHttpPort();
            }
            case 9: {
                return pSPFPreviewNodeBase.getHttpsPort();
            }
            case 10: {
                return pSPFPreviewNodeBase.getIpAddr();
            }
            case 11: {
                return pSPFPreviewNodeBase.getLastPreviewTime();
            }
            case 12: {
                return pSPFPreviewNodeBase.getMemo();
            }
            case 13: {
                return pSPFPreviewNodeBase.getParam();
            }
            case 14: {
                return pSPFPreviewNodeBase.getParam2();
            }
            case 15: {
                return pSPFPreviewNodeBase.getParam3();
            }
            case 16: {
                return pSPFPreviewNodeBase.getParam4();
            }
            case 17: {
                return pSPFPreviewNodeBase.getParam5();
            }
            case 18: {
                return pSPFPreviewNodeBase.getParam6();
            }
            case 19: {
                return pSPFPreviewNodeBase.getParam7();
            }
            case 20: {
                return pSPFPreviewNodeBase.getParam8();
            }
            case 21: {
                return pSPFPreviewNodeBase.getPasswd();
            }
            case 22: {
                return pSPFPreviewNodeBase.getPreviewUrl();
            }
            case 23: {
                return pSPFPreviewNodeBase.getPSPFId();
            }
            case 24: {
                return pSPFPreviewNodeBase.getPSPFName();
            }
            case 25: {
                return pSPFPreviewNodeBase.getPSPFPreviewNodeId();
            }
            case 26: {
                return pSPFPreviewNodeBase.getPSPFPreviewNodeName();
            }
            case 27: {
                return pSPFPreviewNodeBase.getPSSvrDomainId();
            }
            case 28: {
                return pSPFPreviewNodeBase.getPSSvrDomainName();
            }
            case 29: {
                return pSPFPreviewNodeBase.getPSSvrServerId();
            }
            case 30: {
                return pSPFPreviewNodeBase.getPSSvrServerName();
            }
            case 31: {
                return pSPFPreviewNodeBase.getPSSysAppId();
            }
            case 32: {
                return pSPFPreviewNodeBase.getPSTaskServerId();
            }
            case 33: {
                return pSPFPreviewNodeBase.getPSTaskServerName();
            }
            case 34: {
                return pSPFPreviewNodeBase.getSSHIPAddr();
            }
            case 35: {
                return pSPFPreviewNodeBase.getSSHPort();
            }
            case 36: {
                return pSPFPreviewNodeBase.getStartCmd();
            }
            case 37: {
                return pSPFPreviewNodeBase.getStopCmd();
            }
            case 38: {
                return pSPFPreviewNodeBase.getUpdateDate();
            }
            case 39: {
                return pSPFPreviewNodeBase.getUpdateMan();
            }
            case 40: {
                return pSPFPreviewNodeBase.getUploadFileMode();
            }
            case 41: {
                return pSPFPreviewNodeBase.getUploadPath();
            }
            case 42: {
                return pSPFPreviewNodeBase.getUserName();
            }
            case 43: {
                return pSPFPreviewNodeBase.getWaitTime();
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
        PSPFPreviewNodeBase.set(this, n, object);
    }

    private static void set(PSPFPreviewNodeBase pSPFPreviewNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPreviewNodeBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFPreviewNodeBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPreviewNodeBase.setAppFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPreviewNodeBase.setASState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSPFPreviewNodeBase.setCfgFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPreviewNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSPFPreviewNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPreviewNodeBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPreviewNodeBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSPFPreviewNodeBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSPFPreviewNodeBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPreviewNodeBase.setLastPreviewTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSPFPreviewNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPreviewNodeBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPreviewNodeBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPreviewNodeBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPreviewNodeBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPreviewNodeBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSPFPreviewNodeBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSPFPreviewNodeBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSPFPreviewNodeBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSPFPreviewNodeBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFPreviewNodeBase.setPreviewUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPFPreviewNodeBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPFPreviewNodeBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPFPreviewNodeBase.setPSPFPreviewNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPFPreviewNodeBase.setPSPFPreviewNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSPFPreviewNodeBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPFPreviewNodeBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSPFPreviewNodeBase.setPSSvrServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSPFPreviewNodeBase.setPSSvrServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSPFPreviewNodeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSPFPreviewNodeBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSPFPreviewNodeBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSPFPreviewNodeBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSPFPreviewNodeBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSPFPreviewNodeBase.setStartCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSPFPreviewNodeBase.setStopCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSPFPreviewNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 39: {
                pSPFPreviewNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSPFPreviewNodeBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSPFPreviewNodeBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSPFPreviewNodeBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSPFPreviewNodeBase.setWaitTime(DataObject.getIntegerValue((Object)object));
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
        return PSPFPreviewNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPreviewNodeBase pSPFPreviewNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewNodeBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSPFPreviewNodeBase.getAdminUserName() == null;
            }
            case 2: {
                return pSPFPreviewNodeBase.getAppFolder() == null;
            }
            case 3: {
                return pSPFPreviewNodeBase.getASState() == null;
            }
            case 4: {
                return pSPFPreviewNodeBase.getCfgFolder() == null;
            }
            case 5: {
                return pSPFPreviewNodeBase.getCreateDate() == null;
            }
            case 6: {
                return pSPFPreviewNodeBase.getCreateMan() == null;
            }
            case 7: {
                return pSPFPreviewNodeBase.getHttpAddress() == null;
            }
            case 8: {
                return pSPFPreviewNodeBase.getHttpPort() == null;
            }
            case 9: {
                return pSPFPreviewNodeBase.getHttpsPort() == null;
            }
            case 10: {
                return pSPFPreviewNodeBase.getIpAddr() == null;
            }
            case 11: {
                return pSPFPreviewNodeBase.getLastPreviewTime() == null;
            }
            case 12: {
                return pSPFPreviewNodeBase.getMemo() == null;
            }
            case 13: {
                return pSPFPreviewNodeBase.getParam() == null;
            }
            case 14: {
                return pSPFPreviewNodeBase.getParam2() == null;
            }
            case 15: {
                return pSPFPreviewNodeBase.getParam3() == null;
            }
            case 16: {
                return pSPFPreviewNodeBase.getParam4() == null;
            }
            case 17: {
                return pSPFPreviewNodeBase.getParam5() == null;
            }
            case 18: {
                return pSPFPreviewNodeBase.getParam6() == null;
            }
            case 19: {
                return pSPFPreviewNodeBase.getParam7() == null;
            }
            case 20: {
                return pSPFPreviewNodeBase.getParam8() == null;
            }
            case 21: {
                return pSPFPreviewNodeBase.getPasswd() == null;
            }
            case 22: {
                return pSPFPreviewNodeBase.getPreviewUrl() == null;
            }
            case 23: {
                return pSPFPreviewNodeBase.getPSPFId() == null;
            }
            case 24: {
                return pSPFPreviewNodeBase.getPSPFName() == null;
            }
            case 25: {
                return pSPFPreviewNodeBase.getPSPFPreviewNodeId() == null;
            }
            case 26: {
                return pSPFPreviewNodeBase.getPSPFPreviewNodeName() == null;
            }
            case 27: {
                return pSPFPreviewNodeBase.getPSSvrDomainId() == null;
            }
            case 28: {
                return pSPFPreviewNodeBase.getPSSvrDomainName() == null;
            }
            case 29: {
                return pSPFPreviewNodeBase.getPSSvrServerId() == null;
            }
            case 30: {
                return pSPFPreviewNodeBase.getPSSvrServerName() == null;
            }
            case 31: {
                return pSPFPreviewNodeBase.getPSSysAppId() == null;
            }
            case 32: {
                return pSPFPreviewNodeBase.getPSTaskServerId() == null;
            }
            case 33: {
                return pSPFPreviewNodeBase.getPSTaskServerName() == null;
            }
            case 34: {
                return pSPFPreviewNodeBase.getSSHIPAddr() == null;
            }
            case 35: {
                return pSPFPreviewNodeBase.getSSHPort() == null;
            }
            case 36: {
                return pSPFPreviewNodeBase.getStartCmd() == null;
            }
            case 37: {
                return pSPFPreviewNodeBase.getStopCmd() == null;
            }
            case 38: {
                return pSPFPreviewNodeBase.getUpdateDate() == null;
            }
            case 39: {
                return pSPFPreviewNodeBase.getUpdateMan() == null;
            }
            case 40: {
                return pSPFPreviewNodeBase.getUploadFileMode() == null;
            }
            case 41: {
                return pSPFPreviewNodeBase.getUploadPath() == null;
            }
            case 42: {
                return pSPFPreviewNodeBase.getUserName() == null;
            }
            case 43: {
                return pSPFPreviewNodeBase.getWaitTime() == null;
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
        return PSPFPreviewNodeBase.contains(this, n);
    }

    private static boolean contains(PSPFPreviewNodeBase pSPFPreviewNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewNodeBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSPFPreviewNodeBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSPFPreviewNodeBase.isAppFolderDirty();
            }
            case 3: {
                return pSPFPreviewNodeBase.isASStateDirty();
            }
            case 4: {
                return pSPFPreviewNodeBase.isCfgFolderDirty();
            }
            case 5: {
                return pSPFPreviewNodeBase.isCreateDateDirty();
            }
            case 6: {
                return pSPFPreviewNodeBase.isCreateManDirty();
            }
            case 7: {
                return pSPFPreviewNodeBase.isHttpAddressDirty();
            }
            case 8: {
                return pSPFPreviewNodeBase.isHttpPortDirty();
            }
            case 9: {
                return pSPFPreviewNodeBase.isHttpsPortDirty();
            }
            case 10: {
                return pSPFPreviewNodeBase.isIpAddrDirty();
            }
            case 11: {
                return pSPFPreviewNodeBase.isLastPreviewTimeDirty();
            }
            case 12: {
                return pSPFPreviewNodeBase.isMemoDirty();
            }
            case 13: {
                return pSPFPreviewNodeBase.isParamDirty();
            }
            case 14: {
                return pSPFPreviewNodeBase.isParam2Dirty();
            }
            case 15: {
                return pSPFPreviewNodeBase.isParam3Dirty();
            }
            case 16: {
                return pSPFPreviewNodeBase.isParam4Dirty();
            }
            case 17: {
                return pSPFPreviewNodeBase.isParam5Dirty();
            }
            case 18: {
                return pSPFPreviewNodeBase.isParam6Dirty();
            }
            case 19: {
                return pSPFPreviewNodeBase.isParam7Dirty();
            }
            case 20: {
                return pSPFPreviewNodeBase.isParam8Dirty();
            }
            case 21: {
                return pSPFPreviewNodeBase.isPasswdDirty();
            }
            case 22: {
                return pSPFPreviewNodeBase.isPreviewUrlDirty();
            }
            case 23: {
                return pSPFPreviewNodeBase.isPSPFIdDirty();
            }
            case 24: {
                return pSPFPreviewNodeBase.isPSPFNameDirty();
            }
            case 25: {
                return pSPFPreviewNodeBase.isPSPFPreviewNodeIdDirty();
            }
            case 26: {
                return pSPFPreviewNodeBase.isPSPFPreviewNodeNameDirty();
            }
            case 27: {
                return pSPFPreviewNodeBase.isPSSvrDomainIdDirty();
            }
            case 28: {
                return pSPFPreviewNodeBase.isPSSvrDomainNameDirty();
            }
            case 29: {
                return pSPFPreviewNodeBase.isPSSvrServerIdDirty();
            }
            case 30: {
                return pSPFPreviewNodeBase.isPSSvrServerNameDirty();
            }
            case 31: {
                return pSPFPreviewNodeBase.isPSSysAppIdDirty();
            }
            case 32: {
                return pSPFPreviewNodeBase.isPSTaskServerIdDirty();
            }
            case 33: {
                return pSPFPreviewNodeBase.isPSTaskServerNameDirty();
            }
            case 34: {
                return pSPFPreviewNodeBase.isSSHIPAddrDirty();
            }
            case 35: {
                return pSPFPreviewNodeBase.isSSHPortDirty();
            }
            case 36: {
                return pSPFPreviewNodeBase.isStartCmdDirty();
            }
            case 37: {
                return pSPFPreviewNodeBase.isStopCmdDirty();
            }
            case 38: {
                return pSPFPreviewNodeBase.isUpdateDateDirty();
            }
            case 39: {
                return pSPFPreviewNodeBase.isUpdateManDirty();
            }
            case 40: {
                return pSPFPreviewNodeBase.isUploadFileModeDirty();
            }
            case 41: {
                return pSPFPreviewNodeBase.isUploadPathDirty();
            }
            case 42: {
                return pSPFPreviewNodeBase.isUserNameDirty();
            }
            case 43: {
                return pSPFPreviewNodeBase.isWaitTimeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPreviewNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPreviewNodeBase pSPFPreviewNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPreviewNodeBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getAppFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfolder", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getAppFolder()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getASState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asstate", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getASState()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getCfgFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgfolder", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getCfgFolder()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getLastPreviewTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastpreviewtime", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getLastPreviewTime()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam2()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam3()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam4()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam5()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam6()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam7()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getParam8()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPasswd()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPreviewUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurl", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPreviewUrl()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpreviewnodeid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSPFPreviewNodeId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpreviewnodename", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSPFPreviewNodeName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrserverid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSSvrServerId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrservername", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSSvrServerName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getStartCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startcmd", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getStartCmd()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getStopCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopcmd", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getStopCmd()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getUserName()), (boolean)false);
        }
        if (bl || pSPFPreviewNodeBase.getWaitTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"waittime", (Object)PSPFPreviewNodeBase.getJSONValue((Object)pSPFPreviewNodeBase.getWaitTime()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPreviewNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPreviewNodeBase pSPFPreviewNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPreviewNodeBase.getAdminPasswd() != null) {
            object = pSPFPreviewNodeBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPreviewNodeBase.getAdminUserName() != null) {
            object = pSPFPreviewNodeBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPreviewNodeBase.getAppFolder() != null) {
            object = pSPFPreviewNodeBase.getAppFolder();
            xmlNode.setAttribute(FIELD_APPFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getASState() != null) {
            object = pSPFPreviewNodeBase.getASState();
            xmlNode.setAttribute(FIELD_ASSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getCfgFolder() != null) {
            object = pSPFPreviewNodeBase.getCfgFolder();
            xmlNode.setAttribute(FIELD_CFGFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getCreateDate() != null) {
            object = pSPFPreviewNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getCreateMan() != null) {
            object = pSPFPreviewNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getHttpAddress() != null) {
            object = pSPFPreviewNodeBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getHttpPort() != null) {
            object = pSPFPreviewNodeBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getHttpsPort() != null) {
            object = pSPFPreviewNodeBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getIpAddr() != null) {
            object = pSPFPreviewNodeBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getLastPreviewTime() != null) {
            object = pSPFPreviewNodeBase.getLastPreviewTime();
            xmlNode.setAttribute(FIELD_LASTPREVIEWTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getMemo() != null) {
            object = pSPFPreviewNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getParam() != null) {
            object = pSPFPreviewNodeBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getParam2() != null) {
            object = pSPFPreviewNodeBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getParam3() != null) {
            object = pSPFPreviewNodeBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getParam4() != null) {
            object = pSPFPreviewNodeBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getParam5() != null) {
            object = pSPFPreviewNodeBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getParam6() != null) {
            object = pSPFPreviewNodeBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getParam7() != null) {
            object = pSPFPreviewNodeBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getParam8() != null) {
            object = pSPFPreviewNodeBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getPasswd() != null) {
            object = pSPFPreviewNodeBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPreviewUrl() != null) {
            object = pSPFPreviewNodeBase.getPreviewUrl();
            xmlNode.setAttribute(FIELD_PREVIEWURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFId() != null) {
            object = pSPFPreviewNodeBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFName() != null) {
            object = pSPFPreviewNodeBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeId() != null) {
            object = pSPFPreviewNodeBase.getPSPFPreviewNodeId();
            xmlNode.setAttribute(FIELD_PSPFPREVIEWNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeName() != null) {
            object = pSPFPreviewNodeBase.getPSPFPreviewNodeName();
            xmlNode.setAttribute(FIELD_PSPFPREVIEWNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrDomainId() != null) {
            object = pSPFPreviewNodeBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrDomainName() != null) {
            object = pSPFPreviewNodeBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrServerId() != null) {
            object = pSPFPreviewNodeBase.getPSSvrServerId();
            xmlNode.setAttribute(FIELD_PSSVRSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSSvrServerName() != null) {
            object = pSPFPreviewNodeBase.getPSSvrServerName();
            xmlNode.setAttribute(FIELD_PSSVRSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSSysAppId() != null) {
            object = pSPFPreviewNodeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSTaskServerId() != null) {
            object = pSPFPreviewNodeBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getPSTaskServerName() != null) {
            object = pSPFPreviewNodeBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getSSHIPAddr() != null) {
            object = pSPFPreviewNodeBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getSSHPort() != null) {
            object = pSPFPreviewNodeBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getStartCmd() != null) {
            object = pSPFPreviewNodeBase.getStartCmd();
            xmlNode.setAttribute(FIELD_STARTCMD, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getStopCmd() != null) {
            object = pSPFPreviewNodeBase.getStopCmd();
            xmlNode.setAttribute(FIELD_STOPCMD, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getUpdateDate() != null) {
            object = pSPFPreviewNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewNodeBase.getUpdateMan() != null) {
            object = pSPFPreviewNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getUploadFileMode() != null) {
            object = pSPFPreviewNodeBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getUploadPath() != null) {
            object = pSPFPreviewNodeBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getUserName() != null) {
            object = pSPFPreviewNodeBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewNodeBase.getWaitTime() != null) {
            object = pSPFPreviewNodeBase.getWaitTime();
            xmlNode.setAttribute(FIELD_WAITTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPreviewNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPreviewNodeBase pSPFPreviewNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPreviewNodeBase.isAdminPasswdDirty() && (bl || pSPFPreviewNodeBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSPFPreviewNodeBase.getAdminPasswd());
        }
        if (pSPFPreviewNodeBase.isAdminUserNameDirty() && (bl || pSPFPreviewNodeBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSPFPreviewNodeBase.getAdminUserName());
        }
        if (pSPFPreviewNodeBase.isAppFolderDirty() && (bl || pSPFPreviewNodeBase.getAppFolder() != null)) {
            iDataObject.set(FIELD_APPFOLDER, (Object)pSPFPreviewNodeBase.getAppFolder());
        }
        if (pSPFPreviewNodeBase.isASStateDirty() && (bl || pSPFPreviewNodeBase.getASState() != null)) {
            iDataObject.set(FIELD_ASSTATE, (Object)pSPFPreviewNodeBase.getASState());
        }
        if (pSPFPreviewNodeBase.isCfgFolderDirty() && (bl || pSPFPreviewNodeBase.getCfgFolder() != null)) {
            iDataObject.set(FIELD_CFGFOLDER, (Object)pSPFPreviewNodeBase.getCfgFolder());
        }
        if (pSPFPreviewNodeBase.isCreateDateDirty() && (bl || pSPFPreviewNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPreviewNodeBase.getCreateDate());
        }
        if (pSPFPreviewNodeBase.isCreateManDirty() && (bl || pSPFPreviewNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPreviewNodeBase.getCreateMan());
        }
        if (pSPFPreviewNodeBase.isHttpAddressDirty() && (bl || pSPFPreviewNodeBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSPFPreviewNodeBase.getHttpAddress());
        }
        if (pSPFPreviewNodeBase.isHttpPortDirty() && (bl || pSPFPreviewNodeBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSPFPreviewNodeBase.getHttpPort());
        }
        if (pSPFPreviewNodeBase.isHttpsPortDirty() && (bl || pSPFPreviewNodeBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSPFPreviewNodeBase.getHttpsPort());
        }
        if (pSPFPreviewNodeBase.isIpAddrDirty() && (bl || pSPFPreviewNodeBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSPFPreviewNodeBase.getIpAddr());
        }
        if (pSPFPreviewNodeBase.isLastPreviewTimeDirty() && (bl || pSPFPreviewNodeBase.getLastPreviewTime() != null)) {
            iDataObject.set(FIELD_LASTPREVIEWTIME, (Object)pSPFPreviewNodeBase.getLastPreviewTime());
        }
        if (pSPFPreviewNodeBase.isMemoDirty() && (bl || pSPFPreviewNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPreviewNodeBase.getMemo());
        }
        if (pSPFPreviewNodeBase.isParamDirty() && (bl || pSPFPreviewNodeBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSPFPreviewNodeBase.getParam());
        }
        if (pSPFPreviewNodeBase.isParam2Dirty() && (bl || pSPFPreviewNodeBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSPFPreviewNodeBase.getParam2());
        }
        if (pSPFPreviewNodeBase.isParam3Dirty() && (bl || pSPFPreviewNodeBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSPFPreviewNodeBase.getParam3());
        }
        if (pSPFPreviewNodeBase.isParam4Dirty() && (bl || pSPFPreviewNodeBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSPFPreviewNodeBase.getParam4());
        }
        if (pSPFPreviewNodeBase.isParam5Dirty() && (bl || pSPFPreviewNodeBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSPFPreviewNodeBase.getParam5());
        }
        if (pSPFPreviewNodeBase.isParam6Dirty() && (bl || pSPFPreviewNodeBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSPFPreviewNodeBase.getParam6());
        }
        if (pSPFPreviewNodeBase.isParam7Dirty() && (bl || pSPFPreviewNodeBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSPFPreviewNodeBase.getParam7());
        }
        if (pSPFPreviewNodeBase.isParam8Dirty() && (bl || pSPFPreviewNodeBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSPFPreviewNodeBase.getParam8());
        }
        if (pSPFPreviewNodeBase.isPasswdDirty() && (bl || pSPFPreviewNodeBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSPFPreviewNodeBase.getPasswd());
        }
        if (pSPFPreviewNodeBase.isPreviewUrlDirty() && (bl || pSPFPreviewNodeBase.getPreviewUrl() != null)) {
            iDataObject.set(FIELD_PREVIEWURL, (Object)pSPFPreviewNodeBase.getPreviewUrl());
        }
        if (pSPFPreviewNodeBase.isPSPFIdDirty() && (bl || pSPFPreviewNodeBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPreviewNodeBase.getPSPFId());
        }
        if (pSPFPreviewNodeBase.isPSPFNameDirty() && (bl || pSPFPreviewNodeBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPreviewNodeBase.getPSPFName());
        }
        if (pSPFPreviewNodeBase.isPSPFPreviewNodeIdDirty() && (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeId() != null)) {
            iDataObject.set(FIELD_PSPFPREVIEWNODEID, (Object)pSPFPreviewNodeBase.getPSPFPreviewNodeId());
        }
        if (pSPFPreviewNodeBase.isPSPFPreviewNodeNameDirty() && (bl || pSPFPreviewNodeBase.getPSPFPreviewNodeName() != null)) {
            iDataObject.set(FIELD_PSPFPREVIEWNODENAME, (Object)pSPFPreviewNodeBase.getPSPFPreviewNodeName());
        }
        if (pSPFPreviewNodeBase.isPSSvrDomainIdDirty() && (bl || pSPFPreviewNodeBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSPFPreviewNodeBase.getPSSvrDomainId());
        }
        if (pSPFPreviewNodeBase.isPSSvrDomainNameDirty() && (bl || pSPFPreviewNodeBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSPFPreviewNodeBase.getPSSvrDomainName());
        }
        if (pSPFPreviewNodeBase.isPSSvrServerIdDirty() && (bl || pSPFPreviewNodeBase.getPSSvrServerId() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERID, (Object)pSPFPreviewNodeBase.getPSSvrServerId());
        }
        if (pSPFPreviewNodeBase.isPSSvrServerNameDirty() && (bl || pSPFPreviewNodeBase.getPSSvrServerName() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERNAME, (Object)pSPFPreviewNodeBase.getPSSvrServerName());
        }
        if (pSPFPreviewNodeBase.isPSSysAppIdDirty() && (bl || pSPFPreviewNodeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSPFPreviewNodeBase.getPSSysAppId());
        }
        if (pSPFPreviewNodeBase.isPSTaskServerIdDirty() && (bl || pSPFPreviewNodeBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSPFPreviewNodeBase.getPSTaskServerId());
        }
        if (pSPFPreviewNodeBase.isPSTaskServerNameDirty() && (bl || pSPFPreviewNodeBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSPFPreviewNodeBase.getPSTaskServerName());
        }
        if (pSPFPreviewNodeBase.isSSHIPAddrDirty() && (bl || pSPFPreviewNodeBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSPFPreviewNodeBase.getSSHIPAddr());
        }
        if (pSPFPreviewNodeBase.isSSHPortDirty() && (bl || pSPFPreviewNodeBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSPFPreviewNodeBase.getSSHPort());
        }
        if (pSPFPreviewNodeBase.isStartCmdDirty() && (bl || pSPFPreviewNodeBase.getStartCmd() != null)) {
            iDataObject.set(FIELD_STARTCMD, (Object)pSPFPreviewNodeBase.getStartCmd());
        }
        if (pSPFPreviewNodeBase.isStopCmdDirty() && (bl || pSPFPreviewNodeBase.getStopCmd() != null)) {
            iDataObject.set(FIELD_STOPCMD, (Object)pSPFPreviewNodeBase.getStopCmd());
        }
        if (pSPFPreviewNodeBase.isUpdateDateDirty() && (bl || pSPFPreviewNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPreviewNodeBase.getUpdateDate());
        }
        if (pSPFPreviewNodeBase.isUpdateManDirty() && (bl || pSPFPreviewNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPreviewNodeBase.getUpdateMan());
        }
        if (pSPFPreviewNodeBase.isUploadFileModeDirty() && (bl || pSPFPreviewNodeBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSPFPreviewNodeBase.getUploadFileMode());
        }
        if (pSPFPreviewNodeBase.isUploadPathDirty() && (bl || pSPFPreviewNodeBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSPFPreviewNodeBase.getUploadPath());
        }
        if (pSPFPreviewNodeBase.isUserNameDirty() && (bl || pSPFPreviewNodeBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSPFPreviewNodeBase.getUserName());
        }
        if (pSPFPreviewNodeBase.isWaitTimeDirty() && (bl || pSPFPreviewNodeBase.getWaitTime() != null)) {
            iDataObject.set(FIELD_WAITTIME, (Object)pSPFPreviewNodeBase.getWaitTime());
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
        return PSPFPreviewNodeBase.remove(this, n);
    }

    private static boolean remove(PSPFPreviewNodeBase pSPFPreviewNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPreviewNodeBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSPFPreviewNodeBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSPFPreviewNodeBase.resetAppFolder();
                return true;
            }
            case 3: {
                pSPFPreviewNodeBase.resetASState();
                return true;
            }
            case 4: {
                pSPFPreviewNodeBase.resetCfgFolder();
                return true;
            }
            case 5: {
                pSPFPreviewNodeBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSPFPreviewNodeBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSPFPreviewNodeBase.resetHttpAddress();
                return true;
            }
            case 8: {
                pSPFPreviewNodeBase.resetHttpPort();
                return true;
            }
            case 9: {
                pSPFPreviewNodeBase.resetHttpsPort();
                return true;
            }
            case 10: {
                pSPFPreviewNodeBase.resetIpAddr();
                return true;
            }
            case 11: {
                pSPFPreviewNodeBase.resetLastPreviewTime();
                return true;
            }
            case 12: {
                pSPFPreviewNodeBase.resetMemo();
                return true;
            }
            case 13: {
                pSPFPreviewNodeBase.resetParam();
                return true;
            }
            case 14: {
                pSPFPreviewNodeBase.resetParam2();
                return true;
            }
            case 15: {
                pSPFPreviewNodeBase.resetParam3();
                return true;
            }
            case 16: {
                pSPFPreviewNodeBase.resetParam4();
                return true;
            }
            case 17: {
                pSPFPreviewNodeBase.resetParam5();
                return true;
            }
            case 18: {
                pSPFPreviewNodeBase.resetParam6();
                return true;
            }
            case 19: {
                pSPFPreviewNodeBase.resetParam7();
                return true;
            }
            case 20: {
                pSPFPreviewNodeBase.resetParam8();
                return true;
            }
            case 21: {
                pSPFPreviewNodeBase.resetPasswd();
                return true;
            }
            case 22: {
                pSPFPreviewNodeBase.resetPreviewUrl();
                return true;
            }
            case 23: {
                pSPFPreviewNodeBase.resetPSPFId();
                return true;
            }
            case 24: {
                pSPFPreviewNodeBase.resetPSPFName();
                return true;
            }
            case 25: {
                pSPFPreviewNodeBase.resetPSPFPreviewNodeId();
                return true;
            }
            case 26: {
                pSPFPreviewNodeBase.resetPSPFPreviewNodeName();
                return true;
            }
            case 27: {
                pSPFPreviewNodeBase.resetPSSvrDomainId();
                return true;
            }
            case 28: {
                pSPFPreviewNodeBase.resetPSSvrDomainName();
                return true;
            }
            case 29: {
                pSPFPreviewNodeBase.resetPSSvrServerId();
                return true;
            }
            case 30: {
                pSPFPreviewNodeBase.resetPSSvrServerName();
                return true;
            }
            case 31: {
                pSPFPreviewNodeBase.resetPSSysAppId();
                return true;
            }
            case 32: {
                pSPFPreviewNodeBase.resetPSTaskServerId();
                return true;
            }
            case 33: {
                pSPFPreviewNodeBase.resetPSTaskServerName();
                return true;
            }
            case 34: {
                pSPFPreviewNodeBase.resetSSHIPAddr();
                return true;
            }
            case 35: {
                pSPFPreviewNodeBase.resetSSHPort();
                return true;
            }
            case 36: {
                pSPFPreviewNodeBase.resetStartCmd();
                return true;
            }
            case 37: {
                pSPFPreviewNodeBase.resetStopCmd();
                return true;
            }
            case 38: {
                pSPFPreviewNodeBase.resetUpdateDate();
                return true;
            }
            case 39: {
                pSPFPreviewNodeBase.resetUpdateMan();
                return true;
            }
            case 40: {
                pSPFPreviewNodeBase.resetUploadFileMode();
                return true;
            }
            case 41: {
                pSPFPreviewNodeBase.resetUploadPath();
                return true;
            }
            case 42: {
                pSPFPreviewNodeBase.resetUserName();
                return true;
            }
            case 43: {
                pSPFPreviewNodeBase.resetWaitTime();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
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
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrServer getPSSvrServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrServer();
        }
        if (this.getPSSvrServerId() == null) {
            return null;
        }
        Integer n = this.objPSSvrServerLock;
        synchronized (n) {
            if (this.pssvrserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrServerId(), (Object)this.pssvrserver.getPSSvrServerId()) != 0L) {
                this.pssvrserver = null;
            }
            if (this.pssvrserver == null) {
                PSSvrServer pSSvrServer = new PSSvrServer();
                pSSvrServer.setPSSvrServerId(this.getPSSvrServerId());
                PSSvrServerService pSSvrServerService = (PSSvrServerService)ServiceGlobal.getService(PSSvrServerService.class, (SessionFactory)this.getSessionFactory());
                pSSvrServerService.autoGet(pSSvrServer);
                this.pssvrserver = pSSvrServer;
            }
            return this.pssvrserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSPFPreviewNodeBase getProxyEntity() {
        return this.proxyPSPFPreviewNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPreviewNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPreviewNodeBase) {
            this.proxyPSPFPreviewNodeBase = (PSPFPreviewNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_APPFOLDER, 2);
        fieldIndexMap.put(FIELD_ASSTATE, 3);
        fieldIndexMap.put(FIELD_CFGFOLDER, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 7);
        fieldIndexMap.put(FIELD_HTTPPORT, 8);
        fieldIndexMap.put(FIELD_HTTPSPORT, 9);
        fieldIndexMap.put(FIELD_IPADDR, 10);
        fieldIndexMap.put(FIELD_LASTPREVIEWTIME, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PARAM, 13);
        fieldIndexMap.put(FIELD_PARAM2, 14);
        fieldIndexMap.put(FIELD_PARAM3, 15);
        fieldIndexMap.put(FIELD_PARAM4, 16);
        fieldIndexMap.put(FIELD_PARAM5, 17);
        fieldIndexMap.put(FIELD_PARAM6, 18);
        fieldIndexMap.put(FIELD_PARAM7, 19);
        fieldIndexMap.put(FIELD_PARAM8, 20);
        fieldIndexMap.put(FIELD_PASSWD, 21);
        fieldIndexMap.put(FIELD_PREVIEWURL, 22);
        fieldIndexMap.put(FIELD_PSPFID, 23);
        fieldIndexMap.put(FIELD_PSPFNAME, 24);
        fieldIndexMap.put(FIELD_PSPFPREVIEWNODEID, 25);
        fieldIndexMap.put(FIELD_PSPFPREVIEWNODENAME, 26);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 27);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 28);
        fieldIndexMap.put(FIELD_PSSVRSERVERID, 29);
        fieldIndexMap.put(FIELD_PSSVRSERVERNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 31);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 32);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 33);
        fieldIndexMap.put(FIELD_SSHIPADDR, 34);
        fieldIndexMap.put(FIELD_SSHPORT, 35);
        fieldIndexMap.put(FIELD_STARTCMD, 36);
        fieldIndexMap.put(FIELD_STOPCMD, 37);
        fieldIndexMap.put(FIELD_UPDATEDATE, 38);
        fieldIndexMap.put(FIELD_UPDATEMAN, 39);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 40);
        fieldIndexMap.put(FIELD_UPLOADPATH, 41);
        fieldIndexMap.put(FIELD_USERNAME, 42);
        fieldIndexMap.put(FIELD_WAITTIME, 43);
    }
}

