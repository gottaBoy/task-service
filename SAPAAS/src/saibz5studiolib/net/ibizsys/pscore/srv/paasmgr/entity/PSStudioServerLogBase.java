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
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioServerLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioServerLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCCNT = "DCCNT";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_FREEMEMORY = "FREEMEMORY";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_MAXMEMORY = "MAXMEMORY";
    public static final String FIELD_PSSTUDIOSERVERID = "PSSTUDIOSERVERID";
    public static final String FIELD_PSSTUDIOSERVERLOGID = "PSSTUDIOSERVERLOGID";
    public static final String FIELD_PSSTUDIOSERVERLOGNAME = "PSSTUDIOSERVERLOGNAME";
    public static final String FIELD_PSSTUDIOSERVERNAME = "PSSTUDIOSERVERNAME";
    public static final String FIELD_SYSMODELCNT = "SYSMODELCNT";
    public static final String FIELD_SYSMODELINSTCNT = "SYSMODELINSTCNT";
    public static final String FIELD_THREADCNT = "THREADCNT";
    public static final String FIELD_TOTALMEMORY = "TOTALMEMORY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCNT = "USERCNT";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DCCNT = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_FREEMEMORY = 4;
    private static final int INDEX_LOGTIME = 5;
    private static final int INDEX_MAXMEMORY = 6;
    private static final int INDEX_PSSTUDIOSERVERID = 7;
    private static final int INDEX_PSSTUDIOSERVERLOGID = 8;
    private static final int INDEX_PSSTUDIOSERVERLOGNAME = 9;
    private static final int INDEX_PSSTUDIOSERVERNAME = 10;
    private static final int INDEX_SYSMODELCNT = 11;
    private static final int INDEX_SYSMODELINSTCNT = 12;
    private static final int INDEX_THREADCNT = 13;
    private static final int INDEX_TOTALMEMORY = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCNT = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioServerLogBase proxyPSStudioServerLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dccntDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean freememoryDirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean maxmemoryDirtyFlag = false;
    private boolean psstudioserveridDirtyFlag = false;
    private boolean psstudioserverlogidDirtyFlag = false;
    private boolean psstudioserverlognameDirtyFlag = false;
    private boolean psstudioservernameDirtyFlag = false;
    private boolean sysmodelcntDirtyFlag = false;
    private boolean sysmodelinstcntDirtyFlag = false;
    private boolean threadcntDirtyFlag = false;
    private boolean totalmemoryDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercntDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dccnt")
    private Integer dccnt;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="freememory")
    private Integer freememory;
    @Column(name="logtime")
    private Timestamp logtime;
    @Column(name="maxmemory")
    private Integer maxmemory;
    @Column(name="psstudioserverid")
    private String psstudioserverid;
    @Column(name="psstudioserverlogid")
    private String psstudioserverlogid;
    @Column(name="psstudioserverlogname")
    private String psstudioserverlogname;
    @Column(name="psstudioservername")
    private String psstudioservername;
    @Column(name="sysmodelcnt")
    private Integer sysmodelcnt;
    @Column(name="sysmodelinstcnt")
    private Integer sysmodelinstcnt;
    @Column(name="threadcnt")
    private Integer threadcnt;
    @Column(name="totalmemory")
    private Integer totalmemory;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercnt")
    private Integer usercnt;
    private Integer objPSStudioServerLock = new Integer(1);
    private PSStudioServer psstudioserver = null;

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

    public void setDCCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCCnt(n);
            return;
        }
        this.dccnt = n;
        this.dccntDirtyFlag = true;
    }

    public Integer getDCCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCCnt();
        }
        return this.dccnt;
    }

    public boolean isDCCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCCntDirty();
        }
        return this.dccntDirtyFlag;
    }

    public void resetDCCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCCnt();
            return;
        }
        this.dccntDirtyFlag = false;
        this.dccnt = null;
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

    public void setFreeMemory(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFreeMemory(n);
            return;
        }
        this.freememory = n;
        this.freememoryDirtyFlag = true;
    }

    public Integer getFreeMemory() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFreeMemory();
        }
        return this.freememory;
    }

    public boolean isFreeMemoryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFreeMemoryDirty();
        }
        return this.freememoryDirtyFlag;
    }

    public void resetFreeMemory() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFreeMemory();
            return;
        }
        this.freememoryDirtyFlag = false;
        this.freememory = null;
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

    public void setMaxMemory(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMemory(n);
            return;
        }
        this.maxmemory = n;
        this.maxmemoryDirtyFlag = true;
    }

    public Integer getMaxMemory() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMemory();
        }
        return this.maxmemory;
    }

    public boolean isMaxMemoryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMemoryDirty();
        }
        return this.maxmemoryDirtyFlag;
    }

    public void resetMaxMemory() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMemory();
            return;
        }
        this.maxmemoryDirtyFlag = false;
        this.maxmemory = null;
    }

    public void setPSStudioServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioserverid = string;
        this.psstudioserveridDirtyFlag = true;
    }

    public String getPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerId();
        }
        return this.psstudioserverid;
    }

    public boolean isPSStudioServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerIdDirty();
        }
        return this.psstudioserveridDirtyFlag;
    }

    public void resetPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerId();
            return;
        }
        this.psstudioserveridDirtyFlag = false;
        this.psstudioserverid = null;
    }

    public void setPSStudioServerLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioserverlogid = string;
        this.psstudioserverlogidDirtyFlag = true;
    }

    public String getPSStudioServerLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerLogId();
        }
        return this.psstudioserverlogid;
    }

    public boolean isPSStudioServerLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerLogIdDirty();
        }
        return this.psstudioserverlogidDirtyFlag;
    }

    public void resetPSStudioServerLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerLogId();
            return;
        }
        this.psstudioserverlogidDirtyFlag = false;
        this.psstudioserverlogid = null;
    }

    public void setPSStudioServerLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioserverlogname = string;
        this.psstudioserverlognameDirtyFlag = true;
    }

    public String getPSStudioServerLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerLogName();
        }
        return this.psstudioserverlogname;
    }

    public boolean isPSStudioServerLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerLogNameDirty();
        }
        return this.psstudioserverlognameDirtyFlag;
    }

    public void resetPSStudioServerLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerLogName();
            return;
        }
        this.psstudioserverlognameDirtyFlag = false;
        this.psstudioserverlogname = null;
    }

    public void setPSStudioServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservername = string;
        this.psstudioservernameDirtyFlag = true;
    }

    public String getPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerName();
        }
        return this.psstudioservername;
    }

    public boolean isPSStudioServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerNameDirty();
        }
        return this.psstudioservernameDirtyFlag;
    }

    public void resetPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerName();
            return;
        }
        this.psstudioservernameDirtyFlag = false;
        this.psstudioservername = null;
    }

    public void setSysModelCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelCnt(n);
            return;
        }
        this.sysmodelcnt = n;
        this.sysmodelcntDirtyFlag = true;
    }

    public Integer getSysModelCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelCnt();
        }
        return this.sysmodelcnt;
    }

    public boolean isSysModelCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelCntDirty();
        }
        return this.sysmodelcntDirtyFlag;
    }

    public void resetSysModelCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelCnt();
            return;
        }
        this.sysmodelcntDirtyFlag = false;
        this.sysmodelcnt = null;
    }

    public void setSysModelInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelInstCnt(n);
            return;
        }
        this.sysmodelinstcnt = n;
        this.sysmodelinstcntDirtyFlag = true;
    }

    public Integer getSysModelInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelInstCnt();
        }
        return this.sysmodelinstcnt;
    }

    public boolean isSysModelInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelInstCntDirty();
        }
        return this.sysmodelinstcntDirtyFlag;
    }

    public void resetSysModelInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelInstCnt();
            return;
        }
        this.sysmodelinstcntDirtyFlag = false;
        this.sysmodelinstcnt = null;
    }

    public void setThreadCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadCnt(n);
            return;
        }
        this.threadcnt = n;
        this.threadcntDirtyFlag = true;
    }

    public Integer getThreadCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadCnt();
        }
        return this.threadcnt;
    }

    public boolean isThreadCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadCntDirty();
        }
        return this.threadcntDirtyFlag;
    }

    public void resetThreadCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadCnt();
            return;
        }
        this.threadcntDirtyFlag = false;
        this.threadcnt = null;
    }

    public void setTotalMemory(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalMemory(n);
            return;
        }
        this.totalmemory = n;
        this.totalmemoryDirtyFlag = true;
    }

    public Integer getTotalMemory() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalMemory();
        }
        return this.totalmemory;
    }

    public boolean isTotalMemoryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalMemoryDirty();
        }
        return this.totalmemoryDirtyFlag;
    }

    public void resetTotalMemory() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalMemory();
            return;
        }
        this.totalmemoryDirtyFlag = false;
        this.totalmemory = null;
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

    public void setUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCnt(n);
            return;
        }
        this.usercnt = n;
        this.usercntDirtyFlag = true;
    }

    public Integer getUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCnt();
        }
        return this.usercnt;
    }

    public boolean isUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCntDirty();
        }
        return this.usercntDirtyFlag;
    }

    public void resetUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCnt();
            return;
        }
        this.usercntDirtyFlag = false;
        this.usercnt = null;
    }

    protected void onReset() {
        PSStudioServerLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioServerLogBase pSStudioServerLogBase) {
        pSStudioServerLogBase.resetCreateDate();
        pSStudioServerLogBase.resetCreateMan();
        pSStudioServerLogBase.resetDCCnt();
        pSStudioServerLogBase.resetDefaultFlag();
        pSStudioServerLogBase.resetFreeMemory();
        pSStudioServerLogBase.resetLogTime();
        pSStudioServerLogBase.resetMaxMemory();
        pSStudioServerLogBase.resetPSStudioServerId();
        pSStudioServerLogBase.resetPSStudioServerLogId();
        pSStudioServerLogBase.resetPSStudioServerLogName();
        pSStudioServerLogBase.resetPSStudioServerName();
        pSStudioServerLogBase.resetSysModelCnt();
        pSStudioServerLogBase.resetSysModelInstCnt();
        pSStudioServerLogBase.resetThreadCnt();
        pSStudioServerLogBase.resetTotalMemory();
        pSStudioServerLogBase.resetUpdateDate();
        pSStudioServerLogBase.resetUpdateMan();
        pSStudioServerLogBase.resetUserCnt();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCCntDirty()) {
            hashMap.put(FIELD_DCCNT, this.getDCCnt());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isFreeMemoryDirty()) {
            hashMap.put(FIELD_FREEMEMORY, this.getFreeMemory());
        }
        if (!bl || this.isLogTimeDirty()) {
            hashMap.put(FIELD_LOGTIME, this.getLogTime());
        }
        if (!bl || this.isMaxMemoryDirty()) {
            hashMap.put(FIELD_MAXMEMORY, this.getMaxMemory());
        }
        if (!bl || this.isPSStudioServerIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERID, this.getPSStudioServerId());
        }
        if (!bl || this.isPSStudioServerLogIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERLOGID, this.getPSStudioServerLogId());
        }
        if (!bl || this.isPSStudioServerLogNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERLOGNAME, this.getPSStudioServerLogName());
        }
        if (!bl || this.isPSStudioServerNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERNAME, this.getPSStudioServerName());
        }
        if (!bl || this.isSysModelCntDirty()) {
            hashMap.put(FIELD_SYSMODELCNT, this.getSysModelCnt());
        }
        if (!bl || this.isSysModelInstCntDirty()) {
            hashMap.put(FIELD_SYSMODELINSTCNT, this.getSysModelInstCnt());
        }
        if (!bl || this.isThreadCntDirty()) {
            hashMap.put(FIELD_THREADCNT, this.getThreadCnt());
        }
        if (!bl || this.isTotalMemoryDirty()) {
            hashMap.put(FIELD_TOTALMEMORY, this.getTotalMemory());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCntDirty()) {
            hashMap.put(FIELD_USERCNT, this.getUserCnt());
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
        return PSStudioServerLogBase.get(this, n);
    }

    private static Object get(PSStudioServerLogBase pSStudioServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerLogBase.getCreateDate();
            }
            case 1: {
                return pSStudioServerLogBase.getCreateMan();
            }
            case 2: {
                return pSStudioServerLogBase.getDCCnt();
            }
            case 3: {
                return pSStudioServerLogBase.getDefaultFlag();
            }
            case 4: {
                return pSStudioServerLogBase.getFreeMemory();
            }
            case 5: {
                return pSStudioServerLogBase.getLogTime();
            }
            case 6: {
                return pSStudioServerLogBase.getMaxMemory();
            }
            case 7: {
                return pSStudioServerLogBase.getPSStudioServerId();
            }
            case 8: {
                return pSStudioServerLogBase.getPSStudioServerLogId();
            }
            case 9: {
                return pSStudioServerLogBase.getPSStudioServerLogName();
            }
            case 10: {
                return pSStudioServerLogBase.getPSStudioServerName();
            }
            case 11: {
                return pSStudioServerLogBase.getSysModelCnt();
            }
            case 12: {
                return pSStudioServerLogBase.getSysModelInstCnt();
            }
            case 13: {
                return pSStudioServerLogBase.getThreadCnt();
            }
            case 14: {
                return pSStudioServerLogBase.getTotalMemory();
            }
            case 15: {
                return pSStudioServerLogBase.getUpdateDate();
            }
            case 16: {
                return pSStudioServerLogBase.getUpdateMan();
            }
            case 17: {
                return pSStudioServerLogBase.getUserCnt();
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
        PSStudioServerLogBase.set(this, n, object);
    }

    private static void set(PSStudioServerLogBase pSStudioServerLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSStudioServerLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSStudioServerLogBase.setDCCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSStudioServerLogBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSStudioServerLogBase.setFreeMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSStudioServerLogBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSStudioServerLogBase.setMaxMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSStudioServerLogBase.setPSStudioServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioServerLogBase.setPSStudioServerLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioServerLogBase.setPSStudioServerLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioServerLogBase.setPSStudioServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioServerLogBase.setSysModelCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSStudioServerLogBase.setSysModelInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSStudioServerLogBase.setThreadCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSStudioServerLogBase.setTotalMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSStudioServerLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSStudioServerLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSStudioServerLogBase.setUserCnt(DataObject.getIntegerValue((Object)object));
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
        return PSStudioServerLogBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioServerLogBase pSStudioServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSStudioServerLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSStudioServerLogBase.getDCCnt() == null;
            }
            case 3: {
                return pSStudioServerLogBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSStudioServerLogBase.getFreeMemory() == null;
            }
            case 5: {
                return pSStudioServerLogBase.getLogTime() == null;
            }
            case 6: {
                return pSStudioServerLogBase.getMaxMemory() == null;
            }
            case 7: {
                return pSStudioServerLogBase.getPSStudioServerId() == null;
            }
            case 8: {
                return pSStudioServerLogBase.getPSStudioServerLogId() == null;
            }
            case 9: {
                return pSStudioServerLogBase.getPSStudioServerLogName() == null;
            }
            case 10: {
                return pSStudioServerLogBase.getPSStudioServerName() == null;
            }
            case 11: {
                return pSStudioServerLogBase.getSysModelCnt() == null;
            }
            case 12: {
                return pSStudioServerLogBase.getSysModelInstCnt() == null;
            }
            case 13: {
                return pSStudioServerLogBase.getThreadCnt() == null;
            }
            case 14: {
                return pSStudioServerLogBase.getTotalMemory() == null;
            }
            case 15: {
                return pSStudioServerLogBase.getUpdateDate() == null;
            }
            case 16: {
                return pSStudioServerLogBase.getUpdateMan() == null;
            }
            case 17: {
                return pSStudioServerLogBase.getUserCnt() == null;
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
        return PSStudioServerLogBase.contains(this, n);
    }

    private static boolean contains(PSStudioServerLogBase pSStudioServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSStudioServerLogBase.isCreateManDirty();
            }
            case 2: {
                return pSStudioServerLogBase.isDCCntDirty();
            }
            case 3: {
                return pSStudioServerLogBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSStudioServerLogBase.isFreeMemoryDirty();
            }
            case 5: {
                return pSStudioServerLogBase.isLogTimeDirty();
            }
            case 6: {
                return pSStudioServerLogBase.isMaxMemoryDirty();
            }
            case 7: {
                return pSStudioServerLogBase.isPSStudioServerIdDirty();
            }
            case 8: {
                return pSStudioServerLogBase.isPSStudioServerLogIdDirty();
            }
            case 9: {
                return pSStudioServerLogBase.isPSStudioServerLogNameDirty();
            }
            case 10: {
                return pSStudioServerLogBase.isPSStudioServerNameDirty();
            }
            case 11: {
                return pSStudioServerLogBase.isSysModelCntDirty();
            }
            case 12: {
                return pSStudioServerLogBase.isSysModelInstCntDirty();
            }
            case 13: {
                return pSStudioServerLogBase.isThreadCntDirty();
            }
            case 14: {
                return pSStudioServerLogBase.isTotalMemoryDirty();
            }
            case 15: {
                return pSStudioServerLogBase.isUpdateDateDirty();
            }
            case 16: {
                return pSStudioServerLogBase.isUpdateManDirty();
            }
            case 17: {
                return pSStudioServerLogBase.isUserCntDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioServerLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioServerLogBase pSStudioServerLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioServerLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getDCCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dccnt", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getDCCnt()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getFreeMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"freememory", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getFreeMemory()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getLogTime()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getMaxMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmemory", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getMaxMemory()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioserverid", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getPSStudioServerId()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioserverlogid", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getPSStudioServerLogId()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioserverlogname", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getPSStudioServerLogName()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservername", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getPSStudioServerName()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getSysModelCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelcnt", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getSysModelCnt()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getSysModelInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelinstcnt", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getSysModelInstCnt()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getThreadCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadcnt", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getThreadCnt()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getTotalMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalmemory", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getTotalMemory()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSStudioServerLogBase.getUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercnt", (Object)PSStudioServerLogBase.getJSONValue((Object)pSStudioServerLogBase.getUserCnt()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioServerLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioServerLogBase pSStudioServerLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioServerLogBase.getCreateDate() != null) {
            object = pSStudioServerLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getCreateMan() != null) {
            object = pSStudioServerLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getDCCnt() != null) {
            object = pSStudioServerLogBase.getDCCnt();
            xmlNode.setAttribute(FIELD_DCCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getDefaultFlag() != null) {
            object = pSStudioServerLogBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getFreeMemory() != null) {
            object = pSStudioServerLogBase.getFreeMemory();
            xmlNode.setAttribute(FIELD_FREEMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getLogTime() != null) {
            object = pSStudioServerLogBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getMaxMemory() != null) {
            object = pSStudioServerLogBase.getMaxMemory();
            xmlNode.setAttribute(FIELD_MAXMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerId() != null) {
            object = pSStudioServerLogBase.getPSStudioServerId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerLogId() != null) {
            object = pSStudioServerLogBase.getPSStudioServerLogId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerLogName() != null) {
            object = pSStudioServerLogBase.getPSStudioServerLogName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getPSStudioServerName() != null) {
            object = pSStudioServerLogBase.getPSStudioServerName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getSysModelCnt() != null) {
            object = pSStudioServerLogBase.getSysModelCnt();
            xmlNode.setAttribute(FIELD_SYSMODELCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getSysModelInstCnt() != null) {
            object = pSStudioServerLogBase.getSysModelInstCnt();
            xmlNode.setAttribute(FIELD_SYSMODELINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getThreadCnt() != null) {
            object = pSStudioServerLogBase.getThreadCnt();
            xmlNode.setAttribute(FIELD_THREADCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getTotalMemory() != null) {
            object = pSStudioServerLogBase.getTotalMemory();
            xmlNode.setAttribute(FIELD_TOTALMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getUpdateDate() != null) {
            object = pSStudioServerLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerLogBase.getUpdateMan() != null) {
            object = pSStudioServerLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerLogBase.getUserCnt() != null) {
            object = pSStudioServerLogBase.getUserCnt();
            xmlNode.setAttribute(FIELD_USERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioServerLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioServerLogBase pSStudioServerLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioServerLogBase.isCreateDateDirty() && (bl || pSStudioServerLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioServerLogBase.getCreateDate());
        }
        if (pSStudioServerLogBase.isCreateManDirty() && (bl || pSStudioServerLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioServerLogBase.getCreateMan());
        }
        if (pSStudioServerLogBase.isDCCntDirty() && (bl || pSStudioServerLogBase.getDCCnt() != null)) {
            iDataObject.set(FIELD_DCCNT, (Object)pSStudioServerLogBase.getDCCnt());
        }
        if (pSStudioServerLogBase.isDefaultFlagDirty() && (bl || pSStudioServerLogBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSStudioServerLogBase.getDefaultFlag());
        }
        if (pSStudioServerLogBase.isFreeMemoryDirty() && (bl || pSStudioServerLogBase.getFreeMemory() != null)) {
            iDataObject.set(FIELD_FREEMEMORY, (Object)pSStudioServerLogBase.getFreeMemory());
        }
        if (pSStudioServerLogBase.isLogTimeDirty() && (bl || pSStudioServerLogBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSStudioServerLogBase.getLogTime());
        }
        if (pSStudioServerLogBase.isMaxMemoryDirty() && (bl || pSStudioServerLogBase.getMaxMemory() != null)) {
            iDataObject.set(FIELD_MAXMEMORY, (Object)pSStudioServerLogBase.getMaxMemory());
        }
        if (pSStudioServerLogBase.isPSStudioServerIdDirty() && (bl || pSStudioServerLogBase.getPSStudioServerId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERID, (Object)pSStudioServerLogBase.getPSStudioServerId());
        }
        if (pSStudioServerLogBase.isPSStudioServerLogIdDirty() && (bl || pSStudioServerLogBase.getPSStudioServerLogId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERLOGID, (Object)pSStudioServerLogBase.getPSStudioServerLogId());
        }
        if (pSStudioServerLogBase.isPSStudioServerLogNameDirty() && (bl || pSStudioServerLogBase.getPSStudioServerLogName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERLOGNAME, (Object)pSStudioServerLogBase.getPSStudioServerLogName());
        }
        if (pSStudioServerLogBase.isPSStudioServerNameDirty() && (bl || pSStudioServerLogBase.getPSStudioServerName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERNAME, (Object)pSStudioServerLogBase.getPSStudioServerName());
        }
        if (pSStudioServerLogBase.isSysModelCntDirty() && (bl || pSStudioServerLogBase.getSysModelCnt() != null)) {
            iDataObject.set(FIELD_SYSMODELCNT, (Object)pSStudioServerLogBase.getSysModelCnt());
        }
        if (pSStudioServerLogBase.isSysModelInstCntDirty() && (bl || pSStudioServerLogBase.getSysModelInstCnt() != null)) {
            iDataObject.set(FIELD_SYSMODELINSTCNT, (Object)pSStudioServerLogBase.getSysModelInstCnt());
        }
        if (pSStudioServerLogBase.isThreadCntDirty() && (bl || pSStudioServerLogBase.getThreadCnt() != null)) {
            iDataObject.set(FIELD_THREADCNT, (Object)pSStudioServerLogBase.getThreadCnt());
        }
        if (pSStudioServerLogBase.isTotalMemoryDirty() && (bl || pSStudioServerLogBase.getTotalMemory() != null)) {
            iDataObject.set(FIELD_TOTALMEMORY, (Object)pSStudioServerLogBase.getTotalMemory());
        }
        if (pSStudioServerLogBase.isUpdateDateDirty() && (bl || pSStudioServerLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioServerLogBase.getUpdateDate());
        }
        if (pSStudioServerLogBase.isUpdateManDirty() && (bl || pSStudioServerLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioServerLogBase.getUpdateMan());
        }
        if (pSStudioServerLogBase.isUserCntDirty() && (bl || pSStudioServerLogBase.getUserCnt() != null)) {
            iDataObject.set(FIELD_USERCNT, (Object)pSStudioServerLogBase.getUserCnt());
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
        return PSStudioServerLogBase.remove(this, n);
    }

    private static boolean remove(PSStudioServerLogBase pSStudioServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSStudioServerLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSStudioServerLogBase.resetDCCnt();
                return true;
            }
            case 3: {
                pSStudioServerLogBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSStudioServerLogBase.resetFreeMemory();
                return true;
            }
            case 5: {
                pSStudioServerLogBase.resetLogTime();
                return true;
            }
            case 6: {
                pSStudioServerLogBase.resetMaxMemory();
                return true;
            }
            case 7: {
                pSStudioServerLogBase.resetPSStudioServerId();
                return true;
            }
            case 8: {
                pSStudioServerLogBase.resetPSStudioServerLogId();
                return true;
            }
            case 9: {
                pSStudioServerLogBase.resetPSStudioServerLogName();
                return true;
            }
            case 10: {
                pSStudioServerLogBase.resetPSStudioServerName();
                return true;
            }
            case 11: {
                pSStudioServerLogBase.resetSysModelCnt();
                return true;
            }
            case 12: {
                pSStudioServerLogBase.resetSysModelInstCnt();
                return true;
            }
            case 13: {
                pSStudioServerLogBase.resetThreadCnt();
                return true;
            }
            case 14: {
                pSStudioServerLogBase.resetTotalMemory();
                return true;
            }
            case 15: {
                pSStudioServerLogBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSStudioServerLogBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSStudioServerLogBase.resetUserCnt();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioServer getPSStudioServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServer();
        }
        if (this.getPSStudioServerId() == null) {
            return null;
        }
        Integer n = this.objPSStudioServerLock;
        synchronized (n) {
            if (this.psstudioserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioServerId(), (Object)this.psstudioserver.getPSStudioServerId()) != 0L) {
                this.psstudioserver = null;
            }
            if (this.psstudioserver == null) {
                PSStudioServer pSStudioServer = new PSStudioServer();
                pSStudioServer.setPSStudioServerId(this.getPSStudioServerId());
                PSStudioServerService pSStudioServerService = (PSStudioServerService)ServiceGlobal.getService(PSStudioServerService.class, (SessionFactory)this.getSessionFactory());
                pSStudioServerService.autoGet((IEntity)pSStudioServer);
                this.psstudioserver = pSStudioServer;
            }
            return this.psstudioserver;
        }
    }

    private PSStudioServerLogBase getProxyEntity() {
        return this.proxyPSStudioServerLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioServerLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioServerLogBase) {
            this.proxyPSStudioServerLogBase = (PSStudioServerLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DCCNT, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_FREEMEMORY, 4);
        fieldIndexMap.put(FIELD_LOGTIME, 5);
        fieldIndexMap.put(FIELD_MAXMEMORY, 6);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERID, 7);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERLOGID, 8);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERLOGNAME, 9);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERNAME, 10);
        fieldIndexMap.put(FIELD_SYSMODELCNT, 11);
        fieldIndexMap.put(FIELD_SYSMODELINSTCNT, 12);
        fieldIndexMap.put(FIELD_THREADCNT, 13);
        fieldIndexMap.put(FIELD_TOTALMEMORY, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCNT, 17);
    }
}

