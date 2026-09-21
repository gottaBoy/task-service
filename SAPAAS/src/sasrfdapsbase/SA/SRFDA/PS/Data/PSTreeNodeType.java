/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSTreeNodeType
extends BaseDataEntity {
    public static final String TAG_PSTREENODETYPEID = "PSTREENODETYPEID";
    public static final String TAG_PSTREENODETYPENAME = "PSTREENODETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TREENODEOBJ = "TREENODEOBJ";

    public final boolean isPSTREENODETYPEIDNull() {
        return this.IsParamNull(TAG_PSTREENODETYPEID);
    }

    public final String getPSTREENODETYPEID() {
        return this.GetParamStringValue(TAG_PSTREENODETYPEID, "");
    }

    public final void setPSTREENODETYPEID(String strValue) {
        this.SetParamValue(TAG_PSTREENODETYPEID, strValue);
    }

    public final boolean isPSTREENODETYPENAMENull() {
        return this.IsParamNull(TAG_PSTREENODETYPENAME);
    }

    public final String getPSTREENODETYPENAME() {
        return this.GetParamStringValue(TAG_PSTREENODETYPENAME, "");
    }

    public final void setPSTREENODETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSTREENODETYPENAME, strValue);
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

    public final boolean isTREENODEOBJNull() {
        return this.IsParamNull(TAG_TREENODEOBJ);
    }

    public final String getTREENODEOBJ() {
        return this.GetParamStringValue(TAG_TREENODEOBJ, "");
    }

    public final void setTREENODEOBJ(String strValue) {
        this.SetParamValue(TAG_TREENODEOBJ, strValue);
    }
}

