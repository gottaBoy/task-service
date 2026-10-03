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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceUserService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkspaceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWorkspaceBase.class);
    public static final String FIELD_ACCESSUSERS = "ACCESSUSERS";
    public static final String FIELD_ACTIONOWNER = "ACTIONOWNER";
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURACTION = "CURACTION";
    public static final String FIELD_CURACTIVETIME = "CURACTIVETIME";
    public static final String FIELD_CUREXPIREDTIME = "CUREXPIREDTIME";
    public static final String FIELD_EXP = "EXP";
    public static final String FIELD_EXP2 = "EXP2";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_IPADDRS = "IPADDRS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WORKSPACELEVEL = "WORKSPACELEVEL";
    public static final String FIELD_WORKSPACESTATE = "WORKSPACESTATE";
    public static final String FIELD_WORKSPACETYPE = "WORKSPACETYPE";
    public static final String FIELD_WORKSPACEUPDATEDATE = "WORKSPACEUPDATEDATE";
    public static final String FIELD_WORKSPACEUSAGE = "WORKSPACEUSAGE";
    private static final int INDEX_ACCESSUSERS = 0;
    private static final int INDEX_ACTIONOWNER = 1;
    private static final int INDEX_ACTIONPARAM = 2;
    private static final int INDEX_ACTIONPARAM2 = 3;
    private static final int INDEX_ACTIONPARAM3 = 4;
    private static final int INDEX_ACTIONPARAM4 = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CURACTION = 8;
    private static final int INDEX_CURACTIVETIME = 9;
    private static final int INDEX_CUREXPIREDTIME = 10;
    private static final int INDEX_EXP = 11;
    private static final int INDEX_EXP2 = 12;
    private static final int INDEX_EXPIREDTIME = 13;
    private static final int INDEX_IPADDRS = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PSDCWORKSPACEID = 16;
    private static final int INDEX_PSDCWORKSPACENAME = 17;
    private static final int INDEX_PSDEVCENTERID = 18;
    private static final int INDEX_PSDEVCENTERNAME = 19;
    private static final int INDEX_PSDEVSLNID = 20;
    private static final int INDEX_PSDEVSLNNAME = 21;
    private static final int INDEX_PSDEVSLNSYSID = 22;
    private static final int INDEX_PSDEVSLNSYSNAME = 23;
    private static final int INDEX_PSWORKSPACEID = 24;
    private static final int INDEX_PSWORKSPACENAME = 25;
    private static final int INDEX_RESSTATE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_WORKSPACELEVEL = 29;
    private static final int INDEX_WORKSPACESTATE = 30;
    private static final int INDEX_WORKSPACETYPE = 31;
    private static final int INDEX_WORKSPACEUPDATEDATE = 32;
    private static final int INDEX_WORKSPACEUSAGE = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWorkspaceBase proxyPSDCWorkspaceBase = null;
    private boolean accessusersDirtyFlag = false;
    private boolean actionownerDirtyFlag = false;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curactionDirtyFlag = false;
    private boolean curactivetimeDirtyFlag = false;
    private boolean curexpiredtimeDirtyFlag = false;
    private boolean expDirtyFlag = false;
    private boolean exp2DirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean ipaddrsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean workspacelevelDirtyFlag = false;
    private boolean workspacestateDirtyFlag = false;
    private boolean workspacetypeDirtyFlag = false;
    private boolean workspaceupdatedateDirtyFlag = false;
    private boolean workspaceusageDirtyFlag = false;
    @Column(name="accessusers")
    private String accessusers;
    @Column(name="actionowner")
    private String actionowner;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="actionparam2")
    private String actionparam2;
    @Column(name="actionparam3")
    private String actionparam3;
    @Column(name="actionparam4")
    private String actionparam4;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curaction")
    private String curaction;
    @Column(name="curactivetime")
    private Timestamp curactivetime;
    @Column(name="curexpiredtime")
    private Timestamp curexpiredtime;
    @Column(name="exp")
    private Double exp;
    @Column(name="exp2")
    private Double exp2;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="ipaddrs")
    private String ipaddrs;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacename")
    private String psdcworkspacename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacename")
    private String psworkspacename;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="workspacelevel")
    private Integer workspacelevel;
    @Column(name="workspacestate")
    private Integer workspacestate;
    @Column(name="workspacetype")
    private String workspacetype;
    @Column(name="workspaceupdatedate")
    private Timestamp workspaceupdatedate;
    @Column(name="workspaceusage")
    private String workspaceusage;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSWorkspaceLock = new Integer(1);
    private PSWorkspace psworkspace = null;
    private Integer objPSDCWorkspaceUsersLock = new Integer(1);
    private ArrayList<PSDCWorkspaceUser> psdcworkspaceusers = null;

    public void setAccessUsers(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccessUsers(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.accessusers = string;
        this.accessusersDirtyFlag = true;
    }

    public String getAccessUsers() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccessUsers();
        }
        return this.accessusers;
    }

    public boolean isAccessUsersDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccessUsersDirty();
        }
        return this.accessusersDirtyFlag;
    }

    public void resetAccessUsers() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccessUsers();
            return;
        }
        this.accessusersDirtyFlag = false;
        this.accessusers = null;
    }

    public void setActionOwner(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOwner(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionowner = string;
        this.actionownerDirtyFlag = true;
    }

    public String getActionOwner() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOwner();
        }
        return this.actionowner;
    }

    public boolean isActionOwnerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOwnerDirty();
        }
        return this.actionownerDirtyFlag;
    }

    public void resetActionOwner() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOwner();
            return;
        }
        this.actionownerDirtyFlag = false;
        this.actionowner = null;
    }

    public void setActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam = string;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
    }

    public void setActionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam2 = string;
        this.actionparam2DirtyFlag = true;
    }

    public String getActionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam2();
        }
        return this.actionparam2;
    }

    public boolean isActionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam2Dirty();
        }
        return this.actionparam2DirtyFlag;
    }

    public void resetActionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam2();
            return;
        }
        this.actionparam2DirtyFlag = false;
        this.actionparam2 = null;
    }

    public void setActionParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam3 = string;
        this.actionparam3DirtyFlag = true;
    }

    public String getActionParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam3();
        }
        return this.actionparam3;
    }

    public boolean isActionParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam3Dirty();
        }
        return this.actionparam3DirtyFlag;
    }

    public void resetActionParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam3();
            return;
        }
        this.actionparam3DirtyFlag = false;
        this.actionparam3 = null;
    }

    public void setActionParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam4 = string;
        this.actionparam4DirtyFlag = true;
    }

    public String getActionParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam4();
        }
        return this.actionparam4;
    }

    public boolean isActionParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam4Dirty();
        }
        return this.actionparam4DirtyFlag;
    }

    public void resetActionParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam4();
            return;
        }
        this.actionparam4DirtyFlag = false;
        this.actionparam4 = null;
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

    public void setCurAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curaction = string;
        this.curactionDirtyFlag = true;
    }

    public String getCurAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurAction();
        }
        return this.curaction;
    }

    public boolean isCurActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActionDirty();
        }
        return this.curactionDirtyFlag;
    }

    public void resetCurAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurAction();
            return;
        }
        this.curactionDirtyFlag = false;
        this.curaction = null;
    }

    public void setCurActiveTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurActiveTime(timestamp);
            return;
        }
        this.curactivetime = timestamp;
        this.curactivetimeDirtyFlag = true;
    }

    public Timestamp getCurActiveTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurActiveTime();
        }
        return this.curactivetime;
    }

    public boolean isCurActiveTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActiveTimeDirty();
        }
        return this.curactivetimeDirtyFlag;
    }

    public void resetCurActiveTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurActiveTime();
            return;
        }
        this.curactivetimeDirtyFlag = false;
        this.curactivetime = null;
    }

    public void setCurExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurExpiredTime(timestamp);
            return;
        }
        this.curexpiredtime = timestamp;
        this.curexpiredtimeDirtyFlag = true;
    }

    public Timestamp getCurExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurExpiredTime();
        }
        return this.curexpiredtime;
    }

    public boolean isCurExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurExpiredTimeDirty();
        }
        return this.curexpiredtimeDirtyFlag;
    }

    public void resetCurExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurExpiredTime();
            return;
        }
        this.curexpiredtimeDirtyFlag = false;
        this.curexpiredtime = null;
    }

    public void setExp(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp(d);
            return;
        }
        this.exp = d;
        this.expDirtyFlag = true;
    }

    public Double getExp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp();
        }
        return this.exp;
    }

    public boolean isExpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpDirty();
        }
        return this.expDirtyFlag;
    }

    public void resetExp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp();
            return;
        }
        this.expDirtyFlag = false;
        this.exp = null;
    }

    public void setExp2(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp2(d);
            return;
        }
        this.exp2 = d;
        this.exp2DirtyFlag = true;
    }

    public Double getExp2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp2();
        }
        return this.exp2;
    }

    public boolean isExp2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp2Dirty();
        }
        return this.exp2DirtyFlag;
    }

    public void resetExp2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp2();
            return;
        }
        this.exp2DirtyFlag = false;
        this.exp2 = null;
    }

    public void setExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(timestamp);
            return;
        }
        this.expiredtime = timestamp;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
    }

    public void setIPAddrs(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddrs(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddrs = string;
        this.ipaddrsDirtyFlag = true;
    }

    public String getIPAddrs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddrs();
        }
        return this.ipaddrs;
    }

    public boolean isIPAddrsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrsDirty();
        }
        return this.ipaddrsDirtyFlag;
    }

    public void resetIPAddrs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddrs();
            return;
        }
        this.ipaddrsDirtyFlag = false;
        this.ipaddrs = null;
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

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDCWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacename = string;
        this.psdcworkspacenameDirtyFlag = true;
    }

    public String getPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceName();
        }
        return this.psdcworkspacename;
    }

    public boolean isPSDCWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceNameDirty();
        }
        return this.psdcworkspacenameDirtyFlag;
    }

    public void resetPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceName();
            return;
        }
        this.psdcworkspacenameDirtyFlag = false;
        this.psdcworkspacename = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspaceid = string;
        this.psworkspaceidDirtyFlag = true;
    }

    public String getPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceId();
        }
        return this.psworkspaceid;
    }

    public boolean isPSWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceIdDirty();
        }
        return this.psworkspaceidDirtyFlag;
    }

    public void resetPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceId();
            return;
        }
        this.psworkspaceidDirtyFlag = false;
        this.psworkspaceid = null;
    }

    public void setPSWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacename = string;
        this.psworkspacenameDirtyFlag = true;
    }

    public String getPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceName();
        }
        return this.psworkspacename;
    }

    public boolean isPSWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceNameDirty();
        }
        return this.psworkspacenameDirtyFlag;
    }

    public void resetPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceName();
            return;
        }
        this.psworkspacenameDirtyFlag = false;
        this.psworkspacename = null;
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

    public void setWorkspaceLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceLevel(n);
            return;
        }
        this.workspacelevel = n;
        this.workspacelevelDirtyFlag = true;
    }

    public Integer getWorkspaceLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceLevel();
        }
        return this.workspacelevel;
    }

    public boolean isWorkspaceLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceLevelDirty();
        }
        return this.workspacelevelDirtyFlag;
    }

    public void resetWorkspaceLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceLevel();
            return;
        }
        this.workspacelevelDirtyFlag = false;
        this.workspacelevel = null;
    }

    public void setWorkspaceState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceState(n);
            return;
        }
        this.workspacestate = n;
        this.workspacestateDirtyFlag = true;
    }

    public Integer getWorkspaceState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceState();
        }
        return this.workspacestate;
    }

    public boolean isWorkspaceStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceStateDirty();
        }
        return this.workspacestateDirtyFlag;
    }

    public void resetWorkspaceState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceState();
            return;
        }
        this.workspacestateDirtyFlag = false;
        this.workspacestate = null;
    }

    public void setWorkspaceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspacetype = string;
        this.workspacetypeDirtyFlag = true;
    }

    public String getWorkspaceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceType();
        }
        return this.workspacetype;
    }

    public boolean isWorkspaceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceTypeDirty();
        }
        return this.workspacetypeDirtyFlag;
    }

    public void resetWorkspaceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceType();
            return;
        }
        this.workspacetypeDirtyFlag = false;
        this.workspacetype = null;
    }

    public void setWorkspaceUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceUpdateDate(timestamp);
            return;
        }
        this.workspaceupdatedate = timestamp;
        this.workspaceupdatedateDirtyFlag = true;
    }

    public Timestamp getWorkspaceUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceUpdateDate();
        }
        return this.workspaceupdatedate;
    }

    public boolean isWorkspaceUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceUpdateDateDirty();
        }
        return this.workspaceupdatedateDirtyFlag;
    }

    public void resetWorkspaceUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceUpdateDate();
            return;
        }
        this.workspaceupdatedateDirtyFlag = false;
        this.workspaceupdatedate = null;
    }

    public void setWorkspaceUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkspaceUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workspaceusage = string;
        this.workspaceusageDirtyFlag = true;
    }

    public String getWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkspaceUsage();
        }
        return this.workspaceusage;
    }

    public boolean isWorkspaceUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkspaceUsageDirty();
        }
        return this.workspaceusageDirtyFlag;
    }

    public void resetWorkspaceUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkspaceUsage();
            return;
        }
        this.workspaceusageDirtyFlag = false;
        this.workspaceusage = null;
    }

    protected void onReset() {
        PSDCWorkspaceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWorkspaceBase pSDCWorkspaceBase) {
        pSDCWorkspaceBase.resetAccessUsers();
        pSDCWorkspaceBase.resetActionOwner();
        pSDCWorkspaceBase.resetActionParam();
        pSDCWorkspaceBase.resetActionParam2();
        pSDCWorkspaceBase.resetActionParam3();
        pSDCWorkspaceBase.resetActionParam4();
        pSDCWorkspaceBase.resetCreateDate();
        pSDCWorkspaceBase.resetCreateMan();
        pSDCWorkspaceBase.resetCurAction();
        pSDCWorkspaceBase.resetCurActiveTime();
        pSDCWorkspaceBase.resetCurExpiredTime();
        pSDCWorkspaceBase.resetExp();
        pSDCWorkspaceBase.resetExp2();
        pSDCWorkspaceBase.resetExpiredTime();
        pSDCWorkspaceBase.resetIPAddrs();
        pSDCWorkspaceBase.resetMemo();
        pSDCWorkspaceBase.resetPSDCWorkspaceId();
        pSDCWorkspaceBase.resetPSDCWorkspaceName();
        pSDCWorkspaceBase.resetPSDevCenterId();
        pSDCWorkspaceBase.resetPSDevCenterName();
        pSDCWorkspaceBase.resetPSDevSlnId();
        pSDCWorkspaceBase.resetPSDevSlnName();
        pSDCWorkspaceBase.resetPSDevSlnSysId();
        pSDCWorkspaceBase.resetPSDevSlnSysName();
        pSDCWorkspaceBase.resetPSWorkspaceId();
        pSDCWorkspaceBase.resetPSWorkspaceName();
        pSDCWorkspaceBase.resetResState();
        pSDCWorkspaceBase.resetUpdateDate();
        pSDCWorkspaceBase.resetUpdateMan();
        pSDCWorkspaceBase.resetWorkspaceLevel();
        pSDCWorkspaceBase.resetWorkspaceState();
        pSDCWorkspaceBase.resetWorkspaceType();
        pSDCWorkspaceBase.resetWorkspaceUpdateDate();
        pSDCWorkspaceBase.resetWorkspaceUsage();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccessUsersDirty()) {
            hashMap.put(FIELD_ACCESSUSERS, this.getAccessUsers());
        }
        if (!bl || this.isActionOwnerDirty()) {
            hashMap.put(FIELD_ACTIONOWNER, this.getActionOwner());
        }
        if (!bl || this.isActionParamDirty()) {
            hashMap.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bl || this.isActionParam2Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM2, this.getActionParam2());
        }
        if (!bl || this.isActionParam3Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM3, this.getActionParam3());
        }
        if (!bl || this.isActionParam4Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM4, this.getActionParam4());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurActionDirty()) {
            hashMap.put(FIELD_CURACTION, this.getCurAction());
        }
        if (!bl || this.isCurActiveTimeDirty()) {
            hashMap.put(FIELD_CURACTIVETIME, this.getCurActiveTime());
        }
        if (!bl || this.isCurExpiredTimeDirty()) {
            hashMap.put(FIELD_CUREXPIREDTIME, this.getCurExpiredTime());
        }
        if (!bl || this.isExpDirty()) {
            hashMap.put(FIELD_EXP, this.getExp());
        }
        if (!bl || this.isExp2Dirty()) {
            hashMap.put(FIELD_EXP2, this.getExp2());
        }
        if (!bl || this.isExpiredTimeDirty()) {
            hashMap.put(FIELD_EXPIREDTIME, this.getExpiredTime());
        }
        if (!bl || this.isIPAddrsDirty()) {
            hashMap.put(FIELD_IPADDRS, this.getIPAddrs());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACENAME, this.getPSDCWorkspaceName());
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
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEID, this.getPSWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACENAME, this.getPSWorkspaceName());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWorkspaceLevelDirty()) {
            hashMap.put(FIELD_WORKSPACELEVEL, this.getWorkspaceLevel());
        }
        if (!bl || this.isWorkspaceStateDirty()) {
            hashMap.put(FIELD_WORKSPACESTATE, this.getWorkspaceState());
        }
        if (!bl || this.isWorkspaceTypeDirty()) {
            hashMap.put(FIELD_WORKSPACETYPE, this.getWorkspaceType());
        }
        if (!bl || this.isWorkspaceUpdateDateDirty()) {
            hashMap.put(FIELD_WORKSPACEUPDATEDATE, this.getWorkspaceUpdateDate());
        }
        if (!bl || this.isWorkspaceUsageDirty()) {
            hashMap.put(FIELD_WORKSPACEUSAGE, this.getWorkspaceUsage());
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
        return PSDCWorkspaceBase.get(this, n);
    }

    private static Object get(PSDCWorkspaceBase pSDCWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceBase.getAccessUsers();
            }
            case 1: {
                return pSDCWorkspaceBase.getActionOwner();
            }
            case 2: {
                return pSDCWorkspaceBase.getActionParam();
            }
            case 3: {
                return pSDCWorkspaceBase.getActionParam2();
            }
            case 4: {
                return pSDCWorkspaceBase.getActionParam3();
            }
            case 5: {
                return pSDCWorkspaceBase.getActionParam4();
            }
            case 6: {
                return pSDCWorkspaceBase.getCreateDate();
            }
            case 7: {
                return pSDCWorkspaceBase.getCreateMan();
            }
            case 8: {
                return pSDCWorkspaceBase.getCurAction();
            }
            case 9: {
                return pSDCWorkspaceBase.getCurActiveTime();
            }
            case 10: {
                return pSDCWorkspaceBase.getCurExpiredTime();
            }
            case 11: {
                return pSDCWorkspaceBase.getExp();
            }
            case 12: {
                return pSDCWorkspaceBase.getExp2();
            }
            case 13: {
                return pSDCWorkspaceBase.getExpiredTime();
            }
            case 14: {
                return pSDCWorkspaceBase.getIPAddrs();
            }
            case 15: {
                return pSDCWorkspaceBase.getMemo();
            }
            case 16: {
                return pSDCWorkspaceBase.getPSDCWorkspaceId();
            }
            case 17: {
                return pSDCWorkspaceBase.getPSDCWorkspaceName();
            }
            case 18: {
                return pSDCWorkspaceBase.getPSDevCenterId();
            }
            case 19: {
                return pSDCWorkspaceBase.getPSDevCenterName();
            }
            case 20: {
                return pSDCWorkspaceBase.getPSDevSlnId();
            }
            case 21: {
                return pSDCWorkspaceBase.getPSDevSlnName();
            }
            case 22: {
                return pSDCWorkspaceBase.getPSDevSlnSysId();
            }
            case 23: {
                return pSDCWorkspaceBase.getPSDevSlnSysName();
            }
            case 24: {
                return pSDCWorkspaceBase.getPSWorkspaceId();
            }
            case 25: {
                return pSDCWorkspaceBase.getPSWorkspaceName();
            }
            case 26: {
                return pSDCWorkspaceBase.getResState();
            }
            case 27: {
                return pSDCWorkspaceBase.getUpdateDate();
            }
            case 28: {
                return pSDCWorkspaceBase.getUpdateMan();
            }
            case 29: {
                return pSDCWorkspaceBase.getWorkspaceLevel();
            }
            case 30: {
                return pSDCWorkspaceBase.getWorkspaceState();
            }
            case 31: {
                return pSDCWorkspaceBase.getWorkspaceType();
            }
            case 32: {
                return pSDCWorkspaceBase.getWorkspaceUpdateDate();
            }
            case 33: {
                return pSDCWorkspaceBase.getWorkspaceUsage();
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
        PSDCWorkspaceBase.set(this, n, object);
    }

    private static void set(PSDCWorkspaceBase pSDCWorkspaceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceBase.setAccessUsers(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCWorkspaceBase.setActionOwner(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCWorkspaceBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCWorkspaceBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCWorkspaceBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCWorkspaceBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCWorkspaceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCWorkspaceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCWorkspaceBase.setCurAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCWorkspaceBase.setCurActiveTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDCWorkspaceBase.setCurExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCWorkspaceBase.setExp(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 12: {
                pSDCWorkspaceBase.setExp2(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 13: {
                pSDCWorkspaceBase.setExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDCWorkspaceBase.setIPAddrs(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCWorkspaceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCWorkspaceBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCWorkspaceBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCWorkspaceBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCWorkspaceBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCWorkspaceBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCWorkspaceBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCWorkspaceBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCWorkspaceBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCWorkspaceBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCWorkspaceBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCWorkspaceBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDCWorkspaceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDCWorkspaceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCWorkspaceBase.setWorkspaceLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDCWorkspaceBase.setWorkspaceState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDCWorkspaceBase.setWorkspaceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCWorkspaceBase.setWorkspaceUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDCWorkspaceBase.setWorkspaceUsage(DataObject.getStringValue((Object)object));
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
        return PSDCWorkspaceBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWorkspaceBase pSDCWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceBase.getAccessUsers() == null;
            }
            case 1: {
                return pSDCWorkspaceBase.getActionOwner() == null;
            }
            case 2: {
                return pSDCWorkspaceBase.getActionParam() == null;
            }
            case 3: {
                return pSDCWorkspaceBase.getActionParam2() == null;
            }
            case 4: {
                return pSDCWorkspaceBase.getActionParam3() == null;
            }
            case 5: {
                return pSDCWorkspaceBase.getActionParam4() == null;
            }
            case 6: {
                return pSDCWorkspaceBase.getCreateDate() == null;
            }
            case 7: {
                return pSDCWorkspaceBase.getCreateMan() == null;
            }
            case 8: {
                return pSDCWorkspaceBase.getCurAction() == null;
            }
            case 9: {
                return pSDCWorkspaceBase.getCurActiveTime() == null;
            }
            case 10: {
                return pSDCWorkspaceBase.getCurExpiredTime() == null;
            }
            case 11: {
                return pSDCWorkspaceBase.getExp() == null;
            }
            case 12: {
                return pSDCWorkspaceBase.getExp2() == null;
            }
            case 13: {
                return pSDCWorkspaceBase.getExpiredTime() == null;
            }
            case 14: {
                return pSDCWorkspaceBase.getIPAddrs() == null;
            }
            case 15: {
                return pSDCWorkspaceBase.getMemo() == null;
            }
            case 16: {
                return pSDCWorkspaceBase.getPSDCWorkspaceId() == null;
            }
            case 17: {
                return pSDCWorkspaceBase.getPSDCWorkspaceName() == null;
            }
            case 18: {
                return pSDCWorkspaceBase.getPSDevCenterId() == null;
            }
            case 19: {
                return pSDCWorkspaceBase.getPSDevCenterName() == null;
            }
            case 20: {
                return pSDCWorkspaceBase.getPSDevSlnId() == null;
            }
            case 21: {
                return pSDCWorkspaceBase.getPSDevSlnName() == null;
            }
            case 22: {
                return pSDCWorkspaceBase.getPSDevSlnSysId() == null;
            }
            case 23: {
                return pSDCWorkspaceBase.getPSDevSlnSysName() == null;
            }
            case 24: {
                return pSDCWorkspaceBase.getPSWorkspaceId() == null;
            }
            case 25: {
                return pSDCWorkspaceBase.getPSWorkspaceName() == null;
            }
            case 26: {
                return pSDCWorkspaceBase.getResState() == null;
            }
            case 27: {
                return pSDCWorkspaceBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDCWorkspaceBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDCWorkspaceBase.getWorkspaceLevel() == null;
            }
            case 30: {
                return pSDCWorkspaceBase.getWorkspaceState() == null;
            }
            case 31: {
                return pSDCWorkspaceBase.getWorkspaceType() == null;
            }
            case 32: {
                return pSDCWorkspaceBase.getWorkspaceUpdateDate() == null;
            }
            case 33: {
                return pSDCWorkspaceBase.getWorkspaceUsage() == null;
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
        return PSDCWorkspaceBase.contains(this, n);
    }

    private static boolean contains(PSDCWorkspaceBase pSDCWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceBase.isAccessUsersDirty();
            }
            case 1: {
                return pSDCWorkspaceBase.isActionOwnerDirty();
            }
            case 2: {
                return pSDCWorkspaceBase.isActionParamDirty();
            }
            case 3: {
                return pSDCWorkspaceBase.isActionParam2Dirty();
            }
            case 4: {
                return pSDCWorkspaceBase.isActionParam3Dirty();
            }
            case 5: {
                return pSDCWorkspaceBase.isActionParam4Dirty();
            }
            case 6: {
                return pSDCWorkspaceBase.isCreateDateDirty();
            }
            case 7: {
                return pSDCWorkspaceBase.isCreateManDirty();
            }
            case 8: {
                return pSDCWorkspaceBase.isCurActionDirty();
            }
            case 9: {
                return pSDCWorkspaceBase.isCurActiveTimeDirty();
            }
            case 10: {
                return pSDCWorkspaceBase.isCurExpiredTimeDirty();
            }
            case 11: {
                return pSDCWorkspaceBase.isExpDirty();
            }
            case 12: {
                return pSDCWorkspaceBase.isExp2Dirty();
            }
            case 13: {
                return pSDCWorkspaceBase.isExpiredTimeDirty();
            }
            case 14: {
                return pSDCWorkspaceBase.isIPAddrsDirty();
            }
            case 15: {
                return pSDCWorkspaceBase.isMemoDirty();
            }
            case 16: {
                return pSDCWorkspaceBase.isPSDCWorkspaceIdDirty();
            }
            case 17: {
                return pSDCWorkspaceBase.isPSDCWorkspaceNameDirty();
            }
            case 18: {
                return pSDCWorkspaceBase.isPSDevCenterIdDirty();
            }
            case 19: {
                return pSDCWorkspaceBase.isPSDevCenterNameDirty();
            }
            case 20: {
                return pSDCWorkspaceBase.isPSDevSlnIdDirty();
            }
            case 21: {
                return pSDCWorkspaceBase.isPSDevSlnNameDirty();
            }
            case 22: {
                return pSDCWorkspaceBase.isPSDevSlnSysIdDirty();
            }
            case 23: {
                return pSDCWorkspaceBase.isPSDevSlnSysNameDirty();
            }
            case 24: {
                return pSDCWorkspaceBase.isPSWorkspaceIdDirty();
            }
            case 25: {
                return pSDCWorkspaceBase.isPSWorkspaceNameDirty();
            }
            case 26: {
                return pSDCWorkspaceBase.isResStateDirty();
            }
            case 27: {
                return pSDCWorkspaceBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDCWorkspaceBase.isUpdateManDirty();
            }
            case 29: {
                return pSDCWorkspaceBase.isWorkspaceLevelDirty();
            }
            case 30: {
                return pSDCWorkspaceBase.isWorkspaceStateDirty();
            }
            case 31: {
                return pSDCWorkspaceBase.isWorkspaceTypeDirty();
            }
            case 32: {
                return pSDCWorkspaceBase.isWorkspaceUpdateDateDirty();
            }
            case 33: {
                return pSDCWorkspaceBase.isWorkspaceUsageDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWorkspaceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWorkspaceBase pSDCWorkspaceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWorkspaceBase.getAccessUsers() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accessusers", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getAccessUsers()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getActionOwner() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionowner", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getActionOwner()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getActionParam()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getCurAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curaction", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getCurAction()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getCurActiveTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curactivetime", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getCurActiveTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getCurExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curexpiredtime", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getCurExpiredTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getExp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getExp()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getExp2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp2", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getExp2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredtime", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getExpiredTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getIPAddrs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddrs", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getIPAddrs()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getResState()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacelevel", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getWorkspaceLevel()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacestate", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getWorkspaceState()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspacetype", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getWorkspaceType()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspaceupdatedate", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getWorkspaceUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workspaceusage", (Object)PSDCWorkspaceBase.getJSONValue((Object)pSDCWorkspaceBase.getWorkspaceUsage()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWorkspaceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWorkspaceBase pSDCWorkspaceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWorkspaceBase.getAccessUsers() != null) {
            object = pSDCWorkspaceBase.getAccessUsers();
            xmlNode.setAttribute(FIELD_ACCESSUSERS, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceBase.getActionOwner() != null) {
            object = pSDCWorkspaceBase.getActionOwner();
            xmlNode.setAttribute(FIELD_ACTIONOWNER, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceBase.getActionParam() != null) {
            object = pSDCWorkspaceBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceBase.getActionParam2() != null) {
            object = pSDCWorkspaceBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceBase.getActionParam3() != null) {
            object = pSDCWorkspaceBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSDCWorkspaceBase.getActionParam4() != null) {
            object = pSDCWorkspaceBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getCreateDate() != null) {
            object = pSDCWorkspaceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getCreateMan() != null) {
            object = pSDCWorkspaceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getCurAction() != null) {
            object = pSDCWorkspaceBase.getCurAction();
            xmlNode.setAttribute(FIELD_CURACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getCurActiveTime() != null) {
            object = pSDCWorkspaceBase.getCurActiveTime();
            xmlNode.setAttribute(FIELD_CURACTIVETIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getCurExpiredTime() != null) {
            object = pSDCWorkspaceBase.getCurExpiredTime();
            xmlNode.setAttribute(FIELD_CUREXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getExp() != null) {
            object = pSDCWorkspaceBase.getExp();
            xmlNode.setAttribute(FIELD_EXP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getExp2() != null) {
            object = pSDCWorkspaceBase.getExp2();
            xmlNode.setAttribute(FIELD_EXP2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getExpiredTime() != null) {
            object = pSDCWorkspaceBase.getExpiredTime();
            xmlNode.setAttribute(FIELD_EXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getIPAddrs() != null) {
            object = pSDCWorkspaceBase.getIPAddrs();
            xmlNode.setAttribute(FIELD_IPADDRS, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getMemo() != null) {
            object = pSDCWorkspaceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDCWorkspaceId() != null) {
            object = pSDCWorkspaceBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDCWorkspaceName() != null) {
            object = pSDCWorkspaceBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevCenterId() != null) {
            object = pSDCWorkspaceBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevCenterName() != null) {
            object = pSDCWorkspaceBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnId() != null) {
            object = pSDCWorkspaceBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnName() != null) {
            object = pSDCWorkspaceBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnSysId() != null) {
            object = pSDCWorkspaceBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSDevSlnSysName() != null) {
            object = pSDCWorkspaceBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSWorkspaceId() != null) {
            object = pSDCWorkspaceBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getPSWorkspaceName() != null) {
            object = pSDCWorkspaceBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getResState() != null) {
            object = pSDCWorkspaceBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getUpdateDate() != null) {
            object = pSDCWorkspaceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getUpdateMan() != null) {
            object = pSDCWorkspaceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceLevel() != null) {
            object = pSDCWorkspaceBase.getWorkspaceLevel();
            xmlNode.setAttribute(FIELD_WORKSPACELEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceState() != null) {
            object = pSDCWorkspaceBase.getWorkspaceState();
            xmlNode.setAttribute(FIELD_WORKSPACESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceType() != null) {
            object = pSDCWorkspaceBase.getWorkspaceType();
            xmlNode.setAttribute(FIELD_WORKSPACETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceUpdateDate() != null) {
            object = pSDCWorkspaceBase.getWorkspaceUpdateDate();
            xmlNode.setAttribute(FIELD_WORKSPACEUPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceBase.getWorkspaceUsage() != null) {
            object = pSDCWorkspaceBase.getWorkspaceUsage();
            xmlNode.setAttribute(FIELD_WORKSPACEUSAGE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWorkspaceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWorkspaceBase pSDCWorkspaceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWorkspaceBase.isAccessUsersDirty() && (bl || pSDCWorkspaceBase.getAccessUsers() != null)) {
            iDataObject.set(FIELD_ACCESSUSERS, (Object)pSDCWorkspaceBase.getAccessUsers());
        }
        if (pSDCWorkspaceBase.isActionOwnerDirty() && (bl || pSDCWorkspaceBase.getActionOwner() != null)) {
            iDataObject.set(FIELD_ACTIONOWNER, (Object)pSDCWorkspaceBase.getActionOwner());
        }
        if (pSDCWorkspaceBase.isActionParamDirty() && (bl || pSDCWorkspaceBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSDCWorkspaceBase.getActionParam());
        }
        if (pSDCWorkspaceBase.isActionParam2Dirty() && (bl || pSDCWorkspaceBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSDCWorkspaceBase.getActionParam2());
        }
        if (pSDCWorkspaceBase.isActionParam3Dirty() && (bl || pSDCWorkspaceBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSDCWorkspaceBase.getActionParam3());
        }
        if (pSDCWorkspaceBase.isActionParam4Dirty() && (bl || pSDCWorkspaceBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSDCWorkspaceBase.getActionParam4());
        }
        if (pSDCWorkspaceBase.isCreateDateDirty() && (bl || pSDCWorkspaceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWorkspaceBase.getCreateDate());
        }
        if (pSDCWorkspaceBase.isCreateManDirty() && (bl || pSDCWorkspaceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWorkspaceBase.getCreateMan());
        }
        if (pSDCWorkspaceBase.isCurActionDirty() && (bl || pSDCWorkspaceBase.getCurAction() != null)) {
            iDataObject.set(FIELD_CURACTION, (Object)pSDCWorkspaceBase.getCurAction());
        }
        if (pSDCWorkspaceBase.isCurActiveTimeDirty() && (bl || pSDCWorkspaceBase.getCurActiveTime() != null)) {
            iDataObject.set(FIELD_CURACTIVETIME, (Object)pSDCWorkspaceBase.getCurActiveTime());
        }
        if (pSDCWorkspaceBase.isCurExpiredTimeDirty() && (bl || pSDCWorkspaceBase.getCurExpiredTime() != null)) {
            iDataObject.set(FIELD_CUREXPIREDTIME, (Object)pSDCWorkspaceBase.getCurExpiredTime());
        }
        if (pSDCWorkspaceBase.isExpDirty() && (bl || pSDCWorkspaceBase.getExp() != null)) {
            iDataObject.set(FIELD_EXP, (Object)pSDCWorkspaceBase.getExp());
        }
        if (pSDCWorkspaceBase.isExp2Dirty() && (bl || pSDCWorkspaceBase.getExp2() != null)) {
            iDataObject.set(FIELD_EXP2, (Object)pSDCWorkspaceBase.getExp2());
        }
        if (pSDCWorkspaceBase.isExpiredTimeDirty() && (bl || pSDCWorkspaceBase.getExpiredTime() != null)) {
            iDataObject.set(FIELD_EXPIREDTIME, (Object)pSDCWorkspaceBase.getExpiredTime());
        }
        if (pSDCWorkspaceBase.isIPAddrsDirty() && (bl || pSDCWorkspaceBase.getIPAddrs() != null)) {
            iDataObject.set(FIELD_IPADDRS, (Object)pSDCWorkspaceBase.getIPAddrs());
        }
        if (pSDCWorkspaceBase.isMemoDirty() && (bl || pSDCWorkspaceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCWorkspaceBase.getMemo());
        }
        if (pSDCWorkspaceBase.isPSDCWorkspaceIdDirty() && (bl || pSDCWorkspaceBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSDCWorkspaceBase.getPSDCWorkspaceId());
        }
        if (pSDCWorkspaceBase.isPSDCWorkspaceNameDirty() && (bl || pSDCWorkspaceBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSDCWorkspaceBase.getPSDCWorkspaceName());
        }
        if (pSDCWorkspaceBase.isPSDevCenterIdDirty() && (bl || pSDCWorkspaceBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCWorkspaceBase.getPSDevCenterId());
        }
        if (pSDCWorkspaceBase.isPSDevCenterNameDirty() && (bl || pSDCWorkspaceBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCWorkspaceBase.getPSDevCenterName());
        }
        if (pSDCWorkspaceBase.isPSDevSlnIdDirty() && (bl || pSDCWorkspaceBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCWorkspaceBase.getPSDevSlnId());
        }
        if (pSDCWorkspaceBase.isPSDevSlnNameDirty() && (bl || pSDCWorkspaceBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCWorkspaceBase.getPSDevSlnName());
        }
        if (pSDCWorkspaceBase.isPSDevSlnSysIdDirty() && (bl || pSDCWorkspaceBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCWorkspaceBase.getPSDevSlnSysId());
        }
        if (pSDCWorkspaceBase.isPSDevSlnSysNameDirty() && (bl || pSDCWorkspaceBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCWorkspaceBase.getPSDevSlnSysName());
        }
        if (pSDCWorkspaceBase.isPSWorkspaceIdDirty() && (bl || pSDCWorkspaceBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSDCWorkspaceBase.getPSWorkspaceId());
        }
        if (pSDCWorkspaceBase.isPSWorkspaceNameDirty() && (bl || pSDCWorkspaceBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSDCWorkspaceBase.getPSWorkspaceName());
        }
        if (pSDCWorkspaceBase.isResStateDirty() && (bl || pSDCWorkspaceBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCWorkspaceBase.getResState());
        }
        if (pSDCWorkspaceBase.isUpdateDateDirty() && (bl || pSDCWorkspaceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWorkspaceBase.getUpdateDate());
        }
        if (pSDCWorkspaceBase.isUpdateManDirty() && (bl || pSDCWorkspaceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWorkspaceBase.getUpdateMan());
        }
        if (pSDCWorkspaceBase.isWorkspaceLevelDirty() && (bl || pSDCWorkspaceBase.getWorkspaceLevel() != null)) {
            iDataObject.set(FIELD_WORKSPACELEVEL, (Object)pSDCWorkspaceBase.getWorkspaceLevel());
        }
        if (pSDCWorkspaceBase.isWorkspaceStateDirty() && (bl || pSDCWorkspaceBase.getWorkspaceState() != null)) {
            iDataObject.set(FIELD_WORKSPACESTATE, (Object)pSDCWorkspaceBase.getWorkspaceState());
        }
        if (pSDCWorkspaceBase.isWorkspaceTypeDirty() && (bl || pSDCWorkspaceBase.getWorkspaceType() != null)) {
            iDataObject.set(FIELD_WORKSPACETYPE, (Object)pSDCWorkspaceBase.getWorkspaceType());
        }
        if (pSDCWorkspaceBase.isWorkspaceUpdateDateDirty() && (bl || pSDCWorkspaceBase.getWorkspaceUpdateDate() != null)) {
            iDataObject.set(FIELD_WORKSPACEUPDATEDATE, (Object)pSDCWorkspaceBase.getWorkspaceUpdateDate());
        }
        if (pSDCWorkspaceBase.isWorkspaceUsageDirty() && (bl || pSDCWorkspaceBase.getWorkspaceUsage() != null)) {
            iDataObject.set(FIELD_WORKSPACEUSAGE, (Object)pSDCWorkspaceBase.getWorkspaceUsage());
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
        return PSDCWorkspaceBase.remove(this, n);
    }

    private static boolean remove(PSDCWorkspaceBase pSDCWorkspaceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceBase.resetAccessUsers();
                return true;
            }
            case 1: {
                pSDCWorkspaceBase.resetActionOwner();
                return true;
            }
            case 2: {
                pSDCWorkspaceBase.resetActionParam();
                return true;
            }
            case 3: {
                pSDCWorkspaceBase.resetActionParam2();
                return true;
            }
            case 4: {
                pSDCWorkspaceBase.resetActionParam3();
                return true;
            }
            case 5: {
                pSDCWorkspaceBase.resetActionParam4();
                return true;
            }
            case 6: {
                pSDCWorkspaceBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDCWorkspaceBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDCWorkspaceBase.resetCurAction();
                return true;
            }
            case 9: {
                pSDCWorkspaceBase.resetCurActiveTime();
                return true;
            }
            case 10: {
                pSDCWorkspaceBase.resetCurExpiredTime();
                return true;
            }
            case 11: {
                pSDCWorkspaceBase.resetExp();
                return true;
            }
            case 12: {
                pSDCWorkspaceBase.resetExp2();
                return true;
            }
            case 13: {
                pSDCWorkspaceBase.resetExpiredTime();
                return true;
            }
            case 14: {
                pSDCWorkspaceBase.resetIPAddrs();
                return true;
            }
            case 15: {
                pSDCWorkspaceBase.resetMemo();
                return true;
            }
            case 16: {
                pSDCWorkspaceBase.resetPSDCWorkspaceId();
                return true;
            }
            case 17: {
                pSDCWorkspaceBase.resetPSDCWorkspaceName();
                return true;
            }
            case 18: {
                pSDCWorkspaceBase.resetPSDevCenterId();
                return true;
            }
            case 19: {
                pSDCWorkspaceBase.resetPSDevCenterName();
                return true;
            }
            case 20: {
                pSDCWorkspaceBase.resetPSDevSlnId();
                return true;
            }
            case 21: {
                pSDCWorkspaceBase.resetPSDevSlnName();
                return true;
            }
            case 22: {
                pSDCWorkspaceBase.resetPSDevSlnSysId();
                return true;
            }
            case 23: {
                pSDCWorkspaceBase.resetPSDevSlnSysName();
                return true;
            }
            case 24: {
                pSDCWorkspaceBase.resetPSWorkspaceId();
                return true;
            }
            case 25: {
                pSDCWorkspaceBase.resetPSWorkspaceName();
                return true;
            }
            case 26: {
                pSDCWorkspaceBase.resetResState();
                return true;
            }
            case 27: {
                pSDCWorkspaceBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDCWorkspaceBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDCWorkspaceBase.resetWorkspaceLevel();
                return true;
            }
            case 30: {
                pSDCWorkspaceBase.resetWorkspaceState();
                return true;
            }
            case 31: {
                pSDCWorkspaceBase.resetWorkspaceType();
                return true;
            }
            case 32: {
                pSDCWorkspaceBase.resetWorkspaceUpdateDate();
                return true;
            }
            case 33: {
                pSDCWorkspaceBase.resetWorkspaceUsage();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkspace getPSWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspace();
        }
        if (this.getPSWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSWorkspaceLock;
        synchronized (n) {
            if (this.psworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkspaceId(), (Object)this.psworkspace.getPSWorkspaceId()) != 0L) {
                this.psworkspace = null;
            }
            if (this.psworkspace == null) {
                PSWorkspace pSWorkspace = new PSWorkspace();
                pSWorkspace.setPSWorkspaceId(this.getPSWorkspaceId());
                PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSWorkspaceService.autoGet(pSWorkspace);
                this.psworkspace = pSWorkspace;
            }
            return this.psworkspace;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCWorkspaceUser> getPSDCWorkspaceUsers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceUsers();
        }
        if (this.getPSDCWorkspaceId() == null) {
            return null;
        }
        PSDCWorkspaceUserService pSDCWorkspaceUserService = (PSDCWorkspaceUserService)ServiceGlobal.getService(PSDCWorkspaceUserService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCWorkspaceUsersLock;
        synchronized (n) {
            if (this.psdcworkspaceusers == null) {
                this.psdcworkspaceusers = pSDCWorkspaceUserService.selectByPSDCWorkspace(this);
            }
            return this.psdcworkspaceusers;
        }
    }

    private PSDCWorkspaceBase getProxyEntity() {
        return this.proxyPSDCWorkspaceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWorkspaceBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWorkspaceBase) {
            this.proxyPSDCWorkspaceBase = (PSDCWorkspaceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCESSUSERS, 0);
        fieldIndexMap.put(FIELD_ACTIONOWNER, 1);
        fieldIndexMap.put(FIELD_ACTIONPARAM, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAM2, 3);
        fieldIndexMap.put(FIELD_ACTIONPARAM3, 4);
        fieldIndexMap.put(FIELD_ACTIONPARAM4, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CURACTION, 8);
        fieldIndexMap.put(FIELD_CURACTIVETIME, 9);
        fieldIndexMap.put(FIELD_CUREXPIREDTIME, 10);
        fieldIndexMap.put(FIELD_EXP, 11);
        fieldIndexMap.put(FIELD_EXP2, 12);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 13);
        fieldIndexMap.put(FIELD_IPADDRS, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 16);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 23);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 24);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 25);
        fieldIndexMap.put(FIELD_RESSTATE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_WORKSPACELEVEL, 29);
        fieldIndexMap.put(FIELD_WORKSPACESTATE, 30);
        fieldIndexMap.put(FIELD_WORKSPACETYPE, 31);
        fieldIndexMap.put(FIELD_WORKSPACEUPDATEDATE, 32);
        fieldIndexMap.put(FIELD_WORKSPACEUSAGE, 33);
    }
}

