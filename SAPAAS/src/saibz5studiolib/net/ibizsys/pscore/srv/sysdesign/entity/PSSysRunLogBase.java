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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRunLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRunLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGINFO2 = "LOGINFO2";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_PSSYSRUNLOGID = "PSSYSRUNLOGID";
    public static final String FIELD_PSSYSRUNLOGNAME = "PSSYSRUNLOGNAME";
    public static final String FIELD_PSSYSRUNSESSIONID = "PSSYSRUNSESSIONID";
    public static final String FIELD_PSSYSRUNSESSIONNAME = "PSSYSRUNSESSIONNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RUNSTATE = "RUNSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGINFO = 2;
    private static final int INDEX_LOGINFO2 = 3;
    private static final int INDEX_LOGLEVEL = 4;
    private static final int INDEX_LOGLEVEL2 = 5;
    private static final int INDEX_LOGTIME = 6;
    private static final int INDEX_PSSYSRUNLOGID = 7;
    private static final int INDEX_PSSYSRUNLOGNAME = 8;
    private static final int INDEX_PSSYSRUNSESSIONID = 9;
    private static final int INDEX_PSSYSRUNSESSIONNAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_RUNSTATE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRunLogBase proxyPSSysRunLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loginfo2DirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean pssysrunlogidDirtyFlag = false;
    private boolean pssysrunlognameDirtyFlag = false;
    private boolean pssysrunsessionidDirtyFlag = false;
    private boolean pssysrunsessionnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean runstateDirtyFlag = false;
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
    @Column(name="pssysrunlogid")
    private String pssysrunlogid;
    @Column(name="pssysrunlogname")
    private String pssysrunlogname;
    @Column(name="pssysrunsessionid")
    private String pssysrunsessionid;
    @Column(name="pssysrunsessionname")
    private String pssysrunsessionname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="runstate")
    private Integer runstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysRunSessionLock = new Integer(1);
    private PSSysRunSession pssysrunsession = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSysRunLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunlogid = string;
        this.pssysrunlogidDirtyFlag = true;
    }

    public String getPSSysRunLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunLogId();
        }
        return this.pssysrunlogid;
    }

    public boolean isPSSysRunLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunLogIdDirty();
        }
        return this.pssysrunlogidDirtyFlag;
    }

    public void resetPSSysRunLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunLogId();
            return;
        }
        this.pssysrunlogidDirtyFlag = false;
        this.pssysrunlogid = null;
    }

    public void setPSSysRunLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunlogname = string;
        this.pssysrunlognameDirtyFlag = true;
    }

    public String getPSSysRunLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunLogName();
        }
        return this.pssysrunlogname;
    }

    public boolean isPSSysRunLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunLogNameDirty();
        }
        return this.pssysrunlognameDirtyFlag;
    }

    public void resetPSSysRunLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunLogName();
            return;
        }
        this.pssysrunlognameDirtyFlag = false;
        this.pssysrunlogname = null;
    }

    public void setPSSysRunSessionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunSessionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunsessionid = string;
        this.pssysrunsessionidDirtyFlag = true;
    }

    public String getPSSysRunSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunSessionId();
        }
        return this.pssysrunsessionid;
    }

    public boolean isPSSysRunSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunSessionIdDirty();
        }
        return this.pssysrunsessionidDirtyFlag;
    }

    public void resetPSSysRunSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunSessionId();
            return;
        }
        this.pssysrunsessionidDirtyFlag = false;
        this.pssysrunsessionid = null;
    }

    public void setPSSysRunSessionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRunSessionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrunsessionname = string;
        this.pssysrunsessionnameDirtyFlag = true;
    }

    public String getPSSysRunSessionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunSessionName();
        }
        return this.pssysrunsessionname;
    }

    public boolean isPSSysRunSessionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRunSessionNameDirty();
        }
        return this.pssysrunsessionnameDirtyFlag;
    }

    public void resetPSSysRunSessionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRunSessionName();
            return;
        }
        this.pssysrunsessionnameDirtyFlag = false;
        this.pssysrunsessionname = null;
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

    public void setRunState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunState(n);
            return;
        }
        this.runstate = n;
        this.runstateDirtyFlag = true;
    }

    public Integer getRunState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunState();
        }
        return this.runstate;
    }

    public boolean isRunStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunStateDirty();
        }
        return this.runstateDirtyFlag;
    }

    public void resetRunState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunState();
            return;
        }
        this.runstateDirtyFlag = false;
        this.runstate = null;
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
        PSSysRunLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRunLogBase pSSysRunLogBase) {
        pSSysRunLogBase.resetCreateDate();
        pSSysRunLogBase.resetCreateMan();
        pSSysRunLogBase.resetLogInfo();
        pSSysRunLogBase.resetLogInfo2();
        pSSysRunLogBase.resetLogLevel();
        pSSysRunLogBase.resetLogLevel2();
        pSSysRunLogBase.resetLogTime();
        pSSysRunLogBase.resetPSSysRunLogId();
        pSSysRunLogBase.resetPSSysRunLogName();
        pSSysRunLogBase.resetPSSysRunSessionId();
        pSSysRunLogBase.resetPSSysRunSessionName();
        pSSysRunLogBase.resetPSSystemId();
        pSSysRunLogBase.resetPSSystemName();
        pSSysRunLogBase.resetRunState();
        pSSysRunLogBase.resetUpdateDate();
        pSSysRunLogBase.resetUpdateMan();
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
        if (!bl || this.isPSSysRunLogIdDirty()) {
            hashMap.put(FIELD_PSSYSRUNLOGID, this.getPSSysRunLogId());
        }
        if (!bl || this.isPSSysRunLogNameDirty()) {
            hashMap.put(FIELD_PSSYSRUNLOGNAME, this.getPSSysRunLogName());
        }
        if (!bl || this.isPSSysRunSessionIdDirty()) {
            hashMap.put(FIELD_PSSYSRUNSESSIONID, this.getPSSysRunSessionId());
        }
        if (!bl || this.isPSSysRunSessionNameDirty()) {
            hashMap.put(FIELD_PSSYSRUNSESSIONNAME, this.getPSSysRunSessionName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRunStateDirty()) {
            hashMap.put(FIELD_RUNSTATE, this.getRunState());
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
        return PSSysRunLogBase.get(this, n);
    }

    private static Object get(PSSysRunLogBase pSSysRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunLogBase.getCreateDate();
            }
            case 1: {
                return pSSysRunLogBase.getCreateMan();
            }
            case 2: {
                return pSSysRunLogBase.getLogInfo();
            }
            case 3: {
                return pSSysRunLogBase.getLogInfo2();
            }
            case 4: {
                return pSSysRunLogBase.getLogLevel();
            }
            case 5: {
                return pSSysRunLogBase.getLogLevel2();
            }
            case 6: {
                return pSSysRunLogBase.getLogTime();
            }
            case 7: {
                return pSSysRunLogBase.getPSSysRunLogId();
            }
            case 8: {
                return pSSysRunLogBase.getPSSysRunLogName();
            }
            case 9: {
                return pSSysRunLogBase.getPSSysRunSessionId();
            }
            case 10: {
                return pSSysRunLogBase.getPSSysRunSessionName();
            }
            case 11: {
                return pSSysRunLogBase.getPSSystemId();
            }
            case 12: {
                return pSSysRunLogBase.getPSSystemName();
            }
            case 13: {
                return pSSysRunLogBase.getRunState();
            }
            case 14: {
                return pSSysRunLogBase.getUpdateDate();
            }
            case 15: {
                return pSSysRunLogBase.getUpdateMan();
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
        PSSysRunLogBase.set(this, n, object);
    }

    private static void set(PSSysRunLogBase pSSysRunLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRunLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysRunLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysRunLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysRunLogBase.setLogInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysRunLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysRunLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysRunLogBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysRunLogBase.setPSSysRunLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRunLogBase.setPSSysRunLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRunLogBase.setPSSysRunSessionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRunLogBase.setPSSysRunSessionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysRunLogBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysRunLogBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysRunLogBase.setRunState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysRunLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysRunLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysRunLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRunLogBase pSSysRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysRunLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysRunLogBase.getLogInfo() == null;
            }
            case 3: {
                return pSSysRunLogBase.getLogInfo2() == null;
            }
            case 4: {
                return pSSysRunLogBase.getLogLevel() == null;
            }
            case 5: {
                return pSSysRunLogBase.getLogLevel2() == null;
            }
            case 6: {
                return pSSysRunLogBase.getLogTime() == null;
            }
            case 7: {
                return pSSysRunLogBase.getPSSysRunLogId() == null;
            }
            case 8: {
                return pSSysRunLogBase.getPSSysRunLogName() == null;
            }
            case 9: {
                return pSSysRunLogBase.getPSSysRunSessionId() == null;
            }
            case 10: {
                return pSSysRunLogBase.getPSSysRunSessionName() == null;
            }
            case 11: {
                return pSSysRunLogBase.getPSSystemId() == null;
            }
            case 12: {
                return pSSysRunLogBase.getPSSystemName() == null;
            }
            case 13: {
                return pSSysRunLogBase.getRunState() == null;
            }
            case 14: {
                return pSSysRunLogBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysRunLogBase.getUpdateMan() == null;
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
        return PSSysRunLogBase.contains(this, n);
    }

    private static boolean contains(PSSysRunLogBase pSSysRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRunLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysRunLogBase.isCreateManDirty();
            }
            case 2: {
                return pSSysRunLogBase.isLogInfoDirty();
            }
            case 3: {
                return pSSysRunLogBase.isLogInfo2Dirty();
            }
            case 4: {
                return pSSysRunLogBase.isLogLevelDirty();
            }
            case 5: {
                return pSSysRunLogBase.isLogLevel2Dirty();
            }
            case 6: {
                return pSSysRunLogBase.isLogTimeDirty();
            }
            case 7: {
                return pSSysRunLogBase.isPSSysRunLogIdDirty();
            }
            case 8: {
                return pSSysRunLogBase.isPSSysRunLogNameDirty();
            }
            case 9: {
                return pSSysRunLogBase.isPSSysRunSessionIdDirty();
            }
            case 10: {
                return pSSysRunLogBase.isPSSysRunSessionNameDirty();
            }
            case 11: {
                return pSSysRunLogBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSSysRunLogBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSSysRunLogBase.isRunStateDirty();
            }
            case 14: {
                return pSSysRunLogBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysRunLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRunLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRunLogBase pSSysRunLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRunLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getLogInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo2", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getLogInfo2()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getLogTime()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSysRunLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunlogid", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSysRunLogId()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSysRunLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunlogname", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSysRunLogName()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSysRunSessionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunsessionid", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSysRunSessionId()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSysRunSessionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrunsessionname", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSysRunSessionName()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getRunState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runstate", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getRunState()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRunLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRunLogBase.getJSONValue((Object)pSSysRunLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRunLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRunLogBase pSSysRunLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRunLogBase.getCreateDate() != null) {
            object = pSSysRunLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunLogBase.getCreateMan() != null) {
            object = pSSysRunLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getLogInfo() != null) {
            object = pSSysRunLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getLogInfo2() != null) {
            object = pSSysRunLogBase.getLogInfo2();
            xmlNode.setAttribute(FIELD_LOGINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getLogLevel() != null) {
            object = pSSysRunLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getLogLevel2() != null) {
            object = pSSysRunLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunLogBase.getLogTime() != null) {
            object = pSSysRunLogBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunLogBase.getPSSysRunLogId() != null) {
            object = pSSysRunLogBase.getPSSysRunLogId();
            xmlNode.setAttribute(FIELD_PSSYSRUNLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getPSSysRunLogName() != null) {
            object = pSSysRunLogBase.getPSSysRunLogName();
            xmlNode.setAttribute(FIELD_PSSYSRUNLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getPSSysRunSessionId() != null) {
            object = pSSysRunLogBase.getPSSysRunSessionId();
            xmlNode.setAttribute(FIELD_PSSYSRUNSESSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getPSSysRunSessionName() != null) {
            object = pSSysRunLogBase.getPSSysRunSessionName();
            xmlNode.setAttribute(FIELD_PSSYSRUNSESSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getPSSystemId() != null) {
            object = pSSysRunLogBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getPSSystemName() != null) {
            object = pSSysRunLogBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRunLogBase.getRunState() != null) {
            object = pSSysRunLogBase.getRunState();
            xmlNode.setAttribute(FIELD_RUNSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRunLogBase.getUpdateDate() != null) {
            object = pSSysRunLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRunLogBase.getUpdateMan() != null) {
            object = pSSysRunLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRunLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRunLogBase pSSysRunLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRunLogBase.isCreateDateDirty() && (bl || pSSysRunLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRunLogBase.getCreateDate());
        }
        if (pSSysRunLogBase.isCreateManDirty() && (bl || pSSysRunLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRunLogBase.getCreateMan());
        }
        if (pSSysRunLogBase.isLogInfoDirty() && (bl || pSSysRunLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSSysRunLogBase.getLogInfo());
        }
        if (pSSysRunLogBase.isLogInfo2Dirty() && (bl || pSSysRunLogBase.getLogInfo2() != null)) {
            iDataObject.set(FIELD_LOGINFO2, (Object)pSSysRunLogBase.getLogInfo2());
        }
        if (pSSysRunLogBase.isLogLevelDirty() && (bl || pSSysRunLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSSysRunLogBase.getLogLevel());
        }
        if (pSSysRunLogBase.isLogLevel2Dirty() && (bl || pSSysRunLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSSysRunLogBase.getLogLevel2());
        }
        if (pSSysRunLogBase.isLogTimeDirty() && (bl || pSSysRunLogBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSSysRunLogBase.getLogTime());
        }
        if (pSSysRunLogBase.isPSSysRunLogIdDirty() && (bl || pSSysRunLogBase.getPSSysRunLogId() != null)) {
            iDataObject.set(FIELD_PSSYSRUNLOGID, (Object)pSSysRunLogBase.getPSSysRunLogId());
        }
        if (pSSysRunLogBase.isPSSysRunLogNameDirty() && (bl || pSSysRunLogBase.getPSSysRunLogName() != null)) {
            iDataObject.set(FIELD_PSSYSRUNLOGNAME, (Object)pSSysRunLogBase.getPSSysRunLogName());
        }
        if (pSSysRunLogBase.isPSSysRunSessionIdDirty() && (bl || pSSysRunLogBase.getPSSysRunSessionId() != null)) {
            iDataObject.set(FIELD_PSSYSRUNSESSIONID, (Object)pSSysRunLogBase.getPSSysRunSessionId());
        }
        if (pSSysRunLogBase.isPSSysRunSessionNameDirty() && (bl || pSSysRunLogBase.getPSSysRunSessionName() != null)) {
            iDataObject.set(FIELD_PSSYSRUNSESSIONNAME, (Object)pSSysRunLogBase.getPSSysRunSessionName());
        }
        if (pSSysRunLogBase.isPSSystemIdDirty() && (bl || pSSysRunLogBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysRunLogBase.getPSSystemId());
        }
        if (pSSysRunLogBase.isPSSystemNameDirty() && (bl || pSSysRunLogBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysRunLogBase.getPSSystemName());
        }
        if (pSSysRunLogBase.isRunStateDirty() && (bl || pSSysRunLogBase.getRunState() != null)) {
            iDataObject.set(FIELD_RUNSTATE, (Object)pSSysRunLogBase.getRunState());
        }
        if (pSSysRunLogBase.isUpdateDateDirty() && (bl || pSSysRunLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRunLogBase.getUpdateDate());
        }
        if (pSSysRunLogBase.isUpdateManDirty() && (bl || pSSysRunLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRunLogBase.getUpdateMan());
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
        return PSSysRunLogBase.remove(this, n);
    }

    private static boolean remove(PSSysRunLogBase pSSysRunLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRunLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysRunLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysRunLogBase.resetLogInfo();
                return true;
            }
            case 3: {
                pSSysRunLogBase.resetLogInfo2();
                return true;
            }
            case 4: {
                pSSysRunLogBase.resetLogLevel();
                return true;
            }
            case 5: {
                pSSysRunLogBase.resetLogLevel2();
                return true;
            }
            case 6: {
                pSSysRunLogBase.resetLogTime();
                return true;
            }
            case 7: {
                pSSysRunLogBase.resetPSSysRunLogId();
                return true;
            }
            case 8: {
                pSSysRunLogBase.resetPSSysRunLogName();
                return true;
            }
            case 9: {
                pSSysRunLogBase.resetPSSysRunSessionId();
                return true;
            }
            case 10: {
                pSSysRunLogBase.resetPSSysRunSessionName();
                return true;
            }
            case 11: {
                pSSysRunLogBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSSysRunLogBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSSysRunLogBase.resetRunState();
                return true;
            }
            case 14: {
                pSSysRunLogBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysRunLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysRunSession getPSSysRunSession() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRunSession();
        }
        if (this.getPSSysRunSessionId() == null) {
            return null;
        }
        Integer n = this.objPSSysRunSessionLock;
        synchronized (n) {
            if (this.pssysrunsession != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysRunSessionId(), (Object)this.pssysrunsession.getPSSysRunSessionId()) != 0L) {
                this.pssysrunsession = null;
            }
            if (this.pssysrunsession == null) {
                PSSysRunSession pSSysRunSession = new PSSysRunSession();
                pSSysRunSession.setPSSysRunSessionId(this.getPSSysRunSessionId());
                PSSysRunSessionService pSSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)this.getSessionFactory());
                pSSysRunSessionService.autoGet((IEntity)pSSysRunSession);
                this.pssysrunsession = pSSysRunSession;
            }
            return this.pssysrunsession;
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

    private PSSysRunLogBase getProxyEntity() {
        return this.proxyPSSysRunLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRunLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRunLogBase) {
            this.proxyPSSysRunLogBase = (PSSysRunLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSSYSRUNLOGID, 7);
        fieldIndexMap.put(FIELD_PSSYSRUNLOGNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSRUNSESSIONID, 9);
        fieldIndexMap.put(FIELD_PSSYSRUNSESSIONNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_RUNSTATE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

