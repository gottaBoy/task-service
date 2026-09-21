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

public class PSDEWizardForm
extends PSModelBase {
    public static final String FIELD_CMPSLANRESID = "cmpslanresid";
    public static final String FIELD_CMPSLANRESID2 = "cmpslanresid2";
    public static final String FIELD_CMPSLANRESNAME = "cmpslanresname";
    public static final String FIELD_CMPSLANRESNAME2 = "cmpslanresname2";
    public static final String FIELD_CONFIRMINFO = "confirminfo";
    public static final String FIELD_CONFIRMINFO2 = "confirminfo2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_FINISHENABLELOGIC = "finishenablelogic";
    public static final String FIELD_FIRSTFORM = "firstform";
    public static final String FIELD_FORMTAG = "formtag";
    public static final String FIELD_LOADPSDEACTIONID = "loadpsdeactionid";
    public static final String FIELD_LOADPSDEACTIONNAME = "loadpsdeactionname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEXTENABLELOGIC = "nextenablelogic";
    public static final String FIELD_PREVENABLELOGIC = "prevenablelogic";
    public static final String FIELD_PREVPSDEACTIONID = "prevpsdeactionid";
    public static final String FIELD_PREVPSDEACTIONNAME = "prevpsdeactionname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEWIZARDFORMID = "psdewizardformid";
    public static final String FIELD_PSDEWIZARDFORMNAME = "psdewizardformname";
    public static final String FIELD_PSDEWIZARDID = "psdewizardid";
    public static final String FIELD_PSDEWIZARDNAME = "psdewizardname";
    public static final String FIELD_PSDEWIZARDSTEPID = "psdewizardstepid";
    public static final String FIELD_PSDEWIZARDSTEPNAME = "psdewizardstepname";
    public static final String FIELD_SAVEPSDEACTIONID = "savepsdeactionid";
    public static final String FIELD_SAVEPSDEACTIONNAME = "savepsdeactionname";
    public static final String FIELD_STEPACTIONS = "stepactions";
    public static final String FIELD_STEPORDERVALUE = "stepordervalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getCMPSLanResId() {
        Object objValue = this.get(FIELD_CMPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresid")
    public void setCMPSLanResId(String cMPSLanResId) {
        this.set(FIELD_CMPSLANRESID, cMPSLanResId);
    }

    @JsonIgnore
    public boolean isCMPSLanResIdDirty() {
        return this.contains(FIELD_CMPSLANRESID);
    }

    @JsonIgnore
    public String getCMPSLanResId2() {
        Object objValue = this.get(FIELD_CMPSLANRESID2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresid2")
    public void setCMPSLanResId2(String cMPSLanResId2) {
        this.set(FIELD_CMPSLANRESID2, cMPSLanResId2);
    }

    @JsonIgnore
    public boolean isCMPSLanResId2Dirty() {
        return this.contains(FIELD_CMPSLANRESID2);
    }

    @JsonIgnore
    public String getCMPSLanResName() {
        Object objValue = this.get(FIELD_CMPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresname")
    public void setCMPSLanResName(String cMPSLanResName) {
        this.set(FIELD_CMPSLANRESNAME, cMPSLanResName);
    }

    @JsonIgnore
    public boolean isCMPSLanResNameDirty() {
        return this.contains(FIELD_CMPSLANRESNAME);
    }

    @JsonIgnore
    public String getCMPSLanResName2() {
        Object objValue = this.get(FIELD_CMPSLANRESNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cmpslanresname2")
    public void setCMPSLanResName2(String cMPSLanResName2) {
        this.set(FIELD_CMPSLANRESNAME2, cMPSLanResName2);
    }

    @JsonIgnore
    public boolean isCMPSLanResName2Dirty() {
        return this.contains(FIELD_CMPSLANRESNAME2);
    }

    @JsonIgnore
    public String getConfirmInfo() {
        Object objValue = this.get(FIELD_CONFIRMINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="confirminfo")
    public void setConfirmInfo(String confirmInfo) {
        this.set(FIELD_CONFIRMINFO, confirmInfo);
    }

    @JsonIgnore
    public boolean isConfirmInfoDirty() {
        return this.contains(FIELD_CONFIRMINFO);
    }

    @JsonIgnore
    public String getConfirmInfo2() {
        Object objValue = this.get(FIELD_CONFIRMINFO2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="confirminfo2")
    public void setConfirmInfo2(String confirmInfo2) {
        this.set(FIELD_CONFIRMINFO2, confirmInfo2);
    }

    @JsonIgnore
    public boolean isConfirmInfo2Dirty() {
        return this.contains(FIELD_CONFIRMINFO2);
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
    public String getFinishEnableLogic() {
        Object objValue = this.get(FIELD_FINISHENABLELOGIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishenablelogic")
    public void setFinishEnableLogic(String finishEnableLogic) {
        this.set(FIELD_FINISHENABLELOGIC, finishEnableLogic);
    }

    @JsonIgnore
    public boolean isFinishEnableLogicDirty() {
        return this.contains(FIELD_FINISHENABLELOGIC);
    }

    @JsonIgnore
    public Integer getFirstForm() {
        Object objValue = this.get(FIELD_FIRSTFORM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="firstform")
    public void setFirstForm(Integer firstForm) {
        this.set(FIELD_FIRSTFORM, firstForm);
    }

    @JsonIgnore
    public boolean isFirstFormDirty() {
        return this.contains(FIELD_FIRSTFORM);
    }

    @JsonIgnore
    public String getFormTag() {
        Object objValue = this.get(FIELD_FORMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtag")
    public void setFormTag(String formTag) {
        this.set(FIELD_FORMTAG, formTag);
    }

    @JsonIgnore
    public boolean isFormTagDirty() {
        return this.contains(FIELD_FORMTAG);
    }

    @JsonIgnore
    public String getLoadPSDEActionId() {
        Object objValue = this.get(FIELD_LOADPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="loadpsdeactionid")
    public void setLoadPSDEActionId(String loadPSDEActionId) {
        this.set(FIELD_LOADPSDEACTIONID, loadPSDEActionId);
    }

    @JsonIgnore
    public boolean isLoadPSDEActionIdDirty() {
        return this.contains(FIELD_LOADPSDEACTIONID);
    }

    @JsonIgnore
    public String getLoadPSDEActionName() {
        Object objValue = this.get(FIELD_LOADPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="loadpsdeactionname")
    public void setLoadPSDEActionName(String loadPSDEActionName) {
        this.set(FIELD_LOADPSDEACTIONNAME, loadPSDEActionName);
    }

    @JsonIgnore
    public boolean isLoadPSDEActionNameDirty() {
        return this.contains(FIELD_LOADPSDEACTIONNAME);
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
    public String getNextEnableLogic() {
        Object objValue = this.get(FIELD_NEXTENABLELOGIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextenablelogic")
    public void setNextEnableLogic(String nextEnableLogic) {
        this.set(FIELD_NEXTENABLELOGIC, nextEnableLogic);
    }

    @JsonIgnore
    public boolean isNextEnableLogicDirty() {
        return this.contains(FIELD_NEXTENABLELOGIC);
    }

    @JsonIgnore
    public String getPrevEnableLogic() {
        Object objValue = this.get(FIELD_PREVENABLELOGIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevenablelogic")
    public void setPrevEnableLogic(String prevEnableLogic) {
        this.set(FIELD_PREVENABLELOGIC, prevEnableLogic);
    }

    @JsonIgnore
    public boolean isPrevEnableLogicDirty() {
        return this.contains(FIELD_PREVENABLELOGIC);
    }

    @JsonIgnore
    public String getPrevPSDEActionId() {
        Object objValue = this.get(FIELD_PREVPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpsdeactionid")
    public void setPrevPSDEActionId(String prevPSDEActionId) {
        this.set(FIELD_PREVPSDEACTIONID, prevPSDEActionId);
    }

    @JsonIgnore
    public boolean isPrevPSDEActionIdDirty() {
        return this.contains(FIELD_PREVPSDEACTIONID);
    }

    @JsonIgnore
    public String getPrevPSDEActionName() {
        Object objValue = this.get(FIELD_PREVPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="prevpsdeactionname")
    public void setPrevPSDEActionName(String prevPSDEActionName) {
        this.set(FIELD_PREVPSDEACTIONNAME, prevPSDEActionName);
    }

    @JsonIgnore
    public boolean isPrevPSDEActionNameDirty() {
        return this.contains(FIELD_PREVPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
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
    public String getPSDEWizardFormId() {
        Object objValue = this.get(FIELD_PSDEWIZARDFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardformid")
    public void setPSDEWizardFormId(String pSDEWizardFormId) {
        this.set(FIELD_PSDEWIZARDFORMID, pSDEWizardFormId);
    }

    @JsonIgnore
    public boolean isPSDEWizardFormIdDirty() {
        return this.contains(FIELD_PSDEWIZARDFORMID);
    }

    @JsonIgnore
    public String getPSDEWizardFormName() {
        Object objValue = this.get(FIELD_PSDEWIZARDFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardformname")
    public void setPSDEWizardFormName(String pSDEWizardFormName) {
        this.set(FIELD_PSDEWIZARDFORMNAME, pSDEWizardFormName);
    }

    @JsonIgnore
    public boolean isPSDEWizardFormNameDirty() {
        return this.contains(FIELD_PSDEWIZARDFORMNAME);
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
    public String getPSDEWizardStepId() {
        Object objValue = this.get(FIELD_PSDEWIZARDSTEPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardstepid")
    public void setPSDEWizardStepId(String pSDEWizardStepId) {
        this.set(FIELD_PSDEWIZARDSTEPID, pSDEWizardStepId);
    }

    @JsonIgnore
    public boolean isPSDEWizardStepIdDirty() {
        return this.contains(FIELD_PSDEWIZARDSTEPID);
    }

    @JsonIgnore
    public String getPSDEWizardStepName() {
        Object objValue = this.get(FIELD_PSDEWIZARDSTEPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardstepname")
    public void setPSDEWizardStepName(String pSDEWizardStepName) {
        this.set(FIELD_PSDEWIZARDSTEPNAME, pSDEWizardStepName);
    }

    @JsonIgnore
    public boolean isPSDEWizardStepNameDirty() {
        return this.contains(FIELD_PSDEWIZARDSTEPNAME);
    }

    @JsonIgnore
    public String getSavePSDEActionId() {
        Object objValue = this.get(FIELD_SAVEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="savepsdeactionid")
    public void setSavePSDEActionId(String savePSDEActionId) {
        this.set(FIELD_SAVEPSDEACTIONID, savePSDEActionId);
    }

    @JsonIgnore
    public boolean isSavePSDEActionIdDirty() {
        return this.contains(FIELD_SAVEPSDEACTIONID);
    }

    @JsonIgnore
    public String getSavePSDEActionName() {
        Object objValue = this.get(FIELD_SAVEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="savepsdeactionname")
    public void setSavePSDEActionName(String savePSDEActionName) {
        this.set(FIELD_SAVEPSDEACTIONNAME, savePSDEActionName);
    }

    @JsonIgnore
    public boolean isSavePSDEActionNameDirty() {
        return this.contains(FIELD_SAVEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getStepActions() {
        Object objValue = this.get(FIELD_STEPACTIONS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="stepactions")
    public void setStepActions(String stepActions) {
        this.set(FIELD_STEPACTIONS, stepActions);
    }

    @JsonIgnore
    public boolean isStepActionsDirty() {
        return this.contains(FIELD_STEPACTIONS);
    }

    @JsonIgnore
    public Integer getStepOrderValue() {
        Object objValue = this.get(FIELD_STEPORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stepordervalue")
    public void setStepOrderValue(Integer stepOrderValue) {
        this.set(FIELD_STEPORDERVALUE, stepOrderValue);
    }

    @JsonIgnore
    public boolean isStepOrderValueDirty() {
        return this.contains(FIELD_STEPORDERVALUE);
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
    public String getSrfkey() {
        return this.getPSDEWizardFormId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEWizardFormId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEWIZARDFORM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEWizardForm item = (PSDEWizardForm)MAPPER.readValue(new File(strJsonFilePath), PSDEWizardForm.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEWizardForm) {
            PSDEWizardForm pSDEWizardForm = (PSDEWizardForm)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEWizardForm) {
            PSDEWizardForm pSDEWizardForm = (PSDEWizardForm)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

