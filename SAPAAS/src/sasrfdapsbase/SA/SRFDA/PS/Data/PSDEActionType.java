/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEActionType
extends BaseDataEntity {
    public static final String TAG_PSDEACTIONTYPEID = "PSDEACTIONTYPEID";
    public static final String TAG_PSDEACTIONTYPENAME = "PSDEACTIONTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PROCESSOBJ = "PROCESSOBJ";
    public static final String TAG_TYPEPARAM = "TYPEPARAM";

    public final boolean isPSDEACTIONTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONTYPEID);
    }

    public final String getPSDEACTIONTYPEID() {
        return this.GetParamStringValue(TAG_PSDEACTIONTYPEID, "");
    }

    public final void setPSDEACTIONTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTYPEID, strValue);
    }

    public final boolean isPSDEACTIONTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONTYPENAME);
    }

    public final String getPSDEACTIONTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONTYPENAME, "");
    }

    public final void setPSDEACTIONTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTYPENAME, strValue);
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

    public final boolean isTYPEPARAMNull() {
        return this.IsParamNull(TAG_TYPEPARAM);
    }

    public final String getTYPEPARAM() {
        return this.GetParamStringValue(TAG_TYPEPARAM, "");
    }

    public final void setTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_TYPEPARAM, strValue);
    }
}

