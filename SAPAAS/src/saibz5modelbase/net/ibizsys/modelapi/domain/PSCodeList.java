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
import net.ibizsys.modelapi.domain.PSCodeItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSCodeList
extends PSModelBase {
    public static final String FIELD_BEGINVALUEPSDEFID = "beginvaluepsdefid";
    public static final String FIELD_BEGINVALUEPSDEFNAME = "beginvaluepsdefname";
    public static final String FIELD_BKCOLORPSDEFID = "bkcolorpsdefid";
    public static final String FIELD_BKCOLORPSDEFNAME = "bkcolorpsdefname";
    public static final String FIELD_CACHECAT = "cachecat";
    public static final String FIELD_CACHETAG = "cachetag";
    public static final String FIELD_CACHETIMEOUT = "cachetimeout";
    public static final String FIELD_CLSPSDEFID = "clspsdefid";
    public static final String FIELD_CLSPSDEFNAME = "clspsdefname";
    public static final String FIELD_CLTYPE = "cltype";
    public static final String FIELD_CODELISTSN = "codelistsn";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLORPSDEFID = "colorpsdefid";
    public static final String FIELD_COLORPSDEFNAME = "colorpsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DATAPSDEFID = "datapsdefid";
    public static final String FIELD_DATAPSDEFNAME = "datapsdefname";
    public static final String FIELD_DISABLEPSDEFID = "disablepsdefid";
    public static final String FIELD_DISABLEPSDEFNAME = "disablepsdefname";
    public static final String FIELD_DSCONDITIONS = "dsconditions";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_DYNASYSREFMODE = "dynasysrefmode";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_ENABLECACHE = "enablecache";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENDVALUEPSDEFID = "endvaluepsdefid";
    public static final String FIELD_ENDVALUEPSDEFNAME = "endvaluepsdefname";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_ICONCLSPSDEFID = "iconclspsdefid";
    public static final String FIELD_ICONCLSPSDEFNAME = "iconclspsdefname";
    public static final String FIELD_ICONCLSXPSDEFID = "iconclsxpsdefid";
    public static final String FIELD_ICONCLSXPSDEFNAME = "iconclsxpsdefname";
    public static final String FIELD_ICONPATHPSDEFID = "iconpathpsdefid";
    public static final String FIELD_ICONPATHPSDEFNAME = "iconpathpsdefname";
    public static final String FIELD_ICONPATHXPSDEFID = "iconpathxpsdefid";
    public static final String FIELD_ICONPATHXPSDEFNAME = "iconpathxpsdefname";
    public static final String FIELD_INCBEGINVALUE = "incbeginvalue";
    public static final String FIELD_INCENDVALUE = "incendvalue";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_MINORSORTPSDEFID = "minorsortpsdefid";
    public static final String FIELD_MINORSORTPSDEFNAME = "minorsortpsdefname";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_NOVALUEEMPTY = "novalueempty";
    public static final String FIELD_NUMBERITEM = "numberitem";
    public static final String FIELD_ORMODE = "ormode";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSCODELISTTEMPLID = "pscodelisttemplid";
    public static final String FIELD_PSCODELISTTEMPLNAME = "pscodelisttemplname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDYNACODELISTID = "psdynacodelistid";
    public static final String FIELD_PSDYNACODELISTNAME = "psdynacodelistname";
    public static final String FIELD_PSDYNAINSTNAME = "psdynainstname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PVALUEPSDEFID = "pvaluepsdefid";
    public static final String FIELD_PVALUEPSDEFNAME = "pvaluepsdefname";
    public static final String FIELD_SEPERATOR = "seperator";
    public static final String FIELD_SYSREFFLAG = "sysrefflag";
    public static final String FIELD_TEXTPSDEFID = "textpsdefid";
    public static final String FIELD_TEXTPSDEFNAME = "textpsdefname";
    public static final String FIELD_THRESHOLDGROUPFLAG = "thresholdgroupflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERREFFLAG = "userrefflag";
    public static final String FIELD_USERSCOPE = "userscope";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VALUEPSDEFID = "valuepsdefid";
    public static final String FIELD_VALUEPSDEFNAME = "valuepsdefname";
    public static final String FIELD_VALUESEPERATOR = "valueseperator";
    private List<PSCodeItem> pscodeitems;

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
    public String getCacheCat() {
        Object objValue = this.get(FIELD_CACHECAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachecat")
    public void setCacheCat(String cacheCat) {
        this.set(FIELD_CACHECAT, cacheCat);
    }

    @JsonIgnore
    public boolean isCacheCatDirty() {
        return this.contains(FIELD_CACHECAT);
    }

    @JsonIgnore
    public String getCacheTag() {
        Object objValue = this.get(FIELD_CACHETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachetag")
    public void setCacheTag(String cacheTag) {
        this.set(FIELD_CACHETAG, cacheTag);
    }

    @JsonIgnore
    public boolean isCacheTagDirty() {
        return this.contains(FIELD_CACHETAG);
    }

    @JsonIgnore
    public Integer getCacheTimeout() {
        Object objValue = this.get(FIELD_CACHETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cachetimeout")
    public void setCacheTimeout(Integer cacheTimeout) {
        this.set(FIELD_CACHETIMEOUT, cacheTimeout);
    }

    @JsonIgnore
    public boolean isCacheTimeoutDirty() {
        return this.contains(FIELD_CACHETIMEOUT);
    }

    @JsonIgnore
    public String getClsPSDEFId() {
        Object objValue = this.get(FIELD_CLSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefid")
    public void setClsPSDEFId(String clsPSDEFId) {
        this.set(FIELD_CLSPSDEFID, clsPSDEFId);
    }

    @JsonIgnore
    public boolean isClsPSDEFIdDirty() {
        return this.contains(FIELD_CLSPSDEFID);
    }

    @JsonIgnore
    public String getClsPSDEFName() {
        Object objValue = this.get(FIELD_CLSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefname")
    public void setClsPSDEFName(String clsPSDEFName) {
        this.set(FIELD_CLSPSDEFNAME, clsPSDEFName);
    }

    @JsonIgnore
    public boolean isClsPSDEFNameDirty() {
        return this.contains(FIELD_CLSPSDEFNAME);
    }

    @JsonIgnore
    public String getCLType() {
        Object objValue = this.get(FIELD_CLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cltype")
    public void setCLType(String cLType) {
        this.set(FIELD_CLTYPE, cLType);
    }

    @JsonIgnore
    public boolean isCLTypeDirty() {
        return this.contains(FIELD_CLTYPE);
    }

    @JsonIgnore
    public String getCodeListSN() {
        Object objValue = this.get(FIELD_CODELISTSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codelistsn")
    public void setCodeListSN(String codeListSN) {
        this.set(FIELD_CODELISTSN, codeListSN);
    }

    @JsonIgnore
    public boolean isCodeListSNDirty() {
        return this.contains(FIELD_CODELISTSN);
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
    public String getDisablePSDEFId() {
        Object objValue = this.get(FIELD_DISABLEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="disablepsdefid")
    public void setDisablePSDEFId(String disablePSDEFId) {
        this.set(FIELD_DISABLEPSDEFID, disablePSDEFId);
    }

    @JsonIgnore
    public boolean isDisablePSDEFIdDirty() {
        return this.contains(FIELD_DISABLEPSDEFID);
    }

    @JsonIgnore
    public String getDisablePSDEFName() {
        Object objValue = this.get(FIELD_DISABLEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="disablepsdefname")
    public void setDisablePSDEFName(String disablePSDEFName) {
        this.set(FIELD_DISABLEPSDEFNAME, disablePSDEFName);
    }

    @JsonIgnore
    public boolean isDisablePSDEFNameDirty() {
        return this.contains(FIELD_DISABLEPSDEFNAME);
    }

    @JsonIgnore
    public String getDSConditions() {
        Object objValue = this.get(FIELD_DSCONDITIONS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dsconditions")
    public void setDSConditions(String dSConditions) {
        this.set(FIELD_DSCONDITIONS, dSConditions);
    }

    @JsonIgnore
    public boolean isDSConditionsDirty() {
        return this.contains(FIELD_DSCONDITIONS);
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
    public Integer getDynaSysRefMode() {
        Object objValue = this.get(FIELD_DYNASYSREFMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynasysrefmode")
    public void setDynaSysRefMode(Integer dynaSysRefMode) {
        this.set(FIELD_DYNASYSREFMODE, dynaSysRefMode);
    }

    @JsonIgnore
    public boolean isDynaSysRefModeDirty() {
        return this.contains(FIELD_DYNASYSREFMODE);
    }

    @JsonIgnore
    public String getEmptyText() {
        Object objValue = this.get(FIELD_EMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytext")
    public void setEmptyText(String emptyText) {
        this.set(FIELD_EMPTYTEXT, emptyText);
    }

    @JsonIgnore
    public boolean isEmptyTextDirty() {
        return this.contains(FIELD_EMPTYTEXT);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresid")
    public void setEmptyTextPSLanResId(String emptyTextPSLanResId) {
        this.set(FIELD_EMPTYTEXTPSLANRESID, emptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresname")
    public void setEmptyTextPSLanResName(String emptyTextPSLanResName) {
        this.set(FIELD_EMPTYTEXTPSLANRESNAME, emptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESNAME);
    }

    @JsonIgnore
    public Integer getEnableCache() {
        Object objValue = this.get(FIELD_ENABLECACHE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecache")
    public void setEnableCache(Integer enableCache) {
        this.set(FIELD_ENABLECACHE, enableCache);
    }

    @JsonIgnore
    public boolean isEnableCacheDirty() {
        return this.contains(FIELD_ENABLECACHE);
    }

    @JsonIgnore
    public Integer getEnableDynaSys() {
        Object objValue = this.get(FIELD_ENABLEDYNASYS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledynasys")
    public void setEnableDynaSys(Integer enableDynaSys) {
        this.set(FIELD_ENABLEDYNASYS, enableDynaSys);
    }

    @JsonIgnore
    public boolean isEnableDynaSysDirty() {
        return this.contains(FIELD_ENABLEDYNASYS);
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
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
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
    public String getIconClsXPSDEFId() {
        Object objValue = this.get(FIELD_ICONCLSXPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconclsxpsdefid")
    public void setIconClsXPSDEFId(String iconClsXPSDEFId) {
        this.set(FIELD_ICONCLSXPSDEFID, iconClsXPSDEFId);
    }

    @JsonIgnore
    public boolean isIconClsXPSDEFIdDirty() {
        return this.contains(FIELD_ICONCLSXPSDEFID);
    }

    @JsonIgnore
    public String getIconClsXPSDEFName() {
        Object objValue = this.get(FIELD_ICONCLSXPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconclsxpsdefname")
    public void setIconClsXPSDEFName(String iconClsXPSDEFName) {
        this.set(FIELD_ICONCLSXPSDEFNAME, iconClsXPSDEFName);
    }

    @JsonIgnore
    public boolean isIconClsXPSDEFNameDirty() {
        return this.contains(FIELD_ICONCLSXPSDEFNAME);
    }

    @JsonIgnore
    public String getIconPathPSDEFId() {
        Object objValue = this.get(FIELD_ICONPATHPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpathpsdefid")
    public void setIconPathPSDEFId(String iconPathPSDEFId) {
        this.set(FIELD_ICONPATHPSDEFID, iconPathPSDEFId);
    }

    @JsonIgnore
    public boolean isIconPathPSDEFIdDirty() {
        return this.contains(FIELD_ICONPATHPSDEFID);
    }

    @JsonIgnore
    public String getIconPathPSDEFName() {
        Object objValue = this.get(FIELD_ICONPATHPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpathpsdefname")
    public void setIconPathPSDEFName(String iconPathPSDEFName) {
        this.set(FIELD_ICONPATHPSDEFNAME, iconPathPSDEFName);
    }

    @JsonIgnore
    public boolean isIconPathPSDEFNameDirty() {
        return this.contains(FIELD_ICONPATHPSDEFNAME);
    }

    @JsonIgnore
    public String getIconPathXPSDEFId() {
        Object objValue = this.get(FIELD_ICONPATHXPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpathxpsdefid")
    public void setIconPathXPSDEFId(String iconPathXPSDEFId) {
        this.set(FIELD_ICONPATHXPSDEFID, iconPathXPSDEFId);
    }

    @JsonIgnore
    public boolean isIconPathXPSDEFIdDirty() {
        return this.contains(FIELD_ICONPATHXPSDEFID);
    }

    @JsonIgnore
    public String getIconPathXPSDEFName() {
        Object objValue = this.get(FIELD_ICONPATHXPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpathxpsdefname")
    public void setIconPathXPSDEFName(String iconPathXPSDEFName) {
        this.set(FIELD_ICONPATHXPSDEFNAME, iconPathXPSDEFName);
    }

    @JsonIgnore
    public boolean isIconPathXPSDEFNameDirty() {
        return this.contains(FIELD_ICONPATHXPSDEFNAME);
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
    public String getLinkPSDEViewId() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewid")
    public void setLinkPSDEViewId(String linkPSDEViewId) {
        this.set(FIELD_LINKPSDEVIEWID, linkPSDEViewId);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewIdDirty() {
        return this.contains(FIELD_LINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getLinkPSDEViewName() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewname")
    public void setLinkPSDEViewName(String linkPSDEViewName) {
        this.set(FIELD_LINKPSDEVIEWNAME, linkPSDEViewName);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewNameDirty() {
        return this.contains(FIELD_LINKPSDEVIEWNAME);
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
    public String getMinorSortDir() {
        Object objValue = this.get(FIELD_MINORSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortdir")
    public void setMinorSortDir(String minorSortDir) {
        this.set(FIELD_MINORSORTDIR, minorSortDir);
    }

    @JsonIgnore
    public boolean isMinorSortDirDirty() {
        return this.contains(FIELD_MINORSORTDIR);
    }

    @JsonIgnore
    public String getMinorSortPSDEFId() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefid")
    public void setMinorSortPSDEFId(String minorSortPSDEFId) {
        this.set(FIELD_MINORSORTPSDEFID, minorSortPSDEFId);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFIdDirty() {
        return this.contains(FIELD_MINORSORTPSDEFID);
    }

    @JsonIgnore
    public String getMinorSortPSDEFName() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefname")
    public void setMinorSortPSDEFName(String minorSortPSDEFName) {
        this.set(FIELD_MINORSORTPSDEFNAME, minorSortPSDEFName);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFNameDirty() {
        return this.contains(FIELD_MINORSORTPSDEFNAME);
    }

    @JsonIgnore
    public String getModColor() {
        Object objValue = this.get(FIELD_MODCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modcolor")
    public void setModColor(String modColor) {
        this.set(FIELD_MODCOLOR, modColor);
    }

    @JsonIgnore
    public boolean isModColorDirty() {
        return this.contains(FIELD_MODCOLOR);
    }

    @JsonIgnore
    public Integer getNoValueEmpty() {
        Object objValue = this.get(FIELD_NOVALUEEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="novalueempty")
    public void setNoValueEmpty(Integer noValueEmpty) {
        this.set(FIELD_NOVALUEEMPTY, noValueEmpty);
    }

    @JsonIgnore
    public boolean isNoValueEmptyDirty() {
        return this.contains(FIELD_NOVALUEEMPTY);
    }

    @JsonIgnore
    public Integer getNumberItem() {
        Object objValue = this.get(FIELD_NUMBERITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="numberitem")
    public void setNumberItem(Integer numberItem) {
        this.set(FIELD_NUMBERITEM, numberItem);
    }

    @JsonIgnore
    public boolean isNumberItemDirty() {
        return this.contains(FIELD_NUMBERITEM);
    }

    @JsonIgnore
    public String getOrMode() {
        Object objValue = this.get(FIELD_ORMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ormode")
    public void setOrMode(String orMode) {
        this.set(FIELD_ORMODE, orMode);
    }

    @JsonIgnore
    public boolean isOrModeDirty() {
        return this.contains(FIELD_ORMODE);
    }

    @JsonIgnore
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
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
    public String getPSCodeListTemplId() {
        Object objValue = this.get(FIELD_PSCODELISTTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelisttemplid")
    public void setPSCodeListTemplId(String pSCodeListTemplId) {
        this.set(FIELD_PSCODELISTTEMPLID, pSCodeListTemplId);
    }

    @JsonIgnore
    public boolean isPSCodeListTemplIdDirty() {
        return this.contains(FIELD_PSCODELISTTEMPLID);
    }

    @JsonIgnore
    public String getPSCodeListTemplName() {
        Object objValue = this.get(FIELD_PSCODELISTTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelisttemplname")
    public void setPSCodeListTemplName(String pSCodeListTemplName) {
        this.set(FIELD_PSCODELISTTEMPLNAME, pSCodeListTemplName);
    }

    @JsonIgnore
    public boolean isPSCodeListTemplNameDirty() {
        return this.contains(FIELD_PSCODELISTTEMPLNAME);
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
    public String getPSDynaCodeListId() {
        Object objValue = this.get(FIELD_PSDYNACODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynacodelistid")
    public void setPSDynaCodeListId(String pSDynaCodeListId) {
        this.set(FIELD_PSDYNACODELISTID, pSDynaCodeListId);
    }

    @JsonIgnore
    public boolean isPSDynaCodeListIdDirty() {
        return this.contains(FIELD_PSDYNACODELISTID);
    }

    @JsonIgnore
    public String getPSDynaCodeListName() {
        Object objValue = this.get(FIELD_PSDYNACODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynacodelistname")
    public void setPSDynaCodeListName(String pSDynaCodeListName) {
        this.set(FIELD_PSDYNACODELISTNAME, pSDynaCodeListName);
    }

    @JsonIgnore
    public boolean isPSDynaCodeListNameDirty() {
        return this.contains(FIELD_PSDYNACODELISTNAME);
    }

    @JsonIgnore
    public String getPSDynaInstName() {
        Object objValue = this.get(FIELD_PSDYNAINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynainstname")
    public void setPSDynaInstName(String pSDynaInstName) {
        this.set(FIELD_PSDYNAINSTNAME, pSDynaInstName);
    }

    @JsonIgnore
    public boolean isPSDynaInstNameDirty() {
        return this.contains(FIELD_PSDYNAINSTNAME);
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
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
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
    public String getPValuePSDEFId() {
        Object objValue = this.get(FIELD_PVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pvaluepsdefid")
    public void setPValuePSDEFId(String pValuePSDEFId) {
        this.set(FIELD_PVALUEPSDEFID, pValuePSDEFId);
    }

    @JsonIgnore
    public boolean isPValuePSDEFIdDirty() {
        return this.contains(FIELD_PVALUEPSDEFID);
    }

    @JsonIgnore
    public String getPValuePSDEFName() {
        Object objValue = this.get(FIELD_PVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pvaluepsdefname")
    public void setPValuePSDEFName(String pValuePSDEFName) {
        this.set(FIELD_PVALUEPSDEFNAME, pValuePSDEFName);
    }

    @JsonIgnore
    public boolean isPValuePSDEFNameDirty() {
        return this.contains(FIELD_PVALUEPSDEFNAME);
    }

    @JsonIgnore
    public String getSeperator() {
        Object objValue = this.get(FIELD_SEPERATOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seperator")
    public void setSeperator(String seperator) {
        this.set(FIELD_SEPERATOR, seperator);
    }

    @JsonIgnore
    public boolean isSeperatorDirty() {
        return this.contains(FIELD_SEPERATOR);
    }

    @JsonIgnore
    public Integer getSysRefFlag() {
        Object objValue = this.get(FIELD_SYSREFFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sysrefflag")
    public void setSysRefFlag(Integer sysRefFlag) {
        this.set(FIELD_SYSREFFLAG, sysRefFlag);
    }

    @JsonIgnore
    public boolean isSysRefFlagDirty() {
        return this.contains(FIELD_SYSREFFLAG);
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
    public Integer getThresholdGroupFlag() {
        Object objValue = this.get(FIELD_THRESHOLDGROUPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="thresholdgroupflag")
    public void setThresholdGroupFlag(Integer thresholdGroupFlag) {
        this.set(FIELD_THRESHOLDGROUPFLAG, thresholdGroupFlag);
    }

    @JsonIgnore
    public boolean isThresholdGroupFlagDirty() {
        return this.contains(FIELD_THRESHOLDGROUPFLAG);
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
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
    }

    @JsonIgnore
    public Integer getUserRefFlag() {
        Object objValue = this.get(FIELD_USERREFFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userrefflag")
    public void setUserRefFlag(Integer userRefFlag) {
        this.set(FIELD_USERREFFLAG, userRefFlag);
    }

    @JsonIgnore
    public boolean isUserRefFlagDirty() {
        return this.contains(FIELD_USERREFFLAG);
    }

    @JsonIgnore
    public Integer getUserScope() {
        Object objValue = this.get(FIELD_USERSCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userscope")
    public void setUserScope(Integer userScope) {
        this.set(FIELD_USERSCOPE, userScope);
    }

    @JsonIgnore
    public boolean isUserScopeDirty() {
        return this.contains(FIELD_USERSCOPE);
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
    public String getValuePSDEFId() {
        Object objValue = this.get(FIELD_VALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefid")
    public void setValuePSDEFId(String valuePSDEFId) {
        this.set(FIELD_VALUEPSDEFID, valuePSDEFId);
    }

    @JsonIgnore
    public boolean isValuePSDEFIdDirty() {
        return this.contains(FIELD_VALUEPSDEFID);
    }

    @JsonIgnore
    public String getValuePSDEFName() {
        Object objValue = this.get(FIELD_VALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valuepsdefname")
    public void setValuePSDEFName(String valuePSDEFName) {
        this.set(FIELD_VALUEPSDEFNAME, valuePSDEFName);
    }

    @JsonIgnore
    public boolean isValuePSDEFNameDirty() {
        return this.contains(FIELD_VALUEPSDEFNAME);
    }

    @JsonIgnore
    public String getValueSeperator() {
        Object objValue = this.get(FIELD_VALUESEPERATOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueseperator")
    public void setValueSeperator(String valueSeperator) {
        this.set(FIELD_VALUESEPERATOR, valueSeperator);
    }

    @JsonIgnore
    public boolean isValueSeperatorDirty() {
        return this.contains(FIELD_VALUESEPERATOR);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSCodeListId();
    }

    public void setSrfkey(String strValue) {
        this.setPSCodeListId(strValue);
    }

    public List<PSCodeItem> getPscodeitems() {
        return this.pscodeitems;
    }

    public void setPscodeitems(List<PSCodeItem> pscodeitems) {
        this.pscodeitems = pscodeitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pscodeitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pscodeitems")) {
            this.init();
            return this.pscodeitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSCODELIST";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSCodeList item = (PSCodeList)MAPPER.readValue(new File(strJsonFilePath), PSCodeList.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSCodeList) {
            PSCodeList dst = (PSCodeList)target;
            if (!bSimple && this.getPscodeitems() != null) {
                ArrayList<PSCodeItem> pscodeitems = new ArrayList<PSCodeItem>();
                for (PSCodeItem item : this.getPscodeitems()) {
                    if (bDeepMode) {
                        PSCodeItem newitem = new PSCodeItem();
                        item.to(newitem, false, bDeepMode);
                        pscodeitems.add(newitem);
                        continue;
                    }
                    pscodeitems.add(item);
                }
                dst.setPscodeitems(pscodeitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSCodeList) {
            PSCodeList src = (PSCodeList)source;
            if (!bSimple && src.getPscodeitems() != null) {
                ArrayList<PSCodeItem> pscodeitems = new ArrayList<PSCodeItem>();
                for (PSCodeItem item : src.getPscodeitems()) {
                    if (bDeepMode) {
                        PSCodeItem newItem = new PSCodeItem();
                        newItem.from(item, false, bDeepMode);
                        pscodeitems.add(newItem);
                        continue;
                    }
                    pscodeitems.add(item);
                }
                this.setPscodeitems(pscodeitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

