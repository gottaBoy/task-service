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
import java.util.List;
import net.ibizsys.modelapi.dto.PSSysTCAssertDTO;
import net.ibizsys.modelapi.dto.PSSysTCInputDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSSysTestCaseDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONPARAMS = "actionparams";
    public static final String FIELD_ASSERTRESULT = "assertresult";
    public static final String FIELD_ASSERTTYPE = "asserttype";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENT = "content";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFPSSYSSAMPLEVALUEID = "defpssyssamplevalueid";
    public static final String FIELD_DEFPSSYSSAMPLEVALUENAME = "defpssyssamplevaluename";
    public static final String FIELD_DEFVALUE = "defvalue";
    public static final String FIELD_EXCEPTIONDATA = "exceptiondata";
    public static final String FIELD_EXCEPTIONDATA2 = "exceptiondata2";
    public static final String FIELD_EXCEPTIONNAME = "exceptionname";
    public static final String FIELD_INPUTVALUES = "inputvalues";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSAPPVIEWID = "psappviewid";
    public static final String FIELD_PSAPPVIEWNAME = "psappviewname";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDESADETAILID = "psdesadetailid";
    public static final String FIELD_PSDESADETAILNAME = "psdesadetailname";
    public static final String FIELD_PSDESERVICEAPIID = "psdeserviceapiid";
    public static final String FIELD_PSDESERVICEAPINAME = "psdeserviceapiname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSTESTCASEID = "pssystestcaseid";
    public static final String FIELD_PSSYSTESTCASENAME = "pssystestcasename";
    public static final String FIELD_PSSYSTESTDATAID = "pssystestdataid";
    public static final String FIELD_PSSYSTESTDATANAME = "pssystestdataname";
    public static final String FIELD_PSSYSTESTMODULEID = "pssystestmoduleid";
    public static final String FIELD_PSSYSTESTMODULENAME = "pssystestmodulename";
    public static final String FIELD_PSSYSTESTPRJID = "pssystestprjid";
    public static final String FIELD_PSSYSTESTPRJNAME = "pssystestprjname";
    public static final String FIELD_ROLLBACKTRAN = "rollbacktran";
    public static final String FIELD_TARGETTYPE = "targettype";
    public static final String FIELD_TESTCASELEVEL = "testcaselevel";
    public static final String FIELD_TESTCASESN = "testcasesn";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERDATA3 = "userdata3";
    public static final String FIELD_USERDATA4 = "userdata4";
    public static final String FIELD_USERFLAG = "userflag";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysTCInputDTO> pssystcinputs;
    private List<PSSysTCAssertDTO> pssystcasserts;

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
    public String getAssertResult() {
        Object objValue = this.get(FIELD_ASSERTRESULT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="assertresult")
    public void setAssertResult(String assertResult) {
        this.set(FIELD_ASSERTRESULT, assertResult);
    }

    @JsonIgnore
    public boolean isAssertResultDirty() {
        return this.contains(FIELD_ASSERTRESULT);
    }

    @JsonIgnore
    public String getAssertType() {
        Object objValue = this.get(FIELD_ASSERTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="asserttype")
    public void setAssertType(String assertType) {
        this.set(FIELD_ASSERTTYPE, assertType);
    }

    @JsonIgnore
    public boolean isAssertTypeDirty() {
        return this.contains(FIELD_ASSERTTYPE);
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
    public String getContent() {
        Object objValue = this.get(FIELD_CONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content")
    public void setContent(String content) {
        this.set(FIELD_CONTENT, content);
    }

    @JsonIgnore
    public boolean isContentDirty() {
        return this.contains(FIELD_CONTENT);
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
    public String getExceptionData() {
        Object objValue = this.get(FIELD_EXCEPTIONDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exceptiondata")
    public void setExceptionData(String exceptionData) {
        this.set(FIELD_EXCEPTIONDATA, exceptionData);
    }

    @JsonIgnore
    public boolean isExceptionDataDirty() {
        return this.contains(FIELD_EXCEPTIONDATA);
    }

    @JsonIgnore
    public String getExceptionData2() {
        Object objValue = this.get(FIELD_EXCEPTIONDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exceptiondata2")
    public void setExceptionData2(String exceptionData2) {
        this.set(FIELD_EXCEPTIONDATA2, exceptionData2);
    }

    @JsonIgnore
    public boolean isExceptionData2Dirty() {
        return this.contains(FIELD_EXCEPTIONDATA2);
    }

    @JsonIgnore
    public String getExceptionName() {
        Object objValue = this.get(FIELD_EXCEPTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exceptionname")
    public void setExceptionName(String exceptionName) {
        this.set(FIELD_EXCEPTIONNAME, exceptionName);
    }

    @JsonIgnore
    public boolean isExceptionNameDirty() {
        return this.contains(FIELD_EXCEPTIONNAME);
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
    public String getPSAppViewId() {
        Object objValue = this.get(FIELD_PSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewid")
    public void setPSAppViewId(String pSAppViewId) {
        this.set(FIELD_PSAPPVIEWID, pSAppViewId);
    }

    @JsonIgnore
    public boolean isPSAppViewIdDirty() {
        return this.contains(FIELD_PSAPPVIEWID);
    }

    @JsonIgnore
    public String getPSAppViewName() {
        Object objValue = this.get(FIELD_PSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewname")
    public void setPSAppViewName(String pSAppViewName) {
        this.set(FIELD_PSAPPVIEWNAME, pSAppViewName);
    }

    @JsonIgnore
    public boolean isPSAppViewNameDirty() {
        return this.contains(FIELD_PSAPPVIEWNAME);
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
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
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
    public String getPSDESADetailId() {
        Object objValue = this.get(FIELD_PSDESADETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesadetailid")
    public void setPSDESADetailId(String pSDESADetailId) {
        this.set(FIELD_PSDESADETAILID, pSDESADetailId);
    }

    @JsonIgnore
    public boolean isPSDESADetailIdDirty() {
        return this.contains(FIELD_PSDESADETAILID);
    }

    @JsonIgnore
    public String getPSDESADetailName() {
        Object objValue = this.get(FIELD_PSDESADETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesadetailname")
    public void setPSDESADetailName(String pSDESADetailName) {
        this.set(FIELD_PSDESADETAILNAME, pSDESADetailName);
    }

    @JsonIgnore
    public boolean isPSDESADetailNameDirty() {
        return this.contains(FIELD_PSDESADETAILNAME);
    }

    @JsonIgnore
    public String getPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_PSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiid")
    public void setPSDEServiceAPIId(String pSDEServiceAPIId) {
        this.set(FIELD_PSDESERVICEAPIID, pSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_PSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_PSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiname")
    public void setPSDEServiceAPIName(String pSDEServiceAPIName) {
        this.set(FIELD_PSDESERVICEAPINAME, pSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPINameDirty() {
        return this.contains(FIELD_PSDESERVICEAPINAME);
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
    public String getPSSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiid")
    public void setPSSysServiceAPIId(String pSSysServiceAPIId) {
        this.set(FIELD_PSSYSSERVICEAPIID, pSSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
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
    public String getPSSysTestModuleId() {
        Object objValue = this.get(FIELD_PSSYSTESTMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestmoduleid")
    public void setPSSysTestModuleId(String pSSysTestModuleId) {
        this.set(FIELD_PSSYSTESTMODULEID, pSSysTestModuleId);
    }

    @JsonIgnore
    public boolean isPSSysTestModuleIdDirty() {
        return this.contains(FIELD_PSSYSTESTMODULEID);
    }

    @JsonIgnore
    public String getPSSysTestModuleName() {
        Object objValue = this.get(FIELD_PSSYSTESTMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestmodulename")
    public void setPSSysTestModuleName(String pSSysTestModuleName) {
        this.set(FIELD_PSSYSTESTMODULENAME, pSSysTestModuleName);
    }

    @JsonIgnore
    public boolean isPSSysTestModuleNameDirty() {
        return this.contains(FIELD_PSSYSTESTMODULENAME);
    }

    @JsonIgnore
    public String getPSSysTestPrjId() {
        Object objValue = this.get(FIELD_PSSYSTESTPRJID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestprjid")
    public void setPSSysTestPrjId(String pSSysTestPrjId) {
        this.set(FIELD_PSSYSTESTPRJID, pSSysTestPrjId);
    }

    @JsonIgnore
    public boolean isPSSysTestPrjIdDirty() {
        return this.contains(FIELD_PSSYSTESTPRJID);
    }

    @JsonIgnore
    public String getPSSysTestPrjName() {
        Object objValue = this.get(FIELD_PSSYSTESTPRJNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystestprjname")
    public void setPSSysTestPrjName(String pSSysTestPrjName) {
        this.set(FIELD_PSSYSTESTPRJNAME, pSSysTestPrjName);
    }

    @JsonIgnore
    public boolean isPSSysTestPrjNameDirty() {
        return this.contains(FIELD_PSSYSTESTPRJNAME);
    }

    @JsonIgnore
    public Integer getRollbackTran() {
        Object objValue = this.get(FIELD_ROLLBACKTRAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rollbacktran")
    public void setRollbackTran(Integer rollbackTran) {
        this.set(FIELD_ROLLBACKTRAN, rollbackTran);
    }

    @JsonIgnore
    public boolean isRollbackTranDirty() {
        return this.contains(FIELD_ROLLBACKTRAN);
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
    public String getTestCaseLevel() {
        Object objValue = this.get(FIELD_TESTCASELEVEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testcaselevel")
    public void setTestCaseLevel(String testCaseLevel) {
        this.set(FIELD_TESTCASELEVEL, testCaseLevel);
    }

    @JsonIgnore
    public boolean isTestCaseLevelDirty() {
        return this.contains(FIELD_TESTCASELEVEL);
    }

    @JsonIgnore
    public String getTestCaseSN() {
        Object objValue = this.get(FIELD_TESTCASESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testcasesn")
    public void setTestCaseSN(String testCaseSN) {
        this.set(FIELD_TESTCASESN, testCaseSN);
    }

    @JsonIgnore
    public boolean isTestCaseSNDirty() {
        return this.contains(FIELD_TESTCASESN);
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
    public String getUserData() {
        Object objValue = this.get(FIELD_USERDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata")
    public void setUserData(String userData) {
        this.set(FIELD_USERDATA, userData);
    }

    @JsonIgnore
    public boolean isUserDataDirty() {
        return this.contains(FIELD_USERDATA);
    }

    @JsonIgnore
    public String getUserData2() {
        Object objValue = this.get(FIELD_USERDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata2")
    public void setUserData2(String userData2) {
        this.set(FIELD_USERDATA2, userData2);
    }

    @JsonIgnore
    public boolean isUserData2Dirty() {
        return this.contains(FIELD_USERDATA2);
    }

    @JsonIgnore
    public String getUserData3() {
        Object objValue = this.get(FIELD_USERDATA3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata3")
    public void setUserData3(String userData3) {
        this.set(FIELD_USERDATA3, userData3);
    }

    @JsonIgnore
    public boolean isUserData3Dirty() {
        return this.contains(FIELD_USERDATA3);
    }

    @JsonIgnore
    public String getUserData4() {
        Object objValue = this.get(FIELD_USERDATA4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata4")
    public void setUserData4(String userData4) {
        this.set(FIELD_USERDATA4, userData4);
    }

    @JsonIgnore
    public boolean isUserData4Dirty() {
        return this.contains(FIELD_USERDATA4);
    }

    @JsonIgnore
    public Integer getUserFlag() {
        Object objValue = this.get(FIELD_USERFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userflag")
    public void setUserFlag(Integer userFlag) {
        this.set(FIELD_USERFLAG, userFlag);
    }

    @JsonIgnore
    public boolean isUserFlagDirty() {
        return this.contains(FIELD_USERFLAG);
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
        return this.getPSSysTestCaseId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysTestCaseId(strValue);
    }

    @JsonProperty(value="pssystcinputs")
    public List<PSSysTCInputDTO> getPssystcinputs() {
        return this.pssystcinputs;
    }

    @JsonProperty(value="pssystcinputs")
    public void setPssystcinputs(List<PSSysTCInputDTO> pssystcinputs) {
        this.pssystcinputs = pssystcinputs;
    }

    @JsonProperty(value="pssystcasserts")
    public List<PSSysTCAssertDTO> getPssystcasserts() {
        return this.pssystcasserts;
    }

    @JsonProperty(value="pssystcasserts")
    public void setPssystcasserts(List<PSSysTCAssertDTO> pssystcasserts) {
        this.pssystcasserts = pssystcasserts;
    }
}

