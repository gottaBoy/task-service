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

public class PSDEDBIdxFieldDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_INCMODE = "incmode";
    public static final String FIELD_INDEXLENGTH = "indexlength";
    public static final String FIELD_PSDEDBIDXFIELDID = "psdedbidxfieldid";
    public static final String FIELD_PSDEDBIDXFIELDNAME = "psdedbidxfieldname";
    public static final String FIELD_PSDEDBINDEXID = "psdedbindexid";
    public static final String FIELD_PSDEDBINDEXNAME = "psdedbindexname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_SORTDIR = "sortdir";
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
    public Integer getIncMode() {
        Object objValue = this.get(FIELD_INCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incmode")
    public void setIncMode(Integer incMode) {
        this.set(FIELD_INCMODE, incMode);
    }

    @JsonIgnore
    public boolean isIncModeDirty() {
        return this.contains(FIELD_INCMODE);
    }

    @JsonIgnore
    public Integer getIndexLength() {
        Object objValue = this.get(FIELD_INDEXLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="indexlength")
    public void setIndexLength(Integer indexLength) {
        this.set(FIELD_INDEXLENGTH, indexLength);
    }

    @JsonIgnore
    public boolean isIndexLengthDirty() {
        return this.contains(FIELD_INDEXLENGTH);
    }

    @JsonIgnore
    public String getPSDEDBIdxFieldId() {
        Object objValue = this.get(FIELD_PSDEDBIDXFIELDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbidxfieldid")
    public void setPSDEDBIdxFieldId(String pSDEDBIdxFieldId) {
        this.set(FIELD_PSDEDBIDXFIELDID, pSDEDBIdxFieldId);
    }

    @JsonIgnore
    public boolean isPSDEDBIdxFieldIdDirty() {
        return this.contains(FIELD_PSDEDBIDXFIELDID);
    }

    @JsonIgnore
    public String getPSDEDBIdxFieldName() {
        Object objValue = this.get(FIELD_PSDEDBIDXFIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbidxfieldname")
    public void setPSDEDBIdxFieldName(String pSDEDBIdxFieldName) {
        this.set(FIELD_PSDEDBIDXFIELDNAME, pSDEDBIdxFieldName);
    }

    @JsonIgnore
    public boolean isPSDEDBIdxFieldNameDirty() {
        return this.contains(FIELD_PSDEDBIDXFIELDNAME);
    }

    @JsonIgnore
    public String getPSDEDBIndexId() {
        Object objValue = this.get(FIELD_PSDEDBINDEXID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbindexid")
    public void setPSDEDBIndexId(String pSDEDBIndexId) {
        this.set(FIELD_PSDEDBINDEXID, pSDEDBIndexId);
    }

    @JsonIgnore
    public boolean isPSDEDBIndexIdDirty() {
        return this.contains(FIELD_PSDEDBINDEXID);
    }

    @JsonIgnore
    public String getPSDEDBIndexName() {
        Object objValue = this.get(FIELD_PSDEDBINDEXNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbindexname")
    public void setPSDEDBIndexName(String pSDEDBIndexName) {
        this.set(FIELD_PSDEDBINDEXNAME, pSDEDBIndexName);
    }

    @JsonIgnore
    public boolean isPSDEDBIndexNameDirty() {
        return this.contains(FIELD_PSDEDBINDEXNAME);
    }

    @JsonIgnore
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
    }

    @JsonIgnore
    public String getPSDEId() {
        Object objValue = this.get(FIELD_PSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeid")
    public void setPSDEId(String pSDEId) {
        this.set(FIELD_PSDEID, pSDEId);
    }

    @JsonIgnore
    public boolean isPSDEIdDirty() {
        return this.contains(FIELD_PSDEID);
    }

    @JsonIgnore
    public String getSortDir() {
        Object objValue = this.get(FIELD_SORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortdir")
    public void setSortDir(String sortDir) {
        this.set(FIELD_SORTDIR, sortDir);
    }

    @JsonIgnore
    public boolean isSortDirDirty() {
        return this.contains(FIELD_SORTDIR);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDBIdxFieldId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDBIdxFieldId(strValue);
    }
}

