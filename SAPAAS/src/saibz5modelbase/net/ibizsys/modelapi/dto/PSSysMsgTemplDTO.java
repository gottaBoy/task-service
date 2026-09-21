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

public class PSSysMsgTemplDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_CONTENTPSLANRESID = "contentpslanresid";
    public static final String FIELD_CONTENTPSLANRESNAME = "contentpslanresname";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DDCONTENT = "ddcontent";
    public static final String FIELD_DDPSLANRESID = "ddpslanresid";
    public static final String FIELD_DDPSLANRESNAME = "ddpslanresname";
    public static final String FIELD_IMCONTENT = "imcontent";
    public static final String FIELD_IMPSLANRESID = "impslanresid";
    public static final String FIELD_IMPSLANRESNAME = "impslanresname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MAILGROUPSEND = "mailgroupsend";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBTASKURL = "mobtaskurl";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSMSGTEMPLID = "pssysmsgtemplid";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "pssysmsgtemplname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SMSCONTENT = "smscontent";
    public static final String FIELD_SMSPSLANRESID = "smspslanresid";
    public static final String FIELD_SMSPSLANRESNAME = "smspslanresname";
    public static final String FIELD_SUBJECT = "subject";
    public static final String FIELD_SUBPSLANRESID = "subpslanresid";
    public static final String FIELD_SUBPSLANRESNAME = "subpslanresname";
    public static final String FIELD_TASKURL = "taskurl";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_WCCONTENT = "wccontent";
    public static final String FIELD_WXPSLANRESID = "wxpslanresid";
    public static final String FIELD_WXPSLANRESNAME = "wxpslanresname";

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
    public String getContent() {
        Object objValue = this.get(FIELD_CONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content")
    public void setContent(String content) {
        this.set(FIELD_CONTENT, content);
    }

    @JsonIgnore
    public boolean isContentDirty() {
        return this.contains(FIELD_CONTENT);
    }

    @JsonIgnore
    public String getContentPSLanResId() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresid")
    public void setContentPSLanResId(String contentPSLanResId) {
        this.set(FIELD_CONTENTPSLANRESID, contentPSLanResId);
    }

    @JsonIgnore
    public boolean isContentPSLanResIdDirty() {
        return this.contains(FIELD_CONTENTPSLANRESID);
    }

    @JsonIgnore
    public String getContentPSLanResName() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresname")
    public void setContentPSLanResName(String contentPSLanResName) {
        this.set(FIELD_CONTENTPSLANRESNAME, contentPSLanResName);
    }

    @JsonIgnore
    public boolean isContentPSLanResNameDirty() {
        return this.contains(FIELD_CONTENTPSLANRESNAME);
    }

    @JsonIgnore
    public String getContentType() {
        Object objValue = this.get(FIELD_CONTENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contenttype")
    public void setContentType(String contentType) {
        this.set(FIELD_CONTENTTYPE, contentType);
    }

    @JsonIgnore
    public boolean isContentTypeDirty() {
        return this.contains(FIELD_CONTENTTYPE);
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
    public String getDDContent() {
        Object objValue = this.get(FIELD_DDCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ddcontent")
    public void setDDContent(String dDContent) {
        this.set(FIELD_DDCONTENT, dDContent);
    }

    @JsonIgnore
    public boolean isDDContentDirty() {
        return this.contains(FIELD_DDCONTENT);
    }

    @JsonIgnore
    public String getDDPSLanResId() {
        Object objValue = this.get(FIELD_DDPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ddpslanresid")
    public void setDDPSLanResId(String dDPSLanResId) {
        this.set(FIELD_DDPSLANRESID, dDPSLanResId);
    }

    @JsonIgnore
    public boolean isDDPSLanResIdDirty() {
        return this.contains(FIELD_DDPSLANRESID);
    }

    @JsonIgnore
    public String getDDPSLanResName() {
        Object objValue = this.get(FIELD_DDPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ddpslanresname")
    public void setDDPSLanResName(String dDPSLanResName) {
        this.set(FIELD_DDPSLANRESNAME, dDPSLanResName);
    }

    @JsonIgnore
    public boolean isDDPSLanResNameDirty() {
        return this.contains(FIELD_DDPSLANRESNAME);
    }

    @JsonIgnore
    public String getIMContent() {
        Object objValue = this.get(FIELD_IMCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="imcontent")
    public void setIMContent(String iMContent) {
        this.set(FIELD_IMCONTENT, iMContent);
    }

    @JsonIgnore
    public boolean isIMContentDirty() {
        return this.contains(FIELD_IMCONTENT);
    }

    @JsonIgnore
    public String getIMPSLanResId() {
        Object objValue = this.get(FIELD_IMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="impslanresid")
    public void setIMPSLanResId(String iMPSLanResId) {
        this.set(FIELD_IMPSLANRESID, iMPSLanResId);
    }

    @JsonIgnore
    public boolean isIMPSLanResIdDirty() {
        return this.contains(FIELD_IMPSLANRESID);
    }

    @JsonIgnore
    public String getIMPSLanResName() {
        Object objValue = this.get(FIELD_IMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="impslanresname")
    public void setIMPSLanResName(String iMPSLanResName) {
        this.set(FIELD_IMPSLANRESNAME, iMPSLanResName);
    }

    @JsonIgnore
    public boolean isIMPSLanResNameDirty() {
        return this.contains(FIELD_IMPSLANRESNAME);
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
    public Integer getMailGroupSend() {
        Object objValue = this.get(FIELD_MAILGROUPSEND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mailgroupsend")
    public void setMailGroupSend(Integer mailGroupSend) {
        this.set(FIELD_MAILGROUPSEND, mailGroupSend);
    }

    @JsonIgnore
    public boolean isMailGroupSendDirty() {
        return this.contains(FIELD_MAILGROUPSEND);
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
    public String getMobTaskUrl() {
        Object objValue = this.get(FIELD_MOBTASKURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobtaskurl")
    public void setMobTaskUrl(String mobTaskUrl) {
        this.set(FIELD_MOBTASKURL, mobTaskUrl);
    }

    @JsonIgnore
    public boolean isMobTaskUrlDirty() {
        return this.contains(FIELD_MOBTASKURL);
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
    public String getSMSContent() {
        Object objValue = this.get(FIELD_SMSCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smscontent")
    public void setSMSContent(String sMSContent) {
        this.set(FIELD_SMSCONTENT, sMSContent);
    }

    @JsonIgnore
    public boolean isSMSContentDirty() {
        return this.contains(FIELD_SMSCONTENT);
    }

    @JsonIgnore
    public String getSMSPSLanResId() {
        Object objValue = this.get(FIELD_SMSPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smspslanresid")
    public void setSMSPSLanResId(String sMSPSLanResId) {
        this.set(FIELD_SMSPSLANRESID, sMSPSLanResId);
    }

    @JsonIgnore
    public boolean isSMSPSLanResIdDirty() {
        return this.contains(FIELD_SMSPSLANRESID);
    }

    @JsonIgnore
    public String getSMSPSLanResName() {
        Object objValue = this.get(FIELD_SMSPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="smspslanresname")
    public void setSMSPSLanResName(String sMSPSLanResName) {
        this.set(FIELD_SMSPSLANRESNAME, sMSPSLanResName);
    }

    @JsonIgnore
    public boolean isSMSPSLanResNameDirty() {
        return this.contains(FIELD_SMSPSLANRESNAME);
    }

    @JsonIgnore
    public String getSubject() {
        Object objValue = this.get(FIELD_SUBJECT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subject")
    public void setSubject(String subject) {
        this.set(FIELD_SUBJECT, subject);
    }

    @JsonIgnore
    public boolean isSubjectDirty() {
        return this.contains(FIELD_SUBJECT);
    }

    @JsonIgnore
    public String getSubPSLanResId() {
        Object objValue = this.get(FIELD_SUBPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subpslanresid")
    public void setSubPSLanResId(String subPSLanResId) {
        this.set(FIELD_SUBPSLANRESID, subPSLanResId);
    }

    @JsonIgnore
    public boolean isSubPSLanResIdDirty() {
        return this.contains(FIELD_SUBPSLANRESID);
    }

    @JsonIgnore
    public String getSubPSLanResName() {
        Object objValue = this.get(FIELD_SUBPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subpslanresname")
    public void setSubPSLanResName(String subPSLanResName) {
        this.set(FIELD_SUBPSLANRESNAME, subPSLanResName);
    }

    @JsonIgnore
    public boolean isSubPSLanResNameDirty() {
        return this.contains(FIELD_SUBPSLANRESNAME);
    }

    @JsonIgnore
    public String getTaskUrl() {
        Object objValue = this.get(FIELD_TASKURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="taskurl")
    public void setTaskUrl(String taskUrl) {
        this.set(FIELD_TASKURL, taskUrl);
    }

    @JsonIgnore
    public boolean isTaskUrlDirty() {
        return this.contains(FIELD_TASKURL);
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
    public String getWCContent() {
        Object objValue = this.get(FIELD_WCCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wccontent")
    public void setWCContent(String wCContent) {
        this.set(FIELD_WCCONTENT, wCContent);
    }

    @JsonIgnore
    public boolean isWCContentDirty() {
        return this.contains(FIELD_WCCONTENT);
    }

    @JsonIgnore
    public String getWXPSLanResId() {
        Object objValue = this.get(FIELD_WXPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wxpslanresid")
    public void setWXPSLanResId(String wXPSLanResId) {
        this.set(FIELD_WXPSLANRESID, wXPSLanResId);
    }

    @JsonIgnore
    public boolean isWXPSLanResIdDirty() {
        return this.contains(FIELD_WXPSLANRESID);
    }

    @JsonIgnore
    public String getWXPSLanResName() {
        Object objValue = this.get(FIELD_WXPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wxpslanresname")
    public void setWXPSLanResName(String wXPSLanResName) {
        this.set(FIELD_WXPSLANRESNAME, wXPSLanResName);
    }

    @JsonIgnore
    public boolean isWXPSLanResNameDirty() {
        return this.contains(FIELD_WXPSLANRESNAME);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysMsgTemplId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysMsgTemplId(strValue);
    }
}

