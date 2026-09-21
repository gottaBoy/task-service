/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFValueRuleType
extends BaseDataEntity {
    public static final String TAG_PSDEFVRTYPEID = "PSDEFVRTYPEID";
    public static final String TAG_PSDEFVRTYPENAME = "PSDEFVRTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PROCESSOBJ = "PROCESSOBJ";

    public final boolean isPSDEFVRTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEFVRTYPEID);
    }

    public final String getPSDEFVRTYPEID() {
        return this.GetParamStringValue(TAG_PSDEFVRTYPEID, "");
    }

    public final void setPSDEFVRTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRTYPEID, strValue);
    }

    public final boolean isPSDEFVRTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEFVRTYPENAME);
    }

    public final String getPSDEFVRTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEFVRTYPENAME, "");
    }

    public final void setPSDEFVRTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRTYPENAME, strValue);
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

    public final boolean isPROCESSOBJNull() {
        return this.IsParamNull(TAG_PROCESSOBJ);
    }

    public final String getPROCESSOBJ() {
        return this.GetParamStringValue(TAG_PROCESSOBJ, "");
    }

    public final void setPROCESSOBJ(String strValue) {
        this.SetParamValue(TAG_PROCESSOBJ, strValue);
    }
}

