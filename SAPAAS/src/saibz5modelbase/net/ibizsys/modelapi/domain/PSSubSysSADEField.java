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

public class PSSubSysSADEField
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_ARRAYFLAG = "arrayflag";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_EXAMPLEVALUE = "examplevalue";
    public static final String FIELD_FIELDTAG = "fieldtag";
    public static final String FIELD_FIELDTAG2 = "fieldtag2";
    public static final String FIELD_FIELDTYPE = "fieldtype";
    public static final String FIELD_LENGTH = "length";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORFIELD = "majorfield";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PKEY = "pkey";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDATATYPEID = "psdatatypeid";
    public static final String FIELD_PSDATATYPENAME = "psdatatypename";
    public static final String FIELD_PSSUBSYSSADEFIELDID = "pssubsyssadefieldid";
    public static final String FIELD_PSSUBSYSSADEFIELDNAME = "pssubsyssadefieldname";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_REFPSSUBSYSSADEID = "refpssubsyssadeid";
    public static final String FIELD_REFPSSUBSYSSADENAME = "refpssubsyssadename";
    public static final String FIELD_STDDATATYPE = "stddatatype";
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
    public Integer getArrayFlag() {
        Object objValue = this.get(FIELD_ARRAYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="arrayflag")
    public void setArrayFlag(Integer arrayFlag) {
        this.set(FIELD_ARRAYFLAG, arrayFlag);
    }

    @JsonIgnore
    public boolean isArrayFlagDirty() {
        return this.contains(FIELD_ARRAYFLAG);
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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
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
    public String getExampleValue() {
        Object objValue = this.get(FIELD_EXAMPLEVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="examplevalue")
    public void setExampleValue(String exampleValue) {
        this.set(FIELD_EXAMPLEVALUE, exampleValue);
    }

    @JsonIgnore
    public boolean isExampleValueDirty() {
        return this.contains(FIELD_EXAMPLEVALUE);
    }

    @JsonIgnore
    public String getFieldTag() {
        Object objValue = this.get(FIELD_FIELDTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldtag")
    public void setFieldTag(String fieldTag) {
        this.set(FIELD_FIELDTAG, fieldTag);
    }

    @JsonIgnore
    public boolean isFieldTagDirty() {
        return this.contains(FIELD_FIELDTAG);
    }

    @JsonIgnore
    public String getFieldTag2() {
        Object objValue = this.get(FIELD_FIELDTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldtag2")
    public void setFieldTag2(String fieldTag2) {
        this.set(FIELD_FIELDTAG2, fieldTag2);
    }

    @JsonIgnore
    public boolean isFieldTag2Dirty() {
        return this.contains(FIELD_FIELDTAG2);
    }

    @JsonIgnore
    public String getFieldType() {
        Object objValue = this.get(FIELD_FIELDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldtype")
    public void setFieldType(String fieldType) {
        this.set(FIELD_FIELDTYPE, fieldType);
    }

    @JsonIgnore
    public boolean isFieldTypeDirty() {
        return this.contains(FIELD_FIELDTYPE);
    }

    @JsonIgnore
    public Integer getLength() {
        Object objValue = this.get(FIELD_LENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="length")
    public void setLength(Integer length) {
        this.set(FIELD_LENGTH, length);
    }

    @JsonIgnore
    public boolean isLengthDirty() {
        return this.contains(FIELD_LENGTH);
    }

    @JsonIgnore
    public String getLogicName() {
        Object objValue = this.get(FIELD_LOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicname")
    public void setLogicName(String logicName) {
        this.set(FIELD_LOGICNAME, logicName);
    }

    @JsonIgnore
    public boolean isLogicNameDirty() {
        return this.contains(FIELD_LOGICNAME);
    }

    @JsonIgnore
    public Integer getMajorField() {
        Object objValue = this.get(FIELD_MAJORFIELD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="majorfield")
    public void setMajorField(Integer majorField) {
        this.set(FIELD_MAJORFIELD, majorField);
    }

    @JsonIgnore
    public boolean isMajorFieldDirty() {
        return this.contains(FIELD_MAJORFIELD);
    }

    @JsonIgnore
    public String getMaxValue() {
        Object objValue = this.get(FIELD_MAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maxvalue")
    public void setMaxValue(String maxValue) {
        this.set(FIELD_MAXVALUE, maxValue);
    }

    @JsonIgnore
    public boolean isMaxValueDirty() {
        return this.contains(FIELD_MAXVALUE);
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
    public Integer getMinStrLength() {
        Object objValue = this.get(FIELD_MINSTRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minstrlength")
    public void setMinStrLength(Integer minStrLength) {
        this.set(FIELD_MINSTRLENGTH, minStrLength);
    }

    @JsonIgnore
    public boolean isMinStrLengthDirty() {
        return this.contains(FIELD_MINSTRLENGTH);
    }

    @JsonIgnore
    public String getMinValue() {
        Object objValue = this.get(FIELD_MINVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minvalue")
    public void setMinValue(String minValue) {
        this.set(FIELD_MINVALUE, minValue);
    }

    @JsonIgnore
    public boolean isMinValueDirty() {
        return this.contains(FIELD_MINVALUE);
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
    public Integer getPKey() {
        Object objValue = this.get(FIELD_PKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pkey")
    public void setPKey(Integer pKey) {
        this.set(FIELD_PKEY, pKey);
    }

    @JsonIgnore
    public boolean isPKeyDirty() {
        return this.contains(FIELD_PKEY);
    }

    @JsonIgnore
    public Integer getPrecision2() {
        Object objValue = this.get(FIELD_PRECISION2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="precision2")
    public void setPrecision2(Integer precision2) {
        this.set(FIELD_PRECISION2, precision2);
    }

    @JsonIgnore
    public boolean isPrecision2Dirty() {
        return this.contains(FIELD_PRECISION2);
    }

    @JsonIgnore
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
    }

    @JsonIgnore
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
    }

    @JsonIgnore
    public String getPSDataTypeId() {
        Object objValue = this.get(FIELD_PSDATATYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdatatypeid")
    public void setPSDataTypeId(String pSDataTypeId) {
        this.set(FIELD_PSDATATYPEID, pSDataTypeId);
    }

    @JsonIgnore
    public boolean isPSDataTypeIdDirty() {
        return this.contains(FIELD_PSDATATYPEID);
    }

    @JsonIgnore
    public String getPSDataTypeName() {
        Object objValue = this.get(FIELD_PSDATATYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdatatypename")
    public void setPSDataTypeName(String pSDataTypeName) {
        this.set(FIELD_PSDATATYPENAME, pSDataTypeName);
    }

    @JsonIgnore
    public boolean isPSDataTypeNameDirty() {
        return this.contains(FIELD_PSDATATYPENAME);
    }

    @JsonIgnore
    public String getPSSubSysSADEFieldId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEFIELDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadefieldid")
    public void setPSSubSysSADEFieldId(String pSSubSysSADEFieldId) {
        this.set(FIELD_PSSUBSYSSADEFIELDID, pSSubSysSADEFieldId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEFieldIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEFIELDID);
    }

    @JsonIgnore
    public String getPSSubSysSADEFieldName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadefieldname")
    public void setPSSubSysSADEFieldName(String pSSubSysSADEFieldName) {
        this.set(FIELD_PSSUBSYSSADEFIELDNAME, pSSubSysSADEFieldName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEFieldNameDirty() {
        return this.contains(FIELD_PSSUBSYSSADEFIELDNAME);
    }

    @JsonIgnore
    public String getPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadeid")
    public void setPSSubSysSADEId(String pSSubSysSADEId) {
        this.set(FIELD_PSSUBSYSSADEID, pSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadename")
    public void setPSSubSysSADEName(String pSSubSysSADEName) {
        this.set(FIELD_PSSUBSYSSADENAME, pSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADENameDirty() {
        return this.contains(FIELD_PSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
    }

    @JsonIgnore
    public String getRefPSSubSysSADEId() {
        Object objValue = this.get(FIELD_REFPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssubsyssadeid")
    public void setRefPSSubSysSADEId(String refPSSubSysSADEId) {
        this.set(FIELD_REFPSSUBSYSSADEID, refPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isRefPSSubSysSADEIdDirty() {
        return this.contains(FIELD_REFPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getRefPSSubSysSADEName() {
        Object objValue = this.get(FIELD_REFPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssubsyssadename")
    public void setRefPSSubSysSADEName(String refPSSubSysSADEName) {
        this.set(FIELD_REFPSSUBSYSSADENAME, refPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isRefPSSubSysSADENameDirty() {
        return this.contains(FIELD_REFPSSUBSYSSADENAME);
    }

    @JsonIgnore
    public Integer getStdDataType() {
        Object objValue = this.get(FIELD_STDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stddatatype")
    public void setStdDataType(Integer stdDataType) {
        this.set(FIELD_STDDATATYPE, stdDataType);
    }

    @JsonIgnore
    public boolean isStdDataTypeDirty() {
        return this.contains(FIELD_STDDATATYPE);
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
        return this.getPSSubSysSADEFieldId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSubSysSADEFieldId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSUBSYSSADEFIELD";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSubSysSADEField item = (PSSubSysSADEField)MAPPER.readValue(new File(strJsonFilePath), PSSubSysSADEField.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSubSysSADEField) {
            PSSubSysSADEField pSSubSysSADEField = (PSSubSysSADEField)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSubSysSADEField) {
            PSSubSysSADEField pSSubSysSADEField = (PSSubSysSADEField)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

