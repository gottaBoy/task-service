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

public class PSAppUtilView
extends PSAppView {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ERRCODE = "errcode";
    public static final String FIELD_PSAPPMENUID = "psappmenuid";
    public static final String FIELD_PSAPPMENUNAME = "psappmenuname";
    public static final String FIELD_PSAPPUTILVIEWID = "psapputilviewid";
    public static final String FIELD_PSAPPUTILVIEWNAME = "psapputilviewname";
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
    public String getErrCode() {
        Object objValue = this.get(FIELD_ERRCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errcode")
    public void setErrCode(String errCode) {
        this.set(FIELD_ERRCODE, errCode);
    }

    @JsonIgnore
    public boolean isErrCodeDirty() {
        return this.contains(FIELD_ERRCODE);
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
    public String getPSAppUtilViewId() {
        Object objValue = this.get(FIELD_PSAPPUTILVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapputilviewid")
    public void setPSAppUtilViewId(String pSAppUtilViewId) {
        this.set(FIELD_PSAPPUTILVIEWID, pSAppUtilViewId);
    }

    @JsonIgnore
    public boolean isPSAppUtilViewIdDirty() {
        return this.contains(FIELD_PSAPPUTILVIEWID);
    }

    @JsonIgnore
    public String getPSAppUtilViewName() {
        Object objValue = this.get(FIELD_PSAPPUTILVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapputilviewname")
    public void setPSAppUtilViewName(String pSAppUtilViewName) {
        this.set(FIELD_PSAPPUTILVIEWNAME, pSAppUtilViewName);
    }

    @JsonIgnore
    public boolean isPSAppUtilViewNameDirty() {
        return this.contains(FIELD_PSAPPUTILVIEWNAME);
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
        return this.getPSAppUtilViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppUtilViewId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPUTILVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppUtilView item = (PSAppUtilView)MAPPER.readValue(new File(strJsonFilePath), PSAppUtilView.class);
        item.to(this, false, false);
        this.setPSAppViewType("APPUTILVIEW");
        this.setPSAppViewName(this.getPSAppUtilViewName());
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppUtilView) {
            PSAppUtilView pSAppUtilView = (PSAppUtilView)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppUtilView) {
            PSAppUtilView pSAppUtilView = (PSAppUtilView)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

