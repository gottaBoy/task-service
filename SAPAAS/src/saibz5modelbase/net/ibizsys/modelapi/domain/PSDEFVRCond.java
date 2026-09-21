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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEFVRCond
extends PSModelBase {
    public static final String FIELD_CONDTAG = "condtag";
    public static final String FIELD_CONDTAG2 = "condtag2";
    public static final String FIELD_CONDTYPE = "condtype";
    public static final String FIELD_CONDVALUE = "condvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDEFNAME = "customdefname";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EXTMAJORPSDEFID = "extmajorpsdefid";
    public static final String FIELD_EXTMAJORPSDEFNAME = "extmajorpsdefname";
    public static final String FIELD_EXTMINORPSDEFID = "extminorpsdefid";
    public static final String FIELD_EXTMINORPSDEFNAME = "extminorpsdefname";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_KEYCONDFLAG = "keycondflag";
    public static final String FIELD_MAJORPSDEDSID = "majorpsdedstid";
    public static final String FIELD_MAJORPSDEDSNAME = "majorpsdedstname";
    public static final String FIELD_MAJORPSDEID = "majorpsdeid";
    public static final String FIELD_MAJORPSDENAME = "majorpsdename";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAM = "param";
    public static final String FIELD_PARAM10 = "param10";
    public static final String FIELD_PARAM2 = "param2";
    public static final String FIELD_PARAM3 = "param3";
    public static final String FIELD_PARAM4 = "param4";
    public static final String FIELD_PARAM5 = "param5";
    public static final String FIELD_PARAM6 = "param6";
    public static final String FIELD_PARAM7 = "param7";
    public static final String FIELD_PARAM8 = "param8";
    public static final String FIELD_PARAM9 = "param9";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_PPSDEFVRCONDID = "ppsdefvrcondid";
    public static final String FIELD_PPSDEFVRCONDNAME = "ppsdefvrcondname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEFVRCONDID = "psdefvrcondid";
    public static final String FIELD_PSDEFVRCONDNAME = "psdefvrcondname";
    public static final String FIELD_PSDEFVRID = "psdefvrid";
    public static final String FIELD_PSDEFVRNAME = "psdefvrname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_RIPSLANRESID = "ripslanresid";
    public static final String FIELD_RIPSLANRESNAME = "ripslanresname";
    public static final String FIELD_RULEINFO = "ruleinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    private List<PSDEFVRCond> psdefvrconds;

    @JsonIgnore
    public String getCondTag() {
        Object objValue = this.get(FIELD_CONDTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condtag")
    public void setCondTag(String condTag) {
        this.set(FIELD_CONDTAG, condTag);
    }

    @JsonIgnore
    public boolean isCondTagDirty() {
        return this.contains(FIELD_CONDTAG);
    }

    @JsonIgnore
    public String getCondTag2() {
        Object objValue = this.get(FIELD_CONDTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condtag2")
    public void setCondTag2(String condTag2) {
        this.set(FIELD_CONDTAG2, condTag2);
    }

    @JsonIgnore
    public boolean isCondTag2Dirty() {
        return this.contains(FIELD_CONDTAG2);
    }

    @JsonIgnore
    public String getCondType() {
        Object objValue = this.get(FIELD_CONDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condtype")
    public void setCondType(String condType) {
        this.set(FIELD_CONDTYPE, condType);
    }

    @JsonIgnore
    public boolean isCondTypeDirty() {
        return this.contains(FIELD_CONDTYPE);
    }

    @JsonIgnore
    public String getCondValue() {
        Object objValue = this.get(FIELD_CONDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condvalue")
    public void setCondValue(String condValue) {
        this.set(FIELD_CONDVALUE, condValue);
    }

    @JsonIgnore
    public boolean isCondValueDirty() {
        return this.contains(FIELD_CONDVALUE);
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
    public String getCustomDEFName() {
        Object objValue = this.get(FIELD_CUSTOMDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customdefname")
    public void setCustomDEFName(String customDEFName) {
        this.set(FIELD_CUSTOMDEFNAME, customDEFName);
    }

    @JsonIgnore
    public boolean isCustomDEFNameDirty() {
        return this.contains(FIELD_CUSTOMDEFNAME);
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
    public String getExtMajorPSDEFId() {
        Object objValue = this.get(FIELD_EXTMAJORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extmajorpsdefid")
    public void setExtMajorPSDEFId(String extMajorPSDEFId) {
        this.set(FIELD_EXTMAJORPSDEFID, extMajorPSDEFId);
    }

    @JsonIgnore
    public boolean isExtMajorPSDEFIdDirty() {
        return this.contains(FIELD_EXTMAJORPSDEFID);
    }

    @JsonIgnore
    public String getExtMajorPSDEFName() {
        Object objValue = this.get(FIELD_EXTMAJORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extmajorpsdefname")
    public void setExtMajorPSDEFName(String extMajorPSDEFName) {
        this.set(FIELD_EXTMAJORPSDEFNAME, extMajorPSDEFName);
    }

    @JsonIgnore
    public boolean isExtMajorPSDEFNameDirty() {
        return this.contains(FIELD_EXTMAJORPSDEFNAME);
    }

    @JsonIgnore
    public String getExtMinorPSDEFId() {
        Object objValue = this.get(FIELD_EXTMINORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extminorpsdefid")
    public void setExtMinorPSDEFId(String extMinorPSDEFId) {
        this.set(FIELD_EXTMINORPSDEFID, extMinorPSDEFId);
    }

    @JsonIgnore
    public boolean isExtMinorPSDEFIdDirty() {
        return this.contains(FIELD_EXTMINORPSDEFID);
    }

    @JsonIgnore
    public String getExtMinorPSDEFName() {
        Object objValue = this.get(FIELD_EXTMINORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extminorpsdefname")
    public void setExtMinorPSDEFName(String extMinorPSDEFName) {
        this.set(FIELD_EXTMINORPSDEFNAME, extMinorPSDEFName);
    }

    @JsonIgnore
    public boolean isExtMinorPSDEFNameDirty() {
        return this.contains(FIELD_EXTMINORPSDEFNAME);
    }

    @JsonIgnore
    public Integer getGroupNotFlag() {
        Object objValue = this.get(FIELD_GROUPNOTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupnotflag")
    public void setGroupNotFlag(Integer groupNotFlag) {
        this.set(FIELD_GROUPNOTFLAG, groupNotFlag);
    }

    @JsonIgnore
    public boolean isGroupNotFlagDirty() {
        return this.contains(FIELD_GROUPNOTFLAG);
    }

    @JsonIgnore
    public String getGroupOP() {
        Object objValue = this.get(FIELD_GROUPOP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupop")
    public void setGroupOP(String groupOP) {
        this.set(FIELD_GROUPOP, groupOP);
    }

    @JsonIgnore
    public boolean isGroupOPDirty() {
        return this.contains(FIELD_GROUPOP);
    }

    @JsonIgnore
    public Integer getKeyCondFlag() {
        Object objValue = this.get(FIELD_KEYCONDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="keycondflag")
    public void setKeyCondFlag(Integer keyCondFlag) {
        this.set(FIELD_KEYCONDFLAG, keyCondFlag);
    }

    @JsonIgnore
    public boolean isKeyCondFlagDirty() {
        return this.contains(FIELD_KEYCONDFLAG);
    }

    @JsonIgnore
    public String getMajorPSDEDSId() {
        Object objValue = this.get(FIELD_MAJORPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdedstid")
    public void setMajorPSDEDSId(String majorPSDEDSId) {
        this.set(FIELD_MAJORPSDEDSID, majorPSDEDSId);
    }

    @JsonIgnore
    public boolean isMajorPSDEDSIdDirty() {
        return this.contains(FIELD_MAJORPSDEDSID);
    }

    @JsonIgnore
    public String getMajorPSDEDSName() {
        Object objValue = this.get(FIELD_MAJORPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdedstname")
    public void setMajorPSDEDSName(String majorPSDEDSName) {
        this.set(FIELD_MAJORPSDEDSNAME, majorPSDEDSName);
    }

    @JsonIgnore
    public boolean isMajorPSDEDSNameDirty() {
        return this.contains(FIELD_MAJORPSDEDSNAME);
    }

    @JsonIgnore
    public String getMajorPSDEId() {
        Object objValue = this.get(FIELD_MAJORPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdeid")
    public void setMajorPSDEId(String majorPSDEId) {
        this.set(FIELD_MAJORPSDEID, majorPSDEId);
    }

    @JsonIgnore
    public boolean isMajorPSDEIdDirty() {
        return this.contains(FIELD_MAJORPSDEID);
    }

    @JsonIgnore
    public String getMajorPSDEName() {
        Object objValue = this.get(FIELD_MAJORPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdename")
    public void setMajorPSDEName(String majorPSDEName) {
        this.set(FIELD_MAJORPSDENAME, majorPSDEName);
    }

    @JsonIgnore
    public boolean isMajorPSDENameDirty() {
        return this.contains(FIELD_MAJORPSDENAME);
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
    public String getParam() {
        Object objValue = this.get(FIELD_PARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param")
    public void setParam(String param) {
        this.set(FIELD_PARAM, param);
    }

    @JsonIgnore
    public boolean isParamDirty() {
        return this.contains(FIELD_PARAM);
    }

    @JsonIgnore
    public Integer getParam10() {
        Object objValue = this.get(FIELD_PARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param10")
    public void setParam10(Integer param10) {
        this.set(FIELD_PARAM10, param10);
    }

    @JsonIgnore
    public boolean isParam10Dirty() {
        return this.contains(FIELD_PARAM10);
    }

    @JsonIgnore
    public String getParam2() {
        Object objValue = this.get(FIELD_PARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param2")
    public void setParam2(String param2) {
        this.set(FIELD_PARAM2, param2);
    }

    @JsonIgnore
    public boolean isParam2Dirty() {
        return this.contains(FIELD_PARAM2);
    }

    @JsonIgnore
    public Integer getParam3() {
        Object objValue = this.get(FIELD_PARAM3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param3")
    public void setParam3(Integer param3) {
        this.set(FIELD_PARAM3, param3);
    }

    @JsonIgnore
    public boolean isParam3Dirty() {
        return this.contains(FIELD_PARAM3);
    }

    @JsonIgnore
    public Integer getParam4() {
        Object objValue = this.get(FIELD_PARAM4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param4")
    public void setParam4(Integer param4) {
        this.set(FIELD_PARAM4, param4);
    }

    @JsonIgnore
    public boolean isParam4Dirty() {
        return this.contains(FIELD_PARAM4);
    }

    @JsonIgnore
    public Integer getParam5() {
        Object objValue = this.get(FIELD_PARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param5")
    public void setParam5(Integer param5) {
        this.set(FIELD_PARAM5, param5);
    }

    @JsonIgnore
    public boolean isParam5Dirty() {
        return this.contains(FIELD_PARAM5);
    }

    @JsonIgnore
    public Integer getParam6() {
        Object objValue = this.get(FIELD_PARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param6")
    public void setParam6(Integer param6) {
        this.set(FIELD_PARAM6, param6);
    }

    @JsonIgnore
    public boolean isParam6Dirty() {
        return this.contains(FIELD_PARAM6);
    }

    @JsonIgnore
    public BigDecimal getParam7() {
        Object objValue = this.get(FIELD_PARAM7);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="param7")
    public void setParam7(BigDecimal param7) {
        this.set(FIELD_PARAM7, param7);
    }

    @JsonIgnore
    public boolean isParam7Dirty() {
        return this.contains(FIELD_PARAM7);
    }

    @JsonIgnore
    public BigDecimal getParam8() {
        Object objValue = this.get(FIELD_PARAM8);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="param8")
    public void setParam8(BigDecimal param8) {
        this.set(FIELD_PARAM8, param8);
    }

    @JsonIgnore
    public boolean isParam8Dirty() {
        return this.contains(FIELD_PARAM8);
    }

    @JsonIgnore
    public Integer getParam9() {
        Object objValue = this.get(FIELD_PARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param9")
    public void setParam9(Integer param9) {
        this.set(FIELD_PARAM9, param9);
    }

    @JsonIgnore
    public boolean isParam9Dirty() {
        return this.contains(FIELD_PARAM9);
    }

    @JsonIgnore
    public String getParamType() {
        Object objValue = this.get(FIELD_PARAMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtype")
    public void setParamType(String paramType) {
        this.set(FIELD_PARAMTYPE, paramType);
    }

    @JsonIgnore
    public boolean isParamTypeDirty() {
        return this.contains(FIELD_PARAMTYPE);
    }

    @JsonIgnore
    public String getPPSDEFVRCondId() {
        Object objValue = this.get(FIELD_PPSDEFVRCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdefvrcondid")
    public void setPPSDEFVRCondId(String pPSDEFVRCondId) {
        this.set(FIELD_PPSDEFVRCONDID, pPSDEFVRCondId);
    }

    @JsonIgnore
    public boolean isPPSDEFVRCondIdDirty() {
        return this.contains(FIELD_PPSDEFVRCONDID);
    }

    @JsonIgnore
    public String getPPSDEFVRCondName() {
        Object objValue = this.get(FIELD_PPSDEFVRCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdefvrcondname")
    public void setPPSDEFVRCondName(String pPSDEFVRCondName) {
        this.set(FIELD_PPSDEFVRCONDNAME, pPSDEFVRCondName);
    }

    @JsonIgnore
    public boolean isPPSDEFVRCondNameDirty() {
        return this.contains(FIELD_PPSDEFVRCONDNAME);
    }

    @JsonIgnore
    public String getPSDBValueOPId() {
        Object objValue = this.get(FIELD_PSDBVALUEOPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopid")
    public void setPSDBValueOPId(String pSDBValueOPId) {
        this.set(FIELD_PSDBVALUEOPID, pSDBValueOPId);
    }

    @JsonIgnore
    public boolean isPSDBValueOPIdDirty() {
        return this.contains(FIELD_PSDBVALUEOPID);
    }

    @JsonIgnore
    public String getPSDBValueOPName() {
        Object objValue = this.get(FIELD_PSDBVALUEOPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopname")
    public void setPSDBValueOPName(String pSDBValueOPName) {
        this.set(FIELD_PSDBVALUEOPNAME, pSDBValueOPName);
    }

    @JsonIgnore
    public boolean isPSDBValueOPNameDirty() {
        return this.contains(FIELD_PSDBVALUEOPNAME);
    }

    @JsonIgnore
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
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
    public String getPSDEFVRCondId() {
        Object objValue = this.get(FIELD_PSDEFVRCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrcondid")
    public void setPSDEFVRCondId(String pSDEFVRCondId) {
        this.set(FIELD_PSDEFVRCONDID, pSDEFVRCondId);
    }

    @JsonIgnore
    public boolean isPSDEFVRCondIdDirty() {
        return this.contains(FIELD_PSDEFVRCONDID);
    }

    @JsonIgnore
    public String getPSDEFVRCondName() {
        Object objValue = this.get(FIELD_PSDEFVRCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrcondname")
    public void setPSDEFVRCondName(String pSDEFVRCondName) {
        this.set(FIELD_PSDEFVRCONDNAME, pSDEFVRCondName);
    }

    @JsonIgnore
    public boolean isPSDEFVRCondNameDirty() {
        return this.contains(FIELD_PSDEFVRCONDNAME);
    }

    @JsonIgnore
    public String getPSDEFVRId() {
        Object objValue = this.get(FIELD_PSDEFVRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrid")
    public void setPSDEFVRId(String pSDEFVRId) {
        this.set(FIELD_PSDEFVRID, pSDEFVRId);
    }

    @JsonIgnore
    public boolean isPSDEFVRIdDirty() {
        return this.contains(FIELD_PSDEFVRID);
    }

    @JsonIgnore
    public String getPSDEFVRName() {
        Object objValue = this.get(FIELD_PSDEFVRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvrname")
    public void setPSDEFVRName(String pSDEFVRName) {
        this.set(FIELD_PSDEFVRNAME, pSDEFVRName);
    }

    @JsonIgnore
    public boolean isPSDEFVRNameDirty() {
        return this.contains(FIELD_PSDEFVRNAME);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
    }

    @JsonIgnore
    public String getRIPSLanResId() {
        Object objValue = this.get(FIELD_RIPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ripslanresid")
    public void setRIPSLanResId(String rIPSLanResId) {
        this.set(FIELD_RIPSLANRESID, rIPSLanResId);
    }

    @JsonIgnore
    public boolean isRIPSLanResIdDirty() {
        return this.contains(FIELD_RIPSLANRESID);
    }

    @JsonIgnore
    public String getRIPSLanResName() {
        Object objValue = this.get(FIELD_RIPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ripslanresname")
    public void setRIPSLanResName(String rIPSLanResName) {
        this.set(FIELD_RIPSLANRESNAME, rIPSLanResName);
    }

    @JsonIgnore
    public boolean isRIPSLanResNameDirty() {
        return this.contains(FIELD_RIPSLANRESNAME);
    }

    @JsonIgnore
    public String getRuleInfo() {
        Object objValue = this.get(FIELD_RULEINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ruleinfo")
    public void setRuleInfo(String ruleInfo) {
        this.set(FIELD_RULEINFO, ruleInfo);
    }

    @JsonIgnore
    public boolean isRuleInfoDirty() {
        return this.contains(FIELD_RULEINFO);
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
    public String getSrfkey() {
        return this.getPSDEFVRCondId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFVRCondId(strValue);
    }

    public List<PSDEFVRCond> getPsdefvrconds() {
        return this.psdefvrconds;
    }

    public void setPsdefvrconds(List<PSDEFVRCond> psdefvrconds) {
        this.psdefvrconds = psdefvrconds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdefvrconds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdefvrconds")) {
            this.init();
            return this.psdefvrconds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEFVRCOND";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFVRCond item = (PSDEFVRCond)MAPPER.readValue(new File(strJsonFilePath), PSDEFVRCond.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFVRCond) {
            PSDEFVRCond dst = (PSDEFVRCond)target;
            if (!bSimple && this.getPsdefvrconds() != null) {
                ArrayList<PSDEFVRCond> psdefvrconds = new ArrayList<PSDEFVRCond>();
                for (PSDEFVRCond item : this.getPsdefvrconds()) {
                    if (bDeepMode) {
                        PSDEFVRCond newitem = new PSDEFVRCond();
                        item.to(newitem, false, bDeepMode);
                        psdefvrconds.add(newitem);
                        continue;
                    }
                    psdefvrconds.add(item);
                }
                dst.setPsdefvrconds(psdefvrconds);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFVRCond) {
            PSDEFVRCond src = (PSDEFVRCond)source;
            if (!bSimple && src.getPsdefvrconds() != null) {
                ArrayList<PSDEFVRCond> psdefvrconds = new ArrayList<PSDEFVRCond>();
                for (PSDEFVRCond item : src.getPsdefvrconds()) {
                    if (bDeepMode) {
                        PSDEFVRCond newItem = new PSDEFVRCond();
                        newItem.from(item, false, bDeepMode);
                        psdefvrconds.add(newItem);
                        continue;
                    }
                    psdefvrconds.add(item);
                }
                this.setPsdefvrconds(psdefvrconds);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

