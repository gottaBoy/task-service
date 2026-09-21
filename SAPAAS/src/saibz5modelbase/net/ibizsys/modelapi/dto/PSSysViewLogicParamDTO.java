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
import java.math.BigDecimal;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSSysViewLogicParamDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARAMCAT = "paramcat";
    public static final String FIELD_PARAMDESC = "paramdesc";
    public static final String FIELD_PARAMKEY = "paramkey";
    public static final String FIELD_PARAMSTATE = "paramstate";
    public static final String FIELD_PARAMSUBKEY = "paramsubkey";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_PARAMVALUE = "paramvalue";
    public static final String FIELD_PARAMVALUE10 = "paramvalue10";
    public static final String FIELD_PARAMVALUE2 = "paramvalue2";
    public static final String FIELD_PARAMVALUE3 = "paramvalue3";
    public static final String FIELD_PARAMVALUE4 = "paramvalue4";
    public static final String FIELD_PARAMVALUE5 = "paramvalue5";
    public static final String FIELD_PARAMVALUE6 = "paramvalue6";
    public static final String FIELD_PARAMVALUE7 = "paramvalue7";
    public static final String FIELD_PARAMVALUE8 = "paramvalue8";
    public static final String FIELD_PARAMVALUE9 = "paramvalue9";
    public static final String FIELD_PSSYSVIEWLOGICID = "pssysviewlogicid";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "pssysviewlogicname";
    public static final String FIELD_PSSYSVIEWLOGICPARAMID = "pssysviewlogicparamid";
    public static final String FIELD_PSSYSVIEWLOGICPARAMNAME = "pssysviewlogicparamname";
    public static final String FIELD_REFOBJID = "refobjid";
    public static final String FIELD_REFOBJNAME = "refobjname";
    public static final String FIELD_REFOBJTYPE = "refobjtype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getParamCat() {
        Object objValue = this.get(FIELD_PARAMCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramcat")
    public void setParamCat(String paramCat) {
        this.set(FIELD_PARAMCAT, paramCat);
    }

    @JsonIgnore
    public boolean isParamCatDirty() {
        return this.contains(FIELD_PARAMCAT);
    }

    @JsonIgnore
    public String getParamDesc() {
        Object objValue = this.get(FIELD_PARAMDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramdesc")
    public void setParamDesc(String paramDesc) {
        this.set(FIELD_PARAMDESC, paramDesc);
    }

    @JsonIgnore
    public boolean isParamDescDirty() {
        return this.contains(FIELD_PARAMDESC);
    }

    @JsonIgnore
    public String getParamKey() {
        Object objValue = this.get(FIELD_PARAMKEY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramkey")
    public void setParamKey(String paramKey) {
        this.set(FIELD_PARAMKEY, paramKey);
    }

    @JsonIgnore
    public boolean isParamKeyDirty() {
        return this.contains(FIELD_PARAMKEY);
    }

    @JsonIgnore
    public Integer getParamState() {
        Object objValue = this.get(FIELD_PARAMSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramstate")
    public void setParamState(Integer paramState) {
        this.set(FIELD_PARAMSTATE, paramState);
    }

    @JsonIgnore
    public boolean isParamStateDirty() {
        return this.contains(FIELD_PARAMSTATE);
    }

    @JsonIgnore
    public String getParamSubKey() {
        Object objValue = this.get(FIELD_PARAMSUBKEY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramsubkey")
    public void setParamSubKey(String paramSubKey) {
        this.set(FIELD_PARAMSUBKEY, paramSubKey);
    }

    @JsonIgnore
    public boolean isParamSubKeyDirty() {
        return this.contains(FIELD_PARAMSUBKEY);
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
    public String getParamValue() {
        Object objValue = this.get(FIELD_PARAMVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramvalue")
    public void setParamValue(String paramValue) {
        this.set(FIELD_PARAMVALUE, paramValue);
    }

    @JsonIgnore
    public boolean isParamValueDirty() {
        return this.contains(FIELD_PARAMVALUE);
    }

    @JsonIgnore
    public Integer getParamValue10() {
        Object objValue = this.get(FIELD_PARAMVALUE10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramvalue10")
    public void setParamValue10(Integer paramValue10) {
        this.set(FIELD_PARAMVALUE10, paramValue10);
    }

    @JsonIgnore
    public boolean isParamValue10Dirty() {
        return this.contains(FIELD_PARAMVALUE10);
    }

    @JsonIgnore
    public String getParamValue2() {
        Object objValue = this.get(FIELD_PARAMVALUE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramvalue2")
    public void setParamValue2(String paramValue2) {
        this.set(FIELD_PARAMVALUE2, paramValue2);
    }

    @JsonIgnore
    public boolean isParamValue2Dirty() {
        return this.contains(FIELD_PARAMVALUE2);
    }

    @JsonIgnore
    public String getParamValue3() {
        Object objValue = this.get(FIELD_PARAMVALUE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramvalue3")
    public void setParamValue3(String paramValue3) {
        this.set(FIELD_PARAMVALUE3, paramValue3);
    }

    @JsonIgnore
    public boolean isParamValue3Dirty() {
        return this.contains(FIELD_PARAMVALUE3);
    }

    @JsonIgnore
    public String getParamValue4() {
        Object objValue = this.get(FIELD_PARAMVALUE4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramvalue4")
    public void setParamValue4(String paramValue4) {
        this.set(FIELD_PARAMVALUE4, paramValue4);
    }

    @JsonIgnore
    public boolean isParamValue4Dirty() {
        return this.contains(FIELD_PARAMVALUE4);
    }

    @JsonIgnore
    public Integer getParamValue5() {
        Object objValue = this.get(FIELD_PARAMVALUE5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramvalue5")
    public void setParamValue5(Integer paramValue5) {
        this.set(FIELD_PARAMVALUE5, paramValue5);
    }

    @JsonIgnore
    public boolean isParamValue5Dirty() {
        return this.contains(FIELD_PARAMVALUE5);
    }

    @JsonIgnore
    public Integer getParamValue6() {
        Object objValue = this.get(FIELD_PARAMVALUE6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramvalue6")
    public void setParamValue6(Integer paramValue6) {
        this.set(FIELD_PARAMVALUE6, paramValue6);
    }

    @JsonIgnore
    public boolean isParamValue6Dirty() {
        return this.contains(FIELD_PARAMVALUE6);
    }

    @JsonIgnore
    public BigDecimal getParamValue7() {
        Object objValue = this.get(FIELD_PARAMVALUE7);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="paramvalue7")
    public void setParamValue7(BigDecimal paramValue7) {
        this.set(FIELD_PARAMVALUE7, paramValue7);
    }

    @JsonIgnore
    public boolean isParamValue7Dirty() {
        return this.contains(FIELD_PARAMVALUE7);
    }

    @JsonIgnore
    public BigDecimal getParamValue8() {
        Object objValue = this.get(FIELD_PARAMVALUE8);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="paramvalue8")
    public void setParamValue8(BigDecimal paramValue8) {
        this.set(FIELD_PARAMVALUE8, paramValue8);
    }

    @JsonIgnore
    public boolean isParamValue8Dirty() {
        return this.contains(FIELD_PARAMVALUE8);
    }

    @JsonIgnore
    public Integer getParamValue9() {
        Object objValue = this.get(FIELD_PARAMVALUE9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramvalue9")
    public void setParamValue9(Integer paramValue9) {
        this.set(FIELD_PARAMVALUE9, paramValue9);
    }

    @JsonIgnore
    public boolean isParamValue9Dirty() {
        return this.contains(FIELD_PARAMVALUE9);
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
    public String getPSSysViewLogicParamId() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicparamid")
    public void setPSSysViewLogicParamId(String pSSysViewLogicParamId) {
        this.set(FIELD_PSSYSVIEWLOGICPARAMID, pSSysViewLogicParamId);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicParamIdDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICPARAMID);
    }

    @JsonIgnore
    public String getPSSysViewLogicParamName() {
        Object objValue = this.get(FIELD_PSSYSVIEWLOGICPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewlogicparamname")
    public void setPSSysViewLogicParamName(String pSSysViewLogicParamName) {
        this.set(FIELD_PSSYSVIEWLOGICPARAMNAME, pSSysViewLogicParamName);
    }

    @JsonIgnore
    public boolean isPSSysViewLogicParamNameDirty() {
        return this.contains(FIELD_PSSYSVIEWLOGICPARAMNAME);
    }

    @JsonIgnore
    public String getRefObjId() {
        Object objValue = this.get(FIELD_REFOBJID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refobjid")
    public void setRefObjId(String refObjId) {
        this.set(FIELD_REFOBJID, refObjId);
    }

    @JsonIgnore
    public boolean isRefObjIdDirty() {
        return this.contains(FIELD_REFOBJID);
    }

    @JsonIgnore
    public String getRefObjName() {
        Object objValue = this.get(FIELD_REFOBJNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refobjname")
    public void setRefObjName(String refObjName) {
        this.set(FIELD_REFOBJNAME, refObjName);
    }

    @JsonIgnore
    public boolean isRefObjNameDirty() {
        return this.contains(FIELD_REFOBJNAME);
    }

    @JsonIgnore
    public String getRefObjType() {
        Object objValue = this.get(FIELD_REFOBJTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refobjtype")
    public void setRefObjType(String refObjType) {
        this.set(FIELD_REFOBJTYPE, refObjType);
    }

    @JsonIgnore
    public boolean isRefObjTypeDirty() {
        return this.contains(FIELD_REFOBJTYPE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysViewLogicParamId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysViewLogicParamId(strValue);
    }
}

