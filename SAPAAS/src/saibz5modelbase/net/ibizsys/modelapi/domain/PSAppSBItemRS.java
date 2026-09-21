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

public class PSAppSBItemRS
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CPSAPPSBITEMID = "cpsappsbitemid";
    public static final String FIELD_CPSAPPSBITEMNAME = "cpsappsbitemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DSTENDPOINT = "dstendpoint";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSAPPSBITEMID = "ppsappsbitemid";
    public static final String FIELD_PPSAPPSBITEMNAME = "ppsappsbitemname";
    public static final String FIELD_PSAPPSBITEMRSID = "psappsbitemrsid";
    public static final String FIELD_PSAPPSBITEMRSNAME = "psappsbitemrsname";
    public static final String FIELD_PSAPPSTORYBOARDID = "psappstoryboardid";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "psappstoryboardname";
    public static final String FIELD_PSDYNAINSTID = "psdynainstid";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSUSERCASEID = "pssysusercaseid";
    public static final String FIELD_PSSYSUSERCASENAME = "pssysusercasename";
    public static final String FIELD_RSTAG = "rstag";
    public static final String FIELD_RSTAG2 = "rstag2";
    public static final String FIELD_RSTAG3 = "rstag3";
    public static final String FIELD_RSTAG4 = "rstag4";
    public static final String FIELD_RSTYPE = "rstype";
    public static final String FIELD_SRCENDPOINT = "srcendpoint";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERFLAG = "userflag";
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
    public String getCPSAppSBItemId() {
        Object objValue = this.get(FIELD_CPSAPPSBITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsappsbitemid")
    public void setCPSAppSBItemId(String cPSAppSBItemId) {
        this.set(FIELD_CPSAPPSBITEMID, cPSAppSBItemId);
    }

    @JsonIgnore
    public boolean isCPSAppSBItemIdDirty() {
        return this.contains(FIELD_CPSAPPSBITEMID);
    }

    @JsonIgnore
    public String getCPSAppSBItemName() {
        Object objValue = this.get(FIELD_CPSAPPSBITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsappsbitemname")
    public void setCPSAppSBItemName(String cPSAppSBItemName) {
        this.set(FIELD_CPSAPPSBITEMNAME, cPSAppSBItemName);
    }

    @JsonIgnore
    public boolean isCPSAppSBItemNameDirty() {
        return this.contains(FIELD_CPSAPPSBITEMNAME);
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
    public String getDstEndPoint() {
        Object objValue = this.get(FIELD_DSTENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstendpoint")
    public void setDstEndPoint(String dstEndPoint) {
        this.set(FIELD_DSTENDPOINT, dstEndPoint);
    }

    @JsonIgnore
    public boolean isDstEndPointDirty() {
        return this.contains(FIELD_DSTENDPOINT);
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
    public String getPPSAppSBItemId() {
        Object objValue = this.get(FIELD_PPSAPPSBITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsappsbitemid")
    public void setPPSAppSBItemId(String pPSAppSBItemId) {
        this.set(FIELD_PPSAPPSBITEMID, pPSAppSBItemId);
    }

    @JsonIgnore
    public boolean isPPSAppSBItemIdDirty() {
        return this.contains(FIELD_PPSAPPSBITEMID);
    }

    @JsonIgnore
    public String getPPSAppSBItemName() {
        Object objValue = this.get(FIELD_PPSAPPSBITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsappsbitemname")
    public void setPPSAppSBItemName(String pPSAppSBItemName) {
        this.set(FIELD_PPSAPPSBITEMNAME, pPSAppSBItemName);
    }

    @JsonIgnore
    public boolean isPPSAppSBItemNameDirty() {
        return this.contains(FIELD_PPSAPPSBITEMNAME);
    }

    @JsonIgnore
    public String getPSAppSBItemRSId() {
        Object objValue = this.get(FIELD_PSAPPSBITEMRSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsbitemrsid")
    public void setPSAppSBItemRSId(String pSAppSBItemRSId) {
        this.set(FIELD_PSAPPSBITEMRSID, pSAppSBItemRSId);
    }

    @JsonIgnore
    public boolean isPSAppSBItemRSIdDirty() {
        return this.contains(FIELD_PSAPPSBITEMRSID);
    }

    @JsonIgnore
    public String getPSAppSBItemRSName() {
        Object objValue = this.get(FIELD_PSAPPSBITEMRSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsbitemrsname")
    public void setPSAppSBItemRSName(String pSAppSBItemRSName) {
        this.set(FIELD_PSAPPSBITEMRSNAME, pSAppSBItemRSName);
    }

    @JsonIgnore
    public boolean isPSAppSBItemRSNameDirty() {
        return this.contains(FIELD_PSAPPSBITEMRSNAME);
    }

    @JsonIgnore
    public String getPSAppStoryBoardId() {
        Object objValue = this.get(FIELD_PSAPPSTORYBOARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappstoryboardid")
    public void setPSAppStoryBoardId(String pSAppStoryBoardId) {
        this.set(FIELD_PSAPPSTORYBOARDID, pSAppStoryBoardId);
    }

    @JsonIgnore
    public boolean isPSAppStoryBoardIdDirty() {
        return this.contains(FIELD_PSAPPSTORYBOARDID);
    }

    @JsonIgnore
    public String getPSAppStoryBoardName() {
        Object objValue = this.get(FIELD_PSAPPSTORYBOARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappstoryboardname")
    public void setPSAppStoryBoardName(String pSAppStoryBoardName) {
        this.set(FIELD_PSAPPSTORYBOARDNAME, pSAppStoryBoardName);
    }

    @JsonIgnore
    public boolean isPSAppStoryBoardNameDirty() {
        return this.contains(FIELD_PSAPPSTORYBOARDNAME);
    }

    @JsonIgnore
    public String getPSDynaInstId() {
        Object objValue = this.get(FIELD_PSDYNAINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynainstid")
    public void setPSDynaInstId(String pSDynaInstId) {
        this.set(FIELD_PSDYNAINSTID, pSDynaInstId);
    }

    @JsonIgnore
    public boolean isPSDynaInstIdDirty() {
        return this.contains(FIELD_PSDYNAINSTID);
    }

    @JsonIgnore
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
    }

    @JsonIgnore
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public String getRSTag() {
        Object objValue = this.get(FIELD_RSTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag")
    public void setRSTag(String rSTag) {
        this.set(FIELD_RSTAG, rSTag);
    }

    @JsonIgnore
    public boolean isRSTagDirty() {
        return this.contains(FIELD_RSTAG);
    }

    @JsonIgnore
    public String getRSTag2() {
        Object objValue = this.get(FIELD_RSTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag2")
    public void setRSTag2(String rSTag2) {
        this.set(FIELD_RSTAG2, rSTag2);
    }

    @JsonIgnore
    public boolean isRSTag2Dirty() {
        return this.contains(FIELD_RSTAG2);
    }

    @JsonIgnore
    public String getRSTag3() {
        Object objValue = this.get(FIELD_RSTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag3")
    public void setRSTag3(String rSTag3) {
        this.set(FIELD_RSTAG3, rSTag3);
    }

    @JsonIgnore
    public boolean isRSTag3Dirty() {
        return this.contains(FIELD_RSTAG3);
    }

    @JsonIgnore
    public String getRSTag4() {
        Object objValue = this.get(FIELD_RSTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rstag4")
    public void setRSTag4(String rSTag4) {
        this.set(FIELD_RSTAG4, rSTag4);
    }

    @JsonIgnore
    public boolean isRSTag4Dirty() {
        return this.contains(FIELD_RSTAG4);
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
    public String getSrcEndPoint() {
        Object objValue = this.get(FIELD_SRCENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcendpoint")
    public void setSrcEndPoint(String srcEndPoint) {
        this.set(FIELD_SRCENDPOINT, srcEndPoint);
    }

    @JsonIgnore
    public boolean isSrcEndPointDirty() {
        return this.contains(FIELD_SRCENDPOINT);
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
    public Integer getUserFlag() {
        Object objValue = this.get(FIELD_USERFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userflag")
    public void setUserFlag(Integer userFlag) {
        this.set(FIELD_USERFLAG, userFlag);
    }

    @JsonIgnore
    public boolean isUserFlagDirty() {
        return this.contains(FIELD_USERFLAG);
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
        return this.getPSAppSBItemRSId();
    }

    public void setSrfkey(String strValue) {
        this.setPSAppSBItemRSId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPSBITEMRS";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppSBItemRS item = (PSAppSBItemRS)MAPPER.readValue(new File(strJsonFilePath), PSAppSBItemRS.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppSBItemRS) {
            PSAppSBItemRS pSAppSBItemRS = (PSAppSBItemRS)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppSBItemRS) {
            PSAppSBItemRS pSAppSBItemRS = (PSAppSBItemRS)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

