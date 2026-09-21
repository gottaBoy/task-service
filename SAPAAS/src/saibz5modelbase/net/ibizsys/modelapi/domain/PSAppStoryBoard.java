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
import net.ibizsys.modelapi.domain.PSAppSBItem;
import net.ibizsys.modelapi.domain.PSAppSBItemRS;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSAppStoryBoard
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSAPPSTORYBOARDID = "psappstoryboardid";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "psappstoryboardname";
    public static final String FIELD_PSDYNAINSTID = "psdynainstid";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_SBTAG = "sbtag";
    public static final String FIELD_SBTAG2 = "sbtag2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSAppSBItem> psappsbitems;
    private List<PSAppSBItemRS> psappsbitemrs;

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
    public String getPSAppStoryBoardId() {
        Object objValue = this.get(FIELD_PSAPPSTORYBOARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappstoryboardid")
    public void setPSAppStoryBoardId(String pSAppStoryBoardId) {
        this.set(FIELD_PSAPPSTORYBOARDID, pSAppStoryBoardId);
    }

    @JsonIgnore
    public boolean isPSAppStoryBoardIdDirty() {
        return this.contains(FIELD_PSAPPSTORYBOARDID);
    }

    @JsonIgnore
    public String getPSAppStoryBoardName() {
        Object objValue = this.get(FIELD_PSAPPSTORYBOARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappstoryboardname")
    public void setPSAppStoryBoardName(String pSAppStoryBoardName) {
        this.set(FIELD_PSAPPSTORYBOARDNAME, pSAppStoryBoardName);
    }

    @JsonIgnore
    public boolean isPSAppStoryBoardNameDirty() {
        return this.contains(FIELD_PSAPPSTORYBOARDNAME);
    }

    @JsonIgnore
    public String getPSDynaInstId() {
        Object objValue = this.get(FIELD_PSDYNAINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynainstid")
    public void setPSDynaInstId(String pSDynaInstId) {
        this.set(FIELD_PSDYNAINSTID, pSDynaInstId);
    }

    @JsonIgnore
    public boolean isPSDynaInstIdDirty() {
        return this.contains(FIELD_PSDYNAINSTID);
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
    public String getSBTag() {
        Object objValue = this.get(FIELD_SBTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sbtag")
    public void setSBTag(String sBTag) {
        this.set(FIELD_SBTAG, sBTag);
    }

    @JsonIgnore
    public boolean isSBTagDirty() {
        return this.contains(FIELD_SBTAG);
    }

    @JsonIgnore
    public String getSBTag2() {
        Object objValue = this.get(FIELD_SBTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sbtag2")
    public void setSBTag2(String sBTag2) {
        this.set(FIELD_SBTAG2, sBTag2);
    }

    @JsonIgnore
    public boolean isSBTag2Dirty() {
        return this.contains(FIELD_SBTAG2);
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
        return this.getPSAppStoryBoardId();
    }

    public void setSrfkey(String strValue) {
        this.setPSAppStoryBoardId(strValue);
    }

    public List<PSAppSBItem> getPsappsbitems() {
        return this.psappsbitems;
    }

    public void setPsappsbitems(List<PSAppSBItem> psappsbitems) {
        this.psappsbitems = psappsbitems;
    }

    public List<PSAppSBItemRS> getPsappsbitemrs() {
        return this.psappsbitemrs;
    }

    public void setPsappsbitemrs(List<PSAppSBItemRS> psappsbitemrs) {
        this.psappsbitemrs = psappsbitemrs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psappsbitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psappsbitemrs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psappsbitems")) {
            this.init();
            return this.psappsbitems;
        }
        if (strName.equalsIgnoreCase("psappsbitemrs")) {
            this.init();
            return this.psappsbitemrs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSAPPSTORYBOARD";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppStoryBoard item = (PSAppStoryBoard)MAPPER.readValue(new File(strJsonFilePath), PSAppStoryBoard.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppStoryBoard) {
            PSAppStoryBoard dst = (PSAppStoryBoard)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsappsbitems() != null) {
                    ArrayList<PSAppSBItem> psappsbitems = new ArrayList<PSAppSBItem>();
                    for (PSAppSBItem pSAppSBItem : this.getPsappsbitems()) {
                        if (bDeepMode) {
                            newitem = new PSAppSBItem();
                            pSAppSBItem.to(newitem, false, bDeepMode);
                            psappsbitems.add((PSAppSBItem)newitem);
                            continue;
                        }
                        psappsbitems.add(pSAppSBItem);
                    }
                    dst.setPsappsbitems(psappsbitems);
                }
                if (this.getPsappsbitemrs() != null) {
                    ArrayList<PSAppSBItemRS> psappsbitemrs = new ArrayList<PSAppSBItemRS>();
                    for (PSAppSBItemRS pSAppSBItemRS : this.getPsappsbitemrs()) {
                        if (bDeepMode) {
                            newitem = new PSAppSBItemRS();
                            pSAppSBItemRS.to(newitem, false, bDeepMode);
                            psappsbitemrs.add((PSAppSBItemRS)newitem);
                            continue;
                        }
                        psappsbitemrs.add(pSAppSBItemRS);
                    }
                    dst.setPsappsbitemrs(psappsbitemrs);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppStoryBoard) {
            PSAppStoryBoard src = (PSAppStoryBoard)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsappsbitems() != null) {
                    ArrayList<PSAppSBItem> psappsbitems = new ArrayList<PSAppSBItem>();
                    for (PSAppSBItem pSAppSBItem : src.getPsappsbitems()) {
                        if (bDeepMode) {
                            newItem = new PSAppSBItem();
                            ((PSAppSBItem)newItem).from(pSAppSBItem, false, bDeepMode);
                            psappsbitems.add((PSAppSBItem)newItem);
                            continue;
                        }
                        psappsbitems.add(pSAppSBItem);
                    }
                    this.setPsappsbitems(psappsbitems);
                }
                if (src.getPsappsbitemrs() != null) {
                    ArrayList<PSAppSBItemRS> psappsbitemrs = new ArrayList<PSAppSBItemRS>();
                    for (PSAppSBItemRS pSAppSBItemRS : src.getPsappsbitemrs()) {
                        if (bDeepMode) {
                            newItem = new PSAppSBItemRS();
                            ((PSAppSBItemRS)newItem).from(pSAppSBItemRS, false, bDeepMode);
                            psappsbitemrs.add((PSAppSBItemRS)newItem);
                            continue;
                        }
                        psappsbitemrs.add(pSAppSBItemRS);
                    }
                    this.setPsappsbitemrs(psappsbitemrs);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

