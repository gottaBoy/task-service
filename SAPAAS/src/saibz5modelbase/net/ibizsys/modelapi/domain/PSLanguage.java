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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSLanguageItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSLanguage
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSLANGUAGEID = "pslanguageid";
    public static final String FIELD_PSLANGUAGENAME = "pslanguagename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSLanguageItem> pslanguageitems;

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
        return this.getPSLanguageId();
    }

    public void setSrfkey(String strValue) {
        this.setPSLanguageId(strValue);
    }

    public List<PSLanguageItem> getPslanguageitems() {
        return this.pslanguageitems;
    }

    public void setPslanguageitems(List<PSLanguageItem> pslanguageitems) {
        this.pslanguageitems = pslanguageitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pslanguageitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pslanguageitems")) {
            this.init();
            return this.pslanguageitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSLANGUAGE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSLanguage item = (PSLanguage)MAPPER.readValue(new File(strJsonFilePath), PSLanguage.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSLanguage) {
            PSLanguage dst = (PSLanguage)target;
            if (!bSimple && this.getPslanguageitems() != null) {
                ArrayList<PSLanguageItem> pslanguageitems = new ArrayList<PSLanguageItem>();
                for (PSLanguageItem item : this.getPslanguageitems()) {
                    if (bDeepMode) {
                        PSLanguageItem newitem = new PSLanguageItem();
                        item.to(newitem, false, bDeepMode);
                        pslanguageitems.add(newitem);
                        continue;
                    }
                    pslanguageitems.add(item);
                }
                dst.setPslanguageitems(pslanguageitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSLanguage) {
            PSLanguage src = (PSLanguage)source;
            if (!bSimple && src.getPslanguageitems() != null) {
                ArrayList<PSLanguageItem> pslanguageitems = new ArrayList<PSLanguageItem>();
                for (PSLanguageItem item : src.getPslanguageitems()) {
                    if (bDeepMode) {
                        PSLanguageItem newItem = new PSLanguageItem();
                        newItem.from(item, false, bDeepMode);
                        pslanguageitems.add(newItem);
                        continue;
                    }
                    pslanguageitems.add(item);
                }
                this.setPslanguageitems(pslanguageitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

