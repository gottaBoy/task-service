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

public class PSSysBICubeLevelDTO
extends PSModelDTOBase {
    public static final String FIELD_BICUBELEVELTAG = "bicubeleveltag";
    public static final String FIELD_BICUBELEVELTAG2 = "bicubeleveltag2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "pssysbicubedimensionid";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "pssysbicubedimensionname";
    public static final String FIELD_PSSYSBICUBELEVELID = "pssysbicubelevelid";
    public static final String FIELD_PSSYSBICUBELEVELNAME = "pssysbicubelevelname";
    public static final String FIELD_PSSYSBIDIMENSIONID = "pssysbidimensionid";
    public static final String FIELD_PSSYSBIHIERARCHYID = "pssysbihierarchyid";
    public static final String FIELD_PSSYSBIHIERARCHYNAME = "pssysbihierarchyname";
    public static final String FIELD_PSSYSBILEVELID = "pssysbilevelid";
    public static final String FIELD_PSSYSBILEVELNAME = "pssysbilevelname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public String getBICubeLevelTag() {
        Object objValue = this.get(FIELD_BICUBELEVELTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubeleveltag")
    public void setBICubeLevelTag(String bICubeLevelTag) {
        this.set(FIELD_BICUBELEVELTAG, bICubeLevelTag);
    }

    @JsonIgnore
    public boolean isBICubeLevelTagDirty() {
        return this.contains(FIELD_BICUBELEVELTAG);
    }

    @JsonIgnore
    public String getBICubeLevelTag2() {
        Object objValue = this.get(FIELD_BICUBELEVELTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubeleveltag2")
    public void setBICubeLevelTag2(String bICubeLevelTag2) {
        this.set(FIELD_BICUBELEVELTAG2, bICubeLevelTag2);
    }

    @JsonIgnore
    public boolean isBICubeLevelTag2Dirty() {
        return this.contains(FIELD_BICUBELEVELTAG2);
    }

    @JsonIgnore
    public String getCodeName() {
        Object objValue = this.get(FIELD_CODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename")
    public void setCodeName(String codeName) {
        this.set(FIELD_CODENAME, codeName);
    }

    @JsonIgnore
    public boolean isCodeNameDirty() {
        return this.contains(FIELD_CODENAME);
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
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
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
    public String getPSSysBICubeDimensionId() {
        Object objValue = this.get(FIELD_PSSYSBICUBEDIMENSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubedimensionid")
    public void setPSSysBICubeDimensionId(String pSSysBICubeDimensionId) {
        this.set(FIELD_PSSYSBICUBEDIMENSIONID, pSSysBICubeDimensionId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeDimensionIdDirty() {
        return this.contains(FIELD_PSSYSBICUBEDIMENSIONID);
    }

    @JsonIgnore
    public String getPSSysBICubeDimensionName() {
        Object objValue = this.get(FIELD_PSSYSBICUBEDIMENSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubedimensionname")
    public void setPSSysBICubeDimensionName(String pSSysBICubeDimensionName) {
        this.set(FIELD_PSSYSBICUBEDIMENSIONNAME, pSSysBICubeDimensionName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeDimensionNameDirty() {
        return this.contains(FIELD_PSSYSBICUBEDIMENSIONNAME);
    }

    @JsonIgnore
    public String getPSSysBICubeLevelId() {
        Object objValue = this.get(FIELD_PSSYSBICUBELEVELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubelevelid")
    public void setPSSysBICubeLevelId(String pSSysBICubeLevelId) {
        this.set(FIELD_PSSYSBICUBELEVELID, pSSysBICubeLevelId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeLevelIdDirty() {
        return this.contains(FIELD_PSSYSBICUBELEVELID);
    }

    @JsonIgnore
    public String getPSSysBICubeLevelName() {
        Object objValue = this.get(FIELD_PSSYSBICUBELEVELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubelevelname")
    public void setPSSysBICubeLevelName(String pSSysBICubeLevelName) {
        this.set(FIELD_PSSYSBICUBELEVELNAME, pSSysBICubeLevelName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeLevelNameDirty() {
        return this.contains(FIELD_PSSYSBICUBELEVELNAME);
    }

    @JsonIgnore
    public String getPSSysBIDimensionId() {
        Object objValue = this.get(FIELD_PSSYSBIDIMENSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbidimensionid")
    public void setPSSysBIDimensionId(String pSSysBIDimensionId) {
        this.set(FIELD_PSSYSBIDIMENSIONID, pSSysBIDimensionId);
    }

    @JsonIgnore
    public boolean isPSSysBIDimensionIdDirty() {
        return this.contains(FIELD_PSSYSBIDIMENSIONID);
    }

    @JsonIgnore
    public String getPSSysBIHierarchyId() {
        Object objValue = this.get(FIELD_PSSYSBIHIERARCHYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbihierarchyid")
    public void setPSSysBIHierarchyId(String pSSysBIHierarchyId) {
        this.set(FIELD_PSSYSBIHIERARCHYID, pSSysBIHierarchyId);
    }

    @JsonIgnore
    public boolean isPSSysBIHierarchyIdDirty() {
        return this.contains(FIELD_PSSYSBIHIERARCHYID);
    }

    @JsonIgnore
    public String getPSSysBIHierarchyName() {
        Object objValue = this.get(FIELD_PSSYSBIHIERARCHYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbihierarchyname")
    public void setPSSysBIHierarchyName(String pSSysBIHierarchyName) {
        this.set(FIELD_PSSYSBIHIERARCHYNAME, pSSysBIHierarchyName);
    }

    @JsonIgnore
    public boolean isPSSysBIHierarchyNameDirty() {
        return this.contains(FIELD_PSSYSBIHIERARCHYNAME);
    }

    @JsonIgnore
    public String getPSSysBILevelId() {
        Object objValue = this.get(FIELD_PSSYSBILEVELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbilevelid")
    public void setPSSysBILevelId(String pSSysBILevelId) {
        this.set(FIELD_PSSYSBILEVELID, pSSysBILevelId);
    }

    @JsonIgnore
    public boolean isPSSysBILevelIdDirty() {
        return this.contains(FIELD_PSSYSBILEVELID);
    }

    @JsonIgnore
    public String getPSSysBILevelName() {
        Object objValue = this.get(FIELD_PSSYSBILEVELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbilevelname")
    public void setPSSysBILevelName(String pSSysBILevelName) {
        this.set(FIELD_PSSYSBILEVELNAME, pSSysBILevelName);
    }

    @JsonIgnore
    public boolean isPSSysBILevelNameDirty() {
        return this.contains(FIELD_PSSYSBILEVELNAME);
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
    public Integer getValidFlag() {
        Object objValue = this.get(FIELD_VALIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="validflag")
    public void setValidFlag(Integer validFlag) {
        this.set(FIELD_VALIDFLAG, validFlag);
    }

    @JsonIgnore
    public boolean isValidFlagDirty() {
        return this.contains(FIELD_VALIDFLAG);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBICubeLevelId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysBICubeLevelId(strValue);
    }
}

