/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSys
extends BaseDataEntity {
    public static final String PSDEPSYSTYPE_DEVSLNSYS = "DEVSLNSYS";
    public static final String PSDEPSYSTYPE_SAASSYS = "SAASSYS";
    public static final String TAG_PSDEPSYSID = "PSDEPSYSID";
    public static final String TAG_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String TAG_PSDEPSYSTYPE = "PSDEPSYSTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String TAG_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";

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

    public final boolean isPSDEPSYSTYPENull() {
        return this.IsParamNull(TAG_PSDEPSYSTYPE);
    }

    public final String getPSDEPSYSTYPE() {
        return this.GetParamStringValue(TAG_PSDEPSYSTYPE, "");
    }

    public final void setPSDEPSYSTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isROPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNID);
    }

    public final String getROPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNID, "");
    }

    public final void setROPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNID, strValue);
    }

    public final boolean isROPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNNAME);
    }

    public final String getROPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNNAME, "");
    }

    public final void setROPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNNAME, strValue);
    }
}

