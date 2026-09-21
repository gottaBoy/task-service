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

public class PSDEFGroupDetail
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_DETAILPARAM = "detailparam";
    public static final String FIELD_DETAILPARAM2 = "detailparam2";
    public static final String FIELD_DEFAULTVALUETYPE = "dvt";
    public static final String FIELD_ENABLEUSERINPUT = "enableuserinput";
    public static final String FIELD_JSONFORMAT = "jsonformat";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_MODIFYUSERINPUT = "modifyuserinput";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFGROUPDETAILID = "psdefgroupdetailid";
    public static final String FIELD_PSDEFGROUPDETAILNAME = "psdefgroupdetailname";
    public static final String FIELD_PSDEFGROUPID = "psdefgroupid";
    public static final String FIELD_PSDEFGROUPNAME = "psdefgroupname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_SEARCHMODES = "searchmodes";
    public static final String FIELD_STRLENGTH = "strlength";
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
    public String getDetailParam() {
        Object objValue = this.get(FIELD_DETAILPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailparam")
    public void setDetailParam(String detailParam) {
        this.set(FIELD_DETAILPARAM, detailParam);
    }

    @JsonIgnore
    public boolean isDetailParamDirty() {
        return this.contains(FIELD_DETAILPARAM);
    }

    @JsonIgnore
    public String getDetailParam2() {
        Object objValue = this.get(FIELD_DETAILPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailparam2")
    public void setDetailParam2(String detailParam2) {
        this.set(FIELD_DETAILPARAM2, detailParam2);
    }

    @JsonIgnore
    public boolean isDetailParam2Dirty() {
        return this.contains(FIELD_DETAILPARAM2);
    }

    @JsonIgnore
    public String getDefaultValueType() {
        Object objValue = this.get(FIELD_DEFAULTVALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvt")
    public void setDefaultValueType(String defaultValueType) {
        this.set(FIELD_DEFAULTVALUETYPE, defaultValueType);
    }

    @JsonIgnore
    public boolean isDefaultValueTypeDirty() {
        return this.contains(FIELD_DEFAULTVALUETYPE);
    }

    @JsonIgnore
    public Integer getEnableUserInput() {
        Object objValue = this.get(FIELD_ENABLEUSERINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableuserinput")
    public void setEnableUserInput(Integer enableUserInput) {
        this.set(FIELD_ENABLEUSERINPUT, enableUserInput);
    }

    @JsonIgnore
    public boolean isEnableUserInputDirty() {
        return this.contains(FIELD_ENABLEUSERINPUT);
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
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public Integer getModifyUserInput() {
        Object objValue = this.get(FIELD_MODIFYUSERINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modifyuserinput")
    public void setModifyUserInput(Integer modifyUserInput) {
        this.set(FIELD_MODIFYUSERINPUT, modifyUserInput);
    }

    @JsonIgnore
    public boolean isModifyUserInputDirty() {
        return this.contains(FIELD_MODIFYUSERINPUT);
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
    public String getPSDEFGroupDetailId() {
        Object objValue = this.get(FIELD_PSDEFGROUPDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupdetailid")
    public void setPSDEFGroupDetailId(String pSDEFGroupDetailId) {
        this.set(FIELD_PSDEFGROUPDETAILID, pSDEFGroupDetailId);
    }

    @JsonIgnore
    public boolean isPSDEFGroupDetailIdDirty() {
        return this.contains(FIELD_PSDEFGROUPDETAILID);
    }

    @JsonIgnore
    public String getPSDEFGroupDetailName() {
        Object objValue = this.get(FIELD_PSDEFGROUPDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupdetailname")
    public void setPSDEFGroupDetailName(String pSDEFGroupDetailName) {
        this.set(FIELD_PSDEFGROUPDETAILNAME, pSDEFGroupDetailName);
    }

    @JsonIgnore
    public boolean isPSDEFGroupDetailNameDirty() {
        return this.contains(FIELD_PSDEFGROUPDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEFGroupId() {
        Object objValue = this.get(FIELD_PSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupid")
    public void setPSDEFGroupId(String pSDEFGroupId) {
        this.set(FIELD_PSDEFGROUPID, pSDEFGroupId);
    }

    @JsonIgnore
    public boolean isPSDEFGroupIdDirty() {
        return this.contains(FIELD_PSDEFGROUPID);
    }

    @JsonIgnore
    public String getPSDEFGroupName() {
        Object objValue = this.get(FIELD_PSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupname")
    public void setPSDEFGroupName(String pSDEFGroupName) {
        this.set(FIELD_PSDEFGROUPNAME, pSDEFGroupName);
    }

    @JsonIgnore
    public boolean isPSDEFGroupNameDirty() {
        return this.contains(FIELD_PSDEFGROUPNAME);
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
    public String getSearchModes() {
        Object objValue = this.get(FIELD_SEARCHMODES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchmodes")
    public void setSearchModes(String searchModes) {
        this.set(FIELD_SEARCHMODES, searchModes);
    }

    @JsonIgnore
    public boolean isSearchModesDirty() {
        return this.contains(FIELD_SEARCHMODES);
    }

    @JsonIgnore
    public Integer getStrLength() {
        Object objValue = this.get(FIELD_STRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="strlength")
    public void setStrLength(Integer strLength) {
        this.set(FIELD_STRLENGTH, strLength);
    }

    @JsonIgnore
    public boolean isStrLengthDirty() {
        return this.contains(FIELD_STRLENGTH);
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
        return this.getPSDEFGroupDetailId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFGroupDetailId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEFGROUPDETAIL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFGroupDetail item = (PSDEFGroupDetail)MAPPER.readValue(new File(strJsonFilePath), PSDEFGroupDetail.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFGroupDetail) {
            PSDEFGroupDetail pSDEFGroupDetail = (PSDEFGroupDetail)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFGroupDetail) {
            PSDEFGroupDetail pSDEFGroupDetail = (PSDEFGroupDetail)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

