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

public class PSSysBDTableRS
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MAJORPSSYSBDTABLEID = "majorpssysbdtableid";
    public static final String FIELD_MAJORPSSYSBDTABLENAME = "majorpssysbdtablename";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORCODENAME = "minorcodename";
    public static final String FIELD_MINORPSSYSBDTABLEID = "minorpssysbdtableid";
    public static final String FIELD_MINORPSSYSBDTABLENAME = "minorpssysbdtablename";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSSYSBDSCHEMEID = "pssysbdschemeid";
    public static final String FIELD_PSSYSBDSCHEMENAME = "pssysbdschemename";
    public static final String FIELD_PSSYSBDTABLERSID = "pssysbdtablersid";
    public static final String FIELD_PSSYSBDTABLERSNAME = "pssysbdtablersname";
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
    public String getMajorPSSysBDTableId() {
        Object objValue = this.get(FIELD_MAJORPSSYSBDTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpssysbdtableid")
    public void setMajorPSSysBDTableId(String majorPSSysBDTableId) {
        this.set(FIELD_MAJORPSSYSBDTABLEID, majorPSSysBDTableId);
    }

    @JsonIgnore
    public boolean isMajorPSSysBDTableIdDirty() {
        return this.contains(FIELD_MAJORPSSYSBDTABLEID);
    }

    @JsonIgnore
    public String getMajorPSSysBDTableName() {
        Object objValue = this.get(FIELD_MAJORPSSYSBDTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpssysbdtablename")
    public void setMajorPSSysBDTableName(String majorPSSysBDTableName) {
        this.set(FIELD_MAJORPSSYSBDTABLENAME, majorPSSysBDTableName);
    }

    @JsonIgnore
    public boolean isMajorPSSysBDTableNameDirty() {
        return this.contains(FIELD_MAJORPSSYSBDTABLENAME);
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
    public String getMinorCodeName() {
        Object objValue = this.get(FIELD_MINORCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorcodename")
    public void setMinorCodeName(String minorCodeName) {
        this.set(FIELD_MINORCODENAME, minorCodeName);
    }

    @JsonIgnore
    public boolean isMinorCodeNameDirty() {
        return this.contains(FIELD_MINORCODENAME);
    }

    @JsonIgnore
    public String getMinorPSSysBDTableId() {
        Object objValue = this.get(FIELD_MINORPSSYSBDTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpssysbdtableid")
    public void setMinorPSSysBDTableId(String minorPSSysBDTableId) {
        this.set(FIELD_MINORPSSYSBDTABLEID, minorPSSysBDTableId);
    }

    @JsonIgnore
    public boolean isMinorPSSysBDTableIdDirty() {
        return this.contains(FIELD_MINORPSSYSBDTABLEID);
    }

    @JsonIgnore
    public String getMinorPSSysBDTableName() {
        Object objValue = this.get(FIELD_MINORPSSYSBDTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpssysbdtablename")
    public void setMinorPSSysBDTableName(String minorPSSysBDTableName) {
        this.set(FIELD_MINORPSSYSBDTABLENAME, minorPSSysBDTableName);
    }

    @JsonIgnore
    public boolean isMinorPSSysBDTableNameDirty() {
        return this.contains(FIELD_MINORPSSYSBDTABLENAME);
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
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
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
    public String getPSSysBDSchemeName() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemename")
    public void setPSSysBDSchemeName(String pSSysBDSchemeName) {
        this.set(FIELD_PSSYSBDSCHEMENAME, pSSysBDSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeNameDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMENAME);
    }

    @JsonIgnore
    public String getPSSysBDTableRSId() {
        Object objValue = this.get(FIELD_PSSYSBDTABLERSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtablersid")
    public void setPSSysBDTableRSId(String pSSysBDTableRSId) {
        this.set(FIELD_PSSYSBDTABLERSID, pSSysBDTableRSId);
    }

    @JsonIgnore
    public boolean isPSSysBDTableRSIdDirty() {
        return this.contains(FIELD_PSSYSBDTABLERSID);
    }

    @JsonIgnore
    public String getPSSysBDTableRSName() {
        Object objValue = this.get(FIELD_PSSYSBDTABLERSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtablersname")
    public void setPSSysBDTableRSName(String pSSysBDTableRSName) {
        this.set(FIELD_PSSYSBDTABLERSNAME, pSSysBDTableRSName);
    }

    @JsonIgnore
    public boolean isPSSysBDTableRSNameDirty() {
        return this.contains(FIELD_PSSYSBDTABLERSNAME);
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
        return this.getPSSysBDTableRSId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBDTableRSId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBDTABLERS";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBDTableRS item = (PSSysBDTableRS)MAPPER.readValue(new File(strJsonFilePath), PSSysBDTableRS.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBDTableRS) {
            PSSysBDTableRS pSSysBDTableRS = (PSSysBDTableRS)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBDTableRS) {
            PSSysBDTableRS pSSysBDTableRS = (PSSysBDTableRS)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

