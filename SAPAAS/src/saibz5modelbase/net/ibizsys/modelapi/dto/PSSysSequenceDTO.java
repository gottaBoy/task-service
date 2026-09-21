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

public class PSSysSequenceDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EXTFORMATPARAMS = "extformatparams";
    public static final String FIELD_KEYPSDEFID = "keypsdefid";
    public static final String FIELD_KEYPSDEFNAME = "keypsdefname";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSEQUENCEID = "pssyssequenceid";
    public static final String FIELD_PSSYSSEQUENCENAME = "pssyssequencename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SEQUENCEFORMAT = "sequenceformat";
    public static final String FIELD_SEQUENCETAG = "sequencetag";
    public static final String FIELD_SEQUENCETAG2 = "sequencetag2";
    public static final String FIELD_SEQUENCETYPE = "sequencetype";
    public static final String FIELD_TIMEFORMAT = "timeformat";
    public static final String FIELD_TIMEPSDEFID = "timepsdefid";
    public static final String FIELD_TIMEPSDEFNAME = "timepsdefname";
    public static final String FIELD_TYPEPSDEFID = "typepsdefid";
    public static final String FIELD_TYPEPSDEFNAME = "typepsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEPSDEFID = "valuepsdefid";
    public static final String FIELD_VALUEPSDEFNAME = "valuepsdefname";

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
    public String getExtFormatParams() {
        Object objValue = this.get(FIELD_EXTFORMATPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extformatparams")
    public void setExtFormatParams(String extFormatParams) {
        this.set(FIELD_EXTFORMATPARAMS, extFormatParams);
    }

    @JsonIgnore
    public boolean isExtFormatParamsDirty() {
        return this.contains(FIELD_EXTFORMATPARAMS);
    }

    @JsonIgnore
    public String getKeyPSDEFId() {
        Object objValue = this.get(FIELD_KEYPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keypsdefid")
    public void setKeyPSDEFId(String keyPSDEFId) {
        this.set(FIELD_KEYPSDEFID, keyPSDEFId);
    }

    @JsonIgnore
    public boolean isKeyPSDEFIdDirty() {
        return this.contains(FIELD_KEYPSDEFID);
    }

    @JsonIgnore
    public String getKeyPSDEFName() {
        Object objValue = this.get(FIELD_KEYPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keypsdefname")
    public void setKeyPSDEFName(String keyPSDEFName) {
        this.set(FIELD_KEYPSDEFNAME, keyPSDEFName);
    }

    @JsonIgnore
    public boolean isKeyPSDEFNameDirty() {
        return this.contains(FIELD_KEYPSDEFNAME);
    }

    @JsonIgnore
    public Integer getMaxValue() {
        Object objValue = this.get(FIELD_MAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxvalue")
    public void setMaxValue(Integer maxValue) {
        this.set(FIELD_MAXVALUE, maxValue);
    }

    @JsonIgnore
    public boolean isMaxValueDirty() {
        return this.contains(FIELD_MAXVALUE);
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
    public Integer getMinValue() {
        Object objValue = this.get(FIELD_MINVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minvalue")
    public void setMinValue(Integer minValue) {
        this.set(FIELD_MINVALUE, minValue);
    }

    @JsonIgnore
    public boolean isMinValueDirty() {
        return this.contains(FIELD_MINVALUE);
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
    public String getPSSysSequenceId() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequenceid")
    public void setPSSysSequenceId(String pSSysSequenceId) {
        this.set(FIELD_PSSYSSEQUENCEID, pSSysSequenceId);
    }

    @JsonIgnore
    public boolean isPSSysSequenceIdDirty() {
        return this.contains(FIELD_PSSYSSEQUENCEID);
    }

    @JsonIgnore
    public String getPSSysSequenceName() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequencename")
    public void setPSSysSequenceName(String pSSysSequenceName) {
        this.set(FIELD_PSSYSSEQUENCENAME, pSSysSequenceName);
    }

    @JsonIgnore
    public boolean isPSSysSequenceNameDirty() {
        return this.contains(FIELD_PSSYSSEQUENCENAME);
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
    public String getSequenceFormat() {
        Object objValue = this.get(FIELD_SEQUENCEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sequenceformat")
    public void setSequenceFormat(String sequenceFormat) {
        this.set(FIELD_SEQUENCEFORMAT, sequenceFormat);
    }

    @JsonIgnore
    public boolean isSequenceFormatDirty() {
        return this.contains(FIELD_SEQUENCEFORMAT);
    }

    @JsonIgnore
    public String getSequenceTag() {
        Object objValue = this.get(FIELD_SEQUENCETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sequencetag")
    public void setSequenceTag(String sequenceTag) {
        this.set(FIELD_SEQUENCETAG, sequenceTag);
    }

    @JsonIgnore
    public boolean isSequenceTagDirty() {
        return this.contains(FIELD_SEQUENCETAG);
    }

    @JsonIgnore
    public String getSequenceTag2() {
        Object objValue = this.get(FIELD_SEQUENCETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sequencetag2")
    public void setSequenceTag2(String sequenceTag2) {
        this.set(FIELD_SEQUENCETAG2, sequenceTag2);
    }

    @JsonIgnore
    public boolean isSequenceTag2Dirty() {
        return this.contains(FIELD_SEQUENCETAG2);
    }

    @JsonIgnore
    public String getSequenceType() {
        Object objValue = this.get(FIELD_SEQUENCETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sequencetype")
    public void setSequenceType(String sequenceType) {
        this.set(FIELD_SEQUENCETYPE, sequenceType);
    }

    @JsonIgnore
    public boolean isSequenceTypeDirty() {
        return this.contains(FIELD_SEQUENCETYPE);
    }

    @JsonIgnore
    public String getTimeFormat() {
        Object objValue = this.get(FIELD_TIMEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timeformat")
    public void setTimeFormat(String timeFormat) {
        this.set(FIELD_TIMEFORMAT, timeFormat);
    }

    @JsonIgnore
    public boolean isTimeFormatDirty() {
        return this.contains(FIELD_TIMEFORMAT);
    }

    @JsonIgnore
    public String getTimePSDEFId() {
        Object objValue = this.get(FIELD_TIMEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timepsdefid")
    public void setTimePSDEFId(String timePSDEFId) {
        this.set(FIELD_TIMEPSDEFID, timePSDEFId);
    }

    @JsonIgnore
    public boolean isTimePSDEFIdDirty() {
        return this.contains(FIELD_TIMEPSDEFID);
    }

    @JsonIgnore
    public String getTimePSDEFName() {
        Object objValue = this.get(FIELD_TIMEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timepsdefname")
    public void setTimePSDEFName(String timePSDEFName) {
        this.set(FIELD_TIMEPSDEFNAME, timePSDEFName);
    }

    @JsonIgnore
    public boolean isTimePSDEFNameDirty() {
        return this.contains(FIELD_TIMEPSDEFNAME);
    }

    @JsonIgnore
    public String getTypePSDEFId() {
        Object objValue = this.get(FIELD_TYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typepsdefid")
    public void setTypePSDEFId(String typePSDEFId) {
        this.set(FIELD_TYPEPSDEFID, typePSDEFId);
    }

    @JsonIgnore
    public boolean isTypePSDEFIdDirty() {
        return this.contains(FIELD_TYPEPSDEFID);
    }

    @JsonIgnore
    public String getTypePSDEFName() {
        Object objValue = this.get(FIELD_TYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typepsdefname")
    public void setTypePSDEFName(String typePSDEFName) {
        this.set(FIELD_TYPEPSDEFNAME, typePSDEFName);
    }

    @JsonIgnore
    public boolean isTypePSDEFNameDirty() {
        return this.contains(FIELD_TYPEPSDEFNAME);
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
    public String getValuePSDEFId() {
        Object objValue = this.get(FIELD_VALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefid")
    public void setValuePSDEFId(String valuePSDEFId) {
        this.set(FIELD_VALUEPSDEFID, valuePSDEFId);
    }

    @JsonIgnore
    public boolean isValuePSDEFIdDirty() {
        return this.contains(FIELD_VALUEPSDEFID);
    }

    @JsonIgnore
    public String getValuePSDEFName() {
        Object objValue = this.get(FIELD_VALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefname")
    public void setValuePSDEFName(String valuePSDEFName) {
        this.set(FIELD_VALUEPSDEFNAME, valuePSDEFName);
    }

    @JsonIgnore
    public boolean isValuePSDEFNameDirty() {
        return this.contains(FIELD_VALUEPSDEFNAME);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysSequenceId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysSequenceId(strValue);
    }
}

