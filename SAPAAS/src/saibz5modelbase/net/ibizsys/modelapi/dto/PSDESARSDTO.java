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

public class PSDESARSDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONRSMODE = "actionrsmode";
    public static final String FIELD_ARRAYFLAG = "arrayflag";
    public static final String FIELD_CHILDFILTER = "childfilter";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    public static final String FIELD_CPSDEID = "cpsdeid";
    public static final String FIELD_CPSDESERVICEAPIID = "cpsdeserviceapiid";
    public static final String FIELD_CPSDESERVICEAPINAME = "cpsdeserviceapiname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATAACCMODE = "dataaccmode";
    public static final String FIELD_DATARSMODE = "datarsmode";
    public static final String FIELD_ENABLEDATAEXPORT = "enabledataexport";
    public static final String FIELD_ENABLEDATAIMPORT = "enabledataimport";
    public static final String FIELD_ENABLEDEACTION = "enabledeaction";
    public static final String FIELD_ENABLEDEDATASET = "enablededataset";
    public static final String FIELD_ENABLESELECT = "enableselect";
    public static final String FIELD_EXPORTMODEL = "exportmodel";
    public static final String FIELD_EXPORTSCOPE = "exportscope";
    public static final String FIELD_EXPORTSCOPE2 = "exportscope2";
    public static final String FIELD_EXPORTSCOPE3 = "exportscope3";
    public static final String FIELD_EXPORTSCOPE4 = "exportscope4";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSDEID = "ppsdeid";
    public static final String FIELD_PPSDESERVICEAPIID = "ppsdeserviceapiid";
    public static final String FIELD_PPSDESERVICEAPINAME = "ppsdeserviceapiname";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDESARSID = "psdesarsid";
    public static final String FIELD_PSDESARSNAME = "psdesarsname";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_SYNCEXPORTMODEL = "syncexportmodel";
    public static final String FIELD_TEMPORDERVALUE = "tempordervalue";
    public static final String FIELD_TYPEFILTER = "typefilter";
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
    public Integer getActionRSMode() {
        Object objValue = this.get(FIELD_ACTIONRSMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionrsmode")
    public void setActionRSMode(Integer actionRSMode) {
        this.set(FIELD_ACTIONRSMODE, actionRSMode);
    }

    @JsonIgnore
    public boolean isActionRSModeDirty() {
        return this.contains(FIELD_ACTIONRSMODE);
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
    public String getChildFilter() {
        Object objValue = this.get(FIELD_CHILDFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childfilter")
    public void setChildFilter(String childFilter) {
        this.set(FIELD_CHILDFILTER, childFilter);
    }

    @JsonIgnore
    public boolean isChildFilterDirty() {
        return this.contains(FIELD_CHILDFILTER);
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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
    }

    @JsonIgnore
    public String getCPSDEId() {
        Object objValue = this.get(FIELD_CPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsdeid")
    public void setCPSDEId(String cPSDEId) {
        this.set(FIELD_CPSDEID, cPSDEId);
    }

    @JsonIgnore
    public boolean isCPSDEIdDirty() {
        return this.contains(FIELD_CPSDEID);
    }

    @JsonIgnore
    public String getCPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_CPSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsdeserviceapiid")
    public void setCPSDEServiceAPIId(String cPSDEServiceAPIId) {
        this.set(FIELD_CPSDESERVICEAPIID, cPSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isCPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_CPSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getCPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_CPSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsdeserviceapiname")
    public void setCPSDEServiceAPIName(String cPSDEServiceAPIName) {
        this.set(FIELD_CPSDESERVICEAPINAME, cPSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isCPSDEServiceAPINameDirty() {
        return this.contains(FIELD_CPSDESERVICEAPINAME);
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
    public Integer getDataRSMode() {
        Object objValue = this.get(FIELD_DATARSMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="datarsmode")
    public void setDataRSMode(Integer dataRSMode) {
        this.set(FIELD_DATARSMODE, dataRSMode);
    }

    @JsonIgnore
    public boolean isDataRSModeDirty() {
        return this.contains(FIELD_DATARSMODE);
    }

    @JsonIgnore
    public Integer getEnableDataExport() {
        Object objValue = this.get(FIELD_ENABLEDATAEXPORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledataexport")
    public void setEnableDataExport(Integer enableDataExport) {
        this.set(FIELD_ENABLEDATAEXPORT, enableDataExport);
    }

    @JsonIgnore
    public boolean isEnableDataExportDirty() {
        return this.contains(FIELD_ENABLEDATAEXPORT);
    }

    @JsonIgnore
    public Integer getEnableDataImport() {
        Object objValue = this.get(FIELD_ENABLEDATAIMPORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabledataimport")
    public void setEnableDataImport(Integer enableDataImport) {
        this.set(FIELD_ENABLEDATAIMPORT, enableDataImport);
    }

    @JsonIgnore
    public boolean isEnableDataImportDirty() {
        return this.contains(FIELD_ENABLEDATAIMPORT);
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
    public Integer getExportModel() {
        Object objValue = this.get(FIELD_EXPORTMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportmodel")
    public void setExportModel(Integer exportModel) {
        this.set(FIELD_EXPORTMODEL, exportModel);
    }

    @JsonIgnore
    public boolean isExportModelDirty() {
        return this.contains(FIELD_EXPORTMODEL);
    }

    @JsonIgnore
    public Integer getExportScope() {
        Object objValue = this.get(FIELD_EXPORTSCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope")
    public void setExportScope(Integer exportScope) {
        this.set(FIELD_EXPORTSCOPE, exportScope);
    }

    @JsonIgnore
    public boolean isExportScopeDirty() {
        return this.contains(FIELD_EXPORTSCOPE);
    }

    @JsonIgnore
    public Integer getExportScope2() {
        Object objValue = this.get(FIELD_EXPORTSCOPE2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope2")
    public void setExportScope2(Integer exportScope2) {
        this.set(FIELD_EXPORTSCOPE2, exportScope2);
    }

    @JsonIgnore
    public boolean isExportScope2Dirty() {
        return this.contains(FIELD_EXPORTSCOPE2);
    }

    @JsonIgnore
    public Integer getExportScope3() {
        Object objValue = this.get(FIELD_EXPORTSCOPE3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope3")
    public void setExportScope3(Integer exportScope3) {
        this.set(FIELD_EXPORTSCOPE3, exportScope3);
    }

    @JsonIgnore
    public boolean isExportScope3Dirty() {
        return this.contains(FIELD_EXPORTSCOPE3);
    }

    @JsonIgnore
    public Integer getExportScope4() {
        Object objValue = this.get(FIELD_EXPORTSCOPE4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="exportscope4")
    public void setExportScope4(Integer exportScope4) {
        this.set(FIELD_EXPORTSCOPE4, exportScope4);
    }

    @JsonIgnore
    public boolean isExportScope4Dirty() {
        return this.contains(FIELD_EXPORTSCOPE4);
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
    public String getPPSDEId() {
        Object objValue = this.get(FIELD_PPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdeid")
    public void setPPSDEId(String pPSDEId) {
        this.set(FIELD_PPSDEID, pPSDEId);
    }

    @JsonIgnore
    public boolean isPPSDEIdDirty() {
        return this.contains(FIELD_PPSDEID);
    }

    @JsonIgnore
    public String getPPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_PPSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdeserviceapiid")
    public void setPPSDEServiceAPIId(String pPSDEServiceAPIId) {
        this.set(FIELD_PPSDESERVICEAPIID, pPSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isPPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_PPSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getPPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_PPSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdeserviceapiname")
    public void setPPSDEServiceAPIName(String pPSDEServiceAPIName) {
        this.set(FIELD_PPSDESERVICEAPINAME, pPSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isPPSDEServiceAPINameDirty() {
        return this.contains(FIELD_PPSDESERVICEAPINAME);
    }

    @JsonIgnore
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
    }

    @JsonIgnore
    public String getPSDESARSId() {
        Object objValue = this.get(FIELD_PSDESARSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesarsid")
    public void setPSDESARSId(String pSDESARSId) {
        this.set(FIELD_PSDESARSID, pSDESARSId);
    }

    @JsonIgnore
    public boolean isPSDESARSIdDirty() {
        return this.contains(FIELD_PSDESARSID);
    }

    @JsonIgnore
    public String getPSDESARSName() {
        Object objValue = this.get(FIELD_PSDESARSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesarsname")
    public void setPSDESARSName(String pSDESARSName) {
        this.set(FIELD_PSDESARSNAME, pSDESARSName);
    }

    @JsonIgnore
    public boolean isPSDESARSNameDirty() {
        return this.contains(FIELD_PSDESARSNAME);
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
    public String getPSSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiname")
    public void setPSSysServiceAPIName(String pSSysServiceAPIName) {
        this.set(FIELD_PSSYSSERVICEAPINAME, pSSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPINAME);
    }

    @JsonIgnore
    public Integer getSyncExportModel() {
        Object objValue = this.get(FIELD_SYNCEXPORTMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="syncexportmodel")
    public void setSyncExportModel(Integer syncExportModel) {
        this.set(FIELD_SYNCEXPORTMODEL, syncExportModel);
    }

    @JsonIgnore
    public boolean isSyncExportModelDirty() {
        return this.contains(FIELD_SYNCEXPORTMODEL);
    }

    @JsonIgnore
    public Integer getTempOrderValue() {
        Object objValue = this.get(FIELD_TEMPORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tempordervalue")
    public void setTempOrderValue(Integer tempOrderValue) {
        this.set(FIELD_TEMPORDERVALUE, tempOrderValue);
    }

    @JsonIgnore
    public boolean isTempOrderValueDirty() {
        return this.contains(FIELD_TEMPORDERVALUE);
    }

    @JsonIgnore
    public String getTypeFilter() {
        Object objValue = this.get(FIELD_TYPEFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typefilter")
    public void setTypeFilter(String typeFilter) {
        this.set(FIELD_TYPEFILTER, typeFilter);
    }

    @JsonIgnore
    public boolean isTypeFilterDirty() {
        return this.contains(FIELD_TYPEFILTER);
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
        return this.getPSDESARSId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDESARSId(strValue);
    }
}

