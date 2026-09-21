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

public class PSSysMsgQueueDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENTPSDEFID = "contentpsdefid";
    public static final String FIELD_CONTENTPSDEFNAME = "contentpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DDCONTENTPSDEFID = "ddcontentpsdefid";
    public static final String FIELD_DDCONTENTPSDEFNAME = "ddcontentpsdefname";
    public static final String FIELD_FILEPSDEFID = "filepsdefid";
    public static final String FIELD_FILEPSDEFNAME = "filepsdefname";
    public static final String FIELD_IMCONTENTPSDEFID = "imcontentpsdefid";
    public static final String FIELD_IMCONTENTPSDEFNAME = "imcontentpsdefname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBTASKURLPSDEFID = "mobtaskurlpsdefid";
    public static final String FIELD_MOBTASKURLPSDEFNAME = "mobtaskurlpsdefname";
    public static final String FIELD_MSGQUEUETAG = "msgqueuetag";
    public static final String FIELD_MSGQUEUETAG2 = "msgqueuetag2";
    public static final String FIELD_MSGQUEUETYPE = "msgqueuetype";
    public static final String FIELD_MSGTYPEPSDEFID = "msgtypepsdefid";
    public static final String FIELD_MSGTYPEPSDEFNAME = "msgtypepsdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSMSGQUEUEID = "pssysmsgqueueid";
    public static final String FIELD_PSSYSMSGQUEUENAME = "pssysmsgqueuename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUTILDEID = "pssysutildeid";
    public static final String FIELD_PSSYSUTILDENAME = "pssysutildename";
    public static final String FIELD_QUEUEPARAMS = "queueparams";
    public static final String FIELD_SENDTIMEPSDEFID = "sendtimepsdefid";
    public static final String FIELD_SENDTIMEPSDEFNAME = "sendtimepsdefname";
    public static final String FIELD_SMSCONTENTPSDEFID = "smscontentpsdefid";
    public static final String FIELD_SMSCONTENTPSDEFNAME = "smscontentpsdefname";
    public static final String FIELD_STATEPSDEFID = "statepsdefid";
    public static final String FIELD_STATEPSDEFNAME = "statepsdefname";
    public static final String FIELD_TAG2PSDEFID = "tag2psdefid";
    public static final String FIELD_TAG2PSDEFNAME = "tag2psdefname";
    public static final String FIELD_TAGPSDEFID = "tagpsdefid";
    public static final String FIELD_TAGPSDEFNAME = "tagpsdefname";
    public static final String FIELD_TARGETPSDEFID = "targetpsdefid";
    public static final String FIELD_TARGETPSDEFNAME = "targetpsdefname";
    public static final String FIELD_TARGETTYPEPSDEFID = "targettypepsdefid";
    public static final String FIELD_TARGETTYPEPSDEFNAME = "targettypepsdefname";
    public static final String FIELD_TASKURLPSDEFID = "taskurlpsdefid";
    public static final String FIELD_TASKURLPSDEFNAME = "taskurlpsdefname";
    public static final String FIELD_TITLEPSDEFID = "titlepsdefid";
    public static final String FIELD_TITLEPSDEFNAME = "titlepsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WXCONTENTPSDEFID = "wxcontentpsdefid";
    public static final String FIELD_WXCONTENTPSDEFNAME = "wxcontentpsdefname";

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
    public String getContentPSDEFId() {
        Object objValue = this.get(FIELD_CONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefid")
    public void setContentPSDEFId(String contentPSDEFId) {
        this.set(FIELD_CONTENTPSDEFID, contentPSDEFId);
    }

    @JsonIgnore
    public boolean isContentPSDEFIdDirty() {
        return this.contains(FIELD_CONTENTPSDEFID);
    }

    @JsonIgnore
    public String getContentPSDEFName() {
        Object objValue = this.get(FIELD_CONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefname")
    public void setContentPSDEFName(String contentPSDEFName) {
        this.set(FIELD_CONTENTPSDEFNAME, contentPSDEFName);
    }

    @JsonIgnore
    public boolean isContentPSDEFNameDirty() {
        return this.contains(FIELD_CONTENTPSDEFNAME);
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
    public String getDDContentPSDEFId() {
        Object objValue = this.get(FIELD_DDCONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ddcontentpsdefid")
    public void setDDContentPSDEFId(String dDContentPSDEFId) {
        this.set(FIELD_DDCONTENTPSDEFID, dDContentPSDEFId);
    }

    @JsonIgnore
    public boolean isDDContentPSDEFIdDirty() {
        return this.contains(FIELD_DDCONTENTPSDEFID);
    }

    @JsonIgnore
    public String getDDContentPSDEFName() {
        Object objValue = this.get(FIELD_DDCONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ddcontentpsdefname")
    public void setDDContentPSDEFName(String dDContentPSDEFName) {
        this.set(FIELD_DDCONTENTPSDEFNAME, dDContentPSDEFName);
    }

    @JsonIgnore
    public boolean isDDContentPSDEFNameDirty() {
        return this.contains(FIELD_DDCONTENTPSDEFNAME);
    }

    @JsonIgnore
    public String getFilePSDEFId() {
        Object objValue = this.get(FIELD_FILEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filepsdefid")
    public void setFilePSDEFId(String filePSDEFId) {
        this.set(FIELD_FILEPSDEFID, filePSDEFId);
    }

    @JsonIgnore
    public boolean isFilePSDEFIdDirty() {
        return this.contains(FIELD_FILEPSDEFID);
    }

    @JsonIgnore
    public String getFilePSDEFName() {
        Object objValue = this.get(FIELD_FILEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filepsdefname")
    public void setFilePSDEFName(String filePSDEFName) {
        this.set(FIELD_FILEPSDEFNAME, filePSDEFName);
    }

    @JsonIgnore
    public boolean isFilePSDEFNameDirty() {
        return this.contains(FIELD_FILEPSDEFNAME);
    }

    @JsonIgnore
    public String getIMContentPSDEFId() {
        Object objValue = this.get(FIELD_IMCONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="imcontentpsdefid")
    public void setIMContentPSDEFId(String iMContentPSDEFId) {
        this.set(FIELD_IMCONTENTPSDEFID, iMContentPSDEFId);
    }

    @JsonIgnore
    public boolean isIMContentPSDEFIdDirty() {
        return this.contains(FIELD_IMCONTENTPSDEFID);
    }

    @JsonIgnore
    public String getIMContentPSDEFName() {
        Object objValue = this.get(FIELD_IMCONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="imcontentpsdefname")
    public void setIMContentPSDEFName(String iMContentPSDEFName) {
        this.set(FIELD_IMCONTENTPSDEFNAME, iMContentPSDEFName);
    }

    @JsonIgnore
    public boolean isIMContentPSDEFNameDirty() {
        return this.contains(FIELD_IMCONTENTPSDEFNAME);
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
    public String getMobTaskUrlPSDEFId() {
        Object objValue = this.get(FIELD_MOBTASKURLPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobtaskurlpsdefid")
    public void setMobTaskUrlPSDEFId(String mobTaskUrlPSDEFId) {
        this.set(FIELD_MOBTASKURLPSDEFID, mobTaskUrlPSDEFId);
    }

    @JsonIgnore
    public boolean isMobTaskUrlPSDEFIdDirty() {
        return this.contains(FIELD_MOBTASKURLPSDEFID);
    }

    @JsonIgnore
    public String getMobTaskUrlPSDEFName() {
        Object objValue = this.get(FIELD_MOBTASKURLPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobtaskurlpsdefname")
    public void setMobTaskUrlPSDEFName(String mobTaskUrlPSDEFName) {
        this.set(FIELD_MOBTASKURLPSDEFNAME, mobTaskUrlPSDEFName);
    }

    @JsonIgnore
    public boolean isMobTaskUrlPSDEFNameDirty() {
        return this.contains(FIELD_MOBTASKURLPSDEFNAME);
    }

    @JsonIgnore
    public String getMsgQueueTag() {
        Object objValue = this.get(FIELD_MSGQUEUETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgqueuetag")
    public void setMsgQueueTag(String msgQueueTag) {
        this.set(FIELD_MSGQUEUETAG, msgQueueTag);
    }

    @JsonIgnore
    public boolean isMsgQueueTagDirty() {
        return this.contains(FIELD_MSGQUEUETAG);
    }

    @JsonIgnore
    public String getMsgQueueTag2() {
        Object objValue = this.get(FIELD_MSGQUEUETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgqueuetag2")
    public void setMsgQueueTag2(String msgQueueTag2) {
        this.set(FIELD_MSGQUEUETAG2, msgQueueTag2);
    }

    @JsonIgnore
    public boolean isMsgQueueTag2Dirty() {
        return this.contains(FIELD_MSGQUEUETAG2);
    }

    @JsonIgnore
    public String getMsgQueueType() {
        Object objValue = this.get(FIELD_MSGQUEUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgqueuetype")
    public void setMsgQueueType(String msgQueueType) {
        this.set(FIELD_MSGQUEUETYPE, msgQueueType);
    }

    @JsonIgnore
    public boolean isMsgQueueTypeDirty() {
        return this.contains(FIELD_MSGQUEUETYPE);
    }

    @JsonIgnore
    public String getMsgTypePSDEFId() {
        Object objValue = this.get(FIELD_MSGTYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgtypepsdefid")
    public void setMsgTypePSDEFId(String msgTypePSDEFId) {
        this.set(FIELD_MSGTYPEPSDEFID, msgTypePSDEFId);
    }

    @JsonIgnore
    public boolean isMsgTypePSDEFIdDirty() {
        return this.contains(FIELD_MSGTYPEPSDEFID);
    }

    @JsonIgnore
    public String getMsgTypePSDEFName() {
        Object objValue = this.get(FIELD_MSGTYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgtypepsdefname")
    public void setMsgTypePSDEFName(String msgTypePSDEFName) {
        this.set(FIELD_MSGTYPEPSDEFNAME, msgTypePSDEFName);
    }

    @JsonIgnore
    public boolean isMsgTypePSDEFNameDirty() {
        return this.contains(FIELD_MSGTYPEPSDEFNAME);
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
    public String getPSSysUtilDEId() {
        Object objValue = this.get(FIELD_PSSYSUTILDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysutildeid")
    public void setPSSysUtilDEId(String pSSysUtilDEId) {
        this.set(FIELD_PSSYSUTILDEID, pSSysUtilDEId);
    }

    @JsonIgnore
    public boolean isPSSysUtilDEIdDirty() {
        return this.contains(FIELD_PSSYSUTILDEID);
    }

    @JsonIgnore
    public String getPSSysUtilDEName() {
        Object objValue = this.get(FIELD_PSSYSUTILDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysutildename")
    public void setPSSysUtilDEName(String pSSysUtilDEName) {
        this.set(FIELD_PSSYSUTILDENAME, pSSysUtilDEName);
    }

    @JsonIgnore
    public boolean isPSSysUtilDENameDirty() {
        return this.contains(FIELD_PSSYSUTILDENAME);
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
    public String getSendTimePSDEFId() {
        Object objValue = this.get(FIELD_SENDTIMEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sendtimepsdefid")
    public void setSendTimePSDEFId(String sendTimePSDEFId) {
        this.set(FIELD_SENDTIMEPSDEFID, sendTimePSDEFId);
    }

    @JsonIgnore
    public boolean isSendTimePSDEFIdDirty() {
        return this.contains(FIELD_SENDTIMEPSDEFID);
    }

    @JsonIgnore
    public String getSendTimePSDEFName() {
        Object objValue = this.get(FIELD_SENDTIMEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sendtimepsdefname")
    public void setSendTimePSDEFName(String sendTimePSDEFName) {
        this.set(FIELD_SENDTIMEPSDEFNAME, sendTimePSDEFName);
    }

    @JsonIgnore
    public boolean isSendTimePSDEFNameDirty() {
        return this.contains(FIELD_SENDTIMEPSDEFNAME);
    }

    @JsonIgnore
    public String getSMSContentPSDEFId() {
        Object objValue = this.get(FIELD_SMSCONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smscontentpsdefid")
    public void setSMSContentPSDEFId(String sMSContentPSDEFId) {
        this.set(FIELD_SMSCONTENTPSDEFID, sMSContentPSDEFId);
    }

    @JsonIgnore
    public boolean isSMSContentPSDEFIdDirty() {
        return this.contains(FIELD_SMSCONTENTPSDEFID);
    }

    @JsonIgnore
    public String getSMSContentPSDEFName() {
        Object objValue = this.get(FIELD_SMSCONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smscontentpsdefname")
    public void setSMSContentPSDEFName(String sMSContentPSDEFName) {
        this.set(FIELD_SMSCONTENTPSDEFNAME, sMSContentPSDEFName);
    }

    @JsonIgnore
    public boolean isSMSContentPSDEFNameDirty() {
        return this.contains(FIELD_SMSCONTENTPSDEFNAME);
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
    public String getTag2PSDEFId() {
        Object objValue = this.get(FIELD_TAG2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tag2psdefid")
    public void setTag2PSDEFId(String tag2PSDEFId) {
        this.set(FIELD_TAG2PSDEFID, tag2PSDEFId);
    }

    @JsonIgnore
    public boolean isTag2PSDEFIdDirty() {
        return this.contains(FIELD_TAG2PSDEFID);
    }

    @JsonIgnore
    public String getTag2PSDEFName() {
        Object objValue = this.get(FIELD_TAG2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tag2psdefname")
    public void setTag2PSDEFName(String tag2PSDEFName) {
        this.set(FIELD_TAG2PSDEFNAME, tag2PSDEFName);
    }

    @JsonIgnore
    public boolean isTag2PSDEFNameDirty() {
        return this.contains(FIELD_TAG2PSDEFNAME);
    }

    @JsonIgnore
    public String getTagPSDEFId() {
        Object objValue = this.get(FIELD_TAGPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tagpsdefid")
    public void setTagPSDEFId(String tagPSDEFId) {
        this.set(FIELD_TAGPSDEFID, tagPSDEFId);
    }

    @JsonIgnore
    public boolean isTagPSDEFIdDirty() {
        return this.contains(FIELD_TAGPSDEFID);
    }

    @JsonIgnore
    public String getTagPSDEFName() {
        Object objValue = this.get(FIELD_TAGPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tagpsdefname")
    public void setTagPSDEFName(String tagPSDEFName) {
        this.set(FIELD_TAGPSDEFNAME, tagPSDEFName);
    }

    @JsonIgnore
    public boolean isTagPSDEFNameDirty() {
        return this.contains(FIELD_TAGPSDEFNAME);
    }

    @JsonIgnore
    public String getTargetPSDEFId() {
        Object objValue = this.get(FIELD_TARGETPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetpsdefid")
    public void setTargetPSDEFId(String targetPSDEFId) {
        this.set(FIELD_TARGETPSDEFID, targetPSDEFId);
    }

    @JsonIgnore
    public boolean isTargetPSDEFIdDirty() {
        return this.contains(FIELD_TARGETPSDEFID);
    }

    @JsonIgnore
    public String getTargetPSDEFName() {
        Object objValue = this.get(FIELD_TARGETPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetpsdefname")
    public void setTargetPSDEFName(String targetPSDEFName) {
        this.set(FIELD_TARGETPSDEFNAME, targetPSDEFName);
    }

    @JsonIgnore
    public boolean isTargetPSDEFNameDirty() {
        return this.contains(FIELD_TARGETPSDEFNAME);
    }

    @JsonIgnore
    public String getTargetTypePSDEFId() {
        Object objValue = this.get(FIELD_TARGETTYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettypepsdefid")
    public void setTargetTypePSDEFId(String targetTypePSDEFId) {
        this.set(FIELD_TARGETTYPEPSDEFID, targetTypePSDEFId);
    }

    @JsonIgnore
    public boolean isTargetTypePSDEFIdDirty() {
        return this.contains(FIELD_TARGETTYPEPSDEFID);
    }

    @JsonIgnore
    public String getTargetTypePSDEFName() {
        Object objValue = this.get(FIELD_TARGETTYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettypepsdefname")
    public void setTargetTypePSDEFName(String targetTypePSDEFName) {
        this.set(FIELD_TARGETTYPEPSDEFNAME, targetTypePSDEFName);
    }

    @JsonIgnore
    public boolean isTargetTypePSDEFNameDirty() {
        return this.contains(FIELD_TARGETTYPEPSDEFNAME);
    }

    @JsonIgnore
    public String getTaskUrlPSDEFId() {
        Object objValue = this.get(FIELD_TASKURLPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="taskurlpsdefid")
    public void setTaskUrlPSDEFId(String taskUrlPSDEFId) {
        this.set(FIELD_TASKURLPSDEFID, taskUrlPSDEFId);
    }

    @JsonIgnore
    public boolean isTaskUrlPSDEFIdDirty() {
        return this.contains(FIELD_TASKURLPSDEFID);
    }

    @JsonIgnore
    public String getTaskUrlPSDEFName() {
        Object objValue = this.get(FIELD_TASKURLPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="taskurlpsdefname")
    public void setTaskUrlPSDEFName(String taskUrlPSDEFName) {
        this.set(FIELD_TASKURLPSDEFNAME, taskUrlPSDEFName);
    }

    @JsonIgnore
    public boolean isTaskUrlPSDEFNameDirty() {
        return this.contains(FIELD_TASKURLPSDEFNAME);
    }

    @JsonIgnore
    public String getTitlePSDEFId() {
        Object objValue = this.get(FIELD_TITLEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepsdefid")
    public void setTitlePSDEFId(String titlePSDEFId) {
        this.set(FIELD_TITLEPSDEFID, titlePSDEFId);
    }

    @JsonIgnore
    public boolean isTitlePSDEFIdDirty() {
        return this.contains(FIELD_TITLEPSDEFID);
    }

    @JsonIgnore
    public String getTitlePSDEFName() {
        Object objValue = this.get(FIELD_TITLEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepsdefname")
    public void setTitlePSDEFName(String titlePSDEFName) {
        this.set(FIELD_TITLEPSDEFNAME, titlePSDEFName);
    }

    @JsonIgnore
    public boolean isTitlePSDEFNameDirty() {
        return this.contains(FIELD_TITLEPSDEFNAME);
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
    public String getWXContentPSDEFId() {
        Object objValue = this.get(FIELD_WXCONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wxcontentpsdefid")
    public void setWXContentPSDEFId(String wXContentPSDEFId) {
        this.set(FIELD_WXCONTENTPSDEFID, wXContentPSDEFId);
    }

    @JsonIgnore
    public boolean isWXContentPSDEFIdDirty() {
        return this.contains(FIELD_WXCONTENTPSDEFID);
    }

    @JsonIgnore
    public String getWXContentPSDEFName() {
        Object objValue = this.get(FIELD_WXCONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wxcontentpsdefname")
    public void setWXContentPSDEFName(String wXContentPSDEFName) {
        this.set(FIELD_WXCONTENTPSDEFNAME, wXContentPSDEFName);
    }

    @JsonIgnore
    public boolean isWXContentPSDEFNameDirty() {
        return this.contains(FIELD_WXCONTENTPSDEFNAME);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysMsgQueueId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysMsgQueueId(strValue);
    }
}

