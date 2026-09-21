/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEUIActionType
extends BaseDataEntity {
    public static final String TAG_PSDEUIACTIONTYPEID = "PSDEUIACTIONTYPEID";
    public static final String TAG_PSDEUIACTIONTYPENAME = "PSDEUIACTIONTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEUIACTIONTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONTYPEID);
    }

    public final String getPSDEUIACTIONTYPEID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONTYPEID, "");
    }

    public final void setPSDEUIACTIONTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONTYPEID, strValue);
    }

    public final boolean isPSDEUIACTIONTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONTYPENAME);
    }

    public final String getPSDEUIACTIONTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONTYPENAME, "");
    }

    public final void setPSDEUIACTIONTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONTYPENAME, strValue);
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

