/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppDERSView
extends BaseDataEntity {
    public static final String TAG_PSAPPDERSVIEWID = "PSAPPDERSVIEWID";
    public static final String TAG_PSAPPDERSVIEWNAME = "PSAPPDERSVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPDERSID = "PSAPPDERSID";
    public static final String TAG_PSAPPDERSNAME = "PSAPPDERSNAME";
    public static final String TAG_PSAPPDEVIEWID = "PSAPPDEVIEWID";
    public static final String TAG_PSAPPDEVIEWNAME = "PSAPPDEVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";

    public final boolean isPSAPPDERSVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPDERSVIEWID);
    }

    public final String getPSAPPDERSVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPDERSVIEWID, "");
    }

    public final void setPSAPPDERSVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSVIEWID, strValue);
    }

    public final boolean isPSAPPDERSVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPDERSVIEWNAME);
    }

    public final String getPSAPPDERSVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPDERSVIEWNAME, "");
    }

    public final void setPSAPPDERSVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSVIEWNAME, strValue);
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

    public final boolean isPSAPPDERSIDNull() {
        return this.IsParamNull(TAG_PSAPPDERSID);
    }

    public final String getPSAPPDERSID() {
        return this.GetParamStringValue(TAG_PSAPPDERSID, "");
    }

    public final void setPSAPPDERSID(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSID, strValue);
    }

    public final boolean isPSAPPDERSNAMENull() {
        return this.IsParamNull(TAG_PSAPPDERSNAME);
    }

    public final String getPSAPPDERSNAME() {
        return this.GetParamStringValue(TAG_PSAPPDERSNAME, "");
    }

    public final void setPSAPPDERSNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPDERSNAME, strValue);
    }

    public final boolean isPSAPPDEVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPDEVIEWID);
    }

    public final String getPSAPPDEVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPDEVIEWID, "");
    }

    public final void setPSAPPDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPDEVIEWID, strValue);
    }

    public final boolean isPSAPPDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPDEVIEWNAME);
    }

    public final String getPSAPPDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPDEVIEWNAME, "");
    }

    public final void setPSAPPDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPDEVIEWNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }
}

