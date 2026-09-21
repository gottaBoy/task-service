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

public class PSModuleDTO
extends PSModelDTOBase {
    public static final String FIELD_CLSPKGPARAMS = "clspkgparams";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_DTOFORMAT = "dtoformat";
    public static final String FIELD_DYNAINSTMODE = "dynainstmode";
    public static final String FIELD_DYNAINSTTAG = "dynainsttag";
    public static final String FIELD_DYNAINSTTAG2 = "dynainsttag2";
    public static final String FIELD_LANRESTAG = "lanrestag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODTAG = "modtag";
    public static final String FIELD_MODTAG2 = "modtag2";
    public static final String FIELD_MODTAG3 = "modtag3";
    public static final String FIELD_MODTAG4 = "modtag4";
    public static final String FIELD_MODULESN = "modulesn";
    public static final String FIELD_NOVIEWMODE = "noviewmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PKGCODENAME = "pkgcodename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSREFID = "pssysrefid";
    public static final String FIELD_PSSYSREFNAME = "pssysrefname";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SERVICEAPIFLAG = "serviceapiflag";
    public static final String FIELD_SHORTTAG = "shorttag";
    public static final String FIELD_SUBSYSMODULE = "subsysmodule";
    public static final String FIELD_SYSREFTYPE = "sysreftype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTILPARAMS = "utilparams";
    public static final String FIELD_UTILTAG = "utiltag";
    public static final String FIELD_UTILTYPE = "utiltype";

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
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
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
    public Integer getDynaInstMode() {
        Object objValue = this.get(FIELD_DYNAINSTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynainstmode")
    public void setDynaInstMode(Integer dynaInstMode) {
        this.set(FIELD_DYNAINSTMODE, dynaInstMode);
    }

    @JsonIgnore
    public boolean isDynaInstModeDirty() {
        return this.contains(FIELD_DYNAINSTMODE);
    }

    @JsonIgnore
    public String getDynaInstTag() {
        Object objValue = this.get(FIELD_DYNAINSTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag")
    public void setDynaInstTag(String dynaInstTag) {
        this.set(FIELD_DYNAINSTTAG, dynaInstTag);
    }

    @JsonIgnore
    public boolean isDynaInstTagDirty() {
        return this.contains(FIELD_DYNAINSTTAG);
    }

    @JsonIgnore
    public String getDynaInstTag2() {
        Object objValue = this.get(FIELD_DYNAINSTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag2")
    public void setDynaInstTag2(String dynaInstTag2) {
        this.set(FIELD_DYNAINSTTAG2, dynaInstTag2);
    }

    @JsonIgnore
    public boolean isDynaInstTag2Dirty() {
        return this.contains(FIELD_DYNAINSTTAG2);
    }

    @JsonIgnore
    public String getLanResTag() {
        Object objValue = this.get(FIELD_LANRESTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lanrestag")
    public void setLanResTag(String lanResTag) {
        this.set(FIELD_LANRESTAG, lanResTag);
    }

    @JsonIgnore
    public boolean isLanResTagDirty() {
        return this.contains(FIELD_LANRESTAG);
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
    public String getModTag() {
        Object objValue = this.get(FIELD_MODTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag")
    public void setModTag(String modTag) {
        this.set(FIELD_MODTAG, modTag);
    }

    @JsonIgnore
    public boolean isModTagDirty() {
        return this.contains(FIELD_MODTAG);
    }

    @JsonIgnore
    public String getModTag2() {
        Object objValue = this.get(FIELD_MODTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag2")
    public void setModTag2(String modTag2) {
        this.set(FIELD_MODTAG2, modTag2);
    }

    @JsonIgnore
    public boolean isModTag2Dirty() {
        return this.contains(FIELD_MODTAG2);
    }

    @JsonIgnore
    public String getModTag3() {
        Object objValue = this.get(FIELD_MODTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag3")
    public void setModTag3(String modTag3) {
        this.set(FIELD_MODTAG3, modTag3);
    }

    @JsonIgnore
    public boolean isModTag3Dirty() {
        return this.contains(FIELD_MODTAG3);
    }

    @JsonIgnore
    public String getModTag4() {
        Object objValue = this.get(FIELD_MODTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modtag4")
    public void setModTag4(String modTag4) {
        this.set(FIELD_MODTAG4, modTag4);
    }

    @JsonIgnore
    public boolean isModTag4Dirty() {
        return this.contains(FIELD_MODTAG4);
    }

    @JsonIgnore
    public String getModuleSN() {
        Object objValue = this.get(FIELD_MODULESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modulesn")
    public void setModuleSN(String moduleSN) {
        this.set(FIELD_MODULESN, moduleSN);
    }

    @JsonIgnore
    public boolean isModuleSNDirty() {
        return this.contains(FIELD_MODULESN);
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
    public String getPKGCodeName() {
        Object objValue = this.get(FIELD_PKGCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgcodename")
    public void setPKGCodeName(String pKGCodeName) {
        this.set(FIELD_PKGCODENAME, pKGCodeName);
    }

    @JsonIgnore
    public boolean isPKGCodeNameDirty() {
        return this.contains(FIELD_PKGCODENAME);
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
    public String getPSSysSFPubId() {
        Object objValue = this.get(FIELD_PSSYSSFPUBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubid")
    public void setPSSysSFPubId(String pSSysSFPubId) {
        this.set(FIELD_PSSYSSFPUBID, pSSysSFPubId);
    }

    @JsonIgnore
    public boolean isPSSysSFPubIdDirty() {
        return this.contains(FIELD_PSSYSSFPUBID);
    }

    @JsonIgnore
    public String getPSSysSFPubName() {
        Object objValue = this.get(FIELD_PSSYSSFPUBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpubname")
    public void setPSSysSFPubName(String pSSysSFPubName) {
        this.set(FIELD_PSSYSSFPUBNAME, pSSysSFPubName);
    }

    @JsonIgnore
    public boolean isPSSysSFPubNameDirty() {
        return this.contains(FIELD_PSSYSSFPUBNAME);
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
    public String getShortTag() {
        Object objValue = this.get(FIELD_SHORTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="shorttag")
    public void setShortTag(String shortTag) {
        this.set(FIELD_SHORTTAG, shortTag);
    }

    @JsonIgnore
    public boolean isShortTagDirty() {
        return this.contains(FIELD_SHORTTAG);
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
    public String getUtilParams() {
        Object objValue = this.get(FIELD_UTILPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparams")
    public void setUtilParams(String utilParams) {
        this.set(FIELD_UTILPARAMS, utilParams);
    }

    @JsonIgnore
    public boolean isUtilParamsDirty() {
        return this.contains(FIELD_UTILPARAMS);
    }

    @JsonIgnore
    public String getUtilTag() {
        Object objValue = this.get(FIELD_UTILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltag")
    public void setUtilTag(String utilTag) {
        this.set(FIELD_UTILTAG, utilTag);
    }

    @JsonIgnore
    public boolean isUtilTagDirty() {
        return this.contains(FIELD_UTILTAG);
    }

    @JsonIgnore
    public String getUtilType() {
        Object objValue = this.get(FIELD_UTILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltype")
    public void setUtilType(String utilType) {
        this.set(FIELD_UTILTYPE, utilType);
    }

    @JsonIgnore
    public boolean isUtilTypeDirty() {
        return this.contains(FIELD_UTILTYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSModuleId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSModuleId(strValue);
    }
}

