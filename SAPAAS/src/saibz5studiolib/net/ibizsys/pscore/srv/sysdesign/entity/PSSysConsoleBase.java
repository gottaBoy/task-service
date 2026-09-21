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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysConsoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysConsoleBase.class);
    public static final String FIELD_CONSOLETAG = "CONSOLETAG";
    public static final String FIELD_CONSOLETAG2 = "CONSOLETAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FIXDATAKEY = "FIXDATAKEY";
    public static final String FIELD_FIXDEACTION = "FIXDEACTION";
    public static final String FIELD_FIXDENAME = "FIXDENAME";
    public static final String FIELD_FIXSTATE = "FIXSTATE";
    public static final String FIELD_LINKINFO = "LINKINFO";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCONSOLEID = "PSSYSCONSOLEID";
    public static final String FIELD_PSSYSCONSOLENAME = "PSSYSCONSOLENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONSOLETAG = 0;
    private static final int INDEX_CONSOLETAG2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_FIXDATAKEY = 4;
    private static final int INDEX_FIXDEACTION = 5;
    private static final int INDEX_FIXDENAME = 6;
    private static final int INDEX_FIXSTATE = 7;
    private static final int INDEX_LINKINFO = 8;
    private static final int INDEX_LOGINFO = 9;
    private static final int INDEX_LOGLEVEL = 10;
    private static final int INDEX_LOGLEVEL2 = 11;
    private static final int INDEX_LOGTIME = 12;
    private static final int INDEX_PSDYNAINSTID = 13;
    private static final int INDEX_PSSYSAPPID = 14;
    private static final int INDEX_PSSYSAPPNAME = 15;
    private static final int INDEX_PSSYSCONSOLEID = 16;
    private static final int INDEX_PSSYSCONSOLENAME = 17;
    private static final int INDEX_PSSYSTEMID = 18;
    private static final int INDEX_PSSYSTEMNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysConsoleBase proxyPSSysConsoleBase = null;
    private boolean consoletagDirtyFlag = false;
    private boolean consoletag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fixdatakeyDirtyFlag = false;
    private boolean fixdeactionDirtyFlag = false;
    private boolean fixdenameDirtyFlag = false;
    private boolean fixstateDirtyFlag = false;
    private boolean linkinfoDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysconsoleidDirtyFlag = false;
    private boolean pssysconsolenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="consoletag")
    private String consoletag;
    @Column(name="consoletag2")
    private String consoletag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fixdatakey")
    private String fixdatakey;
    @Column(name="fixdeaction")
    private String fixdeaction;
    @Column(name="fixdename")
    private String fixdename;
    @Column(name="fixstate")
    private Integer fixstate;
    @Column(name="linkinfo")
    private String linkinfo;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtime")
    private Timestamp logtime;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysconsoleid")
    private String pssysconsoleid;
    @Column(name="pssysconsolename")
    private String pssysconsolename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setConsoleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConsoleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.consoletag = string;
        this.consoletagDirtyFlag = true;
    }

    public String getConsoleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConsoleTag();
        }
        return this.consoletag;
    }

    public boolean isConsoleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConsoleTagDirty();
        }
        return this.consoletagDirtyFlag;
    }

    public void resetConsoleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConsoleTag();
            return;
        }
        this.consoletagDirtyFlag = false;
        this.consoletag = null;
    }

    public void setConsoleTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConsoleTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.consoletag2 = string;
        this.consoletag2DirtyFlag = true;
    }

    public String getConsoleTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConsoleTag2();
        }
        return this.consoletag2;
    }

    public boolean isConsoleTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConsoleTag2Dirty();
        }
        return this.consoletag2DirtyFlag;
    }

    public void resetConsoleTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConsoleTag2();
            return;
        }
        this.consoletag2DirtyFlag = false;
        this.consoletag2 = null;
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

    public void setFixDataKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixDataKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fixdatakey = string;
        this.fixdatakeyDirtyFlag = true;
    }

    public String getFixDataKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixDataKey();
        }
        return this.fixdatakey;
    }

    public boolean isFixDataKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixDataKeyDirty();
        }
        return this.fixdatakeyDirtyFlag;
    }

    public void resetFixDataKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixDataKey();
            return;
        }
        this.fixdatakeyDirtyFlag = false;
        this.fixdatakey = null;
    }

    public void setFixDEAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixDEAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fixdeaction = string;
        this.fixdeactionDirtyFlag = true;
    }

    public String getFixDEAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixDEAction();
        }
        return this.fixdeaction;
    }

    public boolean isFixDEActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixDEActionDirty();
        }
        return this.fixdeactionDirtyFlag;
    }

    public void resetFixDEAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixDEAction();
            return;
        }
        this.fixdeactionDirtyFlag = false;
        this.fixdeaction = null;
    }

    public void setFixDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fixdename = string;
        this.fixdenameDirtyFlag = true;
    }

    public String getFixDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixDEName();
        }
        return this.fixdename;
    }

    public boolean isFixDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixDENameDirty();
        }
        return this.fixdenameDirtyFlag;
    }

    public void resetFixDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixDEName();
            return;
        }
        this.fixdenameDirtyFlag = false;
        this.fixdename = null;
    }

    public void setFixState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixState(n);
            return;
        }
        this.fixstate = n;
        this.fixstateDirtyFlag = true;
    }

    public Integer getFixState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixState();
        }
        return this.fixstate;
    }

    public boolean isFixStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixStateDirty();
        }
        return this.fixstateDirtyFlag;
    }

    public void resetFixState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixState();
            return;
        }
        this.fixstateDirtyFlag = false;
        this.fixstate = null;
    }

    public void setLinkInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkinfo = string;
        this.linkinfoDirtyFlag = true;
    }

    public String getLinkInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkInfo();
        }
        return this.linkinfo;
    }

    public boolean isLinkInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkInfoDirty();
        }
        return this.linkinfoDirtyFlag;
    }

    public void resetLinkInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkInfo();
            return;
        }
        this.linkinfoDirtyFlag = false;
        this.linkinfo = null;
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

    public void setLogTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogTime(timestamp);
            return;
        }
        this.logtime = timestamp;
        this.logtimeDirtyFlag = true;
    }

    public Timestamp getLogTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogTime();
        }
        return this.logtime;
    }

    public boolean isLogTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogTimeDirty();
        }
        return this.logtimeDirtyFlag;
    }

    public void resetLogTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogTime();
            return;
        }
        this.logtimeDirtyFlag = false;
        this.logtime = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setPSSysConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysconsoleid = string;
        this.pssysconsoleidDirtyFlag = true;
    }

    public String getPSSysConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysConsoleId();
        }
        return this.pssysconsoleid;
    }

    public boolean isPSSysConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysConsoleIdDirty();
        }
        return this.pssysconsoleidDirtyFlag;
    }

    public void resetPSSysConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysConsoleId();
            return;
        }
        this.pssysconsoleidDirtyFlag = false;
        this.pssysconsoleid = null;
    }

    public void setPSSysConsoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysConsoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysconsolename = string;
        this.pssysconsolenameDirtyFlag = true;
    }

    public String getPSSysConsoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysConsoleName();
        }
        return this.pssysconsolename;
    }

    public boolean isPSSysConsoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysConsoleNameDirty();
        }
        return this.pssysconsolenameDirtyFlag;
    }

    public void resetPSSysConsoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysConsoleName();
            return;
        }
        this.pssysconsolenameDirtyFlag = false;
        this.pssysconsolename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSSysConsoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysConsoleBase pSSysConsoleBase) {
        pSSysConsoleBase.resetConsoleTag();
        pSSysConsoleBase.resetConsoleTag2();
        pSSysConsoleBase.resetCreateDate();
        pSSysConsoleBase.resetCreateMan();
        pSSysConsoleBase.resetFixDataKey();
        pSSysConsoleBase.resetFixDEAction();
        pSSysConsoleBase.resetFixDEName();
        pSSysConsoleBase.resetFixState();
        pSSysConsoleBase.resetLinkInfo();
        pSSysConsoleBase.resetLogInfo();
        pSSysConsoleBase.resetLogLevel();
        pSSysConsoleBase.resetLogLevel2();
        pSSysConsoleBase.resetLogTime();
        pSSysConsoleBase.resetPSDynaInstId();
        pSSysConsoleBase.resetPSSysAppId();
        pSSysConsoleBase.resetPSSysAppName();
        pSSysConsoleBase.resetPSSysConsoleId();
        pSSysConsoleBase.resetPSSysConsoleName();
        pSSysConsoleBase.resetPSSystemId();
        pSSysConsoleBase.resetPSSystemName();
        pSSysConsoleBase.resetUpdateDate();
        pSSysConsoleBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConsoleTagDirty()) {
            hashMap.put(FIELD_CONSOLETAG, this.getConsoleTag());
        }
        if (!bl || this.isConsoleTag2Dirty()) {
            hashMap.put(FIELD_CONSOLETAG2, this.getConsoleTag2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFixDataKeyDirty()) {
            hashMap.put(FIELD_FIXDATAKEY, this.getFixDataKey());
        }
        if (!bl || this.isFixDEActionDirty()) {
            hashMap.put(FIELD_FIXDEACTION, this.getFixDEAction());
        }
        if (!bl || this.isFixDENameDirty()) {
            hashMap.put(FIELD_FIXDENAME, this.getFixDEName());
        }
        if (!bl || this.isFixStateDirty()) {
            hashMap.put(FIELD_FIXSTATE, this.getFixState());
        }
        if (!bl || this.isLinkInfoDirty()) {
            hashMap.put(FIELD_LINKINFO, this.getLinkInfo());
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
        if (!bl || this.isLogTimeDirty()) {
            hashMap.put(FIELD_LOGTIME, this.getLogTime());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysConsoleIdDirty()) {
            hashMap.put(FIELD_PSSYSCONSOLEID, this.getPSSysConsoleId());
        }
        if (!bl || this.isPSSysConsoleNameDirty()) {
            hashMap.put(FIELD_PSSYSCONSOLENAME, this.getPSSysConsoleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysConsoleBase.get(this, n);
    }

    private static Object get(PSSysConsoleBase pSSysConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysConsoleBase.getConsoleTag();
            }
            case 1: {
                return pSSysConsoleBase.getConsoleTag2();
            }
            case 2: {
                return pSSysConsoleBase.getCreateDate();
            }
            case 3: {
                return pSSysConsoleBase.getCreateMan();
            }
            case 4: {
                return pSSysConsoleBase.getFixDataKey();
            }
            case 5: {
                return pSSysConsoleBase.getFixDEAction();
            }
            case 6: {
                return pSSysConsoleBase.getFixDEName();
            }
            case 7: {
                return pSSysConsoleBase.getFixState();
            }
            case 8: {
                return pSSysConsoleBase.getLinkInfo();
            }
            case 9: {
                return pSSysConsoleBase.getLogInfo();
            }
            case 10: {
                return pSSysConsoleBase.getLogLevel();
            }
            case 11: {
                return pSSysConsoleBase.getLogLevel2();
            }
            case 12: {
                return pSSysConsoleBase.getLogTime();
            }
            case 13: {
                return pSSysConsoleBase.getPSDynaInstId();
            }
            case 14: {
                return pSSysConsoleBase.getPSSysAppId();
            }
            case 15: {
                return pSSysConsoleBase.getPSSysAppName();
            }
            case 16: {
                return pSSysConsoleBase.getPSSysConsoleId();
            }
            case 17: {
                return pSSysConsoleBase.getPSSysConsoleName();
            }
            case 18: {
                return pSSysConsoleBase.getPSSystemId();
            }
            case 19: {
                return pSSysConsoleBase.getPSSystemName();
            }
            case 20: {
                return pSSysConsoleBase.getUpdateDate();
            }
            case 21: {
                return pSSysConsoleBase.getUpdateMan();
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
        PSSysConsoleBase.set(this, n, object);
    }

    private static void set(PSSysConsoleBase pSSysConsoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysConsoleBase.setConsoleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysConsoleBase.setConsoleTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysConsoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysConsoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysConsoleBase.setFixDataKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysConsoleBase.setFixDEAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysConsoleBase.setFixDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysConsoleBase.setFixState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysConsoleBase.setLinkInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysConsoleBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysConsoleBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysConsoleBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysConsoleBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysConsoleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysConsoleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysConsoleBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysConsoleBase.setPSSysConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysConsoleBase.setPSSysConsoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysConsoleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysConsoleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysConsoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysConsoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysConsoleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysConsoleBase pSSysConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysConsoleBase.getConsoleTag() == null;
            }
            case 1: {
                return pSSysConsoleBase.getConsoleTag2() == null;
            }
            case 2: {
                return pSSysConsoleBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysConsoleBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysConsoleBase.getFixDataKey() == null;
            }
            case 5: {
                return pSSysConsoleBase.getFixDEAction() == null;
            }
            case 6: {
                return pSSysConsoleBase.getFixDEName() == null;
            }
            case 7: {
                return pSSysConsoleBase.getFixState() == null;
            }
            case 8: {
                return pSSysConsoleBase.getLinkInfo() == null;
            }
            case 9: {
                return pSSysConsoleBase.getLogInfo() == null;
            }
            case 10: {
                return pSSysConsoleBase.getLogLevel() == null;
            }
            case 11: {
                return pSSysConsoleBase.getLogLevel2() == null;
            }
            case 12: {
                return pSSysConsoleBase.getLogTime() == null;
            }
            case 13: {
                return pSSysConsoleBase.getPSDynaInstId() == null;
            }
            case 14: {
                return pSSysConsoleBase.getPSSysAppId() == null;
            }
            case 15: {
                return pSSysConsoleBase.getPSSysAppName() == null;
            }
            case 16: {
                return pSSysConsoleBase.getPSSysConsoleId() == null;
            }
            case 17: {
                return pSSysConsoleBase.getPSSysConsoleName() == null;
            }
            case 18: {
                return pSSysConsoleBase.getPSSystemId() == null;
            }
            case 19: {
                return pSSysConsoleBase.getPSSystemName() == null;
            }
            case 20: {
                return pSSysConsoleBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysConsoleBase.getUpdateMan() == null;
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
        return PSSysConsoleBase.contains(this, n);
    }

    private static boolean contains(PSSysConsoleBase pSSysConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysConsoleBase.isConsoleTagDirty();
            }
            case 1: {
                return pSSysConsoleBase.isConsoleTag2Dirty();
            }
            case 2: {
                return pSSysConsoleBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysConsoleBase.isCreateManDirty();
            }
            case 4: {
                return pSSysConsoleBase.isFixDataKeyDirty();
            }
            case 5: {
                return pSSysConsoleBase.isFixDEActionDirty();
            }
            case 6: {
                return pSSysConsoleBase.isFixDENameDirty();
            }
            case 7: {
                return pSSysConsoleBase.isFixStateDirty();
            }
            case 8: {
                return pSSysConsoleBase.isLinkInfoDirty();
            }
            case 9: {
                return pSSysConsoleBase.isLogInfoDirty();
            }
            case 10: {
                return pSSysConsoleBase.isLogLevelDirty();
            }
            case 11: {
                return pSSysConsoleBase.isLogLevel2Dirty();
            }
            case 12: {
                return pSSysConsoleBase.isLogTimeDirty();
            }
            case 13: {
                return pSSysConsoleBase.isPSDynaInstIdDirty();
            }
            case 14: {
                return pSSysConsoleBase.isPSSysAppIdDirty();
            }
            case 15: {
                return pSSysConsoleBase.isPSSysAppNameDirty();
            }
            case 16: {
                return pSSysConsoleBase.isPSSysConsoleIdDirty();
            }
            case 17: {
                return pSSysConsoleBase.isPSSysConsoleNameDirty();
            }
            case 18: {
                return pSSysConsoleBase.isPSSystemIdDirty();
            }
            case 19: {
                return pSSysConsoleBase.isPSSystemNameDirty();
            }
            case 20: {
                return pSSysConsoleBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysConsoleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysConsoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysConsoleBase pSSysConsoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysConsoleBase.getConsoleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"consoletag", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getConsoleTag()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getConsoleTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"consoletag2", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getConsoleTag2()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getFixDataKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixdatakey", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getFixDataKey()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getFixDEAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixdeaction", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getFixDEAction()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getFixDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixdename", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getFixDEName()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getFixState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixstate", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getFixState()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getLinkInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getLinkInfo()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getLogTime()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSysConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysconsoleid", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSysConsoleId()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSysConsoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysconsolename", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSysConsoleName()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysConsoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysConsoleBase.getJSONValue((Object)pSSysConsoleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysConsoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysConsoleBase pSSysConsoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysConsoleBase.getConsoleTag() != null) {
            object = pSSysConsoleBase.getConsoleTag();
            xmlNode.setAttribute(FIELD_CONSOLETAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysConsoleBase.getConsoleTag2() != null) {
            object = pSSysConsoleBase.getConsoleTag2();
            xmlNode.setAttribute(FIELD_CONSOLETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getCreateDate() != null) {
            object = pSSysConsoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysConsoleBase.getCreateMan() != null) {
            object = pSSysConsoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getFixDataKey() != null) {
            object = pSSysConsoleBase.getFixDataKey();
            xmlNode.setAttribute(FIELD_FIXDATAKEY, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getFixDEAction() != null) {
            object = pSSysConsoleBase.getFixDEAction();
            xmlNode.setAttribute(FIELD_FIXDEACTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getFixDEName() != null) {
            object = pSSysConsoleBase.getFixDEName();
            xmlNode.setAttribute(FIELD_FIXDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getFixState() != null) {
            object = pSSysConsoleBase.getFixState();
            xmlNode.setAttribute(FIELD_FIXSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysConsoleBase.getLinkInfo() != null) {
            object = pSSysConsoleBase.getLinkInfo();
            xmlNode.setAttribute(FIELD_LINKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getLogInfo() != null) {
            object = pSSysConsoleBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getLogLevel() != null) {
            object = pSSysConsoleBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getLogLevel2() != null) {
            object = pSSysConsoleBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysConsoleBase.getLogTime() != null) {
            object = pSSysConsoleBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysConsoleBase.getPSDynaInstId() != null) {
            object = pSSysConsoleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSysAppId() != null) {
            object = pSSysConsoleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSysAppName() != null) {
            object = pSSysConsoleBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSysConsoleId() != null) {
            object = pSSysConsoleBase.getPSSysConsoleId();
            xmlNode.setAttribute(FIELD_PSSYSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSysConsoleName() != null) {
            object = pSSysConsoleBase.getPSSysConsoleName();
            xmlNode.setAttribute(FIELD_PSSYSCONSOLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSystemId() != null) {
            object = pSSysConsoleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getPSSystemName() != null) {
            object = pSSysConsoleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysConsoleBase.getUpdateDate() != null) {
            object = pSSysConsoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysConsoleBase.getUpdateMan() != null) {
            object = pSSysConsoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysConsoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysConsoleBase pSSysConsoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysConsoleBase.isConsoleTagDirty() && (bl || pSSysConsoleBase.getConsoleTag() != null)) {
            iDataObject.set(FIELD_CONSOLETAG, (Object)pSSysConsoleBase.getConsoleTag());
        }
        if (pSSysConsoleBase.isConsoleTag2Dirty() && (bl || pSSysConsoleBase.getConsoleTag2() != null)) {
            iDataObject.set(FIELD_CONSOLETAG2, (Object)pSSysConsoleBase.getConsoleTag2());
        }
        if (pSSysConsoleBase.isCreateDateDirty() && (bl || pSSysConsoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysConsoleBase.getCreateDate());
        }
        if (pSSysConsoleBase.isCreateManDirty() && (bl || pSSysConsoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysConsoleBase.getCreateMan());
        }
        if (pSSysConsoleBase.isFixDataKeyDirty() && (bl || pSSysConsoleBase.getFixDataKey() != null)) {
            iDataObject.set(FIELD_FIXDATAKEY, (Object)pSSysConsoleBase.getFixDataKey());
        }
        if (pSSysConsoleBase.isFixDEActionDirty() && (bl || pSSysConsoleBase.getFixDEAction() != null)) {
            iDataObject.set(FIELD_FIXDEACTION, (Object)pSSysConsoleBase.getFixDEAction());
        }
        if (pSSysConsoleBase.isFixDENameDirty() && (bl || pSSysConsoleBase.getFixDEName() != null)) {
            iDataObject.set(FIELD_FIXDENAME, (Object)pSSysConsoleBase.getFixDEName());
        }
        if (pSSysConsoleBase.isFixStateDirty() && (bl || pSSysConsoleBase.getFixState() != null)) {
            iDataObject.set(FIELD_FIXSTATE, (Object)pSSysConsoleBase.getFixState());
        }
        if (pSSysConsoleBase.isLinkInfoDirty() && (bl || pSSysConsoleBase.getLinkInfo() != null)) {
            iDataObject.set(FIELD_LINKINFO, (Object)pSSysConsoleBase.getLinkInfo());
        }
        if (pSSysConsoleBase.isLogInfoDirty() && (bl || pSSysConsoleBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSSysConsoleBase.getLogInfo());
        }
        if (pSSysConsoleBase.isLogLevelDirty() && (bl || pSSysConsoleBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSSysConsoleBase.getLogLevel());
        }
        if (pSSysConsoleBase.isLogLevel2Dirty() && (bl || pSSysConsoleBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSSysConsoleBase.getLogLevel2());
        }
        if (pSSysConsoleBase.isLogTimeDirty() && (bl || pSSysConsoleBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSSysConsoleBase.getLogTime());
        }
        if (pSSysConsoleBase.isPSDynaInstIdDirty() && (bl || pSSysConsoleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysConsoleBase.getPSDynaInstId());
        }
        if (pSSysConsoleBase.isPSSysAppIdDirty() && (bl || pSSysConsoleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysConsoleBase.getPSSysAppId());
        }
        if (pSSysConsoleBase.isPSSysAppNameDirty() && (bl || pSSysConsoleBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysConsoleBase.getPSSysAppName());
        }
        if (pSSysConsoleBase.isPSSysConsoleIdDirty() && (bl || pSSysConsoleBase.getPSSysConsoleId() != null)) {
            iDataObject.set(FIELD_PSSYSCONSOLEID, (Object)pSSysConsoleBase.getPSSysConsoleId());
        }
        if (pSSysConsoleBase.isPSSysConsoleNameDirty() && (bl || pSSysConsoleBase.getPSSysConsoleName() != null)) {
            iDataObject.set(FIELD_PSSYSCONSOLENAME, (Object)pSSysConsoleBase.getPSSysConsoleName());
        }
        if (pSSysConsoleBase.isPSSystemIdDirty() && (bl || pSSysConsoleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysConsoleBase.getPSSystemId());
        }
        if (pSSysConsoleBase.isPSSystemNameDirty() && (bl || pSSysConsoleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysConsoleBase.getPSSystemName());
        }
        if (pSSysConsoleBase.isUpdateDateDirty() && (bl || pSSysConsoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysConsoleBase.getUpdateDate());
        }
        if (pSSysConsoleBase.isUpdateManDirty() && (bl || pSSysConsoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysConsoleBase.getUpdateMan());
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
        return PSSysConsoleBase.remove(this, n);
    }

    private static boolean remove(PSSysConsoleBase pSSysConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysConsoleBase.resetConsoleTag();
                return true;
            }
            case 1: {
                pSSysConsoleBase.resetConsoleTag2();
                return true;
            }
            case 2: {
                pSSysConsoleBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysConsoleBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysConsoleBase.resetFixDataKey();
                return true;
            }
            case 5: {
                pSSysConsoleBase.resetFixDEAction();
                return true;
            }
            case 6: {
                pSSysConsoleBase.resetFixDEName();
                return true;
            }
            case 7: {
                pSSysConsoleBase.resetFixState();
                return true;
            }
            case 8: {
                pSSysConsoleBase.resetLinkInfo();
                return true;
            }
            case 9: {
                pSSysConsoleBase.resetLogInfo();
                return true;
            }
            case 10: {
                pSSysConsoleBase.resetLogLevel();
                return true;
            }
            case 11: {
                pSSysConsoleBase.resetLogLevel2();
                return true;
            }
            case 12: {
                pSSysConsoleBase.resetLogTime();
                return true;
            }
            case 13: {
                pSSysConsoleBase.resetPSDynaInstId();
                return true;
            }
            case 14: {
                pSSysConsoleBase.resetPSSysAppId();
                return true;
            }
            case 15: {
                pSSysConsoleBase.resetPSSysAppName();
                return true;
            }
            case 16: {
                pSSysConsoleBase.resetPSSysConsoleId();
                return true;
            }
            case 17: {
                pSSysConsoleBase.resetPSSysConsoleName();
                return true;
            }
            case 18: {
                pSSysConsoleBase.resetPSSystemId();
                return true;
            }
            case 19: {
                pSSysConsoleBase.resetPSSystemName();
                return true;
            }
            case 20: {
                pSSysConsoleBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysConsoleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysConsoleBase getProxyEntity() {
        return this.proxyPSSysConsoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysConsoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysConsoleBase) {
            this.proxyPSSysConsoleBase = (PSSysConsoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONSOLETAG, 0);
        fieldIndexMap.put(FIELD_CONSOLETAG2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_FIXDATAKEY, 4);
        fieldIndexMap.put(FIELD_FIXDEACTION, 5);
        fieldIndexMap.put(FIELD_FIXDENAME, 6);
        fieldIndexMap.put(FIELD_FIXSTATE, 7);
        fieldIndexMap.put(FIELD_LINKINFO, 8);
        fieldIndexMap.put(FIELD_LOGINFO, 9);
        fieldIndexMap.put(FIELD_LOGLEVEL, 10);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 11);
        fieldIndexMap.put(FIELD_LOGTIME, 12);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSCONSOLEID, 16);
        fieldIndexMap.put(FIELD_PSSYSCONSOLENAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

