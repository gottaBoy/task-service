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

public class PSAppPanelView
extends PSAppView {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_PANELSTYLE = "panelstyle";
    public static final String FIELD_PANELWIDTH = "panelwidth";
    public static final String FIELD_PSAPPPANELVIEWID = "psapppanelviewid";
    public static final String FIELD_PSAPPPANELVIEWNAME = "psapppanelviewname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getLayoutMode() {
        Object objValue = this.get(FIELD_LAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="layoutmode")
    public void setLayoutMode(String layoutMode) {
        this.set(FIELD_LAYOUTMODE, layoutMode);
    }

    @JsonIgnore
    public boolean isLayoutModeDirty() {
        return this.contains(FIELD_LAYOUTMODE);
    }

    @JsonIgnore
    public String getPanelStyle() {
        Object objValue = this.get(FIELD_PANELSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="panelstyle")
    public void setPanelStyle(String panelStyle) {
        this.set(FIELD_PANELSTYLE, panelStyle);
    }

    @JsonIgnore
    public boolean isPanelStyleDirty() {
        return this.contains(FIELD_PANELSTYLE);
    }

    @JsonIgnore
    public Integer getPanelWidth() {
        Object objValue = this.get(FIELD_PANELWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panelwidth")
    public void setPanelWidth(Integer panelWidth) {
        this.set(FIELD_PANELWIDTH, panelWidth);
    }

    @JsonIgnore
    public boolean isPanelWidthDirty() {
        return this.contains(FIELD_PANELWIDTH);
    }

    @JsonIgnore
    public String getPSAppPanelViewId() {
        Object objValue = this.get(FIELD_PSAPPPANELVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapppanelviewid")
    public void setPSAppPanelViewId(String pSAppPanelViewId) {
        this.set(FIELD_PSAPPPANELVIEWID, pSAppPanelViewId);
    }

    @JsonIgnore
    public boolean isPSAppPanelViewIdDirty() {
        return this.contains(FIELD_PSAPPPANELVIEWID);
    }

    @JsonIgnore
    public String getPSAppPanelViewName() {
        Object objValue = this.get(FIELD_PSAPPPANELVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapppanelviewname")
    public void setPSAppPanelViewName(String pSAppPanelViewName) {
        this.set(FIELD_PSAPPPANELVIEWNAME, pSAppPanelViewName);
    }

    @JsonIgnore
    public boolean isPSAppPanelViewNameDirty() {
        return this.contains(FIELD_PSAPPPANELVIEWNAME);
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
        return this.getPSAppPanelViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppPanelViewId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPPANELVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppPanelView item = (PSAppPanelView)MAPPER.readValue(new File(strJsonFilePath), PSAppPanelView.class);
        item.to(this, false, false);
        this.setPSAppViewType("APPPANELVIEW");
        this.setPSAppViewName(this.getPSAppPanelViewName());
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppPanelView) {
            PSAppPanelView pSAppPanelView = (PSAppPanelView)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppPanelView) {
            PSAppPanelView pSAppPanelView = (PSAppPanelView)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

