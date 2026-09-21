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

public class PSACHandlerAction
extends PSModelBase {
    public static final String FIELD_ACTIONDESC = "actiondesc";
    public static final String FIELD_ACTIONTIMEOUT = "actiontimeout";
    public static final String FIELD_ACTIONTYPE = "actiontype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATAACCACTION = "dataaccaction";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSACHANDLERACTIONID = "psachandleractionid";
    public static final String FIELD_PSACHANDLERACTIONNAME = "psachandleractionname";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public String getActionDesc() {
        Object objValue = this.get(FIELD_ACTIONDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiondesc")
    public void setActionDesc(String actionDesc) {
        this.set(FIELD_ACTIONDESC, actionDesc);
    }

    @JsonIgnore
    public boolean isActionDescDirty() {
        return this.contains(FIELD_ACTIONDESC);
    }

    @JsonIgnore
    public Integer getActionTimeout() {
        Object objValue = this.get(FIELD_ACTIONTIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actiontimeout")
    public void setActionTimeout(Integer actionTimeout) {
        this.set(FIELD_ACTIONTIMEOUT, actionTimeout);
    }

    @JsonIgnore
    public boolean isActionTimeoutDirty() {
        return this.contains(FIELD_ACTIONTIMEOUT);
    }

    @JsonIgnore
    public String getActionType() {
        Object objValue = this.get(FIELD_ACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontype")
    public void setActionType(String actionType) {
        this.set(FIELD_ACTIONTYPE, actionType);
    }

    @JsonIgnore
    public boolean isActionTypeDirty() {
        return this.contains(FIELD_ACTIONTYPE);
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
    public String getDataAccAction() {
        Object objValue = this.get(FIELD_DATAACCACTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataaccaction")
    public void setDataAccAction(String dataAccAction) {
        this.set(FIELD_DATAACCACTION, dataAccAction);
    }

    @JsonIgnore
    public boolean isDataAccActionDirty() {
        return this.contains(FIELD_DATAACCACTION);
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
    public String getPSACHandlerActionId() {
        Object objValue = this.get(FIELD_PSACHANDLERACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandleractionid")
    public void setPSACHandlerActionId(String pSACHandlerActionId) {
        this.set(FIELD_PSACHANDLERACTIONID, pSACHandlerActionId);
    }

    @JsonIgnore
    public boolean isPSACHandlerActionIdDirty() {
        return this.contains(FIELD_PSACHANDLERACTIONID);
    }

    @JsonIgnore
    public String getPSACHandlerActionName() {
        Object objValue = this.get(FIELD_PSACHANDLERACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandleractionname")
    public void setPSACHandlerActionName(String pSACHandlerActionName) {
        this.set(FIELD_PSACHANDLERACTIONNAME, pSACHandlerActionName);
    }

    @JsonIgnore
    public boolean isPSACHandlerActionNameDirty() {
        return this.contains(FIELD_PSACHANDLERACTIONNAME);
    }

    @JsonIgnore
    public String getPSACHandlerId() {
        Object objValue = this.get(FIELD_PSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlerid")
    public void setPSACHandlerId(String pSACHandlerId) {
        this.set(FIELD_PSACHANDLERID, pSACHandlerId);
    }

    @JsonIgnore
    public boolean isPSACHandlerIdDirty() {
        return this.contains(FIELD_PSACHANDLERID);
    }

    @JsonIgnore
    public String getPSACHandlerName() {
        Object objValue = this.get(FIELD_PSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlername")
    public void setPSACHandlerName(String pSACHandlerName) {
        this.set(FIELD_PSACHANDLERNAME, pSACHandlerName);
    }

    @JsonIgnore
    public boolean isPSACHandlerNameDirty() {
        return this.contains(FIELD_PSACHANDLERNAME);
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
    public String getPSDEOPPrivId() {
        Object objValue = this.get(FIELD_PSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivid")
    public void setPSDEOPPrivId(String pSDEOPPrivId) {
        this.set(FIELD_PSDEOPPRIVID, pSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivIdDirty() {
        return this.contains(FIELD_PSDEOPPRIVID);
    }

    @JsonIgnore
    public String getPSDEOPPrivName() {
        Object objValue = this.get(FIELD_PSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivname")
    public void setPSDEOPPrivName(String pSDEOPPrivName) {
        this.set(FIELD_PSDEOPPRIVNAME, pSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivNameDirty() {
        return this.contains(FIELD_PSDEOPPRIVNAME);
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
        return this.getPSACHandlerActionId();
    }

    public void setSrfkey(String strValue) {
        this.setPSACHandlerActionId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSACHANDLERACTION";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSACHandlerAction item = (PSACHandlerAction)MAPPER.readValue(new File(strJsonFilePath), PSACHandlerAction.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSACHandlerAction) {
            PSACHandlerAction pSACHandlerAction = (PSACHandlerAction)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSACHandlerAction) {
            PSACHandlerAction pSACHandlerAction = (PSACHandlerAction)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

