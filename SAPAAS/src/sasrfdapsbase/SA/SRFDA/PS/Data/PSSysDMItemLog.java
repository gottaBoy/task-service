/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDMItemLog
extends BaseDataEntity {
    public static final String PSSYSTEMDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String PSSYSTEMDBCFGNAME_DB2 = "DB2";
    public static final String PSSYSTEMDBCFGNAME_ORACLE = "ORACLE";
    public static final String PSSYSTEMDBCFGNAME_SQLSERVER = "SQLSERVER";
    public static final String DBOBJTYPE_TABLE = "TABLE";
    public static final String DBOBJTYPE_COLUMN = "COLUMN";
    public static final String DBOBJTYPE_VIEW = "VIEW";
    public static final String DBOBJTYPE_FKEY = "FKEY";
    public static final String DBOBJTYPE_INDEX = "INDEX";
    public static final String TAG_PSSYSDMITEMLOGID = "PSSYSDMITEMLOGID";
    public static final String TAG_PSSYSDMITEMLOGNAME = "PSSYSDMITEMLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_DBOBJTYPE = "DBOBJTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_NEWSQL = "NEWSQL";
    public static final String TAG_OLDSQL = "OLDSQL";

    public final boolean isPSSYSDMITEMLOGIDNull() {
        return this.IsParamNull(TAG_PSSYSDMITEMLOGID);
    }

    public final String getPSSYSDMITEMLOGID() {
        return this.GetParamStringValue(TAG_PSSYSDMITEMLOGID, "");
    }

    public final void setPSSYSDMITEMLOGID(String strValue) {
        this.SetParamValue(TAG_PSSYSDMITEMLOGID, strValue);
    }

    public final boolean isPSSYSDMITEMLOGNAMENull() {
        return this.IsParamNull(TAG_PSSYSDMITEMLOGNAME);
    }

    public final String getPSSYSDMITEMLOGNAME() {
        return this.GetParamStringValue(TAG_PSSYSDMITEMLOGNAME, "");
    }

    public final void setPSSYSDMITEMLOGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDMITEMLOGNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSTEMDBCFGIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGID);
    }

    public final String getPSSYSTEMDBCFGID() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGID, "");
    }

    public final void setPSSYSTEMDBCFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGID, strValue);
    }

    public final boolean isPSSYSTEMDBCFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGNAME);
    }

    public final String getPSSYSTEMDBCFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGNAME, "");
    }

    public final void setPSSYSTEMDBCFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isDBOBJTYPENull() {
        return this.IsParamNull(TAG_DBOBJTYPE);
    }

    public final String getDBOBJTYPE() {
        return this.GetParamStringValue(TAG_DBOBJTYPE, "");
    }

    public final void setDBOBJTYPE(String strValue) {
        this.SetParamValue(TAG_DBOBJTYPE, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSOBJIDNull() {
        return this.IsParamNull(TAG_PSOBJID);
    }

    public final String getPSOBJID() {
        return this.GetParamStringValue(TAG_PSOBJID, "");
    }

    public final void setPSOBJID(String strValue) {
        this.SetParamValue(TAG_PSOBJID, strValue);
    }

    public final boolean isPSOBJNAMENull() {
        return this.IsParamNull(TAG_PSOBJNAME);
    }

    public final String getPSOBJNAME() {
        return this.GetParamStringValue(TAG_PSOBJNAME, "");
    }

    public final void setPSOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSOBJNAME, strValue);
    }

    public final boolean isNEWSQLNull() {
        return this.IsParamNull(TAG_NEWSQL);
    }

    public final String getNEWSQL() {
        return this.GetParamStringValue(TAG_NEWSQL, "");
    }

    public final void setNEWSQL(String strValue) {
        this.SetParamValue(TAG_NEWSQL, strValue);
    }

    public final boolean isOLDSQLNull() {
        return this.IsParamNull(TAG_OLDSQL);
    }

    public final String getOLDSQL() {
        return this.GetParamStringValue(TAG_OLDSQL, "");
    }

    public final void setOLDSQL(String strValue) {
        this.SetParamValue(TAG_OLDSQL, strValue);
    }
}

