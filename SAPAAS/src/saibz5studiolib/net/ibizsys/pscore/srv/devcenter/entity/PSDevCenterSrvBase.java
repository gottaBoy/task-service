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

public abstract class PSDevCenterSrvBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterSrvBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSRVID = "PSDEVCENTERSRVID";
    public static final String FIELD_PSDEVCENTERSRVNAME = "PSDEVCENTERSRVNAME";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_SVRSTATE = "SVRSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVCENTERSRVID = 7;
    private static final int INDEX_PSDEVCENTERSRVNAME = 8;
    private static final int INDEX_PSDEVSERVERID = 9;
    private static final int INDEX_PSDEVSERVERNAME = 10;
    private static final int INDEX_SVRSTATE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterSrvBase proxyPSDevCenterSrvBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersrvidDirtyFlag = false;
    private boolean psdevcentersrvnameDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean svrstateDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersrvid")
    private String psdevcentersrvid;
    @Column(name="psdevcentersrvname")
    private String psdevcentersrvname;
    @Column(name="psdevserverid")
    private String psdevserverid;
    @Column(name="psdevservername")
    private String psdevservername;
    @Column(name="svrstate")
    private Integer svrstate;
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

    public void setPSDevCenterSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersrvid = string;
        this.psdevcentersrvidDirtyFlag = true;
    }

    public String getPSDevCenterSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSrvId();
        }
        return this.psdevcentersrvid;
    }

    public boolean isPSDevCenterSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSrvIdDirty();
        }
        return this.psdevcentersrvidDirtyFlag;
    }

    public void resetPSDevCenterSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSrvId();
            return;
        }
        this.psdevcentersrvidDirtyFlag = false;
        this.psdevcentersrvid = null;
    }

    public void setPSDevCenterSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersrvname = string;
        this.psdevcentersrvnameDirtyFlag = true;
    }

    public String getPSDevCenterSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSrvName();
        }
        return this.psdevcentersrvname;
    }

    public boolean isPSDevCenterSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSrvNameDirty();
        }
        return this.psdevcentersrvnameDirtyFlag;
    }

    public void resetPSDevCenterSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSrvName();
            return;
        }
        this.psdevcentersrvnameDirtyFlag = false;
        this.psdevcentersrvname = null;
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

    public void setSVRState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSVRState(n);
            return;
        }
        this.svrstate = n;
        this.svrstateDirtyFlag = true;
    }

    public Integer getSVRState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSVRState();
        }
        return this.svrstate;
    }

    public boolean isSVRStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSVRStateDirty();
        }
        return this.svrstateDirtyFlag;
    }

    public void resetSVRState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSVRState();
            return;
        }
        this.svrstateDirtyFlag = false;
        this.svrstate = null;
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
        PSDevCenterSrvBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterSrvBase pSDevCenterSrvBase) {
        pSDevCenterSrvBase.resetBeginTime();
        pSDevCenterSrvBase.resetCreateDate();
        pSDevCenterSrvBase.resetCreateMan();
        pSDevCenterSrvBase.resetEndTime();
        pSDevCenterSrvBase.resetMemo();
        pSDevCenterSrvBase.resetPSDevCenterId();
        pSDevCenterSrvBase.resetPSDevCenterName();
        pSDevCenterSrvBase.resetPSDevCenterSrvId();
        pSDevCenterSrvBase.resetPSDevCenterSrvName();
        pSDevCenterSrvBase.resetPSDevServerId();
        pSDevCenterSrvBase.resetPSDevServerName();
        pSDevCenterSrvBase.resetSVRState();
        pSDevCenterSrvBase.resetUpdateDate();
        pSDevCenterSrvBase.resetUpdateMan();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSRVID, this.getPSDevCenterSrvId());
        }
        if (!bl || this.isPSDevCenterSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSRVNAME, this.getPSDevCenterSrvName());
        }
        if (!bl || this.isPSDevServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERID, this.getPSDevServerId());
        }
        if (!bl || this.isPSDevServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERNAME, this.getPSDevServerName());
        }
        if (!bl || this.isSVRStateDirty()) {
            hashMap.put(FIELD_SVRSTATE, this.getSVRState());
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
        return PSDevCenterSrvBase.get(this, n);
    }

    private static Object get(PSDevCenterSrvBase pSDevCenterSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSrvBase.getBeginTime();
            }
            case 1: {
                return pSDevCenterSrvBase.getCreateDate();
            }
            case 2: {
                return pSDevCenterSrvBase.getCreateMan();
            }
            case 3: {
                return pSDevCenterSrvBase.getEndTime();
            }
            case 4: {
                return pSDevCenterSrvBase.getMemo();
            }
            case 5: {
                return pSDevCenterSrvBase.getPSDevCenterId();
            }
            case 6: {
                return pSDevCenterSrvBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevCenterSrvBase.getPSDevCenterSrvId();
            }
            case 8: {
                return pSDevCenterSrvBase.getPSDevCenterSrvName();
            }
            case 9: {
                return pSDevCenterSrvBase.getPSDevServerId();
            }
            case 10: {
                return pSDevCenterSrvBase.getPSDevServerName();
            }
            case 11: {
                return pSDevCenterSrvBase.getSVRState();
            }
            case 12: {
                return pSDevCenterSrvBase.getUpdateDate();
            }
            case 13: {
                return pSDevCenterSrvBase.getUpdateMan();
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
        PSDevCenterSrvBase.set(this, n, object);
    }

    private static void set(PSDevCenterSrvBase pSDevCenterSrvBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSrvBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterSrvBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterSrvBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterSrvBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterSrvBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterSrvBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterSrvBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterSrvBase.setPSDevCenterSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterSrvBase.setPSDevCenterSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterSrvBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterSrvBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterSrvBase.setSVRState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterSrvBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterSrvBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevCenterSrvBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterSrvBase pSDevCenterSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSrvBase.getBeginTime() == null;
            }
            case 1: {
                return pSDevCenterSrvBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevCenterSrvBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevCenterSrvBase.getEndTime() == null;
            }
            case 4: {
                return pSDevCenterSrvBase.getMemo() == null;
            }
            case 5: {
                return pSDevCenterSrvBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDevCenterSrvBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevCenterSrvBase.getPSDevCenterSrvId() == null;
            }
            case 8: {
                return pSDevCenterSrvBase.getPSDevCenterSrvName() == null;
            }
            case 9: {
                return pSDevCenterSrvBase.getPSDevServerId() == null;
            }
            case 10: {
                return pSDevCenterSrvBase.getPSDevServerName() == null;
            }
            case 11: {
                return pSDevCenterSrvBase.getSVRState() == null;
            }
            case 12: {
                return pSDevCenterSrvBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevCenterSrvBase.getUpdateMan() == null;
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
        return PSDevCenterSrvBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterSrvBase pSDevCenterSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSrvBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDevCenterSrvBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevCenterSrvBase.isCreateManDirty();
            }
            case 3: {
                return pSDevCenterSrvBase.isEndTimeDirty();
            }
            case 4: {
                return pSDevCenterSrvBase.isMemoDirty();
            }
            case 5: {
                return pSDevCenterSrvBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevCenterSrvBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevCenterSrvBase.isPSDevCenterSrvIdDirty();
            }
            case 8: {
                return pSDevCenterSrvBase.isPSDevCenterSrvNameDirty();
            }
            case 9: {
                return pSDevCenterSrvBase.isPSDevServerIdDirty();
            }
            case 10: {
                return pSDevCenterSrvBase.isPSDevServerNameDirty();
            }
            case 11: {
                return pSDevCenterSrvBase.isSVRStateDirty();
            }
            case 12: {
                return pSDevCenterSrvBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevCenterSrvBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterSrvBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterSrvBase pSDevCenterSrvBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterSrvBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersrvid", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevCenterSrvId()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersrvname", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevCenterSrvName()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getSVRState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"svrstate", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getSVRState()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSrvBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterSrvBase.getJSONValue((Object)pSDevCenterSrvBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterSrvBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterSrvBase pSDevCenterSrvBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterSrvBase.getBeginTime() != null) {
            object = pSDevCenterSrvBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSrvBase.getCreateDate() != null) {
            object = pSDevCenterSrvBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSrvBase.getCreateMan() != null) {
            object = pSDevCenterSrvBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getEndTime() != null) {
            object = pSDevCenterSrvBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSrvBase.getMemo() != null) {
            object = pSDevCenterSrvBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterId() != null) {
            object = pSDevCenterSrvBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterName() != null) {
            object = pSDevCenterSrvBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterSrvId() != null) {
            object = pSDevCenterSrvBase.getPSDevCenterSrvId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevCenterSrvName() != null) {
            object = pSDevCenterSrvBase.getPSDevCenterSrvName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevServerId() != null) {
            object = pSDevCenterSrvBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getPSDevServerName() != null) {
            object = pSDevCenterSrvBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSrvBase.getSVRState() != null) {
            object = pSDevCenterSrvBase.getSVRState();
            xmlNode.setAttribute(FIELD_SVRSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterSrvBase.getUpdateDate() != null) {
            object = pSDevCenterSrvBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSrvBase.getUpdateMan() != null) {
            object = pSDevCenterSrvBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterSrvBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterSrvBase pSDevCenterSrvBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterSrvBase.isBeginTimeDirty() && (bl || pSDevCenterSrvBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevCenterSrvBase.getBeginTime());
        }
        if (pSDevCenterSrvBase.isCreateDateDirty() && (bl || pSDevCenterSrvBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterSrvBase.getCreateDate());
        }
        if (pSDevCenterSrvBase.isCreateManDirty() && (bl || pSDevCenterSrvBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterSrvBase.getCreateMan());
        }
        if (pSDevCenterSrvBase.isEndTimeDirty() && (bl || pSDevCenterSrvBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevCenterSrvBase.getEndTime());
        }
        if (pSDevCenterSrvBase.isMemoDirty() && (bl || pSDevCenterSrvBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterSrvBase.getMemo());
        }
        if (pSDevCenterSrvBase.isPSDevCenterIdDirty() && (bl || pSDevCenterSrvBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterSrvBase.getPSDevCenterId());
        }
        if (pSDevCenterSrvBase.isPSDevCenterNameDirty() && (bl || pSDevCenterSrvBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterSrvBase.getPSDevCenterName());
        }
        if (pSDevCenterSrvBase.isPSDevCenterSrvIdDirty() && (bl || pSDevCenterSrvBase.getPSDevCenterSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSRVID, (Object)pSDevCenterSrvBase.getPSDevCenterSrvId());
        }
        if (pSDevCenterSrvBase.isPSDevCenterSrvNameDirty() && (bl || pSDevCenterSrvBase.getPSDevCenterSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSRVNAME, (Object)pSDevCenterSrvBase.getPSDevCenterSrvName());
        }
        if (pSDevCenterSrvBase.isPSDevServerIdDirty() && (bl || pSDevCenterSrvBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDevCenterSrvBase.getPSDevServerId());
        }
        if (pSDevCenterSrvBase.isPSDevServerNameDirty() && (bl || pSDevCenterSrvBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDevCenterSrvBase.getPSDevServerName());
        }
        if (pSDevCenterSrvBase.isSVRStateDirty() && (bl || pSDevCenterSrvBase.getSVRState() != null)) {
            iDataObject.set(FIELD_SVRSTATE, (Object)pSDevCenterSrvBase.getSVRState());
        }
        if (pSDevCenterSrvBase.isUpdateDateDirty() && (bl || pSDevCenterSrvBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterSrvBase.getUpdateDate());
        }
        if (pSDevCenterSrvBase.isUpdateManDirty() && (bl || pSDevCenterSrvBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterSrvBase.getUpdateMan());
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
        return PSDevCenterSrvBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterSrvBase pSDevCenterSrvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSrvBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDevCenterSrvBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevCenterSrvBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevCenterSrvBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDevCenterSrvBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevCenterSrvBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevCenterSrvBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevCenterSrvBase.resetPSDevCenterSrvId();
                return true;
            }
            case 8: {
                pSDevCenterSrvBase.resetPSDevCenterSrvName();
                return true;
            }
            case 9: {
                pSDevCenterSrvBase.resetPSDevServerId();
                return true;
            }
            case 10: {
                pSDevCenterSrvBase.resetPSDevServerName();
                return true;
            }
            case 11: {
                pSDevCenterSrvBase.resetSVRState();
                return true;
            }
            case 12: {
                pSDevCenterSrvBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevCenterSrvBase.resetUpdateMan();
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
                pSDevServerService.autoGet((IEntity)pSDevServer);
                this.psdevserver = pSDevServer;
            }
            return this.psdevserver;
        }
    }

    private PSDevCenterSrvBase getProxyEntity() {
        return this.proxyPSDevCenterSrvBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterSrvBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterSrvBase) {
            this.proxyPSDevCenterSrvBase = (PSDevCenterSrvBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSrvService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERSRVID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERSRVNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 9);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 10);
        fieldIndexMap.put(FIELD_SVRSTATE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

