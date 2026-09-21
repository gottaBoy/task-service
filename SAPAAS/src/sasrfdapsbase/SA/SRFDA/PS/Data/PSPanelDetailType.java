/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPanelDetailType
extends BaseDataEntity {
    public static final String TAG_PSPANELDETAILTYPEID = "PSPANELDETAILTYPEID";
    public static final String TAG_PSPANELDETAILTYPENAME = "PSPANELDETAILTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DETAILOBJ = "DETAILOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";

    public final boolean isPSPANELDETAILTYPEIDNull() {
        return this.IsParamNull(TAG_PSPANELDETAILTYPEID);
    }

    public final String getPSPANELDETAILTYPEID() {
        return this.GetParamStringValue(TAG_PSPANELDETAILTYPEID, "");
    }

    public final void setPSPANELDETAILTYPEID(String strValue) {
        this.SetParamValue(TAG_PSPANELDETAILTYPEID, strValue);
    }

    public final boolean isPSPANELDETAILTYPENAMENull() {
        return this.IsParamNull(TAG_PSPANELDETAILTYPENAME);
    }

    public final String getPSPANELDETAILTYPENAME() {
        return this.GetParamStringValue(TAG_PSPANELDETAILTYPENAME, "");
    }

    public final void setPSPANELDETAILTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSPANELDETAILTYPENAME, strValue);
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

    public final boolean isDETAILOBJNull() {
        return this.IsParamNull(TAG_DETAILOBJ);
    }

    public final String getDETAILOBJ() {
        return this.GetParamStringValue(TAG_DETAILOBJ, "");
    }

    public final void setDETAILOBJ(String strValue) {
        this.SetParamValue(TAG_DETAILOBJ, strValue);
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

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
    }
}

