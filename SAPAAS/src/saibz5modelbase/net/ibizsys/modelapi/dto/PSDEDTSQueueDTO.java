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

public class PSDEDTSQueueDTO
extends PSModelDTOBase {
    public static final String FIELD_CANCELLEDSTATE = "cancelledstate";
    public static final String FIELD_CANCELLEDSTATETEXT = "cancelledstatetext";
    public static final String FIELD_CANCELPSDEACTIONID = "cancelpsdeactionid";
    public static final String FIELD_CANCELPSDEACTIONNAME = "cancelpsdeactionname";
    public static final String FIELD_CANCELTIMEOUT = "canceltimeout";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEDSTATE = "createdstate";
    public static final String FIELD_CREATEDSTATETEXT = "createdstatetext";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_ERRORPSDEFID = "errorpsdefid";
    public static final String FIELD_ERRORPSDEFNAME = "errorpsdefname";
    public static final String FIELD_FAILEDSTATE = "failedstate";
    public static final String FIELD_FAILEDSTATETEXT = "failedstatetext";
    public static final String FIELD_FINISHEDSTATE = "finishedstate";
    public static final String FIELD_FINISHEDSTATETEXT = "finishedstatetext";
    public static final String FIELD_FINISHPSDEACTIONID = "finishpsdeactionid";
    public static final String FIELD_FINISHPSDEACTIONNAME = "finishpsdeactionname";
    public static final String FIELD_HISTORYPSDEID = "historypsdeid";
    public static final String FIELD_HISTORYPSDENAME = "historypsdename";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PROCESSINGSTATE = "processingstate";
    public static final String FIELD_PROCESSINGSTATETEXT = "processingstatetext";
    public static final String FIELD_PSDEDTSQUEUEID = "psdedtsqueueid";
    public static final String FIELD_PSDEDTSQUEUENAME = "psdedtsqueuename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUSHPSDEACTIONID = "pushpsdeactionid";
    public static final String FIELD_PUSHPSDEACTIONNAME = "pushpsdeactionname";
    public static final String FIELD_QUEUEPARAMS = "queueparams";
    public static final String FIELD_REFRESHPSDEACTIONID = "refreshpsdeactionid";
    public static final String FIELD_REFRESHPSDEACTIONNAME = "refreshpsdeactionname";
    public static final String FIELD_REFRESHTIMER = "refreshtimer";
    public static final String FIELD_STATEPSDEFID = "statepsdefid";
    public static final String FIELD_STATEPSDEFNAME = "statepsdefname";
    public static final String FIELD_TIMEPSDEFID = "timepsdefid";
    public static final String FIELD_TIMEPSDEFNAME = "timepsdefname";
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
    public String getCancelledState() {
        Object objValue = this.get(FIELD_CANCELLEDSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cancelledstate")
    public void setCancelledState(String cancelledState) {
        this.set(FIELD_CANCELLEDSTATE, cancelledState);
    }

    @JsonIgnore
    public boolean isCancelledStateDirty() {
        return this.contains(FIELD_CANCELLEDSTATE);
    }

    @JsonIgnore
    public String getCancelledStateText() {
        Object objValue = this.get(FIELD_CANCELLEDSTATETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cancelledstatetext")
    public void setCancelledStateText(String cancelledStateText) {
        this.set(FIELD_CANCELLEDSTATETEXT, cancelledStateText);
    }

    @JsonIgnore
    public boolean isCancelledStateTextDirty() {
        return this.contains(FIELD_CANCELLEDSTATETEXT);
    }

    @JsonIgnore
    public String getCancelPSDEActionId() {
        Object objValue = this.get(FIELD_CANCELPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cancelpsdeactionid")
    public void setCancelPSDEActionId(String cancelPSDEActionId) {
        this.set(FIELD_CANCELPSDEACTIONID, cancelPSDEActionId);
    }

    @JsonIgnore
    public boolean isCancelPSDEActionIdDirty() {
        return this.contains(FIELD_CANCELPSDEACTIONID);
    }

    @JsonIgnore
    public String getCancelPSDEActionName() {
        Object objValue = this.get(FIELD_CANCELPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cancelpsdeactionname")
    public void setCancelPSDEActionName(String cancelPSDEActionName) {
        this.set(FIELD_CANCELPSDEACTIONNAME, cancelPSDEActionName);
    }

    @JsonIgnore
    public boolean isCancelPSDEActionNameDirty() {
        return this.contains(FIELD_CANCELPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getCancelTimeout() {
        Object objValue = this.get(FIELD_CANCELTIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="canceltimeout")
    public void setCancelTimeout(Integer cancelTimeout) {
        this.set(FIELD_CANCELTIMEOUT, cancelTimeout);
    }

    @JsonIgnore
    public boolean isCancelTimeoutDirty() {
        return this.contains(FIELD_CANCELTIMEOUT);
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
    public String getCreatedState() {
        Object objValue = this.get(FIELD_CREATEDSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdstate")
    public void setCreatedState(String createdState) {
        this.set(FIELD_CREATEDSTATE, createdState);
    }

    @JsonIgnore
    public boolean isCreatedStateDirty() {
        return this.contains(FIELD_CREATEDSTATE);
    }

    @JsonIgnore
    public String getCreatedStateText() {
        Object objValue = this.get(FIELD_CREATEDSTATETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdstatetext")
    public void setCreatedStateText(String createdStateText) {
        this.set(FIELD_CREATEDSTATETEXT, createdStateText);
    }

    @JsonIgnore
    public boolean isCreatedStateTextDirty() {
        return this.contains(FIELD_CREATEDSTATETEXT);
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
    public String getErrorPSDEFId() {
        Object objValue = this.get(FIELD_ERRORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errorpsdefid")
    public void setErrorPSDEFId(String errorPSDEFId) {
        this.set(FIELD_ERRORPSDEFID, errorPSDEFId);
    }

    @JsonIgnore
    public boolean isErrorPSDEFIdDirty() {
        return this.contains(FIELD_ERRORPSDEFID);
    }

    @JsonIgnore
    public String getErrorPSDEFName() {
        Object objValue = this.get(FIELD_ERRORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errorpsdefname")
    public void setErrorPSDEFName(String errorPSDEFName) {
        this.set(FIELD_ERRORPSDEFNAME, errorPSDEFName);
    }

    @JsonIgnore
    public boolean isErrorPSDEFNameDirty() {
        return this.contains(FIELD_ERRORPSDEFNAME);
    }

    @JsonIgnore
    public String getFailedState() {
        Object objValue = this.get(FIELD_FAILEDSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="failedstate")
    public void setFailedState(String failedState) {
        this.set(FIELD_FAILEDSTATE, failedState);
    }

    @JsonIgnore
    public boolean isFailedStateDirty() {
        return this.contains(FIELD_FAILEDSTATE);
    }

    @JsonIgnore
    public String getFailedStateText() {
        Object objValue = this.get(FIELD_FAILEDSTATETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="failedstatetext")
    public void setFailedStateText(String failedStateText) {
        this.set(FIELD_FAILEDSTATETEXT, failedStateText);
    }

    @JsonIgnore
    public boolean isFailedStateTextDirty() {
        return this.contains(FIELD_FAILEDSTATETEXT);
    }

    @JsonIgnore
    public String getFinishedState() {
        Object objValue = this.get(FIELD_FINISHEDSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishedstate")
    public void setFinishedState(String finishedState) {
        this.set(FIELD_FINISHEDSTATE, finishedState);
    }

    @JsonIgnore
    public boolean isFinishedStateDirty() {
        return this.contains(FIELD_FINISHEDSTATE);
    }

    @JsonIgnore
    public String getFinishedStateText() {
        Object objValue = this.get(FIELD_FINISHEDSTATETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishedstatetext")
    public void setFinishedStateText(String finishedStateText) {
        this.set(FIELD_FINISHEDSTATETEXT, finishedStateText);
    }

    @JsonIgnore
    public boolean isFinishedStateTextDirty() {
        return this.contains(FIELD_FINISHEDSTATETEXT);
    }

    @JsonIgnore
    public String getFinishPSDEActionId() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionid")
    public void setFinishPSDEActionId(String finishPSDEActionId) {
        this.set(FIELD_FINISHPSDEACTIONID, finishPSDEActionId);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionIdDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONID);
    }

    @JsonIgnore
    public String getFinishPSDEActionName() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionname")
    public void setFinishPSDEActionName(String finishPSDEActionName) {
        this.set(FIELD_FINISHPSDEACTIONNAME, finishPSDEActionName);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionNameDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getHistoryPSDEId() {
        Object objValue = this.get(FIELD_HISTORYPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="historypsdeid")
    public void setHistoryPSDEId(String historyPSDEId) {
        this.set(FIELD_HISTORYPSDEID, historyPSDEId);
    }

    @JsonIgnore
    public boolean isHistoryPSDEIdDirty() {
        return this.contains(FIELD_HISTORYPSDEID);
    }

    @JsonIgnore
    public String getHistoryPSDEName() {
        Object objValue = this.get(FIELD_HISTORYPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="historypsdename")
    public void setHistoryPSDEName(String historyPSDEName) {
        this.set(FIELD_HISTORYPSDENAME, historyPSDEName);
    }

    @JsonIgnore
    public boolean isHistoryPSDENameDirty() {
        return this.contains(FIELD_HISTORYPSDENAME);
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
    public String getProcessingState() {
        Object objValue = this.get(FIELD_PROCESSINGSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="processingstate")
    public void setProcessingState(String processingState) {
        this.set(FIELD_PROCESSINGSTATE, processingState);
    }

    @JsonIgnore
    public boolean isProcessingStateDirty() {
        return this.contains(FIELD_PROCESSINGSTATE);
    }

    @JsonIgnore
    public String getProcessingStateText() {
        Object objValue = this.get(FIELD_PROCESSINGSTATETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="processingstatetext")
    public void setProcessingStateText(String processingStateText) {
        this.set(FIELD_PROCESSINGSTATETEXT, processingStateText);
    }

    @JsonIgnore
    public boolean isProcessingStateTextDirty() {
        return this.contains(FIELD_PROCESSINGSTATETEXT);
    }

    @JsonIgnore
    public String getPSDEDTSQueueId() {
        Object objValue = this.get(FIELD_PSDEDTSQUEUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedtsqueueid")
    public void setPSDEDTSQueueId(String pSDEDTSQueueId) {
        this.set(FIELD_PSDEDTSQUEUEID, pSDEDTSQueueId);
    }

    @JsonIgnore
    public boolean isPSDEDTSQueueIdDirty() {
        return this.contains(FIELD_PSDEDTSQUEUEID);
    }

    @JsonIgnore
    public String getPSDEDTSQueueName() {
        Object objValue = this.get(FIELD_PSDEDTSQUEUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedtsqueuename")
    public void setPSDEDTSQueueName(String pSDEDTSQueueName) {
        this.set(FIELD_PSDEDTSQUEUENAME, pSDEDTSQueueName);
    }

    @JsonIgnore
    public boolean isPSDEDTSQueueNameDirty() {
        return this.contains(FIELD_PSDEDTSQUEUENAME);
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
    public String getPushPSDEActionId() {
        Object objValue = this.get(FIELD_PUSHPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pushpsdeactionid")
    public void setPushPSDEActionId(String pushPSDEActionId) {
        this.set(FIELD_PUSHPSDEACTIONID, pushPSDEActionId);
    }

    @JsonIgnore
    public boolean isPushPSDEActionIdDirty() {
        return this.contains(FIELD_PUSHPSDEACTIONID);
    }

    @JsonIgnore
    public String getPushPSDEActionName() {
        Object objValue = this.get(FIELD_PUSHPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pushpsdeactionname")
    public void setPushPSDEActionName(String pushPSDEActionName) {
        this.set(FIELD_PUSHPSDEACTIONNAME, pushPSDEActionName);
    }

    @JsonIgnore
    public boolean isPushPSDEActionNameDirty() {
        return this.contains(FIELD_PUSHPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getQueueParams() {
        Object objValue = this.get(FIELD_QUEUEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="queueparams")
    public void setQueueParams(String queueParams) {
        this.set(FIELD_QUEUEPARAMS, queueParams);
    }

    @JsonIgnore
    public boolean isQueueParamsDirty() {
        return this.contains(FIELD_QUEUEPARAMS);
    }

    @JsonIgnore
    public String getRefreshPSDEActionId() {
        Object objValue = this.get(FIELD_REFRESHPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refreshpsdeactionid")
    public void setRefreshPSDEActionId(String refreshPSDEActionId) {
        this.set(FIELD_REFRESHPSDEACTIONID, refreshPSDEActionId);
    }

    @JsonIgnore
    public boolean isRefreshPSDEActionIdDirty() {
        return this.contains(FIELD_REFRESHPSDEACTIONID);
    }

    @JsonIgnore
    public String getRefreshPSDEActionName() {
        Object objValue = this.get(FIELD_REFRESHPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refreshpsdeactionname")
    public void setRefreshPSDEActionName(String refreshPSDEActionName) {
        this.set(FIELD_REFRESHPSDEACTIONNAME, refreshPSDEActionName);
    }

    @JsonIgnore
    public boolean isRefreshPSDEActionNameDirty() {
        return this.contains(FIELD_REFRESHPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getRefreshTimer() {
        Object objValue = this.get(FIELD_REFRESHTIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="refreshtimer")
    public void setRefreshTimer(Integer refreshTimer) {
        this.set(FIELD_REFRESHTIMER, refreshTimer);
    }

    @JsonIgnore
    public boolean isRefreshTimerDirty() {
        return this.contains(FIELD_REFRESHTIMER);
    }

    @JsonIgnore
    public String getStatePSDEFId() {
        Object objValue = this.get(FIELD_STATEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statepsdefid")
    public void setStatePSDEFId(String statePSDEFId) {
        this.set(FIELD_STATEPSDEFID, statePSDEFId);
    }

    @JsonIgnore
    public boolean isStatePSDEFIdDirty() {
        return this.contains(FIELD_STATEPSDEFID);
    }

    @JsonIgnore
    public String getStatePSDEFName() {
        Object objValue = this.get(FIELD_STATEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statepsdefname")
    public void setStatePSDEFName(String statePSDEFName) {
        this.set(FIELD_STATEPSDEFNAME, statePSDEFName);
    }

    @JsonIgnore
    public boolean isStatePSDEFNameDirty() {
        return this.contains(FIELD_STATEPSDEFNAME);
    }

    @JsonIgnore
    public String getTimePSDEFId() {
        Object objValue = this.get(FIELD_TIMEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timepsdefid")
    public void setTimePSDEFId(String timePSDEFId) {
        this.set(FIELD_TIMEPSDEFID, timePSDEFId);
    }

    @JsonIgnore
    public boolean isTimePSDEFIdDirty() {
        return this.contains(FIELD_TIMEPSDEFID);
    }

    @JsonIgnore
    public String getTimePSDEFName() {
        Object objValue = this.get(FIELD_TIMEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timepsdefname")
    public void setTimePSDEFName(String timePSDEFName) {
        this.set(FIELD_TIMEPSDEFNAME, timePSDEFName);
    }

    @JsonIgnore
    public boolean isTimePSDEFNameDirty() {
        return this.contains(FIELD_TIMEPSDEFNAME);
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
        return this.getPSDEDTSQueueId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDTSQueueId(strValue);
    }
}

