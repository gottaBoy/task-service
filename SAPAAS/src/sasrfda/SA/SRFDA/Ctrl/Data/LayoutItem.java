/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LayoutItem
extends BaseDataEntity {
    public static final String TAG_LAYOUTITEMID = "LAYOUTITEMID";
    public static final String TAG_LAYOUTITEMNAME = "LAYOUTITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBLISHOBJECT = "PUBLISHOBJECT";

    public final boolean isLAYOUTITEMIDNull() {
        return this.IsParamNull(TAG_LAYOUTITEMID);
    }

    public final String getLAYOUTITEMID() {
        return this.GetParamStringValue(TAG_LAYOUTITEMID, "");
    }

    public final void setLAYOUTITEMID(String strValue) {
        this.SetParamValue(TAG_LAYOUTITEMID, strValue);
    }

    public final boolean isLAYOUTITEMNAMENull() {
        return this.IsParamNull(TAG_LAYOUTITEMNAME);
    }

    public final String getLAYOUTITEMNAME() {
        return this.GetParamStringValue(TAG_LAYOUTITEMNAME, "");
    }

    public final void setLAYOUTITEMNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTITEMNAME, strValue);
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

    public final boolean isPUBLISHOBJECTNull() {
        return this.IsParamNull(TAG_PUBLISHOBJECT);
    }

    public final String getPUBLISHOBJECT() {
        return this.GetParamStringValue(TAG_PUBLISHOBJECT, "");
    }

    public final void setPUBLISHOBJECT(String strValue) {
        this.SetParamValue(TAG_PUBLISHOBJECT, strValue);
    }
}

