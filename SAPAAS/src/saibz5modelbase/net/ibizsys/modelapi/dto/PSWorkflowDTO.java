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

public class PSWorkflowDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONMOBPSDEVIEWID = "actionmobpsdeviewid";
    public static final String FIELD_ACTIONMOBPSDEVIEWNAME = "actionmobpsdeviewname";
    public static final String FIELD_ACTIONPSDEVIEWID = "actionpsdeviewid";
    public static final String FIELD_ACTIONPSDEVIEWNAME = "actionpsdeviewname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITABLEWFSTEP = "editablewfstep";
    public static final String FIELD_ENABLE = "enable";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEDYNAVIEW = "enabledynaview";
    public static final String FIELD_ENABLEMOB = "enablemob";
    public static final String FIELD_EXTCNTSTATES = "extcntstates";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBWFEDITVIEWTYPE = "mobwfeditviewtype";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_NAMEPSLANRESID = "namepslanresid";
    public static final String FIELD_NAMEPSLANRESNAME = "namepslanresname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSWFCATID = "pssyswfcatid";
    public static final String FIELD_PSSYSWFCATNAME = "pssyswfcatname";
    public static final String FIELD_PSWORKFLOWID = "psworkflowid";
    public static final String FIELD_PSWORKFLOWNAME = "psworkflowname";
    public static final String FIELD_PSWXACCOUNTID = "pswxaccountid";
    public static final String FIELD_PSWXACCOUNTNAME = "pswxaccountname";
    public static final String FIELD_PSWXENTAPPID = "pswxentappid";
    public static final String FIELD_PSWXENTAPPNAME = "pswxentappname";
    public static final String FIELD_REMINDPSSYSMSGTEMPLID = "remindpssysmsgtemplid";
    public static final String FIELD_REMINDPSSYSMSGTEMPLNAME = "remindpssysmsgtemplname";
    public static final String FIELD_REMOTEENGINEFLAG = "remoteengineflag";
    public static final String FIELD_STARTMOBPSDEVIEWID = "startmobpsdeviewid";
    public static final String FIELD_STARTMOBPSDEVIEWNAME = "startmobpsdeviewname";
    public static final String FIELD_STARTPSDEVIEWID = "startpsdeviewid";
    public static final String FIELD_STARTPSDEVIEWNAME = "startpsdeviewname";
    public static final String FIELD_STATECODELISTID = "statecodelistid";
    public static final String FIELD_STATECODELISTNAME = "statecodelistname";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WFCANCELVALUE = "wfcancelvalue";
    public static final String FIELD_WFCANCELVALUETEXT = "wfcancelvaluetext";
    public static final String FIELD_WFEDITVIEWTYPE = "wfeditviewtype";
    public static final String FIELD_WFENGINETYPE = "wfenginetype";
    public static final String FIELD_WFERRORVALUE = "wferrorvalue";
    public static final String FIELD_WFERRORVALUETEXT = "wferrorvaluetext";
    public static final String FIELD_WFFINISHVALUE = "wffinishevalue";
    public static final String FIELD_WFFINISHVALUETEXT = "wffinishevaluetext";
    public static final String FIELD_WFPROXYMODE = "wfproxymode";
    public static final String FIELD_WFSN = "wfsn";
    public static final String FIELD_WFSTATEVALUE = "wfstatevalue";
    public static final String FIELD_WFSTEPCODELISTID = "wfstepcodelistid";
    public static final String FIELD_WFSTEPCODELISTNAME = "wfstepcodelistname";
    public static final String FIELD_WFTAG = "wftag";
    public static final String FIELD_WFTAG2 = "wftag2";
    public static final String FIELD_WFTAG3 = "wftag3";
    public static final String FIELD_WFTAG4 = "wftag4";
    public static final String FIELD_WFTYPE = "wftype";

    @JsonIgnore
    public String getActionMobPSDEViewId() {
        Object objValue = this.get(FIELD_ACTIONMOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionmobpsdeviewid")
    public void setActionMobPSDEViewId(String actionMobPSDEViewId) {
        this.set(FIELD_ACTIONMOBPSDEVIEWID, actionMobPSDEViewId);
    }

    @JsonIgnore
    public boolean isActionMobPSDEViewIdDirty() {
        return this.contains(FIELD_ACTIONMOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getActionMobPSDEViewName() {
        Object objValue = this.get(FIELD_ACTIONMOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionmobpsdeviewname")
    public void setActionMobPSDEViewName(String actionMobPSDEViewName) {
        this.set(FIELD_ACTIONMOBPSDEVIEWNAME, actionMobPSDEViewName);
    }

    @JsonIgnore
    public boolean isActionMobPSDEViewNameDirty() {
        return this.contains(FIELD_ACTIONMOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getActionPSDEViewId() {
        Object objValue = this.get(FIELD_ACTIONPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpsdeviewid")
    public void setActionPSDEViewId(String actionPSDEViewId) {
        this.set(FIELD_ACTIONPSDEVIEWID, actionPSDEViewId);
    }

    @JsonIgnore
    public boolean isActionPSDEViewIdDirty() {
        return this.contains(FIELD_ACTIONPSDEVIEWID);
    }

    @JsonIgnore
    public String getActionPSDEViewName() {
        Object objValue = this.get(FIELD_ACTIONPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpsdeviewname")
    public void setActionPSDEViewName(String actionPSDEViewName) {
        this.set(FIELD_ACTIONPSDEVIEWNAME, actionPSDEViewName);
    }

    @JsonIgnore
    public boolean isActionPSDEViewNameDirty() {
        return this.contains(FIELD_ACTIONPSDEVIEWNAME);
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
    public String getEditableWFStep() {
        Object objValue = this.get(FIELD_EDITABLEWFSTEP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editablewfstep")
    public void setEditableWFStep(String editableWFStep) {
        this.set(FIELD_EDITABLEWFSTEP, editableWFStep);
    }

    @JsonIgnore
    public boolean isEditableWFStepDirty() {
        return this.contains(FIELD_EDITABLEWFSTEP);
    }

    @JsonIgnore
    public Integer getEnable() {
        Object objValue = this.get(FIELD_ENABLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enable")
    public void setEnable(Integer enable) {
        this.set(FIELD_ENABLE, enable);
    }

    @JsonIgnore
    public boolean isEnableDirty() {
        return this.contains(FIELD_ENABLE);
    }

    @JsonIgnore
    public Integer getEnableDynaSys() {
        Object objValue = this.get(FIELD_ENABLEDYNASYS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledynasys")
    public void setEnableDynaSys(Integer enableDynaSys) {
        this.set(FIELD_ENABLEDYNASYS, enableDynaSys);
    }

    @JsonIgnore
    public boolean isEnableDynaSysDirty() {
        return this.contains(FIELD_ENABLEDYNASYS);
    }

    @JsonIgnore
    public Integer getEnableDynaView() {
        Object objValue = this.get(FIELD_ENABLEDYNAVIEW);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledynaview")
    public void setEnableDynaView(Integer enableDynaView) {
        this.set(FIELD_ENABLEDYNAVIEW, enableDynaView);
    }

    @JsonIgnore
    public boolean isEnableDynaViewDirty() {
        return this.contains(FIELD_ENABLEDYNAVIEW);
    }

    @JsonIgnore
    public Integer getEnableMob() {
        Object objValue = this.get(FIELD_ENABLEMOB);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemob")
    public void setEnableMob(Integer enableMob) {
        this.set(FIELD_ENABLEMOB, enableMob);
    }

    @JsonIgnore
    public boolean isEnableMobDirty() {
        return this.contains(FIELD_ENABLEMOB);
    }

    @JsonIgnore
    public String getExtCntStates() {
        Object objValue = this.get(FIELD_EXTCNTSTATES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extcntstates")
    public void setExtCntStates(String extCntStates) {
        this.set(FIELD_EXTCNTSTATES, extCntStates);
    }

    @JsonIgnore
    public boolean isExtCntStatesDirty() {
        return this.contains(FIELD_EXTCNTSTATES);
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
    public String getMobWFEditViewType() {
        Object objValue = this.get(FIELD_MOBWFEDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobwfeditviewtype")
    public void setMobWFEditViewType(String mobWFEditViewType) {
        this.set(FIELD_MOBWFEDITVIEWTYPE, mobWFEditViewType);
    }

    @JsonIgnore
    public boolean isMobWFEditViewTypeDirty() {
        return this.contains(FIELD_MOBWFEDITVIEWTYPE);
    }

    @JsonIgnore
    public String getModColor() {
        Object objValue = this.get(FIELD_MODCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modcolor")
    public void setModColor(String modColor) {
        this.set(FIELD_MODCOLOR, modColor);
    }

    @JsonIgnore
    public boolean isModColorDirty() {
        return this.contains(FIELD_MODCOLOR);
    }

    @JsonIgnore
    public String getNamePSLanResId() {
        Object objValue = this.get(FIELD_NAMEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresid")
    public void setNamePSLanResId(String namePSLanResId) {
        this.set(FIELD_NAMEPSLANRESID, namePSLanResId);
    }

    @JsonIgnore
    public boolean isNamePSLanResIdDirty() {
        return this.contains(FIELD_NAMEPSLANRESID);
    }

    @JsonIgnore
    public String getNamePSLanResName() {
        Object objValue = this.get(FIELD_NAMEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresname")
    public void setNamePSLanResName(String namePSLanResName) {
        this.set(FIELD_NAMEPSLANRESNAME, namePSLanResName);
    }

    @JsonIgnore
    public boolean isNamePSLanResNameDirty() {
        return this.contains(FIELD_NAMEPSLANRESNAME);
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
    public String getPSSysWFCatId() {
        Object objValue = this.get(FIELD_PSSYSWFCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfcatid")
    public void setPSSysWFCatId(String pSSysWFCatId) {
        this.set(FIELD_PSSYSWFCATID, pSSysWFCatId);
    }

    @JsonIgnore
    public boolean isPSSysWFCatIdDirty() {
        return this.contains(FIELD_PSSYSWFCATID);
    }

    @JsonIgnore
    public String getPSSysWFCatName() {
        Object objValue = this.get(FIELD_PSSYSWFCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyswfcatname")
    public void setPSSysWFCatName(String pSSysWFCatName) {
        this.set(FIELD_PSSYSWFCATNAME, pSSysWFCatName);
    }

    @JsonIgnore
    public boolean isPSSysWFCatNameDirty() {
        return this.contains(FIELD_PSSYSWFCATNAME);
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
    public String getPSWXAccountId() {
        Object objValue = this.get(FIELD_PSWXACCOUNTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxaccountid")
    public void setPSWXAccountId(String pSWXAccountId) {
        this.set(FIELD_PSWXACCOUNTID, pSWXAccountId);
    }

    @JsonIgnore
    public boolean isPSWXAccountIdDirty() {
        return this.contains(FIELD_PSWXACCOUNTID);
    }

    @JsonIgnore
    public String getPSWXAccountName() {
        Object objValue = this.get(FIELD_PSWXACCOUNTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxaccountname")
    public void setPSWXAccountName(String pSWXAccountName) {
        this.set(FIELD_PSWXACCOUNTNAME, pSWXAccountName);
    }

    @JsonIgnore
    public boolean isPSWXAccountNameDirty() {
        return this.contains(FIELD_PSWXACCOUNTNAME);
    }

    @JsonIgnore
    public String getPSWXEntAppId() {
        Object objValue = this.get(FIELD_PSWXENTAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxentappid")
    public void setPSWXEntAppId(String pSWXEntAppId) {
        this.set(FIELD_PSWXENTAPPID, pSWXEntAppId);
    }

    @JsonIgnore
    public boolean isPSWXEntAppIdDirty() {
        return this.contains(FIELD_PSWXENTAPPID);
    }

    @JsonIgnore
    public String getPSWXEntAppName() {
        Object objValue = this.get(FIELD_PSWXENTAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxentappname")
    public void setPSWXEntAppName(String pSWXEntAppName) {
        this.set(FIELD_PSWXENTAPPNAME, pSWXEntAppName);
    }

    @JsonIgnore
    public boolean isPSWXEntAppNameDirty() {
        return this.contains(FIELD_PSWXENTAPPNAME);
    }

    @JsonIgnore
    public String getRemindPSSysMsgTemplId() {
        Object objValue = this.get(FIELD_REMINDPSSYSMSGTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="remindpssysmsgtemplid")
    public void setRemindPSSysMsgTemplId(String remindPSSysMsgTemplId) {
        this.set(FIELD_REMINDPSSYSMSGTEMPLID, remindPSSysMsgTemplId);
    }

    @JsonIgnore
    public boolean isRemindPSSysMsgTemplIdDirty() {
        return this.contains(FIELD_REMINDPSSYSMSGTEMPLID);
    }

    @JsonIgnore
    public String getRemindPSSysMsgTemplName() {
        Object objValue = this.get(FIELD_REMINDPSSYSMSGTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="remindpssysmsgtemplname")
    public void setRemindPSSysMsgTemplName(String remindPSSysMsgTemplName) {
        this.set(FIELD_REMINDPSSYSMSGTEMPLNAME, remindPSSysMsgTemplName);
    }

    @JsonIgnore
    public boolean isRemindPSSysMsgTemplNameDirty() {
        return this.contains(FIELD_REMINDPSSYSMSGTEMPLNAME);
    }

    @JsonIgnore
    public Integer getRemoteEngineFlag() {
        Object objValue = this.get(FIELD_REMOTEENGINEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="remoteengineflag")
    public void setRemoteEngineFlag(Integer remoteEngineFlag) {
        this.set(FIELD_REMOTEENGINEFLAG, remoteEngineFlag);
    }

    @JsonIgnore
    public boolean isRemoteEngineFlagDirty() {
        return this.contains(FIELD_REMOTEENGINEFLAG);
    }

    @JsonIgnore
    public String getStartMobPSDEViewId() {
        Object objValue = this.get(FIELD_STARTMOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startmobpsdeviewid")
    public void setStartMobPSDEViewId(String startMobPSDEViewId) {
        this.set(FIELD_STARTMOBPSDEVIEWID, startMobPSDEViewId);
    }

    @JsonIgnore
    public boolean isStartMobPSDEViewIdDirty() {
        return this.contains(FIELD_STARTMOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getStartMobPSDEViewName() {
        Object objValue = this.get(FIELD_STARTMOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startmobpsdeviewname")
    public void setStartMobPSDEViewName(String startMobPSDEViewName) {
        this.set(FIELD_STARTMOBPSDEVIEWNAME, startMobPSDEViewName);
    }

    @JsonIgnore
    public boolean isStartMobPSDEViewNameDirty() {
        return this.contains(FIELD_STARTMOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getStartPSDEViewId() {
        Object objValue = this.get(FIELD_STARTPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startpsdeviewid")
    public void setStartPSDEViewId(String startPSDEViewId) {
        this.set(FIELD_STARTPSDEVIEWID, startPSDEViewId);
    }

    @JsonIgnore
    public boolean isStartPSDEViewIdDirty() {
        return this.contains(FIELD_STARTPSDEVIEWID);
    }

    @JsonIgnore
    public String getStartPSDEViewName() {
        Object objValue = this.get(FIELD_STARTPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startpsdeviewname")
    public void setStartPSDEViewName(String startPSDEViewName) {
        this.set(FIELD_STARTPSDEVIEWNAME, startPSDEViewName);
    }

    @JsonIgnore
    public boolean isStartPSDEViewNameDirty() {
        return this.contains(FIELD_STARTPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getStateCodeListId() {
        Object objValue = this.get(FIELD_STATECODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statecodelistid")
    public void setStateCodeListId(String stateCodeListId) {
        this.set(FIELD_STATECODELISTID, stateCodeListId);
    }

    @JsonIgnore
    public boolean isStateCodeListIdDirty() {
        return this.contains(FIELD_STATECODELISTID);
    }

    @JsonIgnore
    public String getStateCodeListName() {
        Object objValue = this.get(FIELD_STATECODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statecodelistname")
    public void setStateCodeListName(String stateCodeListName) {
        this.set(FIELD_STATECODELISTNAME, stateCodeListName);
    }

    @JsonIgnore
    public boolean isStateCodeListNameDirty() {
        return this.contains(FIELD_STATECODELISTNAME);
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
    public String getWFCancelValue() {
        Object objValue = this.get(FIELD_WFCANCELVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfcancelvalue")
    public void setWFCancelValue(String wFCancelValue) {
        this.set(FIELD_WFCANCELVALUE, wFCancelValue);
    }

    @JsonIgnore
    public boolean isWFCancelValueDirty() {
        return this.contains(FIELD_WFCANCELVALUE);
    }

    @JsonIgnore
    public String getWFCancelValueText() {
        Object objValue = this.get(FIELD_WFCANCELVALUETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfcancelvaluetext")
    public void setWFCancelValueText(String wFCancelValueText) {
        this.set(FIELD_WFCANCELVALUETEXT, wFCancelValueText);
    }

    @JsonIgnore
    public boolean isWFCancelValueTextDirty() {
        return this.contains(FIELD_WFCANCELVALUETEXT);
    }

    @JsonIgnore
    public String getWFEditViewType() {
        Object objValue = this.get(FIELD_WFEDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfeditviewtype")
    public void setWFEditViewType(String wFEditViewType) {
        this.set(FIELD_WFEDITVIEWTYPE, wFEditViewType);
    }

    @JsonIgnore
    public boolean isWFEditViewTypeDirty() {
        return this.contains(FIELD_WFEDITVIEWTYPE);
    }

    @JsonIgnore
    public String getWFEngineType() {
        Object objValue = this.get(FIELD_WFENGINETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfenginetype")
    public void setWFEngineType(String wFEngineType) {
        this.set(FIELD_WFENGINETYPE, wFEngineType);
    }

    @JsonIgnore
    public boolean isWFEngineTypeDirty() {
        return this.contains(FIELD_WFENGINETYPE);
    }

    @JsonIgnore
    public String getWFErrorValue() {
        Object objValue = this.get(FIELD_WFERRORVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wferrorvalue")
    public void setWFErrorValue(String wFErrorValue) {
        this.set(FIELD_WFERRORVALUE, wFErrorValue);
    }

    @JsonIgnore
    public boolean isWFErrorValueDirty() {
        return this.contains(FIELD_WFERRORVALUE);
    }

    @JsonIgnore
    public String getWFErrorValueText() {
        Object objValue = this.get(FIELD_WFERRORVALUETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wferrorvaluetext")
    public void setWFErrorValueText(String wFErrorValueText) {
        this.set(FIELD_WFERRORVALUETEXT, wFErrorValueText);
    }

    @JsonIgnore
    public boolean isWFErrorValueTextDirty() {
        return this.contains(FIELD_WFERRORVALUETEXT);
    }

    @JsonIgnore
    public String getWFFinishValue() {
        Object objValue = this.get(FIELD_WFFINISHVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wffinishevalue")
    public void setWFFinishValue(String wFFinishValue) {
        this.set(FIELD_WFFINISHVALUE, wFFinishValue);
    }

    @JsonIgnore
    public boolean isWFFinishValueDirty() {
        return this.contains(FIELD_WFFINISHVALUE);
    }

    @JsonIgnore
    public String getWFFinishValueText() {
        Object objValue = this.get(FIELD_WFFINISHVALUETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wffinishevaluetext")
    public void setWFFinishValueText(String wFFinishValueText) {
        this.set(FIELD_WFFINISHVALUETEXT, wFFinishValueText);
    }

    @JsonIgnore
    public boolean isWFFinishValueTextDirty() {
        return this.contains(FIELD_WFFINISHVALUETEXT);
    }

    @JsonIgnore
    public Integer getWFProxyMode() {
        Object objValue = this.get(FIELD_WFPROXYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfproxymode")
    public void setWFProxyMode(Integer wFProxyMode) {
        this.set(FIELD_WFPROXYMODE, wFProxyMode);
    }

    @JsonIgnore
    public boolean isWFProxyModeDirty() {
        return this.contains(FIELD_WFPROXYMODE);
    }

    @JsonIgnore
    public String getWFSN() {
        Object objValue = this.get(FIELD_WFSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfsn")
    public void setWFSN(String wFSN) {
        this.set(FIELD_WFSN, wFSN);
    }

    @JsonIgnore
    public boolean isWFSNDirty() {
        return this.contains(FIELD_WFSN);
    }

    @JsonIgnore
    public String getWFStateValue() {
        Object objValue = this.get(FIELD_WFSTATEVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstatevalue")
    public void setWFStateValue(String wFStateValue) {
        this.set(FIELD_WFSTATEVALUE, wFStateValue);
    }

    @JsonIgnore
    public boolean isWFStateValueDirty() {
        return this.contains(FIELD_WFSTATEVALUE);
    }

    @JsonIgnore
    public String getWFStepCodeListId() {
        Object objValue = this.get(FIELD_WFSTEPCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstepcodelistid")
    public void setWFStepCodeListId(String wFStepCodeListId) {
        this.set(FIELD_WFSTEPCODELISTID, wFStepCodeListId);
    }

    @JsonIgnore
    public boolean isWFStepCodeListIdDirty() {
        return this.contains(FIELD_WFSTEPCODELISTID);
    }

    @JsonIgnore
    public String getWFStepCodeListName() {
        Object objValue = this.get(FIELD_WFSTEPCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstepcodelistname")
    public void setWFStepCodeListName(String wFStepCodeListName) {
        this.set(FIELD_WFSTEPCODELISTNAME, wFStepCodeListName);
    }

    @JsonIgnore
    public boolean isWFStepCodeListNameDirty() {
        return this.contains(FIELD_WFSTEPCODELISTNAME);
    }

    @JsonIgnore
    public String getWFTag() {
        Object objValue = this.get(FIELD_WFTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wftag")
    public void setWFTag(String wFTag) {
        this.set(FIELD_WFTAG, wFTag);
    }

    @JsonIgnore
    public boolean isWFTagDirty() {
        return this.contains(FIELD_WFTAG);
    }

    @JsonIgnore
    public String getWFTag2() {
        Object objValue = this.get(FIELD_WFTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wftag2")
    public void setWFTag2(String wFTag2) {
        this.set(FIELD_WFTAG2, wFTag2);
    }

    @JsonIgnore
    public boolean isWFTag2Dirty() {
        return this.contains(FIELD_WFTAG2);
    }

    @JsonIgnore
    public String getWFTag3() {
        Object objValue = this.get(FIELD_WFTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wftag3")
    public void setWFTag3(String wFTag3) {
        this.set(FIELD_WFTAG3, wFTag3);
    }

    @JsonIgnore
    public boolean isWFTag3Dirty() {
        return this.contains(FIELD_WFTAG3);
    }

    @JsonIgnore
    public String getWFTag4() {
        Object objValue = this.get(FIELD_WFTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wftag4")
    public void setWFTag4(String wFTag4) {
        this.set(FIELD_WFTAG4, wFTag4);
    }

    @JsonIgnore
    public boolean isWFTag4Dirty() {
        return this.contains(FIELD_WFTAG4);
    }

    @JsonIgnore
    public String getWFType() {
        Object objValue = this.get(FIELD_WFTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wftype")
    public void setWFType(String wFType) {
        this.set(FIELD_WFTYPE, wFType);
    }

    @JsonIgnore
    public boolean isWFTypeDirty() {
        return this.contains(FIELD_WFTYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWorkflowId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWorkflowId(strValue);
    }
}

