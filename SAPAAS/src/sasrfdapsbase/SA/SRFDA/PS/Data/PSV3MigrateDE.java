/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSV3MigrateDE
extends BaseDataEntity {
    public static final String TAG_PSV3MIGRATEDEID = "PSV3MIGRATEDEID";
    public static final String TAG_PSV3MIGRATEDENAME = "PSV3MIGRATEDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String TAG_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";

    public final boolean isPSV3MIGRATEDEIDNull() {
        return this.IsParamNull(TAG_PSV3MIGRATEDEID);
    }

    public final String getPSV3MIGRATEDEID() {
        return this.GetParamStringValue(TAG_PSV3MIGRATEDEID, "");
    }

    public final void setPSV3MIGRATEDEID(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATEDEID, strValue);
    }

    public final boolean isPSV3MIGRATEDENAMENull() {
        return this.IsParamNull(TAG_PSV3MIGRATEDENAME);
    }

    public final String getPSV3MIGRATEDENAME() {
        return this.GetParamStringValue(TAG_PSV3MIGRATEDENAME, "");
    }

    public final void setPSV3MIGRATEDENAME(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATEDENAME, strValue);
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

    public final boolean isPSV3MIGRATEIDNull() {
        return this.IsParamNull(TAG_PSV3MIGRATEID);
    }

    public final String getPSV3MIGRATEID() {
        return this.GetParamStringValue(TAG_PSV3MIGRATEID, "");
    }

    public final void setPSV3MIGRATEID(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATEID, strValue);
    }

    public final boolean isPSV3MIGRATENAMENull() {
        return this.IsParamNull(TAG_PSV3MIGRATENAME);
    }

    public final String getPSV3MIGRATENAME() {
        return this.GetParamStringValue(TAG_PSV3MIGRATENAME, "");
    }

    public final void setPSV3MIGRATENAME(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATENAME, strValue);
    }

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }
}

