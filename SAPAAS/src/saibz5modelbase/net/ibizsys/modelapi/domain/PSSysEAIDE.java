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
import net.ibizsys.modelapi.domain.PSSysEAIDEField;
import net.ibizsys.modelapi.domain.PSSysEAIDER;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysEAIDE
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EAIDETAG = "eaidetag";
    public static final String FIELD_EAIDETAG2 = "eaidetag2";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSEAIDEID = "pssyseaideid";
    public static final String FIELD_PSSYSEAIDENAME = "pssyseaidename";
    public static final String FIELD_PSSYSEAIELEMENTID = "pssyseaielementid";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "pssyseaielementname";
    public static final String FIELD_PSSYSEAISCHEMEID = "pssyseaischemeid";
    public static final String FIELD_PSSYSEAISCHEMENAME = "pssyseaischemename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysEAIDEField> pssyseaidefields;
    private List<PSSysEAIDER> pssyseaiders;

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
    public String getEAIDETag() {
        Object objValue = this.get(FIELD_EAIDETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidetag")
    public void setEAIDETag(String eAIDETag) {
        this.set(FIELD_EAIDETAG, eAIDETag);
    }

    @JsonIgnore
    public boolean isEAIDETagDirty() {
        return this.contains(FIELD_EAIDETAG);
    }

    @JsonIgnore
    public String getEAIDETag2() {
        Object objValue = this.get(FIELD_EAIDETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidetag2")
    public void setEAIDETag2(String eAIDETag2) {
        this.set(FIELD_EAIDETAG2, eAIDETag2);
    }

    @JsonIgnore
    public boolean isEAIDETag2Dirty() {
        return this.contains(FIELD_EAIDETAG2);
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
    public String getPSSysEAIDEId() {
        Object objValue = this.get(FIELD_PSSYSEAIDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaideid")
    public void setPSSysEAIDEId(String pSSysEAIDEId) {
        this.set(FIELD_PSSYSEAIDEID, pSSysEAIDEId);
    }

    @JsonIgnore
    public boolean isPSSysEAIDEIdDirty() {
        return this.contains(FIELD_PSSYSEAIDEID);
    }

    @JsonIgnore
    public String getPSSysEAIDEName() {
        Object objValue = this.get(FIELD_PSSYSEAIDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidename")
    public void setPSSysEAIDEName(String pSSysEAIDEName) {
        this.set(FIELD_PSSYSEAIDENAME, pSSysEAIDEName);
    }

    @JsonIgnore
    public boolean isPSSysEAIDENameDirty() {
        return this.contains(FIELD_PSSYSEAIDENAME);
    }

    @JsonIgnore
    public String getPSSysEAIElementId() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementid")
    public void setPSSysEAIElementId(String pSSysEAIElementId) {
        this.set(FIELD_PSSYSEAIELEMENTID, pSSysEAIElementId);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementIdDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTID);
    }

    @JsonIgnore
    public String getPSSysEAIElementName() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementname")
    public void setPSSysEAIElementName(String pSSysEAIElementName) {
        this.set(FIELD_PSSYSEAIELEMENTNAME, pSSysEAIElementName);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementNameDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTNAME);
    }

    @JsonIgnore
    public String getPSSysEAISchemeId() {
        Object objValue = this.get(FIELD_PSSYSEAISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaischemeid")
    public void setPSSysEAISchemeId(String pSSysEAISchemeId) {
        this.set(FIELD_PSSYSEAISCHEMEID, pSSysEAISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysEAISchemeIdDirty() {
        return this.contains(FIELD_PSSYSEAISCHEMEID);
    }

    @JsonIgnore
    public String getPSSysEAISchemeName() {
        Object objValue = this.get(FIELD_PSSYSEAISCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaischemename")
    public void setPSSysEAISchemeName(String pSSysEAISchemeName) {
        this.set(FIELD_PSSYSEAISCHEMENAME, pSSysEAISchemeName);
    }

    @JsonIgnore
    public boolean isPSSysEAISchemeNameDirty() {
        return this.contains(FIELD_PSSYSEAISCHEMENAME);
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
        return this.getPSSysEAIDEId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysEAIDEId(strValue);
    }

    public List<PSSysEAIDEField> getPssyseaidefields() {
        return this.pssyseaidefields;
    }

    public void setPssyseaidefields(List<PSSysEAIDEField> pssyseaidefields) {
        this.pssyseaidefields = pssyseaidefields;
    }

    public List<PSSysEAIDER> getPssyseaiders() {
        return this.pssyseaiders;
    }

    public void setPssyseaiders(List<PSSysEAIDER> pssyseaiders) {
        this.pssyseaiders = pssyseaiders;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyseaidefields")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssyseaiders")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyseaidefields")) {
            this.init();
            return this.pssyseaidefields;
        }
        if (strName.equalsIgnoreCase("pssyseaiders")) {
            this.init();
            return this.pssyseaiders;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSEAIDE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysEAIDE item = (PSSysEAIDE)MAPPER.readValue(new File(strJsonFilePath), PSSysEAIDE.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysEAIDE) {
            PSSysEAIDE dst = (PSSysEAIDE)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssyseaidefields() != null) {
                    ArrayList<PSSysEAIDEField> pssyseaidefields = new ArrayList<PSSysEAIDEField>();
                    for (PSSysEAIDEField pSSysEAIDEField : this.getPssyseaidefields()) {
                        if (bDeepMode) {
                            newitem = new PSSysEAIDEField();
                            pSSysEAIDEField.to(newitem, false, bDeepMode);
                            pssyseaidefields.add((PSSysEAIDEField)newitem);
                            continue;
                        }
                        pssyseaidefields.add(pSSysEAIDEField);
                    }
                    dst.setPssyseaidefields(pssyseaidefields);
                }
                if (this.getPssyseaiders() != null) {
                    ArrayList<PSSysEAIDER> pssyseaiders = new ArrayList<PSSysEAIDER>();
                    for (PSSysEAIDER pSSysEAIDER : this.getPssyseaiders()) {
                        if (bDeepMode) {
                            newitem = new PSSysEAIDER();
                            pSSysEAIDER.to(newitem, false, bDeepMode);
                            pssyseaiders.add((PSSysEAIDER)newitem);
                            continue;
                        }
                        pssyseaiders.add(pSSysEAIDER);
                    }
                    dst.setPssyseaiders(pssyseaiders);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysEAIDE) {
            PSSysEAIDE src = (PSSysEAIDE)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssyseaidefields() != null) {
                    ArrayList<PSSysEAIDEField> pssyseaidefields = new ArrayList<PSSysEAIDEField>();
                    for (PSSysEAIDEField pSSysEAIDEField : src.getPssyseaidefields()) {
                        if (bDeepMode) {
                            newItem = new PSSysEAIDEField();
                            ((PSSysEAIDEField)newItem).from(pSSysEAIDEField, false, bDeepMode);
                            pssyseaidefields.add((PSSysEAIDEField)newItem);
                            continue;
                        }
                        pssyseaidefields.add(pSSysEAIDEField);
                    }
                    this.setPssyseaidefields(pssyseaidefields);
                }
                if (src.getPssyseaiders() != null) {
                    ArrayList<PSSysEAIDER> pssyseaiders = new ArrayList<PSSysEAIDER>();
                    for (PSSysEAIDER pSSysEAIDER : src.getPssyseaiders()) {
                        if (bDeepMode) {
                            newItem = new PSSysEAIDER();
                            ((PSSysEAIDER)newItem).from(pSSysEAIDER, false, bDeepMode);
                            pssyseaiders.add((PSSysEAIDER)newItem);
                            continue;
                        }
                        pssyseaiders.add(pSSysEAIDER);
                    }
                    this.setPssyseaiders(pssyseaiders);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

