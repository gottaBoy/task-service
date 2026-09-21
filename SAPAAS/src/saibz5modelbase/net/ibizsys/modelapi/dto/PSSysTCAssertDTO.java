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

public class PSSysTCAssertDTO
extends PSModelDTOBase {
    public static final String FIELD_ASSERTRESULT = "assertresult";
    public static final String FIELD_ASSERTTAG = "asserttag";
    public static final String FIELD_ASSERTTAG2 = "asserttag2";
    public static final String FIELD_ASSERTTAG3 = "asserttag3";
    public static final String FIELD_ASSERTTAG4 = "asserttag4";
    public static final String FIELD_ASSERTTYPE = "asserttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DSTKEYPSDEFID = "dstkeypsdefid";
    public static final String FIELD_DSTKEYPSDEFNAME = "dstkeypsdefname";
    public static final String FIELD_DSTPSDEID = "dstpsdeid";
    public static final String FIELD_DSTPSDENAME = "dstpsdename";
    public static final String FIELD_EXCEPTIONDATA = "exceptiondata";
    public static final String FIELD_EXCEPTIONDATA2 = "exceptiondata2";
    public static final String FIELD_EXCEPTIONNAME = "exceptionname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSTCASSERTID = "pssystcassertid";
    public static final String FIELD_PSSYSTCASSERTNAME = "pssystcassertname";
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
    public String getAssertTag() {
        Object objValue = this.get(FIELD_ASSERTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="asserttag")
    public void setAssertTag(String assertTag) {
        this.set(FIELD_ASSERTTAG, assertTag);
    }

    @JsonIgnore
    public boolean isAssertTagDirty() {
        return this.contains(FIELD_ASSERTTAG);
    }

    @JsonIgnore
    public String getAssertTag2() {
        Object objValue = this.get(FIELD_ASSERTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="asserttag2")
    public void setAssertTag2(String assertTag2) {
        this.set(FIELD_ASSERTTAG2, assertTag2);
    }

    @JsonIgnore
    public boolean isAssertTag2Dirty() {
        return this.contains(FIELD_ASSERTTAG2);
    }

    @JsonIgnore
    public String getAssertTag3() {
        Object objValue = this.get(FIELD_ASSERTTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="asserttag3")
    public void setAssertTag3(String assertTag3) {
        this.set(FIELD_ASSERTTAG3, assertTag3);
    }

    @JsonIgnore
    public boolean isAssertTag3Dirty() {
        return this.contains(FIELD_ASSERTTAG3);
    }

    @JsonIgnore
    public String getAssertTag4() {
        Object objValue = this.get(FIELD_ASSERTTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="asserttag4")
    public void setAssertTag4(String assertTag4) {
        this.set(FIELD_ASSERTTAG4, assertTag4);
    }

    @JsonIgnore
    public boolean isAssertTag4Dirty() {
        return this.contains(FIELD_ASSERTTAG4);
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
    public String getDstKeyPSDEFId() {
        Object objValue = this.get(FIELD_DSTKEYPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstkeypsdefid")
    public void setDstKeyPSDEFId(String dstKeyPSDEFId) {
        this.set(FIELD_DSTKEYPSDEFID, dstKeyPSDEFId);
    }

    @JsonIgnore
    public boolean isDstKeyPSDEFIdDirty() {
        return this.contains(FIELD_DSTKEYPSDEFID);
    }

    @JsonIgnore
    public String getDstKeyPSDEFName() {
        Object objValue = this.get(FIELD_DSTKEYPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstkeypsdefname")
    public void setDstKeyPSDEFName(String dstKeyPSDEFName) {
        this.set(FIELD_DSTKEYPSDEFNAME, dstKeyPSDEFName);
    }

    @JsonIgnore
    public boolean isDstKeyPSDEFNameDirty() {
        return this.contains(FIELD_DSTKEYPSDEFNAME);
    }

    @JsonIgnore
    public String getDstPSDEId() {
        Object objValue = this.get(FIELD_DSTPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeid")
    public void setDstPSDEId(String dstPSDEId) {
        this.set(FIELD_DSTPSDEID, dstPSDEId);
    }

    @JsonIgnore
    public boolean isDstPSDEIdDirty() {
        return this.contains(FIELD_DSTPSDEID);
    }

    @JsonIgnore
    public String getDstPSDEName() {
        Object objValue = this.get(FIELD_DSTPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdename")
    public void setDstPSDEName(String dstPSDEName) {
        this.set(FIELD_DSTPSDENAME, dstPSDEName);
    }

    @JsonIgnore
    public boolean isDstPSDENameDirty() {
        return this.contains(FIELD_DSTPSDENAME);
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
    public String getPSSysTCAssertId() {
        Object objValue = this.get(FIELD_PSSYSTCASSERTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystcassertid")
    public void setPSSysTCAssertId(String pSSysTCAssertId) {
        this.set(FIELD_PSSYSTCASSERTID, pSSysTCAssertId);
    }

    @JsonIgnore
    public boolean isPSSysTCAssertIdDirty() {
        return this.contains(FIELD_PSSYSTCASSERTID);
    }

    @JsonIgnore
    public String getPSSysTCAssertName() {
        Object objValue = this.get(FIELD_PSSYSTCASSERTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystcassertname")
    public void setPSSysTCAssertName(String pSSysTCAssertName) {
        this.set(FIELD_PSSYSTCASSERTNAME, pSSysTCAssertName);
    }

    @JsonIgnore
    public boolean isPSSysTCAssertNameDirty() {
        return this.contains(FIELD_PSSYSTCASSERTNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysTCAssertId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysTCAssertId(strValue);
    }
}

