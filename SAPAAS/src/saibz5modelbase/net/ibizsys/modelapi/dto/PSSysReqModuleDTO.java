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

public class PSSysReqModuleDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENT = "content";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODULESN = "modulesn";
    public static final String FIELD_MODULETAG = "moduletag";
    public static final String FIELD_MODULETAG2 = "moduletag2";
    public static final String FIELD_MODULETAG3 = "moduletag3";
    public static final String FIELD_MODULETAG4 = "moduletag4";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSSYSREQMODULEID = "ppssysreqmoduleid";
    public static final String FIELD_PPSSYSREQMODULENAME = "ppssysreqmodulename";
    public static final String FIELD_PSDEVPRDID = "psdevprdid";
    public static final String FIELD_PSDEVPRDNAME = "psdevprdname";
    public static final String FIELD_PSDEVPRDVERID = "psdevprdverid";
    public static final String FIELD_PSDEVPRDVERNAME = "psdevprdvername";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSREQMODULEID = "pssysreqmoduleid";
    public static final String FIELD_PSSYSREQMODULENAME = "pssysreqmodulename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getModuleSN() {
        Object objValue = this.get(FIELD_MODULESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modulesn")
    public void setModuleSN(String moduleSN) {
        this.set(FIELD_MODULESN, moduleSN);
    }

    @JsonIgnore
    public boolean isModuleSNDirty() {
        return this.contains(FIELD_MODULESN);
    }

    @JsonIgnore
    public String getModuleTag() {
        Object objValue = this.get(FIELD_MODULETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moduletag")
    public void setModuleTag(String moduleTag) {
        this.set(FIELD_MODULETAG, moduleTag);
    }

    @JsonIgnore
    public boolean isModuleTagDirty() {
        return this.contains(FIELD_MODULETAG);
    }

    @JsonIgnore
    public String getModuleTag2() {
        Object objValue = this.get(FIELD_MODULETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moduletag2")
    public void setModuleTag2(String moduleTag2) {
        this.set(FIELD_MODULETAG2, moduleTag2);
    }

    @JsonIgnore
    public boolean isModuleTag2Dirty() {
        return this.contains(FIELD_MODULETAG2);
    }

    @JsonIgnore
    public String getModuleTag3() {
        Object objValue = this.get(FIELD_MODULETAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moduletag3")
    public void setModuleTag3(String moduleTag3) {
        this.set(FIELD_MODULETAG3, moduleTag3);
    }

    @JsonIgnore
    public boolean isModuleTag3Dirty() {
        return this.contains(FIELD_MODULETAG3);
    }

    @JsonIgnore
    public String getModuleTag4() {
        Object objValue = this.get(FIELD_MODULETAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="moduletag4")
    public void setModuleTag4(String moduleTag4) {
        this.set(FIELD_MODULETAG4, moduleTag4);
    }

    @JsonIgnore
    public boolean isModuleTag4Dirty() {
        return this.contains(FIELD_MODULETAG4);
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
    public String getPPSSysReqModuleId() {
        Object objValue = this.get(FIELD_PPSSYSREQMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysreqmoduleid")
    public void setPPSSysReqModuleId(String pPSSysReqModuleId) {
        this.set(FIELD_PPSSYSREQMODULEID, pPSSysReqModuleId);
    }

    @JsonIgnore
    public boolean isPPSSysReqModuleIdDirty() {
        return this.contains(FIELD_PPSSYSREQMODULEID);
    }

    @JsonIgnore
    public String getPPSSysReqModuleName() {
        Object objValue = this.get(FIELD_PPSSYSREQMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysreqmodulename")
    public void setPPSSysReqModuleName(String pPSSysReqModuleName) {
        this.set(FIELD_PPSSYSREQMODULENAME, pPSSysReqModuleName);
    }

    @JsonIgnore
    public boolean isPPSSysReqModuleNameDirty() {
        return this.contains(FIELD_PPSSYSREQMODULENAME);
    }

    @JsonIgnore
    public String getPSDevPrdId() {
        Object objValue = this.get(FIELD_PSDEVPRDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdid")
    public void setPSDevPrdId(String pSDevPrdId) {
        this.set(FIELD_PSDEVPRDID, pSDevPrdId);
    }

    @JsonIgnore
    public boolean isPSDevPrdIdDirty() {
        return this.contains(FIELD_PSDEVPRDID);
    }

    @JsonIgnore
    public String getPSDevPrdName() {
        Object objValue = this.get(FIELD_PSDEVPRDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdname")
    public void setPSDevPrdName(String pSDevPrdName) {
        this.set(FIELD_PSDEVPRDNAME, pSDevPrdName);
    }

    @JsonIgnore
    public boolean isPSDevPrdNameDirty() {
        return this.contains(FIELD_PSDEVPRDNAME);
    }

    @JsonIgnore
    public String getPSDevPrdVerId() {
        Object objValue = this.get(FIELD_PSDEVPRDVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdverid")
    public void setPSDevPrdVerId(String pSDevPrdVerId) {
        this.set(FIELD_PSDEVPRDVERID, pSDevPrdVerId);
    }

    @JsonIgnore
    public boolean isPSDevPrdVerIdDirty() {
        return this.contains(FIELD_PSDEVPRDVERID);
    }

    @JsonIgnore
    public String getPSDevPrdVerName() {
        Object objValue = this.get(FIELD_PSDEVPRDVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevprdvername")
    public void setPSDevPrdVerName(String pSDevPrdVerName) {
        this.set(FIELD_PSDEVPRDVERNAME, pSDevPrdVerName);
    }

    @JsonIgnore
    public boolean isPSDevPrdVerNameDirty() {
        return this.contains(FIELD_PSDEVPRDVERNAME);
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
    public String getPSSysReqModuleId() {
        Object objValue = this.get(FIELD_PSSYSREQMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqmoduleid")
    public void setPSSysReqModuleId(String pSSysReqModuleId) {
        this.set(FIELD_PSSYSREQMODULEID, pSSysReqModuleId);
    }

    @JsonIgnore
    public boolean isPSSysReqModuleIdDirty() {
        return this.contains(FIELD_PSSYSREQMODULEID);
    }

    @JsonIgnore
    public String getPSSysReqModuleName() {
        Object objValue = this.get(FIELD_PSSYSREQMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqmodulename")
    public void setPSSysReqModuleName(String pSSysReqModuleName) {
        this.set(FIELD_PSSYSREQMODULENAME, pSSysReqModuleName);
    }

    @JsonIgnore
    public boolean isPSSysReqModuleNameDirty() {
        return this.contains(FIELD_PSSYSREQMODULENAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysReqModuleId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysReqModuleId(strValue);
    }
}

