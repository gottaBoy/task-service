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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelHotCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelHotCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EVENTTYPE = "EVENTTYPE";
    public static final String FIELD_JSCODE = "JSCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELHOTCODEID = "PSMODELHOTCODEID";
    public static final String FIELD_PSMODELHOTCODENAME = "PSMODELHOTCODENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EVENTTYPE = 2;
    private static final int INDEX_JSCODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSMODELHOTCODEID = 6;
    private static final int INDEX_PSMODELHOTCODENAME = 7;
    private static final int INDEX_PSMODELID = 8;
    private static final int INDEX_PSMODELNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelHotCodeBase proxyPSModelHotCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean jscodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelhotcodeidDirtyFlag = false;
    private boolean psmodelhotcodenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="eventtype")
    private String eventtype;
    @Column(name="jscode")
    private String jscode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelhotcodeid")
    private String psmodelhotcodeid;
    @Column(name="psmodelhotcodename")
    private String psmodelhotcodename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setEventType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventtype = string;
        this.eventtypeDirtyFlag = true;
    }

    public String getEventType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventType();
        }
        return this.eventtype;
    }

    public boolean isEventTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventTypeDirty();
        }
        return this.eventtypeDirtyFlag;
    }

    public void resetEventType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventType();
            return;
        }
        this.eventtypeDirtyFlag = false;
        this.eventtype = null;
    }

    public void setJSCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jscode = string;
        this.jscodeDirtyFlag = true;
    }

    public String getJSCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSCode();
        }
        return this.jscode;
    }

    public boolean isJSCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSCodeDirty();
        }
        return this.jscodeDirtyFlag;
    }

    public void resetJSCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSCode();
            return;
        }
        this.jscodeDirtyFlag = false;
        this.jscode = null;
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

    public void setPSModelHotCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelHotCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelhotcodeid = string;
        this.psmodelhotcodeidDirtyFlag = true;
    }

    public String getPSModelHotCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelHotCodeId();
        }
        return this.psmodelhotcodeid;
    }

    public boolean isPSModelHotCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelHotCodeIdDirty();
        }
        return this.psmodelhotcodeidDirtyFlag;
    }

    public void resetPSModelHotCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelHotCodeId();
            return;
        }
        this.psmodelhotcodeidDirtyFlag = false;
        this.psmodelhotcodeid = null;
    }

    public void setPSModelHotCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelHotCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelhotcodename = string;
        this.psmodelhotcodenameDirtyFlag = true;
    }

    public String getPSModelHotCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelHotCodeName();
        }
        return this.psmodelhotcodename;
    }

    public boolean isPSModelHotCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelHotCodeNameDirty();
        }
        return this.psmodelhotcodenameDirtyFlag;
    }

    public void resetPSModelHotCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelHotCodeName();
            return;
        }
        this.psmodelhotcodenameDirtyFlag = false;
        this.psmodelhotcodename = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
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
        PSModelHotCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelHotCodeBase pSModelHotCodeBase) {
        pSModelHotCodeBase.resetCreateDate();
        pSModelHotCodeBase.resetCreateMan();
        pSModelHotCodeBase.resetEventType();
        pSModelHotCodeBase.resetJSCode();
        pSModelHotCodeBase.resetMemo();
        pSModelHotCodeBase.resetOrderValue();
        pSModelHotCodeBase.resetPSModelHotCodeId();
        pSModelHotCodeBase.resetPSModelHotCodeName();
        pSModelHotCodeBase.resetPSModelId();
        pSModelHotCodeBase.resetPSModelName();
        pSModelHotCodeBase.resetUpdateDate();
        pSModelHotCodeBase.resetUpdateMan();
        pSModelHotCodeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEventTypeDirty()) {
            hashMap.put(FIELD_EVENTTYPE, this.getEventType());
        }
        if (!bl || this.isJSCodeDirty()) {
            hashMap.put(FIELD_JSCODE, this.getJSCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelHotCodeIdDirty()) {
            hashMap.put(FIELD_PSMODELHOTCODEID, this.getPSModelHotCodeId());
        }
        if (!bl || this.isPSModelHotCodeNameDirty()) {
            hashMap.put(FIELD_PSMODELHOTCODENAME, this.getPSModelHotCodeName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
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
        return PSModelHotCodeBase.get(this, n);
    }

    private static Object get(PSModelHotCodeBase pSModelHotCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelHotCodeBase.getCreateDate();
            }
            case 1: {
                return pSModelHotCodeBase.getCreateMan();
            }
            case 2: {
                return pSModelHotCodeBase.getEventType();
            }
            case 3: {
                return pSModelHotCodeBase.getJSCode();
            }
            case 4: {
                return pSModelHotCodeBase.getMemo();
            }
            case 5: {
                return pSModelHotCodeBase.getOrderValue();
            }
            case 6: {
                return pSModelHotCodeBase.getPSModelHotCodeId();
            }
            case 7: {
                return pSModelHotCodeBase.getPSModelHotCodeName();
            }
            case 8: {
                return pSModelHotCodeBase.getPSModelId();
            }
            case 9: {
                return pSModelHotCodeBase.getPSModelName();
            }
            case 10: {
                return pSModelHotCodeBase.getUpdateDate();
            }
            case 11: {
                return pSModelHotCodeBase.getUpdateMan();
            }
            case 12: {
                return pSModelHotCodeBase.getValidFlag();
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
        PSModelHotCodeBase.set(this, n, object);
    }

    private static void set(PSModelHotCodeBase pSModelHotCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelHotCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelHotCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelHotCodeBase.setEventType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelHotCodeBase.setJSCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelHotCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelHotCodeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelHotCodeBase.setPSModelHotCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelHotCodeBase.setPSModelHotCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelHotCodeBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelHotCodeBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelHotCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSModelHotCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelHotCodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelHotCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSModelHotCodeBase pSModelHotCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelHotCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelHotCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelHotCodeBase.getEventType() == null;
            }
            case 3: {
                return pSModelHotCodeBase.getJSCode() == null;
            }
            case 4: {
                return pSModelHotCodeBase.getMemo() == null;
            }
            case 5: {
                return pSModelHotCodeBase.getOrderValue() == null;
            }
            case 6: {
                return pSModelHotCodeBase.getPSModelHotCodeId() == null;
            }
            case 7: {
                return pSModelHotCodeBase.getPSModelHotCodeName() == null;
            }
            case 8: {
                return pSModelHotCodeBase.getPSModelId() == null;
            }
            case 9: {
                return pSModelHotCodeBase.getPSModelName() == null;
            }
            case 10: {
                return pSModelHotCodeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSModelHotCodeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSModelHotCodeBase.getValidFlag() == null;
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
        return PSModelHotCodeBase.contains(this, n);
    }

    private static boolean contains(PSModelHotCodeBase pSModelHotCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelHotCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelHotCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSModelHotCodeBase.isEventTypeDirty();
            }
            case 3: {
                return pSModelHotCodeBase.isJSCodeDirty();
            }
            case 4: {
                return pSModelHotCodeBase.isMemoDirty();
            }
            case 5: {
                return pSModelHotCodeBase.isOrderValueDirty();
            }
            case 6: {
                return pSModelHotCodeBase.isPSModelHotCodeIdDirty();
            }
            case 7: {
                return pSModelHotCodeBase.isPSModelHotCodeNameDirty();
            }
            case 8: {
                return pSModelHotCodeBase.isPSModelIdDirty();
            }
            case 9: {
                return pSModelHotCodeBase.isPSModelNameDirty();
            }
            case 10: {
                return pSModelHotCodeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSModelHotCodeBase.isUpdateManDirty();
            }
            case 12: {
                return pSModelHotCodeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelHotCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelHotCodeBase pSModelHotCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelHotCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getEventType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventtype", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getEventType()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getJSCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jscode", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getJSCode()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getPSModelHotCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelhotcodeid", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getPSModelHotCodeId()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getPSModelHotCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelhotcodename", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getPSModelHotCodeName()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelHotCodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelHotCodeBase.getJSONValue((Object)pSModelHotCodeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelHotCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelHotCodeBase pSModelHotCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelHotCodeBase.getCreateDate() != null) {
            object = pSModelHotCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelHotCodeBase.getCreateMan() != null) {
            object = pSModelHotCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getEventType() != null) {
            object = pSModelHotCodeBase.getEventType();
            xmlNode.setAttribute(FIELD_EVENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getJSCode() != null) {
            object = pSModelHotCodeBase.getJSCode();
            xmlNode.setAttribute(FIELD_JSCODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getMemo() != null) {
            object = pSModelHotCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getOrderValue() != null) {
            object = pSModelHotCodeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelHotCodeBase.getPSModelHotCodeId() != null) {
            object = pSModelHotCodeBase.getPSModelHotCodeId();
            xmlNode.setAttribute(FIELD_PSMODELHOTCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getPSModelHotCodeName() != null) {
            object = pSModelHotCodeBase.getPSModelHotCodeName();
            xmlNode.setAttribute(FIELD_PSMODELHOTCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getPSModelId() != null) {
            object = pSModelHotCodeBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getPSModelName() != null) {
            object = pSModelHotCodeBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getUpdateDate() != null) {
            object = pSModelHotCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelHotCodeBase.getUpdateMan() != null) {
            object = pSModelHotCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelHotCodeBase.getValidFlag() != null) {
            object = pSModelHotCodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelHotCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelHotCodeBase pSModelHotCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelHotCodeBase.isCreateDateDirty() && (bl || pSModelHotCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelHotCodeBase.getCreateDate());
        }
        if (pSModelHotCodeBase.isCreateManDirty() && (bl || pSModelHotCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelHotCodeBase.getCreateMan());
        }
        if (pSModelHotCodeBase.isEventTypeDirty() && (bl || pSModelHotCodeBase.getEventType() != null)) {
            iDataObject.set(FIELD_EVENTTYPE, (Object)pSModelHotCodeBase.getEventType());
        }
        if (pSModelHotCodeBase.isJSCodeDirty() && (bl || pSModelHotCodeBase.getJSCode() != null)) {
            iDataObject.set(FIELD_JSCODE, (Object)pSModelHotCodeBase.getJSCode());
        }
        if (pSModelHotCodeBase.isMemoDirty() && (bl || pSModelHotCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelHotCodeBase.getMemo());
        }
        if (pSModelHotCodeBase.isOrderValueDirty() && (bl || pSModelHotCodeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelHotCodeBase.getOrderValue());
        }
        if (pSModelHotCodeBase.isPSModelHotCodeIdDirty() && (bl || pSModelHotCodeBase.getPSModelHotCodeId() != null)) {
            iDataObject.set(FIELD_PSMODELHOTCODEID, (Object)pSModelHotCodeBase.getPSModelHotCodeId());
        }
        if (pSModelHotCodeBase.isPSModelHotCodeNameDirty() && (bl || pSModelHotCodeBase.getPSModelHotCodeName() != null)) {
            iDataObject.set(FIELD_PSMODELHOTCODENAME, (Object)pSModelHotCodeBase.getPSModelHotCodeName());
        }
        if (pSModelHotCodeBase.isPSModelIdDirty() && (bl || pSModelHotCodeBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelHotCodeBase.getPSModelId());
        }
        if (pSModelHotCodeBase.isPSModelNameDirty() && (bl || pSModelHotCodeBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelHotCodeBase.getPSModelName());
        }
        if (pSModelHotCodeBase.isUpdateDateDirty() && (bl || pSModelHotCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelHotCodeBase.getUpdateDate());
        }
        if (pSModelHotCodeBase.isUpdateManDirty() && (bl || pSModelHotCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelHotCodeBase.getUpdateMan());
        }
        if (pSModelHotCodeBase.isValidFlagDirty() && (bl || pSModelHotCodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelHotCodeBase.getValidFlag());
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
        return PSModelHotCodeBase.remove(this, n);
    }

    private static boolean remove(PSModelHotCodeBase pSModelHotCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelHotCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelHotCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelHotCodeBase.resetEventType();
                return true;
            }
            case 3: {
                pSModelHotCodeBase.resetJSCode();
                return true;
            }
            case 4: {
                pSModelHotCodeBase.resetMemo();
                return true;
            }
            case 5: {
                pSModelHotCodeBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSModelHotCodeBase.resetPSModelHotCodeId();
                return true;
            }
            case 7: {
                pSModelHotCodeBase.resetPSModelHotCodeName();
                return true;
            }
            case 8: {
                pSModelHotCodeBase.resetPSModelId();
                return true;
            }
            case 9: {
                pSModelHotCodeBase.resetPSModelName();
                return true;
            }
            case 10: {
                pSModelHotCodeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSModelHotCodeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSModelHotCodeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelHotCodeBase getProxyEntity() {
        return this.proxyPSModelHotCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelHotCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelHotCodeBase) {
            this.proxyPSModelHotCodeBase = (PSModelHotCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelHotCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EVENTTYPE, 2);
        fieldIndexMap.put(FIELD_JSCODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSMODELHOTCODEID, 6);
        fieldIndexMap.put(FIELD_PSMODELHOTCODENAME, 7);
        fieldIndexMap.put(FIELD_PSMODELID, 8);
        fieldIndexMap.put(FIELD_PSMODELNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

