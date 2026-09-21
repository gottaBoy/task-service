/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFStyleCode
extends BaseDataEntity {
    public static final String TAG_PSSFSTYLECODEID = "PSSFSTYLECODEID";
    public static final String TAG_PSSFSTYLECODENAME = "PSSFSTYLECODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STYLECODE = "STYLECODE";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";

    public final boolean isPSSFSTYLECODEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLECODEID);
    }

    public final String getPSSFSTYLECODEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLECODEID, "");
    }

    public final void setPSSFSTYLECODEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLECODEID, strValue);
    }

    public final boolean isPSSFSTYLECODENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLECODENAME);
    }

    public final String getPSSFSTYLECODENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLECODENAME, "");
    }

    public final void setPSSFSTYLECODENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLECODENAME, strValue);
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

    public final boolean isSTYLECODENull() {
        return this.IsParamNull(TAG_STYLECODE);
    }

    public final String getSTYLECODE() {
        return this.GetParamStringValue(TAG_STYLECODE, "");
    }

    public final void setSTYLECODE(String strValue) {
        this.SetParamValue(TAG_STYLECODE, strValue);
    }

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
    }
}

