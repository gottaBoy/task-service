/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysBackService
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTAINERTAG = "containertag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PSBACKSERVICEID = "psbackserviceid";
    public static final String FIELD_PSBACKSERVICENAME = "psbackservicename";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSBACKSERVICEID = "pssysbackserviceid";
    public static final String FIELD_PSSYSBACKSERVICENAME = "pssysbackservicename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUTILDEID = "pssysutildeid";
    public static final String FIELD_PSSYSUTILDENAME = "pssysutildename";
    public static final String FIELD_RUNORDER = "runorder";
    public static final String FIELD_SERVICECONTAINER = "servicecontainer";
    public static final String FIELD_SERVICEOBJ = "serviceobj";
    public static final String FIELD_SERVICEPARAMS = "serviceparams";
    public static final String FIELD_SERVICEPOLICY = "servicepolicy";
    public static final String FIELD_SERVICEPOLICY2 = "servicepolicy2";
    public static final String FIELD_SERVICETAG = "servicetag";
    public static final String FIELD_SERVICETAG2 = "servicetag2";
    public static final String FIELD_STARTMODE = "startmode";
    public static final String FIELD_TASKTYPE = "tasktype";
    public static final String FIELD_TIMERMODE = "timermode";
    public static final String FIELD_TIMERPOLICY = "timerpolicy";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getContainerTag() {
        Object objValue = this.get(FIELD_CONTAINERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="containertag")
    public void setContainerTag(String containerTag) {
        this.set(FIELD_CONTAINERTAG, containerTag);
    }

    @JsonIgnore
    public boolean isContainerTagDirty() {
        return this.contains(FIELD_CONTAINERTAG);
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
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
    }

    @JsonIgnore
    public String getPSBackServiceId() {
        Object objValue = this.get(FIELD_PSBACKSERVICEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psbackserviceid")
    public void setPSBackServiceId(String pSBackServiceId) {
        this.set(FIELD_PSBACKSERVICEID, pSBackServiceId);
    }

    @JsonIgnore
    public boolean isPSBackServiceIdDirty() {
        return this.contains(FIELD_PSBACKSERVICEID);
    }

    @JsonIgnore
    public String getPSBackServiceName() {
        Object objValue = this.get(FIELD_PSBACKSERVICENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psbackservicename")
    public void setPSBackServiceName(String pSBackServiceName) {
        this.set(FIELD_PSBACKSERVICENAME, pSBackServiceName);
    }

    @JsonIgnore
    public boolean isPSBackServiceNameDirty() {
        return this.contains(FIELD_PSBACKSERVICENAME);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
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
    public String getPSSysBackServiceId() {
        Object objValue = this.get(FIELD_PSSYSBACKSERVICEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbackserviceid")
    public void setPSSysBackServiceId(String pSSysBackServiceId) {
        this.set(FIELD_PSSYSBACKSERVICEID, pSSysBackServiceId);
    }

    @JsonIgnore
    public boolean isPSSysBackServiceIdDirty() {
        return this.contains(FIELD_PSSYSBACKSERVICEID);
    }

    @JsonIgnore
    public String getPSSysBackServiceName() {
        Object objValue = this.get(FIELD_PSSYSBACKSERVICENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbackservicename")
    public void setPSSysBackServiceName(String pSSysBackServiceName) {
        this.set(FIELD_PSSYSBACKSERVICENAME, pSSysBackServiceName);
    }

    @JsonIgnore
    public boolean isPSSysBackServiceNameDirty() {
        return this.contains(FIELD_PSSYSBACKSERVICENAME);
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
    public Integer getRunOrder() {
        Object objValue = this.get(FIELD_RUNORDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="runorder")
    public void setRunOrder(Integer runOrder) {
        this.set(FIELD_RUNORDER, runOrder);
    }

    @JsonIgnore
    public boolean isRunOrderDirty() {
        return this.contains(FIELD_RUNORDER);
    }

    @JsonIgnore
    public String getServiceContainer() {
        Object objValue = this.get(FIELD_SERVICECONTAINER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicecontainer")
    public void setServiceContainer(String serviceContainer) {
        this.set(FIELD_SERVICECONTAINER, serviceContainer);
    }

    @JsonIgnore
    public boolean isServiceContainerDirty() {
        return this.contains(FIELD_SERVICECONTAINER);
    }

    @JsonIgnore
    public String getServiceObj() {
        Object objValue = this.get(FIELD_SERVICEOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceobj")
    public void setServiceObj(String serviceObj) {
        this.set(FIELD_SERVICEOBJ, serviceObj);
    }

    @JsonIgnore
    public boolean isServiceObjDirty() {
        return this.contains(FIELD_SERVICEOBJ);
    }

    @JsonIgnore
    public String getServiceParams() {
        Object objValue = this.get(FIELD_SERVICEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceparams")
    public void setServiceParams(String serviceParams) {
        this.set(FIELD_SERVICEPARAMS, serviceParams);
    }

    @JsonIgnore
    public boolean isServiceParamsDirty() {
        return this.contains(FIELD_SERVICEPARAMS);
    }

    @JsonIgnore
    public String getServicePolicy() {
        Object objValue = this.get(FIELD_SERVICEPOLICY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicepolicy")
    public void setServicePolicy(String servicePolicy) {
        this.set(FIELD_SERVICEPOLICY, servicePolicy);
    }

    @JsonIgnore
    public boolean isServicePolicyDirty() {
        return this.contains(FIELD_SERVICEPOLICY);
    }

    @JsonIgnore
    public String getServicePolicy2() {
        Object objValue = this.get(FIELD_SERVICEPOLICY2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicepolicy2")
    public void setServicePolicy2(String servicePolicy2) {
        this.set(FIELD_SERVICEPOLICY2, servicePolicy2);
    }

    @JsonIgnore
    public boolean isServicePolicy2Dirty() {
        return this.contains(FIELD_SERVICEPOLICY2);
    }

    @JsonIgnore
    public String getServiceTag() {
        Object objValue = this.get(FIELD_SERVICETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicetag")
    public void setServiceTag(String serviceTag) {
        this.set(FIELD_SERVICETAG, serviceTag);
    }

    @JsonIgnore
    public boolean isServiceTagDirty() {
        return this.contains(FIELD_SERVICETAG);
    }

    @JsonIgnore
    public String getServiceTag2() {
        Object objValue = this.get(FIELD_SERVICETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicetag2")
    public void setServiceTag2(String serviceTag2) {
        this.set(FIELD_SERVICETAG2, serviceTag2);
    }

    @JsonIgnore
    public boolean isServiceTag2Dirty() {
        return this.contains(FIELD_SERVICETAG2);
    }

    @JsonIgnore
    public String getStartMode() {
        Object objValue = this.get(FIELD_STARTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startmode")
    public void setStartMode(String startMode) {
        this.set(FIELD_STARTMODE, startMode);
    }

    @JsonIgnore
    public boolean isStartModeDirty() {
        return this.contains(FIELD_STARTMODE);
    }

    @JsonIgnore
    public String getTaskType() {
        Object objValue = this.get(FIELD_TASKTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tasktype")
    public void setTaskType(String taskType) {
        this.set(FIELD_TASKTYPE, taskType);
    }

    @JsonIgnore
    public boolean isTaskTypeDirty() {
        return this.contains(FIELD_TASKTYPE);
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
    public String getTimerPolicy() {
        Object objValue = this.get(FIELD_TIMERPOLICY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timerpolicy")
    public void setTimerPolicy(String timerPolicy) {
        this.set(FIELD_TIMERPOLICY, timerPolicy);
    }

    @JsonIgnore
    public boolean isTimerPolicyDirty() {
        return this.contains(FIELD_TIMERPOLICY);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBackServiceId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBackServiceId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBACKSERVICE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBackService item = (PSSysBackService)MAPPER.readValue(new File(strJsonFilePath), PSSysBackService.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBackService) {
            PSSysBackService pSSysBackService = (PSSysBackService)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBackService) {
            PSSysBackService pSSysBackService = (PSSysBackService)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

