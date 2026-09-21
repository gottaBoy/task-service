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

public class PSDEDSDQ
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEDSDQID = "psdedsdqid";
    public static final String FIELD_PSDEDSDQNAME = "psdedsdqname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VIEWCOLLEVEL = "viewcollevel";

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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
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
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
    }

    @JsonIgnore
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
    }

    @JsonIgnore
    public String getPSDEDSDQId() {
        Object objValue = this.get(FIELD_PSDEDSDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsdqid")
    public void setPSDEDSDQId(String pSDEDSDQId) {
        this.set(FIELD_PSDEDSDQID, pSDEDSDQId);
    }

    @JsonIgnore
    public boolean isPSDEDSDQIdDirty() {
        return this.contains(FIELD_PSDEDSDQID);
    }

    @JsonIgnore
    public String getPSDEDSDQName() {
        Object objValue = this.get(FIELD_PSDEDSDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsdqname")
    public void setPSDEDSDQName(String pSDEDSDQName) {
        this.set(FIELD_PSDEDSDQNAME, pSDEDSDQName);
    }

    @JsonIgnore
    public boolean isPSDEDSDQNameDirty() {
        return this.contains(FIELD_PSDEDSDQNAME);
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
    public Integer getViewColLevel() {
        Object objValue = this.get(FIELD_VIEWCOLLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewcollevel")
    public void setViewColLevel(Integer viewColLevel) {
        this.set(FIELD_VIEWCOLLEVEL, viewColLevel);
    }

    @JsonIgnore
    public boolean isViewColLevelDirty() {
        return this.contains(FIELD_VIEWCOLLEVEL);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDSDQId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDSDQId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEDSDQ";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDSDQ item = (PSDEDSDQ)MAPPER.readValue(new File(strJsonFilePath), PSDEDSDQ.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDSDQ) {
            PSDEDSDQ pSDEDSDQ = (PSDEDSDQ)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDSDQ) {
            PSDEDSDQ pSDEDSDQ = (PSDEDSDQ)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

