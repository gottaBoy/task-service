/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobileAppPage
extends BaseDataEntity {
    public static final String TAG_MOBAPPPAGEID = "MOBAPPPAGEID";
    public static final String TAG_MOBAPPPAGENAME = "MOBAPPPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MOBILEAPPID = "MOBILEAPPID";
    public static final String TAG_MOBILEAPPNAME = "MOBILEAPPNAME";
    public static final String TAG_MOBILEPAGEID = "MOBILEPAGEID";
    public static final String TAG_MOBILEPAGENAME = "MOBILEPAGENAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isMOBAPPPAGEIDNull() {
        return this.IsParamNull(TAG_MOBAPPPAGEID);
    }

    public final String getMOBAPPPAGEID() {
        return this.GetParamStringValue(TAG_MOBAPPPAGEID, "");
    }

    public final void setMOBAPPPAGEID(String strValue) {
        this.SetParamValue(TAG_MOBAPPPAGEID, strValue);
    }

    public final boolean isMOBAPPPAGENAMENull() {
        return this.IsParamNull(TAG_MOBAPPPAGENAME);
    }

    public final String getMOBAPPPAGENAME() {
        return this.GetParamStringValue(TAG_MOBAPPPAGENAME, "");
    }

    public final void setMOBAPPPAGENAME(String strValue) {
        this.SetParamValue(TAG_MOBAPPPAGENAME, strValue);
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

    public final boolean isMOBILEPAGEIDNull() {
        return this.IsParamNull(TAG_MOBILEPAGEID);
    }

    public final String getMOBILEPAGEID() {
        return this.GetParamStringValue(TAG_MOBILEPAGEID, "");
    }

    public final void setMOBILEPAGEID(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGEID, strValue);
    }

    public final boolean isMOBILEPAGENAMENull() {
        return this.IsParamNull(TAG_MOBILEPAGENAME);
    }

    public final String getMOBILEPAGENAME() {
        return this.GetParamStringValue(TAG_MOBILEPAGENAME, "");
    }

    public final void setMOBILEPAGENAME(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGENAME, strValue);
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

