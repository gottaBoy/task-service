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

public class PSWFProcParam
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDSTDEFNAME = "customdstdefname";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSWFPROCESSID = "pswfprocessid";
    public static final String FIELD_PSWFPROCESSNAME = "pswfprocessname";
    public static final String FIELD_PSWFPROCPARAMID = "pswfprocparamid";
    public static final String FIELD_PSWFPROCPARAMNAME = "pswfprocparamname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_SRCVALUE = "srcvalue";
    public static final String FIELD_SRCVALUETYPE = "srcvaluetype";
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
    public String getCustomDstDEFName() {
        Object objValue = this.get(FIELD_CUSTOMDSTDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customdstdefname")
    public void setCustomDstDEFName(String customDstDEFName) {
        this.set(FIELD_CUSTOMDSTDEFNAME, customDstDEFName);
    }

    @JsonIgnore
    public boolean isCustomDstDEFNameDirty() {
        return this.contains(FIELD_CUSTOMDSTDEFNAME);
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
    public String getPSWFProcParamId() {
        Object objValue = this.get(FIELD_PSWFPROCPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocparamid")
    public void setPSWFProcParamId(String pSWFProcParamId) {
        this.set(FIELD_PSWFPROCPARAMID, pSWFProcParamId);
    }

    @JsonIgnore
    public boolean isPSWFProcParamIdDirty() {
        return this.contains(FIELD_PSWFPROCPARAMID);
    }

    @JsonIgnore
    public String getPSWFProcParamName() {
        Object objValue = this.get(FIELD_PSWFPROCPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocparamname")
    public void setPSWFProcParamName(String pSWFProcParamName) {
        this.set(FIELD_PSWFPROCPARAMNAME, pSWFProcParamName);
    }

    @JsonIgnore
    public boolean isPSWFProcParamNameDirty() {
        return this.contains(FIELD_PSWFPROCPARAMNAME);
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
    public String getSrcValue() {
        Object objValue = this.get(FIELD_SRCVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcvalue")
    public void setSrcValue(String srcValue) {
        this.set(FIELD_SRCVALUE, srcValue);
    }

    @JsonIgnore
    public boolean isSrcValueDirty() {
        return this.contains(FIELD_SRCVALUE);
    }

    @JsonIgnore
    public String getSrcValueType() {
        Object objValue = this.get(FIELD_SRCVALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcvaluetype")
    public void setSrcValueType(String srcValueType) {
        this.set(FIELD_SRCVALUETYPE, srcValueType);
    }

    @JsonIgnore
    public boolean isSrcValueTypeDirty() {
        return this.contains(FIELD_SRCVALUETYPE);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFProcParamId();
    }

    public void setSrfkey(String strValue) {
        this.setPSWFProcParamId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSWFPROCPARAM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSWFProcParam item = (PSWFProcParam)MAPPER.readValue(new File(strJsonFilePath), PSWFProcParam.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSWFProcParam) {
            PSWFProcParam pSWFProcParam = (PSWFProcParam)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSWFProcParam) {
            PSWFProcParam pSWFProcParam = (PSWFProcParam)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

