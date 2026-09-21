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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDEWizardForm;
import net.ibizsys.modelapi.domain.PSDEWizardLogic;
import net.ibizsys.modelapi.domain.PSDEWizardStep;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEWizard
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENABLEMSLOGIC = "enablemslogic";
    public static final String FIELD_FINISHCAPTION = "finishcaption";
    public static final String FIELD_FINISHPSDEACTIONID = "finishpsdeactionid";
    public static final String FIELD_FINISHPSDEACTIONNAME = "finishpsdeactionname";
    public static final String FIELD_FINISHPSLANRESID = "finishpslanresid";
    public static final String FIELD_FINISHPSLANRESNAME = "finishpslanresname";
    public static final String FIELD_INITPSDEACTIONID = "initpsdeactionid";
    public static final String FIELD_INITPSDEACTIONNAME = "initpsdeactionname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEXTCAPTION = "nextcaption";
    public static final String FIELD_NEXTPSLANRESID = "nextpslanresid";
    public static final String FIELD_NEXTPSLANRESNAME = "nextpslanresname";
    public static final String FIELD_PREVCAPTION = "prevcaption";
    public static final String FIELD_PREVPSLANRESID = "prevpslanresid";
    public static final String FIELD_PREVPSLANRESNAME = "prevpslanresname";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEWIZARDID = "psdewizardid";
    public static final String FIELD_PSDEWIZARDNAME = "psdewizardname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_STATEPSDEFID = "statepsdefid";
    public static final String FIELD_STATEPSDEFNAME = "statepsdefname";
    public static final String FIELD_STATEWIZARDFLAG = "statewizardflag";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_WIZARDSTYLE = "wizardstyle";
    private List<PSDEWizardStep> psdewizardsteps;
    private List<PSDEWizardForm> psdewizardforms;
    private List<PSDEWizardLogic> psdewizardlogics;

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
    public Integer getEnableMSLogic() {
        Object objValue = this.get(FIELD_ENABLEMSLOGIC);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemslogic")
    public void setEnableMSLogic(Integer enableMSLogic) {
        this.set(FIELD_ENABLEMSLOGIC, enableMSLogic);
    }

    @JsonIgnore
    public boolean isEnableMSLogicDirty() {
        return this.contains(FIELD_ENABLEMSLOGIC);
    }

    @JsonIgnore
    public String getFinishCaption() {
        Object objValue = this.get(FIELD_FINISHCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishcaption")
    public void setFinishCaption(String finishCaption) {
        this.set(FIELD_FINISHCAPTION, finishCaption);
    }

    @JsonIgnore
    public boolean isFinishCaptionDirty() {
        return this.contains(FIELD_FINISHCAPTION);
    }

    @JsonIgnore
    public String getFinishPSDEActionId() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionid")
    public void setFinishPSDEActionId(String finishPSDEActionId) {
        this.set(FIELD_FINISHPSDEACTIONID, finishPSDEActionId);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionIdDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONID);
    }

    @JsonIgnore
    public String getFinishPSDEActionName() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionname")
    public void setFinishPSDEActionName(String finishPSDEActionName) {
        this.set(FIELD_FINISHPSDEACTIONNAME, finishPSDEActionName);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionNameDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getFinishPSLanResId() {
        Object objValue = this.get(FIELD_FINISHPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpslanresid")
    public void setFinishPSLanResId(String finishPSLanResId) {
        this.set(FIELD_FINISHPSLANRESID, finishPSLanResId);
    }

    @JsonIgnore
    public boolean isFinishPSLanResIdDirty() {
        return this.contains(FIELD_FINISHPSLANRESID);
    }

    @JsonIgnore
    public String getFinishPSLanResName() {
        Object objValue = this.get(FIELD_FINISHPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpslanresname")
    public void setFinishPSLanResName(String finishPSLanResName) {
        this.set(FIELD_FINISHPSLANRESNAME, finishPSLanResName);
    }

    @JsonIgnore
    public boolean isFinishPSLanResNameDirty() {
        return this.contains(FIELD_FINISHPSLANRESNAME);
    }

    @JsonIgnore
    public String getInitPSDEActionId() {
        Object objValue = this.get(FIELD_INITPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpsdeactionid")
    public void setInitPSDEActionId(String initPSDEActionId) {
        this.set(FIELD_INITPSDEACTIONID, initPSDEActionId);
    }

    @JsonIgnore
    public boolean isInitPSDEActionIdDirty() {
        return this.contains(FIELD_INITPSDEACTIONID);
    }

    @JsonIgnore
    public String getInitPSDEActionName() {
        Object objValue = this.get(FIELD_INITPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpsdeactionname")
    public void setInitPSDEActionName(String initPSDEActionName) {
        this.set(FIELD_INITPSDEACTIONNAME, initPSDEActionName);
    }

    @JsonIgnore
    public boolean isInitPSDEActionNameDirty() {
        return this.contains(FIELD_INITPSDEACTIONNAME);
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
    public String getNextCaption() {
        Object objValue = this.get(FIELD_NEXTCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextcaption")
    public void setNextCaption(String nextCaption) {
        this.set(FIELD_NEXTCAPTION, nextCaption);
    }

    @JsonIgnore
    public boolean isNextCaptionDirty() {
        return this.contains(FIELD_NEXTCAPTION);
    }

    @JsonIgnore
    public String getNextPSLanResId() {
        Object objValue = this.get(FIELD_NEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpslanresid")
    public void setNextPSLanResId(String nextPSLanResId) {
        this.set(FIELD_NEXTPSLANRESID, nextPSLanResId);
    }

    @JsonIgnore
    public boolean isNextPSLanResIdDirty() {
        return this.contains(FIELD_NEXTPSLANRESID);
    }

    @JsonIgnore
    public String getNextPSLanResName() {
        Object objValue = this.get(FIELD_NEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpslanresname")
    public void setNextPSLanResName(String nextPSLanResName) {
        this.set(FIELD_NEXTPSLANRESNAME, nextPSLanResName);
    }

    @JsonIgnore
    public boolean isNextPSLanResNameDirty() {
        return this.contains(FIELD_NEXTPSLANRESNAME);
    }

    @JsonIgnore
    public String getPrevCaption() {
        Object objValue = this.get(FIELD_PREVCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevcaption")
    public void setPrevCaption(String prevCaption) {
        this.set(FIELD_PREVCAPTION, prevCaption);
    }

    @JsonIgnore
    public boolean isPrevCaptionDirty() {
        return this.contains(FIELD_PREVCAPTION);
    }

    @JsonIgnore
    public String getPrevPSLanResId() {
        Object objValue = this.get(FIELD_PREVPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpslanresid")
    public void setPrevPSLanResId(String prevPSLanResId) {
        this.set(FIELD_PREVPSLANRESID, prevPSLanResId);
    }

    @JsonIgnore
    public boolean isPrevPSLanResIdDirty() {
        return this.contains(FIELD_PREVPSLANRESID);
    }

    @JsonIgnore
    public String getPrevPSLanResName() {
        Object objValue = this.get(FIELD_PREVPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpslanresname")
    public void setPrevPSLanResName(String prevPSLanResName) {
        this.set(FIELD_PREVPSLANRESNAME, prevPSLanResName);
    }

    @JsonIgnore
    public boolean isPrevPSLanResNameDirty() {
        return this.contains(FIELD_PREVPSLANRESNAME);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupId() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupid")
    public void setPSCtrlLogicGroupId(String pSCtrlLogicGroupId) {
        this.set(FIELD_PSCTRLLOGICGROUPID, pSCtrlLogicGroupId);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupIdDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPID);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupName() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupname")
    public void setPSCtrlLogicGroupName(String pSCtrlLogicGroupName) {
        this.set(FIELD_PSCTRLLOGICGROUPNAME, pSCtrlLogicGroupName);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupNameDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPNAME);
    }

    @JsonIgnore
    public String getPSCtrlMsgId() {
        Object objValue = this.get(FIELD_PSCTRLMSGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgid")
    public void setPSCtrlMsgId(String pSCtrlMsgId) {
        this.set(FIELD_PSCTRLMSGID, pSCtrlMsgId);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgIdDirty() {
        return this.contains(FIELD_PSCTRLMSGID);
    }

    @JsonIgnore
    public String getPSCtrlMsgName() {
        Object objValue = this.get(FIELD_PSCTRLMSGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgname")
    public void setPSCtrlMsgName(String pSCtrlMsgName) {
        this.set(FIELD_PSCTRLMSGNAME, pSCtrlMsgName);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgNameDirty() {
        return this.contains(FIELD_PSCTRLMSGNAME);
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
    public String getPSDEWizardId() {
        Object objValue = this.get(FIELD_PSDEWIZARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardid")
    public void setPSDEWizardId(String pSDEWizardId) {
        this.set(FIELD_PSDEWIZARDID, pSDEWizardId);
    }

    @JsonIgnore
    public boolean isPSDEWizardIdDirty() {
        return this.contains(FIELD_PSDEWIZARDID);
    }

    @JsonIgnore
    public String getPSDEWizardName() {
        Object objValue = this.get(FIELD_PSDEWIZARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardname")
    public void setPSDEWizardName(String pSDEWizardName) {
        this.set(FIELD_PSDEWIZARDNAME, pSDEWizardName);
    }

    @JsonIgnore
    public boolean isPSDEWizardNameDirty() {
        return this.contains(FIELD_PSDEWIZARDNAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
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
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public Integer getStateWizardFlag() {
        Object objValue = this.get(FIELD_STATEWIZARDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="statewizardflag")
    public void setStateWizardFlag(Integer stateWizardFlag) {
        this.set(FIELD_STATEWIZARDFLAG, stateWizardFlag);
    }

    @JsonIgnore
    public boolean isStateWizardFlagDirty() {
        return this.contains(FIELD_STATEWIZARDFLAG);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
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
    public String getWizardStyle() {
        Object objValue = this.get(FIELD_WIZARDSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wizardstyle")
    public void setWizardStyle(String wizardStyle) {
        this.set(FIELD_WIZARDSTYLE, wizardStyle);
    }

    @JsonIgnore
    public boolean isWizardStyleDirty() {
        return this.contains(FIELD_WIZARDSTYLE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEWizardId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEWizardId(strValue);
    }

    public List<PSDEWizardStep> getPsdewizardsteps() {
        return this.psdewizardsteps;
    }

    public void setPsdewizardsteps(List<PSDEWizardStep> psdewizardsteps) {
        this.psdewizardsteps = psdewizardsteps;
    }

    public List<PSDEWizardForm> getPsdewizardforms() {
        return this.psdewizardforms;
    }

    public void setPsdewizardforms(List<PSDEWizardForm> psdewizardforms) {
        this.psdewizardforms = psdewizardforms;
    }

    public List<PSDEWizardLogic> getPsdewizardlogics() {
        return this.psdewizardlogics;
    }

    public void setPsdewizardlogics(List<PSDEWizardLogic> psdewizardlogics) {
        this.psdewizardlogics = psdewizardlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdewizardsteps")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdewizardforms")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdewizardlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdewizardsteps")) {
            this.init();
            return this.psdewizardsteps;
        }
        if (strName.equalsIgnoreCase("psdewizardforms")) {
            this.init();
            return this.psdewizardforms;
        }
        if (strName.equalsIgnoreCase("psdewizardlogics")) {
            this.init();
            return this.psdewizardlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEWIZARD";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEWizard item = (PSDEWizard)MAPPER.readValue(new File(strJsonFilePath), PSDEWizard.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEWizard) {
            PSDEWizard dst = (PSDEWizard)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdewizardsteps() != null) {
                    ArrayList<PSDEWizardStep> psdewizardsteps = new ArrayList<PSDEWizardStep>();
                    for (PSDEWizardStep pSDEWizardStep : this.getPsdewizardsteps()) {
                        if (bDeepMode) {
                            newitem = new PSDEWizardStep();
                            pSDEWizardStep.to(newitem, false, bDeepMode);
                            psdewizardsteps.add((PSDEWizardStep)newitem);
                            continue;
                        }
                        psdewizardsteps.add(pSDEWizardStep);
                    }
                    dst.setPsdewizardsteps(psdewizardsteps);
                }
                if (this.getPsdewizardforms() != null) {
                    ArrayList<PSDEWizardForm> psdewizardforms = new ArrayList<PSDEWizardForm>();
                    for (PSDEWizardForm pSDEWizardForm : this.getPsdewizardforms()) {
                        if (bDeepMode) {
                            newitem = new PSDEWizardForm();
                            pSDEWizardForm.to(newitem, false, bDeepMode);
                            psdewizardforms.add((PSDEWizardForm)newitem);
                            continue;
                        }
                        psdewizardforms.add(pSDEWizardForm);
                    }
                    dst.setPsdewizardforms(psdewizardforms);
                }
                if (this.getPsdewizardlogics() != null) {
                    ArrayList<PSDEWizardLogic> psdewizardlogics = new ArrayList<PSDEWizardLogic>();
                    for (PSDEWizardLogic pSDEWizardLogic : this.getPsdewizardlogics()) {
                        if (bDeepMode) {
                            newitem = new PSDEWizardLogic();
                            pSDEWizardLogic.to(newitem, false, bDeepMode);
                            psdewizardlogics.add((PSDEWizardLogic)newitem);
                            continue;
                        }
                        psdewizardlogics.add(pSDEWizardLogic);
                    }
                    dst.setPsdewizardlogics(psdewizardlogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEWizard) {
            PSDEWizard src = (PSDEWizard)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdewizardsteps() != null) {
                    ArrayList<PSDEWizardStep> psdewizardsteps = new ArrayList<PSDEWizardStep>();
                    for (PSDEWizardStep pSDEWizardStep : src.getPsdewizardsteps()) {
                        if (bDeepMode) {
                            newItem = new PSDEWizardStep();
                            ((PSDEWizardStep)newItem).from(pSDEWizardStep, false, bDeepMode);
                            psdewizardsteps.add((PSDEWizardStep)newItem);
                            continue;
                        }
                        psdewizardsteps.add(pSDEWizardStep);
                    }
                    this.setPsdewizardsteps(psdewizardsteps);
                }
                if (src.getPsdewizardforms() != null) {
                    ArrayList<PSDEWizardForm> psdewizardforms = new ArrayList<PSDEWizardForm>();
                    for (PSDEWizardForm pSDEWizardForm : src.getPsdewizardforms()) {
                        if (bDeepMode) {
                            newItem = new PSDEWizardForm();
                            ((PSDEWizardForm)newItem).from(pSDEWizardForm, false, bDeepMode);
                            psdewizardforms.add((PSDEWizardForm)newItem);
                            continue;
                        }
                        psdewizardforms.add(pSDEWizardForm);
                    }
                    this.setPsdewizardforms(psdewizardforms);
                }
                if (src.getPsdewizardlogics() != null) {
                    ArrayList<PSDEWizardLogic> psdewizardlogics = new ArrayList<PSDEWizardLogic>();
                    for (PSDEWizardLogic pSDEWizardLogic : src.getPsdewizardlogics()) {
                        if (bDeepMode) {
                            newItem = new PSDEWizardLogic();
                            ((PSDEWizardLogic)newItem).from(pSDEWizardLogic, false, bDeepMode);
                            psdewizardlogics.add((PSDEWizardLogic)newItem);
                            continue;
                        }
                        psdewizardlogics.add(pSDEWizardLogic);
                    }
                    this.setPsdewizardlogics(psdewizardlogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

