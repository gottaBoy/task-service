/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEGridColumnType
extends BaseDataEntity {
    public static final String TAG_PSDEGCTYPEID = "PSDEGCTYPEID";
    public static final String TAG_PSDEGCTYPENAME = "PSDEGCTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COLUMNOBJ = "COLUMNOBJ";
    public static final String TAG_TREECOLUMNOBJ = "TREECOLUMNOBJ";

    public final boolean isPSDEGCTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEGCTYPEID);
    }

    public final String getPSDEGCTYPEID() {
        return this.GetParamStringValue(TAG_PSDEGCTYPEID, "");
    }

    public final void setPSDEGCTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEGCTYPEID, strValue);
    }

    public final boolean isPSDEGCTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEGCTYPENAME);
    }

    public final String getPSDEGCTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEGCTYPENAME, "");
    }

    public final void setPSDEGCTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEGCTYPENAME, strValue);
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

    public final boolean isCOLUMNOBJNull() {
        return this.IsParamNull(TAG_COLUMNOBJ);
    }

    public final String getCOLUMNOBJ() {
        return this.GetParamStringValue(TAG_COLUMNOBJ, "");
    }

    public final void setCOLUMNOBJ(String strValue) {
        this.SetParamValue(TAG_COLUMNOBJ, strValue);
    }

    public final boolean isTREECOLUMNOBJNull() {
        return this.IsParamNull(TAG_TREECOLUMNOBJ);
    }

    public final String getTREECOLUMNOBJ() {
        return this.GetParamStringValue(TAG_TREECOLUMNOBJ, "");
    }

    public final void setTREECOLUMNOBJ(String strValue) {
        this.SetParamValue(TAG_TREECOLUMNOBJ, strValue);
    }
}

