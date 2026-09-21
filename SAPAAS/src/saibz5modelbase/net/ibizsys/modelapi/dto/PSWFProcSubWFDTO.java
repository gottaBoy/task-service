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

public class PSWFProcSubWFDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EMBEDPSDEDSID = "embedpsdedsid";
    public static final String FIELD_EMBEDPSDEDSNAME = "embedpsdedsname";
    public static final String FIELD_EMBEDPSDEID = "embedpsdeid";
    public static final String FIELD_EMBEDPSWFDEID = "embedpswfdeid";
    public static final String FIELD_EMBEDPSWFDENAME = "embedpswfdename";
    public static final String FIELD_EMBEDPSWFID = "embedpswfid";
    public static final String FIELD_EMBEDPSWFNAME = "embedpswfname";
    public static final String FIELD_EMBEDPSWFVERID = "embedpswfverid";
    public static final String FIELD_EMBEDPSWFVERNAME = "embedpswfvername";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFPROCESSID = "pswfprocessid";
    public static final String FIELD_PSWFPROCESSNAME = "pswfprocessname";
    public static final String FIELD_PSWFPROCSUBWFID = "pswfprocsubwfid";
    public static final String FIELD_PSWFPROCSUBWFNAME = "pswfprocsubwfname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_SUSPENDDEFAULT = "suspenddefault";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getEmbedPSDEDSId() {
        Object objValue = this.get(FIELD_EMBEDPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdedsid")
    public void setEmbedPSDEDSId(String embedPSDEDSId) {
        this.set(FIELD_EMBEDPSDEDSID, embedPSDEDSId);
    }

    @JsonIgnore
    public boolean isEmbedPSDEDSIdDirty() {
        return this.contains(FIELD_EMBEDPSDEDSID);
    }

    @JsonIgnore
    public String getEmbedPSDEDSName() {
        Object objValue = this.get(FIELD_EMBEDPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdedsname")
    public void setEmbedPSDEDSName(String embedPSDEDSName) {
        this.set(FIELD_EMBEDPSDEDSNAME, embedPSDEDSName);
    }

    @JsonIgnore
    public boolean isEmbedPSDEDSNameDirty() {
        return this.contains(FIELD_EMBEDPSDEDSNAME);
    }

    @JsonIgnore
    public String getEmbedPSDEId() {
        Object objValue = this.get(FIELD_EMBEDPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdeid")
    public void setEmbedPSDEId(String embedPSDEId) {
        this.set(FIELD_EMBEDPSDEID, embedPSDEId);
    }

    @JsonIgnore
    public boolean isEmbedPSDEIdDirty() {
        return this.contains(FIELD_EMBEDPSDEID);
    }

    @JsonIgnore
    public String getEmbedPSWFDEId() {
        Object objValue = this.get(FIELD_EMBEDPSWFDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfdeid")
    public void setEmbedPSWFDEId(String embedPSWFDEId) {
        this.set(FIELD_EMBEDPSWFDEID, embedPSWFDEId);
    }

    @JsonIgnore
    public boolean isEmbedPSWFDEIdDirty() {
        return this.contains(FIELD_EMBEDPSWFDEID);
    }

    @JsonIgnore
    public String getEmbedPSWFDEName() {
        Object objValue = this.get(FIELD_EMBEDPSWFDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfdename")
    public void setEmbedPSWFDEName(String embedPSWFDEName) {
        this.set(FIELD_EMBEDPSWFDENAME, embedPSWFDEName);
    }

    @JsonIgnore
    public boolean isEmbedPSWFDENameDirty() {
        return this.contains(FIELD_EMBEDPSWFDENAME);
    }

    @JsonIgnore
    public String getEmbedPSWFId() {
        Object objValue = this.get(FIELD_EMBEDPSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfid")
    public void setEmbedPSWFId(String embedPSWFId) {
        this.set(FIELD_EMBEDPSWFID, embedPSWFId);
    }

    @JsonIgnore
    public boolean isEmbedPSWFIdDirty() {
        return this.contains(FIELD_EMBEDPSWFID);
    }

    @JsonIgnore
    public String getEmbedPSWFName() {
        Object objValue = this.get(FIELD_EMBEDPSWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfname")
    public void setEmbedPSWFName(String embedPSWFName) {
        this.set(FIELD_EMBEDPSWFNAME, embedPSWFName);
    }

    @JsonIgnore
    public boolean isEmbedPSWFNameDirty() {
        return this.contains(FIELD_EMBEDPSWFNAME);
    }

    @JsonIgnore
    public String getEmbedPSWFVerId() {
        Object objValue = this.get(FIELD_EMBEDPSWFVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfverid")
    public void setEmbedPSWFVerId(String embedPSWFVerId) {
        this.set(FIELD_EMBEDPSWFVERID, embedPSWFVerId);
    }

    @JsonIgnore
    public boolean isEmbedPSWFVerIdDirty() {
        return this.contains(FIELD_EMBEDPSWFVERID);
    }

    @JsonIgnore
    public String getEmbedPSWFVerName() {
        Object objValue = this.get(FIELD_EMBEDPSWFVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfvername")
    public void setEmbedPSWFVerName(String embedPSWFVerName) {
        this.set(FIELD_EMBEDPSWFVERNAME, embedPSWFVerName);
    }

    @JsonIgnore
    public boolean isEmbedPSWFVerNameDirty() {
        return this.contains(FIELD_EMBEDPSWFVERNAME);
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
    public String getPSSystemId() {
        Object objValue = this.get(FIELD_PSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemid")
    public void setPSSystemId(String pSSystemId) {
        this.set(FIELD_PSSYSTEMID, pSSystemId);
    }

    @JsonIgnore
    public boolean isPSSystemIdDirty() {
        return this.contains(FIELD_PSSYSTEMID);
    }

    @JsonIgnore
    public String getPSWFId() {
        Object objValue = this.get(FIELD_PSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfid")
    public void setPSWFId(String pSWFId) {
        this.set(FIELD_PSWFID, pSWFId);
    }

    @JsonIgnore
    public boolean isPSWFIdDirty() {
        return this.contains(FIELD_PSWFID);
    }

    @JsonIgnore
    public String getPSWFProcessId() {
        Object objValue = this.get(FIELD_PSWFPROCESSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessid")
    public void setPSWFProcessId(String pSWFProcessId) {
        this.set(FIELD_PSWFPROCESSID, pSWFProcessId);
    }

    @JsonIgnore
    public boolean isPSWFProcessIdDirty() {
        return this.contains(FIELD_PSWFPROCESSID);
    }

    @JsonIgnore
    public String getPSWFProcessName() {
        Object objValue = this.get(FIELD_PSWFPROCESSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessname")
    public void setPSWFProcessName(String pSWFProcessName) {
        this.set(FIELD_PSWFPROCESSNAME, pSWFProcessName);
    }

    @JsonIgnore
    public boolean isPSWFProcessNameDirty() {
        return this.contains(FIELD_PSWFPROCESSNAME);
    }

    @JsonIgnore
    public String getPSWFProcSubWFId() {
        Object objValue = this.get(FIELD_PSWFPROCSUBWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocsubwfid")
    public void setPSWFProcSubWFId(String pSWFProcSubWFId) {
        this.set(FIELD_PSWFPROCSUBWFID, pSWFProcSubWFId);
    }

    @JsonIgnore
    public boolean isPSWFProcSubWFIdDirty() {
        return this.contains(FIELD_PSWFPROCSUBWFID);
    }

    @JsonIgnore
    public String getPSWFProcSubWFName() {
        Object objValue = this.get(FIELD_PSWFPROCSUBWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocsubwfname")
    public void setPSWFProcSubWFName(String pSWFProcSubWFName) {
        this.set(FIELD_PSWFPROCSUBWFNAME, pSWFProcSubWFName);
    }

    @JsonIgnore
    public boolean isPSWFProcSubWFNameDirty() {
        return this.contains(FIELD_PSWFPROCSUBWFNAME);
    }

    @JsonIgnore
    public String getPSWFVersionId() {
        Object objValue = this.get(FIELD_PSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionid")
    public void setPSWFVersionId(String pSWFVersionId) {
        this.set(FIELD_PSWFVERSIONID, pSWFVersionId);
    }

    @JsonIgnore
    public boolean isPSWFVersionIdDirty() {
        return this.contains(FIELD_PSWFVERSIONID);
    }

    @JsonIgnore
    public Integer getSuspendDefault() {
        Object objValue = this.get(FIELD_SUSPENDDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="suspenddefault")
    public void setSuspendDefault(Integer suspendDefault) {
        this.set(FIELD_SUSPENDDEFAULT, suspendDefault);
    }

    @JsonIgnore
    public boolean isSuspendDefaultDirty() {
        return this.contains(FIELD_SUSPENDDEFAULT);
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
    public String getUserData() {
        Object objValue = this.get(FIELD_USERDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata")
    public void setUserData(String userData) {
        this.set(FIELD_USERDATA, userData);
    }

    @JsonIgnore
    public boolean isUserDataDirty() {
        return this.contains(FIELD_USERDATA);
    }

    @JsonIgnore
    public String getUserData2() {
        Object objValue = this.get(FIELD_USERDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata2")
    public void setUserData2(String userData2) {
        this.set(FIELD_USERDATA2, userData2);
    }

    @JsonIgnore
    public boolean isUserData2Dirty() {
        return this.contains(FIELD_USERDATA2);
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
        return this.getPSWFProcSubWFId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWFProcSubWFId(strValue);
    }
}

