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

public class PSSubSysSADERS
extends PSModelBase {
    public static final String FIELD_ARRAYFLAG = "arrayflag";
    public static final String FIELD_CHILDFILTER = "childfilter";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    public static final String FIELD_CPSSUBSYSSADEID = "cpssubsyssadeid";
    public static final String FIELD_CPSSUBSYSSADENAME = "cpssubsyssadename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSSUBSYSSADEID = "ppssubsyssadeid";
    public static final String FIELD_PPSSUBSYSSADENAME = "ppssubsyssadename";
    public static final String FIELD_PSSUBSYSSADERSID = "pssubsyssadersid";
    public static final String FIELD_PSSUBSYSSADERSNAME = "pssubsyssadersname";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_RSTAG = "rstag";
    public static final String FIELD_RSTAG2 = "rstag2";
    public static final String FIELD_TYPEFILTER = "typefilter";
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
    public Integer getArrayFlag() {
        Object objValue = this.get(FIELD_ARRAYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="arrayflag")
    public void setArrayFlag(Integer arrayFlag) {
        this.set(FIELD_ARRAYFLAG, arrayFlag);
    }

    @JsonIgnore
    public boolean isArrayFlagDirty() {
        return this.contains(FIELD_ARRAYFLAG);
    }

    @JsonIgnore
    public String getChildFilter() {
        Object objValue = this.get(FIELD_CHILDFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childfilter")
    public void setChildFilter(String childFilter) {
        this.set(FIELD_CHILDFILTER, childFilter);
    }

    @JsonIgnore
    public boolean isChildFilterDirty() {
        return this.contains(FIELD_CHILDFILTER);
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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
    }

    @JsonIgnore
    public String getCPSSubSysSADEId() {
        Object objValue = this.get(FIELD_CPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpssubsyssadeid")
    public void setCPSSubSysSADEId(String cPSSubSysSADEId) {
        this.set(FIELD_CPSSUBSYSSADEID, cPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isCPSSubSysSADEIdDirty() {
        return this.contains(FIELD_CPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getCPSSubSysSADEName() {
        Object objValue = this.get(FIELD_CPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpssubsyssadename")
    public void setCPSSubSysSADEName(String cPSSubSysSADEName) {
        this.set(FIELD_CPSSUBSYSSADENAME, cPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isCPSSubSysSADENameDirty() {
        return this.contains(FIELD_CPSSUBSYSSADENAME);
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
    public String getPPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssubsyssadeid")
    public void setPPSSubSysSADEId(String pPSSubSysSADEId) {
        this.set(FIELD_PPSSUBSYSSADEID, pPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssubsyssadename")
    public void setPPSSubSysSADEName(String pPSSubSysSADEName) {
        this.set(FIELD_PPSSUBSYSSADENAME, pPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPPSSubSysSADENameDirty() {
        return this.contains(FIELD_PPSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getPSSubSysSADERSId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADERSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadersid")
    public void setPSSubSysSADERSId(String pSSubSysSADERSId) {
        this.set(FIELD_PSSUBSYSSADERSID, pSSubSysSADERSId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADERSIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADERSID);
    }

    @JsonIgnore
    public String getPSSubSysSADERSName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADERSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadersname")
    public void setPSSubSysSADERSName(String pSSubSysSADERSName) {
        this.set(FIELD_PSSUBSYSSADERSNAME, pSSubSysSADERSName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADERSNameDirty() {
        return this.contains(FIELD_PSSUBSYSSADERSNAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
    }

    @JsonIgnore
    public String getRSTag() {
        Object objValue = this.get(FIELD_RSTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag")
    public void setRSTag(String rSTag) {
        this.set(FIELD_RSTAG, rSTag);
    }

    @JsonIgnore
    public boolean isRSTagDirty() {
        return this.contains(FIELD_RSTAG);
    }

    @JsonIgnore
    public String getRSTag2() {
        Object objValue = this.get(FIELD_RSTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag2")
    public void setRSTag2(String rSTag2) {
        this.set(FIELD_RSTAG2, rSTag2);
    }

    @JsonIgnore
    public boolean isRSTag2Dirty() {
        return this.contains(FIELD_RSTAG2);
    }

    @JsonIgnore
    public String getTypeFilter() {
        Object objValue = this.get(FIELD_TYPEFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typefilter")
    public void setTypeFilter(String typeFilter) {
        this.set(FIELD_TYPEFILTER, typeFilter);
    }

    @JsonIgnore
    public boolean isTypeFilterDirty() {
        return this.contains(FIELD_TYPEFILTER);
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
    public String getSrfkey() {
        return this.getPSSubSysSADERSId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSubSysSADERSId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSUBSYSSADERS";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSubSysSADERS item = (PSSubSysSADERS)MAPPER.readValue(new File(strJsonFilePath), PSSubSysSADERS.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSubSysSADERS) {
            PSSubSysSADERS pSSubSysSADERS = (PSSubSysSADERS)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSubSysSADERS) {
            PSSubSysSADERS pSSubSysSADERS = (PSSubSysSADERS)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

