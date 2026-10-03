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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspaceLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkspaceLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTYPE = "LOGTYPE";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACELOGID = "PSWORKSPACELOGID";
    public static final String FIELD_PSWORKSPACELOGNAME = "PSWORKSPACELOGNAME";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGINFO = 2;
    private static final int INDEX_LOGLEVEL = 3;
    private static final int INDEX_LOGLEVEL2 = 4;
    private static final int INDEX_LOGTYPE = 5;
    private static final int INDEX_PSSVRDOMAINID = 6;
    private static final int INDEX_PSSVRDOMAINNAME = 7;
    private static final int INDEX_PSTASKSERVERID = 8;
    private static final int INDEX_PSTASKSERVERNAME = 9;
    private static final int INDEX_PSWORKSPACEID = 10;
    private static final int INDEX_PSWORKSPACELOGID = 11;
    private static final int INDEX_PSWORKSPACELOGNAME = 12;
    private static final int INDEX_PSWORKSPACENAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkspaceLogBase proxyPSWorkspaceLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtypeDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacelogidDirtyFlag = false;
    private boolean psworkspacelognameDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtype")
    private String logtype;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacelogid")
    private String psworkspacelogid;
    @Column(name="psworkspacelogname")
    private String psworkspacelogname;
    @Column(name="psworkspacename")
    private String psworkspacename;
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
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSWorkspaceLock = new Integer(1);
    private PSWorkspace psworkspace = null;

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

    public void setPSWorkspaceLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacelogid = string;
        this.psworkspacelogidDirtyFlag = true;
    }

    public String getPSWorkspaceLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceLogId();
        }
        return this.psworkspacelogid;
    }

    public boolean isPSWorkspaceLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceLogIdDirty();
        }
        return this.psworkspacelogidDirtyFlag;
    }

    public void resetPSWorkspaceLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceLogId();
            return;
        }
        this.psworkspacelogidDirtyFlag = false;
        this.psworkspacelogid = null;
    }

    public void setPSWorkspaceLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacelogname = string;
        this.psworkspacelognameDirtyFlag = true;
    }

    public String getPSWorkspaceLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceLogName();
        }
        return this.psworkspacelogname;
    }

    public boolean isPSWorkspaceLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceLogNameDirty();
        }
        return this.psworkspacelognameDirtyFlag;
    }

    public void resetPSWorkspaceLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceLogName();
            return;
        }
        this.psworkspacelognameDirtyFlag = false;
        this.psworkspacelogname = null;
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
        PSWorkspaceLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkspaceLogBase pSWorkspaceLogBase) {
        pSWorkspaceLogBase.resetCreateDate();
        pSWorkspaceLogBase.resetCreateMan();
        pSWorkspaceLogBase.resetLogInfo();
        pSWorkspaceLogBase.resetLogLevel();
        pSWorkspaceLogBase.resetLogLevel2();
        pSWorkspaceLogBase.resetLogType();
        pSWorkspaceLogBase.resetPSSvrDomainId();
        pSWorkspaceLogBase.resetPSSvrDomainName();
        pSWorkspaceLogBase.resetPSTaskServerId();
        pSWorkspaceLogBase.resetPSTaskServerName();
        pSWorkspaceLogBase.resetPSWorkspaceId();
        pSWorkspaceLogBase.resetPSWorkspaceLogId();
        pSWorkspaceLogBase.resetPSWorkspaceLogName();
        pSWorkspaceLogBase.resetPSWorkspaceName();
        pSWorkspaceLogBase.resetUpdateDate();
        pSWorkspaceLogBase.resetUpdateMan();
        pSWorkspaceLogBase.resetUserTag();
        pSWorkspaceLogBase.resetUserTag2();
        pSWorkspaceLogBase.resetUserTag3();
        pSWorkspaceLogBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
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
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isPSWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEID, this.getPSWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceLogIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACELOGID, this.getPSWorkspaceLogId());
        }
        if (!bl || this.isPSWorkspaceLogNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACELOGNAME, this.getPSWorkspaceLogName());
        }
        if (!bl || this.isPSWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACENAME, this.getPSWorkspaceName());
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
        return PSWorkspaceLogBase.get(this, n);
    }

    private static Object get(PSWorkspaceLogBase pSWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceLogBase.getCreateDate();
            }
            case 1: {
                return pSWorkspaceLogBase.getCreateMan();
            }
            case 2: {
                return pSWorkspaceLogBase.getLogInfo();
            }
            case 3: {
                return pSWorkspaceLogBase.getLogLevel();
            }
            case 4: {
                return pSWorkspaceLogBase.getLogLevel2();
            }
            case 5: {
                return pSWorkspaceLogBase.getLogType();
            }
            case 6: {
                return pSWorkspaceLogBase.getPSSvrDomainId();
            }
            case 7: {
                return pSWorkspaceLogBase.getPSSvrDomainName();
            }
            case 8: {
                return pSWorkspaceLogBase.getPSTaskServerId();
            }
            case 9: {
                return pSWorkspaceLogBase.getPSTaskServerName();
            }
            case 10: {
                return pSWorkspaceLogBase.getPSWorkspaceId();
            }
            case 11: {
                return pSWorkspaceLogBase.getPSWorkspaceLogId();
            }
            case 12: {
                return pSWorkspaceLogBase.getPSWorkspaceLogName();
            }
            case 13: {
                return pSWorkspaceLogBase.getPSWorkspaceName();
            }
            case 14: {
                return pSWorkspaceLogBase.getUpdateDate();
            }
            case 15: {
                return pSWorkspaceLogBase.getUpdateMan();
            }
            case 16: {
                return pSWorkspaceLogBase.getUserTag();
            }
            case 17: {
                return pSWorkspaceLogBase.getUserTag2();
            }
            case 18: {
                return pSWorkspaceLogBase.getUserTag3();
            }
            case 19: {
                return pSWorkspaceLogBase.getUserTag4();
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
        PSWorkspaceLogBase.set(this, n, object);
    }

    private static void set(PSWorkspaceLogBase pSWorkspaceLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWorkspaceLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWorkspaceLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkspaceLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWorkspaceLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWorkspaceLogBase.setLogType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWorkspaceLogBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWorkspaceLogBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWorkspaceLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWorkspaceLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWorkspaceLogBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWorkspaceLogBase.setPSWorkspaceLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWorkspaceLogBase.setPSWorkspaceLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWorkspaceLogBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWorkspaceLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSWorkspaceLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWorkspaceLogBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWorkspaceLogBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWorkspaceLogBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWorkspaceLogBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWorkspaceLogBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkspaceLogBase pSWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSWorkspaceLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSWorkspaceLogBase.getLogInfo() == null;
            }
            case 3: {
                return pSWorkspaceLogBase.getLogLevel() == null;
            }
            case 4: {
                return pSWorkspaceLogBase.getLogLevel2() == null;
            }
            case 5: {
                return pSWorkspaceLogBase.getLogType() == null;
            }
            case 6: {
                return pSWorkspaceLogBase.getPSSvrDomainId() == null;
            }
            case 7: {
                return pSWorkspaceLogBase.getPSSvrDomainName() == null;
            }
            case 8: {
                return pSWorkspaceLogBase.getPSTaskServerId() == null;
            }
            case 9: {
                return pSWorkspaceLogBase.getPSTaskServerName() == null;
            }
            case 10: {
                return pSWorkspaceLogBase.getPSWorkspaceId() == null;
            }
            case 11: {
                return pSWorkspaceLogBase.getPSWorkspaceLogId() == null;
            }
            case 12: {
                return pSWorkspaceLogBase.getPSWorkspaceLogName() == null;
            }
            case 13: {
                return pSWorkspaceLogBase.getPSWorkspaceName() == null;
            }
            case 14: {
                return pSWorkspaceLogBase.getUpdateDate() == null;
            }
            case 15: {
                return pSWorkspaceLogBase.getUpdateMan() == null;
            }
            case 16: {
                return pSWorkspaceLogBase.getUserTag() == null;
            }
            case 17: {
                return pSWorkspaceLogBase.getUserTag2() == null;
            }
            case 18: {
                return pSWorkspaceLogBase.getUserTag3() == null;
            }
            case 19: {
                return pSWorkspaceLogBase.getUserTag4() == null;
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
        return PSWorkspaceLogBase.contains(this, n);
    }

    private static boolean contains(PSWorkspaceLogBase pSWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSWorkspaceLogBase.isCreateManDirty();
            }
            case 2: {
                return pSWorkspaceLogBase.isLogInfoDirty();
            }
            case 3: {
                return pSWorkspaceLogBase.isLogLevelDirty();
            }
            case 4: {
                return pSWorkspaceLogBase.isLogLevel2Dirty();
            }
            case 5: {
                return pSWorkspaceLogBase.isLogTypeDirty();
            }
            case 6: {
                return pSWorkspaceLogBase.isPSSvrDomainIdDirty();
            }
            case 7: {
                return pSWorkspaceLogBase.isPSSvrDomainNameDirty();
            }
            case 8: {
                return pSWorkspaceLogBase.isPSTaskServerIdDirty();
            }
            case 9: {
                return pSWorkspaceLogBase.isPSTaskServerNameDirty();
            }
            case 10: {
                return pSWorkspaceLogBase.isPSWorkspaceIdDirty();
            }
            case 11: {
                return pSWorkspaceLogBase.isPSWorkspaceLogIdDirty();
            }
            case 12: {
                return pSWorkspaceLogBase.isPSWorkspaceLogNameDirty();
            }
            case 13: {
                return pSWorkspaceLogBase.isPSWorkspaceNameDirty();
            }
            case 14: {
                return pSWorkspaceLogBase.isUpdateDateDirty();
            }
            case 15: {
                return pSWorkspaceLogBase.isUpdateManDirty();
            }
            case 16: {
                return pSWorkspaceLogBase.isUserTagDirty();
            }
            case 17: {
                return pSWorkspaceLogBase.isUserTag2Dirty();
            }
            case 18: {
                return pSWorkspaceLogBase.isUserTag3Dirty();
            }
            case 19: {
                return pSWorkspaceLogBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkspaceLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkspaceLogBase pSWorkspaceLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkspaceLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getLogType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtype", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getLogType()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacelogid", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSWorkspaceLogId()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacelogname", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSWorkspaceLogName()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWorkspaceLogBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWorkspaceLogBase.getJSONValue((Object)pSWorkspaceLogBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkspaceLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkspaceLogBase pSWorkspaceLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkspaceLogBase.getCreateDate() != null) {
            object = pSWorkspaceLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceLogBase.getCreateMan() != null) {
            object = pSWorkspaceLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getLogInfo() != null) {
            object = pSWorkspaceLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getLogLevel() != null) {
            object = pSWorkspaceLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getLogLevel2() != null) {
            object = pSWorkspaceLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceLogBase.getLogType() != null) {
            object = pSWorkspaceLogBase.getLogType();
            xmlNode.setAttribute(FIELD_LOGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSSvrDomainId() != null) {
            object = pSWorkspaceLogBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSSvrDomainName() != null) {
            object = pSWorkspaceLogBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSTaskServerId() != null) {
            object = pSWorkspaceLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSTaskServerName() != null) {
            object = pSWorkspaceLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceId() != null) {
            object = pSWorkspaceLogBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceLogId() != null) {
            object = pSWorkspaceLogBase.getPSWorkspaceLogId();
            xmlNode.setAttribute(FIELD_PSWORKSPACELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceLogName() != null) {
            object = pSWorkspaceLogBase.getPSWorkspaceLogName();
            xmlNode.setAttribute(FIELD_PSWORKSPACELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getPSWorkspaceName() != null) {
            object = pSWorkspaceLogBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getUpdateDate() != null) {
            object = pSWorkspaceLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceLogBase.getUpdateMan() != null) {
            object = pSWorkspaceLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getUserTag() != null) {
            object = pSWorkspaceLogBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getUserTag2() != null) {
            object = pSWorkspaceLogBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getUserTag3() != null) {
            object = pSWorkspaceLogBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceLogBase.getUserTag4() != null) {
            object = pSWorkspaceLogBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkspaceLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkspaceLogBase pSWorkspaceLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkspaceLogBase.isCreateDateDirty() && (bl || pSWorkspaceLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkspaceLogBase.getCreateDate());
        }
        if (pSWorkspaceLogBase.isCreateManDirty() && (bl || pSWorkspaceLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkspaceLogBase.getCreateMan());
        }
        if (pSWorkspaceLogBase.isLogInfoDirty() && (bl || pSWorkspaceLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSWorkspaceLogBase.getLogInfo());
        }
        if (pSWorkspaceLogBase.isLogLevelDirty() && (bl || pSWorkspaceLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSWorkspaceLogBase.getLogLevel());
        }
        if (pSWorkspaceLogBase.isLogLevel2Dirty() && (bl || pSWorkspaceLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSWorkspaceLogBase.getLogLevel2());
        }
        if (pSWorkspaceLogBase.isLogTypeDirty() && (bl || pSWorkspaceLogBase.getLogType() != null)) {
            iDataObject.set(FIELD_LOGTYPE, (Object)pSWorkspaceLogBase.getLogType());
        }
        if (pSWorkspaceLogBase.isPSSvrDomainIdDirty() && (bl || pSWorkspaceLogBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSWorkspaceLogBase.getPSSvrDomainId());
        }
        if (pSWorkspaceLogBase.isPSSvrDomainNameDirty() && (bl || pSWorkspaceLogBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSWorkspaceLogBase.getPSSvrDomainName());
        }
        if (pSWorkspaceLogBase.isPSTaskServerIdDirty() && (bl || pSWorkspaceLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSWorkspaceLogBase.getPSTaskServerId());
        }
        if (pSWorkspaceLogBase.isPSTaskServerNameDirty() && (bl || pSWorkspaceLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSWorkspaceLogBase.getPSTaskServerName());
        }
        if (pSWorkspaceLogBase.isPSWorkspaceIdDirty() && (bl || pSWorkspaceLogBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWorkspaceLogBase.getPSWorkspaceId());
        }
        if (pSWorkspaceLogBase.isPSWorkspaceLogIdDirty() && (bl || pSWorkspaceLogBase.getPSWorkspaceLogId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACELOGID, (Object)pSWorkspaceLogBase.getPSWorkspaceLogId());
        }
        if (pSWorkspaceLogBase.isPSWorkspaceLogNameDirty() && (bl || pSWorkspaceLogBase.getPSWorkspaceLogName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACELOGNAME, (Object)pSWorkspaceLogBase.getPSWorkspaceLogName());
        }
        if (pSWorkspaceLogBase.isPSWorkspaceNameDirty() && (bl || pSWorkspaceLogBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWorkspaceLogBase.getPSWorkspaceName());
        }
        if (pSWorkspaceLogBase.isUpdateDateDirty() && (bl || pSWorkspaceLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkspaceLogBase.getUpdateDate());
        }
        if (pSWorkspaceLogBase.isUpdateManDirty() && (bl || pSWorkspaceLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkspaceLogBase.getUpdateMan());
        }
        if (pSWorkspaceLogBase.isUserTagDirty() && (bl || pSWorkspaceLogBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWorkspaceLogBase.getUserTag());
        }
        if (pSWorkspaceLogBase.isUserTag2Dirty() && (bl || pSWorkspaceLogBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWorkspaceLogBase.getUserTag2());
        }
        if (pSWorkspaceLogBase.isUserTag3Dirty() && (bl || pSWorkspaceLogBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWorkspaceLogBase.getUserTag3());
        }
        if (pSWorkspaceLogBase.isUserTag4Dirty() && (bl || pSWorkspaceLogBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWorkspaceLogBase.getUserTag4());
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
        return PSWorkspaceLogBase.remove(this, n);
    }

    private static boolean remove(PSWorkspaceLogBase pSWorkspaceLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWorkspaceLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWorkspaceLogBase.resetLogInfo();
                return true;
            }
            case 3: {
                pSWorkspaceLogBase.resetLogLevel();
                return true;
            }
            case 4: {
                pSWorkspaceLogBase.resetLogLevel2();
                return true;
            }
            case 5: {
                pSWorkspaceLogBase.resetLogType();
                return true;
            }
            case 6: {
                pSWorkspaceLogBase.resetPSSvrDomainId();
                return true;
            }
            case 7: {
                pSWorkspaceLogBase.resetPSSvrDomainName();
                return true;
            }
            case 8: {
                pSWorkspaceLogBase.resetPSTaskServerId();
                return true;
            }
            case 9: {
                pSWorkspaceLogBase.resetPSTaskServerName();
                return true;
            }
            case 10: {
                pSWorkspaceLogBase.resetPSWorkspaceId();
                return true;
            }
            case 11: {
                pSWorkspaceLogBase.resetPSWorkspaceLogId();
                return true;
            }
            case 12: {
                pSWorkspaceLogBase.resetPSWorkspaceLogName();
                return true;
            }
            case 13: {
                pSWorkspaceLogBase.resetPSWorkspaceName();
                return true;
            }
            case 14: {
                pSWorkspaceLogBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSWorkspaceLogBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSWorkspaceLogBase.resetUserTag();
                return true;
            }
            case 17: {
                pSWorkspaceLogBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSWorkspaceLogBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSWorkspaceLogBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSWorkspaceLogBase getProxyEntity() {
        return this.proxyPSWorkspaceLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkspaceLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkspaceLogBase) {
            this.proxyPSWorkspaceLogBase = (PSWorkspaceLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGINFO, 2);
        fieldIndexMap.put(FIELD_LOGLEVEL, 3);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 4);
        fieldIndexMap.put(FIELD_LOGTYPE, 5);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 6);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 7);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 8);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 9);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 10);
        fieldIndexMap.put(FIELD_PSWORKSPACELOGID, 11);
        fieldIndexMap.put(FIELD_PSWORKSPACELOGNAME, 12);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

