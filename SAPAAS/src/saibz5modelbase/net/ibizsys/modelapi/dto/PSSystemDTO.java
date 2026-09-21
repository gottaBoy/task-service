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

public class PSSystemDTO
extends PSModelDTOBase {
    public static final String FIELD_ACCCTRLARCH = "accctrlarch";
    public static final String FIELD_AUTOCALCDERER = "autocalcderer";
    public static final String FIELD_BUGFIXS = "bugfixs";
    public static final String FIELD_CHECKMODELVER = "checkmodelver";
    public static final String FIELD_CLEMPTYTEXT = "clemptytext";
    public static final String FIELD_CLEMPTYTEXTPSLANRESID = "clemptytextpslanresid";
    public static final String FIELD_CLEMPTYTEXTPSLANRESNAME = "clemptytextpslanresname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLAPPENDDEITEMS = "ctrlappenddeitems";
    public static final String FIELD_DBTYPES = "dbtypes";
    public static final String FIELD_DEEXPMAXROWCNT = "deexpmaxrowcnt";
    public static final String FIELD_DEFPSSYSDEPLOYID = "defpssysdeployid";
    public static final String FIELD_DEFSFITEMWIDTH = "defsfitemwidth";
    public static final String FIELD_DEFSORTMODE = "defsortmode";
    public static final String FIELD_DEMSACTIONLOGICFLAG = "demsactionlogicflag";
    public static final String FIELD_DOMAINNAME = "domainname";
    public static final String FIELD_DTOFORMAT = "dtoformat";
    public static final String FIELD_ENABLEDBVALUEMODE = "enabledbvaluemode";
    public static final String FIELD_ENABLEDEDATAVER = "enablededataver";
    public static final String FIELD_ENABLEDEFRESTRICTEDUI = "enabledefrestrictedui";
    public static final String FIELD_ENABLEDERFKEY = "enablederfkey";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEMULTILAN = "enablemultilan";
    public static final String FIELD_ENABLEOPNAMEMODEL = "enableopnamemodel";
    public static final String FIELD_ENADEFLANRESCONTENT = "enadeflanrescontent";
    public static final String FIELD_EXTRACTDEFAULT = "extractdefault";
    public static final String FIELD_INITDEDEFAULT = "initdedefault";
    public static final String FIELD_LANRESMAXTAG = "lanresmaxtag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELV2EXPMODE = "modelv2expmode";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_PIAUTOSHOWCAPTION = "piautoshowcaption";
    public static final String FIELD_PSLANGUAGEID = "pslanguageid";
    public static final String FIELD_PSLANGUAGENAME = "pslanguagename";
    public static final String FIELD_PSSFID = "pssfid";
    public static final String FIELD_PSSFNAME = "pssfname";
    public static final String FIELD_PSSYSENGINECFGID = "pssysenginecfgid";
    public static final String FIELD_PSSYSENGINECFGNAME = "pssysenginecfgname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUBDBMODELFLAG = "pubdbmodelflag";
    public static final String FIELD_SAASMODE = "saasmode";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SIMACTIONLOGICS = "simactionlogics";
    public static final String FIELD_SRCPSSYSTEMID = "srcpssystemid";
    public static final String FIELD_SRCPSSYSTEMNAME = "srcpssystemname";
    public static final String FIELD_SSDEMSACTIONLOGICFLAG = "ssdemsactionlogicflag";
    public static final String FIELD_SYSFOLDER = "sysfolder";
    public static final String FIELD_SYSROWKEY = "sysrowkey";
    public static final String FIELD_SYSTYPE = "systype";
    public static final String FIELD_SYSVER = "sysver";
    public static final String FIELD_TEMPLENGINE = "templengine";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_VIEWUAREGMODE = "viewuaregmode";

    @JsonIgnore
    public Integer getAccCtrlArch() {
        Object objValue = this.get(FIELD_ACCCTRLARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="accctrlarch")
    public void setAccCtrlArch(Integer accCtrlArch) {
        this.set(FIELD_ACCCTRLARCH, accCtrlArch);
    }

    @JsonIgnore
    public boolean isAccCtrlArchDirty() {
        return this.contains(FIELD_ACCCTRLARCH);
    }

    @JsonIgnore
    public Integer getAutoCalcDERER() {
        Object objValue = this.get(FIELD_AUTOCALCDERER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="autocalcderer")
    public void setAutoCalcDERER(Integer autoCalcDERER) {
        this.set(FIELD_AUTOCALCDERER, autoCalcDERER);
    }

    @JsonIgnore
    public boolean isAutoCalcDERERDirty() {
        return this.contains(FIELD_AUTOCALCDERER);
    }

    @JsonIgnore
    public Integer getBugFixs() {
        Object objValue = this.get(FIELD_BUGFIXS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bugfixs")
    public void setBugFixs(Integer bugFixs) {
        this.set(FIELD_BUGFIXS, bugFixs);
    }

    @JsonIgnore
    public boolean isBugFixsDirty() {
        return this.contains(FIELD_BUGFIXS);
    }

    @JsonIgnore
    public Integer getCheckModelVer() {
        Object objValue = this.get(FIELD_CHECKMODELVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="checkmodelver")
    public void setCheckModelVer(Integer checkModelVer) {
        this.set(FIELD_CHECKMODELVER, checkModelVer);
    }

    @JsonIgnore
    public boolean isCheckModelVerDirty() {
        return this.contains(FIELD_CHECKMODELVER);
    }

    @JsonIgnore
    public String getCLEmptyText() {
        Object objValue = this.get(FIELD_CLEMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytext")
    public void setCLEmptyText(String cLEmptyText) {
        this.set(FIELD_CLEMPTYTEXT, cLEmptyText);
    }

    @JsonIgnore
    public boolean isCLEmptyTextDirty() {
        return this.contains(FIELD_CLEMPTYTEXT);
    }

    @JsonIgnore
    public String getCLEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_CLEMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytextpslanresid")
    public void setCLEmptyTextPSLanResId(String cLEmptyTextPSLanResId) {
        this.set(FIELD_CLEMPTYTEXTPSLANRESID, cLEmptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isCLEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_CLEMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getCLEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_CLEMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clemptytextpslanresname")
    public void setCLEmptyTextPSLanResName(String cLEmptyTextPSLanResName) {
        this.set(FIELD_CLEMPTYTEXTPSLANRESNAME, cLEmptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isCLEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_CLEMPTYTEXTPSLANRESNAME);
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
    public Integer getCtrlAppendDEItems() {
        Object objValue = this.get(FIELD_CTRLAPPENDDEITEMS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlappenddeitems")
    public void setCtrlAppendDEItems(Integer ctrlAppendDEItems) {
        this.set(FIELD_CTRLAPPENDDEITEMS, ctrlAppendDEItems);
    }

    @JsonIgnore
    public boolean isCtrlAppendDEItemsDirty() {
        return this.contains(FIELD_CTRLAPPENDDEITEMS);
    }

    @JsonIgnore
    public String getDBTypes() {
        Object objValue = this.get(FIELD_DBTYPES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtypes")
    public void setDBTypes(String dBTypes) {
        this.set(FIELD_DBTYPES, dBTypes);
    }

    @JsonIgnore
    public boolean isDBTypesDirty() {
        return this.contains(FIELD_DBTYPES);
    }

    @JsonIgnore
    public Integer getDEExpMaxRowCnt() {
        Object objValue = this.get(FIELD_DEEXPMAXROWCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deexpmaxrowcnt")
    public void setDEExpMaxRowCnt(Integer dEExpMaxRowCnt) {
        this.set(FIELD_DEEXPMAXROWCNT, dEExpMaxRowCnt);
    }

    @JsonIgnore
    public boolean isDEExpMaxRowCntDirty() {
        return this.contains(FIELD_DEEXPMAXROWCNT);
    }

    @JsonIgnore
    public String getDEFPSSysDeployId() {
        Object objValue = this.get(FIELD_DEFPSSYSDEPLOYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpssysdeployid")
    public void setDEFPSSysDeployId(String dEFPSSysDeployId) {
        this.set(FIELD_DEFPSSYSDEPLOYID, dEFPSSysDeployId);
    }

    @JsonIgnore
    public boolean isDEFPSSysDeployIdDirty() {
        return this.contains(FIELD_DEFPSSYSDEPLOYID);
    }

    @JsonIgnore
    public Integer getDEFSFItemWidth() {
        Object objValue = this.get(FIELD_DEFSFITEMWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defsfitemwidth")
    public void setDEFSFItemWidth(Integer dEFSFItemWidth) {
        this.set(FIELD_DEFSFITEMWIDTH, dEFSFItemWidth);
    }

    @JsonIgnore
    public boolean isDEFSFItemWidthDirty() {
        return this.contains(FIELD_DEFSFITEMWIDTH);
    }

    @JsonIgnore
    public String getDEFSortMode() {
        Object objValue = this.get(FIELD_DEFSORTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defsortmode")
    public void setDEFSortMode(String dEFSortMode) {
        this.set(FIELD_DEFSORTMODE, dEFSortMode);
    }

    @JsonIgnore
    public boolean isDEFSortModeDirty() {
        return this.contains(FIELD_DEFSORTMODE);
    }

    @JsonIgnore
    public Integer getDEMSActionLogicFlag() {
        Object objValue = this.get(FIELD_DEMSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="demsactionlogicflag")
    public void setDEMSActionLogicFlag(Integer dEMSActionLogicFlag) {
        this.set(FIELD_DEMSACTIONLOGICFLAG, dEMSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isDEMSActionLogicFlagDirty() {
        return this.contains(FIELD_DEMSACTIONLOGICFLAG);
    }

    @JsonIgnore
    public String getDomainName() {
        Object objValue = this.get(FIELD_DOMAINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="domainname")
    public void setDomainName(String domainName) {
        this.set(FIELD_DOMAINNAME, domainName);
    }

    @JsonIgnore
    public boolean isDomainNameDirty() {
        return this.contains(FIELD_DOMAINNAME);
    }

    @JsonIgnore
    public String getDTOFormat() {
        Object objValue = this.get(FIELD_DTOFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dtoformat")
    public void setDTOFormat(String dTOFormat) {
        this.set(FIELD_DTOFORMAT, dTOFormat);
    }

    @JsonIgnore
    public boolean isDTOFormatDirty() {
        return this.contains(FIELD_DTOFORMAT);
    }

    @JsonIgnore
    public Integer getEnableDBValueMode() {
        Object objValue = this.get(FIELD_ENABLEDBVALUEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledbvaluemode")
    public void setEnableDBValueMode(Integer enableDBValueMode) {
        this.set(FIELD_ENABLEDBVALUEMODE, enableDBValueMode);
    }

    @JsonIgnore
    public boolean isEnableDBValueModeDirty() {
        return this.contains(FIELD_ENABLEDBVALUEMODE);
    }

    @JsonIgnore
    public Integer getEnableDEDataVer() {
        Object objValue = this.get(FIELD_ENABLEDEDATAVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablededataver")
    public void setEnableDEDataVer(Integer enableDEDataVer) {
        this.set(FIELD_ENABLEDEDATAVER, enableDEDataVer);
    }

    @JsonIgnore
    public boolean isEnableDEDataVerDirty() {
        return this.contains(FIELD_ENABLEDEDATAVER);
    }

    @JsonIgnore
    public Integer getEnableDEFRestrictedUI() {
        Object objValue = this.get(FIELD_ENABLEDEFRESTRICTEDUI);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledefrestrictedui")
    public void setEnableDEFRestrictedUI(Integer enableDEFRestrictedUI) {
        this.set(FIELD_ENABLEDEFRESTRICTEDUI, enableDEFRestrictedUI);
    }

    @JsonIgnore
    public boolean isEnableDEFRestrictedUIDirty() {
        return this.contains(FIELD_ENABLEDEFRESTRICTEDUI);
    }

    @JsonIgnore
    public Integer getEnableDERFKey() {
        Object objValue = this.get(FIELD_ENABLEDERFKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablederfkey")
    public void setEnableDERFKey(Integer enableDERFKey) {
        this.set(FIELD_ENABLEDERFKEY, enableDERFKey);
    }

    @JsonIgnore
    public boolean isEnableDERFKeyDirty() {
        return this.contains(FIELD_ENABLEDERFKEY);
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
    public Integer getEnableMultiLan() {
        Object objValue = this.get(FIELD_ENABLEMULTILAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemultilan")
    public void setEnableMultiLan(Integer enableMultiLan) {
        this.set(FIELD_ENABLEMULTILAN, enableMultiLan);
    }

    @JsonIgnore
    public boolean isEnableMultiLanDirty() {
        return this.contains(FIELD_ENABLEMULTILAN);
    }

    @JsonIgnore
    public Integer getEnableOPNameModel() {
        Object objValue = this.get(FIELD_ENABLEOPNAMEMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableopnamemodel")
    public void setEnableOPNameModel(Integer enableOPNameModel) {
        this.set(FIELD_ENABLEOPNAMEMODEL, enableOPNameModel);
    }

    @JsonIgnore
    public boolean isEnableOPNameModelDirty() {
        return this.contains(FIELD_ENABLEOPNAMEMODEL);
    }

    @JsonIgnore
    public Integer getEnaDefLanResContent() {
        Object objValue = this.get(FIELD_ENADEFLANRESCONTENT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enadeflanrescontent")
    public void setEnaDefLanResContent(Integer enaDefLanResContent) {
        this.set(FIELD_ENADEFLANRESCONTENT, enaDefLanResContent);
    }

    @JsonIgnore
    public boolean isEnaDefLanResContentDirty() {
        return this.contains(FIELD_ENADEFLANRESCONTENT);
    }

    @JsonIgnore
    public Integer getExtractDefault() {
        Object objValue = this.get(FIELD_EXTRACTDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extractdefault")
    public void setExtractDefault(Integer extractDefault) {
        this.set(FIELD_EXTRACTDEFAULT, extractDefault);
    }

    @JsonIgnore
    public boolean isExtractDefaultDirty() {
        return this.contains(FIELD_EXTRACTDEFAULT);
    }

    @JsonIgnore
    public Integer getInitDEDefault() {
        Object objValue = this.get(FIELD_INITDEDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="initdedefault")
    public void setInitDEDefault(Integer initDEDefault) {
        this.set(FIELD_INITDEDEFAULT, initDEDefault);
    }

    @JsonIgnore
    public boolean isInitDEDefaultDirty() {
        return this.contains(FIELD_INITDEDEFAULT);
    }

    @JsonIgnore
    public Integer getLanResMaxTag() {
        Object objValue = this.get(FIELD_LANRESMAXTAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lanresmaxtag")
    public void setLanResMaxTag(Integer lanResMaxTag) {
        this.set(FIELD_LANRESMAXTAG, lanResMaxTag);
    }

    @JsonIgnore
    public boolean isLanResMaxTagDirty() {
        return this.contains(FIELD_LANRESMAXTAG);
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
    public Integer getModelV2ExpMode() {
        Object objValue = this.get(FIELD_MODELV2EXPMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelv2expmode")
    public void setModelV2ExpMode(Integer modelV2ExpMode) {
        this.set(FIELD_MODELV2EXPMODE, modelV2ExpMode);
    }

    @JsonIgnore
    public boolean isModelV2ExpModeDirty() {
        return this.contains(FIELD_MODELV2EXPMODE);
    }

    @JsonIgnore
    public Integer getNoViewMode() {
        Object objValue = this.get(FIELD_NOVIEWMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noviewmode")
    public void setNoViewMode(Integer noViewMode) {
        this.set(FIELD_NOVIEWMODE, noViewMode);
    }

    @JsonIgnore
    public boolean isNoViewModeDirty() {
        return this.contains(FIELD_NOVIEWMODE);
    }

    @JsonIgnore
    public Integer getPIAutoShowCaption() {
        Object objValue = this.get(FIELD_PIAUTOSHOWCAPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="piautoshowcaption")
    public void setPIAutoShowCaption(Integer pIAutoShowCaption) {
        this.set(FIELD_PIAUTOSHOWCAPTION, pIAutoShowCaption);
    }

    @JsonIgnore
    public boolean isPIAutoShowCaptionDirty() {
        return this.contains(FIELD_PIAUTOSHOWCAPTION);
    }

    @JsonIgnore
    public String getPSLanguageId() {
        Object objValue = this.get(FIELD_PSLANGUAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguageid")
    public void setPSLanguageId(String pSLanguageId) {
        this.set(FIELD_PSLANGUAGEID, pSLanguageId);
    }

    @JsonIgnore
    public boolean isPSLanguageIdDirty() {
        return this.contains(FIELD_PSLANGUAGEID);
    }

    @JsonIgnore
    public String getPSLanguageName() {
        Object objValue = this.get(FIELD_PSLANGUAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pslanguagename")
    public void setPSLanguageName(String pSLanguageName) {
        this.set(FIELD_PSLANGUAGENAME, pSLanguageName);
    }

    @JsonIgnore
    public boolean isPSLanguageNameDirty() {
        return this.contains(FIELD_PSLANGUAGENAME);
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
    public String getPSSysEngineCfgId() {
        Object objValue = this.get(FIELD_PSSYSENGINECFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysenginecfgid")
    public void setPSSysEngineCfgId(String pSSysEngineCfgId) {
        this.set(FIELD_PSSYSENGINECFGID, pSSysEngineCfgId);
    }

    @JsonIgnore
    public boolean isPSSysEngineCfgIdDirty() {
        return this.contains(FIELD_PSSYSENGINECFGID);
    }

    @JsonIgnore
    public String getPSSysEngineCfgName() {
        Object objValue = this.get(FIELD_PSSYSENGINECFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysenginecfgname")
    public void setPSSysEngineCfgName(String pSSysEngineCfgName) {
        this.set(FIELD_PSSYSENGINECFGNAME, pSSysEngineCfgName);
    }

    @JsonIgnore
    public boolean isPSSysEngineCfgNameDirty() {
        return this.contains(FIELD_PSSYSENGINECFGNAME);
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
    public Integer getPubDBModelFlag() {
        Object objValue = this.get(FIELD_PUBDBMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubdbmodelflag")
    public void setPubDBModelFlag(Integer pubDBModelFlag) {
        this.set(FIELD_PUBDBMODELFLAG, pubDBModelFlag);
    }

    @JsonIgnore
    public boolean isPubDBModelFlagDirty() {
        return this.contains(FIELD_PUBDBMODELFLAG);
    }

    @JsonIgnore
    public Integer getSaaSMode() {
        Object objValue = this.get(FIELD_SAASMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="saasmode")
    public void setSaaSMode(Integer saaSMode) {
        this.set(FIELD_SAASMODE, saaSMode);
    }

    @JsonIgnore
    public boolean isSaaSModeDirty() {
        return this.contains(FIELD_SAASMODE);
    }

    @JsonIgnore
    public Integer getServiceAPIFlag() {
        Object objValue = this.get(FIELD_SERVICEAPIFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="serviceapiflag")
    public void setServiceAPIFlag(Integer serviceAPIFlag) {
        this.set(FIELD_SERVICEAPIFLAG, serviceAPIFlag);
    }

    @JsonIgnore
    public boolean isServiceAPIFlagDirty() {
        return this.contains(FIELD_SERVICEAPIFLAG);
    }

    @JsonIgnore
    public Integer getSimActionLogics() {
        Object objValue = this.get(FIELD_SIMACTIONLOGICS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="simactionlogics")
    public void setSimActionLogics(Integer simActionLogics) {
        this.set(FIELD_SIMACTIONLOGICS, simActionLogics);
    }

    @JsonIgnore
    public boolean isSimActionLogicsDirty() {
        return this.contains(FIELD_SIMACTIONLOGICS);
    }

    @JsonIgnore
    public String getSrcPSSystemId() {
        Object objValue = this.get(FIELD_SRCPSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpssystemid")
    public void setSrcPSSystemId(String srcPSSystemId) {
        this.set(FIELD_SRCPSSYSTEMID, srcPSSystemId);
    }

    @JsonIgnore
    public boolean isSrcPSSystemIdDirty() {
        return this.contains(FIELD_SRCPSSYSTEMID);
    }

    @JsonIgnore
    public String getSrcPSSystemName() {
        Object objValue = this.get(FIELD_SRCPSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpssystemname")
    public void setSrcPSSystemName(String srcPSSystemName) {
        this.set(FIELD_SRCPSSYSTEMNAME, srcPSSystemName);
    }

    @JsonIgnore
    public boolean isSrcPSSystemNameDirty() {
        return this.contains(FIELD_SRCPSSYSTEMNAME);
    }

    @JsonIgnore
    public Integer getSSDEMSActionLogicFlag() {
        Object objValue = this.get(FIELD_SSDEMSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ssdemsactionlogicflag")
    public void setSSDEMSActionLogicFlag(Integer sSDEMSActionLogicFlag) {
        this.set(FIELD_SSDEMSACTIONLOGICFLAG, sSDEMSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isSSDEMSActionLogicFlagDirty() {
        return this.contains(FIELD_SSDEMSACTIONLOGICFLAG);
    }

    @JsonIgnore
    public String getSysFolder() {
        Object objValue = this.get(FIELD_SYSFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysfolder")
    public void setSysFolder(String sysFolder) {
        this.set(FIELD_SYSFOLDER, sysFolder);
    }

    @JsonIgnore
    public boolean isSysFolderDirty() {
        return this.contains(FIELD_SYSFOLDER);
    }

    @JsonIgnore
    public String getSysRowKey() {
        Object objValue = this.get(FIELD_SYSROWKEY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysrowkey")
    public void setSysRowKey(String sysRowKey) {
        this.set(FIELD_SYSROWKEY, sysRowKey);
    }

    @JsonIgnore
    public boolean isSysRowKeyDirty() {
        return this.contains(FIELD_SYSROWKEY);
    }

    @JsonIgnore
    public String getSysType() {
        Object objValue = this.get(FIELD_SYSTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="systype")
    public void setSysType(String sysType) {
        this.set(FIELD_SYSTYPE, sysType);
    }

    @JsonIgnore
    public boolean isSysTypeDirty() {
        return this.contains(FIELD_SYSTYPE);
    }

    @JsonIgnore
    public String getSysVer() {
        Object objValue = this.get(FIELD_SYSVER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysver")
    public void setSysVer(String sysVer) {
        this.set(FIELD_SYSVER, sysVer);
    }

    @JsonIgnore
    public boolean isSysVerDirty() {
        return this.contains(FIELD_SYSVER);
    }

    @JsonIgnore
    public String getTemplEngine() {
        Object objValue = this.get(FIELD_TEMPLENGINE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templengine")
    public void setTemplEngine(String templEngine) {
        this.set(FIELD_TEMPLENGINE, templEngine);
    }

    @JsonIgnore
    public boolean isTemplEngineDirty() {
        return this.contains(FIELD_TEMPLENGINE);
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
    public Integer getViewUARegMode() {
        Object objValue = this.get(FIELD_VIEWUAREGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewuaregmode")
    public void setViewUARegMode(Integer viewUARegMode) {
        this.set(FIELD_VIEWUAREGMODE, viewUARegMode);
    }

    @JsonIgnore
    public boolean isViewUARegModeDirty() {
        return this.contains(FIELD_VIEWUAREGMODE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSystemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSystemId(strValue);
    }
}

