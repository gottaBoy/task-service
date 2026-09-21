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

public class PSSysUniStateDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEDEFAULTFLAG = "dedefaultflag";
    public static final String FIELD_KEY2PSDEFID = "key2psdefid";
    public static final String FIELD_KEY2PSDEFNAME = "key2psdefname";
    public static final String FIELD_KEY3PSDEFID = "key3psdefid";
    public static final String FIELD_KEY3PSDEFNAME = "key3psdefname";
    public static final String FIELD_KEY4PSDEFID = "key4psdefid";
    public static final String FIELD_KEY4PSDEFNAME = "key4psdefname";
    public static final String FIELD_KEYPSDEFID = "keypsdefid";
    public static final String FIELD_KEYPSDEFNAME = "keypsdefname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUNISTATEID = "pssysunistateid";
    public static final String FIELD_PSSYSUNISTATENAME = "pssysunistatename";
    public static final String FIELD_STATE2PSDEFID = "state2psdefid";
    public static final String FIELD_STATE2PSDEFNAME = "state2psdefname";
    public static final String FIELD_STATE3PSDEFID = "state3psdefid";
    public static final String FIELD_STATE3PSDEFNAME = "state3psdefname";
    public static final String FIELD_STATE4PSDEFID = "state4psdefid";
    public static final String FIELD_STATE4PSDEFNAME = "state4psdefname";
    public static final String FIELD_STATE5PSDEFID = "state5psdefid";
    public static final String FIELD_STATE5PSDEFNAME = "state5psdefname";
    public static final String FIELD_STATE6PSDEFID = "state6psdefid";
    public static final String FIELD_STATE6PSDEFNAME = "state6psdefname";
    public static final String FIELD_STATE7PSDEFID = "state7psdefid";
    public static final String FIELD_STATE7PSDEFNAME = "state7psdefname";
    public static final String FIELD_STATE8PSDEFID = "state8psdefid";
    public static final String FIELD_STATE8PSDEFNAME = "state8psdefname";
    public static final String FIELD_STATEPSDEFID = "statepsdefid";
    public static final String FIELD_STATEPSDEFNAME = "statepsdefname";
    public static final String FIELD_UNIQUETAG = "uniquetag";
    public static final String FIELD_UNISTATETYPE = "unistatetype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public Integer getDEDefaultFlag() {
        Object objValue = this.get(FIELD_DEDEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedefaultflag")
    public void setDEDefaultFlag(Integer dEDefaultFlag) {
        this.set(FIELD_DEDEFAULTFLAG, dEDefaultFlag);
    }

    @JsonIgnore
    public boolean isDEDefaultFlagDirty() {
        return this.contains(FIELD_DEDEFAULTFLAG);
    }

    @JsonIgnore
    public String getKey2PSDEFId() {
        Object objValue = this.get(FIELD_KEY2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key2psdefid")
    public void setKey2PSDEFId(String key2PSDEFId) {
        this.set(FIELD_KEY2PSDEFID, key2PSDEFId);
    }

    @JsonIgnore
    public boolean isKey2PSDEFIdDirty() {
        return this.contains(FIELD_KEY2PSDEFID);
    }

    @JsonIgnore
    public String getKey2PSDEFName() {
        Object objValue = this.get(FIELD_KEY2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key2psdefname")
    public void setKey2PSDEFName(String key2PSDEFName) {
        this.set(FIELD_KEY2PSDEFNAME, key2PSDEFName);
    }

    @JsonIgnore
    public boolean isKey2PSDEFNameDirty() {
        return this.contains(FIELD_KEY2PSDEFNAME);
    }

    @JsonIgnore
    public String getKey3PSDEFId() {
        Object objValue = this.get(FIELD_KEY3PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key3psdefid")
    public void setKey3PSDEFId(String key3PSDEFId) {
        this.set(FIELD_KEY3PSDEFID, key3PSDEFId);
    }

    @JsonIgnore
    public boolean isKey3PSDEFIdDirty() {
        return this.contains(FIELD_KEY3PSDEFID);
    }

    @JsonIgnore
    public String getKey3PSDEFName() {
        Object objValue = this.get(FIELD_KEY3PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key3psdefname")
    public void setKey3PSDEFName(String key3PSDEFName) {
        this.set(FIELD_KEY3PSDEFNAME, key3PSDEFName);
    }

    @JsonIgnore
    public boolean isKey3PSDEFNameDirty() {
        return this.contains(FIELD_KEY3PSDEFNAME);
    }

    @JsonIgnore
    public String getKey4PSDEFId() {
        Object objValue = this.get(FIELD_KEY4PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key4psdefid")
    public void setKey4PSDEFId(String key4PSDEFId) {
        this.set(FIELD_KEY4PSDEFID, key4PSDEFId);
    }

    @JsonIgnore
    public boolean isKey4PSDEFIdDirty() {
        return this.contains(FIELD_KEY4PSDEFID);
    }

    @JsonIgnore
    public String getKey4PSDEFName() {
        Object objValue = this.get(FIELD_KEY4PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="key4psdefname")
    public void setKey4PSDEFName(String key4PSDEFName) {
        this.set(FIELD_KEY4PSDEFNAME, key4PSDEFName);
    }

    @JsonIgnore
    public boolean isKey4PSDEFNameDirty() {
        return this.contains(FIELD_KEY4PSDEFNAME);
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
    public String getPSSysUniStateId() {
        Object objValue = this.get(FIELD_PSSYSUNISTATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistateid")
    public void setPSSysUniStateId(String pSSysUniStateId) {
        this.set(FIELD_PSSYSUNISTATEID, pSSysUniStateId);
    }

    @JsonIgnore
    public boolean isPSSysUniStateIdDirty() {
        return this.contains(FIELD_PSSYSUNISTATEID);
    }

    @JsonIgnore
    public String getPSSysUniStateName() {
        Object objValue = this.get(FIELD_PSSYSUNISTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistatename")
    public void setPSSysUniStateName(String pSSysUniStateName) {
        this.set(FIELD_PSSYSUNISTATENAME, pSSysUniStateName);
    }

    @JsonIgnore
    public boolean isPSSysUniStateNameDirty() {
        return this.contains(FIELD_PSSYSUNISTATENAME);
    }

    @JsonIgnore
    public String getState2PSDEFId() {
        Object objValue = this.get(FIELD_STATE2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state2psdefid")
    public void setState2PSDEFId(String state2PSDEFId) {
        this.set(FIELD_STATE2PSDEFID, state2PSDEFId);
    }

    @JsonIgnore
    public boolean isState2PSDEFIdDirty() {
        return this.contains(FIELD_STATE2PSDEFID);
    }

    @JsonIgnore
    public String getState2PSDEFName() {
        Object objValue = this.get(FIELD_STATE2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state2psdefname")
    public void setState2PSDEFName(String state2PSDEFName) {
        this.set(FIELD_STATE2PSDEFNAME, state2PSDEFName);
    }

    @JsonIgnore
    public boolean isState2PSDEFNameDirty() {
        return this.contains(FIELD_STATE2PSDEFNAME);
    }

    @JsonIgnore
    public String getState3PSDEFId() {
        Object objValue = this.get(FIELD_STATE3PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state3psdefid")
    public void setState3PSDEFId(String state3PSDEFId) {
        this.set(FIELD_STATE3PSDEFID, state3PSDEFId);
    }

    @JsonIgnore
    public boolean isState3PSDEFIdDirty() {
        return this.contains(FIELD_STATE3PSDEFID);
    }

    @JsonIgnore
    public String getState3PSDEFName() {
        Object objValue = this.get(FIELD_STATE3PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state3psdefname")
    public void setState3PSDEFName(String state3PSDEFName) {
        this.set(FIELD_STATE3PSDEFNAME, state3PSDEFName);
    }

    @JsonIgnore
    public boolean isState3PSDEFNameDirty() {
        return this.contains(FIELD_STATE3PSDEFNAME);
    }

    @JsonIgnore
    public String getState4PSDEFId() {
        Object objValue = this.get(FIELD_STATE4PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state4psdefid")
    public void setState4PSDEFId(String state4PSDEFId) {
        this.set(FIELD_STATE4PSDEFID, state4PSDEFId);
    }

    @JsonIgnore
    public boolean isState4PSDEFIdDirty() {
        return this.contains(FIELD_STATE4PSDEFID);
    }

    @JsonIgnore
    public String getState4PSDEFName() {
        Object objValue = this.get(FIELD_STATE4PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state4psdefname")
    public void setState4PSDEFName(String state4PSDEFName) {
        this.set(FIELD_STATE4PSDEFNAME, state4PSDEFName);
    }

    @JsonIgnore
    public boolean isState4PSDEFNameDirty() {
        return this.contains(FIELD_STATE4PSDEFNAME);
    }

    @JsonIgnore
    public String getState5PSDEFId() {
        Object objValue = this.get(FIELD_STATE5PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state5psdefid")
    public void setState5PSDEFId(String state5PSDEFId) {
        this.set(FIELD_STATE5PSDEFID, state5PSDEFId);
    }

    @JsonIgnore
    public boolean isState5PSDEFIdDirty() {
        return this.contains(FIELD_STATE5PSDEFID);
    }

    @JsonIgnore
    public String getState5PSDEFName() {
        Object objValue = this.get(FIELD_STATE5PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state5psdefname")
    public void setState5PSDEFName(String state5PSDEFName) {
        this.set(FIELD_STATE5PSDEFNAME, state5PSDEFName);
    }

    @JsonIgnore
    public boolean isState5PSDEFNameDirty() {
        return this.contains(FIELD_STATE5PSDEFNAME);
    }

    @JsonIgnore
    public String getState6PSDEFId() {
        Object objValue = this.get(FIELD_STATE6PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state6psdefid")
    public void setState6PSDEFId(String state6PSDEFId) {
        this.set(FIELD_STATE6PSDEFID, state6PSDEFId);
    }

    @JsonIgnore
    public boolean isState6PSDEFIdDirty() {
        return this.contains(FIELD_STATE6PSDEFID);
    }

    @JsonIgnore
    public String getState6PSDEFName() {
        Object objValue = this.get(FIELD_STATE6PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state6psdefname")
    public void setState6PSDEFName(String state6PSDEFName) {
        this.set(FIELD_STATE6PSDEFNAME, state6PSDEFName);
    }

    @JsonIgnore
    public boolean isState6PSDEFNameDirty() {
        return this.contains(FIELD_STATE6PSDEFNAME);
    }

    @JsonIgnore
    public String getState7PSDEFId() {
        Object objValue = this.get(FIELD_STATE7PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state7psdefid")
    public void setState7PSDEFId(String state7PSDEFId) {
        this.set(FIELD_STATE7PSDEFID, state7PSDEFId);
    }

    @JsonIgnore
    public boolean isState7PSDEFIdDirty() {
        return this.contains(FIELD_STATE7PSDEFID);
    }

    @JsonIgnore
    public String getState7PSDEFName() {
        Object objValue = this.get(FIELD_STATE7PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state7psdefname")
    public void setState7PSDEFName(String state7PSDEFName) {
        this.set(FIELD_STATE7PSDEFNAME, state7PSDEFName);
    }

    @JsonIgnore
    public boolean isState7PSDEFNameDirty() {
        return this.contains(FIELD_STATE7PSDEFNAME);
    }

    @JsonIgnore
    public String getState8PSDEFId() {
        Object objValue = this.get(FIELD_STATE8PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state8psdefid")
    public void setState8PSDEFId(String state8PSDEFId) {
        this.set(FIELD_STATE8PSDEFID, state8PSDEFId);
    }

    @JsonIgnore
    public boolean isState8PSDEFIdDirty() {
        return this.contains(FIELD_STATE8PSDEFID);
    }

    @JsonIgnore
    public String getState8PSDEFName() {
        Object objValue = this.get(FIELD_STATE8PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="state8psdefname")
    public void setState8PSDEFName(String state8PSDEFName) {
        this.set(FIELD_STATE8PSDEFNAME, state8PSDEFName);
    }

    @JsonIgnore
    public boolean isState8PSDEFNameDirty() {
        return this.contains(FIELD_STATE8PSDEFNAME);
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
    public String getUniStateType() {
        Object objValue = this.get(FIELD_UNISTATETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unistatetype")
    public void setUniStateType(String uniStateType) {
        this.set(FIELD_UNISTATETYPE, uniStateType);
    }

    @JsonIgnore
    public boolean isUniStateTypeDirty() {
        return this.contains(FIELD_UNISTATETYPE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysUniStateId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysUniStateId(strValue);
    }
}

