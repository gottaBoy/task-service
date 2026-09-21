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
import net.ibizsys.modelapi.domain.PSSysEAIElementAttr;
import net.ibizsys.modelapi.domain.PSSysEAIElementRE;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysEAIElement
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EAIELEMENTTAG = "eaielementtag";
    public static final String FIELD_EAIELEMENTTAG2 = "eaielementtag2";
    public static final String FIELD_EAIELEMENTTYPE = "eaielementtype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERMODE = "ordermode";
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
    private List<PSSysEAIElementAttr> pssyseaielementattrs;
    private List<PSSysEAIElementRE> pssyseaielementres;

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
    public String getEAIElementTag() {
        Object objValue = this.get(FIELD_EAIELEMENTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaielementtag")
    public void setEAIElementTag(String eAIElementTag) {
        this.set(FIELD_EAIELEMENTTAG, eAIElementTag);
    }

    @JsonIgnore
    public boolean isEAIElementTagDirty() {
        return this.contains(FIELD_EAIELEMENTTAG);
    }

    @JsonIgnore
    public String getEAIElementTag2() {
        Object objValue = this.get(FIELD_EAIELEMENTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaielementtag2")
    public void setEAIElementTag2(String eAIElementTag2) {
        this.set(FIELD_EAIELEMENTTAG2, eAIElementTag2);
    }

    @JsonIgnore
    public boolean isEAIElementTag2Dirty() {
        return this.contains(FIELD_EAIELEMENTTAG2);
    }

    @JsonIgnore
    public String getEAIElementType() {
        Object objValue = this.get(FIELD_EAIELEMENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaielementtype")
    public void setEAIElementType(String eAIElementType) {
        this.set(FIELD_EAIELEMENTTYPE, eAIElementType);
    }

    @JsonIgnore
    public boolean isEAIElementTypeDirty() {
        return this.contains(FIELD_EAIELEMENTTYPE);
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
    public String getOrderMode() {
        Object objValue = this.get(FIELD_ORDERMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordermode")
    public void setOrderMode(String orderMode) {
        this.set(FIELD_ORDERMODE, orderMode);
    }

    @JsonIgnore
    public boolean isOrderModeDirty() {
        return this.contains(FIELD_ORDERMODE);
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
        return this.getPSSysEAIElementId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysEAIElementId(strValue);
    }

    public List<PSSysEAIElementAttr> getPssyseaielementattrs() {
        return this.pssyseaielementattrs;
    }

    public void setPssyseaielementattrs(List<PSSysEAIElementAttr> pssyseaielementattrs) {
        this.pssyseaielementattrs = pssyseaielementattrs;
    }

    public List<PSSysEAIElementRE> getPssyseaielementres() {
        return this.pssyseaielementres;
    }

    public void setPssyseaielementres(List<PSSysEAIElementRE> pssyseaielementres) {
        this.pssyseaielementres = pssyseaielementres;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyseaielementattrs")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssyseaielementres")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyseaielementattrs")) {
            this.init();
            return this.pssyseaielementattrs;
        }
        if (strName.equalsIgnoreCase("pssyseaielementres")) {
            this.init();
            return this.pssyseaielementres;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSEAIELEMENT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysEAIElement item = (PSSysEAIElement)MAPPER.readValue(new File(strJsonFilePath), PSSysEAIElement.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysEAIElement) {
            PSSysEAIElement dst = (PSSysEAIElement)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssyseaielementattrs() != null) {
                    ArrayList<PSSysEAIElementAttr> pssyseaielementattrs = new ArrayList<PSSysEAIElementAttr>();
                    for (PSSysEAIElementAttr pSSysEAIElementAttr : this.getPssyseaielementattrs()) {
                        if (bDeepMode) {
                            newitem = new PSSysEAIElementAttr();
                            pSSysEAIElementAttr.to(newitem, false, bDeepMode);
                            pssyseaielementattrs.add((PSSysEAIElementAttr)newitem);
                            continue;
                        }
                        pssyseaielementattrs.add(pSSysEAIElementAttr);
                    }
                    dst.setPssyseaielementattrs(pssyseaielementattrs);
                }
                if (this.getPssyseaielementres() != null) {
                    ArrayList<PSSysEAIElementRE> pssyseaielementres = new ArrayList<PSSysEAIElementRE>();
                    for (PSSysEAIElementRE pSSysEAIElementRE : this.getPssyseaielementres()) {
                        if (bDeepMode) {
                            newitem = new PSSysEAIElementRE();
                            pSSysEAIElementRE.to(newitem, false, bDeepMode);
                            pssyseaielementres.add((PSSysEAIElementRE)newitem);
                            continue;
                        }
                        pssyseaielementres.add(pSSysEAIElementRE);
                    }
                    dst.setPssyseaielementres(pssyseaielementres);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysEAIElement) {
            PSSysEAIElement src = (PSSysEAIElement)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssyseaielementattrs() != null) {
                    ArrayList<PSSysEAIElementAttr> pssyseaielementattrs = new ArrayList<PSSysEAIElementAttr>();
                    for (PSSysEAIElementAttr pSSysEAIElementAttr : src.getPssyseaielementattrs()) {
                        if (bDeepMode) {
                            newItem = new PSSysEAIElementAttr();
                            ((PSSysEAIElementAttr)newItem).from(pSSysEAIElementAttr, false, bDeepMode);
                            pssyseaielementattrs.add((PSSysEAIElementAttr)newItem);
                            continue;
                        }
                        pssyseaielementattrs.add(pSSysEAIElementAttr);
                    }
                    this.setPssyseaielementattrs(pssyseaielementattrs);
                }
                if (src.getPssyseaielementres() != null) {
                    ArrayList<PSSysEAIElementRE> pssyseaielementres = new ArrayList<PSSysEAIElementRE>();
                    for (PSSysEAIElementRE pSSysEAIElementRE : src.getPssyseaielementres()) {
                        if (bDeepMode) {
                            newItem = new PSSysEAIElementRE();
                            ((PSSysEAIElementRE)newItem).from(pSSysEAIElementRE, false, bDeepMode);
                            pssyseaielementres.add((PSSysEAIElementRE)newItem);
                            continue;
                        }
                        pssyseaielementres.add(pSSysEAIElementRE);
                    }
                    this.setPssyseaielementres(pssyseaielementres);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

