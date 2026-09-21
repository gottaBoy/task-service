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

public class PSDEDRDetailDTO
extends PSModelDTOBase {
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_COUNTERID = "counterid";
    public static final String FIELD_COUNTERMODE = "countermode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DETAILTYPE = "detailtype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEMODE = "enablemode";
    public static final String FIELD_GROUPORDERVALUE = "groupordervalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDRDETAILID = "psdedrdetailid";
    public static final String FIELD_PSDEDRDETAILNAME = "psdedrdetailname";
    public static final String FIELD_PSDEDRGROUPID = "psdedrgroupid";
    public static final String FIELD_PSDEDRGROUPNAME = "psdedrgroupname";
    public static final String FIELD_PSDEDRID = "psdedrid";
    public static final String FIELD_PSDEDRITEMID = "psdedritemid";
    public static final String FIELD_PSDEDRITEMNAME = "psdedritemname";
    public static final String FIELD_PSDEDRNAME = "psdedrname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPDTVIEWID = "pssyspdtviewid";
    public static final String FIELD_PSSYSPDTVIEWNAME = "pssyspdtviewname";
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
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public String getDetailType() {
        Object objValue = this.get(FIELD_DETAILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtype")
    public void setDetailType(String detailType) {
        this.set(FIELD_DETAILTYPE, detailType);
    }

    @JsonIgnore
    public boolean isDetailTypeDirty() {
        return this.contains(FIELD_DETAILTYPE);
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
    public Integer getGroupOrderValue() {
        Object objValue = this.get(FIELD_GROUPORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupordervalue")
    public void setGroupOrderValue(Integer groupOrderValue) {
        this.set(FIELD_GROUPORDERVALUE, groupOrderValue);
    }

    @JsonIgnore
    public boolean isGroupOrderValueDirty() {
        return this.contains(FIELD_GROUPORDERVALUE);
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
    public String getPSDEDRDetailId() {
        Object objValue = this.get(FIELD_PSDEDRDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrdetailid")
    public void setPSDEDRDetailId(String pSDEDRDetailId) {
        this.set(FIELD_PSDEDRDETAILID, pSDEDRDetailId);
    }

    @JsonIgnore
    public boolean isPSDEDRDetailIdDirty() {
        return this.contains(FIELD_PSDEDRDETAILID);
    }

    @JsonIgnore
    public String getPSDEDRDetailName() {
        Object objValue = this.get(FIELD_PSDEDRDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrdetailname")
    public void setPSDEDRDetailName(String pSDEDRDetailName) {
        this.set(FIELD_PSDEDRDETAILNAME, pSDEDRDetailName);
    }

    @JsonIgnore
    public boolean isPSDEDRDetailNameDirty() {
        return this.contains(FIELD_PSDEDRDETAILNAME);
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
    public String getPSDEDRId() {
        Object objValue = this.get(FIELD_PSDEDRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrid")
    public void setPSDEDRId(String pSDEDRId) {
        this.set(FIELD_PSDEDRID, pSDEDRId);
    }

    @JsonIgnore
    public boolean isPSDEDRIdDirty() {
        return this.contains(FIELD_PSDEDRID);
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
    public String getPSDEDRName() {
        Object objValue = this.get(FIELD_PSDEDRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrname")
    public void setPSDEDRName(String pSDEDRName) {
        this.set(FIELD_PSDEDRNAME, pSDEDRName);
    }

    @JsonIgnore
    public boolean isPSDEDRNameDirty() {
        return this.contains(FIELD_PSDEDRNAME);
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
    public String getPSDETreeViewId() {
        Object objValue = this.get(FIELD_PSDETREEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewid")
    public void setPSDETreeViewId(String pSDETreeViewId) {
        this.set(FIELD_PSDETREEVIEWID, pSDETreeViewId);
    }

    @JsonIgnore
    public boolean isPSDETreeViewIdDirty() {
        return this.contains(FIELD_PSDETREEVIEWID);
    }

    @JsonIgnore
    public String getPSDETreeViewName() {
        Object objValue = this.get(FIELD_PSDETREEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewname")
    public void setPSDETreeViewName(String pSDETreeViewName) {
        this.set(FIELD_PSDETREEVIEWNAME, pSDETreeViewName);
    }

    @JsonIgnore
    public boolean isPSDETreeViewNameDirty() {
        return this.contains(FIELD_PSDETREEVIEWNAME);
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
    public String getPSSysPDTViewId() {
        Object objValue = this.get(FIELD_PSSYSPDTVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspdtviewid")
    public void setPSSysPDTViewId(String pSSysPDTViewId) {
        this.set(FIELD_PSSYSPDTVIEWID, pSSysPDTViewId);
    }

    @JsonIgnore
    public boolean isPSSysPDTViewIdDirty() {
        return this.contains(FIELD_PSSYSPDTVIEWID);
    }

    @JsonIgnore
    public String getPSSysPDTViewName() {
        Object objValue = this.get(FIELD_PSSYSPDTVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspdtviewname")
    public void setPSSysPDTViewName(String pSSysPDTViewName) {
        this.set(FIELD_PSSYSPDTVIEWNAME, pSSysPDTViewName);
    }

    @JsonIgnore
    public boolean isPSSysPDTViewNameDirty() {
        return this.contains(FIELD_PSSYSPDTVIEWNAME);
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
        return this.getPSDEDRDetailId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDRDetailId(strValue);
    }
}

