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

public class PSSysDataSyncAgentDTO
extends PSModelDTOBase {
    public static final String FIELD_AGENTPARAMS = "agentparams";
    public static final String FIELD_AGENTTAG = "agenttag";
    public static final String FIELD_AGENTTAG2 = "agenttag2";
    public static final String FIELD_AGENTTYPE = "agenttype";
    public static final String FIELD_AUTHCLIENTID = "authclientid";
    public static final String FIELD_AUTHCLIENTSECRET = "authclientsecret";
    public static final String FIELD_AUTHMODE = "authmode";
    public static final String FIELD_AUTHPARAM = "authparam";
    public static final String FIELD_AUTHPARAM2 = "authparam2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_GROUPID = "groupid";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSDATASYNCAGENTID = "pssysdatasyncagentid";
    public static final String FIELD_PSSYSDATASYNCAGENTNAME = "pssysdatasyncagentname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_RAWDATAMODE = "rawdatamode";
    public static final String FIELD_SERVICEPARAM = "serviceparam";
    public static final String FIELD_SERVICEPARAM2 = "serviceparam2";
    public static final String FIELD_SERVICEPATH = "servicepath";
    public static final String FIELD_SYNCDIR = "syncdir";
    public static final String FIELD_TOPIC = "topic";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getAgentParams() {
        Object objValue = this.get(FIELD_AGENTPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="agentparams")
    public void setAgentParams(String agentParams) {
        this.set(FIELD_AGENTPARAMS, agentParams);
    }

    @JsonIgnore
    public boolean isAgentParamsDirty() {
        return this.contains(FIELD_AGENTPARAMS);
    }

    @JsonIgnore
    public String getAgentTag() {
        Object objValue = this.get(FIELD_AGENTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="agenttag")
    public void setAgentTag(String agentTag) {
        this.set(FIELD_AGENTTAG, agentTag);
    }

    @JsonIgnore
    public boolean isAgentTagDirty() {
        return this.contains(FIELD_AGENTTAG);
    }

    @JsonIgnore
    public String getAgentTag2() {
        Object objValue = this.get(FIELD_AGENTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="agenttag2")
    public void setAgentTag2(String agentTag2) {
        this.set(FIELD_AGENTTAG2, agentTag2);
    }

    @JsonIgnore
    public boolean isAgentTag2Dirty() {
        return this.contains(FIELD_AGENTTAG2);
    }

    @JsonIgnore
    public String getAgentType() {
        Object objValue = this.get(FIELD_AGENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="agenttype")
    public void setAgentType(String agentType) {
        this.set(FIELD_AGENTTYPE, agentType);
    }

    @JsonIgnore
    public boolean isAgentTypeDirty() {
        return this.contains(FIELD_AGENTTYPE);
    }

    @JsonIgnore
    public String getAuthClientId() {
        Object objValue = this.get(FIELD_AUTHCLIENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authclientid")
    public void setAuthClientId(String authClientId) {
        this.set(FIELD_AUTHCLIENTID, authClientId);
    }

    @JsonIgnore
    public boolean isAuthClientIdDirty() {
        return this.contains(FIELD_AUTHCLIENTID);
    }

    @JsonIgnore
    public String getAuthClientSecret() {
        Object objValue = this.get(FIELD_AUTHCLIENTSECRET);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authclientsecret")
    public void setAuthClientSecret(String authClientSecret) {
        this.set(FIELD_AUTHCLIENTSECRET, authClientSecret);
    }

    @JsonIgnore
    public boolean isAuthClientSecretDirty() {
        return this.contains(FIELD_AUTHCLIENTSECRET);
    }

    @JsonIgnore
    public String getAuthMode() {
        Object objValue = this.get(FIELD_AUTHMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authmode")
    public void setAuthMode(String authMode) {
        this.set(FIELD_AUTHMODE, authMode);
    }

    @JsonIgnore
    public boolean isAuthModeDirty() {
        return this.contains(FIELD_AUTHMODE);
    }

    @JsonIgnore
    public String getAuthParam() {
        Object objValue = this.get(FIELD_AUTHPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authparam")
    public void setAuthParam(String authParam) {
        this.set(FIELD_AUTHPARAM, authParam);
    }

    @JsonIgnore
    public boolean isAuthParamDirty() {
        return this.contains(FIELD_AUTHPARAM);
    }

    @JsonIgnore
    public String getAuthParam2() {
        Object objValue = this.get(FIELD_AUTHPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authparam2")
    public void setAuthParam2(String authParam2) {
        this.set(FIELD_AUTHPARAM2, authParam2);
    }

    @JsonIgnore
    public boolean isAuthParam2Dirty() {
        return this.contains(FIELD_AUTHPARAM2);
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
    public String getGroupId() {
        Object objValue = this.get(FIELD_GROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupid")
    public void setGroupId(String groupId) {
        this.set(FIELD_GROUPID, groupId);
    }

    @JsonIgnore
    public boolean isGroupIdDirty() {
        return this.contains(FIELD_GROUPID);
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
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
    }

    @JsonIgnore
    public String getPSSysDataSyncAgentId() {
        Object objValue = this.get(FIELD_PSSYSDATASYNCAGENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdatasyncagentid")
    public void setPSSysDataSyncAgentId(String pSSysDataSyncAgentId) {
        this.set(FIELD_PSSYSDATASYNCAGENTID, pSSysDataSyncAgentId);
    }

    @JsonIgnore
    public boolean isPSSysDataSyncAgentIdDirty() {
        return this.contains(FIELD_PSSYSDATASYNCAGENTID);
    }

    @JsonIgnore
    public String getPSSysDataSyncAgentName() {
        Object objValue = this.get(FIELD_PSSYSDATASYNCAGENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdatasyncagentname")
    public void setPSSysDataSyncAgentName(String pSSysDataSyncAgentName) {
        this.set(FIELD_PSSYSDATASYNCAGENTNAME, pSSysDataSyncAgentName);
    }

    @JsonIgnore
    public boolean isPSSysDataSyncAgentNameDirty() {
        return this.contains(FIELD_PSSYSDATASYNCAGENTNAME);
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
    public Integer getRawDataMode() {
        Object objValue = this.get(FIELD_RAWDATAMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rawdatamode")
    public void setRawDataMode(Integer rawDataMode) {
        this.set(FIELD_RAWDATAMODE, rawDataMode);
    }

    @JsonIgnore
    public boolean isRawDataModeDirty() {
        return this.contains(FIELD_RAWDATAMODE);
    }

    @JsonIgnore
    public String getServiceParam() {
        Object objValue = this.get(FIELD_SERVICEPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceparam")
    public void setServiceParam(String serviceParam) {
        this.set(FIELD_SERVICEPARAM, serviceParam);
    }

    @JsonIgnore
    public boolean isServiceParamDirty() {
        return this.contains(FIELD_SERVICEPARAM);
    }

    @JsonIgnore
    public String getServiceParam2() {
        Object objValue = this.get(FIELD_SERVICEPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceparam2")
    public void setServiceParam2(String serviceParam2) {
        this.set(FIELD_SERVICEPARAM2, serviceParam2);
    }

    @JsonIgnore
    public boolean isServiceParam2Dirty() {
        return this.contains(FIELD_SERVICEPARAM2);
    }

    @JsonIgnore
    public String getServicePath() {
        Object objValue = this.get(FIELD_SERVICEPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicepath")
    public void setServicePath(String servicePath) {
        this.set(FIELD_SERVICEPATH, servicePath);
    }

    @JsonIgnore
    public boolean isServicePathDirty() {
        return this.contains(FIELD_SERVICEPATH);
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
    public String getTopic() {
        Object objValue = this.get(FIELD_TOPIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topic")
    public void setTopic(String topic) {
        this.set(FIELD_TOPIC, topic);
    }

    @JsonIgnore
    public boolean isTopicDirty() {
        return this.contains(FIELD_TOPIC);
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
        return this.getPSSysDataSyncAgentId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysDataSyncAgentId(strValue);
    }
}

