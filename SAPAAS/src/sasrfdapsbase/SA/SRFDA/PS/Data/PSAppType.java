/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppType
extends BaseDataEntity {
    public static final String TAG_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String TAG_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MOBILEMODE = "MOBILEMODE";

    public final boolean isPSAPPTYPEIDNull() {
        return this.IsParamNull(TAG_PSAPPTYPEID);
    }

    public final String getPSAPPTYPEID() {
        return this.GetParamStringValue(TAG_PSAPPTYPEID, "");
    }

    public final void setPSAPPTYPEID(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPEID, strValue);
    }

    public final boolean isPSAPPTYPENAMENull() {
        return this.IsParamNull(TAG_PSAPPTYPENAME);
    }

    public final String getPSAPPTYPENAME() {
        return this.GetParamStringValue(TAG_PSAPPTYPENAME, "");
    }

    public final void setPSAPPTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMOBILEMODENull() {
        return this.IsParamNull(TAG_MOBILEMODE);
    }

    public final boolean getMOBILEMODE() {
        return this.GetParamIntValue(TAG_MOBILEMODE, 0) == 1;
    }

    public final void setMOBILEMODE(boolean bValue) {
        this.SetParamValue(TAG_MOBILEMODE, bValue ? 1 : 0);
    }
}

