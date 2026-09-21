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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterASBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterASBase.class);
    public static final String FIELD_ASINSTALLPATH = "ASINSTALLPATH";
    public static final String FIELD_ASMODE = "ASMODE";
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HOSTADDRESS = "HOSTADDRESS";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTPORT = "HOSTPORT";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_LOCKMODE = "LOCKMODE";
    public static final String FIELD_LOCKOBJID = "LOCKOBJID";
    public static final String FIELD_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String FIELD_MAXCPU = "MAXCPU";
    public static final String FIELD_MAXMEM = "MAXMEN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINCPU = "MINCPU";
    public static final String FIELD_MINMEM = "MINMEN";
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSASBKLISTS = "PSASBKLISTS";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCDBLISTS = "PSDCDBLISTS";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String FIELD_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REFFLAG = "REFFLAG";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_STARTCMD = "STARTCMD";
    public static final String FIELD_STOPCMD = "STOPCMD";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ASINSTALLPATH = 0;
    private static final int INDEX_ASMODE = 1;
    private static final int INDEX_ASTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_EXPRIEDTIME = 5;
    private static final int INDEX_HOSTADDRESS = 6;
    private static final int INDEX_HOSTPASSWD = 7;
    private static final int INDEX_HOSTPORT = 8;
    private static final int INDEX_HOSTUSERNAME = 9;
    private static final int INDEX_HTTPADDRESS = 10;
    private static final int INDEX_HTTPPORT = 11;
    private static final int INDEX_HTTPSPORT = 12;
    private static final int INDEX_LOCKMODE = 13;
    private static final int INDEX_LOCKOBJID = 14;
    private static final int INDEX_LOCKOBJTYPE = 15;
    private static final int INDEX_MAXCPU = 16;
    private static final int INDEX_MAXMEM = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_MINCPU = 19;
    private static final int INDEX_MINMEM = 20;
    private static final int INDEX_PSAPPSERVERID = 21;
    private static final int INDEX_PSAPPSERVERNAME = 22;
    private static final int INDEX_PSASBKLISTS = 23;
    private static final int INDEX_PSDCCLUSTERID = 24;
    private static final int INDEX_PSDCCLUSTERNAME = 25;
    private static final int INDEX_PSDCCONTAINERSPECID = 26;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 27;
    private static final int INDEX_PSDCDBLISTS = 28;
    private static final int INDEX_PSDCFILEID = 29;
    private static final int INDEX_PSDCFILENAME = 30;
    private static final int INDEX_PSDEVCENTERASID = 31;
    private static final int INDEX_PSDEVCENTERASNAME = 32;
    private static final int INDEX_PSDEVCENTERID = 33;
    private static final int INDEX_PSDEVCENTERNAME = 34;
    private static final int INDEX_PSDEVCENTERSERVERID = 35;
    private static final int INDEX_PSDEVCENTERSERVERNAME = 36;
    private static final int INDEX_PSDEVSLNID = 37;
    private static final int INDEX_PSDEVSLNNAME = 38;
    private static final int INDEX_REFFLAG = 39;
    private static final int INDEX_REFOBJID = 40;
    private static final int INDEX_REFOBJNAME = 41;
    private static final int INDEX_REFOBJTYPE = 42;
    private static final int INDEX_RESPOS = 43;
    private static final int INDEX_RESREADYTIME = 44;
    private static final int INDEX_RESSTATE = 45;
    private static final int INDEX_RESVER = 46;
    private static final int INDEX_STARTCMD = 47;
    private static final int INDEX_STOPCMD = 48;
    private static final int INDEX_UPDATEDATE = 49;
    private static final int INDEX_UPDATEMAN = 50;
    private static final int INDEX_UPLOADFILEMODE = 51;
    private static final int INDEX_UPLOADPATH = 52;
    private static final int INDEX_USAGEMODE = 53;
    private static final int INDEX_USERTAG = 54;
    private static final int INDEX_USERTAG2 = 55;
    private static final int INDEX_USERTAG3 = 56;
    private static final int INDEX_USERTAG4 = 57;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterASBase proxyPSDevCenterASBase = null;
    private boolean asinstallpathDirtyFlag = false;
    private boolean asmodeDirtyFlag = false;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean hostaddressDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostportDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean lockmodeDirtyFlag = false;
    private boolean lockobjidDirtyFlag = false;
    private boolean lockobjtypeDirtyFlag = false;
    private boolean maxcpuDirtyFlag = false;
    private boolean maxmemDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mincpuDirtyFlag = false;
    private boolean minmemDirtyFlag = false;
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psasbklistsDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcdblistsDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterserveridDirtyFlag = false;
    private boolean psdevcenterservernameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean refflagDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean startcmdDirtyFlag = false;
    private boolean stopcmdDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="asinstallpath")
    private String asinstallpath;
    @Column(name="asmode")
    private String asmode;
    @Column(name="astype")
    private String astype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="hostaddress")
    private String hostaddress;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostport")
    private Integer hostport;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="lockmode")
    private Integer lockmode;
    @Column(name="lockobjid")
    private String lockobjid;
    @Column(name="lockobjtype")
    private String lockobjtype;
    @Column(name="maxcpu")
    private Double maxcpu;
    @Column(name="maxmem")
    private Double maxmem;
    @Column(name="memo")
    private String memo;
    @Column(name="mincpu")
    private Double mincpu;
    @Column(name="minmem")
    private Double minmem;
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psasbklists")
    private String psasbklists;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcdblists")
    private String psdcdblists;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcenterserverid")
    private String psdevcenterserverid;
    @Column(name="psdevcenterservername")
    private String psdevcenterservername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="refflag")
    private Integer refflag;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
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
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSAppServerLock = new Integer(1);
    private PSAppServer psappserver = null;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterServerLock = new Integer(1);
    private PSDevCenterServer psdevcenterserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setASInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asinstallpath = string;
        this.asinstallpathDirtyFlag = true;
    }

    public String getASInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASInstallPath();
        }
        return this.asinstallpath;
    }

    public boolean isASInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASInstallPathDirty();
        }
        return this.asinstallpathDirtyFlag;
    }

    public void resetASInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASInstallPath();
            return;
        }
        this.asinstallpathDirtyFlag = false;
        this.asinstallpath = null;
    }

    public void setASMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asmode = string;
        this.asmodeDirtyFlag = true;
    }

    public String getASMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASMode();
        }
        return this.asmode;
    }

    public boolean isASModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASModeDirty();
        }
        return this.asmodeDirtyFlag;
    }

    public void resetASMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASMode();
            return;
        }
        this.asmodeDirtyFlag = false;
        this.asmode = null;
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

    public void setHostPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostpasswd = string;
        this.hostpasswdDirtyFlag = true;
    }

    public String getHostPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPasswd();
        }
        return this.hostpasswd;
    }

    public boolean isHostPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPasswdDirty();
        }
        return this.hostpasswdDirtyFlag;
    }

    public void resetHostPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPasswd();
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

    public void setMaxCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCPU(d);
            return;
        }
        this.maxcpu = d;
        this.maxcpuDirtyFlag = true;
    }

    public Double getMaxCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCPU();
        }
        return this.maxcpu;
    }

    public boolean isMaxCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCPUDirty();
        }
        return this.maxcpuDirtyFlag;
    }

    public void resetMaxCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCPU();
            return;
        }
        this.maxcpuDirtyFlag = false;
        this.maxcpu = null;
    }

    public void setMaxMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMem(d);
            return;
        }
        this.maxmem = d;
        this.maxmemDirtyFlag = true;
    }

    public Double getMaxMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMem();
        }
        return this.maxmem;
    }

    public boolean isMaxMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMemDirty();
        }
        return this.maxmemDirtyFlag;
    }

    public void resetMaxMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMem();
            return;
        }
        this.maxmemDirtyFlag = false;
        this.maxmem = null;
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

    public void setMinCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinCPU(d);
            return;
        }
        this.mincpu = d;
        this.mincpuDirtyFlag = true;
    }

    public Double getMinCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinCPU();
        }
        return this.mincpu;
    }

    public boolean isMinCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinCPUDirty();
        }
        return this.mincpuDirtyFlag;
    }

    public void resetMinCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinCPU();
            return;
        }
        this.mincpuDirtyFlag = false;
        this.mincpu = null;
    }

    public void setMinMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinMem(d);
            return;
        }
        this.minmem = d;
        this.minmemDirtyFlag = true;
    }

    public Double getMinMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinMem();
        }
        return this.minmem;
    }

    public boolean isMinMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinMemDirty();
        }
        return this.minmemDirtyFlag;
    }

    public void resetMinMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinMem();
            return;
        }
        this.minmemDirtyFlag = false;
        this.minmem = null;
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

    public void setPSASBKLists(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASBKLists(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasbklists = string;
        this.psasbklistsDirtyFlag = true;
    }

    public String getPSASBKLists() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBKLists();
        }
        return this.psasbklists;
    }

    public boolean isPSASBKListsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASBKListsDirty();
        }
        return this.psasbklistsDirtyFlag;
    }

    public void resetPSASBKLists() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASBKLists();
            return;
        }
        this.psasbklistsDirtyFlag = false;
        this.psasbklists = null;
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

    public void setPSDCDBLists(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBLists(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdblists = string;
        this.psdcdblistsDirtyFlag = true;
    }

    public String getPSDCDBLists() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBLists();
        }
        return this.psdcdblists;
    }

    public boolean isPSDCDBListsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBListsDirty();
        }
        return this.psdcdblistsDirtyFlag;
    }

    public void resetPSDCDBLists() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBLists();
            return;
        }
        this.psdcdblistsDirtyFlag = false;
        this.psdcdblists = null;
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

    public void setPSDevCenterServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterserverid = string;
        this.psdevcenterserveridDirtyFlag = true;
    }

    public String getPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerId();
        }
        return this.psdevcenterserverid;
    }

    public boolean isPSDevCenterServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerIdDirty();
        }
        return this.psdevcenterserveridDirtyFlag;
    }

    public void resetPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerId();
            return;
        }
        this.psdevcenterserveridDirtyFlag = false;
        this.psdevcenterserverid = null;
    }

    public void setPSDevCenterServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterservername = string;
        this.psdevcenterservernameDirtyFlag = true;
    }

    public String getPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerName();
        }
        return this.psdevcenterservername;
    }

    public boolean isPSDevCenterServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerNameDirty();
        }
        return this.psdevcenterservernameDirtyFlag;
    }

    public void resetPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerName();
            return;
        }
        this.psdevcenterservernameDirtyFlag = false;
        this.psdevcenterservername = null;
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

    public void setRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFlag(n);
            return;
        }
        this.refflag = n;
        this.refflagDirtyFlag = true;
    }

    public Integer getRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFlag();
        }
        return this.refflag;
    }

    public boolean isRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFlagDirty();
        }
        return this.refflagDirtyFlag;
    }

    public void resetRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFlag();
            return;
        }
        this.refflagDirtyFlag = false;
        this.refflag = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
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
        PSDevCenterASBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterASBase pSDevCenterASBase) {
        pSDevCenterASBase.resetASInstallPath();
        pSDevCenterASBase.resetASMode();
        pSDevCenterASBase.resetASType();
        pSDevCenterASBase.resetCreateDate();
        pSDevCenterASBase.resetCreateMan();
        pSDevCenterASBase.resetExpriedTime();
        pSDevCenterASBase.resetHostAddress();
        pSDevCenterASBase.resetHostPasswd();
        pSDevCenterASBase.resetHostPort();
        pSDevCenterASBase.resetHostUserName();
        pSDevCenterASBase.resetHttpAddress();
        pSDevCenterASBase.resetHttpPort();
        pSDevCenterASBase.resetHttpsPort();
        pSDevCenterASBase.resetLockMode();
        pSDevCenterASBase.resetLockObjId();
        pSDevCenterASBase.resetLockObjType();
        pSDevCenterASBase.resetMaxCPU();
        pSDevCenterASBase.resetMaxMem();
        pSDevCenterASBase.resetMemo();
        pSDevCenterASBase.resetMinCPU();
        pSDevCenterASBase.resetMinMem();
        pSDevCenterASBase.resetPSAppServerId();
        pSDevCenterASBase.resetPSAppServerName();
        pSDevCenterASBase.resetPSASBKLists();
        pSDevCenterASBase.resetPSDCClusterId();
        pSDevCenterASBase.resetPSDCClusterName();
        pSDevCenterASBase.resetPSDCContainerSpecId();
        pSDevCenterASBase.resetPSDCContainerSpecName();
        pSDevCenterASBase.resetPSDCDBLists();
        pSDevCenterASBase.resetPSDCFileId();
        pSDevCenterASBase.resetPSDCFileName();
        pSDevCenterASBase.resetPSDevCenterASId();
        pSDevCenterASBase.resetPSDevCenterASName();
        pSDevCenterASBase.resetPSDevCenterId();
        pSDevCenterASBase.resetPSDevCenterName();
        pSDevCenterASBase.resetPSDevCenterServerId();
        pSDevCenterASBase.resetPSDevCenterServerName();
        pSDevCenterASBase.resetPSDevSlnId();
        pSDevCenterASBase.resetPSDevSlnName();
        pSDevCenterASBase.resetRefFlag();
        pSDevCenterASBase.resetRefObjId();
        pSDevCenterASBase.resetRefObjName();
        pSDevCenterASBase.resetRefObjType();
        pSDevCenterASBase.resetResPos();
        pSDevCenterASBase.resetResReadyTime();
        pSDevCenterASBase.resetResState();
        pSDevCenterASBase.resetResVer();
        pSDevCenterASBase.resetStartCmd();
        pSDevCenterASBase.resetStopCmd();
        pSDevCenterASBase.resetUpdateDate();
        pSDevCenterASBase.resetUpdateMan();
        pSDevCenterASBase.resetUploadFileMode();
        pSDevCenterASBase.resetUploadPath();
        pSDevCenterASBase.resetUsageMode();
        pSDevCenterASBase.resetUserTag();
        pSDevCenterASBase.resetUserTag2();
        pSDevCenterASBase.resetUserTag3();
        pSDevCenterASBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASInstallPathDirty()) {
            hashMap.put(FIELD_ASINSTALLPATH, this.getASInstallPath());
        }
        if (!bl || this.isASModeDirty()) {
            hashMap.put(FIELD_ASMODE, this.getASMode());
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
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHostAddressDirty()) {
            hashMap.put(FIELD_HOSTADDRESS, this.getHostAddress());
        }
        if (!bl || this.isHostPasswdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPasswd());
        }
        if (!bl || this.isHostPortDirty()) {
            hashMap.put(FIELD_HOSTPORT, this.getHostPort());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
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
        if (!bl || this.isLockModeDirty()) {
            hashMap.put(FIELD_LOCKMODE, this.getLockMode());
        }
        if (!bl || this.isLockObjIdDirty()) {
            hashMap.put(FIELD_LOCKOBJID, this.getLockObjId());
        }
        if (!bl || this.isLockObjTypeDirty()) {
            hashMap.put(FIELD_LOCKOBJTYPE, this.getLockObjType());
        }
        if (!bl || this.isMaxCPUDirty()) {
            hashMap.put(FIELD_MAXCPU, this.getMaxCPU());
        }
        if (!bl || this.isMaxMemDirty()) {
            hashMap.put(FIELD_MAXMEM, this.getMaxMem());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinCPUDirty()) {
            hashMap.put(FIELD_MINCPU, this.getMinCPU());
        }
        if (!bl || this.isMinMemDirty()) {
            hashMap.put(FIELD_MINMEM, this.getMinMem());
        }
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSASBKListsDirty()) {
            hashMap.put(FIELD_PSASBKLISTS, this.getPSASBKLists());
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
        if (!bl || this.isPSDCDBListsDirty()) {
            hashMap.put(FIELD_PSDCDBLISTS, this.getPSDCDBLists());
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterServerIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERID, this.getPSDevCenterServerId());
        }
        if (!bl || this.isPSDevCenterServerNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERNAME, this.getPSDevCenterServerName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isRefFlagDirty()) {
            hashMap.put(FIELD_REFFLAG, this.getRefFlag());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
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
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
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
        return PSDevCenterASBase.get(this, n);
    }

    private static Object get(PSDevCenterASBase pSDevCenterASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterASBase.getASInstallPath();
            }
            case 1: {
                return pSDevCenterASBase.getASMode();
            }
            case 2: {
                return pSDevCenterASBase.getASType();
            }
            case 3: {
                return pSDevCenterASBase.getCreateDate();
            }
            case 4: {
                return pSDevCenterASBase.getCreateMan();
            }
            case 5: {
                return pSDevCenterASBase.getExpriedTime();
            }
            case 6: {
                return pSDevCenterASBase.getHostAddress();
            }
            case 7: {
                return pSDevCenterASBase.getHostPasswd();
            }
            case 8: {
                return pSDevCenterASBase.getHostPort();
            }
            case 9: {
                return pSDevCenterASBase.getHostUserName();
            }
            case 10: {
                return pSDevCenterASBase.getHttpAddress();
            }
            case 11: {
                return pSDevCenterASBase.getHttpPort();
            }
            case 12: {
                return pSDevCenterASBase.getHttpsPort();
            }
            case 13: {
                return pSDevCenterASBase.getLockMode();
            }
            case 14: {
                return pSDevCenterASBase.getLockObjId();
            }
            case 15: {
                return pSDevCenterASBase.getLockObjType();
            }
            case 16: {
                return pSDevCenterASBase.getMaxCPU();
            }
            case 17: {
                return pSDevCenterASBase.getMaxMem();
            }
            case 18: {
                return pSDevCenterASBase.getMemo();
            }
            case 19: {
                return pSDevCenterASBase.getMinCPU();
            }
            case 20: {
                return pSDevCenterASBase.getMinMem();
            }
            case 21: {
                return pSDevCenterASBase.getPSAppServerId();
            }
            case 22: {
                return pSDevCenterASBase.getPSAppServerName();
            }
            case 23: {
                return pSDevCenterASBase.getPSASBKLists();
            }
            case 24: {
                return pSDevCenterASBase.getPSDCClusterId();
            }
            case 25: {
                return pSDevCenterASBase.getPSDCClusterName();
            }
            case 26: {
                return pSDevCenterASBase.getPSDCContainerSpecId();
            }
            case 27: {
                return pSDevCenterASBase.getPSDCContainerSpecName();
            }
            case 28: {
                return pSDevCenterASBase.getPSDCDBLists();
            }
            case 29: {
                return pSDevCenterASBase.getPSDCFileId();
            }
            case 30: {
                return pSDevCenterASBase.getPSDCFileName();
            }
            case 31: {
                return pSDevCenterASBase.getPSDevCenterASId();
            }
            case 32: {
                return pSDevCenterASBase.getPSDevCenterASName();
            }
            case 33: {
                return pSDevCenterASBase.getPSDevCenterId();
            }
            case 34: {
                return pSDevCenterASBase.getPSDevCenterName();
            }
            case 35: {
                return pSDevCenterASBase.getPSDevCenterServerId();
            }
            case 36: {
                return pSDevCenterASBase.getPSDevCenterServerName();
            }
            case 37: {
                return pSDevCenterASBase.getPSDevSlnId();
            }
            case 38: {
                return pSDevCenterASBase.getPSDevSlnName();
            }
            case 39: {
                return pSDevCenterASBase.getRefFlag();
            }
            case 40: {
                return pSDevCenterASBase.getRefObjId();
            }
            case 41: {
                return pSDevCenterASBase.getRefObjName();
            }
            case 42: {
                return pSDevCenterASBase.getRefObjType();
            }
            case 43: {
                return pSDevCenterASBase.getResPos();
            }
            case 44: {
                return pSDevCenterASBase.getResReadyTime();
            }
            case 45: {
                return pSDevCenterASBase.getResState();
            }
            case 46: {
                return pSDevCenterASBase.getResVer();
            }
            case 47: {
                return pSDevCenterASBase.getStartCmd();
            }
            case 48: {
                return pSDevCenterASBase.getStopCmd();
            }
            case 49: {
                return pSDevCenterASBase.getUpdateDate();
            }
            case 50: {
                return pSDevCenterASBase.getUpdateMan();
            }
            case 51: {
                return pSDevCenterASBase.getUploadFileMode();
            }
            case 52: {
                return pSDevCenterASBase.getUploadPath();
            }
            case 53: {
                return pSDevCenterASBase.getUsageMode();
            }
            case 54: {
                return pSDevCenterASBase.getUserTag();
            }
            case 55: {
                return pSDevCenterASBase.getUserTag2();
            }
            case 56: {
                return pSDevCenterASBase.getUserTag3();
            }
            case 57: {
                return pSDevCenterASBase.getUserTag4();
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
        PSDevCenterASBase.set(this, n, object);
    }

    private static void set(PSDevCenterASBase pSDevCenterASBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterASBase.setASInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterASBase.setASMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterASBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterASBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterASBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterASBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterASBase.setHostAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterASBase.setHostPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterASBase.setHostPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterASBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterASBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterASBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterASBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterASBase.setLockMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterASBase.setLockObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterASBase.setLockObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterASBase.setMaxCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterASBase.setMaxMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterASBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterASBase.setMinCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterASBase.setMinMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterASBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterASBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterASBase.setPSASBKLists(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterASBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterASBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterASBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterASBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterASBase.setPSDCDBLists(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterASBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterASBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterASBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevCenterASBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevCenterASBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevCenterASBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevCenterASBase.setPSDevCenterServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevCenterASBase.setPSDevCenterServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevCenterASBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevCenterASBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevCenterASBase.setRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDevCenterASBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevCenterASBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevCenterASBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevCenterASBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDevCenterASBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSDevCenterASBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDevCenterASBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDevCenterASBase.setStartCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevCenterASBase.setStopCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevCenterASBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 50: {
                pSDevCenterASBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevCenterASBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevCenterASBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDevCenterASBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDevCenterASBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDevCenterASBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDevCenterASBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDevCenterASBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevCenterASBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterASBase pSDevCenterASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterASBase.getASInstallPath() == null;
            }
            case 1: {
                return pSDevCenterASBase.getASMode() == null;
            }
            case 2: {
                return pSDevCenterASBase.getASType() == null;
            }
            case 3: {
                return pSDevCenterASBase.getCreateDate() == null;
            }
            case 4: {
                return pSDevCenterASBase.getCreateMan() == null;
            }
            case 5: {
                return pSDevCenterASBase.getExpriedTime() == null;
            }
            case 6: {
                return pSDevCenterASBase.getHostAddress() == null;
            }
            case 7: {
                return pSDevCenterASBase.getHostPasswd() == null;
            }
            case 8: {
                return pSDevCenterASBase.getHostPort() == null;
            }
            case 9: {
                return pSDevCenterASBase.getHostUserName() == null;
            }
            case 10: {
                return pSDevCenterASBase.getHttpAddress() == null;
            }
            case 11: {
                return pSDevCenterASBase.getHttpPort() == null;
            }
            case 12: {
                return pSDevCenterASBase.getHttpsPort() == null;
            }
            case 13: {
                return pSDevCenterASBase.getLockMode() == null;
            }
            case 14: {
                return pSDevCenterASBase.getLockObjId() == null;
            }
            case 15: {
                return pSDevCenterASBase.getLockObjType() == null;
            }
            case 16: {
                return pSDevCenterASBase.getMaxCPU() == null;
            }
            case 17: {
                return pSDevCenterASBase.getMaxMem() == null;
            }
            case 18: {
                return pSDevCenterASBase.getMemo() == null;
            }
            case 19: {
                return pSDevCenterASBase.getMinCPU() == null;
            }
            case 20: {
                return pSDevCenterASBase.getMinMem() == null;
            }
            case 21: {
                return pSDevCenterASBase.getPSAppServerId() == null;
            }
            case 22: {
                return pSDevCenterASBase.getPSAppServerName() == null;
            }
            case 23: {
                return pSDevCenterASBase.getPSASBKLists() == null;
            }
            case 24: {
                return pSDevCenterASBase.getPSDCClusterId() == null;
            }
            case 25: {
                return pSDevCenterASBase.getPSDCClusterName() == null;
            }
            case 26: {
                return pSDevCenterASBase.getPSDCContainerSpecId() == null;
            }
            case 27: {
                return pSDevCenterASBase.getPSDCContainerSpecName() == null;
            }
            case 28: {
                return pSDevCenterASBase.getPSDCDBLists() == null;
            }
            case 29: {
                return pSDevCenterASBase.getPSDCFileId() == null;
            }
            case 30: {
                return pSDevCenterASBase.getPSDCFileName() == null;
            }
            case 31: {
                return pSDevCenterASBase.getPSDevCenterASId() == null;
            }
            case 32: {
                return pSDevCenterASBase.getPSDevCenterASName() == null;
            }
            case 33: {
                return pSDevCenterASBase.getPSDevCenterId() == null;
            }
            case 34: {
                return pSDevCenterASBase.getPSDevCenterName() == null;
            }
            case 35: {
                return pSDevCenterASBase.getPSDevCenterServerId() == null;
            }
            case 36: {
                return pSDevCenterASBase.getPSDevCenterServerName() == null;
            }
            case 37: {
                return pSDevCenterASBase.getPSDevSlnId() == null;
            }
            case 38: {
                return pSDevCenterASBase.getPSDevSlnName() == null;
            }
            case 39: {
                return pSDevCenterASBase.getRefFlag() == null;
            }
            case 40: {
                return pSDevCenterASBase.getRefObjId() == null;
            }
            case 41: {
                return pSDevCenterASBase.getRefObjName() == null;
            }
            case 42: {
                return pSDevCenterASBase.getRefObjType() == null;
            }
            case 43: {
                return pSDevCenterASBase.getResPos() == null;
            }
            case 44: {
                return pSDevCenterASBase.getResReadyTime() == null;
            }
            case 45: {
                return pSDevCenterASBase.getResState() == null;
            }
            case 46: {
                return pSDevCenterASBase.getResVer() == null;
            }
            case 47: {
                return pSDevCenterASBase.getStartCmd() == null;
            }
            case 48: {
                return pSDevCenterASBase.getStopCmd() == null;
            }
            case 49: {
                return pSDevCenterASBase.getUpdateDate() == null;
            }
            case 50: {
                return pSDevCenterASBase.getUpdateMan() == null;
            }
            case 51: {
                return pSDevCenterASBase.getUploadFileMode() == null;
            }
            case 52: {
                return pSDevCenterASBase.getUploadPath() == null;
            }
            case 53: {
                return pSDevCenterASBase.getUsageMode() == null;
            }
            case 54: {
                return pSDevCenterASBase.getUserTag() == null;
            }
            case 55: {
                return pSDevCenterASBase.getUserTag2() == null;
            }
            case 56: {
                return pSDevCenterASBase.getUserTag3() == null;
            }
            case 57: {
                return pSDevCenterASBase.getUserTag4() == null;
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
        return PSDevCenterASBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterASBase pSDevCenterASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterASBase.isASInstallPathDirty();
            }
            case 1: {
                return pSDevCenterASBase.isASModeDirty();
            }
            case 2: {
                return pSDevCenterASBase.isASTypeDirty();
            }
            case 3: {
                return pSDevCenterASBase.isCreateDateDirty();
            }
            case 4: {
                return pSDevCenterASBase.isCreateManDirty();
            }
            case 5: {
                return pSDevCenterASBase.isExpriedTimeDirty();
            }
            case 6: {
                return pSDevCenterASBase.isHostAddressDirty();
            }
            case 7: {
                return pSDevCenterASBase.isHostPasswdDirty();
            }
            case 8: {
                return pSDevCenterASBase.isHostPortDirty();
            }
            case 9: {
                return pSDevCenterASBase.isHostUserNameDirty();
            }
            case 10: {
                return pSDevCenterASBase.isHttpAddressDirty();
            }
            case 11: {
                return pSDevCenterASBase.isHttpPortDirty();
            }
            case 12: {
                return pSDevCenterASBase.isHttpsPortDirty();
            }
            case 13: {
                return pSDevCenterASBase.isLockModeDirty();
            }
            case 14: {
                return pSDevCenterASBase.isLockObjIdDirty();
            }
            case 15: {
                return pSDevCenterASBase.isLockObjTypeDirty();
            }
            case 16: {
                return pSDevCenterASBase.isMaxCPUDirty();
            }
            case 17: {
                return pSDevCenterASBase.isMaxMemDirty();
            }
            case 18: {
                return pSDevCenterASBase.isMemoDirty();
            }
            case 19: {
                return pSDevCenterASBase.isMinCPUDirty();
            }
            case 20: {
                return pSDevCenterASBase.isMinMemDirty();
            }
            case 21: {
                return pSDevCenterASBase.isPSAppServerIdDirty();
            }
            case 22: {
                return pSDevCenterASBase.isPSAppServerNameDirty();
            }
            case 23: {
                return pSDevCenterASBase.isPSASBKListsDirty();
            }
            case 24: {
                return pSDevCenterASBase.isPSDCClusterIdDirty();
            }
            case 25: {
                return pSDevCenterASBase.isPSDCClusterNameDirty();
            }
            case 26: {
                return pSDevCenterASBase.isPSDCContainerSpecIdDirty();
            }
            case 27: {
                return pSDevCenterASBase.isPSDCContainerSpecNameDirty();
            }
            case 28: {
                return pSDevCenterASBase.isPSDCDBListsDirty();
            }
            case 29: {
                return pSDevCenterASBase.isPSDCFileIdDirty();
            }
            case 30: {
                return pSDevCenterASBase.isPSDCFileNameDirty();
            }
            case 31: {
                return pSDevCenterASBase.isPSDevCenterASIdDirty();
            }
            case 32: {
                return pSDevCenterASBase.isPSDevCenterASNameDirty();
            }
            case 33: {
                return pSDevCenterASBase.isPSDevCenterIdDirty();
            }
            case 34: {
                return pSDevCenterASBase.isPSDevCenterNameDirty();
            }
            case 35: {
                return pSDevCenterASBase.isPSDevCenterServerIdDirty();
            }
            case 36: {
                return pSDevCenterASBase.isPSDevCenterServerNameDirty();
            }
            case 37: {
                return pSDevCenterASBase.isPSDevSlnIdDirty();
            }
            case 38: {
                return pSDevCenterASBase.isPSDevSlnNameDirty();
            }
            case 39: {
                return pSDevCenterASBase.isRefFlagDirty();
            }
            case 40: {
                return pSDevCenterASBase.isRefObjIdDirty();
            }
            case 41: {
                return pSDevCenterASBase.isRefObjNameDirty();
            }
            case 42: {
                return pSDevCenterASBase.isRefObjTypeDirty();
            }
            case 43: {
                return pSDevCenterASBase.isResPosDirty();
            }
            case 44: {
                return pSDevCenterASBase.isResReadyTimeDirty();
            }
            case 45: {
                return pSDevCenterASBase.isResStateDirty();
            }
            case 46: {
                return pSDevCenterASBase.isResVerDirty();
            }
            case 47: {
                return pSDevCenterASBase.isStartCmdDirty();
            }
            case 48: {
                return pSDevCenterASBase.isStopCmdDirty();
            }
            case 49: {
                return pSDevCenterASBase.isUpdateDateDirty();
            }
            case 50: {
                return pSDevCenterASBase.isUpdateManDirty();
            }
            case 51: {
                return pSDevCenterASBase.isUploadFileModeDirty();
            }
            case 52: {
                return pSDevCenterASBase.isUploadPathDirty();
            }
            case 53: {
                return pSDevCenterASBase.isUsageModeDirty();
            }
            case 54: {
                return pSDevCenterASBase.isUserTagDirty();
            }
            case 55: {
                return pSDevCenterASBase.isUserTag2Dirty();
            }
            case 56: {
                return pSDevCenterASBase.isUserTag3Dirty();
            }
            case 57: {
                return pSDevCenterASBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterASBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterASBase pSDevCenterASBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterASBase.getASInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asinstallpath", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getASInstallPath()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getASMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asmode", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getASMode()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getASType()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHostAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostaddress", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHostAddress()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHostPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHostPasswd()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHostPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostport", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHostPort()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getLockMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockmode", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getLockMode()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getLockObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getLockObjId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getLockObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjtype", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getLockObjType()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getMaxCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcpu", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getMaxCPU()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getMaxMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmen", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getMaxMem()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getMinCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mincpu", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getMinCPU()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getMinMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minmen", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getMinMem()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSASBKLists() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasbklists", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSASBKLists()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCDBLists() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdblists", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCDBLists()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterserverid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterServerId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterservername", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevCenterServerName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refflag", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getRefFlag()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getResState()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getResVer()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getStartCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startcmd", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getStartCmd()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getStopCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopcmd", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getStopCmd()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevCenterASBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevCenterASBase.getJSONValue((Object)pSDevCenterASBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterASBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterASBase pSDevCenterASBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterASBase.getASInstallPath() != null) {
            object = pSDevCenterASBase.getASInstallPath();
            xmlNode.setAttribute(FIELD_ASINSTALLPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSDevCenterASBase.getASMode() != null) {
            object = pSDevCenterASBase.getASMode();
            xmlNode.setAttribute(FIELD_ASMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevCenterASBase.getASType() != null) {
            object = pSDevCenterASBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getCreateDate() != null) {
            object = pSDevCenterASBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterASBase.getCreateMan() != null) {
            object = pSDevCenterASBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getExpriedTime() != null) {
            object = pSDevCenterASBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterASBase.getHostAddress() != null) {
            object = pSDevCenterASBase.getHostAddress();
            xmlNode.setAttribute(FIELD_HOSTADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getHostPasswd() != null) {
            object = pSDevCenterASBase.getHostPasswd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getHostPort() != null) {
            object = pSDevCenterASBase.getHostPort();
            xmlNode.setAttribute(FIELD_HOSTPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getHostUserName() != null) {
            object = pSDevCenterASBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getHttpAddress() != null) {
            object = pSDevCenterASBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getHttpPort() != null) {
            object = pSDevCenterASBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getHttpsPort() != null) {
            object = pSDevCenterASBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getLockMode() != null) {
            object = pSDevCenterASBase.getLockMode();
            xmlNode.setAttribute(FIELD_LOCKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getLockObjId() != null) {
            object = pSDevCenterASBase.getLockObjId();
            xmlNode.setAttribute(FIELD_LOCKOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getLockObjType() != null) {
            object = pSDevCenterASBase.getLockObjType();
            xmlNode.setAttribute(FIELD_LOCKOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getMaxCPU() != null) {
            object = pSDevCenterASBase.getMaxCPU();
            xmlNode.setAttribute(FIELD_MAXCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getMaxMem() != null) {
            object = pSDevCenterASBase.getMaxMem();
            xmlNode.setAttribute("MAXMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getMemo() != null) {
            object = pSDevCenterASBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getMinCPU() != null) {
            object = pSDevCenterASBase.getMinCPU();
            xmlNode.setAttribute(FIELD_MINCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getMinMem() != null) {
            object = pSDevCenterASBase.getMinMem();
            xmlNode.setAttribute("MINMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getPSAppServerId() != null) {
            object = pSDevCenterASBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSAppServerName() != null) {
            object = pSDevCenterASBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSASBKLists() != null) {
            object = pSDevCenterASBase.getPSASBKLists();
            xmlNode.setAttribute(FIELD_PSASBKLISTS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCClusterId() != null) {
            object = pSDevCenterASBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCClusterName() != null) {
            object = pSDevCenterASBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCContainerSpecId() != null) {
            object = pSDevCenterASBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCContainerSpecName() != null) {
            object = pSDevCenterASBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCDBLists() != null) {
            object = pSDevCenterASBase.getPSDCDBLists();
            xmlNode.setAttribute(FIELD_PSDCDBLISTS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCFileId() != null) {
            object = pSDevCenterASBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDCFileName() != null) {
            object = pSDevCenterASBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterASId() != null) {
            object = pSDevCenterASBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterASName() != null) {
            object = pSDevCenterASBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterId() != null) {
            object = pSDevCenterASBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterName() != null) {
            object = pSDevCenterASBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterServerId() != null) {
            object = pSDevCenterASBase.getPSDevCenterServerId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevCenterServerName() != null) {
            object = pSDevCenterASBase.getPSDevCenterServerName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevSlnId() != null) {
            object = pSDevCenterASBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getPSDevSlnName() != null) {
            object = pSDevCenterASBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getRefFlag() != null) {
            object = pSDevCenterASBase.getRefFlag();
            xmlNode.setAttribute(FIELD_REFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getRefObjId() != null) {
            object = pSDevCenterASBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getRefObjName() != null) {
            object = pSDevCenterASBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getRefObjType() != null) {
            object = pSDevCenterASBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getResPos() != null) {
            object = pSDevCenterASBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getResReadyTime() != null) {
            object = pSDevCenterASBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterASBase.getResState() != null) {
            object = pSDevCenterASBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getResVer() != null) {
            object = pSDevCenterASBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterASBase.getStartCmd() != null) {
            object = pSDevCenterASBase.getStartCmd();
            xmlNode.setAttribute(FIELD_STARTCMD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getStopCmd() != null) {
            object = pSDevCenterASBase.getStopCmd();
            xmlNode.setAttribute(FIELD_STOPCMD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUpdateDate() != null) {
            object = pSDevCenterASBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterASBase.getUpdateMan() != null) {
            object = pSDevCenterASBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUploadFileMode() != null) {
            object = pSDevCenterASBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUploadPath() != null) {
            object = pSDevCenterASBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUsageMode() != null) {
            object = pSDevCenterASBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUserTag() != null) {
            object = pSDevCenterASBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUserTag2() != null) {
            object = pSDevCenterASBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUserTag3() != null) {
            object = pSDevCenterASBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterASBase.getUserTag4() != null) {
            object = pSDevCenterASBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterASBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterASBase pSDevCenterASBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterASBase.isASInstallPathDirty() && (bl || pSDevCenterASBase.getASInstallPath() != null)) {
            iDataObject.set(FIELD_ASINSTALLPATH, (Object)pSDevCenterASBase.getASInstallPath());
        }
        if (pSDevCenterASBase.isASModeDirty() && (bl || pSDevCenterASBase.getASMode() != null)) {
            iDataObject.set(FIELD_ASMODE, (Object)pSDevCenterASBase.getASMode());
        }
        if (pSDevCenterASBase.isASTypeDirty() && (bl || pSDevCenterASBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSDevCenterASBase.getASType());
        }
        if (pSDevCenterASBase.isCreateDateDirty() && (bl || pSDevCenterASBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterASBase.getCreateDate());
        }
        if (pSDevCenterASBase.isCreateManDirty() && (bl || pSDevCenterASBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterASBase.getCreateMan());
        }
        if (pSDevCenterASBase.isExpriedTimeDirty() && (bl || pSDevCenterASBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevCenterASBase.getExpriedTime());
        }
        if (pSDevCenterASBase.isHostAddressDirty() && (bl || pSDevCenterASBase.getHostAddress() != null)) {
            iDataObject.set(FIELD_HOSTADDRESS, (Object)pSDevCenterASBase.getHostAddress());
        }
        if (pSDevCenterASBase.isHostPasswdDirty() && (bl || pSDevCenterASBase.getHostPasswd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevCenterASBase.getHostPasswd());
        }
        if (pSDevCenterASBase.isHostPortDirty() && (bl || pSDevCenterASBase.getHostPort() != null)) {
            iDataObject.set(FIELD_HOSTPORT, (Object)pSDevCenterASBase.getHostPort());
        }
        if (pSDevCenterASBase.isHostUserNameDirty() && (bl || pSDevCenterASBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevCenterASBase.getHostUserName());
        }
        if (pSDevCenterASBase.isHttpAddressDirty() && (bl || pSDevCenterASBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSDevCenterASBase.getHttpAddress());
        }
        if (pSDevCenterASBase.isHttpPortDirty() && (bl || pSDevCenterASBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDevCenterASBase.getHttpPort());
        }
        if (pSDevCenterASBase.isHttpsPortDirty() && (bl || pSDevCenterASBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDevCenterASBase.getHttpsPort());
        }
        if (pSDevCenterASBase.isLockModeDirty() && (bl || pSDevCenterASBase.getLockMode() != null)) {
            iDataObject.set(FIELD_LOCKMODE, (Object)pSDevCenterASBase.getLockMode());
        }
        if (pSDevCenterASBase.isLockObjIdDirty() && (bl || pSDevCenterASBase.getLockObjId() != null)) {
            iDataObject.set(FIELD_LOCKOBJID, (Object)pSDevCenterASBase.getLockObjId());
        }
        if (pSDevCenterASBase.isLockObjTypeDirty() && (bl || pSDevCenterASBase.getLockObjType() != null)) {
            iDataObject.set(FIELD_LOCKOBJTYPE, (Object)pSDevCenterASBase.getLockObjType());
        }
        if (pSDevCenterASBase.isMaxCPUDirty() && (bl || pSDevCenterASBase.getMaxCPU() != null)) {
            iDataObject.set(FIELD_MAXCPU, (Object)pSDevCenterASBase.getMaxCPU());
        }
        if (pSDevCenterASBase.isMaxMemDirty() && (bl || pSDevCenterASBase.getMaxMem() != null)) {
            iDataObject.set(FIELD_MAXMEM, (Object)pSDevCenterASBase.getMaxMem());
        }
        if (pSDevCenterASBase.isMemoDirty() && (bl || pSDevCenterASBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterASBase.getMemo());
        }
        if (pSDevCenterASBase.isMinCPUDirty() && (bl || pSDevCenterASBase.getMinCPU() != null)) {
            iDataObject.set(FIELD_MINCPU, (Object)pSDevCenterASBase.getMinCPU());
        }
        if (pSDevCenterASBase.isMinMemDirty() && (bl || pSDevCenterASBase.getMinMem() != null)) {
            iDataObject.set(FIELD_MINMEM, (Object)pSDevCenterASBase.getMinMem());
        }
        if (pSDevCenterASBase.isPSAppServerIdDirty() && (bl || pSDevCenterASBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSDevCenterASBase.getPSAppServerId());
        }
        if (pSDevCenterASBase.isPSAppServerNameDirty() && (bl || pSDevCenterASBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSDevCenterASBase.getPSAppServerName());
        }
        if (pSDevCenterASBase.isPSASBKListsDirty() && (bl || pSDevCenterASBase.getPSASBKLists() != null)) {
            iDataObject.set(FIELD_PSASBKLISTS, (Object)pSDevCenterASBase.getPSASBKLists());
        }
        if (pSDevCenterASBase.isPSDCClusterIdDirty() && (bl || pSDevCenterASBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDevCenterASBase.getPSDCClusterId());
        }
        if (pSDevCenterASBase.isPSDCClusterNameDirty() && (bl || pSDevCenterASBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDevCenterASBase.getPSDCClusterName());
        }
        if (pSDevCenterASBase.isPSDCContainerSpecIdDirty() && (bl || pSDevCenterASBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDevCenterASBase.getPSDCContainerSpecId());
        }
        if (pSDevCenterASBase.isPSDCContainerSpecNameDirty() && (bl || pSDevCenterASBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDevCenterASBase.getPSDCContainerSpecName());
        }
        if (pSDevCenterASBase.isPSDCDBListsDirty() && (bl || pSDevCenterASBase.getPSDCDBLists() != null)) {
            iDataObject.set(FIELD_PSDCDBLISTS, (Object)pSDevCenterASBase.getPSDCDBLists());
        }
        if (pSDevCenterASBase.isPSDCFileIdDirty() && (bl || pSDevCenterASBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevCenterASBase.getPSDCFileId());
        }
        if (pSDevCenterASBase.isPSDCFileNameDirty() && (bl || pSDevCenterASBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevCenterASBase.getPSDCFileName());
        }
        if (pSDevCenterASBase.isPSDevCenterASIdDirty() && (bl || pSDevCenterASBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSDevCenterASBase.getPSDevCenterASId());
        }
        if (pSDevCenterASBase.isPSDevCenterASNameDirty() && (bl || pSDevCenterASBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSDevCenterASBase.getPSDevCenterASName());
        }
        if (pSDevCenterASBase.isPSDevCenterIdDirty() && (bl || pSDevCenterASBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterASBase.getPSDevCenterId());
        }
        if (pSDevCenterASBase.isPSDevCenterNameDirty() && (bl || pSDevCenterASBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterASBase.getPSDevCenterName());
        }
        if (pSDevCenterASBase.isPSDevCenterServerIdDirty() && (bl || pSDevCenterASBase.getPSDevCenterServerId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERID, (Object)pSDevCenterASBase.getPSDevCenterServerId());
        }
        if (pSDevCenterASBase.isPSDevCenterServerNameDirty() && (bl || pSDevCenterASBase.getPSDevCenterServerName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERNAME, (Object)pSDevCenterASBase.getPSDevCenterServerName());
        }
        if (pSDevCenterASBase.isPSDevSlnIdDirty() && (bl || pSDevCenterASBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevCenterASBase.getPSDevSlnId());
        }
        if (pSDevCenterASBase.isPSDevSlnNameDirty() && (bl || pSDevCenterASBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevCenterASBase.getPSDevSlnName());
        }
        if (pSDevCenterASBase.isRefFlagDirty() && (bl || pSDevCenterASBase.getRefFlag() != null)) {
            iDataObject.set(FIELD_REFFLAG, (Object)pSDevCenterASBase.getRefFlag());
        }
        if (pSDevCenterASBase.isRefObjIdDirty() && (bl || pSDevCenterASBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDevCenterASBase.getRefObjId());
        }
        if (pSDevCenterASBase.isRefObjNameDirty() && (bl || pSDevCenterASBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDevCenterASBase.getRefObjName());
        }
        if (pSDevCenterASBase.isRefObjTypeDirty() && (bl || pSDevCenterASBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSDevCenterASBase.getRefObjType());
        }
        if (pSDevCenterASBase.isResPosDirty() && (bl || pSDevCenterASBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevCenterASBase.getResPos());
        }
        if (pSDevCenterASBase.isResReadyTimeDirty() && (bl || pSDevCenterASBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevCenterASBase.getResReadyTime());
        }
        if (pSDevCenterASBase.isResStateDirty() && (bl || pSDevCenterASBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevCenterASBase.getResState());
        }
        if (pSDevCenterASBase.isResVerDirty() && (bl || pSDevCenterASBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDevCenterASBase.getResVer());
        }
        if (pSDevCenterASBase.isStartCmdDirty() && (bl || pSDevCenterASBase.getStartCmd() != null)) {
            iDataObject.set(FIELD_STARTCMD, (Object)pSDevCenterASBase.getStartCmd());
        }
        if (pSDevCenterASBase.isStopCmdDirty() && (bl || pSDevCenterASBase.getStopCmd() != null)) {
            iDataObject.set(FIELD_STOPCMD, (Object)pSDevCenterASBase.getStopCmd());
        }
        if (pSDevCenterASBase.isUpdateDateDirty() && (bl || pSDevCenterASBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterASBase.getUpdateDate());
        }
        if (pSDevCenterASBase.isUpdateManDirty() && (bl || pSDevCenterASBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterASBase.getUpdateMan());
        }
        if (pSDevCenterASBase.isUploadFileModeDirty() && (bl || pSDevCenterASBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDevCenterASBase.getUploadFileMode());
        }
        if (pSDevCenterASBase.isUploadPathDirty() && (bl || pSDevCenterASBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDevCenterASBase.getUploadPath());
        }
        if (pSDevCenterASBase.isUsageModeDirty() && (bl || pSDevCenterASBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDevCenterASBase.getUsageMode());
        }
        if (pSDevCenterASBase.isUserTagDirty() && (bl || pSDevCenterASBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevCenterASBase.getUserTag());
        }
        if (pSDevCenterASBase.isUserTag2Dirty() && (bl || pSDevCenterASBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevCenterASBase.getUserTag2());
        }
        if (pSDevCenterASBase.isUserTag3Dirty() && (bl || pSDevCenterASBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevCenterASBase.getUserTag3());
        }
        if (pSDevCenterASBase.isUserTag4Dirty() && (bl || pSDevCenterASBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevCenterASBase.getUserTag4());
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
        return PSDevCenterASBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterASBase pSDevCenterASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterASBase.resetASInstallPath();
                return true;
            }
            case 1: {
                pSDevCenterASBase.resetASMode();
                return true;
            }
            case 2: {
                pSDevCenterASBase.resetASType();
                return true;
            }
            case 3: {
                pSDevCenterASBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDevCenterASBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDevCenterASBase.resetExpriedTime();
                return true;
            }
            case 6: {
                pSDevCenterASBase.resetHostAddress();
                return true;
            }
            case 7: {
                pSDevCenterASBase.resetHostPasswd();
                return true;
            }
            case 8: {
                pSDevCenterASBase.resetHostPort();
                return true;
            }
            case 9: {
                pSDevCenterASBase.resetHostUserName();
                return true;
            }
            case 10: {
                pSDevCenterASBase.resetHttpAddress();
                return true;
            }
            case 11: {
                pSDevCenterASBase.resetHttpPort();
                return true;
            }
            case 12: {
                pSDevCenterASBase.resetHttpsPort();
                return true;
            }
            case 13: {
                pSDevCenterASBase.resetLockMode();
                return true;
            }
            case 14: {
                pSDevCenterASBase.resetLockObjId();
                return true;
            }
            case 15: {
                pSDevCenterASBase.resetLockObjType();
                return true;
            }
            case 16: {
                pSDevCenterASBase.resetMaxCPU();
                return true;
            }
            case 17: {
                pSDevCenterASBase.resetMaxMem();
                return true;
            }
            case 18: {
                pSDevCenterASBase.resetMemo();
                return true;
            }
            case 19: {
                pSDevCenterASBase.resetMinCPU();
                return true;
            }
            case 20: {
                pSDevCenterASBase.resetMinMem();
                return true;
            }
            case 21: {
                pSDevCenterASBase.resetPSAppServerId();
                return true;
            }
            case 22: {
                pSDevCenterASBase.resetPSAppServerName();
                return true;
            }
            case 23: {
                pSDevCenterASBase.resetPSASBKLists();
                return true;
            }
            case 24: {
                pSDevCenterASBase.resetPSDCClusterId();
                return true;
            }
            case 25: {
                pSDevCenterASBase.resetPSDCClusterName();
                return true;
            }
            case 26: {
                pSDevCenterASBase.resetPSDCContainerSpecId();
                return true;
            }
            case 27: {
                pSDevCenterASBase.resetPSDCContainerSpecName();
                return true;
            }
            case 28: {
                pSDevCenterASBase.resetPSDCDBLists();
                return true;
            }
            case 29: {
                pSDevCenterASBase.resetPSDCFileId();
                return true;
            }
            case 30: {
                pSDevCenterASBase.resetPSDCFileName();
                return true;
            }
            case 31: {
                pSDevCenterASBase.resetPSDevCenterASId();
                return true;
            }
            case 32: {
                pSDevCenterASBase.resetPSDevCenterASName();
                return true;
            }
            case 33: {
                pSDevCenterASBase.resetPSDevCenterId();
                return true;
            }
            case 34: {
                pSDevCenterASBase.resetPSDevCenterName();
                return true;
            }
            case 35: {
                pSDevCenterASBase.resetPSDevCenterServerId();
                return true;
            }
            case 36: {
                pSDevCenterASBase.resetPSDevCenterServerName();
                return true;
            }
            case 37: {
                pSDevCenterASBase.resetPSDevSlnId();
                return true;
            }
            case 38: {
                pSDevCenterASBase.resetPSDevSlnName();
                return true;
            }
            case 39: {
                pSDevCenterASBase.resetRefFlag();
                return true;
            }
            case 40: {
                pSDevCenterASBase.resetRefObjId();
                return true;
            }
            case 41: {
                pSDevCenterASBase.resetRefObjName();
                return true;
            }
            case 42: {
                pSDevCenterASBase.resetRefObjType();
                return true;
            }
            case 43: {
                pSDevCenterASBase.resetResPos();
                return true;
            }
            case 44: {
                pSDevCenterASBase.resetResReadyTime();
                return true;
            }
            case 45: {
                pSDevCenterASBase.resetResState();
                return true;
            }
            case 46: {
                pSDevCenterASBase.resetResVer();
                return true;
            }
            case 47: {
                pSDevCenterASBase.resetStartCmd();
                return true;
            }
            case 48: {
                pSDevCenterASBase.resetStopCmd();
                return true;
            }
            case 49: {
                pSDevCenterASBase.resetUpdateDate();
                return true;
            }
            case 50: {
                pSDevCenterASBase.resetUpdateMan();
                return true;
            }
            case 51: {
                pSDevCenterASBase.resetUploadFileMode();
                return true;
            }
            case 52: {
                pSDevCenterASBase.resetUploadPath();
                return true;
            }
            case 53: {
                pSDevCenterASBase.resetUsageMode();
                return true;
            }
            case 54: {
                pSDevCenterASBase.resetUserTag();
                return true;
            }
            case 55: {
                pSDevCenterASBase.resetUserTag2();
                return true;
            }
            case 56: {
                pSDevCenterASBase.resetUserTag3();
                return true;
            }
            case 57: {
                pSDevCenterASBase.resetUserTag4();
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
    public PSDevCenterServer getPSDevCenterServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServer();
        }
        if (this.getPSDevCenterServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterServerLock;
        synchronized (n) {
            if (this.psdevcenterserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterServerId(), (Object)this.psdevcenterserver.getPSDevCenterServerId()) != 0L) {
                this.psdevcenterserver = null;
            }
            if (this.psdevcenterserver == null) {
                PSDevCenterServer pSDevCenterServer = new PSDevCenterServer();
                pSDevCenterServer.setPSDevCenterServerId(this.getPSDevCenterServerId());
                PSDevCenterServerService pSDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterServerService.autoGet((IEntity)pSDevCenterServer);
                this.psdevcenterserver = pSDevCenterServer;
            }
            return this.psdevcenterserver;
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

    private PSDevCenterASBase getProxyEntity() {
        return this.proxyPSDevCenterASBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterASBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterASBase) {
            this.proxyPSDevCenterASBase = (PSDevCenterASBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASINSTALLPATH, 0);
        fieldIndexMap.put(FIELD_ASMODE, 1);
        fieldIndexMap.put(FIELD_ASTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 5);
        fieldIndexMap.put(FIELD_HOSTADDRESS, 6);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 7);
        fieldIndexMap.put(FIELD_HOSTPORT, 8);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 9);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 10);
        fieldIndexMap.put(FIELD_HTTPPORT, 11);
        fieldIndexMap.put(FIELD_HTTPSPORT, 12);
        fieldIndexMap.put(FIELD_LOCKMODE, 13);
        fieldIndexMap.put(FIELD_LOCKOBJID, 14);
        fieldIndexMap.put(FIELD_LOCKOBJTYPE, 15);
        fieldIndexMap.put(FIELD_MAXCPU, 16);
        fieldIndexMap.put(FIELD_MAXMEM, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_MINCPU, 19);
        fieldIndexMap.put(FIELD_MINMEM, 20);
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 21);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 22);
        fieldIndexMap.put(FIELD_PSASBKLISTS, 23);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 24);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 25);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 26);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 27);
        fieldIndexMap.put(FIELD_PSDCDBLISTS, 28);
        fieldIndexMap.put(FIELD_PSDCFILEID, 29);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 30);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 31);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 33);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 34);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERID, 35);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERNAME, 36);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 37);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 38);
        fieldIndexMap.put(FIELD_REFFLAG, 39);
        fieldIndexMap.put(FIELD_REFOBJID, 40);
        fieldIndexMap.put(FIELD_REFOBJNAME, 41);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 42);
        fieldIndexMap.put(FIELD_RESPOS, 43);
        fieldIndexMap.put(FIELD_RESREADYTIME, 44);
        fieldIndexMap.put(FIELD_RESSTATE, 45);
        fieldIndexMap.put(FIELD_RESVER, 46);
        fieldIndexMap.put(FIELD_STARTCMD, 47);
        fieldIndexMap.put(FIELD_STOPCMD, 48);
        fieldIndexMap.put(FIELD_UPDATEDATE, 49);
        fieldIndexMap.put(FIELD_UPDATEMAN, 50);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 51);
        fieldIndexMap.put(FIELD_UPLOADPATH, 52);
        fieldIndexMap.put(FIELD_USAGEMODE, 53);
        fieldIndexMap.put(FIELD_USERTAG, 54);
        fieldIndexMap.put(FIELD_USERTAG2, 55);
        fieldIndexMap.put(FIELD_USERTAG3, 56);
        fieldIndexMap.put(FIELD_USERTAG4, 57);
    }
}

