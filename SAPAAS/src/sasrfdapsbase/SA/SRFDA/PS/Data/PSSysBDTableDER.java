/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBDTableDER
extends BaseDataEntity {
    public static final int DERLEVEL_1 = 1;
    public static final int DERLEVEL_2 = 2;
    public static final int DERLEVEL_3 = 3;
    public static final int DERLEVEL_4 = 4;
    public static final int DERLEVEL_5 = 5;
    public static final int DERLEVEL_6 = 6;
    public static final String TAG_PSSYSBDTABLEDERID = "PSSYSBDTABLEDERID";
    public static final String TAG_PSSYSBDTABLEDERNAME = "PSSYSBDTABLEDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String TAG_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DERLEVEL = "DERLEVEL";

    public final boolean isPSSYSBDTABLEDERIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDERID);
    }

    public final String getPSSYSBDTABLEDERID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEDERID, "");
    }

    public final void setPSSYSBDTABLEDERID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDERID, strValue);
    }

    public final boolean isPSSYSBDTABLEDERNAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEDERNAME);
    }

    public final String getPSSYSBDTABLEDERNAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEDERNAME, "");
    }

    public final void setPSSYSBDTABLEDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEDERNAME, strValue);
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

    public final boolean isPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEID);
    }

    public final String getPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEID, "");
    }

    public final void setPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEID, strValue);
    }

    public final boolean isPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLENAME);
    }

    public final String getPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLENAME, "");
    }

    public final void setPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLENAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
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

    public final boolean isDERLEVELNull() {
        return this.IsParamNull(TAG_DERLEVEL);
    }

    public final int getDERLEVEL() {
        return this.GetParamIntValue(TAG_DERLEVEL, 0);
    }

    public final void setDERLEVEL(int nValue) {
        this.SetParamValue(TAG_DERLEVEL, nValue);
    }
}

