/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCWorkspaceUser
extends BaseDataEntity {
    public static final String TAG_PSDCWORKSPACEUSERID = "PSDCWORKSPACEUSERID";
    public static final String TAG_PSDCWORKSPACEUSERNAME = "PSDCWORKSPACEUSERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String TAG_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String TAG_PSDEVUSERID = "PSDEVUSERID";
    public static final String TAG_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String TAG_ACCESSTIME = "ACCESSTIME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDCWORKSPACEUSERIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEUSERID);
    }

    public final String getPSDCWORKSPACEUSERID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEUSERID, "");
    }

    public final void setPSDCWORKSPACEUSERID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEUSERID, strValue);
    }

    public final boolean isPSDCWORKSPACEUSERNAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEUSERNAME);
    }

    public final String getPSDCWORKSPACEUSERNAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEUSERNAME, "");
    }

    public final void setPSDCWORKSPACEUSERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEUSERNAME, strValue);
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

    public final boolean isPSDCWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEID);
    }

    public final String getPSDCWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEID, "");
    }

    public final void setPSDCWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEID, strValue);
    }

    public final boolean isPSDCWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACENAME);
    }

    public final String getPSDCWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACENAME, "");
    }

    public final void setPSDCWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACENAME, strValue);
    }

    public final boolean isPSDEVUSERIDNull() {
        return this.IsParamNull(TAG_PSDEVUSERID);
    }

    public final String getPSDEVUSERID() {
        return this.GetParamStringValue(TAG_PSDEVUSERID, "");
    }

    public final void setPSDEVUSERID(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERID, strValue);
    }

    public final boolean isPSDEVUSERNAMENull() {
        return this.IsParamNull(TAG_PSDEVUSERNAME);
    }

    public final String getPSDEVUSERNAME() {
        return this.GetParamStringValue(TAG_PSDEVUSERNAME, "");
    }

    public final void setPSDEVUSERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERNAME, strValue);
    }

    public final boolean isACCESSTIMENull() {
        return this.IsParamNull(TAG_ACCESSTIME);
    }

    public final Date getACCESSTIME() {
        return this.GetParamDateValue(TAG_ACCESSTIME, null);
    }

    public final void setACCESSTIME(Date dtValue) {
        this.SetParamValue(TAG_ACCESSTIME, dtValue);
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

