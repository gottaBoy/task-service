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

public class PSDEWizardStep
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENABLELINK = "enablelink";
    public static final String FIELD_ENABLELOGIC = "enablelogic";
    public static final String FIELD_INITPSDEACTIONID = "initpsdeactionid";
    public static final String FIELD_INITPSDEACTIONNAME = "initpsdeactionname";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEXTPSDEACTIONID = "nextpsdeactionid";
    public static final String FIELD_NEXTPSDEACTIONNAME = "nextpsdeactionname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEWIZARDID = "psdewizardid";
    public static final String FIELD_PSDEWIZARDNAME = "psdewizardname";
    public static final String FIELD_PSDEWIZARDSTEPID = "psdewizardstepid";
    public static final String FIELD_PSDEWIZARDSTEPNAME = "psdewizardstepname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_STEPACTION = "stepaction";
    public static final String FIELD_STEPTAG = "steptag";
    public static final String FIELD_SUBTITLE = "subtitle";
    public static final String FIELD_SUBTITLEPSLANRESID = "subtitlepslanresid";
    public static final String FIELD_SUBTITLEPSLANRESNAME = "subtitlepslanresname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VISIBLELOGIC = "visiblelogic";

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
    public Integer getEnableLink() {
        Object objValue = this.get(FIELD_ENABLELINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablelink")
    public void setEnableLink(Integer enableLink) {
        this.set(FIELD_ENABLELINK, enableLink);
    }

    @JsonIgnore
    public boolean isEnableLinkDirty() {
        return this.contains(FIELD_ENABLELINK);
    }

    @JsonIgnore
    public String getEnableLogic() {
        Object objValue = this.get(FIELD_ENABLELOGIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="enablelogic")
    public void setEnableLogic(String enableLogic) {
        this.set(FIELD_ENABLELOGIC, enableLogic);
    }

    @JsonIgnore
    public boolean isEnableLogicDirty() {
        return this.contains(FIELD_ENABLELOGIC);
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
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public String getNextPSDEActionId() {
        Object objValue = this.get(FIELD_NEXTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdeactionid")
    public void setNextPSDEActionId(String nextPSDEActionId) {
        this.set(FIELD_NEXTPSDEACTIONID, nextPSDEActionId);
    }

    @JsonIgnore
    public boolean isNextPSDEActionIdDirty() {
        return this.contains(FIELD_NEXTPSDEACTIONID);
    }

    @JsonIgnore
    public String getNextPSDEActionName() {
        Object objValue = this.get(FIELD_NEXTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextpsdeactionname")
    public void setNextPSDEActionName(String nextPSDEActionName) {
        this.set(FIELD_NEXTPSDEACTIONNAME, nextPSDEActionName);
    }

    @JsonIgnore
    public boolean isNextPSDEActionNameDirty() {
        return this.contains(FIELD_NEXTPSDEACTIONNAME);
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
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getStepAction() {
        Object objValue = this.get(FIELD_STEPACTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="stepaction")
    public void setStepAction(String stepAction) {
        this.set(FIELD_STEPACTION, stepAction);
    }

    @JsonIgnore
    public boolean isStepActionDirty() {
        return this.contains(FIELD_STEPACTION);
    }

    @JsonIgnore
    public String getStepTag() {
        Object objValue = this.get(FIELD_STEPTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="steptag")
    public void setStepTag(String stepTag) {
        this.set(FIELD_STEPTAG, stepTag);
    }

    @JsonIgnore
    public boolean isStepTagDirty() {
        return this.contains(FIELD_STEPTAG);
    }

    @JsonIgnore
    public String getSubTitle() {
        Object objValue = this.get(FIELD_SUBTITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subtitle")
    public void setSubTitle(String subTitle) {
        this.set(FIELD_SUBTITLE, subTitle);
    }

    @JsonIgnore
    public boolean isSubTitleDirty() {
        return this.contains(FIELD_SUBTITLE);
    }

    @JsonIgnore
    public String getSubTitlePSLanResId() {
        Object objValue = this.get(FIELD_SUBTITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subtitlepslanresid")
    public void setSubTitlePSLanResId(String subTitlePSLanResId) {
        this.set(FIELD_SUBTITLEPSLANRESID, subTitlePSLanResId);
    }

    @JsonIgnore
    public boolean isSubTitlePSLanResIdDirty() {
        return this.contains(FIELD_SUBTITLEPSLANRESID);
    }

    @JsonIgnore
    public String getSubTitlePSLanResName() {
        Object objValue = this.get(FIELD_SUBTITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subtitlepslanresname")
    public void setSubTitlePSLanResName(String subTitlePSLanResName) {
        this.set(FIELD_SUBTITLEPSLANRESNAME, subTitlePSLanResName);
    }

    @JsonIgnore
    public boolean isSubTitlePSLanResNameDirty() {
        return this.contains(FIELD_SUBTITLEPSLANRESNAME);
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
    public String getVisibleLogic() {
        Object objValue = this.get(FIELD_VISIBLELOGIC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="visiblelogic")
    public void setVisibleLogic(String visibleLogic) {
        this.set(FIELD_VISIBLELOGIC, visibleLogic);
    }

    @JsonIgnore
    public boolean isVisibleLogicDirty() {
        return this.contains(FIELD_VISIBLELOGIC);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEWizardStepId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEWizardStepId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEWIZARDSTEP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEWizardStep item = (PSDEWizardStep)MAPPER.readValue(new File(strJsonFilePath), PSDEWizardStep.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEWizardStep) {
            PSDEWizardStep pSDEWizardStep = (PSDEWizardStep)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEWizardStep) {
            PSDEWizardStep pSDEWizardStep = (PSDEWizardStep)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

