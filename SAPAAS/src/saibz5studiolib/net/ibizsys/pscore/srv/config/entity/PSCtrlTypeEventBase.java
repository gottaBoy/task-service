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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSCtrlEvent;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlEventService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeEventBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeEventBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCTRLEVENTID = "PSCTRLEVENTID";
    public static final String FIELD_PSCTRLEVENTNAME = "PSCTRLEVENTNAME";
    public static final String FIELD_PSCTRLTYPEEVENTID = "PSCTRLTYPEEVENTID";
    public static final String FIELD_PSCTRLTYPEEVENTNAME = "PSCTRLTYPEEVENTNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_R7DEXAMPLE = "R7DEXAMPLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSCTRLEVENTID = 4;
    private static final int INDEX_PSCTRLEVENTNAME = 5;
    private static final int INDEX_PSCTRLTYPEEVENTID = 6;
    private static final int INDEX_PSCTRLTYPEEVENTNAME = 7;
    private static final int INDEX_PSCTRLTYPEID = 8;
    private static final int INDEX_PSCTRLTYPENAME = 9;
    private static final int INDEX_R7DEXAMPLE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeEventBase proxyPSCtrlTypeEventBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psctrleventidDirtyFlag = false;
    private boolean psctrleventnameDirtyFlag = false;
    private boolean psctrltypeeventidDirtyFlag = false;
    private boolean psctrltypeeventnameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean r7dexampleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psctrleventid")
    private String psctrleventid;
    @Column(name="psctrleventname")
    private String psctrleventname;
    @Column(name="psctrltypeeventid")
    private String psctrltypeeventid;
    @Column(name="psctrltypeeventname")
    private String psctrltypeeventname;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="r7dexample")
    private String r7dexample;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCtrlEventLock = new Integer(1);
    private PSCtrlEvent psctrlevent = null;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSCtrlEventId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlEventId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrleventid = string;
        this.psctrleventidDirtyFlag = true;
    }

    public String getPSCtrlEventId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlEventId();
        }
        return this.psctrleventid;
    }

    public boolean isPSCtrlEventIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlEventIdDirty();
        }
        return this.psctrleventidDirtyFlag;
    }

    public void resetPSCtrlEventId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlEventId();
            return;
        }
        this.psctrleventidDirtyFlag = false;
        this.psctrleventid = null;
    }

    public void setPSCtrlEventName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlEventName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrleventname = string;
        this.psctrleventnameDirtyFlag = true;
    }

    public String getPSCtrlEventName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlEventName();
        }
        return this.psctrleventname;
    }

    public boolean isPSCtrlEventNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlEventNameDirty();
        }
        return this.psctrleventnameDirtyFlag;
    }

    public void resetPSCtrlEventName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlEventName();
            return;
        }
        this.psctrleventnameDirtyFlag = false;
        this.psctrleventname = null;
    }

    public void setPSCtrlTypeEventId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeEventId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeeventid = string;
        this.psctrltypeeventidDirtyFlag = true;
    }

    public String getPSCtrlTypeEventId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeEventId();
        }
        return this.psctrltypeeventid;
    }

    public boolean isPSCtrlTypeEventIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeEventIdDirty();
        }
        return this.psctrltypeeventidDirtyFlag;
    }

    public void resetPSCtrlTypeEventId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeEventId();
            return;
        }
        this.psctrltypeeventidDirtyFlag = false;
        this.psctrltypeeventid = null;
    }

    public void setPSCtrlTypeEventName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeEventName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeeventname = string;
        this.psctrltypeeventnameDirtyFlag = true;
    }

    public String getPSCtrlTypeEventName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeEventName();
        }
        return this.psctrltypeeventname;
    }

    public boolean isPSCtrlTypeEventNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeEventNameDirty();
        }
        return this.psctrltypeeventnameDirtyFlag;
    }

    public void resetPSCtrlTypeEventName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeEventName();
            return;
        }
        this.psctrltypeeventnameDirtyFlag = false;
        this.psctrltypeeventname = null;
    }

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setR7DExample(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR7DExample(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.r7dexample = string;
        this.r7dexampleDirtyFlag = true;
    }

    public String getR7DExample() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR7DExample();
        }
        return this.r7dexample;
    }

    public boolean isR7DExampleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR7DExampleDirty();
        }
        return this.r7dexampleDirtyFlag;
    }

    public void resetR7DExample() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR7DExample();
            return;
        }
        this.r7dexampleDirtyFlag = false;
        this.r7dexample = null;
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
        PSCtrlTypeEventBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeEventBase pSCtrlTypeEventBase) {
        pSCtrlTypeEventBase.resetCreateDate();
        pSCtrlTypeEventBase.resetCreateMan();
        pSCtrlTypeEventBase.resetMemo();
        pSCtrlTypeEventBase.resetOrderValue();
        pSCtrlTypeEventBase.resetPSCtrlEventId();
        pSCtrlTypeEventBase.resetPSCtrlEventName();
        pSCtrlTypeEventBase.resetPSCtrlTypeEventId();
        pSCtrlTypeEventBase.resetPSCtrlTypeEventName();
        pSCtrlTypeEventBase.resetPSCtrlTypeId();
        pSCtrlTypeEventBase.resetPSCtrlTypeName();
        pSCtrlTypeEventBase.resetR7DExample();
        pSCtrlTypeEventBase.resetUpdateDate();
        pSCtrlTypeEventBase.resetUpdateMan();
        pSCtrlTypeEventBase.resetValidFlag();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCtrlEventIdDirty()) {
            hashMap.put(FIELD_PSCTRLEVENTID, this.getPSCtrlEventId());
        }
        if (!bl || this.isPSCtrlEventNameDirty()) {
            hashMap.put(FIELD_PSCTRLEVENTNAME, this.getPSCtrlEventName());
        }
        if (!bl || this.isPSCtrlTypeEventIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEEVENTID, this.getPSCtrlTypeEventId());
        }
        if (!bl || this.isPSCtrlTypeEventNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEEVENTNAME, this.getPSCtrlTypeEventName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isR7DExampleDirty()) {
            hashMap.put(FIELD_R7DEXAMPLE, this.getR7DExample());
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
        return PSCtrlTypeEventBase.get(this, n);
    }

    private static Object get(PSCtrlTypeEventBase pSCtrlTypeEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeEventBase.getCreateDate();
            }
            case 1: {
                return pSCtrlTypeEventBase.getCreateMan();
            }
            case 2: {
                return pSCtrlTypeEventBase.getMemo();
            }
            case 3: {
                return pSCtrlTypeEventBase.getOrderValue();
            }
            case 4: {
                return pSCtrlTypeEventBase.getPSCtrlEventId();
            }
            case 5: {
                return pSCtrlTypeEventBase.getPSCtrlEventName();
            }
            case 6: {
                return pSCtrlTypeEventBase.getPSCtrlTypeEventId();
            }
            case 7: {
                return pSCtrlTypeEventBase.getPSCtrlTypeEventName();
            }
            case 8: {
                return pSCtrlTypeEventBase.getPSCtrlTypeId();
            }
            case 9: {
                return pSCtrlTypeEventBase.getPSCtrlTypeName();
            }
            case 10: {
                return pSCtrlTypeEventBase.getR7DExample();
            }
            case 11: {
                return pSCtrlTypeEventBase.getUpdateDate();
            }
            case 12: {
                return pSCtrlTypeEventBase.getUpdateMan();
            }
            case 13: {
                return pSCtrlTypeEventBase.getValidFlag();
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
        PSCtrlTypeEventBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeEventBase pSCtrlTypeEventBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeEventBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeEventBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeEventBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeEventBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeEventBase.setPSCtrlEventId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeEventBase.setPSCtrlEventName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeEventBase.setPSCtrlTypeEventId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeEventBase.setPSCtrlTypeEventName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeEventBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeEventBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeEventBase.setR7DExample(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlTypeEventBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlTypeEventBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlTypeEventBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlTypeEventBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeEventBase pSCtrlTypeEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeEventBase.getCreateDate() == null;
            }
            case 1: {
                return pSCtrlTypeEventBase.getCreateMan() == null;
            }
            case 2: {
                return pSCtrlTypeEventBase.getMemo() == null;
            }
            case 3: {
                return pSCtrlTypeEventBase.getOrderValue() == null;
            }
            case 4: {
                return pSCtrlTypeEventBase.getPSCtrlEventId() == null;
            }
            case 5: {
                return pSCtrlTypeEventBase.getPSCtrlEventName() == null;
            }
            case 6: {
                return pSCtrlTypeEventBase.getPSCtrlTypeEventId() == null;
            }
            case 7: {
                return pSCtrlTypeEventBase.getPSCtrlTypeEventName() == null;
            }
            case 8: {
                return pSCtrlTypeEventBase.getPSCtrlTypeId() == null;
            }
            case 9: {
                return pSCtrlTypeEventBase.getPSCtrlTypeName() == null;
            }
            case 10: {
                return pSCtrlTypeEventBase.getR7DExample() == null;
            }
            case 11: {
                return pSCtrlTypeEventBase.getUpdateDate() == null;
            }
            case 12: {
                return pSCtrlTypeEventBase.getUpdateMan() == null;
            }
            case 13: {
                return pSCtrlTypeEventBase.getValidFlag() == null;
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
        return PSCtrlTypeEventBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeEventBase pSCtrlTypeEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeEventBase.isCreateDateDirty();
            }
            case 1: {
                return pSCtrlTypeEventBase.isCreateManDirty();
            }
            case 2: {
                return pSCtrlTypeEventBase.isMemoDirty();
            }
            case 3: {
                return pSCtrlTypeEventBase.isOrderValueDirty();
            }
            case 4: {
                return pSCtrlTypeEventBase.isPSCtrlEventIdDirty();
            }
            case 5: {
                return pSCtrlTypeEventBase.isPSCtrlEventNameDirty();
            }
            case 6: {
                return pSCtrlTypeEventBase.isPSCtrlTypeEventIdDirty();
            }
            case 7: {
                return pSCtrlTypeEventBase.isPSCtrlTypeEventNameDirty();
            }
            case 8: {
                return pSCtrlTypeEventBase.isPSCtrlTypeIdDirty();
            }
            case 9: {
                return pSCtrlTypeEventBase.isPSCtrlTypeNameDirty();
            }
            case 10: {
                return pSCtrlTypeEventBase.isR7DExampleDirty();
            }
            case 11: {
                return pSCtrlTypeEventBase.isUpdateDateDirty();
            }
            case 12: {
                return pSCtrlTypeEventBase.isUpdateManDirty();
            }
            case 13: {
                return pSCtrlTypeEventBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeEventBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeEventBase pSCtrlTypeEventBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeEventBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlEventId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrleventid", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlEventId()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlEventName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrleventname", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlEventName()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeeventid", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlTypeEventId()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeeventname", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlTypeEventName()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getR7DExample() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"r7dexample", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getR7DExample()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeEventBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlTypeEventBase.getJSONValue((Object)pSCtrlTypeEventBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeEventBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeEventBase pSCtrlTypeEventBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeEventBase.getCreateDate() != null) {
            object = pSCtrlTypeEventBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeEventBase.getCreateMan() != null) {
            object = pSCtrlTypeEventBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getMemo() != null) {
            object = pSCtrlTypeEventBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getOrderValue() != null) {
            object = pSCtrlTypeEventBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlEventId() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlEventId();
            xmlNode.setAttribute(FIELD_PSCTRLEVENTID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlEventName() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlEventName();
            xmlNode.setAttribute(FIELD_PSCTRLEVENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventId() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlTypeEventId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEEVENTID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventName() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlTypeEventName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEEVENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeEventBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getR7DExample() != null) {
            object = pSCtrlTypeEventBase.getR7DExample();
            xmlNode.setAttribute(FIELD_R7DEXAMPLE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getUpdateDate() != null) {
            object = pSCtrlTypeEventBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeEventBase.getUpdateMan() != null) {
            object = pSCtrlTypeEventBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeEventBase.getValidFlag() != null) {
            object = pSCtrlTypeEventBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeEventBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeEventBase pSCtrlTypeEventBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeEventBase.isCreateDateDirty() && (bl || pSCtrlTypeEventBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeEventBase.getCreateDate());
        }
        if (pSCtrlTypeEventBase.isCreateManDirty() && (bl || pSCtrlTypeEventBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeEventBase.getCreateMan());
        }
        if (pSCtrlTypeEventBase.isMemoDirty() && (bl || pSCtrlTypeEventBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlTypeEventBase.getMemo());
        }
        if (pSCtrlTypeEventBase.isOrderValueDirty() && (bl || pSCtrlTypeEventBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlTypeEventBase.getOrderValue());
        }
        if (pSCtrlTypeEventBase.isPSCtrlEventIdDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlEventId() != null)) {
            iDataObject.set(FIELD_PSCTRLEVENTID, (Object)pSCtrlTypeEventBase.getPSCtrlEventId());
        }
        if (pSCtrlTypeEventBase.isPSCtrlEventNameDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlEventName() != null)) {
            iDataObject.set(FIELD_PSCTRLEVENTNAME, (Object)pSCtrlTypeEventBase.getPSCtrlEventName());
        }
        if (pSCtrlTypeEventBase.isPSCtrlTypeEventIdDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEEVENTID, (Object)pSCtrlTypeEventBase.getPSCtrlTypeEventId());
        }
        if (pSCtrlTypeEventBase.isPSCtrlTypeEventNameDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlTypeEventName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEEVENTNAME, (Object)pSCtrlTypeEventBase.getPSCtrlTypeEventName());
        }
        if (pSCtrlTypeEventBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeEventBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeEventBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeEventBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeEventBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeEventBase.isR7DExampleDirty() && (bl || pSCtrlTypeEventBase.getR7DExample() != null)) {
            iDataObject.set(FIELD_R7DEXAMPLE, (Object)pSCtrlTypeEventBase.getR7DExample());
        }
        if (pSCtrlTypeEventBase.isUpdateDateDirty() && (bl || pSCtrlTypeEventBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeEventBase.getUpdateDate());
        }
        if (pSCtrlTypeEventBase.isUpdateManDirty() && (bl || pSCtrlTypeEventBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeEventBase.getUpdateMan());
        }
        if (pSCtrlTypeEventBase.isValidFlagDirty() && (bl || pSCtrlTypeEventBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlTypeEventBase.getValidFlag());
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
        return PSCtrlTypeEventBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeEventBase pSCtrlTypeEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeEventBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCtrlTypeEventBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCtrlTypeEventBase.resetMemo();
                return true;
            }
            case 3: {
                pSCtrlTypeEventBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSCtrlTypeEventBase.resetPSCtrlEventId();
                return true;
            }
            case 5: {
                pSCtrlTypeEventBase.resetPSCtrlEventName();
                return true;
            }
            case 6: {
                pSCtrlTypeEventBase.resetPSCtrlTypeEventId();
                return true;
            }
            case 7: {
                pSCtrlTypeEventBase.resetPSCtrlTypeEventName();
                return true;
            }
            case 8: {
                pSCtrlTypeEventBase.resetPSCtrlTypeId();
                return true;
            }
            case 9: {
                pSCtrlTypeEventBase.resetPSCtrlTypeName();
                return true;
            }
            case 10: {
                pSCtrlTypeEventBase.resetR7DExample();
                return true;
            }
            case 11: {
                pSCtrlTypeEventBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSCtrlTypeEventBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSCtrlTypeEventBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlEvent getPSCtrlEvent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlEvent();
        }
        if (this.getPSCtrlEventId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlEventLock;
        synchronized (n) {
            if (this.psctrlevent != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlEventId(), (Object)this.psctrlevent.getPSCtrlEventId()) != 0L) {
                this.psctrlevent = null;
            }
            if (this.psctrlevent == null) {
                PSCtrlEvent pSCtrlEvent = new PSCtrlEvent();
                pSCtrlEvent.setPSCtrlEventId(this.getPSCtrlEventId());
                PSCtrlEventService pSCtrlEventService = (PSCtrlEventService)ServiceGlobal.getService(PSCtrlEventService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlEventService.autoGet(pSCtrlEvent);
                this.psctrlevent = pSCtrlEvent;
            }
            return this.psctrlevent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlType getPSCtrlType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlType();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlTypeLock;
        synchronized (n) {
            if (this.psctrltype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlTypeId(), (Object)this.psctrltype.getPSCtrlTypeId()) != 0L) {
                this.psctrltype = null;
            }
            if (this.psctrltype == null) {
                PSCtrlType pSCtrlType = new PSCtrlType();
                pSCtrlType.setPSCtrlTypeId(this.getPSCtrlTypeId());
                PSCtrlTypeService pSCtrlTypeService = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlTypeService.autoGet(pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
    }

    private PSCtrlTypeEventBase getProxyEntity() {
        return this.proxyPSCtrlTypeEventBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeEventBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeEventBase) {
            this.proxyPSCtrlTypeEventBase = (PSCtrlTypeEventBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeEventService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSCTRLEVENTID, 4);
        fieldIndexMap.put(FIELD_PSCTRLEVENTNAME, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEEVENTID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPEEVENTNAME, 7);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 8);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 9);
        fieldIndexMap.put(FIELD_R7DEXAMPLE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

