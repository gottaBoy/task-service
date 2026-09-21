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

public class PSSysSFPITemplDTO
extends PSModelDTOBase {
    public static final String FIELD_CODEMAP = "codemap";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSSFID = "pssfid";
    public static final String FIELD_PSSFNAME = "pssfname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSFPITEMPLID = "pssyssfpitemplid";
    public static final String FIELD_PSSYSSFPITEMPLNAME = "pssyssfpitemplname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_TEMPLCODE = "templcode";
    public static final String FIELD_TEMPLCODE2 = "templcode2";
    public static final String FIELD_TEMPLCODE2EX = "templcode2ex";
    public static final String FIELD_TEMPLCODE3 = "templcode3";
    public static final String FIELD_TEMPLCODE4 = "templcode4";
    public static final String FIELD_TEMPLCODE5 = "templcode5";
    public static final String FIELD_TEMPLCODE6 = "templcode6";
    public static final String FIELD_TEMPLCODEEX = "templcodeex";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

    @JsonIgnore
    public String getCodeMap() {
        Object objValue = this.get(FIELD_CODEMAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codemap")
    public void setCodeMap(String codeMap) {
        this.set(FIELD_CODEMAP, codeMap);
    }

    @JsonIgnore
    public boolean isCodeMapDirty() {
        return this.contains(FIELD_CODEMAP);
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
    public String getPSSFId() {
        Object objValue = this.get(FIELD_PSSFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfid")
    public void setPSSFId(String pSSFId) {
        this.set(FIELD_PSSFID, pSSFId);
    }

    @JsonIgnore
    public boolean isPSSFIdDirty() {
        return this.contains(FIELD_PSSFID);
    }

    @JsonIgnore
    public String getPSSFName() {
        Object objValue = this.get(FIELD_PSSFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfname")
    public void setPSSFName(String pSSFName) {
        this.set(FIELD_PSSFNAME, pSSFName);
    }

    @JsonIgnore
    public boolean isPSSFNameDirty() {
        return this.contains(FIELD_PSSFNAME);
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
    public String getPSSysSFPITemplId() {
        Object objValue = this.get(FIELD_PSSYSSFPITEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpitemplid")
    public void setPSSysSFPITemplId(String pSSysSFPITemplId) {
        this.set(FIELD_PSSYSSFPITEMPLID, pSSysSFPITemplId);
    }

    @JsonIgnore
    public boolean isPSSysSFPITemplIdDirty() {
        return this.contains(FIELD_PSSYSSFPITEMPLID);
    }

    @JsonIgnore
    public String getPSSysSFPITemplName() {
        Object objValue = this.get(FIELD_PSSYSSFPITEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpitemplname")
    public void setPSSysSFPITemplName(String pSSysSFPITemplName) {
        this.set(FIELD_PSSYSSFPITEMPLNAME, pSSysSFPITemplName);
    }

    @JsonIgnore
    public boolean isPSSysSFPITemplNameDirty() {
        return this.contains(FIELD_PSSYSSFPITEMPLNAME);
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
    public String getTemplCode() {
        Object objValue = this.get(FIELD_TEMPLCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode")
    public void setTemplCode(String templCode) {
        this.set(FIELD_TEMPLCODE, templCode);
    }

    @JsonIgnore
    public boolean isTemplCodeDirty() {
        return this.contains(FIELD_TEMPLCODE);
    }

    @JsonIgnore
    public String getTemplCode2() {
        Object objValue = this.get(FIELD_TEMPLCODE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode2")
    public void setTemplCode2(String templCode2) {
        this.set(FIELD_TEMPLCODE2, templCode2);
    }

    @JsonIgnore
    public boolean isTemplCode2Dirty() {
        return this.contains(FIELD_TEMPLCODE2);
    }

    @JsonIgnore
    public String getTemplCode2Ex() {
        Object objValue = this.get(FIELD_TEMPLCODE2EX);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode2ex")
    public void setTemplCode2Ex(String templCode2Ex) {
        this.set(FIELD_TEMPLCODE2EX, templCode2Ex);
    }

    @JsonIgnore
    public boolean isTemplCode2ExDirty() {
        return this.contains(FIELD_TEMPLCODE2EX);
    }

    @JsonIgnore
    public String getTemplCode3() {
        Object objValue = this.get(FIELD_TEMPLCODE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode3")
    public void setTemplCode3(String templCode3) {
        this.set(FIELD_TEMPLCODE3, templCode3);
    }

    @JsonIgnore
    public boolean isTemplCode3Dirty() {
        return this.contains(FIELD_TEMPLCODE3);
    }

    @JsonIgnore
    public String getTemplCode4() {
        Object objValue = this.get(FIELD_TEMPLCODE4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode4")
    public void setTemplCode4(String templCode4) {
        this.set(FIELD_TEMPLCODE4, templCode4);
    }

    @JsonIgnore
    public boolean isTemplCode4Dirty() {
        return this.contains(FIELD_TEMPLCODE4);
    }

    @JsonIgnore
    public String getTemplCode5() {
        Object objValue = this.get(FIELD_TEMPLCODE5);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode5")
    public void setTemplCode5(String templCode5) {
        this.set(FIELD_TEMPLCODE5, templCode5);
    }

    @JsonIgnore
    public boolean isTemplCode5Dirty() {
        return this.contains(FIELD_TEMPLCODE5);
    }

    @JsonIgnore
    public String getTemplCode6() {
        Object objValue = this.get(FIELD_TEMPLCODE6);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcode6")
    public void setTemplCode6(String templCode6) {
        this.set(FIELD_TEMPLCODE6, templCode6);
    }

    @JsonIgnore
    public boolean isTemplCode6Dirty() {
        return this.contains(FIELD_TEMPLCODE6);
    }

    @JsonIgnore
    public String getTemplCodeEx() {
        Object objValue = this.get(FIELD_TEMPLCODEEX);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templcodeex")
    public void setTemplCodeEx(String templCodeEx) {
        this.set(FIELD_TEMPLCODEEX, templCodeEx);
    }

    @JsonIgnore
    public boolean isTemplCodeExDirty() {
        return this.contains(FIELD_TEMPLCODEEX);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysSFPITemplId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysSFPITemplId(strValue);
    }
}

