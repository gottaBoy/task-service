/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataSetCode
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String TAG_PSDEDSCODEID = "PSDEDSCODEID";
    public static final String TAG_PSDEDSCODENAME = "PSDEDSCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_QUERYCODE = "QUERYCODE";
    public static final String TAG_USERQUERYCODE = "USERQUERYCODE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEDSCODEIDNull() {
        return this.IsParamNull(TAG_PSDEDSCODEID);
    }

    public final String getPSDEDSCODEID() {
        return this.GetParamStringValue(TAG_PSDEDSCODEID, "");
    }

    public final void setPSDEDSCODEID(String strValue) {
        this.SetParamValue(TAG_PSDEDSCODEID, strValue);
    }

    public final boolean isPSDEDSCODENAMENull() {
        return this.IsParamNull(TAG_PSDEDSCODENAME);
    }

    public final String getPSDEDSCODENAME() {
        return this.GetParamStringValue(TAG_PSDEDSCODENAME, "");
    }

    public final void setPSDEDSCODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSCODENAME, strValue);
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

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isQUERYCODENull() {
        return this.IsParamNull(TAG_QUERYCODE);
    }

    public final String getQUERYCODE() {
        return this.GetParamStringValue(TAG_QUERYCODE, "");
    }

    public final void setQUERYCODE(String strValue) {
        this.SetParamValue(TAG_QUERYCODE, strValue);
    }

    public final boolean isUSERQUERYCODENull() {
        return this.IsParamNull(TAG_USERQUERYCODE);
    }

    public final String getUSERQUERYCODE() {
        return this.GetParamStringValue(TAG_USERQUERYCODE, "");
    }

    public final void setUSERQUERYCODE(String strValue) {
        this.SetParamValue(TAG_USERQUERYCODE, strValue);
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
}

