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

public class PSDEMainStateRSDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENTERPSDEACTIONID = "enterpsdeactionid";
    public static final String FIELD_ENTERPSDEACTIONNAME = "enterpsdeactionname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEXTPSDEMSID = "nextpsdemsid";
    public static final String FIELD_NEXTPSDEMSNAME = "nextpsdemsname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PREVPSDEMSID = "prevpsdemsid";
    public static final String FIELD_PREVPSDEMSNAME = "prevpsdemsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAINSTATERSID = "psdemainstatersid";
    public static final String FIELD_PSDEMAINSTATERSNAME = "psdemainstatersname";
    public static final String FIELD_PSDENAME = "psdename";
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
    public String getEnterPSDEActionId() {
        Object objValue = this.get(FIELD_ENTERPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enterpsdeactionid")
    public void setEnterPSDEActionId(String enterPSDEActionId) {
        this.set(FIELD_ENTERPSDEACTIONID, enterPSDEActionId);
    }

    @JsonIgnore
    public boolean isEnterPSDEActionIdDirty() {
        return this.contains(FIELD_ENTERPSDEACTIONID);
    }

    @JsonIgnore
    public String getEnterPSDEActionName() {
        Object objValue = this.get(FIELD_ENTERPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enterpsdeactionname")
    public void setEnterPSDEActionName(String enterPSDEActionName) {
        this.set(FIELD_ENTERPSDEACTIONNAME, enterPSDEActionName);
    }

    @JsonIgnore
    public boolean isEnterPSDEActionNameDirty() {
        return this.contains(FIELD_ENTERPSDEACTIONNAME);
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
    public String getNextPSDEMSId() {
        Object objValue = this.get(FIELD_NEXTPSDEMSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdemsid")
    public void setNextPSDEMSId(String nextPSDEMSId) {
        this.set(FIELD_NEXTPSDEMSID, nextPSDEMSId);
    }

    @JsonIgnore
    public boolean isNextPSDEMSIdDirty() {
        return this.contains(FIELD_NEXTPSDEMSID);
    }

    @JsonIgnore
    public String getNextPSDEMSName() {
        Object objValue = this.get(FIELD_NEXTPSDEMSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdemsname")
    public void setNextPSDEMSName(String nextPSDEMSName) {
        this.set(FIELD_NEXTPSDEMSNAME, nextPSDEMSName);
    }

    @JsonIgnore
    public boolean isNextPSDEMSNameDirty() {
        return this.contains(FIELD_NEXTPSDEMSNAME);
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
    public String getPrevPSDEMSId() {
        Object objValue = this.get(FIELD_PREVPSDEMSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpsdemsid")
    public void setPrevPSDEMSId(String prevPSDEMSId) {
        this.set(FIELD_PREVPSDEMSID, prevPSDEMSId);
    }

    @JsonIgnore
    public boolean isPrevPSDEMSIdDirty() {
        return this.contains(FIELD_PREVPSDEMSID);
    }

    @JsonIgnore
    public String getPrevPSDEMSName() {
        Object objValue = this.get(FIELD_PREVPSDEMSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpsdemsname")
    public void setPrevPSDEMSName(String prevPSDEMSName) {
        this.set(FIELD_PREVPSDEMSNAME, prevPSDEMSName);
    }

    @JsonIgnore
    public boolean isPrevPSDEMSNameDirty() {
        return this.contains(FIELD_PREVPSDEMSNAME);
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
    public String getPSDEMainStateRSId() {
        Object objValue = this.get(FIELD_PSDEMAINSTATERSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstatersid")
    public void setPSDEMainStateRSId(String pSDEMainStateRSId) {
        this.set(FIELD_PSDEMAINSTATERSID, pSDEMainStateRSId);
    }

    @JsonIgnore
    public boolean isPSDEMainStateRSIdDirty() {
        return this.contains(FIELD_PSDEMAINSTATERSID);
    }

    @JsonIgnore
    public String getPSDEMainStateRSName() {
        Object objValue = this.get(FIELD_PSDEMAINSTATERSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstatersname")
    public void setPSDEMainStateRSName(String pSDEMainStateRSName) {
        this.set(FIELD_PSDEMAINSTATERSNAME, pSDEMainStateRSName);
    }

    @JsonIgnore
    public boolean isPSDEMainStateRSNameDirty() {
        return this.contains(FIELD_PSDEMAINSTATERSNAME);
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
        return this.getPSDEMainStateRSId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEMainStateRSId(strValue);
    }
}

