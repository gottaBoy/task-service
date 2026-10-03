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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysKeyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysKeyBase.class);
    public static final String FIELD_ADMINMODE = "ADMINMODE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_KEYCOUNT = "KEYCOUNT";
    public static final String FIELD_KEYSTATE = "KEYSTATE";
    public static final String FIELD_LOGINUSERFLAG = "LOGINUSERFLAG";
    public static final String FIELD_LOGINUSERID = "LOGINUSERID";
    public static final String FIELD_LOGINUSERNAME = "LOGINUSERNAME";
    public static final String FIELD_PSDEPSLNSYSDYNAINSTID = "PSDEPSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEPSLNSYSDYNAINSTNAME = "PSDEPSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSKEYID = "PSDEPSLNSYSKEYID";
    public static final String FIELD_PSDEPSLNSYSKEYNAME = "PSDEPSLNSYSKEYNAME";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ADMINMODE = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_KEYCOUNT = 5;
    private static final int INDEX_KEYSTATE = 6;
    private static final int INDEX_LOGINUSERFLAG = 7;
    private static final int INDEX_LOGINUSERID = 8;
    private static final int INDEX_LOGINUSERNAME = 9;
    private static final int INDEX_PSDEPSLNSYSDYNAINSTID = 10;
    private static final int INDEX_PSDEPSLNSYSDYNAINSTNAME = 11;
    private static final int INDEX_PSDEPSLNSYSID = 12;
    private static final int INDEX_PSDEPSLNSYSKEYID = 13;
    private static final int INDEX_PSDEPSLNSYSKEYNAME = 14;
    private static final int INDEX_PSDEPSLNSYSNAME = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysKeyBase proxyPSDepSlnSysKeyBase = null;
    private boolean adminmodeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean keycountDirtyFlag = false;
    private boolean keystateDirtyFlag = false;
    private boolean loginuserflagDirtyFlag = false;
    private boolean loginuseridDirtyFlag = false;
    private boolean loginusernameDirtyFlag = false;
    private boolean psdepslnsysdynainstidDirtyFlag = false;
    private boolean psdepslnsysdynainstnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsyskeyidDirtyFlag = false;
    private boolean psdepslnsyskeynameDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="adminmode")
    private Integer adminmode;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="keycount")
    private Integer keycount;
    @Column(name="keystate")
    private Integer keystate;
    @Column(name="loginuserflag")
    private Integer loginuserflag;
    @Column(name="loginuserid")
    private String loginuserid;
    @Column(name="loginusername")
    private String loginusername;
    @Column(name="psdepslnsysdynainstid")
    private String psdepslnsysdynainstid;
    @Column(name="psdepslnsysdynainstname")
    private String psdepslnsysdynainstname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsyskeyid")
    private String psdepslnsyskeyid;
    @Column(name="psdepslnsyskeyname")
    private String psdepslnsyskeyname;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnSysDynaInstLock = new Integer(1);
    private PSDepSlnSysDynaInst psdepslnsysdynainst = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAdminMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminMode(n);
            return;
        }
        this.adminmode = n;
        this.adminmodeDirtyFlag = true;
    }

    public Integer getAdminMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminMode();
        }
        return this.adminmode;
    }

    public boolean isAdminModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminModeDirty();
        }
        return this.adminmodeDirtyFlag;
    }

    public void resetAdminMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminMode();
            return;
        }
        this.adminmodeDirtyFlag = false;
        this.adminmode = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setKeyCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyCount(n);
            return;
        }
        this.keycount = n;
        this.keycountDirtyFlag = true;
    }

    public Integer getKeyCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyCount();
        }
        return this.keycount;
    }

    public boolean isKeyCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyCountDirty();
        }
        return this.keycountDirtyFlag;
    }

    public void resetKeyCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyCount();
            return;
        }
        this.keycountDirtyFlag = false;
        this.keycount = null;
    }

    public void setKeyState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyState(n);
            return;
        }
        this.keystate = n;
        this.keystateDirtyFlag = true;
    }

    public Integer getKeyState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyState();
        }
        return this.keystate;
    }

    public boolean isKeyStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyStateDirty();
        }
        return this.keystateDirtyFlag;
    }

    public void resetKeyState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyState();
            return;
        }
        this.keystateDirtyFlag = false;
        this.keystate = null;
    }

    public void setLoginUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginUserFlag(n);
            return;
        }
        this.loginuserflag = n;
        this.loginuserflagDirtyFlag = true;
    }

    public Integer getLoginUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginUserFlag();
        }
        return this.loginuserflag;
    }

    public boolean isLoginUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginUserFlagDirty();
        }
        return this.loginuserflagDirtyFlag;
    }

    public void resetLoginUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginUserFlag();
            return;
        }
        this.loginuserflagDirtyFlag = false;
        this.loginuserflag = null;
    }

    public void setLoginUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginuserid = string;
        this.loginuseridDirtyFlag = true;
    }

    public String getLoginUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginUserId();
        }
        return this.loginuserid;
    }

    public boolean isLoginUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginUserIdDirty();
        }
        return this.loginuseridDirtyFlag;
    }

    public void resetLoginUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginUserId();
            return;
        }
        this.loginuseridDirtyFlag = false;
        this.loginuserid = null;
    }

    public void setLoginUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginusername = string;
        this.loginusernameDirtyFlag = true;
    }

    public String getLoginUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginUserName();
        }
        return this.loginusername;
    }

    public boolean isLoginUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginUserNameDirty();
        }
        return this.loginusernameDirtyFlag;
    }

    public void resetLoginUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginUserName();
            return;
        }
        this.loginusernameDirtyFlag = false;
        this.loginusername = null;
    }

    public void setPSDepSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdynainstid = string;
        this.psdepslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInstId();
        }
        return this.psdepslnsysdynainstid;
    }

    public boolean isPSDepSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDynaInstIdDirty();
        }
        return this.psdepslnsysdynainstidDirtyFlag;
    }

    public void resetPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDynaInstId();
            return;
        }
        this.psdepslnsysdynainstidDirtyFlag = false;
        this.psdepslnsysdynainstid = null;
    }

    public void setPSDepSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdynainstname = string;
        this.psdepslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInstName();
        }
        return this.psdepslnsysdynainstname;
    }

    public boolean isPSDepSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDynaInstNameDirty();
        }
        return this.psdepslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDynaInstName();
            return;
        }
        this.psdepslnsysdynainstnameDirtyFlag = false;
        this.psdepslnsysdynainstname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysKeyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysKeyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsyskeyid = string;
        this.psdepslnsyskeyidDirtyFlag = true;
    }

    public String getPSDepSlnSysKeyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysKeyId();
        }
        return this.psdepslnsyskeyid;
    }

    public boolean isPSDepSlnSysKeyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysKeyIdDirty();
        }
        return this.psdepslnsyskeyidDirtyFlag;
    }

    public void resetPSDepSlnSysKeyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysKeyId();
            return;
        }
        this.psdepslnsyskeyidDirtyFlag = false;
        this.psdepslnsyskeyid = null;
    }

    public void setPSDepSlnSysKeyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysKeyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsyskeyname = string;
        this.psdepslnsyskeynameDirtyFlag = true;
    }

    public String getPSDepSlnSysKeyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysKeyName();
        }
        return this.psdepslnsyskeyname;
    }

    public boolean isPSDepSlnSysKeyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysKeyNameDirty();
        }
        return this.psdepslnsyskeynameDirtyFlag;
    }

    public void resetPSDepSlnSysKeyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysKeyName();
            return;
        }
        this.psdepslnsyskeynameDirtyFlag = false;
        this.psdepslnsyskeyname = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
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

    protected void onReset() {
        PSDepSlnSysKeyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysKeyBase pSDepSlnSysKeyBase) {
        pSDepSlnSysKeyBase.resetAdminMode();
        pSDepSlnSysKeyBase.resetBeginTime();
        pSDepSlnSysKeyBase.resetCreateDate();
        pSDepSlnSysKeyBase.resetCreateMan();
        pSDepSlnSysKeyBase.resetEndTime();
        pSDepSlnSysKeyBase.resetKeyCount();
        pSDepSlnSysKeyBase.resetKeyState();
        pSDepSlnSysKeyBase.resetLoginUserFlag();
        pSDepSlnSysKeyBase.resetLoginUserId();
        pSDepSlnSysKeyBase.resetLoginUserName();
        pSDepSlnSysKeyBase.resetPSDepSlnSysDynaInstId();
        pSDepSlnSysKeyBase.resetPSDepSlnSysDynaInstName();
        pSDepSlnSysKeyBase.resetPSDepSlnSysId();
        pSDepSlnSysKeyBase.resetPSDepSlnSysKeyId();
        pSDepSlnSysKeyBase.resetPSDepSlnSysKeyName();
        pSDepSlnSysKeyBase.resetPSDepSlnSysName();
        pSDepSlnSysKeyBase.resetPSDevCenterId();
        pSDepSlnSysKeyBase.resetPSDevCenterName();
        pSDepSlnSysKeyBase.resetUpdateDate();
        pSDepSlnSysKeyBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminModeDirty()) {
            hashMap.put(FIELD_ADMINMODE, this.getAdminMode());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isKeyCountDirty()) {
            hashMap.put(FIELD_KEYCOUNT, this.getKeyCount());
        }
        if (!bl || this.isKeyStateDirty()) {
            hashMap.put(FIELD_KEYSTATE, this.getKeyState());
        }
        if (!bl || this.isLoginUserFlagDirty()) {
            hashMap.put(FIELD_LOGINUSERFLAG, this.getLoginUserFlag());
        }
        if (!bl || this.isLoginUserIdDirty()) {
            hashMap.put(FIELD_LOGINUSERID, this.getLoginUserId());
        }
        if (!bl || this.isLoginUserNameDirty()) {
            hashMap.put(FIELD_LOGINUSERNAME, this.getLoginUserName());
        }
        if (!bl || this.isPSDepSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDYNAINSTID, this.getPSDepSlnSysDynaInstId());
        }
        if (!bl || this.isPSDepSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDYNAINSTNAME, this.getPSDepSlnSysDynaInstName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysKeyIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSKEYID, this.getPSDepSlnSysKeyId());
        }
        if (!bl || this.isPSDepSlnSysKeyNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSKEYNAME, this.getPSDepSlnSysKeyName());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDepSlnSysKeyBase.get(this, n);
    }

    private static Object get(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysKeyBase.getAdminMode();
            }
            case 1: {
                return pSDepSlnSysKeyBase.getBeginTime();
            }
            case 2: {
                return pSDepSlnSysKeyBase.getCreateDate();
            }
            case 3: {
                return pSDepSlnSysKeyBase.getCreateMan();
            }
            case 4: {
                return pSDepSlnSysKeyBase.getEndTime();
            }
            case 5: {
                return pSDepSlnSysKeyBase.getKeyCount();
            }
            case 6: {
                return pSDepSlnSysKeyBase.getKeyState();
            }
            case 7: {
                return pSDepSlnSysKeyBase.getLoginUserFlag();
            }
            case 8: {
                return pSDepSlnSysKeyBase.getLoginUserId();
            }
            case 9: {
                return pSDepSlnSysKeyBase.getLoginUserName();
            }
            case 10: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId();
            }
            case 11: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName();
            }
            case 12: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysId();
            }
            case 13: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysKeyId();
            }
            case 14: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysKeyName();
            }
            case 15: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysName();
            }
            case 16: {
                return pSDepSlnSysKeyBase.getPSDevCenterId();
            }
            case 17: {
                return pSDepSlnSysKeyBase.getPSDevCenterName();
            }
            case 18: {
                return pSDepSlnSysKeyBase.getUpdateDate();
            }
            case 19: {
                return pSDepSlnSysKeyBase.getUpdateMan();
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
        PSDepSlnSysKeyBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysKeyBase.setAdminMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysKeyBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysKeyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysKeyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysKeyBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysKeyBase.setKeyCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysKeyBase.setKeyState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysKeyBase.setLoginUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysKeyBase.setLoginUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysKeyBase.setLoginUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysKeyBase.setPSDepSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysKeyBase.setPSDepSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysKeyBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnSysKeyBase.setPSDepSlnSysKeyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnSysKeyBase.setPSDepSlnSysKeyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnSysKeyBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnSysKeyBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnSysKeyBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnSysKeyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDepSlnSysKeyBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysKeyBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysKeyBase.getAdminMode() == null;
            }
            case 1: {
                return pSDepSlnSysKeyBase.getBeginTime() == null;
            }
            case 2: {
                return pSDepSlnSysKeyBase.getCreateDate() == null;
            }
            case 3: {
                return pSDepSlnSysKeyBase.getCreateMan() == null;
            }
            case 4: {
                return pSDepSlnSysKeyBase.getEndTime() == null;
            }
            case 5: {
                return pSDepSlnSysKeyBase.getKeyCount() == null;
            }
            case 6: {
                return pSDepSlnSysKeyBase.getKeyState() == null;
            }
            case 7: {
                return pSDepSlnSysKeyBase.getLoginUserFlag() == null;
            }
            case 8: {
                return pSDepSlnSysKeyBase.getLoginUserId() == null;
            }
            case 9: {
                return pSDepSlnSysKeyBase.getLoginUserName() == null;
            }
            case 10: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId() == null;
            }
            case 11: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName() == null;
            }
            case 12: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysId() == null;
            }
            case 13: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysKeyId() == null;
            }
            case 14: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysKeyName() == null;
            }
            case 15: {
                return pSDepSlnSysKeyBase.getPSDepSlnSysName() == null;
            }
            case 16: {
                return pSDepSlnSysKeyBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSDepSlnSysKeyBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSDepSlnSysKeyBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDepSlnSysKeyBase.getUpdateMan() == null;
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
        return PSDepSlnSysKeyBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysKeyBase.isAdminModeDirty();
            }
            case 1: {
                return pSDepSlnSysKeyBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDepSlnSysKeyBase.isCreateDateDirty();
            }
            case 3: {
                return pSDepSlnSysKeyBase.isCreateManDirty();
            }
            case 4: {
                return pSDepSlnSysKeyBase.isEndTimeDirty();
            }
            case 5: {
                return pSDepSlnSysKeyBase.isKeyCountDirty();
            }
            case 6: {
                return pSDepSlnSysKeyBase.isKeyStateDirty();
            }
            case 7: {
                return pSDepSlnSysKeyBase.isLoginUserFlagDirty();
            }
            case 8: {
                return pSDepSlnSysKeyBase.isLoginUserIdDirty();
            }
            case 9: {
                return pSDepSlnSysKeyBase.isLoginUserNameDirty();
            }
            case 10: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysDynaInstIdDirty();
            }
            case 11: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysDynaInstNameDirty();
            }
            case 12: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysIdDirty();
            }
            case 13: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysKeyIdDirty();
            }
            case 14: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysKeyNameDirty();
            }
            case 15: {
                return pSDepSlnSysKeyBase.isPSDepSlnSysNameDirty();
            }
            case 16: {
                return pSDepSlnSysKeyBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSDepSlnSysKeyBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSDepSlnSysKeyBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDepSlnSysKeyBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysKeyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysKeyBase.getAdminMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminmode", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getAdminMode()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getKeyCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keycount", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getKeyCount()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getKeyState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keystate", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getKeyState()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginuserflag", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getLoginUserFlag()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginuserid", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getLoginUserId()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginusername", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getLoginUserName()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdynainstid", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdynainstname", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsyskeyid", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysKeyId()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsyskeyname", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysKeyName()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysKeyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysKeyBase.getJSONValue((Object)pSDepSlnSysKeyBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysKeyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysKeyBase.getAdminMode() != null) {
            object = pSDepSlnSysKeyBase.getAdminMode();
            xmlNode.setAttribute(FIELD_ADMINMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getBeginTime() != null) {
            object = pSDepSlnSysKeyBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getCreateDate() != null) {
            object = pSDepSlnSysKeyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getCreateMan() != null) {
            object = pSDepSlnSysKeyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getEndTime() != null) {
            object = pSDepSlnSysKeyBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getKeyCount() != null) {
            object = pSDepSlnSysKeyBase.getKeyCount();
            xmlNode.setAttribute(FIELD_KEYCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getKeyState() != null) {
            object = pSDepSlnSysKeyBase.getKeyState();
            xmlNode.setAttribute(FIELD_KEYSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserFlag() != null) {
            object = pSDepSlnSysKeyBase.getLoginUserFlag();
            xmlNode.setAttribute(FIELD_LOGINUSERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserId() != null) {
            object = pSDepSlnSysKeyBase.getLoginUserId();
            xmlNode.setAttribute(FIELD_LOGINUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getLoginUserName() != null) {
            object = pSDepSlnSysKeyBase.getLoginUserName();
            xmlNode.setAttribute(FIELD_LOGINUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyId() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysKeyId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSKEYID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyName() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysKeyName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSKEYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysKeyBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDevCenterId() != null) {
            object = pSDepSlnSysKeyBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getPSDevCenterName() != null) {
            object = pSDepSlnSysKeyBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysKeyBase.getUpdateDate() != null) {
            object = pSDepSlnSysKeyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysKeyBase.getUpdateMan() != null) {
            object = pSDepSlnSysKeyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysKeyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysKeyBase.isAdminModeDirty() && (bl || pSDepSlnSysKeyBase.getAdminMode() != null)) {
            iDataObject.set(FIELD_ADMINMODE, (Object)pSDepSlnSysKeyBase.getAdminMode());
        }
        if (pSDepSlnSysKeyBase.isBeginTimeDirty() && (bl || pSDepSlnSysKeyBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDepSlnSysKeyBase.getBeginTime());
        }
        if (pSDepSlnSysKeyBase.isCreateDateDirty() && (bl || pSDepSlnSysKeyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysKeyBase.getCreateDate());
        }
        if (pSDepSlnSysKeyBase.isCreateManDirty() && (bl || pSDepSlnSysKeyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysKeyBase.getCreateMan());
        }
        if (pSDepSlnSysKeyBase.isEndTimeDirty() && (bl || pSDepSlnSysKeyBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDepSlnSysKeyBase.getEndTime());
        }
        if (pSDepSlnSysKeyBase.isKeyCountDirty() && (bl || pSDepSlnSysKeyBase.getKeyCount() != null)) {
            iDataObject.set(FIELD_KEYCOUNT, (Object)pSDepSlnSysKeyBase.getKeyCount());
        }
        if (pSDepSlnSysKeyBase.isKeyStateDirty() && (bl || pSDepSlnSysKeyBase.getKeyState() != null)) {
            iDataObject.set(FIELD_KEYSTATE, (Object)pSDepSlnSysKeyBase.getKeyState());
        }
        if (pSDepSlnSysKeyBase.isLoginUserFlagDirty() && (bl || pSDepSlnSysKeyBase.getLoginUserFlag() != null)) {
            iDataObject.set(FIELD_LOGINUSERFLAG, (Object)pSDepSlnSysKeyBase.getLoginUserFlag());
        }
        if (pSDepSlnSysKeyBase.isLoginUserIdDirty() && (bl || pSDepSlnSysKeyBase.getLoginUserId() != null)) {
            iDataObject.set(FIELD_LOGINUSERID, (Object)pSDepSlnSysKeyBase.getLoginUserId());
        }
        if (pSDepSlnSysKeyBase.isLoginUserNameDirty() && (bl || pSDepSlnSysKeyBase.getLoginUserName() != null)) {
            iDataObject.set(FIELD_LOGINUSERNAME, (Object)pSDepSlnSysKeyBase.getLoginUserName());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysDynaInstIdDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDYNAINSTID, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstId());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysDynaInstNameDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDYNAINSTNAME, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysDynaInstName());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysKeyIdDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSKEYID, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysKeyId());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysKeyNameDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysKeyName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSKEYNAME, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysKeyName());
        }
        if (pSDepSlnSysKeyBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysKeyBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysKeyBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysKeyBase.isPSDevCenterIdDirty() && (bl || pSDepSlnSysKeyBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDepSlnSysKeyBase.getPSDevCenterId());
        }
        if (pSDepSlnSysKeyBase.isPSDevCenterNameDirty() && (bl || pSDepSlnSysKeyBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDepSlnSysKeyBase.getPSDevCenterName());
        }
        if (pSDepSlnSysKeyBase.isUpdateDateDirty() && (bl || pSDepSlnSysKeyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysKeyBase.getUpdateDate());
        }
        if (pSDepSlnSysKeyBase.isUpdateManDirty() && (bl || pSDepSlnSysKeyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysKeyBase.getUpdateMan());
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
        return PSDepSlnSysKeyBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysKeyBase pSDepSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysKeyBase.resetAdminMode();
                return true;
            }
            case 1: {
                pSDepSlnSysKeyBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDepSlnSysKeyBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDepSlnSysKeyBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDepSlnSysKeyBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDepSlnSysKeyBase.resetKeyCount();
                return true;
            }
            case 6: {
                pSDepSlnSysKeyBase.resetKeyState();
                return true;
            }
            case 7: {
                pSDepSlnSysKeyBase.resetLoginUserFlag();
                return true;
            }
            case 8: {
                pSDepSlnSysKeyBase.resetLoginUserId();
                return true;
            }
            case 9: {
                pSDepSlnSysKeyBase.resetLoginUserName();
                return true;
            }
            case 10: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysDynaInstId();
                return true;
            }
            case 11: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysDynaInstName();
                return true;
            }
            case 12: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysId();
                return true;
            }
            case 13: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysKeyId();
                return true;
            }
            case 14: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysKeyName();
                return true;
            }
            case 15: {
                pSDepSlnSysKeyBase.resetPSDepSlnSysName();
                return true;
            }
            case 16: {
                pSDepSlnSysKeyBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSDepSlnSysKeyBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSDepSlnSysKeyBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDepSlnSysKeyBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSysDynaInst getPSDepSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInst();
        }
        if (this.getPSDepSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysDynaInstLock;
        synchronized (n) {
            if (this.psdepslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysDynaInstId(), (Object)this.psdepslnsysdynainst.getPSDepSlnSysDynaInstId()) != 0L) {
                this.psdepslnsysdynainst = null;
            }
            if (this.psdepslnsysdynainst == null) {
                PSDepSlnSysDynaInst pSDepSlnSysDynaInst = new PSDepSlnSysDynaInst();
                pSDepSlnSysDynaInst.setPSDepSlnSysDynaInstId(this.getPSDepSlnSysDynaInstId());
                PSDepSlnSysDynaInstService pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysDynaInstService.autoGet(pSDepSlnSysDynaInst);
                this.psdepslnsysdynainst = pSDepSlnSysDynaInst;
            }
            return this.psdepslnsysdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDepSlnSysKeyBase getProxyEntity() {
        return this.proxyPSDepSlnSysKeyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysKeyBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysKeyBase) {
            this.proxyPSDepSlnSysKeyBase = (PSDepSlnSysKeyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINMODE, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_KEYCOUNT, 5);
        fieldIndexMap.put(FIELD_KEYSTATE, 6);
        fieldIndexMap.put(FIELD_LOGINUSERFLAG, 7);
        fieldIndexMap.put(FIELD_LOGINUSERID, 8);
        fieldIndexMap.put(FIELD_LOGINUSERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDYNAINSTNAME, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSKEYID, 13);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSKEYNAME, 14);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

