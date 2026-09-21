/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDERType
extends BaseDataEntity {
    public static final String TAG_PSDERTYPEID = "PSDERTYPEID";
    public static final String TAG_PSDERTYPENAME = "PSDERTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEROBJ = "DEROBJ";

    public final boolean isPSDERTYPEIDNull() {
        return this.IsParamNull(TAG_PSDERTYPEID);
    }

    public final String getPSDERTYPEID() {
        return this.GetParamStringValue(TAG_PSDERTYPEID, "");
    }

    public final void setPSDERTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDERTYPEID, strValue);
    }

    public final boolean isPSDERTYPENAMENull() {
        return this.IsParamNull(TAG_PSDERTYPENAME);
    }

    public final String getPSDERTYPENAME() {
        return this.GetParamStringValue(TAG_PSDERTYPENAME, "");
    }

    public final void setPSDERTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDERTYPENAME, strValue);
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

    public final boolean isDEROBJNull() {
        return this.IsParamNull(TAG_DEROBJ);
    }

    public final String getDEROBJ() {
        return this.GetParamStringValue(TAG_DEROBJ, "");
    }

    public final void setDEROBJ(String strValue) {
        this.SetParamValue(TAG_DEROBJ, strValue);
    }
}

