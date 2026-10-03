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
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelLoadLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelLoadLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXCEPTIONINFO = "EXCEPTIONINFO";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSMODELLOADLOGID = "PSSYSMODELLOADLOGID";
    public static final String FIELD_PSSYSMODELLOADLOGNAME = "PSSYSMODELLOADLOGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXCEPTIONINFO = 2;
    private static final int INDEX_LOGINFO = 3;
    private static final int INDEX_LOGLEVEL = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDYNAINSTID = 6;
    private static final int INDEX_PSOBJID = 7;
    private static final int INDEX_PSOBJNAME = 8;
    private static final int INDEX_PSOBJTYPE = 9;
    private static final int INDEX_PSSYSMODELLOADLOGID = 10;
    private static final int INDEX_PSSYSMODELLOADLOGNAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_PSTASKSERVERID = 14;
    private static final int INDEX_PSTASKSERVERNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelLoadLogBase proxyPSSysModelLoadLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean exceptioninfoDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysmodelloadlogidDirtyFlag = false;
    private boolean pssysmodelloadlognameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="exceptioninfo")
    private String exceptioninfo;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssysmodelloadlogid")
    private String pssysmodelloadlogid;
    @Column(name="pssysmodelloadlogname")
    private String pssysmodelloadlogname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setExceptionInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExceptionInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exceptioninfo = string;
        this.exceptioninfoDirtyFlag = true;
    }

    public String getExceptionInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExceptionInfo();
        }
        return this.exceptioninfo;
    }

    public boolean isExceptionInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExceptionInfoDirty();
        }
        return this.exceptioninfoDirtyFlag;
    }

    public void resetExceptionInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExceptionInfo();
            return;
        }
        this.exceptioninfoDirtyFlag = false;
        this.exceptioninfo = null;
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

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSSysModelLoadLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelLoadLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelloadlogid = string;
        this.pssysmodelloadlogidDirtyFlag = true;
    }

    public String getPSSysModelLoadLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelLoadLogId();
        }
        return this.pssysmodelloadlogid;
    }

    public boolean isPSSysModelLoadLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelLoadLogIdDirty();
        }
        return this.pssysmodelloadlogidDirtyFlag;
    }

    public void resetPSSysModelLoadLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelLoadLogId();
            return;
        }
        this.pssysmodelloadlogidDirtyFlag = false;
        this.pssysmodelloadlogid = null;
    }

    public void setPSSysModelLoadLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelLoadLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelloadlogname = string;
        this.pssysmodelloadlognameDirtyFlag = true;
    }

    public String getPSSysModelLoadLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelLoadLogName();
        }
        return this.pssysmodelloadlogname;
    }

    public boolean isPSSysModelLoadLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelLoadLogNameDirty();
        }
        return this.pssysmodelloadlognameDirtyFlag;
    }

    public void resetPSSysModelLoadLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelLoadLogName();
            return;
        }
        this.pssysmodelloadlognameDirtyFlag = false;
        this.pssysmodelloadlogname = null;
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
        PSSysModelLoadLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelLoadLogBase pSSysModelLoadLogBase) {
        pSSysModelLoadLogBase.resetCreateDate();
        pSSysModelLoadLogBase.resetCreateMan();
        pSSysModelLoadLogBase.resetExceptionInfo();
        pSSysModelLoadLogBase.resetLogInfo();
        pSSysModelLoadLogBase.resetLogLevel();
        pSSysModelLoadLogBase.resetMemo();
        pSSysModelLoadLogBase.resetPSDynaInstId();
        pSSysModelLoadLogBase.resetPSObjId();
        pSSysModelLoadLogBase.resetPSObjName();
        pSSysModelLoadLogBase.resetPSObjType();
        pSSysModelLoadLogBase.resetPSSysModelLoadLogId();
        pSSysModelLoadLogBase.resetPSSysModelLoadLogName();
        pSSysModelLoadLogBase.resetPSSystemId();
        pSSysModelLoadLogBase.resetPSSystemName();
        pSSysModelLoadLogBase.resetPSTaskServerId();
        pSSysModelLoadLogBase.resetPSTaskServerName();
        pSSysModelLoadLogBase.resetUpdateDate();
        pSSysModelLoadLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExceptionInfoDirty()) {
            hashMap.put(FIELD_EXCEPTIONINFO, this.getExceptionInfo());
        }
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bl || this.isLogLevelDirty()) {
            hashMap.put(FIELD_LOGLEVEL, this.getLogLevel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSysModelLoadLogIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELLOADLOGID, this.getPSSysModelLoadLogId());
        }
        if (!bl || this.isPSSysModelLoadLogNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELLOADLOGNAME, this.getPSSysModelLoadLogName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        return PSSysModelLoadLogBase.get(this, n);
    }

    private static Object get(PSSysModelLoadLogBase pSSysModelLoadLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLoadLogBase.getCreateDate();
            }
            case 1: {
                return pSSysModelLoadLogBase.getCreateMan();
            }
            case 2: {
                return pSSysModelLoadLogBase.getExceptionInfo();
            }
            case 3: {
                return pSSysModelLoadLogBase.getLogInfo();
            }
            case 4: {
                return pSSysModelLoadLogBase.getLogLevel();
            }
            case 5: {
                return pSSysModelLoadLogBase.getMemo();
            }
            case 6: {
                return pSSysModelLoadLogBase.getPSDynaInstId();
            }
            case 7: {
                return pSSysModelLoadLogBase.getPSObjId();
            }
            case 8: {
                return pSSysModelLoadLogBase.getPSObjName();
            }
            case 9: {
                return pSSysModelLoadLogBase.getPSObjType();
            }
            case 10: {
                return pSSysModelLoadLogBase.getPSSysModelLoadLogId();
            }
            case 11: {
                return pSSysModelLoadLogBase.getPSSysModelLoadLogName();
            }
            case 12: {
                return pSSysModelLoadLogBase.getPSSystemId();
            }
            case 13: {
                return pSSysModelLoadLogBase.getPSSystemName();
            }
            case 14: {
                return pSSysModelLoadLogBase.getPSTaskServerId();
            }
            case 15: {
                return pSSysModelLoadLogBase.getPSTaskServerName();
            }
            case 16: {
                return pSSysModelLoadLogBase.getUpdateDate();
            }
            case 17: {
                return pSSysModelLoadLogBase.getUpdateMan();
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
        PSSysModelLoadLogBase.set(this, n, object);
    }

    private static void set(PSSysModelLoadLogBase pSSysModelLoadLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelLoadLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelLoadLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelLoadLogBase.setExceptionInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelLoadLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelLoadLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelLoadLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelLoadLogBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelLoadLogBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelLoadLogBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelLoadLogBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelLoadLogBase.setPSSysModelLoadLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelLoadLogBase.setPSSysModelLoadLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelLoadLogBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelLoadLogBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelLoadLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelLoadLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelLoadLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelLoadLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelLoadLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelLoadLogBase pSSysModelLoadLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLoadLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelLoadLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelLoadLogBase.getExceptionInfo() == null;
            }
            case 3: {
                return pSSysModelLoadLogBase.getLogInfo() == null;
            }
            case 4: {
                return pSSysModelLoadLogBase.getLogLevel() == null;
            }
            case 5: {
                return pSSysModelLoadLogBase.getMemo() == null;
            }
            case 6: {
                return pSSysModelLoadLogBase.getPSDynaInstId() == null;
            }
            case 7: {
                return pSSysModelLoadLogBase.getPSObjId() == null;
            }
            case 8: {
                return pSSysModelLoadLogBase.getPSObjName() == null;
            }
            case 9: {
                return pSSysModelLoadLogBase.getPSObjType() == null;
            }
            case 10: {
                return pSSysModelLoadLogBase.getPSSysModelLoadLogId() == null;
            }
            case 11: {
                return pSSysModelLoadLogBase.getPSSysModelLoadLogName() == null;
            }
            case 12: {
                return pSSysModelLoadLogBase.getPSSystemId() == null;
            }
            case 13: {
                return pSSysModelLoadLogBase.getPSSystemName() == null;
            }
            case 14: {
                return pSSysModelLoadLogBase.getPSTaskServerId() == null;
            }
            case 15: {
                return pSSysModelLoadLogBase.getPSTaskServerName() == null;
            }
            case 16: {
                return pSSysModelLoadLogBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysModelLoadLogBase.getUpdateMan() == null;
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
        return PSSysModelLoadLogBase.contains(this, n);
    }

    private static boolean contains(PSSysModelLoadLogBase pSSysModelLoadLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLoadLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelLoadLogBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelLoadLogBase.isExceptionInfoDirty();
            }
            case 3: {
                return pSSysModelLoadLogBase.isLogInfoDirty();
            }
            case 4: {
                return pSSysModelLoadLogBase.isLogLevelDirty();
            }
            case 5: {
                return pSSysModelLoadLogBase.isMemoDirty();
            }
            case 6: {
                return pSSysModelLoadLogBase.isPSDynaInstIdDirty();
            }
            case 7: {
                return pSSysModelLoadLogBase.isPSObjIdDirty();
            }
            case 8: {
                return pSSysModelLoadLogBase.isPSObjNameDirty();
            }
            case 9: {
                return pSSysModelLoadLogBase.isPSObjTypeDirty();
            }
            case 10: {
                return pSSysModelLoadLogBase.isPSSysModelLoadLogIdDirty();
            }
            case 11: {
                return pSSysModelLoadLogBase.isPSSysModelLoadLogNameDirty();
            }
            case 12: {
                return pSSysModelLoadLogBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSSysModelLoadLogBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSSysModelLoadLogBase.isPSTaskServerIdDirty();
            }
            case 15: {
                return pSSysModelLoadLogBase.isPSTaskServerNameDirty();
            }
            case 16: {
                return pSSysModelLoadLogBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysModelLoadLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelLoadLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelLoadLogBase pSSysModelLoadLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelLoadLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getExceptionInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exceptioninfo", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getExceptionInfo()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelloadlogid", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSSysModelLoadLogId()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelloadlogname", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSSysModelLoadLogName()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelLoadLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelLoadLogBase.getJSONValue((Object)pSSysModelLoadLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelLoadLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelLoadLogBase pSSysModelLoadLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelLoadLogBase.getCreateDate() != null) {
            object = pSSysModelLoadLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelLoadLogBase.getCreateMan() != null) {
            object = pSSysModelLoadLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getExceptionInfo() != null) {
            object = pSSysModelLoadLogBase.getExceptionInfo();
            xmlNode.setAttribute(FIELD_EXCEPTIONINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getLogInfo() != null) {
            object = pSSysModelLoadLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getLogLevel() != null) {
            object = pSSysModelLoadLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getMemo() != null) {
            object = pSSysModelLoadLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSDynaInstId() != null) {
            object = pSSysModelLoadLogBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjId() != null) {
            object = pSSysModelLoadLogBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjName() != null) {
            object = pSSysModelLoadLogBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSObjType() != null) {
            object = pSSysModelLoadLogBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogId() != null) {
            object = pSSysModelLoadLogBase.getPSSysModelLoadLogId();
            xmlNode.setAttribute(FIELD_PSSYSMODELLOADLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogName() != null) {
            object = pSSysModelLoadLogBase.getPSSysModelLoadLogName();
            xmlNode.setAttribute(FIELD_PSSYSMODELLOADLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSSystemId() != null) {
            object = pSSysModelLoadLogBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSSystemName() != null) {
            object = pSSysModelLoadLogBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSTaskServerId() != null) {
            object = pSSysModelLoadLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getPSTaskServerName() != null) {
            object = pSSysModelLoadLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLoadLogBase.getUpdateDate() != null) {
            object = pSSysModelLoadLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelLoadLogBase.getUpdateMan() != null) {
            object = pSSysModelLoadLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelLoadLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelLoadLogBase pSSysModelLoadLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelLoadLogBase.isCreateDateDirty() && (bl || pSSysModelLoadLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelLoadLogBase.getCreateDate());
        }
        if (pSSysModelLoadLogBase.isCreateManDirty() && (bl || pSSysModelLoadLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelLoadLogBase.getCreateMan());
        }
        if (pSSysModelLoadLogBase.isExceptionInfoDirty() && (bl || pSSysModelLoadLogBase.getExceptionInfo() != null)) {
            iDataObject.set(FIELD_EXCEPTIONINFO, (Object)pSSysModelLoadLogBase.getExceptionInfo());
        }
        if (pSSysModelLoadLogBase.isLogInfoDirty() && (bl || pSSysModelLoadLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSSysModelLoadLogBase.getLogInfo());
        }
        if (pSSysModelLoadLogBase.isLogLevelDirty() && (bl || pSSysModelLoadLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSSysModelLoadLogBase.getLogLevel());
        }
        if (pSSysModelLoadLogBase.isMemoDirty() && (bl || pSSysModelLoadLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelLoadLogBase.getMemo());
        }
        if (pSSysModelLoadLogBase.isPSDynaInstIdDirty() && (bl || pSSysModelLoadLogBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysModelLoadLogBase.getPSDynaInstId());
        }
        if (pSSysModelLoadLogBase.isPSObjIdDirty() && (bl || pSSysModelLoadLogBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysModelLoadLogBase.getPSObjId());
        }
        if (pSSysModelLoadLogBase.isPSObjNameDirty() && (bl || pSSysModelLoadLogBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysModelLoadLogBase.getPSObjName());
        }
        if (pSSysModelLoadLogBase.isPSObjTypeDirty() && (bl || pSSysModelLoadLogBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSysModelLoadLogBase.getPSObjType());
        }
        if (pSSysModelLoadLogBase.isPSSysModelLoadLogIdDirty() && (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELLOADLOGID, (Object)pSSysModelLoadLogBase.getPSSysModelLoadLogId());
        }
        if (pSSysModelLoadLogBase.isPSSysModelLoadLogNameDirty() && (bl || pSSysModelLoadLogBase.getPSSysModelLoadLogName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELLOADLOGNAME, (Object)pSSysModelLoadLogBase.getPSSysModelLoadLogName());
        }
        if (pSSysModelLoadLogBase.isPSSystemIdDirty() && (bl || pSSysModelLoadLogBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelLoadLogBase.getPSSystemId());
        }
        if (pSSysModelLoadLogBase.isPSSystemNameDirty() && (bl || pSSysModelLoadLogBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelLoadLogBase.getPSSystemName());
        }
        if (pSSysModelLoadLogBase.isPSTaskServerIdDirty() && (bl || pSSysModelLoadLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSSysModelLoadLogBase.getPSTaskServerId());
        }
        if (pSSysModelLoadLogBase.isPSTaskServerNameDirty() && (bl || pSSysModelLoadLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSSysModelLoadLogBase.getPSTaskServerName());
        }
        if (pSSysModelLoadLogBase.isUpdateDateDirty() && (bl || pSSysModelLoadLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelLoadLogBase.getUpdateDate());
        }
        if (pSSysModelLoadLogBase.isUpdateManDirty() && (bl || pSSysModelLoadLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelLoadLogBase.getUpdateMan());
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
        return PSSysModelLoadLogBase.remove(this, n);
    }

    private static boolean remove(PSSysModelLoadLogBase pSSysModelLoadLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelLoadLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelLoadLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelLoadLogBase.resetExceptionInfo();
                return true;
            }
            case 3: {
                pSSysModelLoadLogBase.resetLogInfo();
                return true;
            }
            case 4: {
                pSSysModelLoadLogBase.resetLogLevel();
                return true;
            }
            case 5: {
                pSSysModelLoadLogBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysModelLoadLogBase.resetPSDynaInstId();
                return true;
            }
            case 7: {
                pSSysModelLoadLogBase.resetPSObjId();
                return true;
            }
            case 8: {
                pSSysModelLoadLogBase.resetPSObjName();
                return true;
            }
            case 9: {
                pSSysModelLoadLogBase.resetPSObjType();
                return true;
            }
            case 10: {
                pSSysModelLoadLogBase.resetPSSysModelLoadLogId();
                return true;
            }
            case 11: {
                pSSysModelLoadLogBase.resetPSSysModelLoadLogName();
                return true;
            }
            case 12: {
                pSSysModelLoadLogBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSSysModelLoadLogBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSSysModelLoadLogBase.resetPSTaskServerId();
                return true;
            }
            case 15: {
                pSSysModelLoadLogBase.resetPSTaskServerName();
                return true;
            }
            case 16: {
                pSSysModelLoadLogBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysModelLoadLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
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

    private PSSysModelLoadLogBase getProxyEntity() {
        return this.proxyPSSysModelLoadLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelLoadLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelLoadLogBase) {
            this.proxyPSSysModelLoadLogBase = (PSSysModelLoadLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXCEPTIONINFO, 2);
        fieldIndexMap.put(FIELD_LOGINFO, 3);
        fieldIndexMap.put(FIELD_LOGLEVEL, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSOBJID, 7);
        fieldIndexMap.put(FIELD_PSOBJNAME, 8);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 9);
        fieldIndexMap.put(FIELD_PSSYSMODELLOADLOGID, 10);
        fieldIndexMap.put(FIELD_PSSYSMODELLOADLOGNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 14);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

