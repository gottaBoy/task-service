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

public class PSWFUtilUIAction
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSWFSETTINGID = "pssyswfsettingid";
    public static final String FIELD_PSSYSWFSETTINGNAME = "pssyswfsettingname";
    public static final String FIELD_PSWFUTILUIACTIONID = "pswfutiluiactionid";
    public static final String FIELD_PSWFUTILUIACTIONNAME = "pswfutiluiactionname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_PSWORKFLOWID = "psworkflowid";
    public static final String FIELD_PSWORKFLOWNAME = "psworkflowname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UTILTYPE = "utiltype";
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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
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
    public String getPSDEUIActionId() {
        Object objValue = this.get(FIELD_PSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionid")
    public void setPSDEUIActionId(String pSDEUIActionId) {
        this.set(FIELD_PSDEUIACTIONID, pSDEUIActionId);
    }

    @JsonIgnore
    public boolean isPSDEUIActionIdDirty() {
        return this.contains(FIELD_PSDEUIACTIONID);
    }

    @JsonIgnore
    public String getPSDEUIActionName() {
        Object objValue = this.get(FIELD_PSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionname")
    public void setPSDEUIActionName(String pSDEUIActionName) {
        this.set(FIELD_PSDEUIACTIONNAME, pSDEUIActionName);
    }

    @JsonIgnore
    public boolean isPSDEUIActionNameDirty() {
        return this.contains(FIELD_PSDEUIACTIONNAME);
    }

    @JsonIgnore
    public String getPSSysWFSettingId() {
        Object objValue = this.get(FIELD_PSSYSWFSETTINGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfsettingid")
    public void setPSSysWFSettingId(String pSSysWFSettingId) {
        this.set(FIELD_PSSYSWFSETTINGID, pSSysWFSettingId);
    }

    @JsonIgnore
    public boolean isPSSysWFSettingIdDirty() {
        return this.contains(FIELD_PSSYSWFSETTINGID);
    }

    @JsonIgnore
    public String getPSSysWFSettingName() {
        Object objValue = this.get(FIELD_PSSYSWFSETTINGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfsettingname")
    public void setPSSysWFSettingName(String pSSysWFSettingName) {
        this.set(FIELD_PSSYSWFSETTINGNAME, pSSysWFSettingName);
    }

    @JsonIgnore
    public boolean isPSSysWFSettingNameDirty() {
        return this.contains(FIELD_PSSYSWFSETTINGNAME);
    }

    @JsonIgnore
    public String getPSWFUtilUIActionId() {
        Object objValue = this.get(FIELD_PSWFUTILUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfutiluiactionid")
    public void setPSWFUtilUIActionId(String pSWFUtilUIActionId) {
        this.set(FIELD_PSWFUTILUIACTIONID, pSWFUtilUIActionId);
    }

    @JsonIgnore
    public boolean isPSWFUtilUIActionIdDirty() {
        return this.contains(FIELD_PSWFUTILUIACTIONID);
    }

    @JsonIgnore
    public String getPSWFUtilUIActionName() {
        Object objValue = this.get(FIELD_PSWFUTILUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfutiluiactionname")
    public void setPSWFUtilUIActionName(String pSWFUtilUIActionName) {
        this.set(FIELD_PSWFUTILUIACTIONNAME, pSWFUtilUIActionName);
    }

    @JsonIgnore
    public boolean isPSWFUtilUIActionNameDirty() {
        return this.contains(FIELD_PSWFUTILUIACTIONNAME);
    }

    @JsonIgnore
    public String getPSWFVersionId() {
        Object objValue = this.get(FIELD_PSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionid")
    public void setPSWFVersionId(String pSWFVersionId) {
        this.set(FIELD_PSWFVERSIONID, pSWFVersionId);
    }

    @JsonIgnore
    public boolean isPSWFVersionIdDirty() {
        return this.contains(FIELD_PSWFVERSIONID);
    }

    @JsonIgnore
    public String getPSWFVersionName() {
        Object objValue = this.get(FIELD_PSWFVERSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionname")
    public void setPSWFVersionName(String pSWFVersionName) {
        this.set(FIELD_PSWFVERSIONNAME, pSWFVersionName);
    }

    @JsonIgnore
    public boolean isPSWFVersionNameDirty() {
        return this.contains(FIELD_PSWFVERSIONNAME);
    }

    @JsonIgnore
    public String getPSWorkflowId() {
        Object objValue = this.get(FIELD_PSWORKFLOWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psworkflowid")
    public void setPSWorkflowId(String pSWorkflowId) {
        this.set(FIELD_PSWORKFLOWID, pSWorkflowId);
    }

    @JsonIgnore
    public boolean isPSWorkflowIdDirty() {
        return this.contains(FIELD_PSWORKFLOWID);
    }

    @JsonIgnore
    public String getPSWorkflowName() {
        Object objValue = this.get(FIELD_PSWORKFLOWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psworkflowname")
    public void setPSWorkflowName(String pSWorkflowName) {
        this.set(FIELD_PSWORKFLOWNAME, pSWorkflowName);
    }

    @JsonIgnore
    public boolean isPSWorkflowNameDirty() {
        return this.contains(FIELD_PSWORKFLOWNAME);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFUtilUIActionId();
    }

    public void setSrfkey(String strValue) {
        this.setPSWFUtilUIActionId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSWFUTILUIACTION";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSWFUtilUIAction item = (PSWFUtilUIAction)MAPPER.readValue(new File(strJsonFilePath), PSWFUtilUIAction.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSWFUtilUIAction) {
            PSWFUtilUIAction pSWFUtilUIAction = (PSWFUtilUIAction)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSWFUtilUIAction) {
            PSWFUtilUIAction pSWFUtilUIAction = (PSWFUtilUIAction)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

