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

public class PSSysDynaModelDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DTOCODENAME = "dtocodename";
    public static final String FIELD_DYNAMODEL = "dynamodel";
    public static final String FIELD_DYNAMODEL2 = "dynamodel2";
    public static final String FIELD_DYNAMODELFMT = "dynamodelfmt";
    public static final String FIELD_DYNAMODELUSAGE = "dynamodelusage";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELTAG = "modeltag";
    public static final String FIELD_MODELTAG2 = "modeltag2";
    public static final String FIELD_MODELTAG3 = "modeltag3";
    public static final String FIELD_MODELTAG4 = "modeltag4";
    public static final String FIELD_PPSSYSDYNAMODELID = "ppssysdynamodelid";
    public static final String FIELD_PPSSYSDYNAMODELNAME = "ppssysdynamodelname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELCATID = "pssysdynamodelcatid";
    public static final String FIELD_PSSYSDYNAMODELCATNAME = "pssysdynamodelcatname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
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
    public String getDTOCodeName() {
        Object objValue = this.get(FIELD_DTOCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dtocodename")
    public void setDTOCodeName(String dTOCodeName) {
        this.set(FIELD_DTOCODENAME, dTOCodeName);
    }

    @JsonIgnore
    public boolean isDTOCodeNameDirty() {
        return this.contains(FIELD_DTOCODENAME);
    }

    @JsonIgnore
    public String getDynaModel() {
        Object objValue = this.get(FIELD_DYNAMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodel")
    public void setDynaModel(String dynaModel) {
        this.set(FIELD_DYNAMODEL, dynaModel);
    }

    @JsonIgnore
    public boolean isDynaModelDirty() {
        return this.contains(FIELD_DYNAMODEL);
    }

    @JsonIgnore
    public String getDynaModel2() {
        Object objValue = this.get(FIELD_DYNAMODEL2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodel2")
    public void setDynaModel2(String dynaModel2) {
        this.set(FIELD_DYNAMODEL2, dynaModel2);
    }

    @JsonIgnore
    public boolean isDynaModel2Dirty() {
        return this.contains(FIELD_DYNAMODEL2);
    }

    @JsonIgnore
    public String getDynaModelFmt() {
        Object objValue = this.get(FIELD_DYNAMODELFMT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodelfmt")
    public void setDynaModelFmt(String dynaModelFmt) {
        this.set(FIELD_DYNAMODELFMT, dynaModelFmt);
    }

    @JsonIgnore
    public boolean isDynaModelFmtDirty() {
        return this.contains(FIELD_DYNAMODELFMT);
    }

    @JsonIgnore
    public String getDynaModelUsage() {
        Object objValue = this.get(FIELD_DYNAMODELUSAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodelusage")
    public void setDynaModelUsage(String dynaModelUsage) {
        this.set(FIELD_DYNAMODELUSAGE, dynaModelUsage);
    }

    @JsonIgnore
    public boolean isDynaModelUsageDirty() {
        return this.contains(FIELD_DYNAMODELUSAGE);
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
    public String getModelTag() {
        Object objValue = this.get(FIELD_MODELTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modeltag")
    public void setModelTag(String modelTag) {
        this.set(FIELD_MODELTAG, modelTag);
    }

    @JsonIgnore
    public boolean isModelTagDirty() {
        return this.contains(FIELD_MODELTAG);
    }

    @JsonIgnore
    public String getModelTag2() {
        Object objValue = this.get(FIELD_MODELTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modeltag2")
    public void setModelTag2(String modelTag2) {
        this.set(FIELD_MODELTAG2, modelTag2);
    }

    @JsonIgnore
    public boolean isModelTag2Dirty() {
        return this.contains(FIELD_MODELTAG2);
    }

    @JsonIgnore
    public String getModelTag3() {
        Object objValue = this.get(FIELD_MODELTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modeltag3")
    public void setModelTag3(String modelTag3) {
        this.set(FIELD_MODELTAG3, modelTag3);
    }

    @JsonIgnore
    public boolean isModelTag3Dirty() {
        return this.contains(FIELD_MODELTAG3);
    }

    @JsonIgnore
    public String getModelTag4() {
        Object objValue = this.get(FIELD_MODELTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modeltag4")
    public void setModelTag4(String modelTag4) {
        this.set(FIELD_MODELTAG4, modelTag4);
    }

    @JsonIgnore
    public boolean isModelTag4Dirty() {
        return this.contains(FIELD_MODELTAG4);
    }

    @JsonIgnore
    public String getPPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysdynamodelid")
    public void setPPSSysDynaModelId(String pPSSysDynaModelId) {
        this.set(FIELD_PPSSYSDYNAMODELID, pPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysdynamodelname")
    public void setPPSSysDynaModelName(String pPSSysDynaModelName) {
        this.set(FIELD_PPSSYSDYNAMODELNAME, pPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PPSSYSDYNAMODELNAME);
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
    public String getPSSysDynaModelCatId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelcatid")
    public void setPSSysDynaModelCatId(String pSSysDynaModelCatId) {
        this.set(FIELD_PSSYSDYNAMODELCATID, pSSysDynaModelCatId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelCatIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELCATID);
    }

    @JsonIgnore
    public String getPSSysDynaModelCatName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelcatname")
    public void setPSSysDynaModelCatName(String pSSysDynaModelCatName) {
        this.set(FIELD_PSSYSDYNAMODELCATNAME, pSSysDynaModelCatName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelCatNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELCATNAME);
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
        return this.getPSSysDynaModelId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysDynaModelId(strValue);
    }
}

