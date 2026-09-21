/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBSPPartTempl
extends BaseDataEntity {
    public static final String TAG_PSDBSPPARTTEMPLID = "PSDBSPPARTTEMPLID";
    public static final String TAG_PSDBSPPARTTEMPLNAME = "PSDBSPPARTTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDBSYSPROCTEMPLID = "PSDBSYSPROCTEMPLID";
    public static final String TAG_PSDBSYSPROCTEMPLNAME = "PSDBSYSPROCTEMPLNAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDBSPPARTTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDBSPPARTTEMPLID);
    }

    public final String getPSDBSPPARTTEMPLID() {
        return this.GetParamStringValue(TAG_PSDBSPPARTTEMPLID, "");
    }

    public final void setPSDBSPPARTTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDBSPPARTTEMPLID, strValue);
    }

    public final boolean isPSDBSPPARTTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDBSPPARTTEMPLNAME);
    }

    public final String getPSDBSPPARTTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDBSPPARTTEMPLNAME, "");
    }

    public final void setPSDBSPPARTTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDBSPPARTTEMPLNAME, strValue);
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

    public final boolean isPSDBSYSPROCTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTEMPLID);
    }

    public final String getPSDBSYSPROCTEMPLID() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTEMPLID, "");
    }

    public final void setPSDBSYSPROCTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTEMPLID, strValue);
    }

    public final boolean isPSDBSYSPROCTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTEMPLNAME);
    }

    public final String getPSDBSYSPROCTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTEMPLNAME, "");
    }

    public final void setPSDBSYSPROCTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTEMPLNAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
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

