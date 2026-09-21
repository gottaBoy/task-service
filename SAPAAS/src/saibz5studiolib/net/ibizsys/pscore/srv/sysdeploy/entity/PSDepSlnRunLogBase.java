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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMode;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnRunLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnRunLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGINFO2 = "LOGINFO2";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_PSDESLNASID = "PSDEPSLNASID";
    public static final String FIELD_PSDEPSLNASNAME = "PSDEPSLNASNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNMODEID = "PSDEPSLNMODEID";
    public static final String FIELD_PSDEPSLNMODENAME = "PSDEPSLNMODENAME";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNPRDID = "PSDEPSLNPRDID";
    public static final String FIELD_PSDEPSLNPRDNAME = "PSDEPSLNPRDNAME";
    public static final String FIELD_PSDEPSLNRUNLOGID = "PSDEPSLNRUNLOGID";
    public static final String FIELD_PSDEPSLNRUNLOGNAME = "PSDEPSLNRUNLOGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGINFO = 2;
    private static final int INDEX_LOGINFO2 = 3;
    private static final int INDEX_LOGLEVEL = 4;
    private static final int INDEX_LOGLEVEL2 = 5;
    private static final int INDEX_LOGTIME = 6;
    private static final int INDEX_PSDESLNASID = 7;
    private static final int INDEX_PSDEPSLNASNAME = 8;
    private static final int INDEX_PSDEPSLNID = 9;
    private static final int INDEX_PSDEPSLNMODEID = 10;
    private static final int INDEX_PSDEPSLNMODENAME = 11;
    private static final int INDEX_PSDEPSLNNAME = 12;
    private static final int INDEX_PSDEPSLNPRDID = 13;
    private static final int INDEX_PSDEPSLNPRDNAME = 14;
    private static final int INDEX_PSDEPSLNRUNLOGID = 15;
    private static final int INDEX_PSDEPSLNRUNLOGNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnRunLogBase proxyPSDepSlnRunLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loginfo2DirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean psdeslnasidDirtyFlag = false;
    private boolean psdepslnasnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnmodeidDirtyFlag = false;
    private boolean psdepslnmodenameDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnprdidDirtyFlag = false;
    private boolean psdepslnprdnameDirtyFlag = false;
    private boolean psdepslnrunlogidDirtyFlag = false;
    private boolean psdepslnrunlognameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loginfo2")
    private String loginfo2;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtime")
    private Timestamp logtime;
    @Column(name="psdeslnasid")
    private String psdeslnasid;
    @Column(name="psdepslnasname")
    private String psdepslnasname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnmodeid")
    private String psdepslnmodeid;
    @Column(name="psdepslnmodename")
    private String psdepslnmodename;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnprdid")
    private String psdepslnprdid;
    @Column(name="psdepslnprdname")
    private String psdepslnprdname;
    @Column(name="psdepslnrunlogid")
    private String psdepslnrunlogid;
    @Column(name="psdepslnrunlogname")
    private String psdepslnrunlogname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnASLock = new Integer(1);
    private PSDepSlnAS psdepslnas = null;
    private Integer objPSDepSlnModeLock = new Integer(1);
    private PSDepSlnMode psdepslnmode = null;
    private Integer objPSDepSlnPrdLock = new Integer(1);
    private PSDepSlnPrd psdepslnprd = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDeSlnASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeSlnASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeslnasid = string;
        this.psdeslnasidDirtyFlag = true;
    }

    public String getPSDeSlnASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeSlnASId();
        }
        return this.psdeslnasid;
    }

    public boolean isPSDeSlnASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeSlnASIdDirty();
        }
        return this.psdeslnasidDirtyFlag;
    }

    public void resetPSDeSlnASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeSlnASId();
            return;
        }
        this.psdeslnasidDirtyFlag = false;
        this.psdeslnasid = null;
    }

    public void setPSDepSlnASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasname = string;
        this.psdepslnasnameDirtyFlag = true;
    }

    public String getPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASName();
        }
        return this.psdepslnasname;
    }

    public boolean isPSDepSlnASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASNameDirty();
        }
        return this.psdepslnasnameDirtyFlag;
    }

    public void resetPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASName();
            return;
        }
        this.psdepslnasnameDirtyFlag = false;
        this.psdepslnasname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodeid = string;
        this.psdepslnmodeidDirtyFlag = true;
    }

    public String getPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeId();
        }
        return this.psdepslnmodeid;
    }

    public boolean isPSDepSlnModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeIdDirty();
        }
        return this.psdepslnmodeidDirtyFlag;
    }

    public void resetPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeId();
            return;
        }
        this.psdepslnmodeidDirtyFlag = false;
        this.psdepslnmodeid = null;
    }

    public void setPSDepSlnModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodename = string;
        this.psdepslnmodenameDirtyFlag = true;
    }

    public String getPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeName();
        }
        return this.psdepslnmodename;
    }

    public boolean isPSDepSlnModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeNameDirty();
        }
        return this.psdepslnmodenameDirtyFlag;
    }

    public void resetPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeName();
            return;
        }
        this.psdepslnmodenameDirtyFlag = false;
        this.psdepslnmodename = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdid = string;
        this.psdepslnprdidDirtyFlag = true;
    }

    public String getPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdId();
        }
        return this.psdepslnprdid;
    }

    public boolean isPSDepSlnPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdIdDirty();
        }
        return this.psdepslnprdidDirtyFlag;
    }

    public void resetPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdId();
            return;
        }
        this.psdepslnprdidDirtyFlag = false;
        this.psdepslnprdid = null;
    }

    public void setPSDepSlnPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdname = string;
        this.psdepslnprdnameDirtyFlag = true;
    }

    public String getPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdName();
        }
        return this.psdepslnprdname;
    }

    public boolean isPSDepSlnPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdNameDirty();
        }
        return this.psdepslnprdnameDirtyFlag;
    }

    public void resetPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdName();
            return;
        }
        this.psdepslnprdnameDirtyFlag = false;
        this.psdepslnprdname = null;
    }

    public void setPSDepSlnRunLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnRunLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnrunlogid = string;
        this.psdepslnrunlogidDirtyFlag = true;
    }

    public String getPSDepSlnRunLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnRunLogId();
        }
        return this.psdepslnrunlogid;
    }

    public boolean isPSDepSlnRunLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnRunLogIdDirty();
        }
        return this.psdepslnrunlogidDirtyFlag;
    }

    public void resetPSDepSlnRunLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnRunLogId();
            return;
        }
        this.psdepslnrunlogidDirtyFlag = false;
        this.psdepslnrunlogid = null;
    }

    public void setPSDepSlnRunLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnRunLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnrunlogname = string;
        this.psdepslnrunlognameDirtyFlag = true;
    }

    public String getPSDepSlnRunLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnRunLogName();
        }
        return this.psdepslnrunlogname;
    }

    public boolean isPSDepSlnRunLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnRunLogNameDirty();
        }
        return this.psdepslnrunlognameDirtyFlag;
    }

    public void resetPSDepSlnRunLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnRunLogName();
            return;
        }
        this.psdepslnrunlognameDirtyFlag = false;
        this.psdepslnrunlogname = null;
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
        PSDepSlnRunLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnRunLogBase pSDepSlnRunLogBase) {
        pSDepSlnRunLogBase.resetCreateDate();
        pSDepSlnRunLogBase.resetCreateMan();
        pSDepSlnRunLogBase.resetLogInfo();
        pSDepSlnRunLogBase.resetLogInfo2();
        pSDepSlnRunLogBase.resetLogLevel();
        pSDepSlnRunLogBase.resetLogLevel2();
        pSDepSlnRunLogBase.resetLogTime();
        pSDepSlnRunLogBase.resetPSDeSlnASId();
        pSDepSlnRunLogBase.resetPSDepSlnASName();
        pSDepSlnRunLogBase.resetPSDepSlnId();
        pSDepSlnRunLogBase.resetPSDepSlnModeId();
        pSDepSlnRunLogBase.resetPSDepSlnModeName();
        pSDepSlnRunLogBase.resetPSDepSlnName();
        pSDepSlnRunLogBase.resetPSDepSlnPrdId();
        pSDepSlnRunLogBase.resetPSDepSlnPrdName();
        pSDepSlnRunLogBase.resetPSDepSlnRunLogId();
        pSDepSlnRunLogBase.resetPSDepSlnRunLogName();
        pSDepSlnRunLogBase.resetUpdateDate();
        pSDepSlnRunLogBase.resetUpdateMan();
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
        if (!bl || this.isLogInfo2Dirty()) {
            hashMap.put(FIELD_LOGINFO2, this.getLogInfo2());
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
        if (!bl || this.isPSDeSlnASIdDirty()) {
            hashMap.put(FIELD_PSDESLNASID, this.getPSDeSlnASId());
        }
        if (!bl || this.isPSDepSlnASNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASNAME, this.getPSDepSlnASName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnModeIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODEID, this.getPSDepSlnModeId());
        }
        if (!bl || this.isPSDepSlnModeNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODENAME, this.getPSDepSlnModeName());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnPrdIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDID, this.getPSDepSlnPrdId());
        }
        if (!bl || this.isPSDepSlnPrdNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDNAME, this.getPSDepSlnPrdName());
        }
        if (!bl || this.isPSDepSlnRunLogIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNRUNLOGID, this.getPSDepSlnRunLogId());
        }
        if (!bl || this.isPSDepSlnRunLogNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNRUNLOGNAME, this.getPSDepSlnRunLogName());
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
        return PSDepSlnRunLogBase.get(this, n);
    }

    private static Object get(PSDepSlnRunLogBase pSDepSlnRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnRunLogBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnRunLogBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnRunLogBase.getLogInfo();
            }
            case 3: {
                return pSDepSlnRunLogBase.getLogInfo2();
            }
            case 4: {
                return pSDepSlnRunLogBase.getLogLevel();
            }
            case 5: {
                return pSDepSlnRunLogBase.getLogLevel2();
            }
            case 6: {
                return pSDepSlnRunLogBase.getLogTime();
            }
            case 7: {
                return pSDepSlnRunLogBase.getPSDeSlnASId();
            }
            case 8: {
                return pSDepSlnRunLogBase.getPSDepSlnASName();
            }
            case 9: {
                return pSDepSlnRunLogBase.getPSDepSlnId();
            }
            case 10: {
                return pSDepSlnRunLogBase.getPSDepSlnModeId();
            }
            case 11: {
                return pSDepSlnRunLogBase.getPSDepSlnModeName();
            }
            case 12: {
                return pSDepSlnRunLogBase.getPSDepSlnName();
            }
            case 13: {
                return pSDepSlnRunLogBase.getPSDepSlnPrdId();
            }
            case 14: {
                return pSDepSlnRunLogBase.getPSDepSlnPrdName();
            }
            case 15: {
                return pSDepSlnRunLogBase.getPSDepSlnRunLogId();
            }
            case 16: {
                return pSDepSlnRunLogBase.getPSDepSlnRunLogName();
            }
            case 17: {
                return pSDepSlnRunLogBase.getUpdateDate();
            }
            case 18: {
                return pSDepSlnRunLogBase.getUpdateMan();
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
        PSDepSlnRunLogBase.set(this, n, object);
    }

    private static void set(PSDepSlnRunLogBase pSDepSlnRunLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnRunLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnRunLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnRunLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnRunLogBase.setLogInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnRunLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnRunLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnRunLogBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnRunLogBase.setPSDeSlnASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnRunLogBase.setPSDepSlnASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnRunLogBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnRunLogBase.setPSDepSlnModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnRunLogBase.setPSDepSlnModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnRunLogBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnRunLogBase.setPSDepSlnPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnRunLogBase.setPSDepSlnPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnRunLogBase.setPSDepSlnRunLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnRunLogBase.setPSDepSlnRunLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnRunLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnRunLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnRunLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnRunLogBase pSDepSlnRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnRunLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnRunLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnRunLogBase.getLogInfo() == null;
            }
            case 3: {
                return pSDepSlnRunLogBase.getLogInfo2() == null;
            }
            case 4: {
                return pSDepSlnRunLogBase.getLogLevel() == null;
            }
            case 5: {
                return pSDepSlnRunLogBase.getLogLevel2() == null;
            }
            case 6: {
                return pSDepSlnRunLogBase.getLogTime() == null;
            }
            case 7: {
                return pSDepSlnRunLogBase.getPSDeSlnASId() == null;
            }
            case 8: {
                return pSDepSlnRunLogBase.getPSDepSlnASName() == null;
            }
            case 9: {
                return pSDepSlnRunLogBase.getPSDepSlnId() == null;
            }
            case 10: {
                return pSDepSlnRunLogBase.getPSDepSlnModeId() == null;
            }
            case 11: {
                return pSDepSlnRunLogBase.getPSDepSlnModeName() == null;
            }
            case 12: {
                return pSDepSlnRunLogBase.getPSDepSlnName() == null;
            }
            case 13: {
                return pSDepSlnRunLogBase.getPSDepSlnPrdId() == null;
            }
            case 14: {
                return pSDepSlnRunLogBase.getPSDepSlnPrdName() == null;
            }
            case 15: {
                return pSDepSlnRunLogBase.getPSDepSlnRunLogId() == null;
            }
            case 16: {
                return pSDepSlnRunLogBase.getPSDepSlnRunLogName() == null;
            }
            case 17: {
                return pSDepSlnRunLogBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDepSlnRunLogBase.getUpdateMan() == null;
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
        return PSDepSlnRunLogBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnRunLogBase pSDepSlnRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnRunLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnRunLogBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnRunLogBase.isLogInfoDirty();
            }
            case 3: {
                return pSDepSlnRunLogBase.isLogInfo2Dirty();
            }
            case 4: {
                return pSDepSlnRunLogBase.isLogLevelDirty();
            }
            case 5: {
                return pSDepSlnRunLogBase.isLogLevel2Dirty();
            }
            case 6: {
                return pSDepSlnRunLogBase.isLogTimeDirty();
            }
            case 7: {
                return pSDepSlnRunLogBase.isPSDeSlnASIdDirty();
            }
            case 8: {
                return pSDepSlnRunLogBase.isPSDepSlnASNameDirty();
            }
            case 9: {
                return pSDepSlnRunLogBase.isPSDepSlnIdDirty();
            }
            case 10: {
                return pSDepSlnRunLogBase.isPSDepSlnModeIdDirty();
            }
            case 11: {
                return pSDepSlnRunLogBase.isPSDepSlnModeNameDirty();
            }
            case 12: {
                return pSDepSlnRunLogBase.isPSDepSlnNameDirty();
            }
            case 13: {
                return pSDepSlnRunLogBase.isPSDepSlnPrdIdDirty();
            }
            case 14: {
                return pSDepSlnRunLogBase.isPSDepSlnPrdNameDirty();
            }
            case 15: {
                return pSDepSlnRunLogBase.isPSDepSlnRunLogIdDirty();
            }
            case 16: {
                return pSDepSlnRunLogBase.isPSDepSlnRunLogNameDirty();
            }
            case 17: {
                return pSDepSlnRunLogBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDepSlnRunLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnRunLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnRunLogBase pSDepSlnRunLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnRunLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getLogInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo2", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getLogInfo2()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getLogTime()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDeSlnASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasid", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDeSlnASId()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasname", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnASName()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodeid", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnModeId()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodename", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnModeName()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdid", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnPrdId()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdname", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnPrdName()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnrunlogid", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnRunLogId()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnrunlogname", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getPSDepSlnRunLogName()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnRunLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnRunLogBase.getJSONValue((Object)pSDepSlnRunLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnRunLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnRunLogBase pSDepSlnRunLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnRunLogBase.getCreateDate() != null) {
            object = pSDepSlnRunLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnRunLogBase.getCreateMan() != null) {
            object = pSDepSlnRunLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getLogInfo() != null) {
            object = pSDepSlnRunLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getLogInfo2() != null) {
            object = pSDepSlnRunLogBase.getLogInfo2();
            xmlNode.setAttribute(FIELD_LOGINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getLogLevel() != null) {
            object = pSDepSlnRunLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getLogLevel2() != null) {
            object = pSDepSlnRunLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnRunLogBase.getLogTime() != null) {
            object = pSDepSlnRunLogBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnRunLogBase.getPSDeSlnASId() != null) {
            object = pSDepSlnRunLogBase.getPSDeSlnASId();
            xmlNode.setAttribute("PSDESLNASID", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnASName() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnASName();
            xmlNode.setAttribute(FIELD_PSDEPSLNASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnId() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnModeId() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnModeId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnModeName() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnModeName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnName() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnPrdId() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnPrdId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnPrdName() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnPrdName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogId() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnRunLogId();
            xmlNode.setAttribute(FIELD_PSDEPSLNRUNLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogName() != null) {
            object = pSDepSlnRunLogBase.getPSDepSlnRunLogName();
            xmlNode.setAttribute(FIELD_PSDEPSLNRUNLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnRunLogBase.getUpdateDate() != null) {
            object = pSDepSlnRunLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnRunLogBase.getUpdateMan() != null) {
            object = pSDepSlnRunLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnRunLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnRunLogBase pSDepSlnRunLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnRunLogBase.isCreateDateDirty() && (bl || pSDepSlnRunLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnRunLogBase.getCreateDate());
        }
        if (pSDepSlnRunLogBase.isCreateManDirty() && (bl || pSDepSlnRunLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnRunLogBase.getCreateMan());
        }
        if (pSDepSlnRunLogBase.isLogInfoDirty() && (bl || pSDepSlnRunLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDepSlnRunLogBase.getLogInfo());
        }
        if (pSDepSlnRunLogBase.isLogInfo2Dirty() && (bl || pSDepSlnRunLogBase.getLogInfo2() != null)) {
            iDataObject.set(FIELD_LOGINFO2, (Object)pSDepSlnRunLogBase.getLogInfo2());
        }
        if (pSDepSlnRunLogBase.isLogLevelDirty() && (bl || pSDepSlnRunLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSDepSlnRunLogBase.getLogLevel());
        }
        if (pSDepSlnRunLogBase.isLogLevel2Dirty() && (bl || pSDepSlnRunLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSDepSlnRunLogBase.getLogLevel2());
        }
        if (pSDepSlnRunLogBase.isLogTimeDirty() && (bl || pSDepSlnRunLogBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSDepSlnRunLogBase.getLogTime());
        }
        if (pSDepSlnRunLogBase.isPSDeSlnASIdDirty() && (bl || pSDepSlnRunLogBase.getPSDeSlnASId() != null)) {
            iDataObject.set(FIELD_PSDESLNASID, (Object)pSDepSlnRunLogBase.getPSDeSlnASId());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnASNameDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnASName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASNAME, (Object)pSDepSlnRunLogBase.getPSDepSlnASName());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnIdDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnRunLogBase.getPSDepSlnId());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnModeIdDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnModeId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODEID, (Object)pSDepSlnRunLogBase.getPSDepSlnModeId());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnModeNameDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnModeName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODENAME, (Object)pSDepSlnRunLogBase.getPSDepSlnModeName());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnNameDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnRunLogBase.getPSDepSlnName());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnPrdIdDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnPrdId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDID, (Object)pSDepSlnRunLogBase.getPSDepSlnPrdId());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnPrdNameDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnPrdName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDNAME, (Object)pSDepSlnRunLogBase.getPSDepSlnPrdName());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnRunLogIdDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNRUNLOGID, (Object)pSDepSlnRunLogBase.getPSDepSlnRunLogId());
        }
        if (pSDepSlnRunLogBase.isPSDepSlnRunLogNameDirty() && (bl || pSDepSlnRunLogBase.getPSDepSlnRunLogName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNRUNLOGNAME, (Object)pSDepSlnRunLogBase.getPSDepSlnRunLogName());
        }
        if (pSDepSlnRunLogBase.isUpdateDateDirty() && (bl || pSDepSlnRunLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnRunLogBase.getUpdateDate());
        }
        if (pSDepSlnRunLogBase.isUpdateManDirty() && (bl || pSDepSlnRunLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnRunLogBase.getUpdateMan());
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
        return PSDepSlnRunLogBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnRunLogBase pSDepSlnRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnRunLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnRunLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnRunLogBase.resetLogInfo();
                return true;
            }
            case 3: {
                pSDepSlnRunLogBase.resetLogInfo2();
                return true;
            }
            case 4: {
                pSDepSlnRunLogBase.resetLogLevel();
                return true;
            }
            case 5: {
                pSDepSlnRunLogBase.resetLogLevel2();
                return true;
            }
            case 6: {
                pSDepSlnRunLogBase.resetLogTime();
                return true;
            }
            case 7: {
                pSDepSlnRunLogBase.resetPSDeSlnASId();
                return true;
            }
            case 8: {
                pSDepSlnRunLogBase.resetPSDepSlnASName();
                return true;
            }
            case 9: {
                pSDepSlnRunLogBase.resetPSDepSlnId();
                return true;
            }
            case 10: {
                pSDepSlnRunLogBase.resetPSDepSlnModeId();
                return true;
            }
            case 11: {
                pSDepSlnRunLogBase.resetPSDepSlnModeName();
                return true;
            }
            case 12: {
                pSDepSlnRunLogBase.resetPSDepSlnName();
                return true;
            }
            case 13: {
                pSDepSlnRunLogBase.resetPSDepSlnPrdId();
                return true;
            }
            case 14: {
                pSDepSlnRunLogBase.resetPSDepSlnPrdName();
                return true;
            }
            case 15: {
                pSDepSlnRunLogBase.resetPSDepSlnRunLogId();
                return true;
            }
            case 16: {
                pSDepSlnRunLogBase.resetPSDepSlnRunLogName();
                return true;
            }
            case 17: {
                pSDepSlnRunLogBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDepSlnRunLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnAS getPSDepSlnAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnAS();
        }
        if (this.getPSDeSlnASId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASLock;
        synchronized (n) {
            if (this.psdepslnas != null && DataTypeHelper.compare((int)25, (Object)this.getPSDeSlnASId(), (Object)this.psdepslnas.getPSDepSlnASId()) != 0L) {
                this.psdepslnas = null;
            }
            if (this.psdepslnas == null) {
                PSDepSlnAS pSDepSlnAS = new PSDepSlnAS();
                pSDepSlnAS.setPSDepSlnASId(this.getPSDeSlnASId());
                PSDepSlnASService pSDepSlnASService = (PSDepSlnASService)ServiceGlobal.getService(PSDepSlnASService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASService.autoGet((IEntity)pSDepSlnAS);
                this.psdepslnas = pSDepSlnAS;
            }
            return this.psdepslnas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnMode getPSDepSlnMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMode();
        }
        if (this.getPSDepSlnModeId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnModeLock;
        synchronized (n) {
            if (this.psdepslnmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnModeId(), (Object)this.psdepslnmode.getPSDepSlnModeId()) != 0L) {
                this.psdepslnmode = null;
            }
            if (this.psdepslnmode == null) {
                PSDepSlnMode pSDepSlnMode = new PSDepSlnMode();
                pSDepSlnMode.setPSDepSlnModeId(this.getPSDepSlnModeId());
                PSDepSlnModeService pSDepSlnModeService = (PSDepSlnModeService)ServiceGlobal.getService(PSDepSlnModeService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnModeService.autoGet((IEntity)pSDepSlnMode);
                this.psdepslnmode = pSDepSlnMode;
            }
            return this.psdepslnmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnPrd getPSDepSlnPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrd();
        }
        if (this.getPSDepSlnPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnPrdLock;
        synchronized (n) {
            if (this.psdepslnprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnPrdId(), (Object)this.psdepslnprd.getPSDepSlnPrdId()) != 0L) {
                this.psdepslnprd = null;
            }
            if (this.psdepslnprd == null) {
                PSDepSlnPrd pSDepSlnPrd = new PSDepSlnPrd();
                pSDepSlnPrd.setPSDepSlnPrdId(this.getPSDepSlnPrdId());
                PSDepSlnPrdService pSDepSlnPrdService = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnPrdService.autoGet((IEntity)pSDepSlnPrd);
                this.psdepslnprd = pSDepSlnPrd;
            }
            return this.psdepslnprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnRunLogBase getProxyEntity() {
        return this.proxyPSDepSlnRunLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnRunLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnRunLogBase) {
            this.proxyPSDepSlnRunLogBase = (PSDepSlnRunLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGINFO, 2);
        fieldIndexMap.put(FIELD_LOGINFO2, 3);
        fieldIndexMap.put(FIELD_LOGLEVEL, 4);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 5);
        fieldIndexMap.put(FIELD_LOGTIME, 6);
        fieldIndexMap.put(FIELD_PSDESLNASID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNASNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNMODEID, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNMODENAME, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDID, 13);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDNAME, 14);
        fieldIndexMap.put(FIELD_PSDEPSLNRUNLOGID, 15);
        fieldIndexMap.put(FIELD_PSDEPSLNRUNLOGNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

