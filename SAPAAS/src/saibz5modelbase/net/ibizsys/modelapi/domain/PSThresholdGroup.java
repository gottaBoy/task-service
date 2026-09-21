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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSThreshold;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSThresholdGroup
extends PSModelBase {
    public static final String FIELD_BEGINVALUEPSDEFID = "beginvaluepsdefid";
    public static final String FIELD_BEGINVALUEPSDEFNAME = "beginvaluepsdefname";
    public static final String FIELD_BKCOLORPSDEFID = "bkcolorpsdefid";
    public static final String FIELD_BKCOLORPSDEFNAME = "bkcolorpsdefname";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLORPSDEFID = "colorpsdefid";
    public static final String FIELD_COLORPSDEFNAME = "colorpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DATAPSDEFID = "datapsdefid";
    public static final String FIELD_DATAPSDEFNAME = "datapsdefname";
    public static final String FIELD_ENDVALUEPSDEFID = "endvaluepsdefid";
    public static final String FIELD_ENDVALUEPSDEFNAME = "endvaluepsdefname";
    public static final String FIELD_ICONCLSPSDEFID = "iconclspsdefid";
    public static final String FIELD_ICONCLSPSDEFNAME = "iconclspsdefname";
    public static final String FIELD_INCBEGINVALUE = "incbeginvalue";
    public static final String FIELD_INCENDVALUE = "incendvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSTHRESHOLDGROUPID = "psthresholdgroupid";
    public static final String FIELD_PSTHRESHOLDGROUPNAME = "psthresholdgroupname";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    public static final String FIELD_THRESHOLDGROUPTAG = "thresholdgrouptag";
    public static final String FIELD_THRESHOLDGROUPTAG2 = "thresholdgrouptag2";
    public static final String FIELD_THRESHOLDGROUPTYPE = "thresholdgrouptype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSThreshold> psthresholds;

    @JsonIgnore
    public String getBeginValuePSDEFId() {
        Object objValue = this.get(FIELD_BEGINVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginvaluepsdefid")
    public void setBeginValuePSDEFId(String beginValuePSDEFId) {
        this.set(FIELD_BEGINVALUEPSDEFID, beginValuePSDEFId);
    }

    @JsonIgnore
    public boolean isBeginValuePSDEFIdDirty() {
        return this.contains(FIELD_BEGINVALUEPSDEFID);
    }

    @JsonIgnore
    public String getBeginValuePSDEFName() {
        Object objValue = this.get(FIELD_BEGINVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beginvaluepsdefname")
    public void setBeginValuePSDEFName(String beginValuePSDEFName) {
        this.set(FIELD_BEGINVALUEPSDEFNAME, beginValuePSDEFName);
    }

    @JsonIgnore
    public boolean isBeginValuePSDEFNameDirty() {
        return this.contains(FIELD_BEGINVALUEPSDEFNAME);
    }

    @JsonIgnore
    public String getBKColorPSDEFId() {
        Object objValue = this.get(FIELD_BKCOLORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolorpsdefid")
    public void setBKColorPSDEFId(String bKColorPSDEFId) {
        this.set(FIELD_BKCOLORPSDEFID, bKColorPSDEFId);
    }

    @JsonIgnore
    public boolean isBKColorPSDEFIdDirty() {
        return this.contains(FIELD_BKCOLORPSDEFID);
    }

    @JsonIgnore
    public String getBKColorPSDEFName() {
        Object objValue = this.get(FIELD_BKCOLORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolorpsdefname")
    public void setBKColorPSDEFName(String bKColorPSDEFName) {
        this.set(FIELD_BKCOLORPSDEFNAME, bKColorPSDEFName);
    }

    @JsonIgnore
    public boolean isBKColorPSDEFNameDirty() {
        return this.contains(FIELD_BKCOLORPSDEFNAME);
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
    public String getColorPSDEFId() {
        Object objValue = this.get(FIELD_COLORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colorpsdefid")
    public void setColorPSDEFId(String colorPSDEFId) {
        this.set(FIELD_COLORPSDEFID, colorPSDEFId);
    }

    @JsonIgnore
    public boolean isColorPSDEFIdDirty() {
        return this.contains(FIELD_COLORPSDEFID);
    }

    @JsonIgnore
    public String getColorPSDEFName() {
        Object objValue = this.get(FIELD_COLORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colorpsdefname")
    public void setColorPSDEFName(String colorPSDEFName) {
        this.set(FIELD_COLORPSDEFNAME, colorPSDEFName);
    }

    @JsonIgnore
    public boolean isColorPSDEFNameDirty() {
        return this.contains(FIELD_COLORPSDEFNAME);
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
    public String getCustomCond() {
        Object objValue = this.get(FIELD_CUSTOMCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcond")
    public void setCustomCond(String customCond) {
        this.set(FIELD_CUSTOMCOND, customCond);
    }

    @JsonIgnore
    public boolean isCustomCondDirty() {
        return this.contains(FIELD_CUSTOMCOND);
    }

    @JsonIgnore
    public String getDataPSDEFId() {
        Object objValue = this.get(FIELD_DATAPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datapsdefid")
    public void setDataPSDEFId(String dataPSDEFId) {
        this.set(FIELD_DATAPSDEFID, dataPSDEFId);
    }

    @JsonIgnore
    public boolean isDataPSDEFIdDirty() {
        return this.contains(FIELD_DATAPSDEFID);
    }

    @JsonIgnore
    public String getDataPSDEFName() {
        Object objValue = this.get(FIELD_DATAPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datapsdefname")
    public void setDataPSDEFName(String dataPSDEFName) {
        this.set(FIELD_DATAPSDEFNAME, dataPSDEFName);
    }

    @JsonIgnore
    public boolean isDataPSDEFNameDirty() {
        return this.contains(FIELD_DATAPSDEFNAME);
    }

    @JsonIgnore
    public String getEndValuePSDEFId() {
        Object objValue = this.get(FIELD_ENDVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endvaluepsdefid")
    public void setEndValuePSDEFId(String endValuePSDEFId) {
        this.set(FIELD_ENDVALUEPSDEFID, endValuePSDEFId);
    }

    @JsonIgnore
    public boolean isEndValuePSDEFIdDirty() {
        return this.contains(FIELD_ENDVALUEPSDEFID);
    }

    @JsonIgnore
    public String getEndValuePSDEFName() {
        Object objValue = this.get(FIELD_ENDVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="endvaluepsdefname")
    public void setEndValuePSDEFName(String endValuePSDEFName) {
        this.set(FIELD_ENDVALUEPSDEFNAME, endValuePSDEFName);
    }

    @JsonIgnore
    public boolean isEndValuePSDEFNameDirty() {
        return this.contains(FIELD_ENDVALUEPSDEFNAME);
    }

    @JsonIgnore
    public String getIconClsPSDEFId() {
        Object objValue = this.get(FIELD_ICONCLSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconclspsdefid")
    public void setIconClsPSDEFId(String iconClsPSDEFId) {
        this.set(FIELD_ICONCLSPSDEFID, iconClsPSDEFId);
    }

    @JsonIgnore
    public boolean isIconClsPSDEFIdDirty() {
        return this.contains(FIELD_ICONCLSPSDEFID);
    }

    @JsonIgnore
    public String getIconClsPSDEFName() {
        Object objValue = this.get(FIELD_ICONCLSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconclspsdefname")
    public void setIconClsPSDEFName(String iconClsPSDEFName) {
        this.set(FIELD_ICONCLSPSDEFNAME, iconClsPSDEFName);
    }

    @JsonIgnore
    public boolean isIconClsPSDEFNameDirty() {
        return this.contains(FIELD_ICONCLSPSDEFNAME);
    }

    @JsonIgnore
    public Integer getIncBeginValue() {
        Object objValue = this.get(FIELD_INCBEGINVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incbeginvalue")
    public void setIncBeginValue(Integer incBeginValue) {
        this.set(FIELD_INCBEGINVALUE, incBeginValue);
    }

    @JsonIgnore
    public boolean isIncBeginValueDirty() {
        return this.contains(FIELD_INCBEGINVALUE);
    }

    @JsonIgnore
    public Integer getIncEndValue() {
        Object objValue = this.get(FIELD_INCENDVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incendvalue")
    public void setIncEndValue(Integer incEndValue) {
        this.set(FIELD_INCENDVALUE, incEndValue);
    }

    @JsonIgnore
    public boolean isIncEndValueDirty() {
        return this.contains(FIELD_INCENDVALUE);
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
    public String getPSDEDSId() {
        Object objValue = this.get(FIELD_PSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid")
    public void setPSDEDSId(String pSDEDSId) {
        this.set(FIELD_PSDEDSID, pSDEDSId);
    }

    @JsonIgnore
    public boolean isPSDEDSIdDirty() {
        return this.contains(FIELD_PSDEDSID);
    }

    @JsonIgnore
    public String getPSDEDSName() {
        Object objValue = this.get(FIELD_PSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname")
    public void setPSDEDSName(String pSDEDSName) {
        this.set(FIELD_PSDEDSNAME, pSDEDSName);
    }

    @JsonIgnore
    public boolean isPSDEDSNameDirty() {
        return this.contains(FIELD_PSDEDSNAME);
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
    public String getPSThresholdGroupId() {
        Object objValue = this.get(FIELD_PSTHRESHOLDGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psthresholdgroupid")
    public void setPSThresholdGroupId(String pSThresholdGroupId) {
        this.set(FIELD_PSTHRESHOLDGROUPID, pSThresholdGroupId);
    }

    @JsonIgnore
    public boolean isPSThresholdGroupIdDirty() {
        return this.contains(FIELD_PSTHRESHOLDGROUPID);
    }

    @JsonIgnore
    public String getPSThresholdGroupName() {
        Object objValue = this.get(FIELD_PSTHRESHOLDGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psthresholdgroupname")
    public void setPSThresholdGroupName(String pSThresholdGroupName) {
        this.set(FIELD_PSTHRESHOLDGROUPNAME, pSThresholdGroupName);
    }

    @JsonIgnore
    public boolean isPSThresholdGroupNameDirty() {
        return this.contains(FIELD_PSTHRESHOLDGROUPNAME);
    }

    @JsonIgnore
    public String getTextPSDEFId() {
        Object objValue = this.get(FIELD_TEXTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefid")
    public void setTextPSDEFId(String textPSDEFId) {
        this.set(FIELD_TEXTPSDEFID, textPSDEFId);
    }

    @JsonIgnore
    public boolean isTextPSDEFIdDirty() {
        return this.contains(FIELD_TEXTPSDEFID);
    }

    @JsonIgnore
    public String getTextPSDEFName() {
        Object objValue = this.get(FIELD_TEXTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="textpsdefname")
    public void setTextPSDEFName(String textPSDEFName) {
        this.set(FIELD_TEXTPSDEFNAME, textPSDEFName);
    }

    @JsonIgnore
    public boolean isTextPSDEFNameDirty() {
        return this.contains(FIELD_TEXTPSDEFNAME);
    }

    @JsonIgnore
    public String getThresholdGroupTag() {
        Object objValue = this.get(FIELD_THRESHOLDGROUPTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="thresholdgrouptag")
    public void setThresholdGroupTag(String thresholdGroupTag) {
        this.set(FIELD_THRESHOLDGROUPTAG, thresholdGroupTag);
    }

    @JsonIgnore
    public boolean isThresholdGroupTagDirty() {
        return this.contains(FIELD_THRESHOLDGROUPTAG);
    }

    @JsonIgnore
    public String getThresholdGroupTag2() {
        Object objValue = this.get(FIELD_THRESHOLDGROUPTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="thresholdgrouptag2")
    public void setThresholdGroupTag2(String thresholdGroupTag2) {
        this.set(FIELD_THRESHOLDGROUPTAG2, thresholdGroupTag2);
    }

    @JsonIgnore
    public boolean isThresholdGroupTag2Dirty() {
        return this.contains(FIELD_THRESHOLDGROUPTAG2);
    }

    @JsonIgnore
    public String getThresholdGroupType() {
        Object objValue = this.get(FIELD_THRESHOLDGROUPTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="thresholdgrouptype")
    public void setThresholdGroupType(String thresholdGroupType) {
        this.set(FIELD_THRESHOLDGROUPTYPE, thresholdGroupType);
    }

    @JsonIgnore
    public boolean isThresholdGroupTypeDirty() {
        return this.contains(FIELD_THRESHOLDGROUPTYPE);
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
        return this.getPSThresholdGroupId();
    }

    public void setSrfkey(String strValue) {
        this.setPSThresholdGroupId(strValue);
    }

    public List<PSThreshold> getPsthresholds() {
        return this.psthresholds;
    }

    public void setPsthresholds(List<PSThreshold> psthresholds) {
        this.psthresholds = psthresholds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psthresholds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psthresholds")) {
            this.init();
            return this.psthresholds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSTHRESHOLDGROUP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSThresholdGroup item = (PSThresholdGroup)MAPPER.readValue(new File(strJsonFilePath), PSThresholdGroup.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSThresholdGroup) {
            PSThresholdGroup dst = (PSThresholdGroup)target;
            if (!bSimple && this.getPsthresholds() != null) {
                ArrayList<PSThreshold> psthresholds = new ArrayList<PSThreshold>();
                for (PSThreshold item : this.getPsthresholds()) {
                    if (bDeepMode) {
                        PSThreshold newitem = new PSThreshold();
                        item.to(newitem, false, bDeepMode);
                        psthresholds.add(newitem);
                        continue;
                    }
                    psthresholds.add(item);
                }
                dst.setPsthresholds(psthresholds);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSThresholdGroup) {
            PSThresholdGroup src = (PSThresholdGroup)source;
            if (!bSimple && src.getPsthresholds() != null) {
                ArrayList<PSThreshold> psthresholds = new ArrayList<PSThreshold>();
                for (PSThreshold item : src.getPsthresholds()) {
                    if (bDeepMode) {
                        PSThreshold newItem = new PSThreshold();
                        newItem.from(item, false, bDeepMode);
                        psthresholds.add(newItem);
                        continue;
                    }
                    psthresholds.add(item);
                }
                this.setPsthresholds(psthresholds);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

