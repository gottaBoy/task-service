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

public class PSDEFType
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATATYPES = "datatypes";
    public static final String FIELD_DOTNETFORMAT = "dotnetformat";
    public static final String FIELD_EDITORHEIGHT = "editorheight";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORWIDTH = "editorwidth";
    public static final String FIELD_FIELDS = "fields";
    public static final String FIELD_FORMITEMOBJ = "formitemobj";
    public static final String FIELD_GRIDCOLALIGN = "gridcolalign";
    public static final String FIELD_GRIDCOLCLMODE = "gridcolclmode";
    public static final String FIELD_GRIDCOLOBJ = "gridcolobj";
    public static final String FIELD_GRIDCOLWIDTH = "gridcolwidth";
    public static final String FIELD_ICONPATH = "iconpath";
    public static final String FIELD_INCREMENTFLAG = "incrementflag";
    public static final String FIELD_JAVAFORMAT = "javaformat";
    public static final String FIELD_JSFORMAT = "jsformat";
    public static final String FIELD_MAXVALUESTR = "maxvaluestr";
    public static final String FIELD_MBEDITORHEIGHT = "mbeditorheight";
    public static final String FIELD_MBEDITORTYPE = "mbeditortype";
    public static final String FIELD_MBEDITORWIDTH = "mbeditorwidth";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUESTR = "minvaluestr";
    public static final String FIELD_OBJHELPER = "objhelper";
    public static final String FIELD_OBJHELPER2 = "objhelper2";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSCODELISTTEMPLID = "pscodelisttemplid";
    public static final String FIELD_PSCODELISTTEMPLNAME = "pscodelisttemplname";
    public static final String FIELD_PSDEFTYPEID = "psdeftypeid";
    public static final String FIELD_PSDEFTYPENAME = "psdeftypename";
    public static final String FIELD_PSUNITID = "psunitid";
    public static final String FIELD_PSUNITNAME = "psunitname";
    public static final String FIELD_PSVALUERULEID = "psvalueruleid";
    public static final String FIELD_PSVALUERULENAME = "psvaluerulename";
    public static final String FIELD_PYFORMAT = "pyformat";
    public static final String FIELD_SEARCHEDITORHEIGHT = "searcheditorheight";
    public static final String FIELD_SEARCHEDITORTYPE = "searcheditortype";
    public static final String FIELD_SEARCHEDITORWIDTH = "searcheditorwidth";
    public static final String FIELD_SEARCHMBEDITORHEIGHT = "searchmbeditorheight";
    public static final String FIELD_SEARCHMBEDITORTYPE = "searchmbeditortype";
    public static final String FIELD_SEARCHMBEDITORWIDTH = "searchmbeditorwidth";
    public static final String FIELD_SEARCHMODEOBJ = "searchmodeobj";
    public static final String FIELD_SFITEMOBJ = "sfitemobj";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    public static final String FIELD_STRLENGTH = "strlength";
    public static final String FIELD_TESTDATA = "testdata";
    public static final String FIELD_TSFORMAT = "tsformat";
    public static final String FIELD_UIMODEOBJ = "uimodeobj";
    public static final String FIELD_UNSIGNEDFLAG = "unsignedflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getDataTypes() {
        Object objValue = this.get(FIELD_DATATYPES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatypes")
    public void setDataTypes(String dataTypes) {
        this.set(FIELD_DATATYPES, dataTypes);
    }

    @JsonIgnore
    public boolean isDataTypesDirty() {
        return this.contains(FIELD_DATATYPES);
    }

    @JsonIgnore
    public String getDotNETFormat() {
        Object objValue = this.get(FIELD_DOTNETFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dotnetformat")
    public void setDotNETFormat(String dotNETFormat) {
        this.set(FIELD_DOTNETFORMAT, dotNETFormat);
    }

    @JsonIgnore
    public boolean isDotNETFormatDirty() {
        return this.contains(FIELD_DOTNETFORMAT);
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
    public String getFormItemObj() {
        Object objValue = this.get(FIELD_FORMITEMOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formitemobj")
    public void setFormItemObj(String formItemObj) {
        this.set(FIELD_FORMITEMOBJ, formItemObj);
    }

    @JsonIgnore
    public boolean isFormItemObjDirty() {
        return this.contains(FIELD_FORMITEMOBJ);
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
    public String getGridColObj() {
        Object objValue = this.get(FIELD_GRIDCOLOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gridcolobj")
    public void setGridColObj(String gridColObj) {
        this.set(FIELD_GRIDCOLOBJ, gridColObj);
    }

    @JsonIgnore
    public boolean isGridColObjDirty() {
        return this.contains(FIELD_GRIDCOLOBJ);
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
    public String getIconPath() {
        Object objValue = this.get(FIELD_ICONPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpath")
    public void setIconPath(String iconPath) {
        this.set(FIELD_ICONPATH, iconPath);
    }

    @JsonIgnore
    public boolean isIconPathDirty() {
        return this.contains(FIELD_ICONPATH);
    }

    @JsonIgnore
    public Integer getIncrementFlag() {
        Object objValue = this.get(FIELD_INCREMENTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incrementflag")
    public void setIncrementFlag(Integer incrementFlag) {
        this.set(FIELD_INCREMENTFLAG, incrementFlag);
    }

    @JsonIgnore
    public boolean isIncrementFlagDirty() {
        return this.contains(FIELD_INCREMENTFLAG);
    }

    @JsonIgnore
    public String getJAVAFormat() {
        Object objValue = this.get(FIELD_JAVAFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="javaformat")
    public void setJAVAFormat(String jAVAFormat) {
        this.set(FIELD_JAVAFORMAT, jAVAFormat);
    }

    @JsonIgnore
    public boolean isJAVAFormatDirty() {
        return this.contains(FIELD_JAVAFORMAT);
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
    public String getMaxValueStr() {
        Object objValue = this.get(FIELD_MAXVALUESTR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maxvaluestr")
    public void setMaxValueStr(String maxValueStr) {
        this.set(FIELD_MAXVALUESTR, maxValueStr);
    }

    @JsonIgnore
    public boolean isMaxValueStrDirty() {
        return this.contains(FIELD_MAXVALUESTR);
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
    public String getMinValueStr() {
        Object objValue = this.get(FIELD_MINVALUESTR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minvaluestr")
    public void setMinValueStr(String minValueStr) {
        this.set(FIELD_MINVALUESTR, minValueStr);
    }

    @JsonIgnore
    public boolean isMinValueStrDirty() {
        return this.contains(FIELD_MINVALUESTR);
    }

    @JsonIgnore
    public String getObjHelper() {
        Object objValue = this.get(FIELD_OBJHELPER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="objhelper")
    public void setObjHelper(String objHelper) {
        this.set(FIELD_OBJHELPER, objHelper);
    }

    @JsonIgnore
    public boolean isObjHelperDirty() {
        return this.contains(FIELD_OBJHELPER);
    }

    @JsonIgnore
    public String getObjHelper2() {
        Object objValue = this.get(FIELD_OBJHELPER2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="objhelper2")
    public void setObjHelper2(String objHelper2) {
        this.set(FIELD_OBJHELPER2, objHelper2);
    }

    @JsonIgnore
    public boolean isObjHelper2Dirty() {
        return this.contains(FIELD_OBJHELPER2);
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
    public String getPSCodeListTemplId() {
        Object objValue = this.get(FIELD_PSCODELISTTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelisttemplid")
    public void setPSCodeListTemplId(String pSCodeListTemplId) {
        this.set(FIELD_PSCODELISTTEMPLID, pSCodeListTemplId);
    }

    @JsonIgnore
    public boolean isPSCodeListTemplIdDirty() {
        return this.contains(FIELD_PSCODELISTTEMPLID);
    }

    @JsonIgnore
    public String getPSCodeListTemplName() {
        Object objValue = this.get(FIELD_PSCODELISTTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelisttemplname")
    public void setPSCodeListTemplName(String pSCodeListTemplName) {
        this.set(FIELD_PSCODELISTTEMPLNAME, pSCodeListTemplName);
    }

    @JsonIgnore
    public boolean isPSCodeListTemplNameDirty() {
        return this.contains(FIELD_PSCODELISTTEMPLNAME);
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
    public String getPSUnitId() {
        Object objValue = this.get(FIELD_PSUNITID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psunitid")
    public void setPSUnitId(String pSUnitId) {
        this.set(FIELD_PSUNITID, pSUnitId);
    }

    @JsonIgnore
    public boolean isPSUnitIdDirty() {
        return this.contains(FIELD_PSUNITID);
    }

    @JsonIgnore
    public String getPSUnitName() {
        Object objValue = this.get(FIELD_PSUNITNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psunitname")
    public void setPSUnitName(String pSUnitName) {
        this.set(FIELD_PSUNITNAME, pSUnitName);
    }

    @JsonIgnore
    public boolean isPSUnitNameDirty() {
        return this.contains(FIELD_PSUNITNAME);
    }

    @JsonIgnore
    public String getPSValueRuleId() {
        Object objValue = this.get(FIELD_PSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psvalueruleid")
    public void setPSValueRuleId(String pSValueRuleId) {
        this.set(FIELD_PSVALUERULEID, pSValueRuleId);
    }

    @JsonIgnore
    public boolean isPSValueRuleIdDirty() {
        return this.contains(FIELD_PSVALUERULEID);
    }

    @JsonIgnore
    public String getPSValueRuleName() {
        Object objValue = this.get(FIELD_PSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psvaluerulename")
    public void setPSValueRuleName(String pSValueRuleName) {
        this.set(FIELD_PSVALUERULENAME, pSValueRuleName);
    }

    @JsonIgnore
    public boolean isPSValueRuleNameDirty() {
        return this.contains(FIELD_PSVALUERULENAME);
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
    public String getSearchModeObj() {
        Object objValue = this.get(FIELD_SEARCHMODEOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchmodeobj")
    public void setSearchModeObj(String searchModeObj) {
        this.set(FIELD_SEARCHMODEOBJ, searchModeObj);
    }

    @JsonIgnore
    public boolean isSearchModeObjDirty() {
        return this.contains(FIELD_SEARCHMODEOBJ);
    }

    @JsonIgnore
    public String getSFItemObj() {
        Object objValue = this.get(FIELD_SFITEMOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sfitemobj")
    public void setSFItemObj(String sFItemObj) {
        this.set(FIELD_SFITEMOBJ, sFItemObj);
    }

    @JsonIgnore
    public boolean isSFItemObjDirty() {
        return this.contains(FIELD_SFITEMOBJ);
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
    public String getTestData() {
        Object objValue = this.get(FIELD_TESTDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testdata")
    public void setTestData(String testData) {
        this.set(FIELD_TESTDATA, testData);
    }

    @JsonIgnore
    public boolean isTestDataDirty() {
        return this.contains(FIELD_TESTDATA);
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
    public String getUIModeObj() {
        Object objValue = this.get(FIELD_UIMODEOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uimodeobj")
    public void setUIModeObj(String uIModeObj) {
        this.set(FIELD_UIMODEOBJ, uIModeObj);
    }

    @JsonIgnore
    public boolean isUIModeObjDirty() {
        return this.contains(FIELD_UIMODEOBJ);
    }

    @JsonIgnore
    public Integer getUnsignedFlag() {
        Object objValue = this.get(FIELD_UNSIGNEDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="unsignedflag")
    public void setUnsignedFlag(Integer unsignedFlag) {
        this.set(FIELD_UNSIGNEDFLAG, unsignedFlag);
    }

    @JsonIgnore
    public boolean isUnsignedFlagDirty() {
        return this.contains(FIELD_UNSIGNEDFLAG);
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
    public String getSrfkey() {
        return this.getPSDEFTypeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFTypeId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEFTYPE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFType item = (PSDEFType)MAPPER.readValue(new File(strJsonFilePath), PSDEFType.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFType) {
            PSDEFType pSDEFType = (PSDEFType)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFType) {
            PSDEFType pSDEFType = (PSDEFType)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

