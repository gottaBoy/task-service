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

public class PSSysCanvasModelDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODELID = "psmodelid";
    public static final String FIELD_PSMODELNAME = "psmodelname";
    public static final String FIELD_PSMODELTYPE = "psmodeltype";
    public static final String FIELD_PSSYSCANVASID = "pssyscanvasid";
    public static final String FIELD_PSSYSCANVASMODELID = "pssyscanvasmodelid";
    public static final String FIELD_PSSYSCANVASMODELNAME = "pssyscanvasmodelname";
    public static final String FIELD_PSSYSCANVASNAME = "pssyscanvasname";
    public static final String FIELD_SYMBOLNAME = "symbolname";
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
    public String getPSModelId() {
        Object objValue = this.get(FIELD_PSMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodelid")
    public void setPSModelId(String pSModelId) {
        this.set(FIELD_PSMODELID, pSModelId);
    }

    @JsonIgnore
    public boolean isPSModelIdDirty() {
        return this.contains(FIELD_PSMODELID);
    }

    @JsonIgnore
    public String getPSModelName() {
        Object objValue = this.get(FIELD_PSMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodelname")
    public void setPSModelName(String pSModelName) {
        this.set(FIELD_PSMODELNAME, pSModelName);
    }

    @JsonIgnore
    public boolean isPSModelNameDirty() {
        return this.contains(FIELD_PSMODELNAME);
    }

    @JsonIgnore
    public String getPSModelType() {
        Object objValue = this.get(FIELD_PSMODELTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodeltype")
    public void setPSModelType(String pSModelType) {
        this.set(FIELD_PSMODELTYPE, pSModelType);
    }

    @JsonIgnore
    public boolean isPSModelTypeDirty() {
        return this.contains(FIELD_PSMODELTYPE);
    }

    @JsonIgnore
    public String getPSSysCanvasId() {
        Object objValue = this.get(FIELD_PSSYSCANVASID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasid")
    public void setPSSysCanvasId(String pSSysCanvasId) {
        this.set(FIELD_PSSYSCANVASID, pSSysCanvasId);
    }

    @JsonIgnore
    public boolean isPSSysCanvasIdDirty() {
        return this.contains(FIELD_PSSYSCANVASID);
    }

    @JsonIgnore
    public String getPSSysCanvasModelId() {
        Object objValue = this.get(FIELD_PSSYSCANVASMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasmodelid")
    public void setPSSysCanvasModelId(String pSSysCanvasModelId) {
        this.set(FIELD_PSSYSCANVASMODELID, pSSysCanvasModelId);
    }

    @JsonIgnore
    public boolean isPSSysCanvasModelIdDirty() {
        return this.contains(FIELD_PSSYSCANVASMODELID);
    }

    @JsonIgnore
    public String getPSSysCanvasModelName() {
        Object objValue = this.get(FIELD_PSSYSCANVASMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasmodelname")
    public void setPSSysCanvasModelName(String pSSysCanvasModelName) {
        this.set(FIELD_PSSYSCANVASMODELNAME, pSSysCanvasModelName);
    }

    @JsonIgnore
    public boolean isPSSysCanvasModelNameDirty() {
        return this.contains(FIELD_PSSYSCANVASMODELNAME);
    }

    @JsonIgnore
    public String getPSSysCanvasName() {
        Object objValue = this.get(FIELD_PSSYSCANVASNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscanvasname")
    public void setPSSysCanvasName(String pSSysCanvasName) {
        this.set(FIELD_PSSYSCANVASNAME, pSSysCanvasName);
    }

    @JsonIgnore
    public boolean isPSSysCanvasNameDirty() {
        return this.contains(FIELD_PSSYSCANVASNAME);
    }

    @JsonIgnore
    public String getSymbolName() {
        Object objValue = this.get(FIELD_SYMBOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="symbolname")
    public void setSymbolName(String symbolName) {
        this.set(FIELD_SYMBOLNAME, symbolName);
    }

    @JsonIgnore
    public boolean isSymbolNameDirty() {
        return this.contains(FIELD_SYMBOLNAME);
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
        return this.getPSSysCanvasModelId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysCanvasModelId(strValue);
    }
}

