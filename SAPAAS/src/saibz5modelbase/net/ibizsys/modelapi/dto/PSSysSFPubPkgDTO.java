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

public class PSSysSFPubPkgDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PKGPARAM = "pkgparam";
    public static final String FIELD_PKGPARAM2 = "pkgparam2";
    public static final String FIELD_PKGPARAM3 = "pkgparam3";
    public static final String FIELD_PKGPARAM4 = "pkgparam4";
    public static final String FIELD_PSSFPKGID = "pssfpkgid";
    public static final String FIELD_PSSFPKGNAME = "pssfpkgname";
    public static final String FIELD_PSSFPKGVERID = "pssfpkgverid";
    public static final String FIELD_PSSFPKGVERNAME = "pssfpkgvername";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSSFPUBPKGID = "pssyssfpubpkgid";
    public static final String FIELD_PSSYSSFPUBPKGNAME = "pssyssfpubpkgname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getPkgParam() {
        Object objValue = this.get(FIELD_PKGPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgparam")
    public void setPkgParam(String pkgParam) {
        this.set(FIELD_PKGPARAM, pkgParam);
    }

    @JsonIgnore
    public boolean isPkgParamDirty() {
        return this.contains(FIELD_PKGPARAM);
    }

    @JsonIgnore
    public String getPkgParam2() {
        Object objValue = this.get(FIELD_PKGPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgparam2")
    public void setPkgParam2(String pkgParam2) {
        this.set(FIELD_PKGPARAM2, pkgParam2);
    }

    @JsonIgnore
    public boolean isPkgParam2Dirty() {
        return this.contains(FIELD_PKGPARAM2);
    }

    @JsonIgnore
    public String getPkgParam3() {
        Object objValue = this.get(FIELD_PKGPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgparam3")
    public void setPkgParam3(String pkgParam3) {
        this.set(FIELD_PKGPARAM3, pkgParam3);
    }

    @JsonIgnore
    public boolean isPkgParam3Dirty() {
        return this.contains(FIELD_PKGPARAM3);
    }

    @JsonIgnore
    public String getPkgParam4() {
        Object objValue = this.get(FIELD_PKGPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgparam4")
    public void setPkgParam4(String pkgParam4) {
        this.set(FIELD_PKGPARAM4, pkgParam4);
    }

    @JsonIgnore
    public boolean isPkgParam4Dirty() {
        return this.contains(FIELD_PKGPARAM4);
    }

    @JsonIgnore
    public String getPSSFPkgId() {
        Object objValue = this.get(FIELD_PSSFPKGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpkgid")
    public void setPSSFPkgId(String pSSFPkgId) {
        this.set(FIELD_PSSFPKGID, pSSFPkgId);
    }

    @JsonIgnore
    public boolean isPSSFPkgIdDirty() {
        return this.contains(FIELD_PSSFPKGID);
    }

    @JsonIgnore
    public String getPSSFPkgName() {
        Object objValue = this.get(FIELD_PSSFPKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpkgname")
    public void setPSSFPkgName(String pSSFPkgName) {
        this.set(FIELD_PSSFPKGNAME, pSSFPkgName);
    }

    @JsonIgnore
    public boolean isPSSFPkgNameDirty() {
        return this.contains(FIELD_PSSFPKGNAME);
    }

    @JsonIgnore
    public String getPSSFPkgVerId() {
        Object objValue = this.get(FIELD_PSSFPKGVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpkgverid")
    public void setPSSFPkgVerId(String pSSFPkgVerId) {
        this.set(FIELD_PSSFPKGVERID, pSSFPkgVerId);
    }

    @JsonIgnore
    public boolean isPSSFPkgVerIdDirty() {
        return this.contains(FIELD_PSSFPKGVERID);
    }

    @JsonIgnore
    public String getPSSFPkgVerName() {
        Object objValue = this.get(FIELD_PSSFPKGVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpkgvername")
    public void setPSSFPkgVerName(String pSSFPkgVerName) {
        this.set(FIELD_PSSFPKGVERNAME, pSSFPkgVerName);
    }

    @JsonIgnore
    public boolean isPSSFPkgVerNameDirty() {
        return this.contains(FIELD_PSSFPKGVERNAME);
    }

    @JsonIgnore
    public String getPSSysSFPubId() {
        Object objValue = this.get(FIELD_PSSYSSFPUBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubid")
    public void setPSSysSFPubId(String pSSysSFPubId) {
        this.set(FIELD_PSSYSSFPUBID, pSSysSFPubId);
    }

    @JsonIgnore
    public boolean isPSSysSFPubIdDirty() {
        return this.contains(FIELD_PSSYSSFPUBID);
    }

    @JsonIgnore
    public String getPSSysSFPubName() {
        Object objValue = this.get(FIELD_PSSYSSFPUBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubname")
    public void setPSSysSFPubName(String pSSysSFPubName) {
        this.set(FIELD_PSSYSSFPUBNAME, pSSysSFPubName);
    }

    @JsonIgnore
    public boolean isPSSysSFPubNameDirty() {
        return this.contains(FIELD_PSSYSSFPUBNAME);
    }

    @JsonIgnore
    public String getPSSysSFPubPkgId() {
        Object objValue = this.get(FIELD_PSSYSSFPUBPKGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubpkgid")
    public void setPSSysSFPubPkgId(String pSSysSFPubPkgId) {
        this.set(FIELD_PSSYSSFPUBPKGID, pSSysSFPubPkgId);
    }

    @JsonIgnore
    public boolean isPSSysSFPubPkgIdDirty() {
        return this.contains(FIELD_PSSYSSFPUBPKGID);
    }

    @JsonIgnore
    public String getPSSysSFPubPkgName() {
        Object objValue = this.get(FIELD_PSSYSSFPUBPKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubpkgname")
    public void setPSSysSFPubPkgName(String pSSysSFPubPkgName) {
        this.set(FIELD_PSSYSSFPUBPKGNAME, pSSysSFPubPkgName);
    }

    @JsonIgnore
    public boolean isPSSysSFPubPkgNameDirty() {
        return this.contains(FIELD_PSSYSSFPUBPKGNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysSFPubPkgId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysSFPubPkgId(strValue);
    }
}

