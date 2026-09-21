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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysPubLockBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysPubLockBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKREASON = "LOCKREASON";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSPUBLOCKID = "PSDEVSLNSYSPUBLOCKID";
    public static final String FIELD_PSDEVSLNSYSPUBLOCKNAME = "PSDEVSLNSYSPUBLOCKNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_UNLOCKTIME = "UNLOCKTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOCKREASON = 2;
    private static final int INDEX_PSDEVCENTERID = 3;
    private static final int INDEX_PSDEVCENTERNAME = 4;
    private static final int INDEX_PSDEVSLNSYSPUBLOCKID = 5;
    private static final int INDEX_PSDEVSLNSYSPUBLOCKNAME = 6;
    private static final int INDEX_TEMPLCODE = 7;
    private static final int INDEX_UNLOCKTIME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysPubLockBase proxyPSDevSlnSysPubLockBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockreasonDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsyspublockidDirtyFlag = false;
    private boolean psdevslnsyspublocknameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean unlocktimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockreason")
    private String lockreason;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsyspublockid")
    private String psdevslnsyspublockid;
    @Column(name="psdevslnsyspublockname")
    private String psdevslnsyspublockname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="unlocktime")
    private Timestamp unlocktime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setPSDevSlnSysPubLockId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysPubLockId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyspublockid = string;
        this.psdevslnsyspublockidDirtyFlag = true;
    }

    public String getPSDevSlnSysPubLockId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysPubLockId();
        }
        return this.psdevslnsyspublockid;
    }

    public boolean isPSDevSlnSysPubLockIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysPubLockIdDirty();
        }
        return this.psdevslnsyspublockidDirtyFlag;
    }

    public void resetPSDevSlnSysPubLockId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysPubLockId();
            return;
        }
        this.psdevslnsyspublockidDirtyFlag = false;
        this.psdevslnsyspublockid = null;
    }

    public void setPSDevSlnSysPubLockName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysPubLockName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyspublockname = string;
        this.psdevslnsyspublocknameDirtyFlag = true;
    }

    public String getPSDevSlnSysPubLockName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysPubLockName();
        }
        return this.psdevslnsyspublockname;
    }

    public boolean isPSDevSlnSysPubLockNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysPubLockNameDirty();
        }
        return this.psdevslnsyspublocknameDirtyFlag;
    }

    public void resetPSDevSlnSysPubLockName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysPubLockName();
            return;
        }
        this.psdevslnsyspublocknameDirtyFlag = false;
        this.psdevslnsyspublockname = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDevSlnSysPubLockBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase) {
        pSDevSlnSysPubLockBase.resetCreateDate();
        pSDevSlnSysPubLockBase.resetCreateMan();
        pSDevSlnSysPubLockBase.resetLockReason();
        pSDevSlnSysPubLockBase.resetPSDevCenterId();
        pSDevSlnSysPubLockBase.resetPSDevCenterName();
        pSDevSlnSysPubLockBase.resetPSDevSlnSysPubLockId();
        pSDevSlnSysPubLockBase.resetPSDevSlnSysPubLockName();
        pSDevSlnSysPubLockBase.resetTemplCode();
        pSDevSlnSysPubLockBase.resetUnlockTime();
        pSDevSlnSysPubLockBase.resetUpdateDate();
        pSDevSlnSysPubLockBase.resetUpdateMan();
        pSDevSlnSysPubLockBase.resetValidFlag();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysPubLockIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSPUBLOCKID, this.getPSDevSlnSysPubLockId());
        }
        if (!bl || this.isPSDevSlnSysPubLockNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSPUBLOCKNAME, this.getPSDevSlnSysPubLockName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDevSlnSysPubLockBase.get(this, n);
    }

    private static Object get(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPubLockBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysPubLockBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysPubLockBase.getLockReason();
            }
            case 3: {
                return pSDevSlnSysPubLockBase.getPSDevCenterId();
            }
            case 4: {
                return pSDevSlnSysPubLockBase.getPSDevCenterName();
            }
            case 5: {
                return pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId();
            }
            case 6: {
                return pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName();
            }
            case 7: {
                return pSDevSlnSysPubLockBase.getTemplCode();
            }
            case 8: {
                return pSDevSlnSysPubLockBase.getUnlockTime();
            }
            case 9: {
                return pSDevSlnSysPubLockBase.getUpdateDate();
            }
            case 10: {
                return pSDevSlnSysPubLockBase.getUpdateMan();
            }
            case 11: {
                return pSDevSlnSysPubLockBase.getValidFlag();
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
        PSDevSlnSysPubLockBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysPubLockBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysPubLockBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysPubLockBase.setLockReason(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysPubLockBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysPubLockBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysPubLockBase.setPSDevSlnSysPubLockId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysPubLockBase.setPSDevSlnSysPubLockName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysPubLockBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysPubLockBase.setUnlockTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysPubLockBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysPubLockBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysPubLockBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysPubLockBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPubLockBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysPubLockBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysPubLockBase.getLockReason() == null;
            }
            case 3: {
                return pSDevSlnSysPubLockBase.getPSDevCenterId() == null;
            }
            case 4: {
                return pSDevSlnSysPubLockBase.getPSDevCenterName() == null;
            }
            case 5: {
                return pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId() == null;
            }
            case 6: {
                return pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName() == null;
            }
            case 7: {
                return pSDevSlnSysPubLockBase.getTemplCode() == null;
            }
            case 8: {
                return pSDevSlnSysPubLockBase.getUnlockTime() == null;
            }
            case 9: {
                return pSDevSlnSysPubLockBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDevSlnSysPubLockBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDevSlnSysPubLockBase.getValidFlag() == null;
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
        return PSDevSlnSysPubLockBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPubLockBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysPubLockBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysPubLockBase.isLockReasonDirty();
            }
            case 3: {
                return pSDevSlnSysPubLockBase.isPSDevCenterIdDirty();
            }
            case 4: {
                return pSDevSlnSysPubLockBase.isPSDevCenterNameDirty();
            }
            case 5: {
                return pSDevSlnSysPubLockBase.isPSDevSlnSysPubLockIdDirty();
            }
            case 6: {
                return pSDevSlnSysPubLockBase.isPSDevSlnSysPubLockNameDirty();
            }
            case 7: {
                return pSDevSlnSysPubLockBase.isTemplCodeDirty();
            }
            case 8: {
                return pSDevSlnSysPubLockBase.isUnlockTimeDirty();
            }
            case 9: {
                return pSDevSlnSysPubLockBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDevSlnSysPubLockBase.isUpdateManDirty();
            }
            case 11: {
                return pSDevSlnSysPubLockBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysPubLockBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysPubLockBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getLockReason() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockreason", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getLockReason()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyspublockid", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyspublockname", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getUnlockTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unlocktime", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getUnlockTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysPubLockBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysPubLockBase.getJSONValue((Object)pSDevSlnSysPubLockBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysPubLockBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysPubLockBase.getCreateDate() != null) {
            object = pSDevSlnSysPubLockBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysPubLockBase.getCreateMan() != null) {
            object = pSDevSlnSysPubLockBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getLockReason() != null) {
            object = pSDevSlnSysPubLockBase.getLockReason();
            xmlNode.setAttribute(FIELD_LOCKREASON, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysPubLockBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysPubLockBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId() != null) {
            object = pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSPUBLOCKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName() != null) {
            object = pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSPUBLOCKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getTemplCode() != null) {
            object = pSDevSlnSysPubLockBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getUnlockTime() != null) {
            object = pSDevSlnSysPubLockBase.getUnlockTime();
            xmlNode.setAttribute(FIELD_UNLOCKTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysPubLockBase.getUpdateDate() != null) {
            object = pSDevSlnSysPubLockBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysPubLockBase.getUpdateMan() != null) {
            object = pSDevSlnSysPubLockBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPubLockBase.getValidFlag() != null) {
            object = pSDevSlnSysPubLockBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysPubLockBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysPubLockBase.isCreateDateDirty() && (bl || pSDevSlnSysPubLockBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysPubLockBase.getCreateDate());
        }
        if (pSDevSlnSysPubLockBase.isCreateManDirty() && (bl || pSDevSlnSysPubLockBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysPubLockBase.getCreateMan());
        }
        if (pSDevSlnSysPubLockBase.isLockReasonDirty() && (bl || pSDevSlnSysPubLockBase.getLockReason() != null)) {
            iDataObject.set(FIELD_LOCKREASON, (Object)pSDevSlnSysPubLockBase.getLockReason());
        }
        if (pSDevSlnSysPubLockBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysPubLockBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysPubLockBase.getPSDevCenterId());
        }
        if (pSDevSlnSysPubLockBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysPubLockBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysPubLockBase.getPSDevCenterName());
        }
        if (pSDevSlnSysPubLockBase.isPSDevSlnSysPubLockIdDirty() && (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSPUBLOCKID, (Object)pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockId());
        }
        if (pSDevSlnSysPubLockBase.isPSDevSlnSysPubLockNameDirty() && (bl || pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSPUBLOCKNAME, (Object)pSDevSlnSysPubLockBase.getPSDevSlnSysPubLockName());
        }
        if (pSDevSlnSysPubLockBase.isTemplCodeDirty() && (bl || pSDevSlnSysPubLockBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSDevSlnSysPubLockBase.getTemplCode());
        }
        if (pSDevSlnSysPubLockBase.isUnlockTimeDirty() && (bl || pSDevSlnSysPubLockBase.getUnlockTime() != null)) {
            iDataObject.set(FIELD_UNLOCKTIME, (Object)pSDevSlnSysPubLockBase.getUnlockTime());
        }
        if (pSDevSlnSysPubLockBase.isUpdateDateDirty() && (bl || pSDevSlnSysPubLockBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysPubLockBase.getUpdateDate());
        }
        if (pSDevSlnSysPubLockBase.isUpdateManDirty() && (bl || pSDevSlnSysPubLockBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysPubLockBase.getUpdateMan());
        }
        if (pSDevSlnSysPubLockBase.isValidFlagDirty() && (bl || pSDevSlnSysPubLockBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysPubLockBase.getValidFlag());
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
        return PSDevSlnSysPubLockBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysPubLockBase pSDevSlnSysPubLockBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysPubLockBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysPubLockBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysPubLockBase.resetLockReason();
                return true;
            }
            case 3: {
                pSDevSlnSysPubLockBase.resetPSDevCenterId();
                return true;
            }
            case 4: {
                pSDevSlnSysPubLockBase.resetPSDevCenterName();
                return true;
            }
            case 5: {
                pSDevSlnSysPubLockBase.resetPSDevSlnSysPubLockId();
                return true;
            }
            case 6: {
                pSDevSlnSysPubLockBase.resetPSDevSlnSysPubLockName();
                return true;
            }
            case 7: {
                pSDevSlnSysPubLockBase.resetTemplCode();
                return true;
            }
            case 8: {
                pSDevSlnSysPubLockBase.resetUnlockTime();
                return true;
            }
            case 9: {
                pSDevSlnSysPubLockBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDevSlnSysPubLockBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDevSlnSysPubLockBase.resetValidFlag();
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

    private PSDevSlnSysPubLockBase getProxyEntity() {
        return this.proxyPSDevSlnSysPubLockBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysPubLockBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysPubLockBase) {
            this.proxyPSDevSlnSysPubLockBase = (PSDevSlnSysPubLockBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysPubLockService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOCKREASON, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSPUBLOCKID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSPUBLOCKNAME, 6);
        fieldIndexMap.put(FIELD_TEMPLCODE, 7);
        fieldIndexMap.put(FIELD_UNLOCKTIME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

