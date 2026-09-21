/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LayoutPanel
extends BaseDataEntity {
    public static final String TAG_LAYOUTPANELID = "LAYOUTPANELID";
    public static final String TAG_LAYOUTPANELNAME = "LAYOUTPANELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";

    public final boolean isLAYOUTPANELIDNull() {
        return this.IsParamNull(TAG_LAYOUTPANELID);
    }

    public final String getLAYOUTPANELID() {
        return this.GetParamStringValue(TAG_LAYOUTPANELID, "");
    }

    public final void setLAYOUTPANELID(String strValue) {
        this.SetParamValue(TAG_LAYOUTPANELID, strValue);
    }

    public final boolean isLAYOUTPANELNAMENull() {
        return this.IsParamNull(TAG_LAYOUTPANELNAME);
    }

    public final String getLAYOUTPANELNAME() {
        return this.GetParamStringValue(TAG_LAYOUTPANELNAME, "");
    }

    public final void setLAYOUTPANELNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTPANELNAME, strValue);
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

    public final boolean isBKCOLORNull() {
        return this.IsParamNull(TAG_BKCOLOR);
    }

    public final String getBKCOLOR() {
        return this.GetParamStringValue(TAG_BKCOLOR, "");
    }

    public final void setBKCOLOR(String strValue) {
        this.SetParamValue(TAG_BKCOLOR, strValue);
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

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.GetParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.SetParamValue(TAG_WIDTH, Float.valueOf(fValue));
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final float getHEIGHT() {
        return this.GetParamFloatValue(TAG_HEIGHT, 0.0f);
    }

    public final void setHEIGHT(float fValue) {
        this.SetParamValue(TAG_HEIGHT, Float.valueOf(fValue));
    }
}

