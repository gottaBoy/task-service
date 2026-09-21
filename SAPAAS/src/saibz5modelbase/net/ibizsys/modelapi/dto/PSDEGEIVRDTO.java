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

public class PSDEGEIVRDTO
extends PSModelDTOBase {
    public static final String FIELD_CHECKMODE = "checkmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFVRID = "psdefvrid";
    public static final String FIELD_PSDEFVRNAME = "psdefvrname";
    public static final String FIELD_PSDEGEIVRID = "psdegeivrid";
    public static final String FIELD_PSDEGEIVRNAME = "psdegeivrname";
    public static final String FIELD_PSDEGRIDCOLID = "psdegridcolid";
    public static final String FIELD_PSDEGRIDCOLNAME = "psdegridcolname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VRTYPE = "vrtype";

    @JsonIgnore
    public Integer getCheckMode() {
        Object objValue = this.get(FIELD_CHECKMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checkmode")
    public void setCheckMode(Integer checkMode) {
        this.set(FIELD_CHECKMODE, checkMode);
    }

    @JsonIgnore
    public boolean isCheckModeDirty() {
        return this.contains(FIELD_CHECKMODE);
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
    public String getPSDEFVRId() {
        Object objValue = this.get(FIELD_PSDEFVRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrid")
    public void setPSDEFVRId(String pSDEFVRId) {
        this.set(FIELD_PSDEFVRID, pSDEFVRId);
    }

    @JsonIgnore
    public boolean isPSDEFVRIdDirty() {
        return this.contains(FIELD_PSDEFVRID);
    }

    @JsonIgnore
    public String getPSDEFVRName() {
        Object objValue = this.get(FIELD_PSDEFVRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrname")
    public void setPSDEFVRName(String pSDEFVRName) {
        this.set(FIELD_PSDEFVRNAME, pSDEFVRName);
    }

    @JsonIgnore
    public boolean isPSDEFVRNameDirty() {
        return this.contains(FIELD_PSDEFVRNAME);
    }

    @JsonIgnore
    public String getPSDEGEIVRId() {
        Object objValue = this.get(FIELD_PSDEGEIVRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeivrid")
    public void setPSDEGEIVRId(String pSDEGEIVRId) {
        this.set(FIELD_PSDEGEIVRID, pSDEGEIVRId);
    }

    @JsonIgnore
    public boolean isPSDEGEIVRIdDirty() {
        return this.contains(FIELD_PSDEGEIVRID);
    }

    @JsonIgnore
    public String getPSDEGEIVRName() {
        Object objValue = this.get(FIELD_PSDEGEIVRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeivrname")
    public void setPSDEGEIVRName(String pSDEGEIVRName) {
        this.set(FIELD_PSDEGEIVRNAME, pSDEGEIVRName);
    }

    @JsonIgnore
    public boolean isPSDEGEIVRNameDirty() {
        return this.contains(FIELD_PSDEGEIVRNAME);
    }

    @JsonIgnore
    public String getPSDEGridColId() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolid")
    public void setPSDEGridColId(String pSDEGridColId) {
        this.set(FIELD_PSDEGRIDCOLID, pSDEGridColId);
    }

    @JsonIgnore
    public boolean isPSDEGridColIdDirty() {
        return this.contains(FIELD_PSDEGRIDCOLID);
    }

    @JsonIgnore
    public String getPSDEGridColName() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolname")
    public void setPSDEGridColName(String pSDEGridColName) {
        this.set(FIELD_PSDEGRIDCOLNAME, pSDEGridColName);
    }

    @JsonIgnore
    public boolean isPSDEGridColNameDirty() {
        return this.contains(FIELD_PSDEGRIDCOLNAME);
    }

    @JsonIgnore
    public String getPSDEGridId() {
        Object objValue = this.get(FIELD_PSDEGRIDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridid")
    public void setPSDEGridId(String pSDEGridId) {
        this.set(FIELD_PSDEGRIDID, pSDEGridId);
    }

    @JsonIgnore
    public boolean isPSDEGridIdDirty() {
        return this.contains(FIELD_PSDEGRIDID);
    }

    @JsonIgnore
    public String getPSDEGridName() {
        Object objValue = this.get(FIELD_PSDEGRIDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridname")
    public void setPSDEGridName(String pSDEGridName) {
        this.set(FIELD_PSDEGRIDNAME, pSDEGridName);
    }

    @JsonIgnore
    public boolean isPSDEGridNameDirty() {
        return this.contains(FIELD_PSDEGRIDNAME);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
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
    public String getVRType() {
        Object objValue = this.get(FIELD_VRTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vrtype")
    public void setVRType(String vRType) {
        this.set(FIELD_VRTYPE, vRType);
    }

    @JsonIgnore
    public boolean isVRTypeDirty() {
        return this.contains(FIELD_VRTYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEGEIVRId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEGEIVRId(strValue);
    }
}

