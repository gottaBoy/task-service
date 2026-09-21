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
import net.ibizsys.modelapi.domain.PSDEDBIdxField;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDBIndex
extends PSModelBase {
    public static final String FIELD_ALLOWREVERSE = "allowreverse";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_INDEXTYPE = "indextype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEDBINDEXID = "psdedbindexid";
    public static final String FIELD_PSDEDBINDEXNAME = "psdedbindexname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_REMOVEFLAG = "removeflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    private List<PSDEDBIdxField> psdedbidxfields;

    @JsonIgnore
    public Integer getAllowReverse() {
        Object objValue = this.get(FIELD_ALLOWREVERSE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowreverse")
    public void setAllowReverse(Integer allowReverse) {
        this.set(FIELD_ALLOWREVERSE, allowReverse);
    }

    @JsonIgnore
    public boolean isAllowReverseDirty() {
        return this.contains(FIELD_ALLOWREVERSE);
    }

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
    public String getIndexType() {
        Object objValue = this.get(FIELD_INDEXTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="indextype")
    public void setIndexType(String indexType) {
        this.set(FIELD_INDEXTYPE, indexType);
    }

    @JsonIgnore
    public boolean isIndexTypeDirty() {
        return this.contains(FIELD_INDEXTYPE);
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
    public String getPSDEName() {
        Object objValue = this.get(FIELD_PSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdename")
    public void setPSDEName(String pSDEName) {
        this.set(FIELD_PSDENAME, pSDEName);
    }

    @JsonIgnore
    public boolean isPSDENameDirty() {
        return this.contains(FIELD_PSDENAME);
    }

    @JsonIgnore
    public Integer getRemoveFlag() {
        Object objValue = this.get(FIELD_REMOVEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="removeflag")
    public void setRemoveFlag(Integer removeFlag) {
        this.set(FIELD_REMOVEFLAG, removeFlag);
    }

    @JsonIgnore
    public boolean isRemoveFlagDirty() {
        return this.contains(FIELD_REMOVEFLAG);
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
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDBIndexId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDBIndexId(strValue);
    }

    public List<PSDEDBIdxField> getPsdedbidxfields() {
        return this.psdedbidxfields;
    }

    public void setPsdedbidxfields(List<PSDEDBIdxField> psdedbidxfields) {
        this.psdedbidxfields = psdedbidxfields;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdedbidxfields")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedbidxfields")) {
            this.init();
            return this.psdedbidxfields;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDBINDEX";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDBIndex item = (PSDEDBIndex)MAPPER.readValue(new File(strJsonFilePath), PSDEDBIndex.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDBIndex) {
            PSDEDBIndex dst = (PSDEDBIndex)target;
            if (!bSimple && this.getPsdedbidxfields() != null) {
                ArrayList<PSDEDBIdxField> psdedbidxfields = new ArrayList<PSDEDBIdxField>();
                for (PSDEDBIdxField item : this.getPsdedbidxfields()) {
                    if (bDeepMode) {
                        PSDEDBIdxField newitem = new PSDEDBIdxField();
                        item.to(newitem, false, bDeepMode);
                        psdedbidxfields.add(newitem);
                        continue;
                    }
                    psdedbidxfields.add(item);
                }
                dst.setPsdedbidxfields(psdedbidxfields);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDBIndex) {
            PSDEDBIndex src = (PSDEDBIndex)source;
            if (!bSimple && src.getPsdedbidxfields() != null) {
                ArrayList<PSDEDBIdxField> psdedbidxfields = new ArrayList<PSDEDBIdxField>();
                for (PSDEDBIdxField item : src.getPsdedbidxfields()) {
                    if (bDeepMode) {
                        PSDEDBIdxField newItem = new PSDEDBIdxField();
                        newItem.from(item, false, bDeepMode);
                        psdedbidxfields.add(newItem);
                        continue;
                    }
                    psdedbidxfields.add(item);
                }
                this.setPsdedbidxfields(psdedbidxfields);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

