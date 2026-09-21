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
import java.util.List;
import net.ibizsys.modelapi.dto.PSDEActionParamDTO;
import net.ibizsys.modelapi.dto.PSDEActionVRDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEActionDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONHOLDER = "actionholder";
    public static final String FIELD_ACTIONMODE = "actionmode";
    public static final String FIELD_ACTIONTAG = "actiontag";
    public static final String FIELD_ACTIONTAG2 = "actiontag2";
    public static final String FIELD_ACTIONTAG3 = "actiontag3";
    public static final String FIELD_ACTIONTAG4 = "actiontag4";
    public static final String FIELD_ACTIONTYPE = "actiontype";
    public static final String FIELD_AFTERCODE = "aftercode";
    public static final String FIELD_BATCHACTIONMODE = "batchactionmode";
    public static final String FIELD_BEFORECODE = "beforecode";
    public static final String FIELD_CACHECAT = "cachecat";
    public static final String FIELD_CACHESCOPE = "cachescope";
    public static final String FIELD_CACHETAG = "cachetag";
    public static final String FIELD_CACHETIMEOUT = "cachetimeout";
    public static final String FIELD_CALLEROBJ = "callerobj";
    public static final String FIELD_CALLTIMEOUT = "calltimeout";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLECACHE = "enablecache";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FINISHFLAG = "finishflag";
    public static final String FIELD_INPSDEFGROUPID = "inpsdefgroupid";
    public static final String FIELD_INPSDEFGROUPNAME = "inpsdefgroupname";
    public static final String FIELD_INPSSYSDYNAMODELID = "inpssysdynamodelid";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "inpssysdynamodelname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_OUTPSDEFGROUPID = "outpsdefgroupid";
    public static final String FIELD_OUTPSDEFGROUPNAME = "outpsdefgroupname";
    public static final String FIELD_OUTPSSYSDYNAMODELID = "outpssysdynamodelid";
    public static final String FIELD_OUTPSSYSDYNAMODELNAME = "outpssysdynamodelname";
    public static final String FIELD_OUTREFPSDEFGROUPID = "outrefpsdefgroupid";
    public static final String FIELD_OUTREFPSDEFGROUPNAME = "outrefpsdefgroupname";
    public static final String FIELD_OUTREFPSDEID = "outrefpsdeid";
    public static final String FIELD_OUTREFPSDENAME = "outrefpsdename";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_POTIME = "potime";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PREPARELAST = "preparelast";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEACTIONTEMPLID = "psdeactiontemplid";
    public static final String FIELD_PSDEACTIONTEMPLNAME = "psdeactiontemplname";
    public static final String FIELD_PSDEDATAQUERYID = "psdedataqueryid";
    public static final String FIELD_PSDEDATAQUERYNAME = "psdedataqueryname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSDESYSPROCID = "psdesysprocid";
    public static final String FIELD_PSDESYSPROCNAME = "psdesysprocname";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADETAILID = "pssubsyssadetailid";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "pssubsyssadetailname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTASKID = "pssystaskid";
    public static final String FIELD_PSSYSTASKNAME = "pssystaskname";
    public static final String FIELD_PUBMODE = "pubmode";
    public static final String FIELD_RAWSERVICEMETHOD = "rawservicemethod";
    public static final String FIELD_RAWSERVICEURL = "rawserviceurl";
    public static final String FIELD_REQUESTFIELD = "requestfield";
    public static final String FIELD_REQUESTMETHOD = "requestmethod";
    public static final String FIELD_REQUESTPARAMTYPE = "requestparamtype";
    public static final String FIELD_REQUESTPATH = "requestpath";
    public static final String FIELD_RETSTDDATATYPE = "retstddatatype";
    public static final String FIELD_RETVALTYPE = "retvaltype";
    public static final String FIELD_TESTACTIONMODE = "testactionmode";
    public static final String FIELD_TESTCASEFLAG = "testcaseflag";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_TSMODE = "tsmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDEActionParamDTO> psdeactionparams;
    private List<PSDEActionVRDTO> psdeactionvrs;

    @JsonIgnore
    public Integer getActionHolder() {
        Object objValue = this.get(FIELD_ACTIONHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionholder")
    public void setActionHolder(Integer actionHolder) {
        this.set(FIELD_ACTIONHOLDER, actionHolder);
    }

    @JsonIgnore
    public boolean isActionHolderDirty() {
        return this.contains(FIELD_ACTIONHOLDER);
    }

    @JsonIgnore
    public String getActionMode() {
        Object objValue = this.get(FIELD_ACTIONMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionmode")
    public void setActionMode(String actionMode) {
        this.set(FIELD_ACTIONMODE, actionMode);
    }

    @JsonIgnore
    public boolean isActionModeDirty() {
        return this.contains(FIELD_ACTIONMODE);
    }

    @JsonIgnore
    public String getActionTag() {
        Object objValue = this.get(FIELD_ACTIONTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontag")
    public void setActionTag(String actionTag) {
        this.set(FIELD_ACTIONTAG, actionTag);
    }

    @JsonIgnore
    public boolean isActionTagDirty() {
        return this.contains(FIELD_ACTIONTAG);
    }

    @JsonIgnore
    public String getActionTag2() {
        Object objValue = this.get(FIELD_ACTIONTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontag2")
    public void setActionTag2(String actionTag2) {
        this.set(FIELD_ACTIONTAG2, actionTag2);
    }

    @JsonIgnore
    public boolean isActionTag2Dirty() {
        return this.contains(FIELD_ACTIONTAG2);
    }

    @JsonIgnore
    public String getActionTag3() {
        Object objValue = this.get(FIELD_ACTIONTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontag3")
    public void setActionTag3(String actionTag3) {
        this.set(FIELD_ACTIONTAG3, actionTag3);
    }

    @JsonIgnore
    public boolean isActionTag3Dirty() {
        return this.contains(FIELD_ACTIONTAG3);
    }

    @JsonIgnore
    public String getActionTag4() {
        Object objValue = this.get(FIELD_ACTIONTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontag4")
    public void setActionTag4(String actionTag4) {
        this.set(FIELD_ACTIONTAG4, actionTag4);
    }

    @JsonIgnore
    public boolean isActionTag4Dirty() {
        return this.contains(FIELD_ACTIONTAG4);
    }

    @JsonIgnore
    public String getActionType() {
        Object objValue = this.get(FIELD_ACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actiontype")
    public void setActionType(String actionType) {
        this.set(FIELD_ACTIONTYPE, actionType);
    }

    @JsonIgnore
    public boolean isActionTypeDirty() {
        return this.contains(FIELD_ACTIONTYPE);
    }

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
    public Integer getBatchActionMode() {
        Object objValue = this.get(FIELD_BATCHACTIONMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="batchactionmode")
    public void setBatchActionMode(Integer batchActionMode) {
        this.set(FIELD_BATCHACTIONMODE, batchActionMode);
    }

    @JsonIgnore
    public boolean isBatchActionModeDirty() {
        return this.contains(FIELD_BATCHACTIONMODE);
    }

    @JsonIgnore
    public String getBeforeCode() {
        Object objValue = this.get(FIELD_BEFORECODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="beforecode")
    public void setBeforeCode(String beforeCode) {
        this.set(FIELD_BEFORECODE, beforeCode);
    }

    @JsonIgnore
    public boolean isBeforeCodeDirty() {
        return this.contains(FIELD_BEFORECODE);
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
    public String getCacheScope() {
        Object objValue = this.get(FIELD_CACHESCOPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachescope")
    public void setCacheScope(String cacheScope) {
        this.set(FIELD_CACHESCOPE, cacheScope);
    }

    @JsonIgnore
    public boolean isCacheScopeDirty() {
        return this.contains(FIELD_CACHESCOPE);
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
    public String getCallerObj() {
        Object objValue = this.get(FIELD_CALLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="callerobj")
    public void setCallerObj(String callerObj) {
        this.set(FIELD_CALLEROBJ, callerObj);
    }

    @JsonIgnore
    public boolean isCallerObjDirty() {
        return this.contains(FIELD_CALLEROBJ);
    }

    @JsonIgnore
    public Integer getCallTimeout() {
        Object objValue = this.get(FIELD_CALLTIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="calltimeout")
    public void setCallTimeout(Integer callTimeout) {
        this.set(FIELD_CALLTIMEOUT, callTimeout);
    }

    @JsonIgnore
    public boolean isCallTimeoutDirty() {
        return this.contains(FIELD_CALLTIMEOUT);
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
    public String getCustomCode() {
        Object objValue = this.get(FIELD_CUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcode")
    public void setCustomCode(String customCode) {
        this.set(FIELD_CUSTOMCODE, customCode);
    }

    @JsonIgnore
    public boolean isCustomCodeDirty() {
        return this.contains(FIELD_CUSTOMCODE);
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
    public Integer getFinishFlag() {
        Object objValue = this.get(FIELD_FINISHFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="finishflag")
    public void setFinishFlag(Integer finishFlag) {
        this.set(FIELD_FINISHFLAG, finishFlag);
    }

    @JsonIgnore
    public boolean isFinishFlagDirty() {
        return this.contains(FIELD_FINISHFLAG);
    }

    @JsonIgnore
    public String getInPSDEFGroupId() {
        Object objValue = this.get(FIELD_INPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdefgroupid")
    public void setInPSDEFGroupId(String inPSDEFGroupId) {
        this.set(FIELD_INPSDEFGROUPID, inPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isInPSDEFGroupIdDirty() {
        return this.contains(FIELD_INPSDEFGROUPID);
    }

    @JsonIgnore
    public String getInPSDEFGroupName() {
        Object objValue = this.get(FIELD_INPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="inpsdefgroupname")
    public void setInPSDEFGroupName(String inPSDEFGroupName) {
        this.set(FIELD_INPSDEFGROUPNAME, inPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isInPSDEFGroupNameDirty() {
        return this.contains(FIELD_INPSDEFGROUPNAME);
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
    public String getOutPSDEFGroupId() {
        Object objValue = this.get(FIELD_OUTPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdefgroupid")
    public void setOutPSDEFGroupId(String outPSDEFGroupId) {
        this.set(FIELD_OUTPSDEFGROUPID, outPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isOutPSDEFGroupIdDirty() {
        return this.contains(FIELD_OUTPSDEFGROUPID);
    }

    @JsonIgnore
    public String getOutPSDEFGroupName() {
        Object objValue = this.get(FIELD_OUTPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outpsdefgroupname")
    public void setOutPSDEFGroupName(String outPSDEFGroupName) {
        this.set(FIELD_OUTPSDEFGROUPNAME, outPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isOutPSDEFGroupNameDirty() {
        return this.contains(FIELD_OUTPSDEFGROUPNAME);
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
    public String getOutRefPSDEFGroupId() {
        Object objValue = this.get(FIELD_OUTREFPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outrefpsdefgroupid")
    public void setOutRefPSDEFGroupId(String outRefPSDEFGroupId) {
        this.set(FIELD_OUTREFPSDEFGROUPID, outRefPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isOutRefPSDEFGroupIdDirty() {
        return this.contains(FIELD_OUTREFPSDEFGROUPID);
    }

    @JsonIgnore
    public String getOutRefPSDEFGroupName() {
        Object objValue = this.get(FIELD_OUTREFPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outrefpsdefgroupname")
    public void setOutRefPSDEFGroupName(String outRefPSDEFGroupName) {
        this.set(FIELD_OUTREFPSDEFGROUPNAME, outRefPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isOutRefPSDEFGroupNameDirty() {
        return this.contains(FIELD_OUTREFPSDEFGROUPNAME);
    }

    @JsonIgnore
    public String getOutRefPSDEId() {
        Object objValue = this.get(FIELD_OUTREFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outrefpsdeid")
    public void setOutRefPSDEId(String outRefPSDEId) {
        this.set(FIELD_OUTREFPSDEID, outRefPSDEId);
    }

    @JsonIgnore
    public boolean isOutRefPSDEIdDirty() {
        return this.contains(FIELD_OUTREFPSDEID);
    }

    @JsonIgnore
    public String getOutRefPSDEName() {
        Object objValue = this.get(FIELD_OUTREFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="outrefpsdename")
    public void setOutRefPSDEName(String outRefPSDEName) {
        this.set(FIELD_OUTREFPSDENAME, outRefPSDEName);
    }

    @JsonIgnore
    public boolean isOutRefPSDENameDirty() {
        return this.contains(FIELD_OUTREFPSDENAME);
    }

    @JsonIgnore
    public Integer getParamType() {
        Object objValue = this.get(FIELD_PARAMTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paramtype")
    public void setParamType(Integer paramType) {
        this.set(FIELD_PARAMTYPE, paramType);
    }

    @JsonIgnore
    public boolean isParamTypeDirty() {
        return this.contains(FIELD_PARAMTYPE);
    }

    @JsonIgnore
    public Integer getPOTime() {
        Object objValue = this.get(FIELD_POTIME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="potime")
    public void setPOTime(Integer pOTime) {
        this.set(FIELD_POTIME, pOTime);
    }

    @JsonIgnore
    public boolean isPOTimeDirty() {
        return this.contains(FIELD_POTIME);
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
    public String getPredefinedTypeText() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtypetext")
    public void setPredefinedTypeText(String predefinedTypeText) {
        this.set(FIELD_PREDEFINEDTYPETEXT, predefinedTypeText);
    }

    @JsonIgnore
    public boolean isPredefinedTypeTextDirty() {
        return this.contains(FIELD_PREDEFINEDTYPETEXT);
    }

    @JsonIgnore
    public Integer getPrepareLast() {
        Object objValue = this.get(FIELD_PREPARELAST);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preparelast")
    public void setPrepareLast(Integer prepareLast) {
        this.set(FIELD_PREPARELAST, prepareLast);
    }

    @JsonIgnore
    public boolean isPrepareLastDirty() {
        return this.contains(FIELD_PREPARELAST);
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
    public String getPSDEActionTemplId() {
        Object objValue = this.get(FIELD_PSDEACTIONTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactiontemplid")
    public void setPSDEActionTemplId(String pSDEActionTemplId) {
        this.set(FIELD_PSDEACTIONTEMPLID, pSDEActionTemplId);
    }

    @JsonIgnore
    public boolean isPSDEActionTemplIdDirty() {
        return this.contains(FIELD_PSDEACTIONTEMPLID);
    }

    @JsonIgnore
    public String getPSDEActionTemplName() {
        Object objValue = this.get(FIELD_PSDEACTIONTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactiontemplname")
    public void setPSDEActionTemplName(String pSDEActionTemplName) {
        this.set(FIELD_PSDEACTIONTEMPLNAME, pSDEActionTemplName);
    }

    @JsonIgnore
    public boolean isPSDEActionTemplNameDirty() {
        return this.contains(FIELD_PSDEACTIONTEMPLNAME);
    }

    @JsonIgnore
    public String getPSDEDataQueryId() {
        Object objValue = this.get(FIELD_PSDEDATAQUERYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataqueryid")
    public void setPSDEDataQueryId(String pSDEDataQueryId) {
        this.set(FIELD_PSDEDATAQUERYID, pSDEDataQueryId);
    }

    @JsonIgnore
    public boolean isPSDEDataQueryIdDirty() {
        return this.contains(FIELD_PSDEDATAQUERYID);
    }

    @JsonIgnore
    public String getPSDEDataQueryName() {
        Object objValue = this.get(FIELD_PSDEDATAQUERYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataqueryname")
    public void setPSDEDataQueryName(String pSDEDataQueryName) {
        this.set(FIELD_PSDEDATAQUERYNAME, pSDEDataQueryName);
    }

    @JsonIgnore
    public boolean isPSDEDataQueryNameDirty() {
        return this.contains(FIELD_PSDEDATAQUERYNAME);
    }

    @JsonIgnore
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
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
    public String getPSDESysProcId() {
        Object objValue = this.get(FIELD_PSDESYSPROCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesysprocid")
    public void setPSDESysProcId(String pSDESysProcId) {
        this.set(FIELD_PSDESYSPROCID, pSDESysProcId);
    }

    @JsonIgnore
    public boolean isPSDESysProcIdDirty() {
        return this.contains(FIELD_PSDESYSPROCID);
    }

    @JsonIgnore
    public String getPSDESysProcName() {
        Object objValue = this.get(FIELD_PSDESYSPROCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesysprocname")
    public void setPSDESysProcName(String pSDESysProcName) {
        this.set(FIELD_PSDESYSPROCNAME, pSDESysProcName);
    }

    @JsonIgnore
    public boolean isPSDESysProcNameDirty() {
        return this.contains(FIELD_PSDESYSPROCNAME);
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
    public String getPSSysTaskId() {
        Object objValue = this.get(FIELD_PSSYSTASKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystaskid")
    public void setPSSysTaskId(String pSSysTaskId) {
        this.set(FIELD_PSSYSTASKID, pSSysTaskId);
    }

    @JsonIgnore
    public boolean isPSSysTaskIdDirty() {
        return this.contains(FIELD_PSSYSTASKID);
    }

    @JsonIgnore
    public String getPSSysTaskName() {
        Object objValue = this.get(FIELD_PSSYSTASKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystaskname")
    public void setPSSysTaskName(String pSSysTaskName) {
        this.set(FIELD_PSSYSTASKNAME, pSSysTaskName);
    }

    @JsonIgnore
    public boolean isPSSysTaskNameDirty() {
        return this.contains(FIELD_PSSYSTASKNAME);
    }

    @JsonIgnore
    public Integer getPubMode() {
        Object objValue = this.get(FIELD_PUBMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubmode")
    public void setPubMode(Integer pubMode) {
        this.set(FIELD_PUBMODE, pubMode);
    }

    @JsonIgnore
    public boolean isPubModeDirty() {
        return this.contains(FIELD_PUBMODE);
    }

    @JsonIgnore
    public String getRawServiceMethod() {
        Object objValue = this.get(FIELD_RAWSERVICEMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawservicemethod")
    public void setRawServiceMethod(String rawServiceMethod) {
        this.set(FIELD_RAWSERVICEMETHOD, rawServiceMethod);
    }

    @JsonIgnore
    public boolean isRawServiceMethodDirty() {
        return this.contains(FIELD_RAWSERVICEMETHOD);
    }

    @JsonIgnore
    public String getRawServiceUrl() {
        Object objValue = this.get(FIELD_RAWSERVICEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawserviceurl")
    public void setRawServiceUrl(String rawServiceUrl) {
        this.set(FIELD_RAWSERVICEURL, rawServiceUrl);
    }

    @JsonIgnore
    public boolean isRawServiceUrlDirty() {
        return this.contains(FIELD_RAWSERVICEURL);
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
    public String getRequestPath() {
        Object objValue = this.get(FIELD_REQUESTPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestpath")
    public void setRequestPath(String requestPath) {
        this.set(FIELD_REQUESTPATH, requestPath);
    }

    @JsonIgnore
    public boolean isRequestPathDirty() {
        return this.contains(FIELD_REQUESTPATH);
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
    public Integer getTestActionMode() {
        Object objValue = this.get(FIELD_TESTACTIONMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="testactionmode")
    public void setTestActionMode(Integer testActionMode) {
        this.set(FIELD_TESTACTIONMODE, testActionMode);
    }

    @JsonIgnore
    public boolean isTestActionModeDirty() {
        return this.contains(FIELD_TESTACTIONMODE);
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
    public String getTSMode() {
        Object objValue = this.get(FIELD_TSMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tsmode")
    public void setTSMode(String tSMode) {
        this.set(FIELD_TSMODE, tSMode);
    }

    @JsonIgnore
    public boolean isTSModeDirty() {
        return this.contains(FIELD_TSMODE);
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
        return this.getPSDEActionId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEActionId(strValue);
    }

    @JsonProperty(value="psdeactionparams")
    public List<PSDEActionParamDTO> getPsdeactionparams() {
        return this.psdeactionparams;
    }

    @JsonProperty(value="psdeactionparams")
    public void setPsdeactionparams(List<PSDEActionParamDTO> psdeactionparams) {
        this.psdeactionparams = psdeactionparams;
    }

    @JsonProperty(value="psdeactionvrs")
    public List<PSDEActionVRDTO> getPsdeactionvrs() {
        return this.psdeactionvrs;
    }

    @JsonProperty(value="psdeactionvrs")
    public void setPsdeactionvrs(List<PSDEActionVRDTO> psdeactionvrs) {
        this.psdeactionvrs = psdeactionvrs;
    }
}

