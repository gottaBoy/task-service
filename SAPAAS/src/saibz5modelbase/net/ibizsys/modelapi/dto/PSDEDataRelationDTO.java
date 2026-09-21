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
import net.ibizsys.modelapi.dto.PSDEDRDetailDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEDataRelationDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DRTAG = "drtag";
    public static final String FIELD_DRTAG2 = "drtag2";
    public static final String FIELD_DRTAG3 = "drtag3";
    public static final String FIELD_DRTAG4 = "drtag4";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_FORMCAPPSLANRESID = "formcappslanresid";
    public static final String FIELD_FORMCAPPSLANRESNAME = "formcappslanresname";
    public static final String FIELD_FORMCAPTION = "formcaption";
    public static final String FIELD_FORMPSDEVIEWBASEID = "formpsdeviewbaseid";
    public static final String FIELD_FORMPSDEVIEWBASENAME = "formpsdeviewbasename";
    public static final String FIELD_FORMPSSYSIMAGEID = "formpssysimageid";
    public static final String FIELD_FORMPSSYSIMAGENAME = "formpssysimagename";
    public static final String FIELD_HIDEEDITITEM = "hideedititem";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEDATARELATIONID = "psdedatarelationid";
    public static final String FIELD_PSDEDATARELATIONNAME = "psdedatarelationname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDEDRDetailDTO> psdedrdetails;

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
    public String getDRTag() {
        Object objValue = this.get(FIELD_DRTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="drtag")
    public void setDRTag(String dRTag) {
        this.set(FIELD_DRTAG, dRTag);
    }

    @JsonIgnore
    public boolean isDRTagDirty() {
        return this.contains(FIELD_DRTAG);
    }

    @JsonIgnore
    public String getDRTag2() {
        Object objValue = this.get(FIELD_DRTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="drtag2")
    public void setDRTag2(String dRTag2) {
        this.set(FIELD_DRTAG2, dRTag2);
    }

    @JsonIgnore
    public boolean isDRTag2Dirty() {
        return this.contains(FIELD_DRTAG2);
    }

    @JsonIgnore
    public String getDRTag3() {
        Object objValue = this.get(FIELD_DRTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="drtag3")
    public void setDRTag3(String dRTag3) {
        this.set(FIELD_DRTAG3, dRTag3);
    }

    @JsonIgnore
    public boolean isDRTag3Dirty() {
        return this.contains(FIELD_DRTAG3);
    }

    @JsonIgnore
    public String getDRTag4() {
        Object objValue = this.get(FIELD_DRTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="drtag4")
    public void setDRTag4(String dRTag4) {
        this.set(FIELD_DRTAG4, dRTag4);
    }

    @JsonIgnore
    public boolean isDRTag4Dirty() {
        return this.contains(FIELD_DRTAG4);
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
    public String getFormCapPSLanResId() {
        Object objValue = this.get(FIELD_FORMCAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formcappslanresid")
    public void setFormCapPSLanResId(String formCapPSLanResId) {
        this.set(FIELD_FORMCAPPSLANRESID, formCapPSLanResId);
    }

    @JsonIgnore
    public boolean isFormCapPSLanResIdDirty() {
        return this.contains(FIELD_FORMCAPPSLANRESID);
    }

    @JsonIgnore
    public String getFormCapPSLanResName() {
        Object objValue = this.get(FIELD_FORMCAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formcappslanresname")
    public void setFormCapPSLanResName(String formCapPSLanResName) {
        this.set(FIELD_FORMCAPPSLANRESNAME, formCapPSLanResName);
    }

    @JsonIgnore
    public boolean isFormCapPSLanResNameDirty() {
        return this.contains(FIELD_FORMCAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getFormCaption() {
        Object objValue = this.get(FIELD_FORMCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formcaption")
    public void setFormCaption(String formCaption) {
        this.set(FIELD_FORMCAPTION, formCaption);
    }

    @JsonIgnore
    public boolean isFormCaptionDirty() {
        return this.contains(FIELD_FORMCAPTION);
    }

    @JsonIgnore
    public String getFormPSDEViewBaseId() {
        Object objValue = this.get(FIELD_FORMPSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formpsdeviewbaseid")
    public void setFormPSDEViewBaseId(String formPSDEViewBaseId) {
        this.set(FIELD_FORMPSDEVIEWBASEID, formPSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isFormPSDEViewBaseIdDirty() {
        return this.contains(FIELD_FORMPSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getFormPSDEViewBaseName() {
        Object objValue = this.get(FIELD_FORMPSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formpsdeviewbasename")
    public void setFormPSDEViewBaseName(String formPSDEViewBaseName) {
        this.set(FIELD_FORMPSDEVIEWBASENAME, formPSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isFormPSDEViewBaseNameDirty() {
        return this.contains(FIELD_FORMPSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getFormPSSysImageId() {
        Object objValue = this.get(FIELD_FORMPSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formpssysimageid")
    public void setFormPSSysImageId(String formPSSysImageId) {
        this.set(FIELD_FORMPSSYSIMAGEID, formPSSysImageId);
    }

    @JsonIgnore
    public boolean isFormPSSysImageIdDirty() {
        return this.contains(FIELD_FORMPSSYSIMAGEID);
    }

    @JsonIgnore
    public String getFormPSSysImageName() {
        Object objValue = this.get(FIELD_FORMPSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formpssysimagename")
    public void setFormPSSysImageName(String formPSSysImageName) {
        this.set(FIELD_FORMPSSYSIMAGENAME, formPSSysImageName);
    }

    @JsonIgnore
    public boolean isFormPSSysImageNameDirty() {
        return this.contains(FIELD_FORMPSSYSIMAGENAME);
    }

    @JsonIgnore
    public Integer getHideEditItem() {
        Object objValue = this.get(FIELD_HIDEEDITITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hideedititem")
    public void setHideEditItem(Integer hideEditItem) {
        this.set(FIELD_HIDEEDITITEM, hideEditItem);
    }

    @JsonIgnore
    public boolean isHideEditItemDirty() {
        return this.contains(FIELD_HIDEEDITITEM);
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
    public String getPSCtrlLogicGroupId() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupid")
    public void setPSCtrlLogicGroupId(String pSCtrlLogicGroupId) {
        this.set(FIELD_PSCTRLLOGICGROUPID, pSCtrlLogicGroupId);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupIdDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPID);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupName() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupname")
    public void setPSCtrlLogicGroupName(String pSCtrlLogicGroupName) {
        this.set(FIELD_PSCTRLLOGICGROUPNAME, pSCtrlLogicGroupName);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupNameDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPNAME);
    }

    @JsonIgnore
    public String getPSDEDataRelationId() {
        Object objValue = this.get(FIELD_PSDEDATARELATIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatarelationid")
    public void setPSDEDataRelationId(String pSDEDataRelationId) {
        this.set(FIELD_PSDEDATARELATIONID, pSDEDataRelationId);
    }

    @JsonIgnore
    public boolean isPSDEDataRelationIdDirty() {
        return this.contains(FIELD_PSDEDATARELATIONID);
    }

    @JsonIgnore
    public String getPSDEDataRelationName() {
        Object objValue = this.get(FIELD_PSDEDATARELATIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatarelationname")
    public void setPSDEDataRelationName(String pSDEDataRelationName) {
        this.set(FIELD_PSDEDATARELATIONNAME, pSDEDataRelationName);
    }

    @JsonIgnore
    public boolean isPSDEDataRelationNameDirty() {
        return this.contains(FIELD_PSDEDATARELATIONNAME);
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
    public String getPSSysCounterId() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscounterid")
    public void setPSSysCounterId(String pSSysCounterId) {
        this.set(FIELD_PSSYSCOUNTERID, pSSysCounterId);
    }

    @JsonIgnore
    public boolean isPSSysCounterIdDirty() {
        return this.contains(FIELD_PSSYSCOUNTERID);
    }

    @JsonIgnore
    public String getPSSysCounterName() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscountername")
    public void setPSSysCounterName(String pSSysCounterName) {
        this.set(FIELD_PSSYSCOUNTERNAME, pSSysCounterName);
    }

    @JsonIgnore
    public boolean isPSSysCounterNameDirty() {
        return this.contains(FIELD_PSSYSCOUNTERNAME);
    }

    @JsonIgnore
    public String getPSWFDEId() {
        Object objValue = this.get(FIELD_PSWFDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfdeid")
    public void setPSWFDEId(String pSWFDEId) {
        this.set(FIELD_PSWFDEID, pSWFDEId);
    }

    @JsonIgnore
    public boolean isPSWFDEIdDirty() {
        return this.contains(FIELD_PSWFDEID);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDataRelationId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDataRelationId(strValue);
    }

    @JsonProperty(value="psdedrdetails")
    public List<PSDEDRDetailDTO> getPsdedrdetails() {
        return this.psdedrdetails;
    }

    @JsonProperty(value="psdedrdetails")
    public void setPsdedrdetails(List<PSDEDRDetailDTO> psdedrdetails) {
        this.psdedrdetails = psdedrdetails;
    }
}

