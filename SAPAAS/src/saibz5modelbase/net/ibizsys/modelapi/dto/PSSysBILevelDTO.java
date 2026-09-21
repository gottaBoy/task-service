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

public class PSSysBILevelDTO
extends PSModelDTOBase {
    public static final String FIELD_BILEVELTAG = "bileveltag";
    public static final String FIELD_BILEVELTAG2 = "bileveltag2";
    public static final String FIELD_BILEVELTYPE = "bileveltype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSBIHIERARCHYID = "pssysbihierarchyid";
    public static final String FIELD_PSSYSBIHIERARCHYNAME = "pssysbihierarchyname";
    public static final String FIELD_PSSYSBILEVELID = "pssysbilevelid";
    public static final String FIELD_PSSYSBILEVELNAME = "pssysbilevelname";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEPSDEFID = "valuepsdefid";
    public static final String FIELD_VALUEPSDEFNAME = "valuepsdefname";

    @JsonIgnore
    public String getBILevelTag() {
        Object objValue = this.get(FIELD_BILEVELTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bileveltag")
    public void setBILevelTag(String bILevelTag) {
        this.set(FIELD_BILEVELTAG, bILevelTag);
    }

    @JsonIgnore
    public boolean isBILevelTagDirty() {
        return this.contains(FIELD_BILEVELTAG);
    }

    @JsonIgnore
    public String getBILevelTag2() {
        Object objValue = this.get(FIELD_BILEVELTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bileveltag2")
    public void setBILevelTag2(String bILevelTag2) {
        this.set(FIELD_BILEVELTAG2, bILevelTag2);
    }

    @JsonIgnore
    public boolean isBILevelTag2Dirty() {
        return this.contains(FIELD_BILEVELTAG2);
    }

    @JsonIgnore
    public String getBILevelType() {
        Object objValue = this.get(FIELD_BILEVELTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bileveltype")
    public void setBILevelType(String bILevelType) {
        this.set(FIELD_BILEVELTYPE, bILevelType);
    }

    @JsonIgnore
    public boolean isBILevelTypeDirty() {
        return this.contains(FIELD_BILEVELTYPE);
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
    public String getTextPSDEFId() {
        Object objValue = this.get(FIELD_TEXTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefid")
    public void setTextPSDEFId(String textPSDEFId) {
        this.set(FIELD_TEXTPSDEFID, textPSDEFId);
    }

    @JsonIgnore
    public boolean isTextPSDEFIdDirty() {
        return this.contains(FIELD_TEXTPSDEFID);
    }

    @JsonIgnore
    public String getTextPSDEFName() {
        Object objValue = this.get(FIELD_TEXTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefname")
    public void setTextPSDEFName(String textPSDEFName) {
        this.set(FIELD_TEXTPSDEFNAME, textPSDEFName);
    }

    @JsonIgnore
    public boolean isTextPSDEFNameDirty() {
        return this.contains(FIELD_TEXTPSDEFNAME);
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
    public String getValuePSDEFId() {
        Object objValue = this.get(FIELD_VALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefid")
    public void setValuePSDEFId(String valuePSDEFId) {
        this.set(FIELD_VALUEPSDEFID, valuePSDEFId);
    }

    @JsonIgnore
    public boolean isValuePSDEFIdDirty() {
        return this.contains(FIELD_VALUEPSDEFID);
    }

    @JsonIgnore
    public String getValuePSDEFName() {
        Object objValue = this.get(FIELD_VALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefname")
    public void setValuePSDEFName(String valuePSDEFName) {
        this.set(FIELD_VALUEPSDEFNAME, valuePSDEFName);
    }

    @JsonIgnore
    public boolean isValuePSDEFNameDirty() {
        return this.contains(FIELD_VALUEPSDEFNAME);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBILevelId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysBILevelId(strValue);
    }
}

