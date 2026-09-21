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

public class PSSysEAIElementAttr
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_ATTRTAG = "attrtag";
    public static final String FIELD_ATTRTAG2 = "attrtag2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_EAIELEMENTATTRTYPE = "eaielementattrtype";
    public static final String FIELD_FIXEDVALUE = "fixedvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSSYSEAIDATATYPEID = "pssyseaidatatypeid";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "pssyseaidatatypename";
    public static final String FIELD_PSSYSEAIELEMENTATTRID = "pssyseaielementattrid";
    public static final String FIELD_PSSYSEAIELEMENTATTRNAME = "pssyseaielementattrname";
    public static final String FIELD_PSSYSEAIELEMENTID = "pssyseaielementid";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "pssyseaielementname";
    public static final String FIELD_PSSYSEAISCHEMEID = "pssyseaischemeid";
    public static final String FIELD_REFPSSYSEAIELEMENTID = "refpssyseaielementid";
    public static final String FIELD_REFPSSYSEAIELEMENTNAME = "refpssyseaielementname";
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
    public Integer getAllowEmpty() {
        Object objValue = this.get(FIELD_ALLOWEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowempty")
    public void setAllowEmpty(Integer allowEmpty) {
        this.set(FIELD_ALLOWEMPTY, allowEmpty);
    }

    @JsonIgnore
    public boolean isAllowEmptyDirty() {
        return this.contains(FIELD_ALLOWEMPTY);
    }

    @JsonIgnore
    public String getAttrTag() {
        Object objValue = this.get(FIELD_ATTRTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrtag")
    public void setAttrTag(String attrTag) {
        this.set(FIELD_ATTRTAG, attrTag);
    }

    @JsonIgnore
    public boolean isAttrTagDirty() {
        return this.contains(FIELD_ATTRTAG);
    }

    @JsonIgnore
    public String getAttrTag2() {
        Object objValue = this.get(FIELD_ATTRTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrtag2")
    public void setAttrTag2(String attrTag2) {
        this.set(FIELD_ATTRTAG2, attrTag2);
    }

    @JsonIgnore
    public boolean isAttrTag2Dirty() {
        return this.contains(FIELD_ATTRTAG2);
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
    public String getEAIElementAttrType() {
        Object objValue = this.get(FIELD_EAIELEMENTATTRTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaielementattrtype")
    public void setEAIElementAttrType(String eAIElementAttrType) {
        this.set(FIELD_EAIELEMENTATTRTYPE, eAIElementAttrType);
    }

    @JsonIgnore
    public boolean isEAIElementAttrTypeDirty() {
        return this.contains(FIELD_EAIELEMENTATTRTYPE);
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
    public String getPSSysEAIElementAttrId() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTATTRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementattrid")
    public void setPSSysEAIElementAttrId(String pSSysEAIElementAttrId) {
        this.set(FIELD_PSSYSEAIELEMENTATTRID, pSSysEAIElementAttrId);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementAttrIdDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTATTRID);
    }

    @JsonIgnore
    public String getPSSysEAIElementAttrName() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTATTRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementattrname")
    public void setPSSysEAIElementAttrName(String pSSysEAIElementAttrName) {
        this.set(FIELD_PSSYSEAIELEMENTATTRNAME, pSSysEAIElementAttrName);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementAttrNameDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTATTRNAME);
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
        return this.getPSSysEAIElementAttrId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysEAIElementAttrId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSEAIELEMENTATTR";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysEAIElementAttr item = (PSSysEAIElementAttr)MAPPER.readValue(new File(strJsonFilePath), PSSysEAIElementAttr.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysEAIElementAttr) {
            PSSysEAIElementAttr pSSysEAIElementAttr = (PSSysEAIElementAttr)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysEAIElementAttr) {
            PSSysEAIElementAttr pSSysEAIElementAttr = (PSSysEAIElementAttr)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

