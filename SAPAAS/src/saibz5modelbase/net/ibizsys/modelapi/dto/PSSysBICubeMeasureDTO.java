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

public class PSSysBICubeMeasureDTO
extends PSModelDTOBase {
    public static final String FIELD_BICUBEMEASURETAG = "bicubemeasuretag";
    public static final String FIELD_BICUBEMEASURETAG2 = "bicubemeasuretag2";
    public static final String FIELD_BIMEASURETYPE = "bimeasuretype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_HIDDENDATAITEM = "hiddendataitem";
    public static final String FIELD_MEASUREFORMULA = "measureformula";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSBICUBEID = "pssysbicubeid";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "pssysbicubemeasureid";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "pssysbicubemeasurename";
    public static final String FIELD_PSSYSBICUBENAME = "pssysbicubename";
    public static final String FIELD_PSSYSBISCHEMEID = "pssysbischemeid";
    public static final String FIELD_PSTHRESHOLDGROUPID = "psthresholdgroupid";
    public static final String FIELD_PSTHRESHOLDGROUPNAME = "psthresholdgroupname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEFORMAT = "valueformat";

    @JsonIgnore
    public String getBICubeMeasureTag() {
        Object objValue = this.get(FIELD_BICUBEMEASURETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubemeasuretag")
    public void setBICubeMeasureTag(String bICubeMeasureTag) {
        this.set(FIELD_BICUBEMEASURETAG, bICubeMeasureTag);
    }

    @JsonIgnore
    public boolean isBICubeMeasureTagDirty() {
        return this.contains(FIELD_BICUBEMEASURETAG);
    }

    @JsonIgnore
    public String getBICubeMeasureTag2() {
        Object objValue = this.get(FIELD_BICUBEMEASURETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubemeasuretag2")
    public void setBICubeMeasureTag2(String bICubeMeasureTag2) {
        this.set(FIELD_BICUBEMEASURETAG2, bICubeMeasureTag2);
    }

    @JsonIgnore
    public boolean isBICubeMeasureTag2Dirty() {
        return this.contains(FIELD_BICUBEMEASURETAG2);
    }

    @JsonIgnore
    public String getBIMeasureType() {
        Object objValue = this.get(FIELD_BIMEASURETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bimeasuretype")
    public void setBIMeasureType(String bIMeasureType) {
        this.set(FIELD_BIMEASURETYPE, bIMeasureType);
    }

    @JsonIgnore
    public boolean isBIMeasureTypeDirty() {
        return this.contains(FIELD_BIMEASURETYPE);
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
    public Integer getHiddenDataItem() {
        Object objValue = this.get(FIELD_HIDDENDATAITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hiddendataitem")
    public void setHiddenDataItem(Integer hiddenDataItem) {
        this.set(FIELD_HIDDENDATAITEM, hiddenDataItem);
    }

    @JsonIgnore
    public boolean isHiddenDataItemDirty() {
        return this.contains(FIELD_HIDDENDATAITEM);
    }

    @JsonIgnore
    public String getMeasureFormula() {
        Object objValue = this.get(FIELD_MEASUREFORMULA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="measureformula")
    public void setMeasureFormula(String measureFormula) {
        this.set(FIELD_MEASUREFORMULA, measureFormula);
    }

    @JsonIgnore
    public boolean isMeasureFormulaDirty() {
        return this.contains(FIELD_MEASUREFORMULA);
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
    public String getPSSysBICubeName() {
        Object objValue = this.get(FIELD_PSSYSBICUBENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubename")
    public void setPSSysBICubeName(String pSSysBICubeName) {
        this.set(FIELD_PSSYSBICUBENAME, pSSysBICubeName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeNameDirty() {
        return this.contains(FIELD_PSSYSBICUBENAME);
    }

    @JsonIgnore
    public String getPSSysBISchemeId() {
        Object objValue = this.get(FIELD_PSSYSBISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbischemeid")
    public void setPSSysBISchemeId(String pSSysBISchemeId) {
        this.set(FIELD_PSSYSBISCHEMEID, pSSysBISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBISchemeIdDirty() {
        return this.contains(FIELD_PSSYSBISCHEMEID);
    }

    @JsonIgnore
    public String getPSThresholdGroupId() {
        Object objValue = this.get(FIELD_PSTHRESHOLDGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psthresholdgroupid")
    public void setPSThresholdGroupId(String pSThresholdGroupId) {
        this.set(FIELD_PSTHRESHOLDGROUPID, pSThresholdGroupId);
    }

    @JsonIgnore
    public boolean isPSThresholdGroupIdDirty() {
        return this.contains(FIELD_PSTHRESHOLDGROUPID);
    }

    @JsonIgnore
    public String getPSThresholdGroupName() {
        Object objValue = this.get(FIELD_PSTHRESHOLDGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psthresholdgroupname")
    public void setPSThresholdGroupName(String pSThresholdGroupName) {
        this.set(FIELD_PSTHRESHOLDGROUPNAME, pSThresholdGroupName);
    }

    @JsonIgnore
    public boolean isPSThresholdGroupNameDirty() {
        return this.contains(FIELD_PSTHRESHOLDGROUPNAME);
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

    @JsonIgnore
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBICubeMeasureId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysBICubeMeasureId(strValue);
    }
}

