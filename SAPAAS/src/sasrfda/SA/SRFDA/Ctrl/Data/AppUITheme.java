/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class AppUITheme
extends BaseDataEntity {
    public static final String TAG_APPUITHEMEID = "APPUITHEMEID";
    public static final String TAG_APPUITHEMENAME = "APPUITHEMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_STYLE = "STYLE";

    public String getAPPUITHEMEID() {
        return this.GetParamStringValue(TAG_APPUITHEMEID, "");
    }

    public void setAPPUITHEMEID(String strValue) {
        this.SetParamValue(TAG_APPUITHEMEID, strValue);
    }

    public String getAPPUITHEMENAME() {
        return this.GetParamStringValue(TAG_APPUITHEMENAME, "");
    }

    public void setAPPUITHEMENAME(String strValue) {
        this.SetParamValue(TAG_APPUITHEMENAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getSTYLE() {
        return this.GetParamStringValue(TAG_STYLE, "");
    }

    public void setSTYLE(String strValue) {
        this.SetParamValue(TAG_STYLE, strValue);
    }
}

