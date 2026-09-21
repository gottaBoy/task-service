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

public class PSDEDRItemDTO
extends PSModelDTOBase {
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COUNTERID = "counterid";
    public static final String FIELD_COUNTERMODE = "countermode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DRITEMTYPE = "dritemtype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEMODE = "enablemode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDEID = "minorpsdeid";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWFILTERDESC = "navviewfilterdesc";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDRGROUPID = "psdedrgroupid";
    public static final String FIELD_PSDEDRGROUPNAME = "psdedrgroupname";
    public static final String FIELD_PSDEDRITEMID = "psdedritemid";
    public static final String FIELD_PSDEDRITEMNAME = "psdedritemname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_TESTCUSTOMCODE = "testcustomcode";
    public static final String FIELD_TESTCUSTOMMODE = "testcustommode";
    public static final String FIELD_TESTPSDEACTIONID = "testpsdeactionid";
    public static final String FIELD_TESTPSDEACTIONNAME = "testpsdeactionname";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VIEWPARAMS = "viewparams";
    public static final String FIELD_VIEWPSDEID = "viewpsdeid";

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
    public String getCounterId() {
        Object objValue = this.get(FIELD_COUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="counterid")
    public void setCounterId(String counterId) {
        this.set(FIELD_COUNTERID, counterId);
    }

    @JsonIgnore
    public boolean isCounterIdDirty() {
        return this.contains(FIELD_COUNTERID);
    }

    @JsonIgnore
    public Integer getCounterMode() {
        Object objValue = this.get(FIELD_COUNTERMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="countermode")
    public void setCounterMode(Integer counterMode) {
        this.set(FIELD_COUNTERMODE, counterMode);
    }

    @JsonIgnore
    public boolean isCounterModeDirty() {
        return this.contains(FIELD_COUNTERMODE);
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
    public String getDRItemType() {
        Object objValue = this.get(FIELD_DRITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dritemtype")
    public void setDRItemType(String dRItemType) {
        this.set(FIELD_DRITEMTYPE, dRItemType);
    }

    @JsonIgnore
    public boolean isDRItemTypeDirty() {
        return this.contains(FIELD_DRITEMTYPE);
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
    public String getEnableMode() {
        Object objValue = this.get(FIELD_ENABLEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enablemode")
    public void setEnableMode(String enableMode) {
        this.set(FIELD_ENABLEMODE, enableMode);
    }

    @JsonIgnore
    public boolean isEnableModeDirty() {
        return this.contains(FIELD_ENABLEMODE);
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
    public String getMinorPSDEId() {
        Object objValue = this.get(FIELD_MINORPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdeid")
    public void setMinorPSDEId(String minorPSDEId) {
        this.set(FIELD_MINORPSDEID, minorPSDEId);
    }

    @JsonIgnore
    public boolean isMinorPSDEIdDirty() {
        return this.contains(FIELD_MINORPSDEID);
    }

    @JsonIgnore
    public String getNavViewFilter() {
        Object objValue = this.get(FIELD_NAVVIEWFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilter")
    public void setNavViewFilter(String navViewFilter) {
        this.set(FIELD_NAVVIEWFILTER, navViewFilter);
    }

    @JsonIgnore
    public boolean isNavViewFilterDirty() {
        return this.contains(FIELD_NAVVIEWFILTER);
    }

    @JsonIgnore
    public String getNavViewFilterDesc() {
        Object objValue = this.get(FIELD_NAVVIEWFILTERDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilterdesc")
    public void setNavViewFilterDesc(String navViewFilterDesc) {
        this.set(FIELD_NAVVIEWFILTERDESC, navViewFilterDesc);
    }

    @JsonIgnore
    public boolean isNavViewFilterDescDirty() {
        return this.contains(FIELD_NAVVIEWFILTERDESC);
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
    public String getPSDEDRGroupId() {
        Object objValue = this.get(FIELD_PSDEDRGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrgroupid")
    public void setPSDEDRGroupId(String pSDEDRGroupId) {
        this.set(FIELD_PSDEDRGROUPID, pSDEDRGroupId);
    }

    @JsonIgnore
    public boolean isPSDEDRGroupIdDirty() {
        return this.contains(FIELD_PSDEDRGROUPID);
    }

    @JsonIgnore
    public String getPSDEDRGroupName() {
        Object objValue = this.get(FIELD_PSDEDRGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrgroupname")
    public void setPSDEDRGroupName(String pSDEDRGroupName) {
        this.set(FIELD_PSDEDRGROUPNAME, pSDEDRGroupName);
    }

    @JsonIgnore
    public boolean isPSDEDRGroupNameDirty() {
        return this.contains(FIELD_PSDEDRGROUPNAME);
    }

    @JsonIgnore
    public String getPSDEDRItemId() {
        Object objValue = this.get(FIELD_PSDEDRITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedritemid")
    public void setPSDEDRItemId(String pSDEDRItemId) {
        this.set(FIELD_PSDEDRITEMID, pSDEDRItemId);
    }

    @JsonIgnore
    public boolean isPSDEDRItemIdDirty() {
        return this.contains(FIELD_PSDEDRITEMID);
    }

    @JsonIgnore
    public String getPSDEDRItemName() {
        Object objValue = this.get(FIELD_PSDEDRITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedritemname")
    public void setPSDEDRItemName(String pSDEDRItemName) {
        this.set(FIELD_PSDEDRITEMNAME, pSDEDRItemName);
    }

    @JsonIgnore
    public boolean isPSDEDRItemNameDirty() {
        return this.contains(FIELD_PSDEDRITEMNAME);
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
    public String getPSDEOPPrivId() {
        Object objValue = this.get(FIELD_PSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivid")
    public void setPSDEOPPrivId(String pSDEOPPrivId) {
        this.set(FIELD_PSDEOPPRIVID, pSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivIdDirty() {
        return this.contains(FIELD_PSDEOPPRIVID);
    }

    @JsonIgnore
    public String getPSDEOPPrivName() {
        Object objValue = this.get(FIELD_PSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivname")
    public void setPSDEOPPrivName(String pSDEOPPrivName) {
        this.set(FIELD_PSDEOPPRIVNAME, pSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivNameDirty() {
        return this.contains(FIELD_PSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
    }

    @JsonIgnore
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
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
    public String getTestCustomCode() {
        Object objValue = this.get(FIELD_TESTCUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testcustomcode")
    public void setTestCustomCode(String testCustomCode) {
        this.set(FIELD_TESTCUSTOMCODE, testCustomCode);
    }

    @JsonIgnore
    public boolean isTestCustomCodeDirty() {
        return this.contains(FIELD_TESTCUSTOMCODE);
    }

    @JsonIgnore
    public Integer getTestCustomMode() {
        Object objValue = this.get(FIELD_TESTCUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="testcustommode")
    public void setTestCustomMode(Integer testCustomMode) {
        this.set(FIELD_TESTCUSTOMMODE, testCustomMode);
    }

    @JsonIgnore
    public boolean isTestCustomModeDirty() {
        return this.contains(FIELD_TESTCUSTOMMODE);
    }

    @JsonIgnore
    public String getTestPSDEActionId() {
        Object objValue = this.get(FIELD_TESTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testpsdeactionid")
    public void setTestPSDEActionId(String testPSDEActionId) {
        this.set(FIELD_TESTPSDEACTIONID, testPSDEActionId);
    }

    @JsonIgnore
    public boolean isTestPSDEActionIdDirty() {
        return this.contains(FIELD_TESTPSDEACTIONID);
    }

    @JsonIgnore
    public String getTestPSDEActionName() {
        Object objValue = this.get(FIELD_TESTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testpsdeactionname")
    public void setTestPSDEActionName(String testPSDEActionName) {
        this.set(FIELD_TESTPSDEACTIONNAME, testPSDEActionName);
    }

    @JsonIgnore
    public boolean isTestPSDEActionNameDirty() {
        return this.contains(FIELD_TESTPSDEACTIONNAME);
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
    public String getViewParams() {
        Object objValue = this.get(FIELD_VIEWPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparams")
    public void setViewParams(String viewParams) {
        this.set(FIELD_VIEWPARAMS, viewParams);
    }

    @JsonIgnore
    public boolean isViewParamsDirty() {
        return this.contains(FIELD_VIEWPARAMS);
    }

    @JsonIgnore
    public String getViewPSDEId() {
        Object objValue = this.get(FIELD_VIEWPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewpsdeid")
    public void setViewPSDEId(String viewPSDEId) {
        this.set(FIELD_VIEWPSDEID, viewPSDEId);
    }

    @JsonIgnore
    public boolean isViewPSDEIdDirty() {
        return this.contains(FIELD_VIEWPSDEID);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDRItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDRItemId(strValue);
    }
}

