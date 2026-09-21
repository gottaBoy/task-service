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

public class PSAppLocalDEDTO
extends PSModelDTOBase {
    public static final String FIELD_ACCCTRLARCH = "accctrlarch";
    public static final String FIELD_AUTOADDMETHODMODE = "autoaddmethodmode";
    public static final String FIELD_AUTOADDVIEWMODE = "autoaddviewmode";
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMUSERACTION = "customuseraction";
    public static final String FIELD_DATAACCMODE = "dataaccmode";
    public static final String FIELD_DECODENAME = "decodename";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DEFGROUPMODE = "defgroupmode";
    public static final String FIELD_DELOGICNAME = "delogicname";
    public static final String FIELD_ENABLESTORAGE = "enablestorage";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORFLAG = "majorflag";
    public static final String FIELD_MDPSDEVIEWID = "mdpsdeviewid";
    public static final String FIELD_MDPSDEVIEWNAME = "mdpsdeviewname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PPSAPPLOCALDEID = "ppsapplocaldeid";
    public static final String FIELD_PPSAPPLOCALDENAME = "ppsapplocaldename";
    public static final String FIELD_PSAPPLOCALDEID = "psapplocaldeid";
    public static final String FIELD_PSAPPLOCALDENAME = "psapplocaldename";
    public static final String FIELD_PSAPPMODULEID = "psappmoduleid";
    public static final String FIELD_PSAPPMODULENAME = "psappmodulename";
    public static final String FIELD_PSDEFGROUPID = "psdefgroupid";
    public static final String FIELD_PSDEFGROUPNAME = "psdefgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDESERVICEAPIID = "psdeserviceapiid";
    public static final String FIELD_PSDESERVICEAPINAME = "psdeserviceapiname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_SDPSDEVIEWID = "sdpsdeviewid";
    public static final String FIELD_SDPSDEVIEWNAME = "sdpsdeviewname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERACTION = "useraction";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public Integer getAccCtrlArch() {
        Object objValue = this.get(FIELD_ACCCTRLARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="accctrlarch")
    public void setAccCtrlArch(Integer accCtrlArch) {
        this.set(FIELD_ACCCTRLARCH, accCtrlArch);
    }

    @JsonIgnore
    public boolean isAccCtrlArchDirty() {
        return this.contains(FIELD_ACCCTRLARCH);
    }

    @JsonIgnore
    public Integer getAutoAddMethodMode() {
        Object objValue = this.get(FIELD_AUTOADDMETHODMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autoaddmethodmode")
    public void setAutoAddMethodMode(Integer autoAddMethodMode) {
        this.set(FIELD_AUTOADDMETHODMODE, autoAddMethodMode);
    }

    @JsonIgnore
    public boolean isAutoAddMethodModeDirty() {
        return this.contains(FIELD_AUTOADDMETHODMODE);
    }

    @JsonIgnore
    public Integer getAutoAddViewMode() {
        Object objValue = this.get(FIELD_AUTOADDVIEWMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autoaddviewmode")
    public void setAutoAddViewMode(Integer autoAddViewMode) {
        this.set(FIELD_AUTOADDVIEWMODE, autoAddViewMode);
    }

    @JsonIgnore
    public boolean isAutoAddViewModeDirty() {
        return this.contains(FIELD_AUTOADDVIEWMODE);
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
    public Integer getCustomUserAction() {
        Object objValue = this.get(FIELD_CUSTOMUSERACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="customuseraction")
    public void setCustomUserAction(Integer customUserAction) {
        this.set(FIELD_CUSTOMUSERACTION, customUserAction);
    }

    @JsonIgnore
    public boolean isCustomUserActionDirty() {
        return this.contains(FIELD_CUSTOMUSERACTION);
    }

    @JsonIgnore
    public Integer getDataAccMode() {
        Object objValue = this.get(FIELD_DATAACCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dataaccmode")
    public void setDataAccMode(Integer dataAccMode) {
        this.set(FIELD_DATAACCMODE, dataAccMode);
    }

    @JsonIgnore
    public boolean isDataAccModeDirty() {
        return this.contains(FIELD_DATAACCMODE);
    }

    @JsonIgnore
    public String getDECodeName() {
        Object objValue = this.get(FIELD_DECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="decodename")
    public void setDECodeName(String dECodeName) {
        this.set(FIELD_DECODENAME, dECodeName);
    }

    @JsonIgnore
    public boolean isDECodeNameDirty() {
        return this.contains(FIELD_DECODENAME);
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
    public String getDEFGroupMode() {
        Object objValue = this.get(FIELD_DEFGROUPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defgroupmode")
    public void setDEFGroupMode(String dEFGroupMode) {
        this.set(FIELD_DEFGROUPMODE, dEFGroupMode);
    }

    @JsonIgnore
    public boolean isDEFGroupModeDirty() {
        return this.contains(FIELD_DEFGROUPMODE);
    }

    @JsonIgnore
    public String getDELogicName() {
        Object objValue = this.get(FIELD_DELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="delogicname")
    public void setDELogicName(String dELogicName) {
        this.set(FIELD_DELOGICNAME, dELogicName);
    }

    @JsonIgnore
    public boolean isDELogicNameDirty() {
        return this.contains(FIELD_DELOGICNAME);
    }

    @JsonIgnore
    public Integer getEnableStorage() {
        Object objValue = this.get(FIELD_ENABLESTORAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablestorage")
    public void setEnableStorage(Integer enableStorage) {
        this.set(FIELD_ENABLESTORAGE, enableStorage);
    }

    @JsonIgnore
    public boolean isEnableStorageDirty() {
        return this.contains(FIELD_ENABLESTORAGE);
    }

    @JsonIgnore
    public String getLinkPSDEViewId() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewid")
    public void setLinkPSDEViewId(String linkPSDEViewId) {
        this.set(FIELD_LINKPSDEVIEWID, linkPSDEViewId);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewIdDirty() {
        return this.contains(FIELD_LINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getLinkPSDEViewName() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewname")
    public void setLinkPSDEViewName(String linkPSDEViewName) {
        this.set(FIELD_LINKPSDEVIEWNAME, linkPSDEViewName);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewNameDirty() {
        return this.contains(FIELD_LINKPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
    }

    @JsonIgnore
    public String getLogicName() {
        Object objValue = this.get(FIELD_LOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicname")
    public void setLogicName(String logicName) {
        this.set(FIELD_LOGICNAME, logicName);
    }

    @JsonIgnore
    public boolean isLogicNameDirty() {
        return this.contains(FIELD_LOGICNAME);
    }

    @JsonIgnore
    public Integer getMajorFlag() {
        Object objValue = this.get(FIELD_MAJORFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="majorflag")
    public void setMajorFlag(Integer majorFlag) {
        this.set(FIELD_MAJORFLAG, majorFlag);
    }

    @JsonIgnore
    public boolean isMajorFlagDirty() {
        return this.contains(FIELD_MAJORFLAG);
    }

    @JsonIgnore
    public String getMDPSDEViewId() {
        Object objValue = this.get(FIELD_MDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeviewid")
    public void setMDPSDEViewId(String mDPSDEViewId) {
        this.set(FIELD_MDPSDEVIEWID, mDPSDEViewId);
    }

    @JsonIgnore
    public boolean isMDPSDEViewIdDirty() {
        return this.contains(FIELD_MDPSDEVIEWID);
    }

    @JsonIgnore
    public String getMDPSDEViewName() {
        Object objValue = this.get(FIELD_MDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeviewname")
    public void setMDPSDEViewName(String mDPSDEViewName) {
        this.set(FIELD_MDPSDEVIEWNAME, mDPSDEViewName);
    }

    @JsonIgnore
    public boolean isMDPSDEViewNameDirty() {
        return this.contains(FIELD_MDPSDEVIEWNAME);
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
    public String getPPSAppLocalDEId() {
        Object objValue = this.get(FIELD_PPSAPPLOCALDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsapplocaldeid")
    public void setPPSAppLocalDEId(String pPSAppLocalDEId) {
        this.set(FIELD_PPSAPPLOCALDEID, pPSAppLocalDEId);
    }

    @JsonIgnore
    public boolean isPPSAppLocalDEIdDirty() {
        return this.contains(FIELD_PPSAPPLOCALDEID);
    }

    @JsonIgnore
    public String getPPSAppLocalDEName() {
        Object objValue = this.get(FIELD_PPSAPPLOCALDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsapplocaldename")
    public void setPPSAppLocalDEName(String pPSAppLocalDEName) {
        this.set(FIELD_PPSAPPLOCALDENAME, pPSAppLocalDEName);
    }

    @JsonIgnore
    public boolean isPPSAppLocalDENameDirty() {
        return this.contains(FIELD_PPSAPPLOCALDENAME);
    }

    @JsonIgnore
    public String getPSAppLocalDEId() {
        Object objValue = this.get(FIELD_PSAPPLOCALDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldeid")
    public void setPSAppLocalDEId(String pSAppLocalDEId) {
        this.set(FIELD_PSAPPLOCALDEID, pSAppLocalDEId);
    }

    @JsonIgnore
    public boolean isPSAppLocalDEIdDirty() {
        return this.contains(FIELD_PSAPPLOCALDEID);
    }

    @JsonIgnore
    public String getPSAppLocalDEName() {
        Object objValue = this.get(FIELD_PSAPPLOCALDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldename")
    public void setPSAppLocalDEName(String pSAppLocalDEName) {
        this.set(FIELD_PSAPPLOCALDENAME, pSAppLocalDEName);
    }

    @JsonIgnore
    public boolean isPSAppLocalDENameDirty() {
        return this.contains(FIELD_PSAPPLOCALDENAME);
    }

    @JsonIgnore
    public String getPSAppModuleId() {
        Object objValue = this.get(FIELD_PSAPPMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmoduleid")
    public void setPSAppModuleId(String pSAppModuleId) {
        this.set(FIELD_PSAPPMODULEID, pSAppModuleId);
    }

    @JsonIgnore
    public boolean isPSAppModuleIdDirty() {
        return this.contains(FIELD_PSAPPMODULEID);
    }

    @JsonIgnore
    public String getPSAppModuleName() {
        Object objValue = this.get(FIELD_PSAPPMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmodulename")
    public void setPSAppModuleName(String pSAppModuleName) {
        this.set(FIELD_PSAPPMODULENAME, pSAppModuleName);
    }

    @JsonIgnore
    public boolean isPSAppModuleNameDirty() {
        return this.contains(FIELD_PSAPPMODULENAME);
    }

    @JsonIgnore
    public String getPSDEFGroupId() {
        Object objValue = this.get(FIELD_PSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupid")
    public void setPSDEFGroupId(String pSDEFGroupId) {
        this.set(FIELD_PSDEFGROUPID, pSDEFGroupId);
    }

    @JsonIgnore
    public boolean isPSDEFGroupIdDirty() {
        return this.contains(FIELD_PSDEFGROUPID);
    }

    @JsonIgnore
    public String getPSDEFGroupName() {
        Object objValue = this.get(FIELD_PSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupname")
    public void setPSDEFGroupName(String pSDEFGroupName) {
        this.set(FIELD_PSDEFGROUPNAME, pSDEFGroupName);
    }

    @JsonIgnore
    public boolean isPSDEFGroupNameDirty() {
        return this.contains(FIELD_PSDEFGROUPNAME);
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
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
    }

    @JsonIgnore
    public String getPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_PSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiid")
    public void setPSDEServiceAPIId(String pSDEServiceAPIId) {
        this.set(FIELD_PSDESERVICEAPIID, pSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_PSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_PSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiname")
    public void setPSDEServiceAPIName(String pSDEServiceAPIName) {
        this.set(FIELD_PSDESERVICEAPINAME, pSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPINameDirty() {
        return this.contains(FIELD_PSDESERVICEAPINAME);
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
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
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
    public String getSDPSDEViewID() {
        Object objValue = this.get(FIELD_SDPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sdpsdeviewid")
    public void setSDPSDEViewID(String sDPSDEViewID) {
        this.set(FIELD_SDPSDEVIEWID, sDPSDEViewID);
    }

    @JsonIgnore
    public boolean isSDPSDEViewIDDirty() {
        return this.contains(FIELD_SDPSDEVIEWID);
    }

    @JsonIgnore
    public String getSDPSDEViewName() {
        Object objValue = this.get(FIELD_SDPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sdpsdeviewname")
    public void setSDPSDEViewName(String sDPSDEViewName) {
        this.set(FIELD_SDPSDEVIEWNAME, sDPSDEViewName);
    }

    @JsonIgnore
    public boolean isSDPSDEViewNameDirty() {
        return this.contains(FIELD_SDPSDEVIEWNAME);
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
    public Integer getUserAction() {
        Object objValue = this.get(FIELD_USERACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="useraction")
    public void setUserAction(Integer userAction) {
        this.set(FIELD_USERACTION, userAction);
    }

    @JsonIgnore
    public boolean isUserActionDirty() {
        return this.contains(FIELD_USERACTION);
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
        return this.getPSAppLocalDEId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppLocalDEId(strValue);
    }
}

