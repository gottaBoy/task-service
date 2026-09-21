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

public class PSDEMapDetailDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DSTFIELDNAME = "dstfieldname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAPDETAILID = "psdemapdetailid";
    public static final String FIELD_PSDEMAPDETAILNAME = "psdemapdetailname";
    public static final String FIELD_PSDEMAPID = "psdemapid";
    public static final String FIELD_PSDEMAPNAME = "psdemapname";
    public static final String FIELD_SRCPSDEFID = "srcpsdefid";
    public static final String FIELD_SRCPSDEFNAME = "srcpsdefname";
    public static final String FIELD_SRCTYPE = "srctype";
    public static final String FIELD_SRCVALUE = "srcvalue";
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
    public String getDstFieldName() {
        Object objValue = this.get(FIELD_DSTFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstfieldname")
    public void setDstFieldName(String dstFieldName) {
        this.set(FIELD_DSTFIELDNAME, dstFieldName);
    }

    @JsonIgnore
    public boolean isDstFieldNameDirty() {
        return this.contains(FIELD_DSTFIELDNAME);
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
    public String getPSDEMapDetailId() {
        Object objValue = this.get(FIELD_PSDEMAPDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapdetailid")
    public void setPSDEMapDetailId(String pSDEMapDetailId) {
        this.set(FIELD_PSDEMAPDETAILID, pSDEMapDetailId);
    }

    @JsonIgnore
    public boolean isPSDEMapDetailIdDirty() {
        return this.contains(FIELD_PSDEMAPDETAILID);
    }

    @JsonIgnore
    public String getPSDEMapDetailName() {
        Object objValue = this.get(FIELD_PSDEMAPDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapdetailname")
    public void setPSDEMapDetailName(String pSDEMapDetailName) {
        this.set(FIELD_PSDEMAPDETAILNAME, pSDEMapDetailName);
    }

    @JsonIgnore
    public boolean isPSDEMapDetailNameDirty() {
        return this.contains(FIELD_PSDEMAPDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEMapId() {
        Object objValue = this.get(FIELD_PSDEMAPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapid")
    public void setPSDEMapId(String pSDEMapId) {
        this.set(FIELD_PSDEMAPID, pSDEMapId);
    }

    @JsonIgnore
    public boolean isPSDEMapIdDirty() {
        return this.contains(FIELD_PSDEMAPID);
    }

    @JsonIgnore
    public String getPSDEMapName() {
        Object objValue = this.get(FIELD_PSDEMAPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemapname")
    public void setPSDEMapName(String pSDEMapName) {
        this.set(FIELD_PSDEMAPNAME, pSDEMapName);
    }

    @JsonIgnore
    public boolean isPSDEMapNameDirty() {
        return this.contains(FIELD_PSDEMAPNAME);
    }

    @JsonIgnore
    public String getSrcPSDEFId() {
        Object objValue = this.get(FIELD_SRCPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdefid")
    public void setSrcPSDEFId(String srcPSDEFId) {
        this.set(FIELD_SRCPSDEFID, srcPSDEFId);
    }

    @JsonIgnore
    public boolean isSrcPSDEFIdDirty() {
        return this.contains(FIELD_SRCPSDEFID);
    }

    @JsonIgnore
    public String getSrcPSDEFName() {
        Object objValue = this.get(FIELD_SRCPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdefname")
    public void setSrcPSDEFName(String srcPSDEFName) {
        this.set(FIELD_SRCPSDEFNAME, srcPSDEFName);
    }

    @JsonIgnore
    public boolean isSrcPSDEFNameDirty() {
        return this.contains(FIELD_SRCPSDEFNAME);
    }

    @JsonIgnore
    public String getSrcType() {
        Object objValue = this.get(FIELD_SRCTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srctype")
    public void setSrcType(String srcType) {
        this.set(FIELD_SRCTYPE, srcType);
    }

    @JsonIgnore
    public boolean isSrcTypeDirty() {
        return this.contains(FIELD_SRCTYPE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEMapDetailId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEMapDetailId(strValue);
    }
}

