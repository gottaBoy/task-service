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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysLockLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysLockLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKREASON = "LOCKREASON";
    public static final String FIELD_LOCKTYPE = "LOCKTYPE";
    public static final String FIELD_LOGPARAM = "LOGPARAM";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSLOCKLOGID = "PSDEVSLNSYSLOCKLOGID";
    public static final String FIELD_PSDEVSLNSYSLOCKLOGNAME = "PSDEVSLNSYSLOCKLOGNAME";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UNLOCKTIME = "UNLOCKTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOCKREASON = 2;
    private static final int INDEX_LOCKTYPE = 3;
    private static final int INDEX_LOGPARAM = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVSLNSYSID = 7;
    private static final int INDEX_PSDEVSLNSYSLOCKLOGID = 8;
    private static final int INDEX_PSDEVSLNSYSLOCKLOGNAME = 9;
    private static final int INDEX_PSDEVSLNSYSNAME = 10;
    private static final int INDEX_UNLOCKTIME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysLockLogBase proxyPSDevSlnSysLockLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockreasonDirtyFlag = false;
    private boolean locktypeDirtyFlag = false;
    private boolean logparamDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsyslocklogidDirtyFlag = false;
    private boolean psdevslnsyslocklognameDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean unlocktimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockreason")
    private String lockreason;
    @Column(name="locktype")
    private String locktype;
    @Column(name="logparam")
    private String logparam;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsyslocklogid")
    private String psdevslnsyslocklogid;
    @Column(name="psdevslnsyslocklogname")
    private String psdevslnsyslocklogname;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="unlocktime")
    private Timestamp unlocktime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setLockReason(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockReason(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockreason = string;
        this.lockreasonDirtyFlag = true;
    }

    public String getLockReason() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockReason();
        }
        return this.lockreason;
    }

    public boolean isLockReasonDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockReasonDirty();
        }
        return this.lockreasonDirtyFlag;
    }

    public void resetLockReason() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockReason();
            return;
        }
        this.lockreasonDirtyFlag = false;
        this.lockreason = null;
    }

    public void setLockType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.locktype = string;
        this.locktypeDirtyFlag = true;
    }

    public String getLockType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockType();
        }
        return this.locktype;
    }

    public boolean isLockTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockTypeDirty();
        }
        return this.locktypeDirtyFlag;
    }

    public void resetLockType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockType();
            return;
        }
        this.locktypeDirtyFlag = false;
        this.locktype = null;
    }

    public void setLogParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logparam = string;
        this.logparamDirtyFlag = true;
    }

    public String getLogParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogParam();
        }
        return this.logparam;
    }

    public boolean isLogParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogParamDirty();
        }
        return this.logparamDirtyFlag;
    }

    public void resetLogParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogParam();
            return;
        }
        this.logparamDirtyFlag = false;
        this.logparam = null;
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

    public void setPSDevSlnSysLockLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysLockLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyslocklogid = string;
        this.psdevslnsyslocklogidDirtyFlag = true;
    }

    public String getPSDevSlnSysLockLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysLockLogId();
        }
        return this.psdevslnsyslocklogid;
    }

    public boolean isPSDevSlnSysLockLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysLockLogIdDirty();
        }
        return this.psdevslnsyslocklogidDirtyFlag;
    }

    public void resetPSDevSlnSysLockLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysLockLogId();
            return;
        }
        this.psdevslnsyslocklogidDirtyFlag = false;
        this.psdevslnsyslocklogid = null;
    }

    public void setPSDevSlnSysLockLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysLockLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyslocklogname = string;
        this.psdevslnsyslocklognameDirtyFlag = true;
    }

    public String getPSDevSlnSysLockLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysLockLogName();
        }
        return this.psdevslnsyslocklogname;
    }

    public boolean isPSDevSlnSysLockLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysLockLogNameDirty();
        }
        return this.psdevslnsyslocklognameDirtyFlag;
    }

    public void resetPSDevSlnSysLockLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysLockLogName();
            return;
        }
        this.psdevslnsyslocklognameDirtyFlag = false;
        this.psdevslnsyslocklogname = null;
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

    public void setUnlockTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnlockTime(timestamp);
            return;
        }
        this.unlocktime = timestamp;
        this.unlocktimeDirtyFlag = true;
    }

    public Timestamp getUnlockTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnlockTime();
        }
        return this.unlocktime;
    }

    public boolean isUnlockTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnlockTimeDirty();
        }
        return this.unlocktimeDirtyFlag;
    }

    public void resetUnlockTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnlockTime();
            return;
        }
        this.unlocktimeDirtyFlag = false;
        this.unlocktime = null;
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
        PSDevSlnSysLockLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase) {
        pSDevSlnSysLockLogBase.resetCreateDate();
        pSDevSlnSysLockLogBase.resetCreateMan();
        pSDevSlnSysLockLogBase.resetLockReason();
        pSDevSlnSysLockLogBase.resetLockType();
        pSDevSlnSysLockLogBase.resetLogParam();
        pSDevSlnSysLockLogBase.resetPSDevCenterId();
        pSDevSlnSysLockLogBase.resetPSDevCenterName();
        pSDevSlnSysLockLogBase.resetPSDevSlnSysId();
        pSDevSlnSysLockLogBase.resetPSDevSlnSysLockLogId();
        pSDevSlnSysLockLogBase.resetPSDevSlnSysLockLogName();
        pSDevSlnSysLockLogBase.resetPSDevSlnSysName();
        pSDevSlnSysLockLogBase.resetUnlockTime();
        pSDevSlnSysLockLogBase.resetUpdateDate();
        pSDevSlnSysLockLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLockReasonDirty()) {
            hashMap.put(FIELD_LOCKREASON, this.getLockReason());
        }
        if (!bl || this.isLockTypeDirty()) {
            hashMap.put(FIELD_LOCKTYPE, this.getLockType());
        }
        if (!bl || this.isLogParamDirty()) {
            hashMap.put(FIELD_LOGPARAM, this.getLogParam());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysLockLogIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSLOCKLOGID, this.getPSDevSlnSysLockLogId());
        }
        if (!bl || this.isPSDevSlnSysLockLogNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSLOCKLOGNAME, this.getPSDevSlnSysLockLogName());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isUnlockTimeDirty()) {
            hashMap.put(FIELD_UNLOCKTIME, this.getUnlockTime());
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
        return PSDevSlnSysLockLogBase.get(this, n);
    }

    private static Object get(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysLockLogBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysLockLogBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysLockLogBase.getLockReason();
            }
            case 3: {
                return pSDevSlnSysLockLogBase.getLockType();
            }
            case 4: {
                return pSDevSlnSysLockLogBase.getLogParam();
            }
            case 5: {
                return pSDevSlnSysLockLogBase.getPSDevCenterId();
            }
            case 6: {
                return pSDevSlnSysLockLogBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysId();
            }
            case 8: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId();
            }
            case 9: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName();
            }
            case 10: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysName();
            }
            case 11: {
                return pSDevSlnSysLockLogBase.getUnlockTime();
            }
            case 12: {
                return pSDevSlnSysLockLogBase.getUpdateDate();
            }
            case 13: {
                return pSDevSlnSysLockLogBase.getUpdateMan();
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
        PSDevSlnSysLockLogBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysLockLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysLockLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysLockLogBase.setLockReason(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysLockLogBase.setLockType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysLockLogBase.setLogParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysLockLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysLockLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysLockLogBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysLockLogBase.setPSDevSlnSysLockLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysLockLogBase.setPSDevSlnSysLockLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysLockLogBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysLockLogBase.setUnlockTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysLockLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysLockLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysLockLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysLockLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysLockLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysLockLogBase.getLockReason() == null;
            }
            case 3: {
                return pSDevSlnSysLockLogBase.getLockType() == null;
            }
            case 4: {
                return pSDevSlnSysLockLogBase.getLogParam() == null;
            }
            case 5: {
                return pSDevSlnSysLockLogBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDevSlnSysLockLogBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysId() == null;
            }
            case 8: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId() == null;
            }
            case 9: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName() == null;
            }
            case 10: {
                return pSDevSlnSysLockLogBase.getPSDevSlnSysName() == null;
            }
            case 11: {
                return pSDevSlnSysLockLogBase.getUnlockTime() == null;
            }
            case 12: {
                return pSDevSlnSysLockLogBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevSlnSysLockLogBase.getUpdateMan() == null;
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
        return PSDevSlnSysLockLogBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysLockLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysLockLogBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysLockLogBase.isLockReasonDirty();
            }
            case 3: {
                return pSDevSlnSysLockLogBase.isLockTypeDirty();
            }
            case 4: {
                return pSDevSlnSysLockLogBase.isLogParamDirty();
            }
            case 5: {
                return pSDevSlnSysLockLogBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevSlnSysLockLogBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevSlnSysLockLogBase.isPSDevSlnSysIdDirty();
            }
            case 8: {
                return pSDevSlnSysLockLogBase.isPSDevSlnSysLockLogIdDirty();
            }
            case 9: {
                return pSDevSlnSysLockLogBase.isPSDevSlnSysLockLogNameDirty();
            }
            case 10: {
                return pSDevSlnSysLockLogBase.isPSDevSlnSysNameDirty();
            }
            case 11: {
                return pSDevSlnSysLockLogBase.isUnlockTimeDirty();
            }
            case 12: {
                return pSDevSlnSysLockLogBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevSlnSysLockLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysLockLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysLockLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getLockReason() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockreason", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getLockReason()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getLockType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"locktype", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getLockType()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getLogParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logparam", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getLogParam()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyslocklogid", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyslocklogname", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getUnlockTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unlocktime", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getUnlockTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysLockLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysLockLogBase.getJSONValue((Object)pSDevSlnSysLockLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysLockLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysLockLogBase.getCreateDate() != null) {
            object = pSDevSlnSysLockLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysLockLogBase.getCreateMan() != null) {
            object = pSDevSlnSysLockLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getLockReason() != null) {
            object = pSDevSlnSysLockLogBase.getLockReason();
            xmlNode.setAttribute(FIELD_LOCKREASON, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getLockType() != null) {
            object = pSDevSlnSysLockLogBase.getLockType();
            xmlNode.setAttribute(FIELD_LOCKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getLogParam() != null) {
            object = pSDevSlnSysLockLogBase.getLogParam();
            xmlNode.setAttribute(FIELD_LOGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSLOCKLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSLOCKLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysLockLogBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysLockLogBase.getUnlockTime() != null) {
            object = pSDevSlnSysLockLogBase.getUnlockTime();
            xmlNode.setAttribute(FIELD_UNLOCKTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysLockLogBase.getUpdateDate() != null) {
            object = pSDevSlnSysLockLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysLockLogBase.getUpdateMan() != null) {
            object = pSDevSlnSysLockLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysLockLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysLockLogBase.isCreateDateDirty() && (bl || pSDevSlnSysLockLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysLockLogBase.getCreateDate());
        }
        if (pSDevSlnSysLockLogBase.isCreateManDirty() && (bl || pSDevSlnSysLockLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysLockLogBase.getCreateMan());
        }
        if (pSDevSlnSysLockLogBase.isLockReasonDirty() && (bl || pSDevSlnSysLockLogBase.getLockReason() != null)) {
            iDataObject.set(FIELD_LOCKREASON, (Object)pSDevSlnSysLockLogBase.getLockReason());
        }
        if (pSDevSlnSysLockLogBase.isLockTypeDirty() && (bl || pSDevSlnSysLockLogBase.getLockType() != null)) {
            iDataObject.set(FIELD_LOCKTYPE, (Object)pSDevSlnSysLockLogBase.getLockType());
        }
        if (pSDevSlnSysLockLogBase.isLogParamDirty() && (bl || pSDevSlnSysLockLogBase.getLogParam() != null)) {
            iDataObject.set(FIELD_LOGPARAM, (Object)pSDevSlnSysLockLogBase.getLogParam());
        }
        if (pSDevSlnSysLockLogBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysLockLogBase.getPSDevCenterId());
        }
        if (pSDevSlnSysLockLogBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysLockLogBase.getPSDevCenterName());
        }
        if (pSDevSlnSysLockLogBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysLockLogBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysLockLogBase.isPSDevSlnSysLockLogIdDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSLOCKLOGID, (Object)pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogId());
        }
        if (pSDevSlnSysLockLogBase.isPSDevSlnSysLockLogNameDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSLOCKLOGNAME, (Object)pSDevSlnSysLockLogBase.getPSDevSlnSysLockLogName());
        }
        if (pSDevSlnSysLockLogBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysLockLogBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysLockLogBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysLockLogBase.isUnlockTimeDirty() && (bl || pSDevSlnSysLockLogBase.getUnlockTime() != null)) {
            iDataObject.set(FIELD_UNLOCKTIME, (Object)pSDevSlnSysLockLogBase.getUnlockTime());
        }
        if (pSDevSlnSysLockLogBase.isUpdateDateDirty() && (bl || pSDevSlnSysLockLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysLockLogBase.getUpdateDate());
        }
        if (pSDevSlnSysLockLogBase.isUpdateManDirty() && (bl || pSDevSlnSysLockLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysLockLogBase.getUpdateMan());
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
        return PSDevSlnSysLockLogBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysLockLogBase pSDevSlnSysLockLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysLockLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysLockLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysLockLogBase.resetLockReason();
                return true;
            }
            case 3: {
                pSDevSlnSysLockLogBase.resetLockType();
                return true;
            }
            case 4: {
                pSDevSlnSysLockLogBase.resetLogParam();
                return true;
            }
            case 5: {
                pSDevSlnSysLockLogBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevSlnSysLockLogBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevSlnSysLockLogBase.resetPSDevSlnSysId();
                return true;
            }
            case 8: {
                pSDevSlnSysLockLogBase.resetPSDevSlnSysLockLogId();
                return true;
            }
            case 9: {
                pSDevSlnSysLockLogBase.resetPSDevSlnSysLockLogName();
                return true;
            }
            case 10: {
                pSDevSlnSysLockLogBase.resetPSDevSlnSysName();
                return true;
            }
            case 11: {
                pSDevSlnSysLockLogBase.resetUnlockTime();
                return true;
            }
            case 12: {
                pSDevSlnSysLockLogBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevSlnSysLockLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysLockLogBase getProxyEntity() {
        return this.proxyPSDevSlnSysLockLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysLockLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysLockLogBase) {
            this.proxyPSDevSlnSysLockLogBase = (PSDevSlnSysLockLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysLockLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOCKREASON, 2);
        fieldIndexMap.put(FIELD_LOCKTYPE, 3);
        fieldIndexMap.put(FIELD_LOGPARAM, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSLOCKLOGID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSLOCKLOGNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 10);
        fieldIndexMap.put(FIELD_UNLOCKTIME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

