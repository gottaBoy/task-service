/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFormRF
extends BaseDataEntity {
    public static final String TAG_PSDEFORMRFID = "PSDEFORMRFID";
    public static final String TAG_PSDEFORMRFNAME = "PSDEFORMRFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSDEFORMID = "MAJORPSDEFORMID";
    public static final String TAG_MAJORPSDEFORMNAME = "MAJORPSDEFORMNAME";
    public static final String TAG_MINORPSDEFORMID = "MINORPSDEFORMID";
    public static final String TAG_MINORPSDEFORMNAME = "MINORPSDEFORMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";

    public final boolean isPSDEFORMRFIDNull() {
        return this.IsParamNull(TAG_PSDEFORMRFID);
    }

    public final String getPSDEFORMRFID() {
        return this.GetParamStringValue(TAG_PSDEFORMRFID, "");
    }

    public final void setPSDEFORMRFID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMRFID, strValue);
    }

    public final boolean isPSDEFORMRFNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMRFNAME);
    }

    public final String getPSDEFORMRFNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMRFNAME, "");
    }

    public final void setPSDEFORMRFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMRFNAME, strValue);
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

    public final boolean isMAJORPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEFORMID);
    }

    public final String getMAJORPSDEFORMID() {
        return this.GetParamStringValue(TAG_MAJORPSDEFORMID, "");
    }

    public final void setMAJORPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFORMID, strValue);
    }

    public final boolean isMAJORPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEFORMNAME);
    }

    public final String getMAJORPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEFORMNAME, "");
    }

    public final void setMAJORPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFORMNAME, strValue);
    }

    public final boolean isMINORPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MINORPSDEFORMID);
    }

    public final String getMINORPSDEFORMID() {
        return this.GetParamStringValue(TAG_MINORPSDEFORMID, "");
    }

    public final void setMINORPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFORMID, strValue);
    }

    public final boolean isMINORPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEFORMNAME);
    }

    public final String getMINORPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEFORMNAME, "");
    }

    public final void setMINORPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFORMNAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }
}

