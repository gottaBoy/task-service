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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEGEIUDetail
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_PSDEGEIUDETAILID = "psdegeiudetailid";
    public static final String FIELD_PSDEGEIUDETAILNAME = "psdegeiudetailname";
    public static final String FIELD_PSDEGEIUPDATEID = "psdegeiupdateid";
    public static final String FIELD_PSDEGEIUPDATENAME = "psdegeiupdatename";
    public static final String FIELD_PSDEGRIDCOLID = "psdegridcolid";
    public static final String FIELD_PSDEGRIDCOLNAME = "psdegridcolname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

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
    public String getPSDEGEIUDetailId() {
        Object objValue = this.get(FIELD_PSDEGEIUDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiudetailid")
    public void setPSDEGEIUDetailId(String pSDEGEIUDetailId) {
        this.set(FIELD_PSDEGEIUDETAILID, pSDEGEIUDetailId);
    }

    @JsonIgnore
    public boolean isPSDEGEIUDetailIdDirty() {
        return this.contains(FIELD_PSDEGEIUDETAILID);
    }

    @JsonIgnore
    public String getPSDEGEIUDetailName() {
        Object objValue = this.get(FIELD_PSDEGEIUDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiudetailname")
    public void setPSDEGEIUDetailName(String pSDEGEIUDetailName) {
        this.set(FIELD_PSDEGEIUDETAILNAME, pSDEGEIUDetailName);
    }

    @JsonIgnore
    public boolean isPSDEGEIUDetailNameDirty() {
        return this.contains(FIELD_PSDEGEIUDETAILNAME);
    }

    @JsonIgnore
    public String getPSDEGEIUpdateId() {
        Object objValue = this.get(FIELD_PSDEGEIUPDATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiupdateid")
    public void setPSDEGEIUpdateId(String pSDEGEIUpdateId) {
        this.set(FIELD_PSDEGEIUPDATEID, pSDEGEIUpdateId);
    }

    @JsonIgnore
    public boolean isPSDEGEIUpdateIdDirty() {
        return this.contains(FIELD_PSDEGEIUPDATEID);
    }

    @JsonIgnore
    public String getPSDEGEIUpdateName() {
        Object objValue = this.get(FIELD_PSDEGEIUPDATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegeiupdatename")
    public void setPSDEGEIUpdateName(String pSDEGEIUpdateName) {
        this.set(FIELD_PSDEGEIUPDATENAME, pSDEGEIUpdateName);
    }

    @JsonIgnore
    public boolean isPSDEGEIUpdateNameDirty() {
        return this.contains(FIELD_PSDEGEIUPDATENAME);
    }

    @JsonIgnore
    public String getPSDEGridColId() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolid")
    public void setPSDEGridColId(String pSDEGridColId) {
        this.set(FIELD_PSDEGRIDCOLID, pSDEGridColId);
    }

    @JsonIgnore
    public boolean isPSDEGridColIdDirty() {
        return this.contains(FIELD_PSDEGRIDCOLID);
    }

    @JsonIgnore
    public String getPSDEGridColName() {
        Object objValue = this.get(FIELD_PSDEGRIDCOLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridcolname")
    public void setPSDEGridColName(String pSDEGridColName) {
        this.set(FIELD_PSDEGRIDCOLNAME, pSDEGridColName);
    }

    @JsonIgnore
    public boolean isPSDEGridColNameDirty() {
        return this.contains(FIELD_PSDEGRIDCOLNAME);
    }

    @JsonIgnore
    public String getPSDEGridId() {
        Object objValue = this.get(FIELD_PSDEGRIDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridid")
    public void setPSDEGridId(String pSDEGridId) {
        this.set(FIELD_PSDEGRIDID, pSDEGridId);
    }

    @JsonIgnore
    public boolean isPSDEGridIdDirty() {
        return this.contains(FIELD_PSDEGRIDID);
    }

    @JsonIgnore
    public String getPSDEGridName() {
        Object objValue = this.get(FIELD_PSDEGRIDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridname")
    public void setPSDEGridName(String pSDEGridName) {
        this.set(FIELD_PSDEGRIDNAME, pSDEGridName);
    }

    @JsonIgnore
    public boolean isPSDEGridNameDirty() {
        return this.contains(FIELD_PSDEGRIDNAME);
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
    public String getSrfkey() {
        return this.getPSDEGEIUDetailId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEGEIUDetailId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEGEIUDETAIL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEGEIUDetail item = (PSDEGEIUDetail)MAPPER.readValue(new File(strJsonFilePath), PSDEGEIUDetail.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEGEIUDetail) {
            PSDEGEIUDetail pSDEGEIUDetail = (PSDEGEIUDetail)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEGEIUDetail) {
            PSDEGEIUDetail pSDEGEIUDetail = (PSDEGEIUDetail)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

