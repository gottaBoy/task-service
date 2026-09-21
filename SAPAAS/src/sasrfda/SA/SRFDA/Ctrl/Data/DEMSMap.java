/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEMSMap
extends BaseDataEntity {
    public static final String TAG_DEMSMAPID = "DEMSMAPID";
    public static final String TAG_DEMSMAPNAME = "DEMSMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEMAINSTATEID = "DEMAINSTATEID";
    public static final String TAG_DEMAINSTATENAME = "DEMAINSTATENAME";
    public static final String TAG_PDEID = "PDEID";
    public static final String TAG_PDENAME = "PDENAME";
    public static final String TAG_PDEMAINSTATEID = "PDEMAINSTATEID";
    public static final String TAG_PDEMAINSTATENAME = "PDEMAINSTATENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isDEMSMAPIDNull() {
        return this.IsParamNull(TAG_DEMSMAPID);
    }

    public final String getDEMSMAPID() {
        return this.GetParamStringValue(TAG_DEMSMAPID, "");
    }

    public final void setDEMSMAPID(String strValue) {
        this.SetParamValue(TAG_DEMSMAPID, strValue);
    }

    public final boolean isDEMSMAPNAMENull() {
        return this.IsParamNull(TAG_DEMSMAPNAME);
    }

    public final String getDEMSMAPNAME() {
        return this.GetParamStringValue(TAG_DEMSMAPNAME, "");
    }

    public final void setDEMSMAPNAME(String strValue) {
        this.SetParamValue(TAG_DEMSMAPNAME, strValue);
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

    public final boolean isDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_DEMAINSTATEID);
    }

    public final String getDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_DEMAINSTATEID, "");
    }

    public final void setDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATEID, strValue);
    }

    public final boolean isDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_DEMAINSTATENAME);
    }

    public final String getDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_DEMAINSTATENAME, "");
    }

    public final void setDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_DEMAINSTATENAME, strValue);
    }

    public final boolean isPDEIDNull() {
        return this.IsParamNull(TAG_PDEID);
    }

    public final String getPDEID() {
        return this.GetParamStringValue(TAG_PDEID, "");
    }

    public final void setPDEID(String strValue) {
        this.SetParamValue(TAG_PDEID, strValue);
    }

    public final boolean isPDENAMENull() {
        return this.IsParamNull(TAG_PDENAME);
    }

    public final String getPDENAME() {
        return this.GetParamStringValue(TAG_PDENAME, "");
    }

    public final void setPDENAME(String strValue) {
        this.SetParamValue(TAG_PDENAME, strValue);
    }

    public final boolean isPDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PDEMAINSTATEID);
    }

    public final String getPDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PDEMAINSTATEID, "");
    }

    public final void setPDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PDEMAINSTATEID, strValue);
    }

    public final boolean isPDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PDEMAINSTATENAME);
    }

    public final String getPDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PDEMAINSTATENAME, "");
    }

    public final void setPDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PDEMAINSTATENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

