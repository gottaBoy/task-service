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
import net.ibizsys.modelapi.domain.PSWXMenuItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSWXMenu
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSWXACCOUNTID = "pswxaccountid";
    public static final String FIELD_PSWXACCOUNTNAME = "pswxaccountname";
    public static final String FIELD_PSWXENTAPPID = "pswxentappid";
    public static final String FIELD_PSWXENTAPPNAME = "pswxentappname";
    public static final String FIELD_PSWXMENUID = "pswxmenuid";
    public static final String FIELD_PSWXMENUNAME = "pswxmenuname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSWXMenuItem> pswxmenuitems;

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
    public String getPSWXAccountId() {
        Object objValue = this.get(FIELD_PSWXACCOUNTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxaccountid")
    public void setPSWXAccountId(String pSWXAccountId) {
        this.set(FIELD_PSWXACCOUNTID, pSWXAccountId);
    }

    @JsonIgnore
    public boolean isPSWXAccountIdDirty() {
        return this.contains(FIELD_PSWXACCOUNTID);
    }

    @JsonIgnore
    public String getPSWXAccountName() {
        Object objValue = this.get(FIELD_PSWXACCOUNTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxaccountname")
    public void setPSWXAccountName(String pSWXAccountName) {
        this.set(FIELD_PSWXACCOUNTNAME, pSWXAccountName);
    }

    @JsonIgnore
    public boolean isPSWXAccountNameDirty() {
        return this.contains(FIELD_PSWXACCOUNTNAME);
    }

    @JsonIgnore
    public String getPSWXEntAppId() {
        Object objValue = this.get(FIELD_PSWXENTAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxentappid")
    public void setPSWXEntAppId(String pSWXEntAppId) {
        this.set(FIELD_PSWXENTAPPID, pSWXEntAppId);
    }

    @JsonIgnore
    public boolean isPSWXEntAppIdDirty() {
        return this.contains(FIELD_PSWXENTAPPID);
    }

    @JsonIgnore
    public String getPSWXEntAppName() {
        Object objValue = this.get(FIELD_PSWXENTAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswxentappname")
    public void setPSWXEntAppName(String pSWXEntAppName) {
        this.set(FIELD_PSWXENTAPPNAME, pSWXEntAppName);
    }

    @JsonIgnore
    public boolean isPSWXEntAppNameDirty() {
        return this.contains(FIELD_PSWXENTAPPNAME);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWXMenuId();
    }

    public void setSrfkey(String strValue) {
        this.setPSWXMenuId(strValue);
    }

    public List<PSWXMenuItem> getPswxmenuitems() {
        return this.pswxmenuitems;
    }

    public void setPswxmenuitems(List<PSWXMenuItem> pswxmenuitems) {
        this.pswxmenuitems = pswxmenuitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pswxmenuitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pswxmenuitems")) {
            this.init();
            return this.pswxmenuitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSWXMENU";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSWXMenu item = (PSWXMenu)MAPPER.readValue(new File(strJsonFilePath), PSWXMenu.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSWXMenu) {
            PSWXMenu dst = (PSWXMenu)target;
            if (!bSimple && this.getPswxmenuitems() != null) {
                ArrayList<PSWXMenuItem> pswxmenuitems = new ArrayList<PSWXMenuItem>();
                for (PSWXMenuItem item : this.getPswxmenuitems()) {
                    if (bDeepMode) {
                        PSWXMenuItem newitem = new PSWXMenuItem();
                        item.to(newitem, false, bDeepMode);
                        pswxmenuitems.add(newitem);
                        continue;
                    }
                    pswxmenuitems.add(item);
                }
                dst.setPswxmenuitems(pswxmenuitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSWXMenu) {
            PSWXMenu src = (PSWXMenu)source;
            if (!bSimple && src.getPswxmenuitems() != null) {
                ArrayList<PSWXMenuItem> pswxmenuitems = new ArrayList<PSWXMenuItem>();
                for (PSWXMenuItem item : src.getPswxmenuitems()) {
                    if (bDeepMode) {
                        PSWXMenuItem newItem = new PSWXMenuItem();
                        newItem.from(item, false, bDeepMode);
                        pswxmenuitems.add(newItem);
                        continue;
                    }
                    pswxmenuitems.add(item);
                }
                this.setPswxmenuitems(pswxmenuitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

