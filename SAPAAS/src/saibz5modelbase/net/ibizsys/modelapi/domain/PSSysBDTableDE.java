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

public class PSSysBDTableDE
extends PSModelBase {
    public static final String FIELD_ADDCOLMODE = "addcolmode";
    public static final String FIELD_COLFILTER = "colfilter";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSBDCOLSETID = "pssysbdcolsetid";
    public static final String FIELD_PSSYSBDCOLSETNAME = "pssysbdcolsetname";
    public static final String FIELD_PSSYSBDSCHEMEID = "pssysbdschemeid";
    public static final String FIELD_PSSYSBDTABLEDEID = "pssysbdtabledeid";
    public static final String FIELD_PSSYSBDTABLEDENAME = "pssysbdtabledename";
    public static final String FIELD_PSSYSBDTABLEID = "pssysbdtableid";
    public static final String FIELD_PSSYSBDTABLENAME = "pssysbdtablename";
    public static final String FIELD_ROWKEYFORMAT = "rowkeyformat";
    public static final String FIELD_ROWKEYPARAMS = "rowkeyparams";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public Integer getAddColMode() {
        Object objValue = this.get(FIELD_ADDCOLMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="addcolmode")
    public void setAddColMode(Integer addColMode) {
        this.set(FIELD_ADDCOLMODE, addColMode);
    }

    @JsonIgnore
    public boolean isAddColModeDirty() {
        return this.contains(FIELD_ADDCOLMODE);
    }

    @JsonIgnore
    public String getColFilter() {
        Object objValue = this.get(FIELD_COLFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colfilter")
    public void setColFilter(String colFilter) {
        this.set(FIELD_COLFILTER, colFilter);
    }

    @JsonIgnore
    public boolean isColFilterDirty() {
        return this.contains(FIELD_COLFILTER);
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
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public String getPSDEName() {
        Object objValue = this.get(FIELD_PSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdename")
    public void setPSDEName(String pSDEName) {
        this.set(FIELD_PSDENAME, pSDEName);
    }

    @JsonIgnore
    public boolean isPSDENameDirty() {
        return this.contains(FIELD_PSDENAME);
    }

    @JsonIgnore
    public String getPSSysBDColSetId() {
        Object objValue = this.get(FIELD_PSSYSBDCOLSETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdcolsetid")
    public void setPSSysBDColSetId(String pSSysBDColSetId) {
        this.set(FIELD_PSSYSBDCOLSETID, pSSysBDColSetId);
    }

    @JsonIgnore
    public boolean isPSSysBDColSetIdDirty() {
        return this.contains(FIELD_PSSYSBDCOLSETID);
    }

    @JsonIgnore
    public String getPSSysBDColSetName() {
        Object objValue = this.get(FIELD_PSSYSBDCOLSETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdcolsetname")
    public void setPSSysBDColSetName(String pSSysBDColSetName) {
        this.set(FIELD_PSSYSBDCOLSETNAME, pSSysBDColSetName);
    }

    @JsonIgnore
    public boolean isPSSysBDColSetNameDirty() {
        return this.contains(FIELD_PSSYSBDCOLSETNAME);
    }

    @JsonIgnore
    public String getPSSysBDSchemeId() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemeid")
    public void setPSSysBDSchemeId(String pSSysBDSchemeId) {
        this.set(FIELD_PSSYSBDSCHEMEID, pSSysBDSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeIdDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysBDTableDEId() {
        Object objValue = this.get(FIELD_PSSYSBDTABLEDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtabledeid")
    public void setPSSysBDTableDEId(String pSSysBDTableDEId) {
        this.set(FIELD_PSSYSBDTABLEDEID, pSSysBDTableDEId);
    }

    @JsonIgnore
    public boolean isPSSysBDTableDEIdDirty() {
        return this.contains(FIELD_PSSYSBDTABLEDEID);
    }

    @JsonIgnore
    public String getPSSysBDTableDEName() {
        Object objValue = this.get(FIELD_PSSYSBDTABLEDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtabledename")
    public void setPSSysBDTableDEName(String pSSysBDTableDEName) {
        this.set(FIELD_PSSYSBDTABLEDENAME, pSSysBDTableDEName);
    }

    @JsonIgnore
    public boolean isPSSysBDTableDENameDirty() {
        return this.contains(FIELD_PSSYSBDTABLEDENAME);
    }

    @JsonIgnore
    public String getPSSysBDTableId() {
        Object objValue = this.get(FIELD_PSSYSBDTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtableid")
    public void setPSSysBDTableId(String pSSysBDTableId) {
        this.set(FIELD_PSSYSBDTABLEID, pSSysBDTableId);
    }

    @JsonIgnore
    public boolean isPSSysBDTableIdDirty() {
        return this.contains(FIELD_PSSYSBDTABLEID);
    }

    @JsonIgnore
    public String getPSSysBDTableName() {
        Object objValue = this.get(FIELD_PSSYSBDTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtablename")
    public void setPSSysBDTableName(String pSSysBDTableName) {
        this.set(FIELD_PSSYSBDTABLENAME, pSSysBDTableName);
    }

    @JsonIgnore
    public boolean isPSSysBDTableNameDirty() {
        return this.contains(FIELD_PSSYSBDTABLENAME);
    }

    @JsonIgnore
    public String getRowKeyFormat() {
        Object objValue = this.get(FIELD_ROWKEYFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rowkeyformat")
    public void setRowKeyFormat(String rowKeyFormat) {
        this.set(FIELD_ROWKEYFORMAT, rowKeyFormat);
    }

    @JsonIgnore
    public boolean isRowKeyFormatDirty() {
        return this.contains(FIELD_ROWKEYFORMAT);
    }

    @JsonIgnore
    public String getRowKeyParams() {
        Object objValue = this.get(FIELD_ROWKEYPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rowkeyparams")
    public void setRowKeyParams(String rowKeyParams) {
        this.set(FIELD_ROWKEYPARAMS, rowKeyParams);
    }

    @JsonIgnore
    public boolean isRowKeyParamsDirty() {
        return this.contains(FIELD_ROWKEYPARAMS);
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
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
    }

    @JsonIgnore
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBDTableDEId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBDTableDEId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBDTABLEDE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBDTableDE item = (PSSysBDTableDE)MAPPER.readValue(new File(strJsonFilePath), PSSysBDTableDE.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBDTableDE) {
            PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBDTableDE) {
            PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

