/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSMobAppPackTD
extends BaseDataEntity {
    public static final String TAG_PSMOBAPPPACKTDID = "PSMOBAPPPACKTDID";
    public static final String TAG_PSMOBAPPPACKTDNAME = "PSMOBAPPPACKTDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String TAG_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String TAG_PSDCMOBAPPTESTDEVICEID = "PSDCMOBAPPTESTDEVICEID";
    public static final String TAG_PSDCMOBAPPTESTDEVICENAME = "PSDCMOBAPPTESTDEVICENAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSMOBAPPPACKTDIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKTDID);
    }

    public final String getPSMOBAPPPACKTDID() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKTDID, "");
    }

    public final void setPSMOBAPPPACKTDID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKTDID, strValue);
    }

    public final boolean isPSMOBAPPPACKTDNAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKTDNAME);
    }

    public final String getPSMOBAPPPACKTDNAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKTDNAME, "");
    }

    public final void setPSMOBAPPPACKTDNAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKTDNAME, strValue);
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

    public final boolean isPSMOBAPPPACKIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKID);
    }

    public final String getPSMOBAPPPACKID() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKID, "");
    }

    public final void setPSMOBAPPPACKID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKID, strValue);
    }

    public final boolean isPSMOBAPPPACKNAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKNAME);
    }

    public final String getPSMOBAPPPACKNAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKNAME, "");
    }

    public final void setPSMOBAPPPACKNAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKNAME, strValue);
    }

    public final boolean isPSDCMOBAPPTESTDEVICEIDNull() {
        return this.IsParamNull(TAG_PSDCMOBAPPTESTDEVICEID);
    }

    public final String getPSDCMOBAPPTESTDEVICEID() {
        return this.GetParamStringValue(TAG_PSDCMOBAPPTESTDEVICEID, "");
    }

    public final void setPSDCMOBAPPTESTDEVICEID(String strValue) {
        this.SetParamValue(TAG_PSDCMOBAPPTESTDEVICEID, strValue);
    }

    public final boolean isPSDCMOBAPPTESTDEVICENAMENull() {
        return this.IsParamNull(TAG_PSDCMOBAPPTESTDEVICENAME);
    }

    public final String getPSDCMOBAPPTESTDEVICENAME() {
        return this.GetParamStringValue(TAG_PSDCMOBAPPTESTDEVICENAME, "");
    }

    public final void setPSDCMOBAPPTESTDEVICENAME(String strValue) {
        this.SetParamValue(TAG_PSDCMOBAPPTESTDEVICENAME, strValue);
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

