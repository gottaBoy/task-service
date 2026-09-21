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

public class PSSysSearchFieldDTO
extends PSModelDTOBase {
    public static final String FIELD_ANALYZER = "analyzer";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATEFORMAT = "dateformat";
    public static final String FIELD_FIELDDATAFLAG = "fielddataflag";
    public static final String FIELD_FIELDTAG = "fieldtag";
    public static final String FIELD_FIELDTAG2 = "fieldtag2";
    public static final String FIELD_FIELDTYPE = "fieldtype";
    public static final String FIELD_IGNOREFIELDS = "ignorefields";
    public static final String FIELD_INCINPARENTFLAG = "incinparentflag";
    public static final String FIELD_INDEXFLAG = "indexflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PATTERN = "pattern";
    public static final String FIELD_PKEY = "pkey";
    public static final String FIELD_PSSYSSEARCHDOCID = "pssyssearchdocid";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "pssyssearchdocname";
    public static final String FIELD_PSSYSSEARCHFIELDID = "pssyssearchfieldid";
    public static final String FIELD_PSSYSSEARCHFIELDNAME = "pssyssearchfieldname";
    public static final String FIELD_SEARCHANALYZER = "searchanalyzer";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    public static final String FIELD_STOREFLAG = "storeflag";
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
    public String getAnalyzer() {
        Object objValue = this.get(FIELD_ANALYZER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="analyzer")
    public void setAnalyzer(String analyzer) {
        this.set(FIELD_ANALYZER, analyzer);
    }

    @JsonIgnore
    public boolean isAnalyzerDirty() {
        return this.contains(FIELD_ANALYZER);
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
    public String getDateFormat() {
        Object objValue = this.get(FIELD_DATEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dateformat")
    public void setDateFormat(String dateFormat) {
        this.set(FIELD_DATEFORMAT, dateFormat);
    }

    @JsonIgnore
    public boolean isDateFormatDirty() {
        return this.contains(FIELD_DATEFORMAT);
    }

    @JsonIgnore
    public Integer getFieldDataFlag() {
        Object objValue = this.get(FIELD_FIELDDATAFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fielddataflag")
    public void setFieldDataFlag(Integer fieldDataFlag) {
        this.set(FIELD_FIELDDATAFLAG, fieldDataFlag);
    }

    @JsonIgnore
    public boolean isFieldDataFlagDirty() {
        return this.contains(FIELD_FIELDDATAFLAG);
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
    public String getIgnoreFields() {
        Object objValue = this.get(FIELD_IGNOREFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ignorefields")
    public void setIgnoreFields(String ignoreFields) {
        this.set(FIELD_IGNOREFIELDS, ignoreFields);
    }

    @JsonIgnore
    public boolean isIgnoreFieldsDirty() {
        return this.contains(FIELD_IGNOREFIELDS);
    }

    @JsonIgnore
    public Integer getIncInParentFlag() {
        Object objValue = this.get(FIELD_INCINPARENTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incinparentflag")
    public void setIncInParentFlag(Integer incInParentFlag) {
        this.set(FIELD_INCINPARENTFLAG, incInParentFlag);
    }

    @JsonIgnore
    public boolean isIncInParentFlagDirty() {
        return this.contains(FIELD_INCINPARENTFLAG);
    }

    @JsonIgnore
    public Integer getIndexFlag() {
        Object objValue = this.get(FIELD_INDEXFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="indexflag")
    public void setIndexFlag(Integer indexFlag) {
        this.set(FIELD_INDEXFLAG, indexFlag);
    }

    @JsonIgnore
    public boolean isIndexFlagDirty() {
        return this.contains(FIELD_INDEXFLAG);
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
    public String getPattern() {
        Object objValue = this.get(FIELD_PATTERN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pattern")
    public void setPattern(String pattern) {
        this.set(FIELD_PATTERN, pattern);
    }

    @JsonIgnore
    public boolean isPatternDirty() {
        return this.contains(FIELD_PATTERN);
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
    public String getPSSysSearchDocId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHDOCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchdocid")
    public void setPSSysSearchDocId(String pSSysSearchDocId) {
        this.set(FIELD_PSSYSSEARCHDOCID, pSSysSearchDocId);
    }

    @JsonIgnore
    public boolean isPSSysSearchDocIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHDOCID);
    }

    @JsonIgnore
    public String getPSSysSearchDocName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHDOCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchdocname")
    public void setPSSysSearchDocName(String pSSysSearchDocName) {
        this.set(FIELD_PSSYSSEARCHDOCNAME, pSSysSearchDocName);
    }

    @JsonIgnore
    public boolean isPSSysSearchDocNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHDOCNAME);
    }

    @JsonIgnore
    public String getPSSysSearchFieldId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHFIELDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchfieldid")
    public void setPSSysSearchFieldId(String pSSysSearchFieldId) {
        this.set(FIELD_PSSYSSEARCHFIELDID, pSSysSearchFieldId);
    }

    @JsonIgnore
    public boolean isPSSysSearchFieldIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHFIELDID);
    }

    @JsonIgnore
    public String getPSSysSearchFieldName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchfieldname")
    public void setPSSysSearchFieldName(String pSSysSearchFieldName) {
        this.set(FIELD_PSSYSSEARCHFIELDNAME, pSSysSearchFieldName);
    }

    @JsonIgnore
    public boolean isPSSysSearchFieldNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHFIELDNAME);
    }

    @JsonIgnore
    public String getSearchAnalyzer() {
        Object objValue = this.get(FIELD_SEARCHANALYZER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchanalyzer")
    public void setSearchAnalyzer(String searchAnalyzer) {
        this.set(FIELD_SEARCHANALYZER, searchAnalyzer);
    }

    @JsonIgnore
    public boolean isSearchAnalyzerDirty() {
        return this.contains(FIELD_SEARCHANALYZER);
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
    public Integer getStoreFlag() {
        Object objValue = this.get(FIELD_STOREFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="storeflag")
    public void setStoreFlag(Integer storeFlag) {
        this.set(FIELD_STOREFLAG, storeFlag);
    }

    @JsonIgnore
    public boolean isStoreFlagDirty() {
        return this.contains(FIELD_STOREFLAG);
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
        return this.getPSSysSearchFieldId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysSearchFieldId(strValue);
    }
}

