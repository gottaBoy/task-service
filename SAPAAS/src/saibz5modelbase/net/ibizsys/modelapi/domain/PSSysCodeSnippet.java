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

public class PSSysCodeSnippet
extends PSModelBase {
    public static final String FIELD_CODEREFMODE = "coderefmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDCCODESNIPPETID = "psdccodesnippetid";
    public static final String FIELD_PSDCCODESNIPPETNAME = "psdccodesnippetname";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSPFSTYLEID = "pspfstyleid";
    public static final String FIELD_PSPFSTYLENAME = "pspfstylename";
    public static final String FIELD_PSSFID = "pssfid";
    public static final String FIELD_PSSFNAME = "pssfname";
    public static final String FIELD_PSSFSTYLEID = "pssfstyleid";
    public static final String FIELD_PSSFSTYLENAME = "pssfstylename";
    public static final String FIELD_PSSYSCODESNIPPETID = "pssyscodesnippetid";
    public static final String FIELD_PSSYSCODESNIPPETNAME = "pssyscodesnippetname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_TEMPLTYPE = "templtype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public String getCodeRefMode() {
        Object objValue = this.get(FIELD_CODEREFMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="coderefmode")
    public void setCodeRefMode(String codeRefMode) {
        this.set(FIELD_CODEREFMODE, codeRefMode);
    }

    @JsonIgnore
    public boolean isCodeRefModeDirty() {
        return this.contains(FIELD_CODEREFMODE);
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
    public String getPSDCCodeSnippetId() {
        Object objValue = this.get(FIELD_PSDCCODESNIPPETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdccodesnippetid")
    public void setPSDCCodeSnippetId(String pSDCCodeSnippetId) {
        this.set(FIELD_PSDCCODESNIPPETID, pSDCCodeSnippetId);
    }

    @JsonIgnore
    public boolean isPSDCCodeSnippetIdDirty() {
        return this.contains(FIELD_PSDCCODESNIPPETID);
    }

    @JsonIgnore
    public String getPSDCCodeSnippetName() {
        Object objValue = this.get(FIELD_PSDCCODESNIPPETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdccodesnippetname")
    public void setPSDCCodeSnippetName(String pSDCCodeSnippetName) {
        this.set(FIELD_PSDCCODESNIPPETNAME, pSDCCodeSnippetName);
    }

    @JsonIgnore
    public boolean isPSDCCodeSnippetNameDirty() {
        return this.contains(FIELD_PSDCCODESNIPPETNAME);
    }

    @JsonIgnore
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
    }

    @JsonIgnore
    public String getPSPFStyleId() {
        Object objValue = this.get(FIELD_PSPFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstyleid")
    public void setPSPFStyleId(String pSPFStyleId) {
        this.set(FIELD_PSPFSTYLEID, pSPFStyleId);
    }

    @JsonIgnore
    public boolean isPSPFStyleIdDirty() {
        return this.contains(FIELD_PSPFSTYLEID);
    }

    @JsonIgnore
    public String getPSPFStyleName() {
        Object objValue = this.get(FIELD_PSPFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstylename")
    public void setPSPFStyleName(String pSPFStyleName) {
        this.set(FIELD_PSPFSTYLENAME, pSPFStyleName);
    }

    @JsonIgnore
    public boolean isPSPFStyleNameDirty() {
        return this.contains(FIELD_PSPFSTYLENAME);
    }

    @JsonIgnore
    public String getPSSFId() {
        Object objValue = this.get(FIELD_PSSFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfid")
    public void setPSSFId(String pSSFId) {
        this.set(FIELD_PSSFID, pSSFId);
    }

    @JsonIgnore
    public boolean isPSSFIdDirty() {
        return this.contains(FIELD_PSSFID);
    }

    @JsonIgnore
    public String getPSSFName() {
        Object objValue = this.get(FIELD_PSSFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfname")
    public void setPSSFName(String pSSFName) {
        this.set(FIELD_PSSFNAME, pSSFName);
    }

    @JsonIgnore
    public boolean isPSSFNameDirty() {
        return this.contains(FIELD_PSSFNAME);
    }

    @JsonIgnore
    public String getPSSFStyleId() {
        Object objValue = this.get(FIELD_PSSFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstyleid")
    public void setPSSFStyleId(String pSSFStyleId) {
        this.set(FIELD_PSSFSTYLEID, pSSFStyleId);
    }

    @JsonIgnore
    public boolean isPSSFStyleIdDirty() {
        return this.contains(FIELD_PSSFSTYLEID);
    }

    @JsonIgnore
    public String getPSSFStyleName() {
        Object objValue = this.get(FIELD_PSSFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfstylename")
    public void setPSSFStyleName(String pSSFStyleName) {
        this.set(FIELD_PSSFSTYLENAME, pSSFStyleName);
    }

    @JsonIgnore
    public boolean isPSSFStyleNameDirty() {
        return this.contains(FIELD_PSSFSTYLENAME);
    }

    @JsonIgnore
    public String getPSSysCodeSnippetId() {
        Object objValue = this.get(FIELD_PSSYSCODESNIPPETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscodesnippetid")
    public void setPSSysCodeSnippetId(String pSSysCodeSnippetId) {
        this.set(FIELD_PSSYSCODESNIPPETID, pSSysCodeSnippetId);
    }

    @JsonIgnore
    public boolean isPSSysCodeSnippetIdDirty() {
        return this.contains(FIELD_PSSYSCODESNIPPETID);
    }

    @JsonIgnore
    public String getPSSysCodeSnippetName() {
        Object objValue = this.get(FIELD_PSSYSCODESNIPPETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscodesnippetname")
    public void setPSSysCodeSnippetName(String pSSysCodeSnippetName) {
        this.set(FIELD_PSSYSCODESNIPPETNAME, pSSysCodeSnippetName);
    }

    @JsonIgnore
    public boolean isPSSysCodeSnippetNameDirty() {
        return this.contains(FIELD_PSSYSCODESNIPPETNAME);
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
    public String getTemplType() {
        Object objValue = this.get(FIELD_TEMPLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="templtype")
    public void setTemplType(String templType) {
        this.set(FIELD_TEMPLTYPE, templType);
    }

    @JsonIgnore
    public boolean isTemplTypeDirty() {
        return this.contains(FIELD_TEMPLTYPE);
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
    public Integer getValidFlag() {
        Object objValue = this.get(FIELD_VALIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="validflag")
    public void setValidFlag(Integer validFlag) {
        this.set(FIELD_VALIDFLAG, validFlag);
    }

    @JsonIgnore
    public boolean isValidFlagDirty() {
        return this.contains(FIELD_VALIDFLAG);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysCodeSnippetId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysCodeSnippetId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSCODESNIPPET";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysCodeSnippet item = (PSSysCodeSnippet)MAPPER.readValue(new File(strJsonFilePath), PSSysCodeSnippet.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysCodeSnippet) {
            PSSysCodeSnippet pSSysCodeSnippet = (PSSysCodeSnippet)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysCodeSnippet) {
            PSSysCodeSnippet pSSysCodeSnippet = (PSSysCodeSnippet)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

