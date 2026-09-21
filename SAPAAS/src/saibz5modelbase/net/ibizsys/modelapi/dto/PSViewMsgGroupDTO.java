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
import java.util.List;
import net.ibizsys.modelapi.dto.PSViewMsgGrpDetailDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSViewMsgGroupDTO
extends PSModelDTOBase {
    public static final String FIELD_BODYMSGPSSYSCSSID = "bodymsgpssyscssid";
    public static final String FIELD_BODYMSGPSSYSCSSNAME = "bodymsgpssyscssname";
    public static final String FIELD_BODYMSGSTYLE = "bodymsgstyle";
    public static final String FIELD_BOTTOMMSGPSSYSCSSID = "bottommsgpssyscssid";
    public static final String FIELD_BOTTOMMSGPSSYSCSSNAME = "bottommsgpssyscssname";
    public static final String FIELD_BOTTOMMSGSTYLE = "bottommsgstyle";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMICMODE = "dynamicmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSVIEWMSGGROUPID = "psviewmsggroupid";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "psviewmsggroupname";
    public static final String FIELD_TOPMSGPSSYSCSSID = "topmsgpssyscssid";
    public static final String FIELD_TOPMSGPSSYSCSSNAME = "topmsgpssyscssname";
    public static final String FIELD_TOPMSGSTYLE = "topmsgstyle";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSViewMsgGrpDetailDTO> psviewmsggrpdetails;

    @JsonIgnore
    public String getBodyMsgPSSysCssId() {
        Object objValue = this.get(FIELD_BODYMSGPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bodymsgpssyscssid")
    public void setBodyMsgPSSysCssId(String bodyMsgPSSysCssId) {
        this.set(FIELD_BODYMSGPSSYSCSSID, bodyMsgPSSysCssId);
    }

    @JsonIgnore
    public boolean isBodyMsgPSSysCssIdDirty() {
        return this.contains(FIELD_BODYMSGPSSYSCSSID);
    }

    @JsonIgnore
    public String getBodyMsgPSSysCssName() {
        Object objValue = this.get(FIELD_BODYMSGPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bodymsgpssyscssname")
    public void setBodyMsgPSSysCssName(String bodyMsgPSSysCssName) {
        this.set(FIELD_BODYMSGPSSYSCSSNAME, bodyMsgPSSysCssName);
    }

    @JsonIgnore
    public boolean isBodyMsgPSSysCssNameDirty() {
        return this.contains(FIELD_BODYMSGPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getBodyMsgStyle() {
        Object objValue = this.get(FIELD_BODYMSGSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bodymsgstyle")
    public void setBodyMsgStyle(String bodyMsgStyle) {
        this.set(FIELD_BODYMSGSTYLE, bodyMsgStyle);
    }

    @JsonIgnore
    public boolean isBodyMsgStyleDirty() {
        return this.contains(FIELD_BODYMSGSTYLE);
    }

    @JsonIgnore
    public String getBottomMsgPSSysCssId() {
        Object objValue = this.get(FIELD_BOTTOMMSGPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottommsgpssyscssid")
    public void setBottomMsgPSSysCssId(String bottomMsgPSSysCssId) {
        this.set(FIELD_BOTTOMMSGPSSYSCSSID, bottomMsgPSSysCssId);
    }

    @JsonIgnore
    public boolean isBottomMsgPSSysCssIdDirty() {
        return this.contains(FIELD_BOTTOMMSGPSSYSCSSID);
    }

    @JsonIgnore
    public String getBottomMsgPSSysCssName() {
        Object objValue = this.get(FIELD_BOTTOMMSGPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottommsgpssyscssname")
    public void setBottomMsgPSSysCssName(String bottomMsgPSSysCssName) {
        this.set(FIELD_BOTTOMMSGPSSYSCSSNAME, bottomMsgPSSysCssName);
    }

    @JsonIgnore
    public boolean isBottomMsgPSSysCssNameDirty() {
        return this.contains(FIELD_BOTTOMMSGPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getBottomMsgStyle() {
        Object objValue = this.get(FIELD_BOTTOMMSGSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottommsgstyle")
    public void setBottomMsgStyle(String bottomMsgStyle) {
        this.set(FIELD_BOTTOMMSGSTYLE, bottomMsgStyle);
    }

    @JsonIgnore
    public boolean isBottomMsgStyleDirty() {
        return this.contains(FIELD_BOTTOMMSGSTYLE);
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
    public Integer getDynamicMode() {
        Object objValue = this.get(FIELD_DYNAMICMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamicmode")
    public void setDynamicMode(Integer dynamicMode) {
        this.set(FIELD_DYNAMICMODE, dynamicMode);
    }

    @JsonIgnore
    public boolean isDynamicModeDirty() {
        return this.contains(FIELD_DYNAMICMODE);
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
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
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
    public String getPSViewMsgGroupId() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupid")
    public void setPSViewMsgGroupId(String pSViewMsgGroupId) {
        this.set(FIELD_PSVIEWMSGGROUPID, pSViewMsgGroupId);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupIdDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPID);
    }

    @JsonIgnore
    public String getPSViewMsgGroupName() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupname")
    public void setPSViewMsgGroupName(String pSViewMsgGroupName) {
        this.set(FIELD_PSVIEWMSGGROUPNAME, pSViewMsgGroupName);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupNameDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPNAME);
    }

    @JsonIgnore
    public String getTopMsgPSSysCssId() {
        Object objValue = this.get(FIELD_TOPMSGPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topmsgpssyscssid")
    public void setTopMsgPSSysCssId(String topMsgPSSysCssId) {
        this.set(FIELD_TOPMSGPSSYSCSSID, topMsgPSSysCssId);
    }

    @JsonIgnore
    public boolean isTopMsgPSSysCssIdDirty() {
        return this.contains(FIELD_TOPMSGPSSYSCSSID);
    }

    @JsonIgnore
    public String getTopMsgPSSysCssName() {
        Object objValue = this.get(FIELD_TOPMSGPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topmsgpssyscssname")
    public void setTopMsgPSSysCssName(String topMsgPSSysCssName) {
        this.set(FIELD_TOPMSGPSSYSCSSNAME, topMsgPSSysCssName);
    }

    @JsonIgnore
    public boolean isTopMsgPSSysCssNameDirty() {
        return this.contains(FIELD_TOPMSGPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getTopMsgStyle() {
        Object objValue = this.get(FIELD_TOPMSGSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topmsgstyle")
    public void setTopMsgStyle(String topMsgStyle) {
        this.set(FIELD_TOPMSGSTYLE, topMsgStyle);
    }

    @JsonIgnore
    public boolean isTopMsgStyleDirty() {
        return this.contains(FIELD_TOPMSGSTYLE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSViewMsgGroupId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSViewMsgGroupId(strValue);
    }

    @JsonProperty(value="psviewmsggrpdetails")
    public List<PSViewMsgGrpDetailDTO> getPsviewmsggrpdetails() {
        return this.psviewmsggrpdetails;
    }

    @JsonProperty(value="psviewmsggrpdetails")
    public void setPsviewmsggrpdetails(List<PSViewMsgGrpDetailDTO> psviewmsggrpdetails) {
        this.psviewmsggrpdetails = psviewmsggrpdetails;
    }
}

