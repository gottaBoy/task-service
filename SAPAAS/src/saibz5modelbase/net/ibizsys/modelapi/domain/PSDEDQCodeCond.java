/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDQCodeCond
extends PSModelBase {
    public static final String FIELD_CONDCODE = "condcode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDQCODECONDID = "psdedqcodecondid";
    public static final String FIELD_PSDEDQCODECONDNAME = "psdedqcodecondname";
    public static final String FIELD_PSDEDQCODEID = "psdedqcodeid";
    public static final String FIELD_PSDEDQCODENAME = "psdedqcodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

    @JsonIgnore
    public String getCondCode() {
        Object objValue = this.get(FIELD_CONDCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condcode")
    public void setCondCode(String condCode) {
        this.set(FIELD_CONDCODE, condCode);
    }

    @JsonIgnore
    public boolean isCondCodeDirty() {
        return this.contains(FIELD_CONDCODE);
    }

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public String getPSDEDQCodeCondId() {
        Object objValue = this.get(FIELD_PSDEDQCODECONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodecondid")
    public void setPSDEDQCodeCondId(String pSDEDQCodeCondId) {
        this.set(FIELD_PSDEDQCODECONDID, pSDEDQCodeCondId);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeCondIdDirty() {
        return this.contains(FIELD_PSDEDQCODECONDID);
    }

    @JsonIgnore
    public String getPSDEDQCodeCondName() {
        Object objValue = this.get(FIELD_PSDEDQCODECONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodecondname")
    public void setPSDEDQCodeCondName(String pSDEDQCodeCondName) {
        this.set(FIELD_PSDEDQCODECONDNAME, pSDEDQCodeCondName);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeCondNameDirty() {
        return this.contains(FIELD_PSDEDQCODECONDNAME);
    }

    @JsonIgnore
    public String getPSDEDQCodeId() {
        Object objValue = this.get(FIELD_PSDEDQCODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodeid")
    public void setPSDEDQCodeId(String pSDEDQCodeId) {
        this.set(FIELD_PSDEDQCODEID, pSDEDQCodeId);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeIdDirty() {
        return this.contains(FIELD_PSDEDQCODEID);
    }

    @JsonIgnore
    public String getPSDEDQCodeName() {
        Object objValue = this.get(FIELD_PSDEDQCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodename")
    public void setPSDEDQCodeName(String pSDEDQCodeName) {
        this.set(FIELD_PSDEDQCODENAME, pSDEDQCodeName);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeNameDirty() {
        return this.contains(FIELD_PSDEDQCODENAME);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDQCodeCondId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDQCodeCondId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEDQCODECOND";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDQCodeCond item = (PSDEDQCodeCond)MAPPER.readValue(new File(strJsonFilePath), PSDEDQCodeCond.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDQCodeCond) {
            PSDEDQCodeCond pSDEDQCodeCond = (PSDEDQCodeCond)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDQCodeCond) {
            PSDEDQCodeCond pSDEDQCodeCond = (PSDEDQCodeCond)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

