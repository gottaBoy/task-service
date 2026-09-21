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
import net.ibizsys.modelapi.domain.PSACHandlerAction;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSACHandler
extends PSModelBase {
    public static final String FIELD_CACHESCOPE = "cachescope";
    public static final String FIELD_CACHETIMEOUT = "cachetimeout";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COPYPSDEACTIONID = "copypsdeactionid";
    public static final String FIELD_COPYPSDEACTIONNAME = "copypsdeactionname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATEPSDEACTIONID = "createpsdeactionid";
    public static final String FIELD_CREATEPSDEACTIONNAME = "createpsdeactionname";
    public static final String FIELD_CREATEPSDEOPPRIVID = "createpsdeopprivid";
    public static final String FIELD_CREATEPSDEOPPRIVINAME = "createpsdeoppriviname";
    public static final String FIELD_CREATETIMEOUT = "createtimeout";
    public static final String FIELD_CTRLTYPE = "ctrltype";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLECACHE = "enablecache";
    public static final String FIELD_ENABLEORGDR = "enableorgdr";
    public static final String FIELD_ENABLESECBC = "enablesecbc";
    public static final String FIELD_ENABLESECDR = "enablesecdr";
    public static final String FIELD_ENABLEUSERDR = "enableuserdr";
    public static final String FIELD_EXPORTPSDEOPPRIVID = "exportpsdeopprivid";
    public static final String FIELD_EXPORTPSDEOPPRIVNAME = "exportpsdeoppriviname";
    public static final String FIELD_FETCHTIMEOUT = "fetchtimeout";
    public static final String FIELD_FINISHFLAG = "finishflag";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "getdraftpsdeactionid";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "getdraftpsdeactionname";
    public static final String FIELD_GETPSDEACTIONID = "getpsdeactionid";
    public static final String FIELD_GETPSDEACTIONNAME = "getpsdeactionname";
    public static final String FIELD_GETTIMEOUT = "gettimeout";
    public static final String FIELD_HANDLEROBJ = "handlerobj";
    public static final String FIELD_HANDLEROBJ2 = "handlerobj2";
    public static final String FIELD_HANDLERPARAMS = "handlerparams";
    public static final String FIELD_HANDLERTAG = "handlertag";
    public static final String FIELD_HANDLERTAG2 = "handlertag2";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORGDR = "orgdr";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSFACHANDLERID = "pssfachandlerid";
    public static final String FIELD_PSSFACHANDLERNAME = "pssfachandlername";
    public static final String FIELD_PSSFID = "pssfid";
    public static final String FIELD_PSSFNAME = "pssfname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTASKID = "pssystaskid";
    public static final String FIELD_PSSYSTASKNAME = "pssystaskname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUNISTATEID = "pssysunistateid";
    public static final String FIELD_PSSYSUNISTATENAME = "pssysunistatename";
    public static final String FIELD_PSSYSUSERDRID = "pssysuserdrid";
    public static final String FIELD_PSSYSUSERDRID2 = "pssysuserdrid2";
    public static final String FIELD_PSSYSUSERDRNAME = "pssysuserdrname";
    public static final String FIELD_PSSYSUSERDRNAME2 = "pssysuserdrname2";
    public static final String FIELD_READPSDEOPPRIVID = "readpsdeopprivid";
    public static final String FIELD_READPSDEOPPRIVNAME = "readpsdeopprivname";
    public static final String FIELD_REMOVEPSDEACTIONID = "removepsdeactionid";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "removepsdeactionname";
    public static final String FIELD_REMOVEPSDEOPPRIVID = "removepsdeopprivid";
    public static final String FIELD_REMOVEPSDEOPPRIVNAME = "removepsdeopprivname";
    public static final String FIELD_REMOVETIMEOUT = "removetimeout";
    public static final String FIELD_SECBC = "secbc";
    public static final String FIELD_SECDR = "secdr";
    public static final String FIELD_SYSUSERDR2PARAM = "sysuserdr2param";
    public static final String FIELD_SYSUSERDRPARAM = "sysuserdrparam";
    public static final String FIELD_TEMPMODE = "tempmode";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_UNISTATEFIELD = "unistatefield";
    public static final String FIELD_UNISTATEKEYVALUE = "unistatekeyvalue";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEPSDEACTIONID = "updatepsdeactionid";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "updatepsdeactionname";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "updatepsdeopprivid";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "updatepsdeopprivname";
    public static final String FIELD_UPDATETIMEOUT = "updatetimeout";
    public static final String FIELD_USER2PSDEACTIONID = "user2psdeactionid";
    public static final String FIELD_USER2PSDEACTIONNAME = "user2psdeactionname";
    public static final String FIELD_USER2PSDEOPPRIVID = "user2psdeopprivid";
    public static final String FIELD_USER2PSDEOPPRIVNAME = "user2psdeoppriviname";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERPSDEACTIONID = "userpsdeactionid";
    public static final String FIELD_USERPSDEACTIONNAME = "userpsdeactionname";
    public static final String FIELD_USERPSDEOPPRIVID = "userpsdeopprivid";
    public static final String FIELD_USERPSDEOPPRIVNAME = "userpsdeoppriviname";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSACHandlerAction> psachandleractions;

    @JsonIgnore
    public Integer getCacheScope() {
        Object objValue = this.get(FIELD_CACHESCOPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cachescope")
    public void setCacheScope(Integer cacheScope) {
        this.set(FIELD_CACHESCOPE, cacheScope);
    }

    @JsonIgnore
    public boolean isCacheScopeDirty() {
        return this.contains(FIELD_CACHESCOPE);
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
    public String getCopyPSDEActionId() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionid")
    public void setCopyPSDEActionId(String copyPSDEActionId) {
        this.set(FIELD_COPYPSDEACTIONID, copyPSDEActionId);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionIdDirty() {
        return this.contains(FIELD_COPYPSDEACTIONID);
    }

    @JsonIgnore
    public String getCopyPSDEActionName() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionname")
    public void setCopyPSDEActionName(String copyPSDEActionName) {
        this.set(FIELD_COPYPSDEACTIONNAME, copyPSDEActionName);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionNameDirty() {
        return this.contains(FIELD_COPYPSDEACTIONNAME);
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
    public String getCreatePSDEActionId() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionid")
    public void setCreatePSDEActionId(String createPSDEActionId) {
        this.set(FIELD_CREATEPSDEACTIONID, createPSDEActionId);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionIdDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getCreatePSDEActionName() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionname")
    public void setCreatePSDEActionName(String createPSDEActionName) {
        this.set(FIELD_CREATEPSDEACTIONNAME, createPSDEActionName);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionNameDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getCreatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeopprivid")
    public void setCreatePSDEOPPrivId(String createPSDEOPPrivId) {
        this.set(FIELD_CREATEPSDEOPPRIVID, createPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getCreatePSDEOPPrivIName() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeoppriviname")
    public void setCreatePSDEOPPrivIName(String createPSDEOPPrivIName) {
        this.set(FIELD_CREATEPSDEOPPRIVINAME, createPSDEOPPrivIName);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivINameDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVINAME);
    }

    @JsonIgnore
    public Integer getCreateTimeout() {
        Object objValue = this.get(FIELD_CREATETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="createtimeout")
    public void setCreateTimeout(Integer createTimeout) {
        this.set(FIELD_CREATETIMEOUT, createTimeout);
    }

    @JsonIgnore
    public boolean isCreateTimeoutDirty() {
        return this.contains(FIELD_CREATETIMEOUT);
    }

    @JsonIgnore
    public String getCtrlType() {
        Object objValue = this.get(FIELD_CTRLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrltype")
    public void setCtrlType(String ctrlType) {
        this.set(FIELD_CTRLTYPE, ctrlType);
    }

    @JsonIgnore
    public boolean isCtrlTypeDirty() {
        return this.contains(FIELD_CTRLTYPE);
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
    public Integer getEnableOrgDR() {
        Object objValue = this.get(FIELD_ENABLEORGDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableorgdr")
    public void setEnableOrgDR(Integer enableOrgDR) {
        this.set(FIELD_ENABLEORGDR, enableOrgDR);
    }

    @JsonIgnore
    public boolean isEnableOrgDRDirty() {
        return this.contains(FIELD_ENABLEORGDR);
    }

    @JsonIgnore
    public Integer getEnableSecBC() {
        Object objValue = this.get(FIELD_ENABLESECBC);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesecbc")
    public void setEnableSecBC(Integer enableSecBC) {
        this.set(FIELD_ENABLESECBC, enableSecBC);
    }

    @JsonIgnore
    public boolean isEnableSecBCDirty() {
        return this.contains(FIELD_ENABLESECBC);
    }

    @JsonIgnore
    public Integer getEnableSecDR() {
        Object objValue = this.get(FIELD_ENABLESECDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesecdr")
    public void setEnableSecDR(Integer enableSecDR) {
        this.set(FIELD_ENABLESECDR, enableSecDR);
    }

    @JsonIgnore
    public boolean isEnableSecDRDirty() {
        return this.contains(FIELD_ENABLESECDR);
    }

    @JsonIgnore
    public Integer getEnableUserDR() {
        Object objValue = this.get(FIELD_ENABLEUSERDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableuserdr")
    public void setEnableUserDR(Integer enableUserDR) {
        this.set(FIELD_ENABLEUSERDR, enableUserDR);
    }

    @JsonIgnore
    public boolean isEnableUserDRDirty() {
        return this.contains(FIELD_ENABLEUSERDR);
    }

    @JsonIgnore
    public String getExportPSDEOPPrivId() {
        Object objValue = this.get(FIELD_EXPORTPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exportpsdeopprivid")
    public void setExportPSDEOPPrivId(String exportPSDEOPPrivId) {
        this.set(FIELD_EXPORTPSDEOPPRIVID, exportPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isExportPSDEOPPrivIdDirty() {
        return this.contains(FIELD_EXPORTPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getExportPSDEOPPrivName() {
        Object objValue = this.get(FIELD_EXPORTPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exportpsdeoppriviname")
    public void setExportPSDEOPPrivName(String exportPSDEOPPrivName) {
        this.set(FIELD_EXPORTPSDEOPPRIVNAME, exportPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isExportPSDEOPPrivNameDirty() {
        return this.contains(FIELD_EXPORTPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public Integer getFetchTimeout() {
        Object objValue = this.get(FIELD_FETCHTIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fetchtimeout")
    public void setFetchTimeout(Integer fetchTimeout) {
        this.set(FIELD_FETCHTIMEOUT, fetchTimeout);
    }

    @JsonIgnore
    public boolean isFetchTimeoutDirty() {
        return this.contains(FIELD_FETCHTIMEOUT);
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
    public String getGetDraftPSDEActionId() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionid")
    public void setGetDraftPSDEActionId(String getDraftPSDEActionId) {
        this.set(FIELD_GETDRAFTPSDEACTIONID, getDraftPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionIdDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetDraftPSDEActionName() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionname")
    public void setGetDraftPSDEActionName(String getDraftPSDEActionName) {
        this.set(FIELD_GETDRAFTPSDEACTIONNAME, getDraftPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionNameDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getGetPSDEActionId() {
        Object objValue = this.get(FIELD_GETPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionid")
    public void setGetPSDEActionId(String getPSDEActionId) {
        this.set(FIELD_GETPSDEACTIONID, getPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetPSDEActionIdDirty() {
        return this.contains(FIELD_GETPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetPSDEActionName() {
        Object objValue = this.get(FIELD_GETPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionname")
    public void setGetPSDEActionName(String getPSDEActionName) {
        this.set(FIELD_GETPSDEACTIONNAME, getPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetPSDEActionNameDirty() {
        return this.contains(FIELD_GETPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getGetTimeout() {
        Object objValue = this.get(FIELD_GETTIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gettimeout")
    public void setGetTimeout(Integer getTimeout) {
        this.set(FIELD_GETTIMEOUT, getTimeout);
    }

    @JsonIgnore
    public boolean isGetTimeoutDirty() {
        return this.contains(FIELD_GETTIMEOUT);
    }

    @JsonIgnore
    public String getHandlerObj() {
        Object objValue = this.get(FIELD_HANDLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerobj")
    public void setHandlerObj(String handlerObj) {
        this.set(FIELD_HANDLEROBJ, handlerObj);
    }

    @JsonIgnore
    public boolean isHandlerObjDirty() {
        return this.contains(FIELD_HANDLEROBJ);
    }

    @JsonIgnore
    public String getHandlerObj2() {
        Object objValue = this.get(FIELD_HANDLEROBJ2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerobj2")
    public void setHandlerObj2(String handlerObj2) {
        this.set(FIELD_HANDLEROBJ2, handlerObj2);
    }

    @JsonIgnore
    public boolean isHandlerObj2Dirty() {
        return this.contains(FIELD_HANDLEROBJ2);
    }

    @JsonIgnore
    public String getHandlerParams() {
        Object objValue = this.get(FIELD_HANDLERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerparams")
    public void setHandlerParams(String handlerParams) {
        this.set(FIELD_HANDLERPARAMS, handlerParams);
    }

    @JsonIgnore
    public boolean isHandlerParamsDirty() {
        return this.contains(FIELD_HANDLERPARAMS);
    }

    @JsonIgnore
    public String getHandlerTag() {
        Object objValue = this.get(FIELD_HANDLERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlertag")
    public void setHandlerTag(String handlerTag) {
        this.set(FIELD_HANDLERTAG, handlerTag);
    }

    @JsonIgnore
    public boolean isHandlerTagDirty() {
        return this.contains(FIELD_HANDLERTAG);
    }

    @JsonIgnore
    public String getHandlerTag2() {
        Object objValue = this.get(FIELD_HANDLERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlertag2")
    public void setHandlerTag2(String handlerTag2) {
        this.set(FIELD_HANDLERTAG2, handlerTag2);
    }

    @JsonIgnore
    public boolean isHandlerTag2Dirty() {
        return this.contains(FIELD_HANDLERTAG2);
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
    public Integer getOrgDR() {
        Object objValue = this.get(FIELD_ORGDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="orgdr")
    public void setOrgDR(Integer orgDR) {
        this.set(FIELD_ORGDR, orgDR);
    }

    @JsonIgnore
    public boolean isOrgDRDirty() {
        return this.contains(FIELD_ORGDR);
    }

    @JsonIgnore
    public String getPSACHandlerId() {
        Object objValue = this.get(FIELD_PSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlerid")
    public void setPSACHandlerId(String pSACHandlerId) {
        this.set(FIELD_PSACHANDLERID, pSACHandlerId);
    }

    @JsonIgnore
    public boolean isPSACHandlerIdDirty() {
        return this.contains(FIELD_PSACHANDLERID);
    }

    @JsonIgnore
    public String getPSACHandlerName() {
        Object objValue = this.get(FIELD_PSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlername")
    public void setPSACHandlerName(String pSACHandlerName) {
        this.set(FIELD_PSACHANDLERNAME, pSACHandlerName);
    }

    @JsonIgnore
    public boolean isPSACHandlerNameDirty() {
        return this.contains(FIELD_PSACHANDLERNAME);
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
    public String getPSSFACHandlerId() {
        Object objValue = this.get(FIELD_PSSFACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfachandlerid")
    public void setPSSFACHandlerId(String pSSFACHandlerId) {
        this.set(FIELD_PSSFACHANDLERID, pSSFACHandlerId);
    }

    @JsonIgnore
    public boolean isPSSFACHandlerIdDirty() {
        return this.contains(FIELD_PSSFACHANDLERID);
    }

    @JsonIgnore
    public String getPSSFACHandlerName() {
        Object objValue = this.get(FIELD_PSSFACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfachandlername")
    public void setPSSFACHandlerName(String pSSFACHandlerName) {
        this.set(FIELD_PSSFACHANDLERNAME, pSSFACHandlerName);
    }

    @JsonIgnore
    public boolean isPSSFACHandlerNameDirty() {
        return this.contains(FIELD_PSSFACHANDLERNAME);
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
    public String getPSSysUniStateId() {
        Object objValue = this.get(FIELD_PSSYSUNISTATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistateid")
    public void setPSSysUniStateId(String pSSysUniStateId) {
        this.set(FIELD_PSSYSUNISTATEID, pSSysUniStateId);
    }

    @JsonIgnore
    public boolean isPSSysUniStateIdDirty() {
        return this.contains(FIELD_PSSYSUNISTATEID);
    }

    @JsonIgnore
    public String getPSSysUniStateName() {
        Object objValue = this.get(FIELD_PSSYSUNISTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistatename")
    public void setPSSysUniStateName(String pSSysUniStateName) {
        this.set(FIELD_PSSYSUNISTATENAME, pSSysUniStateName);
    }

    @JsonIgnore
    public boolean isPSSysUniStateNameDirty() {
        return this.contains(FIELD_PSSYSUNISTATENAME);
    }

    @JsonIgnore
    public String getPSSysUserDRId() {
        Object objValue = this.get(FIELD_PSSYSUSERDRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrid")
    public void setPSSysUserDRId(String pSSysUserDRId) {
        this.set(FIELD_PSSYSUSERDRID, pSSysUserDRId);
    }

    @JsonIgnore
    public boolean isPSSysUserDRIdDirty() {
        return this.contains(FIELD_PSSYSUSERDRID);
    }

    @JsonIgnore
    public String getPSSysUserDRId2() {
        Object objValue = this.get(FIELD_PSSYSUSERDRID2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrid2")
    public void setPSSysUserDRId2(String pSSysUserDRId2) {
        this.set(FIELD_PSSYSUSERDRID2, pSSysUserDRId2);
    }

    @JsonIgnore
    public boolean isPSSysUserDRId2Dirty() {
        return this.contains(FIELD_PSSYSUSERDRID2);
    }

    @JsonIgnore
    public String getPSSysUserDRName() {
        Object objValue = this.get(FIELD_PSSYSUSERDRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrname")
    public void setPSSysUserDRName(String pSSysUserDRName) {
        this.set(FIELD_PSSYSUSERDRNAME, pSSysUserDRName);
    }

    @JsonIgnore
    public boolean isPSSysUserDRNameDirty() {
        return this.contains(FIELD_PSSYSUSERDRNAME);
    }

    @JsonIgnore
    public String getPSSysUserDRName2() {
        Object objValue = this.get(FIELD_PSSYSUSERDRNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrname2")
    public void setPSSysUserDRName2(String pSSysUserDRName2) {
        this.set(FIELD_PSSYSUSERDRNAME2, pSSysUserDRName2);
    }

    @JsonIgnore
    public boolean isPSSysUserDRName2Dirty() {
        return this.contains(FIELD_PSSYSUSERDRNAME2);
    }

    @JsonIgnore
    public String getReadPSDEOPPrivId() {
        Object objValue = this.get(FIELD_READPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="readpsdeopprivid")
    public void setReadPSDEOPPrivId(String readPSDEOPPrivId) {
        this.set(FIELD_READPSDEOPPRIVID, readPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isReadPSDEOPPrivIdDirty() {
        return this.contains(FIELD_READPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getReadPSDEOPPrivName() {
        Object objValue = this.get(FIELD_READPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="readpsdeopprivname")
    public void setReadPSDEOPPrivName(String readPSDEOPPrivName) {
        this.set(FIELD_READPSDEOPPRIVNAME, readPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isReadPSDEOPPrivNameDirty() {
        return this.contains(FIELD_READPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getRemovePSDEActionId() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionid")
    public void setRemovePSDEActionId(String removePSDEActionId) {
        this.set(FIELD_REMOVEPSDEACTIONID, removePSDEActionId);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionIdDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONID);
    }

    @JsonIgnore
    public String getRemovePSDEActionName() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionname")
    public void setRemovePSDEActionName(String removePSDEActionName) {
        this.set(FIELD_REMOVEPSDEACTIONNAME, removePSDEActionName);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionNameDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getRemovePSDEOPPrivId() {
        Object objValue = this.get(FIELD_REMOVEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeopprivid")
    public void setRemovePSDEOPPrivId(String removePSDEOPPrivId) {
        this.set(FIELD_REMOVEPSDEOPPRIVID, removePSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isRemovePSDEOPPrivIdDirty() {
        return this.contains(FIELD_REMOVEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getRemovePSDEOPPrivName() {
        Object objValue = this.get(FIELD_REMOVEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeopprivname")
    public void setRemovePSDEOPPrivName(String removePSDEOPPrivName) {
        this.set(FIELD_REMOVEPSDEOPPRIVNAME, removePSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isRemovePSDEOPPrivNameDirty() {
        return this.contains(FIELD_REMOVEPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public Integer getRemoveTimeout() {
        Object objValue = this.get(FIELD_REMOVETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removetimeout")
    public void setRemoveTimeout(Integer removeTimeout) {
        this.set(FIELD_REMOVETIMEOUT, removeTimeout);
    }

    @JsonIgnore
    public boolean isRemoveTimeoutDirty() {
        return this.contains(FIELD_REMOVETIMEOUT);
    }

    @JsonIgnore
    public String getSecBC() {
        Object objValue = this.get(FIELD_SECBC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="secbc")
    public void setSecBC(String secBC) {
        this.set(FIELD_SECBC, secBC);
    }

    @JsonIgnore
    public boolean isSecBCDirty() {
        return this.contains(FIELD_SECBC);
    }

    @JsonIgnore
    public Integer getSecDR() {
        Object objValue = this.get(FIELD_SECDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="secdr")
    public void setSecDR(Integer secDR) {
        this.set(FIELD_SECDR, secDR);
    }

    @JsonIgnore
    public boolean isSecDRDirty() {
        return this.contains(FIELD_SECDR);
    }

    @JsonIgnore
    public String getSysUserDR2Param() {
        Object objValue = this.get(FIELD_SYSUSERDR2PARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysuserdr2param")
    public void setSysUserDR2Param(String sysUserDR2Param) {
        this.set(FIELD_SYSUSERDR2PARAM, sysUserDR2Param);
    }

    @JsonIgnore
    public boolean isSysUserDR2ParamDirty() {
        return this.contains(FIELD_SYSUSERDR2PARAM);
    }

    @JsonIgnore
    public String getSysUserDRParam() {
        Object objValue = this.get(FIELD_SYSUSERDRPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysuserdrparam")
    public void setSysUserDRParam(String sysUserDRParam) {
        this.set(FIELD_SYSUSERDRPARAM, sysUserDRParam);
    }

    @JsonIgnore
    public boolean isSysUserDRParamDirty() {
        return this.contains(FIELD_SYSUSERDRPARAM);
    }

    @JsonIgnore
    public Integer getTempMode() {
        Object objValue = this.get(FIELD_TEMPMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tempmode")
    public void setTempMode(Integer tempMode) {
        this.set(FIELD_TEMPMODE, tempMode);
    }

    @JsonIgnore
    public boolean isTempModeDirty() {
        return this.contains(FIELD_TEMPMODE);
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
    public String getUniStateField() {
        Object objValue = this.get(FIELD_UNISTATEFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unistatefield")
    public void setUniStateField(String uniStateField) {
        this.set(FIELD_UNISTATEFIELD, uniStateField);
    }

    @JsonIgnore
    public boolean isUniStateFieldDirty() {
        return this.contains(FIELD_UNISTATEFIELD);
    }

    @JsonIgnore
    public String getUniStateKeyValue() {
        Object objValue = this.get(FIELD_UNISTATEKEYVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="unistatekeyvalue")
    public void setUniStateKeyValue(String uniStateKeyValue) {
        this.set(FIELD_UNISTATEKEYVALUE, uniStateKeyValue);
    }

    @JsonIgnore
    public boolean isUniStateKeyValueDirty() {
        return this.contains(FIELD_UNISTATEKEYVALUE);
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
    public String getUpdatePSDEActionId() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionid")
    public void setUpdatePSDEActionId(String updatePSDEActionId) {
        this.set(FIELD_UPDATEPSDEACTIONID, updatePSDEActionId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionIdDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getUpdatePSDEActionName() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionname")
    public void setUpdatePSDEActionName(String updatePSDEActionName) {
        this.set(FIELD_UPDATEPSDEACTIONNAME, updatePSDEActionName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionNameDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getUpdatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivid")
    public void setUpdatePSDEOPPrivId(String updatePSDEOPPrivId) {
        this.set(FIELD_UPDATEPSDEOPPRIVID, updatePSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getUpdatePSDEOPPrivName() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivname")
    public void setUpdatePSDEOPPrivName(String updatePSDEOPPrivName) {
        this.set(FIELD_UPDATEPSDEOPPRIVNAME, updatePSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivNameDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public Integer getUpdateTimeout() {
        Object objValue = this.get(FIELD_UPDATETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="updatetimeout")
    public void setUpdateTimeout(Integer updateTimeout) {
        this.set(FIELD_UPDATETIMEOUT, updateTimeout);
    }

    @JsonIgnore
    public boolean isUpdateTimeoutDirty() {
        return this.contains(FIELD_UPDATETIMEOUT);
    }

    @JsonIgnore
    public String getUser2PSDEActionId() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionid")
    public void setUser2PSDEActionId(String user2PSDEActionId) {
        this.set(FIELD_USER2PSDEACTIONID, user2PSDEActionId);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionIdDirty() {
        return this.contains(FIELD_USER2PSDEACTIONID);
    }

    @JsonIgnore
    public String getUser2PSDEActionName() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionname")
    public void setUser2PSDEActionName(String user2PSDEActionName) {
        this.set(FIELD_USER2PSDEACTIONNAME, user2PSDEActionName);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionNameDirty() {
        return this.contains(FIELD_USER2PSDEACTIONNAME);
    }

    @JsonIgnore
    public String getUser2PSDEOPPrivId() {
        Object objValue = this.get(FIELD_USER2PSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeopprivid")
    public void setUser2PSDEOPPrivId(String user2PSDEOPPrivId) {
        this.set(FIELD_USER2PSDEOPPRIVID, user2PSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isUser2PSDEOPPrivIdDirty() {
        return this.contains(FIELD_USER2PSDEOPPRIVID);
    }

    @JsonIgnore
    public String getUser2PSDEOPPrivName() {
        Object objValue = this.get(FIELD_USER2PSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeoppriviname")
    public void setUser2PSDEOPPrivName(String user2PSDEOPPrivName) {
        this.set(FIELD_USER2PSDEOPPRIVNAME, user2PSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isUser2PSDEOPPrivNameDirty() {
        return this.contains(FIELD_USER2PSDEOPPRIVNAME);
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
    public String getUserPSDEActionId() {
        Object objValue = this.get(FIELD_USERPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionid")
    public void setUserPSDEActionId(String userPSDEActionId) {
        this.set(FIELD_USERPSDEACTIONID, userPSDEActionId);
    }

    @JsonIgnore
    public boolean isUserPSDEActionIdDirty() {
        return this.contains(FIELD_USERPSDEACTIONID);
    }

    @JsonIgnore
    public String getUserPSDEActionName() {
        Object objValue = this.get(FIELD_USERPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionname")
    public void setUserPSDEActionName(String userPSDEActionName) {
        this.set(FIELD_USERPSDEACTIONNAME, userPSDEActionName);
    }

    @JsonIgnore
    public boolean isUserPSDEActionNameDirty() {
        return this.contains(FIELD_USERPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getUserPSDEOPPrivId() {
        Object objValue = this.get(FIELD_USERPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeopprivid")
    public void setUserPSDEOPPrivId(String userPSDEOPPrivId) {
        this.set(FIELD_USERPSDEOPPRIVID, userPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isUserPSDEOPPrivIdDirty() {
        return this.contains(FIELD_USERPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getUserPSDEOPPrivName() {
        Object objValue = this.get(FIELD_USERPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeoppriviname")
    public void setUserPSDEOPPrivName(String userPSDEOPPrivName) {
        this.set(FIELD_USERPSDEOPPRIVNAME, userPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isUserPSDEOPPrivNameDirty() {
        return this.contains(FIELD_USERPSDEOPPRIVNAME);
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
        return this.getPSACHandlerId();
    }

    public void setSrfkey(String strValue) {
        this.setPSACHandlerId(strValue);
    }

    public List<PSACHandlerAction> getPsachandleractions() {
        return this.psachandleractions;
    }

    public void setPsachandleractions(List<PSACHandlerAction> psachandleractions) {
        this.psachandleractions = psachandleractions;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psachandleractions")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psachandleractions")) {
            this.init();
            return this.psachandleractions;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSACHANDLER";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSACHandler item = (PSACHandler)MAPPER.readValue(new File(strJsonFilePath), PSACHandler.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSACHandler) {
            PSACHandler dst = (PSACHandler)target;
            if (!bSimple && this.getPsachandleractions() != null) {
                ArrayList<PSACHandlerAction> psachandleractions = new ArrayList<PSACHandlerAction>();
                for (PSACHandlerAction item : this.getPsachandleractions()) {
                    if (bDeepMode) {
                        PSACHandlerAction newitem = new PSACHandlerAction();
                        item.to(newitem, false, bDeepMode);
                        psachandleractions.add(newitem);
                        continue;
                    }
                    psachandleractions.add(item);
                }
                dst.setPsachandleractions(psachandleractions);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSACHandler) {
            PSACHandler src = (PSACHandler)source;
            if (!bSimple && src.getPsachandleractions() != null) {
                ArrayList<PSACHandlerAction> psachandleractions = new ArrayList<PSACHandlerAction>();
                for (PSACHandlerAction item : src.getPsachandleractions()) {
                    if (bDeepMode) {
                        PSACHandlerAction newItem = new PSACHandlerAction();
                        newItem.from(item, false, bDeepMode);
                        psachandleractions.add(newItem);
                        continue;
                    }
                    psachandleractions.add(item);
                }
                this.setPsachandleractions(psachandleractions);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

