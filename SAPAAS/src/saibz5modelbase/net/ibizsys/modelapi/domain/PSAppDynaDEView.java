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

public class PSAppDynaDEView
extends PSAppView {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_PSAPPDYNADEVIEWID = "psappdynadeviewid";
    public static final String FIELD_PSAPPDYNADEVIEWNAME = "psappdynadeviewname";
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
    public String getPSAppDynaDEViewId() {
        Object objValue = this.get(FIELD_PSAPPDYNADEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappdynadeviewid")
    public void setPSAppDynaDEViewId(String pSAppDynaDEViewId) {
        this.set(FIELD_PSAPPDYNADEVIEWID, pSAppDynaDEViewId);
    }

    @JsonIgnore
    public boolean isPSAppDynaDEViewIdDirty() {
        return this.contains(FIELD_PSAPPDYNADEVIEWID);
    }

    @JsonIgnore
    public String getPSAppDynaDEViewName() {
        Object objValue = this.get(FIELD_PSAPPDYNADEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappdynadeviewname")
    public void setPSAppDynaDEViewName(String pSAppDynaDEViewName) {
        this.set(FIELD_PSAPPDYNADEVIEWNAME, pSAppDynaDEViewName);
    }

    @JsonIgnore
    public boolean isPSAppDynaDEViewNameDirty() {
        return this.contains(FIELD_PSAPPDYNADEVIEWNAME);
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
        return this.getPSAppDynaDEViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppDynaDEViewId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPDYNADEVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppDynaDEView item = (PSAppDynaDEView)MAPPER.readValue(new File(strJsonFilePath), PSAppDynaDEView.class);
        item.to(this, false, false);
        this.setPSAppViewType("APPDYNADEVIEW");
        this.setPSAppViewName(this.getPSAppDynaDEViewName());
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppDynaDEView) {
            PSAppDynaDEView pSAppDynaDEView = (PSAppDynaDEView)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppDynaDEView) {
            PSAppDynaDEView pSAppDynaDEView = (PSAppDynaDEView)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

