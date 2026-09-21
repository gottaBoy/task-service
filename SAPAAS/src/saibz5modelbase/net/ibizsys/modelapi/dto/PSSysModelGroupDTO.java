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

public class PSSysModelGroupDTO
extends PSModelDTOBase {
    public static final String FIELD_CLSPKGPARAMS = "clspkgparams";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DTOFORMAT = "dtoformat";
    public static final String FIELD_DYNAINSTMODE = "dynainstmode";
    public static final String FIELD_DYNAINSTTAG = "dynainsttag";
    public static final String FIELD_DYNAINSTTAG2 = "dynainsttag2";
    public static final String FIELD_GROUPPARAMS = "groupparams";
    public static final String FIELD_GROUPTAG = "grouptag";
    public static final String FIELD_GROUPTAG2 = "grouptag2";
    public static final String FIELD_GROUPTAG3 = "grouptag3";
    public static final String FIELD_GROUPTAG4 = "grouptag4";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PFRTOBJECTREPO = "pfrtobjectrepo";
    public static final String FIELD_PKGCODENAME = "pkgcodename";
    public static final String FIELD_PSDCSYSMODELREPOID = "psdcsysmodelrepoid";
    public static final String FIELD_PSDCSYSMODELREPONAME = "psdcsysmodelreponame";
    public static final String FIELD_PSSYSMODELGROUPID = "pssysmodelgroupid";
    public static final String FIELD_PSSYSMODELGROUPNAME = "pssysmodelgroupname";
    public static final String FIELD_PSSYSMODELREPOID = "pssysmodelrepoid";
    public static final String FIELD_PSSYSMODELREPONAME = "pssysmodelreponame";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SFRTOBJECTREPO = "sfrtobjectrepo";
    public static final String FIELD_SYNCMODE = "syncmode";
    public static final String FIELD_SYSMODELFROM = "sysmodelfrom";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getGroupParams() {
        Object objValue = this.get(FIELD_GROUPPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupparams")
    public void setGroupParams(String groupParams) {
        this.set(FIELD_GROUPPARAMS, groupParams);
    }

    @JsonIgnore
    public boolean isGroupParamsDirty() {
        return this.contains(FIELD_GROUPPARAMS);
    }

    @JsonIgnore
    public String getGroupTag() {
        Object objValue = this.get(FIELD_GROUPTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag")
    public void setGroupTag(String groupTag) {
        this.set(FIELD_GROUPTAG, groupTag);
    }

    @JsonIgnore
    public boolean isGroupTagDirty() {
        return this.contains(FIELD_GROUPTAG);
    }

    @JsonIgnore
    public String getGroupTag2() {
        Object objValue = this.get(FIELD_GROUPTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag2")
    public void setGroupTag2(String groupTag2) {
        this.set(FIELD_GROUPTAG2, groupTag2);
    }

    @JsonIgnore
    public boolean isGroupTag2Dirty() {
        return this.contains(FIELD_GROUPTAG2);
    }

    @JsonIgnore
    public String getGroupTag3() {
        Object objValue = this.get(FIELD_GROUPTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag3")
    public void setGroupTag3(String groupTag3) {
        this.set(FIELD_GROUPTAG3, groupTag3);
    }

    @JsonIgnore
    public boolean isGroupTag3Dirty() {
        return this.contains(FIELD_GROUPTAG3);
    }

    @JsonIgnore
    public String getGroupTag4() {
        Object objValue = this.get(FIELD_GROUPTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag4")
    public void setGroupTag4(String groupTag4) {
        this.set(FIELD_GROUPTAG4, groupTag4);
    }

    @JsonIgnore
    public boolean isGroupTag4Dirty() {
        return this.contains(FIELD_GROUPTAG4);
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
    public String getPFRTObjectRepo() {
        Object objValue = this.get(FIELD_PFRTOBJECTREPO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pfrtobjectrepo")
    public void setPFRTObjectRepo(String pFRTObjectRepo) {
        this.set(FIELD_PFRTOBJECTREPO, pFRTObjectRepo);
    }

    @JsonIgnore
    public boolean isPFRTObjectRepoDirty() {
        return this.contains(FIELD_PFRTOBJECTREPO);
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
    public String getPSDCSysModelRepoId() {
        Object objValue = this.get(FIELD_PSDCSYSMODELREPOID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdcsysmodelrepoid")
    public void setPSDCSysModelRepoId(String pSDCSysModelRepoId) {
        this.set(FIELD_PSDCSYSMODELREPOID, pSDCSysModelRepoId);
    }

    @JsonIgnore
    public boolean isPSDCSysModelRepoIdDirty() {
        return this.contains(FIELD_PSDCSYSMODELREPOID);
    }

    @JsonIgnore
    public String getPSDCSysModelRepoName() {
        Object objValue = this.get(FIELD_PSDCSYSMODELREPONAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdcsysmodelreponame")
    public void setPSDCSysModelRepoName(String pSDCSysModelRepoName) {
        this.set(FIELD_PSDCSYSMODELREPONAME, pSDCSysModelRepoName);
    }

    @JsonIgnore
    public boolean isPSDCSysModelRepoNameDirty() {
        return this.contains(FIELD_PSDCSYSMODELREPONAME);
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
    public String getPSSysModelRepoId() {
        Object objValue = this.get(FIELD_PSSYSMODELREPOID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelrepoid")
    public void setPSSysModelRepoId(String pSSysModelRepoId) {
        this.set(FIELD_PSSYSMODELREPOID, pSSysModelRepoId);
    }

    @JsonIgnore
    public boolean isPSSysModelRepoIdDirty() {
        return this.contains(FIELD_PSSYSMODELREPOID);
    }

    @JsonIgnore
    public String getPSSysModelRepoName() {
        Object objValue = this.get(FIELD_PSSYSMODELREPONAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmodelreponame")
    public void setPSSysModelRepoName(String pSSysModelRepoName) {
        this.set(FIELD_PSSYSMODELREPONAME, pSSysModelRepoName);
    }

    @JsonIgnore
    public boolean isPSSysModelRepoNameDirty() {
        return this.contains(FIELD_PSSYSMODELREPONAME);
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
    public String getSFRTObjectRepo() {
        Object objValue = this.get(FIELD_SFRTOBJECTREPO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sfrtobjectrepo")
    public void setSFRTObjectRepo(String sFRTObjectRepo) {
        this.set(FIELD_SFRTOBJECTREPO, sFRTObjectRepo);
    }

    @JsonIgnore
    public boolean isSFRTObjectRepoDirty() {
        return this.contains(FIELD_SFRTOBJECTREPO);
    }

    @JsonIgnore
    public String getSyncMode() {
        Object objValue = this.get(FIELD_SYNCMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="syncmode")
    public void setSyncMode(String syncMode) {
        this.set(FIELD_SYNCMODE, syncMode);
    }

    @JsonIgnore
    public boolean isSyncModeDirty() {
        return this.contains(FIELD_SYNCMODE);
    }

    @JsonIgnore
    public String getSysModelFrom() {
        Object objValue = this.get(FIELD_SYSMODELFROM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysmodelfrom")
    public void setSysModelFrom(String sysModelFrom) {
        this.set(FIELD_SYSMODELFROM, sysModelFrom);
    }

    @JsonIgnore
    public boolean isSysModelFromDirty() {
        return this.contains(FIELD_SYSMODELFROM);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysModelGroupId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysModelGroupId(strValue);
    }
}

