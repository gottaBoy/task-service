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
import net.ibizsys.modelapi.domain.PSSysBIHierarchy;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysBIDimension
extends PSModelBase {
    public static final String FIELD_BIDIMENSIONTAG = "bidimensiontag";
    public static final String FIELD_BIDIMENSIONTAG2 = "bidimensiontag2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSSYSBIDIMENSIONID = "pssysbidimensionid";
    public static final String FIELD_PSSYSBIDIMENSIONNAME = "pssysbidimensionname";
    public static final String FIELD_PSSYSBISCHEMEID = "pssysbischemeid";
    public static final String FIELD_PSSYSBISCHEMENAME = "pssysbischemename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysBIHierarchy> pssysbihierarchies;

    @JsonIgnore
    public String getBIDimensionTag() {
        Object objValue = this.get(FIELD_BIDIMENSIONTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bidimensiontag")
    public void setBIDimensionTag(String bIDimensionTag) {
        this.set(FIELD_BIDIMENSIONTAG, bIDimensionTag);
    }

    @JsonIgnore
    public boolean isBIDimensionTagDirty() {
        return this.contains(FIELD_BIDIMENSIONTAG);
    }

    @JsonIgnore
    public String getBIDimensionTag2() {
        Object objValue = this.get(FIELD_BIDIMENSIONTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bidimensiontag2")
    public void setBIDimensionTag2(String bIDimensionTag2) {
        this.set(FIELD_BIDIMENSIONTAG2, bIDimensionTag2);
    }

    @JsonIgnore
    public boolean isBIDimensionTag2Dirty() {
        return this.contains(FIELD_BIDIMENSIONTAG2);
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
    public String getPSSysBIDimensionId() {
        Object objValue = this.get(FIELD_PSSYSBIDIMENSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbidimensionid")
    public void setPSSysBIDimensionId(String pSSysBIDimensionId) {
        this.set(FIELD_PSSYSBIDIMENSIONID, pSSysBIDimensionId);
    }

    @JsonIgnore
    public boolean isPSSysBIDimensionIdDirty() {
        return this.contains(FIELD_PSSYSBIDIMENSIONID);
    }

    @JsonIgnore
    public String getPSSysBIDimensionName() {
        Object objValue = this.get(FIELD_PSSYSBIDIMENSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbidimensionname")
    public void setPSSysBIDimensionName(String pSSysBIDimensionName) {
        this.set(FIELD_PSSYSBIDIMENSIONNAME, pSSysBIDimensionName);
    }

    @JsonIgnore
    public boolean isPSSysBIDimensionNameDirty() {
        return this.contains(FIELD_PSSYSBIDIMENSIONNAME);
    }

    @JsonIgnore
    public String getPSSysBISchemeId() {
        Object objValue = this.get(FIELD_PSSYSBISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbischemeid")
    public void setPSSysBISchemeId(String pSSysBISchemeId) {
        this.set(FIELD_PSSYSBISCHEMEID, pSSysBISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBISchemeIdDirty() {
        return this.contains(FIELD_PSSYSBISCHEMEID);
    }

    @JsonIgnore
    public String getPSSysBISchemeName() {
        Object objValue = this.get(FIELD_PSSYSBISCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbischemename")
    public void setPSSysBISchemeName(String pSSysBISchemeName) {
        this.set(FIELD_PSSYSBISCHEMENAME, pSSysBISchemeName);
    }

    @JsonIgnore
    public boolean isPSSysBISchemeNameDirty() {
        return this.contains(FIELD_PSSYSBISCHEMENAME);
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
        return this.getPSSysBIDimensionId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBIDimensionId(strValue);
    }

    public List<PSSysBIHierarchy> getPssysbihierarchies() {
        return this.pssysbihierarchies;
    }

    public void setPssysbihierarchies(List<PSSysBIHierarchy> pssysbihierarchies) {
        this.pssysbihierarchies = pssysbihierarchies;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysbihierarchies")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysbihierarchies")) {
            this.init();
            return this.pssysbihierarchies;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBIDIMENSION";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBIDimension item = (PSSysBIDimension)MAPPER.readValue(new File(strJsonFilePath), PSSysBIDimension.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBIDimension) {
            PSSysBIDimension dst = (PSSysBIDimension)target;
            if (!bSimple && this.getPssysbihierarchies() != null) {
                ArrayList<PSSysBIHierarchy> pssysbihierarchies = new ArrayList<PSSysBIHierarchy>();
                for (PSSysBIHierarchy item : this.getPssysbihierarchies()) {
                    if (bDeepMode) {
                        PSSysBIHierarchy newitem = new PSSysBIHierarchy();
                        item.to(newitem, false, bDeepMode);
                        pssysbihierarchies.add(newitem);
                        continue;
                    }
                    pssysbihierarchies.add(item);
                }
                dst.setPssysbihierarchies(pssysbihierarchies);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBIDimension) {
            PSSysBIDimension src = (PSSysBIDimension)source;
            if (!bSimple && src.getPssysbihierarchies() != null) {
                ArrayList<PSSysBIHierarchy> pssysbihierarchies = new ArrayList<PSSysBIHierarchy>();
                for (PSSysBIHierarchy item : src.getPssysbihierarchies()) {
                    if (bDeepMode) {
                        PSSysBIHierarchy newItem = new PSSysBIHierarchy();
                        newItem.from(item, false, bDeepMode);
                        pssysbihierarchies.add(newItem);
                        continue;
                    }
                    pssysbihierarchies.add(item);
                }
                this.setPssysbihierarchies(pssysbihierarchies);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

