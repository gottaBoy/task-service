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

public class PSAppResource
extends PSModelBase {
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_CONTENTPSLANRESID = "contentpslanresid";
    public static final String FIELD_CONTENTPSLANRESNAME = "contentpslanresname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSAPPRESOURCEID = "psappresourceid";
    public static final String FIELD_PSAPPRESOURCENAME = "psappresourcename";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_RESOURCETYPE = "resourcetype";
    public static final String FIELD_RESTAG = "restag";
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
    public String getContent() {
        Object objValue = this.get(FIELD_CONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content")
    public void setContent(String content) {
        this.set(FIELD_CONTENT, content);
    }

    @JsonIgnore
    public boolean isContentDirty() {
        return this.contains(FIELD_CONTENT);
    }

    @JsonIgnore
    public String getContentPSLanResId() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresid")
    public void setContentPSLanResId(String contentPSLanResId) {
        this.set(FIELD_CONTENTPSLANRESID, contentPSLanResId);
    }

    @JsonIgnore
    public boolean isContentPSLanResIdDirty() {
        return this.contains(FIELD_CONTENTPSLANRESID);
    }

    @JsonIgnore
    public String getContentPSLanResName() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresname")
    public void setContentPSLanResName(String contentPSLanResName) {
        this.set(FIELD_CONTENTPSLANRESNAME, contentPSLanResName);
    }

    @JsonIgnore
    public boolean isContentPSLanResNameDirty() {
        return this.contains(FIELD_CONTENTPSLANRESNAME);
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
    public String getPSAppResourceId() {
        Object objValue = this.get(FIELD_PSAPPRESOURCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappresourceid")
    public void setPSAppResourceId(String pSAppResourceId) {
        this.set(FIELD_PSAPPRESOURCEID, pSAppResourceId);
    }

    @JsonIgnore
    public boolean isPSAppResourceIdDirty() {
        return this.contains(FIELD_PSAPPRESOURCEID);
    }

    @JsonIgnore
    public String getPSAppResourceName() {
        Object objValue = this.get(FIELD_PSAPPRESOURCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappresourcename")
    public void setPSAppResourceName(String pSAppResourceName) {
        this.set(FIELD_PSAPPRESOURCENAME, pSAppResourceName);
    }

    @JsonIgnore
    public boolean isPSAppResourceNameDirty() {
        return this.contains(FIELD_PSAPPRESOURCENAME);
    }

    @JsonIgnore
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
    }

    @JsonIgnore
    public String getResourceType() {
        Object objValue = this.get(FIELD_RESOURCETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="resourcetype")
    public void setResourceType(String resourceType) {
        this.set(FIELD_RESOURCETYPE, resourceType);
    }

    @JsonIgnore
    public boolean isResourceTypeDirty() {
        return this.contains(FIELD_RESOURCETYPE);
    }

    @JsonIgnore
    public String getResTag() {
        Object objValue = this.get(FIELD_RESTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="restag")
    public void setResTag(String resTag) {
        this.set(FIELD_RESTAG, resTag);
    }

    @JsonIgnore
    public boolean isResTagDirty() {
        return this.contains(FIELD_RESTAG);
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
        return this.getPSAppResourceId();
    }

    public void setSrfkey(String strValue) {
        this.setPSAppResourceId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPRESOURCE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppResource item = (PSAppResource)MAPPER.readValue(new File(strJsonFilePath), PSAppResource.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppResource) {
            PSAppResource pSAppResource = (PSAppResource)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppResource) {
            PSAppResource pSAppResource = (PSAppResource)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

