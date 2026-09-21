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

public class PSSystemDBCfgDTO
extends PSModelDTOBase {
    public static final String FIELD_APPENDSCHEMA = "appendschema";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DBSCHEMANAME = "dbschemaname";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NO2PSDBDEVINSTID = "no2psdbdevinstid";
    public static final String FIELD_NO2PSDBDEVINSTNAME = "no2psdbdevinstname";
    public static final String FIELD_NO2PSDCDBINSTID = "no2psdcdbinstid";
    public static final String FIELD_NO2PSDCDBINSTNAME = "no2psdcdbinstname";
    public static final String FIELD_NODBINSTMODE = "nodbinstmode";
    public static final String FIELD_NULLVALORDER = "nullvalorder";
    public static final String FIELD_OBJNAMECASE = "objnamecase";
    public static final String FIELD_PSDBDEVINSTID = "psdbdevinstid";
    public static final String FIELD_PSDBDEVINSTNAME = "psdbdevinstname";
    public static final String FIELD_PSDEVCENTERDBINSTID = "psdevcenterdbinstid";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "psdevcenterdbinstname";
    public static final String FIELD_PSSYSTEMDBCFGID = "pssystemdbcfgid";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "pssystemdbcfgname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PUBCOMMENTFLAG = "pubcommentflag";
    public static final String FIELD_PUBDBMODELFLAG = "pubdbmodelflag";
    public static final String FIELD_PUBFKEYFLAG = "pubfkeyflag";
    public static final String FIELD_PUBINDEXFLAG = "pubindexflag";
    public static final String FIELD_PUBVIEWFLAG = "pubviewflag";
    public static final String FIELD_RESINFO = "resinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_RESREADYTIME = "resreadytime";
    public static final String FIELD_RESSTATE = "resstate";
    public static final String FIELD_TABSPACE = "tabspace";
    public static final String FIELD_TABSPACE2 = "tabspace2";
    public static final String FIELD_TABSPACE3 = "tabspace3";
    public static final String FIELD_TABSPACE4 = "tabspace4";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public Integer getAppendSchema() {
        Object objValue = this.get(FIELD_APPENDSCHEMA);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appendschema")
    public void setAppendSchema(Integer appendSchema) {
        this.set(FIELD_APPENDSCHEMA, appendSchema);
    }

    @JsonIgnore
    public boolean isAppendSchemaDirty() {
        return this.contains(FIELD_APPENDSCHEMA);
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
    public String getDBSchemaName() {
        Object objValue = this.get(FIELD_DBSCHEMANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbschemaname")
    public void setDBSchemaName(String dBSchemaName) {
        this.set(FIELD_DBSCHEMANAME, dBSchemaName);
    }

    @JsonIgnore
    public boolean isDBSchemaNameDirty() {
        return this.contains(FIELD_DBSCHEMANAME);
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
    public String getNo2PSDBDevInstId() {
        Object objValue = this.get(FIELD_NO2PSDBDEVINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdbdevinstid")
    public void setNo2PSDBDevInstId(String no2PSDBDevInstId) {
        this.set(FIELD_NO2PSDBDEVINSTID, no2PSDBDevInstId);
    }

    @JsonIgnore
    public boolean isNo2PSDBDevInstIdDirty() {
        return this.contains(FIELD_NO2PSDBDEVINSTID);
    }

    @JsonIgnore
    public String getNo2PSDBDevInstName() {
        Object objValue = this.get(FIELD_NO2PSDBDEVINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdbdevinstname")
    public void setNo2PSDBDevInstName(String no2PSDBDevInstName) {
        this.set(FIELD_NO2PSDBDEVINSTNAME, no2PSDBDevInstName);
    }

    @JsonIgnore
    public boolean isNo2PSDBDevInstNameDirty() {
        return this.contains(FIELD_NO2PSDBDEVINSTNAME);
    }

    @JsonIgnore
    public String getNo2PSDCDBInstId() {
        Object objValue = this.get(FIELD_NO2PSDCDBINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdcdbinstid")
    public void setNo2PSDCDBInstId(String no2PSDCDBInstId) {
        this.set(FIELD_NO2PSDCDBINSTID, no2PSDCDBInstId);
    }

    @JsonIgnore
    public boolean isNo2PSDCDBInstIdDirty() {
        return this.contains(FIELD_NO2PSDCDBINSTID);
    }

    @JsonIgnore
    public String getNo2PSDCDBInstName() {
        Object objValue = this.get(FIELD_NO2PSDCDBINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdcdbinstname")
    public void setNo2PSDCDBInstName(String no2PSDCDBInstName) {
        this.set(FIELD_NO2PSDCDBINSTNAME, no2PSDCDBInstName);
    }

    @JsonIgnore
    public boolean isNo2PSDCDBInstNameDirty() {
        return this.contains(FIELD_NO2PSDCDBINSTNAME);
    }

    @JsonIgnore
    public Integer getNoDBInstMode() {
        Object objValue = this.get(FIELD_NODBINSTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="nodbinstmode")
    public void setNoDBInstMode(Integer noDBInstMode) {
        this.set(FIELD_NODBINSTMODE, noDBInstMode);
    }

    @JsonIgnore
    public boolean isNoDBInstModeDirty() {
        return this.contains(FIELD_NODBINSTMODE);
    }

    @JsonIgnore
    public String getNullValOrder() {
        Object objValue = this.get(FIELD_NULLVALORDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nullvalorder")
    public void setNullValOrder(String nullValOrder) {
        this.set(FIELD_NULLVALORDER, nullValOrder);
    }

    @JsonIgnore
    public boolean isNullValOrderDirty() {
        return this.contains(FIELD_NULLVALORDER);
    }

    @JsonIgnore
    public String getObjNameCase() {
        Object objValue = this.get(FIELD_OBJNAMECASE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="objnamecase")
    public void setObjNameCase(String objNameCase) {
        this.set(FIELD_OBJNAMECASE, objNameCase);
    }

    @JsonIgnore
    public boolean isObjNameCaseDirty() {
        return this.contains(FIELD_OBJNAMECASE);
    }

    @JsonIgnore
    public String getPSDBDevInstId() {
        Object objValue = this.get(FIELD_PSDBDEVINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbdevinstid")
    public void setPSDBDevInstId(String pSDBDevInstId) {
        this.set(FIELD_PSDBDEVINSTID, pSDBDevInstId);
    }

    @JsonIgnore
    public boolean isPSDBDevInstIdDirty() {
        return this.contains(FIELD_PSDBDEVINSTID);
    }

    @JsonIgnore
    public String getPSDBDevInstName() {
        Object objValue = this.get(FIELD_PSDBDEVINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbdevinstname")
    public void setPSDBDevInstName(String pSDBDevInstName) {
        this.set(FIELD_PSDBDEVINSTNAME, pSDBDevInstName);
    }

    @JsonIgnore
    public boolean isPSDBDevInstNameDirty() {
        return this.contains(FIELD_PSDBDEVINSTNAME);
    }

    @JsonIgnore
    public String getPSDevCenterDBInstId() {
        Object objValue = this.get(FIELD_PSDEVCENTERDBINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevcenterdbinstid")
    public void setPSDevCenterDBInstId(String pSDevCenterDBInstId) {
        this.set(FIELD_PSDEVCENTERDBINSTID, pSDevCenterDBInstId);
    }

    @JsonIgnore
    public boolean isPSDevCenterDBInstIdDirty() {
        return this.contains(FIELD_PSDEVCENTERDBINSTID);
    }

    @JsonIgnore
    public String getPSDevCenterDBInstName() {
        Object objValue = this.get(FIELD_PSDEVCENTERDBINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevcenterdbinstname")
    public void setPSDevCenterDBInstName(String pSDevCenterDBInstName) {
        this.set(FIELD_PSDEVCENTERDBINSTNAME, pSDevCenterDBInstName);
    }

    @JsonIgnore
    public boolean isPSDevCenterDBInstNameDirty() {
        return this.contains(FIELD_PSDEVCENTERDBINSTNAME);
    }

    @JsonIgnore
    public String getPSSystemDBCfgId() {
        Object objValue = this.get(FIELD_PSSYSTEMDBCFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemdbcfgid")
    public void setPSSystemDBCfgId(String pSSystemDBCfgId) {
        this.set(FIELD_PSSYSTEMDBCFGID, pSSystemDBCfgId);
    }

    @JsonIgnore
    public boolean isPSSystemDBCfgIdDirty() {
        return this.contains(FIELD_PSSYSTEMDBCFGID);
    }

    @JsonIgnore
    public String getPSSystemDBCfgName() {
        Object objValue = this.get(FIELD_PSSYSTEMDBCFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemdbcfgname")
    public void setPSSystemDBCfgName(String pSSystemDBCfgName) {
        this.set(FIELD_PSSYSTEMDBCFGNAME, pSSystemDBCfgName);
    }

    @JsonIgnore
    public boolean isPSSystemDBCfgNameDirty() {
        return this.contains(FIELD_PSSYSTEMDBCFGNAME);
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
    public Integer getPubCommentFlag() {
        Object objValue = this.get(FIELD_PUBCOMMENTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubcommentflag")
    public void setPubCommentFlag(Integer pubCommentFlag) {
        this.set(FIELD_PUBCOMMENTFLAG, pubCommentFlag);
    }

    @JsonIgnore
    public boolean isPubCommentFlagDirty() {
        return this.contains(FIELD_PUBCOMMENTFLAG);
    }

    @JsonIgnore
    public Integer getPubDBModelFlag() {
        Object objValue = this.get(FIELD_PUBDBMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubdbmodelflag")
    public void setPubDBModelFlag(Integer pubDBModelFlag) {
        this.set(FIELD_PUBDBMODELFLAG, pubDBModelFlag);
    }

    @JsonIgnore
    public boolean isPubDBModelFlagDirty() {
        return this.contains(FIELD_PUBDBMODELFLAG);
    }

    @JsonIgnore
    public Integer getPubFKeyFlag() {
        Object objValue = this.get(FIELD_PUBFKEYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubfkeyflag")
    public void setPubFKeyFlag(Integer pubFKeyFlag) {
        this.set(FIELD_PUBFKEYFLAG, pubFKeyFlag);
    }

    @JsonIgnore
    public boolean isPubFKeyFlagDirty() {
        return this.contains(FIELD_PUBFKEYFLAG);
    }

    @JsonIgnore
    public Integer getPubIndexFlag() {
        Object objValue = this.get(FIELD_PUBINDEXFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubindexflag")
    public void setPubIndexFlag(Integer pubIndexFlag) {
        this.set(FIELD_PUBINDEXFLAG, pubIndexFlag);
    }

    @JsonIgnore
    public boolean isPubIndexFlagDirty() {
        return this.contains(FIELD_PUBINDEXFLAG);
    }

    @JsonIgnore
    public Integer getPubViewFlag() {
        Object objValue = this.get(FIELD_PUBVIEWFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubviewflag")
    public void setPubViewFlag(Integer pubViewFlag) {
        this.set(FIELD_PUBVIEWFLAG, pubViewFlag);
    }

    @JsonIgnore
    public boolean isPubViewFlagDirty() {
        return this.contains(FIELD_PUBVIEWFLAG);
    }

    @JsonIgnore
    public String getResInfo() {
        Object objValue = this.get(FIELD_RESINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="resinfo")
    public void setResInfo(String resInfo) {
        this.set(FIELD_RESINFO, resInfo);
    }

    @JsonIgnore
    public boolean isResInfoDirty() {
        return this.contains(FIELD_RESINFO);
    }

    @JsonIgnore
    public Timestamp getResReadyTime() {
        Object objValue = this.get(FIELD_RESREADYTIME);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="resreadytime")
    public void setResReadyTime(Timestamp resReadyTime) {
        this.set(FIELD_RESREADYTIME, resReadyTime);
    }

    @JsonIgnore
    public boolean isResReadyTimeDirty() {
        return this.contains(FIELD_RESREADYTIME);
    }

    @JsonIgnore
    public Integer getResState() {
        Object objValue = this.get(FIELD_RESSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="resstate")
    public void setResState(Integer resState) {
        this.set(FIELD_RESSTATE, resState);
    }

    @JsonIgnore
    public boolean isResStateDirty() {
        return this.contains(FIELD_RESSTATE);
    }

    @JsonIgnore
    public String getTabSpace() {
        Object objValue = this.get(FIELD_TABSPACE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tabspace")
    public void setTabSpace(String tabSpace) {
        this.set(FIELD_TABSPACE, tabSpace);
    }

    @JsonIgnore
    public boolean isTabSpaceDirty() {
        return this.contains(FIELD_TABSPACE);
    }

    @JsonIgnore
    public String getTabSpace2() {
        Object objValue = this.get(FIELD_TABSPACE2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tabspace2")
    public void setTabSpace2(String tabSpace2) {
        this.set(FIELD_TABSPACE2, tabSpace2);
    }

    @JsonIgnore
    public boolean isTabSpace2Dirty() {
        return this.contains(FIELD_TABSPACE2);
    }

    @JsonIgnore
    public String getTabSpace3() {
        Object objValue = this.get(FIELD_TABSPACE3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tabspace3")
    public void setTabSpace3(String tabSpace3) {
        this.set(FIELD_TABSPACE3, tabSpace3);
    }

    @JsonIgnore
    public boolean isTabSpace3Dirty() {
        return this.contains(FIELD_TABSPACE3);
    }

    @JsonIgnore
    public String getTabSpace4() {
        Object objValue = this.get(FIELD_TABSPACE4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tabspace4")
    public void setTabSpace4(String tabSpace4) {
        this.set(FIELD_TABSPACE4, tabSpace4);
    }

    @JsonIgnore
    public boolean isTabSpace4Dirty() {
        return this.contains(FIELD_TABSPACE4);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSystemDBCfgId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSystemDBCfgId(strValue);
    }
}

