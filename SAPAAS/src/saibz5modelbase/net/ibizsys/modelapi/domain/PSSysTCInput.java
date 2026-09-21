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

public class PSSysTCInput
extends PSModelBase {
    public static final String FIELD_ACTIONPARAMS = "actionparams";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DEFPSSYSSAMPLEVALUEID = "defpssyssamplevalueid";
    public static final String FIELD_DEFPSSYSSAMPLEVALUENAME = "defpssyssamplevaluename";
    public static final String FIELD_DEFVALUE = "defvalue";
    public static final String FIELD_INPUTTAG = "inputtag";
    public static final String FIELD_INPUTTAG2 = "inputtag2";
    public static final String FIELD_INPUTTAG3 = "inputtag3";
    public static final String FIELD_INPUTTAG4 = "inputtag4";
    public static final String FIELD_INPUTTYPE = "inputtype";
    public static final String FIELD_INPUTVALUES = "inputvalues";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSTCINPUTID = "pssystcinputid";
    public static final String FIELD_PSSYSTCINPUTNAME = "pssystcinputname";
    public static final String FIELD_PSSYSTESTCASEID = "pssystestcaseid";
    public static final String FIELD_PSSYSTESTCASENAME = "pssystestcasename";
    public static final String FIELD_PSSYSTESTDATAID = "pssystestdataid";
    public static final String FIELD_PSSYSTESTDATANAME = "pssystestdataname";
    public static final String FIELD_TARGETTYPE = "targettype";
    public static final String FIELD_TESTDATASN = "testdatasn";
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
    public String getActionParams() {
        Object objValue = this.get(FIELD_ACTIONPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionparams")
    public void setActionParams(String actionParams) {
        this.set(FIELD_ACTIONPARAMS, actionParams);
    }

    @JsonIgnore
    public boolean isActionParamsDirty() {
        return this.contains(FIELD_ACTIONPARAMS);
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
    public String getDEFPSSysSampleValueId() {
        Object objValue = this.get(FIELD_DEFPSSYSSAMPLEVALUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpssyssamplevalueid")
    public void setDEFPSSysSampleValueId(String dEFPSSysSampleValueId) {
        this.set(FIELD_DEFPSSYSSAMPLEVALUEID, dEFPSSysSampleValueId);
    }

    @JsonIgnore
    public boolean isDEFPSSysSampleValueIdDirty() {
        return this.contains(FIELD_DEFPSSYSSAMPLEVALUEID);
    }

    @JsonIgnore
    public String getDEFPSSysSampleValueName() {
        Object objValue = this.get(FIELD_DEFPSSYSSAMPLEVALUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpssyssamplevaluename")
    public void setDEFPSSysSampleValueName(String dEFPSSysSampleValueName) {
        this.set(FIELD_DEFPSSYSSAMPLEVALUENAME, dEFPSSysSampleValueName);
    }

    @JsonIgnore
    public boolean isDEFPSSysSampleValueNameDirty() {
        return this.contains(FIELD_DEFPSSYSSAMPLEVALUENAME);
    }

    @JsonIgnore
    public String getDEFValue() {
        Object objValue = this.get(FIELD_DEFVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defvalue")
    public void setDEFValue(String dEFValue) {
        this.set(FIELD_DEFVALUE, dEFValue);
    }

    @JsonIgnore
    public boolean isDEFValueDirty() {
        return this.contains(FIELD_DEFVALUE);
    }

    @JsonIgnore
    public String getInputTag() {
        Object objValue = this.get(FIELD_INPUTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputtag")
    public void setInputTag(String inputTag) {
        this.set(FIELD_INPUTTAG, inputTag);
    }

    @JsonIgnore
    public boolean isInputTagDirty() {
        return this.contains(FIELD_INPUTTAG);
    }

    @JsonIgnore
    public String getInputTag2() {
        Object objValue = this.get(FIELD_INPUTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputtag2")
    public void setInputTag2(String inputTag2) {
        this.set(FIELD_INPUTTAG2, inputTag2);
    }

    @JsonIgnore
    public boolean isInputTag2Dirty() {
        return this.contains(FIELD_INPUTTAG2);
    }

    @JsonIgnore
    public String getInputTag3() {
        Object objValue = this.get(FIELD_INPUTTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputtag3")
    public void setInputTag3(String inputTag3) {
        this.set(FIELD_INPUTTAG3, inputTag3);
    }

    @JsonIgnore
    public boolean isInputTag3Dirty() {
        return this.contains(FIELD_INPUTTAG3);
    }

    @JsonIgnore
    public String getInputTag4() {
        Object objValue = this.get(FIELD_INPUTTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputtag4")
    public void setInputTag4(String inputTag4) {
        this.set(FIELD_INPUTTAG4, inputTag4);
    }

    @JsonIgnore
    public boolean isInputTag4Dirty() {
        return this.contains(FIELD_INPUTTAG4);
    }

    @JsonIgnore
    public String getInputType() {
        Object objValue = this.get(FIELD_INPUTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputtype")
    public void setInputType(String inputType) {
        this.set(FIELD_INPUTTYPE, inputType);
    }

    @JsonIgnore
    public boolean isInputTypeDirty() {
        return this.contains(FIELD_INPUTTYPE);
    }

    @JsonIgnore
    public String getInputValues() {
        Object objValue = this.get(FIELD_INPUTVALUES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inputvalues")
    public void setInputValues(String inputValues) {
        this.set(FIELD_INPUTVALUES, inputValues);
    }

    @JsonIgnore
    public boolean isInputValuesDirty() {
        return this.contains(FIELD_INPUTVALUES);
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
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
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
    public String getPSSysTCInputId() {
        Object objValue = this.get(FIELD_PSSYSTCINPUTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystcinputid")
    public void setPSSysTCInputId(String pSSysTCInputId) {
        this.set(FIELD_PSSYSTCINPUTID, pSSysTCInputId);
    }

    @JsonIgnore
    public boolean isPSSysTCInputIdDirty() {
        return this.contains(FIELD_PSSYSTCINPUTID);
    }

    @JsonIgnore
    public String getPSSysTCInputName() {
        Object objValue = this.get(FIELD_PSSYSTCINPUTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystcinputname")
    public void setPSSysTCInputName(String pSSysTCInputName) {
        this.set(FIELD_PSSYSTCINPUTNAME, pSSysTCInputName);
    }

    @JsonIgnore
    public boolean isPSSysTCInputNameDirty() {
        return this.contains(FIELD_PSSYSTCINPUTNAME);
    }

    @JsonIgnore
    public String getPSSysTestCaseId() {
        Object objValue = this.get(FIELD_PSSYSTESTCASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestcaseid")
    public void setPSSysTestCaseId(String pSSysTestCaseId) {
        this.set(FIELD_PSSYSTESTCASEID, pSSysTestCaseId);
    }

    @JsonIgnore
    public boolean isPSSysTestCaseIdDirty() {
        return this.contains(FIELD_PSSYSTESTCASEID);
    }

    @JsonIgnore
    public String getPSSysTestCaseName() {
        Object objValue = this.get(FIELD_PSSYSTESTCASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestcasename")
    public void setPSSysTestCaseName(String pSSysTestCaseName) {
        this.set(FIELD_PSSYSTESTCASENAME, pSSysTestCaseName);
    }

    @JsonIgnore
    public boolean isPSSysTestCaseNameDirty() {
        return this.contains(FIELD_PSSYSTESTCASENAME);
    }

    @JsonIgnore
    public String getPSSysTestDataId() {
        Object objValue = this.get(FIELD_PSSYSTESTDATAID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestdataid")
    public void setPSSysTestDataId(String pSSysTestDataId) {
        this.set(FIELD_PSSYSTESTDATAID, pSSysTestDataId);
    }

    @JsonIgnore
    public boolean isPSSysTestDataIdDirty() {
        return this.contains(FIELD_PSSYSTESTDATAID);
    }

    @JsonIgnore
    public String getPSSysTestDataName() {
        Object objValue = this.get(FIELD_PSSYSTESTDATANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestdataname")
    public void setPSSysTestDataName(String pSSysTestDataName) {
        this.set(FIELD_PSSYSTESTDATANAME, pSSysTestDataName);
    }

    @JsonIgnore
    public boolean isPSSysTestDataNameDirty() {
        return this.contains(FIELD_PSSYSTESTDATANAME);
    }

    @JsonIgnore
    public String getTargetType() {
        Object objValue = this.get(FIELD_TARGETTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettype")
    public void setTargetType(String targetType) {
        this.set(FIELD_TARGETTYPE, targetType);
    }

    @JsonIgnore
    public boolean isTargetTypeDirty() {
        return this.contains(FIELD_TARGETTYPE);
    }

    @JsonIgnore
    public Integer getTestDataSN() {
        Object objValue = this.get(FIELD_TESTDATASN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="testdatasn")
    public void setTestDataSN(Integer testDataSN) {
        this.set(FIELD_TESTDATASN, testDataSN);
    }

    @JsonIgnore
    public boolean isTestDataSNDirty() {
        return this.contains(FIELD_TESTDATASN);
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
    public String getSrfkey() {
        return this.getPSSysTCInputId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysTCInputId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSTCINPUT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysTCInput item = (PSSysTCInput)MAPPER.readValue(new File(strJsonFilePath), PSSysTCInput.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysTCInput) {
            PSSysTCInput pSSysTCInput = (PSSysTCInput)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysTCInput) {
            PSSysTCInput pSSysTCInput = (PSSysTCInput)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

