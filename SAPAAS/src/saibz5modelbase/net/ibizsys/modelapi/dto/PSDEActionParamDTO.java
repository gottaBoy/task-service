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

public class PSDEActionParamDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_ARRAYFLAG = "arrayflag";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_JSONFORMAT = "jsonformat";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMDESC = "paramdesc";
    public static final String FIELD_PARAMTAG = "paramtag";
    public static final String FIELD_PARAMTAG2 = "paramtag2";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEACTIONPARAMID = "psdeactionparamid";
    public static final String FIELD_PSDEACTIONPARAMNAME = "psdeactionparamname";
    public static final String FIELD_PSDEFVALUERULEID = "psdefvalueruleid";
    public static final String FIELD_PSDEFVALUERULENAME = "psdefvaluerulename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_REFPSDEFGROUPID = "refpsdefgroupid";
    public static final String FIELD_REFPSDEFGROUPNAME = "refpsdefgroupname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSSYSDYNAMODELID = "refpssysdynamodelid";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "refpssysdynamodelname";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALUE = "value";
    public static final String FIELD_VALUEDESC = "valuedesc";
    public static final String FIELD_VALUETYPE = "valuetype";

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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getJsonFormat() {
        Object objValue = this.get(FIELD_JSONFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsonformat")
    public void setJsonFormat(String jsonFormat) {
        this.set(FIELD_JSONFORMAT, jsonFormat);
    }

    @JsonIgnore
    public boolean isJsonFormatDirty() {
        return this.contains(FIELD_JSONFORMAT);
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
    public String getParamDesc() {
        Object objValue = this.get(FIELD_PARAMDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramdesc")
    public void setParamDesc(String paramDesc) {
        this.set(FIELD_PARAMDESC, paramDesc);
    }

    @JsonIgnore
    public boolean isParamDescDirty() {
        return this.contains(FIELD_PARAMDESC);
    }

    @JsonIgnore
    public String getParamTag() {
        Object objValue = this.get(FIELD_PARAMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag")
    public void setParamTag(String paramTag) {
        this.set(FIELD_PARAMTAG, paramTag);
    }

    @JsonIgnore
    public boolean isParamTagDirty() {
        return this.contains(FIELD_PARAMTAG);
    }

    @JsonIgnore
    public String getParamTag2() {
        Object objValue = this.get(FIELD_PARAMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag2")
    public void setParamTag2(String paramTag2) {
        this.set(FIELD_PARAMTAG2, paramTag2);
    }

    @JsonIgnore
    public boolean isParamTag2Dirty() {
        return this.contains(FIELD_PARAMTAG2);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEActionParamId() {
        Object objValue = this.get(FIELD_PSDEACTIONPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionparamid")
    public void setPSDEActionParamId(String pSDEActionParamId) {
        this.set(FIELD_PSDEACTIONPARAMID, pSDEActionParamId);
    }

    @JsonIgnore
    public boolean isPSDEActionParamIdDirty() {
        return this.contains(FIELD_PSDEACTIONPARAMID);
    }

    @JsonIgnore
    public String getPSDEActionParamName() {
        Object objValue = this.get(FIELD_PSDEACTIONPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionparamname")
    public void setPSDEActionParamName(String pSDEActionParamName) {
        this.set(FIELD_PSDEACTIONPARAMNAME, pSDEActionParamName);
    }

    @JsonIgnore
    public boolean isPSDEActionParamNameDirty() {
        return this.contains(FIELD_PSDEACTIONPARAMNAME);
    }

    @JsonIgnore
    public String getPSDEFValueRuleId() {
        Object objValue = this.get(FIELD_PSDEFVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvalueruleid")
    public void setPSDEFValueRuleId(String pSDEFValueRuleId) {
        this.set(FIELD_PSDEFVALUERULEID, pSDEFValueRuleId);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleIdDirty() {
        return this.contains(FIELD_PSDEFVALUERULEID);
    }

    @JsonIgnore
    public String getPSDEFValueRuleName() {
        Object objValue = this.get(FIELD_PSDEFVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvaluerulename")
    public void setPSDEFValueRuleName(String pSDEFValueRuleName) {
        this.set(FIELD_PSDEFVALUERULENAME, pSDEFValueRuleName);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleNameDirty() {
        return this.contains(FIELD_PSDEFVALUERULENAME);
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
    public String getRefPSDEFGroupId() {
        Object objValue = this.get(FIELD_REFPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdefgroupid")
    public void setRefPSDEFGroupId(String refPSDEFGroupId) {
        this.set(FIELD_REFPSDEFGROUPID, refPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isRefPSDEFGroupIdDirty() {
        return this.contains(FIELD_REFPSDEFGROUPID);
    }

    @JsonIgnore
    public String getRefPSDEFGroupName() {
        Object objValue = this.get(FIELD_REFPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdefgroupname")
    public void setRefPSDEFGroupName(String refPSDEFGroupName) {
        this.set(FIELD_REFPSDEFGROUPNAME, refPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isRefPSDEFGroupNameDirty() {
        return this.contains(FIELD_REFPSDEFGROUPNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelId() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelid")
    public void setRefPSSysDynaModelId(String refPSSysDynaModelId) {
        this.set(FIELD_REFPSSYSDYNAMODELID, refPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelIdDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelName() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelname")
    public void setRefPSSysDynaModelName(String refPSSysDynaModelName) {
        this.set(FIELD_REFPSSYSDYNAMODELNAME, refPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelNameDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELNAME);
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
    public String getValue() {
        Object objValue = this.get(FIELD_VALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="value")
    public void setValue(String value) {
        this.set(FIELD_VALUE, value);
    }

    @JsonIgnore
    public boolean isValueDirty() {
        return this.contains(FIELD_VALUE);
    }

    @JsonIgnore
    public String getValueDesc() {
        Object objValue = this.get(FIELD_VALUEDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuedesc")
    public void setValueDesc(String valueDesc) {
        this.set(FIELD_VALUEDESC, valueDesc);
    }

    @JsonIgnore
    public boolean isValueDescDirty() {
        return this.contains(FIELD_VALUEDESC);
    }

    @JsonIgnore
    public String getValueType() {
        Object objValue = this.get(FIELD_VALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuetype")
    public void setValueType(String valueType) {
        this.set(FIELD_VALUETYPE, valueType);
    }

    @JsonIgnore
    public boolean isValueTypeDirty() {
        return this.contains(FIELD_VALUETYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEActionParamId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEActionParamId(strValue);
    }
}

