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

public class PSSysServiceAPIDTO
extends PSModelDTOBase {
    public static final String FIELD_APILEVEL = "apilevel";
    public static final String FIELD_APIMODE = "apimode";
    public static final String FIELD_APITAG = "apitag";
    public static final String FIELD_APITAG2 = "apitag2";
    public static final String FIELD_APITYPE = "apitype";
    public static final String FIELD_AUTHCHECKTOKENURI = "authchecktokenuri";
    public static final String FIELD_AUTHCLIENTID = "authclientid";
    public static final String FIELD_AUTHCLIENTSECRET = "authclientsecret";
    public static final String FIELD_AUTHMODE = "authmode";
    public static final String FIELD_AUTHPARAM = "authparam";
    public static final String FIELD_AUTHPARAM2 = "authparam2";
    public static final String FIELD_AUTHPARAM3 = "authparam3";
    public static final String FIELD_AUTHPARAM4 = "authparam4";
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_CFGPSMODELSTORAGEID = "cfgpsmodelstorageid";
    public static final String FIELD_CFGTAG = "cfgtag";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPORT = "defaultport";
    public static final String FIELD_DEFAULTPSDEOPPRIVID = "defaultpsdeopprivid";
    public static final String FIELD_DEFAULTPSDEOPPRIVNAME = "defaultpsdeopprivname";
    public static final String FIELD_DEFCREATEREQMETHOD = "defcreatereqmethod";
    public static final String FIELD_DEFDEACTIONREQMETHOD = "defdeactionreqmethod";
    public static final String FIELD_DEFDEDATASETREQMETHOD = "defdedatasetreqmethod";
    public static final String FIELD_DEFDELETEREQMETHOD = "defdeletereqmethod";
    public static final String FIELD_DEFGETREQMETHOD = "defgetreqmethod";
    public static final String FIELD_DEFNEEDRESOURCEKEY = "defneedresourcekey";
    public static final String FIELD_DEFSELECTREQMETHOD = "defselectreqmethod";
    public static final String FIELD_DEFUPDATEREQMETHOD = "defupdatereqmethod";
    public static final String FIELD_DEPSSYSSFPLUGINID = "depssyssfpluginid";
    public static final String FIELD_DEPSSYSSFPLUGINNAME = "depssyssfpluginname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSAHANDLERID = "pssyssahandlerid";
    public static final String FIELD_PSSYSSAHANDLERNAME = "pssyssahandlername";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_RESETDEFACTIONCODENAME = "resetdefactioncodename";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_SERVICEDTOFLAG = "servicedtoflag";
    public static final String FIELD_SERVICEPARAM = "serviceparam";
    public static final String FIELD_SERVICEPARAM2 = "serviceparam2";
    public static final String FIELD_SERVICEPARAM3 = "serviceparam3";
    public static final String FIELD_SERVICEPARAM4 = "serviceparam4";
    public static final String FIELD_SERVICEPARAMS = "serviceparams";
    public static final String FIELD_SERVICETYPE = "servicetype";
    public static final String FIELD_UNIQUETAG = "uniquetag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VER = "ver";

    @JsonIgnore
    public Integer getAPILevel() {
        Object objValue = this.get(FIELD_APILEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="apilevel")
    public void setAPILevel(Integer aPILevel) {
        this.set(FIELD_APILEVEL, aPILevel);
    }

    @JsonIgnore
    public boolean isAPILevelDirty() {
        return this.contains(FIELD_APILEVEL);
    }

    @JsonIgnore
    public Integer getAPIMode() {
        Object objValue = this.get(FIELD_APIMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="apimode")
    public void setAPIMode(Integer aPIMode) {
        this.set(FIELD_APIMODE, aPIMode);
    }

    @JsonIgnore
    public boolean isAPIModeDirty() {
        return this.contains(FIELD_APIMODE);
    }

    @JsonIgnore
    public String getAPITag() {
        Object objValue = this.get(FIELD_APITAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apitag")
    public void setAPITag(String aPITag) {
        this.set(FIELD_APITAG, aPITag);
    }

    @JsonIgnore
    public boolean isAPITagDirty() {
        return this.contains(FIELD_APITAG);
    }

    @JsonIgnore
    public String getAPITag2() {
        Object objValue = this.get(FIELD_APITAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apitag2")
    public void setAPITag2(String aPITag2) {
        this.set(FIELD_APITAG2, aPITag2);
    }

    @JsonIgnore
    public boolean isAPITag2Dirty() {
        return this.contains(FIELD_APITAG2);
    }

    @JsonIgnore
    public String getAPIType() {
        Object objValue = this.get(FIELD_APITYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apitype")
    public void setAPIType(String aPIType) {
        this.set(FIELD_APITYPE, aPIType);
    }

    @JsonIgnore
    public boolean isAPITypeDirty() {
        return this.contains(FIELD_APITYPE);
    }

    @JsonIgnore
    public String getAuthCheckTokenUri() {
        Object objValue = this.get(FIELD_AUTHCHECKTOKENURI);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authchecktokenuri")
    public void setAuthCheckTokenUri(String authCheckTokenUri) {
        this.set(FIELD_AUTHCHECKTOKENURI, authCheckTokenUri);
    }

    @JsonIgnore
    public boolean isAuthCheckTokenUriDirty() {
        return this.contains(FIELD_AUTHCHECKTOKENURI);
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
    public String getAuthParam3() {
        Object objValue = this.get(FIELD_AUTHPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authparam3")
    public void setAuthParam3(String authParam3) {
        this.set(FIELD_AUTHPARAM3, authParam3);
    }

    @JsonIgnore
    public boolean isAuthParam3Dirty() {
        return this.contains(FIELD_AUTHPARAM3);
    }

    @JsonIgnore
    public String getAuthParam4() {
        Object objValue = this.get(FIELD_AUTHPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="authparam4")
    public void setAuthParam4(String authParam4) {
        this.set(FIELD_AUTHPARAM4, authParam4);
    }

    @JsonIgnore
    public boolean isAuthParam4Dirty() {
        return this.contains(FIELD_AUTHPARAM4);
    }

    @JsonIgnore
    public String getBaseClsParams() {
        Object objValue = this.get(FIELD_BASECLSPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclsparams")
    public void setBaseClsParams(String baseClsParams) {
        this.set(FIELD_BASECLSPARAMS, baseClsParams);
    }

    @JsonIgnore
    public boolean isBaseClsParamsDirty() {
        return this.contains(FIELD_BASECLSPARAMS);
    }

    @JsonIgnore
    public String getCfgPSModelStorageId() {
        Object objValue = this.get(FIELD_CFGPSMODELSTORAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cfgpsmodelstorageid")
    public void setCfgPSModelStorageId(String cfgPSModelStorageId) {
        this.set(FIELD_CFGPSMODELSTORAGEID, cfgPSModelStorageId);
    }

    @JsonIgnore
    public boolean isCfgPSModelStorageIdDirty() {
        return this.contains(FIELD_CFGPSMODELSTORAGEID);
    }

    @JsonIgnore
    public String getCfgTag() {
        Object objValue = this.get(FIELD_CFGTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cfgtag")
    public void setCfgTag(String cfgTag) {
        this.set(FIELD_CFGTAG, cfgTag);
    }

    @JsonIgnore
    public boolean isCfgTagDirty() {
        return this.contains(FIELD_CFGTAG);
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
    public Integer getDefaultPort() {
        Object objValue = this.get(FIELD_DEFAULTPORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultport")
    public void setDefaultPort(Integer defaultPort) {
        this.set(FIELD_DEFAULTPORT, defaultPort);
    }

    @JsonIgnore
    public boolean isDefaultPortDirty() {
        return this.contains(FIELD_DEFAULTPORT);
    }

    @JsonIgnore
    public String getDefaultPSDEOPPrivId() {
        Object objValue = this.get(FIELD_DEFAULTPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultpsdeopprivid")
    public void setDefaultPSDEOPPrivId(String defaultPSDEOPPrivId) {
        this.set(FIELD_DEFAULTPSDEOPPRIVID, defaultPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isDefaultPSDEOPPrivIdDirty() {
        return this.contains(FIELD_DEFAULTPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getDefaultPSDEOPPrivName() {
        Object objValue = this.get(FIELD_DEFAULTPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultpsdeopprivname")
    public void setDefaultPSDEOPPrivName(String defaultPSDEOPPrivName) {
        this.set(FIELD_DEFAULTPSDEOPPRIVNAME, defaultPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isDefaultPSDEOPPrivNameDirty() {
        return this.contains(FIELD_DEFAULTPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getDefCreateReqMethod() {
        Object objValue = this.get(FIELD_DEFCREATEREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defcreatereqmethod")
    public void setDefCreateReqMethod(String defCreateReqMethod) {
        this.set(FIELD_DEFCREATEREQMETHOD, defCreateReqMethod);
    }

    @JsonIgnore
    public boolean isDefCreateReqMethodDirty() {
        return this.contains(FIELD_DEFCREATEREQMETHOD);
    }

    @JsonIgnore
    public String getDefDEActionReqMethod() {
        Object objValue = this.get(FIELD_DEFDEACTIONREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defdeactionreqmethod")
    public void setDefDEActionReqMethod(String defDEActionReqMethod) {
        this.set(FIELD_DEFDEACTIONREQMETHOD, defDEActionReqMethod);
    }

    @JsonIgnore
    public boolean isDefDEActionReqMethodDirty() {
        return this.contains(FIELD_DEFDEACTIONREQMETHOD);
    }

    @JsonIgnore
    public String getDefDEDataSetReqMethod() {
        Object objValue = this.get(FIELD_DEFDEDATASETREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defdedatasetreqmethod")
    public void setDefDEDataSetReqMethod(String defDEDataSetReqMethod) {
        this.set(FIELD_DEFDEDATASETREQMETHOD, defDEDataSetReqMethod);
    }

    @JsonIgnore
    public boolean isDefDEDataSetReqMethodDirty() {
        return this.contains(FIELD_DEFDEDATASETREQMETHOD);
    }

    @JsonIgnore
    public String getDefDeleteReqMethod() {
        Object objValue = this.get(FIELD_DEFDELETEREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defdeletereqmethod")
    public void setDefDeleteReqMethod(String defDeleteReqMethod) {
        this.set(FIELD_DEFDELETEREQMETHOD, defDeleteReqMethod);
    }

    @JsonIgnore
    public boolean isDefDeleteReqMethodDirty() {
        return this.contains(FIELD_DEFDELETEREQMETHOD);
    }

    @JsonIgnore
    public String getDefGetReqMethod() {
        Object objValue = this.get(FIELD_DEFGETREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defgetreqmethod")
    public void setDefGetReqMethod(String defGetReqMethod) {
        this.set(FIELD_DEFGETREQMETHOD, defGetReqMethod);
    }

    @JsonIgnore
    public boolean isDefGetReqMethodDirty() {
        return this.contains(FIELD_DEFGETREQMETHOD);
    }

    @JsonIgnore
    public Integer getDefNeedResourceKey() {
        Object objValue = this.get(FIELD_DEFNEEDRESOURCEKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defneedresourcekey")
    public void setDefNeedResourceKey(Integer defNeedResourceKey) {
        this.set(FIELD_DEFNEEDRESOURCEKEY, defNeedResourceKey);
    }

    @JsonIgnore
    public boolean isDefNeedResourceKeyDirty() {
        return this.contains(FIELD_DEFNEEDRESOURCEKEY);
    }

    @JsonIgnore
    public String getDefSelectReqMethod() {
        Object objValue = this.get(FIELD_DEFSELECTREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defselectreqmethod")
    public void setDefSelectReqMethod(String defSelectReqMethod) {
        this.set(FIELD_DEFSELECTREQMETHOD, defSelectReqMethod);
    }

    @JsonIgnore
    public boolean isDefSelectReqMethodDirty() {
        return this.contains(FIELD_DEFSELECTREQMETHOD);
    }

    @JsonIgnore
    public String getDefUpdateReqMethod() {
        Object objValue = this.get(FIELD_DEFUPDATEREQMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defupdatereqmethod")
    public void setDefUpdateReqMethod(String defUpdateReqMethod) {
        this.set(FIELD_DEFUPDATEREQMETHOD, defUpdateReqMethod);
    }

    @JsonIgnore
    public boolean isDefUpdateReqMethodDirty() {
        return this.contains(FIELD_DEFUPDATEREQMETHOD);
    }

    @JsonIgnore
    public String getDEPSSysSFPluginId() {
        Object objValue = this.get(FIELD_DEPSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="depssyssfpluginid")
    public void setDEPSSysSFPluginId(String dEPSSysSFPluginId) {
        this.set(FIELD_DEPSSYSSFPLUGINID, dEPSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isDEPSSysSFPluginIdDirty() {
        return this.contains(FIELD_DEPSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getDEPSSysSFPluginName() {
        Object objValue = this.get(FIELD_DEPSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="depssyssfpluginname")
    public void setDEPSSysSFPluginName(String dEPSSysSFPluginName) {
        this.set(FIELD_DEPSSYSSFPLUGINNAME, dEPSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isDEPSSysSFPluginNameDirty() {
        return this.contains(FIELD_DEPSSYSSFPLUGINNAME);
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
    public String getPSSysSAHandlerId() {
        Object objValue = this.get(FIELD_PSSYSSAHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssahandlerid")
    public void setPSSysSAHandlerId(String pSSysSAHandlerId) {
        this.set(FIELD_PSSYSSAHANDLERID, pSSysSAHandlerId);
    }

    @JsonIgnore
    public boolean isPSSysSAHandlerIdDirty() {
        return this.contains(FIELD_PSSYSSAHANDLERID);
    }

    @JsonIgnore
    public String getPSSysSAHandlerName() {
        Object objValue = this.get(FIELD_PSSYSSAHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssahandlername")
    public void setPSSysSAHandlerName(String pSSysSAHandlerName) {
        this.set(FIELD_PSSYSSAHANDLERNAME, pSSysSAHandlerName);
    }

    @JsonIgnore
    public boolean isPSSysSAHandlerNameDirty() {
        return this.contains(FIELD_PSSYSSAHANDLERNAME);
    }

    @JsonIgnore
    public String getPSSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiid")
    public void setPSSysServiceAPIId(String pSSysServiceAPIId) {
        this.set(FIELD_PSSYSSERVICEAPIID, pSSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiname")
    public void setPSSysServiceAPIName(String pSSysServiceAPIName) {
        this.set(FIELD_PSSYSSERVICEAPINAME, pSSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPINAME);
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
    public Integer getResetDefActionCodeName() {
        Object objValue = this.get(FIELD_RESETDEFACTIONCODENAME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="resetdefactioncodename")
    public void setResetDefActionCodeName(Integer resetDefActionCodeName) {
        this.set(FIELD_RESETDEFACTIONCODENAME, resetDefActionCodeName);
    }

    @JsonIgnore
    public boolean isResetDefActionCodeNameDirty() {
        return this.contains(FIELD_RESETDEFACTIONCODENAME);
    }

    @JsonIgnore
    public String getServiceCodeName() {
        Object objValue = this.get(FIELD_SERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicecodename")
    public void setServiceCodeName(String serviceCodeName) {
        this.set(FIELD_SERVICECODENAME, serviceCodeName);
    }

    @JsonIgnore
    public boolean isServiceCodeNameDirty() {
        return this.contains(FIELD_SERVICECODENAME);
    }

    @JsonIgnore
    public Integer getServiceDTOFlag() {
        Object objValue = this.get(FIELD_SERVICEDTOFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="servicedtoflag")
    public void setServiceDTOFlag(Integer serviceDTOFlag) {
        this.set(FIELD_SERVICEDTOFLAG, serviceDTOFlag);
    }

    @JsonIgnore
    public boolean isServiceDTOFlagDirty() {
        return this.contains(FIELD_SERVICEDTOFLAG);
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
    public String getServiceParam3() {
        Object objValue = this.get(FIELD_SERVICEPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceparam3")
    public void setServiceParam3(String serviceParam3) {
        this.set(FIELD_SERVICEPARAM3, serviceParam3);
    }

    @JsonIgnore
    public boolean isServiceParam3Dirty() {
        return this.contains(FIELD_SERVICEPARAM3);
    }

    @JsonIgnore
    public String getServiceParam4() {
        Object objValue = this.get(FIELD_SERVICEPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceparam4")
    public void setServiceParam4(String serviceParam4) {
        this.set(FIELD_SERVICEPARAM4, serviceParam4);
    }

    @JsonIgnore
    public boolean isServiceParam4Dirty() {
        return this.contains(FIELD_SERVICEPARAM4);
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
    public String getServiceType() {
        Object objValue = this.get(FIELD_SERVICETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicetype")
    public void setServiceType(String serviceType) {
        this.set(FIELD_SERVICETYPE, serviceType);
    }

    @JsonIgnore
    public boolean isServiceTypeDirty() {
        return this.contains(FIELD_SERVICETYPE);
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
    public Integer getVer() {
        Object objValue = this.get(FIELD_VER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ver")
    public void setVer(Integer ver) {
        this.set(FIELD_VER, ver);
    }

    @JsonIgnore
    public boolean isVerDirty() {
        return this.contains(FIELD_VER);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysServiceAPIId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysServiceAPIId(strValue);
    }
}

