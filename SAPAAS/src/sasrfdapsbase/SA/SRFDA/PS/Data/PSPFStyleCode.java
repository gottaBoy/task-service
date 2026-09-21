/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFStyleCode
extends BaseDataEntity {
    public static final String TAG_PSPFSTYLECODEID = "PSPFSTYLECODEID";
    public static final String TAG_PSPFSTYLECODENAME = "PSPFSTYLECODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STYLECODE = "STYLECODE";

    public final boolean isPSPFSTYLECODEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLECODEID);
    }

    public final String getPSPFSTYLECODEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLECODEID, "");
    }

    public final void setPSPFSTYLECODEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLECODEID, strValue);
    }

    public final boolean isPSPFSTYLECODENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLECODENAME);
    }

    public final String getPSPFSTYLECODENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLECODENAME, "");
    }

    public final void setPSPFSTYLECODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLECODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSTYLECODENull() {
        return this.IsParamNull(TAG_STYLECODE);
    }

    public final String getSTYLECODE() {
        return this.GetParamStringValue(TAG_STYLECODE, "");
    }

    public final void setSTYLECODE(String strValue) {
        this.SetParamValue(TAG_STYLECODE, strValue);
    }
}

