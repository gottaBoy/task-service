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

public class PSDEDQCodeDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DBTYPE = "dbtype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEDQCODEID = "psdedqcodeid";
    public static final String FIELD_PSDEDQCODENAME = "psdedqcodename";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_QUERYCODE = "querycode";
    public static final String FIELD_QUERYCODETEMP = "querycodetemp";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERQUERYCODE = "userquerycode";
    public static final String FIELD_USERQUERYCODE2 = "userquerycode2";

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
    public String getDBType() {
        Object objValue = this.get(FIELD_DBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbtype")
    public void setDBType(String dBType) {
        this.set(FIELD_DBTYPE, dBType);
    }

    @JsonIgnore
    public boolean isDBTypeDirty() {
        return this.contains(FIELD_DBTYPE);
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
    public String getPSDEDQCodeId() {
        Object objValue = this.get(FIELD_PSDEDQCODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodeid")
    public void setPSDEDQCodeId(String pSDEDQCodeId) {
        this.set(FIELD_PSDEDQCODEID, pSDEDQCodeId);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeIdDirty() {
        return this.contains(FIELD_PSDEDQCODEID);
    }

    @JsonIgnore
    public String getPSDEDQCodeName() {
        Object objValue = this.get(FIELD_PSDEDQCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcodename")
    public void setPSDEDQCodeName(String pSDEDQCodeName) {
        this.set(FIELD_PSDEDQCODENAME, pSDEDQCodeName);
    }

    @JsonIgnore
    public boolean isPSDEDQCodeNameDirty() {
        return this.contains(FIELD_PSDEDQCODENAME);
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
    public String getQueryCode() {
        Object objValue = this.get(FIELD_QUERYCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="querycode")
    public void setQueryCode(String queryCode) {
        this.set(FIELD_QUERYCODE, queryCode);
    }

    @JsonIgnore
    public boolean isQueryCodeDirty() {
        return this.contains(FIELD_QUERYCODE);
    }

    @JsonIgnore
    public String getQueryCodeTemp() {
        Object objValue = this.get(FIELD_QUERYCODETEMP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="querycodetemp")
    public void setQueryCodeTemp(String queryCodeTemp) {
        this.set(FIELD_QUERYCODETEMP, queryCodeTemp);
    }

    @JsonIgnore
    public boolean isQueryCodeTempDirty() {
        return this.contains(FIELD_QUERYCODETEMP);
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
    public String getUserQueryCode() {
        Object objValue = this.get(FIELD_USERQUERYCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userquerycode")
    public void setUserQueryCode(String userQueryCode) {
        this.set(FIELD_USERQUERYCODE, userQueryCode);
    }

    @JsonIgnore
    public boolean isUserQueryCodeDirty() {
        return this.contains(FIELD_USERQUERYCODE);
    }

    @JsonIgnore
    public String getUserQueryCode2() {
        Object objValue = this.get(FIELD_USERQUERYCODE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userquerycode2")
    public void setUserQueryCode2(String userQueryCode2) {
        this.set(FIELD_USERQUERYCODE2, userQueryCode2);
    }

    @JsonIgnore
    public boolean isUserQueryCode2Dirty() {
        return this.contains(FIELD_USERQUERYCODE2);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDQCodeId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDQCodeId(strValue);
    }
}

