/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDynaDEFormTempl
extends BaseDataEntity {
    public static final String TAG_PSDYNADEFORMTEMPLID = "PSDYNADEFORMTEMPLID";
    public static final String TAG_PSDYNADEFORMTEMPLNAME = "PSDYNADEFORMTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String TAG_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDYNADEFORMTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADEFORMTEMPLID);
    }

    public final String getPSDYNADEFORMTEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADEFORMTEMPLID, "");
    }

    public final void setPSDYNADEFORMTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADEFORMTEMPLID, strValue);
    }

    public final boolean isPSDYNADEFORMTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADEFORMTEMPLNAME);
    }

    public final String getPSDYNADEFORMTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADEFORMTEMPLNAME, "");
    }

    public final void setPSDYNADEFORMTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADEFORMTEMPLNAME, strValue);
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

    public final boolean isPSDYNADETEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLID);
    }

    public final String getPSDYNADETEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLID, "");
    }

    public final void setPSDYNADETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLID, strValue);
    }

    public final boolean isPSDYNADETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADETEMPLNAME);
    }

    public final String getPSDYNADETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADETEMPLNAME, "");
    }

    public final void setPSDYNADETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADETEMPLNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
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

