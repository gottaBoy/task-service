/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDModule
extends BaseDataEntity {
    public static final int IMPDEMODE_EXCLUDE = 1;
    public static final int IMPDEMODE_INCLUDE = 2;
    public static final String TAG_PSSYSBDMODULEID = "PSSYSBDMODULEID";
    public static final String TAG_PSSYSBDMODULENAME = "PSSYSBDMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_IMPDEMODE = "IMPDEMODE";
    public static final String TAG_DENAMES = "DENAMES";

    public final boolean isPSSYSBDMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDMODULEID);
    }

    public final String getPSSYSBDMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSBDMODULEID, "");
    }

    public final void setPSSYSBDMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDMODULEID, strValue);
    }

    public final boolean isPSSYSBDMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDMODULENAME);
    }

    public final String getPSSYSBDMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDMODULENAME, "");
    }

    public final void setPSSYSBDMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDMODULENAME, strValue);
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

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
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

    public final boolean isIMPDEMODENull() {
        return this.IsParamNull(TAG_IMPDEMODE);
    }

    public final int getIMPDEMODE() {
        return this.GetParamIntValue(TAG_IMPDEMODE, 0);
    }

    public final void setIMPDEMODE(int nValue) {
        this.SetParamValue(TAG_IMPDEMODE, nValue);
    }

    public final boolean isDENAMESNull() {
        return this.IsParamNull(TAG_DENAMES);
    }

    public final String getDENAMES() {
        return this.GetParamStringValue(TAG_DENAMES, "");
    }

    public final void setDENAMES(String strValue) {
        this.SetParamValue(TAG_DENAMES, strValue);
    }
}

