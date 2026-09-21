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

public class PSSysBIAggColumnDTO
extends PSModelDTOBase {
    public static final String FIELD_BIAGGCOLUMNTAG = "biaggcolumntag";
    public static final String FIELD_BIAGGCOLUMNTAG2 = "biaggcolumntag2";
    public static final String FIELD_BIAGGCOLUMNTYPE = "biaggcolumntype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSBIAGGCOLUMNID = "pssysbiaggcolumnid";
    public static final String FIELD_PSSYSBIAGGCOLUMNNAME = "pssysbiaggcolumnname";
    public static final String FIELD_PSSYSBIAGGTABLEID = "pssysbiaggtableid";
    public static final String FIELD_PSSYSBIAGGTABLENAME = "pssysbiaggtablename";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "pssysbicubedimensionid";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "pssysbicubedimensionname";
    public static final String FIELD_PSSYSBICUBEID = "pssysbicubeid";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "pssysbicubemeasureid";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "pssysbicubemeasurename";
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
    public String getBIAggColumnTag() {
        Object objValue = this.get(FIELD_BIAGGCOLUMNTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biaggcolumntag")
    public void setBIAggColumnTag(String bIAggColumnTag) {
        this.set(FIELD_BIAGGCOLUMNTAG, bIAggColumnTag);
    }

    @JsonIgnore
    public boolean isBIAggColumnTagDirty() {
        return this.contains(FIELD_BIAGGCOLUMNTAG);
    }

    @JsonIgnore
    public String getBIAggColumnTag2() {
        Object objValue = this.get(FIELD_BIAGGCOLUMNTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biaggcolumntag2")
    public void setBIAggColumnTag2(String bIAggColumnTag2) {
        this.set(FIELD_BIAGGCOLUMNTAG2, bIAggColumnTag2);
    }

    @JsonIgnore
    public boolean isBIAggColumnTag2Dirty() {
        return this.contains(FIELD_BIAGGCOLUMNTAG2);
    }

    @JsonIgnore
    public String getBIAggColumnType() {
        Object objValue = this.get(FIELD_BIAGGCOLUMNTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biaggcolumntype")
    public void setBIAggColumnType(String bIAggColumnType) {
        this.set(FIELD_BIAGGCOLUMNTYPE, bIAggColumnType);
    }

    @JsonIgnore
    public boolean isBIAggColumnTypeDirty() {
        return this.contains(FIELD_BIAGGCOLUMNTYPE);
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
    public String getPSSysBIAggColumnId() {
        Object objValue = this.get(FIELD_PSSYSBIAGGCOLUMNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggcolumnid")
    public void setPSSysBIAggColumnId(String pSSysBIAggColumnId) {
        this.set(FIELD_PSSYSBIAGGCOLUMNID, pSSysBIAggColumnId);
    }

    @JsonIgnore
    public boolean isPSSysBIAggColumnIdDirty() {
        return this.contains(FIELD_PSSYSBIAGGCOLUMNID);
    }

    @JsonIgnore
    public String getPSSysBIAggColumnName() {
        Object objValue = this.get(FIELD_PSSYSBIAGGCOLUMNNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggcolumnname")
    public void setPSSysBIAggColumnName(String pSSysBIAggColumnName) {
        this.set(FIELD_PSSYSBIAGGCOLUMNNAME, pSSysBIAggColumnName);
    }

    @JsonIgnore
    public boolean isPSSysBIAggColumnNameDirty() {
        return this.contains(FIELD_PSSYSBIAGGCOLUMNNAME);
    }

    @JsonIgnore
    public String getPSSysBIAggTableId() {
        Object objValue = this.get(FIELD_PSSYSBIAGGTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggtableid")
    public void setPSSysBIAggTableId(String pSSysBIAggTableId) {
        this.set(FIELD_PSSYSBIAGGTABLEID, pSSysBIAggTableId);
    }

    @JsonIgnore
    public boolean isPSSysBIAggTableIdDirty() {
        return this.contains(FIELD_PSSYSBIAGGTABLEID);
    }

    @JsonIgnore
    public String getPSSysBIAggTableName() {
        Object objValue = this.get(FIELD_PSSYSBIAGGTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggtablename")
    public void setPSSysBIAggTableName(String pSSysBIAggTableName) {
        this.set(FIELD_PSSYSBIAGGTABLENAME, pSSysBIAggTableName);
    }

    @JsonIgnore
    public boolean isPSSysBIAggTableNameDirty() {
        return this.contains(FIELD_PSSYSBIAGGTABLENAME);
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
    public String getPSSysBICubeId() {
        Object objValue = this.get(FIELD_PSSYSBICUBEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubeid")
    public void setPSSysBICubeId(String pSSysBICubeId) {
        this.set(FIELD_PSSYSBICUBEID, pSSysBICubeId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeIdDirty() {
        return this.contains(FIELD_PSSYSBICUBEID);
    }

    @JsonIgnore
    public String getPSSysBICubeMeasureId() {
        Object objValue = this.get(FIELD_PSSYSBICUBEMEASUREID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubemeasureid")
    public void setPSSysBICubeMeasureId(String pSSysBICubeMeasureId) {
        this.set(FIELD_PSSYSBICUBEMEASUREID, pSSysBICubeMeasureId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeMeasureIdDirty() {
        return this.contains(FIELD_PSSYSBICUBEMEASUREID);
    }

    @JsonIgnore
    public String getPSSysBICubeMeasureName() {
        Object objValue = this.get(FIELD_PSSYSBICUBEMEASURENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubemeasurename")
    public void setPSSysBICubeMeasureName(String pSSysBICubeMeasureName) {
        this.set(FIELD_PSSYSBICUBEMEASURENAME, pSSysBICubeMeasureName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeMeasureNameDirty() {
        return this.contains(FIELD_PSSYSBICUBEMEASURENAME);
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
        return this.getPSSysBIAggColumnId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysBIAggColumnId(strValue);
    }
}

