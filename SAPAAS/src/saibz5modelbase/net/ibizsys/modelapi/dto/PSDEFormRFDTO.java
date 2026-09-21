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

public class PSDEFormRFDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MAJORPSDEFORMID = "majorpsdeformid";
    public static final String FIELD_MAJORPSDEFORMNAME = "majorpsdeformname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDEFORMID = "minorpsdeformid";
    public static final String FIELD_MINORPSDEFORMNAME = "minorpsdeformname";
    public static final String FIELD_PSDEFORMRFID = "psdeformrfid";
    public static final String FIELD_PSDEFORMRFNAME = "psdeformrfname";
    public static final String FIELD_PSDEID = "psdeid";
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
    public String getMajorPSDEFormId() {
        Object objValue = this.get(FIELD_MAJORPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeformid")
    public void setMajorPSDEFormId(String majorPSDEFormId) {
        this.set(FIELD_MAJORPSDEFORMID, majorPSDEFormId);
    }

    @JsonIgnore
    public boolean isMajorPSDEFormIdDirty() {
        return this.contains(FIELD_MAJORPSDEFORMID);
    }

    @JsonIgnore
    public String getMajorPSDEFormName() {
        Object objValue = this.get(FIELD_MAJORPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeformname")
    public void setMajorPSDEFormName(String majorPSDEFormName) {
        this.set(FIELD_MAJORPSDEFORMNAME, majorPSDEFormName);
    }

    @JsonIgnore
    public boolean isMajorPSDEFormNameDirty() {
        return this.contains(FIELD_MAJORPSDEFORMNAME);
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
    public String getMinorPSDEFormId() {
        Object objValue = this.get(FIELD_MINORPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeformid")
    public void setMinorPSDEFormId(String minorPSDEFormId) {
        this.set(FIELD_MINORPSDEFORMID, minorPSDEFormId);
    }

    @JsonIgnore
    public boolean isMinorPSDEFormIdDirty() {
        return this.contains(FIELD_MINORPSDEFORMID);
    }

    @JsonIgnore
    public String getMinorPSDEFormName() {
        Object objValue = this.get(FIELD_MINORPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeformname")
    public void setMinorPSDEFormName(String minorPSDEFormName) {
        this.set(FIELD_MINORPSDEFORMNAME, minorPSDEFormName);
    }

    @JsonIgnore
    public boolean isMinorPSDEFormNameDirty() {
        return this.contains(FIELD_MINORPSDEFORMNAME);
    }

    @JsonIgnore
    public String getPSDEFormRFId() {
        Object objValue = this.get(FIELD_PSDEFORMRFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformrfid")
    public void setPSDEFormRFId(String pSDEFormRFId) {
        this.set(FIELD_PSDEFORMRFID, pSDEFormRFId);
    }

    @JsonIgnore
    public boolean isPSDEFormRFIdDirty() {
        return this.contains(FIELD_PSDEFORMRFID);
    }

    @JsonIgnore
    public String getPSDEFormRFName() {
        Object objValue = this.get(FIELD_PSDEFORMRFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformrfname")
    public void setPSDEFormRFName(String pSDEFormRFName) {
        this.set(FIELD_PSDEFORMRFNAME, pSDEFormRFName);
    }

    @JsonIgnore
    public boolean isPSDEFormRFNameDirty() {
        return this.contains(FIELD_PSDEFORMRFNAME);
    }

    @JsonIgnore
    public String getPSDEId() {
        Object objValue = this.get(FIELD_PSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeid")
    public void setPSDEId(String pSDEId) {
        this.set(FIELD_PSDEID, pSDEId);
    }

    @JsonIgnore
    public boolean isPSDEIdDirty() {
        return this.contains(FIELD_PSDEID);
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
        return this.getPSDEFormRFId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEFormRFId(strValue);
    }
}

