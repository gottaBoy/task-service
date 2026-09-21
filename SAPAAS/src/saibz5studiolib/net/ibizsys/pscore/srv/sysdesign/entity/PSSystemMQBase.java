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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemMQBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemMQBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MQID = "MQID";
    public static final String FIELD_PSDEVCENTERMQID = "PSDEVCENTERMQID";
    public static final String FIELD_PSDEVCENTERMQNAME = "PSDEVCENTERMQNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMMQID = "PSSYSTEMMQID";
    public static final String FIELD_PSSYSTEMMQNAME = "PSSYSTEMMQNAME";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RESINFO = "RESINFO";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_MQID = 3;
    private static final int INDEX_PSDEVCENTERMQID = 4;
    private static final int INDEX_PSDEVCENTERMQNAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMMQID = 7;
    private static final int INDEX_PSSYSTEMMQNAME = 8;
    private static final int INDEX_PSSYSTEMNAME = 9;
    private static final int INDEX_RESINFO = 10;
    private static final int INDEX_RESREADYTIME = 11;
    private static final int INDEX_RESSTATE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemMQBase proxyPSSystemMQBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mqidDirtyFlag = false;
    private boolean psdevcentermqidDirtyFlag = false;
    private boolean psdevcentermqnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemmqidDirtyFlag = false;
    private boolean pssystemmqnameDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean resinfoDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="mqid")
    private String mqid;
    @Column(name="psdevcentermqid")
    private String psdevcentermqid;
    @Column(name="psdevcentermqname")
    private String psdevcentermqname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemmqid")
    private String pssystemmqid;
    @Column(name="pssystemmqname")
    private String pssystemmqname;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="resinfo")
    private String resinfo;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterMQLock = new Integer(1);
    private PSDevCenterMQ psdevcentermq = null;
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

    public void setMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mqid = string;
        this.mqidDirtyFlag = true;
    }

    public String getMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMQId();
        }
        return this.mqid;
    }

    public boolean isMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMQIdDirty();
        }
        return this.mqidDirtyFlag;
    }

    public void resetMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMQId();
            return;
        }
        this.mqidDirtyFlag = false;
        this.mqid = null;
    }

    public void setPSDevCenterMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqid = string;
        this.psdevcentermqidDirtyFlag = true;
    }

    public String getPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQId();
        }
        return this.psdevcentermqid;
    }

    public boolean isPSDevCenterMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQIdDirty();
        }
        return this.psdevcentermqidDirtyFlag;
    }

    public void resetPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQId();
            return;
        }
        this.psdevcentermqidDirtyFlag = false;
        this.psdevcentermqid = null;
    }

    public void setPSDevCenterMQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqname = string;
        this.psdevcentermqnameDirtyFlag = true;
    }

    public String getPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQName();
        }
        return this.psdevcentermqname;
    }

    public boolean isPSDevCenterMQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQNameDirty();
        }
        return this.psdevcentermqnameDirtyFlag;
    }

    public void resetPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQName();
            return;
        }
        this.psdevcentermqnameDirtyFlag = false;
        this.psdevcentermqname = null;
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

    public void setPSSystemMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemmqid = string;
        this.pssystemmqidDirtyFlag = true;
    }

    public String getPSSystemMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemMQId();
        }
        return this.pssystemmqid;
    }

    public boolean isPSSystemMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemMQIdDirty();
        }
        return this.pssystemmqidDirtyFlag;
    }

    public void resetPSSystemMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemMQId();
            return;
        }
        this.pssystemmqidDirtyFlag = false;
        this.pssystemmqid = null;
    }

    public void setPSSystemMQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemMQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemmqname = string;
        this.pssystemmqnameDirtyFlag = true;
    }

    public String getPSSystemMQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemMQName();
        }
        return this.pssystemmqname;
    }

    public boolean isPSSystemMQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemMQNameDirty();
        }
        return this.pssystemmqnameDirtyFlag;
    }

    public void resetPSSystemMQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemMQName();
            return;
        }
        this.pssystemmqnameDirtyFlag = false;
        this.pssystemmqname = null;
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

    public void setResInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resinfo = string;
        this.resinfoDirtyFlag = true;
    }

    public String getResInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResInfo();
        }
        return this.resinfo;
    }

    public boolean isResInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResInfoDirty();
        }
        return this.resinfoDirtyFlag;
    }

    public void resetResInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResInfo();
            return;
        }
        this.resinfoDirtyFlag = false;
        this.resinfo = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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
        PSSystemMQBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemMQBase pSSystemMQBase) {
        pSSystemMQBase.resetCreateDate();
        pSSystemMQBase.resetCreateMan();
        pSSystemMQBase.resetMemo();
        pSSystemMQBase.resetMQId();
        pSSystemMQBase.resetPSDevCenterMQId();
        pSSystemMQBase.resetPSDevCenterMQName();
        pSSystemMQBase.resetPSSystemId();
        pSSystemMQBase.resetPSSystemMQId();
        pSSystemMQBase.resetPSSystemMQName();
        pSSystemMQBase.resetPSSystemName();
        pSSystemMQBase.resetResInfo();
        pSSystemMQBase.resetResReadyTime();
        pSSystemMQBase.resetResState();
        pSSystemMQBase.resetUpdateDate();
        pSSystemMQBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMQIdDirty()) {
            hashMap.put(FIELD_MQID, this.getMQId());
        }
        if (!bl || this.isPSDevCenterMQIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQID, this.getPSDevCenterMQId());
        }
        if (!bl || this.isPSDevCenterMQNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQNAME, this.getPSDevCenterMQName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemMQIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMMQID, this.getPSSystemMQId());
        }
        if (!bl || this.isPSSystemMQNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMMQNAME, this.getPSSystemMQName());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isResInfoDirty()) {
            hashMap.put(FIELD_RESINFO, this.getResInfo());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        return PSSystemMQBase.get(this, n);
    }

    private static Object get(PSSystemMQBase pSSystemMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemMQBase.getCreateDate();
            }
            case 1: {
                return pSSystemMQBase.getCreateMan();
            }
            case 2: {
                return pSSystemMQBase.getMemo();
            }
            case 3: {
                return pSSystemMQBase.getMQId();
            }
            case 4: {
                return pSSystemMQBase.getPSDevCenterMQId();
            }
            case 5: {
                return pSSystemMQBase.getPSDevCenterMQName();
            }
            case 6: {
                return pSSystemMQBase.getPSSystemId();
            }
            case 7: {
                return pSSystemMQBase.getPSSystemMQId();
            }
            case 8: {
                return pSSystemMQBase.getPSSystemMQName();
            }
            case 9: {
                return pSSystemMQBase.getPSSystemName();
            }
            case 10: {
                return pSSystemMQBase.getResInfo();
            }
            case 11: {
                return pSSystemMQBase.getResReadyTime();
            }
            case 12: {
                return pSSystemMQBase.getResState();
            }
            case 13: {
                return pSSystemMQBase.getUpdateDate();
            }
            case 14: {
                return pSSystemMQBase.getUpdateMan();
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
        PSSystemMQBase.set(this, n, object);
    }

    private static void set(PSSystemMQBase pSSystemMQBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemMQBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSystemMQBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSystemMQBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSystemMQBase.setMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSystemMQBase.setPSDevCenterMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSystemMQBase.setPSDevCenterMQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSystemMQBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemMQBase.setPSSystemMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemMQBase.setPSSystemMQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemMQBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSystemMQBase.setResInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSystemMQBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSystemMQBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSystemMQBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSystemMQBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSystemMQBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemMQBase pSSystemMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemMQBase.getCreateDate() == null;
            }
            case 1: {
                return pSSystemMQBase.getCreateMan() == null;
            }
            case 2: {
                return pSSystemMQBase.getMemo() == null;
            }
            case 3: {
                return pSSystemMQBase.getMQId() == null;
            }
            case 4: {
                return pSSystemMQBase.getPSDevCenterMQId() == null;
            }
            case 5: {
                return pSSystemMQBase.getPSDevCenterMQName() == null;
            }
            case 6: {
                return pSSystemMQBase.getPSSystemId() == null;
            }
            case 7: {
                return pSSystemMQBase.getPSSystemMQId() == null;
            }
            case 8: {
                return pSSystemMQBase.getPSSystemMQName() == null;
            }
            case 9: {
                return pSSystemMQBase.getPSSystemName() == null;
            }
            case 10: {
                return pSSystemMQBase.getResInfo() == null;
            }
            case 11: {
                return pSSystemMQBase.getResReadyTime() == null;
            }
            case 12: {
                return pSSystemMQBase.getResState() == null;
            }
            case 13: {
                return pSSystemMQBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSystemMQBase.getUpdateMan() == null;
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
        return PSSystemMQBase.contains(this, n);
    }

    private static boolean contains(PSSystemMQBase pSSystemMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemMQBase.isCreateDateDirty();
            }
            case 1: {
                return pSSystemMQBase.isCreateManDirty();
            }
            case 2: {
                return pSSystemMQBase.isMemoDirty();
            }
            case 3: {
                return pSSystemMQBase.isMQIdDirty();
            }
            case 4: {
                return pSSystemMQBase.isPSDevCenterMQIdDirty();
            }
            case 5: {
                return pSSystemMQBase.isPSDevCenterMQNameDirty();
            }
            case 6: {
                return pSSystemMQBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSSystemMQBase.isPSSystemMQIdDirty();
            }
            case 8: {
                return pSSystemMQBase.isPSSystemMQNameDirty();
            }
            case 9: {
                return pSSystemMQBase.isPSSystemNameDirty();
            }
            case 10: {
                return pSSystemMQBase.isResInfoDirty();
            }
            case 11: {
                return pSSystemMQBase.isResReadyTimeDirty();
            }
            case 12: {
                return pSSystemMQBase.isResStateDirty();
            }
            case 13: {
                return pSSystemMQBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSystemMQBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemMQBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemMQBase pSSystemMQBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemMQBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mqid", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getMQId()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSDevCenterMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqid", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSDevCenterMQId()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSDevCenterMQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqname", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSDevCenterMQName()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSSystemMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemmqid", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSSystemMQId()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSSystemMQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemmqname", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSSystemMQName()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getResInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resinfo", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getResInfo()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getResState()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemMQBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemMQBase.getJSONValue((Object)pSSystemMQBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemMQBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemMQBase pSSystemMQBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemMQBase.getCreateDate() != null) {
            object = pSSystemMQBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemMQBase.getCreateMan() != null) {
            object = pSSystemMQBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getMemo() != null) {
            object = pSSystemMQBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getMQId() != null) {
            object = pSSystemMQBase.getMQId();
            xmlNode.setAttribute(FIELD_MQID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSDevCenterMQId() != null) {
            object = pSSystemMQBase.getPSDevCenterMQId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSDevCenterMQName() != null) {
            object = pSSystemMQBase.getPSDevCenterMQName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSSystemId() != null) {
            object = pSSystemMQBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSSystemMQId() != null) {
            object = pSSystemMQBase.getPSSystemMQId();
            xmlNode.setAttribute(FIELD_PSSYSTEMMQID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSSystemMQName() != null) {
            object = pSSystemMQBase.getPSSystemMQName();
            xmlNode.setAttribute(FIELD_PSSYSTEMMQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getPSSystemName() != null) {
            object = pSSystemMQBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getResInfo() != null) {
            object = pSSystemMQBase.getResInfo();
            xmlNode.setAttribute(FIELD_RESINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemMQBase.getResReadyTime() != null) {
            object = pSSystemMQBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemMQBase.getResState() != null) {
            object = pSSystemMQBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemMQBase.getUpdateDate() != null) {
            object = pSSystemMQBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemMQBase.getUpdateMan() != null) {
            object = pSSystemMQBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemMQBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemMQBase pSSystemMQBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemMQBase.isCreateDateDirty() && (bl || pSSystemMQBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemMQBase.getCreateDate());
        }
        if (pSSystemMQBase.isCreateManDirty() && (bl || pSSystemMQBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemMQBase.getCreateMan());
        }
        if (pSSystemMQBase.isMemoDirty() && (bl || pSSystemMQBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemMQBase.getMemo());
        }
        if (pSSystemMQBase.isMQIdDirty() && (bl || pSSystemMQBase.getMQId() != null)) {
            iDataObject.set(FIELD_MQID, (Object)pSSystemMQBase.getMQId());
        }
        if (pSSystemMQBase.isPSDevCenterMQIdDirty() && (bl || pSSystemMQBase.getPSDevCenterMQId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQID, (Object)pSSystemMQBase.getPSDevCenterMQId());
        }
        if (pSSystemMQBase.isPSDevCenterMQNameDirty() && (bl || pSSystemMQBase.getPSDevCenterMQName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQNAME, (Object)pSSystemMQBase.getPSDevCenterMQName());
        }
        if (pSSystemMQBase.isPSSystemIdDirty() && (bl || pSSystemMQBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemMQBase.getPSSystemId());
        }
        if (pSSystemMQBase.isPSSystemMQIdDirty() && (bl || pSSystemMQBase.getPSSystemMQId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMMQID, (Object)pSSystemMQBase.getPSSystemMQId());
        }
        if (pSSystemMQBase.isPSSystemMQNameDirty() && (bl || pSSystemMQBase.getPSSystemMQName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMMQNAME, (Object)pSSystemMQBase.getPSSystemMQName());
        }
        if (pSSystemMQBase.isPSSystemNameDirty() && (bl || pSSystemMQBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemMQBase.getPSSystemName());
        }
        if (pSSystemMQBase.isResInfoDirty() && (bl || pSSystemMQBase.getResInfo() != null)) {
            iDataObject.set(FIELD_RESINFO, (Object)pSSystemMQBase.getResInfo());
        }
        if (pSSystemMQBase.isResReadyTimeDirty() && (bl || pSSystemMQBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSSystemMQBase.getResReadyTime());
        }
        if (pSSystemMQBase.isResStateDirty() && (bl || pSSystemMQBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSSystemMQBase.getResState());
        }
        if (pSSystemMQBase.isUpdateDateDirty() && (bl || pSSystemMQBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemMQBase.getUpdateDate());
        }
        if (pSSystemMQBase.isUpdateManDirty() && (bl || pSSystemMQBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemMQBase.getUpdateMan());
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
        return PSSystemMQBase.remove(this, n);
    }

    private static boolean remove(PSSystemMQBase pSSystemMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemMQBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSystemMQBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSystemMQBase.resetMemo();
                return true;
            }
            case 3: {
                pSSystemMQBase.resetMQId();
                return true;
            }
            case 4: {
                pSSystemMQBase.resetPSDevCenterMQId();
                return true;
            }
            case 5: {
                pSSystemMQBase.resetPSDevCenterMQName();
                return true;
            }
            case 6: {
                pSSystemMQBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSSystemMQBase.resetPSSystemMQId();
                return true;
            }
            case 8: {
                pSSystemMQBase.resetPSSystemMQName();
                return true;
            }
            case 9: {
                pSSystemMQBase.resetPSSystemName();
                return true;
            }
            case 10: {
                pSSystemMQBase.resetResInfo();
                return true;
            }
            case 11: {
                pSSystemMQBase.resetResReadyTime();
                return true;
            }
            case 12: {
                pSSystemMQBase.resetResState();
                return true;
            }
            case 13: {
                pSSystemMQBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSystemMQBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterMQ getPSDevCenterMQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQ();
        }
        if (this.getPSDevCenterMQId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterMQLock;
        synchronized (n) {
            if (this.psdevcentermq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterMQId(), (Object)this.psdevcentermq.getPSDevCenterMQId()) != 0L) {
                this.psdevcentermq = null;
            }
            if (this.psdevcentermq == null) {
                PSDevCenterMQ pSDevCenterMQ = new PSDevCenterMQ();
                pSDevCenterMQ.setPSDevCenterMQId(this.getPSDevCenterMQId());
                PSDevCenterMQService pSDevCenterMQService = (PSDevCenterMQService)ServiceGlobal.getService(PSDevCenterMQService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterMQService.autoGet((IEntity)pSDevCenterMQ);
                this.psdevcentermq = pSDevCenterMQ;
            }
            return this.psdevcentermq;
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

    private PSSystemMQBase getProxyEntity() {
        return this.proxyPSSystemMQBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemMQBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemMQBase) {
            this.proxyPSSystemMQBase = (PSSystemMQBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemMQService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_MQID, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMMQID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMMQNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 9);
        fieldIndexMap.put(FIELD_RESINFO, 10);
        fieldIndexMap.put(FIELD_RESREADYTIME, 11);
        fieldIndexMap.put(FIELD_RESSTATE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

