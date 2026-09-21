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
import net.ibizsys.modelapi.domain.PSDEDSDQ;
import net.ibizsys.modelapi.domain.PSDEDSGrpParam;
import net.ibizsys.modelapi.domain.PSDEDSParam;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDataSet
extends PSModelBase {
    public static final String FIELD_ACTIONHOLDER = "actionholder";
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_AFTERCODE = "aftercode";
    public static final String FIELD_AGGDATAPSDERID = "aggdatapsderid";
    public static final String FIELD_AGGDATAPSDERNAME = "aggdatapsdername";
    public static final String FIELD_BEFORECODE = "beforecode";
    public static final String FIELD_CACHECAT = "cachecat";
    public static final String FIELD_CACHECHECKSTATE = "cachecheckstate";
    public static final String FIELD_CACHESCOPE = "cachescope";
    public static final String FIELD_CACHESTATEPSDELOGICID = "cachestatepsdelogicid";
    public static final String FIELD_CACHESTATEPSDELOGICNAME = "cachestatepsdelogicname";
    public static final String FIELD_CACHETAG = "cachetag";
    public static final String FIELD_CACHETIMEOUT = "cachetimeout";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DATASETSN = "datasetsn";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DSTAG = "dstag";
    public static final String FIELD_DSTAG2 = "dstag2";
    public static final String FIELD_DSTAG3 = "dstag3";
    public static final String FIELD_DSTAG4 = "dstag4";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLECACHE = "enablecache";
    public static final String FIELD_ENABLEGROUP = "enablegroup";
    public static final String FIELD_ENABLEORGDR = "enableorgdr";
    public static final String FIELD_ENABLESECBC = "enablesecbc";
    public static final String FIELD_ENABLESECDR = "enablesecdr";
    public static final String FIELD_ENABLETEMPDATA = "enabletempdata";
    public static final String FIELD_ENABLEUSERDR = "enableuserdr";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_FINISHFLAG = "finishflag";
    public static final String FIELD_INPSDEFGROUPID = "inpsdefgroupid";
    public static final String FIELD_INPSDEFGROUPNAME = "inpsdefgroupname";
    public static final String FIELD_INPSSYSDYNAMODELID = "inpssysdynamodelid";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "inpssysdynamodelname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MAJORPSDEFID = "majorpsdefid";
    public static final String FIELD_MAJORPSDEFNAME = "majorpsdefname";
    public static final String FIELD_MAJORSORTDIR = "majorsortdir";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDEFID = "minorpsdefid";
    public static final String FIELD_MINORPSDEFNAME = "minorpsdefname";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_ORGDR = "orgdr";
    public static final String FIELD_OUTPSDEFGROUPID = "outpsdefgroupid";
    public static final String FIELD_OUTPSDEFGROUPNAME = "outpsdefgroupname";
    public static final String FIELD_PAGESIZE = "pagesize";
    public static final String FIELD_PARAMTYPE = "paramtype";
    public static final String FIELD_POTIME = "potime";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PREDEFINETYPE = "predefinetype";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEDATAIMPID = "psdedataimpid";
    public static final String FIELD_PSDEDATAIMPNAME = "psdedataimpname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEOPPRIVID = "psdeopprivid";
    public static final String FIELD_PSDEOPPRIVNAME = "psdeopprivname";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADETAILID = "pssubsyssadetailid";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "pssubsyssadetailname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTASKID = "pssystaskid";
    public static final String FIELD_PSSYSTASKNAME = "pssystaskname";
    public static final String FIELD_PSSYSUNISTATEID = "pssysunistateid";
    public static final String FIELD_PSSYSUNISTATENAME = "pssysunistatename";
    public static final String FIELD_PSSYSUSERDRID = "pssysuserdrid";
    public static final String FIELD_PSSYSUSERDRID2 = "pssysuserdrid2";
    public static final String FIELD_PSSYSUSERDRNAME = "pssysuserdrname";
    public static final String FIELD_PSSYSUSERDRNAME2 = "pssysuserdrname2";
    public static final String FIELD_PUBMODE = "pubmode";
    public static final String FIELD_RAWSERVICEMETHOD = "rawservicemethod";
    public static final String FIELD_RAWSERVICEURL = "rawserviceurl";
    public static final String FIELD_REQUESTMETHOD = "requestmethod";
    public static final String FIELD_REQUESTPATH = "requestpath";
    public static final String FIELD_RETVALTYPE = "retvaltype";
    public static final String FIELD_SECBC = "secbc";
    public static final String FIELD_SECDR = "secdr";
    public static final String FIELD_SYSUSERDR2PARAM = "sysuserdr2param";
    public static final String FIELD_SYSUSERDRPARAM = "sysuserdrparam";
    public static final String FIELD_TODOTASK = "todotask";
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
    private List<PSDEDSParam> psdedsparams;
    private List<PSDEDSDQ> psdedsdqs;
    private List<PSDEDSGrpParam> psdedsgrpparams;

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
    public String getADPSDELogicId() {
        Object objValue = this.get(FIELD_ADPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicid")
    public void setADPSDELogicId(String aDPSDELogicId) {
        this.set(FIELD_ADPSDELOGICID, aDPSDELogicId);
    }

    @JsonIgnore
    public boolean isADPSDELogicIdDirty() {
        return this.contains(FIELD_ADPSDELOGICID);
    }

    @JsonIgnore
    public String getADPSDELogicName() {
        Object objValue = this.get(FIELD_ADPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicname")
    public void setADPSDELogicName(String aDPSDELogicName) {
        this.set(FIELD_ADPSDELOGICNAME, aDPSDELogicName);
    }

    @JsonIgnore
    public boolean isADPSDELogicNameDirty() {
        return this.contains(FIELD_ADPSDELOGICNAME);
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
    public String getAggDataPSDERId() {
        Object objValue = this.get(FIELD_AGGDATAPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggdatapsderid")
    public void setAggDataPSDERId(String aggDataPSDERId) {
        this.set(FIELD_AGGDATAPSDERID, aggDataPSDERId);
    }

    @JsonIgnore
    public boolean isAggDataPSDERIdDirty() {
        return this.contains(FIELD_AGGDATAPSDERID);
    }

    @JsonIgnore
    public String getAggDataPSDERName() {
        Object objValue = this.get(FIELD_AGGDATAPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aggdatapsdername")
    public void setAggDataPSDERName(String aggDataPSDERName) {
        this.set(FIELD_AGGDATAPSDERNAME, aggDataPSDERName);
    }

    @JsonIgnore
    public boolean isAggDataPSDERNameDirty() {
        return this.contains(FIELD_AGGDATAPSDERNAME);
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
    public String getCacheCheckState() {
        Object objValue = this.get(FIELD_CACHECHECKSTATE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachecheckstate")
    public void setCacheCheckState(String cacheCheckState) {
        this.set(FIELD_CACHECHECKSTATE, cacheCheckState);
    }

    @JsonIgnore
    public boolean isCacheCheckStateDirty() {
        return this.contains(FIELD_CACHECHECKSTATE);
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
    public String getCacheStatePSDELogicId() {
        Object objValue = this.get(FIELD_CACHESTATEPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachestatepsdelogicid")
    public void setCacheStatePSDELogicId(String cacheStatePSDELogicId) {
        this.set(FIELD_CACHESTATEPSDELOGICID, cacheStatePSDELogicId);
    }

    @JsonIgnore
    public boolean isCacheStatePSDELogicIdDirty() {
        return this.contains(FIELD_CACHESTATEPSDELOGICID);
    }

    @JsonIgnore
    public String getCacheStatePSDELogicName() {
        Object objValue = this.get(FIELD_CACHESTATEPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachestatepsdelogicname")
    public void setCacheStatePSDELogicName(String cacheStatePSDELogicName) {
        this.set(FIELD_CACHESTATEPSDELOGICNAME, cacheStatePSDELogicName);
    }

    @JsonIgnore
    public boolean isCacheStatePSDELogicNameDirty() {
        return this.contains(FIELD_CACHESTATEPSDELOGICNAME);
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
    public String getDataSetSN() {
        Object objValue = this.get(FIELD_DATASETSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datasetsn")
    public void setDataSetSN(String dataSetSN) {
        this.set(FIELD_DATASETSN, dataSetSN);
    }

    @JsonIgnore
    public boolean isDataSetSNDirty() {
        return this.contains(FIELD_DATASETSN);
    }

    @JsonIgnore
    public Integer getDefaultMode() {
        Object objValue = this.get(FIELD_DEFAULTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultmode")
    public void setDefaultMode(Integer defaultMode) {
        this.set(FIELD_DEFAULTMODE, defaultMode);
    }

    @JsonIgnore
    public boolean isDefaultModeDirty() {
        return this.contains(FIELD_DEFAULTMODE);
    }

    @JsonIgnore
    public String getDSTag() {
        Object objValue = this.get(FIELD_DSTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstag")
    public void setDSTag(String dSTag) {
        this.set(FIELD_DSTAG, dSTag);
    }

    @JsonIgnore
    public boolean isDSTagDirty() {
        return this.contains(FIELD_DSTAG);
    }

    @JsonIgnore
    public String getDSTag2() {
        Object objValue = this.get(FIELD_DSTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstag2")
    public void setDSTag2(String dSTag2) {
        this.set(FIELD_DSTAG2, dSTag2);
    }

    @JsonIgnore
    public boolean isDSTag2Dirty() {
        return this.contains(FIELD_DSTAG2);
    }

    @JsonIgnore
    public String getDSTag3() {
        Object objValue = this.get(FIELD_DSTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstag3")
    public void setDSTag3(String dSTag3) {
        this.set(FIELD_DSTAG3, dSTag3);
    }

    @JsonIgnore
    public boolean isDSTag3Dirty() {
        return this.contains(FIELD_DSTAG3);
    }

    @JsonIgnore
    public String getDSTag4() {
        Object objValue = this.get(FIELD_DSTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstag4")
    public void setDSTag4(String dSTag4) {
        this.set(FIELD_DSTAG4, dSTag4);
    }

    @JsonIgnore
    public boolean isDSTag4Dirty() {
        return this.contains(FIELD_DSTAG4);
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
    public Integer getEnableGroup() {
        Object objValue = this.get(FIELD_ENABLEGROUP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablegroup")
    public void setEnableGroup(Integer enableGroup) {
        this.set(FIELD_ENABLEGROUP, enableGroup);
    }

    @JsonIgnore
    public boolean isEnableGroupDirty() {
        return this.contains(FIELD_ENABLEGROUP);
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
    public Integer getEnableTempData() {
        Object objValue = this.get(FIELD_ENABLETEMPDATA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabletempdata")
    public void setEnableTempData(Integer enableTempData) {
        this.set(FIELD_ENABLETEMPDATA, enableTempData);
    }

    @JsonIgnore
    public boolean isEnableTempDataDirty() {
        return this.contains(FIELD_ENABLETEMPDATA);
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
    public String getMajorPSDEFId() {
        Object objValue = this.get(FIELD_MAJORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdefid")
    public void setMajorPSDEFId(String majorPSDEFId) {
        this.set(FIELD_MAJORPSDEFID, majorPSDEFId);
    }

    @JsonIgnore
    public boolean isMajorPSDEFIdDirty() {
        return this.contains(FIELD_MAJORPSDEFID);
    }

    @JsonIgnore
    public String getMajorPSDEFName() {
        Object objValue = this.get(FIELD_MAJORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdefname")
    public void setMajorPSDEFName(String majorPSDEFName) {
        this.set(FIELD_MAJORPSDEFNAME, majorPSDEFName);
    }

    @JsonIgnore
    public boolean isMajorPSDEFNameDirty() {
        return this.contains(FIELD_MAJORPSDEFNAME);
    }

    @JsonIgnore
    public String getMajorSortDir() {
        Object objValue = this.get(FIELD_MAJORSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorsortdir")
    public void setMajorSortDir(String majorSortDir) {
        this.set(FIELD_MAJORSORTDIR, majorSortDir);
    }

    @JsonIgnore
    public boolean isMajorSortDirDirty() {
        return this.contains(FIELD_MAJORSORTDIR);
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
    public String getMinorPSDEFId() {
        Object objValue = this.get(FIELD_MINORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdefid")
    public void setMinorPSDEFId(String minorPSDEFId) {
        this.set(FIELD_MINORPSDEFID, minorPSDEFId);
    }

    @JsonIgnore
    public boolean isMinorPSDEFIdDirty() {
        return this.contains(FIELD_MINORPSDEFID);
    }

    @JsonIgnore
    public String getMinorPSDEFName() {
        Object objValue = this.get(FIELD_MINORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdefname")
    public void setMinorPSDEFName(String minorPSDEFName) {
        this.set(FIELD_MINORPSDEFNAME, minorPSDEFName);
    }

    @JsonIgnore
    public boolean isMinorPSDEFNameDirty() {
        return this.contains(FIELD_MINORPSDEFNAME);
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
    public Integer getPageSize() {
        Object objValue = this.get(FIELD_PAGESIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pagesize")
    public void setPageSize(Integer pageSize) {
        this.set(FIELD_PAGESIZE, pageSize);
    }

    @JsonIgnore
    public boolean isPageSizeDirty() {
        return this.contains(FIELD_PAGESIZE);
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
    public String getPredefineType() {
        Object objValue = this.get(FIELD_PREDEFINETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinetype")
    public void setPredefineType(String predefineType) {
        this.set(FIELD_PREDEFINETYPE, predefineType);
    }

    @JsonIgnore
    public boolean isPredefineTypeDirty() {
        return this.contains(FIELD_PREDEFINETYPE);
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
    public String getPSDEDataImpId() {
        Object objValue = this.get(FIELD_PSDEDATAIMPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpid")
    public void setPSDEDataImpId(String pSDEDataImpId) {
        this.set(FIELD_PSDEDATAIMPID, pSDEDataImpId);
    }

    @JsonIgnore
    public boolean isPSDEDataImpIdDirty() {
        return this.contains(FIELD_PSDEDATAIMPID);
    }

    @JsonIgnore
    public String getPSDEDataImpName() {
        Object objValue = this.get(FIELD_PSDEDATAIMPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpname")
    public void setPSDEDataImpName(String pSDEDataImpName) {
        this.set(FIELD_PSDEDATAIMPNAME, pSDEDataImpName);
    }

    @JsonIgnore
    public boolean isPSDEDataImpNameDirty() {
        return this.contains(FIELD_PSDEDATAIMPNAME);
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
    public String getSrfkey() {
        return this.getPSDEDataSetId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDataSetId(strValue);
    }

    public List<PSDEDSParam> getPsdedsparams() {
        return this.psdedsparams;
    }

    public void setPsdedsparams(List<PSDEDSParam> psdedsparams) {
        this.psdedsparams = psdedsparams;
    }

    public List<PSDEDSDQ> getPsdedsdqs() {
        return this.psdedsdqs;
    }

    public void setPsdedsdqs(List<PSDEDSDQ> psdedsdqs) {
        this.psdedsdqs = psdedsdqs;
    }

    public List<PSDEDSGrpParam> getPsdedsgrpparams() {
        return this.psdedsgrpparams;
    }

    public void setPsdedsgrpparams(List<PSDEDSGrpParam> psdedsgrpparams) {
        this.psdedsgrpparams = psdedsgrpparams;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdedsparams")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedsdqs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedsgrpparams")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedsparams")) {
            this.init();
            return this.psdedsparams;
        }
        if (strName.equalsIgnoreCase("psdedsdqs")) {
            this.init();
            return this.psdedsdqs;
        }
        if (strName.equalsIgnoreCase("psdedsgrpparams")) {
            this.init();
            return this.psdedsgrpparams;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDATASET";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDataSet item = (PSDEDataSet)MAPPER.readValue(new File(strJsonFilePath), PSDEDataSet.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDataSet) {
            PSDEDataSet dst = (PSDEDataSet)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdedsparams() != null) {
                    ArrayList<PSDEDSParam> psdedsparams = new ArrayList<PSDEDSParam>();
                    for (PSDEDSParam pSDEDSParam : this.getPsdedsparams()) {
                        if (bDeepMode) {
                            newitem = new PSDEDSParam();
                            pSDEDSParam.to(newitem, false, bDeepMode);
                            psdedsparams.add((PSDEDSParam)newitem);
                            continue;
                        }
                        psdedsparams.add(pSDEDSParam);
                    }
                    dst.setPsdedsparams(psdedsparams);
                }
                if (this.getPsdedsdqs() != null) {
                    ArrayList<PSDEDSDQ> psdedsdqs = new ArrayList<PSDEDSDQ>();
                    for (PSDEDSDQ pSDEDSDQ : this.getPsdedsdqs()) {
                        if (bDeepMode) {
                            newitem = new PSDEDSDQ();
                            pSDEDSDQ.to(newitem, false, bDeepMode);
                            psdedsdqs.add((PSDEDSDQ)newitem);
                            continue;
                        }
                        psdedsdqs.add(pSDEDSDQ);
                    }
                    dst.setPsdedsdqs(psdedsdqs);
                }
                if (this.getPsdedsgrpparams() != null) {
                    ArrayList<PSDEDSGrpParam> psdedsgrpparams = new ArrayList<PSDEDSGrpParam>();
                    for (PSDEDSGrpParam pSDEDSGrpParam : this.getPsdedsgrpparams()) {
                        if (bDeepMode) {
                            newitem = new PSDEDSGrpParam();
                            pSDEDSGrpParam.to(newitem, false, bDeepMode);
                            psdedsgrpparams.add((PSDEDSGrpParam)newitem);
                            continue;
                        }
                        psdedsgrpparams.add(pSDEDSGrpParam);
                    }
                    dst.setPsdedsgrpparams(psdedsgrpparams);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDataSet) {
            PSDEDataSet src = (PSDEDataSet)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdedsparams() != null) {
                    ArrayList<PSDEDSParam> psdedsparams = new ArrayList<PSDEDSParam>();
                    for (PSDEDSParam pSDEDSParam : src.getPsdedsparams()) {
                        if (bDeepMode) {
                            newItem = new PSDEDSParam();
                            ((PSDEDSParam)newItem).from(pSDEDSParam, false, bDeepMode);
                            psdedsparams.add((PSDEDSParam)newItem);
                            continue;
                        }
                        psdedsparams.add(pSDEDSParam);
                    }
                    this.setPsdedsparams(psdedsparams);
                }
                if (src.getPsdedsdqs() != null) {
                    ArrayList<PSDEDSDQ> psdedsdqs = new ArrayList<PSDEDSDQ>();
                    for (PSDEDSDQ pSDEDSDQ : src.getPsdedsdqs()) {
                        if (bDeepMode) {
                            newItem = new PSDEDSDQ();
                            ((PSDEDSDQ)newItem).from(pSDEDSDQ, false, bDeepMode);
                            psdedsdqs.add((PSDEDSDQ)newItem);
                            continue;
                        }
                        psdedsdqs.add(pSDEDSDQ);
                    }
                    this.setPsdedsdqs(psdedsdqs);
                }
                if (src.getPsdedsgrpparams() != null) {
                    ArrayList<PSDEDSGrpParam> psdedsgrpparams = new ArrayList<PSDEDSGrpParam>();
                    for (PSDEDSGrpParam pSDEDSGrpParam : src.getPsdedsgrpparams()) {
                        if (bDeepMode) {
                            newItem = new PSDEDSGrpParam();
                            ((PSDEDSGrpParam)newItem).from(pSDEDSGrpParam, false, bDeepMode);
                            psdedsgrpparams.add((PSDEDSGrpParam)newItem);
                            continue;
                        }
                        psdedsgrpparams.add(pSDEDSGrpParam);
                    }
                    this.setPsdedsgrpparams(psdedsgrpparams);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

