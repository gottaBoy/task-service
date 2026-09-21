/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBSysProcCodePart
extends BaseDataEntity {
    public static final String PSDESPCODEPARTNAME_USERDECLARE = "USERDECLARE";
    public static final String PSDESPCODEPARTNAME_USERINIT = "USERINIT";
    public static final String PSDESPCODEPARTNAME_INPUTCHECK = "INPUTCHECK";
    public static final String PSDESPCODEPARTNAME_BEFOREACTION = "BEFOREACTION";
    public static final String PSDESPCODEPARTNAME_EXECUTEACTION = "EXECUTEACTION";
    public static final String PSDESPCODEPARTNAME_AFTERACTION = "AFTERACTION";
    public static final String PSDESPCODENAME_MYSQL5 = "MYSQL5";
    public static final String PSDESPCODENAME_DB2 = "DB2";
    public static final String TAG_PSDESPCODEPARTID = "PSDESPCODEPARTID";
    public static final String TAG_PSDESPCODEPARTNAME = "PSDESPCODEPARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDESPCODEID = "PSDESPCODEID";
    public static final String TAG_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODEPART = "CODEPART";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DANGERCODE = "DANGERCODE";
    public static final String TAG_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String TAG_PSDESYSPROCNAME = "PSDESYSPROCNAME";

    public final boolean isPSDESPCODEPARTIDNull() {
        return this.IsParamNull(TAG_PSDESPCODEPARTID);
    }

    public final String getPSDESPCODEPARTID() {
        return this.GetParamStringValue(TAG_PSDESPCODEPARTID, "");
    }

    public final void setPSDESPCODEPARTID(String strValue) {
        this.SetParamValue(TAG_PSDESPCODEPARTID, strValue);
    }

    public final boolean isPSDESPCODEPARTNAMENull() {
        return this.IsParamNull(TAG_PSDESPCODEPARTNAME);
    }

    public final String getPSDESPCODEPARTNAME() {
        return this.GetParamStringValue(TAG_PSDESPCODEPARTNAME, "");
    }

    public final void setPSDESPCODEPARTNAME(String strValue) {
        this.SetParamValue(TAG_PSDESPCODEPARTNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isCODEPARTNull() {
        return this.IsParamNull(TAG_CODEPART);
    }

    public final String getCODEPART() {
        return this.GetParamStringValue(TAG_CODEPART, "");
    }

    public final void setCODEPART(String strValue) {
        this.SetParamValue(TAG_CODEPART, strValue);
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

    public final boolean isDANGERCODENull() {
        return this.IsParamNull(TAG_DANGERCODE);
    }

    public final boolean getDANGERCODE() {
        return this.GetParamIntValue(TAG_DANGERCODE, 0) == 1;
    }

    public final void setDANGERCODE(boolean bValue) {
        this.SetParamValue(TAG_DANGERCODE, bValue ? 1 : 0);
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
}

