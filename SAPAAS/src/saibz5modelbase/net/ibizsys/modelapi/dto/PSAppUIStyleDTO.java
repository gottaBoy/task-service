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

public class PSAppUIStyleDTO
extends PSModelDTOBase {
    public static final String FIELD_ACMINCHARS = "acminchars";
    public static final String FIELD_APPFOLDER = "appfolder";
    public static final String FIELD_APPPKGNAME = "apppkgname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MAINMENUSIDE = "mainmenuside";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PFSTYLEPARAM = "pfstyleparam";
    public static final String FIELD_PSAPPUISTYLEID = "psappuistyleid";
    public static final String FIELD_PSAPPUISTYLENAME = "psappuistylename";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSPFSTYLEID = "pspfstyleid";
    public static final String FIELD_PSPFSTYLENAME = "pspfstylename";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_ROOTPSAPPVIEWID = "rootpsappviewid";
    public static final String FIELD_ROOTPSAPPVIEWNAME = "rootpsappviewname";
    public static final String FIELD_UISTYLE = "uistyle";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public Integer getACMinChars() {
        Object objValue = this.get(FIELD_ACMINCHARS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="acminchars")
    public void setACMinChars(Integer aCMinChars) {
        this.set(FIELD_ACMINCHARS, aCMinChars);
    }

    @JsonIgnore
    public boolean isACMinCharsDirty() {
        return this.contains(FIELD_ACMINCHARS);
    }

    @JsonIgnore
    public String getAppFolder() {
        Object objValue = this.get(FIELD_APPFOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appfolder")
    public void setAppFolder(String appFolder) {
        this.set(FIELD_APPFOLDER, appFolder);
    }

    @JsonIgnore
    public boolean isAppFolderDirty() {
        return this.contains(FIELD_APPFOLDER);
    }

    @JsonIgnore
    public String getAppPKGName() {
        Object objValue = this.get(FIELD_APPPKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="apppkgname")
    public void setAppPKGName(String appPKGName) {
        this.set(FIELD_APPPKGNAME, appPKGName);
    }

    @JsonIgnore
    public boolean isAppPKGNameDirty() {
        return this.contains(FIELD_APPPKGNAME);
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
    public String getMainMenuSide() {
        Object objValue = this.get(FIELD_MAINMENUSIDE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mainmenuside")
    public void setMainMenuSide(String mainMenuSide) {
        this.set(FIELD_MAINMENUSIDE, mainMenuSide);
    }

    @JsonIgnore
    public boolean isMainMenuSideDirty() {
        return this.contains(FIELD_MAINMENUSIDE);
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
    public String getPFStyleParam() {
        Object objValue = this.get(FIELD_PFSTYLEPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pfstyleparam")
    public void setPFStyleParam(String pFStyleParam) {
        this.set(FIELD_PFSTYLEPARAM, pFStyleParam);
    }

    @JsonIgnore
    public boolean isPFStyleParamDirty() {
        return this.contains(FIELD_PFSTYLEPARAM);
    }

    @JsonIgnore
    public String getPSAppUIStyleId() {
        Object objValue = this.get(FIELD_PSAPPUISTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappuistyleid")
    public void setPSAppUIStyleId(String pSAppUIStyleId) {
        this.set(FIELD_PSAPPUISTYLEID, pSAppUIStyleId);
    }

    @JsonIgnore
    public boolean isPSAppUIStyleIdDirty() {
        return this.contains(FIELD_PSAPPUISTYLEID);
    }

    @JsonIgnore
    public String getPSAppUIStyleName() {
        Object objValue = this.get(FIELD_PSAPPUISTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappuistylename")
    public void setPSAppUIStyleName(String pSAppUIStyleName) {
        this.set(FIELD_PSAPPUISTYLENAME, pSAppUIStyleName);
    }

    @JsonIgnore
    public boolean isPSAppUIStyleNameDirty() {
        return this.contains(FIELD_PSAPPUISTYLENAME);
    }

    @JsonIgnore
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
    }

    @JsonIgnore
    public String getPSPFStyleId() {
        Object objValue = this.get(FIELD_PSPFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstyleid")
    public void setPSPFStyleId(String pSPFStyleId) {
        this.set(FIELD_PSPFSTYLEID, pSPFStyleId);
    }

    @JsonIgnore
    public boolean isPSPFStyleIdDirty() {
        return this.contains(FIELD_PSPFSTYLEID);
    }

    @JsonIgnore
    public String getPSPFStyleName() {
        Object objValue = this.get(FIELD_PSPFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstylename")
    public void setPSPFStyleName(String pSPFStyleName) {
        this.set(FIELD_PSPFSTYLENAME, pSPFStyleName);
    }

    @JsonIgnore
    public boolean isPSPFStyleNameDirty() {
        return this.contains(FIELD_PSPFSTYLENAME);
    }

    @JsonIgnore
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
    }

    @JsonIgnore
    public String getRootPSAppViewId() {
        Object objValue = this.get(FIELD_ROOTPSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rootpsappviewid")
    public void setRootPSAppViewId(String rootPSAppViewId) {
        this.set(FIELD_ROOTPSAPPVIEWID, rootPSAppViewId);
    }

    @JsonIgnore
    public boolean isRootPSAppViewIdDirty() {
        return this.contains(FIELD_ROOTPSAPPVIEWID);
    }

    @JsonIgnore
    public String getRootPSAppViewName() {
        Object objValue = this.get(FIELD_ROOTPSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rootpsappviewname")
    public void setRootPSAppViewName(String rootPSAppViewName) {
        this.set(FIELD_ROOTPSAPPVIEWNAME, rootPSAppViewName);
    }

    @JsonIgnore
    public boolean isRootPSAppViewNameDirty() {
        return this.contains(FIELD_ROOTPSAPPVIEWNAME);
    }

    @JsonIgnore
    public String getUIStyle() {
        Object objValue = this.get(FIELD_UISTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uistyle")
    public void setUIStyle(String uIStyle) {
        this.set(FIELD_UISTYLE, uIStyle);
    }

    @JsonIgnore
    public boolean isUIStyleDirty() {
        return this.contains(FIELD_UISTYLE);
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
        return this.getPSAppUIStyleId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppUIStyleId(strValue);
    }
}

