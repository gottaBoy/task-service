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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysViewPanelLogic
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLEVENT = "ctrlevent";
    public static final String FIELD_CTRLEVENTARG = "ctrleventarg";
    public static final String FIELD_CTRLEVENTARG2 = "ctrleventarg2";
    public static final String FIELD_CTRLEVENTNAME = "ctrleventname";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DSTLOGICTYPE = "dstlogictype";
    public static final String FIELD_LOGICPARAM = "logicparam";
    public static final String FIELD_LOGICPARAM2 = "logicparam2";
    public static final String FIELD_LOGICTYPE = "logictype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMPSPANELITEMID = "parampspanelitemid";
    public static final String FIELD_PARAMPSPANELITEMNAME = "parampspanelitemname";
    public static final String FIELD_PSAPPFUNCID = "psappfuncid";
    public static final String FIELD_PSAPPFUNCNAME = "psappfuncname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSVIEWLOGICID = "pssysviewlogicid";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "pssysviewlogicname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "pssysviewpanelitemid";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "pssysviewpanelitemname";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "pssysviewpanellogicid";
    public static final String FIELD_PSSYSVIEWPANELLOGICNAME = "pssysviewpanellogicname";
    public static final String FIELD_PSSYSVIEWPANELMODELID = "pssysviewpanelmodelid";
    public static final String FIELD_PSSYSVIEWPANELMODELNAME = "pssysviewpanelmodelname";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_TIMER = "timer";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public String getCtrlEvent() {
        Object objValue = this.get(FIELD_CTRLEVENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlevent")
    public void setCtrlEvent(String ctrlEvent) {
        this.set(FIELD_CTRLEVENT, ctrlEvent);
    }

    @JsonIgnore
    public boolean isCtrlEventDirty() {
        return this.contains(FIELD_CTRLEVENT);
    }

    @JsonIgnore
    public String getCtrlEventArg() {
        Object objValue = this.get(FIELD_CTRLEVENTARG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrleventarg")
    public void setCtrlEventArg(String ctrlEventArg) {
        this.set(FIELD_CTRLEVENTARG, ctrlEventArg);
    }

    @JsonIgnore
    public boolean isCtrlEventArgDirty() {
        return this.contains(FIELD_CTRLEVENTARG);
    }

    @JsonIgnore
    public String getCtrlEventArg2() {
        Object objValue = this.get(FIELD_CTRLEVENTARG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrleventarg2")
    public void setCtrlEventArg2(String ctrlEventArg2) {
        this.set(FIELD_CTRLEVENTARG2, ctrlEventArg2);
    }

    @JsonIgnore
    public boolean isCtrlEventArg2Dirty() {
        return this.contains(FIELD_CTRLEVENTARG2);
    }

    @JsonIgnore
    public String getCtrlEventName() {
        Object objValue = this.get(FIELD_CTRLEVENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrleventname")
    public void setCtrlEventName(String ctrlEventName) {
        this.set(FIELD_CTRLEVENTNAME, ctrlEventName);
    }

    @JsonIgnore
    public boolean isCtrlEventNameDirty() {
        return this.contains(FIELD_CTRLEVENTNAME);
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
    public String getDstLogicType() {
        Object objValue = this.get(FIELD_DSTLOGICTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstlogictype")
    public void setDstLogicType(String dstLogicType) {
        this.set(FIELD_DSTLOGICTYPE, dstLogicType);
    }

    @JsonIgnore
    public boolean isDstLogicTypeDirty() {
        return this.contains(FIELD_DSTLOGICTYPE);
    }

    @JsonIgnore
    public String getLogicParam() {
        Object objValue = this.get(FIELD_LOGICPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicparam")
    public void setLogicParam(String logicParam) {
        this.set(FIELD_LOGICPARAM, logicParam);
    }

    @JsonIgnore
    public boolean isLogicParamDirty() {
        return this.contains(FIELD_LOGICPARAM);
    }

    @JsonIgnore
    public String getLogicParam2() {
        Object objValue = this.get(FIELD_LOGICPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicparam2")
    public void setLogicParam2(String logicParam2) {
        this.set(FIELD_LOGICPARAM2, logicParam2);
    }

    @JsonIgnore
    public boolean isLogicParam2Dirty() {
        return this.contains(FIELD_LOGICPARAM2);
    }

    @JsonIgnore
    public String getLogicType() {
        Object objValue = this.get(FIELD_LOGICTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logictype")
    public void setLogicType(String logicType) {
        this.set(FIELD_LOGICTYPE, logicType);
    }

    @JsonIgnore
    public boolean isLogicTypeDirty() {
        return this.contains(FIELD_LOGICTYPE);
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
    public String getParamPSPanelItemId() {
        Object objValue = this.get(FIELD_PARAMPSPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="parampspanelitemid")
    public void setParamPSPanelItemId(String paramPSPanelItemId) {
        this.set(FIELD_PARAMPSPANELITEMID, paramPSPanelItemId);
    }

    @JsonIgnore
    public boolean isParamPSPanelItemIdDirty() {
        return this.contains(FIELD_PARAMPSPANELITEMID);
    }

    @JsonIgnore
    public String getParamPSPanelItemName() {
        Object objValue = this.get(FIELD_PARAMPSPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="parampspanelitemname")
    public void setParamPSPanelItemName(String paramPSPanelItemName) {
        this.set(FIELD_PARAMPSPANELITEMNAME, paramPSPanelItemName);
    }

    @JsonIgnore
    public boolean isParamPSPanelItemNameDirty() {
        return this.contains(FIELD_PARAMPSPANELITEMNAME);
    }

    @JsonIgnore
    public String getPSAppFuncId() {
        Object objValue = this.get(FIELD_PSAPPFUNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncid")
    public void setPSAppFuncId(String pSAppFuncId) {
        this.set(FIELD_PSAPPFUNCID, pSAppFuncId);
    }

    @JsonIgnore
    public boolean isPSAppFuncIdDirty() {
        return this.contains(FIELD_PSAPPFUNCID);
    }

    @JsonIgnore
    public String getPSAppFuncName() {
        Object objValue = this.get(FIELD_PSAPPFUNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncname")
    public void setPSAppFuncName(String pSAppFuncName) {
        this.set(FIELD_PSAPPFUNCNAME, pSAppFuncName);
    }

    @JsonIgnore
    public boolean isPSAppFuncNameDirty() {
        return this.contains(FIELD_PSAPPFUNCNAME);
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
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
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
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
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
    public String getPSSysViewLogicId() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicid")
    public void setPSSysViewLogicId(String pSSysViewLogicId) {
        this.set(FIELD_PSSYSVIEWLOGICID, pSSysViewLogicId);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicIdDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICID);
    }

    @JsonIgnore
    public String getPSSysViewLogicName() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicname")
    public void setPSSysViewLogicName(String pSSysViewLogicName) {
        this.set(FIELD_PSSYSVIEWLOGICNAME, pSSysViewLogicName);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicNameDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelid")
    public void setPSSysViewPanelId(String pSSysViewPanelId) {
        this.set(FIELD_PSSYSVIEWPANELID, pSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemid")
    public void setPSSysViewPanelItemId(String pSSysViewPanelItemId) {
        this.set(FIELD_PSSYSVIEWPANELITEMID, pSSysViewPanelItemId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemname")
    public void setPSSysViewPanelItemName(String pSSysViewPanelItemName) {
        this.set(FIELD_PSSYSVIEWPANELITEMNAME, pSSysViewPanelItemName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelLogicId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanellogicid")
    public void setPSSysViewPanelLogicId(String pSSysViewPanelLogicId) {
        this.set(FIELD_PSSYSVIEWPANELLOGICID, pSSysViewPanelLogicId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelLogicIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELLOGICID);
    }

    @JsonIgnore
    public String getPSSysViewPanelLogicName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanellogicname")
    public void setPSSysViewPanelLogicName(String pSSysViewPanelLogicName) {
        this.set(FIELD_PSSYSVIEWPANELLOGICNAME, pSSysViewPanelLogicName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelLogicNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELLOGICNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelModelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelmodelid")
    public void setPSSysViewPanelModelId(String pSSysViewPanelModelId) {
        this.set(FIELD_PSSYSVIEWPANELMODELID, pSSysViewPanelModelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelModelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELMODELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelModelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelmodelname")
    public void setPSSysViewPanelModelName(String pSSysViewPanelModelName) {
        this.set(FIELD_PSSYSVIEWPANELMODELNAME, pSSysViewPanelModelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelModelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELMODELNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelname")
    public void setPSSysViewPanelName(String pSSysViewPanelName) {
        this.set(FIELD_PSSYSVIEWPANELNAME, pSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELNAME);
    }

    @JsonIgnore
    public Integer getTimer() {
        Object objValue = this.get(FIELD_TIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="timer")
    public void setTimer(Integer timer) {
        this.set(FIELD_TIMER, timer);
    }

    @JsonIgnore
    public boolean isTimerDirty() {
        return this.contains(FIELD_TIMER);
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
        return this.getPSSysViewPanelLogicId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysViewPanelLogicId(strValue);
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSVIEWPANELLOGIC";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysViewPanelLogic item = (PSSysViewPanelLogic)MAPPER.readValue(new File(strJsonFilePath), PSSysViewPanelLogic.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysViewPanelLogic) {
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysViewPanelLogic) {
            PSSysViewPanelLogic pSSysViewPanelLogic = (PSSysViewPanelLogic)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

