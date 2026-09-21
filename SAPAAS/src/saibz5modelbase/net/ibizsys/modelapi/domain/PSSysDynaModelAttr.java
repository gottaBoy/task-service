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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysDynaModelAttr
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_ARRAYFLAG = "arrayflag";
    public static final String FIELD_ATTRTAG = "attrtag";
    public static final String FIELD_ATTRTAG2 = "attrtag2";
    public static final String FIELD_ATTRVALUE = "attrvalue";
    public static final String FIELD_ATTRVALUE10 = "attrvalue10";
    public static final String FIELD_ATTRVALUE11 = "attrvalue11";
    public static final String FIELD_ATTRVALUE12 = "attrvalue12";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_ATTRVALUE13 = "attrvalue13";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_ATTRVALUE14 = "attrvalue14";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_ATTRVALUE15 = "attrvalue15";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_ATTRVALUE16 = "attrvalue16";
    public static final String FIELD_ATTRVALUE2 = "attrvalue2";
    public static final String FIELD_ATTRVALUE20 = "attrvalue20";
    public static final String FIELD_ATTRVALUE21 = "attrvalue21";
    public static final String FIELD_ATTRVALUE22 = "attrvalue22";
    public static final String FIELD_ATTRVALUE23 = "attrvalue23";
    public static final String FIELD_ATTRVALUE24 = "attrvalue24";
    public static final String FIELD_ATTRVALUE25 = "attrvalue25";
    public static final String FIELD_ATTRVALUE26 = "attrvalue26";
    public static final String FIELD_ATTRVALUE27 = "attrvalue27";
    public static final String FIELD_ATTRVALUE28 = "attrvalue28";
    public static final String FIELD_ATTRVALUE29 = "attrvalue29";
    public static final String FIELD_ATTRVALUE3 = "attrvalue3";
    public static final String FIELD_ATTRVALUE30 = "attrvalue30";
    public static final String FIELD_ATTRVALUE4 = "attrvalue4";
    public static final String FIELD_ATTRVALUE5 = "attrvalue5";
    public static final String FIELD_ATTRVALUE6 = "attrvalue6";
    public static final String FIELD_ATTRVALUE7 = "attrvalue7";
    public static final String FIELD_ATTRVALUE8 = "attrvalue8";
    public static final String FIELD_ATTRVALUE9 = "attrvalue9";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELUSAGE = "dynamodelusage";
    public static final String FIELD_JSONFORMAT = "jsonformat";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSSYSDYNAMODELATTRID = "pssysdynamodelattrid";
    public static final String FIELD_PSSYSDYNAMODELATTRNAME = "pssysdynamodelattrname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_REFPSDEFGROUPID = "refpsdefgroupid";
    public static final String FIELD_REFPSDEFGROUPNAME = "refpsdefgroupname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSSYSDYNAMODELID = "refpssysdynamodelid";
    public static final String FIELD_REFPSSYSDYNAMODELNAME = "refpssysdynamodelname";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUETYPE = "valuetype";

    @JsonIgnore
    public Integer getAllowEmpty() {
        Object objValue = this.get(FIELD_ALLOWEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowempty")
    public void setAllowEmpty(Integer allowEmpty) {
        this.set(FIELD_ALLOWEMPTY, allowEmpty);
    }

    @JsonIgnore
    public boolean isAllowEmptyDirty() {
        return this.contains(FIELD_ALLOWEMPTY);
    }

    @JsonIgnore
    public Integer getArrayFlag() {
        Object objValue = this.get(FIELD_ARRAYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="arrayflag")
    public void setArrayFlag(Integer arrayFlag) {
        this.set(FIELD_ARRAYFLAG, arrayFlag);
    }

    @JsonIgnore
    public boolean isArrayFlagDirty() {
        return this.contains(FIELD_ARRAYFLAG);
    }

    @JsonIgnore
    public String getAttrTag() {
        Object objValue = this.get(FIELD_ATTRTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrtag")
    public void setAttrTag(String attrTag) {
        this.set(FIELD_ATTRTAG, attrTag);
    }

    @JsonIgnore
    public boolean isAttrTagDirty() {
        return this.contains(FIELD_ATTRTAG);
    }

    @JsonIgnore
    public String getAttrTag2() {
        Object objValue = this.get(FIELD_ATTRTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrtag2")
    public void setAttrTag2(String attrTag2) {
        this.set(FIELD_ATTRTAG2, attrTag2);
    }

    @JsonIgnore
    public boolean isAttrTag2Dirty() {
        return this.contains(FIELD_ATTRTAG2);
    }

    @JsonIgnore
    public String getAttrValue() {
        Object objValue = this.get(FIELD_ATTRVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue")
    public void setAttrValue(String attrValue) {
        this.set(FIELD_ATTRVALUE, attrValue);
    }

    @JsonIgnore
    public boolean isAttrValueDirty() {
        return this.contains(FIELD_ATTRVALUE);
    }

    @JsonIgnore
    public BigDecimal getAttrValue10() {
        Object objValue = this.get(FIELD_ATTRVALUE10);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="attrvalue10")
    public void setAttrValue10(BigDecimal attrValue10) {
        this.set(FIELD_ATTRVALUE10, attrValue10);
    }

    @JsonIgnore
    public boolean isAttrValue10Dirty() {
        return this.contains(FIELD_ATTRVALUE10);
    }

    @JsonIgnore
    public BigDecimal getAttrValue11() {
        Object objValue = this.get(FIELD_ATTRVALUE11);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="attrvalue11")
    public void setAttrValue11(BigDecimal attrValue11) {
        this.set(FIELD_ATTRVALUE11, attrValue11);
    }

    @JsonIgnore
    public boolean isAttrValue11Dirty() {
        return this.contains(FIELD_ATTRVALUE11);
    }

    @JsonIgnore
    public BigDecimal getAttrValue12() {
        Object objValue = this.get(FIELD_ATTRVALUE12);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="attrvalue12")
    public void setAttrValue12(BigDecimal attrValue12) {
        this.set(FIELD_ATTRVALUE12, attrValue12);
    }

    @JsonIgnore
    public boolean isAttrValue12Dirty() {
        return this.contains(FIELD_ATTRVALUE12);
    }

    @JsonIgnore
    public Timestamp getAttrValue13() {
        Object objValue = this.get(FIELD_ATTRVALUE13);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="attrvalue13")
    public void setAttrValue13(Timestamp attrValue13) {
        this.set(FIELD_ATTRVALUE13, attrValue13);
    }

    @JsonIgnore
    public boolean isAttrValue13Dirty() {
        return this.contains(FIELD_ATTRVALUE13);
    }

    @JsonIgnore
    public Timestamp getAttrValue14() {
        Object objValue = this.get(FIELD_ATTRVALUE14);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="attrvalue14")
    public void setAttrValue14(Timestamp attrValue14) {
        this.set(FIELD_ATTRVALUE14, attrValue14);
    }

    @JsonIgnore
    public boolean isAttrValue14Dirty() {
        return this.contains(FIELD_ATTRVALUE14);
    }

    @JsonIgnore
    public Timestamp getAttrValue15() {
        Object objValue = this.get(FIELD_ATTRVALUE15);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="attrvalue15")
    public void setAttrValue15(Timestamp attrValue15) {
        this.set(FIELD_ATTRVALUE15, attrValue15);
    }

    @JsonIgnore
    public boolean isAttrValue15Dirty() {
        return this.contains(FIELD_ATTRVALUE15);
    }

    @JsonIgnore
    public Timestamp getAttrValue16() {
        Object objValue = this.get(FIELD_ATTRVALUE16);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="attrvalue16")
    public void setAttrValue16(Timestamp attrValue16) {
        this.set(FIELD_ATTRVALUE16, attrValue16);
    }

    @JsonIgnore
    public boolean isAttrValue16Dirty() {
        return this.contains(FIELD_ATTRVALUE16);
    }

    @JsonIgnore
    public String getAttrValue2() {
        Object objValue = this.get(FIELD_ATTRVALUE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue2")
    public void setAttrValue2(String attrValue2) {
        this.set(FIELD_ATTRVALUE2, attrValue2);
    }

    @JsonIgnore
    public boolean isAttrValue2Dirty() {
        return this.contains(FIELD_ATTRVALUE2);
    }

    @JsonIgnore
    public String getAttrValue20() {
        Object objValue = this.get(FIELD_ATTRVALUE20);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue20")
    public void setAttrValue20(String attrValue20) {
        this.set(FIELD_ATTRVALUE20, attrValue20);
    }

    @JsonIgnore
    public boolean isAttrValue20Dirty() {
        return this.contains(FIELD_ATTRVALUE20);
    }

    @JsonIgnore
    public String getAttrValue21() {
        Object objValue = this.get(FIELD_ATTRVALUE21);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue21")
    public void setAttrValue21(String attrValue21) {
        this.set(FIELD_ATTRVALUE21, attrValue21);
    }

    @JsonIgnore
    public boolean isAttrValue21Dirty() {
        return this.contains(FIELD_ATTRVALUE21);
    }

    @JsonIgnore
    public String getAttrValue22() {
        Object objValue = this.get(FIELD_ATTRVALUE22);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue22")
    public void setAttrValue22(String attrValue22) {
        this.set(FIELD_ATTRVALUE22, attrValue22);
    }

    @JsonIgnore
    public boolean isAttrValue22Dirty() {
        return this.contains(FIELD_ATTRVALUE22);
    }

    @JsonIgnore
    public String getAttrValue23() {
        Object objValue = this.get(FIELD_ATTRVALUE23);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue23")
    public void setAttrValue23(String attrValue23) {
        this.set(FIELD_ATTRVALUE23, attrValue23);
    }

    @JsonIgnore
    public boolean isAttrValue23Dirty() {
        return this.contains(FIELD_ATTRVALUE23);
    }

    @JsonIgnore
    public String getAttrValue24() {
        Object objValue = this.get(FIELD_ATTRVALUE24);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue24")
    public void setAttrValue24(String attrValue24) {
        this.set(FIELD_ATTRVALUE24, attrValue24);
    }

    @JsonIgnore
    public boolean isAttrValue24Dirty() {
        return this.contains(FIELD_ATTRVALUE24);
    }

    @JsonIgnore
    public String getAttrValue25() {
        Object objValue = this.get(FIELD_ATTRVALUE25);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue25")
    public void setAttrValue25(String attrValue25) {
        this.set(FIELD_ATTRVALUE25, attrValue25);
    }

    @JsonIgnore
    public boolean isAttrValue25Dirty() {
        return this.contains(FIELD_ATTRVALUE25);
    }

    @JsonIgnore
    public String getAttrValue26() {
        Object objValue = this.get(FIELD_ATTRVALUE26);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue26")
    public void setAttrValue26(String attrValue26) {
        this.set(FIELD_ATTRVALUE26, attrValue26);
    }

    @JsonIgnore
    public boolean isAttrValue26Dirty() {
        return this.contains(FIELD_ATTRVALUE26);
    }

    @JsonIgnore
    public String getAttrValue27() {
        Object objValue = this.get(FIELD_ATTRVALUE27);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue27")
    public void setAttrValue27(String attrValue27) {
        this.set(FIELD_ATTRVALUE27, attrValue27);
    }

    @JsonIgnore
    public boolean isAttrValue27Dirty() {
        return this.contains(FIELD_ATTRVALUE27);
    }

    @JsonIgnore
    public String getAttrValue28() {
        Object objValue = this.get(FIELD_ATTRVALUE28);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue28")
    public void setAttrValue28(String attrValue28) {
        this.set(FIELD_ATTRVALUE28, attrValue28);
    }

    @JsonIgnore
    public boolean isAttrValue28Dirty() {
        return this.contains(FIELD_ATTRVALUE28);
    }

    @JsonIgnore
    public String getAttrValue29() {
        Object objValue = this.get(FIELD_ATTRVALUE29);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue29")
    public void setAttrValue29(String attrValue29) {
        this.set(FIELD_ATTRVALUE29, attrValue29);
    }

    @JsonIgnore
    public boolean isAttrValue29Dirty() {
        return this.contains(FIELD_ATTRVALUE29);
    }

    @JsonIgnore
    public String getAttrValue3() {
        Object objValue = this.get(FIELD_ATTRVALUE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue3")
    public void setAttrValue3(String attrValue3) {
        this.set(FIELD_ATTRVALUE3, attrValue3);
    }

    @JsonIgnore
    public boolean isAttrValue3Dirty() {
        return this.contains(FIELD_ATTRVALUE3);
    }

    @JsonIgnore
    public String getAttrValue30() {
        Object objValue = this.get(FIELD_ATTRVALUE30);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue30")
    public void setAttrValue30(String attrValue30) {
        this.set(FIELD_ATTRVALUE30, attrValue30);
    }

    @JsonIgnore
    public boolean isAttrValue30Dirty() {
        return this.contains(FIELD_ATTRVALUE30);
    }

    @JsonIgnore
    public String getAttrValue4() {
        Object objValue = this.get(FIELD_ATTRVALUE4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attrvalue4")
    public void setAttrValue4(String attrValue4) {
        this.set(FIELD_ATTRVALUE4, attrValue4);
    }

    @JsonIgnore
    public boolean isAttrValue4Dirty() {
        return this.contains(FIELD_ATTRVALUE4);
    }

    @JsonIgnore
    public Integer getAttrValue5() {
        Object objValue = this.get(FIELD_ATTRVALUE5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="attrvalue5")
    public void setAttrValue5(Integer attrValue5) {
        this.set(FIELD_ATTRVALUE5, attrValue5);
    }

    @JsonIgnore
    public boolean isAttrValue5Dirty() {
        return this.contains(FIELD_ATTRVALUE5);
    }

    @JsonIgnore
    public Integer getAttrValue6() {
        Object objValue = this.get(FIELD_ATTRVALUE6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="attrvalue6")
    public void setAttrValue6(Integer attrValue6) {
        this.set(FIELD_ATTRVALUE6, attrValue6);
    }

    @JsonIgnore
    public boolean isAttrValue6Dirty() {
        return this.contains(FIELD_ATTRVALUE6);
    }

    @JsonIgnore
    public Integer getAttrValue7() {
        Object objValue = this.get(FIELD_ATTRVALUE7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="attrvalue7")
    public void setAttrValue7(Integer attrValue7) {
        this.set(FIELD_ATTRVALUE7, attrValue7);
    }

    @JsonIgnore
    public boolean isAttrValue7Dirty() {
        return this.contains(FIELD_ATTRVALUE7);
    }

    @JsonIgnore
    public Integer getAttrValue8() {
        Object objValue = this.get(FIELD_ATTRVALUE8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="attrvalue8")
    public void setAttrValue8(Integer attrValue8) {
        this.set(FIELD_ATTRVALUE8, attrValue8);
    }

    @JsonIgnore
    public boolean isAttrValue8Dirty() {
        return this.contains(FIELD_ATTRVALUE8);
    }

    @JsonIgnore
    public BigDecimal getAttrValue9() {
        Object objValue = this.get(FIELD_ATTRVALUE9);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="attrvalue9")
    public void setAttrValue9(BigDecimal attrValue9) {
        this.set(FIELD_ATTRVALUE9, attrValue9);
    }

    @JsonIgnore
    public boolean isAttrValue9Dirty() {
        return this.contains(FIELD_ATTRVALUE9);
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
    public String getDynaModelUsage() {
        Object objValue = this.get(FIELD_DYNAMODELUSAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodelusage")
    public void setDynaModelUsage(String dynaModelUsage) {
        this.set(FIELD_DYNAMODELUSAGE, dynaModelUsage);
    }

    @JsonIgnore
    public boolean isDynaModelUsageDirty() {
        return this.contains(FIELD_DYNAMODELUSAGE);
    }

    @JsonIgnore
    public String getJsonFormat() {
        Object objValue = this.get(FIELD_JSONFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsonformat")
    public void setJsonFormat(String jsonFormat) {
        this.set(FIELD_JSONFORMAT, jsonFormat);
    }

    @JsonIgnore
    public boolean isJsonFormatDirty() {
        return this.contains(FIELD_JSONFORMAT);
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
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelAttrId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELATTRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelattrid")
    public void setPSSysDynaModelAttrId(String pSSysDynaModelAttrId) {
        this.set(FIELD_PSSYSDYNAMODELATTRID, pSSysDynaModelAttrId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelAttrIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELATTRID);
    }

    @JsonIgnore
    public String getPSSysDynaModelAttrName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELATTRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelattrname")
    public void setPSSysDynaModelAttrName(String pSSysDynaModelAttrName) {
        this.set(FIELD_PSSYSDYNAMODELATTRNAME, pSSysDynaModelAttrName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelAttrNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELATTRNAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
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
    public String getRefPSDEFGroupId() {
        Object objValue = this.get(FIELD_REFPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdefgroupid")
    public void setRefPSDEFGroupId(String refPSDEFGroupId) {
        this.set(FIELD_REFPSDEFGROUPID, refPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isRefPSDEFGroupIdDirty() {
        return this.contains(FIELD_REFPSDEFGROUPID);
    }

    @JsonIgnore
    public String getRefPSDEFGroupName() {
        Object objValue = this.get(FIELD_REFPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdefgroupname")
    public void setRefPSDEFGroupName(String refPSDEFGroupName) {
        this.set(FIELD_REFPSDEFGROUPNAME, refPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isRefPSDEFGroupNameDirty() {
        return this.contains(FIELD_REFPSDEFGROUPNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelId() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelid")
    public void setRefPSSysDynaModelId(String refPSSysDynaModelId) {
        this.set(FIELD_REFPSSYSDYNAMODELID, refPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelIdDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getRefPSSysDynaModelName() {
        Object objValue = this.get(FIELD_REFPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpssysdynamodelname")
    public void setRefPSSysDynaModelName(String refPSSysDynaModelName) {
        this.set(FIELD_REFPSSYSDYNAMODELNAME, refPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isRefPSSysDynaModelNameDirty() {
        return this.contains(FIELD_REFPSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public Integer getStdDataType() {
        Object objValue = this.get(FIELD_STDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stddatatype")
    public void setStdDataType(Integer stdDataType) {
        this.set(FIELD_STDDATATYPE, stdDataType);
    }

    @JsonIgnore
    public boolean isStdDataTypeDirty() {
        return this.contains(FIELD_STDDATATYPE);
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
    public String getValueType() {
        Object objValue = this.get(FIELD_VALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuetype")
    public void setValueType(String valueType) {
        this.set(FIELD_VALUETYPE, valueType);
    }

    @JsonIgnore
    public boolean isValueTypeDirty() {
        return this.contains(FIELD_VALUETYPE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysDynaModelAttrId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDynaModelAttrId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDYNAMODELATTR";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDynaModelAttr item = (PSSysDynaModelAttr)MAPPER.readValue(new File(strJsonFilePath), PSSysDynaModelAttr.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDynaModelAttr) {
            PSSysDynaModelAttr pSSysDynaModelAttr = (PSSysDynaModelAttr)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDynaModelAttr) {
            PSSysDynaModelAttr pSSysDynaModelAttr = (PSSysDynaModelAttr)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

