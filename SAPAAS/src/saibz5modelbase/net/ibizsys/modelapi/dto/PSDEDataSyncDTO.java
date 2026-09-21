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

public class PSDEDataSyncDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DENAMES = "denames";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EVENTTYPE = "eventtype";
    public static final String FIELD_EXPORTFULL = "exportfull";
    public static final String FIELD_IMPORTPSDEACTIONID = "importpsdeactionid";
    public static final String FIELD_IMPORTPSDEACTIONNAME = "importpsdeactionname";
    public static final String FIELD_INCUSTOMCODE = "incustomcode";
    public static final String FIELD_INCUSTOMMODE = "incustommode";
    public static final String FIELD_INPSDEACTIONID = "inpsdeactionid";
    public static final String FIELD_INPSDEACTIONNAME = "inpsdeactionname";
    public static final String FIELD_INPSDEDATASETID = "inpsdedatasetid";
    public static final String FIELD_INPSDEDATASETNAME = "inpsdedatasetname";
    public static final String FIELD_INPSSYSDATASYNCAGENTID = "inpssysdatasyncagentid";
    public static final String FIELD_INPSSYSDATASYNCAGENTNAME = "inpssysdatasyncagentname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_OUTCUSTOMCODE = "outcustomcode";
    public static final String FIELD_OUTCUSTOMMODE = "outcustommode";
    public static final String FIELD_OUTMODE = "outmode";
    public static final String FIELD_OUTPSDEACTIONID = "outpsdeactionid";
    public static final String FIELD_OUTPSDEACTIONNAME = "outpsdeactionname";
    public static final String FIELD_OUTPSDEDATASETID = "outpsdedatasetid";
    public static final String FIELD_OUTPSDEDATASETNAME = "outpsdedatasetname";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTID = "outpssysdatasyncagentid";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTNAME = "outpssysdatasyncagentname";
    public static final String FIELD_OUTTIMER = "outtimer";
    public static final String FIELD_PSDEDATASYNCID = "psdedatasyncid";
    public static final String FIELD_PSDEDATASYNCNAME = "psdedatasyncname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_SYNCDIR = "syncdir";
    public static final String FIELD_SYNCEXPORT = "syncexport";
    public static final String FIELD_TIMERMODE = "timermode";
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
    public String getDENames() {
        Object objValue = this.get(FIELD_DENAMES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="denames")
    public void setDENames(String dENames) {
        this.set(FIELD_DENAMES, dENames);
    }

    @JsonIgnore
    public boolean isDENamesDirty() {
        return this.contains(FIELD_DENAMES);
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
    public Integer getEventType() {
        Object objValue = this.get(FIELD_EVENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="eventtype")
    public void setEventType(Integer eventType) {
        this.set(FIELD_EVENTTYPE, eventType);
    }

    @JsonIgnore
    public boolean isEventTypeDirty() {
        return this.contains(FIELD_EVENTTYPE);
    }

    @JsonIgnore
    public Integer getExportFull() {
        Object objValue = this.get(FIELD_EXPORTFULL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportfull")
    public void setExportFull(Integer exportFull) {
        this.set(FIELD_EXPORTFULL, exportFull);
    }

    @JsonIgnore
    public boolean isExportFullDirty() {
        return this.contains(FIELD_EXPORTFULL);
    }

    @JsonIgnore
    public String getImportPSDEActionId() {
        Object objValue = this.get(FIELD_IMPORTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="importpsdeactionid")
    public void setImportPSDEActionId(String importPSDEActionId) {
        this.set(FIELD_IMPORTPSDEACTIONID, importPSDEActionId);
    }

    @JsonIgnore
    public boolean isImportPSDEActionIdDirty() {
        return this.contains(FIELD_IMPORTPSDEACTIONID);
    }

    @JsonIgnore
    public String getImportPSDEActionName() {
        Object objValue = this.get(FIELD_IMPORTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="importpsdeactionname")
    public void setImportPSDEActionName(String importPSDEActionName) {
        this.set(FIELD_IMPORTPSDEACTIONNAME, importPSDEActionName);
    }

    @JsonIgnore
    public boolean isImportPSDEActionNameDirty() {
        return this.contains(FIELD_IMPORTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getInCustomCode() {
        Object objValue = this.get(FIELD_INCUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="incustomcode")
    public void setInCustomCode(String inCustomCode) {
        this.set(FIELD_INCUSTOMCODE, inCustomCode);
    }

    @JsonIgnore
    public boolean isInCustomCodeDirty() {
        return this.contains(FIELD_INCUSTOMCODE);
    }

    @JsonIgnore
    public Integer getInCustomMode() {
        Object objValue = this.get(FIELD_INCUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incustommode")
    public void setInCustomMode(Integer inCustomMode) {
        this.set(FIELD_INCUSTOMMODE, inCustomMode);
    }

    @JsonIgnore
    public boolean isInCustomModeDirty() {
        return this.contains(FIELD_INCUSTOMMODE);
    }

    @JsonIgnore
    public String getInPSDEActionId() {
        Object objValue = this.get(FIELD_INPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdeactionid")
    public void setInPSDEActionId(String inPSDEActionId) {
        this.set(FIELD_INPSDEACTIONID, inPSDEActionId);
    }

    @JsonIgnore
    public boolean isInPSDEActionIdDirty() {
        return this.contains(FIELD_INPSDEACTIONID);
    }

    @JsonIgnore
    public String getInPSDEActionName() {
        Object objValue = this.get(FIELD_INPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdeactionname")
    public void setInPSDEActionName(String inPSDEActionName) {
        this.set(FIELD_INPSDEACTIONNAME, inPSDEActionName);
    }

    @JsonIgnore
    public boolean isInPSDEActionNameDirty() {
        return this.contains(FIELD_INPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getInPSDEDataSetId() {
        Object objValue = this.get(FIELD_INPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdedatasetid")
    public void setInPSDEDataSetId(String inPSDEDataSetId) {
        this.set(FIELD_INPSDEDATASETID, inPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isInPSDEDataSetIdDirty() {
        return this.contains(FIELD_INPSDEDATASETID);
    }

    @JsonIgnore
    public String getInPSDEDataSetName() {
        Object objValue = this.get(FIELD_INPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdedatasetname")
    public void setInPSDEDataSetName(String inPSDEDataSetName) {
        this.set(FIELD_INPSDEDATASETNAME, inPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isInPSDEDataSetNameDirty() {
        return this.contains(FIELD_INPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getInPSSysDataSyncAgentId() {
        Object objValue = this.get(FIELD_INPSSYSDATASYNCAGENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssysdatasyncagentid")
    public void setInPSSysDataSyncAgentId(String inPSSysDataSyncAgentId) {
        this.set(FIELD_INPSSYSDATASYNCAGENTID, inPSSysDataSyncAgentId);
    }

    @JsonIgnore
    public boolean isInPSSysDataSyncAgentIdDirty() {
        return this.contains(FIELD_INPSSYSDATASYNCAGENTID);
    }

    @JsonIgnore
    public String getInPSSysDataSyncAgentName() {
        Object objValue = this.get(FIELD_INPSSYSDATASYNCAGENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssysdatasyncagentname")
    public void setInPSSysDataSyncAgentName(String inPSSysDataSyncAgentName) {
        this.set(FIELD_INPSSYSDATASYNCAGENTNAME, inPSSysDataSyncAgentName);
    }

    @JsonIgnore
    public boolean isInPSSysDataSyncAgentNameDirty() {
        return this.contains(FIELD_INPSSYSDATASYNCAGENTNAME);
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
    public String getOutCustomCode() {
        Object objValue = this.get(FIELD_OUTCUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outcustomcode")
    public void setOutCustomCode(String outCustomCode) {
        this.set(FIELD_OUTCUSTOMCODE, outCustomCode);
    }

    @JsonIgnore
    public boolean isOutCustomCodeDirty() {
        return this.contains(FIELD_OUTCUSTOMCODE);
    }

    @JsonIgnore
    public Integer getOutCustomMode() {
        Object objValue = this.get(FIELD_OUTCUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="outcustommode")
    public void setOutCustomMode(Integer outCustomMode) {
        this.set(FIELD_OUTCUSTOMMODE, outCustomMode);
    }

    @JsonIgnore
    public boolean isOutCustomModeDirty() {
        return this.contains(FIELD_OUTCUSTOMMODE);
    }

    @JsonIgnore
    public Integer getOutMode() {
        Object objValue = this.get(FIELD_OUTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="outmode")
    public void setOutMode(Integer outMode) {
        this.set(FIELD_OUTMODE, outMode);
    }

    @JsonIgnore
    public boolean isOutModeDirty() {
        return this.contains(FIELD_OUTMODE);
    }

    @JsonIgnore
    public String getOutPSDEActionId() {
        Object objValue = this.get(FIELD_OUTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdeactionid")
    public void setOutPSDEActionId(String outPSDEActionId) {
        this.set(FIELD_OUTPSDEACTIONID, outPSDEActionId);
    }

    @JsonIgnore
    public boolean isOutPSDEActionIdDirty() {
        return this.contains(FIELD_OUTPSDEACTIONID);
    }

    @JsonIgnore
    public String getOutPSDEActionName() {
        Object objValue = this.get(FIELD_OUTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdeactionname")
    public void setOutPSDEActionName(String outPSDEActionName) {
        this.set(FIELD_OUTPSDEACTIONNAME, outPSDEActionName);
    }

    @JsonIgnore
    public boolean isOutPSDEActionNameDirty() {
        return this.contains(FIELD_OUTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getOutPSDEDataSetId() {
        Object objValue = this.get(FIELD_OUTPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdedatasetid")
    public void setOutPSDEDataSetId(String outPSDEDataSetId) {
        this.set(FIELD_OUTPSDEDATASETID, outPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isOutPSDEDataSetIdDirty() {
        return this.contains(FIELD_OUTPSDEDATASETID);
    }

    @JsonIgnore
    public String getOutPSDEDataSetName() {
        Object objValue = this.get(FIELD_OUTPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdedatasetname")
    public void setOutPSDEDataSetName(String outPSDEDataSetName) {
        this.set(FIELD_OUTPSDEDATASETNAME, outPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isOutPSDEDataSetNameDirty() {
        return this.contains(FIELD_OUTPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getOutPSSysDataSyncAgentId() {
        Object objValue = this.get(FIELD_OUTPSSYSDATASYNCAGENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssysdatasyncagentid")
    public void setOutPSSysDataSyncAgentId(String outPSSysDataSyncAgentId) {
        this.set(FIELD_OUTPSSYSDATASYNCAGENTID, outPSSysDataSyncAgentId);
    }

    @JsonIgnore
    public boolean isOutPSSysDataSyncAgentIdDirty() {
        return this.contains(FIELD_OUTPSSYSDATASYNCAGENTID);
    }

    @JsonIgnore
    public String getOutPSSysDataSyncAgentName() {
        Object objValue = this.get(FIELD_OUTPSSYSDATASYNCAGENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssysdatasyncagentname")
    public void setOutPSSysDataSyncAgentName(String outPSSysDataSyncAgentName) {
        this.set(FIELD_OUTPSSYSDATASYNCAGENTNAME, outPSSysDataSyncAgentName);
    }

    @JsonIgnore
    public boolean isOutPSSysDataSyncAgentNameDirty() {
        return this.contains(FIELD_OUTPSSYSDATASYNCAGENTNAME);
    }

    @JsonIgnore
    public Integer getOutTimer() {
        Object objValue = this.get(FIELD_OUTTIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="outtimer")
    public void setOutTimer(Integer outTimer) {
        this.set(FIELD_OUTTIMER, outTimer);
    }

    @JsonIgnore
    public boolean isOutTimerDirty() {
        return this.contains(FIELD_OUTTIMER);
    }

    @JsonIgnore
    public String getPSDEDataSyncId() {
        Object objValue = this.get(FIELD_PSDEDATASYNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasyncid")
    public void setPSDEDataSyncId(String pSDEDataSyncId) {
        this.set(FIELD_PSDEDATASYNCID, pSDEDataSyncId);
    }

    @JsonIgnore
    public boolean isPSDEDataSyncIdDirty() {
        return this.contains(FIELD_PSDEDATASYNCID);
    }

    @JsonIgnore
    public String getPSDEDataSyncName() {
        Object objValue = this.get(FIELD_PSDEDATASYNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasyncname")
    public void setPSDEDataSyncName(String pSDEDataSyncName) {
        this.set(FIELD_PSDEDATASYNCNAME, pSDEDataSyncName);
    }

    @JsonIgnore
    public boolean isPSDEDataSyncNameDirty() {
        return this.contains(FIELD_PSDEDATASYNCNAME);
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
    public String getSyncDir() {
        Object objValue = this.get(FIELD_SYNCDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="syncdir")
    public void setSyncDir(String syncDir) {
        this.set(FIELD_SYNCDIR, syncDir);
    }

    @JsonIgnore
    public boolean isSyncDirDirty() {
        return this.contains(FIELD_SYNCDIR);
    }

    @JsonIgnore
    public Integer getSyncExport() {
        Object objValue = this.get(FIELD_SYNCEXPORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="syncexport")
    public void setSyncExport(Integer syncExport) {
        this.set(FIELD_SYNCEXPORT, syncExport);
    }

    @JsonIgnore
    public boolean isSyncExportDirty() {
        return this.contains(FIELD_SYNCEXPORT);
    }

    @JsonIgnore
    public Integer getTimerMode() {
        Object objValue = this.get(FIELD_TIMERMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="timermode")
    public void setTimerMode(Integer timerMode) {
        this.set(FIELD_TIMERMODE, timerMode);
    }

    @JsonIgnore
    public boolean isTimerModeDirty() {
        return this.contains(FIELD_TIMERMODE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDataSyncId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDataSyncId(strValue);
    }
}

