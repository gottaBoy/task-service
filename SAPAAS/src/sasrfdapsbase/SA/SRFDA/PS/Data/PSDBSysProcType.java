/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBSysProcType
extends BaseDataEntity {
    public static final String TAG_PSDBSYSPROCTYPEID = "PSDBSYSPROCTYPEID";
    public static final String TAG_PSDBSYSPROCTYPENAME = "PSDBSYSPROCTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_RETURNRESULT = "RETURNRESULT";

    public final boolean isPSDBSYSPROCTYPEIDNull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTYPEID);
    }

    public final String getPSDBSYSPROCTYPEID() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTYPEID, "");
    }

    public final void setPSDBSYSPROCTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTYPEID, strValue);
    }

    public final boolean isPSDBSYSPROCTYPENAMENull() {
        return this.IsParamNull(TAG_PSDBSYSPROCTYPENAME);
    }

    public final String getPSDBSYSPROCTYPENAME() {
        return this.GetParamStringValue(TAG_PSDBSYSPROCTYPENAME, "");
    }

    public final void setPSDBSYSPROCTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDBSYSPROCTYPENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isRETURNRESULTNull() {
        return this.IsParamNull(TAG_RETURNRESULT);
    }

    public final boolean getRETURNRESULT() {
        return this.GetParamIntValue(TAG_RETURNRESULT, 0) == 1;
    }

    public final void setRETURNRESULT(boolean bValue) {
        this.SetParamValue(TAG_RETURNRESULT, bValue ? 1 : 0);
    }
}

