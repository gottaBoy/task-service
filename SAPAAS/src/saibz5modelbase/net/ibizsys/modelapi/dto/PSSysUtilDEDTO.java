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

public class PSSysUtilDEDTO
extends PSModelDTOBase {
    public static final String FIELD_AUTHACCESSTOKENURI = "authaccesstokenuri";
    public static final String FIELD_AUTHCLIENTID = "authclientid";
    public static final String FIELD_AUTHCLIENTSECRET = "authclientsecret";
    public static final String FIELD_AUTHMODE = "authmode";
    public static final String FIELD_AUTHPARAM = "authparam";
    public static final String FIELD_AUTHPARAM2 = "authparam2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_INPSSYSDATASYNCAGENTID = "inpssysdatasyncagentid";
    public static final String FIELD_INPSSYSDATASYNCAGENTNAME = "inpssysdatasyncagentname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTID = "outpssysdatasyncagentid";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTNAME = "outpssysdatasyncagentname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUTILDEID = "pssysutildeid";
    public static final String FIELD_PSSYSUTILDENAME = "pssysutildename";
    public static final String FIELD_SERVICEPARAM = "serviceparam";
    public static final String FIELD_SERVICEPARAM2 = "serviceparam2";
    public static final String FIELD_SERVICEPATH = "servicepath";
    public static final String FIELD_UNIQUETAG = "uniquetag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTILOBJ = "utilobj";
    public static final String FIELD_UTILPARAM = "utilparam";
    public static final String FIELD_UTILPARAM10 = "utilparam10";
    public static final String FIELD_UTILPARAM11 = "utilparam11";
    public static final String FIELD_UTILPARAM12 = "utilparam12";
    public static final String FIELD_UTILPARAM2 = "utilparam2";
    public static final String FIELD_UTILPARAM3 = "utilparam3";
    public static final String FIELD_UTILPARAM4 = "utilparam4";
    public static final String FIELD_UTILPARAM5 = "utilparam5";
    public static final String FIELD_UTILPARAM6 = "utilparam6";
    public static final String FIELD_UTILPARAM7 = "utilparam7";
    public static final String FIELD_UTILPARAM8 = "utilparam8";
    public static final String FIELD_UTILPARAM9 = "utilparam9";
    public static final String FIELD_UTILPARAMS = "utilparams";
    public static final String FIELD_UTILPSDE10ID = "utilpsde10id";
    public static final String FIELD_UTILPSDE10NAME = "utilpsde10name";
    public static final String FIELD_UTILPSDE11ID = "utilpsde11id";
    public static final String FIELD_UTILPSDE11NAME = "utilpsde11name";
    public static final String FIELD_UTILPSDE12ID = "utilpsde12id";
    public static final String FIELD_UTILPSDE12NAME = "utilpsde12name";
    public static final String FIELD_UTILPSDE13ID = "utilpsde13id";
    public static final String FIELD_UTILPSDE13NAME = "utilpsde13name";
    public static final String FIELD_UTILPSDE14ID = "utilpsde14id";
    public static final String FIELD_UTILPSDE14NAME = "utilpsde14name";
    public static final String FIELD_UTILPSDE15ID = "utilpsde15id";
    public static final String FIELD_UTILPSDE15NAME = "utilpsde15name";
    public static final String FIELD_UTILPSDE16ID = "utilpsde16id";
    public static final String FIELD_UTILPSDE16NAME = "utilpsde16name";
    public static final String FIELD_UTILPSDE17ID = "utilpsde17id";
    public static final String FIELD_UTILPSDE17NAME = "utilpsde17name";
    public static final String FIELD_UTILPSDE18ID = "utilpsde18id";
    public static final String FIELD_UTILPSDE18NAME = "utilpsde18name";
    public static final String FIELD_UTILPSDE19ID = "utilpsde19id";
    public static final String FIELD_UTILPSDE19NAME = "utilpsde19name";
    public static final String FIELD_UTILPSDE20ID = "utilpsde20id";
    public static final String FIELD_UTILPSDE20NAME = "utilpsde20name";
    public static final String FIELD_UTILPSDE2ID = "utilpsde2id";
    public static final String FIELD_UTILPSDE2NAME = "utilpsde2name";
    public static final String FIELD_UTILPSDE3ID = "utilpsde3id";
    public static final String FIELD_UTILPSDE3NAME = "utilpsde3name";
    public static final String FIELD_UTILPSDE4ID = "utilpsde4id";
    public static final String FIELD_UTILPSDE4NAME = "utilpsde4name";
    public static final String FIELD_UTILPSDE5ID = "utilpsde5id";
    public static final String FIELD_UTILPSDE5NAME = "utilpsde5name";
    public static final String FIELD_UTILPSDE6ID = "utilpsde6id";
    public static final String FIELD_UTILPSDE6NAME = "utilpsde6name";
    public static final String FIELD_UTILPSDE7ID = "utilpsde7id";
    public static final String FIELD_UTILPSDE7NAME = "utilpsde7name";
    public static final String FIELD_UTILPSDE8ID = "utilpsde8id";
    public static final String FIELD_UTILPSDE8NAME = "utilpsde8name";
    public static final String FIELD_UTILPSDE9ID = "utilpsde9id";
    public static final String FIELD_UTILPSDE9NAME = "utilpsde9name";
    public static final String FIELD_UTILPSDEID = "utilpsdeid";
    public static final String FIELD_UTILPSDENAME = "utilpsdename";
    public static final String FIELD_UTILTAG = "utiltag";
    public static final String FIELD_UTILTAG2 = "utiltag2";
    public static final String FIELD_UTILTYPE = "utiltype";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public String getAuthAccessTokenUri() {
        Object objValue = this.get(FIELD_AUTHACCESSTOKENURI);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authaccesstokenuri")
    public void setAuthAccessTokenUri(String authAccessTokenUri) {
        this.set(FIELD_AUTHACCESSTOKENURI, authAccessTokenUri);
    }

    @JsonIgnore
    public boolean isAuthAccessTokenUriDirty() {
        return this.contains(FIELD_AUTHACCESSTOKENURI);
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
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
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
    public String getPSSysModelGroupId() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupid")
    public void setPSSysModelGroupId(String pSSysModelGroupId) {
        this.set(FIELD_PSSYSMODELGROUPID, pSSysModelGroupId);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupIdDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPID);
    }

    @JsonIgnore
    public String getPSSysModelGroupName() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupname")
    public void setPSSysModelGroupName(String pSSysModelGroupName) {
        this.set(FIELD_PSSYSMODELGROUPNAME, pSSysModelGroupName);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupNameDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPNAME);
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
    public String getUniqueTag() {
        Object objValue = this.get(FIELD_UNIQUETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uniquetag")
    public void setUniqueTag(String uniqueTag) {
        this.set(FIELD_UNIQUETAG, uniqueTag);
    }

    @JsonIgnore
    public boolean isUniqueTagDirty() {
        return this.contains(FIELD_UNIQUETAG);
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
    public String getUtilObj() {
        Object objValue = this.get(FIELD_UTILOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilobj")
    public void setUtilObj(String utilObj) {
        this.set(FIELD_UTILOBJ, utilObj);
    }

    @JsonIgnore
    public boolean isUtilObjDirty() {
        return this.contains(FIELD_UTILOBJ);
    }

    @JsonIgnore
    public String getUtilParam() {
        Object objValue = this.get(FIELD_UTILPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam")
    public void setUtilParam(String utilParam) {
        this.set(FIELD_UTILPARAM, utilParam);
    }

    @JsonIgnore
    public boolean isUtilParamDirty() {
        return this.contains(FIELD_UTILPARAM);
    }

    @JsonIgnore
    public Integer getUtilParam10() {
        Object objValue = this.get(FIELD_UTILPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam10")
    public void setUtilParam10(Integer utilParam10) {
        this.set(FIELD_UTILPARAM10, utilParam10);
    }

    @JsonIgnore
    public boolean isUtilParam10Dirty() {
        return this.contains(FIELD_UTILPARAM10);
    }

    @JsonIgnore
    public String getUtilParam11() {
        Object objValue = this.get(FIELD_UTILPARAM11);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam11")
    public void setUtilParam11(String utilParam11) {
        this.set(FIELD_UTILPARAM11, utilParam11);
    }

    @JsonIgnore
    public boolean isUtilParam11Dirty() {
        return this.contains(FIELD_UTILPARAM11);
    }

    @JsonIgnore
    public String getUtilParam12() {
        Object objValue = this.get(FIELD_UTILPARAM12);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam12")
    public void setUtilParam12(String utilParam12) {
        this.set(FIELD_UTILPARAM12, utilParam12);
    }

    @JsonIgnore
    public boolean isUtilParam12Dirty() {
        return this.contains(FIELD_UTILPARAM12);
    }

    @JsonIgnore
    public String getUtilParam2() {
        Object objValue = this.get(FIELD_UTILPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam2")
    public void setUtilParam2(String utilParam2) {
        this.set(FIELD_UTILPARAM2, utilParam2);
    }

    @JsonIgnore
    public boolean isUtilParam2Dirty() {
        return this.contains(FIELD_UTILPARAM2);
    }

    @JsonIgnore
    public String getUtilParam3() {
        Object objValue = this.get(FIELD_UTILPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam3")
    public void setUtilParam3(String utilParam3) {
        this.set(FIELD_UTILPARAM3, utilParam3);
    }

    @JsonIgnore
    public boolean isUtilParam3Dirty() {
        return this.contains(FIELD_UTILPARAM3);
    }

    @JsonIgnore
    public String getUtilParam4() {
        Object objValue = this.get(FIELD_UTILPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam4")
    public void setUtilParam4(String utilParam4) {
        this.set(FIELD_UTILPARAM4, utilParam4);
    }

    @JsonIgnore
    public boolean isUtilParam4Dirty() {
        return this.contains(FIELD_UTILPARAM4);
    }

    @JsonIgnore
    public Integer getUtilParam5() {
        Object objValue = this.get(FIELD_UTILPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam5")
    public void setUtilParam5(Integer utilParam5) {
        this.set(FIELD_UTILPARAM5, utilParam5);
    }

    @JsonIgnore
    public boolean isUtilParam5Dirty() {
        return this.contains(FIELD_UTILPARAM5);
    }

    @JsonIgnore
    public Integer getUtilParam6() {
        Object objValue = this.get(FIELD_UTILPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam6")
    public void setUtilParam6(Integer utilParam6) {
        this.set(FIELD_UTILPARAM6, utilParam6);
    }

    @JsonIgnore
    public boolean isUtilParam6Dirty() {
        return this.contains(FIELD_UTILPARAM6);
    }

    @JsonIgnore
    public Integer getUtilParam7() {
        Object objValue = this.get(FIELD_UTILPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam7")
    public void setUtilParam7(Integer utilParam7) {
        this.set(FIELD_UTILPARAM7, utilParam7);
    }

    @JsonIgnore
    public boolean isUtilParam7Dirty() {
        return this.contains(FIELD_UTILPARAM7);
    }

    @JsonIgnore
    public Integer getUtilParam8() {
        Object objValue = this.get(FIELD_UTILPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam8")
    public void setUtilParam8(Integer utilParam8) {
        this.set(FIELD_UTILPARAM8, utilParam8);
    }

    @JsonIgnore
    public boolean isUtilParam8Dirty() {
        return this.contains(FIELD_UTILPARAM8);
    }

    @JsonIgnore
    public Integer getUtilParam9() {
        Object objValue = this.get(FIELD_UTILPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam9")
    public void setUtilParam9(Integer utilParam9) {
        this.set(FIELD_UTILPARAM9, utilParam9);
    }

    @JsonIgnore
    public boolean isUtilParam9Dirty() {
        return this.contains(FIELD_UTILPARAM9);
    }

    @JsonIgnore
    public String getUtilParams() {
        Object objValue = this.get(FIELD_UTILPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparams")
    public void setUtilParams(String utilParams) {
        this.set(FIELD_UTILPARAMS, utilParams);
    }

    @JsonIgnore
    public boolean isUtilParamsDirty() {
        return this.contains(FIELD_UTILPARAMS);
    }

    @JsonIgnore
    public String getUtilPSDE10Id() {
        Object objValue = this.get(FIELD_UTILPSDE10ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde10id")
    public void setUtilPSDE10Id(String utilPSDE10Id) {
        this.set(FIELD_UTILPSDE10ID, utilPSDE10Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE10IdDirty() {
        return this.contains(FIELD_UTILPSDE10ID);
    }

    @JsonIgnore
    public String getUtilPSDE10Name() {
        Object objValue = this.get(FIELD_UTILPSDE10NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde10name")
    public void setUtilPSDE10Name(String utilPSDE10Name) {
        this.set(FIELD_UTILPSDE10NAME, utilPSDE10Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE10NameDirty() {
        return this.contains(FIELD_UTILPSDE10NAME);
    }

    @JsonIgnore
    public String getUtilPSDE11Id() {
        Object objValue = this.get(FIELD_UTILPSDE11ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde11id")
    public void setUtilPSDE11Id(String utilPSDE11Id) {
        this.set(FIELD_UTILPSDE11ID, utilPSDE11Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE11IdDirty() {
        return this.contains(FIELD_UTILPSDE11ID);
    }

    @JsonIgnore
    public String getUtilPSDE11Name() {
        Object objValue = this.get(FIELD_UTILPSDE11NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde11name")
    public void setUtilPSDE11Name(String utilPSDE11Name) {
        this.set(FIELD_UTILPSDE11NAME, utilPSDE11Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE11NameDirty() {
        return this.contains(FIELD_UTILPSDE11NAME);
    }

    @JsonIgnore
    public String getUtilPSDE12Id() {
        Object objValue = this.get(FIELD_UTILPSDE12ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde12id")
    public void setUtilPSDE12Id(String utilPSDE12Id) {
        this.set(FIELD_UTILPSDE12ID, utilPSDE12Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE12IdDirty() {
        return this.contains(FIELD_UTILPSDE12ID);
    }

    @JsonIgnore
    public String getUtilPSDE12Name() {
        Object objValue = this.get(FIELD_UTILPSDE12NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde12name")
    public void setUtilPSDE12Name(String utilPSDE12Name) {
        this.set(FIELD_UTILPSDE12NAME, utilPSDE12Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE12NameDirty() {
        return this.contains(FIELD_UTILPSDE12NAME);
    }

    @JsonIgnore
    public String getUtilPSDE13Id() {
        Object objValue = this.get(FIELD_UTILPSDE13ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde13id")
    public void setUtilPSDE13Id(String utilPSDE13Id) {
        this.set(FIELD_UTILPSDE13ID, utilPSDE13Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE13IdDirty() {
        return this.contains(FIELD_UTILPSDE13ID);
    }

    @JsonIgnore
    public String getUtilPSDE13Name() {
        Object objValue = this.get(FIELD_UTILPSDE13NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde13name")
    public void setUtilPSDE13Name(String utilPSDE13Name) {
        this.set(FIELD_UTILPSDE13NAME, utilPSDE13Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE13NameDirty() {
        return this.contains(FIELD_UTILPSDE13NAME);
    }

    @JsonIgnore
    public String getUtilPSDE14Id() {
        Object objValue = this.get(FIELD_UTILPSDE14ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde14id")
    public void setUtilPSDE14Id(String utilPSDE14Id) {
        this.set(FIELD_UTILPSDE14ID, utilPSDE14Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE14IdDirty() {
        return this.contains(FIELD_UTILPSDE14ID);
    }

    @JsonIgnore
    public String getUtilPSDE14Name() {
        Object objValue = this.get(FIELD_UTILPSDE14NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde14name")
    public void setUtilPSDE14Name(String utilPSDE14Name) {
        this.set(FIELD_UTILPSDE14NAME, utilPSDE14Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE14NameDirty() {
        return this.contains(FIELD_UTILPSDE14NAME);
    }

    @JsonIgnore
    public String getUtilPSDE15Id() {
        Object objValue = this.get(FIELD_UTILPSDE15ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde15id")
    public void setUtilPSDE15Id(String utilPSDE15Id) {
        this.set(FIELD_UTILPSDE15ID, utilPSDE15Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE15IdDirty() {
        return this.contains(FIELD_UTILPSDE15ID);
    }

    @JsonIgnore
    public String getUtilPSDE15Name() {
        Object objValue = this.get(FIELD_UTILPSDE15NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde15name")
    public void setUtilPSDE15Name(String utilPSDE15Name) {
        this.set(FIELD_UTILPSDE15NAME, utilPSDE15Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE15NameDirty() {
        return this.contains(FIELD_UTILPSDE15NAME);
    }

    @JsonIgnore
    public String getUtilPSDE16Id() {
        Object objValue = this.get(FIELD_UTILPSDE16ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde16id")
    public void setUtilPSDE16Id(String utilPSDE16Id) {
        this.set(FIELD_UTILPSDE16ID, utilPSDE16Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE16IdDirty() {
        return this.contains(FIELD_UTILPSDE16ID);
    }

    @JsonIgnore
    public String getUtilPSDE16Name() {
        Object objValue = this.get(FIELD_UTILPSDE16NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde16name")
    public void setUtilPSDE16Name(String utilPSDE16Name) {
        this.set(FIELD_UTILPSDE16NAME, utilPSDE16Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE16NameDirty() {
        return this.contains(FIELD_UTILPSDE16NAME);
    }

    @JsonIgnore
    public String getUtilPSDE17Id() {
        Object objValue = this.get(FIELD_UTILPSDE17ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde17id")
    public void setUtilPSDE17Id(String utilPSDE17Id) {
        this.set(FIELD_UTILPSDE17ID, utilPSDE17Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE17IdDirty() {
        return this.contains(FIELD_UTILPSDE17ID);
    }

    @JsonIgnore
    public String getUtilPSDE17Name() {
        Object objValue = this.get(FIELD_UTILPSDE17NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde17name")
    public void setUtilPSDE17Name(String utilPSDE17Name) {
        this.set(FIELD_UTILPSDE17NAME, utilPSDE17Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE17NameDirty() {
        return this.contains(FIELD_UTILPSDE17NAME);
    }

    @JsonIgnore
    public String getUtilPSDE18Id() {
        Object objValue = this.get(FIELD_UTILPSDE18ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde18id")
    public void setUtilPSDE18Id(String utilPSDE18Id) {
        this.set(FIELD_UTILPSDE18ID, utilPSDE18Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE18IdDirty() {
        return this.contains(FIELD_UTILPSDE18ID);
    }

    @JsonIgnore
    public String getUtilPSDE18Name() {
        Object objValue = this.get(FIELD_UTILPSDE18NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde18name")
    public void setUtilPSDE18Name(String utilPSDE18Name) {
        this.set(FIELD_UTILPSDE18NAME, utilPSDE18Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE18NameDirty() {
        return this.contains(FIELD_UTILPSDE18NAME);
    }

    @JsonIgnore
    public String getUtilPSDE19Id() {
        Object objValue = this.get(FIELD_UTILPSDE19ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde19id")
    public void setUtilPSDE19Id(String utilPSDE19Id) {
        this.set(FIELD_UTILPSDE19ID, utilPSDE19Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE19IdDirty() {
        return this.contains(FIELD_UTILPSDE19ID);
    }

    @JsonIgnore
    public String getUtilPSDE19Name() {
        Object objValue = this.get(FIELD_UTILPSDE19NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde19name")
    public void setUtilPSDE19Name(String utilPSDE19Name) {
        this.set(FIELD_UTILPSDE19NAME, utilPSDE19Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE19NameDirty() {
        return this.contains(FIELD_UTILPSDE19NAME);
    }

    @JsonIgnore
    public String getUtilPSDE20Id() {
        Object objValue = this.get(FIELD_UTILPSDE20ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde20id")
    public void setUtilPSDE20Id(String utilPSDE20Id) {
        this.set(FIELD_UTILPSDE20ID, utilPSDE20Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE20IdDirty() {
        return this.contains(FIELD_UTILPSDE20ID);
    }

    @JsonIgnore
    public String getUtilPSDE20Name() {
        Object objValue = this.get(FIELD_UTILPSDE20NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde20name")
    public void setUtilPSDE20Name(String utilPSDE20Name) {
        this.set(FIELD_UTILPSDE20NAME, utilPSDE20Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE20NameDirty() {
        return this.contains(FIELD_UTILPSDE20NAME);
    }

    @JsonIgnore
    public String getUtilPSDE2Id() {
        Object objValue = this.get(FIELD_UTILPSDE2ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde2id")
    public void setUtilPSDE2Id(String utilPSDE2Id) {
        this.set(FIELD_UTILPSDE2ID, utilPSDE2Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE2IdDirty() {
        return this.contains(FIELD_UTILPSDE2ID);
    }

    @JsonIgnore
    public String getUtilPSDE2Name() {
        Object objValue = this.get(FIELD_UTILPSDE2NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde2name")
    public void setUtilPSDE2Name(String utilPSDE2Name) {
        this.set(FIELD_UTILPSDE2NAME, utilPSDE2Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE2NameDirty() {
        return this.contains(FIELD_UTILPSDE2NAME);
    }

    @JsonIgnore
    public String getUtilPSDE3Id() {
        Object objValue = this.get(FIELD_UTILPSDE3ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde3id")
    public void setUtilPSDE3Id(String utilPSDE3Id) {
        this.set(FIELD_UTILPSDE3ID, utilPSDE3Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE3IdDirty() {
        return this.contains(FIELD_UTILPSDE3ID);
    }

    @JsonIgnore
    public String getUtilPSDE3Name() {
        Object objValue = this.get(FIELD_UTILPSDE3NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde3name")
    public void setUtilPSDE3Name(String utilPSDE3Name) {
        this.set(FIELD_UTILPSDE3NAME, utilPSDE3Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE3NameDirty() {
        return this.contains(FIELD_UTILPSDE3NAME);
    }

    @JsonIgnore
    public String getUtilPSDE4Id() {
        Object objValue = this.get(FIELD_UTILPSDE4ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde4id")
    public void setUtilPSDE4Id(String utilPSDE4Id) {
        this.set(FIELD_UTILPSDE4ID, utilPSDE4Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE4IdDirty() {
        return this.contains(FIELD_UTILPSDE4ID);
    }

    @JsonIgnore
    public String getUtilPSDE4Name() {
        Object objValue = this.get(FIELD_UTILPSDE4NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde4name")
    public void setUtilPSDE4Name(String utilPSDE4Name) {
        this.set(FIELD_UTILPSDE4NAME, utilPSDE4Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE4NameDirty() {
        return this.contains(FIELD_UTILPSDE4NAME);
    }

    @JsonIgnore
    public String getUtilPSDE5Id() {
        Object objValue = this.get(FIELD_UTILPSDE5ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde5id")
    public void setUtilPSDE5Id(String utilPSDE5Id) {
        this.set(FIELD_UTILPSDE5ID, utilPSDE5Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE5IdDirty() {
        return this.contains(FIELD_UTILPSDE5ID);
    }

    @JsonIgnore
    public String getUtilPSDE5Name() {
        Object objValue = this.get(FIELD_UTILPSDE5NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde5name")
    public void setUtilPSDE5Name(String utilPSDE5Name) {
        this.set(FIELD_UTILPSDE5NAME, utilPSDE5Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE5NameDirty() {
        return this.contains(FIELD_UTILPSDE5NAME);
    }

    @JsonIgnore
    public String getUtilPSDE6Id() {
        Object objValue = this.get(FIELD_UTILPSDE6ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde6id")
    public void setUtilPSDE6Id(String utilPSDE6Id) {
        this.set(FIELD_UTILPSDE6ID, utilPSDE6Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE6IdDirty() {
        return this.contains(FIELD_UTILPSDE6ID);
    }

    @JsonIgnore
    public String getUtilPSDE6Name() {
        Object objValue = this.get(FIELD_UTILPSDE6NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde6name")
    public void setUtilPSDE6Name(String utilPSDE6Name) {
        this.set(FIELD_UTILPSDE6NAME, utilPSDE6Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE6NameDirty() {
        return this.contains(FIELD_UTILPSDE6NAME);
    }

    @JsonIgnore
    public String getUtilPSDE7Id() {
        Object objValue = this.get(FIELD_UTILPSDE7ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde7id")
    public void setUtilPSDE7Id(String utilPSDE7Id) {
        this.set(FIELD_UTILPSDE7ID, utilPSDE7Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE7IdDirty() {
        return this.contains(FIELD_UTILPSDE7ID);
    }

    @JsonIgnore
    public String getUtilPSDE7Name() {
        Object objValue = this.get(FIELD_UTILPSDE7NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde7name")
    public void setUtilPSDE7Name(String utilPSDE7Name) {
        this.set(FIELD_UTILPSDE7NAME, utilPSDE7Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE7NameDirty() {
        return this.contains(FIELD_UTILPSDE7NAME);
    }

    @JsonIgnore
    public String getUtilPSDE8Id() {
        Object objValue = this.get(FIELD_UTILPSDE8ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde8id")
    public void setUtilPSDE8Id(String utilPSDE8Id) {
        this.set(FIELD_UTILPSDE8ID, utilPSDE8Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE8IdDirty() {
        return this.contains(FIELD_UTILPSDE8ID);
    }

    @JsonIgnore
    public String getUtilPSDE8Name() {
        Object objValue = this.get(FIELD_UTILPSDE8NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde8name")
    public void setUtilPSDE8Name(String utilPSDE8Name) {
        this.set(FIELD_UTILPSDE8NAME, utilPSDE8Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE8NameDirty() {
        return this.contains(FIELD_UTILPSDE8NAME);
    }

    @JsonIgnore
    public String getUtilPSDE9Id() {
        Object objValue = this.get(FIELD_UTILPSDE9ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde9id")
    public void setUtilPSDE9Id(String utilPSDE9Id) {
        this.set(FIELD_UTILPSDE9ID, utilPSDE9Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE9IdDirty() {
        return this.contains(FIELD_UTILPSDE9ID);
    }

    @JsonIgnore
    public String getUtilPSDE9Name() {
        Object objValue = this.get(FIELD_UTILPSDE9NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde9name")
    public void setUtilPSDE9Name(String utilPSDE9Name) {
        this.set(FIELD_UTILPSDE9NAME, utilPSDE9Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE9NameDirty() {
        return this.contains(FIELD_UTILPSDE9NAME);
    }

    @JsonIgnore
    public String getUtilPSDEId() {
        Object objValue = this.get(FIELD_UTILPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeid")
    public void setUtilPSDEId(String utilPSDEId) {
        this.set(FIELD_UTILPSDEID, utilPSDEId);
    }

    @JsonIgnore
    public boolean isUtilPSDEIdDirty() {
        return this.contains(FIELD_UTILPSDEID);
    }

    @JsonIgnore
    public String getUtilPSDEName() {
        Object objValue = this.get(FIELD_UTILPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdename")
    public void setUtilPSDEName(String utilPSDEName) {
        this.set(FIELD_UTILPSDENAME, utilPSDEName);
    }

    @JsonIgnore
    public boolean isUtilPSDENameDirty() {
        return this.contains(FIELD_UTILPSDENAME);
    }

    @JsonIgnore
    public String getUtilTag() {
        Object objValue = this.get(FIELD_UTILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltag")
    public void setUtilTag(String utilTag) {
        this.set(FIELD_UTILTAG, utilTag);
    }

    @JsonIgnore
    public boolean isUtilTagDirty() {
        return this.contains(FIELD_UTILTAG);
    }

    @JsonIgnore
    public String getUtilTag2() {
        Object objValue = this.get(FIELD_UTILTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltag2")
    public void setUtilTag2(String utilTag2) {
        this.set(FIELD_UTILTAG2, utilTag2);
    }

    @JsonIgnore
    public boolean isUtilTag2Dirty() {
        return this.contains(FIELD_UTILTAG2);
    }

    @JsonIgnore
    public String getUtilType() {
        Object objValue = this.get(FIELD_UTILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltype")
    public void setUtilType(String utilType) {
        this.set(FIELD_UTILTYPE, utilType);
    }

    @JsonIgnore
    public boolean isUtilTypeDirty() {
        return this.contains(FIELD_UTILTYPE);
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
        return this.getPSSysUtilDEId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysUtilDEId(strValue);
    }
}

