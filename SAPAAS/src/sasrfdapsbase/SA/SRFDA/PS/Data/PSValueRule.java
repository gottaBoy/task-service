/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSValueRule
extends BaseDataEntity {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String TAG_PSVALUERULEID = "PSVALUERULEID";
    public static final String TAG_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REGEXP = "REGEXP";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String TAG_SCRIPT = "SCRIPT";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSVALUERULEID);
    }

    public final String getPSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSVALUERULEID, "");
    }

    public final void setPSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSVALUERULEID, strValue);
    }

    public final boolean isPSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSVALUERULENAME);
    }

    public final String getPSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSVALUERULENAME, "");
    }

    public final void setPSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSVALUERULENAME, strValue);
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

    public final boolean isREGEXPNull() {
        return this.IsParamNull(TAG_REGEXP);
    }

    public final String getREGEXP() {
        return this.GetParamStringValue(TAG_REGEXP, "");
    }

    public final void setREGEXP(String strValue) {
        this.SetParamValue(TAG_REGEXP, strValue);
    }

    public final boolean isRULEINFONull() {
        return this.IsParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.GetParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.SetParamValue(TAG_RULEINFO, strValue);
    }

    public final boolean isRULETYPENull() {
        return this.IsParamNull(TAG_RULETYPE);
    }

    public final String getRULETYPE() {
        return this.GetParamStringValue(TAG_RULETYPE, "");
    }

    public final void setRULETYPE(String strValue) {
        this.SetParamValue(TAG_RULETYPE, strValue);
    }

    public final boolean isSCRIPTNull() {
        return this.IsParamNull("SCRIPT");
    }

    public final String getSCRIPT() {
        return this.GetParamStringValue("SCRIPT", "");
    }

    public final void setSCRIPT(String strValue) {
        this.SetParamValue("SCRIPT", strValue);
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

