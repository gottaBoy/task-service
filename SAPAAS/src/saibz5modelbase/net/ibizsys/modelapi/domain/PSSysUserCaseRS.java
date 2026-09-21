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

public class PSSysUserCaseRS
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENT = "content";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSSYSACTORID = "ppssysactorid";
    public static final String FIELD_PPSSYSACTORNAME = "ppssysactorname";
    public static final String FIELD_PPSSYSUSERCASEID = "ppssysusercaseid";
    public static final String FIELD_PPSSYSUSERCASENAME = "ppssysusercasename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSACTORID = "pssysactorid";
    public static final String FIELD_PSSYSACTORNAME = "pssysactorname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUSERCASEID = "pssysusercaseid";
    public static final String FIELD_PSSYSUSERCASENAME = "pssysusercasename";
    public static final String FIELD_PSSYSUSERCASERSID = "pssysusercasersid";
    public static final String FIELD_PSSYSUSERCASERSNAME = "pssysusercasersname";
    public static final String FIELD_RSMODE = "rsmode";
    public static final String FIELD_RSTYPE = "rstype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public String getContent() {
        Object objValue = this.get(FIELD_CONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content")
    public void setContent(String content) {
        this.set(FIELD_CONTENT, content);
    }

    @JsonIgnore
    public boolean isContentDirty() {
        return this.contains(FIELD_CONTENT);
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
    public String getPPSSysActorId() {
        Object objValue = this.get(FIELD_PPSSYSACTORID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysactorid")
    public void setPPSSysActorId(String pPSSysActorId) {
        this.set(FIELD_PPSSYSACTORID, pPSSysActorId);
    }

    @JsonIgnore
    public boolean isPPSSysActorIdDirty() {
        return this.contains(FIELD_PPSSYSACTORID);
    }

    @JsonIgnore
    public String getPPSSysActorName() {
        Object objValue = this.get(FIELD_PPSSYSACTORNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysactorname")
    public void setPPSSysActorName(String pPSSysActorName) {
        this.set(FIELD_PPSSYSACTORNAME, pPSSysActorName);
    }

    @JsonIgnore
    public boolean isPPSSysActorNameDirty() {
        return this.contains(FIELD_PPSSYSACTORNAME);
    }

    @JsonIgnore
    public String getPPSSysUserCaseId() {
        Object objValue = this.get(FIELD_PPSSYSUSERCASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysusercaseid")
    public void setPPSSysUserCaseId(String pPSSysUserCaseId) {
        this.set(FIELD_PPSSYSUSERCASEID, pPSSysUserCaseId);
    }

    @JsonIgnore
    public boolean isPPSSysUserCaseIdDirty() {
        return this.contains(FIELD_PPSSYSUSERCASEID);
    }

    @JsonIgnore
    public String getPPSSysUserCaseName() {
        Object objValue = this.get(FIELD_PPSSYSUSERCASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysusercasename")
    public void setPPSSysUserCaseName(String pPSSysUserCaseName) {
        this.set(FIELD_PPSSYSUSERCASENAME, pPSSysUserCaseName);
    }

    @JsonIgnore
    public boolean isPPSSysUserCaseNameDirty() {
        return this.contains(FIELD_PPSSYSUSERCASENAME);
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
    public String getPSSysActorId() {
        Object objValue = this.get(FIELD_PSSYSACTORID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysactorid")
    public void setPSSysActorId(String pSSysActorId) {
        this.set(FIELD_PSSYSACTORID, pSSysActorId);
    }

    @JsonIgnore
    public boolean isPSSysActorIdDirty() {
        return this.contains(FIELD_PSSYSACTORID);
    }

    @JsonIgnore
    public String getPSSysActorName() {
        Object objValue = this.get(FIELD_PSSYSACTORNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysactorname")
    public void setPSSysActorName(String pSSysActorName) {
        this.set(FIELD_PSSYSACTORNAME, pSSysActorName);
    }

    @JsonIgnore
    public boolean isPSSysActorNameDirty() {
        return this.contains(FIELD_PSSYSACTORNAME);
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
    public String getPSSysUserCaseId() {
        Object objValue = this.get(FIELD_PSSYSUSERCASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercaseid")
    public void setPSSysUserCaseId(String pSSysUserCaseId) {
        this.set(FIELD_PSSYSUSERCASEID, pSSysUserCaseId);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseIdDirty() {
        return this.contains(FIELD_PSSYSUSERCASEID);
    }

    @JsonIgnore
    public String getPSSysUserCaseName() {
        Object objValue = this.get(FIELD_PSSYSUSERCASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercasename")
    public void setPSSysUserCaseName(String pSSysUserCaseName) {
        this.set(FIELD_PSSYSUSERCASENAME, pSSysUserCaseName);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseNameDirty() {
        return this.contains(FIELD_PSSYSUSERCASENAME);
    }

    @JsonIgnore
    public String getPSSysUserCaseRSId() {
        Object objValue = this.get(FIELD_PSSYSUSERCASERSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercasersid")
    public void setPSSysUserCaseRSId(String pSSysUserCaseRSId) {
        this.set(FIELD_PSSYSUSERCASERSID, pSSysUserCaseRSId);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseRSIdDirty() {
        return this.contains(FIELD_PSSYSUSERCASERSID);
    }

    @JsonIgnore
    public String getPSSysUserCaseRSName() {
        Object objValue = this.get(FIELD_PSSYSUSERCASERSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercasersname")
    public void setPSSysUserCaseRSName(String pSSysUserCaseRSName) {
        this.set(FIELD_PSSYSUSERCASERSNAME, pSSysUserCaseRSName);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseRSNameDirty() {
        return this.contains(FIELD_PSSYSUSERCASERSNAME);
    }

    @JsonIgnore
    public String getRSMode() {
        Object objValue = this.get(FIELD_RSMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rsmode")
    public void setRSMode(String rSMode) {
        this.set(FIELD_RSMODE, rSMode);
    }

    @JsonIgnore
    public boolean isRSModeDirty() {
        return this.contains(FIELD_RSMODE);
    }

    @JsonIgnore
    public String getRSType() {
        Object objValue = this.get(FIELD_RSTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstype")
    public void setRSType(String rSType) {
        this.set(FIELD_RSTYPE, rSType);
    }

    @JsonIgnore
    public boolean isRSTypeDirty() {
        return this.contains(FIELD_RSTYPE);
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
        return this.getPSSysUserCaseRSId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysUserCaseRSId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSUSERCASERS";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysUserCaseRS item = (PSSysUserCaseRS)MAPPER.readValue(new File(strJsonFilePath), PSSysUserCaseRS.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysUserCaseRS) {
            PSSysUserCaseRS pSSysUserCaseRS = (PSSysUserCaseRS)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysUserCaseRS) {
            PSSysUserCaseRS pSSysUserCaseRS = (PSSysUserCaseRS)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

