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
import java.util.List;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSWXMenuItemDTO
extends PSModelDTOBase {
    public static final String FIELD_CAPTION = "caption";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSWXMENUITEMID = "ppswxmenuitemid";
    public static final String FIELD_PPSWXMENUITEMNAME = "ppswxmenuitemname";
    public static final String FIELD_PSWXMENUFUNCID = "pswxmenufuncid";
    public static final String FIELD_PSWXMENUFUNCNAME = "pswxmenufuncname";
    public static final String FIELD_PSWXMENUID = "pswxmenuid";
    public static final String FIELD_PSWXMENUITEMID = "pswxmenuitemid";
    public static final String FIELD_PSWXMENUITEMNAME = "pswxmenuitemname";
    public static final String FIELD_PSWXMENUNAME = "pswxmenuname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSWXMenuItemDTO> pswxmenuitems;

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
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
    public String getPPSWXMenuItemId() {
        Object objValue = this.get(FIELD_PPSWXMENUITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppswxmenuitemid")
    public void setPPSWXMenuItemId(String pPSWXMenuItemId) {
        this.set(FIELD_PPSWXMENUITEMID, pPSWXMenuItemId);
    }

    @JsonIgnore
    public boolean isPPSWXMenuItemIdDirty() {
        return this.contains(FIELD_PPSWXMENUITEMID);
    }

    @JsonIgnore
    public String getPPSWXMenuItemName() {
        Object objValue = this.get(FIELD_PPSWXMENUITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppswxmenuitemname")
    public void setPPSWXMenuItemName(String pPSWXMenuItemName) {
        this.set(FIELD_PPSWXMENUITEMNAME, pPSWXMenuItemName);
    }

    @JsonIgnore
    public boolean isPPSWXMenuItemNameDirty() {
        return this.contains(FIELD_PPSWXMENUITEMNAME);
    }

    @JsonIgnore
    public String getPSWXMenuFuncId() {
        Object objValue = this.get(FIELD_PSWXMENUFUNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenufuncid")
    public void setPSWXMenuFuncId(String pSWXMenuFuncId) {
        this.set(FIELD_PSWXMENUFUNCID, pSWXMenuFuncId);
    }

    @JsonIgnore
    public boolean isPSWXMenuFuncIdDirty() {
        return this.contains(FIELD_PSWXMENUFUNCID);
    }

    @JsonIgnore
    public String getPSWXMenuFuncName() {
        Object objValue = this.get(FIELD_PSWXMENUFUNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenufuncname")
    public void setPSWXMenuFuncName(String pSWXMenuFuncName) {
        this.set(FIELD_PSWXMENUFUNCNAME, pSWXMenuFuncName);
    }

    @JsonIgnore
    public boolean isPSWXMenuFuncNameDirty() {
        return this.contains(FIELD_PSWXMENUFUNCNAME);
    }

    @JsonIgnore
    public String getPSWXMenuId() {
        Object objValue = this.get(FIELD_PSWXMENUID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenuid")
    public void setPSWXMenuId(String pSWXMenuId) {
        this.set(FIELD_PSWXMENUID, pSWXMenuId);
    }

    @JsonIgnore
    public boolean isPSWXMenuIdDirty() {
        return this.contains(FIELD_PSWXMENUID);
    }

    @JsonIgnore
    public String getPSWXMenuItemId() {
        Object objValue = this.get(FIELD_PSWXMENUITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenuitemid")
    public void setPSWXMenuItemId(String pSWXMenuItemId) {
        this.set(FIELD_PSWXMENUITEMID, pSWXMenuItemId);
    }

    @JsonIgnore
    public boolean isPSWXMenuItemIdDirty() {
        return this.contains(FIELD_PSWXMENUITEMID);
    }

    @JsonIgnore
    public String getPSWXMenuItemName() {
        Object objValue = this.get(FIELD_PSWXMENUITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenuitemname")
    public void setPSWXMenuItemName(String pSWXMenuItemName) {
        this.set(FIELD_PSWXMENUITEMNAME, pSWXMenuItemName);
    }

    @JsonIgnore
    public boolean isPSWXMenuItemNameDirty() {
        return this.contains(FIELD_PSWXMENUITEMNAME);
    }

    @JsonIgnore
    public String getPSWXMenuName() {
        Object objValue = this.get(FIELD_PSWXMENUNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxmenuname")
    public void setPSWXMenuName(String pSWXMenuName) {
        this.set(FIELD_PSWXMENUNAME, pSWXMenuName);
    }

    @JsonIgnore
    public boolean isPSWXMenuNameDirty() {
        return this.contains(FIELD_PSWXMENUNAME);
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
        return this.getPSWXMenuItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWXMenuItemId(strValue);
    }

    @JsonProperty(value="pswxmenuitems")
    public List<PSWXMenuItemDTO> getPswxmenuitems() {
        return this.pswxmenuitems;
    }

    @JsonProperty(value="pswxmenuitems")
    public void setPswxmenuitems(List<PSWXMenuItemDTO> pswxmenuitems) {
        this.pswxmenuitems = pswxmenuitems;
    }
}

