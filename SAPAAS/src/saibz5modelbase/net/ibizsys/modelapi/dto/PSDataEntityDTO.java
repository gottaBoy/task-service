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

public class PSDataEntityDTO
extends PSModelDTOBase {
    public static final String FIELD_ACCCTRLARCH = "accctrlarch";
    public static final String FIELD_AUDITMODE = "auditmode";
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_BIZTAG = "biztag";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATAACCMODE = "dataaccmode";
    public static final String FIELD_DATACHGLOGMODE = "datachglogmode";
    public static final String FIELD_DATAIMPEXPFLAG = "dataimpexpflag";
    public static final String FIELD_DBTABSPACE = "dbtabspace";
    public static final String FIELD_DECAT = "decat";
    public static final String FIELD_DEHOLDER = "deholder";
    public static final String FIELD_DELOCKFLAG = "delockflag";
    public static final String FIELD_DESN = "desn";
    public static final String FIELD_DETAG = "detag";
    public static final String FIELD_DETAG2 = "detag2";
    public static final String FIELD_DETYPE = "detype";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_DYNAMICMODE = "dynamicmode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLEDATAVER = "enabledataver";
    public static final String FIELD_ENABLEDEACTION = "enabledeaction";
    public static final String FIELD_ENABLEDEDATASET = "enablededataset";
    public static final String FIELD_ENABLEDYNASYS = "enabledynasys";
    public static final String FIELD_ENABLEENTITYCACHE = "enableentitycache";
    public static final String FIELD_ENABLEMOB = "enablemob";
    public static final String FIELD_ENABLEOPNAMEMODEL = "enableopnamemodel";
    public static final String FIELD_ENABLEORGMODEL = "enableorgmodel";
    public static final String FIELD_ENABLESELECT = "enableselect";
    public static final String FIELD_ENABLEWFMODEL = "enablewfmodel";
    public static final String FIELD_ENAMULTIFORM = "enamultiform";
    public static final String FIELD_ENATEMPDATA = "enatempdata";
    public static final String FIELD_ENTITYCACHETIMEOUT = "entitycachetimeout";
    public static final String FIELD_EXISTINGMODEL = "existingmodel";
    public static final String FIELD_EXTABLENAME = "extablename";
    public static final String FIELD_INDEXDETYPE = "indexdetype";
    public static final String FIELD_KEYRULE = "keyrule";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICINVALIDVALUE = "logicinvalidvalue";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_LOGICVALID = "logicvalid";
    public static final String FIELD_LOGICVALIDVALUE = "logicvalidvalue";
    public static final String FIELD_MAXENTITYCACHECNT = "maxentitycachecnt";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_MODELIMPEXPFLAG = "modelimpexpflag";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_MSACTIONLOGICFLAG = "msactionlogicflag";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDATAENTITYID = "psdataentityid";
    public static final String FIELD_PSDATAENTITYNAME = "psdataentityname";
    public static final String FIELD_PSDEFINPUTTIPSETID = "psdefinputtipsetid";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "psdefinputtipsetname";
    public static final String FIELD_PSDYNADETEMPLID = "psdynadetemplid";
    public static final String FIELD_PSDYNADETEMPLNAME = "psdynadetemplname";
    public static final String FIELD_PSHELPMODULEID = "pshelpmoduleid";
    public static final String FIELD_PSHELPMODULENAME = "pshelpmodulename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    public static final String FIELD_SAASMODE = "saasmode";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SERVICECODENAME = "servicecodename";
    public static final String FIELD_STORAGEMODE = "storagemode";
    public static final String FIELD_SUBSYSMODULE = "subsysmodule";
    public static final String FIELD_SYSTEMFLAG = "systemflag";
    public static final String FIELD_TABLENAME = "tablename";
    public static final String FIELD_TESTCASEFLAG = "testcaseflag";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERACTION = "useraction";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWLEVEL = "viewlevel";
    public static final String FIELD_VIEWNAME = "viewname";
    public static final String FIELD_VIEWNAME2 = "viewname2";
    public static final String FIELD_VIEWNAME3 = "viewname3";
    public static final String FIELD_VIEWNAME4 = "viewname4";
    public static final String FIELD_VIRTUALFLAG = "virtualflag";
    public static final String FIELD_VKEYSEPARATOR = "vkeyseparator";

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
    public Integer getAuditMode() {
        Object objValue = this.get(FIELD_AUDITMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="auditmode")
    public void setAuditMode(Integer auditMode) {
        this.set(FIELD_AUDITMODE, auditMode);
    }

    @JsonIgnore
    public boolean isAuditModeDirty() {
        return this.contains(FIELD_AUDITMODE);
    }

    @JsonIgnore
    public String getBaseClsParams() {
        Object objValue = this.get(FIELD_BASECLSPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclsparams")
    public void setBaseClsParams(String baseClsParams) {
        this.set(FIELD_BASECLSPARAMS, baseClsParams);
    }

    @JsonIgnore
    public boolean isBaseClsParamsDirty() {
        return this.contains(FIELD_BASECLSPARAMS);
    }

    @JsonIgnore
    public String getBizTag() {
        Object objValue = this.get(FIELD_BIZTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biztag")
    public void setBizTag(String bizTag) {
        this.set(FIELD_BIZTAG, bizTag);
    }

    @JsonIgnore
    public boolean isBizTagDirty() {
        return this.contains(FIELD_BIZTAG);
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
    public String getColor() {
        Object objValue = this.get(FIELD_COLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="color")
    public void setColor(String color) {
        this.set(FIELD_COLOR, color);
    }

    @JsonIgnore
    public boolean isColorDirty() {
        return this.contains(FIELD_COLOR);
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
    public Integer getDataAccMode() {
        Object objValue = this.get(FIELD_DATAACCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dataaccmode")
    public void setDataAccMode(Integer dataAccMode) {
        this.set(FIELD_DATAACCMODE, dataAccMode);
    }

    @JsonIgnore
    public boolean isDataAccModeDirty() {
        return this.contains(FIELD_DATAACCMODE);
    }

    @JsonIgnore
    public Integer getDataChgLogMode() {
        Object objValue = this.get(FIELD_DATACHGLOGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="datachglogmode")
    public void setDataChgLogMode(Integer dataChgLogMode) {
        this.set(FIELD_DATACHGLOGMODE, dataChgLogMode);
    }

    @JsonIgnore
    public boolean isDataChgLogModeDirty() {
        return this.contains(FIELD_DATACHGLOGMODE);
    }

    @JsonIgnore
    public Integer getDataImpExpFlag() {
        Object objValue = this.get(FIELD_DATAIMPEXPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dataimpexpflag")
    public void setDataImpExpFlag(Integer dataImpExpFlag) {
        this.set(FIELD_DATAIMPEXPFLAG, dataImpExpFlag);
    }

    @JsonIgnore
    public boolean isDataImpExpFlagDirty() {
        return this.contains(FIELD_DATAIMPEXPFLAG);
    }

    @JsonIgnore
    public String getDBTabSpace() {
        Object objValue = this.get(FIELD_DBTABSPACE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtabspace")
    public void setDBTabSpace(String dBTabSpace) {
        this.set(FIELD_DBTABSPACE, dBTabSpace);
    }

    @JsonIgnore
    public boolean isDBTabSpaceDirty() {
        return this.contains(FIELD_DBTABSPACE);
    }

    @JsonIgnore
    public String getDECat() {
        Object objValue = this.get(FIELD_DECAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="decat")
    public void setDECat(String dECat) {
        this.set(FIELD_DECAT, dECat);
    }

    @JsonIgnore
    public boolean isDECatDirty() {
        return this.contains(FIELD_DECAT);
    }

    @JsonIgnore
    public Integer getDEHolder() {
        Object objValue = this.get(FIELD_DEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deholder")
    public void setDEHolder(Integer dEHolder) {
        this.set(FIELD_DEHOLDER, dEHolder);
    }

    @JsonIgnore
    public boolean isDEHolderDirty() {
        return this.contains(FIELD_DEHOLDER);
    }

    @JsonIgnore
    public Integer getDELockFlag() {
        Object objValue = this.get(FIELD_DELOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="delockflag")
    public void setDELockFlag(Integer dELockFlag) {
        this.set(FIELD_DELOCKFLAG, dELockFlag);
    }

    @JsonIgnore
    public boolean isDELockFlagDirty() {
        return this.contains(FIELD_DELOCKFLAG);
    }

    @JsonIgnore
    public String getDESN() {
        Object objValue = this.get(FIELD_DESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="desn")
    public void setDESN(String dESN) {
        this.set(FIELD_DESN, dESN);
    }

    @JsonIgnore
    public boolean isDESNDirty() {
        return this.contains(FIELD_DESN);
    }

    @JsonIgnore
    public String getDETag() {
        Object objValue = this.get(FIELD_DETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag")
    public void setDETag(String dETag) {
        this.set(FIELD_DETAG, dETag);
    }

    @JsonIgnore
    public boolean isDETagDirty() {
        return this.contains(FIELD_DETAG);
    }

    @JsonIgnore
    public String getDETag2() {
        Object objValue = this.get(FIELD_DETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detag2")
    public void setDETag2(String dETag2) {
        this.set(FIELD_DETAG2, dETag2);
    }

    @JsonIgnore
    public boolean isDETag2Dirty() {
        return this.contains(FIELD_DETAG2);
    }

    @JsonIgnore
    public Integer getDEType() {
        Object objValue = this.get(FIELD_DETYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="detype")
    public void setDEType(Integer dEType) {
        this.set(FIELD_DETYPE, dEType);
    }

    @JsonIgnore
    public boolean isDETypeDirty() {
        return this.contains(FIELD_DETYPE);
    }

    @JsonIgnore
    public String getDSLink() {
        Object objValue = this.get(FIELD_DSLINK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dslink")
    public void setDSLink(String dSLink) {
        this.set(FIELD_DSLINK, dSLink);
    }

    @JsonIgnore
    public boolean isDSLinkDirty() {
        return this.contains(FIELD_DSLINK);
    }

    @JsonIgnore
    public Integer getDynamicMode() {
        Object objValue = this.get(FIELD_DYNAMICMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamicmode")
    public void setDynamicMode(Integer dynamicMode) {
        this.set(FIELD_DYNAMICMODE, dynamicMode);
    }

    @JsonIgnore
    public boolean isDynamicModeDirty() {
        return this.contains(FIELD_DYNAMICMODE);
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
    public Integer getEnableAudit() {
        Object objValue = this.get(FIELD_ENABLEAUDIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableaudit")
    public void setEnableAudit(Integer enableAudit) {
        this.set(FIELD_ENABLEAUDIT, enableAudit);
    }

    @JsonIgnore
    public boolean isEnableAuditDirty() {
        return this.contains(FIELD_ENABLEAUDIT);
    }

    @JsonIgnore
    public Integer getEnableDataVer() {
        Object objValue = this.get(FIELD_ENABLEDATAVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledataver")
    public void setEnableDataVer(Integer enableDataVer) {
        this.set(FIELD_ENABLEDATAVER, enableDataVer);
    }

    @JsonIgnore
    public boolean isEnableDataVerDirty() {
        return this.contains(FIELD_ENABLEDATAVER);
    }

    @JsonIgnore
    public Integer getEnableDEAction() {
        Object objValue = this.get(FIELD_ENABLEDEACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledeaction")
    public void setEnableDEAction(Integer enableDEAction) {
        this.set(FIELD_ENABLEDEACTION, enableDEAction);
    }

    @JsonIgnore
    public boolean isEnableDEActionDirty() {
        return this.contains(FIELD_ENABLEDEACTION);
    }

    @JsonIgnore
    public Integer getEnableDEDataSet() {
        Object objValue = this.get(FIELD_ENABLEDEDATASET);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablededataset")
    public void setEnableDEDataSet(Integer enableDEDataSet) {
        this.set(FIELD_ENABLEDEDATASET, enableDEDataSet);
    }

    @JsonIgnore
    public boolean isEnableDEDataSetDirty() {
        return this.contains(FIELD_ENABLEDEDATASET);
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
    public Integer getEnableEntityCache() {
        Object objValue = this.get(FIELD_ENABLEENTITYCACHE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableentitycache")
    public void setEnableEntityCache(Integer enableEntityCache) {
        this.set(FIELD_ENABLEENTITYCACHE, enableEntityCache);
    }

    @JsonIgnore
    public boolean isEnableEntityCacheDirty() {
        return this.contains(FIELD_ENABLEENTITYCACHE);
    }

    @JsonIgnore
    public Integer getEnableMob() {
        Object objValue = this.get(FIELD_ENABLEMOB);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemob")
    public void setEnableMob(Integer enableMob) {
        this.set(FIELD_ENABLEMOB, enableMob);
    }

    @JsonIgnore
    public boolean isEnableMobDirty() {
        return this.contains(FIELD_ENABLEMOB);
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
    public Integer getEnableOrgModel() {
        Object objValue = this.get(FIELD_ENABLEORGMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableorgmodel")
    public void setEnableOrgModel(Integer enableOrgModel) {
        this.set(FIELD_ENABLEORGMODEL, enableOrgModel);
    }

    @JsonIgnore
    public boolean isEnableOrgModelDirty() {
        return this.contains(FIELD_ENABLEORGMODEL);
    }

    @JsonIgnore
    public Integer getEnableSelect() {
        Object objValue = this.get(FIELD_ENABLESELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableselect")
    public void setEnableSelect(Integer enableSelect) {
        this.set(FIELD_ENABLESELECT, enableSelect);
    }

    @JsonIgnore
    public boolean isEnableSelectDirty() {
        return this.contains(FIELD_ENABLESELECT);
    }

    @JsonIgnore
    public Integer getEnableWFModel() {
        Object objValue = this.get(FIELD_ENABLEWFMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablewfmodel")
    public void setEnableWFModel(Integer enableWFModel) {
        this.set(FIELD_ENABLEWFMODEL, enableWFModel);
    }

    @JsonIgnore
    public boolean isEnableWFModelDirty() {
        return this.contains(FIELD_ENABLEWFMODEL);
    }

    @JsonIgnore
    public Integer getEnaMultiForm() {
        Object objValue = this.get(FIELD_ENAMULTIFORM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enamultiform")
    public void setEnaMultiForm(Integer enaMultiForm) {
        this.set(FIELD_ENAMULTIFORM, enaMultiForm);
    }

    @JsonIgnore
    public boolean isEnaMultiFormDirty() {
        return this.contains(FIELD_ENAMULTIFORM);
    }

    @JsonIgnore
    public Integer getEnaTempData() {
        Object objValue = this.get(FIELD_ENATEMPDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enatempdata")
    public void setEnaTempData(Integer enaTempData) {
        this.set(FIELD_ENATEMPDATA, enaTempData);
    }

    @JsonIgnore
    public boolean isEnaTempDataDirty() {
        return this.contains(FIELD_ENATEMPDATA);
    }

    @JsonIgnore
    public Integer getEntityCacheTimeout() {
        Object objValue = this.get(FIELD_ENTITYCACHETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="entitycachetimeout")
    public void setEntityCacheTimeout(Integer entityCacheTimeout) {
        this.set(FIELD_ENTITYCACHETIMEOUT, entityCacheTimeout);
    }

    @JsonIgnore
    public boolean isEntityCacheTimeoutDirty() {
        return this.contains(FIELD_ENTITYCACHETIMEOUT);
    }

    @JsonIgnore
    public Integer getExistingModel() {
        Object objValue = this.get(FIELD_EXISTINGMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="existingmodel")
    public void setExistingModel(Integer existingModel) {
        this.set(FIELD_EXISTINGMODEL, existingModel);
    }

    @JsonIgnore
    public boolean isExistingModelDirty() {
        return this.contains(FIELD_EXISTINGMODEL);
    }

    @JsonIgnore
    public String getExTableName() {
        Object objValue = this.get(FIELD_EXTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extablename")
    public void setExTableName(String exTableName) {
        this.set(FIELD_EXTABLENAME, exTableName);
    }

    @JsonIgnore
    public boolean isExTableNameDirty() {
        return this.contains(FIELD_EXTABLENAME);
    }

    @JsonIgnore
    public String getIndexDEType() {
        Object objValue = this.get(FIELD_INDEXDETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="indexdetype")
    public void setIndexDEType(String indexDEType) {
        this.set(FIELD_INDEXDETYPE, indexDEType);
    }

    @JsonIgnore
    public boolean isIndexDETypeDirty() {
        return this.contains(FIELD_INDEXDETYPE);
    }

    @JsonIgnore
    public String getKeyRule() {
        Object objValue = this.get(FIELD_KEYRULE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keyrule")
    public void setKeyRule(String keyRule) {
        this.set(FIELD_KEYRULE, keyRule);
    }

    @JsonIgnore
    public boolean isKeyRuleDirty() {
        return this.contains(FIELD_KEYRULE);
    }

    @JsonIgnore
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public String getLogicInvalidValue() {
        Object objValue = this.get(FIELD_LOGICINVALIDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicinvalidvalue")
    public void setLogicInvalidValue(String logicInvalidValue) {
        this.set(FIELD_LOGICINVALIDVALUE, logicInvalidValue);
    }

    @JsonIgnore
    public boolean isLogicInvalidValueDirty() {
        return this.contains(FIELD_LOGICINVALIDVALUE);
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
    public Integer getLogicValid() {
        Object objValue = this.get(FIELD_LOGICVALID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="logicvalid")
    public void setLogicValid(Integer logicValid) {
        this.set(FIELD_LOGICVALID, logicValid);
    }

    @JsonIgnore
    public boolean isLogicValidDirty() {
        return this.contains(FIELD_LOGICVALID);
    }

    @JsonIgnore
    public String getLogicValidValue() {
        Object objValue = this.get(FIELD_LOGICVALIDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicvalidvalue")
    public void setLogicValidValue(String logicValidValue) {
        this.set(FIELD_LOGICVALIDVALUE, logicValidValue);
    }

    @JsonIgnore
    public boolean isLogicValidValueDirty() {
        return this.contains(FIELD_LOGICVALIDVALUE);
    }

    @JsonIgnore
    public Integer getMaxEntityCacheCnt() {
        Object objValue = this.get(FIELD_MAXENTITYCACHECNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxentitycachecnt")
    public void setMaxEntityCacheCnt(Integer maxEntityCacheCnt) {
        this.set(FIELD_MAXENTITYCACHECNT, maxEntityCacheCnt);
    }

    @JsonIgnore
    public boolean isMaxEntityCacheCntDirty() {
        return this.contains(FIELD_MAXENTITYCACHECNT);
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
    public Integer getModelImpExpFlag() {
        Object objValue = this.get(FIELD_MODELIMPEXPFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelimpexpflag")
    public void setModelImpExpFlag(Integer modelImpExpFlag) {
        this.set(FIELD_MODELIMPEXPFLAG, modelImpExpFlag);
    }

    @JsonIgnore
    public boolean isModelImpExpFlagDirty() {
        return this.contains(FIELD_MODELIMPEXPFLAG);
    }

    @JsonIgnore
    public Integer getModelState() {
        Object objValue = this.get(FIELD_MODELSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelstate")
    public void setModelState(Integer modelState) {
        this.set(FIELD_MODELSTATE, modelState);
    }

    @JsonIgnore
    public boolean isModelStateDirty() {
        return this.contains(FIELD_MODELSTATE);
    }

    @JsonIgnore
    public Integer getMSActionLogicFlag() {
        Object objValue = this.get(FIELD_MSACTIONLOGICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="msactionlogicflag")
    public void setMSActionLogicFlag(Integer mSActionLogicFlag) {
        this.set(FIELD_MSACTIONLOGICFLAG, mSActionLogicFlag);
    }

    @JsonIgnore
    public boolean isMSActionLogicFlagDirty() {
        return this.contains(FIELD_MSACTIONLOGICFLAG);
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
    public String getPSDataEntityId() {
        Object objValue = this.get(FIELD_PSDATAENTITYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdataentityid")
    public void setPSDataEntityId(String pSDataEntityId) {
        this.set(FIELD_PSDATAENTITYID, pSDataEntityId);
    }

    @JsonIgnore
    public boolean isPSDataEntityIdDirty() {
        return this.contains(FIELD_PSDATAENTITYID);
    }

    @JsonIgnore
    public String getPSDataEntityName() {
        Object objValue = this.get(FIELD_PSDATAENTITYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdataentityname")
    public void setPSDataEntityName(String pSDataEntityName) {
        this.set(FIELD_PSDATAENTITYNAME, pSDataEntityName);
    }

    @JsonIgnore
    public boolean isPSDataEntityNameDirty() {
        return this.contains(FIELD_PSDATAENTITYNAME);
    }

    @JsonIgnore
    public String getPSDEFInputTipSetId() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPSETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipsetid")
    public void setPSDEFInputTipSetId(String pSDEFInputTipSetId) {
        this.set(FIELD_PSDEFINPUTTIPSETID, pSDEFInputTipSetId);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipSetIdDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPSETID);
    }

    @JsonIgnore
    public String getPSDEFInputTipSetName() {
        Object objValue = this.get(FIELD_PSDEFINPUTTIPSETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefinputtipsetname")
    public void setPSDEFInputTipSetName(String pSDEFInputTipSetName) {
        this.set(FIELD_PSDEFINPUTTIPSETNAME, pSDEFInputTipSetName);
    }

    @JsonIgnore
    public boolean isPSDEFInputTipSetNameDirty() {
        return this.contains(FIELD_PSDEFINPUTTIPSETNAME);
    }

    @JsonIgnore
    public String getPSDynaDETemplId() {
        Object objValue = this.get(FIELD_PSDYNADETEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadetemplid")
    public void setPSDynaDETemplId(String pSDynaDETemplId) {
        this.set(FIELD_PSDYNADETEMPLID, pSDynaDETemplId);
    }

    @JsonIgnore
    public boolean isPSDynaDETemplIdDirty() {
        return this.contains(FIELD_PSDYNADETEMPLID);
    }

    @JsonIgnore
    public String getPSDynaDETemplName() {
        Object objValue = this.get(FIELD_PSDYNADETEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadetemplname")
    public void setPSDynaDETemplName(String pSDynaDETemplName) {
        this.set(FIELD_PSDYNADETEMPLNAME, pSDynaDETemplName);
    }

    @JsonIgnore
    public boolean isPSDynaDETemplNameDirty() {
        return this.contains(FIELD_PSDYNADETEMPLNAME);
    }

    @JsonIgnore
    public String getPSHelpModuleId() {
        Object objValue = this.get(FIELD_PSHELPMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmoduleid")
    public void setPSHelpModuleId(String pSHelpModuleId) {
        this.set(FIELD_PSHELPMODULEID, pSHelpModuleId);
    }

    @JsonIgnore
    public boolean isPSHelpModuleIdDirty() {
        return this.contains(FIELD_PSHELPMODULEID);
    }

    @JsonIgnore
    public String getPSHelpModuleName() {
        Object objValue = this.get(FIELD_PSHELPMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmodulename")
    public void setPSHelpModuleName(String pSHelpModuleName) {
        this.set(FIELD_PSHELPMODULENAME, pSHelpModuleName);
    }

    @JsonIgnore
    public boolean isPSHelpModuleNameDirty() {
        return this.contains(FIELD_PSHELPMODULENAME);
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
    public String getPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadeid")
    public void setPSSubSysSADEId(String pSSubSysSADEId) {
        this.set(FIELD_PSSUBSYSSADEID, pSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadename")
    public void setPSSubSysSADEName(String pSSubSysSADEName) {
        this.set(FIELD_PSSUBSYSSADENAME, pSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADENameDirty() {
        return this.contains(FIELD_PSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
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
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getPSSysModelGroupId() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupid")
    public void setPSSysModelGroupId(String pSSysModelGroupId) {
        this.set(FIELD_PSSYSMODELGROUPID, pSSysModelGroupId);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupIdDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPID);
    }

    @JsonIgnore
    public String getPSSysModelGroupName() {
        Object objValue = this.get(FIELD_PSSYSMODELGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelgroupname")
    public void setPSSysModelGroupName(String pSSysModelGroupName) {
        this.set(FIELD_PSSYSMODELGROUPNAME, pSSysModelGroupName);
    }

    @JsonIgnore
    public boolean isPSSysModelGroupNameDirty() {
        return this.contains(FIELD_PSSYSMODELGROUPNAME);
    }

    @JsonIgnore
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public Integer getReadOnlyMode() {
        Object objValue = this.get(FIELD_READONLYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="readonlymode")
    public void setReadOnlyMode(Integer readOnlyMode) {
        this.set(FIELD_READONLYMODE, readOnlyMode);
    }

    @JsonIgnore
    public boolean isReadOnlyModeDirty() {
        return this.contains(FIELD_READONLYMODE);
    }

    @JsonIgnore
    public Integer getRemoveFlag() {
        Object objValue = this.get(FIELD_REMOVEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeflag")
    public void setRemoveFlag(Integer removeFlag) {
        this.set(FIELD_REMOVEFLAG, removeFlag);
    }

    @JsonIgnore
    public boolean isRemoveFlagDirty() {
        return this.contains(FIELD_REMOVEFLAG);
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
    public String getServiceCodeName() {
        Object objValue = this.get(FIELD_SERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="servicecodename")
    public void setServiceCodeName(String serviceCodeName) {
        this.set(FIELD_SERVICECODENAME, serviceCodeName);
    }

    @JsonIgnore
    public boolean isServiceCodeNameDirty() {
        return this.contains(FIELD_SERVICECODENAME);
    }

    @JsonIgnore
    public Integer getStorageMode() {
        Object objValue = this.get(FIELD_STORAGEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="storagemode")
    public void setStorageMode(Integer storageMode) {
        this.set(FIELD_STORAGEMODE, storageMode);
    }

    @JsonIgnore
    public boolean isStorageModeDirty() {
        return this.contains(FIELD_STORAGEMODE);
    }

    @JsonIgnore
    public Integer getSubSysModule() {
        Object objValue = this.get(FIELD_SUBSYSMODULE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="subsysmodule")
    public void setSubSysModule(Integer subSysModule) {
        this.set(FIELD_SUBSYSMODULE, subSysModule);
    }

    @JsonIgnore
    public boolean isSubSysModuleDirty() {
        return this.contains(FIELD_SUBSYSMODULE);
    }

    @JsonIgnore
    public Integer getSystemFlag() {
        Object objValue = this.get(FIELD_SYSTEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="systemflag")
    public void setSystemFlag(Integer systemFlag) {
        this.set(FIELD_SYSTEMFLAG, systemFlag);
    }

    @JsonIgnore
    public boolean isSystemFlagDirty() {
        return this.contains(FIELD_SYSTEMFLAG);
    }

    @JsonIgnore
    public String getTableName() {
        Object objValue = this.get(FIELD_TABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablename")
    public void setTableName(String tableName) {
        this.set(FIELD_TABLENAME, tableName);
    }

    @JsonIgnore
    public boolean isTableNameDirty() {
        return this.contains(FIELD_TABLENAME);
    }

    @JsonIgnore
    public Integer getTestCaseFlag() {
        Object objValue = this.get(FIELD_TESTCASEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="testcaseflag")
    public void setTestCaseFlag(Integer testCaseFlag) {
        this.set(FIELD_TESTCASEFLAG, testCaseFlag);
    }

    @JsonIgnore
    public boolean isTestCaseFlagDirty() {
        return this.contains(FIELD_TESTCASEFLAG);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
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
    public Integer getUserAction() {
        Object objValue = this.get(FIELD_USERACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="useraction")
    public void setUserAction(Integer userAction) {
        this.set(FIELD_USERACTION, userAction);
    }

    @JsonIgnore
    public boolean isUserActionDirty() {
        return this.contains(FIELD_USERACTION);
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
    public Integer getViewLevel() {
        Object objValue = this.get(FIELD_VIEWLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewlevel")
    public void setViewLevel(Integer viewLevel) {
        this.set(FIELD_VIEWLEVEL, viewLevel);
    }

    @JsonIgnore
    public boolean isViewLevelDirty() {
        return this.contains(FIELD_VIEWLEVEL);
    }

    @JsonIgnore
    public String getViewName() {
        Object objValue = this.get(FIELD_VIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname")
    public void setViewName(String viewName) {
        this.set(FIELD_VIEWNAME, viewName);
    }

    @JsonIgnore
    public boolean isViewNameDirty() {
        return this.contains(FIELD_VIEWNAME);
    }

    @JsonIgnore
    public String getViewName2() {
        Object objValue = this.get(FIELD_VIEWNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname2")
    public void setViewName2(String viewName2) {
        this.set(FIELD_VIEWNAME2, viewName2);
    }

    @JsonIgnore
    public boolean isViewName2Dirty() {
        return this.contains(FIELD_VIEWNAME2);
    }

    @JsonIgnore
    public String getViewName3() {
        Object objValue = this.get(FIELD_VIEWNAME3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname3")
    public void setViewName3(String viewName3) {
        this.set(FIELD_VIEWNAME3, viewName3);
    }

    @JsonIgnore
    public boolean isViewName3Dirty() {
        return this.contains(FIELD_VIEWNAME3);
    }

    @JsonIgnore
    public String getViewName4() {
        Object objValue = this.get(FIELD_VIEWNAME4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname4")
    public void setViewName4(String viewName4) {
        this.set(FIELD_VIEWNAME4, viewName4);
    }

    @JsonIgnore
    public boolean isViewName4Dirty() {
        return this.contains(FIELD_VIEWNAME4);
    }

    @JsonIgnore
    public Integer getVirtualFlag() {
        Object objValue = this.get(FIELD_VIRTUALFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="virtualflag")
    public void setVirtualFlag(Integer virtualFlag) {
        this.set(FIELD_VIRTUALFLAG, virtualFlag);
    }

    @JsonIgnore
    public boolean isVirtualFlagDirty() {
        return this.contains(FIELD_VIRTUALFLAG);
    }

    @JsonIgnore
    public String getVKeySeparator() {
        Object objValue = this.get(FIELD_VKEYSEPARATOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="vkeyseparator")
    public void setVKeySeparator(String vKeySeparator) {
        this.set(FIELD_VKEYSEPARATOR, vKeySeparator);
    }

    @JsonIgnore
    public boolean isVKeySeparatorDirty() {
        return this.contains(FIELD_VKEYSEPARATOR);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDataEntityId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDataEntityId(strValue);
    }
}

