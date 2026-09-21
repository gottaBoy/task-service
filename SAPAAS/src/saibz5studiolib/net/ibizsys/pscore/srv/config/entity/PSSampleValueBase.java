/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSampleValueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSampleValueBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NULLVALUE = "NULLVALUE";
    public static final String FIELD_PSSAMPLEVALUEID = "PSSAMPLEVALUEID";
    public static final String FIELD_PSSAMPLEVALUENAME = "PSSAMPLEVALUENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUELIST = "VALUELIST";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_NULLVALUE = 3;
    private static final int INDEX_PSSAMPLEVALUEID = 4;
    private static final int INDEX_PSSAMPLEVALUENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final int INDEX_VALUE = 9;
    private static final int INDEX_VALUELIST = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSampleValueBase proxyPSSampleValueBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nullvalueDirtyFlag = false;
    private boolean pssamplevalueidDirtyFlag = false;
    private boolean pssamplevaluenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean valuelistDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="nullvalue")
    private Integer nullvalue;
    @Column(name="pssamplevalueid")
    private String pssamplevalueid;
    @Column(name="pssamplevaluename")
    private String pssamplevaluename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    @Column(name="valuelist")
    private String valuelist;

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

    public void setNullValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNullValue(n);
            return;
        }
        this.nullvalue = n;
        this.nullvalueDirtyFlag = true;
    }

    public Integer getNullValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNullValue();
        }
        return this.nullvalue;
    }

    public boolean isNullValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNullValueDirty();
        }
        return this.nullvalueDirtyFlag;
    }

    public void resetNullValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNullValue();
            return;
        }
        this.nullvalueDirtyFlag = false;
        this.nullvalue = null;
    }

    public void setPSSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssamplevalueid = string;
        this.pssamplevalueidDirtyFlag = true;
    }

    public String getPSSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSampleValueId();
        }
        return this.pssamplevalueid;
    }

    public boolean isPSSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSampleValueIdDirty();
        }
        return this.pssamplevalueidDirtyFlag;
    }

    public void resetPSSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSampleValueId();
            return;
        }
        this.pssamplevalueidDirtyFlag = false;
        this.pssamplevalueid = null;
    }

    public void setPSSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssamplevaluename = string;
        this.pssamplevaluenameDirtyFlag = true;
    }

    public String getPSSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSampleValueName();
        }
        return this.pssamplevaluename;
    }

    public boolean isPSSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSampleValueNameDirty();
        }
        return this.pssamplevaluenameDirtyFlag;
    }

    public void resetPSSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSampleValueName();
            return;
        }
        this.pssamplevaluenameDirtyFlag = false;
        this.pssamplevaluename = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValueList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuelist = string;
        this.valuelistDirtyFlag = true;
    }

    public String getValueList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueList();
        }
        return this.valuelist;
    }

    public boolean isValueListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueListDirty();
        }
        return this.valuelistDirtyFlag;
    }

    public void resetValueList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueList();
            return;
        }
        this.valuelistDirtyFlag = false;
        this.valuelist = null;
    }

    protected void onReset() {
        PSSampleValueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSampleValueBase pSSampleValueBase) {
        pSSampleValueBase.resetCreateDate();
        pSSampleValueBase.resetCreateMan();
        pSSampleValueBase.resetMemo();
        pSSampleValueBase.resetNullValue();
        pSSampleValueBase.resetPSSampleValueId();
        pSSampleValueBase.resetPSSampleValueName();
        pSSampleValueBase.resetUpdateDate();
        pSSampleValueBase.resetUpdateMan();
        pSSampleValueBase.resetValidFlag();
        pSSampleValueBase.resetValue();
        pSSampleValueBase.resetValueList();
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
        if (!bl || this.isNullValueDirty()) {
            hashMap.put(FIELD_NULLVALUE, this.getNullValue());
        }
        if (!bl || this.isPSSampleValueIdDirty()) {
            hashMap.put(FIELD_PSSAMPLEVALUEID, this.getPSSampleValueId());
        }
        if (!bl || this.isPSSampleValueNameDirty()) {
            hashMap.put(FIELD_PSSAMPLEVALUENAME, this.getPSSampleValueName());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValueListDirty()) {
            hashMap.put(FIELD_VALUELIST, this.getValueList());
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
        return PSSampleValueBase.get(this, n);
    }

    private static Object get(PSSampleValueBase pSSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSampleValueBase.getCreateDate();
            }
            case 1: {
                return pSSampleValueBase.getCreateMan();
            }
            case 2: {
                return pSSampleValueBase.getMemo();
            }
            case 3: {
                return pSSampleValueBase.getNullValue();
            }
            case 4: {
                return pSSampleValueBase.getPSSampleValueId();
            }
            case 5: {
                return pSSampleValueBase.getPSSampleValueName();
            }
            case 6: {
                return pSSampleValueBase.getUpdateDate();
            }
            case 7: {
                return pSSampleValueBase.getUpdateMan();
            }
            case 8: {
                return pSSampleValueBase.getValidFlag();
            }
            case 9: {
                return pSSampleValueBase.getValue();
            }
            case 10: {
                return pSSampleValueBase.getValueList();
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
        PSSampleValueBase.set(this, n, object);
    }

    private static void set(PSSampleValueBase pSSampleValueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSampleValueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSampleValueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSampleValueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSampleValueBase.setNullValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSampleValueBase.setPSSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSampleValueBase.setPSSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSampleValueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSampleValueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSampleValueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSampleValueBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSampleValueBase.setValueList(DataObject.getStringValue((Object)object));
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
        return PSSampleValueBase.isNull(this, n);
    }

    private static boolean isNull(PSSampleValueBase pSSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSampleValueBase.getCreateDate() == null;
            }
            case 1: {
                return pSSampleValueBase.getCreateMan() == null;
            }
            case 2: {
                return pSSampleValueBase.getMemo() == null;
            }
            case 3: {
                return pSSampleValueBase.getNullValue() == null;
            }
            case 4: {
                return pSSampleValueBase.getPSSampleValueId() == null;
            }
            case 5: {
                return pSSampleValueBase.getPSSampleValueName() == null;
            }
            case 6: {
                return pSSampleValueBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSampleValueBase.getUpdateMan() == null;
            }
            case 8: {
                return pSSampleValueBase.getValidFlag() == null;
            }
            case 9: {
                return pSSampleValueBase.getValue() == null;
            }
            case 10: {
                return pSSampleValueBase.getValueList() == null;
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
        return PSSampleValueBase.contains(this, n);
    }

    private static boolean contains(PSSampleValueBase pSSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSampleValueBase.isCreateDateDirty();
            }
            case 1: {
                return pSSampleValueBase.isCreateManDirty();
            }
            case 2: {
                return pSSampleValueBase.isMemoDirty();
            }
            case 3: {
                return pSSampleValueBase.isNullValueDirty();
            }
            case 4: {
                return pSSampleValueBase.isPSSampleValueIdDirty();
            }
            case 5: {
                return pSSampleValueBase.isPSSampleValueNameDirty();
            }
            case 6: {
                return pSSampleValueBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSampleValueBase.isUpdateManDirty();
            }
            case 8: {
                return pSSampleValueBase.isValidFlagDirty();
            }
            case 9: {
                return pSSampleValueBase.isValueDirty();
            }
            case 10: {
                return pSSampleValueBase.isValueListDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSampleValueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSampleValueBase pSSampleValueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSampleValueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getMemo()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getNullValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nullvalue", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getNullValue()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getPSSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssamplevalueid", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getPSSampleValueId()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getPSSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssamplevaluename", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getPSSampleValueName()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getValue()), (boolean)false);
        }
        if (bl || pSSampleValueBase.getValueList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuelist", (Object)PSSampleValueBase.getJSONValue((Object)pSSampleValueBase.getValueList()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSampleValueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSampleValueBase pSSampleValueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSampleValueBase.getCreateDate() != null) {
            object = pSSampleValueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSampleValueBase.getCreateMan() != null) {
            object = pSSampleValueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getMemo() != null) {
            object = pSSampleValueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getNullValue() != null) {
            object = pSSampleValueBase.getNullValue();
            xmlNode.setAttribute(FIELD_NULLVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSampleValueBase.getPSSampleValueId() != null) {
            object = pSSampleValueBase.getPSSampleValueId();
            xmlNode.setAttribute(FIELD_PSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getPSSampleValueName() != null) {
            object = pSSampleValueBase.getPSSampleValueName();
            xmlNode.setAttribute(FIELD_PSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getUpdateDate() != null) {
            object = pSSampleValueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSampleValueBase.getUpdateMan() != null) {
            object = pSSampleValueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getValidFlag() != null) {
            object = pSSampleValueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSampleValueBase.getValue() != null) {
            object = pSSampleValueBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSampleValueBase.getValueList() != null) {
            object = pSSampleValueBase.getValueList();
            xmlNode.setAttribute(FIELD_VALUELIST, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSampleValueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSampleValueBase pSSampleValueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSampleValueBase.isCreateDateDirty() && (bl || pSSampleValueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSampleValueBase.getCreateDate());
        }
        if (pSSampleValueBase.isCreateManDirty() && (bl || pSSampleValueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSampleValueBase.getCreateMan());
        }
        if (pSSampleValueBase.isMemoDirty() && (bl || pSSampleValueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSampleValueBase.getMemo());
        }
        if (pSSampleValueBase.isNullValueDirty() && (bl || pSSampleValueBase.getNullValue() != null)) {
            iDataObject.set(FIELD_NULLVALUE, (Object)pSSampleValueBase.getNullValue());
        }
        if (pSSampleValueBase.isPSSampleValueIdDirty() && (bl || pSSampleValueBase.getPSSampleValueId() != null)) {
            iDataObject.set(FIELD_PSSAMPLEVALUEID, (Object)pSSampleValueBase.getPSSampleValueId());
        }
        if (pSSampleValueBase.isPSSampleValueNameDirty() && (bl || pSSampleValueBase.getPSSampleValueName() != null)) {
            iDataObject.set(FIELD_PSSAMPLEVALUENAME, (Object)pSSampleValueBase.getPSSampleValueName());
        }
        if (pSSampleValueBase.isUpdateDateDirty() && (bl || pSSampleValueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSampleValueBase.getUpdateDate());
        }
        if (pSSampleValueBase.isUpdateManDirty() && (bl || pSSampleValueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSampleValueBase.getUpdateMan());
        }
        if (pSSampleValueBase.isValidFlagDirty() && (bl || pSSampleValueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSampleValueBase.getValidFlag());
        }
        if (pSSampleValueBase.isValueDirty() && (bl || pSSampleValueBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSSampleValueBase.getValue());
        }
        if (pSSampleValueBase.isValueListDirty() && (bl || pSSampleValueBase.getValueList() != null)) {
            iDataObject.set(FIELD_VALUELIST, (Object)pSSampleValueBase.getValueList());
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
        return PSSampleValueBase.remove(this, n);
    }

    private static boolean remove(PSSampleValueBase pSSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSampleValueBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSampleValueBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSampleValueBase.resetMemo();
                return true;
            }
            case 3: {
                pSSampleValueBase.resetNullValue();
                return true;
            }
            case 4: {
                pSSampleValueBase.resetPSSampleValueId();
                return true;
            }
            case 5: {
                pSSampleValueBase.resetPSSampleValueName();
                return true;
            }
            case 6: {
                pSSampleValueBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSampleValueBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSSampleValueBase.resetValidFlag();
                return true;
            }
            case 9: {
                pSSampleValueBase.resetValue();
                return true;
            }
            case 10: {
                pSSampleValueBase.resetValueList();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSampleValueBase getProxyEntity() {
        return this.proxyPSSampleValueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSampleValueBase = null;
        if (iDataObject != null && iDataObject instanceof PSSampleValueBase) {
            this.proxyPSSampleValueBase = (PSSampleValueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSampleValueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_NULLVALUE, 3);
        fieldIndexMap.put(FIELD_PSSAMPLEVALUEID, 4);
        fieldIndexMap.put(FIELD_PSSAMPLEVALUENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
        fieldIndexMap.put(FIELD_VALUE, 9);
        fieldIndexMap.put(FIELD_VALUELIST, 10);
    }
}

