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

public class PSSystemRunDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPID2 = "pssysappid2";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSAPPNAME2 = "pssysappname2";
    public static final String FIELD_PSSYSBDINSTCFGID = "pssysbdinstcfgid";
    public static final String FIELD_PSSYSBDINSTCFGNAME = "pssysbdinstcfgname";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSTEMASID = "pssystemasid";
    public static final String FIELD_PSSYSTEMASNAME = "pssystemasname";
    public static final String FIELD_PSSYSTEMDBCFGID = "pssystemdbcfgid";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "pssystemdbcfgname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSTEMRUNID = "pssystemrunid";
    public static final String FIELD_PSSYSTEMRUNNAME = "pssystemrunname";
    public static final String FIELD_RUNPSSYSDYNAMODELID = "runpssysdynamodelid";
    public static final String FIELD_RUNPSSYSDYNAMODELNAME = "runpssysdynamodelname";
    public static final String FIELD_STOPWHENTEMPLERROR = "stopwhentemplerror";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getPSSysAppId2() {
        Object objValue = this.get(FIELD_PSSYSAPPID2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid2")
    public void setPSSysAppId2(String pSSysAppId2) {
        this.set(FIELD_PSSYSAPPID2, pSSysAppId2);
    }

    @JsonIgnore
    public boolean isPSSysAppId2Dirty() {
        return this.contains(FIELD_PSSYSAPPID2);
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
    public String getPSSysAppName2() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname2")
    public void setPSSysAppName2(String pSSysAppName2) {
        this.set(FIELD_PSSYSAPPNAME2, pSSysAppName2);
    }

    @JsonIgnore
    public boolean isPSSysAppName2Dirty() {
        return this.contains(FIELD_PSSYSAPPNAME2);
    }

    @JsonIgnore
    public String getPSSysBDInstCfgId() {
        Object objValue = this.get(FIELD_PSSYSBDINSTCFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdinstcfgid")
    public void setPSSysBDInstCfgId(String pSSysBDInstCfgId) {
        this.set(FIELD_PSSYSBDINSTCFGID, pSSysBDInstCfgId);
    }

    @JsonIgnore
    public boolean isPSSysBDInstCfgIdDirty() {
        return this.contains(FIELD_PSSYSBDINSTCFGID);
    }

    @JsonIgnore
    public String getPSSysBDInstCfgName() {
        Object objValue = this.get(FIELD_PSSYSBDINSTCFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdinstcfgname")
    public void setPSSysBDInstCfgName(String pSSysBDInstCfgName) {
        this.set(FIELD_PSSYSBDINSTCFGNAME, pSSysBDInstCfgName);
    }

    @JsonIgnore
    public boolean isPSSysBDInstCfgNameDirty() {
        return this.contains(FIELD_PSSYSBDINSTCFGNAME);
    }

    @JsonIgnore
    public String getPSSysSFPubId() {
        Object objValue = this.get(FIELD_PSSYSSFPUBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubid")
    public void setPSSysSFPubId(String pSSysSFPubId) {
        this.set(FIELD_PSSYSSFPUBID, pSSysSFPubId);
    }

    @JsonIgnore
    public boolean isPSSysSFPubIdDirty() {
        return this.contains(FIELD_PSSYSSFPUBID);
    }

    @JsonIgnore
    public String getPSSysSFPubName() {
        Object objValue = this.get(FIELD_PSSYSSFPUBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubname")
    public void setPSSysSFPubName(String pSSysSFPubName) {
        this.set(FIELD_PSSYSSFPUBNAME, pSSysSFPubName);
    }

    @JsonIgnore
    public boolean isPSSysSFPubNameDirty() {
        return this.contains(FIELD_PSSYSSFPUBNAME);
    }

    @JsonIgnore
    public String getPSSystemASId() {
        Object objValue = this.get(FIELD_PSSYSTEMASID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemasid")
    public void setPSSystemASId(String pSSystemASId) {
        this.set(FIELD_PSSYSTEMASID, pSSystemASId);
    }

    @JsonIgnore
    public boolean isPSSystemASIdDirty() {
        return this.contains(FIELD_PSSYSTEMASID);
    }

    @JsonIgnore
    public String getPSSystemASName() {
        Object objValue = this.get(FIELD_PSSYSTEMASNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemasname")
    public void setPSSystemASName(String pSSystemASName) {
        this.set(FIELD_PSSYSTEMASNAME, pSSystemASName);
    }

    @JsonIgnore
    public boolean isPSSystemASNameDirty() {
        return this.contains(FIELD_PSSYSTEMASNAME);
    }

    @JsonIgnore
    public String getPSSystemDBCfgId() {
        Object objValue = this.get(FIELD_PSSYSTEMDBCFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemdbcfgid")
    public void setPSSystemDBCfgId(String pSSystemDBCfgId) {
        this.set(FIELD_PSSYSTEMDBCFGID, pSSystemDBCfgId);
    }

    @JsonIgnore
    public boolean isPSSystemDBCfgIdDirty() {
        return this.contains(FIELD_PSSYSTEMDBCFGID);
    }

    @JsonIgnore
    public String getPSSystemDBCfgName() {
        Object objValue = this.get(FIELD_PSSYSTEMDBCFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemdbcfgname")
    public void setPSSystemDBCfgName(String pSSystemDBCfgName) {
        this.set(FIELD_PSSYSTEMDBCFGNAME, pSSystemDBCfgName);
    }

    @JsonIgnore
    public boolean isPSSystemDBCfgNameDirty() {
        return this.contains(FIELD_PSSYSTEMDBCFGNAME);
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
    public String getPSSystemRunId() {
        Object objValue = this.get(FIELD_PSSYSTEMRUNID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemrunid")
    public void setPSSystemRunId(String pSSystemRunId) {
        this.set(FIELD_PSSYSTEMRUNID, pSSystemRunId);
    }

    @JsonIgnore
    public boolean isPSSystemRunIdDirty() {
        return this.contains(FIELD_PSSYSTEMRUNID);
    }

    @JsonIgnore
    public String getPSSystemRunName() {
        Object objValue = this.get(FIELD_PSSYSTEMRUNNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemrunname")
    public void setPSSystemRunName(String pSSystemRunName) {
        this.set(FIELD_PSSYSTEMRUNNAME, pSSystemRunName);
    }

    @JsonIgnore
    public boolean isPSSystemRunNameDirty() {
        return this.contains(FIELD_PSSYSTEMRUNNAME);
    }

    @JsonIgnore
    public String getRunPSSysDynaModelId() {
        Object objValue = this.get(FIELD_RUNPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="runpssysdynamodelid")
    public void setRunPSSysDynaModelId(String runPSSysDynaModelId) {
        this.set(FIELD_RUNPSSYSDYNAMODELID, runPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isRunPSSysDynaModelIdDirty() {
        return this.contains(FIELD_RUNPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getRunPSSysDynaModelName() {
        Object objValue = this.get(FIELD_RUNPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="runpssysdynamodelname")
    public void setRunPSSysDynaModelName(String runPSSysDynaModelName) {
        this.set(FIELD_RUNPSSYSDYNAMODELNAME, runPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isRunPSSysDynaModelNameDirty() {
        return this.contains(FIELD_RUNPSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public Integer getStopWhenTemplError() {
        Object objValue = this.get(FIELD_STOPWHENTEMPLERROR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stopwhentemplerror")
    public void setStopWhenTemplError(Integer stopWhenTemplError) {
        this.set(FIELD_STOPWHENTEMPLERROR, stopWhenTemplError);
    }

    @JsonIgnore
    public boolean isStopWhenTemplErrorDirty() {
        return this.contains(FIELD_STOPWHENTEMPLERROR);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSystemRunId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSystemRunId(strValue);
    }
}

