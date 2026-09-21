/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBDetail
extends BaseDataEntity {
    public static final String PSSYSTEMDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String PSSYSTEMDBCFGNAME_DB2 = "DB2";
    public static final String PSSYSTEMDBCFGNAME_ORACLE = "ORACLE";
    public static final String PSSYSTEMDBCFGNAME_SQLSERVER = "SQLSERVER";
    public static final String TAG_PSSYSDBDETAILID = "PSSYSDBDETAILID";
    public static final String TAG_PSSYSDBDETAILNAME = "PSSYSDBDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBDBVER = "PUBDBVER";
    public static final String TAG_DBVER = "DBVER";

    public final boolean isPSSYSDBDETAILIDNull() {
        return this.IsParamNull(TAG_PSSYSDBDETAILID);
    }

    public final String getPSSYSDBDETAILID() {
        return this.GetParamStringValue(TAG_PSSYSDBDETAILID, "");
    }

    public final void setPSSYSDBDETAILID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBDETAILID, strValue);
    }

    public final boolean isPSSYSDBDETAILNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBDETAILNAME);
    }

    public final String getPSSYSDBDETAILNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBDETAILNAME, "");
    }

    public final void setPSSYSDBDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBDETAILNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPUBDBVERNull() {
        return this.IsParamNull(TAG_PUBDBVER);
    }

    public final int getPUBDBVER() {
        return this.GetParamIntValue(TAG_PUBDBVER, 0);
    }

    public final void setPUBDBVER(int nValue) {
        this.SetParamValue(TAG_PUBDBVER, nValue);
    }

    public final boolean isDBVERNull() {
        return this.IsParamNull(TAG_DBVER);
    }

    public final int getDBVER() {
        return this.GetParamIntValue(TAG_DBVER, 0);
    }

    public final void setDBVER(int nValue) {
        this.SetParamValue(TAG_DBVER, nValue);
    }
}

