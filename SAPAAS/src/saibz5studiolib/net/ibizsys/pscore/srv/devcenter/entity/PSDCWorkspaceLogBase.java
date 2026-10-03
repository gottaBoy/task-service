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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkspaceLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCWorkspaceLogBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGINFO2 = "LOGINFO2";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTYPE = "LOGTYPE";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACELOGID = "PSDCWORKSPACELOGID";
    public static final String FIELD_PSDCWORKSPACELOGNAME = "PSDCWORKSPACELOGNAME";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_LOGINFO = 4;
    private static final int INDEX_LOGINFO2 = 5;
    private static final int INDEX_LOGLEVEL = 6;
    private static final int INDEX_LOGLEVEL2 = 7;
    private static final int INDEX_LOGTYPE = 8;
    private static final int INDEX_PSDCWORKSPACEID = 9;
    private static final int INDEX_PSDCWORKSPACELOGID = 10;
    private static final int INDEX_PSDCWORKSPACELOGNAME = 11;
    private static final int INDEX_PSDCWORKSPACENAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNNAME = 16;
    private static final int INDEX_PSDEVSLNSYSID = 17;
    private static final int INDEX_PSDEVSLNSYSNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCWorkspaceLogBase proxyPSDCWorkspaceLogBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loginfo2DirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtypeDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacelogidDirtyFlag = false;
    private boolean psdcworkspacelognameDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loginfo2")
    private String loginfo2;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtype")
    private String logtype;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacelogid")
    private String psdcworkspacelogid;
    @Column(name="psdcworkspacelogname")
    private String psdcworkspacelogname;
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
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDCWorkspaceLock = new Integer(1);
    private PSDCWorkspace psdcworkspace = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setLogInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginfo = string;
        this.loginfoDirtyFlag = true;
    }

    public String getLogInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo();
        }
        return this.loginfo;
    }

    public boolean isLogInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfoDirty();
        }
        return this.loginfoDirtyFlag;
    }

    public void resetLogInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo();
            return;
        }
        this.loginfoDirtyFlag = false;
        this.loginfo = null;
    }

    public void setLogInfo2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginfo2 = string;
        this.loginfo2DirtyFlag = true;
    }

    public String getLogInfo2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo2();
        }
        return this.loginfo2;
    }

    public boolean isLogInfo2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfo2Dirty();
        }
        return this.loginfo2DirtyFlag;
    }

    public void resetLogInfo2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo2();
            return;
        }
        this.loginfo2DirtyFlag = false;
        this.loginfo2 = null;
    }

    public void setLogLevel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loglevel = string;
        this.loglevelDirtyFlag = true;
    }

    public String getLogLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel();
        }
        return this.loglevel;
    }

    public boolean isLogLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevelDirty();
        }
        return this.loglevelDirtyFlag;
    }

    public void resetLogLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel();
            return;
        }
        this.loglevelDirtyFlag = false;
        this.loglevel = null;
    }

    public void setLogLevel2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel2(n);
            return;
        }
        this.loglevel2 = n;
        this.loglevel2DirtyFlag = true;
    }

    public Integer getLogLevel2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel2();
        }
        return this.loglevel2;
    }

    public boolean isLogLevel2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevel2Dirty();
        }
        return this.loglevel2DirtyFlag;
    }

    public void resetLogLevel2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel2();
            return;
        }
        this.loglevel2DirtyFlag = false;
        this.loglevel2 = null;
    }

    public void setLogType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logtype = string;
        this.logtypeDirtyFlag = true;
    }

    public String getLogType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogType();
        }
        return this.logtype;
    }

    public boolean isLogTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogTypeDirty();
        }
        return this.logtypeDirtyFlag;
    }

    public void resetLogType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogType();
            return;
        }
        this.logtypeDirtyFlag = false;
        this.logtype = null;
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

    public void setPSDCWorkspaceLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacelogid = string;
        this.psdcworkspacelogidDirtyFlag = true;
    }

    public String getPSDCWorkspaceLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceLogId();
        }
        return this.psdcworkspacelogid;
    }

    public boolean isPSDCWorkspaceLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceLogIdDirty();
        }
        return this.psdcworkspacelogidDirtyFlag;
    }

    public void resetPSDCWorkspaceLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceLogId();
            return;
        }
        this.psdcworkspacelogidDirtyFlag = false;
        this.psdcworkspacelogid = null;
    }

    public void setPSDCWorkspaceLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacelogname = string;
        this.psdcworkspacelognameDirtyFlag = true;
    }

    public String getPSDCWorkspaceLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceLogName();
        }
        return this.psdcworkspacelogname;
    }

    public boolean isPSDCWorkspaceLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceLogNameDirty();
        }
        return this.psdcworkspacelognameDirtyFlag;
    }

    public void resetPSDCWorkspaceLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceLogName();
            return;
        }
        this.psdcworkspacelognameDirtyFlag = false;
        this.psdcworkspacelogname = null;
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
        PSDCWorkspaceLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCWorkspaceLogBase pSDCWorkspaceLogBase) {
        pSDCWorkspaceLogBase.resetBeginTime();
        pSDCWorkspaceLogBase.resetCreateDate();
        pSDCWorkspaceLogBase.resetCreateMan();
        pSDCWorkspaceLogBase.resetEndTime();
        pSDCWorkspaceLogBase.resetLogInfo();
        pSDCWorkspaceLogBase.resetLogInfo2();
        pSDCWorkspaceLogBase.resetLogLevel();
        pSDCWorkspaceLogBase.resetLogLevel2();
        pSDCWorkspaceLogBase.resetLogType();
        pSDCWorkspaceLogBase.resetPSDCWorkspaceId();
        pSDCWorkspaceLogBase.resetPSDCWorkspaceLogId();
        pSDCWorkspaceLogBase.resetPSDCWorkspaceLogName();
        pSDCWorkspaceLogBase.resetPSDCWorkspaceName();
        pSDCWorkspaceLogBase.resetPSDevCenterId();
        pSDCWorkspaceLogBase.resetPSDevCenterName();
        pSDCWorkspaceLogBase.resetPSDevSlnId();
        pSDCWorkspaceLogBase.resetPSDevSlnName();
        pSDCWorkspaceLogBase.resetPSDevSlnSysId();
        pSDCWorkspaceLogBase.resetPSDevSlnSysName();
        pSDCWorkspaceLogBase.resetUpdateDate();
        pSDCWorkspaceLogBase.resetUpdateMan();
        pSDCWorkspaceLogBase.resetUserTag();
        pSDCWorkspaceLogBase.resetUserTag2();
        pSDCWorkspaceLogBase.resetUserTag3();
        pSDCWorkspaceLogBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bl || this.isLogInfo2Dirty()) {
            hashMap.put(FIELD_LOGINFO2, this.getLogInfo2());
        }
        if (!bl || this.isLogLevelDirty()) {
            hashMap.put(FIELD_LOGLEVEL, this.getLogLevel());
        }
        if (!bl || this.isLogLevel2Dirty()) {
            hashMap.put(FIELD_LOGLEVEL2, this.getLogLevel2());
        }
        if (!bl || this.isLogTypeDirty()) {
            hashMap.put(FIELD_LOGTYPE, this.getLogType());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceLogIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACELOGID, this.getPSDCWorkspaceLogId());
        }
        if (!bl || this.isPSDCWorkspaceLogNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACELOGNAME, this.getPSDCWorkspaceLogName());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCWorkspaceLogBase.get(this, n);
    }

    private static Object get(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceLogBase.getBeginTime();
            }
            case 1: {
                return pSDCWorkspaceLogBase.getCreateDate();
            }
            case 2: {
                return pSDCWorkspaceLogBase.getCreateMan();
            }
            case 3: {
                return pSDCWorkspaceLogBase.getEndTime();
            }
            case 4: {
                return pSDCWorkspaceLogBase.getLogInfo();
            }
            case 5: {
                return pSDCWorkspaceLogBase.getLogInfo2();
            }
            case 6: {
                return pSDCWorkspaceLogBase.getLogLevel();
            }
            case 7: {
                return pSDCWorkspaceLogBase.getLogLevel2();
            }
            case 8: {
                return pSDCWorkspaceLogBase.getLogType();
            }
            case 9: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceId();
            }
            case 10: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceLogId();
            }
            case 11: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceLogName();
            }
            case 12: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceName();
            }
            case 13: {
                return pSDCWorkspaceLogBase.getPSDevCenterId();
            }
            case 14: {
                return pSDCWorkspaceLogBase.getPSDevCenterName();
            }
            case 15: {
                return pSDCWorkspaceLogBase.getPSDevSlnId();
            }
            case 16: {
                return pSDCWorkspaceLogBase.getPSDevSlnName();
            }
            case 17: {
                return pSDCWorkspaceLogBase.getPSDevSlnSysId();
            }
            case 18: {
                return pSDCWorkspaceLogBase.getPSDevSlnSysName();
            }
            case 19: {
                return pSDCWorkspaceLogBase.getUpdateDate();
            }
            case 20: {
                return pSDCWorkspaceLogBase.getUpdateMan();
            }
            case 21: {
                return pSDCWorkspaceLogBase.getUserTag();
            }
            case 22: {
                return pSDCWorkspaceLogBase.getUserTag2();
            }
            case 23: {
                return pSDCWorkspaceLogBase.getUserTag3();
            }
            case 24: {
                return pSDCWorkspaceLogBase.getUserTag4();
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
        PSDCWorkspaceLogBase.set(this, n, object);
    }

    private static void set(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCWorkspaceLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCWorkspaceLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCWorkspaceLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCWorkspaceLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCWorkspaceLogBase.setLogInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCWorkspaceLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCWorkspaceLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCWorkspaceLogBase.setLogType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCWorkspaceLogBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCWorkspaceLogBase.setPSDCWorkspaceLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCWorkspaceLogBase.setPSDCWorkspaceLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCWorkspaceLogBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCWorkspaceLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCWorkspaceLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCWorkspaceLogBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCWorkspaceLogBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCWorkspaceLogBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCWorkspaceLogBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCWorkspaceLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDCWorkspaceLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCWorkspaceLogBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCWorkspaceLogBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCWorkspaceLogBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCWorkspaceLogBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCWorkspaceLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceLogBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCWorkspaceLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCWorkspaceLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCWorkspaceLogBase.getEndTime() == null;
            }
            case 4: {
                return pSDCWorkspaceLogBase.getLogInfo() == null;
            }
            case 5: {
                return pSDCWorkspaceLogBase.getLogInfo2() == null;
            }
            case 6: {
                return pSDCWorkspaceLogBase.getLogLevel() == null;
            }
            case 7: {
                return pSDCWorkspaceLogBase.getLogLevel2() == null;
            }
            case 8: {
                return pSDCWorkspaceLogBase.getLogType() == null;
            }
            case 9: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceId() == null;
            }
            case 10: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceLogId() == null;
            }
            case 11: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceLogName() == null;
            }
            case 12: {
                return pSDCWorkspaceLogBase.getPSDCWorkspaceName() == null;
            }
            case 13: {
                return pSDCWorkspaceLogBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDCWorkspaceLogBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDCWorkspaceLogBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDCWorkspaceLogBase.getPSDevSlnName() == null;
            }
            case 17: {
                return pSDCWorkspaceLogBase.getPSDevSlnSysId() == null;
            }
            case 18: {
                return pSDCWorkspaceLogBase.getPSDevSlnSysName() == null;
            }
            case 19: {
                return pSDCWorkspaceLogBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDCWorkspaceLogBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDCWorkspaceLogBase.getUserTag() == null;
            }
            case 22: {
                return pSDCWorkspaceLogBase.getUserTag2() == null;
            }
            case 23: {
                return pSDCWorkspaceLogBase.getUserTag3() == null;
            }
            case 24: {
                return pSDCWorkspaceLogBase.getUserTag4() == null;
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
        return PSDCWorkspaceLogBase.contains(this, n);
    }

    private static boolean contains(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCWorkspaceLogBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCWorkspaceLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCWorkspaceLogBase.isCreateManDirty();
            }
            case 3: {
                return pSDCWorkspaceLogBase.isEndTimeDirty();
            }
            case 4: {
                return pSDCWorkspaceLogBase.isLogInfoDirty();
            }
            case 5: {
                return pSDCWorkspaceLogBase.isLogInfo2Dirty();
            }
            case 6: {
                return pSDCWorkspaceLogBase.isLogLevelDirty();
            }
            case 7: {
                return pSDCWorkspaceLogBase.isLogLevel2Dirty();
            }
            case 8: {
                return pSDCWorkspaceLogBase.isLogTypeDirty();
            }
            case 9: {
                return pSDCWorkspaceLogBase.isPSDCWorkspaceIdDirty();
            }
            case 10: {
                return pSDCWorkspaceLogBase.isPSDCWorkspaceLogIdDirty();
            }
            case 11: {
                return pSDCWorkspaceLogBase.isPSDCWorkspaceLogNameDirty();
            }
            case 12: {
                return pSDCWorkspaceLogBase.isPSDCWorkspaceNameDirty();
            }
            case 13: {
                return pSDCWorkspaceLogBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDCWorkspaceLogBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDCWorkspaceLogBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDCWorkspaceLogBase.isPSDevSlnNameDirty();
            }
            case 17: {
                return pSDCWorkspaceLogBase.isPSDevSlnSysIdDirty();
            }
            case 18: {
                return pSDCWorkspaceLogBase.isPSDevSlnSysNameDirty();
            }
            case 19: {
                return pSDCWorkspaceLogBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDCWorkspaceLogBase.isUpdateManDirty();
            }
            case 21: {
                return pSDCWorkspaceLogBase.isUserTagDirty();
            }
            case 22: {
                return pSDCWorkspaceLogBase.isUserTag2Dirty();
            }
            case 23: {
                return pSDCWorkspaceLogBase.isUserTag3Dirty();
            }
            case 24: {
                return pSDCWorkspaceLogBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCWorkspaceLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCWorkspaceLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getLogInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo2", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getLogInfo2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getLogType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtype", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getLogType()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacelogid", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDCWorkspaceLogId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacelogname", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDCWorkspaceLogName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCWorkspaceLogBase.getJSONValue((Object)pSDCWorkspaceLogBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCWorkspaceLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCWorkspaceLogBase.getBeginTime() != null) {
            object = pSDCWorkspaceLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceLogBase.getCreateDate() != null) {
            object = pSDCWorkspaceLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceLogBase.getCreateMan() != null) {
            object = pSDCWorkspaceLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getEndTime() != null) {
            object = pSDCWorkspaceLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceLogBase.getLogInfo() != null) {
            object = pSDCWorkspaceLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getLogInfo2() != null) {
            object = pSDCWorkspaceLogBase.getLogInfo2();
            xmlNode.setAttribute(FIELD_LOGINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getLogLevel() != null) {
            object = pSDCWorkspaceLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getLogLevel2() != null) {
            object = pSDCWorkspaceLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCWorkspaceLogBase.getLogType() != null) {
            object = pSDCWorkspaceLogBase.getLogType();
            xmlNode.setAttribute(FIELD_LOGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceId() != null) {
            object = pSDCWorkspaceLogBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogId() != null) {
            object = pSDCWorkspaceLogBase.getPSDCWorkspaceLogId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogName() != null) {
            object = pSDCWorkspaceLogBase.getPSDCWorkspaceLogName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceName() != null) {
            object = pSDCWorkspaceLogBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevCenterId() != null) {
            object = pSDCWorkspaceLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevCenterName() != null) {
            object = pSDCWorkspaceLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnId() != null) {
            object = pSDCWorkspaceLogBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnName() != null) {
            object = pSDCWorkspaceLogBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnSysId() != null) {
            object = pSDCWorkspaceLogBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getPSDevSlnSysName() != null) {
            object = pSDCWorkspaceLogBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getUpdateDate() != null) {
            object = pSDCWorkspaceLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCWorkspaceLogBase.getUpdateMan() != null) {
            object = pSDCWorkspaceLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag() != null) {
            object = pSDCWorkspaceLogBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag2() != null) {
            object = pSDCWorkspaceLogBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag3() != null) {
            object = pSDCWorkspaceLogBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCWorkspaceLogBase.getUserTag4() != null) {
            object = pSDCWorkspaceLogBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCWorkspaceLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCWorkspaceLogBase.isBeginTimeDirty() && (bl || pSDCWorkspaceLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCWorkspaceLogBase.getBeginTime());
        }
        if (pSDCWorkspaceLogBase.isCreateDateDirty() && (bl || pSDCWorkspaceLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCWorkspaceLogBase.getCreateDate());
        }
        if (pSDCWorkspaceLogBase.isCreateManDirty() && (bl || pSDCWorkspaceLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCWorkspaceLogBase.getCreateMan());
        }
        if (pSDCWorkspaceLogBase.isEndTimeDirty() && (bl || pSDCWorkspaceLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCWorkspaceLogBase.getEndTime());
        }
        if (pSDCWorkspaceLogBase.isLogInfoDirty() && (bl || pSDCWorkspaceLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDCWorkspaceLogBase.getLogInfo());
        }
        if (pSDCWorkspaceLogBase.isLogInfo2Dirty() && (bl || pSDCWorkspaceLogBase.getLogInfo2() != null)) {
            iDataObject.set(FIELD_LOGINFO2, (Object)pSDCWorkspaceLogBase.getLogInfo2());
        }
        if (pSDCWorkspaceLogBase.isLogLevelDirty() && (bl || pSDCWorkspaceLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSDCWorkspaceLogBase.getLogLevel());
        }
        if (pSDCWorkspaceLogBase.isLogLevel2Dirty() && (bl || pSDCWorkspaceLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSDCWorkspaceLogBase.getLogLevel2());
        }
        if (pSDCWorkspaceLogBase.isLogTypeDirty() && (bl || pSDCWorkspaceLogBase.getLogType() != null)) {
            iDataObject.set(FIELD_LOGTYPE, (Object)pSDCWorkspaceLogBase.getLogType());
        }
        if (pSDCWorkspaceLogBase.isPSDCWorkspaceIdDirty() && (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSDCWorkspaceLogBase.getPSDCWorkspaceId());
        }
        if (pSDCWorkspaceLogBase.isPSDCWorkspaceLogIdDirty() && (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACELOGID, (Object)pSDCWorkspaceLogBase.getPSDCWorkspaceLogId());
        }
        if (pSDCWorkspaceLogBase.isPSDCWorkspaceLogNameDirty() && (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceLogName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACELOGNAME, (Object)pSDCWorkspaceLogBase.getPSDCWorkspaceLogName());
        }
        if (pSDCWorkspaceLogBase.isPSDCWorkspaceNameDirty() && (bl || pSDCWorkspaceLogBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSDCWorkspaceLogBase.getPSDCWorkspaceName());
        }
        if (pSDCWorkspaceLogBase.isPSDevCenterIdDirty() && (bl || pSDCWorkspaceLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCWorkspaceLogBase.getPSDevCenterId());
        }
        if (pSDCWorkspaceLogBase.isPSDevCenterNameDirty() && (bl || pSDCWorkspaceLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCWorkspaceLogBase.getPSDevCenterName());
        }
        if (pSDCWorkspaceLogBase.isPSDevSlnIdDirty() && (bl || pSDCWorkspaceLogBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCWorkspaceLogBase.getPSDevSlnId());
        }
        if (pSDCWorkspaceLogBase.isPSDevSlnNameDirty() && (bl || pSDCWorkspaceLogBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCWorkspaceLogBase.getPSDevSlnName());
        }
        if (pSDCWorkspaceLogBase.isPSDevSlnSysIdDirty() && (bl || pSDCWorkspaceLogBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCWorkspaceLogBase.getPSDevSlnSysId());
        }
        if (pSDCWorkspaceLogBase.isPSDevSlnSysNameDirty() && (bl || pSDCWorkspaceLogBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCWorkspaceLogBase.getPSDevSlnSysName());
        }
        if (pSDCWorkspaceLogBase.isUpdateDateDirty() && (bl || pSDCWorkspaceLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCWorkspaceLogBase.getUpdateDate());
        }
        if (pSDCWorkspaceLogBase.isUpdateManDirty() && (bl || pSDCWorkspaceLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCWorkspaceLogBase.getUpdateMan());
        }
        if (pSDCWorkspaceLogBase.isUserTagDirty() && (bl || pSDCWorkspaceLogBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCWorkspaceLogBase.getUserTag());
        }
        if (pSDCWorkspaceLogBase.isUserTag2Dirty() && (bl || pSDCWorkspaceLogBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCWorkspaceLogBase.getUserTag2());
        }
        if (pSDCWorkspaceLogBase.isUserTag3Dirty() && (bl || pSDCWorkspaceLogBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCWorkspaceLogBase.getUserTag3());
        }
        if (pSDCWorkspaceLogBase.isUserTag4Dirty() && (bl || pSDCWorkspaceLogBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCWorkspaceLogBase.getUserTag4());
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
        return PSDCWorkspaceLogBase.remove(this, n);
    }

    private static boolean remove(PSDCWorkspaceLogBase pSDCWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCWorkspaceLogBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCWorkspaceLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCWorkspaceLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCWorkspaceLogBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDCWorkspaceLogBase.resetLogInfo();
                return true;
            }
            case 5: {
                pSDCWorkspaceLogBase.resetLogInfo2();
                return true;
            }
            case 6: {
                pSDCWorkspaceLogBase.resetLogLevel();
                return true;
            }
            case 7: {
                pSDCWorkspaceLogBase.resetLogLevel2();
                return true;
            }
            case 8: {
                pSDCWorkspaceLogBase.resetLogType();
                return true;
            }
            case 9: {
                pSDCWorkspaceLogBase.resetPSDCWorkspaceId();
                return true;
            }
            case 10: {
                pSDCWorkspaceLogBase.resetPSDCWorkspaceLogId();
                return true;
            }
            case 11: {
                pSDCWorkspaceLogBase.resetPSDCWorkspaceLogName();
                return true;
            }
            case 12: {
                pSDCWorkspaceLogBase.resetPSDCWorkspaceName();
                return true;
            }
            case 13: {
                pSDCWorkspaceLogBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDCWorkspaceLogBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDCWorkspaceLogBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDCWorkspaceLogBase.resetPSDevSlnName();
                return true;
            }
            case 17: {
                pSDCWorkspaceLogBase.resetPSDevSlnSysId();
                return true;
            }
            case 18: {
                pSDCWorkspaceLogBase.resetPSDevSlnSysName();
                return true;
            }
            case 19: {
                pSDCWorkspaceLogBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDCWorkspaceLogBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDCWorkspaceLogBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDCWorkspaceLogBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSDCWorkspaceLogBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSDCWorkspaceLogBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkspace getPSDCWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspace();
        }
        if (this.getPSDCWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkspaceLock;
        synchronized (n) {
            if (this.psdcworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkspaceId(), (Object)this.psdcworkspace.getPSDCWorkspaceId()) != 0L) {
                this.psdcworkspace = null;
            }
            if (this.psdcworkspace == null) {
                PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                pSDCWorkspace.setPSDCWorkspaceId(this.getPSDCWorkspaceId());
                PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkspaceService.autoGet(pSDCWorkspace);
                this.psdcworkspace = pSDCWorkspace;
            }
            return this.psdcworkspace;
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

    private PSDCWorkspaceLogBase getProxyEntity() {
        return this.proxyPSDCWorkspaceLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCWorkspaceLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCWorkspaceLogBase) {
            this.proxyPSDCWorkspaceLogBase = (PSDCWorkspaceLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_LOGINFO, 4);
        fieldIndexMap.put(FIELD_LOGINFO2, 5);
        fieldIndexMap.put(FIELD_LOGLEVEL, 6);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 7);
        fieldIndexMap.put(FIELD_LOGTYPE, 8);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 9);
        fieldIndexMap.put(FIELD_PSDCWORKSPACELOGID, 10);
        fieldIndexMap.put(FIELD_PSDCWORKSPACELOGNAME, 11);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
    }
}

