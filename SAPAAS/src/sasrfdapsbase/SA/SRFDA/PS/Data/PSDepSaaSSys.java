/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSaaSSys
extends BaseDataEntity {
    public static final String PSDEPSYSTYPE_DEVSLNSYS = "DEVSLNSYS";
    public static final String PSDEPSYSTYPE_SAASSYS = "SAASSYS";
    public static final String TAG_PSDEPSAASSYSID = "PSDEPSAASSYSID";
    public static final String TAG_PSDEPSAASSYSNAME = "PSDEPSAASSYSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_PSDEPSYSTYPE = "PSDEPSYSTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSSAASSYSID = "PSSAASSYSID";
    public static final String TAG_PSSAASSYSNAME = "PSSAASSYSNAME";

    public final boolean isPSDEPSAASSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSAASSYSID);
    }

    public final String getPSDEPSAASSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSAASSYSID, "");
    }

    public final void setPSDEPSAASSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSAASSYSID, strValue);
    }

    public final boolean isPSDEPSAASSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSAASSYSNAME);
    }

    public final String getPSDEPSAASSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSAASSYSNAME, "");
    }

    public final void setPSDEPSAASSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSAASSYSNAME, strValue);
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

    public final boolean isPSDEPSYSTYPENull() {
        return this.IsParamNull(TAG_PSDEPSYSTYPE);
    }

    public final String getPSDEPSYSTYPE() {
        return this.GetParamStringValue(TAG_PSDEPSYSTYPE, "");
    }

    public final void setPSDEPSYSTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSTYPE, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSSAASSYSIDNull() {
        return this.IsParamNull(TAG_PSSAASSYSID);
    }

    public final String getPSSAASSYSID() {
        return this.GetParamStringValue(TAG_PSSAASSYSID, "");
    }

    public final void setPSSAASSYSID(String strValue) {
        this.SetParamValue(TAG_PSSAASSYSID, strValue);
    }

    public final boolean isPSSAASSYSNAMENull() {
        return this.IsParamNull(TAG_PSSAASSYSNAME);
    }

    public final String getPSSAASSYSNAME() {
        return this.GetParamStringValue(TAG_PSSAASSYSNAME, "");
    }

    public final void setPSSAASSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSAASSYSNAME, strValue);
    }
}

