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
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTaskServerLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSTaskServerLogBase.class);
    public static final String FIELD_ASBOOKINGQUEUECNT = "ASBOOKINGQUEUECNT";
    public static final String FIELD_ASBOOKINGQUEUECNT2 = "ASBOOKINGQUEUECNT2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBDEVINSTCNT = "DBDEVINSTCNT";
    public static final String FIELD_DCCNT = "DCCNT";
    public static final String FIELD_DCTASKQUEUECNT = "DCTASKQUEUECNT";
    public static final String FIELD_DCTASKQUEUECNT2 = "DCTASKQUEUECNT2";
    public static final String FIELD_DCTASKQUEUECNT3 = "DCTASKQUEUECNT3";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DSBOOKINGQUEUECNT = "DSBOOKINGQUEUECNT";
    public static final String FIELD_DSBOOKINGQUEUECNT2 = "DSBOOKINGQUEUECNT2";
    public static final String FIELD_FREEMEMORY = "FREEMEMORY";
    public static final String FIELD_JITSYSCNT = "JITSYSCNT";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_MAXMEMORY = "MAXMEMORY";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERLOGID = "PSTASKSERVERLOGID";
    public static final String FIELD_PSTASKSERVERLOGNAME = "PSTASKSERVERLOGNAME";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_ROBOTCNT = "ROBOTCNT";
    public static final String FIELD_SYSMODELCNT = "SYSMODELCNT";
    public static final String FIELD_SYSMODELHELPERCNT = "SYSMODELHELPERCNT";
    public static final String FIELD_SYSMODELINSTCNT = "SYSMODELINSTCNT";
    public static final String FIELD_SYSTASKQUEUECNT = "SYSTASKQUEUECNT";
    public static final String FIELD_SYSTASKQUEUECNT2 = "SYSTASKQUEUECNT2";
    public static final String FIELD_SYSTASKQUEUECNT3 = "SYSTASKQUEUECNT3";
    public static final String FIELD_THREADCNT = "THREADCNT";
    public static final String FIELD_TOTALMEMORY = "TOTALMEMORY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ASBOOKINGQUEUECNT = 0;
    private static final int INDEX_ASBOOKINGQUEUECNT2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DBDEVINSTCNT = 4;
    private static final int INDEX_DCCNT = 5;
    private static final int INDEX_DCTASKQUEUECNT = 6;
    private static final int INDEX_DCTASKQUEUECNT2 = 7;
    private static final int INDEX_DCTASKQUEUECNT3 = 8;
    private static final int INDEX_DEFAULTFLAG = 9;
    private static final int INDEX_DSBOOKINGQUEUECNT = 10;
    private static final int INDEX_DSBOOKINGQUEUECNT2 = 11;
    private static final int INDEX_FREEMEMORY = 12;
    private static final int INDEX_JITSYSCNT = 13;
    private static final int INDEX_LOGTIME = 14;
    private static final int INDEX_MAXMEMORY = 15;
    private static final int INDEX_PSTASKSERVERID = 16;
    private static final int INDEX_PSTASKSERVERLOGID = 17;
    private static final int INDEX_PSTASKSERVERLOGNAME = 18;
    private static final int INDEX_PSTASKSERVERNAME = 19;
    private static final int INDEX_ROBOTCNT = 20;
    private static final int INDEX_SYSMODELCNT = 21;
    private static final int INDEX_SYSMODELHELPERCNT = 22;
    private static final int INDEX_SYSMODELINSTCNT = 23;
    private static final int INDEX_SYSTASKQUEUECNT = 24;
    private static final int INDEX_SYSTASKQUEUECNT2 = 25;
    private static final int INDEX_SYSTASKQUEUECNT3 = 26;
    private static final int INDEX_THREADCNT = 27;
    private static final int INDEX_TOTALMEMORY = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSTaskServerLogBase proxyPSTaskServerLogBase = null;
    private boolean asbookingqueuecntDirtyFlag = false;
    private boolean asbookingqueuecnt2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbdevinstcntDirtyFlag = false;
    private boolean dccntDirtyFlag = false;
    private boolean dctaskqueuecntDirtyFlag = false;
    private boolean dctaskqueuecnt2DirtyFlag = false;
    private boolean dctaskqueuecnt3DirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dsbookingqueuecntDirtyFlag = false;
    private boolean dsbookingqueuecnt2DirtyFlag = false;
    private boolean freememoryDirtyFlag = false;
    private boolean jitsyscntDirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean maxmemoryDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskserverlogidDirtyFlag = false;
    private boolean pstaskserverlognameDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean robotcntDirtyFlag = false;
    private boolean sysmodelcntDirtyFlag = false;
    private boolean sysmodelhelpercntDirtyFlag = false;
    private boolean sysmodelinstcntDirtyFlag = false;
    private boolean systaskqueuecntDirtyFlag = false;
    private boolean systaskqueuecnt2DirtyFlag = false;
    private boolean systaskqueuecnt3DirtyFlag = false;
    private boolean threadcntDirtyFlag = false;
    private boolean totalmemoryDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="asbookingqueuecnt")
    private Integer asbookingqueuecnt;
    @Column(name="asbookingqueuecnt2")
    private Integer asbookingqueuecnt2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbdevinstcnt")
    private Integer dbdevinstcnt;
    @Column(name="dccnt")
    private Integer dccnt;
    @Column(name="dctaskqueuecnt")
    private Integer dctaskqueuecnt;
    @Column(name="dctaskqueuecnt2")
    private Integer dctaskqueuecnt2;
    @Column(name="dctaskqueuecnt3")
    private Integer dctaskqueuecnt3;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dsbookingqueuecnt")
    private Integer dsbookingqueuecnt;
    @Column(name="dsbookingqueuecnt2")
    private Integer dsbookingqueuecnt2;
    @Column(name="freememory")
    private Integer freememory;
    @Column(name="jitsyscnt")
    private Integer jitsyscnt;
    @Column(name="logtime")
    private Timestamp logtime;
    @Column(name="maxmemory")
    private Integer maxmemory;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskserverlogid")
    private String pstaskserverlogid;
    @Column(name="pstaskserverlogname")
    private String pstaskserverlogname;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="robotcnt")
    private Integer robotcnt;
    @Column(name="sysmodelcnt")
    private Integer sysmodelcnt;
    @Column(name="sysmodelhelpercnt")
    private Integer sysmodelhelpercnt;
    @Column(name="sysmodelinstcnt")
    private Integer sysmodelinstcnt;
    @Column(name="systaskqueuecnt")
    private Integer systaskqueuecnt;
    @Column(name="systaskqueuecnt2")
    private Integer systaskqueuecnt2;
    @Column(name="systaskqueuecnt3")
    private Integer systaskqueuecnt3;
    @Column(name="threadcnt")
    private Integer threadcnt;
    @Column(name="totalmemory")
    private Integer totalmemory;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

    public void setASBookingQueueCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASBookingQueueCnt(n);
            return;
        }
        this.asbookingqueuecnt = n;
        this.asbookingqueuecntDirtyFlag = true;
    }

    public Integer getASBookingQueueCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASBookingQueueCnt();
        }
        return this.asbookingqueuecnt;
    }

    public boolean isASBookingQueueCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASBookingQueueCntDirty();
        }
        return this.asbookingqueuecntDirtyFlag;
    }

    public void resetASBookingQueueCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASBookingQueueCnt();
            return;
        }
        this.asbookingqueuecntDirtyFlag = false;
        this.asbookingqueuecnt = null;
    }

    public void setASBookingQueueCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASBookingQueueCnt2(n);
            return;
        }
        this.asbookingqueuecnt2 = n;
        this.asbookingqueuecnt2DirtyFlag = true;
    }

    public Integer getASBookingQueueCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASBookingQueueCnt2();
        }
        return this.asbookingqueuecnt2;
    }

    public boolean isASBookingQueueCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASBookingQueueCnt2Dirty();
        }
        return this.asbookingqueuecnt2DirtyFlag;
    }

    public void resetASBookingQueueCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASBookingQueueCnt2();
            return;
        }
        this.asbookingqueuecnt2DirtyFlag = false;
        this.asbookingqueuecnt2 = null;
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

    public void setDBDevInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBDevInstCnt(n);
            return;
        }
        this.dbdevinstcnt = n;
        this.dbdevinstcntDirtyFlag = true;
    }

    public Integer getDBDevInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBDevInstCnt();
        }
        return this.dbdevinstcnt;
    }

    public boolean isDBDevInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBDevInstCntDirty();
        }
        return this.dbdevinstcntDirtyFlag;
    }

    public void resetDBDevInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBDevInstCnt();
            return;
        }
        this.dbdevinstcntDirtyFlag = false;
        this.dbdevinstcnt = null;
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

    public void setDCTaskQueueCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTaskQueueCnt(n);
            return;
        }
        this.dctaskqueuecnt = n;
        this.dctaskqueuecntDirtyFlag = true;
    }

    public Integer getDCTaskQueueCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTaskQueueCnt();
        }
        return this.dctaskqueuecnt;
    }

    public boolean isDCTaskQueueCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTaskQueueCntDirty();
        }
        return this.dctaskqueuecntDirtyFlag;
    }

    public void resetDCTaskQueueCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTaskQueueCnt();
            return;
        }
        this.dctaskqueuecntDirtyFlag = false;
        this.dctaskqueuecnt = null;
    }

    public void setDCTaskQueueCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTaskQueueCnt2(n);
            return;
        }
        this.dctaskqueuecnt2 = n;
        this.dctaskqueuecnt2DirtyFlag = true;
    }

    public Integer getDCTaskQueueCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTaskQueueCnt2();
        }
        return this.dctaskqueuecnt2;
    }

    public boolean isDCTaskQueueCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTaskQueueCnt2Dirty();
        }
        return this.dctaskqueuecnt2DirtyFlag;
    }

    public void resetDCTaskQueueCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTaskQueueCnt2();
            return;
        }
        this.dctaskqueuecnt2DirtyFlag = false;
        this.dctaskqueuecnt2 = null;
    }

    public void setDCTaskQueueCnt3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCTaskQueueCnt3(n);
            return;
        }
        this.dctaskqueuecnt3 = n;
        this.dctaskqueuecnt3DirtyFlag = true;
    }

    public Integer getDCTaskQueueCnt3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCTaskQueueCnt3();
        }
        return this.dctaskqueuecnt3;
    }

    public boolean isDCTaskQueueCnt3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTaskQueueCnt3Dirty();
        }
        return this.dctaskqueuecnt3DirtyFlag;
    }

    public void resetDCTaskQueueCnt3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCTaskQueueCnt3();
            return;
        }
        this.dctaskqueuecnt3DirtyFlag = false;
        this.dctaskqueuecnt3 = null;
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

    public void setDSBookingQueueCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSBookingQueueCnt(n);
            return;
        }
        this.dsbookingqueuecnt = n;
        this.dsbookingqueuecntDirtyFlag = true;
    }

    public Integer getDSBookingQueueCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSBookingQueueCnt();
        }
        return this.dsbookingqueuecnt;
    }

    public boolean isDSBookingQueueCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSBookingQueueCntDirty();
        }
        return this.dsbookingqueuecntDirtyFlag;
    }

    public void resetDSBookingQueueCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSBookingQueueCnt();
            return;
        }
        this.dsbookingqueuecntDirtyFlag = false;
        this.dsbookingqueuecnt = null;
    }

    public void setDSBookingQueueCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSBookingQueueCnt2(n);
            return;
        }
        this.dsbookingqueuecnt2 = n;
        this.dsbookingqueuecnt2DirtyFlag = true;
    }

    public Integer getDSBookingQueueCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSBookingQueueCnt2();
        }
        return this.dsbookingqueuecnt2;
    }

    public boolean isDSBookingQueueCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSBookingQueueCnt2Dirty();
        }
        return this.dsbookingqueuecnt2DirtyFlag;
    }

    public void resetDSBookingQueueCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSBookingQueueCnt2();
            return;
        }
        this.dsbookingqueuecnt2DirtyFlag = false;
        this.dsbookingqueuecnt2 = null;
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

    public void setJITSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITSysCnt(n);
            return;
        }
        this.jitsyscnt = n;
        this.jitsyscntDirtyFlag = true;
    }

    public Integer getJITSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITSysCnt();
        }
        return this.jitsyscnt;
    }

    public boolean isJITSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITSysCntDirty();
        }
        return this.jitsyscntDirtyFlag;
    }

    public void resetJITSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITSysCnt();
            return;
        }
        this.jitsyscntDirtyFlag = false;
        this.jitsyscnt = null;
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

    public void setPSTaskServerLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverlogid = string;
        this.pstaskserverlogidDirtyFlag = true;
    }

    public String getPSTaskServerLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerLogId();
        }
        return this.pstaskserverlogid;
    }

    public boolean isPSTaskServerLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerLogIdDirty();
        }
        return this.pstaskserverlogidDirtyFlag;
    }

    public void resetPSTaskServerLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerLogId();
            return;
        }
        this.pstaskserverlogidDirtyFlag = false;
        this.pstaskserverlogid = null;
    }

    public void setPSTaskServerLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverlogname = string;
        this.pstaskserverlognameDirtyFlag = true;
    }

    public String getPSTaskServerLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerLogName();
        }
        return this.pstaskserverlogname;
    }

    public boolean isPSTaskServerLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerLogNameDirty();
        }
        return this.pstaskserverlognameDirtyFlag;
    }

    public void resetPSTaskServerLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerLogName();
            return;
        }
        this.pstaskserverlognameDirtyFlag = false;
        this.pstaskserverlogname = null;
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

    public void setRobotCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotCnt(n);
            return;
        }
        this.robotcnt = n;
        this.robotcntDirtyFlag = true;
    }

    public Integer getRobotCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotCnt();
        }
        return this.robotcnt;
    }

    public boolean isRobotCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotCntDirty();
        }
        return this.robotcntDirtyFlag;
    }

    public void resetRobotCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotCnt();
            return;
        }
        this.robotcntDirtyFlag = false;
        this.robotcnt = null;
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

    public void setSysModelHelperCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelHelperCnt(n);
            return;
        }
        this.sysmodelhelpercnt = n;
        this.sysmodelhelpercntDirtyFlag = true;
    }

    public Integer getSysModelHelperCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelHelperCnt();
        }
        return this.sysmodelhelpercnt;
    }

    public boolean isSysModelHelperCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelHelperCntDirty();
        }
        return this.sysmodelhelpercntDirtyFlag;
    }

    public void resetSysModelHelperCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelHelperCnt();
            return;
        }
        this.sysmodelhelpercntDirtyFlag = false;
        this.sysmodelhelpercnt = null;
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

    public void setSysTaskQueueCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTaskQueueCnt(n);
            return;
        }
        this.systaskqueuecnt = n;
        this.systaskqueuecntDirtyFlag = true;
    }

    public Integer getSysTaskQueueCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTaskQueueCnt();
        }
        return this.systaskqueuecnt;
    }

    public boolean isSysTaskQueueCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTaskQueueCntDirty();
        }
        return this.systaskqueuecntDirtyFlag;
    }

    public void resetSysTaskQueueCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTaskQueueCnt();
            return;
        }
        this.systaskqueuecntDirtyFlag = false;
        this.systaskqueuecnt = null;
    }

    public void setSysTaskQueueCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTaskQueueCnt2(n);
            return;
        }
        this.systaskqueuecnt2 = n;
        this.systaskqueuecnt2DirtyFlag = true;
    }

    public Integer getSysTaskQueueCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTaskQueueCnt2();
        }
        return this.systaskqueuecnt2;
    }

    public boolean isSysTaskQueueCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTaskQueueCnt2Dirty();
        }
        return this.systaskqueuecnt2DirtyFlag;
    }

    public void resetSysTaskQueueCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTaskQueueCnt2();
            return;
        }
        this.systaskqueuecnt2DirtyFlag = false;
        this.systaskqueuecnt2 = null;
    }

    public void setSysTaskQueueCnt3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTaskQueueCnt3(n);
            return;
        }
        this.systaskqueuecnt3 = n;
        this.systaskqueuecnt3DirtyFlag = true;
    }

    public Integer getSysTaskQueueCnt3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTaskQueueCnt3();
        }
        return this.systaskqueuecnt3;
    }

    public boolean isSysTaskQueueCnt3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTaskQueueCnt3Dirty();
        }
        return this.systaskqueuecnt3DirtyFlag;
    }

    public void resetSysTaskQueueCnt3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTaskQueueCnt3();
            return;
        }
        this.systaskqueuecnt3DirtyFlag = false;
        this.systaskqueuecnt3 = null;
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

    protected void onReset() {
        PSTaskServerLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSTaskServerLogBase pSTaskServerLogBase) {
        pSTaskServerLogBase.resetASBookingQueueCnt();
        pSTaskServerLogBase.resetASBookingQueueCnt2();
        pSTaskServerLogBase.resetCreateDate();
        pSTaskServerLogBase.resetCreateMan();
        pSTaskServerLogBase.resetDBDevInstCnt();
        pSTaskServerLogBase.resetDCCnt();
        pSTaskServerLogBase.resetDCTaskQueueCnt();
        pSTaskServerLogBase.resetDCTaskQueueCnt2();
        pSTaskServerLogBase.resetDCTaskQueueCnt3();
        pSTaskServerLogBase.resetDefaultFlag();
        pSTaskServerLogBase.resetDSBookingQueueCnt();
        pSTaskServerLogBase.resetDSBookingQueueCnt2();
        pSTaskServerLogBase.resetFreeMemory();
        pSTaskServerLogBase.resetJITSysCnt();
        pSTaskServerLogBase.resetLogTime();
        pSTaskServerLogBase.resetMaxMemory();
        pSTaskServerLogBase.resetPSTaskServerId();
        pSTaskServerLogBase.resetPSTaskServerLogId();
        pSTaskServerLogBase.resetPSTaskServerLogName();
        pSTaskServerLogBase.resetPSTaskServerName();
        pSTaskServerLogBase.resetRobotCnt();
        pSTaskServerLogBase.resetSysModelCnt();
        pSTaskServerLogBase.resetSysModelHelperCnt();
        pSTaskServerLogBase.resetSysModelInstCnt();
        pSTaskServerLogBase.resetSysTaskQueueCnt();
        pSTaskServerLogBase.resetSysTaskQueueCnt2();
        pSTaskServerLogBase.resetSysTaskQueueCnt3();
        pSTaskServerLogBase.resetThreadCnt();
        pSTaskServerLogBase.resetTotalMemory();
        pSTaskServerLogBase.resetUpdateDate();
        pSTaskServerLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASBookingQueueCntDirty()) {
            hashMap.put(FIELD_ASBOOKINGQUEUECNT, this.getASBookingQueueCnt());
        }
        if (!bl || this.isASBookingQueueCnt2Dirty()) {
            hashMap.put(FIELD_ASBOOKINGQUEUECNT2, this.getASBookingQueueCnt2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBDevInstCntDirty()) {
            hashMap.put(FIELD_DBDEVINSTCNT, this.getDBDevInstCnt());
        }
        if (!bl || this.isDCCntDirty()) {
            hashMap.put(FIELD_DCCNT, this.getDCCnt());
        }
        if (!bl || this.isDCTaskQueueCntDirty()) {
            hashMap.put(FIELD_DCTASKQUEUECNT, this.getDCTaskQueueCnt());
        }
        if (!bl || this.isDCTaskQueueCnt2Dirty()) {
            hashMap.put(FIELD_DCTASKQUEUECNT2, this.getDCTaskQueueCnt2());
        }
        if (!bl || this.isDCTaskQueueCnt3Dirty()) {
            hashMap.put(FIELD_DCTASKQUEUECNT3, this.getDCTaskQueueCnt3());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDSBookingQueueCntDirty()) {
            hashMap.put(FIELD_DSBOOKINGQUEUECNT, this.getDSBookingQueueCnt());
        }
        if (!bl || this.isDSBookingQueueCnt2Dirty()) {
            hashMap.put(FIELD_DSBOOKINGQUEUECNT2, this.getDSBookingQueueCnt2());
        }
        if (!bl || this.isFreeMemoryDirty()) {
            hashMap.put(FIELD_FREEMEMORY, this.getFreeMemory());
        }
        if (!bl || this.isJITSysCntDirty()) {
            hashMap.put(FIELD_JITSYSCNT, this.getJITSysCnt());
        }
        if (!bl || this.isLogTimeDirty()) {
            hashMap.put(FIELD_LOGTIME, this.getLogTime());
        }
        if (!bl || this.isMaxMemoryDirty()) {
            hashMap.put(FIELD_MAXMEMORY, this.getMaxMemory());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerLogIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERLOGID, this.getPSTaskServerLogId());
        }
        if (!bl || this.isPSTaskServerLogNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERLOGNAME, this.getPSTaskServerLogName());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isRobotCntDirty()) {
            hashMap.put(FIELD_ROBOTCNT, this.getRobotCnt());
        }
        if (!bl || this.isSysModelCntDirty()) {
            hashMap.put(FIELD_SYSMODELCNT, this.getSysModelCnt());
        }
        if (!bl || this.isSysModelHelperCntDirty()) {
            hashMap.put(FIELD_SYSMODELHELPERCNT, this.getSysModelHelperCnt());
        }
        if (!bl || this.isSysModelInstCntDirty()) {
            hashMap.put(FIELD_SYSMODELINSTCNT, this.getSysModelInstCnt());
        }
        if (!bl || this.isSysTaskQueueCntDirty()) {
            hashMap.put(FIELD_SYSTASKQUEUECNT, this.getSysTaskQueueCnt());
        }
        if (!bl || this.isSysTaskQueueCnt2Dirty()) {
            hashMap.put(FIELD_SYSTASKQUEUECNT2, this.getSysTaskQueueCnt2());
        }
        if (!bl || this.isSysTaskQueueCnt3Dirty()) {
            hashMap.put(FIELD_SYSTASKQUEUECNT3, this.getSysTaskQueueCnt3());
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
        return PSTaskServerLogBase.get(this, n);
    }

    private static Object get(PSTaskServerLogBase pSTaskServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerLogBase.getASBookingQueueCnt();
            }
            case 1: {
                return pSTaskServerLogBase.getASBookingQueueCnt2();
            }
            case 2: {
                return pSTaskServerLogBase.getCreateDate();
            }
            case 3: {
                return pSTaskServerLogBase.getCreateMan();
            }
            case 4: {
                return pSTaskServerLogBase.getDBDevInstCnt();
            }
            case 5: {
                return pSTaskServerLogBase.getDCCnt();
            }
            case 6: {
                return pSTaskServerLogBase.getDCTaskQueueCnt();
            }
            case 7: {
                return pSTaskServerLogBase.getDCTaskQueueCnt2();
            }
            case 8: {
                return pSTaskServerLogBase.getDCTaskQueueCnt3();
            }
            case 9: {
                return pSTaskServerLogBase.getDefaultFlag();
            }
            case 10: {
                return pSTaskServerLogBase.getDSBookingQueueCnt();
            }
            case 11: {
                return pSTaskServerLogBase.getDSBookingQueueCnt2();
            }
            case 12: {
                return pSTaskServerLogBase.getFreeMemory();
            }
            case 13: {
                return pSTaskServerLogBase.getJITSysCnt();
            }
            case 14: {
                return pSTaskServerLogBase.getLogTime();
            }
            case 15: {
                return pSTaskServerLogBase.getMaxMemory();
            }
            case 16: {
                return pSTaskServerLogBase.getPSTaskServerId();
            }
            case 17: {
                return pSTaskServerLogBase.getPSTaskServerLogId();
            }
            case 18: {
                return pSTaskServerLogBase.getPSTaskServerLogName();
            }
            case 19: {
                return pSTaskServerLogBase.getPSTaskServerName();
            }
            case 20: {
                return pSTaskServerLogBase.getRobotCnt();
            }
            case 21: {
                return pSTaskServerLogBase.getSysModelCnt();
            }
            case 22: {
                return pSTaskServerLogBase.getSysModelHelperCnt();
            }
            case 23: {
                return pSTaskServerLogBase.getSysModelInstCnt();
            }
            case 24: {
                return pSTaskServerLogBase.getSysTaskQueueCnt();
            }
            case 25: {
                return pSTaskServerLogBase.getSysTaskQueueCnt2();
            }
            case 26: {
                return pSTaskServerLogBase.getSysTaskQueueCnt3();
            }
            case 27: {
                return pSTaskServerLogBase.getThreadCnt();
            }
            case 28: {
                return pSTaskServerLogBase.getTotalMemory();
            }
            case 29: {
                return pSTaskServerLogBase.getUpdateDate();
            }
            case 30: {
                return pSTaskServerLogBase.getUpdateMan();
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
        PSTaskServerLogBase.set(this, n, object);
    }

    private static void set(PSTaskServerLogBase pSTaskServerLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSTaskServerLogBase.setASBookingQueueCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSTaskServerLogBase.setASBookingQueueCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSTaskServerLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSTaskServerLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSTaskServerLogBase.setDBDevInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSTaskServerLogBase.setDCCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSTaskServerLogBase.setDCTaskQueueCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSTaskServerLogBase.setDCTaskQueueCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSTaskServerLogBase.setDCTaskQueueCnt3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSTaskServerLogBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSTaskServerLogBase.setDSBookingQueueCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSTaskServerLogBase.setDSBookingQueueCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSTaskServerLogBase.setFreeMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSTaskServerLogBase.setJITSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSTaskServerLogBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSTaskServerLogBase.setMaxMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSTaskServerLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSTaskServerLogBase.setPSTaskServerLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSTaskServerLogBase.setPSTaskServerLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSTaskServerLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSTaskServerLogBase.setRobotCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSTaskServerLogBase.setSysModelCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSTaskServerLogBase.setSysModelHelperCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSTaskServerLogBase.setSysModelInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSTaskServerLogBase.setSysTaskQueueCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSTaskServerLogBase.setSysTaskQueueCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSTaskServerLogBase.setSysTaskQueueCnt3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSTaskServerLogBase.setThreadCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSTaskServerLogBase.setTotalMemory(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSTaskServerLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSTaskServerLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSTaskServerLogBase.isNull(this, n);
    }

    private static boolean isNull(PSTaskServerLogBase pSTaskServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerLogBase.getASBookingQueueCnt() == null;
            }
            case 1: {
                return pSTaskServerLogBase.getASBookingQueueCnt2() == null;
            }
            case 2: {
                return pSTaskServerLogBase.getCreateDate() == null;
            }
            case 3: {
                return pSTaskServerLogBase.getCreateMan() == null;
            }
            case 4: {
                return pSTaskServerLogBase.getDBDevInstCnt() == null;
            }
            case 5: {
                return pSTaskServerLogBase.getDCCnt() == null;
            }
            case 6: {
                return pSTaskServerLogBase.getDCTaskQueueCnt() == null;
            }
            case 7: {
                return pSTaskServerLogBase.getDCTaskQueueCnt2() == null;
            }
            case 8: {
                return pSTaskServerLogBase.getDCTaskQueueCnt3() == null;
            }
            case 9: {
                return pSTaskServerLogBase.getDefaultFlag() == null;
            }
            case 10: {
                return pSTaskServerLogBase.getDSBookingQueueCnt() == null;
            }
            case 11: {
                return pSTaskServerLogBase.getDSBookingQueueCnt2() == null;
            }
            case 12: {
                return pSTaskServerLogBase.getFreeMemory() == null;
            }
            case 13: {
                return pSTaskServerLogBase.getJITSysCnt() == null;
            }
            case 14: {
                return pSTaskServerLogBase.getLogTime() == null;
            }
            case 15: {
                return pSTaskServerLogBase.getMaxMemory() == null;
            }
            case 16: {
                return pSTaskServerLogBase.getPSTaskServerId() == null;
            }
            case 17: {
                return pSTaskServerLogBase.getPSTaskServerLogId() == null;
            }
            case 18: {
                return pSTaskServerLogBase.getPSTaskServerLogName() == null;
            }
            case 19: {
                return pSTaskServerLogBase.getPSTaskServerName() == null;
            }
            case 20: {
                return pSTaskServerLogBase.getRobotCnt() == null;
            }
            case 21: {
                return pSTaskServerLogBase.getSysModelCnt() == null;
            }
            case 22: {
                return pSTaskServerLogBase.getSysModelHelperCnt() == null;
            }
            case 23: {
                return pSTaskServerLogBase.getSysModelInstCnt() == null;
            }
            case 24: {
                return pSTaskServerLogBase.getSysTaskQueueCnt() == null;
            }
            case 25: {
                return pSTaskServerLogBase.getSysTaskQueueCnt2() == null;
            }
            case 26: {
                return pSTaskServerLogBase.getSysTaskQueueCnt3() == null;
            }
            case 27: {
                return pSTaskServerLogBase.getThreadCnt() == null;
            }
            case 28: {
                return pSTaskServerLogBase.getTotalMemory() == null;
            }
            case 29: {
                return pSTaskServerLogBase.getUpdateDate() == null;
            }
            case 30: {
                return pSTaskServerLogBase.getUpdateMan() == null;
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
        return PSTaskServerLogBase.contains(this, n);
    }

    private static boolean contains(PSTaskServerLogBase pSTaskServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerLogBase.isASBookingQueueCntDirty();
            }
            case 1: {
                return pSTaskServerLogBase.isASBookingQueueCnt2Dirty();
            }
            case 2: {
                return pSTaskServerLogBase.isCreateDateDirty();
            }
            case 3: {
                return pSTaskServerLogBase.isCreateManDirty();
            }
            case 4: {
                return pSTaskServerLogBase.isDBDevInstCntDirty();
            }
            case 5: {
                return pSTaskServerLogBase.isDCCntDirty();
            }
            case 6: {
                return pSTaskServerLogBase.isDCTaskQueueCntDirty();
            }
            case 7: {
                return pSTaskServerLogBase.isDCTaskQueueCnt2Dirty();
            }
            case 8: {
                return pSTaskServerLogBase.isDCTaskQueueCnt3Dirty();
            }
            case 9: {
                return pSTaskServerLogBase.isDefaultFlagDirty();
            }
            case 10: {
                return pSTaskServerLogBase.isDSBookingQueueCntDirty();
            }
            case 11: {
                return pSTaskServerLogBase.isDSBookingQueueCnt2Dirty();
            }
            case 12: {
                return pSTaskServerLogBase.isFreeMemoryDirty();
            }
            case 13: {
                return pSTaskServerLogBase.isJITSysCntDirty();
            }
            case 14: {
                return pSTaskServerLogBase.isLogTimeDirty();
            }
            case 15: {
                return pSTaskServerLogBase.isMaxMemoryDirty();
            }
            case 16: {
                return pSTaskServerLogBase.isPSTaskServerIdDirty();
            }
            case 17: {
                return pSTaskServerLogBase.isPSTaskServerLogIdDirty();
            }
            case 18: {
                return pSTaskServerLogBase.isPSTaskServerLogNameDirty();
            }
            case 19: {
                return pSTaskServerLogBase.isPSTaskServerNameDirty();
            }
            case 20: {
                return pSTaskServerLogBase.isRobotCntDirty();
            }
            case 21: {
                return pSTaskServerLogBase.isSysModelCntDirty();
            }
            case 22: {
                return pSTaskServerLogBase.isSysModelHelperCntDirty();
            }
            case 23: {
                return pSTaskServerLogBase.isSysModelInstCntDirty();
            }
            case 24: {
                return pSTaskServerLogBase.isSysTaskQueueCntDirty();
            }
            case 25: {
                return pSTaskServerLogBase.isSysTaskQueueCnt2Dirty();
            }
            case 26: {
                return pSTaskServerLogBase.isSysTaskQueueCnt3Dirty();
            }
            case 27: {
                return pSTaskServerLogBase.isThreadCntDirty();
            }
            case 28: {
                return pSTaskServerLogBase.isTotalMemoryDirty();
            }
            case 29: {
                return pSTaskServerLogBase.isUpdateDateDirty();
            }
            case 30: {
                return pSTaskServerLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSTaskServerLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSTaskServerLogBase pSTaskServerLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSTaskServerLogBase.getASBookingQueueCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asbookingqueuecnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getASBookingQueueCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getASBookingQueueCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asbookingqueuecnt2", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getASBookingQueueCnt2()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDBDevInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbdevinstcnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDBDevInstCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDCCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dccnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDCCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctaskqueuecnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDCTaskQueueCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctaskqueuecnt2", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDCTaskQueueCnt2()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctaskqueuecnt3", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDCTaskQueueCnt3()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDSBookingQueueCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsbookingqueuecnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDSBookingQueueCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getDSBookingQueueCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsbookingqueuecnt2", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getDSBookingQueueCnt2()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getFreeMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"freememory", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getFreeMemory()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getJITSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitsyscnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getJITSysCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getLogTime()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getMaxMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmemory", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getMaxMemory()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverlogid", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getPSTaskServerLogId()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverlogname", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getPSTaskServerLogName()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getRobotCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotcnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getRobotCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysModelCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelcnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysModelCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysModelHelperCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelhelpercnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysModelHelperCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysModelInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelinstcnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysModelInstCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systaskqueuecnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysTaskQueueCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systaskqueuecnt2", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysTaskQueueCnt2()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systaskqueuecnt3", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getSysTaskQueueCnt3()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getThreadCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadcnt", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getThreadCnt()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getTotalMemory() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalmemory", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getTotalMemory()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSTaskServerLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSTaskServerLogBase.getJSONValue((Object)pSTaskServerLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSTaskServerLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSTaskServerLogBase pSTaskServerLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSTaskServerLogBase.getASBookingQueueCnt() != null) {
            object = pSTaskServerLogBase.getASBookingQueueCnt();
            xmlNode.setAttribute(FIELD_ASBOOKINGQUEUECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getASBookingQueueCnt2() != null) {
            object = pSTaskServerLogBase.getASBookingQueueCnt2();
            xmlNode.setAttribute(FIELD_ASBOOKINGQUEUECNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getCreateDate() != null) {
            object = pSTaskServerLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getCreateMan() != null) {
            object = pSTaskServerLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerLogBase.getDBDevInstCnt() != null) {
            object = pSTaskServerLogBase.getDBDevInstCnt();
            xmlNode.setAttribute(FIELD_DBDEVINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDCCnt() != null) {
            object = pSTaskServerLogBase.getDCCnt();
            xmlNode.setAttribute(FIELD_DCCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt() != null) {
            object = pSTaskServerLogBase.getDCTaskQueueCnt();
            xmlNode.setAttribute(FIELD_DCTASKQUEUECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt2() != null) {
            object = pSTaskServerLogBase.getDCTaskQueueCnt2();
            xmlNode.setAttribute(FIELD_DCTASKQUEUECNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDCTaskQueueCnt3() != null) {
            object = pSTaskServerLogBase.getDCTaskQueueCnt3();
            xmlNode.setAttribute(FIELD_DCTASKQUEUECNT3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDefaultFlag() != null) {
            object = pSTaskServerLogBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDSBookingQueueCnt() != null) {
            object = pSTaskServerLogBase.getDSBookingQueueCnt();
            xmlNode.setAttribute(FIELD_DSBOOKINGQUEUECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getDSBookingQueueCnt2() != null) {
            object = pSTaskServerLogBase.getDSBookingQueueCnt2();
            xmlNode.setAttribute(FIELD_DSBOOKINGQUEUECNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getFreeMemory() != null) {
            object = pSTaskServerLogBase.getFreeMemory();
            xmlNode.setAttribute(FIELD_FREEMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getJITSysCnt() != null) {
            object = pSTaskServerLogBase.getJITSysCnt();
            xmlNode.setAttribute(FIELD_JITSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getLogTime() != null) {
            object = pSTaskServerLogBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getMaxMemory() != null) {
            object = pSTaskServerLogBase.getMaxMemory();
            xmlNode.setAttribute(FIELD_MAXMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerId() != null) {
            object = pSTaskServerLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerLogId() != null) {
            object = pSTaskServerLogBase.getPSTaskServerLogId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerLogName() != null) {
            object = pSTaskServerLogBase.getPSTaskServerLogName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerLogBase.getPSTaskServerName() != null) {
            object = pSTaskServerLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerLogBase.getRobotCnt() != null) {
            object = pSTaskServerLogBase.getRobotCnt();
            xmlNode.setAttribute(FIELD_ROBOTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysModelCnt() != null) {
            object = pSTaskServerLogBase.getSysModelCnt();
            xmlNode.setAttribute(FIELD_SYSMODELCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysModelHelperCnt() != null) {
            object = pSTaskServerLogBase.getSysModelHelperCnt();
            xmlNode.setAttribute(FIELD_SYSMODELHELPERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysModelInstCnt() != null) {
            object = pSTaskServerLogBase.getSysModelInstCnt();
            xmlNode.setAttribute(FIELD_SYSMODELINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt() != null) {
            object = pSTaskServerLogBase.getSysTaskQueueCnt();
            xmlNode.setAttribute(FIELD_SYSTASKQUEUECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt2() != null) {
            object = pSTaskServerLogBase.getSysTaskQueueCnt2();
            xmlNode.setAttribute(FIELD_SYSTASKQUEUECNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getSysTaskQueueCnt3() != null) {
            object = pSTaskServerLogBase.getSysTaskQueueCnt3();
            xmlNode.setAttribute(FIELD_SYSTASKQUEUECNT3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getThreadCnt() != null) {
            object = pSTaskServerLogBase.getThreadCnt();
            xmlNode.setAttribute(FIELD_THREADCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getTotalMemory() != null) {
            object = pSTaskServerLogBase.getTotalMemory();
            xmlNode.setAttribute(FIELD_TOTALMEMORY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getUpdateDate() != null) {
            object = pSTaskServerLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTaskServerLogBase.getUpdateMan() != null) {
            object = pSTaskServerLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSTaskServerLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSTaskServerLogBase pSTaskServerLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSTaskServerLogBase.isASBookingQueueCntDirty() && (bl || pSTaskServerLogBase.getASBookingQueueCnt() != null)) {
            iDataObject.set(FIELD_ASBOOKINGQUEUECNT, (Object)pSTaskServerLogBase.getASBookingQueueCnt());
        }
        if (pSTaskServerLogBase.isASBookingQueueCnt2Dirty() && (bl || pSTaskServerLogBase.getASBookingQueueCnt2() != null)) {
            iDataObject.set(FIELD_ASBOOKINGQUEUECNT2, (Object)pSTaskServerLogBase.getASBookingQueueCnt2());
        }
        if (pSTaskServerLogBase.isCreateDateDirty() && (bl || pSTaskServerLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSTaskServerLogBase.getCreateDate());
        }
        if (pSTaskServerLogBase.isCreateManDirty() && (bl || pSTaskServerLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSTaskServerLogBase.getCreateMan());
        }
        if (pSTaskServerLogBase.isDBDevInstCntDirty() && (bl || pSTaskServerLogBase.getDBDevInstCnt() != null)) {
            iDataObject.set(FIELD_DBDEVINSTCNT, (Object)pSTaskServerLogBase.getDBDevInstCnt());
        }
        if (pSTaskServerLogBase.isDCCntDirty() && (bl || pSTaskServerLogBase.getDCCnt() != null)) {
            iDataObject.set(FIELD_DCCNT, (Object)pSTaskServerLogBase.getDCCnt());
        }
        if (pSTaskServerLogBase.isDCTaskQueueCntDirty() && (bl || pSTaskServerLogBase.getDCTaskQueueCnt() != null)) {
            iDataObject.set(FIELD_DCTASKQUEUECNT, (Object)pSTaskServerLogBase.getDCTaskQueueCnt());
        }
        if (pSTaskServerLogBase.isDCTaskQueueCnt2Dirty() && (bl || pSTaskServerLogBase.getDCTaskQueueCnt2() != null)) {
            iDataObject.set(FIELD_DCTASKQUEUECNT2, (Object)pSTaskServerLogBase.getDCTaskQueueCnt2());
        }
        if (pSTaskServerLogBase.isDCTaskQueueCnt3Dirty() && (bl || pSTaskServerLogBase.getDCTaskQueueCnt3() != null)) {
            iDataObject.set(FIELD_DCTASKQUEUECNT3, (Object)pSTaskServerLogBase.getDCTaskQueueCnt3());
        }
        if (pSTaskServerLogBase.isDefaultFlagDirty() && (bl || pSTaskServerLogBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSTaskServerLogBase.getDefaultFlag());
        }
        if (pSTaskServerLogBase.isDSBookingQueueCntDirty() && (bl || pSTaskServerLogBase.getDSBookingQueueCnt() != null)) {
            iDataObject.set(FIELD_DSBOOKINGQUEUECNT, (Object)pSTaskServerLogBase.getDSBookingQueueCnt());
        }
        if (pSTaskServerLogBase.isDSBookingQueueCnt2Dirty() && (bl || pSTaskServerLogBase.getDSBookingQueueCnt2() != null)) {
            iDataObject.set(FIELD_DSBOOKINGQUEUECNT2, (Object)pSTaskServerLogBase.getDSBookingQueueCnt2());
        }
        if (pSTaskServerLogBase.isFreeMemoryDirty() && (bl || pSTaskServerLogBase.getFreeMemory() != null)) {
            iDataObject.set(FIELD_FREEMEMORY, (Object)pSTaskServerLogBase.getFreeMemory());
        }
        if (pSTaskServerLogBase.isJITSysCntDirty() && (bl || pSTaskServerLogBase.getJITSysCnt() != null)) {
            iDataObject.set(FIELD_JITSYSCNT, (Object)pSTaskServerLogBase.getJITSysCnt());
        }
        if (pSTaskServerLogBase.isLogTimeDirty() && (bl || pSTaskServerLogBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSTaskServerLogBase.getLogTime());
        }
        if (pSTaskServerLogBase.isMaxMemoryDirty() && (bl || pSTaskServerLogBase.getMaxMemory() != null)) {
            iDataObject.set(FIELD_MAXMEMORY, (Object)pSTaskServerLogBase.getMaxMemory());
        }
        if (pSTaskServerLogBase.isPSTaskServerIdDirty() && (bl || pSTaskServerLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSTaskServerLogBase.getPSTaskServerId());
        }
        if (pSTaskServerLogBase.isPSTaskServerLogIdDirty() && (bl || pSTaskServerLogBase.getPSTaskServerLogId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERLOGID, (Object)pSTaskServerLogBase.getPSTaskServerLogId());
        }
        if (pSTaskServerLogBase.isPSTaskServerLogNameDirty() && (bl || pSTaskServerLogBase.getPSTaskServerLogName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERLOGNAME, (Object)pSTaskServerLogBase.getPSTaskServerLogName());
        }
        if (pSTaskServerLogBase.isPSTaskServerNameDirty() && (bl || pSTaskServerLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSTaskServerLogBase.getPSTaskServerName());
        }
        if (pSTaskServerLogBase.isRobotCntDirty() && (bl || pSTaskServerLogBase.getRobotCnt() != null)) {
            iDataObject.set(FIELD_ROBOTCNT, (Object)pSTaskServerLogBase.getRobotCnt());
        }
        if (pSTaskServerLogBase.isSysModelCntDirty() && (bl || pSTaskServerLogBase.getSysModelCnt() != null)) {
            iDataObject.set(FIELD_SYSMODELCNT, (Object)pSTaskServerLogBase.getSysModelCnt());
        }
        if (pSTaskServerLogBase.isSysModelHelperCntDirty() && (bl || pSTaskServerLogBase.getSysModelHelperCnt() != null)) {
            iDataObject.set(FIELD_SYSMODELHELPERCNT, (Object)pSTaskServerLogBase.getSysModelHelperCnt());
        }
        if (pSTaskServerLogBase.isSysModelInstCntDirty() && (bl || pSTaskServerLogBase.getSysModelInstCnt() != null)) {
            iDataObject.set(FIELD_SYSMODELINSTCNT, (Object)pSTaskServerLogBase.getSysModelInstCnt());
        }
        if (pSTaskServerLogBase.isSysTaskQueueCntDirty() && (bl || pSTaskServerLogBase.getSysTaskQueueCnt() != null)) {
            iDataObject.set(FIELD_SYSTASKQUEUECNT, (Object)pSTaskServerLogBase.getSysTaskQueueCnt());
        }
        if (pSTaskServerLogBase.isSysTaskQueueCnt2Dirty() && (bl || pSTaskServerLogBase.getSysTaskQueueCnt2() != null)) {
            iDataObject.set(FIELD_SYSTASKQUEUECNT2, (Object)pSTaskServerLogBase.getSysTaskQueueCnt2());
        }
        if (pSTaskServerLogBase.isSysTaskQueueCnt3Dirty() && (bl || pSTaskServerLogBase.getSysTaskQueueCnt3() != null)) {
            iDataObject.set(FIELD_SYSTASKQUEUECNT3, (Object)pSTaskServerLogBase.getSysTaskQueueCnt3());
        }
        if (pSTaskServerLogBase.isThreadCntDirty() && (bl || pSTaskServerLogBase.getThreadCnt() != null)) {
            iDataObject.set(FIELD_THREADCNT, (Object)pSTaskServerLogBase.getThreadCnt());
        }
        if (pSTaskServerLogBase.isTotalMemoryDirty() && (bl || pSTaskServerLogBase.getTotalMemory() != null)) {
            iDataObject.set(FIELD_TOTALMEMORY, (Object)pSTaskServerLogBase.getTotalMemory());
        }
        if (pSTaskServerLogBase.isUpdateDateDirty() && (bl || pSTaskServerLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSTaskServerLogBase.getUpdateDate());
        }
        if (pSTaskServerLogBase.isUpdateManDirty() && (bl || pSTaskServerLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSTaskServerLogBase.getUpdateMan());
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
        return PSTaskServerLogBase.remove(this, n);
    }

    private static boolean remove(PSTaskServerLogBase pSTaskServerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSTaskServerLogBase.resetASBookingQueueCnt();
                return true;
            }
            case 1: {
                pSTaskServerLogBase.resetASBookingQueueCnt2();
                return true;
            }
            case 2: {
                pSTaskServerLogBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSTaskServerLogBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSTaskServerLogBase.resetDBDevInstCnt();
                return true;
            }
            case 5: {
                pSTaskServerLogBase.resetDCCnt();
                return true;
            }
            case 6: {
                pSTaskServerLogBase.resetDCTaskQueueCnt();
                return true;
            }
            case 7: {
                pSTaskServerLogBase.resetDCTaskQueueCnt2();
                return true;
            }
            case 8: {
                pSTaskServerLogBase.resetDCTaskQueueCnt3();
                return true;
            }
            case 9: {
                pSTaskServerLogBase.resetDefaultFlag();
                return true;
            }
            case 10: {
                pSTaskServerLogBase.resetDSBookingQueueCnt();
                return true;
            }
            case 11: {
                pSTaskServerLogBase.resetDSBookingQueueCnt2();
                return true;
            }
            case 12: {
                pSTaskServerLogBase.resetFreeMemory();
                return true;
            }
            case 13: {
                pSTaskServerLogBase.resetJITSysCnt();
                return true;
            }
            case 14: {
                pSTaskServerLogBase.resetLogTime();
                return true;
            }
            case 15: {
                pSTaskServerLogBase.resetMaxMemory();
                return true;
            }
            case 16: {
                pSTaskServerLogBase.resetPSTaskServerId();
                return true;
            }
            case 17: {
                pSTaskServerLogBase.resetPSTaskServerLogId();
                return true;
            }
            case 18: {
                pSTaskServerLogBase.resetPSTaskServerLogName();
                return true;
            }
            case 19: {
                pSTaskServerLogBase.resetPSTaskServerName();
                return true;
            }
            case 20: {
                pSTaskServerLogBase.resetRobotCnt();
                return true;
            }
            case 21: {
                pSTaskServerLogBase.resetSysModelCnt();
                return true;
            }
            case 22: {
                pSTaskServerLogBase.resetSysModelHelperCnt();
                return true;
            }
            case 23: {
                pSTaskServerLogBase.resetSysModelInstCnt();
                return true;
            }
            case 24: {
                pSTaskServerLogBase.resetSysTaskQueueCnt();
                return true;
            }
            case 25: {
                pSTaskServerLogBase.resetSysTaskQueueCnt2();
                return true;
            }
            case 26: {
                pSTaskServerLogBase.resetSysTaskQueueCnt3();
                return true;
            }
            case 27: {
                pSTaskServerLogBase.resetThreadCnt();
                return true;
            }
            case 28: {
                pSTaskServerLogBase.resetTotalMemory();
                return true;
            }
            case 29: {
                pSTaskServerLogBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSTaskServerLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSTaskServerLogBase getProxyEntity() {
        return this.proxyPSTaskServerLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSTaskServerLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSTaskServerLogBase) {
            this.proxyPSTaskServerLogBase = (PSTaskServerLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASBOOKINGQUEUECNT, 0);
        fieldIndexMap.put(FIELD_ASBOOKINGQUEUECNT2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DBDEVINSTCNT, 4);
        fieldIndexMap.put(FIELD_DCCNT, 5);
        fieldIndexMap.put(FIELD_DCTASKQUEUECNT, 6);
        fieldIndexMap.put(FIELD_DCTASKQUEUECNT2, 7);
        fieldIndexMap.put(FIELD_DCTASKQUEUECNT3, 8);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 9);
        fieldIndexMap.put(FIELD_DSBOOKINGQUEUECNT, 10);
        fieldIndexMap.put(FIELD_DSBOOKINGQUEUECNT2, 11);
        fieldIndexMap.put(FIELD_FREEMEMORY, 12);
        fieldIndexMap.put(FIELD_JITSYSCNT, 13);
        fieldIndexMap.put(FIELD_LOGTIME, 14);
        fieldIndexMap.put(FIELD_MAXMEMORY, 15);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 16);
        fieldIndexMap.put(FIELD_PSTASKSERVERLOGID, 17);
        fieldIndexMap.put(FIELD_PSTASKSERVERLOGNAME, 18);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 19);
        fieldIndexMap.put(FIELD_ROBOTCNT, 20);
        fieldIndexMap.put(FIELD_SYSMODELCNT, 21);
        fieldIndexMap.put(FIELD_SYSMODELHELPERCNT, 22);
        fieldIndexMap.put(FIELD_SYSMODELINSTCNT, 23);
        fieldIndexMap.put(FIELD_SYSTASKQUEUECNT, 24);
        fieldIndexMap.put(FIELD_SYSTASKQUEUECNT2, 25);
        fieldIndexMap.put(FIELD_SYSTASKQUEUECNT3, 26);
        fieldIndexMap.put(FIELD_THREADCNT, 27);
        fieldIndexMap.put(FIELD_TOTALMEMORY, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
    }
}

