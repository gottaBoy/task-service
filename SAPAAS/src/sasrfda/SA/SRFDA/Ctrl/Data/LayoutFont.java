/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LayoutFont
extends BaseDataEntity {
    public static final String TAG_LAYOUTFONTID = "LAYOUTFONTID";
    public static final String TAG_LAYOUTFONTNAME = "LAYOUTFONTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FONTNAME = "FONTNAME";
    public static final String TAG_FONTSIZE = "FONTSIZE";

    public final boolean isLAYOUTFONTIDNull() {
        return this.IsParamNull(TAG_LAYOUTFONTID);
    }

    public final String getLAYOUTFONTID() {
        return this.GetParamStringValue(TAG_LAYOUTFONTID, "");
    }

    public final void setLAYOUTFONTID(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTID, strValue);
    }

    public final boolean isLAYOUTFONTNAMENull() {
        return this.IsParamNull(TAG_LAYOUTFONTNAME);
    }

    public final String getLAYOUTFONTNAME() {
        return this.GetParamStringValue(TAG_LAYOUTFONTNAME, "");
    }

    public final void setLAYOUTFONTNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTNAME, strValue);
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

    public final boolean isFONTNAMENull() {
        return this.IsParamNull(TAG_FONTNAME);
    }

    public final String getFONTNAME() {
        return this.GetParamStringValue(TAG_FONTNAME, "");
    }

    public final void setFONTNAME(String strValue) {
        this.SetParamValue(TAG_FONTNAME, strValue);
    }

    public final boolean isFONTSIZENull() {
        return this.IsParamNull(TAG_FONTSIZE);
    }

    public final float getFONTSIZE() {
        return this.GetParamFloatValue(TAG_FONTSIZE, 0.0f);
    }

    public final void setFONTSIZE(float fValue) {
        this.SetParamValue(TAG_FONTSIZE, Float.valueOf(fValue));
    }
}

