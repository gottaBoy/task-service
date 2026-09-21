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

public class PSDEFSFItem
extends PSModelBase {
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORTYPENAME = "editortypename";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_ITEMTAG = "itemtag";
    public static final String FIELD_ITEMTAG2 = "itemtag2";
    public static final String FIELD_JSONFORMAT = "jsonformat";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PHPSLANRESID = "phpslanresid";
    public static final String FIELD_PHPSLANRESNAME = "phpslanresname";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEFSFITEMID = "psdefsfitemid";
    public static final String FIELD_PSDEFSFITEMNAME = "psdefsfitemname";
    public static final String FIELD_PSDEFVALUERULEID = "psdefvalueruleid";
    public static final String FIELD_PSDEFVALUERULENAME = "psdefvaluerulename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSDBVFID = "pssysdbvfid";
    public static final String FIELD_PSSYSDBVFNAME = "pssysdbvfname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    public static final String FIELD_REFADPSDELOGICID = "refadpsdelogicid";
    public static final String FIELD_REFADPSDELOGICNAME = "refadpsdelogicname";
    public static final String FIELD_REFMOBMPICKUPPSDEVIEWID = "refmobmpickuppsdeviewid";
    public static final String FIELD_REFMOBMPICKUPPSDEVIEWNAME = "refmobmpickuppsdeviewname";
    public static final String FIELD_REFMOBPICKUPPSDEVIEWID = "refmobpickuppsdeviewid";
    public static final String FIELD_REFMOBPICKUPPSDEVIEWNAME = "refmobpickuppsdeviewname";
    public static final String FIELD_REFMPICKUPPSDEVIEWID = "refmpickuppsdeviewid";
    public static final String FIELD_REFMPICKUPPSDEVIEWNAME = "refmpickuppsdeviewname";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "refpickuppsdeviewid";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "refpickuppsdeviewname";
    public static final String FIELD_REFPSDEACMODEID = "refpsdeacmodeid";
    public static final String FIELD_REFPSDEACMODENAME = "refpsdeacmodename";
    public static final String FIELD_REFPSDEDATASETID = "refpsdedatasetid";
    public static final String FIELD_REFPSDEDATASETNAME = "refpsdedatasetname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSDERID = "refpsderid";
    public static final String FIELD_REFPSDERNAME = "refpsdername";
    public static final String FIELD_SEARCHMODE = "searchmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_WIDTH = "width";

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
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
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
    }

    @JsonIgnore
    public String getEditorType() {
        Object objValue = this.get(FIELD_EDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortype")
    public void setEditorType(String editorType) {
        this.set(FIELD_EDITORTYPE, editorType);
    }

    @JsonIgnore
    public boolean isEditorTypeDirty() {
        return this.contains(FIELD_EDITORTYPE);
    }

    @JsonIgnore
    public String getEditorTypeName() {
        Object objValue = this.get(FIELD_EDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortypename")
    public void setEditorTypeName(String editorTypeName) {
        this.set(FIELD_EDITORTYPENAME, editorTypeName);
    }

    @JsonIgnore
    public boolean isEditorTypeNameDirty() {
        return this.contains(FIELD_EDITORTYPENAME);
    }

    @JsonIgnore
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
    }

    @JsonIgnore
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getItemTag() {
        Object objValue = this.get(FIELD_ITEMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag")
    public void setItemTag(String itemTag) {
        this.set(FIELD_ITEMTAG, itemTag);
    }

    @JsonIgnore
    public boolean isItemTagDirty() {
        return this.contains(FIELD_ITEMTAG);
    }

    @JsonIgnore
    public String getItemTag2() {
        Object objValue = this.get(FIELD_ITEMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtag2")
    public void setItemTag2(String itemTag2) {
        this.set(FIELD_ITEMTAG2, itemTag2);
    }

    @JsonIgnore
    public boolean isItemTag2Dirty() {
        return this.contains(FIELD_ITEMTAG2);
    }

    @JsonIgnore
    public String getJsonFormat() {
        Object objValue = this.get(FIELD_JSONFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jsonformat")
    public void setJsonFormat(String jsonFormat) {
        this.set(FIELD_JSONFORMAT, jsonFormat);
    }

    @JsonIgnore
    public boolean isJsonFormatDirty() {
        return this.contains(FIELD_JSONFORMAT);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
    }

    @JsonIgnore
    public String getLogicName() {
        Object objValue = this.get(FIELD_LOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicname")
    public void setLogicName(String logicName) {
        this.set(FIELD_LOGICNAME, logicName);
    }

    @JsonIgnore
    public boolean isLogicNameDirty() {
        return this.contains(FIELD_LOGICNAME);
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
    public String getPHPSLanResId() {
        Object objValue = this.get(FIELD_PHPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresid")
    public void setPHPSLanResId(String pHPSLanResId) {
        this.set(FIELD_PHPSLANRESID, pHPSLanResId);
    }

    @JsonIgnore
    public boolean isPHPSLanResIdDirty() {
        return this.contains(FIELD_PHPSLANRESID);
    }

    @JsonIgnore
    public String getPHPSLanResName() {
        Object objValue = this.get(FIELD_PHPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresname")
    public void setPHPSLanResName(String pHPSLanResName) {
        this.set(FIELD_PHPSLANRESNAME, pHPSLanResName);
    }

    @JsonIgnore
    public boolean isPHPSLanResNameDirty() {
        return this.contains(FIELD_PHPSLANRESNAME);
    }

    @JsonIgnore
    public String getPlaceHolder() {
        Object objValue = this.get(FIELD_PLACEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="placeholder")
    public void setPlaceHolder(String placeHolder) {
        this.set(FIELD_PLACEHOLDER, placeHolder);
    }

    @JsonIgnore
    public boolean isPlaceHolderDirty() {
        return this.contains(FIELD_PLACEHOLDER);
    }

    @JsonIgnore
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
    }

    @JsonIgnore
    public String getPSDBValueOPId() {
        Object objValue = this.get(FIELD_PSDBVALUEOPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopid")
    public void setPSDBValueOPId(String pSDBValueOPId) {
        this.set(FIELD_PSDBVALUEOPID, pSDBValueOPId);
    }

    @JsonIgnore
    public boolean isPSDBValueOPIdDirty() {
        return this.contains(FIELD_PSDBVALUEOPID);
    }

    @JsonIgnore
    public String getPSDBValueOPName() {
        Object objValue = this.get(FIELD_PSDBVALUEOPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopname")
    public void setPSDBValueOPName(String pSDBValueOPName) {
        this.set(FIELD_PSDBVALUEOPNAME, pSDBValueOPName);
    }

    @JsonIgnore
    public boolean isPSDBValueOPNameDirty() {
        return this.contains(FIELD_PSDBVALUEOPNAME);
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
    public String getPSDEFSFItemId() {
        Object objValue = this.get(FIELD_PSDEFSFITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemid")
    public void setPSDEFSFItemId(String pSDEFSFItemId) {
        this.set(FIELD_PSDEFSFITEMID, pSDEFSFItemId);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemIdDirty() {
        return this.contains(FIELD_PSDEFSFITEMID);
    }

    @JsonIgnore
    public String getPSDEFSFItemName() {
        Object objValue = this.get(FIELD_PSDEFSFITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemname")
    public void setPSDEFSFItemName(String pSDEFSFItemName) {
        this.set(FIELD_PSDEFSFITEMNAME, pSDEFSFItemName);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemNameDirty() {
        return this.contains(FIELD_PSDEFSFITEMNAME);
    }

    @JsonIgnore
    public String getPSDEFValueRuleId() {
        Object objValue = this.get(FIELD_PSDEFVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvalueruleid")
    public void setPSDEFValueRuleId(String pSDEFValueRuleId) {
        this.set(FIELD_PSDEFVALUERULEID, pSDEFValueRuleId);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleIdDirty() {
        return this.contains(FIELD_PSDEFVALUERULEID);
    }

    @JsonIgnore
    public String getPSDEFValueRuleName() {
        Object objValue = this.get(FIELD_PSDEFVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvaluerulename")
    public void setPSDEFValueRuleName(String pSDEFValueRuleName) {
        this.set(FIELD_PSDEFVALUERULENAME, pSDEFValueRuleName);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleNameDirty() {
        return this.contains(FIELD_PSDEFVALUERULENAME);
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
    public String getPSSysDBVFId() {
        Object objValue = this.get(FIELD_PSSYSDBVFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbvfid")
    public void setPSSysDBVFId(String pSSysDBVFId) {
        this.set(FIELD_PSSYSDBVFID, pSSysDBVFId);
    }

    @JsonIgnore
    public boolean isPSSysDBVFIdDirty() {
        return this.contains(FIELD_PSSYSDBVFID);
    }

    @JsonIgnore
    public String getPSSysDBVFName() {
        Object objValue = this.get(FIELD_PSSYSDBVFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbvfname")
    public void setPSSysDBVFName(String pSSysDBVFName) {
        this.set(FIELD_PSSYSDBVFNAME, pSSysDBVFName);
    }

    @JsonIgnore
    public boolean isPSSysDBVFNameDirty() {
        return this.contains(FIELD_PSSYSDBVFNAME);
    }

    @JsonIgnore
    public String getPSSysEditorStyleId() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstyleid")
    public void setPSSysEditorStyleId(String pSSysEditorStyleId) {
        this.set(FIELD_PSSYSEDITORSTYLEID, pSSysEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleIdDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSSysEditorStyleName() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstylename")
    public void setPSSysEditorStyleName(String pSSysEditorStyleName) {
        this.set(FIELD_PSSYSEDITORSTYLENAME, pSSysEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleNameDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLENAME);
    }

    @JsonIgnore
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
    }

    @JsonIgnore
    public String getRefADPSDELogicId() {
        Object objValue = this.get(FIELD_REFADPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refadpsdelogicid")
    public void setRefADPSDELogicId(String refADPSDELogicId) {
        this.set(FIELD_REFADPSDELOGICID, refADPSDELogicId);
    }

    @JsonIgnore
    public boolean isRefADPSDELogicIdDirty() {
        return this.contains(FIELD_REFADPSDELOGICID);
    }

    @JsonIgnore
    public String getRefADPSDELogicName() {
        Object objValue = this.get(FIELD_REFADPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refadpsdelogicname")
    public void setRefADPSDELogicName(String refADPSDELogicName) {
        this.set(FIELD_REFADPSDELOGICNAME, refADPSDELogicName);
    }

    @JsonIgnore
    public boolean isRefADPSDELogicNameDirty() {
        return this.contains(FIELD_REFADPSDELOGICNAME);
    }

    @JsonIgnore
    public String getRefMobMPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFMOBMPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmobmpickuppsdeviewid")
    public void setRefMobMPickupPSDEViewId(String refMobMPickupPSDEViewId) {
        this.set(FIELD_REFMOBMPICKUPPSDEVIEWID, refMobMPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefMobMPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFMOBMPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefMobMPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFMOBMPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmobmpickuppsdeviewname")
    public void setRefMobMPickupPSDEViewName(String refMobMPickupPSDEViewName) {
        this.set(FIELD_REFMOBMPICKUPPSDEVIEWNAME, refMobMPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefMobMPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFMOBMPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefMobPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFMOBPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmobpickuppsdeviewid")
    public void setRefMobPickupPSDEViewId(String refMobPickupPSDEViewId) {
        this.set(FIELD_REFMOBPICKUPPSDEVIEWID, refMobPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefMobPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFMOBPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefMobPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFMOBPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmobpickuppsdeviewname")
    public void setRefMobPickupPSDEViewName(String refMobPickupPSDEViewName) {
        this.set(FIELD_REFMOBPICKUPPSDEVIEWNAME, refMobPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefMobPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFMOBPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefMPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFMPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmpickuppsdeviewid")
    public void setRefMPickupPSDEViewId(String refMPickupPSDEViewId) {
        this.set(FIELD_REFMPICKUPPSDEVIEWID, refMPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefMPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFMPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefMPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFMPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refmpickuppsdeviewname")
    public void setRefMPickupPSDEViewName(String refMPickupPSDEViewName) {
        this.set(FIELD_REFMPICKUPPSDEVIEWNAME, refMPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefMPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFMPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewid")
    public void setRefPickupPSDEViewId(String refPickupPSDEViewId) {
        this.set(FIELD_REFPICKUPPSDEVIEWID, refPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewname")
    public void setRefPickupPSDEViewName(String refPickupPSDEViewName) {
        this.set(FIELD_REFPICKUPPSDEVIEWNAME, refPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPSDEACModeId() {
        Object objValue = this.get(FIELD_REFPSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodeid")
    public void setRefPSDEACModeId(String refPSDEACModeId) {
        this.set(FIELD_REFPSDEACMODEID, refPSDEACModeId);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeIdDirty() {
        return this.contains(FIELD_REFPSDEACMODEID);
    }

    @JsonIgnore
    public String getRefPSDEACModeName() {
        Object objValue = this.get(FIELD_REFPSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodename")
    public void setRefPSDEACModeName(String refPSDEACModeName) {
        this.set(FIELD_REFPSDEACMODENAME, refPSDEACModeName);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeNameDirty() {
        return this.contains(FIELD_REFPSDEACMODENAME);
    }

    @JsonIgnore
    public String getRefPSDEDataSetId() {
        Object objValue = this.get(FIELD_REFPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetid")
    public void setRefPSDEDataSetId(String refPSDEDataSetId) {
        this.set(FIELD_REFPSDEDATASETID, refPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetIdDirty() {
        return this.contains(FIELD_REFPSDEDATASETID);
    }

    @JsonIgnore
    public String getRefPSDEDataSetName() {
        Object objValue = this.get(FIELD_REFPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetname")
    public void setRefPSDEDataSetName(String refPSDEDataSetName) {
        this.set(FIELD_REFPSDEDATASETNAME, refPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetNameDirty() {
        return this.contains(FIELD_REFPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRefPSDERId() {
        Object objValue = this.get(FIELD_REFPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsderid")
    public void setRefPSDERId(String refPSDERId) {
        this.set(FIELD_REFPSDERID, refPSDERId);
    }

    @JsonIgnore
    public boolean isRefPSDERIdDirty() {
        return this.contains(FIELD_REFPSDERID);
    }

    @JsonIgnore
    public String getRefPSDERName() {
        Object objValue = this.get(FIELD_REFPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdername")
    public void setRefPSDERName(String refPSDERName) {
        this.set(FIELD_REFPSDERNAME, refPSDERName);
    }

    @JsonIgnore
    public boolean isRefPSDERNameDirty() {
        return this.contains(FIELD_REFPSDERNAME);
    }

    @JsonIgnore
    public String getSearchMode() {
        Object objValue = this.get(FIELD_SEARCHMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchmode")
    public void setSearchMode(String searchMode) {
        this.set(FIELD_SEARCHMODE, searchMode);
    }

    @JsonIgnore
    public boolean isSearchModeDirty() {
        return this.contains(FIELD_SEARCHMODE);
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
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
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
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @JsonIgnore
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @JsonIgnore
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEFSFItemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFSFItemId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEFSFITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFSFItem item = (PSDEFSFItem)MAPPER.readValue(new File(strJsonFilePath), PSDEFSFItem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFSFItem) {
            PSDEFSFItem pSDEFSFItem = (PSDEFSFItem)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFSFItem) {
            PSDEFSFItem pSDEFSFItem = (PSDEFSFItem)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

