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
import net.ibizsys.modelapi.dto.PSDENotifyTargetDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDENotifyDTO
extends PSModelDTOBase {
    public static final String FIELD_ATTACHMENTTYPE = "attachmenttype";
    public static final String FIELD_BEGINPSDEFID = "beginpsdefid";
    public static final String FIELD_BEGINPSDEFNAME = "beginpsdefname";
    public static final String FIELD_CHECKTIMER = "checktimer";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_ENDPSDEFID = "endpsdefid";
    public static final String FIELD_ENDPSDEFNAME = "endpsdefname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MSGTYPE = "msgtype";
    public static final String FIELD_NOTIFYEND = "notifyend";
    public static final String FIELD_NOTIFYSTART = "notifystart";
    public static final String FIELD_NOTIFYTAG = "notifytag";
    public static final String FIELD_NOTIFYTAG2 = "notifytag2";
    public static final String FIELD_PROPERTYMAP = "propertymap";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDENOTIFYID = "psdenotifyid";
    public static final String FIELD_PSDENOTIFYNAME = "psdenotifyname";
    public static final String FIELD_PSDEPRINTID = "psdeprintid";
    public static final String FIELD_PSDEPRINTNAME = "psdeprintname";
    public static final String FIELD_PSDEREPORTID = "psdereportid";
    public static final String FIELD_PSDEREPORTNAME = "psdereportname";
    public static final String FIELD_PSSYSMSGQUEUEID = "pssysmsgqueueid";
    public static final String FIELD_PSSYSMSGQUEUENAME = "pssysmsgqueuename";
    public static final String FIELD_PSSYSMSGTEMPLID = "pssysmsgtemplid";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "pssysmsgtemplname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_TASKMODE = "taskmode";
    public static final String FIELD_TIMERMODE = "timermode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDENotifyTargetDTO> psdenotifytargets;

    @JsonIgnore
    public String getAttachmentType() {
        Object objValue = this.get(FIELD_ATTACHMENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attachmenttype")
    public void setAttachmentType(String attachmentType) {
        this.set(FIELD_ATTACHMENTTYPE, attachmentType);
    }

    @JsonIgnore
    public boolean isAttachmentTypeDirty() {
        return this.contains(FIELD_ATTACHMENTTYPE);
    }

    @JsonIgnore
    public String getBeginPSDEFId() {
        Object objValue = this.get(FIELD_BEGINPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginpsdefid")
    public void setBeginPSDEFId(String beginPSDEFId) {
        this.set(FIELD_BEGINPSDEFID, beginPSDEFId);
    }

    @JsonIgnore
    public boolean isBeginPSDEFIdDirty() {
        return this.contains(FIELD_BEGINPSDEFID);
    }

    @JsonIgnore
    public String getBeginPSDEFName() {
        Object objValue = this.get(FIELD_BEGINPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginpsdefname")
    public void setBeginPSDEFName(String beginPSDEFName) {
        this.set(FIELD_BEGINPSDEFNAME, beginPSDEFName);
    }

    @JsonIgnore
    public boolean isBeginPSDEFNameDirty() {
        return this.contains(FIELD_BEGINPSDEFNAME);
    }

    @JsonIgnore
    public Integer getCheckTimer() {
        Object objValue = this.get(FIELD_CHECKTIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checktimer")
    public void setCheckTimer(Integer checkTimer) {
        this.set(FIELD_CHECKTIMER, checkTimer);
    }

    @JsonIgnore
    public boolean isCheckTimerDirty() {
        return this.contains(FIELD_CHECKTIMER);
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
    public String getCustomCond() {
        Object objValue = this.get(FIELD_CUSTOMCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcond")
    public void setCustomCond(String customCond) {
        this.set(FIELD_CUSTOMCOND, customCond);
    }

    @JsonIgnore
    public boolean isCustomCondDirty() {
        return this.contains(FIELD_CUSTOMCOND);
    }

    @JsonIgnore
    public String getEndPSDEFId() {
        Object objValue = this.get(FIELD_ENDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endpsdefid")
    public void setEndPSDEFId(String endPSDEFId) {
        this.set(FIELD_ENDPSDEFID, endPSDEFId);
    }

    @JsonIgnore
    public boolean isEndPSDEFIdDirty() {
        return this.contains(FIELD_ENDPSDEFID);
    }

    @JsonIgnore
    public String getEndPSDEFName() {
        Object objValue = this.get(FIELD_ENDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endpsdefname")
    public void setEndPSDEFName(String endPSDEFName) {
        this.set(FIELD_ENDPSDEFNAME, endPSDEFName);
    }

    @JsonIgnore
    public boolean isEndPSDEFNameDirty() {
        return this.contains(FIELD_ENDPSDEFNAME);
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
    public Integer getMsgType() {
        Object objValue = this.get(FIELD_MSGTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="msgtype")
    public void setMsgType(Integer msgType) {
        this.set(FIELD_MSGTYPE, msgType);
    }

    @JsonIgnore
    public boolean isMsgTypeDirty() {
        return this.contains(FIELD_MSGTYPE);
    }

    @JsonIgnore
    public Integer getNotifyEnd() {
        Object objValue = this.get(FIELD_NOTIFYEND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="notifyend")
    public void setNotifyEnd(Integer notifyEnd) {
        this.set(FIELD_NOTIFYEND, notifyEnd);
    }

    @JsonIgnore
    public boolean isNotifyEndDirty() {
        return this.contains(FIELD_NOTIFYEND);
    }

    @JsonIgnore
    public Integer getNotifyStart() {
        Object objValue = this.get(FIELD_NOTIFYSTART);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="notifystart")
    public void setNotifyStart(Integer notifyStart) {
        this.set(FIELD_NOTIFYSTART, notifyStart);
    }

    @JsonIgnore
    public boolean isNotifyStartDirty() {
        return this.contains(FIELD_NOTIFYSTART);
    }

    @JsonIgnore
    public String getNotifyTag() {
        Object objValue = this.get(FIELD_NOTIFYTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="notifytag")
    public void setNotifyTag(String notifyTag) {
        this.set(FIELD_NOTIFYTAG, notifyTag);
    }

    @JsonIgnore
    public boolean isNotifyTagDirty() {
        return this.contains(FIELD_NOTIFYTAG);
    }

    @JsonIgnore
    public String getNotifyTag2() {
        Object objValue = this.get(FIELD_NOTIFYTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="notifytag2")
    public void setNotifyTag2(String notifyTag2) {
        this.set(FIELD_NOTIFYTAG2, notifyTag2);
    }

    @JsonIgnore
    public boolean isNotifyTag2Dirty() {
        return this.contains(FIELD_NOTIFYTAG2);
    }

    @JsonIgnore
    public String getPropertyMap() {
        Object objValue = this.get(FIELD_PROPERTYMAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="propertymap")
    public void setPropertyMap(String propertyMap) {
        this.set(FIELD_PROPERTYMAP, propertyMap);
    }

    @JsonIgnore
    public boolean isPropertyMapDirty() {
        return this.contains(FIELD_PROPERTYMAP);
    }

    @JsonIgnore
    public String getPSDEDSId() {
        Object objValue = this.get(FIELD_PSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid")
    public void setPSDEDSId(String pSDEDSId) {
        this.set(FIELD_PSDEDSID, pSDEDSId);
    }

    @JsonIgnore
    public boolean isPSDEDSIdDirty() {
        return this.contains(FIELD_PSDEDSID);
    }

    @JsonIgnore
    public String getPSDEDSName() {
        Object objValue = this.get(FIELD_PSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname")
    public void setPSDEDSName(String pSDEDSName) {
        this.set(FIELD_PSDEDSNAME, pSDEDSName);
    }

    @JsonIgnore
    public boolean isPSDEDSNameDirty() {
        return this.contains(FIELD_PSDEDSNAME);
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
    public String getPSDENotifyId() {
        Object objValue = this.get(FIELD_PSDENOTIFYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyid")
    public void setPSDENotifyId(String pSDENotifyId) {
        this.set(FIELD_PSDENOTIFYID, pSDENotifyId);
    }

    @JsonIgnore
    public boolean isPSDENotifyIdDirty() {
        return this.contains(FIELD_PSDENOTIFYID);
    }

    @JsonIgnore
    public String getPSDENotifyName() {
        Object objValue = this.get(FIELD_PSDENOTIFYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyname")
    public void setPSDENotifyName(String pSDENotifyName) {
        this.set(FIELD_PSDENOTIFYNAME, pSDENotifyName);
    }

    @JsonIgnore
    public boolean isPSDENotifyNameDirty() {
        return this.contains(FIELD_PSDENOTIFYNAME);
    }

    @JsonIgnore
    public String getPSDEPrintId() {
        Object objValue = this.get(FIELD_PSDEPRINTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintid")
    public void setPSDEPrintId(String pSDEPrintId) {
        this.set(FIELD_PSDEPRINTID, pSDEPrintId);
    }

    @JsonIgnore
    public boolean isPSDEPrintIdDirty() {
        return this.contains(FIELD_PSDEPRINTID);
    }

    @JsonIgnore
    public String getPSDEPrintName() {
        Object objValue = this.get(FIELD_PSDEPRINTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintname")
    public void setPSDEPrintName(String pSDEPrintName) {
        this.set(FIELD_PSDEPRINTNAME, pSDEPrintName);
    }

    @JsonIgnore
    public boolean isPSDEPrintNameDirty() {
        return this.contains(FIELD_PSDEPRINTNAME);
    }

    @JsonIgnore
    public String getPSDEReportId() {
        Object objValue = this.get(FIELD_PSDEREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportid")
    public void setPSDEReportId(String pSDEReportId) {
        this.set(FIELD_PSDEREPORTID, pSDEReportId);
    }

    @JsonIgnore
    public boolean isPSDEReportIdDirty() {
        return this.contains(FIELD_PSDEREPORTID);
    }

    @JsonIgnore
    public String getPSDEReportName() {
        Object objValue = this.get(FIELD_PSDEREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportname")
    public void setPSDEReportName(String pSDEReportName) {
        this.set(FIELD_PSDEREPORTNAME, pSDEReportName);
    }

    @JsonIgnore
    public boolean isPSDEReportNameDirty() {
        return this.contains(FIELD_PSDEREPORTNAME);
    }

    @JsonIgnore
    public String getPSSysMsgQueueId() {
        Object objValue = this.get(FIELD_PSSYSMSGQUEUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgqueueid")
    public void setPSSysMsgQueueId(String pSSysMsgQueueId) {
        this.set(FIELD_PSSYSMSGQUEUEID, pSSysMsgQueueId);
    }

    @JsonIgnore
    public boolean isPSSysMsgQueueIdDirty() {
        return this.contains(FIELD_PSSYSMSGQUEUEID);
    }

    @JsonIgnore
    public String getPSSysMsgQueueName() {
        Object objValue = this.get(FIELD_PSSYSMSGQUEUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgqueuename")
    public void setPSSysMsgQueueName(String pSSysMsgQueueName) {
        this.set(FIELD_PSSYSMSGQUEUENAME, pSSysMsgQueueName);
    }

    @JsonIgnore
    public boolean isPSSysMsgQueueNameDirty() {
        return this.contains(FIELD_PSSYSMSGQUEUENAME);
    }

    @JsonIgnore
    public String getPSSysMsgTemplId() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplid")
    public void setPSSysMsgTemplId(String pSSysMsgTemplId) {
        this.set(FIELD_PSSYSMSGTEMPLID, pSSysMsgTemplId);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplIdDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLID);
    }

    @JsonIgnore
    public String getPSSysMsgTemplName() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplname")
    public void setPSSysMsgTemplName(String pSSysMsgTemplName) {
        this.set(FIELD_PSSYSMSGTEMPLNAME, pSSysMsgTemplName);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplNameDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLNAME);
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
    public Integer getTaskMode() {
        Object objValue = this.get(FIELD_TASKMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="taskmode")
    public void setTaskMode(Integer taskMode) {
        this.set(FIELD_TASKMODE, taskMode);
    }

    @JsonIgnore
    public boolean isTaskModeDirty() {
        return this.contains(FIELD_TASKMODE);
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
        return this.getPSDENotifyId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDENotifyId(strValue);
    }

    @JsonProperty(value="psdenotifytargets")
    public List<PSDENotifyTargetDTO> getPsdenotifytargets() {
        return this.psdenotifytargets;
    }

    @JsonProperty(value="psdenotifytargets")
    public void setPsdenotifytargets(List<PSDENotifyTargetDTO> psdenotifytargets) {
        this.psdenotifytargets = psdenotifytargets;
    }
}

