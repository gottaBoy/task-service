/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFStylePkg
extends BaseDataEntity {
    public static final String TAG_PSPFSTYLEPKGID = "PSPFSTYLEPKGID";
    public static final String TAG_PSPFSTYLEPKGNAME = "PSPFSTYLEPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PSPFPKGID = "PSPFPKGID";
    public static final String TAG_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String TAG_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String TAG_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSPFSTYLEPKGIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEPKGID);
    }

    public final String getPSPFSTYLEPKGID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEPKGID, "");
    }

    public final void setPSPFSTYLEPKGID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEPKGID, strValue);
    }

    public final boolean isPSPFSTYLEPKGNAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLEPKGNAME);
    }

    public final String getPSPFSTYLEPKGNAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLEPKGNAME, "");
    }

    public final void setPSPFSTYLEPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEPKGNAME, strValue);
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

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
    }

    public final boolean isPSPFPKGIDNull() {
        return this.IsParamNull(TAG_PSPFPKGID);
    }

    public final String getPSPFPKGID() {
        return this.GetParamStringValue(TAG_PSPFPKGID, "");
    }

    public final void setPSPFPKGID(String strValue) {
        this.SetParamValue(TAG_PSPFPKGID, strValue);
    }

    public final boolean isPSPFPKGNAMENull() {
        return this.IsParamNull(TAG_PSPFPKGNAME);
    }

    public final String getPSPFPKGNAME() {
        return this.GetParamStringValue(TAG_PSPFPKGNAME, "");
    }

    public final void setPSPFPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPKGNAME, strValue);
    }

    public final boolean isPSPFPKGVERIDNull() {
        return this.IsParamNull(TAG_PSPFPKGVERID);
    }

    public final String getPSPFPKGVERID() {
        return this.GetParamStringValue(TAG_PSPFPKGVERID, "");
    }

    public final void setPSPFPKGVERID(String strValue) {
        this.SetParamValue(TAG_PSPFPKGVERID, strValue);
    }

    public final boolean isPSPFPKGVERNAMENull() {
        return this.IsParamNull(TAG_PSPFPKGVERNAME);
    }

    public final String getPSPFPKGVERNAME() {
        return this.GetParamStringValue(TAG_PSPFPKGVERNAME, "");
    }

    public final void setPSPFPKGVERNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPKGVERNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

