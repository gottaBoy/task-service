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
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBServerBase.class);
    public static final String FIELD_BACKUPMODE = "BACKUPMODE";
    public static final String FIELD_BAKDBPASSWD = "BAKDBPASSWD";
    public static final String FIELD_BAKDBPORT = "BAKDBPORT";
    public static final String FIELD_BAKDBURL = "BAKDBURL";
    public static final String FIELD_BAKDBUSERNAME = "BAKDBUSERNAME";
    public static final String FIELD_BAKIPADDR = "BAKIPADDR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBINSTALLPATH = "DBINSTALLPATH";
    public static final String FIELD_DBPASSWD = "DBPASSWD";
    public static final String FIELD_DBPORT = "DBPORT";
    public static final String FIELD_DBROOT = "DBROOT";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_DBURL = "DBURL";
    public static final String FIELD_DBUSERNAME = "DBUSERNAME";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSDBSERVERID = "PSDBSERVERID";
    public static final String FIELD_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BACKUPMODE = 0;
    private static final int INDEX_BAKDBPASSWD = 1;
    private static final int INDEX_BAKDBPORT = 2;
    private static final int INDEX_BAKDBURL = 3;
    private static final int INDEX_BAKDBUSERNAME = 4;
    private static final int INDEX_BAKIPADDR = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DBINSTALLPATH = 8;
    private static final int INDEX_DBPASSWD = 9;
    private static final int INDEX_DBPORT = 10;
    private static final int INDEX_DBROOT = 11;
    private static final int INDEX_DBTYPE = 12;
    private static final int INDEX_DBURL = 13;
    private static final int INDEX_DBUSERNAME = 14;
    private static final int INDEX_ENABLE = 15;
    private static final int INDEX_IPADDR = 16;
    private static final int INDEX_LOCALRES = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PASSWD = 19;
    private static final int INDEX_PORT = 20;
    private static final int INDEX_PSAPPSERVERID = 21;
    private static final int INDEX_PSAPPSERVERNAME = 22;
    private static final int INDEX_PSDBSERVERID = 23;
    private static final int INDEX_PSDBSERVERNAME = 24;
    private static final int INDEX_PSSVRDOMAINID = 25;
    private static final int INDEX_PSSVRDOMAINNAME = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_UPLOADFILEMODE = 29;
    private static final int INDEX_UPLOADPATH = 30;
    private static final int INDEX_USERNAME = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBServerBase proxyPSDBServerBase = null;
    private boolean backupmodeDirtyFlag = false;
    private boolean bakdbpasswdDirtyFlag = false;
    private boolean bakdbportDirtyFlag = false;
    private boolean bakdburlDirtyFlag = false;
    private boolean bakdbusernameDirtyFlag = false;
    private boolean bakipaddrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbinstallpathDirtyFlag = false;
    private boolean dbpasswdDirtyFlag = false;
    private boolean dbportDirtyFlag = false;
    private boolean dbrootDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean dburlDirtyFlag = false;
    private boolean dbusernameDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psdbserveridDirtyFlag = false;
    private boolean psdbservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="backupmode")
    private Integer backupmode;
    @Column(name="bakdbpasswd")
    private String bakdbpasswd;
    @Column(name="bakdbport")
    private Integer bakdbport;
    @Column(name="bakdburl")
    private String bakdburl;
    @Column(name="bakdbusername")
    private String bakdbusername;
    @Column(name="bakipaddr")
    private String bakipaddr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbinstallpath")
    private String dbinstallpath;
    @Column(name="dbpasswd")
    private String dbpasswd;
    @Column(name="dbport")
    private Integer dbport;
    @Column(name="dbroot")
    private String dbroot;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="dburl")
    private String dburl;
    @Column(name="dbusername")
    private String dbusername;
    @Column(name="enable")
    private Integer enable;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psdbserverid")
    private String psdbserverid;
    @Column(name="psdbservername")
    private String psdbservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
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
    private Integer objPSAppServerLock = new Integer(1);
    private PSAppServer psappserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setBackupMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupMode(n);
            return;
        }
        this.backupmode = n;
        this.backupmodeDirtyFlag = true;
    }

    public Integer getBackupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupMode();
        }
        return this.backupmode;
    }

    public boolean isBackupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupModeDirty();
        }
        return this.backupmodeDirtyFlag;
    }

    public void resetBackupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupMode();
            return;
        }
        this.backupmodeDirtyFlag = false;
        this.backupmode = null;
    }

    public void setBakDBPassWD(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBakDBPassWD(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bakdbpasswd = string;
        this.bakdbpasswdDirtyFlag = true;
    }

    public String getBakDBPassWD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBakDBPassWD();
        }
        return this.bakdbpasswd;
    }

    public boolean isBakDBPassWDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBakDBPassWDDirty();
        }
        return this.bakdbpasswdDirtyFlag;
    }

    public void resetBakDBPassWD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBakDBPassWD();
            return;
        }
        this.bakdbpasswdDirtyFlag = false;
        this.bakdbpasswd = null;
    }

    public void setBakDBPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBakDBPort(n);
            return;
        }
        this.bakdbport = n;
        this.bakdbportDirtyFlag = true;
    }

    public Integer getBakDBPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBakDBPort();
        }
        return this.bakdbport;
    }

    public boolean isBakDBPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBakDBPortDirty();
        }
        return this.bakdbportDirtyFlag;
    }

    public void resetBakDBPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBakDBPort();
            return;
        }
        this.bakdbportDirtyFlag = false;
        this.bakdbport = null;
    }

    public void setBakDBUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBakDBUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bakdburl = string;
        this.bakdburlDirtyFlag = true;
    }

    public String getBakDBUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBakDBUrl();
        }
        return this.bakdburl;
    }

    public boolean isBakDBUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBakDBUrlDirty();
        }
        return this.bakdburlDirtyFlag;
    }

    public void resetBakDBUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBakDBUrl();
            return;
        }
        this.bakdburlDirtyFlag = false;
        this.bakdburl = null;
    }

    public void setBakDBUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBakDBUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bakdbusername = string;
        this.bakdbusernameDirtyFlag = true;
    }

    public String getBakDBUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBakDBUserName();
        }
        return this.bakdbusername;
    }

    public boolean isBakDBUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBakDBUserNameDirty();
        }
        return this.bakdbusernameDirtyFlag;
    }

    public void resetBakDBUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBakDBUserName();
            return;
        }
        this.bakdbusernameDirtyFlag = false;
        this.bakdbusername = null;
    }

    public void setBakIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBakIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bakipaddr = string;
        this.bakipaddrDirtyFlag = true;
    }

    public String getBakIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBakIPAddr();
        }
        return this.bakipaddr;
    }

    public boolean isBakIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBakIPAddrDirty();
        }
        return this.bakipaddrDirtyFlag;
    }

    public void resetBakIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBakIPAddr();
            return;
        }
        this.bakipaddrDirtyFlag = false;
        this.bakipaddr = null;
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

    public void setDBInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbinstallpath = string;
        this.dbinstallpathDirtyFlag = true;
    }

    public String getDBInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBInstallPath();
        }
        return this.dbinstallpath;
    }

    public boolean isDBInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBInstallPathDirty();
        }
        return this.dbinstallpathDirtyFlag;
    }

    public void resetDBInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBInstallPath();
            return;
        }
        this.dbinstallpathDirtyFlag = false;
        this.dbinstallpath = null;
    }

    public void setDBPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbpasswd = string;
        this.dbpasswdDirtyFlag = true;
    }

    public String getDBPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBPasswd();
        }
        return this.dbpasswd;
    }

    public boolean isDBPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBPasswdDirty();
        }
        return this.dbpasswdDirtyFlag;
    }

    public void resetDBPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBPasswd();
            return;
        }
        this.dbpasswdDirtyFlag = false;
        this.dbpasswd = null;
    }

    public void setDBPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBPort(n);
            return;
        }
        this.dbport = n;
        this.dbportDirtyFlag = true;
    }

    public Integer getDBPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBPort();
        }
        return this.dbport;
    }

    public boolean isDBPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBPortDirty();
        }
        return this.dbportDirtyFlag;
    }

    public void resetDBPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBPort();
            return;
        }
        this.dbportDirtyFlag = false;
        this.dbport = null;
    }

    public void setDBRoot(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBRoot(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbroot = string;
        this.dbrootDirtyFlag = true;
    }

    public String getDBRoot() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBRoot();
        }
        return this.dbroot;
    }

    public boolean isDBRootDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBRootDirty();
        }
        return this.dbrootDirtyFlag;
    }

    public void resetDBRoot() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBRoot();
            return;
        }
        this.dbrootDirtyFlag = false;
        this.dbroot = null;
    }

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
    }

    public void setDBUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dburl = string;
        this.dburlDirtyFlag = true;
    }

    public String getDBUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBUrl();
        }
        return this.dburl;
    }

    public boolean isDBUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBUrlDirty();
        }
        return this.dburlDirtyFlag;
    }

    public void resetDBUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBUrl();
            return;
        }
        this.dburlDirtyFlag = false;
        this.dburl = null;
    }

    public void setDBUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbusername = string;
        this.dbusernameDirtyFlag = true;
    }

    public String getDBUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBUserName();
        }
        return this.dbusername;
    }

    public boolean isDBUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBUserNameDirty();
        }
        return this.dbusernameDirtyFlag;
    }

    public void resetDBUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBUserName();
            return;
        }
        this.dbusernameDirtyFlag = false;
        this.dbusername = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSDBServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbserverid = string;
        this.psdbserveridDirtyFlag = true;
    }

    public String getPSDBServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerId();
        }
        return this.psdbserverid;
    }

    public boolean isPSDBServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerIdDirty();
        }
        return this.psdbserveridDirtyFlag;
    }

    public void resetPSDBServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerId();
            return;
        }
        this.psdbserveridDirtyFlag = false;
        this.psdbserverid = null;
    }

    public void setPSDBServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbservername = string;
        this.psdbservernameDirtyFlag = true;
    }

    public String getPSDBServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerName();
        }
        return this.psdbservername;
    }

    public boolean isPSDBServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerNameDirty();
        }
        return this.psdbservernameDirtyFlag;
    }

    public void resetPSDBServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerName();
            return;
        }
        this.psdbservernameDirtyFlag = false;
        this.psdbservername = null;
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

    protected void onReset() {
        PSDBServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBServerBase pSDBServerBase) {
        pSDBServerBase.resetBackupMode();
        pSDBServerBase.resetBakDBPassWD();
        pSDBServerBase.resetBakDBPort();
        pSDBServerBase.resetBakDBUrl();
        pSDBServerBase.resetBakDBUserName();
        pSDBServerBase.resetBakIPAddr();
        pSDBServerBase.resetCreateDate();
        pSDBServerBase.resetCreateMan();
        pSDBServerBase.resetDBInstallPath();
        pSDBServerBase.resetDBPasswd();
        pSDBServerBase.resetDBPort();
        pSDBServerBase.resetDBRoot();
        pSDBServerBase.resetDBType();
        pSDBServerBase.resetDBUrl();
        pSDBServerBase.resetDBUserName();
        pSDBServerBase.resetEnable();
        pSDBServerBase.resetIPAddr();
        pSDBServerBase.resetLocalRes();
        pSDBServerBase.resetMemo();
        pSDBServerBase.resetPasswd();
        pSDBServerBase.resetPort();
        pSDBServerBase.resetPSAppServerId();
        pSDBServerBase.resetPSAppServerName();
        pSDBServerBase.resetPSDBServerId();
        pSDBServerBase.resetPSDBServerName();
        pSDBServerBase.resetPSSvrDomainId();
        pSDBServerBase.resetPSSvrDomainName();
        pSDBServerBase.resetUpdateDate();
        pSDBServerBase.resetUpdateMan();
        pSDBServerBase.resetUploadFileMode();
        pSDBServerBase.resetUploadPath();
        pSDBServerBase.resetUserName();
        pSDBServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupModeDirty()) {
            hashMap.put(FIELD_BACKUPMODE, this.getBackupMode());
        }
        if (!bl || this.isBakDBPassWDDirty()) {
            hashMap.put(FIELD_BAKDBPASSWD, this.getBakDBPassWD());
        }
        if (!bl || this.isBakDBPortDirty()) {
            hashMap.put(FIELD_BAKDBPORT, this.getBakDBPort());
        }
        if (!bl || this.isBakDBUrlDirty()) {
            hashMap.put(FIELD_BAKDBURL, this.getBakDBUrl());
        }
        if (!bl || this.isBakDBUserNameDirty()) {
            hashMap.put(FIELD_BAKDBUSERNAME, this.getBakDBUserName());
        }
        if (!bl || this.isBakIPAddrDirty()) {
            hashMap.put(FIELD_BAKIPADDR, this.getBakIPAddr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBInstallPathDirty()) {
            hashMap.put(FIELD_DBINSTALLPATH, this.getDBInstallPath());
        }
        if (!bl || this.isDBPasswdDirty()) {
            hashMap.put(FIELD_DBPASSWD, this.getDBPasswd());
        }
        if (!bl || this.isDBPortDirty()) {
            hashMap.put(FIELD_DBPORT, this.getDBPort());
        }
        if (!bl || this.isDBRootDirty()) {
            hashMap.put(FIELD_DBROOT, this.getDBRoot());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isDBUrlDirty()) {
            hashMap.put(FIELD_DBURL, this.getDBUrl());
        }
        if (!bl || this.isDBUserNameDirty()) {
            hashMap.put(FIELD_DBUSERNAME, this.getDBUserName());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
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
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSDBServerIdDirty()) {
            hashMap.put(FIELD_PSDBSERVERID, this.getPSDBServerId());
        }
        if (!bl || this.isPSDBServerNameDirty()) {
            hashMap.put(FIELD_PSDBSERVERNAME, this.getPSDBServerName());
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
        return PSDBServerBase.get(this, n);
    }

    private static Object get(PSDBServerBase pSDBServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBServerBase.getBackupMode();
            }
            case 1: {
                return pSDBServerBase.getBakDBPassWD();
            }
            case 2: {
                return pSDBServerBase.getBakDBPort();
            }
            case 3: {
                return pSDBServerBase.getBakDBUrl();
            }
            case 4: {
                return pSDBServerBase.getBakDBUserName();
            }
            case 5: {
                return pSDBServerBase.getBakIPAddr();
            }
            case 6: {
                return pSDBServerBase.getCreateDate();
            }
            case 7: {
                return pSDBServerBase.getCreateMan();
            }
            case 8: {
                return pSDBServerBase.getDBInstallPath();
            }
            case 9: {
                return pSDBServerBase.getDBPasswd();
            }
            case 10: {
                return pSDBServerBase.getDBPort();
            }
            case 11: {
                return pSDBServerBase.getDBRoot();
            }
            case 12: {
                return pSDBServerBase.getDBType();
            }
            case 13: {
                return pSDBServerBase.getDBUrl();
            }
            case 14: {
                return pSDBServerBase.getDBUserName();
            }
            case 15: {
                return pSDBServerBase.getEnable();
            }
            case 16: {
                return pSDBServerBase.getIPAddr();
            }
            case 17: {
                return pSDBServerBase.getLocalRes();
            }
            case 18: {
                return pSDBServerBase.getMemo();
            }
            case 19: {
                return pSDBServerBase.getPasswd();
            }
            case 20: {
                return pSDBServerBase.getPort();
            }
            case 21: {
                return pSDBServerBase.getPSAppServerId();
            }
            case 22: {
                return pSDBServerBase.getPSAppServerName();
            }
            case 23: {
                return pSDBServerBase.getPSDBServerId();
            }
            case 24: {
                return pSDBServerBase.getPSDBServerName();
            }
            case 25: {
                return pSDBServerBase.getPSSvrDomainId();
            }
            case 26: {
                return pSDBServerBase.getPSSvrDomainName();
            }
            case 27: {
                return pSDBServerBase.getUpdateDate();
            }
            case 28: {
                return pSDBServerBase.getUpdateMan();
            }
            case 29: {
                return pSDBServerBase.getUploadFileMode();
            }
            case 30: {
                return pSDBServerBase.getUploadPath();
            }
            case 31: {
                return pSDBServerBase.getUserName();
            }
            case 32: {
                return pSDBServerBase.getValidFlag();
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
        PSDBServerBase.set(this, n, object);
    }

    private static void set(PSDBServerBase pSDBServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBServerBase.setBackupMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDBServerBase.setBakDBPassWD(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBServerBase.setBakDBPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDBServerBase.setBakDBUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBServerBase.setBakDBUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBServerBase.setBakIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDBServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBServerBase.setDBInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBServerBase.setDBPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBServerBase.setDBPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDBServerBase.setDBRoot(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDBServerBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDBServerBase.setDBUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDBServerBase.setDBUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDBServerBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDBServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDBServerBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDBServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDBServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDBServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDBServerBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDBServerBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDBServerBase.setPSDBServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDBServerBase.setPSDBServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDBServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDBServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDBServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDBServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDBServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDBServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDBServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDBServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDBServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDBServerBase pSDBServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBServerBase.getBackupMode() == null;
            }
            case 1: {
                return pSDBServerBase.getBakDBPassWD() == null;
            }
            case 2: {
                return pSDBServerBase.getBakDBPort() == null;
            }
            case 3: {
                return pSDBServerBase.getBakDBUrl() == null;
            }
            case 4: {
                return pSDBServerBase.getBakDBUserName() == null;
            }
            case 5: {
                return pSDBServerBase.getBakIPAddr() == null;
            }
            case 6: {
                return pSDBServerBase.getCreateDate() == null;
            }
            case 7: {
                return pSDBServerBase.getCreateMan() == null;
            }
            case 8: {
                return pSDBServerBase.getDBInstallPath() == null;
            }
            case 9: {
                return pSDBServerBase.getDBPasswd() == null;
            }
            case 10: {
                return pSDBServerBase.getDBPort() == null;
            }
            case 11: {
                return pSDBServerBase.getDBRoot() == null;
            }
            case 12: {
                return pSDBServerBase.getDBType() == null;
            }
            case 13: {
                return pSDBServerBase.getDBUrl() == null;
            }
            case 14: {
                return pSDBServerBase.getDBUserName() == null;
            }
            case 15: {
                return pSDBServerBase.getEnable() == null;
            }
            case 16: {
                return pSDBServerBase.getIPAddr() == null;
            }
            case 17: {
                return pSDBServerBase.getLocalRes() == null;
            }
            case 18: {
                return pSDBServerBase.getMemo() == null;
            }
            case 19: {
                return pSDBServerBase.getPasswd() == null;
            }
            case 20: {
                return pSDBServerBase.getPort() == null;
            }
            case 21: {
                return pSDBServerBase.getPSAppServerId() == null;
            }
            case 22: {
                return pSDBServerBase.getPSAppServerName() == null;
            }
            case 23: {
                return pSDBServerBase.getPSDBServerId() == null;
            }
            case 24: {
                return pSDBServerBase.getPSDBServerName() == null;
            }
            case 25: {
                return pSDBServerBase.getPSSvrDomainId() == null;
            }
            case 26: {
                return pSDBServerBase.getPSSvrDomainName() == null;
            }
            case 27: {
                return pSDBServerBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDBServerBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDBServerBase.getUploadFileMode() == null;
            }
            case 30: {
                return pSDBServerBase.getUploadPath() == null;
            }
            case 31: {
                return pSDBServerBase.getUserName() == null;
            }
            case 32: {
                return pSDBServerBase.getValidFlag() == null;
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
        return PSDBServerBase.contains(this, n);
    }

    private static boolean contains(PSDBServerBase pSDBServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBServerBase.isBackupModeDirty();
            }
            case 1: {
                return pSDBServerBase.isBakDBPassWDDirty();
            }
            case 2: {
                return pSDBServerBase.isBakDBPortDirty();
            }
            case 3: {
                return pSDBServerBase.isBakDBUrlDirty();
            }
            case 4: {
                return pSDBServerBase.isBakDBUserNameDirty();
            }
            case 5: {
                return pSDBServerBase.isBakIPAddrDirty();
            }
            case 6: {
                return pSDBServerBase.isCreateDateDirty();
            }
            case 7: {
                return pSDBServerBase.isCreateManDirty();
            }
            case 8: {
                return pSDBServerBase.isDBInstallPathDirty();
            }
            case 9: {
                return pSDBServerBase.isDBPasswdDirty();
            }
            case 10: {
                return pSDBServerBase.isDBPortDirty();
            }
            case 11: {
                return pSDBServerBase.isDBRootDirty();
            }
            case 12: {
                return pSDBServerBase.isDBTypeDirty();
            }
            case 13: {
                return pSDBServerBase.isDBUrlDirty();
            }
            case 14: {
                return pSDBServerBase.isDBUserNameDirty();
            }
            case 15: {
                return pSDBServerBase.isEnableDirty();
            }
            case 16: {
                return pSDBServerBase.isIPAddrDirty();
            }
            case 17: {
                return pSDBServerBase.isLocalResDirty();
            }
            case 18: {
                return pSDBServerBase.isMemoDirty();
            }
            case 19: {
                return pSDBServerBase.isPasswdDirty();
            }
            case 20: {
                return pSDBServerBase.isPortDirty();
            }
            case 21: {
                return pSDBServerBase.isPSAppServerIdDirty();
            }
            case 22: {
                return pSDBServerBase.isPSAppServerNameDirty();
            }
            case 23: {
                return pSDBServerBase.isPSDBServerIdDirty();
            }
            case 24: {
                return pSDBServerBase.isPSDBServerNameDirty();
            }
            case 25: {
                return pSDBServerBase.isPSSvrDomainIdDirty();
            }
            case 26: {
                return pSDBServerBase.isPSSvrDomainNameDirty();
            }
            case 27: {
                return pSDBServerBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDBServerBase.isUpdateManDirty();
            }
            case 29: {
                return pSDBServerBase.isUploadFileModeDirty();
            }
            case 30: {
                return pSDBServerBase.isUploadPathDirty();
            }
            case 31: {
                return pSDBServerBase.isUserNameDirty();
            }
            case 32: {
                return pSDBServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBServerBase pSDBServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBServerBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupmode", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDBServerBase.getBakDBPassWD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bakdbpasswd", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBakDBPassWD()), (boolean)false);
        }
        if (bl || pSDBServerBase.getBakDBPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bakdbport", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBakDBPort()), (boolean)false);
        }
        if (bl || pSDBServerBase.getBakDBUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bakdburl", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBakDBUrl()), (boolean)false);
        }
        if (bl || pSDBServerBase.getBakDBUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bakdbusername", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBakDBUserName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getBakIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bakipaddr", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getBakIPAddr()), (boolean)false);
        }
        if (bl || pSDBServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbinstallpath", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBInstallPath()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbpasswd", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBPasswd()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbport", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBPort()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBRoot() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbroot", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBRoot()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBType()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dburl", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBUrl()), (boolean)false);
        }
        if (bl || pSDBServerBase.getDBUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbusername", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getDBUserName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getEnable()), (boolean)false);
        }
        if (bl || pSDBServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSDBServerBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSDBServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPort()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSDBServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbserverid", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSDBServerId()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSDBServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbservername", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSDBServerName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDBServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDBServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDBServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSDBServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDBServerBase.getJSONValue((Object)pSDBServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBServerBase pSDBServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBServerBase.getBackupMode() != null) {
            object = pSDBServerBase.getBackupMode();
            xmlNode.setAttribute(FIELD_BACKUPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getBakDBPassWD() != null) {
            object = pSDBServerBase.getBakDBPassWD();
            xmlNode.setAttribute(FIELD_BAKDBPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getBakDBPort() != null) {
            object = pSDBServerBase.getBakDBPort();
            xmlNode.setAttribute(FIELD_BAKDBPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getBakDBUrl() != null) {
            object = pSDBServerBase.getBakDBUrl();
            xmlNode.setAttribute(FIELD_BAKDBURL, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getBakDBUserName() != null) {
            object = pSDBServerBase.getBakDBUserName();
            xmlNode.setAttribute(FIELD_BAKDBUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getBakIPAddr() != null) {
            object = pSDBServerBase.getBakIPAddr();
            xmlNode.setAttribute(FIELD_BAKIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getCreateDate() != null) {
            object = pSDBServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBServerBase.getCreateMan() != null) {
            object = pSDBServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBInstallPath() != null) {
            object = pSDBServerBase.getDBInstallPath();
            xmlNode.setAttribute(FIELD_DBINSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBPasswd() != null) {
            object = pSDBServerBase.getDBPasswd();
            xmlNode.setAttribute(FIELD_DBPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBPort() != null) {
            object = pSDBServerBase.getDBPort();
            xmlNode.setAttribute(FIELD_DBPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getDBRoot() != null) {
            object = pSDBServerBase.getDBRoot();
            xmlNode.setAttribute(FIELD_DBROOT, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBType() != null) {
            object = pSDBServerBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBUrl() != null) {
            object = pSDBServerBase.getDBUrl();
            xmlNode.setAttribute(FIELD_DBURL, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getDBUserName() != null) {
            object = pSDBServerBase.getDBUserName();
            xmlNode.setAttribute(FIELD_DBUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getEnable() != null) {
            object = pSDBServerBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getIPAddr() != null) {
            object = pSDBServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getLocalRes() != null) {
            object = pSDBServerBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getMemo() != null) {
            object = pSDBServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPasswd() != null) {
            object = pSDBServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPort() != null) {
            object = pSDBServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBServerBase.getPSAppServerId() != null) {
            object = pSDBServerBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPSAppServerName() != null) {
            object = pSDBServerBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPSDBServerId() != null) {
            object = pSDBServerBase.getPSDBServerId();
            xmlNode.setAttribute(FIELD_PSDBSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPSDBServerName() != null) {
            object = pSDBServerBase.getPSDBServerName();
            xmlNode.setAttribute(FIELD_PSDBSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPSSvrDomainId() != null) {
            object = pSDBServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getPSSvrDomainName() != null) {
            object = pSDBServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getUpdateDate() != null) {
            object = pSDBServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBServerBase.getUpdateMan() != null) {
            object = pSDBServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getUploadFileMode() != null) {
            object = pSDBServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getUploadPath() != null) {
            object = pSDBServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getUserName() != null) {
            object = pSDBServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBServerBase.getValidFlag() != null) {
            object = pSDBServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBServerBase pSDBServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBServerBase.isBackupModeDirty() && (bl || pSDBServerBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDBServerBase.getBackupMode());
        }
        if (pSDBServerBase.isBakDBPassWDDirty() && (bl || pSDBServerBase.getBakDBPassWD() != null)) {
            iDataObject.set(FIELD_BAKDBPASSWD, (Object)pSDBServerBase.getBakDBPassWD());
        }
        if (pSDBServerBase.isBakDBPortDirty() && (bl || pSDBServerBase.getBakDBPort() != null)) {
            iDataObject.set(FIELD_BAKDBPORT, (Object)pSDBServerBase.getBakDBPort());
        }
        if (pSDBServerBase.isBakDBUrlDirty() && (bl || pSDBServerBase.getBakDBUrl() != null)) {
            iDataObject.set(FIELD_BAKDBURL, (Object)pSDBServerBase.getBakDBUrl());
        }
        if (pSDBServerBase.isBakDBUserNameDirty() && (bl || pSDBServerBase.getBakDBUserName() != null)) {
            iDataObject.set(FIELD_BAKDBUSERNAME, (Object)pSDBServerBase.getBakDBUserName());
        }
        if (pSDBServerBase.isBakIPAddrDirty() && (bl || pSDBServerBase.getBakIPAddr() != null)) {
            iDataObject.set(FIELD_BAKIPADDR, (Object)pSDBServerBase.getBakIPAddr());
        }
        if (pSDBServerBase.isCreateDateDirty() && (bl || pSDBServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBServerBase.getCreateDate());
        }
        if (pSDBServerBase.isCreateManDirty() && (bl || pSDBServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBServerBase.getCreateMan());
        }
        if (pSDBServerBase.isDBInstallPathDirty() && (bl || pSDBServerBase.getDBInstallPath() != null)) {
            iDataObject.set(FIELD_DBINSTALLPATH, (Object)pSDBServerBase.getDBInstallPath());
        }
        if (pSDBServerBase.isDBPasswdDirty() && (bl || pSDBServerBase.getDBPasswd() != null)) {
            iDataObject.set(FIELD_DBPASSWD, (Object)pSDBServerBase.getDBPasswd());
        }
        if (pSDBServerBase.isDBPortDirty() && (bl || pSDBServerBase.getDBPort() != null)) {
            iDataObject.set(FIELD_DBPORT, (Object)pSDBServerBase.getDBPort());
        }
        if (pSDBServerBase.isDBRootDirty() && (bl || pSDBServerBase.getDBRoot() != null)) {
            iDataObject.set(FIELD_DBROOT, (Object)pSDBServerBase.getDBRoot());
        }
        if (pSDBServerBase.isDBTypeDirty() && (bl || pSDBServerBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDBServerBase.getDBType());
        }
        if (pSDBServerBase.isDBUrlDirty() && (bl || pSDBServerBase.getDBUrl() != null)) {
            iDataObject.set(FIELD_DBURL, (Object)pSDBServerBase.getDBUrl());
        }
        if (pSDBServerBase.isDBUserNameDirty() && (bl || pSDBServerBase.getDBUserName() != null)) {
            iDataObject.set(FIELD_DBUSERNAME, (Object)pSDBServerBase.getDBUserName());
        }
        if (pSDBServerBase.isEnableDirty() && (bl || pSDBServerBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDBServerBase.getEnable());
        }
        if (pSDBServerBase.isIPAddrDirty() && (bl || pSDBServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDBServerBase.getIPAddr());
        }
        if (pSDBServerBase.isLocalResDirty() && (bl || pSDBServerBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSDBServerBase.getLocalRes());
        }
        if (pSDBServerBase.isMemoDirty() && (bl || pSDBServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBServerBase.getMemo());
        }
        if (pSDBServerBase.isPasswdDirty() && (bl || pSDBServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDBServerBase.getPasswd());
        }
        if (pSDBServerBase.isPortDirty() && (bl || pSDBServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDBServerBase.getPort());
        }
        if (pSDBServerBase.isPSAppServerIdDirty() && (bl || pSDBServerBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSDBServerBase.getPSAppServerId());
        }
        if (pSDBServerBase.isPSAppServerNameDirty() && (bl || pSDBServerBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSDBServerBase.getPSAppServerName());
        }
        if (pSDBServerBase.isPSDBServerIdDirty() && (bl || pSDBServerBase.getPSDBServerId() != null)) {
            iDataObject.set(FIELD_PSDBSERVERID, (Object)pSDBServerBase.getPSDBServerId());
        }
        if (pSDBServerBase.isPSDBServerNameDirty() && (bl || pSDBServerBase.getPSDBServerName() != null)) {
            iDataObject.set(FIELD_PSDBSERVERNAME, (Object)pSDBServerBase.getPSDBServerName());
        }
        if (pSDBServerBase.isPSSvrDomainIdDirty() && (bl || pSDBServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDBServerBase.getPSSvrDomainId());
        }
        if (pSDBServerBase.isPSSvrDomainNameDirty() && (bl || pSDBServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDBServerBase.getPSSvrDomainName());
        }
        if (pSDBServerBase.isUpdateDateDirty() && (bl || pSDBServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBServerBase.getUpdateDate());
        }
        if (pSDBServerBase.isUpdateManDirty() && (bl || pSDBServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBServerBase.getUpdateMan());
        }
        if (pSDBServerBase.isUploadFileModeDirty() && (bl || pSDBServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDBServerBase.getUploadFileMode());
        }
        if (pSDBServerBase.isUploadPathDirty() && (bl || pSDBServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDBServerBase.getUploadPath());
        }
        if (pSDBServerBase.isUserNameDirty() && (bl || pSDBServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDBServerBase.getUserName());
        }
        if (pSDBServerBase.isValidFlagDirty() && (bl || pSDBServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDBServerBase.getValidFlag());
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
        return PSDBServerBase.remove(this, n);
    }

    private static boolean remove(PSDBServerBase pSDBServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBServerBase.resetBackupMode();
                return true;
            }
            case 1: {
                pSDBServerBase.resetBakDBPassWD();
                return true;
            }
            case 2: {
                pSDBServerBase.resetBakDBPort();
                return true;
            }
            case 3: {
                pSDBServerBase.resetBakDBUrl();
                return true;
            }
            case 4: {
                pSDBServerBase.resetBakDBUserName();
                return true;
            }
            case 5: {
                pSDBServerBase.resetBakIPAddr();
                return true;
            }
            case 6: {
                pSDBServerBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDBServerBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDBServerBase.resetDBInstallPath();
                return true;
            }
            case 9: {
                pSDBServerBase.resetDBPasswd();
                return true;
            }
            case 10: {
                pSDBServerBase.resetDBPort();
                return true;
            }
            case 11: {
                pSDBServerBase.resetDBRoot();
                return true;
            }
            case 12: {
                pSDBServerBase.resetDBType();
                return true;
            }
            case 13: {
                pSDBServerBase.resetDBUrl();
                return true;
            }
            case 14: {
                pSDBServerBase.resetDBUserName();
                return true;
            }
            case 15: {
                pSDBServerBase.resetEnable();
                return true;
            }
            case 16: {
                pSDBServerBase.resetIPAddr();
                return true;
            }
            case 17: {
                pSDBServerBase.resetLocalRes();
                return true;
            }
            case 18: {
                pSDBServerBase.resetMemo();
                return true;
            }
            case 19: {
                pSDBServerBase.resetPasswd();
                return true;
            }
            case 20: {
                pSDBServerBase.resetPort();
                return true;
            }
            case 21: {
                pSDBServerBase.resetPSAppServerId();
                return true;
            }
            case 22: {
                pSDBServerBase.resetPSAppServerName();
                return true;
            }
            case 23: {
                pSDBServerBase.resetPSDBServerId();
                return true;
            }
            case 24: {
                pSDBServerBase.resetPSDBServerName();
                return true;
            }
            case 25: {
                pSDBServerBase.resetPSSvrDomainId();
                return true;
            }
            case 26: {
                pSDBServerBase.resetPSSvrDomainName();
                return true;
            }
            case 27: {
                pSDBServerBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDBServerBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDBServerBase.resetUploadFileMode();
                return true;
            }
            case 30: {
                pSDBServerBase.resetUploadPath();
                return true;
            }
            case 31: {
                pSDBServerBase.resetUserName();
                return true;
            }
            case 32: {
                pSDBServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppServer getPSAppServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServer();
        }
        if (this.getPSAppServerId() == null) {
            return null;
        }
        Integer n = this.objPSAppServerLock;
        synchronized (n) {
            if (this.psappserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppServerId(), (Object)this.psappserver.getPSAppServerId()) != 0L) {
                this.psappserver = null;
            }
            if (this.psappserver == null) {
                PSAppServer pSAppServer = new PSAppServer();
                pSAppServer.setPSAppServerId(this.getPSAppServerId());
                PSAppServerService pSAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
                pSAppServerService.autoGet((IEntity)pSAppServer);
                this.psappserver = pSAppServer;
            }
            return this.psappserver;
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

    private PSDBServerBase getProxyEntity() {
        return this.proxyPSDBServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBServerBase) {
            this.proxyPSDBServerBase = (PSDBServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPMODE, 0);
        fieldIndexMap.put(FIELD_BAKDBPASSWD, 1);
        fieldIndexMap.put(FIELD_BAKDBPORT, 2);
        fieldIndexMap.put(FIELD_BAKDBURL, 3);
        fieldIndexMap.put(FIELD_BAKDBUSERNAME, 4);
        fieldIndexMap.put(FIELD_BAKIPADDR, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DBINSTALLPATH, 8);
        fieldIndexMap.put(FIELD_DBPASSWD, 9);
        fieldIndexMap.put(FIELD_DBPORT, 10);
        fieldIndexMap.put(FIELD_DBROOT, 11);
        fieldIndexMap.put(FIELD_DBTYPE, 12);
        fieldIndexMap.put(FIELD_DBURL, 13);
        fieldIndexMap.put(FIELD_DBUSERNAME, 14);
        fieldIndexMap.put(FIELD_ENABLE, 15);
        fieldIndexMap.put(FIELD_IPADDR, 16);
        fieldIndexMap.put(FIELD_LOCALRES, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PASSWD, 19);
        fieldIndexMap.put(FIELD_PORT, 20);
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 21);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 22);
        fieldIndexMap.put(FIELD_PSDBSERVERID, 23);
        fieldIndexMap.put(FIELD_PSDBSERVERNAME, 24);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 25);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 29);
        fieldIndexMap.put(FIELD_UPLOADPATH, 30);
        fieldIndexMap.put(FIELD_USERNAME, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

