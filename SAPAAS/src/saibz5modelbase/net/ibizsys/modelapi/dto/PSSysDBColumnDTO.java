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

public class PSSysDBColumnDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    public static final String FIELD_COLDESC = "coldesc";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATESQL = "createsql";
    public static final String FIELD_DATATYPE = "datatype";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_DROPSQL = "dropsql";
    public static final String FIELD_FKEY = "fkey";
    public static final String FIELD_IDENTITYMODE = "identitymode";
    public static final String FIELD_LENGTH = "length";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PKEY = "pkey";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSSYSDBCOLUMNID = "pssysdbcolumnid";
    public static final String FIELD_PSSYSDBCOLUMNNAME = "pssysdbcolumnname";
    public static final String FIELD_PSSYSDBSCHEMEID = "pssysdbschemeid";
    public static final String FIELD_PSSYSDBTABLEID = "pssysdbtableid";
    public static final String FIELD_PSSYSDBTABLENAME = "pssysdbtablename";
    public static final String FIELD_REFPSSYSDBCOLUMNID = "refpssysdbcolumnid";
    public static final String FIELD_REFPSSYSDBCOLUMNNAME = "refpssysdbcolumnname";
    public static final String FIELD_REFPSSYSDBTABLEID = "refpssysdbtableid";
    public static final String FIELD_REFPSSYSDBTABLENAME = "refpssysdbtablename";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    public static final String FIELD_UNSIGNEDMODE = "unsignedmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getColDesc() {
        Object objValue = this.get(FIELD_COLDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="coldesc")
    public void setColDesc(String colDesc) {
        this.set(FIELD_COLDESC, colDesc);
    }

    @JsonIgnore
    public boolean isColDescDirty() {
        return this.contains(FIELD_COLDESC);
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
    public String getCreateSql() {
        Object objValue = this.get(FIELD_CREATESQL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql")
    public void setCreateSql(String createSql) {
        this.set(FIELD_CREATESQL, createSql);
    }

    @JsonIgnore
    public boolean isCreateSqlDirty() {
        return this.contains(FIELD_CREATESQL);
    }

    @JsonIgnore
    public String getDataType() {
        Object objValue = this.get(FIELD_DATATYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatype")
    public void setDataType(String dataType) {
        this.set(FIELD_DATATYPE, dataType);
    }

    @JsonIgnore
    public boolean isDataTypeDirty() {
        return this.contains(FIELD_DATATYPE);
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
    public String getDropSql() {
        Object objValue = this.get(FIELD_DROPSQL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dropsql")
    public void setDropSql(String dropSql) {
        this.set(FIELD_DROPSQL, dropSql);
    }

    @JsonIgnore
    public boolean isDropSqlDirty() {
        return this.contains(FIELD_DROPSQL);
    }

    @JsonIgnore
    public Integer getFKey() {
        Object objValue = this.get(FIELD_FKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fkey")
    public void setFKey(Integer fKey) {
        this.set(FIELD_FKEY, fKey);
    }

    @JsonIgnore
    public boolean isFKeyDirty() {
        return this.contains(FIELD_FKEY);
    }

    @JsonIgnore
    public Integer getIdentityMode() {
        Object objValue = this.get(FIELD_IDENTITYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="identitymode")
    public void setIdentityMode(Integer identityMode) {
        this.set(FIELD_IDENTITYMODE, identityMode);
    }

    @JsonIgnore
    public boolean isIdentityModeDirty() {
        return this.contains(FIELD_IDENTITYMODE);
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
    public String getPSSysDBColumnId() {
        Object objValue = this.get(FIELD_PSSYSDBCOLUMNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbcolumnid")
    public void setPSSysDBColumnId(String pSSysDBColumnId) {
        this.set(FIELD_PSSYSDBCOLUMNID, pSSysDBColumnId);
    }

    @JsonIgnore
    public boolean isPSSysDBColumnIdDirty() {
        return this.contains(FIELD_PSSYSDBCOLUMNID);
    }

    @JsonIgnore
    public String getPSSysDBColumnName() {
        Object objValue = this.get(FIELD_PSSYSDBCOLUMNNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbcolumnname")
    public void setPSSysDBColumnName(String pSSysDBColumnName) {
        this.set(FIELD_PSSYSDBCOLUMNNAME, pSSysDBColumnName);
    }

    @JsonIgnore
    public boolean isPSSysDBColumnNameDirty() {
        return this.contains(FIELD_PSSYSDBCOLUMNNAME);
    }

    @JsonIgnore
    public String getPSSysDBSchemeId() {
        Object objValue = this.get(FIELD_PSSYSDBSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbschemeid")
    public void setPSSysDBSchemeId(String pSSysDBSchemeId) {
        this.set(FIELD_PSSYSDBSCHEMEID, pSSysDBSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysDBSchemeIdDirty() {
        return this.contains(FIELD_PSSYSDBSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysDBTableId() {
        Object objValue = this.get(FIELD_PSSYSDBTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbtableid")
    public void setPSSysDBTableId(String pSSysDBTableId) {
        this.set(FIELD_PSSYSDBTABLEID, pSSysDBTableId);
    }

    @JsonIgnore
    public boolean isPSSysDBTableIdDirty() {
        return this.contains(FIELD_PSSYSDBTABLEID);
    }

    @JsonIgnore
    public String getPSSysDBTableName() {
        Object objValue = this.get(FIELD_PSSYSDBTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbtablename")
    public void setPSSysDBTableName(String pSSysDBTableName) {
        this.set(FIELD_PSSYSDBTABLENAME, pSSysDBTableName);
    }

    @JsonIgnore
    public boolean isPSSysDBTableNameDirty() {
        return this.contains(FIELD_PSSYSDBTABLENAME);
    }

    @JsonIgnore
    public String getRefPSSysDBColumnId() {
        Object objValue = this.get(FIELD_REFPSSYSDBCOLUMNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdbcolumnid")
    public void setRefPSSysDBColumnId(String refPSSysDBColumnId) {
        this.set(FIELD_REFPSSYSDBCOLUMNID, refPSSysDBColumnId);
    }

    @JsonIgnore
    public boolean isRefPSSysDBColumnIdDirty() {
        return this.contains(FIELD_REFPSSYSDBCOLUMNID);
    }

    @JsonIgnore
    public String getRefPSSysDBColumnName() {
        Object objValue = this.get(FIELD_REFPSSYSDBCOLUMNNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdbcolumnname")
    public void setRefPSSysDBColumnName(String refPSSysDBColumnName) {
        this.set(FIELD_REFPSSYSDBCOLUMNNAME, refPSSysDBColumnName);
    }

    @JsonIgnore
    public boolean isRefPSSysDBColumnNameDirty() {
        return this.contains(FIELD_REFPSSYSDBCOLUMNNAME);
    }

    @JsonIgnore
    public String getRefPSSysDBTableId() {
        Object objValue = this.get(FIELD_REFPSSYSDBTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdbtableid")
    public void setRefPSSysDBTableId(String refPSSysDBTableId) {
        this.set(FIELD_REFPSSYSDBTABLEID, refPSSysDBTableId);
    }

    @JsonIgnore
    public boolean isRefPSSysDBTableIdDirty() {
        return this.contains(FIELD_REFPSSYSDBTABLEID);
    }

    @JsonIgnore
    public String getRefPSSysDBTableName() {
        Object objValue = this.get(FIELD_REFPSSYSDBTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdbtablename")
    public void setRefPSSysDBTableName(String refPSSysDBTableName) {
        this.set(FIELD_REFPSSYSDBTABLENAME, refPSSysDBTableName);
    }

    @JsonIgnore
    public boolean isRefPSSysDBTableNameDirty() {
        return this.contains(FIELD_REFPSSYSDBTABLENAME);
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
    public Integer getUnsignedMode() {
        Object objValue = this.get(FIELD_UNSIGNEDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="unsignedmode")
    public void setUnsignedMode(Integer unsignedMode) {
        this.set(FIELD_UNSIGNEDMODE, unsignedMode);
    }

    @JsonIgnore
    public boolean isUnsignedModeDirty() {
        return this.contains(FIELD_UNSIGNEDMODE);
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
        return this.getPSSysDBColumnId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysDBColumnId(strValue);
    }
}

