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

public class PSSysSAHandler
extends PSModelBase {
    public static final String FIELD_CLIENTHANDLEROBJ = "clienthandlerobj";
    public static final String FIELD_CLIENTHANDLEROBJ2 = "clienthandlerobj2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_HANDLEROBJ = "handlerobj";
    public static final String FIELD_HANDLEROBJ2 = "handlerobj2";
    public static final String FIELD_HANDLERPARAMS = "handlerparams";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSFSAHANDLERID = "pssfsahandlerid";
    public static final String FIELD_PSSFSAHANDLERNAME = "pssfsahandlername";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSSAHANDLERID = "pssyssahandlerid";
    public static final String FIELD_PSSYSSAHANDLERNAME = "pssyssahandlername";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SATYPE = "satype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getClientHandlerObj() {
        Object objValue = this.get(FIELD_CLIENTHANDLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clienthandlerobj")
    public void setClientHandlerObj(String clientHandlerObj) {
        this.set(FIELD_CLIENTHANDLEROBJ, clientHandlerObj);
    }

    @JsonIgnore
    public boolean isClientHandlerObjDirty() {
        return this.contains(FIELD_CLIENTHANDLEROBJ);
    }

    @JsonIgnore
    public String getClientHandlerObj2() {
        Object objValue = this.get(FIELD_CLIENTHANDLEROBJ2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clienthandlerobj2")
    public void setClientHandlerObj2(String clientHandlerObj2) {
        this.set(FIELD_CLIENTHANDLEROBJ2, clientHandlerObj2);
    }

    @JsonIgnore
    public boolean isClientHandlerObj2Dirty() {
        return this.contains(FIELD_CLIENTHANDLEROBJ2);
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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getHandlerObj() {
        Object objValue = this.get(FIELD_HANDLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerobj")
    public void setHandlerObj(String handlerObj) {
        this.set(FIELD_HANDLEROBJ, handlerObj);
    }

    @JsonIgnore
    public boolean isHandlerObjDirty() {
        return this.contains(FIELD_HANDLEROBJ);
    }

    @JsonIgnore
    public String getHandlerObj2() {
        Object objValue = this.get(FIELD_HANDLEROBJ2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerobj2")
    public void setHandlerObj2(String handlerObj2) {
        this.set(FIELD_HANDLEROBJ2, handlerObj2);
    }

    @JsonIgnore
    public boolean isHandlerObj2Dirty() {
        return this.contains(FIELD_HANDLEROBJ2);
    }

    @JsonIgnore
    public String getHandlerParams() {
        Object objValue = this.get(FIELD_HANDLERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="handlerparams")
    public void setHandlerParams(String handlerParams) {
        this.set(FIELD_HANDLERPARAMS, handlerParams);
    }

    @JsonIgnore
    public boolean isHandlerParamsDirty() {
        return this.contains(FIELD_HANDLERPARAMS);
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
    public String getPSSFSAHandlerId() {
        Object objValue = this.get(FIELD_PSSFSAHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfsahandlerid")
    public void setPSSFSAHandlerId(String pSSFSAHandlerId) {
        this.set(FIELD_PSSFSAHANDLERID, pSSFSAHandlerId);
    }

    @JsonIgnore
    public boolean isPSSFSAHandlerIdDirty() {
        return this.contains(FIELD_PSSFSAHANDLERID);
    }

    @JsonIgnore
    public String getPSSFSAHandlerName() {
        Object objValue = this.get(FIELD_PSSFSAHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfsahandlername")
    public void setPSSFSAHandlerName(String pSSFSAHandlerName) {
        this.set(FIELD_PSSFSAHANDLERNAME, pSSFSAHandlerName);
    }

    @JsonIgnore
    public boolean isPSSFSAHandlerNameDirty() {
        return this.contains(FIELD_PSSFSAHANDLERNAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysSAHandlerId() {
        Object objValue = this.get(FIELD_PSSYSSAHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssahandlerid")
    public void setPSSysSAHandlerId(String pSSysSAHandlerId) {
        this.set(FIELD_PSSYSSAHANDLERID, pSSysSAHandlerId);
    }

    @JsonIgnore
    public boolean isPSSysSAHandlerIdDirty() {
        return this.contains(FIELD_PSSYSSAHANDLERID);
    }

    @JsonIgnore
    public String getPSSysSAHandlerName() {
        Object objValue = this.get(FIELD_PSSYSSAHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssahandlername")
    public void setPSSysSAHandlerName(String pSSysSAHandlerName) {
        this.set(FIELD_PSSYSSAHANDLERNAME, pSSysSAHandlerName);
    }

    @JsonIgnore
    public boolean isPSSysSAHandlerNameDirty() {
        return this.contains(FIELD_PSSYSSAHANDLERNAME);
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
    public String getSAType() {
        Object objValue = this.get(FIELD_SATYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="satype")
    public void setSAType(String sAType) {
        this.set(FIELD_SATYPE, sAType);
    }

    @JsonIgnore
    public boolean isSATypeDirty() {
        return this.contains(FIELD_SATYPE);
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
    public String getSrfkey() {
        return this.getPSSysSAHandlerId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysSAHandlerId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSSAHANDLER";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysSAHandler item = (PSSysSAHandler)MAPPER.readValue(new File(strJsonFilePath), PSSysSAHandler.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysSAHandler) {
            PSSysSAHandler pSSysSAHandler = (PSSysSAHandler)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysSAHandler) {
            PSSysSAHandler pSSysSAHandler = (PSSysSAHandler)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

