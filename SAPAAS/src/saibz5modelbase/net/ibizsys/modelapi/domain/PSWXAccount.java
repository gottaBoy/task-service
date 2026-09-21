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
import net.ibizsys.modelapi.domain.PSWXEntApp;
import net.ibizsys.modelapi.domain.PSWXLogic;
import net.ibizsys.modelapi.domain.PSWXMenu;
import net.ibizsys.modelapi.domain.PSWXMenuFunc;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSWXAccount
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSWXACCOUNTID = "pswxaccountid";
    public static final String FIELD_PSWXACCOUNTNAME = "pswxaccountname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_WXACCOUNTTYPE = "wxaccounttype";
    private List<PSWXEntApp> pswxentapps;
    private List<PSWXLogic> pswxlogics;
    private List<PSWXMenu> pswxmenus;
    private List<PSWXMenuFunc> pswxmenufuncs;

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
    public String getWXAccountType() {
        Object objValue = this.get(FIELD_WXACCOUNTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wxaccounttype")
    public void setWXAccountType(String wXAccountType) {
        this.set(FIELD_WXACCOUNTTYPE, wXAccountType);
    }

    @JsonIgnore
    public boolean isWXAccountTypeDirty() {
        return this.contains(FIELD_WXACCOUNTTYPE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWXAccountId();
    }

    public void setSrfkey(String strValue) {
        this.setPSWXAccountId(strValue);
    }

    public List<PSWXEntApp> getPswxentapps() {
        return this.pswxentapps;
    }

    public void setPswxentapps(List<PSWXEntApp> pswxentapps) {
        this.pswxentapps = pswxentapps;
    }

    public List<PSWXLogic> getPswxlogics() {
        return this.pswxlogics;
    }

    public void setPswxlogics(List<PSWXLogic> pswxlogics) {
        this.pswxlogics = pswxlogics;
    }

    public List<PSWXMenu> getPswxmenus() {
        return this.pswxmenus;
    }

    public void setPswxmenus(List<PSWXMenu> pswxmenus) {
        this.pswxmenus = pswxmenus;
    }

    public List<PSWXMenuFunc> getPswxmenufuncs() {
        return this.pswxmenufuncs;
    }

    public void setPswxmenufuncs(List<PSWXMenuFunc> pswxmenufuncs) {
        this.pswxmenufuncs = pswxmenufuncs;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pswxentapps")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswxlogics")) {
            return true;
        }
        if (bFullMode && strName.equalsIgnoreCase("pswxmenus")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pswxmenufuncs")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pswxentapps")) {
            this.init();
            return this.pswxentapps;
        }
        if (strName.equalsIgnoreCase("pswxlogics")) {
            this.init();
            return this.pswxlogics;
        }
        if (strName.equalsIgnoreCase("pswxmenus")) {
            this.init();
            return this.pswxmenus;
        }
        if (strName.equalsIgnoreCase("pswxmenufuncs")) {
            this.init();
            return this.pswxmenufuncs;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSWXACCOUNT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSWXAccount item = (PSWXAccount)MAPPER.readValue(new File(strJsonFilePath), PSWXAccount.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSWXAccount) {
            PSWXAccount dst = (PSWXAccount)target;
            if (!bSimple && this.getPswxmenufuncs() != null) {
                ArrayList<PSWXMenuFunc> pswxmenufuncs = new ArrayList<PSWXMenuFunc>();
                for (PSWXMenuFunc item : this.getPswxmenufuncs()) {
                    if (bDeepMode) {
                        PSWXMenuFunc newitem = new PSWXMenuFunc();
                        item.to(newitem, false, bDeepMode);
                        pswxmenufuncs.add(newitem);
                        continue;
                    }
                    pswxmenufuncs.add(item);
                }
                dst.setPswxmenufuncs(pswxmenufuncs);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSWXAccount) {
            PSWXAccount src = (PSWXAccount)source;
            if (!bSimple && src.getPswxmenufuncs() != null) {
                ArrayList<PSWXMenuFunc> pswxmenufuncs = new ArrayList<PSWXMenuFunc>();
                for (PSWXMenuFunc item : src.getPswxmenufuncs()) {
                    if (bDeepMode) {
                        PSWXMenuFunc newItem = new PSWXMenuFunc();
                        newItem.from(item, false, bDeepMode);
                        pswxmenufuncs.add(newItem);
                        continue;
                    }
                    pswxmenufuncs.add(item);
                }
                this.setPswxmenufuncs(pswxmenufuncs);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

