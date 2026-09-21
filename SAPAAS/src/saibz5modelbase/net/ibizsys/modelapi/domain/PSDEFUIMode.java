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

public class PSDEFUIMode
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CODELISTCONFIGMODE = "codelistconfigmode";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONVERTCITEXT = "convertcitext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEDV = "createdv";
    public static final String FIELD_CREATEDVT = "createdvt";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITORPARAMS = "editorparams";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORTYPENAME = "editortypename";
    public static final String FIELD_ENABLEINPUTTIP = "enableinputtip";
    public static final String FIELD_ENABLERESETITEMNAME = "enableresetitemname";
    public static final String FIELD_ENABLEUNITNAME = "enableunitname";
    public static final String FIELD_ENABLEVALUERULE = "enablevaluerule";
    public static final String FIELD_FTMODE = "ftmode";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "gcrpssyspfpluginid";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "gcrpssyspfpluginname";
    public static final String FIELD_GRIDCOLALIGN = "gridcolalign";
    public static final String FIELD_GRIDCOLCLMODE = "gridcolclmode";
    public static final String FIELD_GRIDCOLWIDTH = "gridcolwidth";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_IGNOREINPUT = "ignoreinput";
    public static final String FIELD_ITEMPSACHANDLERID = "itempsachandlerid";
    public static final String FIELD_ITEMPSACHANDLERNAME = "itempsachandlername";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_NEEDCODELISTCONFIG = "needcodelistconfig";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_PHPSLANRESID = "phpslanresid";
    public static final String FIELD_PHPSLANRESNAME = "phpslanresname";
    public static final String FIELD_PICKUPTEXTOPTS = "pickuptextopts";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEFUIMODEID = "psdefformitemid";
    public static final String FIELD_PSDEFUIMODENAME = "psdefformitemname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFINPUTTIPID = "psdefinputtipid";
    public static final String FIELD_PSDEFINPUTTIPNAME = "psdefinputtipname";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSDICTCATID = "pssysdictcatid";
    public static final String FIELD_PSSYSDICTCATNAME = "pssysdictcatname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSUNITID = "pssysunitid";
    public static final String FIELD_PSSYSUNITNAME = "pssysunitname";
    public static final String FIELD_REFADPSDELOGICID = "refadpsdelogicid";
    public static final String FIELD_REFADPSDELOGICNAME = "refadpsdelogicname";
    public static final String FIELD_REFLINKPSDEVIEWID = "reflinkpsdeviewid";
    public static final String FIELD_REFLINKPSDEVIEWNAME = "reflinkpsdeviewname";
    public static final String FIELD_REFMPICKUPPSDEVIEWID = "refmpickuppsdeviewid";
    public static final String FIELD_REFMPICKUPPSDEVIEWNAME = "refmpickuppsdeviewname";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "refpickuppsdeviewid";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "refpickuppsdeviewname";
    public static final String FIELD_REFPSDEACMODEID = "refpsdeacmodeid";
    public static final String FIELD_REFPSDEACMODENAME = "refpsdeacmodename";
    public static final String FIELD_REFPSDEDATASETID = "refpsdedatasetid";
    public static final String FIELD_REFPSDEDATASETNAME = "refpsdedatasetname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSDERID = "refpsderid";
    public static final String FIELD_REFPSDERNAME = "refpsdername";
    public static final String FIELD_REFTEMPDATA = "reftempdata";
    public static final String FIELD_RESETITEMNAME = "resetitemname";
    public static final String FIELD_STRINGCASE = "stringcase";
    public static final String FIELD_STRLENGTH = "strlength";
    public static final String FIELD_UNITNAME = "unitname";
    public static final String FIELD_UNITNAMEWIDTH = "unitnamewidth";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEDV = "updatedv";
    public static final String FIELD_UPDATEDVT = "updatedvt";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_VALUEITEMNAME = "valueitemname";
    public static final String FIELD_WIDTH = "width";

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
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public Integer getCodeListConfigMode() {
        Object objValue = this.get(FIELD_CODELISTCONFIGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="codelistconfigmode")
    public void setCodeListConfigMode(Integer codeListConfigMode) {
        this.set(FIELD_CODELISTCONFIGMODE, codeListConfigMode);
    }

    @JsonIgnore
    public boolean isCodeListConfigModeDirty() {
        return this.contains(FIELD_CODELISTCONFIGMODE);
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
    public Integer getConvertCIText() {
        Object objValue = this.get(FIELD_CONVERTCITEXT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="convertcitext")
    public void setConvertCIText(Integer convertCIText) {
        this.set(FIELD_CONVERTCITEXT, convertCIText);
    }

    @JsonIgnore
    public boolean isConvertCITextDirty() {
        return this.contains(FIELD_CONVERTCITEXT);
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
    public String getCreateDV() {
        Object objValue = this.get(FIELD_CREATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdv")
    public void setCreateDV(String createDV) {
        this.set(FIELD_CREATEDV, createDV);
    }

    @JsonIgnore
    public boolean isCreateDVDirty() {
        return this.contains(FIELD_CREATEDV);
    }

    @JsonIgnore
    public String getCreateDVT() {
        Object objValue = this.get(FIELD_CREATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdvt")
    public void setCreateDVT(String createDVT) {
        this.set(FIELD_CREATEDVT, createDVT);
    }

    @JsonIgnore
    public boolean isCreateDVTDirty() {
        return this.contains(FIELD_CREATEDVT);
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
    public String getEditorParams() {
        Object objValue = this.get(FIELD_EDITORPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editorparams")
    public void setEditorParams(String editorParams) {
        this.set(FIELD_EDITORPARAMS, editorParams);
    }

    @JsonIgnore
    public boolean isEditorParamsDirty() {
        return this.contains(FIELD_EDITORPARAMS);
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
    public String getEditorTypeName() {
        Object objValue = this.get(FIELD_EDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortypename")
    public void setEditorTypeName(String editorTypeName) {
        this.set(FIELD_EDITORTYPENAME, editorTypeName);
    }

    @JsonIgnore
    public boolean isEditorTypeNameDirty() {
        return this.contains(FIELD_EDITORTYPENAME);
    }

    @JsonIgnore
    public Integer getEnableInputTip() {
        Object objValue = this.get(FIELD_ENABLEINPUTTIP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableinputtip")
    public void setEnableInputTip(Integer enableInputTip) {
        this.set(FIELD_ENABLEINPUTTIP, enableInputTip);
    }

    @JsonIgnore
    public boolean isEnableInputTipDirty() {
        return this.contains(FIELD_ENABLEINPUTTIP);
    }

    @JsonIgnore
    public Integer getEnableResetItemName() {
        Object objValue = this.get(FIELD_ENABLERESETITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableresetitemname")
    public void setEnableResetItemName(Integer enableResetItemName) {
        this.set(FIELD_ENABLERESETITEMNAME, enableResetItemName);
    }

    @JsonIgnore
    public boolean isEnableResetItemNameDirty() {
        return this.contains(FIELD_ENABLERESETITEMNAME);
    }

    @JsonIgnore
    public Integer getEnableUnitName() {
        Object objValue = this.get(FIELD_ENABLEUNITNAME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableunitname")
    public void setEnableUnitName(Integer enableUnitName) {
        this.set(FIELD_ENABLEUNITNAME, enableUnitName);
    }

    @JsonIgnore
    public boolean isEnableUnitNameDirty() {
        return this.contains(FIELD_ENABLEUNITNAME);
    }

    @JsonIgnore
    public Integer getEnableValueRule() {
        Object objValue = this.get(FIELD_ENABLEVALUERULE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablevaluerule")
    public void setEnableValueRule(Integer enableValueRule) {
        this.set(FIELD_ENABLEVALUERULE, enableValueRule);
    }

    @JsonIgnore
    public boolean isEnableValueRuleDirty() {
        return this.contains(FIELD_ENABLEVALUERULE);
    }

    @JsonIgnore
    public String getFTMode() {
        Object objValue = this.get(FIELD_FTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ftmode")
    public void setFTMode(String fTMode) {
        this.set(FIELD_FTMODE, fTMode);
    }

    @JsonIgnore
    public boolean isFTModeDirty() {
        return this.contains(FIELD_FTMODE);
    }

    @JsonIgnore
    public String getGCRPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GCRPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gcrpssyspfpluginid")
    public void setGCRPSSysPFPluginId(String gCRPSSysPFPluginId) {
        this.set(FIELD_GCRPSSYSPFPLUGINID, gCRPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGCRPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GCRPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGCRPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GCRPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="gcrpssyspfpluginname")
    public void setGCRPSSysPFPluginName(String gCRPSSysPFPluginName) {
        this.set(FIELD_GCRPSSYSPFPLUGINNAME, gCRPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGCRPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GCRPSSYSPFPLUGINNAME);
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
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public Integer getIgnoreInput() {
        Object objValue = this.get(FIELD_IGNOREINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoreinput")
    public void setIgnoreInput(Integer ignoreInput) {
        this.set(FIELD_IGNOREINPUT, ignoreInput);
    }

    @JsonIgnore
    public boolean isIgnoreInputDirty() {
        return this.contains(FIELD_IGNOREINPUT);
    }

    @JsonIgnore
    public String getItemPSACHandlerId() {
        Object objValue = this.get(FIELD_ITEMPSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempsachandlerid")
    public void setItemPSACHandlerId(String itemPSACHandlerId) {
        this.set(FIELD_ITEMPSACHANDLERID, itemPSACHandlerId);
    }

    @JsonIgnore
    public boolean isItemPSACHandlerIdDirty() {
        return this.contains(FIELD_ITEMPSACHANDLERID);
    }

    @JsonIgnore
    public String getItemPSACHandlerName() {
        Object objValue = this.get(FIELD_ITEMPSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempsachandlername")
    public void setItemPSACHandlerName(String itemPSACHandlerName) {
        this.set(FIELD_ITEMPSACHANDLERNAME, itemPSACHandlerName);
    }

    @JsonIgnore
    public boolean isItemPSACHandlerNameDirty() {
        return this.contains(FIELD_ITEMPSACHANDLERNAME);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public Integer getNeedCodeListConfig() {
        Object objValue = this.get(FIELD_NEEDCODELISTCONFIG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="needcodelistconfig")
    public void setNeedCodeListConfig(Integer needCodeListConfig) {
        this.set(FIELD_NEEDCODELISTCONFIG, needCodeListConfig);
    }

    @JsonIgnore
    public boolean isNeedCodeListConfigDirty() {
        return this.contains(FIELD_NEEDCODELISTCONFIG);
    }

    @JsonIgnore
    public Integer getNoSort() {
        Object objValue = this.get(FIELD_NOSORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="nosort")
    public void setNoSort(Integer noSort) {
        this.set(FIELD_NOSORT, noSort);
    }

    @JsonIgnore
    public boolean isNoSortDirty() {
        return this.contains(FIELD_NOSORT);
    }

    @JsonIgnore
    public String getPHPSLanResId() {
        Object objValue = this.get(FIELD_PHPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresid")
    public void setPHPSLanResId(String pHPSLanResId) {
        this.set(FIELD_PHPSLANRESID, pHPSLanResId);
    }

    @JsonIgnore
    public boolean isPHPSLanResIdDirty() {
        return this.contains(FIELD_PHPSLANRESID);
    }

    @JsonIgnore
    public String getPHPSLanResName() {
        Object objValue = this.get(FIELD_PHPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresname")
    public void setPHPSLanResName(String pHPSLanResName) {
        this.set(FIELD_PHPSLANRESNAME, pHPSLanResName);
    }

    @JsonIgnore
    public boolean isPHPSLanResNameDirty() {
        return this.contains(FIELD_PHPSLANRESNAME);
    }

    @JsonIgnore
    public Integer getPickupTextOpts() {
        Object objValue = this.get(FIELD_PICKUPTEXTOPTS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pickuptextopts")
    public void setPickupTextOpts(Integer pickupTextOpts) {
        this.set(FIELD_PICKUPTEXTOPTS, pickupTextOpts);
    }

    @JsonIgnore
    public boolean isPickupTextOptsDirty() {
        return this.contains(FIELD_PICKUPTEXTOPTS);
    }

    @JsonIgnore
    public String getPlaceHolder() {
        Object objValue = this.get(FIELD_PLACEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="placeholder")
    public void setPlaceHolder(String placeHolder) {
        this.set(FIELD_PLACEHOLDER, placeHolder);
    }

    @JsonIgnore
    public boolean isPlaceHolderDirty() {
        return this.contains(FIELD_PLACEHOLDER);
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
    public Integer getPreventXSS() {
        Object objValue = this.get(FIELD_PREVENTXSS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preventxss")
    public void setPreventXSS(Integer preventXSS) {
        this.set(FIELD_PREVENTXSS, preventXSS);
    }

    @JsonIgnore
    public boolean isPreventXSSDirty() {
        return this.contains(FIELD_PREVENTXSS);
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
    public String getPSDEFUIModeId() {
        Object objValue = this.get(FIELD_PSDEFUIMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefformitemid")
    public void setPSDEFUIModeId(String pSDEFUIModeId) {
        this.set(FIELD_PSDEFUIMODEID, pSDEFUIModeId);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeIdDirty() {
        return this.contains(FIELD_PSDEFUIMODEID);
    }

    @JsonIgnore
    public String getPSDEFUIModeName() {
        Object objValue = this.get(FIELD_PSDEFUIMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefformitemname")
    public void setPSDEFUIModeName(String pSDEFUIModeName) {
        this.set(FIELD_PSDEFUIMODENAME, pSDEFUIModeName);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeNameDirty() {
        return this.contains(FIELD_PSDEFUIMODENAME);
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
    public String getPSDEFInputTipId() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipid")
    public void setPSDEFInputTipId(String pSDEFInputTipId) {
        this.set(FIELD_PSDEFINPUTTIPID, pSDEFInputTipId);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipIdDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPID);
    }

    @JsonIgnore
    public String getPSDEFInputTipName() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipname")
    public void setPSDEFInputTipName(String pSDEFInputTipName) {
        this.set(FIELD_PSDEFINPUTTIPNAME, pSDEFInputTipName);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipNameDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPNAME);
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
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
    }

    @JsonIgnore
    public String getPSSysDictCatId() {
        Object objValue = this.get(FIELD_PSSYSDICTCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatid")
    public void setPSSysDictCatId(String pSSysDictCatId) {
        this.set(FIELD_PSSYSDICTCATID, pSSysDictCatId);
    }

    @JsonIgnore
    public boolean isPSSysDictCatIdDirty() {
        return this.contains(FIELD_PSSYSDICTCATID);
    }

    @JsonIgnore
    public String getPSSysDictCatName() {
        Object objValue = this.get(FIELD_PSSYSDICTCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatname")
    public void setPSSysDictCatName(String pSSysDictCatName) {
        this.set(FIELD_PSSYSDICTCATNAME, pSSysDictCatName);
    }

    @JsonIgnore
    public boolean isPSSysDictCatNameDirty() {
        return this.contains(FIELD_PSSYSDICTCATNAME);
    }

    @JsonIgnore
    public String getPSSysEditorStyleId() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstyleid")
    public void setPSSysEditorStyleId(String pSSysEditorStyleId) {
        this.set(FIELD_PSSYSEDITORSTYLEID, pSSysEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleIdDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSSysEditorStyleName() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstylename")
    public void setPSSysEditorStyleName(String pSSysEditorStyleName) {
        this.set(FIELD_PSSYSEDITORSTYLENAME, pSSysEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleNameDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLENAME);
    }

    @JsonIgnore
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
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
    public String getRefADPSDELogicId() {
        Object objValue = this.get(FIELD_REFADPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refadpsdelogicid")
    public void setRefADPSDELogicId(String refADPSDELogicId) {
        this.set(FIELD_REFADPSDELOGICID, refADPSDELogicId);
    }

    @JsonIgnore
    public boolean isRefADPSDELogicIdDirty() {
        return this.contains(FIELD_REFADPSDELOGICID);
    }

    @JsonIgnore
    public String getRefADPSDELogicName() {
        Object objValue = this.get(FIELD_REFADPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refadpsdelogicname")
    public void setRefADPSDELogicName(String refADPSDELogicName) {
        this.set(FIELD_REFADPSDELOGICNAME, refADPSDELogicName);
    }

    @JsonIgnore
    public boolean isRefADPSDELogicNameDirty() {
        return this.contains(FIELD_REFADPSDELOGICNAME);
    }

    @JsonIgnore
    public String getRefLinkPSDEViewId() {
        Object objValue = this.get(FIELD_REFLINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reflinkpsdeviewid")
    public void setRefLinkPSDEViewId(String refLinkPSDEViewId) {
        this.set(FIELD_REFLINKPSDEVIEWID, refLinkPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefLinkPSDEViewIdDirty() {
        return this.contains(FIELD_REFLINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefLinkPSDEViewName() {
        Object objValue = this.get(FIELD_REFLINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reflinkpsdeviewname")
    public void setRefLinkPSDEViewName(String refLinkPSDEViewName) {
        this.set(FIELD_REFLINKPSDEVIEWNAME, refLinkPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefLinkPSDEViewNameDirty() {
        return this.contains(FIELD_REFLINKPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefMPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFMPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmpickuppsdeviewid")
    public void setRefMPickupPSDEViewId(String refMPickupPSDEViewId) {
        this.set(FIELD_REFMPICKUPPSDEVIEWID, refMPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefMPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFMPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefMPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFMPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmpickuppsdeviewname")
    public void setRefMPickupPSDEViewName(String refMPickupPSDEViewName) {
        this.set(FIELD_REFMPICKUPPSDEVIEWNAME, refMPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefMPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFMPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewid")
    public void setRefPickupPSDEViewId(String refPickupPSDEViewId) {
        this.set(FIELD_REFPICKUPPSDEVIEWID, refPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewname")
    public void setRefPickupPSDEViewName(String refPickupPSDEViewName) {
        this.set(FIELD_REFPICKUPPSDEVIEWNAME, refPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPSDEACModeId() {
        Object objValue = this.get(FIELD_REFPSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodeid")
    public void setRefPSDEACModeId(String refPSDEACModeId) {
        this.set(FIELD_REFPSDEACMODEID, refPSDEACModeId);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeIdDirty() {
        return this.contains(FIELD_REFPSDEACMODEID);
    }

    @JsonIgnore
    public String getRefPSDEACModeName() {
        Object objValue = this.get(FIELD_REFPSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodename")
    public void setRefPSDEACModeName(String refPSDEACModeName) {
        this.set(FIELD_REFPSDEACMODENAME, refPSDEACModeName);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeNameDirty() {
        return this.contains(FIELD_REFPSDEACMODENAME);
    }

    @JsonIgnore
    public String getRefPSDEDataSetId() {
        Object objValue = this.get(FIELD_REFPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetid")
    public void setRefPSDEDataSetId(String refPSDEDataSetId) {
        this.set(FIELD_REFPSDEDATASETID, refPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetIdDirty() {
        return this.contains(FIELD_REFPSDEDATASETID);
    }

    @JsonIgnore
    public String getRefPSDEDataSetName() {
        Object objValue = this.get(FIELD_REFPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetname")
    public void setRefPSDEDataSetName(String refPSDEDataSetName) {
        this.set(FIELD_REFPSDEDATASETNAME, refPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetNameDirty() {
        return this.contains(FIELD_REFPSDEDATASETNAME);
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
    public String getRefPSDERId() {
        Object objValue = this.get(FIELD_REFPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsderid")
    public void setRefPSDERId(String refPSDERId) {
        this.set(FIELD_REFPSDERID, refPSDERId);
    }

    @JsonIgnore
    public boolean isRefPSDERIdDirty() {
        return this.contains(FIELD_REFPSDERID);
    }

    @JsonIgnore
    public String getRefPSDERName() {
        Object objValue = this.get(FIELD_REFPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdername")
    public void setRefPSDERName(String refPSDERName) {
        this.set(FIELD_REFPSDERNAME, refPSDERName);
    }

    @JsonIgnore
    public boolean isRefPSDERNameDirty() {
        return this.contains(FIELD_REFPSDERNAME);
    }

    @JsonIgnore
    public Integer getRefTempData() {
        Object objValue = this.get(FIELD_REFTEMPDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="reftempdata")
    public void setRefTempData(Integer refTempData) {
        this.set(FIELD_REFTEMPDATA, refTempData);
    }

    @JsonIgnore
    public boolean isRefTempDataDirty() {
        return this.contains(FIELD_REFTEMPDATA);
    }

    @JsonIgnore
    public String getResetItemName() {
        Object objValue = this.get(FIELD_RESETITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="resetitemname")
    public void setResetItemName(String resetItemName) {
        this.set(FIELD_RESETITEMNAME, resetItemName);
    }

    @JsonIgnore
    public boolean isResetItemNameDirty() {
        return this.contains(FIELD_RESETITEMNAME);
    }

    @JsonIgnore
    public String getStringCase() {
        Object objValue = this.get(FIELD_STRINGCASE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="stringcase")
    public void setStringCase(String stringCase) {
        this.set(FIELD_STRINGCASE, stringCase);
    }

    @JsonIgnore
    public boolean isStringCaseDirty() {
        return this.contains(FIELD_STRINGCASE);
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
    public String getUnitName() {
        Object objValue = this.get(FIELD_UNITNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unitname")
    public void setUnitName(String unitName) {
        this.set(FIELD_UNITNAME, unitName);
    }

    @JsonIgnore
    public boolean isUnitNameDirty() {
        return this.contains(FIELD_UNITNAME);
    }

    @JsonIgnore
    public Integer getUnitNameWidth() {
        Object objValue = this.get(FIELD_UNITNAMEWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="unitnamewidth")
    public void setUnitNameWidth(Integer unitNameWidth) {
        this.set(FIELD_UNITNAMEWIDTH, unitNameWidth);
    }

    @JsonIgnore
    public boolean isUnitNameWidthDirty() {
        return this.contains(FIELD_UNITNAMEWIDTH);
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
    public String getUpdateDV() {
        Object objValue = this.get(FIELD_UPDATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedv")
    public void setUpdateDV(String updateDV) {
        this.set(FIELD_UPDATEDV, updateDV);
    }

    @JsonIgnore
    public boolean isUpdateDVDirty() {
        return this.contains(FIELD_UPDATEDV);
    }

    @JsonIgnore
    public String getUpdateDVT() {
        Object objValue = this.get(FIELD_UPDATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedvt")
    public void setUpdateDVT(String updateDVT) {
        this.set(FIELD_UPDATEDVT, updateDVT);
    }

    @JsonIgnore
    public boolean isUpdateDVTDirty() {
        return this.contains(FIELD_UPDATEDVT);
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
    public String getValueItemName() {
        Object objValue = this.get(FIELD_VALUEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueitemname")
    public void setValueItemName(String valueItemName) {
        this.set(FIELD_VALUEITEMNAME, valueItemName);
    }

    @JsonIgnore
    public boolean isValueItemNameDirty() {
        return this.contains(FIELD_VALUEITEMNAME);
    }

    @JsonIgnore
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEFUIModeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFUIModeId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEFFORMITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFUIMode item = (PSDEFUIMode)MAPPER.readValue(new File(strJsonFilePath), PSDEFUIMode.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFUIMode) {
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFUIMode) {
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

