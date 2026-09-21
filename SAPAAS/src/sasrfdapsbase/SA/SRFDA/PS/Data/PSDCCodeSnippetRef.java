/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCCodeSnippetRef
extends BaseDataEntity {
    public static final String TAG_PSDCCODESNIPPETREFID = "PSDCCODESNIPPETREFID";
    public static final String TAG_PSDCCODESNIPPETREFNAME = "PSDCCODESNIPPETREFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String TAG_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String TAG_REFPSDCCODESNIPPETID = "REFPSDCCODESNIPPETID";
    public static final String TAG_REFPSDCCODESNIPPETNAME = "REFPSDCCODESNIPPETNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDCCODESNIPPETREFIDNull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETREFID);
    }

    public final String getPSDCCODESNIPPETREFID() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETREFID, "");
    }

    public final void setPSDCCODESNIPPETREFID(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETREFID, strValue);
    }

    public final boolean isPSDCCODESNIPPETREFNAMENull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETREFNAME);
    }

    public final String getPSDCCODESNIPPETREFNAME() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETREFNAME, "");
    }

    public final void setPSDCCODESNIPPETREFNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETREFNAME, strValue);
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

    public final boolean isPSDCCODESNIPPETIDNull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETID);
    }

    public final String getPSDCCODESNIPPETID() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETID, "");
    }

    public final void setPSDCCODESNIPPETID(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETID, strValue);
    }

    public final boolean isPSDCCODESNIPPETNAMENull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETNAME);
    }

    public final String getPSDCCODESNIPPETNAME() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETNAME, "");
    }

    public final void setPSDCCODESNIPPETNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETNAME, strValue);
    }

    public final boolean isREFPSDCCODESNIPPETIDNull() {
        return this.IsParamNull(TAG_REFPSDCCODESNIPPETID);
    }

    public final String getREFPSDCCODESNIPPETID() {
        return this.GetParamStringValue(TAG_REFPSDCCODESNIPPETID, "");
    }

    public final void setREFPSDCCODESNIPPETID(String strValue) {
        this.SetParamValue(TAG_REFPSDCCODESNIPPETID, strValue);
    }

    public final boolean isREFPSDCCODESNIPPETNAMENull() {
        return this.IsParamNull(TAG_REFPSDCCODESNIPPETNAME);
    }

    public final String getREFPSDCCODESNIPPETNAME() {
        return this.GetParamStringValue(TAG_REFPSDCCODESNIPPETNAME, "");
    }

    public final void setREFPSDCCODESNIPPETNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDCCODESNIPPETNAME, strValue);
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

