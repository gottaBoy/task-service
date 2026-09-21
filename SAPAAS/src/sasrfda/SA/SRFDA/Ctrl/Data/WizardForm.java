/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WizardForm
extends BaseDataEntity {
    public static final String TAG_WIZARDFORMID = "WIZARDFORMID";
    public static final String TAG_WIZARDFORMNAME = "WIZARDFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public final boolean isWIZARDFORMIDNull() {
        return this.IsParamNull(TAG_WIZARDFORMID);
    }

    public final String getWIZARDFORMID() {
        return this.GetParamStringValue(TAG_WIZARDFORMID, "");
    }

    public final void setWIZARDFORMID(String strValue) {
        this.SetParamValue(TAG_WIZARDFORMID, strValue);
    }

    public final boolean isWIZARDFORMNAMENull() {
        return this.IsParamNull(TAG_WIZARDFORMNAME);
    }

    public final String getWIZARDFORMNAME() {
        return this.GetParamStringValue(TAG_WIZARDFORMNAME, "");
    }

    public final void setWIZARDFORMNAME(String strValue) {
        this.SetParamValue(TAG_WIZARDFORMNAME, strValue);
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
}

