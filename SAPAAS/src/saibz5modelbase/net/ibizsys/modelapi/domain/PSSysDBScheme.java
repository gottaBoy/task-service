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
import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBProc;
import net.ibizsys.modelapi.domain.PSSysDBTable;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysDBScheme
extends PSModelBase {
    public static final String FIELD_AUTOEXTENDMODEL = "autoextendmodel";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_ENABLESERVICEAPI = "enableserviceapi";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "enablesubsysserviceapi";
    public static final String FIELD_EXISTINGMODEL = "existingmodel";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSDBSCHEMEID = "pssysdbschemeid";
    public static final String FIELD_PSSYSDBSCHEMENAME = "pssysdbschemename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SCHEMEPARAMS = "schemeparams";
    public static final String FIELD_SCHEMETAG = "schemetag";
    public static final String FIELD_SCHEMETAG2 = "schemetag2";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_SUBSYSSERVICECODENAME = "subsysservicecodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSSysDBProc> pssysdbprocs;
    private List<PSSysDBTable> pssysdbtables;

    @JsonIgnore
    public Integer getAutoExtendModel() {
        Object objValue = this.get(FIELD_AUTOEXTENDMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autoextendmodel")
    public void setAutoExtendModel(Integer autoExtendModel) {
        this.set(FIELD_AUTOEXTENDMODEL, autoExtendModel);
    }

    @JsonIgnore
    public boolean isAutoExtendModelDirty() {
        return this.contains(FIELD_AUTOEXTENDMODEL);
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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
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
    public String getDSLink() {
        Object objValue = this.get(FIELD_DSLINK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dslink")
    public void setDSLink(String dSLink) {
        this.set(FIELD_DSLINK, dSLink);
    }

    @JsonIgnore
    public boolean isDSLinkDirty() {
        return this.contains(FIELD_DSLINK);
    }

    @JsonIgnore
    public Integer getEnableServiceAPI() {
        Object objValue = this.get(FIELD_ENABLESERVICEAPI);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableserviceapi")
    public void setEnableServiceAPI(Integer enableServiceAPI) {
        this.set(FIELD_ENABLESERVICEAPI, enableServiceAPI);
    }

    @JsonIgnore
    public boolean isEnableServiceAPIDirty() {
        return this.contains(FIELD_ENABLESERVICEAPI);
    }

    @JsonIgnore
    public Integer getEnableSubSysServiceAPI() {
        Object objValue = this.get(FIELD_ENABLESUBSYSSERVICEAPI);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesubsysserviceapi")
    public void setEnableSubSysServiceAPI(Integer enableSubSysServiceAPI) {
        this.set(FIELD_ENABLESUBSYSSERVICEAPI, enableSubSysServiceAPI);
    }

    @JsonIgnore
    public boolean isEnableSubSysServiceAPIDirty() {
        return this.contains(FIELD_ENABLESUBSYSSERVICEAPI);
    }

    @JsonIgnore
    public Integer getExistingModel() {
        Object objValue = this.get(FIELD_EXISTINGMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="existingmodel")
    public void setExistingModel(Integer existingModel) {
        this.set(FIELD_EXISTINGMODEL, existingModel);
    }

    @JsonIgnore
    public boolean isExistingModelDirty() {
        return this.contains(FIELD_EXISTINGMODEL);
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
    public String getPSSysDBSchemeId() {
        Object objValue = this.get(FIELD_PSSYSDBSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbschemeid")
    public void setPSSysDBSchemeId(String pSSysDBSchemeId) {
        this.set(FIELD_PSSYSDBSCHEMEID, pSSysDBSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysDBSchemeIdDirty() {
        return this.contains(FIELD_PSSYSDBSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysDBSchemeName() {
        Object objValue = this.get(FIELD_PSSYSDBSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbschemename")
    public void setPSSysDBSchemeName(String pSSysDBSchemeName) {
        this.set(FIELD_PSSYSDBSCHEMENAME, pSSysDBSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysDBSchemeNameDirty() {
        return this.contains(FIELD_PSSYSDBSCHEMENAME);
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
    public String getSchemeParams() {
        Object objValue = this.get(FIELD_SCHEMEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="schemeparams")
    public void setSchemeParams(String schemeParams) {
        this.set(FIELD_SCHEMEPARAMS, schemeParams);
    }

    @JsonIgnore
    public boolean isSchemeParamsDirty() {
        return this.contains(FIELD_SCHEMEPARAMS);
    }

    @JsonIgnore
    public String getSchemeTag() {
        Object objValue = this.get(FIELD_SCHEMETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="schemetag")
    public void setSchemeTag(String schemeTag) {
        this.set(FIELD_SCHEMETAG, schemeTag);
    }

    @JsonIgnore
    public boolean isSchemeTagDirty() {
        return this.contains(FIELD_SCHEMETAG);
    }

    @JsonIgnore
    public String getSchemeTag2() {
        Object objValue = this.get(FIELD_SCHEMETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="schemetag2")
    public void setSchemeTag2(String schemeTag2) {
        this.set(FIELD_SCHEMETAG2, schemeTag2);
    }

    @JsonIgnore
    public boolean isSchemeTag2Dirty() {
        return this.contains(FIELD_SCHEMETAG2);
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
    public String getSubSysServiceCodeName() {
        Object objValue = this.get(FIELD_SUBSYSSERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subsysservicecodename")
    public void setSubSysServiceCodeName(String subSysServiceCodeName) {
        this.set(FIELD_SUBSYSSERVICECODENAME, subSysServiceCodeName);
    }

    @JsonIgnore
    public boolean isSubSysServiceCodeNameDirty() {
        return this.contains(FIELD_SUBSYSSERVICECODENAME);
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
    public String getSrfkey() {
        return this.getPSSysDBSchemeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDBSchemeId(strValue);
    }

    public List<PSSysDBProc> getPssysdbprocs() {
        return this.pssysdbprocs;
    }

    public void setPssysdbprocs(List<PSSysDBProc> pssysdbprocs) {
        this.pssysdbprocs = pssysdbprocs;
    }

    public List<PSSysDBTable> getPssysdbtables() {
        return this.pssysdbtables;
    }

    public void setPssysdbtables(List<PSSysDBTable> pssysdbtables) {
        this.pssysdbtables = pssysdbtables;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pssysdbprocs")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pssysdbtables")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysdbprocs")) {
            this.init();
            return this.pssysdbprocs;
        }
        if (strName.equalsIgnoreCase("pssysdbtables")) {
            this.init();
            return this.pssysdbtables;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDBSCHEME";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDBScheme item = (PSSysDBScheme)MAPPER.readValue(new File(strJsonFilePath), PSSysDBScheme.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDBScheme) {
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDBScheme) {
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

