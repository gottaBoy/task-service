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

public class PSDEUAGroupDetailDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONLEVEL = "actionlevel";
    public static final String FIELD_ADDSEPARATOR = "addseparator";
    public static final String FIELD_AFTERCONTENT = "aftercontent";
    public static final String FIELD_AFTERITEMTYPE = "afteritemtype";
    public static final String FIELD_AFTERPSSYSCSSID = "afterpssyscssid";
    public static final String FIELD_AFTERPSSYSCSSNAME = "afterpssyscssname";
    public static final String FIELD_AFTERPSSYSRESOURCEID = "afterpssysresourceid";
    public static final String FIELD_AFTERPSSYSRESOURCENAME = "afterpssysresourcename";
    public static final String FIELD_BEFORECONTENT = "beforecontent";
    public static final String FIELD_BEFOREITEMTYPE = "beforeitemtype";
    public static final String FIELD_BEFOREPSSYSCSSID = "beforepssyscssid";
    public static final String FIELD_BEFOREPSSYSCSSNAME = "beforepssyscssname";
    public static final String FIELD_BEFOREPSSYSRESOURCEID = "beforepssysresourceid";
    public static final String FIELD_BEFOREPSSYSRESOURCENAME = "beforepssysresourcename";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DETAILTAG = "detailtag";
    public static final String FIELD_DETAILTAG2 = "detailtag2";
    public static final String FIELD_DETAILTYPE = "detailtype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEUAGRPDETAILID = "psdeuagrpdetailid";
    public static final String FIELD_PSDEUAGRPDETAILNAME = "psdeuagrpdetailname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_SHOWMODE = "showmode";
    public static final String FIELD_UACAPTION = "uacaption";
    public static final String FIELD_UIACTIONPARAMS = "uiactionparams";
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
    public Integer getActionLevel() {
        Object objValue = this.get(FIELD_ACTIONLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionlevel")
    public void setActionLevel(Integer actionLevel) {
        this.set(FIELD_ACTIONLEVEL, actionLevel);
    }

    @JsonIgnore
    public boolean isActionLevelDirty() {
        return this.contains(FIELD_ACTIONLEVEL);
    }

    @JsonIgnore
    public Integer getAddSeparator() {
        Object objValue = this.get(FIELD_ADDSEPARATOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="addseparator")
    public void setAddSeparator(Integer addSeparator) {
        this.set(FIELD_ADDSEPARATOR, addSeparator);
    }

    @JsonIgnore
    public boolean isAddSeparatorDirty() {
        return this.contains(FIELD_ADDSEPARATOR);
    }

    @JsonIgnore
    public String getAfterContent() {
        Object objValue = this.get(FIELD_AFTERCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aftercontent")
    public void setAfterContent(String afterContent) {
        this.set(FIELD_AFTERCONTENT, afterContent);
    }

    @JsonIgnore
    public boolean isAfterContentDirty() {
        return this.contains(FIELD_AFTERCONTENT);
    }

    @JsonIgnore
    public String getAfterItemType() {
        Object objValue = this.get(FIELD_AFTERITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="afteritemtype")
    public void setAfterItemType(String afterItemType) {
        this.set(FIELD_AFTERITEMTYPE, afterItemType);
    }

    @JsonIgnore
    public boolean isAfterItemTypeDirty() {
        return this.contains(FIELD_AFTERITEMTYPE);
    }

    @JsonIgnore
    public String getAfterPSSysCssId() {
        Object objValue = this.get(FIELD_AFTERPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="afterpssyscssid")
    public void setAfterPSSysCssId(String afterPSSysCssId) {
        this.set(FIELD_AFTERPSSYSCSSID, afterPSSysCssId);
    }

    @JsonIgnore
    public boolean isAfterPSSysCssIdDirty() {
        return this.contains(FIELD_AFTERPSSYSCSSID);
    }

    @JsonIgnore
    public String getAfterPSSysCssName() {
        Object objValue = this.get(FIELD_AFTERPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="afterpssyscssname")
    public void setAfterPSSysCssName(String afterPSSysCssName) {
        this.set(FIELD_AFTERPSSYSCSSNAME, afterPSSysCssName);
    }

    @JsonIgnore
    public boolean isAfterPSSysCssNameDirty() {
        return this.contains(FIELD_AFTERPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getAfterPSSysResourceId() {
        Object objValue = this.get(FIELD_AFTERPSSYSRESOURCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="afterpssysresourceid")
    public void setAfterPSSysResourceId(String afterPSSysResourceId) {
        this.set(FIELD_AFTERPSSYSRESOURCEID, afterPSSysResourceId);
    }

    @JsonIgnore
    public boolean isAfterPSSysResourceIdDirty() {
        return this.contains(FIELD_AFTERPSSYSRESOURCEID);
    }

    @JsonIgnore
    public String getAfterPSSysResourceName() {
        Object objValue = this.get(FIELD_AFTERPSSYSRESOURCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="afterpssysresourcename")
    public void setAfterPSSysResourceName(String afterPSSysResourceName) {
        this.set(FIELD_AFTERPSSYSRESOURCENAME, afterPSSysResourceName);
    }

    @JsonIgnore
    public boolean isAfterPSSysResourceNameDirty() {
        return this.contains(FIELD_AFTERPSSYSRESOURCENAME);
    }

    @JsonIgnore
    public String getBeforeContent() {
        Object objValue = this.get(FIELD_BEFORECONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforecontent")
    public void setBeforeContent(String beforeContent) {
        this.set(FIELD_BEFORECONTENT, beforeContent);
    }

    @JsonIgnore
    public boolean isBeforeContentDirty() {
        return this.contains(FIELD_BEFORECONTENT);
    }

    @JsonIgnore
    public String getBeforeItemType() {
        Object objValue = this.get(FIELD_BEFOREITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforeitemtype")
    public void setBeforeItemType(String beforeItemType) {
        this.set(FIELD_BEFOREITEMTYPE, beforeItemType);
    }

    @JsonIgnore
    public boolean isBeforeItemTypeDirty() {
        return this.contains(FIELD_BEFOREITEMTYPE);
    }

    @JsonIgnore
    public String getBeforePSSysCssId() {
        Object objValue = this.get(FIELD_BEFOREPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforepssyscssid")
    public void setBeforePSSysCssId(String beforePSSysCssId) {
        this.set(FIELD_BEFOREPSSYSCSSID, beforePSSysCssId);
    }

    @JsonIgnore
    public boolean isBeforePSSysCssIdDirty() {
        return this.contains(FIELD_BEFOREPSSYSCSSID);
    }

    @JsonIgnore
    public String getBeforePSSysCssName() {
        Object objValue = this.get(FIELD_BEFOREPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforepssyscssname")
    public void setBeforePSSysCssName(String beforePSSysCssName) {
        this.set(FIELD_BEFOREPSSYSCSSNAME, beforePSSysCssName);
    }

    @JsonIgnore
    public boolean isBeforePSSysCssNameDirty() {
        return this.contains(FIELD_BEFOREPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getBeforePSSysResourceId() {
        Object objValue = this.get(FIELD_BEFOREPSSYSRESOURCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforepssysresourceid")
    public void setBeforePSSysResourceId(String beforePSSysResourceId) {
        this.set(FIELD_BEFOREPSSYSRESOURCEID, beforePSSysResourceId);
    }

    @JsonIgnore
    public boolean isBeforePSSysResourceIdDirty() {
        return this.contains(FIELD_BEFOREPSSYSRESOURCEID);
    }

    @JsonIgnore
    public String getBeforePSSysResourceName() {
        Object objValue = this.get(FIELD_BEFOREPSSYSRESOURCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforepssysresourcename")
    public void setBeforePSSysResourceName(String beforePSSysResourceName) {
        this.set(FIELD_BEFOREPSSYSRESOURCENAME, beforePSSysResourceName);
    }

    @JsonIgnore
    public boolean isBeforePSSysResourceNameDirty() {
        return this.contains(FIELD_BEFOREPSSYSRESOURCENAME);
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
    public String getDetailTag() {
        Object objValue = this.get(FIELD_DETAILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag")
    public void setDetailTag(String detailTag) {
        this.set(FIELD_DETAILTAG, detailTag);
    }

    @JsonIgnore
    public boolean isDetailTagDirty() {
        return this.contains(FIELD_DETAILTAG);
    }

    @JsonIgnore
    public String getDetailTag2() {
        Object objValue = this.get(FIELD_DETAILTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag2")
    public void setDetailTag2(String detailTag2) {
        this.set(FIELD_DETAILTAG2, detailTag2);
    }

    @JsonIgnore
    public boolean isDetailTag2Dirty() {
        return this.contains(FIELD_DETAILTAG2);
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
    public String getPSDEUAGroupId() {
        Object objValue = this.get(FIELD_PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupid")
    public void setPSDEUAGroupId(String pSDEUAGroupId) {
        this.set(FIELD_PSDEUAGROUPID, pSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupIdDirty() {
        return this.contains(FIELD_PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getPSDEUAGroupName() {
        Object objValue = this.get(FIELD_PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupname")
    public void setPSDEUAGroupName(String pSDEUAGroupName) {
        this.set(FIELD_PSDEUAGROUPNAME, pSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupNameDirty() {
        return this.contains(FIELD_PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getPSDEUAGRPDetailId() {
        Object objValue = this.get(FIELD_PSDEUAGRPDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagrpdetailid")
    public void setPSDEUAGRPDetailId(String pSDEUAGRPDetailId) {
        this.set(FIELD_PSDEUAGRPDETAILID, pSDEUAGRPDetailId);
    }

    @JsonIgnore
    public boolean isPSDEUAGRPDetailIdDirty() {
        return this.contains(FIELD_PSDEUAGRPDETAILID);
    }

    @JsonIgnore
    public String getPSDEUAGRPDetailName() {
        Object objValue = this.get(FIELD_PSDEUAGRPDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagrpdetailname")
    public void setPSDEUAGRPDetailName(String pSDEUAGRPDetailName) {
        this.set(FIELD_PSDEUAGRPDETAILNAME, pSDEUAGRPDetailName);
    }

    @JsonIgnore
    public boolean isPSDEUAGRPDetailNameDirty() {
        return this.contains(FIELD_PSDEUAGRPDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEUIActionId() {
        Object objValue = this.get(FIELD_PSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionid")
    public void setPSDEUIActionId(String pSDEUIActionId) {
        this.set(FIELD_PSDEUIACTIONID, pSDEUIActionId);
    }

    @JsonIgnore
    public boolean isPSDEUIActionIdDirty() {
        return this.contains(FIELD_PSDEUIACTIONID);
    }

    @JsonIgnore
    public String getPSDEUIActionName() {
        Object objValue = this.get(FIELD_PSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionname")
    public void setPSDEUIActionName(String pSDEUIActionName) {
        this.set(FIELD_PSDEUIACTIONNAME, pSDEUIActionName);
    }

    @JsonIgnore
    public boolean isPSDEUIActionNameDirty() {
        return this.contains(FIELD_PSDEUIACTIONNAME);
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
    public String getShowMode() {
        Object objValue = this.get(FIELD_SHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="showmode")
    public void setShowMode(String showMode) {
        this.set(FIELD_SHOWMODE, showMode);
    }

    @JsonIgnore
    public boolean isShowModeDirty() {
        return this.contains(FIELD_SHOWMODE);
    }

    @JsonIgnore
    public String getUACaption() {
        Object objValue = this.get(FIELD_UACAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uacaption")
    public void setUACaption(String uACaption) {
        this.set(FIELD_UACAPTION, uACaption);
    }

    @JsonIgnore
    public boolean isUACaptionDirty() {
        return this.contains(FIELD_UACAPTION);
    }

    @JsonIgnore
    public String getUIActionParams() {
        Object objValue = this.get(FIELD_UIACTIONPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uiactionparams")
    public void setUIActionParams(String uIActionParams) {
        this.set(FIELD_UIACTIONPARAMS, uIActionParams);
    }

    @JsonIgnore
    public boolean isUIActionParamsDirty() {
        return this.contains(FIELD_UIACTIONPARAMS);
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
        return this.getPSDEUAGRPDetailId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEUAGRPDetailId(strValue);
    }
}

