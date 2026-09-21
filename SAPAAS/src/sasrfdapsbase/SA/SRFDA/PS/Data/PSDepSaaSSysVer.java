/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSaaSSysVer
extends BaseDataEntity {
    public static final String PSDEPSYSVERTYPE_DEVSLNSYS = "DEVSLNSYS";
    public static final String PSDEPSYSVERTYPE_SAASSYS = "SAASSYS";
    public static final String TAG_PSDEPSAASSYSVERID = "PSDEPSAASSYSVERID";
    public static final String TAG_PSDEPSAASSYSVERNAME = "PSDEPSAASSYSVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_PSDEPSYSVERTYPE = "PSDEPSYSVERTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSYSID = "PSDEPSYSID";
    public static final String TAG_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String TAG_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String TAG_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";

    public final boolean isPSDEPSAASSYSVERIDNull() {
        return this.IsParamNull(TAG_PSDEPSAASSYSVERID);
    }

    public final String getPSDEPSAASSYSVERID() {
        return this.GetParamStringValue(TAG_PSDEPSAASSYSVERID, "");
    }

    public final void setPSDEPSAASSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSDEPSAASSYSVERID, strValue);
    }

    public final boolean isPSDEPSAASSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSDEPSAASSYSVERNAME);
    }

    public final String getPSDEPSAASSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSDEPSAASSYSVERNAME, "");
    }

    public final void setPSDEPSAASSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSAASSYSVERNAME, strValue);
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

    public final boolean isPSDEPSYSVERTYPENull() {
        return this.IsParamNull(TAG_PSDEPSYSVERTYPE);
    }

    public final String getPSDEPSYSVERTYPE() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERTYPE, "");
    }

    public final void setPSDEPSYSVERTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERTYPE, strValue);
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

    public final boolean isPSDEPSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSID);
    }

    public final String getPSDEPSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSYSID, "");
    }

    public final void setPSDEPSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSID, strValue);
    }

    public final boolean isPSDEPSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSNAME);
    }

    public final String getPSDEPSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSNAME, "");
    }

    public final void setPSDEPSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSNAME, strValue);
    }

    public final boolean isPSSAASSYSVERIDNull() {
        return this.IsParamNull(TAG_PSSAASSYSVERID);
    }

    public final String getPSSAASSYSVERID() {
        return this.GetParamStringValue(TAG_PSSAASSYSVERID, "");
    }

    public final void setPSSAASSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSSAASSYSVERID, strValue);
    }

    public final boolean isPSSAASSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSSAASSYSVERNAME);
    }

    public final String getPSSAASSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSSAASSYSVERNAME, "");
    }

    public final void setPSSAASSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSAASSYSVERNAME, strValue);
    }
}

