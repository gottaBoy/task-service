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
import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysRef
extends PSModelBase {
    public static final String FIELD_CLSPKGPARAMS = "clspkgparams";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DCDOMAINNAME = "dcdomainname";
    public static final String FIELD_DEVSLNCODENAME = "devslncodename";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEVSLNSYSID = "psdevslnsysid";
    public static final String FIELD_PSDEVSLNSYSNAME = "psdevslnsysname";
    public static final String FIELD_PSDEVSLNSYSSRVID = "psdevslnsyssrvid";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "psdevslnsyssrvname";
    public static final String FIELD_PSSUBSYSID = "pssubsysid";
    public static final String FIELD_PSSUBSYSNAME = "pssubsysname";
    public static final String FIELD_PSSYSREFID = "pssysrefid";
    public static final String FIELD_PSSYSREFNAME = "pssysrefname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_REALSYSID = "realsysid";
    public static final String FIELD_REFPARAM = "refparam";
    public static final String FIELD_REFPARAM2 = "refparam2";
    public static final String FIELD_REFPARAMS = "refparams";
    public static final String FIELD_SFFWFLAG = "sffwflag";
    public static final String FIELD_SRVCODENAME = "srvcodename";
    public static final String FIELD_SYSCODENAME = "syscodename";
    public static final String FIELD_SYSNAME = "sysname";
    public static final String FIELD_SYSPKGNAME = "syspkgname";
    public static final String FIELD_SYSREFTYPE = "sysreftype";
    public static final String FIELD_SYSVCNAME = "sysvcname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VERSION = "version";
    private List<PSModule> psmodules;

    @JsonIgnore
    public String getClsPkgParams() {
        Object objValue = this.get(FIELD_CLSPKGPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspkgparams")
    public void setClsPkgParams(String clsPkgParams) {
        this.set(FIELD_CLSPKGPARAMS, clsPkgParams);
    }

    @JsonIgnore
    public boolean isClsPkgParamsDirty() {
        return this.contains(FIELD_CLSPKGPARAMS);
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
    public String getDCDomainName() {
        Object objValue = this.get(FIELD_DCDOMAINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dcdomainname")
    public void setDCDomainName(String dCDomainName) {
        this.set(FIELD_DCDOMAINNAME, dCDomainName);
    }

    @JsonIgnore
    public boolean isDCDomainNameDirty() {
        return this.contains(FIELD_DCDOMAINNAME);
    }

    @JsonIgnore
    public String getDevSlnCodeName() {
        Object objValue = this.get(FIELD_DEVSLNCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="devslncodename")
    public void setDevSlnCodeName(String devSlnCodeName) {
        this.set(FIELD_DEVSLNCODENAME, devSlnCodeName);
    }

    @JsonIgnore
    public boolean isDevSlnCodeNameDirty() {
        return this.contains(FIELD_DEVSLNCODENAME);
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
    public String getPSDevSlnSysId() {
        Object objValue = this.get(FIELD_PSDEVSLNSYSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevslnsysid")
    public void setPSDevSlnSysId(String pSDevSlnSysId) {
        this.set(FIELD_PSDEVSLNSYSID, pSDevSlnSysId);
    }

    @JsonIgnore
    public boolean isPSDevSlnSysIdDirty() {
        return this.contains(FIELD_PSDEVSLNSYSID);
    }

    @JsonIgnore
    public String getPSDevSlnSysName() {
        Object objValue = this.get(FIELD_PSDEVSLNSYSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevslnsysname")
    public void setPSDevSlnSysName(String pSDevSlnSysName) {
        this.set(FIELD_PSDEVSLNSYSNAME, pSDevSlnSysName);
    }

    @JsonIgnore
    public boolean isPSDevSlnSysNameDirty() {
        return this.contains(FIELD_PSDEVSLNSYSNAME);
    }

    @JsonIgnore
    public String getPSDevSlnSysSrvId() {
        Object objValue = this.get(FIELD_PSDEVSLNSYSSRVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevslnsyssrvid")
    public void setPSDevSlnSysSrvId(String pSDevSlnSysSrvId) {
        this.set(FIELD_PSDEVSLNSYSSRVID, pSDevSlnSysSrvId);
    }

    @JsonIgnore
    public boolean isPSDevSlnSysSrvIdDirty() {
        return this.contains(FIELD_PSDEVSLNSYSSRVID);
    }

    @JsonIgnore
    public String getPSDevSlnSysSrvName() {
        Object objValue = this.get(FIELD_PSDEVSLNSYSSRVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevslnsyssrvname")
    public void setPSDevSlnSysSrvName(String pSDevSlnSysSrvName) {
        this.set(FIELD_PSDEVSLNSYSSRVNAME, pSDevSlnSysSrvName);
    }

    @JsonIgnore
    public boolean isPSDevSlnSysSrvNameDirty() {
        return this.contains(FIELD_PSDEVSLNSYSSRVNAME);
    }

    @JsonIgnore
    public String getPSSubSysId() {
        Object objValue = this.get(FIELD_PSSUBSYSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysid")
    public void setPSSubSysId(String pSSubSysId) {
        this.set(FIELD_PSSUBSYSID, pSSubSysId);
    }

    @JsonIgnore
    public boolean isPSSubSysIdDirty() {
        return this.contains(FIELD_PSSUBSYSID);
    }

    @JsonIgnore
    public String getPSSubSysName() {
        Object objValue = this.get(FIELD_PSSUBSYSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysname")
    public void setPSSubSysName(String pSSubSysName) {
        this.set(FIELD_PSSUBSYSNAME, pSSubSysName);
    }

    @JsonIgnore
    public boolean isPSSubSysNameDirty() {
        return this.contains(FIELD_PSSUBSYSNAME);
    }

    @JsonIgnore
    public String getPSSysRefId() {
        Object objValue = this.get(FIELD_PSSYSREFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefid")
    public void setPSSysRefId(String pSSysRefId) {
        this.set(FIELD_PSSYSREFID, pSSysRefId);
    }

    @JsonIgnore
    public boolean isPSSysRefIdDirty() {
        return this.contains(FIELD_PSSYSREFID);
    }

    @JsonIgnore
    public String getPSSysRefName() {
        Object objValue = this.get(FIELD_PSSYSREFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysrefname")
    public void setPSSysRefName(String pSSysRefName) {
        this.set(FIELD_PSSYSREFNAME, pSSysRefName);
    }

    @JsonIgnore
    public boolean isPSSysRefNameDirty() {
        return this.contains(FIELD_PSSYSREFNAME);
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
    public String getRealSysId() {
        Object objValue = this.get(FIELD_REALSYSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="realsysid")
    public void setRealSysId(String realSysId) {
        this.set(FIELD_REALSYSID, realSysId);
    }

    @JsonIgnore
    public boolean isRealSysIdDirty() {
        return this.contains(FIELD_REALSYSID);
    }

    @JsonIgnore
    public String getRefParam() {
        Object objValue = this.get(FIELD_REFPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparam")
    public void setRefParam(String refParam) {
        this.set(FIELD_REFPARAM, refParam);
    }

    @JsonIgnore
    public boolean isRefParamDirty() {
        return this.contains(FIELD_REFPARAM);
    }

    @JsonIgnore
    public String getRefParam2() {
        Object objValue = this.get(FIELD_REFPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparam2")
    public void setRefParam2(String refParam2) {
        this.set(FIELD_REFPARAM2, refParam2);
    }

    @JsonIgnore
    public boolean isRefParam2Dirty() {
        return this.contains(FIELD_REFPARAM2);
    }

    @JsonIgnore
    public String getRefParams() {
        Object objValue = this.get(FIELD_REFPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refparams")
    public void setRefParams(String refParams) {
        this.set(FIELD_REFPARAMS, refParams);
    }

    @JsonIgnore
    public boolean isRefParamsDirty() {
        return this.contains(FIELD_REFPARAMS);
    }

    @JsonIgnore
    public Integer getSFFWFlag() {
        Object objValue = this.get(FIELD_SFFWFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sffwflag")
    public void setSFFWFlag(Integer sFFWFlag) {
        this.set(FIELD_SFFWFLAG, sFFWFlag);
    }

    @JsonIgnore
    public boolean isSFFWFlagDirty() {
        return this.contains(FIELD_SFFWFLAG);
    }

    @JsonIgnore
    public String getSrvCodeName() {
        Object objValue = this.get(FIELD_SRVCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srvcodename")
    public void setSrvCodeName(String srvCodeName) {
        this.set(FIELD_SRVCODENAME, srvCodeName);
    }

    @JsonIgnore
    public boolean isSrvCodeNameDirty() {
        return this.contains(FIELD_SRVCODENAME);
    }

    @JsonIgnore
    public String getSysCodeName() {
        Object objValue = this.get(FIELD_SYSCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="syscodename")
    public void setSysCodeName(String sysCodeName) {
        this.set(FIELD_SYSCODENAME, sysCodeName);
    }

    @JsonIgnore
    public boolean isSysCodeNameDirty() {
        return this.contains(FIELD_SYSCODENAME);
    }

    @JsonIgnore
    public String getSysName() {
        Object objValue = this.get(FIELD_SYSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysname")
    public void setSysName(String sysName) {
        this.set(FIELD_SYSNAME, sysName);
    }

    @JsonIgnore
    public boolean isSysNameDirty() {
        return this.contains(FIELD_SYSNAME);
    }

    @JsonIgnore
    public String getSysPkgName() {
        Object objValue = this.get(FIELD_SYSPKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="syspkgname")
    public void setSysPkgName(String sysPkgName) {
        this.set(FIELD_SYSPKGNAME, sysPkgName);
    }

    @JsonIgnore
    public boolean isSysPkgNameDirty() {
        return this.contains(FIELD_SYSPKGNAME);
    }

    @JsonIgnore
    public String getSysRefType() {
        Object objValue = this.get(FIELD_SYSREFTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysreftype")
    public void setSysRefType(String sysRefType) {
        this.set(FIELD_SYSREFTYPE, sysRefType);
    }

    @JsonIgnore
    public boolean isSysRefTypeDirty() {
        return this.contains(FIELD_SYSREFTYPE);
    }

    @JsonIgnore
    public String getSysVCName() {
        Object objValue = this.get(FIELD_SYSVCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysvcname")
    public void setSysVCName(String sysVCName) {
        this.set(FIELD_SYSVCNAME, sysVCName);
    }

    @JsonIgnore
    public boolean isSysVCNameDirty() {
        return this.contains(FIELD_SYSVCNAME);
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
    public Integer getVersion() {
        Object objValue = this.get(FIELD_VERSION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="version")
    public void setVersion(Integer version) {
        this.set(FIELD_VERSION, version);
    }

    @JsonIgnore
    public boolean isVersionDirty() {
        return this.contains(FIELD_VERSION);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysRefId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysRefId(strValue);
    }

    public List<PSModule> getPsmodules() {
        return this.psmodules;
    }

    public void setPsmodules(List<PSModule> psmodules) {
        this.psmodules = psmodules;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("psmodules")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psmodules")) {
            this.init();
            return this.psmodules;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSREF";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysRef item = (PSSysRef)MAPPER.readValue(new File(strJsonFilePath), PSSysRef.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysRef) {
            PSSysRef pSSysRef = (PSSysRef)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysRef) {
            PSSysRef pSSysRef = (PSSysRef)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

