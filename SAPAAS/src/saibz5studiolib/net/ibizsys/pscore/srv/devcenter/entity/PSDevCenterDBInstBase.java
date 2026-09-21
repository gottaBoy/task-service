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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterDBInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterDBInstBase.class);
    public static final String FIELD_ALLOCSIZE = "ALLOCSIZE";
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURDBACTION = "CURDBACTION";
    public static final String FIELD_DBINSTALLPATH = "DBINSTALLPATH";
    public static final String FIELD_DBNAME = "DBNAME";
    public static final String FIELD_DBPORT = "DBPORT";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_DCINSTSTATE = "DCINSTSTATE";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HOSTADDRESS = "HOSTADDRESS";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTPORT = "HOSTPORT";
    public static final String FIELD_HOSTSSHPORT = "HOSTSSHPORT";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_LOCKMODE = "LOCKMODE";
    public static final String FIELD_LOCKOBJID = "LOCKOBJID";
    public static final String FIELD_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String FIELD_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_SYSMEMO = "SYSMEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USEDSIZE = "USEDSIZE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ALLOCSIZE = 0;
    private static final int INDEX_CONNSTR = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CURDBACTION = 4;
    private static final int INDEX_DBINSTALLPATH = 5;
    private static final int INDEX_DBNAME = 6;
    private static final int INDEX_DBPORT = 7;
    private static final int INDEX_DBTYPE = 8;
    private static final int INDEX_DCINSTSTATE = 9;
    private static final int INDEX_EXPRIEDTIME = 10;
    private static final int INDEX_HOSTADDRESS = 11;
    private static final int INDEX_HOSTPASSWD = 12;
    private static final int INDEX_HOSTPORT = 13;
    private static final int INDEX_HOSTSSHPORT = 14;
    private static final int INDEX_HOSTUSERNAME = 15;
    private static final int INDEX_LOCKMODE = 16;
    private static final int INDEX_LOCKOBJID = 17;
    private static final int INDEX_LOCKOBJTYPE = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_PASSWD = 20;
    private static final int INDEX_PSDBDEVINSTID = 21;
    private static final int INDEX_PSDBDEVINSTNAME = 22;
    private static final int INDEX_PSDCCLUSTERID = 23;
    private static final int INDEX_PSDCCLUSTERNAME = 24;
    private static final int INDEX_PSDCCONTAINERSPECID = 25;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 26;
    private static final int INDEX_PSDCFILEID = 27;
    private static final int INDEX_PSDCFILENAME = 28;
    private static final int INDEX_PSDEVCENTERASID = 29;
    private static final int INDEX_PSDEVCENTERASNAME = 30;
    private static final int INDEX_PSDEVCENTERDBINSTID = 31;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 32;
    private static final int INDEX_PSDEVCENTERID = 33;
    private static final int INDEX_PSDEVCENTERNAME = 34;
    private static final int INDEX_PSDEVSLNID = 35;
    private static final int INDEX_PSDEVSLNNAME = 36;
    private static final int INDEX_REFCOUNT = 37;
    private static final int INDEX_REFINFO = 38;
    private static final int INDEX_RESPOS = 39;
    private static final int INDEX_RESREADYTIME = 40;
    private static final int INDEX_RESSTATE = 41;
    private static final int INDEX_RESVER = 42;
    private static final int INDEX_SYSMEMO = 43;
    private static final int INDEX_UPDATEDATE = 44;
    private static final int INDEX_UPDATEMAN = 45;
    private static final int INDEX_UPLOADFILEMODE = 46;
    private static final int INDEX_UPLOADPATH = 47;
    private static final int INDEX_USAGEMODE = 48;
    private static final int INDEX_USEDSIZE = 49;
    private static final int INDEX_USERNAME = 50;
    private static final int INDEX_USERPARAMS = 51;
    private static final int INDEX_USERTAG = 52;
    private static final int INDEX_USERTAG2 = 53;
    private static final int INDEX_USERTAG3 = 54;
    private static final int INDEX_USERTAG4 = 55;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterDBInstBase proxyPSDevCenterDBInstBase = null;
    private boolean allocsizeDirtyFlag = false;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curdbactionDirtyFlag = false;
    private boolean dbinstallpathDirtyFlag = false;
    private boolean dbnameDirtyFlag = false;
    private boolean dbportDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean dcinststateDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean hostaddressDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostportDirtyFlag = false;
    private boolean hostsshportDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean lockmodeDirtyFlag = false;
    private boolean lockobjidDirtyFlag = false;
    private boolean lockobjtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdbdevinstidDirtyFlag = false;
    private boolean psdbdevinstnameDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean sysmemoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usedsizeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="allocsize")
    private Integer allocsize;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curdbaction")
    private String curdbaction;
    @Column(name="dbinstallpath")
    private String dbinstallpath;
    @Column(name="dbname")
    private String dbname;
    @Column(name="dbport")
    private Integer dbport;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="dcinststate")
    private Integer dcinststate;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="hostaddress")
    private String hostaddress;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostport")
    private Integer hostport;
    @Column(name="hostsshport")
    private Integer hostsshport;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="lockmode")
    private Integer lockmode;
    @Column(name="lockobjid")
    private String lockobjid;
    @Column(name="lockobjtype")
    private String lockobjtype;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdbdevinstid")
    private String psdbdevinstid;
    @Column(name="psdbdevinstname")
    private String psdbdevinstname;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="sysmemo")
    private String sysmemo;
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
    @Column(name="usedsize")
    private Integer usedsize;
    @Column(name="username")
    private String username;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDBDevInstLock = new Integer(1);
    private PSDBDevInst psdbdevinst = null;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setAllocSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllocSize(n);
            return;
        }
        this.allocsize = n;
        this.allocsizeDirtyFlag = true;
    }

    public Integer getAllocSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllocSize();
        }
        return this.allocsize;
    }

    public boolean isAllocSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllocSizeDirty();
        }
        return this.allocsizeDirtyFlag;
    }

    public void resetAllocSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllocSize();
            return;
        }
        this.allocsizeDirtyFlag = false;
        this.allocsize = null;
    }

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setCurDBAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurDBAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curdbaction = string;
        this.curdbactionDirtyFlag = true;
    }

    public String getCurDBAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurDBAction();
        }
        return this.curdbaction;
    }

    public boolean isCurDBActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurDBActionDirty();
        }
        return this.curdbactionDirtyFlag;
    }

    public void resetCurDBAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurDBAction();
            return;
        }
        this.curdbactionDirtyFlag = false;
        this.curdbaction = null;
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

    public void setDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbname = string;
        this.dbnameDirtyFlag = true;
    }

    public String getDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBName();
        }
        return this.dbname;
    }

    public boolean isDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBNameDirty();
        }
        return this.dbnameDirtyFlag;
    }

    public void resetDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBName();
            return;
        }
        this.dbnameDirtyFlag = false;
        this.dbname = null;
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

    public void setDCInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCInstState(n);
            return;
        }
        this.dcinststate = n;
        this.dcinststateDirtyFlag = true;
    }

    public Integer getDCInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCInstState();
        }
        return this.dcinststate;
    }

    public boolean isDCInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCInstStateDirty();
        }
        return this.dcinststateDirtyFlag;
    }

    public void resetDCInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCInstState();
            return;
        }
        this.dcinststateDirtyFlag = false;
        this.dcinststate = null;
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

    public void setHostAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostaddress = string;
        this.hostaddressDirtyFlag = true;
    }

    public String getHostAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostAddress();
        }
        return this.hostaddress;
    }

    public boolean isHostAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostAddressDirty();
        }
        return this.hostaddressDirtyFlag;
    }

    public void resetHostAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostAddress();
            return;
        }
        this.hostaddressDirtyFlag = false;
        this.hostaddress = null;
    }

    public void setHostPassWd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPassWd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostpasswd = string;
        this.hostpasswdDirtyFlag = true;
    }

    public String getHostPassWd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPassWd();
        }
        return this.hostpasswd;
    }

    public boolean isHostPassWdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPassWdDirty();
        }
        return this.hostpasswdDirtyFlag;
    }

    public void resetHostPassWd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPassWd();
            return;
        }
        this.hostpasswdDirtyFlag = false;
        this.hostpasswd = null;
    }

    public void setHostPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPort(n);
            return;
        }
        this.hostport = n;
        this.hostportDirtyFlag = true;
    }

    public Integer getHostPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPort();
        }
        return this.hostport;
    }

    public boolean isHostPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPortDirty();
        }
        return this.hostportDirtyFlag;
    }

    public void resetHostPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPort();
            return;
        }
        this.hostportDirtyFlag = false;
        this.hostport = null;
    }

    public void setHostSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostSSHPort(n);
            return;
        }
        this.hostsshport = n;
        this.hostsshportDirtyFlag = true;
    }

    public Integer getHostSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostSSHPort();
        }
        return this.hostsshport;
    }

    public boolean isHostSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostSSHPortDirty();
        }
        return this.hostsshportDirtyFlag;
    }

    public void resetHostSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostSSHPort();
            return;
        }
        this.hostsshportDirtyFlag = false;
        this.hostsshport = null;
    }

    public void setHostUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostusername = string;
        this.hostusernameDirtyFlag = true;
    }

    public String getHostUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostUserName();
        }
        return this.hostusername;
    }

    public boolean isHostUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostUserNameDirty();
        }
        return this.hostusernameDirtyFlag;
    }

    public void resetHostUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostUserName();
            return;
        }
        this.hostusernameDirtyFlag = false;
        this.hostusername = null;
    }

    public void setLockMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockMode(n);
            return;
        }
        this.lockmode = n;
        this.lockmodeDirtyFlag = true;
    }

    public Integer getLockMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockMode();
        }
        return this.lockmode;
    }

    public boolean isLockModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockModeDirty();
        }
        return this.lockmodeDirtyFlag;
    }

    public void resetLockMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockMode();
            return;
        }
        this.lockmodeDirtyFlag = false;
        this.lockmode = null;
    }

    public void setLockObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjid = string;
        this.lockobjidDirtyFlag = true;
    }

    public String getLockObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjId();
        }
        return this.lockobjid;
    }

    public boolean isLockObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjIdDirty();
        }
        return this.lockobjidDirtyFlag;
    }

    public void resetLockObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjId();
            return;
        }
        this.lockobjidDirtyFlag = false;
        this.lockobjid = null;
    }

    public void setLockObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjtype = string;
        this.lockobjtypeDirtyFlag = true;
    }

    public String getLockObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjType();
        }
        return this.lockobjtype;
    }

    public boolean isLockObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjTypeDirty();
        }
        return this.lockobjtypeDirtyFlag;
    }

    public void resetLockObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjType();
            return;
        }
        this.lockobjtypeDirtyFlag = false;
        this.lockobjtype = null;
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

    public void setPSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstid = string;
        this.psdbdevinstidDirtyFlag = true;
    }

    public String getPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstId();
        }
        return this.psdbdevinstid;
    }

    public boolean isPSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstIdDirty();
        }
        return this.psdbdevinstidDirtyFlag;
    }

    public void resetPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstId();
            return;
        }
        this.psdbdevinstidDirtyFlag = false;
        this.psdbdevinstid = null;
    }

    public void setPSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstname = string;
        this.psdbdevinstnameDirtyFlag = true;
    }

    public String getPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstName();
        }
        return this.psdbdevinstname;
    }

    public boolean isPSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstNameDirty();
        }
        return this.psdbdevinstnameDirtyFlag;
    }

    public void resetPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstName();
            return;
        }
        this.psdbdevinstnameDirtyFlag = false;
        this.psdbdevinstname = null;
    }

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
    }

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
    }

    public void setSysMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysmemo = string;
        this.sysmemoDirtyFlag = true;
    }

    public String getSysMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysMemo();
        }
        return this.sysmemo;
    }

    public boolean isSysMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysMemoDirty();
        }
        return this.sysmemoDirtyFlag;
    }

    public void resetSysMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysMemo();
            return;
        }
        this.sysmemoDirtyFlag = false;
        this.sysmemo = null;
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

    public void setUsedSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedSize(n);
            return;
        }
        this.usedsize = n;
        this.usedsizeDirtyFlag = true;
    }

    public Integer getUsedSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedSize();
        }
        return this.usedsize;
    }

    public boolean isUsedSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedSizeDirty();
        }
        return this.usedsizeDirtyFlag;
    }

    public void resetUsedSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedSize();
            return;
        }
        this.usedsizeDirtyFlag = false;
        this.usedsize = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSDevCenterDBInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterDBInstBase pSDevCenterDBInstBase) {
        pSDevCenterDBInstBase.resetAllocSize();
        pSDevCenterDBInstBase.resetConnStr();
        pSDevCenterDBInstBase.resetCreateDate();
        pSDevCenterDBInstBase.resetCreateMan();
        pSDevCenterDBInstBase.resetCurDBAction();
        pSDevCenterDBInstBase.resetDBInstallPath();
        pSDevCenterDBInstBase.resetDBName();
        pSDevCenterDBInstBase.resetDBPort();
        pSDevCenterDBInstBase.resetDBType();
        pSDevCenterDBInstBase.resetDCInstState();
        pSDevCenterDBInstBase.resetExpriedTime();
        pSDevCenterDBInstBase.resetHostAddress();
        pSDevCenterDBInstBase.resetHostPassWd();
        pSDevCenterDBInstBase.resetHostPort();
        pSDevCenterDBInstBase.resetHostSSHPort();
        pSDevCenterDBInstBase.resetHostUserName();
        pSDevCenterDBInstBase.resetLockMode();
        pSDevCenterDBInstBase.resetLockObjId();
        pSDevCenterDBInstBase.resetLockObjType();
        pSDevCenterDBInstBase.resetMemo();
        pSDevCenterDBInstBase.resetPasswd();
        pSDevCenterDBInstBase.resetPSDBDevInstId();
        pSDevCenterDBInstBase.resetPSDBDevInstName();
        pSDevCenterDBInstBase.resetPSDCClusterId();
        pSDevCenterDBInstBase.resetPSDCClusterName();
        pSDevCenterDBInstBase.resetPSDCContainerSpecId();
        pSDevCenterDBInstBase.resetPSDCContainerSpecName();
        pSDevCenterDBInstBase.resetPSDCFileId();
        pSDevCenterDBInstBase.resetPSDCFileName();
        pSDevCenterDBInstBase.resetPSDevCenterASId();
        pSDevCenterDBInstBase.resetPSDevCenterASName();
        pSDevCenterDBInstBase.resetPSDevCenterDBInstId();
        pSDevCenterDBInstBase.resetPSDevCenterDBInstName();
        pSDevCenterDBInstBase.resetPSDevCenterId();
        pSDevCenterDBInstBase.resetPSDevCenterName();
        pSDevCenterDBInstBase.resetPSDevSlnId();
        pSDevCenterDBInstBase.resetPSDevSlnName();
        pSDevCenterDBInstBase.resetRefCount();
        pSDevCenterDBInstBase.resetRefInfo();
        pSDevCenterDBInstBase.resetResPos();
        pSDevCenterDBInstBase.resetResReadyTime();
        pSDevCenterDBInstBase.resetResState();
        pSDevCenterDBInstBase.resetResVer();
        pSDevCenterDBInstBase.resetSysMemo();
        pSDevCenterDBInstBase.resetUpdateDate();
        pSDevCenterDBInstBase.resetUpdateMan();
        pSDevCenterDBInstBase.resetUploadFileMode();
        pSDevCenterDBInstBase.resetUploadPath();
        pSDevCenterDBInstBase.resetUsageMode();
        pSDevCenterDBInstBase.resetUsedSize();
        pSDevCenterDBInstBase.resetUserName();
        pSDevCenterDBInstBase.resetUserParams();
        pSDevCenterDBInstBase.resetUserTag();
        pSDevCenterDBInstBase.resetUserTag2();
        pSDevCenterDBInstBase.resetUserTag3();
        pSDevCenterDBInstBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllocSizeDirty()) {
            hashMap.put(FIELD_ALLOCSIZE, this.getAllocSize());
        }
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurDBActionDirty()) {
            hashMap.put(FIELD_CURDBACTION, this.getCurDBAction());
        }
        if (!bl || this.isDBInstallPathDirty()) {
            hashMap.put(FIELD_DBINSTALLPATH, this.getDBInstallPath());
        }
        if (!bl || this.isDBNameDirty()) {
            hashMap.put(FIELD_DBNAME, this.getDBName());
        }
        if (!bl || this.isDBPortDirty()) {
            hashMap.put(FIELD_DBPORT, this.getDBPort());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isDCInstStateDirty()) {
            hashMap.put(FIELD_DCINSTSTATE, this.getDCInstState());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHostAddressDirty()) {
            hashMap.put(FIELD_HOSTADDRESS, this.getHostAddress());
        }
        if (!bl || this.isHostPassWdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPassWd());
        }
        if (!bl || this.isHostPortDirty()) {
            hashMap.put(FIELD_HOSTPORT, this.getHostPort());
        }
        if (!bl || this.isHostSSHPortDirty()) {
            hashMap.put(FIELD_HOSTSSHPORT, this.getHostSSHPort());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
        }
        if (!bl || this.isLockModeDirty()) {
            hashMap.put(FIELD_LOCKMODE, this.getLockMode());
        }
        if (!bl || this.isLockObjIdDirty()) {
            hashMap.put(FIELD_LOCKOBJID, this.getLockObjId());
        }
        if (!bl || this.isLockObjTypeDirty()) {
            hashMap.put(FIELD_LOCKOBJTYPE, this.getLockObjType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDBDevInstIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTID, this.getPSDBDevInstId());
        }
        if (!bl || this.isPSDBDevInstNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTNAME, this.getPSDBDevInstName());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
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
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isSysMemoDirty()) {
            hashMap.put(FIELD_SYSMEMO, this.getSysMemo());
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
        if (!bl || this.isUsedSizeDirty()) {
            hashMap.put(FIELD_USEDSIZE, this.getUsedSize());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSDevCenterDBInstBase.get(this, n);
    }

    private static Object get(PSDevCenterDBInstBase pSDevCenterDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterDBInstBase.getAllocSize();
            }
            case 1: {
                return pSDevCenterDBInstBase.getConnStr();
            }
            case 2: {
                return pSDevCenterDBInstBase.getCreateDate();
            }
            case 3: {
                return pSDevCenterDBInstBase.getCreateMan();
            }
            case 4: {
                return pSDevCenterDBInstBase.getCurDBAction();
            }
            case 5: {
                return pSDevCenterDBInstBase.getDBInstallPath();
            }
            case 6: {
                return pSDevCenterDBInstBase.getDBName();
            }
            case 7: {
                return pSDevCenterDBInstBase.getDBPort();
            }
            case 8: {
                return pSDevCenterDBInstBase.getDBType();
            }
            case 9: {
                return pSDevCenterDBInstBase.getDCInstState();
            }
            case 10: {
                return pSDevCenterDBInstBase.getExpriedTime();
            }
            case 11: {
                return pSDevCenterDBInstBase.getHostAddress();
            }
            case 12: {
                return pSDevCenterDBInstBase.getHostPassWd();
            }
            case 13: {
                return pSDevCenterDBInstBase.getHostPort();
            }
            case 14: {
                return pSDevCenterDBInstBase.getHostSSHPort();
            }
            case 15: {
                return pSDevCenterDBInstBase.getHostUserName();
            }
            case 16: {
                return pSDevCenterDBInstBase.getLockMode();
            }
            case 17: {
                return pSDevCenterDBInstBase.getLockObjId();
            }
            case 18: {
                return pSDevCenterDBInstBase.getLockObjType();
            }
            case 19: {
                return pSDevCenterDBInstBase.getMemo();
            }
            case 20: {
                return pSDevCenterDBInstBase.getPasswd();
            }
            case 21: {
                return pSDevCenterDBInstBase.getPSDBDevInstId();
            }
            case 22: {
                return pSDevCenterDBInstBase.getPSDBDevInstName();
            }
            case 23: {
                return pSDevCenterDBInstBase.getPSDCClusterId();
            }
            case 24: {
                return pSDevCenterDBInstBase.getPSDCClusterName();
            }
            case 25: {
                return pSDevCenterDBInstBase.getPSDCContainerSpecId();
            }
            case 26: {
                return pSDevCenterDBInstBase.getPSDCContainerSpecName();
            }
            case 27: {
                return pSDevCenterDBInstBase.getPSDCFileId();
            }
            case 28: {
                return pSDevCenterDBInstBase.getPSDCFileName();
            }
            case 29: {
                return pSDevCenterDBInstBase.getPSDevCenterASId();
            }
            case 30: {
                return pSDevCenterDBInstBase.getPSDevCenterASName();
            }
            case 31: {
                return pSDevCenterDBInstBase.getPSDevCenterDBInstId();
            }
            case 32: {
                return pSDevCenterDBInstBase.getPSDevCenterDBInstName();
            }
            case 33: {
                return pSDevCenterDBInstBase.getPSDevCenterId();
            }
            case 34: {
                return pSDevCenterDBInstBase.getPSDevCenterName();
            }
            case 35: {
                return pSDevCenterDBInstBase.getPSDevSlnId();
            }
            case 36: {
                return pSDevCenterDBInstBase.getPSDevSlnName();
            }
            case 37: {
                return pSDevCenterDBInstBase.getRefCount();
            }
            case 38: {
                return pSDevCenterDBInstBase.getRefInfo();
            }
            case 39: {
                return pSDevCenterDBInstBase.getResPos();
            }
            case 40: {
                return pSDevCenterDBInstBase.getResReadyTime();
            }
            case 41: {
                return pSDevCenterDBInstBase.getResState();
            }
            case 42: {
                return pSDevCenterDBInstBase.getResVer();
            }
            case 43: {
                return pSDevCenterDBInstBase.getSysMemo();
            }
            case 44: {
                return pSDevCenterDBInstBase.getUpdateDate();
            }
            case 45: {
                return pSDevCenterDBInstBase.getUpdateMan();
            }
            case 46: {
                return pSDevCenterDBInstBase.getUploadFileMode();
            }
            case 47: {
                return pSDevCenterDBInstBase.getUploadPath();
            }
            case 48: {
                return pSDevCenterDBInstBase.getUsageMode();
            }
            case 49: {
                return pSDevCenterDBInstBase.getUsedSize();
            }
            case 50: {
                return pSDevCenterDBInstBase.getUserName();
            }
            case 51: {
                return pSDevCenterDBInstBase.getUserParams();
            }
            case 52: {
                return pSDevCenterDBInstBase.getUserTag();
            }
            case 53: {
                return pSDevCenterDBInstBase.getUserTag2();
            }
            case 54: {
                return pSDevCenterDBInstBase.getUserTag3();
            }
            case 55: {
                return pSDevCenterDBInstBase.getUserTag4();
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
        PSDevCenterDBInstBase.set(this, n, object);
    }

    private static void set(PSDevCenterDBInstBase pSDevCenterDBInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterDBInstBase.setAllocSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterDBInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterDBInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterDBInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterDBInstBase.setCurDBAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterDBInstBase.setDBInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterDBInstBase.setDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterDBInstBase.setDBPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterDBInstBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterDBInstBase.setDCInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterDBInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterDBInstBase.setHostAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterDBInstBase.setHostPassWd(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterDBInstBase.setHostPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterDBInstBase.setHostSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterDBInstBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterDBInstBase.setLockMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterDBInstBase.setLockObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterDBInstBase.setLockObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterDBInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterDBInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterDBInstBase.setPSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterDBInstBase.setPSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterDBInstBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterDBInstBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterDBInstBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterDBInstBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterDBInstBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterDBInstBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterDBInstBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterDBInstBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterDBInstBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevCenterDBInstBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevCenterDBInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevCenterDBInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevCenterDBInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevCenterDBInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevCenterDBInstBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDevCenterDBInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevCenterDBInstBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDevCenterDBInstBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSDevCenterDBInstBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDevCenterDBInstBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDevCenterDBInstBase.setSysMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevCenterDBInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSDevCenterDBInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevCenterDBInstBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevCenterDBInstBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevCenterDBInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevCenterDBInstBase.setUsedSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSDevCenterDBInstBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevCenterDBInstBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevCenterDBInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDevCenterDBInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDevCenterDBInstBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDevCenterDBInstBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevCenterDBInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterDBInstBase pSDevCenterDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterDBInstBase.getAllocSize() == null;
            }
            case 1: {
                return pSDevCenterDBInstBase.getConnStr() == null;
            }
            case 2: {
                return pSDevCenterDBInstBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevCenterDBInstBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevCenterDBInstBase.getCurDBAction() == null;
            }
            case 5: {
                return pSDevCenterDBInstBase.getDBInstallPath() == null;
            }
            case 6: {
                return pSDevCenterDBInstBase.getDBName() == null;
            }
            case 7: {
                return pSDevCenterDBInstBase.getDBPort() == null;
            }
            case 8: {
                return pSDevCenterDBInstBase.getDBType() == null;
            }
            case 9: {
                return pSDevCenterDBInstBase.getDCInstState() == null;
            }
            case 10: {
                return pSDevCenterDBInstBase.getExpriedTime() == null;
            }
            case 11: {
                return pSDevCenterDBInstBase.getHostAddress() == null;
            }
            case 12: {
                return pSDevCenterDBInstBase.getHostPassWd() == null;
            }
            case 13: {
                return pSDevCenterDBInstBase.getHostPort() == null;
            }
            case 14: {
                return pSDevCenterDBInstBase.getHostSSHPort() == null;
            }
            case 15: {
                return pSDevCenterDBInstBase.getHostUserName() == null;
            }
            case 16: {
                return pSDevCenterDBInstBase.getLockMode() == null;
            }
            case 17: {
                return pSDevCenterDBInstBase.getLockObjId() == null;
            }
            case 18: {
                return pSDevCenterDBInstBase.getLockObjType() == null;
            }
            case 19: {
                return pSDevCenterDBInstBase.getMemo() == null;
            }
            case 20: {
                return pSDevCenterDBInstBase.getPasswd() == null;
            }
            case 21: {
                return pSDevCenterDBInstBase.getPSDBDevInstId() == null;
            }
            case 22: {
                return pSDevCenterDBInstBase.getPSDBDevInstName() == null;
            }
            case 23: {
                return pSDevCenterDBInstBase.getPSDCClusterId() == null;
            }
            case 24: {
                return pSDevCenterDBInstBase.getPSDCClusterName() == null;
            }
            case 25: {
                return pSDevCenterDBInstBase.getPSDCContainerSpecId() == null;
            }
            case 26: {
                return pSDevCenterDBInstBase.getPSDCContainerSpecName() == null;
            }
            case 27: {
                return pSDevCenterDBInstBase.getPSDCFileId() == null;
            }
            case 28: {
                return pSDevCenterDBInstBase.getPSDCFileName() == null;
            }
            case 29: {
                return pSDevCenterDBInstBase.getPSDevCenterASId() == null;
            }
            case 30: {
                return pSDevCenterDBInstBase.getPSDevCenterASName() == null;
            }
            case 31: {
                return pSDevCenterDBInstBase.getPSDevCenterDBInstId() == null;
            }
            case 32: {
                return pSDevCenterDBInstBase.getPSDevCenterDBInstName() == null;
            }
            case 33: {
                return pSDevCenterDBInstBase.getPSDevCenterId() == null;
            }
            case 34: {
                return pSDevCenterDBInstBase.getPSDevCenterName() == null;
            }
            case 35: {
                return pSDevCenterDBInstBase.getPSDevSlnId() == null;
            }
            case 36: {
                return pSDevCenterDBInstBase.getPSDevSlnName() == null;
            }
            case 37: {
                return pSDevCenterDBInstBase.getRefCount() == null;
            }
            case 38: {
                return pSDevCenterDBInstBase.getRefInfo() == null;
            }
            case 39: {
                return pSDevCenterDBInstBase.getResPos() == null;
            }
            case 40: {
                return pSDevCenterDBInstBase.getResReadyTime() == null;
            }
            case 41: {
                return pSDevCenterDBInstBase.getResState() == null;
            }
            case 42: {
                return pSDevCenterDBInstBase.getResVer() == null;
            }
            case 43: {
                return pSDevCenterDBInstBase.getSysMemo() == null;
            }
            case 44: {
                return pSDevCenterDBInstBase.getUpdateDate() == null;
            }
            case 45: {
                return pSDevCenterDBInstBase.getUpdateMan() == null;
            }
            case 46: {
                return pSDevCenterDBInstBase.getUploadFileMode() == null;
            }
            case 47: {
                return pSDevCenterDBInstBase.getUploadPath() == null;
            }
            case 48: {
                return pSDevCenterDBInstBase.getUsageMode() == null;
            }
            case 49: {
                return pSDevCenterDBInstBase.getUsedSize() == null;
            }
            case 50: {
                return pSDevCenterDBInstBase.getUserName() == null;
            }
            case 51: {
                return pSDevCenterDBInstBase.getUserParams() == null;
            }
            case 52: {
                return pSDevCenterDBInstBase.getUserTag() == null;
            }
            case 53: {
                return pSDevCenterDBInstBase.getUserTag2() == null;
            }
            case 54: {
                return pSDevCenterDBInstBase.getUserTag3() == null;
            }
            case 55: {
                return pSDevCenterDBInstBase.getUserTag4() == null;
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
        return PSDevCenterDBInstBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterDBInstBase pSDevCenterDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterDBInstBase.isAllocSizeDirty();
            }
            case 1: {
                return pSDevCenterDBInstBase.isConnStrDirty();
            }
            case 2: {
                return pSDevCenterDBInstBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevCenterDBInstBase.isCreateManDirty();
            }
            case 4: {
                return pSDevCenterDBInstBase.isCurDBActionDirty();
            }
            case 5: {
                return pSDevCenterDBInstBase.isDBInstallPathDirty();
            }
            case 6: {
                return pSDevCenterDBInstBase.isDBNameDirty();
            }
            case 7: {
                return pSDevCenterDBInstBase.isDBPortDirty();
            }
            case 8: {
                return pSDevCenterDBInstBase.isDBTypeDirty();
            }
            case 9: {
                return pSDevCenterDBInstBase.isDCInstStateDirty();
            }
            case 10: {
                return pSDevCenterDBInstBase.isExpriedTimeDirty();
            }
            case 11: {
                return pSDevCenterDBInstBase.isHostAddressDirty();
            }
            case 12: {
                return pSDevCenterDBInstBase.isHostPassWdDirty();
            }
            case 13: {
                return pSDevCenterDBInstBase.isHostPortDirty();
            }
            case 14: {
                return pSDevCenterDBInstBase.isHostSSHPortDirty();
            }
            case 15: {
                return pSDevCenterDBInstBase.isHostUserNameDirty();
            }
            case 16: {
                return pSDevCenterDBInstBase.isLockModeDirty();
            }
            case 17: {
                return pSDevCenterDBInstBase.isLockObjIdDirty();
            }
            case 18: {
                return pSDevCenterDBInstBase.isLockObjTypeDirty();
            }
            case 19: {
                return pSDevCenterDBInstBase.isMemoDirty();
            }
            case 20: {
                return pSDevCenterDBInstBase.isPasswdDirty();
            }
            case 21: {
                return pSDevCenterDBInstBase.isPSDBDevInstIdDirty();
            }
            case 22: {
                return pSDevCenterDBInstBase.isPSDBDevInstNameDirty();
            }
            case 23: {
                return pSDevCenterDBInstBase.isPSDCClusterIdDirty();
            }
            case 24: {
                return pSDevCenterDBInstBase.isPSDCClusterNameDirty();
            }
            case 25: {
                return pSDevCenterDBInstBase.isPSDCContainerSpecIdDirty();
            }
            case 26: {
                return pSDevCenterDBInstBase.isPSDCContainerSpecNameDirty();
            }
            case 27: {
                return pSDevCenterDBInstBase.isPSDCFileIdDirty();
            }
            case 28: {
                return pSDevCenterDBInstBase.isPSDCFileNameDirty();
            }
            case 29: {
                return pSDevCenterDBInstBase.isPSDevCenterASIdDirty();
            }
            case 30: {
                return pSDevCenterDBInstBase.isPSDevCenterASNameDirty();
            }
            case 31: {
                return pSDevCenterDBInstBase.isPSDevCenterDBInstIdDirty();
            }
            case 32: {
                return pSDevCenterDBInstBase.isPSDevCenterDBInstNameDirty();
            }
            case 33: {
                return pSDevCenterDBInstBase.isPSDevCenterIdDirty();
            }
            case 34: {
                return pSDevCenterDBInstBase.isPSDevCenterNameDirty();
            }
            case 35: {
                return pSDevCenterDBInstBase.isPSDevSlnIdDirty();
            }
            case 36: {
                return pSDevCenterDBInstBase.isPSDevSlnNameDirty();
            }
            case 37: {
                return pSDevCenterDBInstBase.isRefCountDirty();
            }
            case 38: {
                return pSDevCenterDBInstBase.isRefInfoDirty();
            }
            case 39: {
                return pSDevCenterDBInstBase.isResPosDirty();
            }
            case 40: {
                return pSDevCenterDBInstBase.isResReadyTimeDirty();
            }
            case 41: {
                return pSDevCenterDBInstBase.isResStateDirty();
            }
            case 42: {
                return pSDevCenterDBInstBase.isResVerDirty();
            }
            case 43: {
                return pSDevCenterDBInstBase.isSysMemoDirty();
            }
            case 44: {
                return pSDevCenterDBInstBase.isUpdateDateDirty();
            }
            case 45: {
                return pSDevCenterDBInstBase.isUpdateManDirty();
            }
            case 46: {
                return pSDevCenterDBInstBase.isUploadFileModeDirty();
            }
            case 47: {
                return pSDevCenterDBInstBase.isUploadPathDirty();
            }
            case 48: {
                return pSDevCenterDBInstBase.isUsageModeDirty();
            }
            case 49: {
                return pSDevCenterDBInstBase.isUsedSizeDirty();
            }
            case 50: {
                return pSDevCenterDBInstBase.isUserNameDirty();
            }
            case 51: {
                return pSDevCenterDBInstBase.isUserParamsDirty();
            }
            case 52: {
                return pSDevCenterDBInstBase.isUserTagDirty();
            }
            case 53: {
                return pSDevCenterDBInstBase.isUserTag2Dirty();
            }
            case 54: {
                return pSDevCenterDBInstBase.isUserTag3Dirty();
            }
            case 55: {
                return pSDevCenterDBInstBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterDBInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterDBInstBase pSDevCenterDBInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterDBInstBase.getAllocSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allocsize", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getAllocSize()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getCurDBAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curdbaction", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getCurDBAction()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getDBInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbinstallpath", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getDBInstallPath()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getDBName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getDBPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbport", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getDBPort()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getDBType()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getDCInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcinststate", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getDCInstState()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getHostAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostaddress", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getHostAddress()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getHostPassWd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getHostPassWd()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getHostPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostport", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getHostPort()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getHostSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostsshport", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getHostSSHPort()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getLockMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockmode", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getLockMode()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getLockObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getLockObjId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getLockObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjtype", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getLockObjType()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDBDevInstId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDBDevInstName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getResState()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getResVer()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getSysMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmemo", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getSysMemo()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedsize", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUsedSize()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserName()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevCenterDBInstBase.getJSONValue((Object)pSDevCenterDBInstBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterDBInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterDBInstBase pSDevCenterDBInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterDBInstBase.getAllocSize() != null) {
            object = pSDevCenterDBInstBase.getAllocSize();
            xmlNode.setAttribute(FIELD_ALLOCSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getConnStr() != null) {
            object = pSDevCenterDBInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getCreateDate() != null) {
            object = pSDevCenterDBInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getCreateMan() != null) {
            object = pSDevCenterDBInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getCurDBAction() != null) {
            object = pSDevCenterDBInstBase.getCurDBAction();
            xmlNode.setAttribute(FIELD_CURDBACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getDBInstallPath() != null) {
            object = pSDevCenterDBInstBase.getDBInstallPath();
            xmlNode.setAttribute(FIELD_DBINSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getDBName() != null) {
            object = pSDevCenterDBInstBase.getDBName();
            xmlNode.setAttribute(FIELD_DBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getDBPort() != null) {
            object = pSDevCenterDBInstBase.getDBPort();
            xmlNode.setAttribute(FIELD_DBPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getDBType() != null) {
            object = pSDevCenterDBInstBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getDCInstState() != null) {
            object = pSDevCenterDBInstBase.getDCInstState();
            xmlNode.setAttribute(FIELD_DCINSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getExpriedTime() != null) {
            object = pSDevCenterDBInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getHostAddress() != null) {
            object = pSDevCenterDBInstBase.getHostAddress();
            xmlNode.setAttribute(FIELD_HOSTADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getHostPassWd() != null) {
            object = pSDevCenterDBInstBase.getHostPassWd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getHostPort() != null) {
            object = pSDevCenterDBInstBase.getHostPort();
            xmlNode.setAttribute(FIELD_HOSTPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getHostSSHPort() != null) {
            object = pSDevCenterDBInstBase.getHostSSHPort();
            xmlNode.setAttribute(FIELD_HOSTSSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getHostUserName() != null) {
            object = pSDevCenterDBInstBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getLockMode() != null) {
            object = pSDevCenterDBInstBase.getLockMode();
            xmlNode.setAttribute(FIELD_LOCKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getLockObjId() != null) {
            object = pSDevCenterDBInstBase.getLockObjId();
            xmlNode.setAttribute(FIELD_LOCKOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getLockObjType() != null) {
            object = pSDevCenterDBInstBase.getLockObjType();
            xmlNode.setAttribute(FIELD_LOCKOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getMemo() != null) {
            object = pSDevCenterDBInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPasswd() != null) {
            object = pSDevCenterDBInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDBDevInstId() != null) {
            object = pSDevCenterDBInstBase.getPSDBDevInstId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDBDevInstName() != null) {
            object = pSDevCenterDBInstBase.getPSDBDevInstName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCClusterId() != null) {
            object = pSDevCenterDBInstBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCClusterName() != null) {
            object = pSDevCenterDBInstBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCContainerSpecId() != null) {
            object = pSDevCenterDBInstBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCContainerSpecName() != null) {
            object = pSDevCenterDBInstBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCFileId() != null) {
            object = pSDevCenterDBInstBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDCFileName() != null) {
            object = pSDevCenterDBInstBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterASId() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterASName() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstId() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstName() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterId() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevCenterName() != null) {
            object = pSDevCenterDBInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevSlnId() != null) {
            object = pSDevCenterDBInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getPSDevSlnName() != null) {
            object = pSDevCenterDBInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getRefCount() != null) {
            object = pSDevCenterDBInstBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getRefInfo() != null) {
            object = pSDevCenterDBInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getResPos() != null) {
            object = pSDevCenterDBInstBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getResReadyTime() != null) {
            object = pSDevCenterDBInstBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getResState() != null) {
            object = pSDevCenterDBInstBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getResVer() != null) {
            object = pSDevCenterDBInstBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getSysMemo() != null) {
            object = pSDevCenterDBInstBase.getSysMemo();
            xmlNode.setAttribute(FIELD_SYSMEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUpdateDate() != null) {
            object = pSDevCenterDBInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getUpdateMan() != null) {
            object = pSDevCenterDBInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUploadFileMode() != null) {
            object = pSDevCenterDBInstBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUploadPath() != null) {
            object = pSDevCenterDBInstBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUsageMode() != null) {
            object = pSDevCenterDBInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUsedSize() != null) {
            object = pSDevCenterDBInstBase.getUsedSize();
            xmlNode.setAttribute(FIELD_USEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterDBInstBase.getUserName() != null) {
            object = pSDevCenterDBInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUserParams() != null) {
            object = pSDevCenterDBInstBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag() != null) {
            object = pSDevCenterDBInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag2() != null) {
            object = pSDevCenterDBInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag3() != null) {
            object = pSDevCenterDBInstBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterDBInstBase.getUserTag4() != null) {
            object = pSDevCenterDBInstBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterDBInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterDBInstBase pSDevCenterDBInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterDBInstBase.isAllocSizeDirty() && (bl || pSDevCenterDBInstBase.getAllocSize() != null)) {
            iDataObject.set(FIELD_ALLOCSIZE, (Object)pSDevCenterDBInstBase.getAllocSize());
        }
        if (pSDevCenterDBInstBase.isConnStrDirty() && (bl || pSDevCenterDBInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDevCenterDBInstBase.getConnStr());
        }
        if (pSDevCenterDBInstBase.isCreateDateDirty() && (bl || pSDevCenterDBInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterDBInstBase.getCreateDate());
        }
        if (pSDevCenterDBInstBase.isCreateManDirty() && (bl || pSDevCenterDBInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterDBInstBase.getCreateMan());
        }
        if (pSDevCenterDBInstBase.isCurDBActionDirty() && (bl || pSDevCenterDBInstBase.getCurDBAction() != null)) {
            iDataObject.set(FIELD_CURDBACTION, (Object)pSDevCenterDBInstBase.getCurDBAction());
        }
        if (pSDevCenterDBInstBase.isDBInstallPathDirty() && (bl || pSDevCenterDBInstBase.getDBInstallPath() != null)) {
            iDataObject.set(FIELD_DBINSTALLPATH, (Object)pSDevCenterDBInstBase.getDBInstallPath());
        }
        if (pSDevCenterDBInstBase.isDBNameDirty() && (bl || pSDevCenterDBInstBase.getDBName() != null)) {
            iDataObject.set(FIELD_DBNAME, (Object)pSDevCenterDBInstBase.getDBName());
        }
        if (pSDevCenterDBInstBase.isDBPortDirty() && (bl || pSDevCenterDBInstBase.getDBPort() != null)) {
            iDataObject.set(FIELD_DBPORT, (Object)pSDevCenterDBInstBase.getDBPort());
        }
        if (pSDevCenterDBInstBase.isDBTypeDirty() && (bl || pSDevCenterDBInstBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDevCenterDBInstBase.getDBType());
        }
        if (pSDevCenterDBInstBase.isDCInstStateDirty() && (bl || pSDevCenterDBInstBase.getDCInstState() != null)) {
            iDataObject.set(FIELD_DCINSTSTATE, (Object)pSDevCenterDBInstBase.getDCInstState());
        }
        if (pSDevCenterDBInstBase.isExpriedTimeDirty() && (bl || pSDevCenterDBInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevCenterDBInstBase.getExpriedTime());
        }
        if (pSDevCenterDBInstBase.isHostAddressDirty() && (bl || pSDevCenterDBInstBase.getHostAddress() != null)) {
            iDataObject.set(FIELD_HOSTADDRESS, (Object)pSDevCenterDBInstBase.getHostAddress());
        }
        if (pSDevCenterDBInstBase.isHostPassWdDirty() && (bl || pSDevCenterDBInstBase.getHostPassWd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevCenterDBInstBase.getHostPassWd());
        }
        if (pSDevCenterDBInstBase.isHostPortDirty() && (bl || pSDevCenterDBInstBase.getHostPort() != null)) {
            iDataObject.set(FIELD_HOSTPORT, (Object)pSDevCenterDBInstBase.getHostPort());
        }
        if (pSDevCenterDBInstBase.isHostSSHPortDirty() && (bl || pSDevCenterDBInstBase.getHostSSHPort() != null)) {
            iDataObject.set(FIELD_HOSTSSHPORT, (Object)pSDevCenterDBInstBase.getHostSSHPort());
        }
        if (pSDevCenterDBInstBase.isHostUserNameDirty() && (bl || pSDevCenterDBInstBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevCenterDBInstBase.getHostUserName());
        }
        if (pSDevCenterDBInstBase.isLockModeDirty() && (bl || pSDevCenterDBInstBase.getLockMode() != null)) {
            iDataObject.set(FIELD_LOCKMODE, (Object)pSDevCenterDBInstBase.getLockMode());
        }
        if (pSDevCenterDBInstBase.isLockObjIdDirty() && (bl || pSDevCenterDBInstBase.getLockObjId() != null)) {
            iDataObject.set(FIELD_LOCKOBJID, (Object)pSDevCenterDBInstBase.getLockObjId());
        }
        if (pSDevCenterDBInstBase.isLockObjTypeDirty() && (bl || pSDevCenterDBInstBase.getLockObjType() != null)) {
            iDataObject.set(FIELD_LOCKOBJTYPE, (Object)pSDevCenterDBInstBase.getLockObjType());
        }
        if (pSDevCenterDBInstBase.isMemoDirty() && (bl || pSDevCenterDBInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterDBInstBase.getMemo());
        }
        if (pSDevCenterDBInstBase.isPasswdDirty() && (bl || pSDevCenterDBInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDevCenterDBInstBase.getPasswd());
        }
        if (pSDevCenterDBInstBase.isPSDBDevInstIdDirty() && (bl || pSDevCenterDBInstBase.getPSDBDevInstId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTID, (Object)pSDevCenterDBInstBase.getPSDBDevInstId());
        }
        if (pSDevCenterDBInstBase.isPSDBDevInstNameDirty() && (bl || pSDevCenterDBInstBase.getPSDBDevInstName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTNAME, (Object)pSDevCenterDBInstBase.getPSDBDevInstName());
        }
        if (pSDevCenterDBInstBase.isPSDCClusterIdDirty() && (bl || pSDevCenterDBInstBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDevCenterDBInstBase.getPSDCClusterId());
        }
        if (pSDevCenterDBInstBase.isPSDCClusterNameDirty() && (bl || pSDevCenterDBInstBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDevCenterDBInstBase.getPSDCClusterName());
        }
        if (pSDevCenterDBInstBase.isPSDCContainerSpecIdDirty() && (bl || pSDevCenterDBInstBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDevCenterDBInstBase.getPSDCContainerSpecId());
        }
        if (pSDevCenterDBInstBase.isPSDCContainerSpecNameDirty() && (bl || pSDevCenterDBInstBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDevCenterDBInstBase.getPSDCContainerSpecName());
        }
        if (pSDevCenterDBInstBase.isPSDCFileIdDirty() && (bl || pSDevCenterDBInstBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevCenterDBInstBase.getPSDCFileId());
        }
        if (pSDevCenterDBInstBase.isPSDCFileNameDirty() && (bl || pSDevCenterDBInstBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevCenterDBInstBase.getPSDCFileName());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterASIdDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSDevCenterDBInstBase.getPSDevCenterASId());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterASNameDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSDevCenterDBInstBase.getPSDevCenterASName());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstName());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterIdDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterDBInstBase.getPSDevCenterId());
        }
        if (pSDevCenterDBInstBase.isPSDevCenterNameDirty() && (bl || pSDevCenterDBInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterDBInstBase.getPSDevCenterName());
        }
        if (pSDevCenterDBInstBase.isPSDevSlnIdDirty() && (bl || pSDevCenterDBInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevCenterDBInstBase.getPSDevSlnId());
        }
        if (pSDevCenterDBInstBase.isPSDevSlnNameDirty() && (bl || pSDevCenterDBInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevCenterDBInstBase.getPSDevSlnName());
        }
        if (pSDevCenterDBInstBase.isRefCountDirty() && (bl || pSDevCenterDBInstBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDevCenterDBInstBase.getRefCount());
        }
        if (pSDevCenterDBInstBase.isRefInfoDirty() && (bl || pSDevCenterDBInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSDevCenterDBInstBase.getRefInfo());
        }
        if (pSDevCenterDBInstBase.isResPosDirty() && (bl || pSDevCenterDBInstBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevCenterDBInstBase.getResPos());
        }
        if (pSDevCenterDBInstBase.isResReadyTimeDirty() && (bl || pSDevCenterDBInstBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevCenterDBInstBase.getResReadyTime());
        }
        if (pSDevCenterDBInstBase.isResStateDirty() && (bl || pSDevCenterDBInstBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevCenterDBInstBase.getResState());
        }
        if (pSDevCenterDBInstBase.isResVerDirty() && (bl || pSDevCenterDBInstBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDevCenterDBInstBase.getResVer());
        }
        if (pSDevCenterDBInstBase.isSysMemoDirty() && (bl || pSDevCenterDBInstBase.getSysMemo() != null)) {
            iDataObject.set(FIELD_SYSMEMO, (Object)pSDevCenterDBInstBase.getSysMemo());
        }
        if (pSDevCenterDBInstBase.isUpdateDateDirty() && (bl || pSDevCenterDBInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterDBInstBase.getUpdateDate());
        }
        if (pSDevCenterDBInstBase.isUpdateManDirty() && (bl || pSDevCenterDBInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterDBInstBase.getUpdateMan());
        }
        if (pSDevCenterDBInstBase.isUploadFileModeDirty() && (bl || pSDevCenterDBInstBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDevCenterDBInstBase.getUploadFileMode());
        }
        if (pSDevCenterDBInstBase.isUploadPathDirty() && (bl || pSDevCenterDBInstBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDevCenterDBInstBase.getUploadPath());
        }
        if (pSDevCenterDBInstBase.isUsageModeDirty() && (bl || pSDevCenterDBInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDevCenterDBInstBase.getUsageMode());
        }
        if (pSDevCenterDBInstBase.isUsedSizeDirty() && (bl || pSDevCenterDBInstBase.getUsedSize() != null)) {
            iDataObject.set(FIELD_USEDSIZE, (Object)pSDevCenterDBInstBase.getUsedSize());
        }
        if (pSDevCenterDBInstBase.isUserNameDirty() && (bl || pSDevCenterDBInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDevCenterDBInstBase.getUserName());
        }
        if (pSDevCenterDBInstBase.isUserParamsDirty() && (bl || pSDevCenterDBInstBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevCenterDBInstBase.getUserParams());
        }
        if (pSDevCenterDBInstBase.isUserTagDirty() && (bl || pSDevCenterDBInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevCenterDBInstBase.getUserTag());
        }
        if (pSDevCenterDBInstBase.isUserTag2Dirty() && (bl || pSDevCenterDBInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevCenterDBInstBase.getUserTag2());
        }
        if (pSDevCenterDBInstBase.isUserTag3Dirty() && (bl || pSDevCenterDBInstBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevCenterDBInstBase.getUserTag3());
        }
        if (pSDevCenterDBInstBase.isUserTag4Dirty() && (bl || pSDevCenterDBInstBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevCenterDBInstBase.getUserTag4());
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
        return PSDevCenterDBInstBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterDBInstBase pSDevCenterDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterDBInstBase.resetAllocSize();
                return true;
            }
            case 1: {
                pSDevCenterDBInstBase.resetConnStr();
                return true;
            }
            case 2: {
                pSDevCenterDBInstBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevCenterDBInstBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevCenterDBInstBase.resetCurDBAction();
                return true;
            }
            case 5: {
                pSDevCenterDBInstBase.resetDBInstallPath();
                return true;
            }
            case 6: {
                pSDevCenterDBInstBase.resetDBName();
                return true;
            }
            case 7: {
                pSDevCenterDBInstBase.resetDBPort();
                return true;
            }
            case 8: {
                pSDevCenterDBInstBase.resetDBType();
                return true;
            }
            case 9: {
                pSDevCenterDBInstBase.resetDCInstState();
                return true;
            }
            case 10: {
                pSDevCenterDBInstBase.resetExpriedTime();
                return true;
            }
            case 11: {
                pSDevCenterDBInstBase.resetHostAddress();
                return true;
            }
            case 12: {
                pSDevCenterDBInstBase.resetHostPassWd();
                return true;
            }
            case 13: {
                pSDevCenterDBInstBase.resetHostPort();
                return true;
            }
            case 14: {
                pSDevCenterDBInstBase.resetHostSSHPort();
                return true;
            }
            case 15: {
                pSDevCenterDBInstBase.resetHostUserName();
                return true;
            }
            case 16: {
                pSDevCenterDBInstBase.resetLockMode();
                return true;
            }
            case 17: {
                pSDevCenterDBInstBase.resetLockObjId();
                return true;
            }
            case 18: {
                pSDevCenterDBInstBase.resetLockObjType();
                return true;
            }
            case 19: {
                pSDevCenterDBInstBase.resetMemo();
                return true;
            }
            case 20: {
                pSDevCenterDBInstBase.resetPasswd();
                return true;
            }
            case 21: {
                pSDevCenterDBInstBase.resetPSDBDevInstId();
                return true;
            }
            case 22: {
                pSDevCenterDBInstBase.resetPSDBDevInstName();
                return true;
            }
            case 23: {
                pSDevCenterDBInstBase.resetPSDCClusterId();
                return true;
            }
            case 24: {
                pSDevCenterDBInstBase.resetPSDCClusterName();
                return true;
            }
            case 25: {
                pSDevCenterDBInstBase.resetPSDCContainerSpecId();
                return true;
            }
            case 26: {
                pSDevCenterDBInstBase.resetPSDCContainerSpecName();
                return true;
            }
            case 27: {
                pSDevCenterDBInstBase.resetPSDCFileId();
                return true;
            }
            case 28: {
                pSDevCenterDBInstBase.resetPSDCFileName();
                return true;
            }
            case 29: {
                pSDevCenterDBInstBase.resetPSDevCenterASId();
                return true;
            }
            case 30: {
                pSDevCenterDBInstBase.resetPSDevCenterASName();
                return true;
            }
            case 31: {
                pSDevCenterDBInstBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 32: {
                pSDevCenterDBInstBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 33: {
                pSDevCenterDBInstBase.resetPSDevCenterId();
                return true;
            }
            case 34: {
                pSDevCenterDBInstBase.resetPSDevCenterName();
                return true;
            }
            case 35: {
                pSDevCenterDBInstBase.resetPSDevSlnId();
                return true;
            }
            case 36: {
                pSDevCenterDBInstBase.resetPSDevSlnName();
                return true;
            }
            case 37: {
                pSDevCenterDBInstBase.resetRefCount();
                return true;
            }
            case 38: {
                pSDevCenterDBInstBase.resetRefInfo();
                return true;
            }
            case 39: {
                pSDevCenterDBInstBase.resetResPos();
                return true;
            }
            case 40: {
                pSDevCenterDBInstBase.resetResReadyTime();
                return true;
            }
            case 41: {
                pSDevCenterDBInstBase.resetResState();
                return true;
            }
            case 42: {
                pSDevCenterDBInstBase.resetResVer();
                return true;
            }
            case 43: {
                pSDevCenterDBInstBase.resetSysMemo();
                return true;
            }
            case 44: {
                pSDevCenterDBInstBase.resetUpdateDate();
                return true;
            }
            case 45: {
                pSDevCenterDBInstBase.resetUpdateMan();
                return true;
            }
            case 46: {
                pSDevCenterDBInstBase.resetUploadFileMode();
                return true;
            }
            case 47: {
                pSDevCenterDBInstBase.resetUploadPath();
                return true;
            }
            case 48: {
                pSDevCenterDBInstBase.resetUsageMode();
                return true;
            }
            case 49: {
                pSDevCenterDBInstBase.resetUsedSize();
                return true;
            }
            case 50: {
                pSDevCenterDBInstBase.resetUserName();
                return true;
            }
            case 51: {
                pSDevCenterDBInstBase.resetUserParams();
                return true;
            }
            case 52: {
                pSDevCenterDBInstBase.resetUserTag();
                return true;
            }
            case 53: {
                pSDevCenterDBInstBase.resetUserTag2();
                return true;
            }
            case 54: {
                pSDevCenterDBInstBase.resetUserTag3();
                return true;
            }
            case 55: {
                pSDevCenterDBInstBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInst getPSDBDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInst();
        }
        if (this.getPSDBDevInstId() == null) {
            return null;
        }
        Integer n = this.objPSDBDevInstLock;
        synchronized (n) {
            if (this.psdbdevinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBDevInstId(), (Object)this.psdbdevinst.getPSDBDevInstId()) != 0L) {
                this.psdbdevinst = null;
            }
            if (this.psdbdevinst == null) {
                PSDBDevInst pSDBDevInst = new PSDBDevInst();
                pSDBDevInst.setPSDBDevInstId(this.getPSDBDevInstId());
                PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstService.autoGet((IEntity)pSDBDevInst);
                this.psdbdevinst = pSDBDevInst;
            }
            return this.psdbdevinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet((IEntity)pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet((IEntity)pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet((IEntity)pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevCenterDBInstBase getProxyEntity() {
        return this.proxyPSDevCenterDBInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterDBInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterDBInstBase) {
            this.proxyPSDevCenterDBInstBase = (PSDevCenterDBInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOCSIZE, 0);
        fieldIndexMap.put(FIELD_CONNSTR, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CURDBACTION, 4);
        fieldIndexMap.put(FIELD_DBINSTALLPATH, 5);
        fieldIndexMap.put(FIELD_DBNAME, 6);
        fieldIndexMap.put(FIELD_DBPORT, 7);
        fieldIndexMap.put(FIELD_DBTYPE, 8);
        fieldIndexMap.put(FIELD_DCINSTSTATE, 9);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 10);
        fieldIndexMap.put(FIELD_HOSTADDRESS, 11);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 12);
        fieldIndexMap.put(FIELD_HOSTPORT, 13);
        fieldIndexMap.put(FIELD_HOSTSSHPORT, 14);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 15);
        fieldIndexMap.put(FIELD_LOCKMODE, 16);
        fieldIndexMap.put(FIELD_LOCKOBJID, 17);
        fieldIndexMap.put(FIELD_LOCKOBJTYPE, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_PASSWD, 20);
        fieldIndexMap.put(FIELD_PSDBDEVINSTID, 21);
        fieldIndexMap.put(FIELD_PSDBDEVINSTNAME, 22);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 23);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 24);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 25);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 26);
        fieldIndexMap.put(FIELD_PSDCFILEID, 27);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 28);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 29);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 30);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 31);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 33);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 34);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 35);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 36);
        fieldIndexMap.put(FIELD_REFCOUNT, 37);
        fieldIndexMap.put(FIELD_REFINFO, 38);
        fieldIndexMap.put(FIELD_RESPOS, 39);
        fieldIndexMap.put(FIELD_RESREADYTIME, 40);
        fieldIndexMap.put(FIELD_RESSTATE, 41);
        fieldIndexMap.put(FIELD_RESVER, 42);
        fieldIndexMap.put(FIELD_SYSMEMO, 43);
        fieldIndexMap.put(FIELD_UPDATEDATE, 44);
        fieldIndexMap.put(FIELD_UPDATEMAN, 45);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 46);
        fieldIndexMap.put(FIELD_UPLOADPATH, 47);
        fieldIndexMap.put(FIELD_USAGEMODE, 48);
        fieldIndexMap.put(FIELD_USEDSIZE, 49);
        fieldIndexMap.put(FIELD_USERNAME, 50);
        fieldIndexMap.put(FIELD_USERPARAMS, 51);
        fieldIndexMap.put(FIELD_USERTAG, 52);
        fieldIndexMap.put(FIELD_USERTAG2, 53);
        fieldIndexMap.put(FIELD_USERTAG3, 54);
        fieldIndexMap.put(FIELD_USERTAG4, 55);
    }
}

