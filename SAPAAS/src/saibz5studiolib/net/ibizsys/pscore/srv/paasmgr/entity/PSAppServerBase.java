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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSROSServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppServerBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_APPFOLDER = "APPFOLDER";
    public static final String FIELD_ASSTATE = "ASSTATE";
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_BEGINPORT = "BEGINPORT";
    public static final String FIELD_CFGFOLDER = "CFGFOLDER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDPORT = "ENDPORT";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LOCALRES = "LOCALRES";
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
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSROSSERVERID = "PSROSSERVERID";
    public static final String FIELD_PSROSSERVERNAME = "PSROSSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String FIELD_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_STARTCMD = "STARTCMD";
    public static final String FIELD_STOPCMD = "STOPCMD";
    public static final String FIELD_TIMESHAREMODE = "TIMESHAREMODE";
    public static final String FIELD_TIMESHARERESSPEC = "TIMESHARERESSPEC";
    public static final String FIELD_TIMESHARERESTYPE = "TIMESHARERESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_APPFOLDER = 2;
    private static final int INDEX_ASSTATE = 3;
    private static final int INDEX_ASTYPE = 4;
    private static final int INDEX_BEGINPORT = 5;
    private static final int INDEX_CFGFOLDER = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_ENDPORT = 9;
    private static final int INDEX_HTTPADDRESS = 10;
    private static final int INDEX_HTTPPORT = 11;
    private static final int INDEX_HTTPSPORT = 12;
    private static final int INDEX_IPADDR = 13;
    private static final int INDEX_LOCALRES = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PARAM = 16;
    private static final int INDEX_PARAM2 = 17;
    private static final int INDEX_PARAM3 = 18;
    private static final int INDEX_PARAM4 = 19;
    private static final int INDEX_PARAM5 = 20;
    private static final int INDEX_PARAM6 = 21;
    private static final int INDEX_PARAM7 = 22;
    private static final int INDEX_PARAM8 = 23;
    private static final int INDEX_PASSWD = 24;
    private static final int INDEX_PSAPPSERVERID = 25;
    private static final int INDEX_PSAPPSERVERNAME = 26;
    private static final int INDEX_PSROSSERVERID = 27;
    private static final int INDEX_PSROSSERVERNAME = 28;
    private static final int INDEX_PSSVRDOMAINID = 29;
    private static final int INDEX_PSSVRDOMAINNAME = 30;
    private static final int INDEX_PSSVRSERVERID = 31;
    private static final int INDEX_PSSVRSERVERNAME = 32;
    private static final int INDEX_PSTASKSERVERID = 33;
    private static final int INDEX_PSTASKSERVERNAME = 34;
    private static final int INDEX_REFINFO = 35;
    private static final int INDEX_SSHIPADDR = 36;
    private static final int INDEX_SSHPORT = 37;
    private static final int INDEX_STARTCMD = 38;
    private static final int INDEX_STOPCMD = 39;
    private static final int INDEX_TIMESHAREMODE = 40;
    private static final int INDEX_TIMESHARERESSPEC = 41;
    private static final int INDEX_TIMESHARERESTYPE = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_UPLOADFILEMODE = 45;
    private static final int INDEX_UPLOADPATH = 46;
    private static final int INDEX_USAGEMODE = 47;
    private static final int INDEX_USERNAME = 48;
    private static final int INDEX_WEBCONSOLEPATH = 49;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppServerBase proxyPSAppServerBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean appfolderDirtyFlag = false;
    private boolean asstateDirtyFlag = false;
    private boolean astypeDirtyFlag = false;
    private boolean beginportDirtyFlag = false;
    private boolean cfgfolderDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endportDirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean localresDirtyFlag = false;
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
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psrosserveridDirtyFlag = false;
    private boolean psrosservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssvrserveridDirtyFlag = false;
    private boolean pssvrservernameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean startcmdDirtyFlag = false;
    private boolean stopcmdDirtyFlag = false;
    private boolean timesharemodeDirtyFlag = false;
    private boolean timeshareresspecDirtyFlag = false;
    private boolean timesharerestypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean webconsolepathDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="appfolder")
    private String appfolder;
    @Column(name="asstate")
    private Integer asstate;
    @Column(name="astype")
    private String astype;
    @Column(name="beginport")
    private Integer beginport;
    @Column(name="cfgfolder")
    private String cfgfolder;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endport")
    private Integer endport;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="localres")
    private Integer localres;
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
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psrosserverid")
    private String psrosserverid;
    @Column(name="psrosservername")
    private String psrosservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pssvrserverid")
    private String pssvrserverid;
    @Column(name="pssvrservername")
    private String pssvrservername;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
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
    @Column(name="timesharemode")
    private Integer timesharemode;
    @Column(name="timeshareresspec")
    private String timeshareresspec;
    @Column(name="timesharerestype")
    private String timesharerestype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="username")
    private String username;
    @Column(name="webconsolepath")
    private String webconsolepath;
    private Integer objPSROSServerLock = new Integer(1);
    private PSROSServer psrosserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSSvrServerLock = new Integer(1);
    private PSSvrServer pssvrserver = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSDBDevInstsLock = new Integer(1);
    private ArrayList<PSDBDevInst> psdbdevinsts = null;
    private Integer objPSDBServersLock = new Integer(1);
    private ArrayList<PSDBServer> psdbservers = null;

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

    public void setBeginPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginPort(n);
            return;
        }
        this.beginport = n;
        this.beginportDirtyFlag = true;
    }

    public Integer getBeginPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPort();
        }
        return this.beginport;
    }

    public boolean isBeginPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginPortDirty();
        }
        return this.beginportDirtyFlag;
    }

    public void resetBeginPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginPort();
            return;
        }
        this.beginportDirtyFlag = false;
        this.beginport = null;
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

    public void setEndPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndPort(n);
            return;
        }
        this.endport = n;
        this.endportDirtyFlag = true;
    }

    public Integer getEndPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPort();
        }
        return this.endport;
    }

    public boolean isEndPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndPortDirty();
        }
        return this.endportDirtyFlag;
    }

    public void resetEndPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndPort();
            return;
        }
        this.endportDirtyFlag = false;
        this.endport = null;
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

    public void setPSAppServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappserverid = string;
        this.psappserveridDirtyFlag = true;
    }

    public String getPSAppServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerId();
        }
        return this.psappserverid;
    }

    public boolean isPSAppServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerIdDirty();
        }
        return this.psappserveridDirtyFlag;
    }

    public void resetPSAppServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerId();
            return;
        }
        this.psappserveridDirtyFlag = false;
        this.psappserverid = null;
    }

    public void setPSAppServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappservername = string;
        this.psappservernameDirtyFlag = true;
    }

    public String getPSAppServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerName();
        }
        return this.psappservername;
    }

    public boolean isPSAppServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerNameDirty();
        }
        return this.psappservernameDirtyFlag;
    }

    public void resetPSAppServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerName();
            return;
        }
        this.psappservernameDirtyFlag = false;
        this.psappservername = null;
    }

    public void setPSROSServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSROSServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrosserverid = string;
        this.psrosserveridDirtyFlag = true;
    }

    public String getPSROSServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServerId();
        }
        return this.psrosserverid;
    }

    public boolean isPSROSServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSROSServerIdDirty();
        }
        return this.psrosserveridDirtyFlag;
    }

    public void resetPSROSServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSROSServerId();
            return;
        }
        this.psrosserveridDirtyFlag = false;
        this.psrosserverid = null;
    }

    public void setPSROSServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSROSServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrosservername = string;
        this.psrosservernameDirtyFlag = true;
    }

    public String getPSROSServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServerName();
        }
        return this.psrosservername;
    }

    public boolean isPSROSServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSROSServerNameDirty();
        }
        return this.psrosservernameDirtyFlag;
    }

    public void resetPSROSServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSROSServerName();
            return;
        }
        this.psrosservernameDirtyFlag = false;
        this.psrosservername = null;
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

    public void setTimeShareMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareMode(n);
            return;
        }
        this.timesharemode = n;
        this.timesharemodeDirtyFlag = true;
    }

    public Integer getTimeShareMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareMode();
        }
        return this.timesharemode;
    }

    public boolean isTimeShareModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareModeDirty();
        }
        return this.timesharemodeDirtyFlag;
    }

    public void resetTimeShareMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareMode();
            return;
        }
        this.timesharemodeDirtyFlag = false;
        this.timesharemode = null;
    }

    public void setTimeShareResSpec(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareResSpec(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeshareresspec = string;
        this.timeshareresspecDirtyFlag = true;
    }

    public String getTimeShareResSpec() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareResSpec();
        }
        return this.timeshareresspec;
    }

    public boolean isTimeShareResSpecDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareResSpecDirty();
        }
        return this.timeshareresspecDirtyFlag;
    }

    public void resetTimeShareResSpec() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareResSpec();
            return;
        }
        this.timeshareresspecDirtyFlag = false;
        this.timeshareresspec = null;
    }

    public void setTimeShareResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timesharerestype = string;
        this.timesharerestypeDirtyFlag = true;
    }

    public String getTimeShareResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareResType();
        }
        return this.timesharerestype;
    }

    public boolean isTimeShareResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareResTypeDirty();
        }
        return this.timesharerestypeDirtyFlag;
    }

    public void resetTimeShareResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareResType();
            return;
        }
        this.timesharerestypeDirtyFlag = false;
        this.timesharerestype = null;
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

    protected void onReset() {
        PSAppServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppServerBase pSAppServerBase) {
        pSAppServerBase.resetAdminPasswd();
        pSAppServerBase.resetAdminUserName();
        pSAppServerBase.resetAppFolder();
        pSAppServerBase.resetASState();
        pSAppServerBase.resetASType();
        pSAppServerBase.resetBeginPort();
        pSAppServerBase.resetCfgFolder();
        pSAppServerBase.resetCreateDate();
        pSAppServerBase.resetCreateMan();
        pSAppServerBase.resetEndPort();
        pSAppServerBase.resetHttpAddress();
        pSAppServerBase.resetHttpPort();
        pSAppServerBase.resetHttpsPort();
        pSAppServerBase.resetIpAddr();
        pSAppServerBase.resetLocalRes();
        pSAppServerBase.resetMemo();
        pSAppServerBase.resetParam();
        pSAppServerBase.resetParam2();
        pSAppServerBase.resetParam3();
        pSAppServerBase.resetParam4();
        pSAppServerBase.resetParam5();
        pSAppServerBase.resetParam6();
        pSAppServerBase.resetParam7();
        pSAppServerBase.resetParam8();
        pSAppServerBase.resetPasswd();
        pSAppServerBase.resetPSAppServerId();
        pSAppServerBase.resetPSAppServerName();
        pSAppServerBase.resetPSROSServerId();
        pSAppServerBase.resetPSROSServerName();
        pSAppServerBase.resetPSSvrDomainId();
        pSAppServerBase.resetPSSvrDomainName();
        pSAppServerBase.resetPSSvrServerId();
        pSAppServerBase.resetPSSvrServerName();
        pSAppServerBase.resetPSTaskServerId();
        pSAppServerBase.resetPSTaskServerName();
        pSAppServerBase.resetRefInfo();
        pSAppServerBase.resetSSHIPAddr();
        pSAppServerBase.resetSSHPort();
        pSAppServerBase.resetStartCmd();
        pSAppServerBase.resetStopCmd();
        pSAppServerBase.resetTimeShareMode();
        pSAppServerBase.resetTimeShareResSpec();
        pSAppServerBase.resetTimeShareResType();
        pSAppServerBase.resetUpdateDate();
        pSAppServerBase.resetUpdateMan();
        pSAppServerBase.resetUploadFileMode();
        pSAppServerBase.resetUploadPath();
        pSAppServerBase.resetUsageMode();
        pSAppServerBase.resetUserName();
        pSAppServerBase.resetWebConsolePath();
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
        if (!bl || this.isASTypeDirty()) {
            hashMap.put(FIELD_ASTYPE, this.getASType());
        }
        if (!bl || this.isBeginPortDirty()) {
            hashMap.put(FIELD_BEGINPORT, this.getBeginPort());
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
        if (!bl || this.isEndPortDirty()) {
            hashMap.put(FIELD_ENDPORT, this.getEndPort());
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
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
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
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSROSServerIdDirty()) {
            hashMap.put(FIELD_PSROSSERVERID, this.getPSROSServerId());
        }
        if (!bl || this.isPSROSServerNameDirty()) {
            hashMap.put(FIELD_PSROSSERVERNAME, this.getPSROSServerName());
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
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        if (!bl || this.isTimeShareModeDirty()) {
            hashMap.put(FIELD_TIMESHAREMODE, this.getTimeShareMode());
        }
        if (!bl || this.isTimeShareResSpecDirty()) {
            hashMap.put(FIELD_TIMESHARERESSPEC, this.getTimeShareResSpec());
        }
        if (!bl || this.isTimeShareResTypeDirty()) {
            hashMap.put(FIELD_TIMESHARERESTYPE, this.getTimeShareResType());
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
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isWebConsolePathDirty()) {
            hashMap.put(FIELD_WEBCONSOLEPATH, this.getWebConsolePath());
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
        return PSAppServerBase.get(this, n);
    }

    private static Object get(PSAppServerBase pSAppServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppServerBase.getAdminPasswd();
            }
            case 1: {
                return pSAppServerBase.getAdminUserName();
            }
            case 2: {
                return pSAppServerBase.getAppFolder();
            }
            case 3: {
                return pSAppServerBase.getASState();
            }
            case 4: {
                return pSAppServerBase.getASType();
            }
            case 5: {
                return pSAppServerBase.getBeginPort();
            }
            case 6: {
                return pSAppServerBase.getCfgFolder();
            }
            case 7: {
                return pSAppServerBase.getCreateDate();
            }
            case 8: {
                return pSAppServerBase.getCreateMan();
            }
            case 9: {
                return pSAppServerBase.getEndPort();
            }
            case 10: {
                return pSAppServerBase.getHttpAddress();
            }
            case 11: {
                return pSAppServerBase.getHttpPort();
            }
            case 12: {
                return pSAppServerBase.getHttpsPort();
            }
            case 13: {
                return pSAppServerBase.getIpAddr();
            }
            case 14: {
                return pSAppServerBase.getLocalRes();
            }
            case 15: {
                return pSAppServerBase.getMemo();
            }
            case 16: {
                return pSAppServerBase.getParam();
            }
            case 17: {
                return pSAppServerBase.getParam2();
            }
            case 18: {
                return pSAppServerBase.getParam3();
            }
            case 19: {
                return pSAppServerBase.getParam4();
            }
            case 20: {
                return pSAppServerBase.getParam5();
            }
            case 21: {
                return pSAppServerBase.getParam6();
            }
            case 22: {
                return pSAppServerBase.getParam7();
            }
            case 23: {
                return pSAppServerBase.getParam8();
            }
            case 24: {
                return pSAppServerBase.getPasswd();
            }
            case 25: {
                return pSAppServerBase.getPSAppServerId();
            }
            case 26: {
                return pSAppServerBase.getPSAppServerName();
            }
            case 27: {
                return pSAppServerBase.getPSROSServerId();
            }
            case 28: {
                return pSAppServerBase.getPSROSServerName();
            }
            case 29: {
                return pSAppServerBase.getPSSvrDomainId();
            }
            case 30: {
                return pSAppServerBase.getPSSvrDomainName();
            }
            case 31: {
                return pSAppServerBase.getPSSvrServerId();
            }
            case 32: {
                return pSAppServerBase.getPSSvrServerName();
            }
            case 33: {
                return pSAppServerBase.getPSTaskServerId();
            }
            case 34: {
                return pSAppServerBase.getPSTaskServerName();
            }
            case 35: {
                return pSAppServerBase.getRefInfo();
            }
            case 36: {
                return pSAppServerBase.getSSHIPAddr();
            }
            case 37: {
                return pSAppServerBase.getSSHPort();
            }
            case 38: {
                return pSAppServerBase.getStartCmd();
            }
            case 39: {
                return pSAppServerBase.getStopCmd();
            }
            case 40: {
                return pSAppServerBase.getTimeShareMode();
            }
            case 41: {
                return pSAppServerBase.getTimeShareResSpec();
            }
            case 42: {
                return pSAppServerBase.getTimeShareResType();
            }
            case 43: {
                return pSAppServerBase.getUpdateDate();
            }
            case 44: {
                return pSAppServerBase.getUpdateMan();
            }
            case 45: {
                return pSAppServerBase.getUploadFileMode();
            }
            case 46: {
                return pSAppServerBase.getUploadPath();
            }
            case 47: {
                return pSAppServerBase.getUsageMode();
            }
            case 48: {
                return pSAppServerBase.getUserName();
            }
            case 49: {
                return pSAppServerBase.getWebConsolePath();
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
        PSAppServerBase.set(this, n, object);
    }

    private static void set(PSAppServerBase pSAppServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppServerBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppServerBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppServerBase.setAppFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppServerBase.setASState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSAppServerBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppServerBase.setBeginPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppServerBase.setCfgFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppServerBase.setEndPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppServerBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppServerBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppServerBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSAppServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppServerBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSAppServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppServerBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppServerBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppServerBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppServerBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppServerBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSAppServerBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSAppServerBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSAppServerBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSAppServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppServerBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppServerBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppServerBase.setPSROSServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppServerBase.setPSROSServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppServerBase.setPSSvrServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppServerBase.setPSSvrServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppServerBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppServerBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppServerBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppServerBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppServerBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSAppServerBase.setStartCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppServerBase.setStopCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppServerBase.setTimeShareMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSAppServerBase.setTimeShareResSpec(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppServerBase.setTimeShareResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSAppServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppServerBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppServerBase.setWebConsolePath(DataObject.getStringValue((Object)object));
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
        return PSAppServerBase.isNull(this, n);
    }

    private static boolean isNull(PSAppServerBase pSAppServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppServerBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSAppServerBase.getAdminUserName() == null;
            }
            case 2: {
                return pSAppServerBase.getAppFolder() == null;
            }
            case 3: {
                return pSAppServerBase.getASState() == null;
            }
            case 4: {
                return pSAppServerBase.getASType() == null;
            }
            case 5: {
                return pSAppServerBase.getBeginPort() == null;
            }
            case 6: {
                return pSAppServerBase.getCfgFolder() == null;
            }
            case 7: {
                return pSAppServerBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppServerBase.getCreateMan() == null;
            }
            case 9: {
                return pSAppServerBase.getEndPort() == null;
            }
            case 10: {
                return pSAppServerBase.getHttpAddress() == null;
            }
            case 11: {
                return pSAppServerBase.getHttpPort() == null;
            }
            case 12: {
                return pSAppServerBase.getHttpsPort() == null;
            }
            case 13: {
                return pSAppServerBase.getIpAddr() == null;
            }
            case 14: {
                return pSAppServerBase.getLocalRes() == null;
            }
            case 15: {
                return pSAppServerBase.getMemo() == null;
            }
            case 16: {
                return pSAppServerBase.getParam() == null;
            }
            case 17: {
                return pSAppServerBase.getParam2() == null;
            }
            case 18: {
                return pSAppServerBase.getParam3() == null;
            }
            case 19: {
                return pSAppServerBase.getParam4() == null;
            }
            case 20: {
                return pSAppServerBase.getParam5() == null;
            }
            case 21: {
                return pSAppServerBase.getParam6() == null;
            }
            case 22: {
                return pSAppServerBase.getParam7() == null;
            }
            case 23: {
                return pSAppServerBase.getParam8() == null;
            }
            case 24: {
                return pSAppServerBase.getPasswd() == null;
            }
            case 25: {
                return pSAppServerBase.getPSAppServerId() == null;
            }
            case 26: {
                return pSAppServerBase.getPSAppServerName() == null;
            }
            case 27: {
                return pSAppServerBase.getPSROSServerId() == null;
            }
            case 28: {
                return pSAppServerBase.getPSROSServerName() == null;
            }
            case 29: {
                return pSAppServerBase.getPSSvrDomainId() == null;
            }
            case 30: {
                return pSAppServerBase.getPSSvrDomainName() == null;
            }
            case 31: {
                return pSAppServerBase.getPSSvrServerId() == null;
            }
            case 32: {
                return pSAppServerBase.getPSSvrServerName() == null;
            }
            case 33: {
                return pSAppServerBase.getPSTaskServerId() == null;
            }
            case 34: {
                return pSAppServerBase.getPSTaskServerName() == null;
            }
            case 35: {
                return pSAppServerBase.getRefInfo() == null;
            }
            case 36: {
                return pSAppServerBase.getSSHIPAddr() == null;
            }
            case 37: {
                return pSAppServerBase.getSSHPort() == null;
            }
            case 38: {
                return pSAppServerBase.getStartCmd() == null;
            }
            case 39: {
                return pSAppServerBase.getStopCmd() == null;
            }
            case 40: {
                return pSAppServerBase.getTimeShareMode() == null;
            }
            case 41: {
                return pSAppServerBase.getTimeShareResSpec() == null;
            }
            case 42: {
                return pSAppServerBase.getTimeShareResType() == null;
            }
            case 43: {
                return pSAppServerBase.getUpdateDate() == null;
            }
            case 44: {
                return pSAppServerBase.getUpdateMan() == null;
            }
            case 45: {
                return pSAppServerBase.getUploadFileMode() == null;
            }
            case 46: {
                return pSAppServerBase.getUploadPath() == null;
            }
            case 47: {
                return pSAppServerBase.getUsageMode() == null;
            }
            case 48: {
                return pSAppServerBase.getUserName() == null;
            }
            case 49: {
                return pSAppServerBase.getWebConsolePath() == null;
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
        return PSAppServerBase.contains(this, n);
    }

    private static boolean contains(PSAppServerBase pSAppServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppServerBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSAppServerBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSAppServerBase.isAppFolderDirty();
            }
            case 3: {
                return pSAppServerBase.isASStateDirty();
            }
            case 4: {
                return pSAppServerBase.isASTypeDirty();
            }
            case 5: {
                return pSAppServerBase.isBeginPortDirty();
            }
            case 6: {
                return pSAppServerBase.isCfgFolderDirty();
            }
            case 7: {
                return pSAppServerBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppServerBase.isCreateManDirty();
            }
            case 9: {
                return pSAppServerBase.isEndPortDirty();
            }
            case 10: {
                return pSAppServerBase.isHttpAddressDirty();
            }
            case 11: {
                return pSAppServerBase.isHttpPortDirty();
            }
            case 12: {
                return pSAppServerBase.isHttpsPortDirty();
            }
            case 13: {
                return pSAppServerBase.isIpAddrDirty();
            }
            case 14: {
                return pSAppServerBase.isLocalResDirty();
            }
            case 15: {
                return pSAppServerBase.isMemoDirty();
            }
            case 16: {
                return pSAppServerBase.isParamDirty();
            }
            case 17: {
                return pSAppServerBase.isParam2Dirty();
            }
            case 18: {
                return pSAppServerBase.isParam3Dirty();
            }
            case 19: {
                return pSAppServerBase.isParam4Dirty();
            }
            case 20: {
                return pSAppServerBase.isParam5Dirty();
            }
            case 21: {
                return pSAppServerBase.isParam6Dirty();
            }
            case 22: {
                return pSAppServerBase.isParam7Dirty();
            }
            case 23: {
                return pSAppServerBase.isParam8Dirty();
            }
            case 24: {
                return pSAppServerBase.isPasswdDirty();
            }
            case 25: {
                return pSAppServerBase.isPSAppServerIdDirty();
            }
            case 26: {
                return pSAppServerBase.isPSAppServerNameDirty();
            }
            case 27: {
                return pSAppServerBase.isPSROSServerIdDirty();
            }
            case 28: {
                return pSAppServerBase.isPSROSServerNameDirty();
            }
            case 29: {
                return pSAppServerBase.isPSSvrDomainIdDirty();
            }
            case 30: {
                return pSAppServerBase.isPSSvrDomainNameDirty();
            }
            case 31: {
                return pSAppServerBase.isPSSvrServerIdDirty();
            }
            case 32: {
                return pSAppServerBase.isPSSvrServerNameDirty();
            }
            case 33: {
                return pSAppServerBase.isPSTaskServerIdDirty();
            }
            case 34: {
                return pSAppServerBase.isPSTaskServerNameDirty();
            }
            case 35: {
                return pSAppServerBase.isRefInfoDirty();
            }
            case 36: {
                return pSAppServerBase.isSSHIPAddrDirty();
            }
            case 37: {
                return pSAppServerBase.isSSHPortDirty();
            }
            case 38: {
                return pSAppServerBase.isStartCmdDirty();
            }
            case 39: {
                return pSAppServerBase.isStopCmdDirty();
            }
            case 40: {
                return pSAppServerBase.isTimeShareModeDirty();
            }
            case 41: {
                return pSAppServerBase.isTimeShareResSpecDirty();
            }
            case 42: {
                return pSAppServerBase.isTimeShareResTypeDirty();
            }
            case 43: {
                return pSAppServerBase.isUpdateDateDirty();
            }
            case 44: {
                return pSAppServerBase.isUpdateManDirty();
            }
            case 45: {
                return pSAppServerBase.isUploadFileModeDirty();
            }
            case 46: {
                return pSAppServerBase.isUploadPathDirty();
            }
            case 47: {
                return pSAppServerBase.isUsageModeDirty();
            }
            case 48: {
                return pSAppServerBase.isUserNameDirty();
            }
            case 49: {
                return pSAppServerBase.isWebConsolePathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppServerBase pSAppServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppServerBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSAppServerBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getAppFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfolder", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getAppFolder()), (boolean)false);
        }
        if (bl || pSAppServerBase.getASState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asstate", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getASState()), (boolean)false);
        }
        if (bl || pSAppServerBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getASType()), (boolean)false);
        }
        if (bl || pSAppServerBase.getBeginPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginport", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getBeginPort()), (boolean)false);
        }
        if (bl || pSAppServerBase.getCfgFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgfolder", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getCfgFolder()), (boolean)false);
        }
        if (bl || pSAppServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppServerBase.getEndPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endport", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getEndPort()), (boolean)false);
        }
        if (bl || pSAppServerBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSAppServerBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSAppServerBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSAppServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSAppServerBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSAppServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam2()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam3()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam4()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam5()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam6()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam7()), (boolean)false);
        }
        if (bl || pSAppServerBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getParam8()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSROSServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrosserverid", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSROSServerId()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSROSServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrosservername", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSROSServerName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSSvrServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrserverid", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSSvrServerId()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSSvrServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrservername", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSSvrServerName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSAppServerBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSAppServerBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSAppServerBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSAppServerBase.getStartCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startcmd", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getStartCmd()), (boolean)false);
        }
        if (bl || pSAppServerBase.getStopCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopcmd", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getStopCmd()), (boolean)false);
        }
        if (bl || pSAppServerBase.getTimeShareMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timesharemode", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getTimeShareMode()), (boolean)false);
        }
        if (bl || pSAppServerBase.getTimeShareResSpec() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeshareresspec", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getTimeShareResSpec()), (boolean)false);
        }
        if (bl || pSAppServerBase.getTimeShareResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timesharerestype", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getTimeShareResType()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSAppServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSAppServerBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSAppServerBase.getJSONValue((Object)pSAppServerBase.getWebConsolePath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppServerBase pSAppServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppServerBase.getAdminPasswd() != null) {
            object = pSAppServerBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSAppServerBase.getAdminUserName() != null) {
            object = pSAppServerBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSAppServerBase.getAppFolder() != null) {
            object = pSAppServerBase.getAppFolder();
            xmlNode.setAttribute(FIELD_APPFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getASState() != null) {
            object = pSAppServerBase.getASState();
            xmlNode.setAttribute(FIELD_ASSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getASType() != null) {
            object = pSAppServerBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getBeginPort() != null) {
            object = pSAppServerBase.getBeginPort();
            xmlNode.setAttribute(FIELD_BEGINPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getCfgFolder() != null) {
            object = pSAppServerBase.getCfgFolder();
            xmlNode.setAttribute(FIELD_CFGFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getCreateDate() != null) {
            object = pSAppServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppServerBase.getCreateMan() != null) {
            object = pSAppServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getEndPort() != null) {
            object = pSAppServerBase.getEndPort();
            xmlNode.setAttribute(FIELD_ENDPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getHttpAddress() != null) {
            object = pSAppServerBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getHttpPort() != null) {
            object = pSAppServerBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getHttpsPort() != null) {
            object = pSAppServerBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getIpAddr() != null) {
            object = pSAppServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getLocalRes() != null) {
            object = pSAppServerBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getMemo() != null) {
            object = pSAppServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getParam() != null) {
            object = pSAppServerBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getParam2() != null) {
            object = pSAppServerBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getParam3() != null) {
            object = pSAppServerBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getParam4() != null) {
            object = pSAppServerBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getParam5() != null) {
            object = pSAppServerBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getParam6() != null) {
            object = pSAppServerBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getParam7() != null) {
            object = pSAppServerBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getParam8() != null) {
            object = pSAppServerBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getPasswd() != null) {
            object = pSAppServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSAppServerId() != null) {
            object = pSAppServerBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSAppServerName() != null) {
            object = pSAppServerBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSROSServerId() != null) {
            object = pSAppServerBase.getPSROSServerId();
            xmlNode.setAttribute(FIELD_PSROSSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSROSServerName() != null) {
            object = pSAppServerBase.getPSROSServerName();
            xmlNode.setAttribute(FIELD_PSROSSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSSvrDomainId() != null) {
            object = pSAppServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSSvrDomainName() != null) {
            object = pSAppServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSSvrServerId() != null) {
            object = pSAppServerBase.getPSSvrServerId();
            xmlNode.setAttribute(FIELD_PSSVRSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSSvrServerName() != null) {
            object = pSAppServerBase.getPSSvrServerName();
            xmlNode.setAttribute(FIELD_PSSVRSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSTaskServerId() != null) {
            object = pSAppServerBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getPSTaskServerName() != null) {
            object = pSAppServerBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getRefInfo() != null) {
            object = pSAppServerBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getSSHIPAddr() != null) {
            object = pSAppServerBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getSSHPort() != null) {
            object = pSAppServerBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getStartCmd() != null) {
            object = pSAppServerBase.getStartCmd();
            xmlNode.setAttribute(FIELD_STARTCMD, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getStopCmd() != null) {
            object = pSAppServerBase.getStopCmd();
            xmlNode.setAttribute(FIELD_STOPCMD, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getTimeShareMode() != null) {
            object = pSAppServerBase.getTimeShareMode();
            xmlNode.setAttribute(FIELD_TIMESHAREMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppServerBase.getTimeShareResSpec() != null) {
            object = pSAppServerBase.getTimeShareResSpec();
            xmlNode.setAttribute(FIELD_TIMESHARERESSPEC, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getTimeShareResType() != null) {
            object = pSAppServerBase.getTimeShareResType();
            xmlNode.setAttribute(FIELD_TIMESHARERESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getUpdateDate() != null) {
            object = pSAppServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppServerBase.getUpdateMan() != null) {
            object = pSAppServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getUploadFileMode() != null) {
            object = pSAppServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getUploadPath() != null) {
            object = pSAppServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getUsageMode() != null) {
            object = pSAppServerBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getUserName() != null) {
            object = pSAppServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppServerBase.getWebConsolePath() != null) {
            object = pSAppServerBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppServerBase pSAppServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppServerBase.isAdminPasswdDirty() && (bl || pSAppServerBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSAppServerBase.getAdminPasswd());
        }
        if (pSAppServerBase.isAdminUserNameDirty() && (bl || pSAppServerBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSAppServerBase.getAdminUserName());
        }
        if (pSAppServerBase.isAppFolderDirty() && (bl || pSAppServerBase.getAppFolder() != null)) {
            iDataObject.set(FIELD_APPFOLDER, (Object)pSAppServerBase.getAppFolder());
        }
        if (pSAppServerBase.isASStateDirty() && (bl || pSAppServerBase.getASState() != null)) {
            iDataObject.set(FIELD_ASSTATE, (Object)pSAppServerBase.getASState());
        }
        if (pSAppServerBase.isASTypeDirty() && (bl || pSAppServerBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSAppServerBase.getASType());
        }
        if (pSAppServerBase.isBeginPortDirty() && (bl || pSAppServerBase.getBeginPort() != null)) {
            iDataObject.set(FIELD_BEGINPORT, (Object)pSAppServerBase.getBeginPort());
        }
        if (pSAppServerBase.isCfgFolderDirty() && (bl || pSAppServerBase.getCfgFolder() != null)) {
            iDataObject.set(FIELD_CFGFOLDER, (Object)pSAppServerBase.getCfgFolder());
        }
        if (pSAppServerBase.isCreateDateDirty() && (bl || pSAppServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppServerBase.getCreateDate());
        }
        if (pSAppServerBase.isCreateManDirty() && (bl || pSAppServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppServerBase.getCreateMan());
        }
        if (pSAppServerBase.isEndPortDirty() && (bl || pSAppServerBase.getEndPort() != null)) {
            iDataObject.set(FIELD_ENDPORT, (Object)pSAppServerBase.getEndPort());
        }
        if (pSAppServerBase.isHttpAddressDirty() && (bl || pSAppServerBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSAppServerBase.getHttpAddress());
        }
        if (pSAppServerBase.isHttpPortDirty() && (bl || pSAppServerBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSAppServerBase.getHttpPort());
        }
        if (pSAppServerBase.isHttpsPortDirty() && (bl || pSAppServerBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSAppServerBase.getHttpsPort());
        }
        if (pSAppServerBase.isIpAddrDirty() && (bl || pSAppServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSAppServerBase.getIpAddr());
        }
        if (pSAppServerBase.isLocalResDirty() && (bl || pSAppServerBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSAppServerBase.getLocalRes());
        }
        if (pSAppServerBase.isMemoDirty() && (bl || pSAppServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppServerBase.getMemo());
        }
        if (pSAppServerBase.isParamDirty() && (bl || pSAppServerBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSAppServerBase.getParam());
        }
        if (pSAppServerBase.isParam2Dirty() && (bl || pSAppServerBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSAppServerBase.getParam2());
        }
        if (pSAppServerBase.isParam3Dirty() && (bl || pSAppServerBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSAppServerBase.getParam3());
        }
        if (pSAppServerBase.isParam4Dirty() && (bl || pSAppServerBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSAppServerBase.getParam4());
        }
        if (pSAppServerBase.isParam5Dirty() && (bl || pSAppServerBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSAppServerBase.getParam5());
        }
        if (pSAppServerBase.isParam6Dirty() && (bl || pSAppServerBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSAppServerBase.getParam6());
        }
        if (pSAppServerBase.isParam7Dirty() && (bl || pSAppServerBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSAppServerBase.getParam7());
        }
        if (pSAppServerBase.isParam8Dirty() && (bl || pSAppServerBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSAppServerBase.getParam8());
        }
        if (pSAppServerBase.isPasswdDirty() && (bl || pSAppServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSAppServerBase.getPasswd());
        }
        if (pSAppServerBase.isPSAppServerIdDirty() && (bl || pSAppServerBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSAppServerBase.getPSAppServerId());
        }
        if (pSAppServerBase.isPSAppServerNameDirty() && (bl || pSAppServerBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSAppServerBase.getPSAppServerName());
        }
        if (pSAppServerBase.isPSROSServerIdDirty() && (bl || pSAppServerBase.getPSROSServerId() != null)) {
            iDataObject.set(FIELD_PSROSSERVERID, (Object)pSAppServerBase.getPSROSServerId());
        }
        if (pSAppServerBase.isPSROSServerNameDirty() && (bl || pSAppServerBase.getPSROSServerName() != null)) {
            iDataObject.set(FIELD_PSROSSERVERNAME, (Object)pSAppServerBase.getPSROSServerName());
        }
        if (pSAppServerBase.isPSSvrDomainIdDirty() && (bl || pSAppServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSAppServerBase.getPSSvrDomainId());
        }
        if (pSAppServerBase.isPSSvrDomainNameDirty() && (bl || pSAppServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSAppServerBase.getPSSvrDomainName());
        }
        if (pSAppServerBase.isPSSvrServerIdDirty() && (bl || pSAppServerBase.getPSSvrServerId() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERID, (Object)pSAppServerBase.getPSSvrServerId());
        }
        if (pSAppServerBase.isPSSvrServerNameDirty() && (bl || pSAppServerBase.getPSSvrServerName() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERNAME, (Object)pSAppServerBase.getPSSvrServerName());
        }
        if (pSAppServerBase.isPSTaskServerIdDirty() && (bl || pSAppServerBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSAppServerBase.getPSTaskServerId());
        }
        if (pSAppServerBase.isPSTaskServerNameDirty() && (bl || pSAppServerBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSAppServerBase.getPSTaskServerName());
        }
        if (pSAppServerBase.isRefInfoDirty() && (bl || pSAppServerBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSAppServerBase.getRefInfo());
        }
        if (pSAppServerBase.isSSHIPAddrDirty() && (bl || pSAppServerBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSAppServerBase.getSSHIPAddr());
        }
        if (pSAppServerBase.isSSHPortDirty() && (bl || pSAppServerBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSAppServerBase.getSSHPort());
        }
        if (pSAppServerBase.isStartCmdDirty() && (bl || pSAppServerBase.getStartCmd() != null)) {
            iDataObject.set(FIELD_STARTCMD, (Object)pSAppServerBase.getStartCmd());
        }
        if (pSAppServerBase.isStopCmdDirty() && (bl || pSAppServerBase.getStopCmd() != null)) {
            iDataObject.set(FIELD_STOPCMD, (Object)pSAppServerBase.getStopCmd());
        }
        if (pSAppServerBase.isTimeShareModeDirty() && (bl || pSAppServerBase.getTimeShareMode() != null)) {
            iDataObject.set(FIELD_TIMESHAREMODE, (Object)pSAppServerBase.getTimeShareMode());
        }
        if (pSAppServerBase.isTimeShareResSpecDirty() && (bl || pSAppServerBase.getTimeShareResSpec() != null)) {
            iDataObject.set(FIELD_TIMESHARERESSPEC, (Object)pSAppServerBase.getTimeShareResSpec());
        }
        if (pSAppServerBase.isTimeShareResTypeDirty() && (bl || pSAppServerBase.getTimeShareResType() != null)) {
            iDataObject.set(FIELD_TIMESHARERESTYPE, (Object)pSAppServerBase.getTimeShareResType());
        }
        if (pSAppServerBase.isUpdateDateDirty() && (bl || pSAppServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppServerBase.getUpdateDate());
        }
        if (pSAppServerBase.isUpdateManDirty() && (bl || pSAppServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppServerBase.getUpdateMan());
        }
        if (pSAppServerBase.isUploadFileModeDirty() && (bl || pSAppServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSAppServerBase.getUploadFileMode());
        }
        if (pSAppServerBase.isUploadPathDirty() && (bl || pSAppServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSAppServerBase.getUploadPath());
        }
        if (pSAppServerBase.isUsageModeDirty() && (bl || pSAppServerBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSAppServerBase.getUsageMode());
        }
        if (pSAppServerBase.isUserNameDirty() && (bl || pSAppServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSAppServerBase.getUserName());
        }
        if (pSAppServerBase.isWebConsolePathDirty() && (bl || pSAppServerBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSAppServerBase.getWebConsolePath());
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
        return PSAppServerBase.remove(this, n);
    }

    private static boolean remove(PSAppServerBase pSAppServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppServerBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSAppServerBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSAppServerBase.resetAppFolder();
                return true;
            }
            case 3: {
                pSAppServerBase.resetASState();
                return true;
            }
            case 4: {
                pSAppServerBase.resetASType();
                return true;
            }
            case 5: {
                pSAppServerBase.resetBeginPort();
                return true;
            }
            case 6: {
                pSAppServerBase.resetCfgFolder();
                return true;
            }
            case 7: {
                pSAppServerBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppServerBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSAppServerBase.resetEndPort();
                return true;
            }
            case 10: {
                pSAppServerBase.resetHttpAddress();
                return true;
            }
            case 11: {
                pSAppServerBase.resetHttpPort();
                return true;
            }
            case 12: {
                pSAppServerBase.resetHttpsPort();
                return true;
            }
            case 13: {
                pSAppServerBase.resetIpAddr();
                return true;
            }
            case 14: {
                pSAppServerBase.resetLocalRes();
                return true;
            }
            case 15: {
                pSAppServerBase.resetMemo();
                return true;
            }
            case 16: {
                pSAppServerBase.resetParam();
                return true;
            }
            case 17: {
                pSAppServerBase.resetParam2();
                return true;
            }
            case 18: {
                pSAppServerBase.resetParam3();
                return true;
            }
            case 19: {
                pSAppServerBase.resetParam4();
                return true;
            }
            case 20: {
                pSAppServerBase.resetParam5();
                return true;
            }
            case 21: {
                pSAppServerBase.resetParam6();
                return true;
            }
            case 22: {
                pSAppServerBase.resetParam7();
                return true;
            }
            case 23: {
                pSAppServerBase.resetParam8();
                return true;
            }
            case 24: {
                pSAppServerBase.resetPasswd();
                return true;
            }
            case 25: {
                pSAppServerBase.resetPSAppServerId();
                return true;
            }
            case 26: {
                pSAppServerBase.resetPSAppServerName();
                return true;
            }
            case 27: {
                pSAppServerBase.resetPSROSServerId();
                return true;
            }
            case 28: {
                pSAppServerBase.resetPSROSServerName();
                return true;
            }
            case 29: {
                pSAppServerBase.resetPSSvrDomainId();
                return true;
            }
            case 30: {
                pSAppServerBase.resetPSSvrDomainName();
                return true;
            }
            case 31: {
                pSAppServerBase.resetPSSvrServerId();
                return true;
            }
            case 32: {
                pSAppServerBase.resetPSSvrServerName();
                return true;
            }
            case 33: {
                pSAppServerBase.resetPSTaskServerId();
                return true;
            }
            case 34: {
                pSAppServerBase.resetPSTaskServerName();
                return true;
            }
            case 35: {
                pSAppServerBase.resetRefInfo();
                return true;
            }
            case 36: {
                pSAppServerBase.resetSSHIPAddr();
                return true;
            }
            case 37: {
                pSAppServerBase.resetSSHPort();
                return true;
            }
            case 38: {
                pSAppServerBase.resetStartCmd();
                return true;
            }
            case 39: {
                pSAppServerBase.resetStopCmd();
                return true;
            }
            case 40: {
                pSAppServerBase.resetTimeShareMode();
                return true;
            }
            case 41: {
                pSAppServerBase.resetTimeShareResSpec();
                return true;
            }
            case 42: {
                pSAppServerBase.resetTimeShareResType();
                return true;
            }
            case 43: {
                pSAppServerBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSAppServerBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSAppServerBase.resetUploadFileMode();
                return true;
            }
            case 46: {
                pSAppServerBase.resetUploadPath();
                return true;
            }
            case 47: {
                pSAppServerBase.resetUsageMode();
                return true;
            }
            case 48: {
                pSAppServerBase.resetUserName();
                return true;
            }
            case 49: {
                pSAppServerBase.resetWebConsolePath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSROSServer getPSROSServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServer();
        }
        if (this.getPSROSServerId() == null) {
            return null;
        }
        Integer n = this.objPSROSServerLock;
        synchronized (n) {
            if (this.psrosserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSROSServerId(), (Object)this.psrosserver.getPSROSServerId()) != 0L) {
                this.psrosserver = null;
            }
            if (this.psrosserver == null) {
                PSROSServer pSROSServer = new PSROSServer();
                pSROSServer.setPSROSServerId(this.getPSROSServerId());
                PSROSServerService pSROSServerService = (PSROSServerService)ServiceGlobal.getService(PSROSServerService.class, (SessionFactory)this.getSessionFactory());
                pSROSServerService.autoGet((IEntity)pSROSServer);
                this.psrosserver = pSROSServer;
            }
            return this.psrosserver;
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
                pSSvrServerService.autoGet((IEntity)pSSvrServer);
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
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDBDevInst> getPSDBDevInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInsts();
        }
        if (this.getPSAppServerId() == null) {
            return null;
        }
        PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDBDevInstsLock;
        synchronized (n) {
            if (this.psdbdevinsts == null) {
                this.psdbdevinsts = pSDBDevInstService.selectByPSAppServer(this);
            }
            return this.psdbdevinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDBServer> getPSDBServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServers();
        }
        if (this.getPSAppServerId() == null) {
            return null;
        }
        PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDBServersLock;
        synchronized (n) {
            if (this.psdbservers == null) {
                this.psdbservers = pSDBServerService.selectByPSAppServer(this);
            }
            return this.psdbservers;
        }
    }

    private PSAppServerBase getProxyEntity() {
        return this.proxyPSAppServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppServerBase) {
            this.proxyPSAppServerBase = (PSAppServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_APPFOLDER, 2);
        fieldIndexMap.put(FIELD_ASSTATE, 3);
        fieldIndexMap.put(FIELD_ASTYPE, 4);
        fieldIndexMap.put(FIELD_BEGINPORT, 5);
        fieldIndexMap.put(FIELD_CFGFOLDER, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_ENDPORT, 9);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 10);
        fieldIndexMap.put(FIELD_HTTPPORT, 11);
        fieldIndexMap.put(FIELD_HTTPSPORT, 12);
        fieldIndexMap.put(FIELD_IPADDR, 13);
        fieldIndexMap.put(FIELD_LOCALRES, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PARAM, 16);
        fieldIndexMap.put(FIELD_PARAM2, 17);
        fieldIndexMap.put(FIELD_PARAM3, 18);
        fieldIndexMap.put(FIELD_PARAM4, 19);
        fieldIndexMap.put(FIELD_PARAM5, 20);
        fieldIndexMap.put(FIELD_PARAM6, 21);
        fieldIndexMap.put(FIELD_PARAM7, 22);
        fieldIndexMap.put(FIELD_PARAM8, 23);
        fieldIndexMap.put(FIELD_PASSWD, 24);
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 25);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 26);
        fieldIndexMap.put(FIELD_PSROSSERVERID, 27);
        fieldIndexMap.put(FIELD_PSROSSERVERNAME, 28);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 29);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 30);
        fieldIndexMap.put(FIELD_PSSVRSERVERID, 31);
        fieldIndexMap.put(FIELD_PSSVRSERVERNAME, 32);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 33);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 34);
        fieldIndexMap.put(FIELD_REFINFO, 35);
        fieldIndexMap.put(FIELD_SSHIPADDR, 36);
        fieldIndexMap.put(FIELD_SSHPORT, 37);
        fieldIndexMap.put(FIELD_STARTCMD, 38);
        fieldIndexMap.put(FIELD_STOPCMD, 39);
        fieldIndexMap.put(FIELD_TIMESHAREMODE, 40);
        fieldIndexMap.put(FIELD_TIMESHARERESSPEC, 41);
        fieldIndexMap.put(FIELD_TIMESHARERESTYPE, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 45);
        fieldIndexMap.put(FIELD_UPLOADPATH, 46);
        fieldIndexMap.put(FIELD_USAGEMODE, 47);
        fieldIndexMap.put(FIELD_USERNAME, 48);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 49);
    }
}

