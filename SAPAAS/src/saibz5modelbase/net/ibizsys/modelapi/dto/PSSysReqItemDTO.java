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

public class PSSysReqItemDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ITEMSN = "itemsn";
    public static final String FIELD_ITEMTAG = "itemtag";
    public static final String FIELD_ITEMTAG2 = "itemtag2";
    public static final String FIELD_ITEMTYPE = "itemtype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSSYSREQITEMID = "ppssysreqitemid";
    public static final String FIELD_PPSSYSREQITEMNAME = "ppssysreqitemname";
    public static final String FIELD_PSDEVPRDID = "psdevprdid";
    public static final String FIELD_PSDEVPRDNAME = "psdevprdname";
    public static final String FIELD_PSDEVPRDSPECID = "psdevprdspecid";
    public static final String FIELD_PSDEVPRDSPECNAME = "psdevprdspecname";
    public static final String FIELD_PSDEVPRDVERID = "psdevprdverid";
    public static final String FIELD_PSDEVPRDVERNAME = "psdevprdvername";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSREQMODULEID = "pssysreqmoduleid";
    public static final String FIELD_PSSYSREQMODULENAME = "pssysreqmodulename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUSERCASEID = "pssysusercaseid";
    public static final String FIELD_PSSYSUSERCASENAME = "pssysusercasename";
    public static final String FIELD_REQCONTENT = "reqcontent";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VER = "ver";

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
    public String getItemSN() {
        Object objValue = this.get(FIELD_ITEMSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemsn")
    public void setItemSN(String itemSN) {
        this.set(FIELD_ITEMSN, itemSN);
    }

    @JsonIgnore
    public boolean isItemSNDirty() {
        return this.contains(FIELD_ITEMSN);
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
    public String getPPSSysReqItemId() {
        Object objValue = this.get(FIELD_PPSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysreqitemid")
    public void setPPSSysReqItemId(String pPSSysReqItemId) {
        this.set(FIELD_PPSSYSREQITEMID, pPSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPPSSysReqItemIdDirty() {
        return this.contains(FIELD_PPSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPPSSysReqItemName() {
        Object objValue = this.get(FIELD_PPSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysreqitemname")
    public void setPPSSysReqItemName(String pPSSysReqItemName) {
        this.set(FIELD_PPSSYSREQITEMNAME, pPSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPPSSysReqItemNameDirty() {
        return this.contains(FIELD_PPSSYSREQITEMNAME);
    }

    @JsonIgnore
    public String getPSDevPrdId() {
        Object objValue = this.get(FIELD_PSDEVPRDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdid")
    public void setPSDevPrdId(String pSDevPrdId) {
        this.set(FIELD_PSDEVPRDID, pSDevPrdId);
    }

    @JsonIgnore
    public boolean isPSDevPrdIdDirty() {
        return this.contains(FIELD_PSDEVPRDID);
    }

    @JsonIgnore
    public String getPSDevPrdName() {
        Object objValue = this.get(FIELD_PSDEVPRDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdname")
    public void setPSDevPrdName(String pSDevPrdName) {
        this.set(FIELD_PSDEVPRDNAME, pSDevPrdName);
    }

    @JsonIgnore
    public boolean isPSDevPrdNameDirty() {
        return this.contains(FIELD_PSDEVPRDNAME);
    }

    @JsonIgnore
    public String getPSDevPrdSpecId() {
        Object objValue = this.get(FIELD_PSDEVPRDSPECID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdspecid")
    public void setPSDevPrdSpecId(String pSDevPrdSpecId) {
        this.set(FIELD_PSDEVPRDSPECID, pSDevPrdSpecId);
    }

    @JsonIgnore
    public boolean isPSDevPrdSpecIdDirty() {
        return this.contains(FIELD_PSDEVPRDSPECID);
    }

    @JsonIgnore
    public String getPSDevPrdSpecName() {
        Object objValue = this.get(FIELD_PSDEVPRDSPECNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdspecname")
    public void setPSDevPrdSpecName(String pSDevPrdSpecName) {
        this.set(FIELD_PSDEVPRDSPECNAME, pSDevPrdSpecName);
    }

    @JsonIgnore
    public boolean isPSDevPrdSpecNameDirty() {
        return this.contains(FIELD_PSDEVPRDSPECNAME);
    }

    @JsonIgnore
    public String getPSDevPrdVerId() {
        Object objValue = this.get(FIELD_PSDEVPRDVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdverid")
    public void setPSDevPrdVerId(String pSDevPrdVerId) {
        this.set(FIELD_PSDEVPRDVERID, pSDevPrdVerId);
    }

    @JsonIgnore
    public boolean isPSDevPrdVerIdDirty() {
        return this.contains(FIELD_PSDEVPRDVERID);
    }

    @JsonIgnore
    public String getPSDevPrdVerName() {
        Object objValue = this.get(FIELD_PSDEVPRDVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdvername")
    public void setPSDevPrdVerName(String pSDevPrdVerName) {
        this.set(FIELD_PSDEVPRDVERNAME, pSDevPrdVerName);
    }

    @JsonIgnore
    public boolean isPSDevPrdVerNameDirty() {
        return this.contains(FIELD_PSDEVPRDVERNAME);
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
    public String getPSSysReqModuleId() {
        Object objValue = this.get(FIELD_PSSYSREQMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqmoduleid")
    public void setPSSysReqModuleId(String pSSysReqModuleId) {
        this.set(FIELD_PSSYSREQMODULEID, pSSysReqModuleId);
    }

    @JsonIgnore
    public boolean isPSSysReqModuleIdDirty() {
        return this.contains(FIELD_PSSYSREQMODULEID);
    }

    @JsonIgnore
    public String getPSSysReqModuleName() {
        Object objValue = this.get(FIELD_PSSYSREQMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqmodulename")
    public void setPSSysReqModuleName(String pSSysReqModuleName) {
        this.set(FIELD_PSSYSREQMODULENAME, pSSysReqModuleName);
    }

    @JsonIgnore
    public boolean isPSSysReqModuleNameDirty() {
        return this.contains(FIELD_PSSYSREQMODULENAME);
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
    public String getReqContent() {
        Object objValue = this.get(FIELD_REQCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reqcontent")
    public void setReqContent(String reqContent) {
        this.set(FIELD_REQCONTENT, reqContent);
    }

    @JsonIgnore
    public boolean isReqContentDirty() {
        return this.contains(FIELD_REQCONTENT);
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
    public Integer getVer() {
        Object objValue = this.get(FIELD_VER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ver")
    public void setVer(Integer ver) {
        this.set(FIELD_VER, ver);
    }

    @JsonIgnore
    public boolean isVerDirty() {
        return this.contains(FIELD_VER);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysReqItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysReqItemId(strValue);
    }
}

