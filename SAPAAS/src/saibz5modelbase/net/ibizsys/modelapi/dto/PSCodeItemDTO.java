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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSCodeItemDTO
extends PSModelDTOBase {
    public static final String FIELD_BEGINVALUE = "beginvalue";
    public static final String FIELD_BKCOLOR = "bkcolor";
    public static final String FIELD_CODEITEMVALUE = "codeitemvalue";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DISABLESELECT = "disableselect";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENDVALUE = "endvalue";
    public static final String FIELD_ICONCLS = "iconcls";
    public static final String FIELD_INCBEGINVALUE = "incbeginvalue";
    public static final String FIELD_INCENDVALUE = "incendvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSCODEITEMID = "ppscodeitemid";
    public static final String FIELD_PPSCODEITEMNAME = "ppscodeitemname";
    public static final String FIELD_PSCODEITEMID = "pscodeitemid";
    public static final String FIELD_PSCODEITEMNAME = "pscodeitemname";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_SHORTKEY = "shortkey";
    public static final String FIELD_SHOWASEMPTY = "showasempty";
    public static final String FIELD_TEXTPSLANRESID = "textpslanresid";
    public static final String FIELD_TEXTPSLANRESNAME = "textpslanresname";
    public static final String FIELD_THRESHOLDGROUPFLAG = "thresholdgroupflag";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSCodeItemDTO> pscodeitems;

    @JsonIgnore
    public BigDecimal getBeginValue() {
        Object objValue = this.get(FIELD_BEGINVALUE);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="beginvalue")
    public void setBeginValue(BigDecimal beginValue) {
        this.set(FIELD_BEGINVALUE, beginValue);
    }

    @JsonIgnore
    public boolean isBeginValueDirty() {
        return this.contains(FIELD_BEGINVALUE);
    }

    @JsonIgnore
    public String getBKColor() {
        Object objValue = this.get(FIELD_BKCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolor")
    public void setBKColor(String bKColor) {
        this.set(FIELD_BKCOLOR, bKColor);
    }

    @JsonIgnore
    public boolean isBKColorDirty() {
        return this.contains(FIELD_BKCOLOR);
    }

    @JsonIgnore
    public String getCodeItemValue() {
        Object objValue = this.get(FIELD_CODEITEMVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codeitemvalue")
    public void setCodeItemValue(String codeItemValue) {
        this.set(FIELD_CODEITEMVALUE, codeItemValue);
    }

    @JsonIgnore
    public boolean isCodeItemValueDirty() {
        return this.contains(FIELD_CODEITEMVALUE);
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
    public String getColor() {
        Object objValue = this.get(FIELD_COLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="color")
    public void setColor(String color) {
        this.set(FIELD_COLOR, color);
    }

    @JsonIgnore
    public boolean isColorDirty() {
        return this.contains(FIELD_COLOR);
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
    public String getData() {
        Object objValue = this.get(FIELD_DATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data")
    public void setData(String data) {
        this.set(FIELD_DATA, data);
    }

    @JsonIgnore
    public boolean isDataDirty() {
        return this.contains(FIELD_DATA);
    }

    @JsonIgnore
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
    }

    @JsonIgnore
    public Integer getDisableSelect() {
        Object objValue = this.get(FIELD_DISABLESELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="disableselect")
    public void setDisableSelect(Integer disableSelect) {
        this.set(FIELD_DISABLESELECT, disableSelect);
    }

    @JsonIgnore
    public boolean isDisableSelectDirty() {
        return this.contains(FIELD_DISABLESELECT);
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
    public BigDecimal getEndValue() {
        Object objValue = this.get(FIELD_ENDVALUE);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="endvalue")
    public void setEndValue(BigDecimal endValue) {
        this.set(FIELD_ENDVALUE, endValue);
    }

    @JsonIgnore
    public boolean isEndValueDirty() {
        return this.contains(FIELD_ENDVALUE);
    }

    @JsonIgnore
    public String getIconCls() {
        Object objValue = this.get(FIELD_ICONCLS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconcls")
    public void setIconCls(String iconCls) {
        this.set(FIELD_ICONCLS, iconCls);
    }

    @JsonIgnore
    public boolean isIconClsDirty() {
        return this.contains(FIELD_ICONCLS);
    }

    @JsonIgnore
    public Integer getIncBeginValue() {
        Object objValue = this.get(FIELD_INCBEGINVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incbeginvalue")
    public void setIncBeginValue(Integer incBeginValue) {
        this.set(FIELD_INCBEGINVALUE, incBeginValue);
    }

    @JsonIgnore
    public boolean isIncBeginValueDirty() {
        return this.contains(FIELD_INCBEGINVALUE);
    }

    @JsonIgnore
    public Integer getIncEndValue() {
        Object objValue = this.get(FIELD_INCENDVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incendvalue")
    public void setIncEndValue(Integer incEndValue) {
        this.set(FIELD_INCENDVALUE, incEndValue);
    }

    @JsonIgnore
    public boolean isIncEndValueDirty() {
        return this.contains(FIELD_INCENDVALUE);
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
    public String getPPSCodeItemId() {
        Object objValue = this.get(FIELD_PPSCODEITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppscodeitemid")
    public void setPPSCodeItemId(String pPSCodeItemId) {
        this.set(FIELD_PPSCODEITEMID, pPSCodeItemId);
    }

    @JsonIgnore
    public boolean isPPSCodeItemIdDirty() {
        return this.contains(FIELD_PPSCODEITEMID);
    }

    @JsonIgnore
    public String getPPSCodeItemName() {
        Object objValue = this.get(FIELD_PPSCODEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppscodeitemname")
    public void setPPSCodeItemName(String pPSCodeItemName) {
        this.set(FIELD_PPSCODEITEMNAME, pPSCodeItemName);
    }

    @JsonIgnore
    public boolean isPPSCodeItemNameDirty() {
        return this.contains(FIELD_PPSCODEITEMNAME);
    }

    @JsonIgnore
    public String getPSCodeItemId() {
        Object objValue = this.get(FIELD_PSCODEITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodeitemid")
    public void setPSCodeItemId(String pSCodeItemId) {
        this.set(FIELD_PSCODEITEMID, pSCodeItemId);
    }

    @JsonIgnore
    public boolean isPSCodeItemIdDirty() {
        return this.contains(FIELD_PSCODEITEMID);
    }

    @JsonIgnore
    public String getPSCodeItemName() {
        Object objValue = this.get(FIELD_PSCODEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodeitemname")
    public void setPSCodeItemName(String pSCodeItemName) {
        this.set(FIELD_PSCODEITEMNAME, pSCodeItemName);
    }

    @JsonIgnore
    public boolean isPSCodeItemNameDirty() {
        return this.contains(FIELD_PSCODEITEMNAME);
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
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
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
    public String getShortKey() {
        Object objValue = this.get(FIELD_SHORTKEY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="shortkey")
    public void setShortKey(String shortKey) {
        this.set(FIELD_SHORTKEY, shortKey);
    }

    @JsonIgnore
    public boolean isShortKeyDirty() {
        return this.contains(FIELD_SHORTKEY);
    }

    @JsonIgnore
    public Integer getShowAsEmpty() {
        Object objValue = this.get(FIELD_SHOWASEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showasempty")
    public void setShowAsEmpty(Integer showAsEmpty) {
        this.set(FIELD_SHOWASEMPTY, showAsEmpty);
    }

    @JsonIgnore
    public boolean isShowAsEmptyDirty() {
        return this.contains(FIELD_SHOWASEMPTY);
    }

    @JsonIgnore
    public String getTextPSLanResId() {
        Object objValue = this.get(FIELD_TEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpslanresid")
    public void setTextPSLanResId(String textPSLanResId) {
        this.set(FIELD_TEXTPSLANRESID, textPSLanResId);
    }

    @JsonIgnore
    public boolean isTextPSLanResIdDirty() {
        return this.contains(FIELD_TEXTPSLANRESID);
    }

    @JsonIgnore
    public String getTextPSLanResName() {
        Object objValue = this.get(FIELD_TEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpslanresname")
    public void setTextPSLanResName(String textPSLanResName) {
        this.set(FIELD_TEXTPSLANRESNAME, textPSLanResName);
    }

    @JsonIgnore
    public boolean isTextPSLanResNameDirty() {
        return this.contains(FIELD_TEXTPSLANRESNAME);
    }

    @JsonIgnore
    public Integer getThresholdGroupFlag() {
        Object objValue = this.get(FIELD_THRESHOLDGROUPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="thresholdgroupflag")
    public void setThresholdGroupFlag(Integer thresholdGroupFlag) {
        this.set(FIELD_THRESHOLDGROUPFLAG, thresholdGroupFlag);
    }

    @JsonIgnore
    public boolean isThresholdGroupFlagDirty() {
        return this.contains(FIELD_THRESHOLDGROUPFLAG);
    }

    @JsonIgnore
    public String getTipPSLanResId() {
        Object objValue = this.get(FIELD_TIPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresid")
    public void setTipPSLanResId(String tipPSLanResId) {
        this.set(FIELD_TIPPSLANRESID, tipPSLanResId);
    }

    @JsonIgnore
    public boolean isTipPSLanResIdDirty() {
        return this.contains(FIELD_TIPPSLANRESID);
    }

    @JsonIgnore
    public String getTipPSLanResName() {
        Object objValue = this.get(FIELD_TIPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresname")
    public void setTipPSLanResName(String tipPSLanResName) {
        this.set(FIELD_TIPPSLANRESNAME, tipPSLanResName);
    }

    @JsonIgnore
    public boolean isTipPSLanResNameDirty() {
        return this.contains(FIELD_TIPPSLANRESNAME);
    }

    @JsonIgnore
    public String getTooltipInfo() {
        Object objValue = this.get(FIELD_TOOLTIPINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tooltipinfo")
    public void setTooltipInfo(String tooltipInfo) {
        this.set(FIELD_TOOLTIPINFO, tooltipInfo);
    }

    @JsonIgnore
    public boolean isTooltipInfoDirty() {
        return this.contains(FIELD_TOOLTIPINFO);
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
    public String getUserData() {
        Object objValue = this.get(FIELD_USERDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata")
    public void setUserData(String userData) {
        this.set(FIELD_USERDATA, userData);
    }

    @JsonIgnore
    public boolean isUserDataDirty() {
        return this.contains(FIELD_USERDATA);
    }

    @JsonIgnore
    public String getUserData2() {
        Object objValue = this.get(FIELD_USERDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata2")
    public void setUserData2(String userData2) {
        this.set(FIELD_USERDATA2, userData2);
    }

    @JsonIgnore
    public boolean isUserData2Dirty() {
        return this.contains(FIELD_USERDATA2);
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
        return this.getPSCodeItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSCodeItemId(strValue);
    }

    @JsonProperty(value="pscodeitems")
    public List<PSCodeItemDTO> getPscodeitems() {
        return this.pscodeitems;
    }

    @JsonProperty(value="pscodeitems")
    public void setPscodeitems(List<PSCodeItemDTO> pscodeitems) {
        this.pscodeitems = pscodeitems;
    }
}

