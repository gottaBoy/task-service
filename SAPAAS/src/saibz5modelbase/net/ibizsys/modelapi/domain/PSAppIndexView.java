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
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.util.IPSModel;

public class PSAppIndexView
extends PSAppView {
    public static final String FIELD_APPICONPATH = "appiconpath";
    public static final String FIELD_APPICONPATH2 = "appiconpath2";
    public static final String FIELD_APPSWITCHMODE = "appswitchmode";
    public static final String FIELD_BLANKMODE = "blankmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPAGE = "defaultpage";
    public static final String FIELD_DEFPSAPPVIEWID = "defpsappviewid";
    public static final String FIELD_DEFPSAPPVIEWNAME = "defpsappviewname";
    public static final String FIELD_ENABLECOUNTER = "enablecounter";
    public static final String FIELD_MAINMENUSIDE = "mainmenuside";
    public static final String FIELD_PSAPPINDEXVIEWID = "psappindexviewid";
    public static final String FIELD_PSAPPINDEXVIEWNAME = "psappindexviewname";
    public static final String FIELD_PSAPPMENUID = "psappmenuid";
    public static final String FIELD_PSAPPMENUNAME = "psappmenuname";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

    @JsonIgnore
    public String getAppIconPath() {
        Object objValue = this.get(FIELD_APPICONPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appiconpath")
    public void setAppIconPath(String appIconPath) {
        this.set(FIELD_APPICONPATH, appIconPath);
    }

    @JsonIgnore
    public boolean isAppIconPathDirty() {
        return this.contains(FIELD_APPICONPATH);
    }

    @JsonIgnore
    public String getAppIconPath2() {
        Object objValue = this.get(FIELD_APPICONPATH2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appiconpath2")
    public void setAppIconPath2(String appIconPath2) {
        this.set(FIELD_APPICONPATH2, appIconPath2);
    }

    @JsonIgnore
    public boolean isAppIconPath2Dirty() {
        return this.contains(FIELD_APPICONPATH2);
    }

    @JsonIgnore
    public Integer getAppSwitchMode() {
        Object objValue = this.get(FIELD_APPSWITCHMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appswitchmode")
    public void setAppSwitchMode(Integer appSwitchMode) {
        this.set(FIELD_APPSWITCHMODE, appSwitchMode);
    }

    @JsonIgnore
    public boolean isAppSwitchModeDirty() {
        return this.contains(FIELD_APPSWITCHMODE);
    }

    @JsonIgnore
    public Integer getBlankMode() {
        Object objValue = this.get(FIELD_BLANKMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="blankmode")
    public void setBlankMode(Integer blankMode) {
        this.set(FIELD_BLANKMODE, blankMode);
    }

    @JsonIgnore
    public boolean isBlankModeDirty() {
        return this.contains(FIELD_BLANKMODE);
    }

    @Override
    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @Override
    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @Override
    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @Override
    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @Override
    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @Override
    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public Integer getDefaultPage() {
        Object objValue = this.get(FIELD_DEFAULTPAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultpage")
    public void setDefaultPage(Integer defaultPage) {
        this.set(FIELD_DEFAULTPAGE, defaultPage);
    }

    @JsonIgnore
    public boolean isDefaultPageDirty() {
        return this.contains(FIELD_DEFAULTPAGE);
    }

    @JsonIgnore
    public String getDefPSAppViewId() {
        Object objValue = this.get(FIELD_DEFPSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpsappviewid")
    public void setDefPSAppViewId(String defPSAppViewId) {
        this.set(FIELD_DEFPSAPPVIEWID, defPSAppViewId);
    }

    @JsonIgnore
    public boolean isDefPSAppViewIdDirty() {
        return this.contains(FIELD_DEFPSAPPVIEWID);
    }

    @JsonIgnore
    public String getDefPSAppViewName() {
        Object objValue = this.get(FIELD_DEFPSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defpsappviewname")
    public void setDefPSAppViewName(String defPSAppViewName) {
        this.set(FIELD_DEFPSAPPVIEWNAME, defPSAppViewName);
    }

    @JsonIgnore
    public boolean isDefPSAppViewNameDirty() {
        return this.contains(FIELD_DEFPSAPPVIEWNAME);
    }

    @JsonIgnore
    public Integer getEnableCounter() {
        Object objValue = this.get(FIELD_ENABLECOUNTER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecounter")
    public void setEnableCounter(Integer enableCounter) {
        this.set(FIELD_ENABLECOUNTER, enableCounter);
    }

    @JsonIgnore
    public boolean isEnableCounterDirty() {
        return this.contains(FIELD_ENABLECOUNTER);
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
    public String getPSAppIndexViewId() {
        Object objValue = this.get(FIELD_PSAPPINDEXVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappindexviewid")
    public void setPSAppIndexViewId(String pSAppIndexViewId) {
        this.set(FIELD_PSAPPINDEXVIEWID, pSAppIndexViewId);
    }

    @JsonIgnore
    public boolean isPSAppIndexViewIdDirty() {
        return this.contains(FIELD_PSAPPINDEXVIEWID);
    }

    @JsonIgnore
    public String getPSAppIndexViewName() {
        Object objValue = this.get(FIELD_PSAPPINDEXVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappindexviewname")
    public void setPSAppIndexViewName(String pSAppIndexViewName) {
        this.set(FIELD_PSAPPINDEXVIEWNAME, pSAppIndexViewName);
    }

    @JsonIgnore
    public boolean isPSAppIndexViewNameDirty() {
        return this.contains(FIELD_PSAPPINDEXVIEWNAME);
    }

    @JsonIgnore
    public String getPSAppMenuId() {
        Object objValue = this.get(FIELD_PSAPPMENUID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuid")
    public void setPSAppMenuId(String pSAppMenuId) {
        this.set(FIELD_PSAPPMENUID, pSAppMenuId);
    }

    @JsonIgnore
    public boolean isPSAppMenuIdDirty() {
        return this.contains(FIELD_PSAPPMENUID);
    }

    @JsonIgnore
    public String getPSAppMenuName() {
        Object objValue = this.get(FIELD_PSAPPMENUNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuname")
    public void setPSAppMenuName(String pSAppMenuName) {
        this.set(FIELD_PSAPPMENUNAME, pSAppMenuName);
    }

    @JsonIgnore
    public boolean isPSAppMenuNameDirty() {
        return this.contains(FIELD_PSAPPMENUNAME);
    }

    @JsonIgnore
    public String getPSSysCounterId() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscounterid")
    public void setPSSysCounterId(String pSSysCounterId) {
        this.set(FIELD_PSSYSCOUNTERID, pSSysCounterId);
    }

    @JsonIgnore
    public boolean isPSSysCounterIdDirty() {
        return this.contains(FIELD_PSSYSCOUNTERID);
    }

    @JsonIgnore
    public String getPSSysCounterName() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscountername")
    public void setPSSysCounterName(String pSSysCounterName) {
        this.set(FIELD_PSSYSCOUNTERNAME, pSSysCounterName);
    }

    @JsonIgnore
    public boolean isPSSysCounterNameDirty() {
        return this.contains(FIELD_PSSYSCOUNTERNAME);
    }

    @Override
    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @Override
    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @Override
    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @Override
    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @Override
    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @Override
    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSAppIndexViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppIndexViewId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPINDEXVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppIndexView item = (PSAppIndexView)MAPPER.readValue(new File(strJsonFilePath), PSAppIndexView.class);
        item.to(this, false, false);
        this.setPSAppViewType("APPINDEXVIEW");
        this.setPSAppViewName(this.getPSAppIndexViewName());
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppIndexView) {
            PSAppIndexView pSAppIndexView = (PSAppIndexView)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppIndexView) {
            PSAppIndexView pSAppIndexView = (PSAppIndexView)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

