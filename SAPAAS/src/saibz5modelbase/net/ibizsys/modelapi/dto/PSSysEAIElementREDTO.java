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

public class PSSysEAIElementREDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_EAIELEMENTRETYPE = "eaielementretype";
    public static final String FIELD_FIXEDVALUE = "fixedvalue";
    public static final String FIELD_MAXOCCURS = "maxoccurs";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINOCCURS = "minoccurs";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSSYSEAIDATATYPEID = "pssyseaidatatypeid";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "pssyseaidatatypename";
    public static final String FIELD_PSSYSEAIELEMENTID = "pssyseaielementid";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "pssyseaielementname";
    public static final String FIELD_PSSYSEAIELEMENTREID = "pssyseaielementreid";
    public static final String FIELD_PSSYSEAIELEMENTRENAME = "pssyseaielementrename";
    public static final String FIELD_PSSYSEAISCHEMEID = "pssyseaischemeid";
    public static final String FIELD_REFPSSYSEAIELEMENTID = "refpssyseaielementid";
    public static final String FIELD_REFPSSYSEAIELEMENTNAME = "refpssyseaielementname";
    public static final String FIELD_RETAG = "retag";
    public static final String FIELD_RETAG2 = "retag2";
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
    public String getDefaultValue() {
        Object objValue = this.get(FIELD_DEFAULTVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultvalue")
    public void setDefaultValue(String defaultValue) {
        this.set(FIELD_DEFAULTVALUE, defaultValue);
    }

    @JsonIgnore
    public boolean isDefaultValueDirty() {
        return this.contains(FIELD_DEFAULTVALUE);
    }

    @JsonIgnore
    public String getEAIElementREType() {
        Object objValue = this.get(FIELD_EAIELEMENTRETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaielementretype")
    public void setEAIElementREType(String eAIElementREType) {
        this.set(FIELD_EAIELEMENTRETYPE, eAIElementREType);
    }

    @JsonIgnore
    public boolean isEAIElementRETypeDirty() {
        return this.contains(FIELD_EAIELEMENTRETYPE);
    }

    @JsonIgnore
    public String getFixedValue() {
        Object objValue = this.get(FIELD_FIXEDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fixedvalue")
    public void setFixedValue(String fixedValue) {
        this.set(FIELD_FIXEDVALUE, fixedValue);
    }

    @JsonIgnore
    public boolean isFixedValueDirty() {
        return this.contains(FIELD_FIXEDVALUE);
    }

    @JsonIgnore
    public Integer getMaxOccurs() {
        Object objValue = this.get(FIELD_MAXOCCURS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxoccurs")
    public void setMaxOccurs(Integer maxOccurs) {
        this.set(FIELD_MAXOCCURS, maxOccurs);
    }

    @JsonIgnore
    public boolean isMaxOccursDirty() {
        return this.contains(FIELD_MAXOCCURS);
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
    public Integer getMinOccurs() {
        Object objValue = this.get(FIELD_MINOCCURS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minoccurs")
    public void setMinOccurs(Integer minOccurs) {
        this.set(FIELD_MINOCCURS, minOccurs);
    }

    @JsonIgnore
    public boolean isMinOccursDirty() {
        return this.contains(FIELD_MINOCCURS);
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
    public String getPSSysEAIDataTypeId() {
        Object objValue = this.get(FIELD_PSSYSEAIDATATYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidatatypeid")
    public void setPSSysEAIDataTypeId(String pSSysEAIDataTypeId) {
        this.set(FIELD_PSSYSEAIDATATYPEID, pSSysEAIDataTypeId);
    }

    @JsonIgnore
    public boolean isPSSysEAIDataTypeIdDirty() {
        return this.contains(FIELD_PSSYSEAIDATATYPEID);
    }

    @JsonIgnore
    public String getPSSysEAIDataTypeName() {
        Object objValue = this.get(FIELD_PSSYSEAIDATATYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidatatypename")
    public void setPSSysEAIDataTypeName(String pSSysEAIDataTypeName) {
        this.set(FIELD_PSSYSEAIDATATYPENAME, pSSysEAIDataTypeName);
    }

    @JsonIgnore
    public boolean isPSSysEAIDataTypeNameDirty() {
        return this.contains(FIELD_PSSYSEAIDATATYPENAME);
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
    public String getPSSysEAIElementName() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementname")
    public void setPSSysEAIElementName(String pSSysEAIElementName) {
        this.set(FIELD_PSSYSEAIELEMENTNAME, pSSysEAIElementName);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementNameDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTNAME);
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
    public String getPSSysEAISchemeId() {
        Object objValue = this.get(FIELD_PSSYSEAISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaischemeid")
    public void setPSSysEAISchemeId(String pSSysEAISchemeId) {
        this.set(FIELD_PSSYSEAISCHEMEID, pSSysEAISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysEAISchemeIdDirty() {
        return this.contains(FIELD_PSSYSEAISCHEMEID);
    }

    @JsonIgnore
    public String getRefPSSysEAIElementId() {
        Object objValue = this.get(FIELD_REFPSSYSEAIELEMENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssyseaielementid")
    public void setRefPSSysEAIElementId(String refPSSysEAIElementId) {
        this.set(FIELD_REFPSSYSEAIELEMENTID, refPSSysEAIElementId);
    }

    @JsonIgnore
    public boolean isRefPSSysEAIElementIdDirty() {
        return this.contains(FIELD_REFPSSYSEAIELEMENTID);
    }

    @JsonIgnore
    public String getRefPSSysEAIElementName() {
        Object objValue = this.get(FIELD_REFPSSYSEAIELEMENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssyseaielementname")
    public void setRefPSSysEAIElementName(String refPSSysEAIElementName) {
        this.set(FIELD_REFPSSYSEAIELEMENTNAME, refPSSysEAIElementName);
    }

    @JsonIgnore
    public boolean isRefPSSysEAIElementNameDirty() {
        return this.contains(FIELD_REFPSSYSEAIELEMENTNAME);
    }

    @JsonIgnore
    public String getRETag() {
        Object objValue = this.get(FIELD_RETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retag")
    public void setRETag(String rETag) {
        this.set(FIELD_RETAG, rETag);
    }

    @JsonIgnore
    public boolean isRETagDirty() {
        return this.contains(FIELD_RETAG);
    }

    @JsonIgnore
    public String getRETag2() {
        Object objValue = this.get(FIELD_RETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retag2")
    public void setRETag2(String rETag2) {
        this.set(FIELD_RETAG2, rETag2);
    }

    @JsonIgnore
    public boolean isRETag2Dirty() {
        return this.contains(FIELD_RETAG2);
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
        return this.getPSSysEAIElementREId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysEAIElementREId(strValue);
    }
}

