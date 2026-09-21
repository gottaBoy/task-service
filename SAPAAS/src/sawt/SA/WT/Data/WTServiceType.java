/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTServiceType
extends BaseDataEntity {
    public static final String TAG_WTSERVICETYPEID = "WTSERVICETYPEID";
    public static final String TAG_WTSERVICETYPENAME = "WTSERVICETYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SERVICEHELPER = "SERVICEHELPER";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isWTSERVICETYPEIDNull() {
        return this.IsParamNull(TAG_WTSERVICETYPEID);
    }

    public final String getWTSERVICETYPEID() {
        return this.GetParamStringValue(TAG_WTSERVICETYPEID, "");
    }

    public final void setWTSERVICETYPEID(String strValue) {
        this.SetParamValue(TAG_WTSERVICETYPEID, strValue);
    }

    public final boolean isWTSERVICETYPENAMENull() {
        return this.IsParamNull(TAG_WTSERVICETYPENAME);
    }

    public final String getWTSERVICETYPENAME() {
        return this.GetParamStringValue(TAG_WTSERVICETYPENAME, "");
    }

    public final void setWTSERVICETYPENAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICETYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isSERVICEHELPERNull() {
        return this.IsParamNull(TAG_SERVICEHELPER);
    }

    public final String getSERVICEHELPER() {
        return this.GetParamStringValue(TAG_SERVICEHELPER, "");
    }

    public final void setSERVICEHELPER(String strValue) {
        this.SetParamValue(TAG_SERVICEHELPER, strValue);
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

