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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevServerLeaseBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevServerLeaseBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_LEASESTATE = "LEASESTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERLEASEID = "PSDEVSERVERLEASEID";
    public static final String FIELD_PSDEVSERVERLEASENAME = "PSDEVSERVERLEASENAME";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_LEASESTATE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSDEVSERVERID = 8;
    private static final int INDEX_PSDEVSERVERLEASEID = 9;
    private static final int INDEX_PSDEVSERVERLEASENAME = 10;
    private static final int INDEX_PSDEVSERVERNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevServerLeaseBase proxyPSDevServerLeaseBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean leasestateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevserverleaseidDirtyFlag = false;
    private boolean psdevserverleasenameDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="leasestate")
    private Integer leasestate;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevserverid")
    private String psdevserverid;
    @Column(name="psdevserverleaseid")
    private String psdevserverleaseid;
    @Column(name="psdevserverleasename")
    private String psdevserverleasename;
    @Column(name="psdevservername")
    private String psdevservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevServerLock = new Integer(1);
    private PSDevServer psdevserver = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setLeaseState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeaseState(n);
            return;
        }
        this.leasestate = n;
        this.leasestateDirtyFlag = true;
    }

    public Integer getLeaseState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeaseState();
        }
        return this.leasestate;
    }

    public boolean isLeaseStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeaseStateDirty();
        }
        return this.leasestateDirtyFlag;
    }

    public void resetLeaseState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeaseState();
            return;
        }
        this.leasestateDirtyFlag = false;
        this.leasestate = null;
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

    public void setPSDevServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverid = string;
        this.psdevserveridDirtyFlag = true;
    }

    public String getPSDevServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerId();
        }
        return this.psdevserverid;
    }

    public boolean isPSDevServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerIdDirty();
        }
        return this.psdevserveridDirtyFlag;
    }

    public void resetPSDevServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerId();
            return;
        }
        this.psdevserveridDirtyFlag = false;
        this.psdevserverid = null;
    }

    public void setPSDevServerLeaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerLeaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverleaseid = string;
        this.psdevserverleaseidDirtyFlag = true;
    }

    public String getPSDevServerLeaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerLeaseId();
        }
        return this.psdevserverleaseid;
    }

    public boolean isPSDevServerLeaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerLeaseIdDirty();
        }
        return this.psdevserverleaseidDirtyFlag;
    }

    public void resetPSDevServerLeaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerLeaseId();
            return;
        }
        this.psdevserverleaseidDirtyFlag = false;
        this.psdevserverleaseid = null;
    }

    public void setPSDevServerLeaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerLeaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverleasename = string;
        this.psdevserverleasenameDirtyFlag = true;
    }

    public String getPSDevServerLeaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerLeaseName();
        }
        return this.psdevserverleasename;
    }

    public boolean isPSDevServerLeaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerLeaseNameDirty();
        }
        return this.psdevserverleasenameDirtyFlag;
    }

    public void resetPSDevServerLeaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerLeaseName();
            return;
        }
        this.psdevserverleasenameDirtyFlag = false;
        this.psdevserverleasename = null;
    }

    public void setPSDevServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservername = string;
        this.psdevservernameDirtyFlag = true;
    }

    public String getPSDevServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerName();
        }
        return this.psdevservername;
    }

    public boolean isPSDevServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerNameDirty();
        }
        return this.psdevservernameDirtyFlag;
    }

    public void resetPSDevServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerName();
            return;
        }
        this.psdevservernameDirtyFlag = false;
        this.psdevservername = null;
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
        PSDevServerLeaseBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevServerLeaseBase pSDevServerLeaseBase) {
        pSDevServerLeaseBase.resetBeginTime();
        pSDevServerLeaseBase.resetCreateDate();
        pSDevServerLeaseBase.resetCreateMan();
        pSDevServerLeaseBase.resetEndTime();
        pSDevServerLeaseBase.resetLeaseState();
        pSDevServerLeaseBase.resetMemo();
        pSDevServerLeaseBase.resetPSDevCenterId();
        pSDevServerLeaseBase.resetPSDevCenterName();
        pSDevServerLeaseBase.resetPSDevServerId();
        pSDevServerLeaseBase.resetPSDevServerLeaseId();
        pSDevServerLeaseBase.resetPSDevServerLeaseName();
        pSDevServerLeaseBase.resetPSDevServerName();
        pSDevServerLeaseBase.resetUpdateDate();
        pSDevServerLeaseBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isLeaseStateDirty()) {
            hashMap.put(FIELD_LEASESTATE, this.getLeaseState());
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
        if (!bl || this.isPSDevServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERID, this.getPSDevServerId());
        }
        if (!bl || this.isPSDevServerLeaseIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERLEASEID, this.getPSDevServerLeaseId());
        }
        if (!bl || this.isPSDevServerLeaseNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERLEASENAME, this.getPSDevServerLeaseName());
        }
        if (!bl || this.isPSDevServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERNAME, this.getPSDevServerName());
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
        return PSDevServerLeaseBase.get(this, n);
    }

    private static Object get(PSDevServerLeaseBase pSDevServerLeaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerLeaseBase.getBeginTime();
            }
            case 1: {
                return pSDevServerLeaseBase.getCreateDate();
            }
            case 2: {
                return pSDevServerLeaseBase.getCreateMan();
            }
            case 3: {
                return pSDevServerLeaseBase.getEndTime();
            }
            case 4: {
                return pSDevServerLeaseBase.getLeaseState();
            }
            case 5: {
                return pSDevServerLeaseBase.getMemo();
            }
            case 6: {
                return pSDevServerLeaseBase.getPSDevCenterId();
            }
            case 7: {
                return pSDevServerLeaseBase.getPSDevCenterName();
            }
            case 8: {
                return pSDevServerLeaseBase.getPSDevServerId();
            }
            case 9: {
                return pSDevServerLeaseBase.getPSDevServerLeaseId();
            }
            case 10: {
                return pSDevServerLeaseBase.getPSDevServerLeaseName();
            }
            case 11: {
                return pSDevServerLeaseBase.getPSDevServerName();
            }
            case 12: {
                return pSDevServerLeaseBase.getUpdateDate();
            }
            case 13: {
                return pSDevServerLeaseBase.getUpdateMan();
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
        PSDevServerLeaseBase.set(this, n, object);
    }

    private static void set(PSDevServerLeaseBase pSDevServerLeaseBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerLeaseBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevServerLeaseBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevServerLeaseBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevServerLeaseBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevServerLeaseBase.setLeaseState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevServerLeaseBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevServerLeaseBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevServerLeaseBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevServerLeaseBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevServerLeaseBase.setPSDevServerLeaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevServerLeaseBase.setPSDevServerLeaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevServerLeaseBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevServerLeaseBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevServerLeaseBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevServerLeaseBase.isNull(this, n);
    }

    private static boolean isNull(PSDevServerLeaseBase pSDevServerLeaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerLeaseBase.getBeginTime() == null;
            }
            case 1: {
                return pSDevServerLeaseBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevServerLeaseBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevServerLeaseBase.getEndTime() == null;
            }
            case 4: {
                return pSDevServerLeaseBase.getLeaseState() == null;
            }
            case 5: {
                return pSDevServerLeaseBase.getMemo() == null;
            }
            case 6: {
                return pSDevServerLeaseBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSDevServerLeaseBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSDevServerLeaseBase.getPSDevServerId() == null;
            }
            case 9: {
                return pSDevServerLeaseBase.getPSDevServerLeaseId() == null;
            }
            case 10: {
                return pSDevServerLeaseBase.getPSDevServerLeaseName() == null;
            }
            case 11: {
                return pSDevServerLeaseBase.getPSDevServerName() == null;
            }
            case 12: {
                return pSDevServerLeaseBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevServerLeaseBase.getUpdateMan() == null;
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
        return PSDevServerLeaseBase.contains(this, n);
    }

    private static boolean contains(PSDevServerLeaseBase pSDevServerLeaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerLeaseBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDevServerLeaseBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevServerLeaseBase.isCreateManDirty();
            }
            case 3: {
                return pSDevServerLeaseBase.isEndTimeDirty();
            }
            case 4: {
                return pSDevServerLeaseBase.isLeaseStateDirty();
            }
            case 5: {
                return pSDevServerLeaseBase.isMemoDirty();
            }
            case 6: {
                return pSDevServerLeaseBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSDevServerLeaseBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSDevServerLeaseBase.isPSDevServerIdDirty();
            }
            case 9: {
                return pSDevServerLeaseBase.isPSDevServerLeaseIdDirty();
            }
            case 10: {
                return pSDevServerLeaseBase.isPSDevServerLeaseNameDirty();
            }
            case 11: {
                return pSDevServerLeaseBase.isPSDevServerNameDirty();
            }
            case 12: {
                return pSDevServerLeaseBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevServerLeaseBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevServerLeaseBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevServerLeaseBase pSDevServerLeaseBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevServerLeaseBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getLeaseState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leasestate", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getLeaseState()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerLeaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverleaseid", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevServerLeaseId()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerLeaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverleasename", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevServerLeaseName()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevServerLeaseBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevServerLeaseBase.getJSONValue((Object)pSDevServerLeaseBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevServerLeaseBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevServerLeaseBase pSDevServerLeaseBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevServerLeaseBase.getBeginTime() != null) {
            object = pSDevServerLeaseBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerLeaseBase.getCreateDate() != null) {
            object = pSDevServerLeaseBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerLeaseBase.getCreateMan() != null) {
            object = pSDevServerLeaseBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getEndTime() != null) {
            object = pSDevServerLeaseBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerLeaseBase.getLeaseState() != null) {
            object = pSDevServerLeaseBase.getLeaseState();
            xmlNode.setAttribute(FIELD_LEASESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerLeaseBase.getMemo() != null) {
            object = pSDevServerLeaseBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevCenterId() != null) {
            object = pSDevServerLeaseBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevCenterName() != null) {
            object = pSDevServerLeaseBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerId() != null) {
            object = pSDevServerLeaseBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerLeaseId() != null) {
            object = pSDevServerLeaseBase.getPSDevServerLeaseId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERLEASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerLeaseName() != null) {
            object = pSDevServerLeaseBase.getPSDevServerLeaseName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERLEASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getPSDevServerName() != null) {
            object = pSDevServerLeaseBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerLeaseBase.getUpdateDate() != null) {
            object = pSDevServerLeaseBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerLeaseBase.getUpdateMan() != null) {
            object = pSDevServerLeaseBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevServerLeaseBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevServerLeaseBase pSDevServerLeaseBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevServerLeaseBase.isBeginTimeDirty() && (bl || pSDevServerLeaseBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevServerLeaseBase.getBeginTime());
        }
        if (pSDevServerLeaseBase.isCreateDateDirty() && (bl || pSDevServerLeaseBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevServerLeaseBase.getCreateDate());
        }
        if (pSDevServerLeaseBase.isCreateManDirty() && (bl || pSDevServerLeaseBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevServerLeaseBase.getCreateMan());
        }
        if (pSDevServerLeaseBase.isEndTimeDirty() && (bl || pSDevServerLeaseBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevServerLeaseBase.getEndTime());
        }
        if (pSDevServerLeaseBase.isLeaseStateDirty() && (bl || pSDevServerLeaseBase.getLeaseState() != null)) {
            iDataObject.set(FIELD_LEASESTATE, (Object)pSDevServerLeaseBase.getLeaseState());
        }
        if (pSDevServerLeaseBase.isMemoDirty() && (bl || pSDevServerLeaseBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevServerLeaseBase.getMemo());
        }
        if (pSDevServerLeaseBase.isPSDevCenterIdDirty() && (bl || pSDevServerLeaseBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevServerLeaseBase.getPSDevCenterId());
        }
        if (pSDevServerLeaseBase.isPSDevCenterNameDirty() && (bl || pSDevServerLeaseBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevServerLeaseBase.getPSDevCenterName());
        }
        if (pSDevServerLeaseBase.isPSDevServerIdDirty() && (bl || pSDevServerLeaseBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDevServerLeaseBase.getPSDevServerId());
        }
        if (pSDevServerLeaseBase.isPSDevServerLeaseIdDirty() && (bl || pSDevServerLeaseBase.getPSDevServerLeaseId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERLEASEID, (Object)pSDevServerLeaseBase.getPSDevServerLeaseId());
        }
        if (pSDevServerLeaseBase.isPSDevServerLeaseNameDirty() && (bl || pSDevServerLeaseBase.getPSDevServerLeaseName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERLEASENAME, (Object)pSDevServerLeaseBase.getPSDevServerLeaseName());
        }
        if (pSDevServerLeaseBase.isPSDevServerNameDirty() && (bl || pSDevServerLeaseBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDevServerLeaseBase.getPSDevServerName());
        }
        if (pSDevServerLeaseBase.isUpdateDateDirty() && (bl || pSDevServerLeaseBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevServerLeaseBase.getUpdateDate());
        }
        if (pSDevServerLeaseBase.isUpdateManDirty() && (bl || pSDevServerLeaseBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevServerLeaseBase.getUpdateMan());
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
        return PSDevServerLeaseBase.remove(this, n);
    }

    private static boolean remove(PSDevServerLeaseBase pSDevServerLeaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerLeaseBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDevServerLeaseBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevServerLeaseBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevServerLeaseBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDevServerLeaseBase.resetLeaseState();
                return true;
            }
            case 5: {
                pSDevServerLeaseBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevServerLeaseBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSDevServerLeaseBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSDevServerLeaseBase.resetPSDevServerId();
                return true;
            }
            case 9: {
                pSDevServerLeaseBase.resetPSDevServerLeaseId();
                return true;
            }
            case 10: {
                pSDevServerLeaseBase.resetPSDevServerLeaseName();
                return true;
            }
            case 11: {
                pSDevServerLeaseBase.resetPSDevServerName();
                return true;
            }
            case 12: {
                pSDevServerLeaseBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevServerLeaseBase.resetUpdateMan();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevServer getPSDevServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServer();
        }
        if (this.getPSDevServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevServerLock;
        synchronized (n) {
            if (this.psdevserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevServerId(), (Object)this.psdevserver.getPSDevServerId()) != 0L) {
                this.psdevserver = null;
            }
            if (this.psdevserver == null) {
                PSDevServer pSDevServer = new PSDevServer();
                pSDevServer.setPSDevServerId(this.getPSDevServerId());
                PSDevServerService pSDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevServerService.autoGet(pSDevServer);
                this.psdevserver = pSDevServer;
            }
            return this.psdevserver;
        }
    }

    private PSDevServerLeaseBase getProxyEntity() {
        return this.proxyPSDevServerLeaseBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevServerLeaseBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevServerLeaseBase) {
            this.proxyPSDevServerLeaseBase = (PSDevServerLeaseBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevServerLeaseService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_LEASESTATE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 8);
        fieldIndexMap.put(FIELD_PSDEVSERVERLEASEID, 9);
        fieldIndexMap.put(FIELD_PSDEVSERVERLEASENAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

