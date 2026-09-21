/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppSubApp
extends BaseDataEntity {
    public static final String TAG_PSAPPSUBAPPID = "PSAPPSUBAPPID";
    public static final String TAG_PSAPPSUBAPPNAME = "PSAPPSUBAPPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSSUBSYSID = "PSSUBSYSID";
    public static final String TAG_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String TAG_PSSUBAPPID = "PSSUBAPPID";
    public static final String TAG_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FOLDERNAME = "FOLDERNAME";

    public final boolean isPSAPPSUBAPPIDNull() {
        return this.IsParamNull(TAG_PSAPPSUBAPPID);
    }

    public final String getPSAPPSUBAPPID() {
        return this.GetParamStringValue(TAG_PSAPPSUBAPPID, "");
    }

    public final void setPSAPPSUBAPPID(String strValue) {
        this.SetParamValue(TAG_PSAPPSUBAPPID, strValue);
    }

    public final boolean isPSAPPSUBAPPNAMENull() {
        return this.IsParamNull(TAG_PSAPPSUBAPPNAME);
    }

    public final String getPSAPPSUBAPPNAME() {
        return this.GetParamStringValue(TAG_PSAPPSUBAPPNAME, "");
    }

    public final void setPSAPPSUBAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSUBAPPNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isPSSUBAPPIDNull() {
        return this.IsParamNull(TAG_PSSUBAPPID);
    }

    public final String getPSSUBAPPID() {
        return this.GetParamStringValue(TAG_PSSUBAPPID, "");
    }

    public final void setPSSUBAPPID(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPID, strValue);
    }

    public final boolean isPSSUBAPPNAMENull() {
        return this.IsParamNull(TAG_PSSUBAPPNAME);
    }

    public final String getPSSUBAPPNAME() {
        return this.GetParamStringValue(TAG_PSSUBAPPNAME, "");
    }

    public final void setPSSUBAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPNAME, strValue);
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

    public final boolean isFOLDERNAMENull() {
        return this.IsParamNull(TAG_FOLDERNAME);
    }

    public final String getFOLDERNAME() {
        return this.GetParamStringValue(TAG_FOLDERNAME, "");
    }

    public final void setFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_FOLDERNAME, strValue);
    }
}

