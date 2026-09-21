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

public class PSDEFDTColDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDATATYPE = "customdatatype";
    public static final String FIELD_DATATYPE = "datatype";
    public static final String FIELD_DBTYPE = "dbtype";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_FORMULAFIELDS = "formulafields";
    public static final String FIELD_FORMULAFORMAT = "formulaformat";
    public static final String FIELD_LENGTH = "length";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NULLVALORDER = "nullvalorder";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSDEFDTCOLID = "psdefdtcolid";
    public static final String FIELD_PSDEFDTCOLNAME = "psdefdtcolname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_TABLENAME = "tablename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALUEFUNC2FIELDS = "valuefunc2fields";
    public static final String FIELD_VALUEFUNC2FORMAT = "valuefunc2format";
    public static final String FIELD_VALUEFUNCFIELDS = "valuefuncfields";
    public static final String FIELD_VALUEFUNCFORMAT = "valuefuncformat";

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
    public Integer getCustomDataType() {
        Object objValue = this.get(FIELD_CUSTOMDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="customdatatype")
    public void setCustomDataType(Integer customDataType) {
        this.set(FIELD_CUSTOMDATATYPE, customDataType);
    }

    @JsonIgnore
    public boolean isCustomDataTypeDirty() {
        return this.contains(FIELD_CUSTOMDATATYPE);
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
    public String getDBType() {
        Object objValue = this.get(FIELD_DBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtype")
    public void setDBType(String dBType) {
        this.set(FIELD_DBTYPE, dBType);
    }

    @JsonIgnore
    public boolean isDBTypeDirty() {
        return this.contains(FIELD_DBTYPE);
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
    public String getFormulaFields() {
        Object objValue = this.get(FIELD_FORMULAFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formulafields")
    public void setFormulaFields(String formulaFields) {
        this.set(FIELD_FORMULAFIELDS, formulaFields);
    }

    @JsonIgnore
    public boolean isFormulaFieldsDirty() {
        return this.contains(FIELD_FORMULAFIELDS);
    }

    @JsonIgnore
    public String getFormulaFormat() {
        Object objValue = this.get(FIELD_FORMULAFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formulaformat")
    public void setFormulaFormat(String formulaFormat) {
        this.set(FIELD_FORMULAFORMAT, formulaFormat);
    }

    @JsonIgnore
    public boolean isFormulaFormatDirty() {
        return this.contains(FIELD_FORMULAFORMAT);
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
    public String getNullValOrder() {
        Object objValue = this.get(FIELD_NULLVALORDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nullvalorder")
    public void setNullValOrder(String nullValOrder) {
        this.set(FIELD_NULLVALORDER, nullValOrder);
    }

    @JsonIgnore
    public boolean isNullValOrderDirty() {
        return this.contains(FIELD_NULLVALORDER);
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
    public String getPSDEFDTColId() {
        Object objValue = this.get(FIELD_PSDEFDTCOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefdtcolid")
    public void setPSDEFDTColId(String pSDEFDTColId) {
        this.set(FIELD_PSDEFDTCOLID, pSDEFDTColId);
    }

    @JsonIgnore
    public boolean isPSDEFDTColIdDirty() {
        return this.contains(FIELD_PSDEFDTCOLID);
    }

    @JsonIgnore
    public String getPSDEFDTColName() {
        Object objValue = this.get(FIELD_PSDEFDTCOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefdtcolname")
    public void setPSDEFDTColName(String pSDEFDTColName) {
        this.set(FIELD_PSDEFDTCOLNAME, pSDEFDTColName);
    }

    @JsonIgnore
    public boolean isPSDEFDTColNameDirty() {
        return this.contains(FIELD_PSDEFDTCOLNAME);
    }

    @JsonIgnore
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
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
    public String getPSDEName() {
        Object objValue = this.get(FIELD_PSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdename")
    public void setPSDEName(String pSDEName) {
        this.set(FIELD_PSDENAME, pSDEName);
    }

    @JsonIgnore
    public boolean isPSDENameDirty() {
        return this.contains(FIELD_PSDENAME);
    }

    @JsonIgnore
    public String getTableName() {
        Object objValue = this.get(FIELD_TABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablename")
    public void setTableName(String tableName) {
        this.set(FIELD_TABLENAME, tableName);
    }

    @JsonIgnore
    public boolean isTableNameDirty() {
        return this.contains(FIELD_TABLENAME);
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
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
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
    public String getValueFunc2Fields() {
        Object objValue = this.get(FIELD_VALUEFUNC2FIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuefunc2fields")
    public void setValueFunc2Fields(String valueFunc2Fields) {
        this.set(FIELD_VALUEFUNC2FIELDS, valueFunc2Fields);
    }

    @JsonIgnore
    public boolean isValueFunc2FieldsDirty() {
        return this.contains(FIELD_VALUEFUNC2FIELDS);
    }

    @JsonIgnore
    public String getValueFunc2Format() {
        Object objValue = this.get(FIELD_VALUEFUNC2FORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuefunc2format")
    public void setValueFunc2Format(String valueFunc2Format) {
        this.set(FIELD_VALUEFUNC2FORMAT, valueFunc2Format);
    }

    @JsonIgnore
    public boolean isValueFunc2FormatDirty() {
        return this.contains(FIELD_VALUEFUNC2FORMAT);
    }

    @JsonIgnore
    public String getValueFuncFields() {
        Object objValue = this.get(FIELD_VALUEFUNCFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuefuncfields")
    public void setValueFuncFields(String valueFuncFields) {
        this.set(FIELD_VALUEFUNCFIELDS, valueFuncFields);
    }

    @JsonIgnore
    public boolean isValueFuncFieldsDirty() {
        return this.contains(FIELD_VALUEFUNCFIELDS);
    }

    @JsonIgnore
    public String getValueFuncFormat() {
        Object objValue = this.get(FIELD_VALUEFUNCFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuefuncformat")
    public void setValueFuncFormat(String valueFuncFormat) {
        this.set(FIELD_VALUEFUNCFORMAT, valueFuncFormat);
    }

    @JsonIgnore
    public boolean isValueFuncFormatDirty() {
        return this.contains(FIELD_VALUEFUNCFORMAT);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEFDTColId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEFDTColId(strValue);
    }
}

