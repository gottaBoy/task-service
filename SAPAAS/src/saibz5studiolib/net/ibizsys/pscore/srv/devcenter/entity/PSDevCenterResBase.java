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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterResBase.class);
    public static final String FIELD_ALLOCATED = "ALLOCATED";
    public static final String FIELD_ALLOCATEDINFO = "ALLOCATEDINFO";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERRESID = "PSDEVCENTERRESID";
    public static final String FIELD_PSDEVCENTERRESNAME = "PSDEVCENTERRESNAME";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_TIMETAG = "TIMETAG";
    public static final String FIELD_TIMETYPE = "TIMETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USED = "USED";
    public static final String FIELD_USEDINFO = "USEDINFO";
    private static final int INDEX_ALLOCATED = 0;
    private static final int INDEX_ALLOCATEDINFO = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVCENTERRESID = 7;
    private static final int INDEX_PSDEVCENTERRESNAME = 8;
    private static final int INDEX_RESTYPE = 9;
    private static final int INDEX_TIMETAG = 10;
    private static final int INDEX_TIMETYPE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USED = 14;
    private static final int INDEX_USEDINFO = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterResBase proxyPSDevCenterResBase = null;
    private boolean allocatedDirtyFlag = false;
    private boolean allocatedinfoDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterresidDirtyFlag = false;
    private boolean psdevcenterresnameDirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean timetagDirtyFlag = false;
    private boolean timetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usedDirtyFlag = false;
    private boolean usedinfoDirtyFlag = false;
    @Column(name="allocated")
    private Integer allocated;
    @Column(name="allocatedinfo")
    private String allocatedinfo;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcenterresid")
    private String psdevcenterresid;
    @Column(name="psdevcenterresname")
    private String psdevcenterresname;
    @Column(name="restype")
    private String restype;
    @Column(name="timetag")
    private String timetag;
    @Column(name="timetype")
    private String timetype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="used")
    private Integer used;
    @Column(name="usedinfo")
    private String usedinfo;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllocated(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllocated(n);
            return;
        }
        this.allocated = n;
        this.allocatedDirtyFlag = true;
    }

    public Integer getAllocated() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllocated();
        }
        return this.allocated;
    }

    public boolean isAllocatedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllocatedDirty();
        }
        return this.allocatedDirtyFlag;
    }

    public void resetAllocated() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllocated();
            return;
        }
        this.allocatedDirtyFlag = false;
        this.allocated = null;
    }

    public void setAllocatedInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllocatedInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.allocatedinfo = string;
        this.allocatedinfoDirtyFlag = true;
    }

    public String getAllocatedInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllocatedInfo();
        }
        return this.allocatedinfo;
    }

    public boolean isAllocatedInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllocatedInfoDirty();
        }
        return this.allocatedinfoDirtyFlag;
    }

    public void resetAllocatedInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllocatedInfo();
            return;
        }
        this.allocatedinfoDirtyFlag = false;
        this.allocatedinfo = null;
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

    public void setPSDevCenterResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterresid = string;
        this.psdevcenterresidDirtyFlag = true;
    }

    public String getPSDevCenterResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterResId();
        }
        return this.psdevcenterresid;
    }

    public boolean isPSDevCenterResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterResIdDirty();
        }
        return this.psdevcenterresidDirtyFlag;
    }

    public void resetPSDevCenterResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterResId();
            return;
        }
        this.psdevcenterresidDirtyFlag = false;
        this.psdevcenterresid = null;
    }

    public void setPSDevCenterResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterresname = string;
        this.psdevcenterresnameDirtyFlag = true;
    }

    public String getPSDevCenterResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterResName();
        }
        return this.psdevcenterresname;
    }

    public boolean isPSDevCenterResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterResNameDirty();
        }
        return this.psdevcenterresnameDirtyFlag;
    }

    public void resetPSDevCenterResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterResName();
            return;
        }
        this.psdevcenterresnameDirtyFlag = false;
        this.psdevcenterresname = null;
    }

    public void setResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restype = string;
        this.restypeDirtyFlag = true;
    }

    public String getResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResType();
        }
        return this.restype;
    }

    public boolean isResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTypeDirty();
        }
        return this.restypeDirtyFlag;
    }

    public void resetResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResType();
            return;
        }
        this.restypeDirtyFlag = false;
        this.restype = null;
    }

    public void setTimeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timetag = string;
        this.timetagDirtyFlag = true;
    }

    public String getTimeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeTag();
        }
        return this.timetag;
    }

    public boolean isTimeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeTagDirty();
        }
        return this.timetagDirtyFlag;
    }

    public void resetTimeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeTag();
            return;
        }
        this.timetagDirtyFlag = false;
        this.timetag = null;
    }

    public void setTimeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timetype = string;
        this.timetypeDirtyFlag = true;
    }

    public String getTimeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeType();
        }
        return this.timetype;
    }

    public boolean isTimeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeTypeDirty();
        }
        return this.timetypeDirtyFlag;
    }

    public void resetTimeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeType();
            return;
        }
        this.timetypeDirtyFlag = false;
        this.timetype = null;
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

    public void setUsed(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsed(n);
            return;
        }
        this.used = n;
        this.usedDirtyFlag = true;
    }

    public Integer getUsed() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsed();
        }
        return this.used;
    }

    public boolean isUsedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedDirty();
        }
        return this.usedDirtyFlag;
    }

    public void resetUsed() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsed();
            return;
        }
        this.usedDirtyFlag = false;
        this.used = null;
    }

    public void setUsedInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usedinfo = string;
        this.usedinfoDirtyFlag = true;
    }

    public String getUsedInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedInfo();
        }
        return this.usedinfo;
    }

    public boolean isUsedInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedInfoDirty();
        }
        return this.usedinfoDirtyFlag;
    }

    public void resetUsedInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedInfo();
            return;
        }
        this.usedinfoDirtyFlag = false;
        this.usedinfo = null;
    }

    protected void onReset() {
        PSDevCenterResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterResBase pSDevCenterResBase) {
        pSDevCenterResBase.resetAllocated();
        pSDevCenterResBase.resetAllocatedInfo();
        pSDevCenterResBase.resetCreateDate();
        pSDevCenterResBase.resetCreateMan();
        pSDevCenterResBase.resetMemo();
        pSDevCenterResBase.resetPSDevCenterId();
        pSDevCenterResBase.resetPSDevCenterName();
        pSDevCenterResBase.resetPSDevCenterResId();
        pSDevCenterResBase.resetPSDevCenterResName();
        pSDevCenterResBase.resetResType();
        pSDevCenterResBase.resetTimeTag();
        pSDevCenterResBase.resetTimeType();
        pSDevCenterResBase.resetUpdateDate();
        pSDevCenterResBase.resetUpdateMan();
        pSDevCenterResBase.resetUsed();
        pSDevCenterResBase.resetUsedInfo();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllocatedDirty()) {
            hashMap.put(FIELD_ALLOCATED, this.getAllocated());
        }
        if (!bl || this.isAllocatedInfoDirty()) {
            hashMap.put(FIELD_ALLOCATEDINFO, this.getAllocatedInfo());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterResIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERRESID, this.getPSDevCenterResId());
        }
        if (!bl || this.isPSDevCenterResNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERRESNAME, this.getPSDevCenterResName());
        }
        if (!bl || this.isResTypeDirty()) {
            hashMap.put(FIELD_RESTYPE, this.getResType());
        }
        if (!bl || this.isTimeTagDirty()) {
            hashMap.put(FIELD_TIMETAG, this.getTimeTag());
        }
        if (!bl || this.isTimeTypeDirty()) {
            hashMap.put(FIELD_TIMETYPE, this.getTimeType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsedDirty()) {
            hashMap.put(FIELD_USED, this.getUsed());
        }
        if (!bl || this.isUsedInfoDirty()) {
            hashMap.put(FIELD_USEDINFO, this.getUsedInfo());
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
        return PSDevCenterResBase.get(this, n);
    }

    private static Object get(PSDevCenterResBase pSDevCenterResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterResBase.getAllocated();
            }
            case 1: {
                return pSDevCenterResBase.getAllocatedInfo();
            }
            case 2: {
                return pSDevCenterResBase.getCreateDate();
            }
            case 3: {
                return pSDevCenterResBase.getCreateMan();
            }
            case 4: {
                return pSDevCenterResBase.getMemo();
            }
            case 5: {
                return pSDevCenterResBase.getPSDevCenterId();
            }
            case 6: {
                return pSDevCenterResBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevCenterResBase.getPSDevCenterResId();
            }
            case 8: {
                return pSDevCenterResBase.getPSDevCenterResName();
            }
            case 9: {
                return pSDevCenterResBase.getResType();
            }
            case 10: {
                return pSDevCenterResBase.getTimeTag();
            }
            case 11: {
                return pSDevCenterResBase.getTimeType();
            }
            case 12: {
                return pSDevCenterResBase.getUpdateDate();
            }
            case 13: {
                return pSDevCenterResBase.getUpdateMan();
            }
            case 14: {
                return pSDevCenterResBase.getUsed();
            }
            case 15: {
                return pSDevCenterResBase.getUsedInfo();
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
        PSDevCenterResBase.set(this, n, object);
    }

    private static void set(PSDevCenterResBase pSDevCenterResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterResBase.setAllocated(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterResBase.setAllocatedInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterResBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterResBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterResBase.setPSDevCenterResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterResBase.setPSDevCenterResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterResBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterResBase.setTimeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterResBase.setTimeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterResBase.setUsed(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterResBase.setUsedInfo(DataObject.getStringValue((Object)object));
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
        return PSDevCenterResBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterResBase pSDevCenterResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterResBase.getAllocated() == null;
            }
            case 1: {
                return pSDevCenterResBase.getAllocatedInfo() == null;
            }
            case 2: {
                return pSDevCenterResBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevCenterResBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevCenterResBase.getMemo() == null;
            }
            case 5: {
                return pSDevCenterResBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDevCenterResBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevCenterResBase.getPSDevCenterResId() == null;
            }
            case 8: {
                return pSDevCenterResBase.getPSDevCenterResName() == null;
            }
            case 9: {
                return pSDevCenterResBase.getResType() == null;
            }
            case 10: {
                return pSDevCenterResBase.getTimeTag() == null;
            }
            case 11: {
                return pSDevCenterResBase.getTimeType() == null;
            }
            case 12: {
                return pSDevCenterResBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevCenterResBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDevCenterResBase.getUsed() == null;
            }
            case 15: {
                return pSDevCenterResBase.getUsedInfo() == null;
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
        return PSDevCenterResBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterResBase pSDevCenterResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterResBase.isAllocatedDirty();
            }
            case 1: {
                return pSDevCenterResBase.isAllocatedInfoDirty();
            }
            case 2: {
                return pSDevCenterResBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevCenterResBase.isCreateManDirty();
            }
            case 4: {
                return pSDevCenterResBase.isMemoDirty();
            }
            case 5: {
                return pSDevCenterResBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevCenterResBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevCenterResBase.isPSDevCenterResIdDirty();
            }
            case 8: {
                return pSDevCenterResBase.isPSDevCenterResNameDirty();
            }
            case 9: {
                return pSDevCenterResBase.isResTypeDirty();
            }
            case 10: {
                return pSDevCenterResBase.isTimeTagDirty();
            }
            case 11: {
                return pSDevCenterResBase.isTimeTypeDirty();
            }
            case 12: {
                return pSDevCenterResBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevCenterResBase.isUpdateManDirty();
            }
            case 14: {
                return pSDevCenterResBase.isUsedDirty();
            }
            case 15: {
                return pSDevCenterResBase.isUsedInfoDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterResBase pSDevCenterResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterResBase.getAllocated() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allocated", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getAllocated()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getAllocatedInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allocatedinfo", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getAllocatedInfo()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterresid", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getPSDevCenterResId()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterresname", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getPSDevCenterResName()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getResType()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getTimeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timetag", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getTimeTag()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getTimeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timetype", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getTimeType()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getUsed() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"used", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getUsed()), (boolean)false);
        }
        if (bl || pSDevCenterResBase.getUsedInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedinfo", (Object)PSDevCenterResBase.getJSONValue((Object)pSDevCenterResBase.getUsedInfo()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterResBase pSDevCenterResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterResBase.getAllocated() != null) {
            object = pSDevCenterResBase.getAllocated();
            xmlNode.setAttribute(FIELD_ALLOCATED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterResBase.getAllocatedInfo() != null) {
            object = pSDevCenterResBase.getAllocatedInfo();
            xmlNode.setAttribute(FIELD_ALLOCATEDINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getCreateDate() != null) {
            object = pSDevCenterResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterResBase.getCreateMan() != null) {
            object = pSDevCenterResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getMemo() != null) {
            object = pSDevCenterResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterId() != null) {
            object = pSDevCenterResBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterName() != null) {
            object = pSDevCenterResBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterResId() != null) {
            object = pSDevCenterResBase.getPSDevCenterResId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getPSDevCenterResName() != null) {
            object = pSDevCenterResBase.getPSDevCenterResName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getResType() != null) {
            object = pSDevCenterResBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getTimeTag() != null) {
            object = pSDevCenterResBase.getTimeTag();
            xmlNode.setAttribute(FIELD_TIMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getTimeType() != null) {
            object = pSDevCenterResBase.getTimeType();
            xmlNode.setAttribute(FIELD_TIMETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getUpdateDate() != null) {
            object = pSDevCenterResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterResBase.getUpdateMan() != null) {
            object = pSDevCenterResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterResBase.getUsed() != null) {
            object = pSDevCenterResBase.getUsed();
            xmlNode.setAttribute(FIELD_USED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterResBase.getUsedInfo() != null) {
            object = pSDevCenterResBase.getUsedInfo();
            xmlNode.setAttribute(FIELD_USEDINFO, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterResBase pSDevCenterResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterResBase.isAllocatedDirty() && (bl || pSDevCenterResBase.getAllocated() != null)) {
            iDataObject.set(FIELD_ALLOCATED, (Object)pSDevCenterResBase.getAllocated());
        }
        if (pSDevCenterResBase.isAllocatedInfoDirty() && (bl || pSDevCenterResBase.getAllocatedInfo() != null)) {
            iDataObject.set(FIELD_ALLOCATEDINFO, (Object)pSDevCenterResBase.getAllocatedInfo());
        }
        if (pSDevCenterResBase.isCreateDateDirty() && (bl || pSDevCenterResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterResBase.getCreateDate());
        }
        if (pSDevCenterResBase.isCreateManDirty() && (bl || pSDevCenterResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterResBase.getCreateMan());
        }
        if (pSDevCenterResBase.isMemoDirty() && (bl || pSDevCenterResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterResBase.getMemo());
        }
        if (pSDevCenterResBase.isPSDevCenterIdDirty() && (bl || pSDevCenterResBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterResBase.getPSDevCenterId());
        }
        if (pSDevCenterResBase.isPSDevCenterNameDirty() && (bl || pSDevCenterResBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterResBase.getPSDevCenterName());
        }
        if (pSDevCenterResBase.isPSDevCenterResIdDirty() && (bl || pSDevCenterResBase.getPSDevCenterResId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERRESID, (Object)pSDevCenterResBase.getPSDevCenterResId());
        }
        if (pSDevCenterResBase.isPSDevCenterResNameDirty() && (bl || pSDevCenterResBase.getPSDevCenterResName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERRESNAME, (Object)pSDevCenterResBase.getPSDevCenterResName());
        }
        if (pSDevCenterResBase.isResTypeDirty() && (bl || pSDevCenterResBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSDevCenterResBase.getResType());
        }
        if (pSDevCenterResBase.isTimeTagDirty() && (bl || pSDevCenterResBase.getTimeTag() != null)) {
            iDataObject.set(FIELD_TIMETAG, (Object)pSDevCenterResBase.getTimeTag());
        }
        if (pSDevCenterResBase.isTimeTypeDirty() && (bl || pSDevCenterResBase.getTimeType() != null)) {
            iDataObject.set(FIELD_TIMETYPE, (Object)pSDevCenterResBase.getTimeType());
        }
        if (pSDevCenterResBase.isUpdateDateDirty() && (bl || pSDevCenterResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterResBase.getUpdateDate());
        }
        if (pSDevCenterResBase.isUpdateManDirty() && (bl || pSDevCenterResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterResBase.getUpdateMan());
        }
        if (pSDevCenterResBase.isUsedDirty() && (bl || pSDevCenterResBase.getUsed() != null)) {
            iDataObject.set(FIELD_USED, (Object)pSDevCenterResBase.getUsed());
        }
        if (pSDevCenterResBase.isUsedInfoDirty() && (bl || pSDevCenterResBase.getUsedInfo() != null)) {
            iDataObject.set(FIELD_USEDINFO, (Object)pSDevCenterResBase.getUsedInfo());
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
        return PSDevCenterResBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterResBase pSDevCenterResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterResBase.resetAllocated();
                return true;
            }
            case 1: {
                pSDevCenterResBase.resetAllocatedInfo();
                return true;
            }
            case 2: {
                pSDevCenterResBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevCenterResBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevCenterResBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevCenterResBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevCenterResBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevCenterResBase.resetPSDevCenterResId();
                return true;
            }
            case 8: {
                pSDevCenterResBase.resetPSDevCenterResName();
                return true;
            }
            case 9: {
                pSDevCenterResBase.resetResType();
                return true;
            }
            case 10: {
                pSDevCenterResBase.resetTimeTag();
                return true;
            }
            case 11: {
                pSDevCenterResBase.resetTimeType();
                return true;
            }
            case 12: {
                pSDevCenterResBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevCenterResBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDevCenterResBase.resetUsed();
                return true;
            }
            case 15: {
                pSDevCenterResBase.resetUsedInfo();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDevCenterResBase getProxyEntity() {
        return this.proxyPSDevCenterResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterResBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterResBase) {
            this.proxyPSDevCenterResBase = (PSDevCenterResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOCATED, 0);
        fieldIndexMap.put(FIELD_ALLOCATEDINFO, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERRESID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERRESNAME, 8);
        fieldIndexMap.put(FIELD_RESTYPE, 9);
        fieldIndexMap.put(FIELD_TIMETAG, 10);
        fieldIndexMap.put(FIELD_TIMETYPE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USED, 14);
        fieldIndexMap.put(FIELD_USEDINFO, 15);
    }
}

