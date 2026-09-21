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
import net.ibizsys.modelapi.domain.PSDESADetailParam;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDESADetail
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DETAILPARAM = "detailparam";
    public static final String FIELD_DETAILPARAM2 = "detailparam2";
    public static final String FIELD_DETAILTYPE = "detailtype";
    public static final String FIELD_INPSDESERVICEAPIID = "inpsdeserviceapiid";
    public static final String FIELD_INPSDESERVICEAPINAME = "inpsdeserviceapiname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_METHODTAG = "methodtag";
    public static final String FIELD_NEEDRESOURCEKEY = "needresourcekey";
    public static final String FIELD_NOSERVICECODENAME = "noservicecodename";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_OUTPSDESERVICEAPIID = "outpsdeserviceapiid";
    public static final String FIELD_OUTPSDESERVICEAPINAME = "outpsdeserviceapiname";
    public static final String FIELD_PARENTKEYMODE = "parentkeymode";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDESADETAILID = "psdesadetailid";
    public static final String FIELD_PSDESADETAILNAME = "psdesadetailname";
    public static final String FIELD_PSDESARSID = "psdesarsid";
    public static final String FIELD_PSDESARSNAME = "psdesarsname";
    public static final String FIELD_PSDESERVICEAPIID = "psdeserviceapiid";
    public static final String FIELD_PSDESERVICEAPINAME = "psdeserviceapiname";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_REQUESTFIELD = "requestfield";
    public static final String FIELD_REQUESTMETHOD = "requestmethod";
    public static final String FIELD_REQUESTPARAMTYPE = "requestparamtype";
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
    private List<PSDESADetailParam> psdesadetailparams;

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
    public String getInPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_INPSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdeserviceapiid")
    public void setInPSDEServiceAPIId(String inPSDEServiceAPIId) {
        this.set(FIELD_INPSDESERVICEAPIID, inPSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isInPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_INPSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getInPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_INPSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdeserviceapiname")
    public void setInPSDEServiceAPIName(String inPSDEServiceAPIName) {
        this.set(FIELD_INPSDESERVICEAPINAME, inPSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isInPSDEServiceAPINameDirty() {
        return this.contains(FIELD_INPSDESERVICEAPINAME);
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
    public String getMethodTag() {
        Object objValue = this.get(FIELD_METHODTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="methodtag")
    public void setMethodTag(String methodTag) {
        this.set(FIELD_METHODTAG, methodTag);
    }

    @JsonIgnore
    public boolean isMethodTagDirty() {
        return this.contains(FIELD_METHODTAG);
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
    public String getOutPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_OUTPSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdeserviceapiid")
    public void setOutPSDEServiceAPIId(String outPSDEServiceAPIId) {
        this.set(FIELD_OUTPSDESERVICEAPIID, outPSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isOutPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_OUTPSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getOutPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_OUTPSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdeserviceapiname")
    public void setOutPSDEServiceAPIName(String outPSDEServiceAPIName) {
        this.set(FIELD_OUTPSDESERVICEAPINAME, outPSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isOutPSDEServiceAPINameDirty() {
        return this.contains(FIELD_OUTPSDESERVICEAPINAME);
    }

    @JsonIgnore
    public String getParentKeyMode() {
        Object objValue = this.get(FIELD_PARENTKEYMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="parentkeymode")
    public void setParentKeyMode(String parentKeyMode) {
        this.set(FIELD_PARENTKEYMODE, parentKeyMode);
    }

    @JsonIgnore
    public boolean isParentKeyModeDirty() {
        return this.contains(FIELD_PARENTKEYMODE);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
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
    public String getPSDEOPPrivId() {
        Object objValue = this.get(FIELD_PSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivid")
    public void setPSDEOPPrivId(String pSDEOPPrivId) {
        this.set(FIELD_PSDEOPPRIVID, pSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivIdDirty() {
        return this.contains(FIELD_PSDEOPPRIVID);
    }

    @JsonIgnore
    public String getPSDEOPPrivName() {
        Object objValue = this.get(FIELD_PSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeopprivname")
    public void setPSDEOPPrivName(String pSDEOPPrivName) {
        this.set(FIELD_PSDEOPPRIVNAME, pSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isPSDEOPPrivNameDirty() {
        return this.contains(FIELD_PSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getPSDESADetailId() {
        Object objValue = this.get(FIELD_PSDESADETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesadetailid")
    public void setPSDESADetailId(String pSDESADetailId) {
        this.set(FIELD_PSDESADETAILID, pSDESADetailId);
    }

    @JsonIgnore
    public boolean isPSDESADetailIdDirty() {
        return this.contains(FIELD_PSDESADETAILID);
    }

    @JsonIgnore
    public String getPSDESADetailName() {
        Object objValue = this.get(FIELD_PSDESADETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesadetailname")
    public void setPSDESADetailName(String pSDESADetailName) {
        this.set(FIELD_PSDESADETAILNAME, pSDESADetailName);
    }

    @JsonIgnore
    public boolean isPSDESADetailNameDirty() {
        return this.contains(FIELD_PSDESADETAILNAME);
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
    public String getPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_PSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiid")
    public void setPSDEServiceAPIId(String pSDEServiceAPIId) {
        this.set(FIELD_PSDESERVICEAPIID, pSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_PSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_PSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiname")
    public void setPSDEServiceAPIName(String pSDEServiceAPIName) {
        this.set(FIELD_PSDESERVICEAPINAME, pSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPINameDirty() {
        return this.contains(FIELD_PSDESERVICEAPINAME);
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
    public String getRequestField() {
        Object objValue = this.get(FIELD_REQUESTFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestfield")
    public void setRequestField(String requestField) {
        this.set(FIELD_REQUESTFIELD, requestField);
    }

    @JsonIgnore
    public boolean isRequestFieldDirty() {
        return this.contains(FIELD_REQUESTFIELD);
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
        return this.getPSDESADetailId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDESADetailId(strValue);
    }

    public List<PSDESADetailParam> getPsdesadetailparams() {
        return this.psdesadetailparams;
    }

    public void setPsdesadetailparams(List<PSDESADetailParam> psdesadetailparams) {
        this.psdesadetailparams = psdesadetailparams;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdesadetailparams")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdesadetailparams")) {
            this.init();
            return this.psdesadetailparams;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDESADETAIL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDESADetail item = (PSDESADetail)MAPPER.readValue(new File(strJsonFilePath), PSDESADetail.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDESADetail) {
            PSDESADetail dst = (PSDESADetail)target;
            if (!bSimple && this.getPsdesadetailparams() != null) {
                ArrayList<PSDESADetailParam> psdesadetailparams = new ArrayList<PSDESADetailParam>();
                for (PSDESADetailParam item : this.getPsdesadetailparams()) {
                    if (bDeepMode) {
                        PSDESADetailParam newitem = new PSDESADetailParam();
                        item.to(newitem, false, bDeepMode);
                        psdesadetailparams.add(newitem);
                        continue;
                    }
                    psdesadetailparams.add(item);
                }
                dst.setPsdesadetailparams(psdesadetailparams);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDESADetail) {
            PSDESADetail src = (PSDESADetail)source;
            if (!bSimple && src.getPsdesadetailparams() != null) {
                ArrayList<PSDESADetailParam> psdesadetailparams = new ArrayList<PSDESADetailParam>();
                for (PSDESADetailParam item : src.getPsdesadetailparams()) {
                    if (bDeepMode) {
                        PSDESADetailParam newItem = new PSDESADetailParam();
                        newItem.from(item, false, bDeepMode);
                        psdesadetailparams.add(newItem);
                        continue;
                    }
                    psdesadetailparams.add(item);
                }
                this.setPsdesadetailparams(psdesadetailparams);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

