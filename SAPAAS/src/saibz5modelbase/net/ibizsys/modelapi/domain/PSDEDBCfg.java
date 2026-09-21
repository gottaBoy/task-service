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

public class PSDEDBCfg
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EXTABLENAME = "extablename";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_OBJNAMECASE = "objnamecase";
    public static final String FIELD_PSDEDBCFGID = "psdedbcfgid";
    public static final String FIELD_PSDEDBCFGNAME = "psdedbcfgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PUBMODEL = "pubmodel";
    public static final String FIELD_TABLENAME = "tablename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWNAME = "viewname";
    public static final String FIELD_VIEWNAME2 = "viewname2";
    public static final String FIELD_VIEWNAME3 = "viewname3";
    public static final String FIELD_VIEWNAME4 = "viewname4";

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
    public String getExTableName() {
        Object objValue = this.get(FIELD_EXTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extablename")
    public void setExTableName(String exTableName) {
        this.set(FIELD_EXTABLENAME, exTableName);
    }

    @JsonIgnore
    public boolean isExTableNameDirty() {
        return this.contains(FIELD_EXTABLENAME);
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
    public String getPSDEDBCfgId() {
        Object objValue = this.get(FIELD_PSDEDBCFGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbcfgid")
    public void setPSDEDBCfgId(String pSDEDBCfgId) {
        this.set(FIELD_PSDEDBCFGID, pSDEDBCfgId);
    }

    @JsonIgnore
    public boolean isPSDEDBCfgIdDirty() {
        return this.contains(FIELD_PSDEDBCFGID);
    }

    @JsonIgnore
    public String getPSDEDBCfgName() {
        Object objValue = this.get(FIELD_PSDEDBCFGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedbcfgname")
    public void setPSDEDBCfgName(String pSDEDBCfgName) {
        this.set(FIELD_PSDEDBCFGNAME, pSDEDBCfgName);
    }

    @JsonIgnore
    public boolean isPSDEDBCfgNameDirty() {
        return this.contains(FIELD_PSDEDBCFGNAME);
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
    public Integer getPubModel() {
        Object objValue = this.get(FIELD_PUBMODEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubmodel")
    public void setPubModel(Integer pubModel) {
        this.set(FIELD_PUBMODEL, pubModel);
    }

    @JsonIgnore
    public boolean isPubModelDirty() {
        return this.contains(FIELD_PUBMODEL);
    }

    @JsonIgnore
    public String getTableName() {
        Object objValue = this.get(FIELD_TABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tablename")
    public void setTableName(String tableName) {
        this.set(FIELD_TABLENAME, tableName);
    }

    @JsonIgnore
    public boolean isTableNameDirty() {
        return this.contains(FIELD_TABLENAME);
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
    public String getViewName() {
        Object objValue = this.get(FIELD_VIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname")
    public void setViewName(String viewName) {
        this.set(FIELD_VIEWNAME, viewName);
    }

    @JsonIgnore
    public boolean isViewNameDirty() {
        return this.contains(FIELD_VIEWNAME);
    }

    @JsonIgnore
    public String getViewName2() {
        Object objValue = this.get(FIELD_VIEWNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname2")
    public void setViewName2(String viewName2) {
        this.set(FIELD_VIEWNAME2, viewName2);
    }

    @JsonIgnore
    public boolean isViewName2Dirty() {
        return this.contains(FIELD_VIEWNAME2);
    }

    @JsonIgnore
    public String getViewName3() {
        Object objValue = this.get(FIELD_VIEWNAME3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname3")
    public void setViewName3(String viewName3) {
        this.set(FIELD_VIEWNAME3, viewName3);
    }

    @JsonIgnore
    public boolean isViewName3Dirty() {
        return this.contains(FIELD_VIEWNAME3);
    }

    @JsonIgnore
    public String getViewName4() {
        Object objValue = this.get(FIELD_VIEWNAME4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewname4")
    public void setViewName4(String viewName4) {
        this.set(FIELD_VIEWNAME4, viewName4);
    }

    @JsonIgnore
    public boolean isViewName4Dirty() {
        return this.contains(FIELD_VIEWNAME4);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDBCfgId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDBCfgId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEDBCFG";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDBCfg item = (PSDEDBCfg)MAPPER.readValue(new File(strJsonFilePath), PSDEDBCfg.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDBCfg) {
            PSDEDBCfg pSDEDBCfg = (PSDEDBCfg)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDBCfg) {
            PSDEDBCfg pSDEDBCfg = (PSDEDBCfg)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

