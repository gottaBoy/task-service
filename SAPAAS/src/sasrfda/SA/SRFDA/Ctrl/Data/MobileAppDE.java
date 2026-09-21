/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobileAppDE
extends BaseDataEntity {
    public static final String TAG_MOBAPPDEID = "MOBAPPDEID";
    public static final String TAG_MOBAPPDENAME = "MOBAPPDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MOBILEAPPID = "MOBILEAPPID";
    public static final String TAG_MOBILEAPPNAME = "MOBILEAPPNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";

    public final boolean isMOBAPPDEIDNull() {
        return this.IsParamNull(TAG_MOBAPPDEID);
    }

    public final String getMOBAPPDEID() {
        return this.GetParamStringValue(TAG_MOBAPPDEID, "");
    }

    public final void setMOBAPPDEID(String strValue) {
        this.SetParamValue(TAG_MOBAPPDEID, strValue);
    }

    public final boolean isMOBAPPDENAMENull() {
        return this.IsParamNull(TAG_MOBAPPDENAME);
    }

    public final String getMOBAPPDENAME() {
        return this.GetParamStringValue(TAG_MOBAPPDENAME, "");
    }

    public final void setMOBAPPDENAME(String strValue) {
        this.SetParamValue(TAG_MOBAPPDENAME, strValue);
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

    public final boolean isMOBILEAPPIDNull() {
        return this.IsParamNull(TAG_MOBILEAPPID);
    }

    public final String getMOBILEAPPID() {
        return this.GetParamStringValue(TAG_MOBILEAPPID, "");
    }

    public final void setMOBILEAPPID(String strValue) {
        this.SetParamValue(TAG_MOBILEAPPID, strValue);
    }

    public final boolean isMOBILEAPPNAMENull() {
        return this.IsParamNull(TAG_MOBILEAPPNAME);
    }

    public final String getMOBILEAPPNAME() {
        return this.GetParamStringValue(TAG_MOBILEAPPNAME, "");
    }

    public final void setMOBILEAPPNAME(String strValue) {
        this.SetParamValue(TAG_MOBILEAPPNAME, strValue);
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
}

