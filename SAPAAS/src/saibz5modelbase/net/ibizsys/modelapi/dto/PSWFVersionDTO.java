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
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSWFVersionDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIVITIMODEL = "activitimodel";
    public static final String FIELD_BPMNMODEL = "bpmnmodel";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_DYNASYSREFMODE = "dynasysrefmode";
    public static final String FIELD_DYNAWFVER = "dynawfver";
    public static final String FIELD_ENABLE = "enable";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLELOG = "enablelog";
    public static final String FIELD_LASTBACKDATATAG = "lastbackdatatag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDYNAINSTNAME = "psdynainstname";
    public static final String FIELD_PSDYNAWFVERID = "psdynawfverid";
    public static final String FIELD_PSDYNAWFVERINSTID = "psdynawfverinstid";
    public static final String FIELD_PSDYNAWFVERINSTNAME = "psdynawfverinstname";
    public static final String FIELD_PSDYNAWFVERNAME = "psdynawfvername";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSWFMODEID = "pssyswfmodeid";
    public static final String FIELD_PSSYSWFMODENAME = "pssyswfmodename";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFNAME = "pswfname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VERTAG = "vertag";
    public static final String FIELD_VERTAG2 = "vertag2";
    public static final String FIELD_WFENGINETYPE = "wfenginetype";
    public static final String FIELD_WFMODE = "wfmode";
    public static final String FIELD_WFSTEPPSCODELISTID = "wfsteppscodelistid";
    public static final String FIELD_WFSTEPPSCODELISTNAME = "wfsteppscodelistname";
    public static final String FIELD_WFVERMODE = "wfvermode";
    public static final String FIELD_WFVERSION = "wfversion";
    private List<PSWFProcessDTO> pswfprocesses;
    private List<PSWFLinkDTO> pswflinks;
    private List<PSWFLinkCondDTO> pswflinkconds;

    @JsonIgnore
    public String getActivitiModel() {
        Object objValue = this.get(FIELD_ACTIVITIMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="activitimodel")
    public void setActivitiModel(String activitiModel) {
        this.set(FIELD_ACTIVITIMODEL, activitiModel);
    }

    @JsonIgnore
    public boolean isActivitiModelDirty() {
        return this.contains(FIELD_ACTIVITIMODEL);
    }

    @JsonIgnore
    public String getBPMNModel() {
        Object objValue = this.get(FIELD_BPMNMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bpmnmodel")
    public void setBPMNModel(String bPMNModel) {
        this.set(FIELD_BPMNMODEL, bPMNModel);
    }

    @JsonIgnore
    public boolean isBPMNModelDirty() {
        return this.contains(FIELD_BPMNMODEL);
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
    public Integer getDynaSysRefMode() {
        Object objValue = this.get(FIELD_DYNASYSREFMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynasysrefmode")
    public void setDynaSysRefMode(Integer dynaSysRefMode) {
        this.set(FIELD_DYNASYSREFMODE, dynaSysRefMode);
    }

    @JsonIgnore
    public boolean isDynaSysRefModeDirty() {
        return this.contains(FIELD_DYNASYSREFMODE);
    }

    @JsonIgnore
    public Integer getDynaWFVer() {
        Object objValue = this.get(FIELD_DYNAWFVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynawfver")
    public void setDynaWFVer(Integer dynaWFVer) {
        this.set(FIELD_DYNAWFVER, dynaWFVer);
    }

    @JsonIgnore
    public boolean isDynaWFVerDirty() {
        return this.contains(FIELD_DYNAWFVER);
    }

    @JsonIgnore
    public Integer getEnable() {
        Object objValue = this.get(FIELD_ENABLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enable")
    public void setEnable(Integer enable) {
        this.set(FIELD_ENABLE, enable);
    }

    @JsonIgnore
    public boolean isEnableDirty() {
        return this.contains(FIELD_ENABLE);
    }

    @JsonIgnore
    public Integer getEnableDynaSys() {
        Object objValue = this.get(FIELD_ENABLEDYNASYS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledynasys")
    public void setEnableDynaSys(Integer enableDynaSys) {
        this.set(FIELD_ENABLEDYNASYS, enableDynaSys);
    }

    @JsonIgnore
    public boolean isEnableDynaSysDirty() {
        return this.contains(FIELD_ENABLEDYNASYS);
    }

    @JsonIgnore
    public Integer getEnableLog() {
        Object objValue = this.get(FIELD_ENABLELOG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablelog")
    public void setEnableLog(Integer enableLog) {
        this.set(FIELD_ENABLELOG, enableLog);
    }

    @JsonIgnore
    public boolean isEnableLogDirty() {
        return this.contains(FIELD_ENABLELOG);
    }

    @JsonIgnore
    public String getLastBackDataTag() {
        Object objValue = this.get(FIELD_LASTBACKDATATAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lastbackdatatag")
    public void setLastBackDataTag(String lastBackDataTag) {
        this.set(FIELD_LASTBACKDATATAG, lastBackDataTag);
    }

    @JsonIgnore
    public boolean isLastBackDataTagDirty() {
        return this.contains(FIELD_LASTBACKDATATAG);
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
    public String getPSDynaInstName() {
        Object objValue = this.get(FIELD_PSDYNAINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynainstname")
    public void setPSDynaInstName(String pSDynaInstName) {
        this.set(FIELD_PSDYNAINSTNAME, pSDynaInstName);
    }

    @JsonIgnore
    public boolean isPSDynaInstNameDirty() {
        return this.contains(FIELD_PSDYNAINSTNAME);
    }

    @JsonIgnore
    public String getPSDynaWFVerId() {
        Object objValue = this.get(FIELD_PSDYNAWFVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynawfverid")
    public void setPSDynaWFVerId(String pSDynaWFVerId) {
        this.set(FIELD_PSDYNAWFVERID, pSDynaWFVerId);
    }

    @JsonIgnore
    public boolean isPSDynaWFVerIdDirty() {
        return this.contains(FIELD_PSDYNAWFVERID);
    }

    @JsonIgnore
    public String getPSDynaWFVerInstId() {
        Object objValue = this.get(FIELD_PSDYNAWFVERINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynawfverinstid")
    public void setPSDynaWFVerInstId(String pSDynaWFVerInstId) {
        this.set(FIELD_PSDYNAWFVERINSTID, pSDynaWFVerInstId);
    }

    @JsonIgnore
    public boolean isPSDynaWFVerInstIdDirty() {
        return this.contains(FIELD_PSDYNAWFVERINSTID);
    }

    @JsonIgnore
    public String getPSDynaWFVerInstName() {
        Object objValue = this.get(FIELD_PSDYNAWFVERINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynawfverinstname")
    public void setPSDynaWFVerInstName(String pSDynaWFVerInstName) {
        this.set(FIELD_PSDYNAWFVERINSTNAME, pSDynaWFVerInstName);
    }

    @JsonIgnore
    public boolean isPSDynaWFVerInstNameDirty() {
        return this.contains(FIELD_PSDYNAWFVERINSTNAME);
    }

    @JsonIgnore
    public String getPSDynaWFVerName() {
        Object objValue = this.get(FIELD_PSDYNAWFVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynawfvername")
    public void setPSDynaWFVerName(String pSDynaWFVerName) {
        this.set(FIELD_PSDYNAWFVERNAME, pSDynaWFVerName);
    }

    @JsonIgnore
    public boolean isPSDynaWFVerNameDirty() {
        return this.contains(FIELD_PSDYNAWFVERNAME);
    }

    @JsonIgnore
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public String getPSSysWFModeId() {
        Object objValue = this.get(FIELD_PSSYSWFMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfmodeid")
    public void setPSSysWFModeId(String pSSysWFModeId) {
        this.set(FIELD_PSSYSWFMODEID, pSSysWFModeId);
    }

    @JsonIgnore
    public boolean isPSSysWFModeIdDirty() {
        return this.contains(FIELD_PSSYSWFMODEID);
    }

    @JsonIgnore
    public String getPSSysWFModeName() {
        Object objValue = this.get(FIELD_PSSYSWFMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfmodename")
    public void setPSSysWFModeName(String pSSysWFModeName) {
        this.set(FIELD_PSSYSWFMODENAME, pSSysWFModeName);
    }

    @JsonIgnore
    public boolean isPSSysWFModeNameDirty() {
        return this.contains(FIELD_PSSYSWFMODENAME);
    }

    @JsonIgnore
    public String getPSWFId() {
        Object objValue = this.get(FIELD_PSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfid")
    public void setPSWFId(String pSWFId) {
        this.set(FIELD_PSWFID, pSWFId);
    }

    @JsonIgnore
    public boolean isPSWFIdDirty() {
        return this.contains(FIELD_PSWFID);
    }

    @JsonIgnore
    public String getPSWFName() {
        Object objValue = this.get(FIELD_PSWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfname")
    public void setPSWFName(String pSWFName) {
        this.set(FIELD_PSWFNAME, pSWFName);
    }

    @JsonIgnore
    public boolean isPSWFNameDirty() {
        return this.contains(FIELD_PSWFNAME);
    }

    @JsonIgnore
    public String getPSWFVersionId() {
        Object objValue = this.get(FIELD_PSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionid")
    public void setPSWFVersionId(String pSWFVersionId) {
        this.set(FIELD_PSWFVERSIONID, pSWFVersionId);
    }

    @JsonIgnore
    public boolean isPSWFVersionIdDirty() {
        return this.contains(FIELD_PSWFVERSIONID);
    }

    @JsonIgnore
    public String getPSWFVersionName() {
        Object objValue = this.get(FIELD_PSWFVERSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionname")
    public void setPSWFVersionName(String pSWFVersionName) {
        this.set(FIELD_PSWFVERSIONNAME, pSWFVersionName);
    }

    @JsonIgnore
    public boolean isPSWFVersionNameDirty() {
        return this.contains(FIELD_PSWFVERSIONNAME);
    }

    @JsonIgnore
    public Integer getRemoveFlag() {
        Object objValue = this.get(FIELD_REMOVEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeflag")
    public void setRemoveFlag(Integer removeFlag) {
        this.set(FIELD_REMOVEFLAG, removeFlag);
    }

    @JsonIgnore
    public boolean isRemoveFlagDirty() {
        return this.contains(FIELD_REMOVEFLAG);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
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
    public String getVerTag() {
        Object objValue = this.get(FIELD_VERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vertag")
    public void setVerTag(String verTag) {
        this.set(FIELD_VERTAG, verTag);
    }

    @JsonIgnore
    public boolean isVerTagDirty() {
        return this.contains(FIELD_VERTAG);
    }

    @JsonIgnore
    public String getVerTag2() {
        Object objValue = this.get(FIELD_VERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vertag2")
    public void setVerTag2(String verTag2) {
        this.set(FIELD_VERTAG2, verTag2);
    }

    @JsonIgnore
    public boolean isVerTag2Dirty() {
        return this.contains(FIELD_VERTAG2);
    }

    @JsonIgnore
    public String getWFEngineType() {
        Object objValue = this.get(FIELD_WFENGINETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfenginetype")
    public void setWFEngineType(String wFEngineType) {
        this.set(FIELD_WFENGINETYPE, wFEngineType);
    }

    @JsonIgnore
    public boolean isWFEngineTypeDirty() {
        return this.contains(FIELD_WFENGINETYPE);
    }

    @JsonIgnore
    public String getWFMode() {
        Object objValue = this.get(FIELD_WFMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfmode")
    public void setWFMode(String wFMode) {
        this.set(FIELD_WFMODE, wFMode);
    }

    @JsonIgnore
    public boolean isWFModeDirty() {
        return this.contains(FIELD_WFMODE);
    }

    @JsonIgnore
    public String getWFStepPSCodeListId() {
        Object objValue = this.get(FIELD_WFSTEPPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfsteppscodelistid")
    public void setWFStepPSCodeListId(String wFStepPSCodeListId) {
        this.set(FIELD_WFSTEPPSCODELISTID, wFStepPSCodeListId);
    }

    @JsonIgnore
    public boolean isWFStepPSCodeListIdDirty() {
        return this.contains(FIELD_WFSTEPPSCODELISTID);
    }

    @JsonIgnore
    public String getWFStepPSCodeListName() {
        Object objValue = this.get(FIELD_WFSTEPPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfsteppscodelistname")
    public void setWFStepPSCodeListName(String wFStepPSCodeListName) {
        this.set(FIELD_WFSTEPPSCODELISTNAME, wFStepPSCodeListName);
    }

    @JsonIgnore
    public boolean isWFStepPSCodeListNameDirty() {
        return this.contains(FIELD_WFSTEPPSCODELISTNAME);
    }

    @JsonIgnore
    public String getWFVerMode() {
        Object objValue = this.get(FIELD_WFVERMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfvermode")
    public void setWFVerMode(String wFVerMode) {
        this.set(FIELD_WFVERMODE, wFVerMode);
    }

    @JsonIgnore
    public boolean isWFVerModeDirty() {
        return this.contains(FIELD_WFVERMODE);
    }

    @JsonIgnore
    public Integer getWFVersion() {
        Object objValue = this.get(FIELD_WFVERSION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfversion")
    public void setWFVersion(Integer wFVersion) {
        this.set(FIELD_WFVERSION, wFVersion);
    }

    @JsonIgnore
    public boolean isWFVersionDirty() {
        return this.contains(FIELD_WFVERSION);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFVersionId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWFVersionId(strValue);
    }

    @JsonProperty(value="pswfprocesses")
    public List<PSWFProcessDTO> getPswfprocesses() {
        return this.pswfprocesses;
    }

    @JsonProperty(value="pswfprocesses")
    public void setPswfprocesses(List<PSWFProcessDTO> pswfprocesses) {
        this.pswfprocesses = pswfprocesses;
    }

    @JsonProperty(value="pswflinks")
    public List<PSWFLinkDTO> getPswflinks() {
        return this.pswflinks;
    }

    @JsonProperty(value="pswflinks")
    public void setPswflinks(List<PSWFLinkDTO> pswflinks) {
        this.pswflinks = pswflinks;
    }

    @JsonProperty(value="pswflinkconds")
    public List<PSWFLinkCondDTO> getPswflinkconds() {
        return this.pswflinkconds;
    }

    @JsonProperty(value="pswflinkconds")
    public void setPswflinkconds(List<PSWFLinkCondDTO> pswflinkconds) {
        this.pswflinkconds = pswflinkconds;
    }
}

