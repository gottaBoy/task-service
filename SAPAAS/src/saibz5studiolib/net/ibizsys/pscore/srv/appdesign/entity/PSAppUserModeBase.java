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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserMode;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUserModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUserModeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSAPPUSERMODEID = "PSAPPUSERMODEID";
    public static final String FIELD_PSAPPUSERMODENAME = "PSAPPUSERMODENAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSUSERMODEID = "PSSYSUSERMODEID";
    public static final String FIELD_PSSYSUSERMODENAME = "PSSYSUSERMODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSAPPMENUID = 6;
    private static final int INDEX_PSAPPMENUNAME = 7;
    private static final int INDEX_PSAPPUSERMODEID = 8;
    private static final int INDEX_PSAPPUSERMODENAME = 9;
    private static final int INDEX_PSAPPVIEWID = 10;
    private static final int INDEX_PSAPPVIEWNAME = 11;
    private static final int INDEX_PSSYSAPPID = 12;
    private static final int INDEX_PSSYSAPPNAME = 13;
    private static final int INDEX_PSSYSUSERMODEID = 14;
    private static final int INDEX_PSSYSUSERMODENAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUserModeBase proxyPSAppUserModeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psappusermodeidDirtyFlag = false;
    private boolean psappusermodenameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysusermodeidDirtyFlag = false;
    private boolean pssysusermodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psappusermodeid")
    private String psappusermodeid;
    @Column(name="psappusermodename")
    private String psappusermodename;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysusermodeid")
    private String pssysusermodeid;
    @Column(name="pssysusermodename")
    private String pssysusermodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysUserModeLock = new Integer(1);
    private PSSysUserMode pssysusermode = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSAppUserModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUserModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappusermodeid = string;
        this.psappusermodeidDirtyFlag = true;
    }

    public String getPSAppUserModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUserModeId();
        }
        return this.psappusermodeid;
    }

    public boolean isPSAppUserModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUserModeIdDirty();
        }
        return this.psappusermodeidDirtyFlag;
    }

    public void resetPSAppUserModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUserModeId();
            return;
        }
        this.psappusermodeidDirtyFlag = false;
        this.psappusermodeid = null;
    }

    public void setPSAppUserModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUserModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappusermodename = string;
        this.psappusermodenameDirtyFlag = true;
    }

    public String getPSAppUserModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUserModeName();
        }
        return this.psappusermodename;
    }

    public boolean isPSAppUserModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUserModeNameDirty();
        }
        return this.psappusermodenameDirtyFlag;
    }

    public void resetPSAppUserModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUserModeName();
            return;
        }
        this.psappusermodenameDirtyFlag = false;
        this.psappusermodename = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
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

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysUserModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusermodeid = string;
        this.pssysusermodeidDirtyFlag = true;
    }

    public String getPSSysUserModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserModeId();
        }
        return this.pssysusermodeid;
    }

    public boolean isPSSysUserModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserModeIdDirty();
        }
        return this.pssysusermodeidDirtyFlag;
    }

    public void resetPSSysUserModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserModeId();
            return;
        }
        this.pssysusermodeidDirtyFlag = false;
        this.pssysusermodeid = null;
    }

    public void setPSSysUserModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusermodename = string;
        this.pssysusermodenameDirtyFlag = true;
    }

    public String getPSSysUserModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserModeName();
        }
        return this.pssysusermodename;
    }

    public boolean isPSSysUserModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserModeNameDirty();
        }
        return this.pssysusermodenameDirtyFlag;
    }

    public void resetPSSysUserModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserModeName();
            return;
        }
        this.pssysusermodenameDirtyFlag = false;
        this.pssysusermodename = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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
        PSAppUserModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUserModeBase pSAppUserModeBase) {
        pSAppUserModeBase.resetCodeName();
        pSAppUserModeBase.resetCreateDate();
        pSAppUserModeBase.resetCreateMan();
        pSAppUserModeBase.resetDefaultFlag();
        pSAppUserModeBase.resetLogicName();
        pSAppUserModeBase.resetMemo();
        pSAppUserModeBase.resetPSAppMenuId();
        pSAppUserModeBase.resetPSAppMenuName();
        pSAppUserModeBase.resetPSAppUserModeId();
        pSAppUserModeBase.resetPSAppUserModeName();
        pSAppUserModeBase.resetPSAppViewId();
        pSAppUserModeBase.resetPSAppViewName();
        pSAppUserModeBase.resetPSSysAppId();
        pSAppUserModeBase.resetPSSysAppName();
        pSAppUserModeBase.resetPSSysUserModeId();
        pSAppUserModeBase.resetPSSysUserModeName();
        pSAppUserModeBase.resetUpdateDate();
        pSAppUserModeBase.resetUpdateMan();
        pSAppUserModeBase.resetUserCat();
        pSAppUserModeBase.resetUserTag();
        pSAppUserModeBase.resetUserTag2();
        pSAppUserModeBase.resetUserTag3();
        pSAppUserModeBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSAppUserModeIdDirty()) {
            hashMap.put(FIELD_PSAPPUSERMODEID, this.getPSAppUserModeId());
        }
        if (!bl || this.isPSAppUserModeNameDirty()) {
            hashMap.put(FIELD_PSAPPUSERMODENAME, this.getPSAppUserModeName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysUserModeIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERMODEID, this.getPSSysUserModeId());
        }
        if (!bl || this.isPSSysUserModeNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERMODENAME, this.getPSSysUserModeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        return PSAppUserModeBase.get(this, n);
    }

    private static Object get(PSAppUserModeBase pSAppUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUserModeBase.getCodeName();
            }
            case 1: {
                return pSAppUserModeBase.getCreateDate();
            }
            case 2: {
                return pSAppUserModeBase.getCreateMan();
            }
            case 3: {
                return pSAppUserModeBase.getDefaultFlag();
            }
            case 4: {
                return pSAppUserModeBase.getLogicName();
            }
            case 5: {
                return pSAppUserModeBase.getMemo();
            }
            case 6: {
                return pSAppUserModeBase.getPSAppMenuId();
            }
            case 7: {
                return pSAppUserModeBase.getPSAppMenuName();
            }
            case 8: {
                return pSAppUserModeBase.getPSAppUserModeId();
            }
            case 9: {
                return pSAppUserModeBase.getPSAppUserModeName();
            }
            case 10: {
                return pSAppUserModeBase.getPSAppViewId();
            }
            case 11: {
                return pSAppUserModeBase.getPSAppViewName();
            }
            case 12: {
                return pSAppUserModeBase.getPSSysAppId();
            }
            case 13: {
                return pSAppUserModeBase.getPSSysAppName();
            }
            case 14: {
                return pSAppUserModeBase.getPSSysUserModeId();
            }
            case 15: {
                return pSAppUserModeBase.getPSSysUserModeName();
            }
            case 16: {
                return pSAppUserModeBase.getUpdateDate();
            }
            case 17: {
                return pSAppUserModeBase.getUpdateMan();
            }
            case 18: {
                return pSAppUserModeBase.getUserCat();
            }
            case 19: {
                return pSAppUserModeBase.getUserTag();
            }
            case 20: {
                return pSAppUserModeBase.getUserTag2();
            }
            case 21: {
                return pSAppUserModeBase.getUserTag3();
            }
            case 22: {
                return pSAppUserModeBase.getUserTag4();
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
        PSAppUserModeBase.set(this, n, object);
    }

    private static void set(PSAppUserModeBase pSAppUserModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUserModeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppUserModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppUserModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUserModeBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSAppUserModeBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppUserModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppUserModeBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUserModeBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppUserModeBase.setPSAppUserModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUserModeBase.setPSAppUserModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUserModeBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUserModeBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUserModeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppUserModeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppUserModeBase.setPSSysUserModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppUserModeBase.setPSSysUserModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppUserModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSAppUserModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppUserModeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppUserModeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppUserModeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppUserModeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppUserModeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppUserModeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUserModeBase pSAppUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUserModeBase.getCodeName() == null;
            }
            case 1: {
                return pSAppUserModeBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppUserModeBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppUserModeBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSAppUserModeBase.getLogicName() == null;
            }
            case 5: {
                return pSAppUserModeBase.getMemo() == null;
            }
            case 6: {
                return pSAppUserModeBase.getPSAppMenuId() == null;
            }
            case 7: {
                return pSAppUserModeBase.getPSAppMenuName() == null;
            }
            case 8: {
                return pSAppUserModeBase.getPSAppUserModeId() == null;
            }
            case 9: {
                return pSAppUserModeBase.getPSAppUserModeName() == null;
            }
            case 10: {
                return pSAppUserModeBase.getPSAppViewId() == null;
            }
            case 11: {
                return pSAppUserModeBase.getPSAppViewName() == null;
            }
            case 12: {
                return pSAppUserModeBase.getPSSysAppId() == null;
            }
            case 13: {
                return pSAppUserModeBase.getPSSysAppName() == null;
            }
            case 14: {
                return pSAppUserModeBase.getPSSysUserModeId() == null;
            }
            case 15: {
                return pSAppUserModeBase.getPSSysUserModeName() == null;
            }
            case 16: {
                return pSAppUserModeBase.getUpdateDate() == null;
            }
            case 17: {
                return pSAppUserModeBase.getUpdateMan() == null;
            }
            case 18: {
                return pSAppUserModeBase.getUserCat() == null;
            }
            case 19: {
                return pSAppUserModeBase.getUserTag() == null;
            }
            case 20: {
                return pSAppUserModeBase.getUserTag2() == null;
            }
            case 21: {
                return pSAppUserModeBase.getUserTag3() == null;
            }
            case 22: {
                return pSAppUserModeBase.getUserTag4() == null;
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
        return PSAppUserModeBase.contains(this, n);
    }

    private static boolean contains(PSAppUserModeBase pSAppUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUserModeBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppUserModeBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppUserModeBase.isCreateManDirty();
            }
            case 3: {
                return pSAppUserModeBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSAppUserModeBase.isLogicNameDirty();
            }
            case 5: {
                return pSAppUserModeBase.isMemoDirty();
            }
            case 6: {
                return pSAppUserModeBase.isPSAppMenuIdDirty();
            }
            case 7: {
                return pSAppUserModeBase.isPSAppMenuNameDirty();
            }
            case 8: {
                return pSAppUserModeBase.isPSAppUserModeIdDirty();
            }
            case 9: {
                return pSAppUserModeBase.isPSAppUserModeNameDirty();
            }
            case 10: {
                return pSAppUserModeBase.isPSAppViewIdDirty();
            }
            case 11: {
                return pSAppUserModeBase.isPSAppViewNameDirty();
            }
            case 12: {
                return pSAppUserModeBase.isPSSysAppIdDirty();
            }
            case 13: {
                return pSAppUserModeBase.isPSSysAppNameDirty();
            }
            case 14: {
                return pSAppUserModeBase.isPSSysUserModeIdDirty();
            }
            case 15: {
                return pSAppUserModeBase.isPSSysUserModeNameDirty();
            }
            case 16: {
                return pSAppUserModeBase.isUpdateDateDirty();
            }
            case 17: {
                return pSAppUserModeBase.isUpdateManDirty();
            }
            case 18: {
                return pSAppUserModeBase.isUserCatDirty();
            }
            case 19: {
                return pSAppUserModeBase.isUserTagDirty();
            }
            case 20: {
                return pSAppUserModeBase.isUserTag2Dirty();
            }
            case 21: {
                return pSAppUserModeBase.isUserTag3Dirty();
            }
            case 22: {
                return pSAppUserModeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUserModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUserModeBase pSAppUserModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUserModeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getLogicName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppUserModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappusermodeid", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppUserModeId()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppUserModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappusermodename", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppUserModeName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSSysUserModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusermodeid", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSSysUserModeId()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getPSSysUserModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusermodename", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getPSSysUserModeName()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppUserModeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppUserModeBase.getJSONValue((Object)pSAppUserModeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUserModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUserModeBase pSAppUserModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUserModeBase.getCodeName() != null) {
            object = pSAppUserModeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getCreateDate() != null) {
            object = pSAppUserModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUserModeBase.getCreateMan() != null) {
            object = pSAppUserModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getDefaultFlag() != null) {
            object = pSAppUserModeBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUserModeBase.getLogicName() != null) {
            object = pSAppUserModeBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getMemo() != null) {
            object = pSAppUserModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppMenuId() != null) {
            object = pSAppUserModeBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppMenuName() != null) {
            object = pSAppUserModeBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppUserModeId() != null) {
            object = pSAppUserModeBase.getPSAppUserModeId();
            xmlNode.setAttribute(FIELD_PSAPPUSERMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppUserModeName() != null) {
            object = pSAppUserModeBase.getPSAppUserModeName();
            xmlNode.setAttribute(FIELD_PSAPPUSERMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppViewId() != null) {
            object = pSAppUserModeBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSAppViewName() != null) {
            object = pSAppUserModeBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSSysAppId() != null) {
            object = pSAppUserModeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSSysAppName() != null) {
            object = pSAppUserModeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSSysUserModeId() != null) {
            object = pSAppUserModeBase.getPSSysUserModeId();
            xmlNode.setAttribute(FIELD_PSSYSUSERMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getPSSysUserModeName() != null) {
            object = pSAppUserModeBase.getPSSysUserModeName();
            xmlNode.setAttribute(FIELD_PSSYSUSERMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUpdateDate() != null) {
            object = pSAppUserModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUserModeBase.getUpdateMan() != null) {
            object = pSAppUserModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUserCat() != null) {
            object = pSAppUserModeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUserTag() != null) {
            object = pSAppUserModeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUserTag2() != null) {
            object = pSAppUserModeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUserTag3() != null) {
            object = pSAppUserModeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppUserModeBase.getUserTag4() != null) {
            object = pSAppUserModeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUserModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUserModeBase pSAppUserModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUserModeBase.isCodeNameDirty() && (bl || pSAppUserModeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppUserModeBase.getCodeName());
        }
        if (pSAppUserModeBase.isCreateDateDirty() && (bl || pSAppUserModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUserModeBase.getCreateDate());
        }
        if (pSAppUserModeBase.isCreateManDirty() && (bl || pSAppUserModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUserModeBase.getCreateMan());
        }
        if (pSAppUserModeBase.isDefaultFlagDirty() && (bl || pSAppUserModeBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSAppUserModeBase.getDefaultFlag());
        }
        if (pSAppUserModeBase.isLogicNameDirty() && (bl || pSAppUserModeBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSAppUserModeBase.getLogicName());
        }
        if (pSAppUserModeBase.isMemoDirty() && (bl || pSAppUserModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUserModeBase.getMemo());
        }
        if (pSAppUserModeBase.isPSAppMenuIdDirty() && (bl || pSAppUserModeBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppUserModeBase.getPSAppMenuId());
        }
        if (pSAppUserModeBase.isPSAppMenuNameDirty() && (bl || pSAppUserModeBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppUserModeBase.getPSAppMenuName());
        }
        if (pSAppUserModeBase.isPSAppUserModeIdDirty() && (bl || pSAppUserModeBase.getPSAppUserModeId() != null)) {
            iDataObject.set(FIELD_PSAPPUSERMODEID, (Object)pSAppUserModeBase.getPSAppUserModeId());
        }
        if (pSAppUserModeBase.isPSAppUserModeNameDirty() && (bl || pSAppUserModeBase.getPSAppUserModeName() != null)) {
            iDataObject.set(FIELD_PSAPPUSERMODENAME, (Object)pSAppUserModeBase.getPSAppUserModeName());
        }
        if (pSAppUserModeBase.isPSAppViewIdDirty() && (bl || pSAppUserModeBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppUserModeBase.getPSAppViewId());
        }
        if (pSAppUserModeBase.isPSAppViewNameDirty() && (bl || pSAppUserModeBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppUserModeBase.getPSAppViewName());
        }
        if (pSAppUserModeBase.isPSSysAppIdDirty() && (bl || pSAppUserModeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppUserModeBase.getPSSysAppId());
        }
        if (pSAppUserModeBase.isPSSysAppNameDirty() && (bl || pSAppUserModeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppUserModeBase.getPSSysAppName());
        }
        if (pSAppUserModeBase.isPSSysUserModeIdDirty() && (bl || pSAppUserModeBase.getPSSysUserModeId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERMODEID, (Object)pSAppUserModeBase.getPSSysUserModeId());
        }
        if (pSAppUserModeBase.isPSSysUserModeNameDirty() && (bl || pSAppUserModeBase.getPSSysUserModeName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERMODENAME, (Object)pSAppUserModeBase.getPSSysUserModeName());
        }
        if (pSAppUserModeBase.isUpdateDateDirty() && (bl || pSAppUserModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUserModeBase.getUpdateDate());
        }
        if (pSAppUserModeBase.isUpdateManDirty() && (bl || pSAppUserModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUserModeBase.getUpdateMan());
        }
        if (pSAppUserModeBase.isUserCatDirty() && (bl || pSAppUserModeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppUserModeBase.getUserCat());
        }
        if (pSAppUserModeBase.isUserTagDirty() && (bl || pSAppUserModeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppUserModeBase.getUserTag());
        }
        if (pSAppUserModeBase.isUserTag2Dirty() && (bl || pSAppUserModeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppUserModeBase.getUserTag2());
        }
        if (pSAppUserModeBase.isUserTag3Dirty() && (bl || pSAppUserModeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppUserModeBase.getUserTag3());
        }
        if (pSAppUserModeBase.isUserTag4Dirty() && (bl || pSAppUserModeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppUserModeBase.getUserTag4());
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
        return PSAppUserModeBase.remove(this, n);
    }

    private static boolean remove(PSAppUserModeBase pSAppUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUserModeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppUserModeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppUserModeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppUserModeBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSAppUserModeBase.resetLogicName();
                return true;
            }
            case 5: {
                pSAppUserModeBase.resetMemo();
                return true;
            }
            case 6: {
                pSAppUserModeBase.resetPSAppMenuId();
                return true;
            }
            case 7: {
                pSAppUserModeBase.resetPSAppMenuName();
                return true;
            }
            case 8: {
                pSAppUserModeBase.resetPSAppUserModeId();
                return true;
            }
            case 9: {
                pSAppUserModeBase.resetPSAppUserModeName();
                return true;
            }
            case 10: {
                pSAppUserModeBase.resetPSAppViewId();
                return true;
            }
            case 11: {
                pSAppUserModeBase.resetPSAppViewName();
                return true;
            }
            case 12: {
                pSAppUserModeBase.resetPSSysAppId();
                return true;
            }
            case 13: {
                pSAppUserModeBase.resetPSSysAppName();
                return true;
            }
            case 14: {
                pSAppUserModeBase.resetPSSysUserModeId();
                return true;
            }
            case 15: {
                pSAppUserModeBase.resetPSSysUserModeName();
                return true;
            }
            case 16: {
                pSAppUserModeBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSAppUserModeBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSAppUserModeBase.resetUserCat();
                return true;
            }
            case 19: {
                pSAppUserModeBase.resetUserTag();
                return true;
            }
            case 20: {
                pSAppUserModeBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSAppUserModeBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSAppUserModeBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet((IEntity)pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserMode getPSSysUserMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserMode();
        }
        if (this.getPSSysUserModeId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserModeLock;
        synchronized (n) {
            if (this.pssysusermode != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserModeId(), (Object)this.pssysusermode.getPSSysUserModeId()) != 0L) {
                this.pssysusermode = null;
            }
            if (this.pssysusermode == null) {
                PSSysUserMode pSSysUserMode = new PSSysUserMode();
                pSSysUserMode.setPSSysUserModeId(this.getPSSysUserModeId());
                PSSysUserModeService pSSysUserModeService = (PSSysUserModeService)ServiceGlobal.getService(PSSysUserModeService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserModeService.autoGet((IEntity)pSSysUserMode);
                this.pssysusermode = pSSysUserMode;
            }
            return this.pssysusermode;
        }
    }

    private PSAppUserModeBase getProxyEntity() {
        return this.proxyPSAppUserModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUserModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUserModeBase) {
            this.proxyPSAppUserModeBase = (PSAppUserModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 6);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 7);
        fieldIndexMap.put(FIELD_PSAPPUSERMODEID, 8);
        fieldIndexMap.put(FIELD_PSAPPUSERMODENAME, 9);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 10);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 12);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSUSERMODEID, 14);
        fieldIndexMap.put(FIELD_PSSYSUSERMODENAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

