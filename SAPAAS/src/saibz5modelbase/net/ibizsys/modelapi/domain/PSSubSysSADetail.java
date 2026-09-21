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
import net.ibizsys.modelapi.domain.PSSubSysSADetailParam;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSubSysSADetail
extends PSModelBase {
    public static final String FIELD_AFTERCODE = "aftercode";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DETAILID = "detailid";
    public static final String FIELD_DETAILPARAM = "detailparam";
    public static final String FIELD_DETAILPARAM2 = "detailparam2";
    public static final String FIELD_DETAILPARAMS = "detailparams";
    public static final String FIELD_DETAILTAG = "detailtag";
    public static final String FIELD_DETAILTAG2 = "detailtag2";
    public static final String FIELD_DETAILTYPE = "detailtype";
    public static final String FIELD_INPSSUBSYSSADEID = "inpssubsyssadeid";
    public static final String FIELD_INPSSUBSYSSADENAME = "inpssubsyssadename";
    public static final String FIELD_INPSSYSDYNAMODELID = "inpssysdynamodelid";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "inpssysdynamodelname";
    public static final String FIELD_KEYFIELDNAME = "keyfieldname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_METHODCODE = "methodcode";
    public static final String FIELD_NEEDRESOURCEKEY = "needresourcekey";
    public static final String FIELD_NOSERVICECODENAME = "noservicecodename";
    public static final String FIELD_OUTPSSUBSYSSADEID = "outpssubsyssadeid";
    public static final String FIELD_OUTPSSUBSYSSADENAME = "outpssubsyssadename";
    public static final String FIELD_OUTPSSYSDYNAMODELID = "outpssysdynamodelid";
    public static final String FIELD_OUTPSSYSDYNAMODELNAME = "outpssysdynamodelname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSADETAILID = "pssubsyssadetailid";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "pssubsyssadetailname";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_REQUESTCONTENTTYPE = "requestcontenttype";
    public static final String FIELD_REQUESTMETHOD = "requestmethod";
    public static final String FIELD_REQUESTPARAMTYPE = "requestparamtype";
    public static final String FIELD_RETPSSUBSYSSADEID = "retpssubsyssadeid";
    public static final String FIELD_RETPSSUBSYSSADENAME = "retpssubsyssadename";
    public static final String FIELD_RETSTDDATATYPE = "retstddatatype";
    public static final String FIELD_RETVALTYPE = "retvaltype";
    public static final String FIELD_SERVICEURL = "serviceurl";
    public static final String FIELD_UNIQUETAG = "uniquetag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSubSysSADetailParam> pssubsyssadetailparams;

    @JsonIgnore
    public String getAfterCode() {
        Object objValue = this.get(FIELD_AFTERCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aftercode")
    public void setAfterCode(String afterCode) {
        this.set(FIELD_AFTERCODE, afterCode);
    }

    @JsonIgnore
    public boolean isAfterCodeDirty() {
        return this.contains(FIELD_AFTERCODE);
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
    public String getDetailId() {
        Object objValue = this.get(FIELD_DETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailid")
    public void setDetailId(String detailId) {
        this.set(FIELD_DETAILID, detailId);
    }

    @JsonIgnore
    public boolean isDetailIdDirty() {
        return this.contains(FIELD_DETAILID);
    }

    @JsonIgnore
    public String getDetailParam() {
        Object objValue = this.get(FIELD_DETAILPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailparam")
    public void setDetailParam(String detailParam) {
        this.set(FIELD_DETAILPARAM, detailParam);
    }

    @JsonIgnore
    public boolean isDetailParamDirty() {
        return this.contains(FIELD_DETAILPARAM);
    }

    @JsonIgnore
    public String getDetailParam2() {
        Object objValue = this.get(FIELD_DETAILPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailparam2")
    public void setDetailParam2(String detailParam2) {
        this.set(FIELD_DETAILPARAM2, detailParam2);
    }

    @JsonIgnore
    public boolean isDetailParam2Dirty() {
        return this.contains(FIELD_DETAILPARAM2);
    }

    @JsonIgnore
    public String getDetailParams() {
        Object objValue = this.get(FIELD_DETAILPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailparams")
    public void setDetailParams(String detailParams) {
        this.set(FIELD_DETAILPARAMS, detailParams);
    }

    @JsonIgnore
    public boolean isDetailParamsDirty() {
        return this.contains(FIELD_DETAILPARAMS);
    }

    @JsonIgnore
    public String getDetailTag() {
        Object objValue = this.get(FIELD_DETAILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag")
    public void setDetailTag(String detailTag) {
        this.set(FIELD_DETAILTAG, detailTag);
    }

    @JsonIgnore
    public boolean isDetailTagDirty() {
        return this.contains(FIELD_DETAILTAG);
    }

    @JsonIgnore
    public String getDetailTag2() {
        Object objValue = this.get(FIELD_DETAILTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag2")
    public void setDetailTag2(String detailTag2) {
        this.set(FIELD_DETAILTAG2, detailTag2);
    }

    @JsonIgnore
    public boolean isDetailTag2Dirty() {
        return this.contains(FIELD_DETAILTAG2);
    }

    @JsonIgnore
    public String getDetailType() {
        Object objValue = this.get(FIELD_DETAILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtype")
    public void setDetailType(String detailType) {
        this.set(FIELD_DETAILTYPE, detailType);
    }

    @JsonIgnore
    public boolean isDetailTypeDirty() {
        return this.contains(FIELD_DETAILTYPE);
    }

    @JsonIgnore
    public String getInPSSubSysSADEId() {
        Object objValue = this.get(FIELD_INPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssubsyssadeid")
    public void setInPSSubSysSADEId(String inPSSubSysSADEId) {
        this.set(FIELD_INPSSUBSYSSADEID, inPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isInPSSubSysSADEIdDirty() {
        return this.contains(FIELD_INPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getInPSSubSysSADEName() {
        Object objValue = this.get(FIELD_INPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssubsyssadename")
    public void setInPSSubSysSADEName(String inPSSubSysSADEName) {
        this.set(FIELD_INPSSUBSYSSADENAME, inPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isInPSSubSysSADENameDirty() {
        return this.contains(FIELD_INPSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getInPSSysDynaModelId() {
        Object objValue = this.get(FIELD_INPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssysdynamodelid")
    public void setInPSSysDynaModelId(String inPSSysDynaModelId) {
        this.set(FIELD_INPSSYSDYNAMODELID, inPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isInPSSysDynaModelIdDirty() {
        return this.contains(FIELD_INPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getInPSSysDynaModelName() {
        Object objValue = this.get(FIELD_INPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpssysdynamodelname")
    public void setInPSSysDynaModelName(String inPSSysDynaModelName) {
        this.set(FIELD_INPSSYSDYNAMODELNAME, inPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isInPSSysDynaModelNameDirty() {
        return this.contains(FIELD_INPSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getKeyFieldName() {
        Object objValue = this.get(FIELD_KEYFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keyfieldname")
    public void setKeyFieldName(String keyFieldName) {
        this.set(FIELD_KEYFIELDNAME, keyFieldName);
    }

    @JsonIgnore
    public boolean isKeyFieldNameDirty() {
        return this.contains(FIELD_KEYFIELDNAME);
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
    public String getMethodCode() {
        Object objValue = this.get(FIELD_METHODCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="methodcode")
    public void setMethodCode(String methodCode) {
        this.set(FIELD_METHODCODE, methodCode);
    }

    @JsonIgnore
    public boolean isMethodCodeDirty() {
        return this.contains(FIELD_METHODCODE);
    }

    @JsonIgnore
    public Integer getNeedResourceKey() {
        Object objValue = this.get(FIELD_NEEDRESOURCEKEY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="needresourcekey")
    public void setNeedResourceKey(Integer needResourceKey) {
        this.set(FIELD_NEEDRESOURCEKEY, needResourceKey);
    }

    @JsonIgnore
    public boolean isNeedResourceKeyDirty() {
        return this.contains(FIELD_NEEDRESOURCEKEY);
    }

    @JsonIgnore
    public Integer getNoServiceCodeName() {
        Object objValue = this.get(FIELD_NOSERVICECODENAME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noservicecodename")
    public void setNoServiceCodeName(Integer noServiceCodeName) {
        this.set(FIELD_NOSERVICECODENAME, noServiceCodeName);
    }

    @JsonIgnore
    public boolean isNoServiceCodeNameDirty() {
        return this.contains(FIELD_NOSERVICECODENAME);
    }

    @JsonIgnore
    public String getOutPSSubSysSADEId() {
        Object objValue = this.get(FIELD_OUTPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssubsyssadeid")
    public void setOutPSSubSysSADEId(String outPSSubSysSADEId) {
        this.set(FIELD_OUTPSSUBSYSSADEID, outPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isOutPSSubSysSADEIdDirty() {
        return this.contains(FIELD_OUTPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getOutPSSubSysSADEName() {
        Object objValue = this.get(FIELD_OUTPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssubsyssadename")
    public void setOutPSSubSysSADEName(String outPSSubSysSADEName) {
        this.set(FIELD_OUTPSSUBSYSSADENAME, outPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isOutPSSubSysSADENameDirty() {
        return this.contains(FIELD_OUTPSSUBSYSSADENAME);
    }

    @JsonIgnore
    public String getOutPSSysDynaModelId() {
        Object objValue = this.get(FIELD_OUTPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssysdynamodelid")
    public void setOutPSSysDynaModelId(String outPSSysDynaModelId) {
        this.set(FIELD_OUTPSSYSDYNAMODELID, outPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isOutPSSysDynaModelIdDirty() {
        return this.contains(FIELD_OUTPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getOutPSSysDynaModelName() {
        Object objValue = this.get(FIELD_OUTPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpssysdynamodelname")
    public void setOutPSSysDynaModelName(String outPSSysDynaModelName) {
        this.set(FIELD_OUTPSSYSDYNAMODELNAME, outPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isOutPSSysDynaModelNameDirty() {
        return this.contains(FIELD_OUTPSSYSDYNAMODELNAME);
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
    public String getPSSubSysSADetailId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadetailid")
    public void setPSSubSysSADetailId(String pSSubSysSADetailId) {
        this.set(FIELD_PSSUBSYSSADETAILID, pSSubSysSADetailId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADetailIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADETAILID);
    }

    @JsonIgnore
    public String getPSSubSysSADetailName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadetailname")
    public void setPSSubSysSADetailName(String pSSubSysSADetailName) {
        this.set(FIELD_PSSUBSYSSADETAILNAME, pSSubSysSADetailName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADetailNameDirty() {
        return this.contains(FIELD_PSSUBSYSSADETAILNAME);
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
    public String getRequestContentType() {
        Object objValue = this.get(FIELD_REQUESTCONTENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestcontenttype")
    public void setRequestContentType(String requestContentType) {
        this.set(FIELD_REQUESTCONTENTTYPE, requestContentType);
    }

    @JsonIgnore
    public boolean isRequestContentTypeDirty() {
        return this.contains(FIELD_REQUESTCONTENTTYPE);
    }

    @JsonIgnore
    public String getRequestMethod() {
        Object objValue = this.get(FIELD_REQUESTMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestmethod")
    public void setRequestMethod(String requestMethod) {
        this.set(FIELD_REQUESTMETHOD, requestMethod);
    }

    @JsonIgnore
    public boolean isRequestMethodDirty() {
        return this.contains(FIELD_REQUESTMETHOD);
    }

    @JsonIgnore
    public String getRequestParamType() {
        Object objValue = this.get(FIELD_REQUESTPARAMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestparamtype")
    public void setRequestParamType(String requestParamType) {
        this.set(FIELD_REQUESTPARAMTYPE, requestParamType);
    }

    @JsonIgnore
    public boolean isRequestParamTypeDirty() {
        return this.contains(FIELD_REQUESTPARAMTYPE);
    }

    @JsonIgnore
    public String getRetPSSubSysSADEId() {
        Object objValue = this.get(FIELD_RETPSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retpssubsyssadeid")
    public void setRetPSSubSysSADEId(String retPSSubSysSADEId) {
        this.set(FIELD_RETPSSUBSYSSADEID, retPSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isRetPSSubSysSADEIdDirty() {
        return this.contains(FIELD_RETPSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getRetPSSubSysSADEName() {
        Object objValue = this.get(FIELD_RETPSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retpssubsyssadename")
    public void setRetPSSubSysSADEName(String retPSSubSysSADEName) {
        this.set(FIELD_RETPSSUBSYSSADENAME, retPSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isRetPSSubSysSADENameDirty() {
        return this.contains(FIELD_RETPSSUBSYSSADENAME);
    }

    @JsonIgnore
    public Integer getRetStdDataType() {
        Object objValue = this.get(FIELD_RETSTDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="retstddatatype")
    public void setRetStdDataType(Integer retStdDataType) {
        this.set(FIELD_RETSTDDATATYPE, retStdDataType);
    }

    @JsonIgnore
    public boolean isRetStdDataTypeDirty() {
        return this.contains(FIELD_RETSTDDATATYPE);
    }

    @JsonIgnore
    public String getRetValType() {
        Object objValue = this.get(FIELD_RETVALTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retvaltype")
    public void setRetValType(String retValType) {
        this.set(FIELD_RETVALTYPE, retValType);
    }

    @JsonIgnore
    public boolean isRetValTypeDirty() {
        return this.contains(FIELD_RETVALTYPE);
    }

    @JsonIgnore
    public String getServiceUrl() {
        Object objValue = this.get(FIELD_SERVICEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceurl")
    public void setServiceUrl(String serviceUrl) {
        this.set(FIELD_SERVICEURL, serviceUrl);
    }

    @JsonIgnore
    public boolean isServiceUrlDirty() {
        return this.contains(FIELD_SERVICEURL);
    }

    @JsonIgnore
    public String getUniqueTag() {
        Object objValue = this.get(FIELD_UNIQUETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uniquetag")
    public void setUniqueTag(String uniqueTag) {
        this.set(FIELD_UNIQUETAG, uniqueTag);
    }

    @JsonIgnore
    public boolean isUniqueTagDirty() {
        return this.contains(FIELD_UNIQUETAG);
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
        return this.getPSSubSysSADetailId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSubSysSADetailId(strValue);
    }

    public List<PSSubSysSADetailParam> getPssubsyssadetailparams() {
        return this.pssubsyssadetailparams;
    }

    public void setPssubsyssadetailparams(List<PSSubSysSADetailParam> pssubsyssadetailparams) {
        this.pssubsyssadetailparams = pssubsyssadetailparams;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssubsyssadetailparams")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssubsyssadetailparams")) {
            this.init();
            return this.pssubsyssadetailparams;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSUBSYSSADETAIL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSubSysSADetail item = (PSSubSysSADetail)MAPPER.readValue(new File(strJsonFilePath), PSSubSysSADetail.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSubSysSADetail) {
            PSSubSysSADetail dst = (PSSubSysSADetail)target;
            if (!bSimple && this.getPssubsyssadetailparams() != null) {
                ArrayList<PSSubSysSADetailParam> pssubsyssadetailparams = new ArrayList<PSSubSysSADetailParam>();
                for (PSSubSysSADetailParam item : this.getPssubsyssadetailparams()) {
                    if (bDeepMode) {
                        PSSubSysSADetailParam newitem = new PSSubSysSADetailParam();
                        item.to(newitem, false, bDeepMode);
                        pssubsyssadetailparams.add(newitem);
                        continue;
                    }
                    pssubsyssadetailparams.add(item);
                }
                dst.setPssubsyssadetailparams(pssubsyssadetailparams);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSubSysSADetail) {
            PSSubSysSADetail src = (PSSubSysSADetail)source;
            if (!bSimple && src.getPssubsyssadetailparams() != null) {
                ArrayList<PSSubSysSADetailParam> pssubsyssadetailparams = new ArrayList<PSSubSysSADetailParam>();
                for (PSSubSysSADetailParam item : src.getPssubsyssadetailparams()) {
                    if (bDeepMode) {
                        PSSubSysSADetailParam newItem = new PSSubSysSADetailParam();
                        newItem.from(item, false, bDeepMode);
                        pssubsyssadetailparams.add(newItem);
                        continue;
                    }
                    pssubsyssadetailparams.add(item);
                }
                this.setPssubsyssadetailparams(pssubsyssadetailparams);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

