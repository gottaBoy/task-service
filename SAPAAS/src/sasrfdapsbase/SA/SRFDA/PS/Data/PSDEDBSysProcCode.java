/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBSysProcCode
extends BaseDataEntity {
    public static final String PSDESPCODENAME_MYSQL5 = "MYSQL5";
    public static final String PSDESPCODENAME_DB2 = "DB2";
    public static final int COMPILEFLAG_NOTCOMPILE = 99;
    public static final int COMPILEFLAG_FAILED = 1;
    public static final int COMPILEFLAG_OK = 0;
    public static final String SYSPROCTYPE_INSERT = "INSERT";
    public static final String SYSPROCTYPE_UPDATE = "UPDATE";
    public static final String SYSPROCTYPE_DELETE = "DELETE";
    public static final String TAG_PSDESPCODEID = "PSDESPCODEID";
    public static final String TAG_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String TAG_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FULLCODE = "FULLCODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_COMPILEFLAG = "COMPILEFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_SYSPROCTYPE = "SYSPROCTYPE";

    public final boolean isPSDESPCODEIDNull() {
        return this.IsParamNull(TAG_PSDESPCODEID);
    }

    public final String getPSDESPCODEID() {
        return this.GetParamStringValue(TAG_PSDESPCODEID, "");
    }

    public final void setPSDESPCODEID(String strValue) {
        this.SetParamValue(TAG_PSDESPCODEID, strValue);
    }

    public final boolean isPSDESPCODENAMENull() {
        return this.IsParamNull(TAG_PSDESPCODENAME);
    }

    public final String getPSDESPCODENAME() {
        return this.GetParamStringValue(TAG_PSDESPCODENAME, "");
    }

    public final void setPSDESPCODENAME(String strValue) {
        this.SetParamValue(TAG_PSDESPCODENAME, strValue);
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

    public final boolean isPSDESYSPROCIDNull() {
        return this.IsParamNull(TAG_PSDESYSPROCID);
    }

    public final String getPSDESYSPROCID() {
        return this.GetParamStringValue(TAG_PSDESYSPROCID, "");
    }

    public final void setPSDESYSPROCID(String strValue) {
        this.SetParamValue(TAG_PSDESYSPROCID, strValue);
    }

    public final boolean isPSDESYSPROCNAMENull() {
        return this.IsParamNull(TAG_PSDESYSPROCNAME);
    }

    public final String getPSDESYSPROCNAME() {
        return this.GetParamStringValue(TAG_PSDESYSPROCNAME, "");
    }

    public final void setPSDESYSPROCNAME(String strValue) {
        this.SetParamValue(TAG_PSDESYSPROCNAME, strValue);
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

    public final boolean isFULLCODENull() {
        return this.IsParamNull(TAG_FULLCODE);
    }

    public final String getFULLCODE() {
        return this.GetParamStringValue(TAG_FULLCODE, "");
    }

    public final void setFULLCODE(String strValue) {
        this.SetParamValue(TAG_FULLCODE, strValue);
    }

    public final boolean isUSERCODENull() {
        return this.IsParamNull(TAG_USERCODE);
    }

    public final String getUSERCODE() {
        return this.GetParamStringValue(TAG_USERCODE, "");
    }

    public final void setUSERCODE(String strValue) {
        this.SetParamValue(TAG_USERCODE, strValue);
    }

    public final boolean isCOMPILEFLAGNull() {
        return this.IsParamNull(TAG_COMPILEFLAG);
    }

    public final int getCOMPILEFLAG() {
        return this.GetParamIntValue(TAG_COMPILEFLAG, 0);
    }

    public final void setCOMPILEFLAG(int nValue) {
        this.SetParamValue(TAG_COMPILEFLAG, nValue);
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

    public final boolean isSYSPROCTYPENull() {
        return this.IsParamNull(TAG_SYSPROCTYPE);
    }

    public final String getSYSPROCTYPE() {
        return this.GetParamStringValue(TAG_SYSPROCTYPE, "");
    }

    public final void setSYSPROCTYPE(String strValue) {
        this.SetParamValue(TAG_SYSPROCTYPE, strValue);
    }
}

