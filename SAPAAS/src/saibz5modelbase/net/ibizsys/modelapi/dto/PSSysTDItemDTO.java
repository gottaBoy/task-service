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

public class PSSysTDItemDTO
extends PSModelDTOBase {
    public static final String FIELD_BADVALUE = "badvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSSAMPLEVALUEID = "pssyssamplevalueid";
    public static final String FIELD_PSSYSSAMPLEVALUENAME = "pssyssamplevaluename";
    public static final String FIELD_PSSYSTDITEMID = "pssystditemid";
    public static final String FIELD_PSSYSTDITEMNAME = "pssystditemname";
    public static final String FIELD_PSSYSTESTDATAID = "pssystestdataid";
    public static final String FIELD_PSSYSTESTDATANAME = "pssystestdataname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSSYSTESTDATAID = "refpssystestdataid";
    public static final String FIELD_REFPSSYSTESTDATANAME = "refpssystestdataname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUE = "value";
    public static final String FIELD_VALUERANGE = "valuerange";
    public static final String FIELD_VALUETYPE = "valuetype";

    @JsonIgnore
    public String getBadValue() {
        Object objValue = this.get(FIELD_BADVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="badvalue")
    public void setBadValue(String badValue) {
        this.set(FIELD_BADVALUE, badValue);
    }

    @JsonIgnore
    public boolean isBadValueDirty() {
        return this.contains(FIELD_BADVALUE);
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
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
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
    public String getPSSysSampleValueId() {
        Object objValue = this.get(FIELD_PSSYSSAMPLEVALUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssamplevalueid")
    public void setPSSysSampleValueId(String pSSysSampleValueId) {
        this.set(FIELD_PSSYSSAMPLEVALUEID, pSSysSampleValueId);
    }

    @JsonIgnore
    public boolean isPSSysSampleValueIdDirty() {
        return this.contains(FIELD_PSSYSSAMPLEVALUEID);
    }

    @JsonIgnore
    public String getPSSysSampleValueName() {
        Object objValue = this.get(FIELD_PSSYSSAMPLEVALUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssamplevaluename")
    public void setPSSysSampleValueName(String pSSysSampleValueName) {
        this.set(FIELD_PSSYSSAMPLEVALUENAME, pSSysSampleValueName);
    }

    @JsonIgnore
    public boolean isPSSysSampleValueNameDirty() {
        return this.contains(FIELD_PSSYSSAMPLEVALUENAME);
    }

    @JsonIgnore
    public String getPSSysTDItemId() {
        Object objValue = this.get(FIELD_PSSYSTDITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystditemid")
    public void setPSSysTDItemId(String pSSysTDItemId) {
        this.set(FIELD_PSSYSTDITEMID, pSSysTDItemId);
    }

    @JsonIgnore
    public boolean isPSSysTDItemIdDirty() {
        return this.contains(FIELD_PSSYSTDITEMID);
    }

    @JsonIgnore
    public String getPSSysTDItemName() {
        Object objValue = this.get(FIELD_PSSYSTDITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystditemname")
    public void setPSSysTDItemName(String pSSysTDItemName) {
        this.set(FIELD_PSSYSTDITEMNAME, pSSysTDItemName);
    }

    @JsonIgnore
    public boolean isPSSysTDItemNameDirty() {
        return this.contains(FIELD_PSSYSTDITEMNAME);
    }

    @JsonIgnore
    public String getPSSysTestDataId() {
        Object objValue = this.get(FIELD_PSSYSTESTDATAID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestdataid")
    public void setPSSysTestDataId(String pSSysTestDataId) {
        this.set(FIELD_PSSYSTESTDATAID, pSSysTestDataId);
    }

    @JsonIgnore
    public boolean isPSSysTestDataIdDirty() {
        return this.contains(FIELD_PSSYSTESTDATAID);
    }

    @JsonIgnore
    public String getPSSysTestDataName() {
        Object objValue = this.get(FIELD_PSSYSTESTDATANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestdataname")
    public void setPSSysTestDataName(String pSSysTestDataName) {
        this.set(FIELD_PSSYSTESTDATANAME, pSSysTestDataName);
    }

    @JsonIgnore
    public boolean isPSSysTestDataNameDirty() {
        return this.contains(FIELD_PSSYSTESTDATANAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRefPSSysTestDataId() {
        Object objValue = this.get(FIELD_REFPSSYSTESTDATAID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssystestdataid")
    public void setRefPSSysTestDataId(String refPSSysTestDataId) {
        this.set(FIELD_REFPSSYSTESTDATAID, refPSSysTestDataId);
    }

    @JsonIgnore
    public boolean isRefPSSysTestDataIdDirty() {
        return this.contains(FIELD_REFPSSYSTESTDATAID);
    }

    @JsonIgnore
    public String getRefPSSysTestDataName() {
        Object objValue = this.get(FIELD_REFPSSYSTESTDATANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssystestdataname")
    public void setRefPSSysTestDataName(String refPSSysTestDataName) {
        this.set(FIELD_REFPSSYSTESTDATANAME, refPSSysTestDataName);
    }

    @JsonIgnore
    public boolean isRefPSSysTestDataNameDirty() {
        return this.contains(FIELD_REFPSSYSTESTDATANAME);
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
    public String getValue() {
        Object objValue = this.get(FIELD_VALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="value")
    public void setValue(String value) {
        this.set(FIELD_VALUE, value);
    }

    @JsonIgnore
    public boolean isValueDirty() {
        return this.contains(FIELD_VALUE);
    }

    @JsonIgnore
    public String getValueRange() {
        Object objValue = this.get(FIELD_VALUERANGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuerange")
    public void setValueRange(String valueRange) {
        this.set(FIELD_VALUERANGE, valueRange);
    }

    @JsonIgnore
    public boolean isValueRangeDirty() {
        return this.contains(FIELD_VALUERANGE);
    }

    @JsonIgnore
    public String getValueType() {
        Object objValue = this.get(FIELD_VALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuetype")
    public void setValueType(String valueType) {
        this.set(FIELD_VALUETYPE, valueType);
    }

    @JsonIgnore
    public boolean isValueTypeDirty() {
        return this.contains(FIELD_VALUETYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysTDItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysTDItemId(strValue);
    }
}

