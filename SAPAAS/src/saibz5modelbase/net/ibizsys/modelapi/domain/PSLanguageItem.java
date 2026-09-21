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

public class PSLanguageItem
extends PSModelBase {
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_CONTENT2 = "content2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFCONTENT = "defcontent";
    public static final String FIELD_LANRESTAG = "lanrestag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSLANGUAGEID = "pslanguageid";
    public static final String FIELD_PSLANGUAGEITEMID = "pslanguageitemid";
    public static final String FIELD_PSLANGUAGEITEMNAME = "pslanguageitemname";
    public static final String FIELD_PSLANGUAGENAME = "pslanguagename";
    public static final String FIELD_PSLANGUAGERESID = "pslanguageresid";
    public static final String FIELD_PSLANGUAGERESNAME = "pslanguageresname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getContent2() {
        Object objValue = this.get(FIELD_CONTENT2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content2")
    public void setContent2(String content2) {
        this.set(FIELD_CONTENT2, content2);
    }

    @JsonIgnore
    public boolean isContent2Dirty() {
        return this.contains(FIELD_CONTENT2);
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
    public String getDefContent() {
        Object objValue = this.get(FIELD_DEFCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defcontent")
    public void setDefContent(String defContent) {
        this.set(FIELD_DEFCONTENT, defContent);
    }

    @JsonIgnore
    public boolean isDefContentDirty() {
        return this.contains(FIELD_DEFCONTENT);
    }

    @JsonIgnore
    public String getLanResTag() {
        Object objValue = this.get(FIELD_LANRESTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lanrestag")
    public void setLanResTag(String lanResTag) {
        this.set(FIELD_LANRESTAG, lanResTag);
    }

    @JsonIgnore
    public boolean isLanResTagDirty() {
        return this.contains(FIELD_LANRESTAG);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public String getPSLanguageId() {
        Object objValue = this.get(FIELD_PSLANGUAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageid")
    public void setPSLanguageId(String pSLanguageId) {
        this.set(FIELD_PSLANGUAGEID, pSLanguageId);
    }

    @JsonIgnore
    public boolean isPSLanguageIdDirty() {
        return this.contains(FIELD_PSLANGUAGEID);
    }

    @JsonIgnore
    public String getPSLanguageItemId() {
        Object objValue = this.get(FIELD_PSLANGUAGEITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageitemid")
    public void setPSLanguageItemId(String pSLanguageItemId) {
        this.set(FIELD_PSLANGUAGEITEMID, pSLanguageItemId);
    }

    @JsonIgnore
    public boolean isPSLanguageItemIdDirty() {
        return this.contains(FIELD_PSLANGUAGEITEMID);
    }

    @JsonIgnore
    public String getPSLanguageItemName() {
        Object objValue = this.get(FIELD_PSLANGUAGEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageitemname")
    public void setPSLanguageItemName(String pSLanguageItemName) {
        this.set(FIELD_PSLANGUAGEITEMNAME, pSLanguageItemName);
    }

    @JsonIgnore
    public boolean isPSLanguageItemNameDirty() {
        return this.contains(FIELD_PSLANGUAGEITEMNAME);
    }

    @JsonIgnore
    public String getPSLanguageName() {
        Object objValue = this.get(FIELD_PSLANGUAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguagename")
    public void setPSLanguageName(String pSLanguageName) {
        this.set(FIELD_PSLANGUAGENAME, pSLanguageName);
    }

    @JsonIgnore
    public boolean isPSLanguageNameDirty() {
        return this.contains(FIELD_PSLANGUAGENAME);
    }

    @JsonIgnore
    public String getPSLanguageResId() {
        Object objValue = this.get(FIELD_PSLANGUAGERESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageresid")
    public void setPSLanguageResId(String pSLanguageResId) {
        this.set(FIELD_PSLANGUAGERESID, pSLanguageResId);
    }

    @JsonIgnore
    public boolean isPSLanguageResIdDirty() {
        return this.contains(FIELD_PSLANGUAGERESID);
    }

    @JsonIgnore
    public String getPSLanguageResName() {
        Object objValue = this.get(FIELD_PSLANGUAGERESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageresname")
    public void setPSLanguageResName(String pSLanguageResName) {
        this.set(FIELD_PSLANGUAGERESNAME, pSLanguageResName);
    }

    @JsonIgnore
    public boolean isPSLanguageResNameDirty() {
        return this.contains(FIELD_PSLANGUAGERESNAME);
    }

    @JsonIgnore
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
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
    public String getPSSystemName() {
        Object objValue = this.get(FIELD_PSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemname")
    public void setPSSystemName(String pSSystemName) {
        this.set(FIELD_PSSYSTEMNAME, pSSystemName);
    }

    @JsonIgnore
    public boolean isPSSystemNameDirty() {
        return this.contains(FIELD_PSSYSTEMNAME);
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
    public String getSrfkey() {
        return this.getPSLanguageItemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSLanguageItemId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSLANGUAGEITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSLanguageItem item = (PSLanguageItem)MAPPER.readValue(new File(strJsonFilePath), PSLanguageItem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSLanguageItem) {
            PSLanguageItem pSLanguageItem = (PSLanguageItem)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSLanguageItem) {
            PSLanguageItem pSLanguageItem = (PSLanguageItem)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

