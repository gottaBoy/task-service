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
import net.ibizsys.modelapi.dto.PSDELogicLinkDTO;
import net.ibizsys.modelapi.dto.PSDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDELogicDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DEBUGMODE = "debugmode";
    public static final String FIELD_DEFAULTMSLOGIC = "defaultmslogic";
    public static final String FIELD_DEFLOGICMODE = "deflogicmode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FINISHFLAG = "finishflag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICHOLDER = "logicholder";
    public static final String FIELD_LOGICSN = "logicsn";
    public static final String FIELD_LOGICSUBTYPE = "logicsubtype";
    public static final String FIELD_LOGICTAG = "logictag";
    public static final String FIELD_LOGICTAG2 = "logictag2";
    public static final String FIELD_LOGICTAG3 = "logictag3";
    public static final String FIELD_LOGICTAG4 = "logictag4";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTASKID = "pssystaskid";
    public static final String FIELD_PSSYSTASKNAME = "pssystaskname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDELogicLinkDTO> psdelogiclinks;
    private List<PSDELogicNodeDTO> psdelogicnodes;
    private List<PSDELogicParamDTO> psdelogicparams;

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
    public String getCustomCode() {
        Object objValue = this.get(FIELD_CUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcode")
    public void setCustomCode(String customCode) {
        this.set(FIELD_CUSTOMCODE, customCode);
    }

    @JsonIgnore
    public boolean isCustomCodeDirty() {
        return this.contains(FIELD_CUSTOMCODE);
    }

    @JsonIgnore
    public Integer getCustomMode() {
        Object objValue = this.get(FIELD_CUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="custommode")
    public void setCustomMode(Integer customMode) {
        this.set(FIELD_CUSTOMMODE, customMode);
    }

    @JsonIgnore
    public boolean isCustomModeDirty() {
        return this.contains(FIELD_CUSTOMMODE);
    }

    @JsonIgnore
    public Integer getDebugMode() {
        Object objValue = this.get(FIELD_DEBUGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="debugmode")
    public void setDebugMode(Integer debugMode) {
        this.set(FIELD_DEBUGMODE, debugMode);
    }

    @JsonIgnore
    public boolean isDebugModeDirty() {
        return this.contains(FIELD_DEBUGMODE);
    }

    @JsonIgnore
    public Integer getDefaultMSLogic() {
        Object objValue = this.get(FIELD_DEFAULTMSLOGIC);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultmslogic")
    public void setDefaultMSLogic(Integer defaultMSLogic) {
        this.set(FIELD_DEFAULTMSLOGIC, defaultMSLogic);
    }

    @JsonIgnore
    public boolean isDefaultMSLogicDirty() {
        return this.contains(FIELD_DEFAULTMSLOGIC);
    }

    @JsonIgnore
    public String getDEFLogicMode() {
        Object objValue = this.get(FIELD_DEFLOGICMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deflogicmode")
    public void setDEFLogicMode(String dEFLogicMode) {
        this.set(FIELD_DEFLOGICMODE, dEFLogicMode);
    }

    @JsonIgnore
    public boolean isDEFLogicModeDirty() {
        return this.contains(FIELD_DEFLOGICMODE);
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
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
    }

    @JsonIgnore
    public Integer getFinishFlag() {
        Object objValue = this.get(FIELD_FINISHFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="finishflag")
    public void setFinishFlag(Integer finishFlag) {
        this.set(FIELD_FINISHFLAG, finishFlag);
    }

    @JsonIgnore
    public boolean isFinishFlagDirty() {
        return this.contains(FIELD_FINISHFLAG);
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
    public Integer getLogicHolder() {
        Object objValue = this.get(FIELD_LOGICHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="logicholder")
    public void setLogicHolder(Integer logicHolder) {
        this.set(FIELD_LOGICHOLDER, logicHolder);
    }

    @JsonIgnore
    public boolean isLogicHolderDirty() {
        return this.contains(FIELD_LOGICHOLDER);
    }

    @JsonIgnore
    public String getLogicSN() {
        Object objValue = this.get(FIELD_LOGICSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicsn")
    public void setLogicSN(String logicSN) {
        this.set(FIELD_LOGICSN, logicSN);
    }

    @JsonIgnore
    public boolean isLogicSNDirty() {
        return this.contains(FIELD_LOGICSN);
    }

    @JsonIgnore
    public String getLogicSubType() {
        Object objValue = this.get(FIELD_LOGICSUBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicsubtype")
    public void setLogicSubType(String logicSubType) {
        this.set(FIELD_LOGICSUBTYPE, logicSubType);
    }

    @JsonIgnore
    public boolean isLogicSubTypeDirty() {
        return this.contains(FIELD_LOGICSUBTYPE);
    }

    @JsonIgnore
    public String getLogicTag() {
        Object objValue = this.get(FIELD_LOGICTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictag")
    public void setLogicTag(String logicTag) {
        this.set(FIELD_LOGICTAG, logicTag);
    }

    @JsonIgnore
    public boolean isLogicTagDirty() {
        return this.contains(FIELD_LOGICTAG);
    }

    @JsonIgnore
    public String getLogicTag2() {
        Object objValue = this.get(FIELD_LOGICTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictag2")
    public void setLogicTag2(String logicTag2) {
        this.set(FIELD_LOGICTAG2, logicTag2);
    }

    @JsonIgnore
    public boolean isLogicTag2Dirty() {
        return this.contains(FIELD_LOGICTAG2);
    }

    @JsonIgnore
    public String getLogicTag3() {
        Object objValue = this.get(FIELD_LOGICTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictag3")
    public void setLogicTag3(String logicTag3) {
        this.set(FIELD_LOGICTAG3, logicTag3);
    }

    @JsonIgnore
    public boolean isLogicTag3Dirty() {
        return this.contains(FIELD_LOGICTAG3);
    }

    @JsonIgnore
    public String getLogicTag4() {
        Object objValue = this.get(FIELD_LOGICTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictag4")
    public void setLogicTag4(String logicTag4) {
        this.set(FIELD_LOGICTAG4, logicTag4);
    }

    @JsonIgnore
    public boolean isLogicTag4Dirty() {
        return this.contains(FIELD_LOGICTAG4);
    }

    @JsonIgnore
    public String getLogicType() {
        Object objValue = this.get(FIELD_LOGICTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictype")
    public void setLogicType(String logicType) {
        this.set(FIELD_LOGICTYPE, logicType);
    }

    @JsonIgnore
    public boolean isLogicTypeDirty() {
        return this.contains(FIELD_LOGICTYPE);
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
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
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
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
    }

    @JsonIgnore
    public String getPSSysTaskId() {
        Object objValue = this.get(FIELD_PSSYSTASKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystaskid")
    public void setPSSysTaskId(String pSSysTaskId) {
        this.set(FIELD_PSSYSTASKID, pSSysTaskId);
    }

    @JsonIgnore
    public boolean isPSSysTaskIdDirty() {
        return this.contains(FIELD_PSSYSTASKID);
    }

    @JsonIgnore
    public String getPSSysTaskName() {
        Object objValue = this.get(FIELD_PSSYSTASKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystaskname")
    public void setPSSysTaskName(String pSSysTaskName) {
        this.set(FIELD_PSSYSTASKNAME, pSSysTaskName);
    }

    @JsonIgnore
    public boolean isPSSysTaskNameDirty() {
        return this.contains(FIELD_PSSYSTASKNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDELogicId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDELogicId(strValue);
    }

    @JsonProperty(value="psdelogiclinks")
    public List<PSDELogicLinkDTO> getPsdelogiclinks() {
        return this.psdelogiclinks;
    }

    @JsonProperty(value="psdelogiclinks")
    public void setPsdelogiclinks(List<PSDELogicLinkDTO> psdelogiclinks) {
        this.psdelogiclinks = psdelogiclinks;
    }

    @JsonProperty(value="psdelogicnodes")
    public List<PSDELogicNodeDTO> getPsdelogicnodes() {
        return this.psdelogicnodes;
    }

    @JsonProperty(value="psdelogicnodes")
    public void setPsdelogicnodes(List<PSDELogicNodeDTO> psdelogicnodes) {
        this.psdelogicnodes = psdelogicnodes;
    }

    @JsonProperty(value="psdelogicparams")
    public List<PSDELogicParamDTO> getPsdelogicparams() {
        return this.psdelogicparams;
    }

    @JsonProperty(value="psdelogicparams")
    public void setPsdelogicparams(List<PSDELogicParamDTO> psdelogicparams) {
        this.psdelogicparams = psdelogicparams;
    }
}

