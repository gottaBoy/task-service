/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWFSubWF
extends BaseDataEntity {
    public static final String TAG_PSWFSUBWFID = "PSWFSUBWFID";
    public static final String TAG_PSWFSUBWFNAME = "PSWFSUBWFNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_SUBPSWFID = "SUBPSWFID";
    public static final String TAG_SUBPSWFNAME = "SUBPSWFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_SUBPSWFVERID = "SUBPSWFVERID";
    public static final String TAG_SUBPSWFVERNAME = "SUBPSWFVERNAME";

    public final boolean isPSWFSUBWFIDNull() {
        return this.IsParamNull(TAG_PSWFSUBWFID);
    }

    public final String getPSWFSUBWFID() {
        return this.GetParamStringValue(TAG_PSWFSUBWFID, "");
    }

    public final void setPSWFSUBWFID(String strValue) {
        this.SetParamValue(TAG_PSWFSUBWFID, strValue);
    }

    public final boolean isPSWFSUBWFNAMENull() {
        return this.IsParamNull(TAG_PSWFSUBWFNAME);
    }

    public final String getPSWFSUBWFNAME() {
        return this.GetParamStringValue(TAG_PSWFSUBWFNAME, "");
    }

    public final void setPSWFSUBWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFSUBWFNAME, strValue);
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

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isSUBPSWFIDNull() {
        return this.IsParamNull(TAG_SUBPSWFID);
    }

    public final String getSUBPSWFID() {
        return this.GetParamStringValue(TAG_SUBPSWFID, "");
    }

    public final void setSUBPSWFID(String strValue) {
        this.SetParamValue(TAG_SUBPSWFID, strValue);
    }

    public final boolean isSUBPSWFNAMENull() {
        return this.IsParamNull(TAG_SUBPSWFNAME);
    }

    public final String getSUBPSWFNAME() {
        return this.GetParamStringValue(TAG_SUBPSWFNAME, "");
    }

    public final void setSUBPSWFNAME(String strValue) {
        this.SetParamValue(TAG_SUBPSWFNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isSUBPSWFVERIDNull() {
        return this.IsParamNull(TAG_SUBPSWFVERID);
    }

    public final String getSUBPSWFVERID() {
        return this.GetParamStringValue(TAG_SUBPSWFVERID, "");
    }

    public final void setSUBPSWFVERID(String strValue) {
        this.SetParamValue(TAG_SUBPSWFVERID, strValue);
    }

    public final boolean isSUBPSWFVERNAMENull() {
        return this.IsParamNull(TAG_SUBPSWFVERNAME);
    }

    public final String getSUBPSWFVERNAME() {
        return this.GetParamStringValue(TAG_SUBPSWFVERNAME, "");
    }

    public final void setSUBPSWFVERNAME(String strValue) {
        this.SetParamValue(TAG_SUBPSWFVERNAME, strValue);
    }
}

