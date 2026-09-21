/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBSysProcField
extends BaseDataEntity {
    public static final String TAG_PSDESPFIELDID = "PSDESPFIELDID";
    public static final String TAG_PSDESPFIELDNAME = "PSDESPFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String TAG_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PROCPARAM = "PROCPARAM";
    public static final String TAG_DECLAREPARAM = "DECLAREPARAM";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDESPFIELDIDNull() {
        return this.IsParamNull(TAG_PSDESPFIELDID);
    }

    public final String getPSDESPFIELDID() {
        return this.GetParamStringValue(TAG_PSDESPFIELDID, "");
    }

    public final void setPSDESPFIELDID(String strValue) {
        this.SetParamValue(TAG_PSDESPFIELDID, strValue);
    }

    public final boolean isPSDESPFIELDNAMENull() {
        return this.IsParamNull(TAG_PSDESPFIELDNAME);
    }

    public final String getPSDESPFIELDNAME() {
        return this.GetParamStringValue(TAG_PSDESPFIELDNAME, "");
    }

    public final void setPSDESPFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSDESPFIELDNAME, strValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPROCPARAMNull() {
        return this.IsParamNull(TAG_PROCPARAM);
    }

    public final boolean getPROCPARAM() {
        return this.GetParamIntValue(TAG_PROCPARAM, 0) == 1;
    }

    public final void setPROCPARAM(boolean bValue) {
        this.SetParamValue(TAG_PROCPARAM, bValue ? 1 : 0);
    }

    public final boolean isDECLAREPARAMNull() {
        return this.IsParamNull(TAG_DECLAREPARAM);
    }

    public final boolean getDECLAREPARAM() {
        return this.GetParamIntValue(TAG_DECLAREPARAM, 0) == 1;
    }

    public final void setDECLAREPARAM(boolean bValue) {
        this.SetParamValue(TAG_DECLAREPARAM, bValue ? 1 : 0);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

