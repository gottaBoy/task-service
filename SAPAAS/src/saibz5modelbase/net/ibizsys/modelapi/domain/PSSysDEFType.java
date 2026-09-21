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

public class PSSysDEFType
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EDITORHEIGHT = "editorheight";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORWIDTH = "editorwidth";
    public static final String FIELD_FIELDS = "fields";
    public static final String FIELD_GRIDCOLALIGN = "gridcolalign";
    public static final String FIELD_GRIDCOLCLMODE = "gridcolclmode";
    public static final String FIELD_GRIDCOLWIDTH = "gridcolwidth";
    public static final String FIELD_JSFORMAT = "jsformat";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MBEDITORHEIGHT = "mbeditorheight";
    public static final String FIELD_MBEDITORTYPE = "mbeditortype";
    public static final String FIELD_MBEDITORWIDTH = "mbeditorwidth";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFTYPEID = "psdeftypeid";
    public static final String FIELD_PSDEFTYPENAME = "psdeftypename";
    public static final String FIELD_PSSYSDEFTYPEID = "pssysdeftypeid";
    public static final String FIELD_PSSYSDEFTYPENAME = "pssysdeftypename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUNITID = "pssysunitid";
    public static final String FIELD_PSSYSUNITNAME = "pssysunitname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_PYFORMAT = "pyformat";
    public static final String FIELD_SEARCHEDITORHEIGHT = "searcheditorheight";
    public static final String FIELD_SEARCHEDITORTYPE = "searcheditortype";
    public static final String FIELD_SEARCHEDITORWIDTH = "searcheditorwidth";
    public static final String FIELD_SEARCHMBEDITORHEIGHT = "searchmbeditorheight";
    public static final String FIELD_SEARCHMBEDITORTYPE = "searchmbeditortype";
    public static final String FIELD_SEARCHMBEDITORWIDTH = "searchmbeditorwidth";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    public static final String FIELD_STRLENGTH = "strlength";
    public static final String FIELD_TSFORMAT = "tsformat";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEFORMAT = "valueformat";

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
    public Integer getEditorHeight() {
        Object objValue = this.get(FIELD_EDITORHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="editorheight")
    public void setEditorHeight(Integer editorHeight) {
        this.set(FIELD_EDITORHEIGHT, editorHeight);
    }

    @JsonIgnore
    public boolean isEditorHeightDirty() {
        return this.contains(FIELD_EDITORHEIGHT);
    }

    @JsonIgnore
    public String getEditorType() {
        Object objValue = this.get(FIELD_EDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortype")
    public void setEditorType(String editorType) {
        this.set(FIELD_EDITORTYPE, editorType);
    }

    @JsonIgnore
    public boolean isEditorTypeDirty() {
        return this.contains(FIELD_EDITORTYPE);
    }

    @JsonIgnore
    public Integer getEditorWidth() {
        Object objValue = this.get(FIELD_EDITORWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="editorwidth")
    public void setEditorWidth(Integer editorWidth) {
        this.set(FIELD_EDITORWIDTH, editorWidth);
    }

    @JsonIgnore
    public boolean isEditorWidthDirty() {
        return this.contains(FIELD_EDITORWIDTH);
    }

    @JsonIgnore
    public String getFields() {
        Object objValue = this.get(FIELD_FIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fields")
    public void setFields(String fields) {
        this.set(FIELD_FIELDS, fields);
    }

    @JsonIgnore
    public boolean isFieldsDirty() {
        return this.contains(FIELD_FIELDS);
    }

    @JsonIgnore
    public String getGridColAlign() {
        Object objValue = this.get(FIELD_GRIDCOLALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridcolalign")
    public void setGridColAlign(String gridColAlign) {
        this.set(FIELD_GRIDCOLALIGN, gridColAlign);
    }

    @JsonIgnore
    public boolean isGridColAlignDirty() {
        return this.contains(FIELD_GRIDCOLALIGN);
    }

    @JsonIgnore
    public String getGridColCLMode() {
        Object objValue = this.get(FIELD_GRIDCOLCLMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridcolclmode")
    public void setGridColCLMode(String gridColCLMode) {
        this.set(FIELD_GRIDCOLCLMODE, gridColCLMode);
    }

    @JsonIgnore
    public boolean isGridColCLModeDirty() {
        return this.contains(FIELD_GRIDCOLCLMODE);
    }

    @JsonIgnore
    public Integer getGridColWidth() {
        Object objValue = this.get(FIELD_GRIDCOLWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridcolwidth")
    public void setGridColWidth(Integer gridColWidth) {
        this.set(FIELD_GRIDCOLWIDTH, gridColWidth);
    }

    @JsonIgnore
    public boolean isGridColWidthDirty() {
        return this.contains(FIELD_GRIDCOLWIDTH);
    }

    @JsonIgnore
    public String getJSFormat() {
        Object objValue = this.get(FIELD_JSFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsformat")
    public void setJSFormat(String jSFormat) {
        this.set(FIELD_JSFORMAT, jSFormat);
    }

    @JsonIgnore
    public boolean isJSFormatDirty() {
        return this.contains(FIELD_JSFORMAT);
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
    public Integer getMBEditorHeight() {
        Object objValue = this.get(FIELD_MBEDITORHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mbeditorheight")
    public void setMBEditorHeight(Integer mBEditorHeight) {
        this.set(FIELD_MBEDITORHEIGHT, mBEditorHeight);
    }

    @JsonIgnore
    public boolean isMBEditorHeightDirty() {
        return this.contains(FIELD_MBEDITORHEIGHT);
    }

    @JsonIgnore
    public String getMBEditorType() {
        Object objValue = this.get(FIELD_MBEDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mbeditortype")
    public void setMBEditorType(String mBEditorType) {
        this.set(FIELD_MBEDITORTYPE, mBEditorType);
    }

    @JsonIgnore
    public boolean isMBEditorTypeDirty() {
        return this.contains(FIELD_MBEDITORTYPE);
    }

    @JsonIgnore
    public Integer getMBEditorWidth() {
        Object objValue = this.get(FIELD_MBEDITORWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mbeditorwidth")
    public void setMBEditorWidth(Integer mBEditorWidth) {
        this.set(FIELD_MBEDITORWIDTH, mBEditorWidth);
    }

    @JsonIgnore
    public boolean isMBEditorWidthDirty() {
        return this.contains(FIELD_MBEDITORWIDTH);
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
    public String getPSDEFTypeId() {
        Object objValue = this.get(FIELD_PSDEFTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeftypeid")
    public void setPSDEFTypeId(String pSDEFTypeId) {
        this.set(FIELD_PSDEFTYPEID, pSDEFTypeId);
    }

    @JsonIgnore
    public boolean isPSDEFTypeIdDirty() {
        return this.contains(FIELD_PSDEFTYPEID);
    }

    @JsonIgnore
    public String getPSDEFTypeName() {
        Object objValue = this.get(FIELD_PSDEFTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeftypename")
    public void setPSDEFTypeName(String pSDEFTypeName) {
        this.set(FIELD_PSDEFTYPENAME, pSDEFTypeName);
    }

    @JsonIgnore
    public boolean isPSDEFTypeNameDirty() {
        return this.contains(FIELD_PSDEFTYPENAME);
    }

    @JsonIgnore
    public String getPSSysDEFTypeId() {
        Object objValue = this.get(FIELD_PSSYSDEFTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdeftypeid")
    public void setPSSysDEFTypeId(String pSSysDEFTypeId) {
        this.set(FIELD_PSSYSDEFTYPEID, pSSysDEFTypeId);
    }

    @JsonIgnore
    public boolean isPSSysDEFTypeIdDirty() {
        return this.contains(FIELD_PSSYSDEFTYPEID);
    }

    @JsonIgnore
    public String getPSSysDEFTypeName() {
        Object objValue = this.get(FIELD_PSSYSDEFTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdeftypename")
    public void setPSSysDEFTypeName(String pSSysDEFTypeName) {
        this.set(FIELD_PSSYSDEFTYPENAME, pSSysDEFTypeName);
    }

    @JsonIgnore
    public boolean isPSSysDEFTypeNameDirty() {
        return this.contains(FIELD_PSSYSDEFTYPENAME);
    }

    @JsonIgnore
    public String getPSSystemId() {
        Object objValue = this.get(FIELD_PSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemid")
    public void setPSSystemId(String pSSystemId) {
        this.set(FIELD_PSSYSTEMID, pSSystemId);
    }

    @JsonIgnore
    public boolean isPSSystemIdDirty() {
        return this.contains(FIELD_PSSYSTEMID);
    }

    @JsonIgnore
    public String getPSSystemName() {
        Object objValue = this.get(FIELD_PSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemname")
    public void setPSSystemName(String pSSystemName) {
        this.set(FIELD_PSSYSTEMNAME, pSSystemName);
    }

    @JsonIgnore
    public boolean isPSSystemNameDirty() {
        return this.contains(FIELD_PSSYSTEMNAME);
    }

    @JsonIgnore
    public String getPSSysUnitId() {
        Object objValue = this.get(FIELD_PSSYSUNITID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunitid")
    public void setPSSysUnitId(String pSSysUnitId) {
        this.set(FIELD_PSSYSUNITID, pSSysUnitId);
    }

    @JsonIgnore
    public boolean isPSSysUnitIdDirty() {
        return this.contains(FIELD_PSSYSUNITID);
    }

    @JsonIgnore
    public String getPSSysUnitName() {
        Object objValue = this.get(FIELD_PSSYSUNITNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunitname")
    public void setPSSysUnitName(String pSSysUnitName) {
        this.set(FIELD_PSSYSUNITNAME, pSSysUnitName);
    }

    @JsonIgnore
    public boolean isPSSysUnitNameDirty() {
        return this.contains(FIELD_PSSYSUNITNAME);
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
    public String getPYFormat() {
        Object objValue = this.get(FIELD_PYFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pyformat")
    public void setPYFormat(String pYFormat) {
        this.set(FIELD_PYFORMAT, pYFormat);
    }

    @JsonIgnore
    public boolean isPYFormatDirty() {
        return this.contains(FIELD_PYFORMAT);
    }

    @JsonIgnore
    public Integer getSearchEditorHeight() {
        Object objValue = this.get(FIELD_SEARCHEDITORHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="searcheditorheight")
    public void setSearchEditorHeight(Integer searchEditorHeight) {
        this.set(FIELD_SEARCHEDITORHEIGHT, searchEditorHeight);
    }

    @JsonIgnore
    public boolean isSearchEditorHeightDirty() {
        return this.contains(FIELD_SEARCHEDITORHEIGHT);
    }

    @JsonIgnore
    public String getSearchEditorType() {
        Object objValue = this.get(FIELD_SEARCHEDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searcheditortype")
    public void setSearchEditorType(String searchEditorType) {
        this.set(FIELD_SEARCHEDITORTYPE, searchEditorType);
    }

    @JsonIgnore
    public boolean isSearchEditorTypeDirty() {
        return this.contains(FIELD_SEARCHEDITORTYPE);
    }

    @JsonIgnore
    public Integer getSearchEditorWidth() {
        Object objValue = this.get(FIELD_SEARCHEDITORWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="searcheditorwidth")
    public void setSearchEditorWidth(Integer searchEditorWidth) {
        this.set(FIELD_SEARCHEDITORWIDTH, searchEditorWidth);
    }

    @JsonIgnore
    public boolean isSearchEditorWidthDirty() {
        return this.contains(FIELD_SEARCHEDITORWIDTH);
    }

    @JsonIgnore
    public Integer getSearchMBEditorHeight() {
        Object objValue = this.get(FIELD_SEARCHMBEDITORHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="searchmbeditorheight")
    public void setSearchMBEditorHeight(Integer searchMBEditorHeight) {
        this.set(FIELD_SEARCHMBEDITORHEIGHT, searchMBEditorHeight);
    }

    @JsonIgnore
    public boolean isSearchMBEditorHeightDirty() {
        return this.contains(FIELD_SEARCHMBEDITORHEIGHT);
    }

    @JsonIgnore
    public String getSearchMBEditorType() {
        Object objValue = this.get(FIELD_SEARCHMBEDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchmbeditortype")
    public void setSearchMBEditorType(String searchMBEditorType) {
        this.set(FIELD_SEARCHMBEDITORTYPE, searchMBEditorType);
    }

    @JsonIgnore
    public boolean isSearchMBEditorTypeDirty() {
        return this.contains(FIELD_SEARCHMBEDITORTYPE);
    }

    @JsonIgnore
    public Integer getSearchMBEditorWidth() {
        Object objValue = this.get(FIELD_SEARCHMBEDITORWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="searchmbeditorwidth")
    public void setSearchMBEditorWidth(Integer searchMBEditorWidth) {
        this.set(FIELD_SEARCHMBEDITORWIDTH, searchMBEditorWidth);
    }

    @JsonIgnore
    public boolean isSearchMBEditorWidthDirty() {
        return this.contains(FIELD_SEARCHMBEDITORWIDTH);
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
    public String getTSFormat() {
        Object objValue = this.get(FIELD_TSFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tsformat")
    public void setTSFormat(String tSFormat) {
        this.set(FIELD_TSFORMAT, tSFormat);
    }

    @JsonIgnore
    public boolean isTSFormatDirty() {
        return this.contains(FIELD_TSFORMAT);
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
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysDEFTypeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDEFTypeId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDEFTYPE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDEFType item = (PSSysDEFType)MAPPER.readValue(new File(strJsonFilePath), PSSysDEFType.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDEFType) {
            PSSysDEFType pSSysDEFType = (PSSysDEFType)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDEFType) {
            PSSysDEFType pSSysDEFType = (PSSysDEFType)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

