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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDELogicParam
extends PSModelBase {
    public static final String FIELD_CLONEPARAMFLAG = "cloneparamflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPARAM = "defaultparam";
    public static final String FIELD_DEFAULTVALUE = "defaultvalue";
    public static final String FIELD_DEFAULTVALUETYPE = "defaultvaluetype";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_FILETYPE = "filetype";
    public static final String FIELD_FILEURL = "fileurl";
    public static final String FIELD_GLOBALPARAM = "globalparam";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORIGINENTITYFLAG = "originentityflag";
    public static final String FIELD_PARAMPSDEID = "parampsdeid";
    public static final String FIELD_PARAMPSDENAME = "parampsdename";
    public static final String FIELD_PARAMS = "params";
    public static final String FIELD_PARAMTAG = "paramtag";
    public static final String FIELD_PARAMTAG2 = "paramtag2";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDELOGICPARAMID = "psdelogicparamid";
    public static final String FIELD_PSDELOGICPARAMNAME = "psdelogicparamname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_REFFIELDNAME = "reffieldname";
    public static final String FIELD_REFPARAMNAME = "refparamname";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public Integer getCloneParamFlag() {
        Object objValue = this.get(FIELD_CLONEPARAMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cloneparamflag")
    public void setCloneParamFlag(Integer cloneParamFlag) {
        this.set(FIELD_CLONEPARAMFLAG, cloneParamFlag);
    }

    @JsonIgnore
    public boolean isCloneParamFlagDirty() {
        return this.contains(FIELD_CLONEPARAMFLAG);
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
    public Integer getDefaultParam() {
        Object objValue = this.get(FIELD_DEFAULTPARAM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultparam")
    public void setDefaultParam(Integer defaultParam) {
        this.set(FIELD_DEFAULTPARAM, defaultParam);
    }

    @JsonIgnore
    public boolean isDefaultParamDirty() {
        return this.contains(FIELD_DEFAULTPARAM);
    }

    @JsonIgnore
    public String getDefaultValue() {
        Object objValue = this.get(FIELD_DEFAULTVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultvalue")
    public void setDefaultValue(String defaultValue) {
        this.set(FIELD_DEFAULTVALUE, defaultValue);
    }

    @JsonIgnore
    public boolean isDefaultValueDirty() {
        return this.contains(FIELD_DEFAULTVALUE);
    }

    @JsonIgnore
    public String getDefaultValueType() {
        Object objValue = this.get(FIELD_DEFAULTVALUETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultvaluetype")
    public void setDefaultValueType(String defaultValueType) {
        this.set(FIELD_DEFAULTVALUETYPE, defaultValueType);
    }

    @JsonIgnore
    public boolean isDefaultValueTypeDirty() {
        return this.contains(FIELD_DEFAULTVALUETYPE);
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
    public String getFileType() {
        Object objValue = this.get(FIELD_FILETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filetype")
    public void setFileType(String fileType) {
        this.set(FIELD_FILETYPE, fileType);
    }

    @JsonIgnore
    public boolean isFileTypeDirty() {
        return this.contains(FIELD_FILETYPE);
    }

    @JsonIgnore
    public String getFileUrl() {
        Object objValue = this.get(FIELD_FILEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fileurl")
    public void setFileUrl(String fileUrl) {
        this.set(FIELD_FILEURL, fileUrl);
    }

    @JsonIgnore
    public boolean isFileUrlDirty() {
        return this.contains(FIELD_FILEURL);
    }

    @JsonIgnore
    public Integer getGlobalParam() {
        Object objValue = this.get(FIELD_GLOBALPARAM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="globalparam")
    public void setGlobalParam(Integer globalParam) {
        this.set(FIELD_GLOBALPARAM, globalParam);
    }

    @JsonIgnore
    public boolean isGlobalParamDirty() {
        return this.contains(FIELD_GLOBALPARAM);
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
    public Integer getOriginEntityFlag() {
        Object objValue = this.get(FIELD_ORIGINENTITYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="originentityflag")
    public void setOriginEntityFlag(Integer originEntityFlag) {
        this.set(FIELD_ORIGINENTITYFLAG, originEntityFlag);
    }

    @JsonIgnore
    public boolean isOriginEntityFlagDirty() {
        return this.contains(FIELD_ORIGINENTITYFLAG);
    }

    @JsonIgnore
    public String getParamPSDEId() {
        Object objValue = this.get(FIELD_PARAMPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="parampsdeid")
    public void setParamPSDEId(String paramPSDEId) {
        this.set(FIELD_PARAMPSDEID, paramPSDEId);
    }

    @JsonIgnore
    public boolean isParamPSDEIdDirty() {
        return this.contains(FIELD_PARAMPSDEID);
    }

    @JsonIgnore
    public String getParamPSDEName() {
        Object objValue = this.get(FIELD_PARAMPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="parampsdename")
    public void setParamPSDEName(String paramPSDEName) {
        this.set(FIELD_PARAMPSDENAME, paramPSDEName);
    }

    @JsonIgnore
    public boolean isParamPSDENameDirty() {
        return this.contains(FIELD_PARAMPSDENAME);
    }

    @JsonIgnore
    public String getParams() {
        Object objValue = this.get(FIELD_PARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="params")
    public void setParams(String params) {
        this.set(FIELD_PARAMS, params);
    }

    @JsonIgnore
    public boolean isParamsDirty() {
        return this.contains(FIELD_PARAMS);
    }

    @JsonIgnore
    public String getParamTag() {
        Object objValue = this.get(FIELD_PARAMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag")
    public void setParamTag(String paramTag) {
        this.set(FIELD_PARAMTAG, paramTag);
    }

    @JsonIgnore
    public boolean isParamTagDirty() {
        return this.contains(FIELD_PARAMTAG);
    }

    @JsonIgnore
    public String getParamTag2() {
        Object objValue = this.get(FIELD_PARAMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramtag2")
    public void setParamTag2(String paramTag2) {
        this.set(FIELD_PARAMTAG2, paramTag2);
    }

    @JsonIgnore
    public boolean isParamTag2Dirty() {
        return this.contains(FIELD_PARAMTAG2);
    }

    @JsonIgnore
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
    }

    @JsonIgnore
    public String getPSDELogicParamId() {
        Object objValue = this.get(FIELD_PSDELOGICPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicparamid")
    public void setPSDELogicParamId(String pSDELogicParamId) {
        this.set(FIELD_PSDELOGICPARAMID, pSDELogicParamId);
    }

    @JsonIgnore
    public boolean isPSDELogicParamIdDirty() {
        return this.contains(FIELD_PSDELOGICPARAMID);
    }

    @JsonIgnore
    public String getPSDELogicParamName() {
        Object objValue = this.get(FIELD_PSDELOGICPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicparamname")
    public void setPSDELogicParamName(String pSDELogicParamName) {
        this.set(FIELD_PSDELOGICPARAMNAME, pSDELogicParamName);
    }

    @JsonIgnore
    public boolean isPSDELogicParamNameDirty() {
        return this.contains(FIELD_PSDELOGICPARAMNAME);
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
    public String getRefFieldName() {
        Object objValue = this.get(FIELD_REFFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reffieldname")
    public void setRefFieldName(String refFieldName) {
        this.set(FIELD_REFFIELDNAME, refFieldName);
    }

    @JsonIgnore
    public boolean isRefFieldNameDirty() {
        return this.contains(FIELD_REFFIELDNAME);
    }

    @JsonIgnore
    public String getRefParamName() {
        Object objValue = this.get(FIELD_REFPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparamname")
    public void setRefParamName(String refParamName) {
        this.set(FIELD_REFPARAMNAME, refParamName);
    }

    @JsonIgnore
    public boolean isRefParamNameDirty() {
        return this.contains(FIELD_REFPARAMNAME);
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
    public String getSrfkey() {
        return this.getPSDELogicParamId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDELogicParamId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDELOGICPARAM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDELogicParam item = (PSDELogicParam)MAPPER.readValue(new File(strJsonFilePath), PSDELogicParam.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDELogicParam) {
            PSDELogicParam pSDELogicParam = (PSDELogicParam)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDELogicParam) {
            PSDELogicParam pSDELogicParam = (PSDELogicParam)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

