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

public class PSSysCssDTO
extends PSModelDTOBase {
    public static final String FIELD_BKCOLOR = "bkcolor";
    public static final String FIELD_BORDER = "border";
    public static final String FIELD_BORDERCOLOR = "bordercolor";
    public static final String FIELD_BORDERSTYLE = "borderstyle";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CSSNAME = "cssname";
    public static final String FIELD_CSSSTYLE = "cssstyle";
    public static final String FIELD_CSSSTYLE2 = "cssstyle2";
    public static final String FIELD_FONTCOLOR = "fontcolor";
    public static final String FIELD_FONTFAMILY = "fontfamily";
    public static final String FIELD_FONTSIZE = "fontsize";
    public static final String FIELD_FONTSTYLE = "fontstyle";
    public static final String FIELD_HALIGN = "halign";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MARGIN = "margin";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_OWNERID = "ownerid";
    public static final String FIELD_OWNERTAG = "ownertag";
    public static final String FIELD_OWNERTYPE = "ownertype";
    public static final String FIELD_PADDING = "padding";
    public static final String FIELD_PSCSSTEMPLID = "pscsstemplid";
    public static final String FIELD_PSCSSTEMPLNAME = "pscsstemplname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCSSCATID = "pssyscsscatid";
    public static final String FIELD_PSSYSCSSCATNAME = "pssyscsscatname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUBLICFLAG = "publicflag";
    public static final String FIELD_SAMPLECONTENT = "samplecontent";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIGN = "valign";

    @JsonIgnore
    public String getBKColor() {
        Object objValue = this.get(FIELD_BKCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bkcolor")
    public void setBKColor(String bKColor) {
        this.set(FIELD_BKCOLOR, bKColor);
    }

    @JsonIgnore
    public boolean isBKColorDirty() {
        return this.contains(FIELD_BKCOLOR);
    }

    @JsonIgnore
    public String getBorder() {
        Object objValue = this.get(FIELD_BORDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="border")
    public void setBorder(String border) {
        this.set(FIELD_BORDER, border);
    }

    @JsonIgnore
    public boolean isBorderDirty() {
        return this.contains(FIELD_BORDER);
    }

    @JsonIgnore
    public String getBorderColor() {
        Object objValue = this.get(FIELD_BORDERCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bordercolor")
    public void setBorderColor(String borderColor) {
        this.set(FIELD_BORDERCOLOR, borderColor);
    }

    @JsonIgnore
    public boolean isBorderColorDirty() {
        return this.contains(FIELD_BORDERCOLOR);
    }

    @JsonIgnore
    public String getBorderStyle() {
        Object objValue = this.get(FIELD_BORDERSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="borderstyle")
    public void setBorderStyle(String borderStyle) {
        this.set(FIELD_BORDERSTYLE, borderStyle);
    }

    @JsonIgnore
    public boolean isBorderStyleDirty() {
        return this.contains(FIELD_BORDERSTYLE);
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
    public String getCSSName() {
        Object objValue = this.get(FIELD_CSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cssname")
    public void setCSSName(String cSSName) {
        this.set(FIELD_CSSNAME, cSSName);
    }

    @JsonIgnore
    public boolean isCSSNameDirty() {
        return this.contains(FIELD_CSSNAME);
    }

    @JsonIgnore
    public String getCSSStyle() {
        Object objValue = this.get(FIELD_CSSSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cssstyle")
    public void setCSSStyle(String cSSStyle) {
        this.set(FIELD_CSSSTYLE, cSSStyle);
    }

    @JsonIgnore
    public boolean isCSSStyleDirty() {
        return this.contains(FIELD_CSSSTYLE);
    }

    @JsonIgnore
    public String getCssStyle2() {
        Object objValue = this.get(FIELD_CSSSTYLE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cssstyle2")
    public void setCssStyle2(String cssStyle2) {
        this.set(FIELD_CSSSTYLE2, cssStyle2);
    }

    @JsonIgnore
    public boolean isCssStyle2Dirty() {
        return this.contains(FIELD_CSSSTYLE2);
    }

    @JsonIgnore
    public String getFontColor() {
        Object objValue = this.get(FIELD_FONTCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fontcolor")
    public void setFontColor(String fontColor) {
        this.set(FIELD_FONTCOLOR, fontColor);
    }

    @JsonIgnore
    public boolean isFontColorDirty() {
        return this.contains(FIELD_FONTCOLOR);
    }

    @JsonIgnore
    public String getFontFamily() {
        Object objValue = this.get(FIELD_FONTFAMILY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fontfamily")
    public void setFontFamily(String fontFamily) {
        this.set(FIELD_FONTFAMILY, fontFamily);
    }

    @JsonIgnore
    public boolean isFontFamilyDirty() {
        return this.contains(FIELD_FONTFAMILY);
    }

    @JsonIgnore
    public Integer getFontSize() {
        Object objValue = this.get(FIELD_FONTSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fontsize")
    public void setFontSize(Integer fontSize) {
        this.set(FIELD_FONTSIZE, fontSize);
    }

    @JsonIgnore
    public boolean isFontSizeDirty() {
        return this.contains(FIELD_FONTSIZE);
    }

    @JsonIgnore
    public Integer getFontStyle() {
        Object objValue = this.get(FIELD_FONTSTYLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fontstyle")
    public void setFontStyle(Integer fontStyle) {
        this.set(FIELD_FONTSTYLE, fontStyle);
    }

    @JsonIgnore
    public boolean isFontStyleDirty() {
        return this.contains(FIELD_FONTSTYLE);
    }

    @JsonIgnore
    public String getHAlign() {
        Object objValue = this.get(FIELD_HALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="halign")
    public void setHAlign(String hAlign) {
        this.set(FIELD_HALIGN, hAlign);
    }

    @JsonIgnore
    public boolean isHAlignDirty() {
        return this.contains(FIELD_HALIGN);
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
    public String getMargin() {
        Object objValue = this.get(FIELD_MARGIN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="margin")
    public void setMargin(String margin) {
        this.set(FIELD_MARGIN, margin);
    }

    @JsonIgnore
    public boolean isMarginDirty() {
        return this.contains(FIELD_MARGIN);
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
    public String getOwnerId() {
        Object objValue = this.get(FIELD_OWNERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownerid")
    public void setOwnerId(String ownerId) {
        this.set(FIELD_OWNERID, ownerId);
    }

    @JsonIgnore
    public boolean isOwnerIdDirty() {
        return this.contains(FIELD_OWNERID);
    }

    @JsonIgnore
    public String getOwnerTag() {
        Object objValue = this.get(FIELD_OWNERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownertag")
    public void setOwnerTag(String ownerTag) {
        this.set(FIELD_OWNERTAG, ownerTag);
    }

    @JsonIgnore
    public boolean isOwnerTagDirty() {
        return this.contains(FIELD_OWNERTAG);
    }

    @JsonIgnore
    public String getOwnerType() {
        Object objValue = this.get(FIELD_OWNERTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownertype")
    public void setOwnerType(String ownerType) {
        this.set(FIELD_OWNERTYPE, ownerType);
    }

    @JsonIgnore
    public boolean isOwnerTypeDirty() {
        return this.contains(FIELD_OWNERTYPE);
    }

    @JsonIgnore
    public String getPadding() {
        Object objValue = this.get(FIELD_PADDING);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="padding")
    public void setPadding(String padding) {
        this.set(FIELD_PADDING, padding);
    }

    @JsonIgnore
    public boolean isPaddingDirty() {
        return this.contains(FIELD_PADDING);
    }

    @JsonIgnore
    public String getPSCssTemplId() {
        Object objValue = this.get(FIELD_PSCSSTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscsstemplid")
    public void setPSCssTemplId(String pSCssTemplId) {
        this.set(FIELD_PSCSSTEMPLID, pSCssTemplId);
    }

    @JsonIgnore
    public boolean isPSCssTemplIdDirty() {
        return this.contains(FIELD_PSCSSTEMPLID);
    }

    @JsonIgnore
    public String getPSCssTemplName() {
        Object objValue = this.get(FIELD_PSCSSTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscsstemplname")
    public void setPSCssTemplName(String pSCssTemplName) {
        this.set(FIELD_PSCSSTEMPLNAME, pSCssTemplName);
    }

    @JsonIgnore
    public boolean isPSCssTemplNameDirty() {
        return this.contains(FIELD_PSCSSTEMPLNAME);
    }

    @JsonIgnore
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
    }

    @JsonIgnore
    public String getPSSysCssCatId() {
        Object objValue = this.get(FIELD_PSSYSCSSCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscsscatid")
    public void setPSSysCssCatId(String pSSysCssCatId) {
        this.set(FIELD_PSSYSCSSCATID, pSSysCssCatId);
    }

    @JsonIgnore
    public boolean isPSSysCssCatIdDirty() {
        return this.contains(FIELD_PSSYSCSSCATID);
    }

    @JsonIgnore
    public String getPSSysCssCatName() {
        Object objValue = this.get(FIELD_PSSYSCSSCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscsscatname")
    public void setPSSysCssCatName(String pSSysCssCatName) {
        this.set(FIELD_PSSYSCSSCATNAME, pSSysCssCatName);
    }

    @JsonIgnore
    public boolean isPSSysCssCatNameDirty() {
        return this.contains(FIELD_PSSYSCSSCATNAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
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
    public Integer getPublicFlag() {
        Object objValue = this.get(FIELD_PUBLICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="publicflag")
    public void setPublicFlag(Integer publicFlag) {
        this.set(FIELD_PUBLICFLAG, publicFlag);
    }

    @JsonIgnore
    public boolean isPublicFlagDirty() {
        return this.contains(FIELD_PUBLICFLAG);
    }

    @JsonIgnore
    public String getSampleContent() {
        Object objValue = this.get(FIELD_SAMPLECONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="samplecontent")
    public void setSampleContent(String sampleContent) {
        this.set(FIELD_SAMPLECONTENT, sampleContent);
    }

    @JsonIgnore
    public boolean isSampleContentDirty() {
        return this.contains(FIELD_SAMPLECONTENT);
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
    public String getVAlign() {
        Object objValue = this.get(FIELD_VALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valign")
    public void setVAlign(String vAlign) {
        this.set(FIELD_VALIGN, vAlign);
    }

    @JsonIgnore
    public boolean isVAlignDirty() {
        return this.contains(FIELD_VALIGN);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysCssId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysCssId(strValue);
    }
}

