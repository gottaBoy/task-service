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

public class PSDEFIUDetailDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_PSDEFIUDETAILID = "psdefiudetailid";
    public static final String FIELD_PSDEFIUDETAILNAME = "psdefiudetailname";
    public static final String FIELD_PSDEFIUPDATEID = "psdefiupdateid";
    public static final String FIELD_PSDEFIUPDATENAME = "psdefiupdatename";
    public static final String FIELD_PSDEFORMDETAILID = "psdeformdetailid";
    public static final String FIELD_PSDEFORMDETAILNAME = "psdeformdetailname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getPSDEFIUDetailId() {
        Object objValue = this.get(FIELD_PSDEFIUDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiudetailid")
    public void setPSDEFIUDetailId(String pSDEFIUDetailId) {
        this.set(FIELD_PSDEFIUDETAILID, pSDEFIUDetailId);
    }

    @JsonIgnore
    public boolean isPSDEFIUDetailIdDirty() {
        return this.contains(FIELD_PSDEFIUDETAILID);
    }

    @JsonIgnore
    public String getPSDEFIUDetailName() {
        Object objValue = this.get(FIELD_PSDEFIUDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiudetailname")
    public void setPSDEFIUDetailName(String pSDEFIUDetailName) {
        this.set(FIELD_PSDEFIUDETAILNAME, pSDEFIUDetailName);
    }

    @JsonIgnore
    public boolean isPSDEFIUDetailNameDirty() {
        return this.contains(FIELD_PSDEFIUDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEFIUpdateId() {
        Object objValue = this.get(FIELD_PSDEFIUPDATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiupdateid")
    public void setPSDEFIUpdateId(String pSDEFIUpdateId) {
        this.set(FIELD_PSDEFIUPDATEID, pSDEFIUpdateId);
    }

    @JsonIgnore
    public boolean isPSDEFIUpdateIdDirty() {
        return this.contains(FIELD_PSDEFIUPDATEID);
    }

    @JsonIgnore
    public String getPSDEFIUpdateName() {
        Object objValue = this.get(FIELD_PSDEFIUPDATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiupdatename")
    public void setPSDEFIUpdateName(String pSDEFIUpdateName) {
        this.set(FIELD_PSDEFIUPDATENAME, pSDEFIUpdateName);
    }

    @JsonIgnore
    public boolean isPSDEFIUpdateNameDirty() {
        return this.contains(FIELD_PSDEFIUPDATENAME);
    }

    @JsonIgnore
    public String getPSDEFormDetailId() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailid")
    public void setPSDEFormDetailId(String pSDEFormDetailId) {
        this.set(FIELD_PSDEFORMDETAILID, pSDEFormDetailId);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailIdDirty() {
        return this.contains(FIELD_PSDEFORMDETAILID);
    }

    @JsonIgnore
    public String getPSDEFormDetailName() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailname")
    public void setPSDEFormDetailName(String pSDEFormDetailName) {
        this.set(FIELD_PSDEFORMDETAILNAME, pSDEFormDetailName);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailNameDirty() {
        return this.contains(FIELD_PSDEFORMDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
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
        return this.getPSDEFIUDetailId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEFIUDetailId(strValue);
    }
}

