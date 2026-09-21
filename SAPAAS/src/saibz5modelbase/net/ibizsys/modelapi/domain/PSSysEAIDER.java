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

public class PSSysEAIDER
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EAIDERTAG = "eaidertag";
    public static final String FIELD_EAIDERTAG2 = "eaidertag2";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSSYSEAIDEID = "pssyseaideid";
    public static final String FIELD_PSSYSEAIDENAME = "pssyseaidename";
    public static final String FIELD_PSSYSEAIDERID = "pssyseaiderid";
    public static final String FIELD_PSSYSEAIDERNAME = "pssyseaidername";
    public static final String FIELD_PSSYSEAIELEMENTID = "pssyseaielementid";
    public static final String FIELD_PSSYSEAIELEMENTREID = "pssyseaielementreid";
    public static final String FIELD_PSSYSEAIELEMENTRENAME = "pssyseaielementrename";
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
    public String getEAIDERTag() {
        Object objValue = this.get(FIELD_EAIDERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidertag")
    public void setEAIDERTag(String eAIDERTag) {
        this.set(FIELD_EAIDERTAG, eAIDERTag);
    }

    @JsonIgnore
    public boolean isEAIDERTagDirty() {
        return this.contains(FIELD_EAIDERTAG);
    }

    @JsonIgnore
    public String getEAIDERTag2() {
        Object objValue = this.get(FIELD_EAIDERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidertag2")
    public void setEAIDERTag2(String eAIDERTag2) {
        this.set(FIELD_EAIDERTAG2, eAIDERTag2);
    }

    @JsonIgnore
    public boolean isEAIDERTag2Dirty() {
        return this.contains(FIELD_EAIDERTAG2);
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
    public String getPSSysEAIDEId() {
        Object objValue = this.get(FIELD_PSSYSEAIDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaideid")
    public void setPSSysEAIDEId(String pSSysEAIDEId) {
        this.set(FIELD_PSSYSEAIDEID, pSSysEAIDEId);
    }

    @JsonIgnore
    public boolean isPSSysEAIDEIdDirty() {
        return this.contains(FIELD_PSSYSEAIDEID);
    }

    @JsonIgnore
    public String getPSSysEAIDEName() {
        Object objValue = this.get(FIELD_PSSYSEAIDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidename")
    public void setPSSysEAIDEName(String pSSysEAIDEName) {
        this.set(FIELD_PSSYSEAIDENAME, pSSysEAIDEName);
    }

    @JsonIgnore
    public boolean isPSSysEAIDENameDirty() {
        return this.contains(FIELD_PSSYSEAIDENAME);
    }

    @JsonIgnore
    public String getPSSysEAIDERId() {
        Object objValue = this.get(FIELD_PSSYSEAIDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaiderid")
    public void setPSSysEAIDERId(String pSSysEAIDERId) {
        this.set(FIELD_PSSYSEAIDERID, pSSysEAIDERId);
    }

    @JsonIgnore
    public boolean isPSSysEAIDERIdDirty() {
        return this.contains(FIELD_PSSYSEAIDERID);
    }

    @JsonIgnore
    public String getPSSysEAIDERName() {
        Object objValue = this.get(FIELD_PSSYSEAIDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidername")
    public void setPSSysEAIDERName(String pSSysEAIDERName) {
        this.set(FIELD_PSSYSEAIDERNAME, pSSysEAIDERName);
    }

    @JsonIgnore
    public boolean isPSSysEAIDERNameDirty() {
        return this.contains(FIELD_PSSYSEAIDERNAME);
    }

    @JsonIgnore
    public String getPSSysEAIElementId() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementid")
    public void setPSSysEAIElementId(String pSSysEAIElementId) {
        this.set(FIELD_PSSYSEAIELEMENTID, pSSysEAIElementId);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementIdDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTID);
    }

    @JsonIgnore
    public String getPSSysEAIElementREId() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTREID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementreid")
    public void setPSSysEAIElementREId(String pSSysEAIElementREId) {
        this.set(FIELD_PSSYSEAIELEMENTREID, pSSysEAIElementREId);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementREIdDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTREID);
    }

    @JsonIgnore
    public String getPSSysEAIElementREName() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTRENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementrename")
    public void setPSSysEAIElementREName(String pSSysEAIElementREName) {
        this.set(FIELD_PSSYSEAIELEMENTRENAME, pSSysEAIElementREName);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementRENameDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTRENAME);
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
        return this.getPSSysEAIDERId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysEAIDERId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSEAIDER";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysEAIDER item = (PSSysEAIDER)MAPPER.readValue(new File(strJsonFilePath), PSSysEAIDER.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysEAIDER) {
            PSSysEAIDER pSSysEAIDER = (PSSysEAIDER)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysEAIDER) {
            PSSysEAIDER pSSysEAIDER = (PSSysEAIDER)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

