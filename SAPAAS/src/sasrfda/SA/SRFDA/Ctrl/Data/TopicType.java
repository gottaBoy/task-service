/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TopicType
extends BaseDataEntity {
    public static final String TAG_TOPICTYPEID = "TOPICTYPEID";
    public static final String TAG_TOPICTYPENAME = "TOPICTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isTOPICTYPEIDNull() {
        return this.IsParamNull(TAG_TOPICTYPEID);
    }

    public final String getTOPICTYPEID() {
        return this.GetParamStringValue(TAG_TOPICTYPEID, "");
    }

    public final void setTOPICTYPEID(String strValue) {
        this.SetParamValue(TAG_TOPICTYPEID, strValue);
    }

    public final boolean isTOPICTYPENAMENull() {
        return this.IsParamNull(TAG_TOPICTYPENAME);
    }

    public final String getTOPICTYPENAME() {
        return this.GetParamStringValue(TAG_TOPICTYPENAME, "");
    }

    public final void setTOPICTYPENAME(String strValue) {
        this.SetParamValue(TAG_TOPICTYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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
}

