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

public class PSSysCalendarItemRVDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSCALENDARID = "pssyscalendarid";
    public static final String FIELD_PSSYSCALENDARITEMID = "pssyscalendaritemid";
    public static final String FIELD_PSSYSCALENDARITEMNAME = "pssyscalendaritemname";
    public static final String FIELD_PSSYSCALENDARITEMRVID = "pssyscalendaritemrvid";
    public static final String FIELD_PSSYSCALENDARITEMRVNAME = "pssyscalendaritemrvname";
    public static final String FIELD_REFMODETEXT = "refmodetext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VIEWPARAMS = "viewparams";

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
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getPSSysCalendarId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendarid")
    public void setPSSysCalendarId(String pSSysCalendarId) {
        this.set(FIELD_PSSYSCALENDARID, pSSysCalendarId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARID);
    }

    @JsonIgnore
    public String getPSSysCalendarItemId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemid")
    public void setPSSysCalendarItemId(String pSSysCalendarItemId) {
        this.set(FIELD_PSSYSCALENDARITEMID, pSSysCalendarItemId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMID);
    }

    @JsonIgnore
    public String getPSSysCalendarItemName() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemname")
    public void setPSSysCalendarItemName(String pSSysCalendarItemName) {
        this.set(FIELD_PSSYSCALENDARITEMNAME, pSSysCalendarItemName);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemNameDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMNAME);
    }

    @JsonIgnore
    public String getPSSysCalendarItemRVId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMRVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemrvid")
    public void setPSSysCalendarItemRVId(String pSSysCalendarItemRVId) {
        this.set(FIELD_PSSYSCALENDARITEMRVID, pSSysCalendarItemRVId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemRVIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMRVID);
    }

    @JsonIgnore
    public String getPSSysCalendarItemRVName() {
        Object objValue = this.get(FIELD_PSSYSCALENDARITEMRVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendaritemrvname")
    public void setPSSysCalendarItemRVName(String pSSysCalendarItemRVName) {
        this.set(FIELD_PSSYSCALENDARITEMRVNAME, pSSysCalendarItemRVName);
    }

    @JsonIgnore
    public boolean isPSSysCalendarItemRVNameDirty() {
        return this.contains(FIELD_PSSYSCALENDARITEMRVNAME);
    }

    @JsonIgnore
    public String getRefModeText() {
        Object objValue = this.get(FIELD_REFMODETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmodetext")
    public void setRefModeText(String refModeText) {
        this.set(FIELD_REFMODETEXT, refModeText);
    }

    @JsonIgnore
    public boolean isRefModeTextDirty() {
        return this.contains(FIELD_REFMODETEXT);
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
    public String getViewParams() {
        Object objValue = this.get(FIELD_VIEWPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparams")
    public void setViewParams(String viewParams) {
        this.set(FIELD_VIEWPARAMS, viewParams);
    }

    @JsonIgnore
    public boolean isViewParamsDirty() {
        return this.contains(FIELD_VIEWPARAMS);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysCalendarItemRVId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysCalendarItemRVId(strValue);
    }
}

