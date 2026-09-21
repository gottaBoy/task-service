/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysToolbar
extends BaseDataEntity {
    public static final String TAG_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String TAG_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TBMODEL = "TBMODEL";

    public final boolean isPSSYSTOOLBARIDNull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARID);
    }

    public final String getPSSYSTOOLBARID() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARID, "");
    }

    public final void setPSSYSTOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARID, strValue);
    }

    public final boolean isPSSYSTOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARNAME);
    }

    public final String getPSSYSTOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARNAME, "");
    }

    public final void setPSSYSTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARNAME, strValue);
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

    public final boolean isTBMODELNull() {
        return this.IsParamNull(TAG_TBMODEL);
    }

    public final String getTBMODEL() {
        return this.GetParamStringValue(TAG_TBMODEL, "");
    }

    public final void setTBMODEL(String strValue) {
        this.SetParamValue(TAG_TBMODEL, strValue);
    }
}

