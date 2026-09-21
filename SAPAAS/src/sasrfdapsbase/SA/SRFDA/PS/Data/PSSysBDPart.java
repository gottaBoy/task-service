/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDPart
extends BaseDataEntity {
    public static final String TAG_PSSYSBDPARTID = "PSSYSBDPARTID";
    public static final String TAG_PSSYSBDPARTNAME = "PSSYSBDPARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";

    public final boolean isPSSYSBDPARTIDNull() {
        return this.IsParamNull(TAG_PSSYSBDPARTID);
    }

    public final String getPSSYSBDPARTID() {
        return this.GetParamStringValue(TAG_PSSYSBDPARTID, "");
    }

    public final void setPSSYSBDPARTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDPARTID, strValue);
    }

    public final boolean isPSSYSBDPARTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDPARTNAME);
    }

    public final String getPSSYSBDPARTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDPARTNAME, "");
    }

    public final void setPSSYSBDPARTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDPARTNAME, strValue);
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

    public final boolean isPSSYSBDSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMEID);
    }

    public final String getPSSYSBDSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMEID, "");
    }

    public final void setPSSYSBDSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMEID, strValue);
    }

    public final boolean isPSSYSBDSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMENAME);
    }

    public final String getPSSYSBDSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMENAME, "");
    }

    public final void setPSSYSBDSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMENAME, strValue);
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

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }
}

