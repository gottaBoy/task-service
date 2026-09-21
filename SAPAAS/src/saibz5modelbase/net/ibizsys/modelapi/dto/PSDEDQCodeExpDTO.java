/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEDQCodeExpDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EXPCODE = "expcode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDQCODEEXPID = "psdedqcodeexpid";
    public static final String FIELD_PSDEDQCODEEXPNAME = "psdedqcodeexpname";
    public static final String FIELD_PSDEDQCODEID = "psdedqcodeid";
    public static final String FIELD_PSDEDQCODENAME = "psdedqcodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getExpCode() {
        Object objValue = this.get(FIELD_EXPCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="expcode")
    public void setExpCode(String expCode) {
        this.set(FIELD_EXPCODE, expCode);
    }

    @JsonIgnore
    public boolean isExpCodeDirty() {
        return this.contains(FIELD_EXPCODE);
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
    public String getPSDEDQCodeExpId() {
        Object objValue = this.get(FIELD_PSDEDQCODEEXPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodeexpid")
    public void setPSDEDQCodeExpId(String pSDEDQCodeExpId) {
        this.set(FIELD_PSDEDQCODEEXPID, pSDEDQCodeExpId);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeExpIdDirty() {
        return this.contains(FIELD_PSDEDQCODEEXPID);
    }

    @JsonIgnore
    public String getPSDEDQCodeExpName() {
        Object objValue = this.get(FIELD_PSDEDQCODEEXPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodeexpname")
    public void setPSDEDQCodeExpName(String pSDEDQCodeExpName) {
        this.set(FIELD_PSDEDQCODEEXPNAME, pSDEDQCodeExpName);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeExpNameDirty() {
        return this.contains(FIELD_PSDEDQCODEEXPNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDQCodeExpId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDQCodeExpId(strValue);
    }
}

