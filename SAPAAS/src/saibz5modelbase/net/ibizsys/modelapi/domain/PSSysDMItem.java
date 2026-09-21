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

public class PSSysDMItem
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATESQL = "createsql";
    public static final String FIELD_CREATESQL2 = "createsql2";
    public static final String FIELD_CREATESQL3 = "createsql3";
    public static final String FIELD_CREATESQL4 = "createsql4";
    public static final String FIELD_CREATESQL5 = "createsql5";
    public static final String FIELD_CREATESQL6 = "createsql6";
    public static final String FIELD_CREATESQL7 = "createsql7";
    public static final String FIELD_DBOBJTYPE = "dbobjtype";
    public static final String FIELD_DROPSQL = "dropsql";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSOBJID = "psobjid";
    public static final String FIELD_PSOBJNAME = "psobjname";
    public static final String FIELD_PSSYSDMITEMID = "pssysdmitemid";
    public static final String FIELD_PSSYSDMITEMNAME = "pssysdmitemname";
    public static final String FIELD_PSSYSDMVERID = "pssysdmverid";
    public static final String FIELD_PSSYSDMVERNAME = "pssysdmvername";
    public static final String FIELD_PSSYSTEMDBCFGID = "pssystemdbcfgid";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "pssystemdbcfgname";
    public static final String FIELD_SYSDBVER = "sysdbver";
    public static final String FIELD_TESTSQL = "testsql";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERFLAG = "userflag";

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
    public String getCreateSql() {
        Object objValue = this.get(FIELD_CREATESQL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql")
    public void setCreateSql(String createSql) {
        this.set(FIELD_CREATESQL, createSql);
    }

    @JsonIgnore
    public boolean isCreateSqlDirty() {
        return this.contains(FIELD_CREATESQL);
    }

    @JsonIgnore
    public String getCreateSql2() {
        Object objValue = this.get(FIELD_CREATESQL2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql2")
    public void setCreateSql2(String createSql2) {
        this.set(FIELD_CREATESQL2, createSql2);
    }

    @JsonIgnore
    public boolean isCreateSql2Dirty() {
        return this.contains(FIELD_CREATESQL2);
    }

    @JsonIgnore
    public String getCreateSql3() {
        Object objValue = this.get(FIELD_CREATESQL3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql3")
    public void setCreateSql3(String createSql3) {
        this.set(FIELD_CREATESQL3, createSql3);
    }

    @JsonIgnore
    public boolean isCreateSql3Dirty() {
        return this.contains(FIELD_CREATESQL3);
    }

    @JsonIgnore
    public String getCreateSql4() {
        Object objValue = this.get(FIELD_CREATESQL4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql4")
    public void setCreateSql4(String createSql4) {
        this.set(FIELD_CREATESQL4, createSql4);
    }

    @JsonIgnore
    public boolean isCreateSql4Dirty() {
        return this.contains(FIELD_CREATESQL4);
    }

    @JsonIgnore
    public String getCreateSql5() {
        Object objValue = this.get(FIELD_CREATESQL5);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql5")
    public void setCreateSql5(String createSql5) {
        this.set(FIELD_CREATESQL5, createSql5);
    }

    @JsonIgnore
    public boolean isCreateSql5Dirty() {
        return this.contains(FIELD_CREATESQL5);
    }

    @JsonIgnore
    public String getCreateSql6() {
        Object objValue = this.get(FIELD_CREATESQL6);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql6")
    public void setCreateSql6(String createSql6) {
        this.set(FIELD_CREATESQL6, createSql6);
    }

    @JsonIgnore
    public boolean isCreateSql6Dirty() {
        return this.contains(FIELD_CREATESQL6);
    }

    @JsonIgnore
    public String getCreateSql7() {
        Object objValue = this.get(FIELD_CREATESQL7);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createsql7")
    public void setCreateSql7(String createSql7) {
        this.set(FIELD_CREATESQL7, createSql7);
    }

    @JsonIgnore
    public boolean isCreateSql7Dirty() {
        return this.contains(FIELD_CREATESQL7);
    }

    @JsonIgnore
    public String getDBObjType() {
        Object objValue = this.get(FIELD_DBOBJTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbobjtype")
    public void setDBObjType(String dBObjType) {
        this.set(FIELD_DBOBJTYPE, dBObjType);
    }

    @JsonIgnore
    public boolean isDBObjTypeDirty() {
        return this.contains(FIELD_DBOBJTYPE);
    }

    @JsonIgnore
    public String getDropSql() {
        Object objValue = this.get(FIELD_DROPSQL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dropsql")
    public void setDropSql(String dropSql) {
        this.set(FIELD_DROPSQL, dropSql);
    }

    @JsonIgnore
    public boolean isDropSqlDirty() {
        return this.contains(FIELD_DROPSQL);
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
    public String getPSObjId() {
        Object objValue = this.get(FIELD_PSOBJID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjid")
    public void setPSObjId(String pSObjId) {
        this.set(FIELD_PSOBJID, pSObjId);
    }

    @JsonIgnore
    public boolean isPSObjIdDirty() {
        return this.contains(FIELD_PSOBJID);
    }

    @JsonIgnore
    public String getPSObjName() {
        Object objValue = this.get(FIELD_PSOBJNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psobjname")
    public void setPSObjName(String pSObjName) {
        this.set(FIELD_PSOBJNAME, pSObjName);
    }

    @JsonIgnore
    public boolean isPSObjNameDirty() {
        return this.contains(FIELD_PSOBJNAME);
    }

    @JsonIgnore
    public String getPSSysDMItemId() {
        Object objValue = this.get(FIELD_PSSYSDMITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdmitemid")
    public void setPSSysDMItemId(String pSSysDMItemId) {
        this.set(FIELD_PSSYSDMITEMID, pSSysDMItemId);
    }

    @JsonIgnore
    public boolean isPSSysDMItemIdDirty() {
        return this.contains(FIELD_PSSYSDMITEMID);
    }

    @JsonIgnore
    public String getPSSysDMItemName() {
        Object objValue = this.get(FIELD_PSSYSDMITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdmitemname")
    public void setPSSysDMItemName(String pSSysDMItemName) {
        this.set(FIELD_PSSYSDMITEMNAME, pSSysDMItemName);
    }

    @JsonIgnore
    public boolean isPSSysDMItemNameDirty() {
        return this.contains(FIELD_PSSYSDMITEMNAME);
    }

    @JsonIgnore
    public String getPSSysDMVerId() {
        Object objValue = this.get(FIELD_PSSYSDMVERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdmverid")
    public void setPSSysDMVerId(String pSSysDMVerId) {
        this.set(FIELD_PSSYSDMVERID, pSSysDMVerId);
    }

    @JsonIgnore
    public boolean isPSSysDMVerIdDirty() {
        return this.contains(FIELD_PSSYSDMVERID);
    }

    @JsonIgnore
    public String getPSSysDMVerName() {
        Object objValue = this.get(FIELD_PSSYSDMVERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdmvername")
    public void setPSSysDMVerName(String pSSysDMVerName) {
        this.set(FIELD_PSSYSDMVERNAME, pSSysDMVerName);
    }

    @JsonIgnore
    public boolean isPSSysDMVerNameDirty() {
        return this.contains(FIELD_PSSYSDMVERNAME);
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
    public Integer getSysDBVer() {
        Object objValue = this.get(FIELD_SYSDBVER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sysdbver")
    public void setSysDBVer(Integer sysDBVer) {
        this.set(FIELD_SYSDBVER, sysDBVer);
    }

    @JsonIgnore
    public boolean isSysDBVerDirty() {
        return this.contains(FIELD_SYSDBVER);
    }

    @JsonIgnore
    public String getTestSql() {
        Object objValue = this.get(FIELD_TESTSQL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="testsql")
    public void setTestSql(String testSql) {
        this.set(FIELD_TESTSQL, testSql);
    }

    @JsonIgnore
    public boolean isTestSqlDirty() {
        return this.contains(FIELD_TESTSQL);
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
    public String getSrfkey() {
        return this.getPSSysDMItemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDMItemId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDMITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDMItem item = (PSSysDMItem)MAPPER.readValue(new File(strJsonFilePath), PSSysDMItem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDMItem) {
            PSSysDMItem pSSysDMItem = (PSSysDMItem)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDMItem) {
            PSSysDMItem pSSysDMItem = (PSSysDMItem)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

