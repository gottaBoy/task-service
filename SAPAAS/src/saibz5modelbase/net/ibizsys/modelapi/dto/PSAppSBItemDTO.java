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

public class PSAppSBItemDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ITEMTAG = "itemtag";
    public static final String FIELD_ITEMTAG2 = "itemtag2";
    public static final String FIELD_ITEMTAG3 = "itemtag3";
    public static final String FIELD_ITEMTAG4 = "itemtag4";
    public static final String FIELD_ITEMTYPE = "itemtype";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSAPPSBITEMID = "psappsbitemid";
    public static final String FIELD_PSAPPSBITEMNAME = "psappsbitemname";
    public static final String FIELD_PSAPPSTORYBOARDID = "psappstoryboardid";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "psappstoryboardname";
    public static final String FIELD_PSAPPVIEWID = "psappviewid";
    public static final String FIELD_PSAPPVIEWNAME = "psappviewname";
    public static final String FIELD_PSDYNAINSTID = "psdynainstid";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSUSERCASEID = "pssysusercaseid";
    public static final String FIELD_PSSYSUSERCASENAME = "pssysusercasename";
    public static final String FIELD_ROOTITEM = "rootitem";
    public static final String FIELD_TOPPOS = "toppos";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERFLAG = "userflag";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public String getItemTag() {
        Object objValue = this.get(FIELD_ITEMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag")
    public void setItemTag(String itemTag) {
        this.set(FIELD_ITEMTAG, itemTag);
    }

    @JsonIgnore
    public boolean isItemTagDirty() {
        return this.contains(FIELD_ITEMTAG);
    }

    @JsonIgnore
    public String getItemTag2() {
        Object objValue = this.get(FIELD_ITEMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag2")
    public void setItemTag2(String itemTag2) {
        this.set(FIELD_ITEMTAG2, itemTag2);
    }

    @JsonIgnore
    public boolean isItemTag2Dirty() {
        return this.contains(FIELD_ITEMTAG2);
    }

    @JsonIgnore
    public String getItemTag3() {
        Object objValue = this.get(FIELD_ITEMTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag3")
    public void setItemTag3(String itemTag3) {
        this.set(FIELD_ITEMTAG3, itemTag3);
    }

    @JsonIgnore
    public boolean isItemTag3Dirty() {
        return this.contains(FIELD_ITEMTAG3);
    }

    @JsonIgnore
    public String getItemTag4() {
        Object objValue = this.get(FIELD_ITEMTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag4")
    public void setItemTag4(String itemTag4) {
        this.set(FIELD_ITEMTAG4, itemTag4);
    }

    @JsonIgnore
    public boolean isItemTag4Dirty() {
        return this.contains(FIELD_ITEMTAG4);
    }

    @JsonIgnore
    public String getItemType() {
        Object objValue = this.get(FIELD_ITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtype")
    public void setItemType(String itemType) {
        this.set(FIELD_ITEMTYPE, itemType);
    }

    @JsonIgnore
    public boolean isItemTypeDirty() {
        return this.contains(FIELD_ITEMTYPE);
    }

    @JsonIgnore
    public Integer getLeftPos() {
        Object objValue = this.get(FIELD_LEFTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="leftpos")
    public void setLeftPos(Integer leftPos) {
        this.set(FIELD_LEFTPOS, leftPos);
    }

    @JsonIgnore
    public boolean isLeftPosDirty() {
        return this.contains(FIELD_LEFTPOS);
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
    public String getPSAppSBItemId() {
        Object objValue = this.get(FIELD_PSAPPSBITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsbitemid")
    public void setPSAppSBItemId(String pSAppSBItemId) {
        this.set(FIELD_PSAPPSBITEMID, pSAppSBItemId);
    }

    @JsonIgnore
    public boolean isPSAppSBItemIdDirty() {
        return this.contains(FIELD_PSAPPSBITEMID);
    }

    @JsonIgnore
    public String getPSAppSBItemName() {
        Object objValue = this.get(FIELD_PSAPPSBITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsbitemname")
    public void setPSAppSBItemName(String pSAppSBItemName) {
        this.set(FIELD_PSAPPSBITEMNAME, pSAppSBItemName);
    }

    @JsonIgnore
    public boolean isPSAppSBItemNameDirty() {
        return this.contains(FIELD_PSAPPSBITEMNAME);
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
    public String getPSAppViewId() {
        Object objValue = this.get(FIELD_PSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewid")
    public void setPSAppViewId(String pSAppViewId) {
        this.set(FIELD_PSAPPVIEWID, pSAppViewId);
    }

    @JsonIgnore
    public boolean isPSAppViewIdDirty() {
        return this.contains(FIELD_PSAPPVIEWID);
    }

    @JsonIgnore
    public String getPSAppViewName() {
        Object objValue = this.get(FIELD_PSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewname")
    public void setPSAppViewName(String pSAppViewName) {
        this.set(FIELD_PSAPPVIEWNAME, pSAppViewName);
    }

    @JsonIgnore
    public boolean isPSAppViewNameDirty() {
        return this.contains(FIELD_PSAPPVIEWNAME);
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
    public String getPSSysUserCaseId() {
        Object objValue = this.get(FIELD_PSSYSUSERCASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercaseid")
    public void setPSSysUserCaseId(String pSSysUserCaseId) {
        this.set(FIELD_PSSYSUSERCASEID, pSSysUserCaseId);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseIdDirty() {
        return this.contains(FIELD_PSSYSUSERCASEID);
    }

    @JsonIgnore
    public String getPSSysUserCaseName() {
        Object objValue = this.get(FIELD_PSSYSUSERCASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercasename")
    public void setPSSysUserCaseName(String pSSysUserCaseName) {
        this.set(FIELD_PSSYSUSERCASENAME, pSSysUserCaseName);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseNameDirty() {
        return this.contains(FIELD_PSSYSUSERCASENAME);
    }

    @JsonIgnore
    public Integer getRootItem() {
        Object objValue = this.get(FIELD_ROOTITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rootitem")
    public void setRootItem(Integer rootItem) {
        this.set(FIELD_ROOTITEM, rootItem);
    }

    @JsonIgnore
    public boolean isRootItemDirty() {
        return this.contains(FIELD_ROOTITEM);
    }

    @JsonIgnore
    public Integer getTopPos() {
        Object objValue = this.get(FIELD_TOPPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="toppos")
    public void setTopPos(Integer topPos) {
        this.set(FIELD_TOPPOS, topPos);
    }

    @JsonIgnore
    public boolean isTopPosDirty() {
        return this.contains(FIELD_TOPPOS);
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
    public Integer getUserFlag() {
        Object objValue = this.get(FIELD_USERFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userflag")
    public void setUserFlag(Integer userFlag) {
        this.set(FIELD_USERFLAG, userFlag);
    }

    @JsonIgnore
    public boolean isUserFlagDirty() {
        return this.contains(FIELD_USERFLAG);
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
        return this.getPSAppSBItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppSBItemId(strValue);
    }
}

