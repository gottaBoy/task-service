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

public class PSSysSFPubDTO
extends PSModelDTOBase {
    public static final String FIELD_BASECLSPARAMS = "baseclsparams";
    public static final String FIELD_BASECLSPKGCODENAME = "baseclspkgcodename";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPUB = "defaultpub";
    public static final String FIELD_DOCPSSFSTYLEID = "docpssfstyleid";
    public static final String FIELD_DOCPSSFSTYLENAME = "docpssfstylename";
    public static final String FIELD_DYNAMODELMODE = "dynamodelmode";
    public static final String FIELD_GLOBALTSFLAG = "globaltsflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PKGCODENAME = "pkgcodename";
    public static final String FIELD_PPSSYSSFPUBID = "ppssyssfpubid";
    public static final String FIELD_PPSSYSSFPUBNAME = "ppssyssfpubname";
    public static final String FIELD_PSSFSTYLEID = "pssfstyleid";
    public static final String FIELD_PSSFSTYLENAME = "pssfstylename";
    public static final String FIELD_PSSFSTYLEPARAMID = "pssfstyleparamid";
    public static final String FIELD_PSSFSTYLEPARAMNAME = "pssfstyleparamname";
    public static final String FIELD_PSSFSTYLEVERID = "pssfstyleverid";
    public static final String FIELD_PSSFSTYLEVERNAME = "pssfstylevername";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSFPUBID = "pssyssfpubid";
    public static final String FIELD_PSSYSSFPUBNAME = "pssyssfpubname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUBFOLDER = "pubfolder";
    public static final String FIELD_PUBTAG = "pubtag";
    public static final String FIELD_PUBTAG2 = "pubtag2";
    public static final String FIELD_PUBTAG3 = "pubtag3";
    public static final String FIELD_PUBTAG4 = "pubtag4";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    public static final String FIELD_STYLEPARAMS = "styleparams";
    public static final String FIELD_SUBSYSPKGFLAG = "subsyspkgflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VERSTR = "verstr";

    @JsonIgnore
    public String getBaseClsParams() {
        Object objValue = this.get(FIELD_BASECLSPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclsparams")
    public void setBaseClsParams(String baseClsParams) {
        this.set(FIELD_BASECLSPARAMS, baseClsParams);
    }

    @JsonIgnore
    public boolean isBaseClsParamsDirty() {
        return this.contains(FIELD_BASECLSPARAMS);
    }

    @JsonIgnore
    public String getBaseCLSPKGCodeName() {
        Object objValue = this.get(FIELD_BASECLSPKGCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="baseclspkgcodename")
    public void setBaseCLSPKGCodeName(String baseCLSPKGCodeName) {
        this.set(FIELD_BASECLSPKGCODENAME, baseCLSPKGCodeName);
    }

    @JsonIgnore
    public boolean isBaseCLSPKGCodeNameDirty() {
        return this.contains(FIELD_BASECLSPKGCODENAME);
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
    public String getContentType() {
        Object objValue = this.get(FIELD_CONTENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contenttype")
    public void setContentType(String contentType) {
        this.set(FIELD_CONTENTTYPE, contentType);
    }

    @JsonIgnore
    public boolean isContentTypeDirty() {
        return this.contains(FIELD_CONTENTTYPE);
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
    public Integer getDefaultPub() {
        Object objValue = this.get(FIELD_DEFAULTPUB);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultpub")
    public void setDefaultPub(Integer defaultPub) {
        this.set(FIELD_DEFAULTPUB, defaultPub);
    }

    @JsonIgnore
    public boolean isDefaultPubDirty() {
        return this.contains(FIELD_DEFAULTPUB);
    }

    @JsonIgnore
    public String getDocPSSFStyleId() {
        Object objValue = this.get(FIELD_DOCPSSFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="docpssfstyleid")
    public void setDocPSSFStyleId(String docPSSFStyleId) {
        this.set(FIELD_DOCPSSFSTYLEID, docPSSFStyleId);
    }

    @JsonIgnore
    public boolean isDocPSSFStyleIdDirty() {
        return this.contains(FIELD_DOCPSSFSTYLEID);
    }

    @JsonIgnore
    public String getDocPSSFStyleName() {
        Object objValue = this.get(FIELD_DOCPSSFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="docpssfstylename")
    public void setDocPSSFStyleName(String docPSSFStyleName) {
        this.set(FIELD_DOCPSSFSTYLENAME, docPSSFStyleName);
    }

    @JsonIgnore
    public boolean isDocPSSFStyleNameDirty() {
        return this.contains(FIELD_DOCPSSFSTYLENAME);
    }

    @JsonIgnore
    public String getDynaModelMode() {
        Object objValue = this.get(FIELD_DYNAMODELMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynamodelmode")
    public void setDynaModelMode(String dynaModelMode) {
        this.set(FIELD_DYNAMODELMODE, dynaModelMode);
    }

    @JsonIgnore
    public boolean isDynaModelModeDirty() {
        return this.contains(FIELD_DYNAMODELMODE);
    }

    @JsonIgnore
    public Integer getGlobalTSFlag() {
        Object objValue = this.get(FIELD_GLOBALTSFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="globaltsflag")
    public void setGlobalTSFlag(Integer globalTSFlag) {
        this.set(FIELD_GLOBALTSFLAG, globalTSFlag);
    }

    @JsonIgnore
    public boolean isGlobalTSFlagDirty() {
        return this.contains(FIELD_GLOBALTSFLAG);
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
    public String getPPSSysSFPubId() {
        Object objValue = this.get(FIELD_PPSSYSSFPUBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssyssfpubid")
    public void setPPSSysSFPubId(String pPSSysSFPubId) {
        this.set(FIELD_PPSSYSSFPUBID, pPSSysSFPubId);
    }

    @JsonIgnore
    public boolean isPPSSysSFPubIdDirty() {
        return this.contains(FIELD_PPSSYSSFPUBID);
    }

    @JsonIgnore
    public String getPPSSysSFPubName() {
        Object objValue = this.get(FIELD_PPSSYSSFPUBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssyssfpubname")
    public void setPPSSysSFPubName(String pPSSysSFPubName) {
        this.set(FIELD_PPSSYSSFPUBNAME, pPSSysSFPubName);
    }

    @JsonIgnore
    public boolean isPPSSysSFPubNameDirty() {
        return this.contains(FIELD_PPSSYSSFPUBNAME);
    }

    @JsonIgnore
    public String getPSSFStyleId() {
        Object objValue = this.get(FIELD_PSSFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstyleid")
    public void setPSSFStyleId(String pSSFStyleId) {
        this.set(FIELD_PSSFSTYLEID, pSSFStyleId);
    }

    @JsonIgnore
    public boolean isPSSFStyleIdDirty() {
        return this.contains(FIELD_PSSFSTYLEID);
    }

    @JsonIgnore
    public String getPSSFStyleName() {
        Object objValue = this.get(FIELD_PSSFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstylename")
    public void setPSSFStyleName(String pSSFStyleName) {
        this.set(FIELD_PSSFSTYLENAME, pSSFStyleName);
    }

    @JsonIgnore
    public boolean isPSSFStyleNameDirty() {
        return this.contains(FIELD_PSSFSTYLENAME);
    }

    @JsonIgnore
    public String getPSSFStyleParamId() {
        Object objValue = this.get(FIELD_PSSFSTYLEPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstyleparamid")
    public void setPSSFStyleParamId(String pSSFStyleParamId) {
        this.set(FIELD_PSSFSTYLEPARAMID, pSSFStyleParamId);
    }

    @JsonIgnore
    public boolean isPSSFStyleParamIdDirty() {
        return this.contains(FIELD_PSSFSTYLEPARAMID);
    }

    @JsonIgnore
    public String getPSSFStyleParamName() {
        Object objValue = this.get(FIELD_PSSFSTYLEPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstyleparamname")
    public void setPSSFStyleParamName(String pSSFStyleParamName) {
        this.set(FIELD_PSSFSTYLEPARAMNAME, pSSFStyleParamName);
    }

    @JsonIgnore
    public boolean isPSSFStyleParamNameDirty() {
        return this.contains(FIELD_PSSFSTYLEPARAMNAME);
    }

    @JsonIgnore
    public String getPSSFStyleVerId() {
        Object objValue = this.get(FIELD_PSSFSTYLEVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstyleverid")
    public void setPSSFStyleVerId(String pSSFStyleVerId) {
        this.set(FIELD_PSSFSTYLEVERID, pSSFStyleVerId);
    }

    @JsonIgnore
    public boolean isPSSFStyleVerIdDirty() {
        return this.contains(FIELD_PSSFSTYLEVERID);
    }

    @JsonIgnore
    public String getPSSFStyleVerName() {
        Object objValue = this.get(FIELD_PSSFSTYLEVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstylevername")
    public void setPSSFStyleVerName(String pSSFStyleVerName) {
        this.set(FIELD_PSSFSTYLEVERNAME, pSSFStyleVerName);
    }

    @JsonIgnore
    public boolean isPSSFStyleVerNameDirty() {
        return this.contains(FIELD_PSSFSTYLEVERNAME);
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
    public String getPubFolder() {
        Object objValue = this.get(FIELD_PUBFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pubfolder")
    public void setPubFolder(String pubFolder) {
        this.set(FIELD_PUBFOLDER, pubFolder);
    }

    @JsonIgnore
    public boolean isPubFolderDirty() {
        return this.contains(FIELD_PUBFOLDER);
    }

    @JsonIgnore
    public String getPubTag() {
        Object objValue = this.get(FIELD_PUBTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pubtag")
    public void setPubTag(String pubTag) {
        this.set(FIELD_PUBTAG, pubTag);
    }

    @JsonIgnore
    public boolean isPubTagDirty() {
        return this.contains(FIELD_PUBTAG);
    }

    @JsonIgnore
    public String getPubTag2() {
        Object objValue = this.get(FIELD_PUBTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pubtag2")
    public void setPubTag2(String pubTag2) {
        this.set(FIELD_PUBTAG2, pubTag2);
    }

    @JsonIgnore
    public boolean isPubTag2Dirty() {
        return this.contains(FIELD_PUBTAG2);
    }

    @JsonIgnore
    public String getPubTag3() {
        Object objValue = this.get(FIELD_PUBTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pubtag3")
    public void setPubTag3(String pubTag3) {
        this.set(FIELD_PUBTAG3, pubTag3);
    }

    @JsonIgnore
    public boolean isPubTag3Dirty() {
        return this.contains(FIELD_PUBTAG3);
    }

    @JsonIgnore
    public String getPubTag4() {
        Object objValue = this.get(FIELD_PUBTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pubtag4")
    public void setPubTag4(String pubTag4) {
        this.set(FIELD_PUBTAG4, pubTag4);
    }

    @JsonIgnore
    public boolean isPubTag4Dirty() {
        return this.contains(FIELD_PUBTAG4);
    }

    @JsonIgnore
    public Integer getRemoveFlag() {
        Object objValue = this.get(FIELD_REMOVEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeflag")
    public void setRemoveFlag(Integer removeFlag) {
        this.set(FIELD_REMOVEFLAG, removeFlag);
    }

    @JsonIgnore
    public boolean isRemoveFlagDirty() {
        return this.contains(FIELD_REMOVEFLAG);
    }

    @JsonIgnore
    public String getStyleParams() {
        Object objValue = this.get(FIELD_STYLEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="styleparams")
    public void setStyleParams(String styleParams) {
        this.set(FIELD_STYLEPARAMS, styleParams);
    }

    @JsonIgnore
    public boolean isStyleParamsDirty() {
        return this.contains(FIELD_STYLEPARAMS);
    }

    @JsonIgnore
    public Integer getSubSysPkgFlag() {
        Object objValue = this.get(FIELD_SUBSYSPKGFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="subsyspkgflag")
    public void setSubSysPkgFlag(Integer subSysPkgFlag) {
        this.set(FIELD_SUBSYSPKGFLAG, subSysPkgFlag);
    }

    @JsonIgnore
    public boolean isSubSysPkgFlagDirty() {
        return this.contains(FIELD_SUBSYSPKGFLAG);
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
    public String getVerStr() {
        Object objValue = this.get(FIELD_VERSTR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="verstr")
    public void setVerStr(String verStr) {
        this.set(FIELD_VERSTR, verStr);
    }

    @JsonIgnore
    public boolean isVerStrDirty() {
        return this.contains(FIELD_VERSTR);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysSFPubId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysSFPubId(strValue);
    }
}

