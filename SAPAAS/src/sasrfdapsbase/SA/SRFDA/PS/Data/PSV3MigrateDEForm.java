/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSV3MigrateDEForm
extends BaseDataEntity {
    public static final String TAG_PSV3MGFORMID = "PSV3MGFORMID";
    public static final String TAG_PSV3MGFORMNAME = "PSV3MGFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String TAG_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String TAG_DEFORMID = "DEFORMID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_IGNOREFLAG = "IGNOREFLAG";

    public final boolean isPSV3MGFORMIDNull() {
        return this.IsParamNull(TAG_PSV3MGFORMID);
    }

    public final String getPSV3MGFORMID() {
        return this.GetParamStringValue(TAG_PSV3MGFORMID, "");
    }

    public final void setPSV3MGFORMID(String strValue) {
        this.SetParamValue(TAG_PSV3MGFORMID, strValue);
    }

    public final boolean isPSV3MGFORMNAMENull() {
        return this.IsParamNull(TAG_PSV3MGFORMNAME);
    }

    public final String getPSV3MGFORMNAME() {
        return this.GetParamStringValue(TAG_PSV3MGFORMNAME, "");
    }

    public final void setPSV3MGFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSV3MGFORMNAME, strValue);
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

    public final boolean isPSV3MIGRATEIDNull() {
        return this.IsParamNull(TAG_PSV3MIGRATEID);
    }

    public final String getPSV3MIGRATEID() {
        return this.GetParamStringValue(TAG_PSV3MIGRATEID, "");
    }

    public final void setPSV3MIGRATEID(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATEID, strValue);
    }

    public final boolean isPSV3MIGRATENAMENull() {
        return this.IsParamNull(TAG_PSV3MIGRATENAME);
    }

    public final String getPSV3MIGRATENAME() {
        return this.GetParamStringValue(TAG_PSV3MIGRATENAME, "");
    }

    public final void setPSV3MIGRATENAME(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATENAME, strValue);
    }

    public final boolean isDEFORMIDNull() {
        return this.IsParamNull(TAG_DEFORMID);
    }

    public final String getDEFORMID() {
        return this.GetParamStringValue(TAG_DEFORMID, "");
    }

    public final void setDEFORMID(String strValue) {
        this.SetParamValue(TAG_DEFORMID, strValue);
    }

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isIGNOREFLAGNull() {
        return this.IsParamNull(TAG_IGNOREFLAG);
    }

    public final boolean getIGNOREFLAG() {
        return this.GetParamIntValue(TAG_IGNOREFLAG, 0) == 1;
    }

    public final void setIGNOREFLAG(boolean bValue) {
        this.SetParamValue(TAG_IGNOREFLAG, bValue ? 1 : 0);
    }
}

